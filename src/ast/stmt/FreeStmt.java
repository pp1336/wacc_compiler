package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Expr;
import ast.Statement;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;
import ast.expr.rhsexpr.LhsExpr;


/*
 * Represents a free statement
 */
public class FreeStmt implements Statement {

	Expr freeExpr;

	public FreeStmt(Expr freeExpr) {
		this.freeExpr = freeExpr;
	}

	public Expr getFreeExpr() {
		return freeExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		freeExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		AssemblyInstruction ai = AssemblyInstruction.getInstance();

		if (freeExpr instanceof LhsExpr) {
			freeExpr.codeGen(m);
		}else{
			System.err.println("ERROR: Trying to free something other than variable reference.");
		}
		m.addStmt(ai.getMovRegInstr(Register.r0, m.getLastUsedRegister()));
		m.addStmt("\tBL p_free_pair\n");
		m.expectExitStmt();
		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("free(");
		freeExpr.CGen(a);
		a.addStmt(");");
		a.pushBuilderAndReset();
	}

}
