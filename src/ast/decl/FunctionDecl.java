package ast.decl;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import c_codeGeneration.InstructionAccumulator;

import ast.Statement;
import ast.Type;
import ast.expr.IdentExpr;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import astVisitor.Visitor;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.KnownRegister;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.RegisterArgument;
import codeGeneration.Assembly.Instruction.Arguments.RegisterSet;
import codeGeneration.Assembly.Instruction.Memory.Push;
import codeGeneration.MachineState;
import codeGeneration.Register;

/*
 * Class representing a function declaration
 */
public class FunctionDecl implements Decl {

	public static final Set<RegisterArgument> CALLEE_SAVE_REGISTERS
			= Register.getRegisterRange(Register.r4, Register.r12).stream()
			.map(KnownRegister::new).collect(Collectors.toSet());

	private Type returnType;
	private IdentExpr id;
	private ArrayList<VarDecl> paramList;
	private Statement funcBodyStmt;
	private boolean isActuallyCalled = false;

    private int pushedValuesSize = 0;

	public FunctionDecl(Type returnType, IdentExpr id,
			ArrayList<VarDecl> paramList, Statement funcBodyStmt) {
		this.returnType = returnType;
		this.id = id;
		this.paramList = paramList;
		this.funcBodyStmt = funcBodyStmt;
	}
	
	public void setCallStatus(boolean b) {
		isActuallyCalled = b;
	}

	@Override
	public String getDeclName() {
		return id.getIdentName();
	}

	@Override
	public Type getType() {
		return returnType;
	}

	public ArrayList<VarDecl> getParamList() {
		return paramList;
	}

	public Statement getFunctionBodyStmt() {
		return funcBodyStmt;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		returnType.walk(v);
		id.walk(v);
		funcBodyStmt.walk(v);
		v.leave();
	}

	@Override
	public IdentExpr getIdentExpr() {
		return id;
	}

	@Override
	public String codeGen(MachineState m) {
		if (!isActuallyCalled) {
			return null;
		}
		// using arm procedure call standard:
		// - first four arguments are in r0-r3
		// - Excess arguments are on the stack
		// - Return value in r0
        m.saveRsp(m.getRspOffset());
        m.addStmt("@@ Begin function " + getDeclName());
        m.addStmt(getDeclName() + ":");
		// create new function block, using the function name as the label.
		m.addBlock(getDeclName(), "some comment");

        long offset_at_start = m.getRspOffset();

        m.addStmt("PUSH {lr}");
        m.setRspOffset(m.getRspOffset() - 4);
        // push callee save registers
        m.addInstruction(new Push(new RegisterSet(CALLEE_SAVE_REGISTERS)));
		m.addStmt("PUSH {r4-r12}");
        // stack pointer exists and has a whale of a time.
        m.setRspOffset(m.getRspOffset() - 4*CALLEE_SAVE_REGISTERS.size());

        // Extract arguments
        // =================
        for (int i = 0; i < paramList.size() && i < 4; i++) {
            // instantiate paramList.get(i) with value in r0-r3;
            Register r = Register.values()[i];
            VarDecl param = paramList.get(i);
            InstantiateVarDecl(m, param, r);
        }

        // passing all arguments as words, regardless of type.

        int paramsMemory = 0;
        for (int i = 4; i < paramList.size(); i++) {
            paramsMemory += 4; // paramList.get(i).getType().getSize();
        }
        int paramsMemorySoFar = 0;
        for (int i = 4; i < paramList.size(); i++) {
            // fetch parameters from stack tasty tasty tasty
			VarDecl param = paramList.get(i);
            paramsMemorySoFar += 4; // param.getType().getSize();
            // args = a, b, c, d, e, f, g
            // at start of function, r0 = a, r1 = b, r2 = c, r3 = d
            // stack is [..., 23, 65535, e, f, g]
            // when function is entered, offset_at_start points to g
            // to get parameter f, use offset_at_start + paramMemoryWidth to
            // get a pointer to e, then subtract 6 - 4 = 2 to get f.

			// but wait! due to a terrible design decision, all arguments are
			// passed as words! hence, if our param is a boolean, we should
			// modify the pointer to point to the bottom of the word.
            long rspValue = offset_at_start + paramsMemory - paramsMemorySoFar
					- (4 - param.getType().getSize()); // point to bottom byte
            param.setRspValue(rspValue);
        }

		// Generate code for body
        // ======================
        m.addStmt("@@ Begin function body " + getDeclName());
        funcBodyStmt.codeGen(m); // should just work, right????
        m.addStmt("@@ End function body " + getDeclName() +
                  System.lineSeparator());


        // fix stack pointer
       // System.out.println("after func rsp" + m.getRspOffset());
        m.setRspOffset(offset_at_start);
        //m.setCurrrentFunctionDeclarationsCount(pushedValuesSize);
		//pop instruction will have to be generated with the return statement.
		return null;
	}

