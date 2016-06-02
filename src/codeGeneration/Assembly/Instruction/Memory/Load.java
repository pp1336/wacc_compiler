package codeGeneration.Assembly.Instruction.Memory;

import codeGeneration.Assembly.Instruction.Arguments.ImmediateEQ;
import codeGeneration.Assembly.Instruction.Arguments.ImmediateLabel;
import codeGeneration.Assembly.Instruction.Arguments.MemoryAddress;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.Instruction;

public class Load extends Instruction {

    private Type t = Type.WORD;

    public Load(NonShiftedRegister dest, MemoryAddress src) {
        super(dest, src);
    }
    
    public Load(NonShiftedRegister dest, ImmediateEQ target) {
        super(dest, target);
    }

    public Load(NonShiftedRegister dest, ImmediateLabel target) {
        super(dest, target);
    }

    public Load(Type t, NonShiftedRegister dest, MemoryAddress src) {
        super(dest, src);
        this.t = t;
    }

    @Override
    public String getMnemonic() {
        return "LDR" + t.getSuffix();
    }
}
