package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Expr;
import ast.Statement;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;


/*
 * Represents a while statement
 */
public class WhileStmt implements Statement {

	Expr condition;
	Statement body;

	public WhileStmt(Expr condition, Statement body) {
		this.condition = condition;
		this.body = body;
	}

	public Expr getCondition() {
		return condition;
	}

	public Statement getBody() {
		return body;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		condition.walk(v);
		body.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {

		AssemblyInstruction ai = AssemblyInstruction.getInstance();

		long rsp  = m.getRspOffset();

		String condLabel = m.getNextWhileLabel();
		String bodyLabel = m.getNextWhileLabel();
		m.addStmt("B " + condLabel);

		m.addStmt(bodyLabel + ":");
		body.codeGen(m);

		if (rsp - m.getRspOffset() != 0) {
			m.addStmt("\tADD sp, sp, #" + (rsp - m.getRspOffset()));
		}

		// need to clear stack frame
		m.setRspOffset(rsp);

		m.addStmt(condLabel + ":");
		condition.codeGen(m);
		Register r = m.getLastUsedRegister();
		m.addStmt("CMP " + r + ", #1");
		m.addStmt("BEQ " + bodyLabel);

		/*String whileLabel = m.getNextWhileLabel();
		m.addStmt(whileLabel + ":");

		condition.codeGen(m);

		String endWhileLabel = m.getNextWhileLabel();

		m.addStmt(ai.getCMPInstr(m.getLastUsedRegister().toString(), "#0"));

		m.addStmt("\tBEQ " + endWhileLabel + "\n");

		body.codeGen(m);

		m.addStmt("\tB " + whileLabel + "\n");

		m.addStmt(endWhileLabel + ":");

		if (rsp - m.getRspOffset() != 0) {
			  m.addStmt("\tADD sp, sp, #" + (rsp - m.getRspOffset()));
		}
		// need to clear stack frame
		m.setRspOffset(rsp);
		 */
		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("");
		a.addStmt("while(");
		condition.CGen(a);
		a.addStmt("){");
		a.pushBuilderAndReset();
		
		body.CGen(a);
		a.addStmt("}");
	}

}
