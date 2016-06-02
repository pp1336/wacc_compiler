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
 * Class representing a char
 */
public class CharLitrExpr implements RhsExpr {

	private char value;

	public CharLitrExpr(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new BaseType(BaseTypeEnum.CHAR);
	}

	@Override
	public String codeGen(MachineState m) {
		Register r = m.getUnused().pop();
		m.addStmt(AssemblyInstruction.getInstance().getMovCharInstr(
				r, value));
		m.getUnused().push(r);
		return null;
	}

	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public int getExprSize() {
		return 1;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt(String.format("\'%c\'", value));
	}

}
