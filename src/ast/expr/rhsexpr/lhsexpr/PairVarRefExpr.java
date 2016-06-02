package ast.expr.rhsexpr.lhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.decl.VarDecl;
import ast.expr.IdentExpr;
import ast.expr.rhsexpr.LhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import ast.type.NoType;
import ast.type.PairType;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing a reference to fst/snd element of a pair
 */
public class PairVarRefExpr implements LhsExpr {

	private PairEnum index;
	private LhsExpr pairVar;

	public PairVarRefExpr(PairEnum index, LhsExpr pairVar) {
		this.index = index;
		this.pairVar = pairVar;
	}

	public LhsExpr getPairVarRefExpr() {
		return pairVar;
	}

	public PairEnum getIndex() {
		return index;
	}

	@Override
	public VarRefExpr getVarRefExpr() {
		return pairVar.getVarRefExpr();
	}

	@Override
	public VarDecl getVarDecl() {
		return pairVar.getVarDecl();
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		pairVar.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		Type type = pairVar.getType(st);
		if (!type.isPairType()) {
			return new NoType();
		}

		PairType p = (PairType) type;
		if (index == PairEnum.FST) {
			return p.getFstType();
		}
		return p.getSndType();
	}

	@Override
	public IdentExpr getIdentExpr() {
		return pairVar.getIdentExpr();
	}

	@Override
	public String codeGen(MachineState m) {
		pairVar.codeGen(m);
		m.addStmt("\tMOV r0, " + m.getLastUsedRegister() + "\n");
		m.addStmt("BL p_check_null_pointer");
		m.expectNullPtr();

		if (index == PairEnum.FST) {
			m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
					+ m.getLastUsedRegister() + "]\n");

			if (this.getTypeFromDecl().getSize() == 1) {
				m.addStmt("\tLDRSB " + m.getLastUsedRegister() + ", ["
						+ m.getLastUsedRegister() + "]\n");
			} else {
				m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
						+ m.getLastUsedRegister() + "]\n");
			}

		} else {// SND
			m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
					+ m.getLastUsedRegister() + ", #4]\n");

			if (this.getTypeFromDecl().getSize() == 1) {
				m.addStmt("\tLDRSB " + m.getLastUsedRegister() + ", ["
						+ m.getLastUsedRegister() + "]\n");
			} else {
				m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
						+ m.getLastUsedRegister() + "]\n");
			}
		}

		return "NotYetImplemented";
	}

	@Override
	public String generateCodeForAddress(MachineState m) {
		pairVar.codeGen(m);
		m.addStmt("\tMOV r0, " + m.getLastUsedRegister() + "\n");
		m.addStmt("BL p_check_null_pointer");
		m.expectNullPtr();
		if (index == PairEnum.FST) {
			m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
					+ m.getLastUsedRegister() + "]\n");
		} else {
			m.addStmt("\tLDR " + m.getLastUsedRegister() + ", ["
					+ m.getLastUsedRegister() + ", #4]\n");
		}

		return null;
	}

	@Override
	public int getWeight() {
		return pairVar.getWeight();
	}

	@Override
	public int getExprSize() {
		return getTypeFromDecl().getSize();
	}

	@Override
	public Type getTypeFromDecl() {
		PairType type = (PairType) pairVar.getTypeFromDecl();
		if (index == PairEnum.FST) {
			return type.getFstType();
		}
		return type.getSndType();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt("PAIR VAR REF EXPR");
	}
}
