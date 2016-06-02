package codeGeneration.Assembly.Instruction.Branch;

import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.Instruction;

/**
 * Branches to the memory address in the register Rm.
 */
public class BranchIndirect extends Instruction {

    public BranchIndirect(NonShiftedRegister Rm) {
        super(Rm);
    }

    @Override
    public String getMnemonic() {
        return "BX";
    }
}
