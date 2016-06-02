package ast.expr.rhsexpr;

import c_codeGeneration.InstructionAccumulator;
import symbolTable.SymbolTable;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.PairType;
import astVisitor.Visitor;
import codeGeneration.MachineState;
import codeGeneration.Register;
import codeGeneration.AssemblyInstruction;


/*
 * Class representing a pair literal(a.k.a NULL)
 */
public class PairLitrExpr implements RhsExpr {

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new PairType(null, null);
	}

	// Note: using 0 as null
	@Override
	public String codeGen(MachineState m) {
		Register r = m.getUnused().pop();
		m.addStmt(AssemblyInstruction.getInstance().getLdrInstr(r, "0"));
		m.getUnused().push(r);
		return null;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		//TODO C
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public int getExprSize() {
		return 0;
	}

}
