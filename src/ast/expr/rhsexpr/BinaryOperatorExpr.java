package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a binary operator expression
 */
public class BinaryOperatorExpr implements RhsExpr {
	Expr leftExpr;
	Expr rightExpr;
	BinaryOperator op;

	public BinaryOperatorExpr(BinaryOperator op) {
		this.op = op;
	}

	public void setLeftExpr(Expr leftExpr) {
		this.leftExpr = leftExpr;
	}

	public void setRightExpr(Expr rightExpr) {
		this.rightExpr = rightExpr;
	}

	public Expr getLeftExpr() {
		return leftExpr;
	}

	public Expr getRightExpr() {
		return rightExpr;
	}

	public BinaryOperator getOperator() {
		return op;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		leftExpr.walk(v);
		rightExpr.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		switch (op) {
		case MULTIPLY:
		case DIVIDE:
		case MODULAR:
		case PLUS:
		case MINUS:
			return new BaseType(BaseTypeEnum.INT);
		case GREATER_THAN:
		case GREATER_OR_EQUAL:
		case SMALLER_THAN:
		case SMALLER_OR_EQUAL:
		case EQUALS_EQUALS:
		case NOT_EQUALS:
		case LOGICAL_AND:
		case LOGICAL_OR:
			return new BaseType(BaseTypeEnum.BOOL);
		default:
			System.out.println("unrecognised binary operator");
			return null;
		}
	}

	@Override
	public String toString() {
		return "[" + (leftExpr.toString()) + "] " + op.toString() + " ["
				+ (rightExpr.toString()) + "]";
	}


	@Override
	public String codeGen(MachineState m) {

		Register result;
		Register notResult;
		boolean rightFirst = false;
		
		if (leftExpr.getWeight() > rightExpr.getWeight()) {
			leftExpr.codeGen(m);
			result = m.getUnused().pop();
			rightExpr.codeGen(m);
			notResult = m.getUnused().pop();
		} else {
			rightExpr.codeGen(m);
			notResult = m.getUnused().pop();
			leftExpr.codeGen(m);
			result = m.getUnused().pop();
			rightFirst = true;
		}


		switch (op) {
		case GREATER_THAN:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVGT " + result + ", #1\n");
			m.addStmt("\tMOVLE " + result + ", #0\n");
			break;
		case GREATER_OR_EQUAL:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVGE " + result + ", #1\n");
			m.addStmt("\tMOVLT " + result + ", #0\n");
			break;
		case SMALLER_THAN:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVLT " + result + ", #1\n");
			m.addStmt("\tMOVGE " + result + ", #0\n");
			break;
		case SMALLER_OR_EQUAL:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVLE " + result + ", #1\n");
			m.addStmt("\tMOVGT " + result + ", #0\n");
			break;
		case EQUALS_EQUALS:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVEQ " + result + ", #1\n");
			m.addStmt("\tMOVNE " + result + ", #0\n");
			break;
		case NOT_EQUALS:
			m.addStmt("\tCMP " + result + ", " + notResult + "\n");
			m.addStmt("\tMOVNE " + result + ", #1\n");
			m.addStmt("\tMOVEQ " + result + ", #0\n");
			break;
		case LOGICAL_AND:
			m.addStmt("\tADD " + result + ", " + result + ", " + notResult);
			m.addStmt("\tCMP " + result + ", #2\n");
			m.addStmt("\tMOVEQ " + result + ", #1\n");
			m.addStmt("\tMOVNE " + result + ", #0\n");
			break;
		case LOGICAL_OR:
			m.addStmt("\tORR " + result + ", " + result + ", " + notResult);
			m.addStmt("\tCMP " + result + ", #1\n");
			m.addStmt("\tMOVEQ " + result + ", #1\n");
			m.addStmt("\tMOVNE " + result + ", #0\n");
			break;
		case DIVIDE:
		case MODULAR:
		case MULTIPLY:
		case PLUS:
		case MINUS:
			m.addStmt(getBinOpInstr(result, notResult));
			m.addStmt(getErrorInstr());

			if (op == BinaryOperator.DIVIDE || op == BinaryOperator.MODULAR) {
				Register resR = op == BinaryOperator.DIVIDE ? Register.r0 : Register.r1; 
				m.addStmt("MOV " + result + ", " + resR);
				m.expectDivisionByZeroError();
			} else {
				m.expectOverflowError();
			}

			break;
		default:
			System.out.println("unrecognised binary operator");
		}

		m.getUnused().push(notResult);
		m.getUnused().push(result, 0);

		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		leftExpr.CGen(a);
		switch (op){
			case MULTIPLY:
				a.addStmt("*");
				break;
			case DIVIDE:
				a.addStmt("/");
				break;
			case MODULAR:
				a.addStmt("%");
				break;
			case PLUS:
				a.addStmt("+");
				break;
			case MINUS:
				a.addStmt("-");
				break;
			case LOGICAL_AND:
				a.addStmt("&&");
				break;
			case LOGICAL_OR:
				a.addStmt("||");
				break;
			case NOT_EQUALS:
				a.addStmt("!=");
				break;
			case EQUALS_EQUALS:
				a.addStmt("==");
				break;
			case GREATER_OR_EQUAL:
				a.addStmt(">=");
				break;
			case GREATER_THAN:
				a.addStmt(">");
				break;
			case SMALLER_OR_EQUAL:
				a.addStmt("<=");
				break;
			case SMALLER_THAN:
				a.addStmt("<");
				break;
		}
		rightExpr.CGen(a);
	}

	private String getErrorInstr() {
		switch (op) {
		case MULTIPLY:
			return "BLNE p_throw_overflow_error";
		case DIVIDE:
			return "BL p_check_divide_by_zero\nBL __aeabi_idiv";
		case MODULAR:
			return "BL p_check_divide_by_zero\nBL __aeabi_idivmod";
		case MINUS:
		case PLUS:
			return "BLVS p_throw_overflow_error";
		default:
			System.out.println("unrecognised binary operator");
			return null;
		}
	}

	private String getBinOpInstr(Register r1, Register r2) {
		switch (op) {
		case MULTIPLY: // SMULL r4, r5, r4, r5
			// CMP r5, r4, ASR #31
			return "SMULL " + r1 + ", " + r2 + ", " + r1 + ", " + r2 + "\n"
			+ "CMP " + r2 + ", " + r1 + ", ASR #31";
		case DIVIDE:
			return "MOV " + Register.r0 + ", " + r1 + "\n" + "MOV "
			+ Register.r1 + ", " + r2;
		case MODULAR:
			return "MOV " + Register.r0 + ", " + r1 + "\n" + "MOV "
			+ Register.r1 + ", " + r2;
		case PLUS: // ADDS r4, r4, r5
			return "ADDS " + r1 + ", " + r1 + ", " + r2;
		case MINUS: // SUBS r4, r4, r5
			return "SUBS " + r1 + ", " + r1 + ", " + r2;
		default:
			System.out.println("unrecognised binary operator");
			return null;
		}
	}

	@Override
	public int getWeight() {
		int costLeftTraversal = max(leftExpr.getWeight(),
				rightExpr.getWeight() + 1);
		int costRightTraversal = max(leftExpr.getWeight() + 1,
				rightExpr.getWeight());
		return min(costLeftTraversal, costRightTraversal);
	}

	private int max(int u, int v) {
		if (u > v) {
			return u;
		}
		return v;
	}

	private int min(int u, int v) {
		if (u > v) {
			return v;
		}
		return u;
	}

	@Override
	public int getExprSize() {
		return leftExpr.getExprSize() + rightExpr.getExprSize();
	}
}
