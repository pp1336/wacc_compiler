package c_codeGeneration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import codeGeneration.MachineState;
import ast.decl.FunctionDecl;
import ast.decl.VarDecl;
import ast.expr.DigitExpr;
import ast.expr.IdentExpr;
import ast.expr.IntSignExpr;
import ast.expr.rhsexpr.ArrayLitrExpr;
import ast.expr.rhsexpr.BinaryOperatorExpr;
import ast.expr.rhsexpr.BoolLitrExpr;
import ast.expr.rhsexpr.BracketedExpr;
import ast.expr.rhsexpr.CallExpr;
import ast.expr.rhsexpr.CharLitrExpr;
import ast.expr.rhsexpr.IntLitrExpr;
import ast.expr.rhsexpr.NewPairExpr;
import ast.expr.rhsexpr.PairLitrExpr;
import ast.expr.rhsexpr.StringLitrExpr;
import ast.expr.rhsexpr.UnaryOperatorExpr;
import ast.expr.rhsexpr.lhsexpr.ArrayVarIndexRefExpr;
import ast.expr.rhsexpr.lhsexpr.PairVarRefExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import ast.program.Program;
import ast.stmt.AssignmentStmt;
import ast.stmt.BeginStmt;
import ast.stmt.CompoundStmt;
import ast.stmt.ElseBranchStmt;
import ast.stmt.ExitStmt;
import ast.stmt.FreeStmt;
import ast.stmt.IfStmt;
import ast.stmt.PrintStmt;
import ast.stmt.PrintlnStmt;
import ast.stmt.ReadStmt;
import ast.stmt.ReturnStmt;
import ast.stmt.SkipStmt;
import ast.stmt.ThenBranchStmt;
import ast.stmt.VarDeclStmt;
import ast.stmt.WhileStmt;
import ast.type.ArrayType;
import ast.type.BaseType;
import ast.type.NoType;
import ast.type.PairType;
import astVisitor.Visitor;

public class CGeneration implements Visitor {

	private String fileName;
	
	private int positionOfName(String s){
		int t = 0;
		int pos = 0;
		while(s.charAt(t)!='.'){
			if(s.charAt(t)=='/'){
				pos = t;
			}
			t++;
		}
		return pos+1;
	}
	
	public CGeneration(String fileName){
		StringBuilder s = new StringBuilder();
		s.append(fileName);
		s.replace(s.length()-4, s.length(), "c");
		s.substring(positionOfName(s.toString()), s.length());
		System.out.println(s.substring(positionOfName(s.toString()), s.length()));
		this.fileName = s.substring(positionOfName(s.toString()), s.length());
	}
	
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FunctionDecl funcDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDecl varDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DigitExpr digit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IdentExpr ident) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntSignExpr intSign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayLitrExpr arrayLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinaryOperatorExpr binOp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BoolLitrExpr boolLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BracketedExpr bracketExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CallExpr callExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CharLitrExpr charLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntLitrExpr intLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NewPairExpr newpair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PairLitrExpr pairLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringLitrExpr stringLitr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnaryOperatorExpr unOp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayVarIndexRefExpr arrayVarIndexRefExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PairVarRefExpr pairVarRefExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarRefExpr varRefExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Program program) {
		PrintWriter file;
		try {
			file = new PrintWriter(fileName, "UTF-8");
			
			InstructionAccumulator a = new InstructionAccumulator();
			program.CGen(a);
			
			for(String s : a.getC()){
				file.println(s);
			}
			
			file.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("FILE NOT FOUND ON SYSTEM!!!");
		} catch (UnsupportedEncodingException e) {
			System.err.println("encoding NOT supported ON SYSTEM!!!");
		}
	}

	@Override
	public void visit(ThenBranchStmt thenStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ElseBranchStmt esleStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(AssignmentStmt assignStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BeginStmt beginStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CompoundStmt compoundStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExitStmt exitStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FreeStmt freeStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IfStmt ifStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PrintlnStmt printlnStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PrintStmt printStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ReadStmt readStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ReturnStmt returnStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SkipStmt skipStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclStmt varDeclStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WhileStmt whileStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ArrayType arrayType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BaseType baseType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PairType pairType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoType noType) {
		// TODO Auto-generated method stub
		
	}

}
