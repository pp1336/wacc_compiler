package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * does a bitwise not on b, then ands it with a.
 */
public class AndNot extends LogicalInstruction {
    public AndNot(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public AndNot(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "BIC";
    }
}
