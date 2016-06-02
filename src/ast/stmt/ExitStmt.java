package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Expr;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.MachineState;


/*
 * Represents an exit statement
 */
public class ExitStmt implements Statement {

	private Expr exitExpr;

	public ExitStmt(Expr exitExpr) {
		this.exitExpr = exitExpr;
	}

	public Expr getExitExpr() {
		return exitExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		exitExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		exitExpr.codeGen(m);
		String setExitCodeAndExit = "MOV " + "r0, " 
				+ m.getUnused().firstUnused().toString() + "\nBL exit\n";
		m.addStmt(setExitCodeAndExit);
		return null; 
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("return ");
		exitExpr.CGen(a);
		a.pushBuilderAndReset();
	}

}
