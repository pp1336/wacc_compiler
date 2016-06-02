package codeGeneration.Assembly.Instruction.Memory;

import codeGeneration.Assembly.Instruction.Arguments.RegisterSet;
import codeGeneration.Assembly.Instruction.Instruction;


public class Pop extends Instruction {
    public Pop(RegisterSet regs) {
        super(regs);
    }

    @Override
    public String getMnemonic() {
        return "POP";
    }
}
