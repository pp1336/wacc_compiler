package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Expr;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.MachineState;


/*
 * Represents an if statement
 */
public class IfStmt implements Statement {

	private Expr condition;
	ThenBranchStmt trueBranch;
	ElseBranchStmt falseBranch;

	public IfStmt(Expr condition, Statement trueBranch, Statement falseBranch) {
		this.condition = condition;
		this.trueBranch = new ThenBranchStmt(trueBranch);
		this.falseBranch = new ElseBranchStmt(falseBranch);
	}

	public Expr getCondition() {
		return condition;
	}

	public Statement getTrueBranch() {
		return trueBranch;
	}

	public Statement getFalseBranch() {
		return falseBranch;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		condition.walk(v);
		trueBranch.walk(v);
		falseBranch.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {

		condition.codeGen(m);

		String trueLabel = m.getNextIfLabel();
		String falseLabel = m.getNextIfLabel();

		//comparison between expression value and zero, if equivalent
		//the go to false branch
		m.addStmt("\tCMP " + m.getLastUsedRegister() + ", #0");

		m.addStmt("\tBEQ " + falseLabel + "\n");

		trueBranch.codeGen(m);
		//true jumps to true label
		m.addStmt("\tB " + trueLabel + "\n");

		m.addStmt(falseLabel + ":");
		falseBranch.codeGen(m);

		m.addStmt(trueLabel + ":");

		return null;
	}

	@Override
	public int getVarDeclSize() {
		return trueBranch.getTrueBranch().getVarDeclSize() 
				+ falseBranch.getVarDeclSize();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("");
		a.addStmt("if(");
		condition.CGen(a);
		a.addStmt("){");
		a.pushBuilderAndReset();
		
		trueBranch.CGen(a);
		a.addStmt("}else{");
		falseBranch.CGen(a);
		a.addStmt("}");
	}

}
