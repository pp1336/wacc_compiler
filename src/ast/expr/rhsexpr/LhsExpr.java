package ast.expr.rhsexpr;

import ast.Type;
import ast.decl.VarDecl;
import ast.expr.IdentExpr;
import ast.expr.RhsExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import codeGeneration.MachineState;

/*
 * Interface for lhs expression
 * (a.k.a. anything that can appear on the lhs and the rhs)
 */
public interface LhsExpr extends RhsExpr {

	/*
	 * Gets the variable reference expression
	 * @return the variable reference expression
	 */
	VarRefExpr getVarRefExpr();

	/*
	 * Gets the variable declaration
	 * @return the variable declaration
	 */
	VarDecl getVarDecl();
	
	/*
	 * Gets the identity expression
	 * @return the identity expression
	 */
	IdentExpr getIdentExpr();
	
	/*
	 * Gets the type of a declaration
	 * @return the type of a declaration
	 */
	Type getTypeFromDecl();
	
	/*
	 * Used specially for read statement
	 * @return the correct instruction 
	 *         when called from read statement
	 */
	String generateCodeForAddress(MachineState m);

}
