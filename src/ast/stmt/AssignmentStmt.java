package ast.stmt;

import ast.Statement;
import ast.expr.RhsExpr;
import ast.expr.rhsexpr.LhsExpr;
import ast.expr.rhsexpr.NewPairExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import c_codeGeneration.InstructionAccumulator;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Represents an assignment statement
 */
public class AssignmentStmt implements Statement {

	private LhsExpr lhs;
	private RhsExpr rhs;

	public AssignmentStmt(LhsExpr lhs, RhsExpr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public LhsExpr getLhsExpr() {
		return lhs;
	}

	public RhsExpr getRhsExpr() {
		return rhs;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		lhs.walk(v);
		rhs.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		rhs.codeGen(m);

		//long current = m.getRspOffset();
		Register r = m.getUnused().pop();;

		//long offset = lhs.getVarRefExpr().getVarDecl().getRspValue() - current;

		String code = "STR";

		if (lhs.getTypeFromDecl().isBaseType()) {
			BaseTypeEnum t =  ((BaseType) lhs.getTypeFromDecl()).getBaseTypeEnum();
			if (t == BaseTypeEnum.BOOL || t == BaseTypeEnum.CHAR) {
				code += "B";
			}
		}
		code += " ";

		lhs.generateCodeForAddress(m);
		Register address = m.getUnused().pop();
		m.addStmt(code + r.toString() + ", [" + address + "]");
		m.getUnused().push(address);
		m.getUnused().push(r);

		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		if(!(rhs instanceof NewPairExpr)){
			a.instructionBuilder("");
			lhs.CGen(a);
			a.addStmt(" = ");
			rhs.CGen(a);
			a.addStmt(";");
			a.pushBuilderAndReset();
		}else{



			a.instructionBuilder("");
			lhs.CGen(a);
			a.addStmt(" = ");
			rhs.CGen(a);
			a.addStmt(";");

			a.pushBuilderAndReset();
		}

	}

}
