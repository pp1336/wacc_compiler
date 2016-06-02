package ast.stmt;

import symbolTable.SymbolTable;
import ast.Expr;
import ast.Statement;
import ast.expr.rhsexpr.BinaryOperatorExpr;
import ast.expr.rhsexpr.BoolLitrExpr;
import ast.expr.rhsexpr.CallExpr;
import ast.expr.rhsexpr.CharLitrExpr;
import ast.expr.rhsexpr.IntLitrExpr;
import ast.expr.rhsexpr.StringLitrExpr;
import ast.expr.rhsexpr.UnaryOperatorExpr;
import ast.expr.rhsexpr.lhsexpr.ArrayVarIndexRefExpr;
import ast.expr.rhsexpr.lhsexpr.PairVarRefExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import c_codeGeneration.InstructionAccumulator;
import codeGeneration.MachineState;


/*
 * Represents a println statement
 */
public class PrintlnStmt implements Statement {

	Expr printlnExpr;

	public PrintlnStmt(Expr printlnExpr) {
		this.printlnExpr = printlnExpr;
	}

	public Expr getPrintlnExpr() {
		return printlnExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		printlnExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		PrintStmt.codeGenForStmt(printlnExpr, m);
		m.addStmt("\tBL p_print_ln");

		return null;
	}

	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
a.instructionBuilder("");
		
		if(printlnExpr instanceof VarRefExpr){
			if(((VarRefExpr)printlnExpr).getVarDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					a.addStmt("printf(\"%i\\n\", ");
				}else if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					a.addStmt("printf(\"%c\\n\", ");
				}else if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					a.addStmt("printf(\"%b\\n\", ");
				}else{
					a.addStmt("printf(\"%p\\n\", ");
				}
			}else if(((VarRefExpr)printlnExpr).getVarDecl().getType().isArrayType()){
				if(((VarRefExpr)printlnExpr).getVarDecl().getType().getInnerType().sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%s\\n\", ");
				}else{
					a.addStmt("printf(\"%p\\n\", ");
				}
			}else if(((VarRefExpr)printlnExpr).getVarDecl().getType().isBaseType()){
				
			}else{
				a.addStmt("printf(\"%p\\n\", ");
			}
		}else if(printlnExpr instanceof ArrayVarIndexRefExpr){
			if(((ArrayVarIndexRefExpr)printlnExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.INT))){
				a.addStmt("printf(\"%i\\n\", ");
			}else if(((ArrayVarIndexRefExpr)printlnExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.CHAR))){
				a.addStmt("printf(\"%c\\n\", ");
			}else if(((ArrayVarIndexRefExpr)printlnExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.BOOL))){
				a.addStmt("printf(\"%b\\n\", ");
			}else{
				a.addStmt("printf(\"%p\\n\", ");
			}
		}else if(printlnExpr instanceof PairVarRefExpr){
			a.addStmt("printf(\"%p\\n\", ");
		}else if(printlnExpr instanceof IntLitrExpr){
			a.addStmt("printf(\"%i\\n\", ");
		}else if(printlnExpr instanceof CharLitrExpr){
			a.addStmt("printf(\"%c\\n\", ");
		}else if(printlnExpr instanceof StringLitrExpr){
			a.addStmt("printf(\"%s\\n\", ");
		}else if(printlnExpr instanceof BoolLitrExpr){
			a.addStmt("printf(\"%b\\n\", ");
		}else if(printlnExpr instanceof CallExpr){
			if(((CallExpr)printlnExpr).getFuncDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					a.addStmt("printf(\"%i\\n\", ");
				}else if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					a.addStmt("printf(\"%c\\n\", ");
				}else if(((BaseType) (((VarRefExpr)printlnExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					a.addStmt("printf(\"%b\\n\", ");
				}
			}
		}else if(printlnExpr instanceof BinaryOperatorExpr){
			if(((BinaryOperatorExpr)printlnExpr).getType(new SymbolTable()).isBaseType()){
				if(((BinaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					a.addStmt("printf(\"%i\\n\", ");
				}else if(((BinaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%c\\n\", ");
				}else if(((BinaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					a.addStmt("printf(\"%b\\n\", ");
				}
			}
		}else if(printlnExpr instanceof UnaryOperatorExpr){
			if(((UnaryOperatorExpr)printlnExpr).getType(new SymbolTable()).isBaseType()){
				if(((UnaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					a.addStmt("printf(\"%i\\n\", ");
				}else if(((UnaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%c\\n\", ");
				}else if(((UnaryOperatorExpr)printlnExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					a.addStmt("printf(\"%b\\n\", ");
				}
			}
		}else{
			a.addStmt("printf(\"%p\\n\", ");
		}
		
		
		printlnExpr.CGen(a);
		a.addStmt(");");
		a.pushBuilderAndReset();
	}

}
