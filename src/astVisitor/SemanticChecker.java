package astVisitor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr.BasicLexer;
import antlr.BasicParser;
import symbolTable.SymbolTable;
import ast.AstNode;
import ast.Expr;
import ast.Statement;
import ast.Type;
import ast.decl.Decl;
import ast.decl.FunctionDecl;
import ast.decl.VarDecl;
import ast.expr.DigitExpr;
import ast.expr.IdentExpr;
import ast.expr.IntSignExpr;
import ast.expr.rhsexpr.ArrayLitrExpr;
import ast.expr.rhsexpr.BinaryOperatorExpr;
import ast.expr.rhsexpr.BoolLitrExpr;
import ast.expr.rhsexpr.BracketedExpr;
import ast.expr.rhsexpr.CallExpr;
import ast.expr.rhsexpr.CharLitrExpr;
import ast.expr.rhsexpr.IntLitrExpr;
import ast.expr.rhsexpr.NewPairExpr;
import ast.expr.rhsexpr.PairLitrExpr;
import ast.expr.rhsexpr.StringLitrExpr;
import ast.expr.rhsexpr.UnaryOperator;
import ast.expr.rhsexpr.UnaryOperatorExpr;
import ast.expr.rhsexpr.lhsexpr.ArrayVarIndexRefExpr;
import ast.expr.rhsexpr.lhsexpr.PairVarRefExpr;
import ast.expr.rhsexpr.lhsexpr.VarRefExpr;
import ast.program.Program;
import ast.stmt.AssignmentStmt;
import ast.stmt.BeginStmt;
import ast.stmt.CompoundStmt;
import ast.stmt.ElseBranchStmt;
import ast.stmt.ExitStmt;
import ast.stmt.FreeStmt;
import ast.stmt.IfStmt;
import ast.stmt.PrintStmt;
import ast.stmt.PrintlnStmt;
import ast.stmt.ReadStmt;
import ast.stmt.ReturnStmt;
import ast.stmt.SkipStmt;
import ast.stmt.ThenBranchStmt;
import ast.stmt.VarDeclStmt;
import ast.stmt.WhileStmt;
import ast.type.ArrayType;
import ast.type.BaseType;
import ast.type.BaseTypeEnum;
import ast.type.NoType;
import ast.type.PairType;
import astBuilder.ASTBuildingVisitor;
import codeGeneration.MachineState;
import errorCode.ErrorCode;
import libExten.AstImport;
import libExten.Library;

/*
 * class representing a visitor to check for semantic error
 */
public class SemanticChecker implements Visitor {
	
	private static final int DEFAULT_MODE = 0;
	
	private static final int INTERNAL_MODE = 1;

	private Stack<SymbolTable> tables;

	private Stack<AstNode> visited;

	private Type lastReturnType = null;
	
	private SymbolTable root = null;
	
	private Library master;
	
	private ArrayList<Library> validImports;
	
	private ArrayList<FunctionDecl> libFunctions;
	
	private int mode = DEFAULT_MODE;

	public SemanticChecker() {
		tables = new Stack<>();
		visited = new Stack<>();
		validImports = new ArrayList<Library>();
		master = Library.getMasterLibrary();
	}
	
	public SemanticChecker(int mode) {
		this.mode = mode;
		tables = new Stack<>();
		visited = new Stack<>();
		validImports = new ArrayList<Library>();
		master = Library.getMasterLibrary();
	}
	
	// return the SymbolTable at the program level
	public SymbolTable getRoot() {
		return root;
	}

	public void handleSemanticError(String s) {
		System.out.println("#SemanticError#");
		System.out.println(s);
		System.exit(ErrorCode.SEMANTIC_ERROR.getNumVal());
	}

	@Override
	public void visit(FunctionDecl funcDecl) {
		visited.push(funcDecl);
		// saves the return type for return type checking
		lastReturnType = funcDecl.getType();
		// link t to parent p
		SymbolTable p = tables.peek();
		SymbolTable t = new SymbolTable();
		t.setParentTable(p);
		// push vardecl onto current st
		ArrayList<VarDecl> vars = funcDecl.getParamList();
		for (VarDecl v : vars) {
			t.add(v.getIdentExpr(), v);
		}
		// push table onto the stack
		tables.push(t);
	}

	@Override
	public void visit(VarDecl varDecl) {
		visited.push(varDecl);
		SymbolTable p = tables.peek();
		Decl d = p.lookupThisScope(varDecl.getIdentExpr());
		if (d != null && d instanceof VarDecl) {
			handleSemanticError("var " + varDecl.getDeclName()
					+ " double declaration");
		}
		p.add(varDecl.getIdentExpr(), varDecl);
	}

