package ast.expr.rhsexpr;

import java.util.List;

import c_codeGeneration.InstructionAccumulator;

import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.ArrayType;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing an unnamed array literal
 */
public class ArrayLitrExpr implements RhsExpr {

	private List<Expr> elems;

	public ArrayLitrExpr(List<Expr> elems) {
		this.elems = elems;
	}

	public void pushElem(Expr elem) {
		elems.add(elem);
	}

	// might be used in the future
	public Expr popElem() {
		return elems.remove(0);
	}

	public Expr getElem(int pos) {
		return elems.get(pos);
	}

	public int size() {
		return elems.size();
	}

	// might be used in the future
	public void insertElem(int pos, Expr elem) {
		elems.add(pos, elem);
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		for (Expr e : elems) {
			e.walk(v);
		}
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		if (elems.isEmpty()) {
			return new ArrayType(null);
		}
		return new ArrayType(elems.get(0).getType(st));
	}

	@Override
	public String codeGen(MachineState m) {

		AssemblyInstruction ai = AssemblyInstruction.getInstance();
		Register arrayReg = m.getUnused().pop();
		Register elementReg = null;
		//4 is for the size of the array which is always an integer
		m.addStmt(ai.getLdrInstr(Register.r0, this.getExprSize() + 4 + ""));
		m.addStmt(ai.getBlInstr("malloc"));                  
		m.addStmt(ai.getMovRegInstr(arrayReg, Register.r0));

		int offset = 4;
		String instr = "";
		if (!elems.isEmpty()) {
			instr = elems.get(0).getExprSize() == 1 ? "STRB " : "STR ";
		}

		for(int i = 0; i < elems.size(); i++) {
			elems.get(i).codeGen(m);
			elementReg = m.getLastUsedRegister();
			//STRB r5, [r4, #4]
			m.addStmt(instr + elementReg + ", " + "[" + arrayReg + ", #" + offset + "]");
			offset += elems.get(i).getExprSize();
		}
		if (elems.isEmpty()) {
			elementReg = m.getUnused().pop();
		}
		m.addStmt(ai.getLdrInstr(elementReg, elems.size() + ""));
		if (elems.isEmpty()) {
			m.getUnused().push(elementReg, 0);
		}
		m.addStmt(ai.getStrInstr(elementReg, arrayReg));
		m.getUnused().push(arrayReg, 0);
		return null;
	}

	@Override
	public int getWeight() {
		return 2;
	}

	@Override
	public int getExprSize() {
		int size = 0;
		for (Expr elem : elems) {
			size += elem.getExprSize();
		}
		return size;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt("{");
		for(int i=0; i<elems.size(); i++){
			elems.get(i).CGen(a);
			if(i!=elems.size()-1){
				a.addStmt(", ");
			}
		}
		a.addStmt("}");
	}
}
