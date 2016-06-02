package codeGeneration.Assembly.Instruction.Arguments.RegisterArguments;

import codeGeneration.Register;

/**
 * Sometimes a register is shifted.
 */
public class ShiftedRegister<T extends NonShiftedRegister>
        extends RegisterArgument {

    private RegisterArgument registerArgument;
    private ShiftType shift;
    private int shift_magnitude;

    /**
     * enum detailing the different kinds of argument a register can have.
     */
    protected enum ShiftType {
        NONE(Integer.MIN_VALUE, Integer.MAX_VALUE),
        RRX(Integer.MIN_VALUE, Integer.MAX_VALUE),
        ASR(0, 32), LSL(0, 31), LSR(0, 32), ROR(0, 31);

        int min;
        int max;

        ShiftType(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    /**
     * if shift is of type RRX, magnitude is ignored.
     */
    ShiftedRegister(T registerArgument, ShiftType shift, int magnitude) {
        this.registerArgument = registerArgument;
        this.shift = shift;
        this.shift_magnitude = magnitude;
        checkMagnitude();
    }

    private void checkMagnitude() {
        if (shift_magnitude < shift.min || shift_magnitude > shift.max) {
            String msg = shift + " shifts must be between " + shift.min
                    + " and " + shift.max;
            throw new IllegalArgumentException(msg);
        }
    }


    @Override
    public Register getRegister() {
        return registerArgument.getRegister();
    }

    @Override
    public String getRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRegister().toString());
        if (shift.equals(ShiftType.NONE)
                || (shift.equals(ShiftType.LSL)
                && shift_magnitude == 0)) {
            // ugly conditions ftw
            return sb.toString();
        }
        sb.append(", ");
        sb.append(shift);
        if (shift.equals(ShiftType.RRX)) {
            return sb.toString();
        }
        sb.append(" #");
        sb.append(shift_magnitude);
        return sb.toString();
    }
}
