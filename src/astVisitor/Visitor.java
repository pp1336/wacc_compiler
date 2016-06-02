package astVisitor;

import ast.decl.*;
import ast.expr.*;
import ast.expr.rhsexpr.*;
import ast.expr.rhsexpr.lhsexpr.*;
import ast.program.*;
import ast.stmt.*;
import ast.type.*;

/*
 * Interface for implementing a visitor pattern of the AST 
 */
public interface Visitor {

	void leave();

	void visit(FunctionDecl funcDecl);

	void visit(VarDecl varDecl);

	void visit(DigitExpr digit);

	void visit(IdentExpr ident);

	void visit(IntSignExpr intSign);

	void visit(ArrayLitrExpr arrayLitr);

	void visit(BinaryOperatorExpr binOp);

	void visit(BoolLitrExpr boolLitr);

	void visit(BracketedExpr bracketExpr);

	void visit(CallExpr callExpr);

	void visit(CharLitrExpr charLitr);

	void visit(IntLitrExpr intLitr);

	void visit(NewPairExpr newpair);

	void visit(PairLitrExpr pairLitr);

	void visit(StringLitrExpr stringLitr);

	void visit(UnaryOperatorExpr unOp);

	void visit(ArrayVarIndexRefExpr arrayVarIndexRefExpr);

	void visit(PairVarRefExpr pairVarRefExpr);

	void visit(VarRefExpr varRefExpr);

	void visit(Program program);

	void visit(ThenBranchStmt thenStmt);

	void visit(ElseBranchStmt esleStmt);

	void visit(AssignmentStmt assignStmt);

	void visit(BeginStmt beginStmt);

	void visit(CompoundStmt compoundStmt);

	void visit(ExitStmt exitStmt);

	void visit(FreeStmt freeStmt);

	void visit(IfStmt ifStmt);

	void visit(PrintlnStmt printlnStmt);

	void visit(PrintStmt printStmt);

	void visit(ReadStmt readStmt);

	void visit(ReturnStmt returnStmt);

	void visit(SkipStmt skipStmt);

	void visit(VarDeclStmt varDeclStmt);

	void visit(WhileStmt whileStmt);

	void visit(ArrayType arrayType);

	void visit(BaseType baseType);

	void visit(PairType pairType);

	void visit(NoType noType);

}
