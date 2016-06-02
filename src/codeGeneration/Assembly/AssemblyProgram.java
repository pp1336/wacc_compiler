package codeGeneration.Assembly;

import codeGeneration.Assembly.Data.*;
import codeGeneration.Assembly.Instruction.Instruction;

import java.util.*;

/**
 * Structural class for an entire assembly program.
 *
 * Please provide a comment when you add an instruction! This is useful for
 * debugging, and makes the generated assembly much more readable.
 */
public class AssemblyProgram {

    public static final String SOURCE_FILE_DIRECTIVE = ".file ";
    public static final String PROGRAM_DIRECTIVE = ".text ";
    public static final String DATA_DIRECTIVE = ".data ";

    private final String filename;
    private final List<AssemblyBlock> text = new LinkedList<>();
    private final Set<Data> data = new HashSet<>();

    public AssemblyProgram() {
        this.filename = null;
    }
    public AssemblyProgram(String filename) {
        this.filename = filename;
    }

    /**
     * Adds an instruction to the most recently added block.
     * @param instr the instruction to add.
     */
    public void addInstruction(Instruction instr) {
        AssemblyBlock lastBlock = text.get(text.size() - 1);
        lastBlock.addInstruction(instr);
    }

    /**
     * Adds an instruction to the most recently added block.
     * @param instr the instruction to add.
     * @param comment a comment explaining the line.
     */
    public void addInstruction(Instruction instr, String comment) {
        AssemblyBlock lastBlock = text.get(text.size() - 1);
        lastBlock.addInstruction(instr, comment);
    }

    /**
     * Adds a block to the program.
     * @param label the label for the new block, unique within the program.
     */
    public void addBlock(String label, String descriptor) {
        for (AssemblyBlock b : text) {
            if (b.label.equals(label)) {
                String msg = "there is already a block in this program with" +
                        "label" + label;
                throw new IllegalArgumentException(msg);
            }
        }
        text.add(new AssemblyBlock(label, descriptor));
    }

    /**
     * Adds a globally visible block to the program.
     * @param label the label for the new block, unique within the program.
     */
    public void addGlobalBlock(String label, String descriptor) {
        for (AssemblyBlock b : text) {
            if (b.label.equals(label)) {
                String msg = "there is already a block in this program with" +
                        "label" + label;
                throw new IllegalArgumentException(msg);
            }
        }
        text.add(new AssemblyBlock(label, descriptor).globallyVisible());
    }

    /**
     * Gets the block of the program with the corresponding label.
     * @param label the label of the block, unique within the program.
     * @return the AssemblyBlock with the matching label if one exists,
     * otherwise null.
     */
    public AssemblyBlock getBlock(String label) {
        for (AssemblyBlock b : text) {
            if (b.label.equals(label)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adds d to the program data, but checks its label for conflicts first.
     * @param d the data to add to the program.
     * @throws IllegalArgumentException if there is already data with that
     * label.
     */
    private void addData(Data d) {
        for (Data datum : data) {
            if (datum.getLabel().equals(d.getLabel())) {
                String msg = "data already exists with that label";
                throw new IllegalArgumentException(msg);
            }
        }
        data.add(d);
    }

    /**
     * Generates a new data label, adds the string as program data, then returns
     * the newly created label.
     * @param s the data to add to the program.
     * @return the label for the inserted data.
     */
    public String addData(String s) {
        String label = UUID.randomUUID().toString();
        addData(new StringData(label, s));
        return label;
    }

    /**
     * Generates a new data label, adds the boolean as program data, then
     * returns the newly created label.
     * @param b the data to add to the program.
     * @return the label for the inserted data.
     */
    public String addData(boolean b) {
        String label = UUID.randomUUID().toString();
        addData(new BytesData(label, b ? 1 : 0));
        return label;
    }

    /**
     * Generates a new data label, adds the int as program data, then
     * returns the newly created label.
     * @param i the data to add to the program.
     * @return the label for the inserted data.
     */
    public String addData(int i) {
        String label = UUID.randomUUID().toString();
        addData(new WordData(label, i));
        return label;
    }

    /**
     * Generates a new data label, adds the string as program data, then
     * returns the newly created label.
     * @param label the label for the new data.
     * @param s the data to add to the program.
     * @throws IllegalArgumentException if there is already data with that
     * label.
     */
    public void addData(String label, String s) {
        addData(new StringData(label, s));
    }

    /**
     * Generates a new data label, adds the boolean as program data, then
     * returns the newly created label.
     * @param label the label for the new data.
     * @param b the data to add to the program.
     * @throws IllegalArgumentException if there is already data with that
     * label.
     */
    public void addData(String label, boolean b) {
        addData(new BytesData(label, b ? 1 : 0));
    }

    /**
     * Generates a new data label, adds the int as program data, then
     * returns the newly created label.
     * @param label the label for the new data.
     * @param i the data to add to the program.
     * @throws IllegalArgumentException if there is already data with that
     * label.
     */
    public void addData(String label, int i) {
        addData(new WordData(label, i));
    }

    /**
     * Generates the string representation of the program code.
     * @return the string representation of the program code.
     */
    public String generate() {
        StringBuilder sb = new StringBuilder();

        if (filename != null) {
            sb.append(SOURCE_FILE_DIRECTIVE).append(filename);
            sb.append(System.lineSeparator());
        }

        sb.append(PROGRAM_DIRECTIVE).append(System.lineSeparator());
        for (AssemblyBlock b : text) {
            sb.append(b.generate()).append(System.lineSeparator());
        }

        sb.append(DATA_DIRECTIVE).append(System.lineSeparator());
        for (Data d : data) {
            sb.append(d.getRepresentation()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
