package codeGeneration.Assembly.Instruction.Memory;

/**
 * different types of memory load/store
 */
public enum Type {
    WORD(""), UNSIGNED_HALFWORD("H"), SIGNED_HALFWORD("SH"),
    UNSIGNED_BYTE("B"), SIGNED_BYTE("SB");

    final String suffix;

    Type(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }
}
