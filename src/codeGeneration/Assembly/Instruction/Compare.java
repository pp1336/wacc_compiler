package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * subtracts a from b and then sets the flags
 */
public class Compare extends Instruction {
    public Compare(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    @Override
    public String getMnemonic() {
        return "CMP";
    }
}
