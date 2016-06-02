package codeGeneration.Assembly.Instruction.Arguments.RegisterArguments;

import codeGeneration.Register;

/**
 * register argument, e.g. r0, r1, ..., r12, sp, lr
 */
public class KnownRegister extends NonShiftedRegister {
    private Register register;

    public KnownRegister(Register register) {
        this.register = register;
    }

    @Override
    public Register getRegister() {
        return register;
    }
}
