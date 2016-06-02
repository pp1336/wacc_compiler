package codeGeneration.Assembly.Instruction.Arguments;

/**
 * Master interface for arguments. Has no methods because all we need is
 * toString.
 */
public interface Argument {
    /**
     * Arguments should return a valid representation in ARM assembly.
     * @return "r{0-12}" or "sp" or "lr" for registers,
     *     "#{int}" for immediate operand2s,
     *     "={int}" for immediate load operands,
     *     "[register]" or "[register, #offset]" for memory,
     *     "{range}" for register ranges
     */
    String getRepresentation();
}
