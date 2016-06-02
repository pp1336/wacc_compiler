package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;


/*
 * Represents a then statement
 */
public class ThenBranchStmt implements Statement {

	private Statement trueBranch;

	public ThenBranchStmt(Statement trueBranch) {
		this.trueBranch = trueBranch;
	}

	public Statement getTrueBranch() {
		return trueBranch;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		trueBranch.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {

		long rsp  = m.getRspOffset();
		// need to set up the stack frame

		trueBranch.codeGen(m);

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
		trueBranch.CGen(a);
	}

}
