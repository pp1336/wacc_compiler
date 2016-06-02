package c_codeGeneration;

import java.util.ArrayList;

public class InstructionAccumulator {

	private ArrayList<String> generatedC = new ArrayList<>();
	private String builder = "";
	private boolean isUsingBuilder = false;

	private boolean isFunctionCode = false;
	private int funcPosition = 1;

	public void addStmt(String s){
		if(isUsingBuilder){
			builder = builder + " " + s;
		}else{
			if(isFunctionCode){
				generatedC.add(funcPosition, s);
				funcPosition++;
			}else{
				generatedC.add(s);
			}
		}
	}

	public ArrayList<String> getC(){
		return generatedC;
	}

	public void instructionBuilder(String s){
		builder = builder + " " + s;
		isUsingBuilder = true;
	}

	public void pushBuilderAndReset(){
		isUsingBuilder = false;
		addStmt(builder);
		builder = "";
	}

	public void nowFunction(){
		isFunctionCode = true;
	}

	public void endFunction(){
		isFunctionCode = false;
	}



}