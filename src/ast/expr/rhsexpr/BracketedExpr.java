package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.expr.RhsExpr;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing a bracketed expression
 */
public class BracketedExpr implements RhsExpr {

	protected Expr innerExpr;

	public Expr getExpr() {
		return innerExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		innerExpr.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return innerExpr.getType(null);
	}

	@Override
	public String codeGen(MachineState m) {
		innerExpr.codeGen(m);
		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt("(");
		innerExpr.CGen(a);
		a.addStmt(")");
	}

	@Override
	public int getWeight() {
		return innerExpr.getWeight();
	}

	@Override
	public int getExprSize() {
		return innerExpr.getExprSize();
	}

}
