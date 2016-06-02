import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;

import symbolTable.SymbolTable;
import antlr.BasicLexer;
import antlr.BasicParser;
import ast.AstNode;
import astBuilder.ASTBuildingVisitor;
import astVisitor.SemanticChecker;
import c_codeGeneration.CGeneration;
import codeGeneration.CodeGenerator;
import errorCode.ErrorCode;

/*
 * Compiler Class which compiles the program
 */

/*
 * Takes care of printing notifications of syntax errors 
 */
class ErrorListener extends BaseErrorListener {
	public static ErrorListener INSTANCE = new ErrorListener();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		/*
		 * Note to future selves: Even though the documentation claims that
		 * getSourceName doesn't return null, it totally does if you don't set
		 * the .name field of your ANTLRInputStream! Fun times.
		 */
		String sourceName = recognizer.getInputStream().getSourceName();
		if (sourceName == null) {
			sourceName = "<unknown source>";
		}

		System.out.println(sourceName + ":" + line + ":" + charPositionInLine
				+ ": " + msg);
		throw new RuntimeException("syntax error");
	}
}

class Compiler {

	public static void main(String[] args) throws IOException {

		ParseTree t = null;
		try {
			t = getProgramFromArgs(args[0]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(ErrorCode.SYNTAX_ERROR.getNumVal());
		}

		ASTBuildingVisitor astBuilder = new ASTBuildingVisitor();
		AstNode root = astBuilder.visit(t);
		SemanticChecker sc = new SemanticChecker();
		root.walk(sc);

		CodeGenerator cg = new CodeGenerator(args[0]);
		root.walk(cg);

		if (args.length > 1 && args[1].equals("-c")) {
			CGeneration ccg = new CGeneration(args[0]);
			root.walk(ccg);
		}
		
		// to stop garbage collector from deleting st before codegen
		SymbolTable st = sc.getRoot();

		System.exit(ErrorCode.SUCCESS.getNumVal());
	}

	/*
	 * Parsing the program (a.k.a . doing syntax check)
	 */
	public static ParseTree getProgramFromArgs(String path) throws IOException {
		InputStream in = new FileInputStream(path);

		ANTLRInputStream input = new ANTLRInputStream(in);
		input.name = path;

		BasicLexer lexer = new BasicLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ErrorListener.INSTANCE);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BasicParser parser = new BasicParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(ErrorListener.INSTANCE);

		if (parser.getNumberOfSyntaxErrors() > 0) {
			System.exit(ErrorCode.SYNTAX_ERROR.getNumVal());
		}

		return parser.program();
	}
}
