package ast.expr;

public enum IntSign {
	
	POSITIVE(""), NEGATIVE("-");
	
	private String intSignChar;
	
	private IntSign(String intSignChar) {
		this.intSignChar = intSignChar; 
	}
	
	public String getAssemblyCode() {
		return intSignChar;	
	}
	
}
