package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * does a bitwise and of a and b
 */
public class And extends LogicalInstruction {

    public And(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public And(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "AND";
    }
}
