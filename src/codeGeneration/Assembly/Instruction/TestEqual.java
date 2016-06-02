package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * performs a bitwise EOR operation on a and b.
 * Use to test if two values are equal without affecting the V or C flags.
 */
public class TestEqual extends Instruction {
    public TestEqual(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    @Override
    public String getMnemonic() {
        return "TEQ";
    }
}
