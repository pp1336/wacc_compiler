package ast.decl;

import c_codeGeneration.InstructionAccumulator;
import ast.Type;
import ast.expr.IdentExpr;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing a variable declaration
 */
public class VarDecl implements Decl {

	private IdentExpr id;
	private Type type;
	// stores the rsp value which points
	//  to the variable value on the stack
	private long rsp; 

	public VarDecl(IdentExpr id, Type type) {
		this.id = id;
		this.type = type;
	}

	@Override
	public String getDeclName() {
		return id.getIdentName();
	}

	/*
	 * Returns pointer to the address
	 * of the declaration on the stack
	 */
	public long getRspValue() {
		return rsp;
	}

	/*
	 * Sets pointer to the address
	 * of the declaration on the stack
	 */
	public void setRspValue(long rsp) {
		this.rsp = rsp;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		id.walk(v);
		type.walk(v);
		v.leave();
	}

	@Override
	public IdentExpr getIdentExpr() {
		return id;
	}

	@Override
	public String codeGen(MachineState m) {
		return "Nothing to do here, everything is handled in VarDeclStmt";
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		// TODO Auto-generated method stub

	}

}
