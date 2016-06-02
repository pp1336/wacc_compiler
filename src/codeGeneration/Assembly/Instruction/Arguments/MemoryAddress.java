package codeGeneration.Assembly.Instruction.Arguments;

import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.RegisterArgument;

/**
 * memory address from register, with optional
 */
public class MemoryAddress implements Argument {

    public static int MIN_NON_INDEXED_MEMORY_OFFSET = -255;
    public static int MAX_NON_INDEXED_MEMORY_OFFSET = 4095;
    public static int MIN_INDEXED_MEMORY_OFFSET = -255;
    public static int MAX_INDEXED_MEMORY_OFFSET = 255;

    public enum IndexType {
        NONE("non-indexed"), PRE("pre-indexed"), POST("post-indexed");

        public final String adjective;

        IndexType(String adjective) {
            this.adjective = adjective;
        }

        @Override
        public String toString() {
            return adjective;
        }
    }

    private NonShiftedRegister reg;
    private RegisterArgument registerOffset = null;
    private Long offset = null;
    private IndexType index;

    public MemoryAddress(NonShiftedRegister reg) {
        this(reg, 0, IndexType.NONE);
    }

    public MemoryAddress(NonShiftedRegister reg, long offset) {
        this(reg, offset, IndexType.NONE);
    }

    public MemoryAddress(NonShiftedRegister reg, long offset,
                  IndexType index_type) {
        this.reg = reg;
        this.offset = offset;
        this.index = index_type;
        checkOffset();
    }

    public MemoryAddress(NonShiftedRegister reg, RegisterArgument offset) {
        this.reg = reg;
        this.registerOffset = offset;
    }

    private void checkOffset() {
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        switch (index) {
            case NONE:
                min = MIN_NON_INDEXED_MEMORY_OFFSET;
                max = MAX_NON_INDEXED_MEMORY_OFFSET;
                break;
            case PRE:
            case POST:
                min = MIN_INDEXED_MEMORY_OFFSET;
                max = MAX_INDEXED_MEMORY_OFFSET;
                break;
        }
        if (offset < min || offset > max) {
            String msg = "ARM cannot handle offsets smaller than " +
                    min + " or larger than " + max + " for " +
                    index.adjective + " memory accesses.";
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String getRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(reg.getRegister().toString());
        if (offset != null && offset == 0) {
            sb.append("]");
            return sb.toString();
        }
        if (registerOffset != null) {
            sb.append(registerOffset.getRepresentation()).append("]");
            return sb.toString();
        }
        switch (index) {
            case NONE:
                sb.append(", #").append(index).append("]");
                return sb.toString();
            case PRE:
                sb.append(", #").append(index).append("]!");
                return sb.toString();
            case POST:
                sb.append("], #").append(index);
                return sb.toString();
            default:
                // should never be reached.
                return "inconceivable!";
        }
    }
}
