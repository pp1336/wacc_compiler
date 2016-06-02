package ast.type;

import c_codeGeneration.InstructionAccumulator;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

public class PairType implements Type {

	private Type fstType;
	private Type sndType;

	public PairType(Type fstType, Type sndType) {
		this.fstType = fstType;
		this.sndType = sndType;
	}

	public Type getFstType() {
		return fstType;
	}

	public Type getSndType() {
		return sndType;
	}

	public boolean isEmptyPairType() {
		return fstType == null && sndType == null;
	}

	@Override
	public boolean sameType(Type thatType) {
		if (!thatType.isPairType()) {
			return false;
		}
		PairType thatPairType = (PairType) thatType;
		return isEmptyPairType() || thatPairType.isEmptyPairType()
				|| (fstType.sameType(thatPairType.getFstType())
					&& sndType.sameType(thatPairType.getSndType()));
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		if (fstType != null) {
			fstType.walk(v);
		}
		if (sndType != null) {
			sndType.walk(v);
		}
		v.leave();
	}

	@Override
	public Type getInnerType() {
		return null;
	}

	@Override
	public boolean isPairType() {
		return true;
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
		return 4;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub
		
	}

}
