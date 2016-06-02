package codeGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
 * A mechanism employing the dead code elimination technique
 * to obliterate redundant code.
 */
public class DeadCodeElim {

    ArrayList<String> instructions = new ArrayList<String>();
    Map<Register, Integer> m = new HashMap<Register, Integer>();

    //input code
    public DeadCodeElim(ArrayList<String> instructions){
        this.instructions = instructions;
    }

    //main optimisation function
    public void optimise(){
        passOne();
    }

    //first pass to remove any redundant moves or loads into a register
    public void passOne(){
        int insNumber = 0;
        for(String ins : instructions) {
            if(isLabel(ins)||ins.charAt(0)=='B'){
                m.clear();
            }else {
                String com = com(ins);
                if(com.equals("MOV")){
                    if(m.get(writesTo(ins))!=null){
                        //overwritten case, previous instruction is clobbered
                        instructions.remove(m.remove(writesTo(ins)));
                    }

                    //adds the value put to into the clobbering list
                    m.put(writesTo(ins), insNumber);

                    //register value used so certainly do not want to clobber it ever
                    m.remove(readFrom(ins));
                }else if(com.equals("PUSH")){
                    m.remove(writesTo(ins));
                }else if(com.equals("POP")){
                    if(m.get(writesTo(ins))!=null){
                        //overwritten case, previous instruction is clobbered
                        instructions.remove(m.remove(writesTo(ins)));
                    }

                    m.put(writesTo(ins), insNumber);
                }else if(com.equals("LDR")){
                    if(m.get(writesTo(ins))!=null){
                        //overwritten case, previous instruction is clobbered
                        instructions.remove(m.remove(writesTo(ins)));
                    }

                    m.put(writesTo(ins), insNumber);

                    try{
                        m.remove(readFrom(ins));
                    }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
                        //this is ok
                    }catch (Exception e){
                        //this is not
                        System.err.println("PROBLEMS IN DEAD CODE ELIM");
                    }
                }else if(isTripleStatement(ins)!=null){
                    if(m.get(writesTo(ins))!=null){
                        //overwritten case, previous instruction is clobbered
                        instructions.remove(m.remove(writesTo(ins)));
                    }

                    //adds the value put to into the clobbering list
                    m.put(writesTo(ins), insNumber);

                    //register value used so certainly do not want to clobber it ever
                    m.remove(readFrom(ins));
                    m.remove(isTripleStatement(ins));
                }else if(com.equals("CMP")){
                    m.remove(readFrom(ins));
                    m.remove(writesTo(ins));
                }else{
                    try {
                        m.remove(writesTo(ins));
                        m.remove(readFrom(ins));
                    }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
                        //this is ok
                    }catch (Exception e){
                        //this is not
                        System.err.println("PROBLEMS IN DEAD CODE ELIM");
                    }

                }
            }
//          grounding logic for implementation
//    		if(ins is a MOV into || POP || LDR into){
//       			if(m.get(this ins"\'"s register)!=null){
//    				instructions.remove(m.remove(this ins"\'"s register));
//    			}
//    			m.put(This instruction"\'"s dst register, instructionNumber);
//    		}else{ //ins reads from a register){
//    			PUSH, MOV from, LDR from,
//    			m.remove(the instructions register);
//    		}
            insNumber++;
        }
    }

    private boolean isLabel(String ins){
        try{
            ins.split(":");
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    private String com(String ins){
        return (ins.split(" "))[0];
    }

    //GETS THE SECOND REGISTER IN THE INSTRUCTION
    private Register readFrom(String ins){
        return Register.getRegister(((ins.split("(r|R){1}(4|5|6|7|8|9){1}"))[1].split("(r|R){1}(4|5|6|7|8|9){1}"))[1].charAt(1) - '0');
    }

    //GETS THE FIRST REGISTER IN THE INSTRUCTION
    private Register writesTo(String ins){
        return Register.getRegister(((ins.split("(r|R){1}(4|5|6|7|8|9){1}"))[1].charAt(1) - '0'));
    }

    private Register isTripleStatement(String ins){
        Register t;
        try{
            t = Register.getRegister((((ins.split("(r|R){1}(4|5|6|7|8|9){1}"))[1].split("(r|R){1}(4|5|6|7|8|9){1}"))[1].split("(r|R){1}(4|5|6|7|8|9){1}"))[1].charAt(1) - '0');
        }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
            return null;
        }catch (Exception e){
            System.err.println("PROBLEMS IN DEAD CODE ELIM");
            return null;
        }
        return t;
    }

    //output code
    public ArrayList<String> getOptimised(){
        return instructions;
    }
}