package codeGeneration.Assembly.Data;

/**
 * Strings consist of a word containing the length of the string, then
 * the ascii values of every character in the string, without a null terminator.
 */
public class StringData implements Data {
    private final String label;
    private final String s;

    public StringData(String label, String s) {
        this.label = label;
        this.s = s;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getRepresentation() {
        return label + ": " + System.lineSeparator()
                + ".word " + getRealLength(s) + System.lineSeparator()
                + ".ascii \"" + s + "\"";
    }

    /**
     * Sometimes, a string might have an escaped character. This will be a
     * two character code! The .ascii directive will collapse it into one
     * character. So, we count the number of escaped characters and subtract
     * that from the string's length to get its actual character length after
     * assembling.
     * @param s the string to get the real length of
     * @return the length of the string once escaped characters are collapsed.
     */
    private static int getRealLength(String s) {
        int numOfEscapedChars = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\' && i < s.length() - 1) {
                numOfEscapedChars++;
                i++;
            }
        }

        return s.length() - numOfEscapedChars;
    }
}
