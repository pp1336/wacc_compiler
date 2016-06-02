package ast;

/*
 * Interface for the type of an expression
 */
public interface Type extends AstNode {

	/*
	 * Return the next level of the type of an expression
	 * 
	 * @return inner type of an expression
	 */
	Type getInnerType();

	/*
	 * Checks if two types are the same
	 * 
	 * @param type
	 * 
	 * @return true if types are the same, false if not
	 */
	boolean sameType(Type thatType);

	/*
	 * @return true if it is pair type
	 */
	boolean isPairType();

	/*
	 * @return true if it is base type
	 */
	boolean isBaseType();

	/*
	 * @return true if it is array type
	 */
	boolean isArrayType();

	/*
	 * @return the byte size of the type as it is on the stack
	 */
	int getSize();
}
