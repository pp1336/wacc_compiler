package codeGeneration.Assembly.Instruction.Logical;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.FlagSettingInstruction;

/**
 * Template class for logic instructions.
 */
abstract class LogicalInstruction extends FlagSettingInstruction {
    public LogicalInstruction(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public LogicalInstruction(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }
}
