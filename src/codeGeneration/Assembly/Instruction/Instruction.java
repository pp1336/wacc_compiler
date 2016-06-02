package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.AssemblyBlock;
import codeGeneration.Assembly.Instruction.Arguments.Argument;

/**
 * Class to model assembly instructions.
 */
public abstract class Instruction {

    private String label = null;
    private ConditionCode cond = null;
    private Argument[] arguments;

    public abstract String getMnemonic();

    /*=========================================================================
     Build methods: Call these when you create a new object. They return this,
     so they can be chained together.
     */
    /**
     * Sets the condition code for the instruction. Use this while building the
     * object, e.g.
     *      new Add(<i>&lt;valid arguments&gt;</i>)
     *          .setCond(ConditionCode.ALWAYS)
     * @param cond the condition under which the instruction should execute.
     * @return this
     */
    public Instruction setCond(ConditionCode cond) {
        this.cond = cond;
        return this;
    }

    /**
     * Sets the condition code for the instruction. Use this while building the
     * object, e.g.
     *      new Add(<i>&lt;valid arguments&gt;</i>)
     *          .setLabel("while_loop_4")
     * @param label the label for the instruction
     * @return this
     */
    public Instruction setLabel(String label) {
        this.label = label;
        return this;
    }
    /*end build methods.
     ==========================================================================
     */

    /**
     * Creates a new instruction.
     * @param arguments the arguments to pass to the instruction.
     */
    protected Instruction(Argument... arguments) {
        this.arguments = arguments;
    }

    /**
     * Generates the String representation of the instruction.
     * @return the String representation of the instruction.
     */
    public String generate() {
        // "MNEMONIC arg1, arg2, ..., argN"
        StringBuilder sb = new StringBuilder();
        if (label != null) {
            sb.append(label).append(":").append(System.lineSeparator());
            sb.append(AssemblyBlock.INDENT); // bad encapsulation but oh well
        }
        sb.append(getMnemonic());
        if (cond != null) {
            sb.append(cond.getMnemonic());
        }
        boolean commas = false;
        for (Argument a : arguments) {
            if (commas) sb.append(", ");
            else { commas = true; sb.append(" "); }
            sb.append(a);
        }
        return sb.toString();
    }
}
