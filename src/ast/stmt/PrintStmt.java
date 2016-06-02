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
import codeGeneration.Register;


/*
 * Represents a print statement
 */
public class PrintStmt implements Statement {

	Expr printExpr;

	public PrintStmt(Expr printExpr) {
		this.printExpr = printExpr;
	}

	public Expr getPrintExpr() {
		return printExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		printExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		
		codeGenForStmt(printExpr, m);
		
		m.expectPrintStmt();
		
		return null;
	}
	
	@Override
	public int getVarDeclSize() {
		return 0;
	}
	
	public static void codeGenForStmt(Expr printExpr, MachineState m){
		//System.out.println(printExpr.getClass());
		printExpr.codeGen(m);
		Register r = m.getUnused().getLastUsedRegister();
		m.addStmt("\tMOV r0, " + r);
		//m.getUnused().push(r);
		
		
		if(printExpr instanceof VarRefExpr){
			if(((VarRefExpr)printExpr).getVarDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					m.addStmt("\tBL p_print_int");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					m.addStmt("\tBL putchar");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					m.addStmt("\tBL p_print_bool");
				}else{
					m.addStmt("\tBL p_print_reference");
				}
			}else if(((VarRefExpr)printExpr).getVarDecl().getType().isArrayType()){
				if(((VarRefExpr)printExpr).getVarDecl().getType().getInnerType().sameType(new BaseType(BaseTypeEnum.CHAR))){
					m.addStmt("\tBL p_print_string");
				}else{
					m.addStmt("\tBL p_print_reference");
				}
			}else if(((VarRefExpr)printExpr).getVarDecl().getType().isBaseType()){
				m.addStmt("NOT IMPLEMENTED YET PLS ADD ACCORDINGLY : CANNOT PRINT NOT BASE TYPE");
			}else{
				m.addStmt("\tBL p_print_reference");
			}
		}else if(printExpr instanceof ArrayVarIndexRefExpr){
			if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.INT))){
				m.addStmt("\tBL p_print_int");
			}else if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.CHAR))){
				m.addStmt("\tBL putchar");
			}else if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.BOOL))){
				m.addStmt("\tBL p_print_bool");
			}else{
				m.addStmt("\tBL p_print_reference");
			}
		}else if(printExpr instanceof PairVarRefExpr){
			m.addStmt("\tBL p_print_reference");
		}else if(printExpr instanceof IntLitrExpr){
			m.addStmt("\tBL p_print_int");
		}else if(printExpr instanceof CharLitrExpr){
			m.addStmt("\tBL putchar");
		}else if(printExpr instanceof StringLitrExpr){
			m.addStmt("\tBL p_print_string");
		}else if(printExpr instanceof BoolLitrExpr){
			m.addStmt("\tBL p_print_bool");
		}else if(printExpr instanceof CallExpr){
			if(((CallExpr)printExpr).getFuncDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					m.addStmt("\tBL p_print_int");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					m.addStmt("\tBL putchar");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					m.addStmt("\tBL p_print_bool");
				}else{
					m.addStmt("ddd");
				}
			}else{
				m.addStmt("NOT IMPLEMENTED YET PLS ADD ACCORDINGLY : CANNOT PRINT NOT BASE TYPE");
			}
		}else if(printExpr instanceof BinaryOperatorExpr){
			if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).isBaseType()){
				if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					m.addStmt("\tBL p_print_int");
				}else if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					m.addStmt("\tBL putchar");
				}else if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					m.addStmt("\tBL p_print_bool");
				}else{
					m.addStmt("fff");
				}
			}else{
				m.addStmt("BINARY OP CANNOT RETURN NON BASE TYPE");
			}
		}else if(printExpr instanceof UnaryOperatorExpr){
			if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).isBaseType()){
				if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					m.addStmt("\tBL p_print_int");
				}else if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					m.addStmt("\tBL putchar");
				}else if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					m.addStmt("\tBL p_print_bool");
				}else{
					m.addStmt("eee");
				}
			}else{
				m.addStmt("UNARY OP CANNOT RETURN NON BASE TYPE");
			}
		}else{
			m.addStmt("\tBL p_print_reference");
			//m.addStmt("NOT IMPLEMENTED YET PLS ADD ACCORDINGLYa");
		}
		
		m.needsPrintStrings();
		m.expectPrintStmt();
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("");
		
		if(printExpr instanceof VarRefExpr){
			if(((VarRefExpr)printExpr).getVarDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					a.addStmt("printf(\"%i\", ");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					a.addStmt("printf(\"%c\", ");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					a.addStmt("printf(\"%b\", ");
				}else{
					a.addStmt("printf(\"%p\", ");
				}
			}else if(((VarRefExpr)printExpr).getVarDecl().getType().isArrayType()){
				if(((VarRefExpr)printExpr).getVarDecl().getType().getInnerType().sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%s\", ");
				}else{
					a.addStmt("printf(\"%p\", ");
				}
			}else if(((VarRefExpr)printExpr).getVarDecl().getType().isBaseType()){
				
			}else{
				a.addStmt("printf(\"%p\", ");
			}
		}else if(printExpr instanceof ArrayVarIndexRefExpr){
			if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.INT))){
				a.addStmt("printf(\"%i\", ");
			}else if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.CHAR))){
				a.addStmt("printf(\"%c\", ");
			}else if(((ArrayVarIndexRefExpr)printExpr).getTypeFromDecl().sameType(new BaseType(BaseTypeEnum.BOOL))){
				a.addStmt("printf(\"%b\", ");
			}else{
				a.addStmt("printf(\"%p\", ");
			}
		}else if(printExpr instanceof PairVarRefExpr){
			a.addStmt("printf(\"%p\", ");
		}else if(printExpr instanceof IntLitrExpr){
			a.addStmt("printf(\"%i\", ");
		}else if(printExpr instanceof CharLitrExpr){
			a.addStmt("printf(\"%c\", ");
		}else if(printExpr instanceof StringLitrExpr){
			a.addStmt("printf(\"%s\", ");
		}else if(printExpr instanceof BoolLitrExpr){
			a.addStmt("printf(\"%b\", ");
		}else if(printExpr instanceof CallExpr){
			if(((CallExpr)printExpr).getFuncDecl().getType().isBaseType()){
				if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.INT){
					a.addStmt("printf(\"%i\", ");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.CHAR){
					a.addStmt("printf(\"%c\", ");
				}else if(((BaseType) (((VarRefExpr)printExpr).getVarDecl().getType())).getBaseTypeEnum()==BaseTypeEnum.BOOL){
					a.addStmt("printf(\"%b\", ");
				}
			}
		}else if(printExpr instanceof BinaryOperatorExpr){
			if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).isBaseType()){
				if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					a.addStmt("printf(\"%i\", ");
				}else if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%c\", ");
				}else if(((BinaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					a.addStmt("printf(\"%b\", ");
				}
			}
		}else if(printExpr instanceof UnaryOperatorExpr){
			if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).isBaseType()){
				if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.INT))){
					a.addStmt("printf(\"%i\", ");
				}else if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.CHAR))){
					a.addStmt("printf(\"%c\", ");
				}else if(((UnaryOperatorExpr)printExpr).getType(new SymbolTable()).sameType(new BaseType(BaseTypeEnum.BOOL))){
					a.addStmt("printf(\"%b\", ");
				}
			}
		}else{
			a.addStmt("printf(\"%p\", ");
		}
		
		
		printExpr.CGen(a);
		a.addStmt(");");
		a.pushBuilderAndReset();
	}

}
