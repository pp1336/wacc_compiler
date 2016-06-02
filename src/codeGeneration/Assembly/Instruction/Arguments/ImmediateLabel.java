package codeGeneration.Assembly.Instruction.Arguments;

/**
 * For use with the ldr reg, =label instruction.
 */
public class ImmediateLabel implements Argument {
    private String label;

    public ImmediateLabel(String label) {
        this.label = label;
    }

    @Override
    public String getRepresentation() {
        return "=" + label;
    }
}
