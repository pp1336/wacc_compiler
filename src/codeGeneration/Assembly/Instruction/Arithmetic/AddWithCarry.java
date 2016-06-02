package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * Adds a to b with a carry.
 */
public class AddWithCarry extends ArithmeticInstruction {

    public AddWithCarry(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public AddWithCarry(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "ADC";
    }
}
