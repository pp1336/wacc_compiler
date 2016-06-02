package ast.stmt;

import c_codeGeneration.InstructionAccumulator;
import ast.Expr;
import ast.Statement;
import ast.decl.FunctionDecl;
import astVisitor.Visitor;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.KnownRegister;
import codeGeneration.Assembly.Instruction.Arguments.RegisterSet;
import codeGeneration.Assembly.Instruction.Branch.BranchIndirect;
import codeGeneration.Assembly.Instruction.Memory.Pop;
import codeGeneration.Assembly.Instruction.Memory.Push;
import codeGeneration.Assembly.Instruction.Move;
import codeGeneration.MachineState;
import codeGeneration.Register;

public class ReturnStmt implements Statement {

	private Expr returnExpr;

	public ReturnStmt(Expr returnExpr) {
		this.returnExpr = returnExpr;
	}

	public Expr getReturnExpr() {
		return returnExpr;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		returnExpr.walk(v);
		v.leave();
	}

	@Override
	public String codeGen(MachineState m) {
		returnExpr.codeGen(m);

		// THIS IS BETTER PLEASE USE THIS
	/*	m.addInstruction(new Move(
				new KnownRegister(Register.r0),
				new KnownRegister(m.getLastUsedRegister())
		)); //move return value into r0
		m.addInstruction(new Pop(
				new RegisterSet(FunctionDecl.CALLEE_SAVE_REGISTERS)
		)); //pop callee registers
		m.addInstruction(new BranchIndirect(
				new KnownRegister(Register.lr)
		)); //return to address in link register
*/
		// please make this code not necessary kthnxbai
        long savedRsp = m.getSavedRsp();
		m.addStmt("MOV " + Register.r0 + ", " + m.getLastUsedRegister());

        m.setRspOffset(m.getRspOffset() +
              4*FunctionDecl.CALLEE_SAVE_REGISTERS.size() + 4);

        long toAdd = -(m.getRspOffset() - savedRsp);
    //    System.out.println("rospoffsetreturn "  + m.getRspOffset());
    //    System.out.println("SAVEDRSPreturn "  + savedRsp);
        //System.out.println(m.getRspOffset() + "\n" + m.functionStackPointer);
        if (toAdd != 0) {
            m.addStmt("ADD sp, sp, #" + toAdd);
        }
		m.addStmt("POP {r4-r12}");
        // fix stack frame
		m.addStmt("POP {pc}");
		//m.addStmt("BX lr");
		return null;
	}
	
	@Override
	public int getVarDeclSize() {
		return 0;
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.instructionBuilder("return ");
		returnExpr.CGen(a);
		a.addStmt(";");
		a.pushBuilderAndReset();
	}

}
