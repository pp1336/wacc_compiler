package codeGeneration.Assembly.Instruction.Arguments;

/**
 * Immediate integer constant argument.
 */
public class Immediate implements Operand2 {
    private int value;

    public Immediate(int value) {
        this.value = value;
        checkValue();
    }

    private void checkValue() {
        // value is allowed to be:
        // 1) any constant that can be produced by shifting an 8-bit value
        //    left by any number of bits within a 32-bit word
        // 2) any constant of the form 0x00XY00XY
        // 3) any constant of the form 0xXY00XY00
        // 4) any constant of the form 0xXYXYXYXY.
        // where X,Y are hexadecimal digits.

        // change int to "unsigned" so we don't get confusion with negatives.
        long l = value & 0x00000000ffffffffL;
        if (!(checkRule1(l) || checkRule2(l) ||
                checkRule3(l) || checkRule4(l))) {
            String msg = "Invalid constant.";
            throw new IllegalArgumentException(msg);
        }
    }

    private boolean checkRule1(long value) {
        // 1) shift right (through division) until the last digit is one
        //    then if the result is higher than 2^8 it's not allowed.
        while (value % 2 == 0 && value != 0) {
            value /= 2;
        }
        return value < 255;
    }

    private boolean checkRule2(long value) {
        // check that the first two and 5th and 6th digits are 0
        // check that the last hex digit equals the 5th last hex digit
        // check that the second las hex digit equals the 6th last hex digit
        return (value & 0x00000000FF00FF00L) == 0
                && (getDigit(0, value) == getDigit(4, value))
                && (getDigit(1, value) == getDigit(5, value));
    }

    private boolean checkRule3(long value) {
        // check last 3rd, 4th, 7th and 8th digits are 0
        // shift right by two hex digits, then check rule 2
        return (value & 0x0000000000FF00FFL) == 0 && checkRule2(value / 256);
    }

    private boolean checkRule4(long value) {
        // check that alternating digits match
        return allTheSame(getDigit(0, value), getDigit(2, value),
                          getDigit(4, value), getDigit(6, value))
            && allTheSame(getDigit(1, value), getDigit(3, value),
                          getDigit(5, value), getDigit(7, value));
    }

    /**
     * checks that all arguments are the same.
     */
    private boolean allTheSame(int... values) {
        if (values.length == 0) return true;
        int x = values[0];
        for (int v : values) {
            if (v != x) return false;
        }
        return true;
    }

    /**
     * gets the indexth from last hex digit of a long.
     */
    private int getDigit(int index, long value) {
        return (int) ((value / (long) Math.pow(16, index)) % 16);
    }

    @Override
    public String getRepresentation() {
        return "#" + value;
    }
}
