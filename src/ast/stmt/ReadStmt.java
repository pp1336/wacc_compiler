package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Statement;
import ast.expr.rhsexpr.LhsExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;


/*
 * Represents a read statement
 */
public class ReadStmt implements Statement {

	private LhsExpr readExpr;

	public ReadStmt(LhsExpr readExpr) {
		this.readExpr = readExpr;
	}

	public LhsExpr getReadExpr() {
		return readExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		readExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {

		//m.addStmt(((VarRefExpr) readExpr).generateCodeForReadStmt(m));
		readExpr.generateCodeForAddress(m);

		m.addStmt("MOV " + Register.r0 + ", " + m.getLastUsedRegister());

		if (readExpr.getTypeFromDecl().getSize() == 1) {
			m.expectReadChars();
			m.addStmt("BL p_read_char");
		} else if (readExpr.getTypeFromDecl().getSize() == 4) {
			m.expectReadInts();
			m.addStmt("BL p_read_int");
		} else {
			System.out.println("WTF!!!");
			return "WTFFF";			
		}
		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("cin>>");
		readExpr.CGen(a);
		a.addStmt(";");
		a.pushBuilderAndReset();
	}

}
