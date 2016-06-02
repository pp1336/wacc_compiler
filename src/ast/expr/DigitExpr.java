package ast.expr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing a single digit
 * NB: Used only during the AST building
 * 	   Has no semantic meaning in the AST	 
 */
public class DigitExpr implements Expr {
	private int value;

	public DigitExpr(int value) {
		if (0 > value || value > 9) {
			throw new IllegalArgumentException("Digit must be between 0 and 9");
		}
		this.value = value;
	}

	public int getValue() {
		return value;
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
		return "" + value;
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
		// TODO Auto-generated method stub
		
	}

}
