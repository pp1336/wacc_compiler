package ast;

import codeGeneration.MachineState;

/*
 * Interface for statements
 * NB: there are no common methods, but it is 
 * 	   required to follow the structure of the program
 */
public interface Statement extends AstNode {

	/*
	 * Method for generating the assembly code
	 * 
	 * @param returns null for the time being but it might be needed in the
	 * extension
	 */
	@Override
	String codeGen(MachineState m);

	/*
	 * Calculates what size does the declaration takes in bytes
	 * 
	 * @return gets the size of the declaration bytes
	 */
	int getVarDeclSize();

}
