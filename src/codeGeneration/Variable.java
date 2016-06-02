package codeGeneration;

/**
 * Right now, variables are just wrappers around registers. Possibly implement
 * come way to move them to and from the stack?
 */
public class Variable {
    private Register register;

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
