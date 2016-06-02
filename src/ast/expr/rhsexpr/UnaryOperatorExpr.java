package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.expr.RhsExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing an unary expression
 */
public class UnaryOperatorExpr implements RhsExpr {
	UnaryOperator op;
	Expr innerExpr;

	public UnaryOperatorExpr(UnaryOperator op) {
		this.op = op;
	}

	public void setExpr(Expr innerExpr) {
		this.innerExpr = innerExpr;
	}

	public Expr getInnerExpr() {
		return innerExpr;
	}

	public UnaryOperator getOperator() {
		return op;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		innerExpr.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		switch (op) {
		case MINUS:
		case LEN:
		case ORD:
			return new BaseType(BaseTypeEnum.INT);
		case CHR:
			return new BaseType(BaseTypeEnum.CHAR);
		case EXCLAMATION:
			return new BaseType(BaseTypeEnum.BOOL);
		default:
			System.out.println("unrecognised unary operator");
			return null;
		}
	}

	@Override
	public String codeGen(MachineState m) {
		Register r;
		AssemblyInstruction ai = AssemblyInstruction.getInstance();
		switch (op) {
		case MINUS:
			innerExpr.codeGen(m);
			r =  m.getLastUsedRegister();
			m.addStmt(ai.getRsbsInstr(r, r, 0));
			m.addStmt(ai.getBlvsInstr("p_throw_overflow_error"));
			m.expectOverflowError();
			break;
		case LEN:
			innerExpr.codeGen(m);
			r =  m.getLastUsedRegister();
			m.addStmt("LDR " + r + ", [" + r + "]");
			break;
		case ORD:
			if (innerExpr instanceof VarRefExpr) {
				long current = m.getRspOffset();

				r = m.getUnused().pop();

				VarRefExpr e = (VarRefExpr) innerExpr;

				long offset = e.getVarDecl().getRspValue() - current;

				if (offset == 0) {
					m.addStmt("LDRSB " + r.toString() + ", [sp]\n");
				} else {
					m.addStmt("LDRSB " + r.toString() + ", [sp, #" + offset + "]\n");
				}
				m.getUnused().push(r);
			} else {
				innerExpr.codeGen(m);
			}
			break;
		case CHR:
			innerExpr.codeGen(m);
			break;
		case EXCLAMATION:
			if (innerExpr instanceof VarRefExpr) {
				long current = m.getRspOffset();

				r = m.getUnused().pop();

				VarRefExpr e = (VarRefExpr) innerExpr;

				long offset = e.getVarDecl().getRspValue() - current;


				if (offset == 0) {
					m.addStmt("LDRSB " + r.toString() + ", [sp]\n");
				} else {
					m.addStmt("LDRSB " + r.toString() + ", [sp, #" + offset + "]\n");
				}
				m.getUnused().push(r);
			} else {
				innerExpr.codeGen(m);
			}
			r =  m.getLastUsedRegister();
			m.addStmt(ai.getEorInstr(r, r, 1));
			break;
		}
		return null;
	}

	@Override
	public int getWeight() {
		return innerExpr.getWeight();
	}

	@Override
	public int getExprSize() {
		return innerExpr.getExprSize();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		switch(op){
		case EXCLAMATION:
			a.addStmt("!");
			break;
		case MINUS:
			a.addStmt("-");
			break;
		case LEN:
			a.addStmt("len");
			break;
		case ORD:
			a.addStmt("ord");
			break;
		case CHR:
			a.addStmt("chr");
			break;
		}
	}

}