	@Override
	public void visit(DigitExpr digit) {
		visited.push(digit);
	}

	@Override
	public void visit(IdentExpr ident) {
		visited.push(ident);
	}

	@Override
	public void visit(IntSignExpr intSign) {
		visited.push(intSign);
	}

	@Override
	public void visit(ArrayLitrExpr arrayLitr) {
		visited.push(arrayLitr);
		SymbolTable st = tables.peek();
		// check all exprs in arrayLitr have same type
		if (arrayLitr.size() != 0) {
			Expr e = arrayLitr.getElem(0);
			Expr ee = null;
			for (int i = 1; i < arrayLitr.size(); i++) {
				ee = arrayLitr.getElem(i);
				if (!e.getType(st).sameType(ee.getType(st))) {
					handleSemanticError(" array liter has expressions of varying types");
				}
				e = ee;
			}
		}
	}

	@Override
	public void visit(BinaryOperatorExpr binOp) {
		visited.push(binOp);
		SymbolTable st = tables.peek();
		Type t = binOp.getLeftExpr().getType(st);
		switch (binOp.getOperator()) {
		case MULTIPLY:
		case DIVIDE:
		case MODULAR:
		case PLUS:
		case MINUS:
			if (!t.sameType(new BaseType(BaseTypeEnum.INT))) {
				handleSemanticError("arguements of "
						+ binOp.getOperator().toString()
						+ " are not of type Int");
			}
			break;
		case LOGICAL_AND:
		case LOGICAL_OR:
			if (!t.sameType(new BaseType(BaseTypeEnum.BOOL))) {
				handleSemanticError("arguements of "
						+ binOp.getOperator().toString()
						+ " are not of type Bool");
			}
			break;
		case EQUALS_EQUALS:
		case NOT_EQUALS:
			break;
		default:
			if (!(t.sameType(new BaseType(BaseTypeEnum.INT)) || t
					.sameType(new BaseType(BaseTypeEnum.CHAR)))) {
				handleSemanticError("arguements of "
						+ binOp.getOperator().toString()
						+ " are not of type Char or Int");
			}
		}
		if (!binOp.getLeftExpr().getType(st)
				.sameType(binOp.getRightExpr().getType(st))) {
			handleSemanticError("arguements of "
					+ binOp.getOperator().toString() + " has different types");
		}
	}

	@Override
	public void visit(BoolLitrExpr boolLitr) {
		visited.push(boolLitr);
	}

	@Override
	public void visit(BracketedExpr bracketExpr) {
		visited.push(bracketExpr);
	}

	@Override
	public void visit(CallExpr callExpr) {
		visited.push(callExpr);
		SymbolTable st = tables.peek();
		Decl d = st.lookupFunction(callExpr.getFunctionRef());
		if (d == null || !(d instanceof FunctionDecl)) {
			handleSemanticError("calling function"
					+ callExpr.getFunctionRef().getIdentName()
					+ " that is not defined");
		}
		FunctionDecl f = (FunctionDecl) d;
		List<Expr> params = callExpr.getParams();
		ArrayList<VarDecl> fparams = f.getParamList();
		if (params.size() != fparams.size()) {
			handleSemanticError("The call to function "
					+ callExpr.getFunctionRef().getIdentName()
					+ " has incorrect number of arguments");
		}
		for (int i = 0; i < params.size(); i++) {
			if (!params.get(i).getType(st).sameType(fparams.get(i).getType())) {
				handleSemanticError("The call to function "
						+ callExpr.getFunctionRef().getIdentName()
						+ " has wrong parameter type");
			}
		}
		// generate code for functions iif it is actually called somewhere
		f.setCallStatus(true);
		// save the function decl in the call for code gen
		callExpr.setFuncDecl((FunctionDecl) d);
	}
	
