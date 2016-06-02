package codeGeneration.Assembly.Instruction.Shift;

import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.FlagSettingInstruction;

public class RotateRightWithExtend extends FlagSettingInstruction {

    public RotateRightWithExtend(NonShiftedRegister dest, NonShiftedRegister a) {
        super(dest, a);
    }

    @Override
    protected String getRawMnemonic() {
        return "RRX";
    }
}
