package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * does a binary or on a and b
 */
public class Or extends LogicalInstruction {
    public Or(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public Or(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "ORR";
    }
}
