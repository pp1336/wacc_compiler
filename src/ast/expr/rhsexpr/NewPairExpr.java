package ast.expr.rhsexpr;

import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.expr.RhsExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import ast.type.PairType;
import astVisitor.Visitor;
import c_codeGeneration.InstructionAccumulator;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a new unnamed pair
 */
public class NewPairExpr implements RhsExpr {

	Pair<Expr, Expr> p;

	public NewPairExpr(Pair<Expr, Expr> p) {
		this.p = p;
	}

	public Expr getFst() {
		return p.getFst();
	}

	public Expr getSnd() {
		return p.getSnd();
	}


	public Pair<Expr, Expr> getP(){
				return p;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		p.getFst().walk(v);
		p.getSnd().walk(v);
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return new PairType(p.fst.getType(st), p.snd.getType(st));
	}

	@Override
	public String codeGen(MachineState m) {
		Register pairReg = m.getUnused().pop();

		m.addStmt(AssemblyInstruction.getInstance().getLdrInstr(Register.r0, "8"));
		m.addStmt(AssemblyInstruction.getInstance().getBlInstr("malloc"));
		m.addStmt(AssemblyInstruction.getInstance().getMovRegInstr(pairReg, Register.r0));

		p.getFst().codeGen(m);

		m.addStmt(AssemblyInstruction.getInstance().
				getLdrInstr(Register.r0, "" + p.getFst().getExprSize()));
		m.addStmt(AssemblyInstruction.getInstance().getBlInstr("malloc"));
		Register elementReg = m.getUnused().pop();

		if (p.getFst().getExprSize() == 1) {
			m.addStmt("STRB " + elementReg + ", [" + Register.r0 + "]\n"); 
		} else {
			m.addStmt(AssemblyInstruction.getInstance().
					getStrInstr(elementReg, Register.r0));
		}

		m.getUnused().push(elementReg);
		m.addStmt(AssemblyInstruction.getInstance().
				getStrInstr(Register.r0, pairReg));

		p.getSnd().codeGen(m);

		m.addStmt(AssemblyInstruction.getInstance().
				getLdrInstr(Register.r0, "" + p.getSnd().getExprSize()));
		m.addStmt(AssemblyInstruction.getInstance().getBlInstr("malloc"));
		elementReg = m.getUnused().pop();

		if (p.getSnd().getExprSize() == 1) {
			m.addStmt("STRB " + elementReg + ", [" + Register.r0 + "]\n"); 
		} else {
			m.addStmt(AssemblyInstruction.getInstance().
					getStrInstr(elementReg, Register.r0));
		} 

		m.getUnused().push(elementReg);
		m.addStmt(AssemblyInstruction.getInstance().
				getStrInstr(Register.r0, pairReg, "4"));
		m.getUnused().push(pairReg, 0);
		return null;
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public int getExprSize() {
		return p.getFst().getExprSize() + p.getSnd().getExprSize();
	}

    @Override
    public void CGen(InstructionAccumulator a) {
        a.addStmt(genStringRepOfType(p.getFst().getType(new SymbolTable())) + " fst;");
        a.addStmt(genStringRepOfType(p.getSnd().getType(new SymbolTable())) + " snd;");
    }

    public String genStringRepOfType(Type t){
        if(t.isArrayType()){
            if(t.getInnerType().sameType(new BaseType(BaseTypeEnum.INT))){
                return("int[] ");
            }else if(t.getInnerType().sameType(new BaseType(BaseTypeEnum.BOOL))){
                return("bool[] ");
            }else{//CHAR
                return("char[] ");
            }
        }else if(t.isBaseType()){
            if(t.sameType(new BaseType(BaseTypeEnum.INT))){
                return("int ");
            }else if(t.sameType(new BaseType(BaseTypeEnum.BOOL))){
                return("bool ");
            }else{//CHAR
                return("char ");
            }
        }else{//pair type
            //not yet implemented TODO
        }
        return "";
    }
}
