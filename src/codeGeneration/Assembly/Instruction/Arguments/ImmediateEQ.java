package codeGeneration.Assembly.Instruction.Arguments;

/**
 * Used for the ldr, =num pseudo-instruction
 */
public class ImmediateEQ implements Argument {
    private int value;

    public ImmediateEQ(int value) {
        this.value = value;
    }

    @Override
    public String getRepresentation() {
        return "=" + value;
    }
}
