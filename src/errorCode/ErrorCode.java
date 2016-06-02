package errorCode;

public enum ErrorCode {
	
	SYNTAX_ERROR (100), SEMANTIC_ERROR(200), SUCCESS(0);
	
	private int numVal;

    ErrorCode(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}
