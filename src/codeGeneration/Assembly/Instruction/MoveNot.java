package codeGeneration.Assembly.Instruction;
import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;

/**
 * Nots a value, then moves it into a register
 */
public class MoveNot extends Instruction {

    @Override
    public String getMnemonic(){
        return "MOVN";
    }

    public MoveNot(NonShiftedRegister dest, Operand2 target) {
        super(dest, target);
    }

}
