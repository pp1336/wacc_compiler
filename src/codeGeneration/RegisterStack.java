package codeGeneration;

import java.util.Stack;


/*
 * Represents the register stack
 */

public class RegisterStack {
	
	//needed for unary operator
	private Register lastUsedRegister = null;
	private Stack<Register> regs =  new Stack<Register>();
	
	public RegisterStack(){
		lastUsedRegister = null;
		regs.push(Register.r10);
		regs.push(Register.r9);
		regs.push(Register.r8);
		regs.push(Register.r7);
		regs.push(Register.r6);
		regs.push(Register.r5);
		regs.push(Register.r4);
	}
	
	public Register firstUnused(){
		return regs.peek();
	}
	
	public void push(Register r){
		regs.push(r);
	}
	
	public void push(Register r, int mode) {
		if (mode == 0) {
			lastUsedRegister = r;
		}
		push(r);
	}
	
	public Register pop(){
		lastUsedRegister = regs.pop();
		return lastUsedRegister;
	}
	
	public Register getLastUsedRegister() {
		return lastUsedRegister;
	}
	
}
