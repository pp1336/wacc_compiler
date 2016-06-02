package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a boolean value
 */

public class BoolLitrExpr implements RhsExpr {

	private boolean value;

	public BoolLitrExpr(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new BaseType(BaseTypeEnum.BOOL);
	}

	@Override
	public String codeGen(MachineState m) {
		Register r = m.getUnused().pop();
		m.addStmt(AssemblyInstruction.getInstance().getMovBoolInstr(
				r, (value ? "1" : "0")));
		m.getUnused().push(r);
		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		if(value) {
			a.addStmt("true");
		}else{
			a.addStmt("false");
		}
	}

	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public int getExprSize() {
		return 1;
	}

}
