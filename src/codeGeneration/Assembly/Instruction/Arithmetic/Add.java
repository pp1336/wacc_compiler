package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * Adds a flexible second operand to a register, optionally putting the result
 * in another register instead of modifying the original.
 */
public class Add extends ArithmeticInstruction {

    public Add(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public Add(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "ADD";
    }
}
