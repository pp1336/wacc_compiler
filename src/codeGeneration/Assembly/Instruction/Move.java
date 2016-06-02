package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * Moves a value into a register
 */
public class Move extends Instruction {

    @Override
    public String getMnemonic() {
        return "MOV";
    }

    public Move(NonShiftedRegister dest, Operand2 target) {
        super(dest, target);
    }

}