    private void InstantiateVarDecl(MachineState m, VarDecl decl, Register r) {
        // THIS CODE WAS COPY-PASTED FROM VARDECLSTATEMENT 07-12-15 19:20
        // IF IT DOESN'T WORK I BLAME PENG PENG
        int offset = -decl.getType().getSize();
        if (decl.getType().isBaseType()) {
            BaseType bt = (BaseType) decl.getType();
            if (bt.getBaseTypeEnum() == BaseTypeEnum.BOOL
                    || bt.getBaseTypeEnum() == BaseTypeEnum.CHAR) {
                /*
                m.addInstruction(new Subtract(
                        new KnownRegister(Register.sp),
                        new KnownRegister(Register.sp),
                        new Immediate(1)
                ));
                m.addInstruction(new Store(
                        codeGeneration.Assembly.Instruction.Memory.Type.UNSIGNED_BYTE,
                        new KnownRegister(r),
                        new MemoryAddress(new KnownRegister(Register.sp))
                ));
                */
				m.addStmt("SUB sp, sp, #1", -1);
				m.addStmt("STRB " + r + ", [sp]");
                decl.setRspValue(m.getRspOffset());
                return;
            }
		}
		// adjust the relative offset from current rsp to initial rsp
        /*
		m.addInstruction(new Push(
				new RegisterSet(new KnownRegister(r))
		));
		*/
		m.addStmt("PUSH {" + r + "}");
		m.setRspOffset(m.getRspOffset() + offset);
		decl.setRspValue(m.getRspOffset());
    }

	@Override
	public void CGen(InstructionAccumulator a) {

		a.nowFunction();

		a.instructionBuilder(genStringRepOfType(returnType));

		a.addStmt(id.getRepresentation());
		a.addStmt("(");
		for(int i=0; i<paramList.size(); i++){
			a.addStmt(genStringRepOfType(paramList.get(i).getType()));
			a.addStmt(paramList.get(i).getDeclName());
			if(i!=paramList.size()-1){
				a.addStmt(",");
			}
		}
		a.addStmt("){");
		a.pushBuilderAndReset();
		funcBodyStmt.CGen(a);
		a.addStmt("}");

		a.endFunction();
	}

	public String genStringRepOfType(Type t){
		if(t.isArrayType()){
			if(t.getInnerType().sameType(new BaseType(BaseTypeEnum.INT))){
				return("int[] ");
			}else if(t.getInnerType().sameType(new BaseType(BaseTypeEnum.BOOL))){
				return("bool[] ");
			}else{//CHAR
				return("char[] ");
			}
		}else if(t.isBaseType()){
			if(t.sameType(new BaseType(BaseTypeEnum.INT))){
				return("int ");
			}else if(t.sameType(new BaseType(BaseTypeEnum.BOOL))){
				return("bool ");
			}else{//CHAR
				return("char ");
			}
		}else{//pair type
			//not yet implemented TODO
		}
		return "";
	}

}
