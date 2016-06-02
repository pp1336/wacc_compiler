package codeGeneration.Assembly.Instruction.Arguments;

import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.RegisterArgument;
import codeGeneration.Register;

import java.util.*;

import static java.lang.Math.abs;

/**
 * set of registers, e.g. {r0}, {r1-r7}, {r2,r4,r9-r12}, {r3,sp,lr}
 */
public class RegisterSet implements Argument {
    private Set<RegisterArgument> set;

    public RegisterSet(Set<RegisterArgument> set) {
        this.set = set;
    }

    public RegisterSet(RegisterArgument... regs) {
        this.set = new HashSet<>();
        Collections.addAll(set, regs);
    }

    @Override
    public String getRepresentation() {
        Set<Register> registers = new HashSet<>();
        for (RegisterArgument r : set) {
            registers.add(r.getRegister());
        }
        return registerSetToCommaSeparatedRanges(registers);
    }

    /**
     * Gets a comma-separated list of ranges, e.g. if the set
     * provided is `{Register.r0, Register.r3, Register.r4, Register.r5}`,
     * returns "r0,r3-r5".
     * @param set a set of `Register`s.
     * @return a `String` containing the `.toString()` values for each
     * element of the set, ordered, with consecutive values replaced by
     * range contractions, e.g. `{r0,r1,r3,r4,r2,r7,r9}` -> "r0-r4,r7,r9",
     */
    private String registerSetToCommaSeparatedRanges(Set<Register> set) {
        List<Register> l = new ArrayList<Register>() {{ addAll(set); }};
        Collections.sort(l, (o1, o2) -> o1.ordinal() - o2.ordinal());
        StringBuilder stringBuilder = new StringBuilder();
        boolean commas = false;
        for (int i = 0; i < l.size(); i++) {
            String repr = l.get(i).toString();
            // construct ranges: if r0, r1 and r2 are in the set,
            // add "r0-r2", not "r0, r1, r2".
            while (i + 1 < l.size() &&
                    abs(l.get(i).ordinal() - l.get(i+1).ordinal()) <= 1) {
                repr = l.get(i).toString() + "-" + l.get(i+1).toString();
                l.remove(i+1);
            }
            // Only insert commas after the first value.
            if (commas) stringBuilder.append(","); else commas = true;
            stringBuilder.append(repr);
        }
        return stringBuilder.toString();
    }
}
