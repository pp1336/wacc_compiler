package codeGeneration.Assembly.Instruction.Branch;

import codeGeneration.Assembly.Instruction.Arguments.Label;
import codeGeneration.Assembly.Instruction.Instruction;

/**
 * Branches to the specified label and sets the link register to the address of
 * the next instruction.
 */
public class BranchImmediateWithLink extends Instruction {

    public BranchImmediateWithLink(Label label) {
        super(label);
    }

    @Override
    public String getMnemonic() {
        return "BL";
    }
}
