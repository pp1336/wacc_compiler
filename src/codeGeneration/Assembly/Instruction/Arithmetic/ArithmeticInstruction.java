package codeGeneration.Assembly.Instruction.Arithmetic;

import codeGeneration.Assembly.Instruction.Arguments.Operand2;
import codeGeneration.Assembly.Instruction.Arguments.RegisterArguments.NonShiftedRegister;
import codeGeneration.Assembly.Instruction.FlagSettingInstruction;

/**
 * Template class for arithmetic instructions.
 */
abstract class ArithmeticInstruction extends FlagSettingInstruction {

    public ArithmeticInstruction(NonShiftedRegister a, Operand2 b) {
        super(a, b);
    }

    public ArithmeticInstruction(NonShiftedRegister dest, NonShiftedRegister a, Operand2 b) {
        super(dest, a, b);
    }
}