	private FunctionDecl lookForFunctionDeclInLib(String id) {
		for (FunctionDecl f : libFunctions) {
			if (f.getDeclName().equals(id)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void visit(CharLitrExpr charLitr) {
		visited.push(charLitr);
	}

	@Override
	public void visit(IntLitrExpr intLitr) {
		visited.push(intLitr);
	}

	@Override
	public void visit(NewPairExpr newpair) {
		visited.push(newpair);
	}

	@Override
	public void visit(PairLitrExpr pairLitr) {
		visited.push(pairLitr);
	}

	@Override
	public void visit(StringLitrExpr stringLitr) {
		visited.push(stringLitr);
	}

	@Override
	public void visit(UnaryOperatorExpr unOp) {
		visited.push(unOp);
		SymbolTable st = tables.peek();
		Expr e = unOp.getInnerExpr();
		UnaryOperator uop = unOp.getOperator();
		switch (uop) {
		case EXCLAMATION:
			if (!e.getType(st).sameType(new BaseType(BaseTypeEnum.BOOL))) {
				handleSemanticError("unary op ! has arugment of type other than Bool");
			}
			break;
		case LEN:
			if (!((e.getType(st)) instanceof ArrayType)) {
				handleSemanticError("unary op len has arugment of type other than Array");
			}
			break;
		case ORD:
			if (!e.getType(st).sameType(new BaseType(BaseTypeEnum.CHAR))) {
				handleSemanticError("unary op ord has arugment of type other than Char");
			}
			break;
		default:
			if (!e.getType(st).sameType(new BaseType(BaseTypeEnum.INT))) {
				handleSemanticError("unary op" + uop.toString()
						+ "has arugment of type other than Int");
			}
		}
	}

	@Override
	public void visit(ArrayVarIndexRefExpr arrayVarIndexRefExpr) {
		visited.push(arrayVarIndexRefExpr);
		IdentExpr id = arrayVarIndexRefExpr.getIdentExpr();
		SymbolTable st = tables.peek();
		Decl d = st.lookup(id);
		if (d == null) {
			handleSemanticError("undefined reference to variable "
					+ id.getIdentName() + " in array index expr");
		}
		if (!(d instanceof VarDecl)) {
			handleSemanticError("the identifier "
					+ d.getIdentExpr().getIdentName() + " is not a variable");
		}
		if (!(arrayVarIndexRefExpr.getRefedExpr().getType(st) instanceof ArrayType)) {
			handleSemanticError("cannot index non array variable");
		}
		if (!arrayVarIndexRefExpr.getIndex().getType(st)
				.sameType(new BaseType(BaseTypeEnum.INT))) {
			handleSemanticError("cannot index array " + id.getIdentName()
					+ "with an index of type other than Int");
		}
	}

	@Override
	public void visit(PairVarRefExpr pairVarRefExpr) {
		visited.push(pairVarRefExpr);
		IdentExpr id = pairVarRefExpr.getIdentExpr();
		SymbolTable st = tables.peek();
		Decl d = st.lookup(id);
		if (d == null) {
			handleSemanticError("undefined reference to variable "
					+ id.getIdentName() + " in pair ref expr");
		}
		if (!(d instanceof VarDecl)) {
			handleSemanticError("the identifier "
					+ d.getIdentExpr().getIdentName() + " is not a variable");
		}
		if (!(pairVarRefExpr.getPairVarRefExpr().getType(st) instanceof PairType)) {
			handleSemanticError("cannot take fst/snd of non PairType variable");
		}
	}

	@Override
	public void visit(VarRefExpr varRefExpr) {
		visited.push(varRefExpr);
		IdentExpr id = varRefExpr.getIdentExpr();
		SymbolTable st = tables.peek();
		Decl d = st.lookup(id);
		if (d == null) {
			handleSemanticError("undefined reference to variable "
					+ id.getIdentName());
		}
		if (!(d instanceof VarDecl)) {
			handleSemanticError("the identifier "
					+ d.getIdentExpr().getIdentName() + " is not a variable");
		}
		
		// stores the varDecl for later use in code gen
		varRefExpr.setVarDecl((VarDecl) d);
	}

	private void checkFuncDeclHasReturn(FunctionDecl f) {
		if (!containsReturnStmt(f.getFunctionBodyStmt())) {
			System.err.println("function " + f.getDeclName()
					+ " contains control flow with no return statement");
			// exit with syntax error
			System.exit(ErrorCode.SYNTAX_ERROR.getNumVal());
		}
	}

	private boolean containsReturnStmt(Statement body) {
		Statement stmt;
		for (stmt = body; stmt instanceof CompoundStmt; stmt = ((CompoundStmt) stmt)
				.getNextStmt()) {
			Statement curr = ((CompoundStmt) stmt).getThisStmt();
			if (isReturnStatementEquivalent(curr)) {
				return true;
			}
		}
		return isReturnStatementEquivalent(stmt);
	}

	private boolean isReturnStatementEquivalent(Statement stmt) {
		return (stmt instanceof IfStmt
				&& containsReturnStmt(((ThenBranchStmt) ((IfStmt) stmt)
						.getTrueBranch()).getTrueBranch()) && containsReturnStmt(((ElseBranchStmt) ((IfStmt) stmt)
					.getFalseBranch()).getFalseBranch()))
				|| (stmt instanceof BeginStmt && containsReturnStmt(((BeginStmt) stmt)
						.getBeginBody()))
				|| stmt instanceof ReturnStmt
				|| stmt instanceof ExitStmt;
	}

	@Override
	public void visit(Program program) {
		visited.push(program);
		
		// checking for imports
		ArrayList<AstImport> imports = program.getImports();
		for (AstImport im : imports) {
			ArrayList<String> names = null;
			try {
				names = new ArrayList<String>(Arrays.asList(im.getLibName().split("\\.")));
			} catch (Exception e) {
				handleSemanticError("invalid import : " + im.getLibName());
			}
			if (names == null) {
				handleSemanticError("invalid import : " + im.getLibName());
			}
			Library l = master.searchForLibraryWithGivenPath(names);
			if (l == null) {
				handleSemanticError("the import for library " + im.getLibName() + " is not defined");
			}
			validImports.add(l);
		}
		
		// generating ast representation of the lib functions
		ArrayList<FunctionDecl> localLibFunctions = null;
		String code = "begin\n";
		for (Library l : validImports) {
			code += l.getLibraryCode();
		}
		code += " \nskip\nend";
		if (validImports.size() > 0) {
		    InputStream in = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		    try {
		    	ANTLRInputStream input = new ANTLRInputStream(in);
		    	BasicLexer lexer = new BasicLexer(input);
		    	CommonTokenStream tokens = new CommonTokenStream(lexer);
		    	BasicParser parser = new BasicParser(tokens);
		    	AstNode root = (new ASTBuildingVisitor()).visit(parser.program());
		    	root.walk(new SemanticChecker(INTERNAL_MODE));
		    	localLibFunctions = ((Program) root).getFuncDeclList();
		    } catch (IOException e) {
		    	System.out.println("should not happen if our lib function codes are bug free");
		    }
		    libFunctions = removeDuplicate(localLibFunctions);
		    program.setLibFunctions(libFunctions);
		}
		
		// setting up FunctionDecl
		ArrayList<FunctionDecl> functions = program.getFuncDeclList();
		Set<String> names = new HashSet<>();
		SymbolTable st = new SymbolTable();
		this.root = st;
		st.setLibFunctions(libFunctions);
		for (FunctionDecl f : functions) {
			if (mode == DEFAULT_MODE) {
			    checkFuncDeclHasReturn(f);
			    if (!names.contains(f.getDeclName())) {
			    	names.add(f.getDeclName());
			    } else {
			    	// VOMIT EVERYWGHERE
			    	handleSemanticError("Function " + f.getDeclName()
			    			+ " is already declared");
			    }
			}
			st.add(f.getIdentExpr(), f);
		}
		tables.push(st);

	}
	
	private ArrayList<FunctionDecl> removeDuplicate(ArrayList<FunctionDecl> fs) {
		ArrayList<FunctionDecl> result = new ArrayList<FunctionDecl>();
		HashSet<String> ids = new HashSet<String>();
		for (FunctionDecl f : fs) {
			if (!ids.contains(f.getDeclName())) {
				result.add(f);
				ids.add(f.getDeclName());
			}
		}
		return result;
	}

	@Override
	public void visit(AssignmentStmt assignStmt) {
		visited.push(assignStmt);
		SymbolTable st = tables.peek();

		// check variable is defined
		if (st.lookup(assignStmt.getLhsExpr().getIdentExpr()) == null) {
			handleSemanticError("target of assignment "
					+ assignStmt.getLhsExpr().getIdentExpr().getIdentName()
					+ " not defined in scope!");
		}
		Type lhsExprType = assignStmt.getLhsExpr().getType(st);
		Type rhsExprType = assignStmt.getRhsExpr().getType(st);

		if (!lhsExprType.sameType(rhsExprType)) {
			handleSemanticError("ERROR - Type of the value does "
					+ "not match the variable it is being assigned to.");
		}
	}

	@Override
	public void visit(BeginStmt beginStmt) {
		visited.push(beginStmt);
		SymbolTable st = new SymbolTable();
		st.setParentTable(tables.peek());
		tables.push(st);
	}

	@Override
	public void visit(CompoundStmt compoundStmt) {
		visited.push(compoundStmt);
	}

	@Override
	public void visit(ExitStmt exitStmt) {
		visited.push(exitStmt);
		SymbolTable st = tables.peek();
		if (!exitStmt.getExitExpr().getType(st)
				.sameType(new BaseType(BaseTypeEnum.INT))) {
			handleSemanticError("exiting with argument of type other than Int");
		}
	}

	@Override
	public void visit(FreeStmt freeStmt) {
		visited.push(freeStmt);
		SymbolTable st = tables.peek();
		Type t = freeStmt.getFreeExpr().getType(st);
		if (!(t instanceof ArrayType || t instanceof PairType)) {
			handleSemanticError("Only arrays or pairs may be freed.");
		}
		// error freeing should be runtime error
	}

	@Override
	public void visit(IfStmt ifStmt) {
		visited.push(ifStmt);
		SymbolTable st = tables.peek();
		if (!ifStmt.getCondition().getType(st)
				.sameType(new BaseType(BaseTypeEnum.BOOL))) {
			handleSemanticError("if stmt has condition of type other than Bool");
		}
	}

	@Override
	public void visit(PrintlnStmt printlnStmt) {
		visited.push(printlnStmt);
	}

	@Override
	public void visit(PrintStmt printStmt) {
		visited.push(printStmt);
	}

	@Override
	public void visit(ReadStmt readStmt) {
		SymbolTable st = tables.peek();
		visited.add(readStmt);
		Expr expr = readStmt.getReadExpr();
		if (!((expr instanceof VarRefExpr || expr instanceof PairVarRefExpr || expr instanceof ArrayVarIndexRefExpr) && (expr
				.getType(st).sameType(new BaseType(BaseTypeEnum.CHAR)) || expr
				.getType(st).sameType(new BaseType(BaseTypeEnum.INT))))) {
			handleSemanticError("read stmt does not have argument of type char or string");
		}
	}

	@Override
	public void visit(ReturnStmt returnStmt) {
		visited.push(returnStmt);
		if (lastReturnType == null) {
			handleSemanticError("top level naked return statement");
		}
		SymbolTable st = tables.peek();
		if (returnStmt.getReturnExpr() == null
				|| !returnStmt.getReturnExpr().getType(st)
						.sameType(lastReturnType)) {
			handleSemanticError("return statement with incompatible type");
		}
	}

	@Override
	public void visit(SkipStmt skipStmt) {
		visited.push(skipStmt);
	}

	@Override
	public void visit(VarDeclStmt varDeclStmt) {
		visited.push(varDeclStmt);
		SymbolTable st = tables.peek();
		
		if (!varDeclStmt.getVariableType().sameType(
				varDeclStmt.getVariableExpr().getType(st))) {
			handleSemanticError("declaring variables with incompatible types");
		}
	}

	@Override
	public void visit(WhileStmt whileStmt) {
		visited.push(whileStmt);
		SymbolTable p = tables.peek();

		if (!whileStmt.getCondition().getType(p)
				.sameType(new BaseType(BaseTypeEnum.BOOL))) {
			handleSemanticError("while stmt has condition of type other than Bool");
		}
		SymbolTable st = new SymbolTable();
		st.setParentTable(p);
		tables.push(st);
	}

	@Override
	public void visit(ArrayType arrayType) {
		visited.push(arrayType);
	}

	@Override
	public void visit(BaseType baseType) {
		visited.push(baseType);
	}

	@Override
	public void visit(PairType pairType) {
		visited.push(pairType);
	}

	@Override
	public void visit(NoType noType) {
		visited.push(noType);
	}

	@Override
	public void leave() {
		AstNode node = visited.pop();
		if (node instanceof FunctionDecl) {
			lastReturnType = null;
			tables.pop();
		}
		if (node instanceof WhileStmt) {
			tables.pop();
		}
		if (node instanceof BeginStmt) {
			tables.pop();
		}
		if (node instanceof ElseBranchStmt) {
			tables.pop();
		}
		if (node instanceof ThenBranchStmt) {
			tables.pop();
		}
	}

	@Override
	public void visit(ThenBranchStmt thenStmt) {
		visited.push(thenStmt);
		SymbolTable st = new SymbolTable();
		st.setParentTable(tables.peek());
		tables.push(st);
	}

	@Override
	public void visit(ElseBranchStmt elseStmt) {
		visited.push(elseStmt);
		SymbolTable st = new SymbolTable();
		st.setParentTable(tables.peek());
		tables.push(st);
	}

}
