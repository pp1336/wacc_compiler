package codeGeneration.Assembly.Instruction;

/**
 * Condition codes for instructions.
 */
public enum ConditionCode {
    EQUAL("equal", "EQ"),
    NOT_EQUAL("not equal", "NE"),
    HIGHER("higher, unsigned", "HI"),
    HIGHER_SAME("higher or same, unsigned", "HS"),
    LOWER("lower, unsigned", "LO"),
    LOWER_SAME("lower or same unsigned", "LS"),
    GREATER_THAN("greater than, signed", "GT"),
    GREATER_THAN_EQ("greater than or equal to, signed", "GE"),
    LESS_THAN("less than, signed", "LT"),
    LESS_THAN_EQ("less than or equal to, signed", "LE"),
    NEGATIVE("negative", "MI"),
    POSITIVE("positive or zero", "PL"),
    OVERFLOW("overflow", "VS"),
    NO_OVERFLOW("no overflow", "VC"),
    ALWAYS("always (default)", "AL");

    private String description;
    private String mnemonic;

    ConditionCode(String description, String mnemonic) {
        this.description = description;
        this.mnemonic = mnemonic;
    }

    public String getDescription() {
        return description;
    }

    public String getMnemonic() {
        return mnemonic;
    }
}
