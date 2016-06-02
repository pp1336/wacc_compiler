package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.MachineState;


/*
 * Represents a skip statement
 */
public class SkipStmt implements Statement {

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
	}

}
