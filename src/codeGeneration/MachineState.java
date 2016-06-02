package codeGeneration;

import codeGeneration.Assembly.AssemblyProgram;

import java.util.ArrayList;


/*
 * Represents the machine state such as rsp and error/print msgs
 */

public class MachineState extends AssemblyProgram {
	private int currrentFunctionDeclarationsCount = 0;
	private int numberOfConstants = 0;
	private int numberOfIfStatements = 0;
	private int numberOfWhileStatements = 0; //used for generating while labels, label starts from 1
	private int numberOfInstructions = 0;
	private RegisterStack unusedRegs = new RegisterStack();
	private ArrayList<String> generatedAssembly = new ArrayList<>();
	private boolean needsPrintFunctions = false;
	private boolean needsPrintString = false;
	private boolean needsExitFunctions = false;
	private boolean needsOverflowError = false;
	private boolean needsDivisionByZeroError = false;
	private boolean needsRuntimeError = false;
	private boolean needsReadInt = false;
	private boolean needsReadChar = false;
	private boolean needsArraysError = false;
	private boolean needsNullPtr = false;
	private long rspOffset = 0; // difference between current rsp and rsp at program start
	private long savedRsp = 0;

	public long getRspOffset() {
		return rspOffset;
	}

	public void setRspOffset(long rsp) {
		rspOffset = rsp;
	}

	public MachineState() {
		super();
	}

	public MachineState(String filename) {
		super(filename);
	}
	
	public void deadCodeElim(){
		DeadCodeElim dce = new DeadCodeElim(generatedAssembly);
		dce.optimise();
		generatedAssembly = dce.getOptimised();
	}

	public RegisterStack getUnused(){
		return unusedRegs;
	}

	// needed for unary operator
	public Register getLastUsedRegister() {
		return unusedRegs.getLastUsedRegister();
	}

	public void saveRsp(long rspOffset) {
		savedRsp = rspOffset;
	}

	public long getSavedRsp() {
		return savedRsp;
	}
	
	public void setCurrrentFunctionDeclarationsCount(int count) {
		currrentFunctionDeclarationsCount = count;
	}

	public int getCurrrentFunctionDeclarationsCount() {
		return currrentFunctionDeclarationsCount;
	}

	public void addStmt(String stmt){
		generatedAssembly.add(stmt);
		numberOfInstructions++;
	}
	
	public void addStmt(String stmt, long rsp){
		addStmt(stmt);
		rspOffset += rsp;
	}

	public void addThrowRuntimeErrorStmt(){
		addStmt("p_throw_runtime_error:\n");
		addStmt("\tBL p_print_string\n");
		addStmt("\tMOV r0, #-1\n");
		addStmt("\tBL exit\n");
	}

	public void addFreePairStmt(int sizeOfFst){

	}

	public ArrayList<String> getAssembly(){
		return generatedAssembly;
	}

	public void addToCurrentInstruction(String s){
		String t = generatedAssembly.get(numberOfInstructions-1);
		t += s;
		generatedAssembly.set(numberOfInstructions-1, t);
	}
	
	public String getNextIfLabel(){
		numberOfIfStatements++;
		return "IF_L" + numberOfIfStatements;
	}
	
	public String getNextWhileLabel(){
		numberOfWhileStatements++;
		return "WHILE_L" + numberOfWhileStatements;
	}
	
	//adds a constant and returns the identifier
	public String addConstant(String s){
		String constIdent = getConstantIdentifier();
		generatedAssembly.add(1+numberOfConstants*3, constIdent + ":\n");
		generatedAssembly.add(2+numberOfConstants*3, ".word " + getRealLength(s) + "\n");
		generatedAssembly.add(3+numberOfConstants*3, ".ascii " + s + "\n");
		numberOfConstants++;
		return constIdent;
	}
	
	private int getRealLength(String s){
		int len = s.length();
		int numOfEscapedChars = 0;		
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='\\'){
				numOfEscapedChars++;
				i++;
			}
		}
		return len-2-numOfEscapedChars;
	}
	
	private String getConstantIdentifier(){
		return "msg_" + numberOfConstants;
	}
	
	public void expectPrintStmt(){
		needsPrintFunctions = true;
		needsPrintString = true;
	}
	
	public boolean needsPrintFunctions(){
		return needsPrintFunctions;
	}
	
	public void expectExitStmt(){
		needsRuntimeError = true;
		needsExitFunctions = true;
		needsPrintString = true;
	}

	public boolean needsExitFunctions(){
		return needsExitFunctions;
	}

	public boolean needsPrintStrings(){
		return needsPrintString;
	}

	public void expectOverflowError(){
		expectRuntimeError();
		needsOverflowError = true;
	}

	public void expectDivisionByZeroError(){
		expectRuntimeError();
		needsDivisionByZeroError  = true;
	}

	public void expectRuntimeError(){
		needsRuntimeError = true;
		needsPrintString = true;
	}

	public void expectReadInts() {
		needsReadInt = true;
	}

	public void expectReadChars() {
		needsReadChar = true;
	}

	public void expectArraysErrors() {
		expectRuntimeError();
		needsArraysError = true;
	}

	public void expectNullPtr(){
		needsNullPtr = true;
		expectRuntimeError();
	}

	public boolean needsArraysErrors() {
		return needsArraysError;
	}

	public boolean needsOverflowErrors(){
		return needsOverflowError;
	}

	public boolean needsDivisionByZeroErrors(){
		return needsDivisionByZeroError;
	}

	public boolean needsRuntimeErrors(){
		return needsRuntimeError;
	}

	public boolean needsReadInts(){
		return needsReadInt;
	}

	public boolean needsReadChars(){
		return needsReadChar;
	}

	public boolean needsNullPtr(){
		return needsNullPtr;
	}

}
