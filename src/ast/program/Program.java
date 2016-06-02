package ast.program;

import java.util.ArrayList;

import c_codeGeneration.InstructionAccumulator;

import ast.Statement;
import ast.decl.FunctionDecl;
import astVisitor.Visitor;
import codeGeneration.AssemblyInstruction;
import codeGeneration.MachineState;
import libExten.AstImport;
import libExten.Library;

/*
 * Class representing the top level program (a.k.a the main scope)
 * It is the root node of the AST
 */
public class Program implements ProgramContext {
	private ArrayList<FunctionDecl> funcDeclList;
	private Statement progStmt;
	private int declSize;
	private ArrayList<AstImport> imports;
	private ArrayList<FunctionDecl> libFunctions = null;

	public Program(ArrayList<AstImport> imports, ArrayList<FunctionDecl> funcDeclList, Statement progStmt) {
		this.imports = imports;
		this.funcDeclList = funcDeclList;
		this.progStmt = progStmt;
	}
	
	public ArrayList<AstImport> getImports() {
		return imports;
	}
	
	public void setLibFunctions(ArrayList<FunctionDecl> libFunctions) {
		this.libFunctions = libFunctions;
	}

	public Statement getProgStmt() {
		return progStmt;
	}

	public ArrayList<FunctionDecl> getFuncDeclList() {
		return funcDeclList;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		for (FunctionDecl f : funcDeclList) {
			f.walk(v);
		}
		progStmt.walk(v);
		v.leave();
	}

