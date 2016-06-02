package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.expr.IntSignExpr;
import ast.expr.RhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a signed integer
 */
public class IntLitrExpr implements RhsExpr {

	private long rawValue;
	private IntSignExpr sign;

	public IntLitrExpr(IntSignExpr sign, long rawValue) {
		this.rawValue = rawValue;
		this.sign = sign;
	}

	public IntSignExpr getSign() {
		return sign;
	}

	public long getRawValue() {
		return rawValue;
	}

	public long getValue() {
		if (sign.isPositive()) {
			return rawValue;
		} else {
			return -rawValue;
		}
	}

	public boolean isPositive() {
		return sign.isPositive();
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		sign.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new BaseType(BaseTypeEnum.INT);
	}

	@Override
	public String codeGen(MachineState m) {
		Register r = m.getUnused().pop();
		m.addStmt(AssemblyInstruction.getInstance().getLdrInstr(
				r, sign.getRepresentation() + rawValue));
		m.getUnused().push(r);
		return null;
	}

	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public int getExprSize() {
		return 4;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt(String.format("%s%d", sign.getRepresentation(), rawValue));
	}
}
