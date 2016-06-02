package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * subtracts a from b. Useful because of the wide range of options for b.
 */
public class ReverseSubtract extends ArithmeticInstruction {

    public ReverseSubtract(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public ReverseSubtract(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "RSB";
    }
}
