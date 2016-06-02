package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;


/*
 * Represents an else statement
 */
public class ElseBranchStmt implements Statement {

	private Statement falseBranch;

	public ElseBranchStmt(Statement falseBranch) {
		this.falseBranch = falseBranch;
	}

	public Statement getFalseBranch() {
		return falseBranch;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		falseBranch.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {

		long rsp  = m.getRspOffset();
		// need to set up the stack frame

		falseBranch.codeGen(m);

		if (rsp - m.getRspOffset() != 0) {
			m.addStmt("ADD sp, sp, #" + (rsp - m.getRspOffset()));
		}
		// need to clear stack frame
		m.setRspOffset(rsp);

		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		falseBranch.CGen(a);
	}

}
