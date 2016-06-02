package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.ArrayType;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a string
 */
public class StringLitrExpr implements RhsExpr {

	private String value;

	public StringLitrExpr(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new ArrayType(new BaseType(BaseTypeEnum.CHAR));
	}

	@Override
	public String codeGen(MachineState m) {
		Register r = m.getUnused().pop();
		m.addStmt("\tLDR " + r + ", =" + m.addConstant(value) + "\n");
		m.getUnused().push(r);
		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt(value);
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public int getExprSize() {
		return 4;
	}

}
