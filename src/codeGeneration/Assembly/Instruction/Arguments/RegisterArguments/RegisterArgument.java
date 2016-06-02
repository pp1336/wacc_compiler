package codeGeneration.Assembly.Instruction.Arguments.RegisterArguments;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Register;

/**
 * interface to group variables and known registers
 */
public abstract class RegisterArgument implements Operand2 {

    public abstract Register getRegister();

    @Override
    public String getRepresentation() {
        return getRegister().toString();
    }

}
