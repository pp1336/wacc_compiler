package codeGeneration.Assembly.Instruction.Memory;

import codeGeneration.Assembly.Instruction.Arguments.RegisterSet;
import codeGeneration.Assembly.Instruction.Instruction;


public class Push extends Instruction {
    public Push(RegisterSet regs) {
        super(regs);
    }

    @Override
    public String getMnemonic() {
        return "PUSH";
    }
}
