package ast.expr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing a integer sign
 */
public class IntSignExpr implements Expr {

	private IntSign sign;

	public IntSignExpr(IntSign sign) {
		this.sign = sign;
	}

	public IntSign getSign() {
		return sign;
	}

	public boolean isPositive() {
		return sign == IntSign.POSITIVE;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return null;
	}

	@Override
	public String codeGen(MachineState m) {
		return null;
	}
	
	public String getRepresentation(){
		return sign.getAssemblyCode();
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public int getExprSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		
	}

}
