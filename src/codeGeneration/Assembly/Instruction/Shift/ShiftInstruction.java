package codeGeneration.Assembly.Instruction.Shift;

import codeGeneration.Assembly.Instruction.Arguments.Immediate;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.FlagSettingInstruction;

/**
 * This class exists to make it way easier to generate code for other shift
 * instructions using IDEA.
 */
abstract class ShiftInstruction extends FlagSettingInstruction {
    public ShiftInstruction(NonShiftedRegister dest, NonShiftedRegister a, NonShiftedRegister b) {
        super(dest, a, b);
    }

    public ShiftInstruction(NonShiftedRegister dest, NonShiftedRegister a, Immediate b) {
        super(dest, a, b);
    }
}
