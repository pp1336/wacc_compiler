package ast.type;

public enum BaseTypeEnum {

	INT(4), CHAR(1), BOOL(1);
	
	private int size;
	
	BaseTypeEnum(int size) {
		this.size = size;
	}
	
	public int getBaseTypeSize() {
		return size;
	}

}
