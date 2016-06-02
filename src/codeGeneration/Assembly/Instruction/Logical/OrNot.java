package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * nots b, then ors it with a.
 */
public class OrNot extends LogicalInstruction {
    public OrNot(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public OrNot(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "ORN";
    }
}
