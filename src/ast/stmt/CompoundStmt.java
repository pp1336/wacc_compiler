package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.MachineState;


/*
 * Represents compound statement
 */
public class CompoundStmt implements Statement {

	private Statement thisStmt;
	private Statement nextStmt;

	public CompoundStmt(Statement thisStmt, Statement nextStmt) {
		this.thisStmt = thisStmt;
		this.nextStmt = nextStmt;
	}

	public Statement getThisStmt() {
		return thisStmt;
	}

	public Statement getNextStmt() {
		return nextStmt;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		thisStmt.walk(v);
		nextStmt.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		thisStmt.codeGen(m);
		nextStmt.codeGen(m);
		return null;
	}

	@Override
	public int getVarDeclSize() {
		return thisStmt.getVarDeclSize() + nextStmt.getVarDeclSize();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		thisStmt.CGen(a);
		nextStmt.CGen(a);
	}

}
