package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * subtracts a from not b and then sets the flags
 */
public class CompareNot extends Instruction {
    public CompareNot(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    @Override
    public String getMnemonic() {
        return "CMN";
    }
}
