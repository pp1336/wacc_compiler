package ast.decl;

import ast.AstNode;
import ast.expr.IdentExpr;
import ast.Type;

/*
 * Interface for the declarations of functions and variables
 */
public interface Decl extends AstNode {

	/*
	 * @return the name of the declaration
	 */
	String getDeclName();

	/*
	 * @return the type of the declaration
	 */
	Type getType();

	/*
	 * @return the Identity Expression (a.k.a name of the declaration)
	 */
	IdentExpr getIdentExpr();

}
