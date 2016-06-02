package ast.expr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing an identifier
 * Used by all *RefExpr and Decl
 */
public class IdentExpr implements RhsExpr {

	String identName;

	public IdentExpr(String identName) {
		this.identName = identName;
	}

	public String getIdentName() {
		return identName;
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

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public int getExprSize() {
		return 0;
	}
	
	public String getRepresentation(){
		return identName;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub
		
	}


}
