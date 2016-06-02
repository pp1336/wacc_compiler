package codeGeneration.Assembly.Instruction.Arguments;

/**
 * labels for branch instructions
 */
public class Label implements Argument {

    private String label;

    public Label(String label) {
        this.label = label;
    }

    @Override
    public String getRepresentation() {
        return label;
    }
}
