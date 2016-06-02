package codeGeneration.Assembly.Instruction.Arguments.RegisterArguments;

import codeGeneration.Register;
import codeGeneration.Variable;

/**
 * a register, but we don't know which register yet.
 */
public class VariableRegister extends NonShiftedRegister {
    private Variable v;

    VariableRegister(Variable v) {
        this.v = v;
    }

    @Override
    public Register getRegister() {
        return v.getRegister();
    }
}
