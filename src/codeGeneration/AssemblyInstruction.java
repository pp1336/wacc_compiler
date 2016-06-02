package codeGeneration;

import java.util.Set;


/*
 * Helper class for generating String instructions
 */
public class AssemblyInstruction {

	private static AssemblyInstruction instance 
		= new AssemblyInstruction();
	
	private AssemblyInstruction(){}
	
	public static AssemblyInstruction getInstance() {
		return instance;
	}

	public String getSubInstr(int value) {
		return "SUB sp, sp, #" + value + "\n";
	}
	
	public String getAddInstr(int value) {
		return "ADD sp, sp, #" + value + "\n";
	}
	
	public String getMovCharInstr(Register r, char value) {
		return "\tMOV " + r.toString() + ", #'" + value + "'\n";
	}
	
	public String getCMPInstr(String r1, String r2) {
		return "\tCMP " + r1 + ", " + r2 + "\n";
	}
	
	public String getMovBoolInstr(Register r, String value) {
		return "\tMOV " + r.toString() + ", #" + value + "\n";
	}
	
	public String getMovRegInstr(Register r1, Register r2) {
		return "\tMOV " + r1.toString() + ", " + r2.toString() + "\n";
	}
	
	public String getLdrInstr(Register r, String value) {
		return "\tLDR " + r.toString() + ", =" + value + "\n";
	}
	
	public String getBlInstr(String label) {
		return "\tBL " + label + "\n";
	}
	
	public String getStrInstr(Register r1, Register r2) {
		return "\tSTR " + r1.toString() + ", [" + r2.toString() + "]\n";
	}
	
	public String getStrInstr(Register r, String sp) {
		return "\tSTR " + r.toString() + ", [" + sp + "]\n";
	}
	
	public String getStrInstr(Register r1, Register r2, String value) {
		return "\tSTR " + r1.toString() + ", [" + r2.toString() + ", #" + value + "]\n";
	}
	
	public String getStrInstr(Register r1, String sp, String value) {
		return "\tSTR " + r1.toString() + ", [" + sp + ", #" + value + "]\n";
	}
	
	public String getStrBInstr(Register r1, String sp, String value) {
		return !value.equals("") ? "\tSTRB " + r1.toString() + ", [" + sp + ", #" + value + "]\n"
				: "\tSTRB " + r1.toString() + ", [" + sp + "]\n";
	}
	
	public String getPushInstr(String value) {
		return "\tPUSH {" + value + "}\n";
	}

	public String getPushInstr(Set<Register> registers) {
		return "\tPUSH {" + setToCSV(registers) + "}\n";
	}
	
	public String getPopInstr(String value) {
		return "\tPOP {" + value + "}\n";
	}

	public String getPopInstr(Set<Register> registers) {
		return "\tPUSH {" + setToCSV(registers) + "}\n";
	}
	
	/**
	 * Gets a comma-seperated list of the .toString() values of the members
	 * of a set.
	 * @param set the set to get a comma separated list from
	 * @return a String containing the .toString() values, separated internally
	 * by commas (i.e. no leading comma, no trailing comma, no whitespace).
     */
	private String setToCSV(Set set) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean commas = false;
		for (Object item : set) {
			// Only insert commas after the first value.
			if (commas) stringBuilder.append(","); else commas = true;
			stringBuilder.append(item);
		}
		return stringBuilder.toString();
	}

	public String getSubInstr(String s1, String s2, String value) {
		return "\tSUB " + s1 + ", " + s2 + ", #" + value + "\n";
	}
	
	public String getAddInstr(String s1, String s2, String value) {
		return "\tADD " + s1 + ", " + s2 + ", #" + value + "\n";
	}
	
	public String getRsbsInstr(Register r1, Register r2, int value) {
		return "\tRSBS " + r1.toString() + ", " + r2.toString() + ", #" + value + "\n";
	}
	
	public String getBlvsInstr(String label) {
		return "\tBLVS " + label + "\n";
	}

	public String getEorInstr(Register r1, Register r2, int value) {
		return "\tEOR " + r1.toString() + ", " + r2.toString() + ", #" + value + "\n";
	}
		
}
