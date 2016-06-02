package ast.expr.rhsexpr.lhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.decl.VarDecl;
import ast.expr.IdentExpr;
import ast.expr.rhsexpr.LhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import ast.type.NoType;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a reference to an array variable at a specified index
 */
public class ArrayVarIndexRefExpr implements LhsExpr {
	private LhsExpr arrayVar;
	private Expr index;

	public ArrayVarIndexRefExpr(LhsExpr arrayVar, Expr index) {
		this.arrayVar = arrayVar;
		this.index = index;
	}

	public LhsExpr getRefedExpr() {
		return arrayVar;
	}

	public Expr getIndex() {
		return index;
	}

	@Override
	public VarRefExpr getVarRefExpr() {
		return arrayVar.getVarRefExpr();
	}

	@Override
	public VarDecl getVarDecl() {
		return arrayVar.getVarDecl();
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		arrayVar.walk(v);
		index.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		Type type = arrayVar.getType(st);
		if (!type.isArrayType()) {
			return new NoType();
		}
		return type.getInnerType();
	}

	@Override
	public IdentExpr getIdentExpr() {
		return arrayVar.getIdentExpr();
	}

	@Override
	public String codeGen(MachineState m) {
		arrayVar.codeGen(m);
		Register r = m.getUnused().pop();
		index.codeGen(m);
		// setting up parameter for p_check_array_bounds, index in r0, size in r1
		m.addStmt("MOV r0, " + m.getLastUsedRegister());
		m.addStmt("MOV r1, " + r);
		m.addStmt("BL p_check_array_bounds");
		// add 4 because size is at index 0 on the stack, size of int == 4bytes
		m.addStmt("\tADD " + r + ", " + r + ", #4");
		int shift = 2; // for int, ptr shift == 2, for bool, char shift == 0
		if (arrayVar.getTypeFromDecl().isBaseType()) {
			BaseType t = (BaseType) arrayVar.getTypeFromDecl();
			if (t.getBaseTypeEnum() == BaseTypeEnum.CHAR 
					|| t.getBaseTypeEnum() == BaseTypeEnum.BOOL) {
				shift = 0;
			}
		}
		m.addStmt("\tADD " + r + ", " + r + ", " 
					+ m.getLastUsedRegister() + ", LSL #" + shift);
		m.addStmt("\tLDR " + r + ", [" + r + "]");
		m. expectArraysErrors();
		m.getUnused().push(r, 0);
		return null;
	}

	@Override
	public String generateCodeForAddress(MachineState m) {
		arrayVar.codeGen(m);
		Register r = m.getUnused().pop();
		index.codeGen(m);
		// setting up parameter for p_check_array_bounds, index in r0, size in r1
		m.addStmt("MOV r0, " + m.getLastUsedRegister());
		m.addStmt("MOV r1, " + r);
		m.addStmt("BL p_check_array_bounds");
		// add 4 because size is at index 0 on the stack, size of int == 4bytes
		m.addStmt("\tADD " + r + ", " + r + ", #4");
		int shift = 2; // for int, ptr shift == 2, for bool, char shift == 0
		if (arrayVar.getTypeFromDecl().isBaseType()) {
			BaseType t = (BaseType) arrayVar.getTypeFromDecl();
			if (t.getBaseTypeEnum() == BaseTypeEnum.CHAR 
					|| t.getBaseTypeEnum() == BaseTypeEnum.BOOL) {
				shift = 0;
			}
		}
		m.addStmt("\tADD " + r + ", " + r + ", "
					+ m.getLastUsedRegister() + ", LSL #" + shift);
		m. expectArraysErrors();
		m.getUnused().push(r, 0);
		return null;
	}

	@Override
	public int getWeight() {
		return arrayVar.getWeight() + index.getWeight();
	}

	@Override
	public int getExprSize() {
		return getTypeFromDecl().getSize();
	}

	@Override
	public Type getTypeFromDecl() {
		return arrayVar.getTypeFromDecl().getInnerType();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		arrayVar.CGen(a);
		a.addStmt("[");
		index.CGen(a);
		a.addStmt("]");
	}

}