	/*
	 * Sets the messages needed before the main scope
	 * and the needed print and error functions after the main scope
	 */
	@Override
	public String codeGen(MachineState m) {
		String dataMain = ".data\n";
		String textMain = ".text\n";
		String globalMain  = ".global main\n";
		String mainLabel = "main:\n";
		String pushLR = "PUSH {lr}\n";
		String loadR0 = "LDR r0, =0\n";
		String popPC = "POP {pc}\n";
		String ltorg = ".ltorg\n";

		m.addStmt(dataMain);

		String exitFuncMsg = "";
		String overflowMsg = "";
		String runTimeMsg = "";
		String readIntMsg = "";
		String readCharMsg = "";
		String stringPrinting2 = "";
		String arrayErrNeg = "";
		String arrayErrInd = "";
		String nullPtrMsg = "";

		if(m.needsNullPtr()) {
			m.addStmt(nullPtrMsg);
		}

		if(m.needsArraysErrors()) {
			m.addStmt(arrayErrNeg);
			m.addStmt(arrayErrInd);
		}

		if(m.needsPrintStrings()) {
			m.addStmt(stringPrinting2);
		}

		if (m.needsExitFunctions()) {
			m.addStmt(exitFuncMsg);
		}
		if (m.needsOverflowErrors()) {
			m.addStmt(overflowMsg);
		}
		if (m.needsDivisionByZeroErrors()) {
			m.addStmt(runTimeMsg);
		}
		if (m.needsReadInts()) {
			m.addStmt(readIntMsg);
		}
		if (m.needsReadChars()) {
			m.addStmt(readCharMsg);
		}

		m.addStmt(textMain);
		m.addStmt(globalMain);
		if (libFunctions != null) {
		    for (FunctionDecl f : libFunctions) {
			    f.codeGen(m);
		    }
		}
		
		for(FunctionDecl f : funcDeclList){
			f.codeGen(m);
		}

		m.addStmt(mainLabel);
		m.addStmt(pushLR);

		long rsp  = m.getRspOffset();
		progStmt.codeGen(m);
		if (rsp - m.getRspOffset() != 0) {
			long total = rsp - m.getRspOffset();
			if (total > 1024) {
				m.addStmt("ADD sp, sp, #1024");
				m.addStmt("ADD sp, sp, #" + (total - 1024));
			} else {
				m.addStmt("ADD sp, sp, #" + total);
			}
		}
		m.setRspOffset(rsp);

		m.addStmt(loadR0);
		m.addStmt(popPC);
		m.addStmt(ltorg);

		if(m.needsArraysErrors()) {
			arrayErrNeg = m.addConstant("\"ArrayIndexOutOfBoundsError: negative index\\n\\0\"");
			arrayErrInd = m.addConstant("\"ArrayIndexOutOfBoundsError: index too large\\n\\0\"");

			m.addStmt("p_check_array_bounds:");
			m.addStmt("PUSH {lr}");
			m.addStmt("CMP r0, #0");
			m.addStmt("LDRLT r0, =" + arrayErrNeg);
			m.addStmt("BLLT p_throw_runtime_error");
			m.addStmt("LDR r1, [r1]");
			m.addStmt("CMP r0, r1");
			m.addStmt("LDRCS r0, =" + arrayErrInd);
			m.addStmt("BLCS p_throw_runtime_error");
			m.addStmt("POP {pc}");
		}

		if (m.needsPrintStrings()) {
			stringPrinting2 = m.addConstant("\"%.*s\\0\"");
			//string printing
			m.addStmt("p_print_string:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tLDR r1, [r0]\n");
			m.addStmt("\tADD r2, r0, #4\n");
			m.addStmt("\tLDR r0, =" + stringPrinting2 +"\n");
			m.addStmt("\tADD r0, r0, #4\n");
			m.addStmt("\tBL printf\n");
			m.addStmt("\tMOV r0, #0\n");
			m.addStmt("\tBL fflush\n");
			m.addStmt("\tPOP {pc}\n");
		}

		if(m.needsPrintFunctions()){

			String decimalPrinting = m.addConstant("\"%d\\0\"");
			String truePrinting = m.addConstant("\"true\\0\"");
			String falsePrinting = m.addConstant("\"false\\0\"");
			String linePrinting = m.addConstant("\"\\0\"");
			String refPrinting = m.addConstant("\"%p\\0\"");


			//integer printing
			m.addStmt("p_print_int:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tMOV r1, r0\n");
			m.addStmt("\tLDR r0, =" + decimalPrinting + "\n");
			m.addStmt("\tADD r0, r0, #4\n");
			m.addStmt("\tBL printf\n");
			m.addStmt("\tMOV r0, #0\n");
			m.addStmt("\tBL fflush\n");
			m.addStmt("\tPOP {pc}\n");

			//boolean printing
			m.addStmt("p_print_bool:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tCMP r0, #0\n");
			m.addStmt("\tLDRNE r0, =" + truePrinting + "\n");
			m.addStmt("\tLDREQ r0, =" + falsePrinting + "\n");
			m.addStmt("\tADD r0, r0, #4\n");
			m.addStmt("\tBL printf\n");
			m.addStmt("\tMOV r0, #0\n");
			m.addStmt("\tBL fflush\n");
			m.addStmt("\tPOP {pc}\n");

			//eol printing
			m.addStmt("p_print_ln:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tLDR r0, =" + linePrinting + "\n");
			m.addStmt("\tADD r0, r0, #4\n");
			m.addStmt("\tBL puts\n");
			m.addStmt("\tMOV r0, #0\n");
			m.addStmt("\tBL fflush\n");
			m.addStmt("\tPOP {pc}\n");

			//reference printing
			m.addStmt("p_print_reference:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tMOV r1, r0\n");
			m.addStmt("\tLDR r0, =" + refPrinting + "\n");
			m.addStmt("\tADD r0, r0, #4\n");
			m.addStmt("\tBL printf\n");
			m.addStmt("\tMOV r0, #0\n");
			m.addStmt("\tBL fflush\n");
			m.addStmt("\tPOP {pc}\n");
		}

		if (m.needsExitFunctions()) {
			exitFuncMsg = m.addConstant("\"NullReferenceError: dereference a null reference\\n\\0\"");
		}
		if (m.needsOverflowErrors()) {
			overflowMsg = m.addConstant("\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"");
		}
		if (m.needsDivisionByZeroErrors()) {
			runTimeMsg = m.addConstant("\"DivideByZeroError: divide or modulo by zero\\n\\0\"");
		}
		if (m.needsReadInts()) {
			readIntMsg =  m.addConstant("\"%d\\0\"");
		}
		if (m.needsReadChars()) {
			readCharMsg =  m.addConstant("\" %c\\0\"");
		}
		if(m.needsNullPtr()){
			nullPtrMsg = m.addConstant("\"NullReferenceError: dereference a null reference\\n\\0\"");
		}

		if(m.needsExitFunctions()){
			m.addStmt("p_free_pair:");
			m.addStmt("\tPUSH {lr}");
			m.addStmt("\tCMP r0, #0");
			m.addStmt("\tLDREQ r0, =" + exitFuncMsg);
			m.addStmt("\tBEQ p_throw_runtime_error");
			m.addStmt("\tPUSH {r0}");
			m.addStmt("\tLDR r0, [r0]");
			m.addStmt("\tBL free");
			m.addStmt("\tLDR r0, [sp]");
			m.addStmt("\tLDR r0, [r0, #4]");
			m.addStmt("\tBL free");
			m.addStmt("\tPOP {r0}");
			m.addStmt("\tBL free");
			m.addStmt("\tPOP {pc}");
		}

		if (m.needsOverflowErrors()) {
			m.addStmt("p_throw_overflow_error:");
			m.addStmt("\tLDR r0, =" + overflowMsg);
			m.addStmt("\tBL p_throw_runtime_error");
		}

		if(m.needsDivisionByZeroErrors()) {
			m.addStmt("p_check_divide_by_zero:");
			m.addStmt("\tPUSH {lr}");
			m.addStmt("\tCMP r1, #0");
			m.addStmt("\tLDREQ r0, =" + runTimeMsg);
			m.addStmt("\tBLEQ p_throw_runtime_error");
			m.addStmt("\tPOP {pc}");
		}

		if (m.needsRuntimeErrors()) {
			m.addStmt("p_throw_runtime_error:");
			m.addStmt("\tBL p_print_string");
			m.addStmt("\tMOV r0, #-1");
			m.addStmt("\tBL exit");
		}

		if (m.needsReadChars()) {
			m.addStmt("p_read_char:");
			m.addStmt("\tPUSH {lr}");
			m.addStmt("\tMOV r1, r0");
			m.addStmt("\tLDR r0, =" + readCharMsg);
			m.addStmt("\tADD r0, r0, #4");
			m.addStmt("\tBL scanf");
			m.addStmt("\tPOP {pc}");
		}

		if (m.needsReadInts()) {
			m.addStmt("p_read_int:");
			m.addStmt("\tPUSH {lr}");
			m.addStmt("\tMOV r1, r0");
			m.addStmt("\tLDR r0, =" + readIntMsg);
			m.addStmt("\tADD r0, r0, #4");
			m.addStmt("\tBL scanf");
			m.addStmt("\tPOP {pc}");
		}


		if(m.needsNullPtr()){
			m.addStmt("p_check_null_pointer:\n");
			m.addStmt("\tPUSH {lr}\n");
			m.addStmt("\tCMP r0, #0\n");
			m.addStmt("\tLDREQ r0, =" + nullPtrMsg + "\n");
			m.addStmt("\tBLEQ p_throw_runtime_error\n");
			m.addStmt("\tPOP {pc}\n");
		}

		return null;
	}

	public int getVarDeclSize() {
		declSize = progStmt.getVarDeclSize();
		return declSize;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt("#include \"stdio.h\"");
		a.addStmt("int main(){");
		for(FunctionDecl f : funcDeclList){
			f.CGen(a);
		}
		progStmt.CGen(a);
		a.addStmt("}");
	}

}
