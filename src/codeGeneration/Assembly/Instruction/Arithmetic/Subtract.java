package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * subtracts b from a
 */
public class Subtract extends ArithmeticInstruction {
    public Subtract(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public Subtract(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "SUB";
    }
}
