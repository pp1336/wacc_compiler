package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * does an xor on a and b
 */
public class ExclusiveOr extends LogicalInstruction {

    public ExclusiveOr(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public ExclusiveOr(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "EOR";
    }
}
