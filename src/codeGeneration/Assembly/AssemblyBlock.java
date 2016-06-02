package codeGeneration.Assembly;

import codeGeneration.Assembly.Instruction.Instruction;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A block of assembly code. Includes
 * - assembler directives in header
 * - label
 * - body of instructions
 *
 * Please provide a comment when you add an instruction! This is useful for
 * debugging, and makes the generated assembly much more readable.
 */
public class AssemblyBlock {

    // various constants dictating code style
    public static final String HORIZONTAL_LINE = repeat(79, '-');
    public static final char COMMENT_CHARACTER = '@';
    public static final int COMMENT_DEPTH = 40;
    public static final String COMMENT_INDENT = repeat(COMMENT_DEPTH, ' ');
    public static final String INDENT = "    ";

    // If included, the label after it is marked as globally visible
    public static final String GLOBALLY_VISIBLE_DIRECTIVE = ".global ";

    // a character that no-one types that doesn't break lines.
    private static final char FAKE_NEWLINE = '\01';

    public final String label;
    // each entry is an instruction and a comment.
    public final List<Pair<Instruction, String>> body = new LinkedList<>();

    private boolean globallyVisible = false;
    private final String descriptor;

    /**
     * replaces all line breaks (which might be multiple characters) with
     * `FAKE_NEWLINE`: a character that no-one types, but which doesn't break
     * lines, which we can easily check for when printing.
     * @param s the string to sanitise
     * @return `s` with all line breaks replaced with `FAKE_NEWLINE`
     */
    private static String replaceNewLines(String s) {
        return s.replace(System.lineSeparator(), String.valueOf(FAKE_NEWLINE))
                .replace("\n", String.valueOf(FAKE_NEWLINE));
    }

    /**
     * Creates a string of the specified length containing the character c
     * repeated over and over.
     * @param length the length of the string to produce
     * @param c the character to repeat
     * @return a String s such that s.length() = length and every character in
     * s is c.
     */
    private static String repeat(int length, char c) {
        return IntStream.rangeClosed(0, length)
                .mapToObj(x->String.valueOf(c))
                .collect(Collectors.joining());
    }

    /**
     * Creates a new assembly block.
     * @param label The label for the block, used to branch to the block.
     * @param descriptor A description of the purpose of the code in the block.
     *                   Useful for debugging.
     */
    AssemblyBlock(String label, String descriptor) {
        this.label = label;
        // when the descriptor is printed, we need to make sure there is
        // a comment character at each new line, so we replace all
        // line breaks (which might be multiple characters) with some character
        // that no-one types, but which doesn't break lines, which
        // we can easily check for when printing.
        this.descriptor = replaceNewLines(descriptor);
    }

    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Indicates that this block should be globally visible, i.e. it can be
     * linked into other assembly programs. The 'main' block should be marked
     * as globally visible. Call this method as part of constructing the
     * block.
     * @return this
     */
    public AssemblyBlock globallyVisible() {
        this.globallyVisible = true;
        return this;
    }

    /**
     * Adds an instruction to the body of the block.
     * @param instr the instruction to add.
     */
    public void addInstruction(Instruction instr) {
        body.add(new Pair<>(instr, null));
    }

    /**
     * Adds an instruction to the body of the block.
     * @param instr the instruction to add.
     * @param comment a comment explaining what the instruction does.
     */
    public void addInstruction(Instruction instr, String comment) {
        body.add(new Pair<>(instr, replaceNewLines(comment)));
    }

    /**
     * Generates the string representation of this block of code.
     * @return the string representation of this block of code.
     */
    public String generate() {
        StringBuilder sb = new StringBuilder();

        sb.append(COMMENT_CHARACTER).append(HORIZONTAL_LINE);
        sb.append(System.lineSeparator());
        sb.append(COMMENT_CHARACTER).append(" ");

        addComment(sb, 2, COMMENT_CHARACTER + " ", descriptor);

        if (globallyVisible) {
            sb.append(GLOBALLY_VISIBLE_DIRECTIVE).append(label);
            sb.append(System.lineSeparator());
        }

        sb.append(label).append(":").append(System.lineSeparator());

        for (Pair<Instruction, String> line : body) {
            // lines that are not labels should be one level of indentation deep
            sb.append(INDENT);

            Instruction instr = line.getKey();
            String instrRepr = instr.generate();
            sb.append(instrRepr);

            String comment = line.getValue();
            if (comment != null) {
                // comments should start at COMMENT_INDENT.length()
                for (int lineLength = INDENT.length() + instrRepr.length();
                     lineLength < COMMENT_INDENT.length(); lineLength++) {
                    sb.append(" ");
                }
                sb.append(COMMENT_CHARACTER).append(" ");
                addComment(sb, COMMENT_INDENT.length() + 2,
                           COMMENT_INDENT + COMMENT_CHARACTER + " ", comment);
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    /**
     * Adds a sanitised comment to sb, replacing the FAKE_NEWLINE characters
     * with actual line breaks and comment prefixes.
     * @param sb the StringBuilder to add the comment to
     * @param initialIndent the indent the comment starts at
     * @param linePrefix a prefix for comment lines, less that 79 characters
     * @param text the text of the comment
     */
    private void addComment(StringBuilder sb, int initialIndent,
                              String linePrefix, String text) {
        //TODO: Proper word wrapping for comments.
        int lineLength = initialIndent;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == FAKE_NEWLINE) {
                sb.append(System.lineSeparator()).append(linePrefix);
                lineLength = linePrefix.length();
                i++;
            }
            if (lineLength >= 80) {
                sb.append(System.lineSeparator()).append(linePrefix);
                lineLength = linePrefix.length();
            }
            sb.append(text.charAt(i));
            lineLength++;
        }
    }

}
