package codeGeneration;

import java.util.HashSet;
import java.util.Set;

public enum Register {
	
	r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, sp, lr, pc;

	/**
	 * Gets a range of registers from `start` to `end` inclusive, e.g. if
	 * `start` is `Register.r0` and `end` is `Register.r3`, returns the set
	 * `{Register.r0, Register.r1, Register.r2, Register.r3}`.
	 * @param start the register to start from
	 * @param end the register to end at
     * @return a `Set` containing every `Register r` with
	 * `start.ordinal() <= r.ordinal() <= end.ordinal()`. If `start.ordinal()`
	 * is less than `end.ordinal()`, an empty set will be returned; if
	 * `start` is `end`, returns the set containing just `start`.
     */
	public static Set<Register> getRegisterRange(Register start, Register end) {
		Set<Register> set = new HashSet<>();
		Register[] vals = Register.values();
		for (Register r = start;
			 r.ordinal() <= end.ordinal();
			 r = vals[r.ordinal()+1]) {
			set.add(r);
		}
		return set;
	}

	public static Register getRegister(int r){
	switch(r){
	case 4:
		return r4;
	case 5:
		return r5;
	case 6:
		return r6;
	case 7:
		return r7;
	case 8:
		return r8;
	case 9:
		return r9;
	}
		return null;
	}

}
