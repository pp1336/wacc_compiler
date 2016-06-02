package codeGeneration.Assembly.Instruction;

import codeGeneration.Assembly.Instruction.Arguments.Argument;

/**
 * Template class for arithmetic instructions.
 */
public abstract class FlagSettingInstruction extends Instruction {

    private boolean shouldSetFlags = false;

    public FlagSettingInstruction(Argument... arguments) {
        super(arguments);
    }

    /**
     * If this method is called, the condition flags will be set when this
     * instruction executes. Use while building the instruction.
     * @return this
     */
    public Instruction shouldSetFlags() {
        this.shouldSetFlags = true;
        return this;
    }

    @Override
    public String getMnemonic() {
        return getRawMnemonic() + (shouldSetFlags ? "" : "S");
    }

    /**
     * Get the mnemonic before suffixes.
     * @return the mnemonic before suffixes, i.e. "ADD" for add instructions...
     */
    protected abstract String getRawMnemonic();
}
