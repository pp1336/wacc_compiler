package ast.expr.rhsexpr;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import c_codeGeneration.InstructionAccumulator;

import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import codeGeneration.Assembly.Instruction.Arguments.Immediate;
import codeGeneration.Assembly.Instruction.Arguments.Label;
import codeGeneration.Assembly.Instruction.Arguments.MemoryAddress;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.KnownRegister;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.RegisterArgument;
import codeGeneration.Assembly.Instruction.Arguments.RegisterSet;
import codeGeneration.Assembly.Instruction.Arithmetic.Subtract;
import codeGeneration.Assembly.Instruction.Branch.BranchImmediateWithLink;
import codeGeneration.Assembly.Instruction.Instruction;
import codeGeneration.Assembly.Instruction.Memory.Pop;
import codeGeneration.Assembly.Instruction.Memory.Push;
import codeGeneration.Assembly.Instruction.Memory.Store;
import codeGeneration.Assembly.Instruction.Move;
import codeGeneration.Register;
import symbolTable.SymbolTable;
import ast.Expr;
import ast.Type;
import ast.decl.FunctionDecl;
import ast.expr.IdentExpr;
import ast.expr.RhsExpr;
import astVisitor.Visitor;
import codeGeneration.MachineState;

/*
 * Class representing the call expression
 */
public class CallExpr implements RhsExpr {

    // Caller should save r1 - r3 (r0 is always lost to return statement)
    public static final Set<RegisterArgument> CALLER_SAVE_REGISTERS
            = Register.getRegisterRange(Register.r1, Register.r3).stream()
            .map(KnownRegister::new).collect(Collectors.toSet());
    
	private IdentExpr id;
	private List<Expr> params;
	private FunctionDecl funcDecl;

	public CallExpr(IdentExpr id, List<Expr> params) {
		this.id = id;
		this.params = params;
	}
	
	public void setFuncDecl(FunctionDecl funcDecl) {
		this.funcDecl = funcDecl;
	}
	
	public FunctionDecl getFuncDecl() {
		return funcDecl;
	}

	public IdentExpr getFunctionRef() {
		return id;
	}

	public List<Expr> getParams() {
		return params;
	}

	@Override
	public void walk(Visitor v) {
		v.visit(this);
		id.walk(v);
		for (Expr e : params) {
			e.walk(v);
		}
		v.leave();
	}

	@Override
	public Type getType(SymbolTable st) {
		return st.lookupFunction(id).getType();
	}

	@Override
	public String codeGen(MachineState m) {
		//We should follow the arm standard of using regs r0-r4 for arguments,
		//then putting any excess on the stack.

        long offset_at_start = m.getRspOffset();

      //  m.addStmt("tuk "  + offset_at_start);

			//comment
		m.addStmt("@@ Begin call to function " + funcDecl.getDeclName());

        // save registers
        m.addInstruction(new Push(
                new RegisterSet(CALLER_SAVE_REGISTERS)
        ));
        m.addStmt("PUSH {r1-r3}");
        m.setRspOffset(m.getRspOffset()-4*CALLER_SAVE_REGISTERS.size());

      //  m.addStmt("blaa "  + m.getRspOffset());

        //set up arguments
        for (int i = 0; i < params.size() && i < 4; i++) {
			// possible bug; what if e.codegen(m) dumps the value in r0-r3
			Register destination = Register.values()[i];
            Expr e = params.get(i);
			String param_name = funcDecl.getParamList().get(i).getDeclName();
			m.addStmt("@@ Move param " + param_name + " into " + destination);
            e.codeGen(m);
            /*m.addInstruction(new Move(
                    new KnownRegister(destination),
                    new KnownRegister(m.getLastUsedRegister())
            )); // move result of expr calculation into ri*/
            m.addStmt("MOV " + destination + ", " + m.getLastUsedRegister());
        }
        for (int i = 4; i < params.size(); i++) {
			String param_name = funcDecl.getParamList().get(i).getDeclName();
			m.addStmt("@@ Move param " + param_name + " onto the stack");
            Expr e = params.get(i);
            e.codeGen(m);

            int offset = -funcDecl.getParamList().get(i).getType().getSize();

         //   m.addStmt("meeeh "  + offset);

            if (offset == -1) {
                m.addStmt("SUB sp, sp, #1", -1);
                m.addStmt("STRB " + m.getLastUsedRegister() + "[sp]");
            }
            // adjust the relative offset from current rsp to initial rsp
            /*m.addInstruction(new Push(
                    new RegisterSet(new KnownRegister(m.getLastUsedRegister()))
            ));*/
            m.addStmt("PUSH {" + m.getLastUsedRegister() + "}");
        //    m.addStmt("huuush " + (m.getRspOffset() + offset));
            m.setRspOffset(m.getRspOffset() + offset);
        }

        //make the call
        m.addStmt("@@ branch to " + funcDecl.getDeclName());
        m.addInstruction(new BranchImmediateWithLink(
                new Label(id.getIdentName())
        ));
        m.addStmt("BL " + id.getIdentName());

     //   m.addStmt("huuuuu "  + m.getRspOffset());

        //forget arguments that were on the stack
        m.addStmt("@@ forget arguments that were on the stack");
        m.setRspOffset(m.getRspOffset()+4*CALLER_SAVE_REGISTERS.size());
        long toAdd = -(m.getRspOffset() - offset_at_start);
        if (toAdd != 0) {
            m.addStmt("ADD sp, sp, #" + toAdd);
        }

        //pop caller save registers
        m.addInstruction(new Pop(
                new RegisterSet(CALLER_SAVE_REGISTERS)
        ));
        m.addStmt("POP {r1-r3}");

    //    m.addStmt("blaaa "  + offset_at_start);
        m.setRspOffset(offset_at_start);
        Register result = m.getUnused().pop();
        //tell the machine state that the return value is in r0
      //  Register result = m.getUnused().pop();
        m.addStmt("MOV " + result + ", " + Register.r0);
       // m.getUnused().push(Register.r0, 0);

		m.addStmt("@@ end call to function " + funcDecl.getDeclName());

        m.getUnused().push(result);
        return "NotYetImplemented";
	}
    
    private void pushExprToStack(MachineState m, Expr e) {
        e.codeGen(m);
        int offset = -4;
        // adjust the relative offset from current rsp to initial rsp
        m.addInstruction(new Push(
                new RegisterSet(new KnownRegister(m.getLastUsedRegister()))
        ));
        m.addStmt("PUSH {" + m.getLastUsedRegister() + "}");
        m.setRspOffset(m.getRspOffset() + offset);
    }

	@Override
	public int getWeight() {
		return 10000;
	}

	@Override
	public int getExprSize() {
		int size = id.getExprSize();
		for (Expr elem : params) {
			size += elem.getExprSize();
		}
		return size; 
	}

	@Override
	public void CGen(InstructionAccumulator a) {
		a.addStmt(String.format("%s(", id.getRepresentation()));
		for(Expr e : params){
			e.CGen(a);
		}
		a.addStmt(");");
	}

}
