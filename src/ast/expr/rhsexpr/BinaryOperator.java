package ast.expr.rhsexpr;

public enum BinaryOperator {
	MULTIPLY("MUL"), DIVIDE("DIV"), MODULAR("MOD"), PLUS("ADD"), MINUS("SUB"), 
	GREATER_THAN("MOVGT"), GREATER_OR_EQUAL("MOVGE"), SMALLER_THAN("MOVLT"), SMALLER_OR_EQUAL("MOVLE"), EQUALS_EQUALS("MOVEQ"), NOT_EQUALS("MOVNE"), 
	LOGICAL_AND("AND"), LOGICAL_OR("ORR");
	
	private String assemblyCommand;
	
	BinaryOperator(String assemblyCommand){
		this.assemblyCommand = assemblyCommand;
	}
	
	public String getAssemblyCommand(){
		return assemblyCommand;
	}
}
