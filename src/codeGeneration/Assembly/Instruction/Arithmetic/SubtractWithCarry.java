package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * subtracts b from a with carry
 */
public class SubtractWithCarry extends ArithmeticInstruction {

    public SubtractWithCarry(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public SubtractWithCarry(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "SBC";
    }
}
