package ast;

import astVisitor.Visitor;
import c_codeGeneration.InstructionAccumulator;
import codeGeneration.MachineState;

/*
 * Interface for an AST node
 */
public interface AstNode {

	/*
	 * Method for traversing the tree
	 * 
	 * @param takes visitor
	 */
	void walk(Visitor v);
	
	/*
	 *  Method for generating the assembly code
	 *  
	 *  @param returns null for the time being 
	 *  	   but it might be needed in the extension
	 */
	String codeGen(MachineState m);
	
	void CGen(InstructionAccumulator a);
}
