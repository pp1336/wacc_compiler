package codeGeneration.Assembly.Instruction.Branch;

import codeGeneration.Assembly.Instruction.Arguments.Label;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.Instruction;

/**
 * Branches to the address in Rm and sets the link register to the address of
 * the next instruction.
 */
public class BranchIndirectWithLink extends Instruction {

    public BranchIndirectWithLink(NonShiftedRegister Rm) {
        super(Rm);
    }

    @Override
    public String getMnemonic() {
        return "BLX";
    }
}
