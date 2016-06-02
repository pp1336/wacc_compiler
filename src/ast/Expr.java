package ast;

import symbolTable.SymbolTable;

/*
 * Interface for an expression
 */
public interface Expr extends AstNode {

	/*
	 * Pre: st != null,
	 * 
	 * @param takes a symbol table
	 * 
	 * @return the type of the expression or NoType if expression is not defined
	 */
	Type getType(SymbolTable st);

	/*
	 * Calculates how many registers an expression needs for a calculation
	 * 
	 * @return the number of registers needed for evaluation of the expression
	 */
	int getWeight();

	/*
	 * Calculates what is the size of the expression in bytes
	 * 
	 * @return gets the size of the expression in bytes
	 */
	int getExprSize();
}
