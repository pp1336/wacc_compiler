package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;


/*
 * Represents a begin end statement
 */
public class BeginStmt implements Statement {

	Statement body;

	public BeginStmt(Statement body) {
		this.body = body;
	}

	public Statement getBeginBody() {
		return body;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		body.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		long rsp  = m.getRspOffset();
		// need to set up the stack frame
		body.codeGen(m);
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
		a.addStmt("{");
		body.CGen(a);
		a.addStmt("}");
	}

}
