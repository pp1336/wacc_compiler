package codeGeneration.Assembly.Instruction.Branch;

import codeGeneration.Assembly.Instruction.Arguments.Label;
import codeGeneration.Assembly.Instruction.Instruction;

/**
 * Jumps to the specified label, without setting the link register.
 */
public class BranchImmediate extends Instruction{

    public BranchImmediate(Label label) {
        super(label);
    }

    @Override
    public String getMnemonic() {
        return "B";
    }
}
