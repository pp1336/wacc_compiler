package ast.stmt;

import ast.Expr;
import ast.Statement;
import ast.Type;
import ast.decl.VarDecl;
import ast.expr.IdentExpr;
import ast.expr.RhsExpr;
import ast.expr.rhsexpr.NewPairExpr;
import ast.expr.rhsexpr.Pair;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import ast.type.PairType;
import astVisitor.Visitor;
import c_codeGeneration.InstructionAccumulator;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Represents a variable declaration statement
 */
public class VarDeclStmt implements Statement {
	
	private Type variableType;
	private IdentExpr id;
	private RhsExpr variableExpr;
	private VarDecl varDecl;

	public VarDeclStmt(Type variableType, IdentExpr id, RhsExpr variableExpr) {
		this.variableType = variableType;
		this.id = id;
		this.variableExpr = variableExpr;
		varDecl = new VarDecl(id, variableType);
	}

	public Type getVariableType() {
		return variableType;
	}

	
	public String getVariableName() {
		return id.getIdentName();
	}

	public RhsExpr getVariableExpr() {
		return variableExpr;
	}

	public VarDecl getVarDecl() {
		return varDecl;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		variableType.walk(v);
		id.walk(v);
		variableExpr.walk(v);
		varDecl.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		variableExpr.codeGen(m);
		int offset = -variableType.getSize();
		if (variableType.isBaseType()) {
			BaseType bt = (BaseType) variableType;
			if (bt.getBaseTypeEnum() == BaseTypeEnum.BOOL 
					|| bt.getBaseTypeEnum() == BaseTypeEnum.CHAR) {
				offset = -1;
				m.addStmt("SUB sp, sp, #1", offset);
				m.addStmt("STRB " + m.getLastUsedRegister() + ", [sp]");
				varDecl.setRspValue(m.getRspOffset());
				return null;
			}
		}
		
		try{
			m.getLastUsedRegister().toString().equals("null");
			m.addStmt("PUSH {" + m.getLastUsedRegister() + "}", offset);
		}catch (NullPointerException e){
			Register r = m.getUnused().pop();
			m.addStmt("\tSUB sp, sp, #4\n", -4);
			m.addStmt("\tLDR " + m.getLastUsedRegister() + ", =0\n");
			m.addStmt("\tSTR " + m.getLastUsedRegister() + ", [sp]\n");
			m.getUnused().push(r);
		}
		
		varDecl.setRspValue(m.getRspOffset());
		return null;
	}
	
	@Override
	public int getVarDeclSize() {
		return varDecl.getType().getSize();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("");
		if(variableType.isArrayType()){
			if(variableType.getInnerType().sameType(new BaseType(BaseTypeEnum.INT))){
				a.instructionBuilder("int " + id.getIdentName() + "[] = ");
			}else if(variableType.getInnerType().sameType(new BaseType(BaseTypeEnum.CHAR))){
				a.instructionBuilder("char " + id.getIdentName() + "[] = ");
			}else{//BOOL
				a.instructionBuilder("bool " + id.getIdentName() + "[] = ");
			}
			variableExpr.CGen(a);
			a.addStmt(";");
		}else if(variableType.isPairType()){
			a.nowFunction();
			a.instructionBuilder("typedef struct ");
			a.addStmt(id.getIdentName()+"_rawType");
			a.addStmt("{");
			a.pushBuilderAndReset();
			variableExpr.CGen(a);
			a.addStmt("}" + id.getIdentName() + "_t;");
			a.endFunction();

			Pair<Expr, Expr> p = ((NewPairExpr)(variableExpr)).getP();
			a.instructionBuilder(id.getIdentName() + "_t ");
			a.addStmt(id.getIdentName());
			a.addStmt(" = { ");

			p.getFst().CGen(a);
			a.addStmt(",");

			p.getSnd().CGen(a);
			a.addStmt("};");

		}else if(variableType.isBaseType()){
			if(variableType.sameType(new BaseType(BaseTypeEnum.INT))){
				a.instructionBuilder("int " + id.getIdentName() + " = ");
			}else if(variableType.sameType(new BaseType(BaseTypeEnum.CHAR))){
				a.instructionBuilder("char " + id.getIdentName() + " = ");
			}else{//BOOL
				a.instructionBuilder("bool " + id.getIdentName() + " = ");
			}
			variableExpr.CGen(a);
			a.addStmt(";");
		}else{
			System.out.println("VARDECLSTMT.JAVA");
		}
		a.pushBuilderAndReset();
	}
	
}
