package ast.type;

import c_codeGeneration.InstructionAccumulator;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

public class ArrayType implements Type {

	Type firstLevelType;

	public ArrayType(Type firstLevelType) {
		this.firstLevelType = firstLevelType;
	}

	public boolean isEmptyArrayType() {
		return firstLevelType == null;
	}

	@Override
	public boolean sameType(Type thatType) {
		if (!thatType.isArrayType()) {
			return false;
		}
		ArrayType thatArrayType = (ArrayType) thatType;
		return isEmptyArrayType()
				|| thatArrayType.isEmptyArrayType()
				|| firstLevelType.sameType(thatType.getInnerType());
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		firstLevelType.walk(v);
		v.leave();
	}

	@Override
	public Type getInnerType() {
		return firstLevelType;
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
		return true;
	}

	@Override
	public String codeGen(MachineState m) {
		//TODO nyi
		return "NotYetImplemented";
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub
		
	}

}
