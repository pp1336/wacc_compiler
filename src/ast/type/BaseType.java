package ast.type;

import c_codeGeneration.InstructionAccumulator;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

public class BaseType implements Type {

	BaseTypeEnum baseTypeEnum;

	public BaseType(BaseTypeEnum baseTypeEnum) {
		this.baseTypeEnum = baseTypeEnum;
	}

	public BaseTypeEnum getBaseTypeEnum() {
		return baseTypeEnum;
	}

	@Override
	public boolean sameType(Type thatType) {
		if (!thatType.isBaseType()) {
			return false;
		}
		BaseType thatBaseType = (BaseType) thatType;
		return baseTypeEnum == thatBaseType.getBaseTypeEnum();
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getInnerType() {
		return null;
	}

	@Override
	public boolean isPairType() {
		return false;
	}

	@Override
	public boolean isBaseType() {
		return true;
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
		return baseTypeEnum.getBaseTypeSize();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub
		
	}

}
