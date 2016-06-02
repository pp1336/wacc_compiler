package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * ands a and b and then sets the flags
 */
public class TestBits extends Instruction {
    public TestBits(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    @Override
    public String getMnemonic() {
        return "TST";
    }
}
