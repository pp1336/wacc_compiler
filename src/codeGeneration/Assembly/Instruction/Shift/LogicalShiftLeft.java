package codeGeneration.Assembly.Instruction.Shift;

import codeGeneration.Assembly.Instruction.Arguments.Immediate;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

public class LogicalShiftLeft extends ShiftInstruction {

    public LogicalShiftLeft(NonShiftedRegister dest, NonShiftedRegister a, NonShiftedRegister b) {
        super(dest, a, b);
    }

    public LogicalShiftLeft(NonShiftedRegister dest, NonShiftedRegister a, Immediate b) {
        super(dest, a, b);
    }

    @Override
    protected String getRawMnemonic() {
        return "LSL";
    }
}
