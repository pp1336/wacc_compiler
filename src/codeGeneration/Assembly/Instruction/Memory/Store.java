package codeGeneration.Assembly.Instruction.Memory;

import codeGeneration.Assembly.Instruction.Arguments.MemoryAddress;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.Instruction;

public class Store extends Instruction {

    private Type t = Type.WORD;

    public Store(NonShiftedRegister src, MemoryAddress dest) {
        super(src, dest);
    }

    public Store(Type t, NonShiftedRegister src, MemoryAddress dest) {
        super(src, dest);
        this.t = t;
    }

    @Override
    public String getMnemonic() {
        return "STR" + t.getSuffix();
    }
}
