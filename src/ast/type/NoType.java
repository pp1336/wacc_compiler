package ast.type;

import c_codeGeneration.InstructionAccumulator;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

public class NoType implements Type {

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public boolean sameType(Type thatType) {
		return false;
	}

	@Override
	public Type getInnerType() {
		return new NoType();
	}

	@Override
	public boolean isPairType() {
		return false;
	}

	@Override
	public boolean isBaseType() {
		return false;
	}

	@Override
	public boolean isArrayType() {
		return false;
	}

	@Override
	public String codeGen(MachineState m) {//TODO nyi
		return "NotYetImplemented";
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub
		
	}

}
