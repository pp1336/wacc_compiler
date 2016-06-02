package ast.expr.rhsexpr.lhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.decl.Decl;
import ast.decl.VarDecl;
import ast.expr.IdentExpr;
import ast.expr.rhsexpr.LhsExpr;
import ast.type.NoType;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a reference to a variable declared previously
 */
public class VarRefExpr implements LhsExpr {

	private IdentExpr id;
	private VarDecl ref;

	public VarRefExpr(IdentExpr id) {
		this.id = id;
	}

	public String getVarName() {
		return id.getIdentName();
	}

	@Override
	public VarRefExpr getVarRefExpr() {
		return this;
	}

	public void setVarDecl(VarDecl ref) {
		this.ref = ref;
	}

	@Override
	public VarDecl getVarDecl() {
		return ref;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		id.walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		Decl decl = st.lookup(getIdentExpr());
		return decl == null ? new NoType() : decl.getType();
	}

	@Override
	public IdentExpr getIdentExpr() {
		return id;
	}

	@Override
	public String codeGen(MachineState m) {

		long current = m.getRspOffset();

		Register r = m.getUnused().pop();

		//LDR r4, [sp, #8]
		long offset = ref.getRspValue() - current;

		String instr = ref.getType().getSize() == 1 ? "LDRSB " : "LDR ";

		if (offset == 0) {
			m.addStmt(instr + r + ", [sp]\n");
		} else {
			m.addStmt(instr + r + ", [sp, #" + offset + "]\n");
		}

		m.getUnused().push(r);

		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt(id.getRepresentation());
	}

	/*
	public String generateCodeForReadStmt(MachineState m) {
		long current = m.getRspOffset();

		Register r = m.getUnused().pop();

		long offset = ref.getRspValue() - current;

		m.getUnused().push(r);
		//for adding git stuff only comment :D
		return "ADD " + r + ", sp, #" + offset;
	}
	 */
	@Override
	public String generateCodeForAddress(MachineState m) {
		long current = m.getRspOffset();

		Register r = m.getUnused().pop();

		//LDR r4, [sp, #8]
		long offset = ref.getRspValue() - current;
		
		if (offset == 0) {
			m.addStmt("MOV " + r + ", sp\n");
		} else {
			m.addStmt("ADD " + r + ", sp, #" + offset);
		}
		
		m.getUnused().push(r);

		return null;
	}

	@Override
	public int getWeight() {
		return id.getWeight();
	}

	@Override
	public int getExprSize() {
		return getTypeFromDecl().getSize();
	}

	@Override
	public Type getTypeFromDecl() {
		return ref.getType();
	}

}
