// Generated from ./BasicParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXCLAMATION_MARK=35, WHILE=20, FST=26, BOOL_TYPE=29, MOD=41, GREATER_OR_EQUAL=45, 
		CHAR=52, DO=21, ID=59, NOT_EQUALS=49, ORD=37, LOGICAL_AND=50, IF=16, FREE=11, 
		IMPORT=3, UPPERCASE=63, CLOSE_PARENTHESES=2, THEN=17, SMALLER_THAN=46, 
		COMMA=4, DONE=22, IS=9, PRINTLN=15, EQUAL=6, BEGIN=7, LOGICAL_OR=51, RETURN=12, 
		OPEN_SQUARE=32, EQUALS_EQUALS=48, PLUS=42, PAIR=34, DIGIT=64, COMMENT=54, 
		CLOSE_SQUARE=33, NEWPAIR=24, EXIT=13, GREATER_THAN=44, SND=27, CHAR_TYPE=30, 
		NULL=58, ELSE=18, UNDERSCORE=61, SEMI_COLON=23, INT_TYPE=28, MINUS=43, 
		TRUE=56, MUL=39, PRINT=14, CHR=38, FI=19, SKIP=5, WS=55, LOWERCASE=62, 
		SMALLER_OR_EQUAL=47, LIBNAME=60, READ=10, STRING_TYPE=31, OPEN_PARENTHESES=1, 
		LEN=36, CALL=25, DIV=40, END=8, FALSE=57, STRING=53;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "'import'", "','", "'skip'", "'='", "'begin'", 
		"'end'", "'is'", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"';'", "'newpair'", "'call'", "'fst'", "'snd'", "'int'", "'bool'", "'char'", 
		"'string'", "'['", "']'", "'pair'", "'!'", "'len'", "'ord'", "'chr'", 
		"'*'", "'/'", "'%'", "'+'", "'-'", "'>'", "'>='", "'<'", "'<='", "'=='", 
		"'!='", "'&&'", "'||'", "CHAR", "STRING", "COMMENT", "WS", "'true'", "'false'", 
		"'null'", "ID", "LIBNAME", "'_'", "LOWERCASE", "UPPERCASE", "DIGIT"
	};
	public static final int
		RULE_program = 0, RULE_importlib = 1, RULE_function = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_pair_elem = 7, 
		RULE_type = 8, RULE_base_type = 9, RULE_array_type = 10, RULE_pair_type = 11, 
		RULE_pair_elem_type = 12, RULE_expr = 13, RULE_unary_exp = 14, RULE_unary_oper = 15, 
		RULE_ident = 16, RULE_array_elem = 17, RULE_int_liter = 18, RULE_digit = 19, 
		RULE_int_sign = 20, RULE_bool_liter = 21, RULE_char_liter = 22, RULE_str_liter = 23, 
		RULE_array_liter = 24, RULE_pair_liter = 25;
	public static final String[] ruleNames = {
		"program", "importlib", "function", "param", "stat", "assign_lhs", "assign_rhs", 
		"pair_elem", "type", "base_type", "array_type", "pair_type", "pair_elem_type", 
		"expr", "unary_exp", "unary_oper", "ident", "array_elem", "int_liter", 
		"digit", "int_sign", "bool_liter", "char_liter", "str_liter", "array_liter", 
		"pair_liter"
	};

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public FunctionContext function;
		public List<FunctionContext> funcs = new ArrayList<FunctionContext>();
		public StatContext body;
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<ImportlibContext> importlib() {
			return getRuleContexts(ImportlibContext.class);
		}
		public ImportlibContext importlib(int i) {
			return getRuleContext(ImportlibContext.class,i);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(52); importlib();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(BEGIN);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59); ((ProgramContext)_localctx).function = function();
					((ProgramContext)_localctx).funcs.add(((ProgramContext)_localctx).function);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(65); ((ProgramContext)_localctx).body = stat(0);
			setState(66); match(END);
			setState(67); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportlibContext extends ParserRuleContext {
		public Token id;
		public TerminalNode SEMI_COLON() { return getToken(BasicParser.SEMI_COLON, 0); }
		public TerminalNode IMPORT() { return getToken(BasicParser.IMPORT, 0); }
		public TerminalNode ID() { return getToken(BasicParser.ID, 0); }
		public TerminalNode LIBNAME() { return getToken(BasicParser.LIBNAME, 0); }
		public ImportlibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importlib; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitImportlib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportlibContext importlib() throws RecognitionException {
		ImportlibContext _localctx = new ImportlibContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importlib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(IMPORT);
			setState(70);
			((ImportlibContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==LIBNAME) ) {
				((ImportlibContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(71); match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TypeContext t;
		public IdentContext id;
		public ParamContext param;
		public List<ParamContext> params = new ArrayList<ParamContext>();
		public StatContext body;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); ((FunctionContext)_localctx).t = type();
			setState(74); ((FunctionContext)_localctx).id = ident();
			setState(75); match(OPEN_PARENTHESES);
			setState(84);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << BOOL_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PAIR))) != 0)) {
				{
				setState(76); ((FunctionContext)_localctx).param = param();
				((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).param);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77); match(COMMA);
					setState(78); ((FunctionContext)_localctx).param = param();
					((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).param);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(86); match(CLOSE_PARENTHESES);
			setState(87); match(IS);
			setState(88); ((FunctionContext)_localctx).body = stat(0);
			setState(89); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext t;
		public IdentContext id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); ((ParamContext)_localctx).t = type();
			setState(92); ((ParamContext)_localctx).id = ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStmtContext extends StatContext {
		public ExprContext cond;
		public StatContext ifbranch;
		public StatContext elsebranch;
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipStmtContext extends StatContext {
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public SkipStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSkipStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompoundStmtContext extends StatContext {
		public StatContext head;
		public StatContext tail;
		public TerminalNode SEMI_COLON() { return getToken(BasicParser.SEMI_COLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public CompoundStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCompoundStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStmtContext extends StatContext {
		public ExprContext child;
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitStmtContext extends StatContext {
		public ExprContext child;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public ExitStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExitStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintLnStmtContext extends StatContext {
		public ExprContext child;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public PrintLnStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrintLnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatContext {
		public ExprContext child;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public ReturnStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStmtContext extends StatContext {
		public Assign_lhsContext lhs;
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public ReadStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitReadStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclAssnStmtContext extends StatContext {
		public TypeContext t;
		public IdentContext id;
		public Assign_rhsContext rhs;
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public VarDeclAssnStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitVarDeclAssnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StatContext {
		public ExprContext cond;
		public StatContext body;
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeginStmtContext extends StatContext {
		public StatContext body;
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public BeginStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBeginStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStmtContext extends StatContext {
		public Assign_lhsContext lhs;
		public Assign_rhsContext rhs;
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public AssignmentStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FreeStmtContext extends StatContext {
		public ExprContext child;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public FreeStmtContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFreeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new SkipStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(95); match(SKIP);
				}
				break;
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
			case PAIR:
				{
				_localctx = new VarDeclAssnStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); ((VarDeclAssnStmtContext)_localctx).t = type();
				setState(97); ((VarDeclAssnStmtContext)_localctx).id = ident();
				setState(98); match(EQUAL);
				setState(99); ((VarDeclAssnStmtContext)_localctx).rhs = assign_rhs();
				}
				break;
			case FST:
			case SND:
			case ID:
				{
				_localctx = new AssignmentStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101); ((AssignmentStmtContext)_localctx).lhs = assign_lhs();
				setState(102); match(EQUAL);
				setState(103); ((AssignmentStmtContext)_localctx).rhs = assign_rhs();
				}
				break;
			case READ:
				{
				_localctx = new ReadStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105); match(READ);
				setState(106); ((ReadStmtContext)_localctx).lhs = assign_lhs();
				}
				break;
			case FREE:
				{
				_localctx = new FreeStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107); match(FREE);
				setState(108); ((FreeStmtContext)_localctx).child = expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new ReturnStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); match(RETURN);
				setState(110); ((ReturnStmtContext)_localctx).child = expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new ExitStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111); match(EXIT);
				setState(112); ((ExitStmtContext)_localctx).child = expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new PrintStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); match(PRINT);
				setState(114); ((PrintStmtContext)_localctx).child = expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new PrintLnStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); match(PRINTLN);
				setState(116); ((PrintLnStmtContext)_localctx).child = expr(0);
				}
				break;
			case IF:
				{
				_localctx = new IfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); match(IF);
				setState(118); ((IfStmtContext)_localctx).cond = expr(0);
				setState(119); match(THEN);
				setState(120); ((IfStmtContext)_localctx).ifbranch = stat(0);
				setState(121); match(ELSE);
				setState(122); ((IfStmtContext)_localctx).elsebranch = stat(0);
				setState(123); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new WhileStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125); match(WHILE);
				setState(126); ((WhileStmtContext)_localctx).cond = expr(0);
				setState(127); match(DO);
				setState(128); ((WhileStmtContext)_localctx).body = stat(0);
				setState(129); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new BeginStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131); match(BEGIN);
				setState(132); ((BeginStmtContext)_localctx).body = stat(0);
				setState(133); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompoundStmtContext(new StatContext(_parentctx, _parentState));
					((CompoundStmtContext)_localctx).head = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(137);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(138); match(SEMI_COLON);
					setState(139); ((CompoundStmtContext)_localctx).tail = stat(2);
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Assign_lhsContext extends ParserRuleContext {
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
	 
		public Assign_lhsContext() { }
		public void copyFrom(Assign_lhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LhsVarRefExprContext extends Assign_lhsContext {
		public IdentContext id;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LhsVarRefExprContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitLhsVarRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LhsArrayVarIndexRefExprContext extends Assign_lhsContext {
		public Array_elemContext elem;
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public LhsArrayVarIndexRefExprContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitLhsArrayVarIndexRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LhsPairVarRefExprContext extends Assign_lhsContext {
		public Pair_elemContext elem;
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public LhsPairVarRefExprContext(Assign_lhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitLhsPairVarRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LhsVarRefExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145); ((LhsVarRefExprContext)_localctx).id = ident();
				}
				break;
			case 2:
				_localctx = new LhsArrayVarIndexRefExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146); ((LhsArrayVarIndexRefExprContext)_localctx).elem = array_elem();
				}
				break;
			case 3:
				_localctx = new LhsPairVarRefExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(147); ((LhsPairVarRefExprContext)_localctx).elem = pair_elem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_rhsContext extends ParserRuleContext {
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
	 
		public Assign_rhsContext() { }
		public void copyFrom(Assign_rhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RhsCallExprContext extends Assign_rhsContext {
		public IdentContext id;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public RhsCallExprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRhsCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsNewPairExprContext extends Assign_rhsContext {
		public ExprContext valueLhs;
		public ExprContext valueRhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public RhsNewPairExprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRhsNewPairExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsPairVarRefExprContext extends Assign_rhsContext {
		public Pair_elemContext value;
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public RhsPairVarRefExprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRhsPairVarRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsArrayLiterExprContext extends Assign_rhsContext {
		public Array_literContext value;
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public RhsArrayLiterExprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRhsArrayLiterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsExprContext extends Assign_rhsContext {
		public ExprContext value;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RhsExprContext(Assign_rhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRhsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(175);
			switch (_input.LA(1)) {
			case OPEN_PARENTHESES:
			case EXCLAMATION_MARK:
			case LEN:
			case ORD:
			case CHR:
			case PLUS:
			case MINUS:
			case CHAR:
			case STRING:
			case TRUE:
			case FALSE:
			case NULL:
			case ID:
			case DIGIT:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150); ((RhsExprContext)_localctx).value = expr(0);
				}
				break;
			case OPEN_SQUARE:
				_localctx = new RhsArrayLiterExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151); ((RhsArrayLiterExprContext)_localctx).value = array_liter();
				}
				break;
			case NEWPAIR:
				_localctx = new RhsNewPairExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152); match(NEWPAIR);
				setState(153); match(OPEN_PARENTHESES);
				setState(154); ((RhsNewPairExprContext)_localctx).valueLhs = expr(0);
				setState(155); match(COMMA);
				setState(156); ((RhsNewPairExprContext)_localctx).valueRhs = expr(0);
				setState(157); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new RhsPairVarRefExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(159); ((RhsPairVarRefExprContext)_localctx).value = pair_elem();
				}
				break;
			case CALL:
				_localctx = new RhsCallExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(160); match(CALL);
				setState(161); ((RhsCallExprContext)_localctx).id = ident();
				setState(162); match(OPEN_PARENTHESES);
				setState(171);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (OPEN_PARENTHESES - 1)) | (1L << (EXCLAMATION_MARK - 1)) | (1L << (LEN - 1)) | (1L << (ORD - 1)) | (1L << (CHR - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (CHAR - 1)) | (1L << (STRING - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (NULL - 1)) | (1L << (ID - 1)) | (1L << (DIGIT - 1)))) != 0)) {
					{
					setState(163); ((RhsCallExprContext)_localctx).expr = expr(0);
					((RhsCallExprContext)_localctx).args.add(((RhsCallExprContext)_localctx).expr);
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(164); match(COMMA);
						setState(165); ((RhsCallExprContext)_localctx).expr = expr(0);
						((RhsCallExprContext)_localctx).args.add(((RhsCallExprContext)_localctx).expr);
						}
						}
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(173); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_elemContext extends ParserRuleContext {
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
	 
		public Pair_elemContext() { }
		public void copyFrom(Pair_elemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PairElemFstContext extends Pair_elemContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public PairElemFstContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemFst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElemSndContext extends Pair_elemContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public PairElemSndContext(Pair_elemContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemSnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pair_elem);
		try {
			setState(187);
			switch (_input.LA(1)) {
			case FST:
				_localctx = new PairElemFstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177); match(FST);
				setState(180);
				switch (_input.LA(1)) {
				case OPEN_PARENTHESES:
				case EXCLAMATION_MARK:
				case LEN:
				case ORD:
				case CHR:
				case PLUS:
				case MINUS:
				case CHAR:
				case STRING:
				case TRUE:
				case FALSE:
				case NULL:
				case ID:
				case DIGIT:
					{
					setState(178); expr(0);
					}
					break;
				case FST:
				case SND:
					{
					setState(179); pair_elem();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SND:
				_localctx = new PairElemSndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182); match(SND);
				setState(185);
				switch (_input.LA(1)) {
				case OPEN_PARENTHESES:
				case EXCLAMATION_MARK:
				case LEN:
				case ORD:
				case CHR:
				case PLUS:
				case MINUS:
				case CHAR:
				case STRING:
				case TRUE:
				case FALSE:
				case NULL:
				case ID:
				case DIGIT:
					{
					setState(183); expr(0);
					}
					break;
				case FST:
				case SND:
					{
					setState(184); pair_elem();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArrayTypeContext extends TypeContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TypeArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTypeArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBaseTypeContext extends TypeContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeBaseTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTypeBaseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePairTypeContext extends TypeContext {
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TypePairTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTypePairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new TypeBaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189); base_type();
				}
				break;
			case 2:
				_localctx = new TypeArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190); array_type(0);
				}
				break;
			case 3:
				_localctx = new TypePairTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191); pair_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
	 
		public Base_typeContext() { }
		public void copyFrom(Base_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringTypeContext extends Base_typeContext {
		public TerminalNode STRING_TYPE() { return getToken(BasicParser.STRING_TYPE, 0); }
		public StringTypeContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends Base_typeContext {
		public TerminalNode BOOL_TYPE() { return getToken(BasicParser.BOOL_TYPE, 0); }
		public BoolTypeContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharTypeContext extends Base_typeContext {
		public TerminalNode CHAR_TYPE() { return getToken(BasicParser.CHAR_TYPE, 0); }
		public CharTypeContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends Base_typeContext {
		public TerminalNode INT_TYPE() { return getToken(BasicParser.INT_TYPE, 0); }
		public IntTypeContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_base_type);
		try {
			setState(198);
			switch (_input.LA(1)) {
			case INT_TYPE:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194); match(INT_TYPE);
				}
				break;
			case BOOL_TYPE:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195); match(BOOL_TYPE);
				}
				break;
			case CHAR_TYPE:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196); match(CHAR_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(197); match(STRING_TYPE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	 
		public Array_typeContext() { }
		public void copyFrom(Array_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayElemTypePairTypeContext extends Array_typeContext {
		public Pair_typeContext innerType;
		public TerminalNode OPEN_SQUARE() { return getToken(BasicParser.OPEN_SQUARE, 0); }
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE() { return getToken(BasicParser.CLOSE_SQUARE, 0); }
		public ArrayElemTypePairTypeContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElemTypePairType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeBaseTypeContext extends Array_typeContext {
		public Base_typeContext innerType;
		public TerminalNode OPEN_SQUARE() { return getToken(BasicParser.OPEN_SQUARE, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE() { return getToken(BasicParser.CLOSE_SQUARE, 0); }
		public ArrayTypeBaseTypeContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayTypeBaseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElemTypeArrayTypeContext extends Array_typeContext {
		public Array_typeContext innerType;
		public TerminalNode OPEN_SQUARE() { return getToken(BasicParser.OPEN_SQUARE, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE() { return getToken(BasicParser.CLOSE_SQUARE, 0); }
		public ArrayElemTypeArrayTypeContext(Array_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElemTypeArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		return array_type(0);
	}

	private Array_typeContext array_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Array_typeContext _localctx = new Array_typeContext(_ctx, _parentState);
		Array_typeContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_array_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
				{
				_localctx = new ArrayTypeBaseTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(201); ((ArrayTypeBaseTypeContext)_localctx).innerType = base_type();
				setState(202); match(OPEN_SQUARE);
				setState(203); match(CLOSE_SQUARE);
				}
				break;
			case PAIR:
				{
				_localctx = new ArrayElemTypePairTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205); ((ArrayElemTypePairTypeContext)_localctx).innerType = pair_type();
				setState(206); match(OPEN_SQUARE);
				setState(207); match(CLOSE_SQUARE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayElemTypeArrayTypeContext(new Array_typeContext(_parentctx, _parentState));
					((ArrayElemTypeArrayTypeContext)_localctx).innerType = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_array_type);
					setState(211);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(212); match(OPEN_SQUARE);
					setState(213); match(CLOSE_SQUARE);
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Pair_typeContext extends ParserRuleContext {
		public Pair_elem_typeContext fstType;
		public Pair_elem_typeContext sndType;
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(PAIR);
			setState(220); match(OPEN_PARENTHESES);
			setState(221); ((Pair_typeContext)_localctx).fstType = pair_elem_type();
			setState(222); match(COMMA);
			setState(223); ((Pair_typeContext)_localctx).sndType = pair_elem_type();
			setState(224); match(CLOSE_PARENTHESES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
	 
		public Pair_elem_typeContext() { }
		public void copyFrom(Pair_elem_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PairElemTypeArrayTypeContext extends Pair_elem_typeContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public PairElemTypeArrayTypeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemTypeArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElemTypeBaseTypeContext extends Pair_elem_typeContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public PairElemTypeBaseTypeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemTypeBaseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElemTypePairTypeContext extends Pair_elem_typeContext {
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public PairElemTypePairTypeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemTypePairType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElemTypeFullPairTypeContext extends Pair_elem_typeContext {
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public PairElemTypeFullPairTypeContext(Pair_elem_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemTypeFullPairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_elem_type);
		try {
			setState(230);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new PairElemTypeBaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226); base_type();
				}
				break;
			case 2:
				_localctx = new PairElemTypeArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227); array_type(0);
				}
				break;
			case 3:
				_localctx = new PairElemTypePairTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(228); match(PAIR);
				}
				break;
			case 4:
				_localctx = new PairElemTypeFullPairTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(229); pair_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprBinaryOperatorExprPrec5Context extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public TerminalNode LOGICAL_AND() { return getToken(BasicParser.LOGICAL_AND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBinaryOperatorExprPrec5Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec5(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinaryOperatorExprPrec6Context extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGICAL_OR() { return getToken(BasicParser.LOGICAL_OR, 0); }
		public ExprBinaryOperatorExprPrec6Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec6(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinaryOperatorExprPrec3Context extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public TerminalNode SMALLER_OR_EQUAL() { return getToken(BasicParser.SMALLER_OR_EQUAL, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(BasicParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode SMALLER_THAN() { return getToken(BasicParser.SMALLER_THAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(BasicParser.GREATER_THAN, 0); }
		public ExprBinaryOperatorExprPrec3Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinaryOperatorExprPrec4Context extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public TerminalNode EQUALS_EQUALS() { return getToken(BasicParser.EQUALS_EQUALS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT_EQUALS() { return getToken(BasicParser.NOT_EQUALS, 0); }
		public ExprBinaryOperatorExprPrec4Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec4(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinaryOperatorExprPrec1Context extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public TerminalNode MUL() { return getToken(BasicParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public ExprBinaryOperatorExprPrec1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinaryOperatorExprPrec2Context extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public ExprBinaryOperatorExprPrec2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBinaryOperatorExprPrec2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCharLitrExprContext extends ExprContext {
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public ExprCharLitrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprCharLitrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBoolLitrExprContext extends ExprContext {
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public ExprBoolLitrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBoolLitrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIntLitrExprContext extends ExprContext {
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public ExprIntLitrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprIntLitrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPairLitrExprContext extends ExprContext {
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public ExprPairLitrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprPairLitrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBracketedExprContext extends ExprContext {
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public ExprBracketedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprBracketedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStringLitrExprContext extends ExprContext {
		public Str_literContext str_liter() {
			return getRuleContext(Str_literContext.class,0);
		}
		public ExprStringLitrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprStringLitrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprUnaryOperatorExprContext extends ExprContext {
		public Unary_expContext unary_exp() {
			return getRuleContext(Unary_expContext.class,0);
		}
		public ExprUnaryOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprUnaryOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrayVarIndexRefExprContext extends ExprContext {
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public ExprArrayVarIndexRefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprArrayVarIndexRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprVarRefExprContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprVarRefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExprVarRefExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new ExprIntLitrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(233); int_liter();
				}
				break;
			case 2:
				{
				_localctx = new ExprBoolLitrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); bool_liter();
				}
				break;
			case 3:
				{
				_localctx = new ExprCharLitrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235); char_liter();
				}
				break;
			case 4:
				{
				_localctx = new ExprStringLitrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236); str_liter();
				}
				break;
			case 5:
				{
				_localctx = new ExprPairLitrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); pair_liter();
				}
				break;
			case 6:
				{
				_localctx = new ExprVarRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); ident();
				}
				break;
			case 7:
				{
				_localctx = new ExprArrayVarIndexRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239); array_elem();
				}
				break;
			case 8:
				{
				_localctx = new ExprUnaryOperatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); unary_exp();
				}
				break;
			case 9:
				{
				_localctx = new ExprBracketedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241); match(OPEN_PARENTHESES);
				setState(242); ((ExprBracketedExprContext)_localctx).body = expr(0);
				setState(243); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(265);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinaryOperatorExprPrec1Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec1Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(248);
						((ExprBinaryOperatorExprPrec1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ExprBinaryOperatorExprPrec1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(249); ((ExprBinaryOperatorExprPrec1Context)_localctx).rhs = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinaryOperatorExprPrec2Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec2Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(251);
						((ExprBinaryOperatorExprPrec2Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExprBinaryOperatorExprPrec2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(252); ((ExprBinaryOperatorExprPrec2Context)_localctx).rhs = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinaryOperatorExprPrec3Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec3Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(254);
						((ExprBinaryOperatorExprPrec3Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN) | (1L << GREATER_OR_EQUAL) | (1L << SMALLER_THAN) | (1L << SMALLER_OR_EQUAL))) != 0)) ) {
							((ExprBinaryOperatorExprPrec3Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(255); ((ExprBinaryOperatorExprPrec3Context)_localctx).rhs = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinaryOperatorExprPrec4Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec4Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(257);
						((ExprBinaryOperatorExprPrec4Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==NOT_EQUALS) ) {
							((ExprBinaryOperatorExprPrec4Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(258); ((ExprBinaryOperatorExprPrec4Context)_localctx).rhs = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinaryOperatorExprPrec5Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec5Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(260); match(LOGICAL_AND);
						setState(261); ((ExprBinaryOperatorExprPrec5Context)_localctx).rhs = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new ExprBinaryOperatorExprPrec6Context(new ExprContext(_parentctx, _parentState));
						((ExprBinaryOperatorExprPrec6Context)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(263); match(LOGICAL_OR);
						setState(264); ((ExprBinaryOperatorExprPrec6Context)_localctx).rhs = expr(3);
						}
						break;
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_expContext extends ParserRuleContext {
		public ExprContext operand;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Unary_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expContext unary_exp() throws RecognitionException {
		Unary_expContext _localctx = new Unary_expContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unary_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); unary_oper();
			setState(271); ((Unary_expContext)_localctx).operand = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operContext extends ParserRuleContext {
		public Unary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_oper; }
	 
		public Unary_operContext() { }
		public void copyFrom(Unary_operContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnMinusContext extends Unary_operContext {
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public UnMinusContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrdContext extends Unary_operContext {
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public OrdContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitOrd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LenContext extends Unary_operContext {
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public LenContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitLen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExclamationContext extends Unary_operContext {
		public TerminalNode EXCLAMATION_MARK() { return getToken(BasicParser.EXCLAMATION_MARK, 0); }
		public ExclamationContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExclamation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChrContext extends Unary_operContext {
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public ChrContext(Unary_operContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operContext unary_oper() throws RecognitionException {
		Unary_operContext _localctx = new Unary_operContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_oper);
		try {
			setState(278);
			switch (_input.LA(1)) {
			case EXCLAMATION_MARK:
				_localctx = new ExclamationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(273); match(EXCLAMATION_MARK);
				}
				break;
			case MINUS:
				_localctx = new UnMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(274); match(MINUS);
				}
				break;
			case LEN:
				_localctx = new LenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(275); match(LEN);
				}
				break;
			case ORD:
				_localctx = new OrdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(276); match(ORD);
				}
				break;
			case CHR:
				_localctx = new ChrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(277); match(CHR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicParser.ID, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_elemContext extends ParserRuleContext {
		public IdentContext id;
		public List<TerminalNode> OPEN_SQUARE() { return getTokens(BasicParser.OPEN_SQUARE); }
		public TerminalNode CLOSE_SQUARE(int i) {
			return getToken(BasicParser.CLOSE_SQUARE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_SQUARE(int i) {
			return getToken(BasicParser.OPEN_SQUARE, i);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<TerminalNode> CLOSE_SQUARE() { return getTokens(BasicParser.CLOSE_SQUARE); }
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282); ((Array_elemContext)_localctx).id = ident();
			setState(287); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(283); match(OPEN_SQUARE);
					setState(284); expr(0);
					setState(285); match(CLOSE_SQUARE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(289); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public Int_signContext int_sign() {
			return getRuleContext(Int_signContext.class,0);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public Int_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literContext int_liter() throws RecognitionException {
		Int_literContext _localctx = new Int_literContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_int_liter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(291); int_sign();
				}
			}

			setState(295); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(294); digit();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(297); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(BasicParser.DIGIT, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); match(DIGIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_signContext extends ParserRuleContext {
		public Int_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_sign; }
	 
		public Int_signContext() { }
		public void copyFrom(Int_signContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusContext extends Int_signContext {
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public PlusContext(Int_signContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusContext extends Int_signContext {
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public MinusContext(Int_signContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_signContext int_sign() throws RecognitionException {
		Int_signContext _localctx = new Int_signContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_int_sign);
		try {
			setState(303);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301); match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302); match(MINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literContext extends ParserRuleContext {
		public Bool_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_liter; }
	 
		public Bool_literContext() { }
		public void copyFrom(Bool_literContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TrueContext extends Bool_literContext {
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public TrueContext(Bool_literContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends Bool_literContext {
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
		public FalseContext(Bool_literContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literContext bool_liter() throws RecognitionException {
		Bool_literContext _localctx = new Bool_literContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bool_liter);
		try {
			setState(307);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305); match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306); match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public Char_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literContext char_liter() throws RecognitionException {
		Char_literContext _localctx = new Char_literContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_char_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309); match(CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Str_literContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public Str_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStr_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Str_literContext str_liter() throws RecognitionException {
		Str_literContext _localctx = new Str_literContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_str_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_literContext extends ParserRuleContext {
		public ExprContext expr;
		public List<ExprContext> elems = new ArrayList<ExprContext>();
		public TerminalNode OPEN_SQUARE() { return getToken(BasicParser.OPEN_SQUARE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public TerminalNode CLOSE_SQUARE() { return getToken(BasicParser.CLOSE_SQUARE, 0); }
		public Array_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArray_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(OPEN_SQUARE);
			setState(322);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (OPEN_PARENTHESES - 1)) | (1L << (EXCLAMATION_MARK - 1)) | (1L << (LEN - 1)) | (1L << (ORD - 1)) | (1L << (CHR - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (CHAR - 1)) | (1L << (STRING - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (NULL - 1)) | (1L << (ID - 1)) | (1L << (DIGIT - 1)))) != 0)) {
				{
				setState(314); ((Array_literContext)_localctx).expr = expr(0);
				((Array_literContext)_localctx).elems.add(((Array_literContext)_localctx).expr);
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(315); match(COMMA);
					setState(316); ((Array_literContext)_localctx).expr = expr(0);
					((Array_literContext)_localctx).elems.add(((Array_literContext)_localctx).expr);
					}
					}
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(324); match(CLOSE_SQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_literContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(BasicParser.NULL, 0); }
		public Pair_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_literContext pair_liter() throws RecognitionException {
		Pair_literContext _localctx = new Pair_literContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pair_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 10: return array_type_sempred((Array_typeContext)_localctx, predIndex);
		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 5);
		case 5: return precpred(_ctx, 4);
		case 6: return precpred(_ctx, 3);
		case 7: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean array_type_sempred(Array_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u014b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\7\2?\n\2\f\2"+
		"\16\2B\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4R\n\4\f\4\16\4U\13\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6\u008a\n\6\3\6\3\6\3\6\7\6\u008f\n\6\f\6\16\6\u0092"+
		"\13\6\3\7\3\7\3\7\5\7\u0097\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00a9\n\b\f\b\16\b\u00ac\13\b\5\b\u00ae"+
		"\n\b\3\b\3\b\5\b\u00b2\n\b\3\t\3\t\3\t\5\t\u00b7\n\t\3\t\3\t\3\t\5\t\u00bc"+
		"\n\t\5\t\u00be\n\t\3\n\3\n\3\n\5\n\u00c3\n\n\3\13\3\13\3\13\3\13\5\13"+
		"\u00c9\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d4\n\f\3\f\3\f"+
		"\3\f\7\f\u00d9\n\f\f\f\16\f\u00dc\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\5\16\u00e9\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00f8\n\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u010c"+
		"\n\17\f\17\16\17\u010f\13\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u0119\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u0122\n\23\r\23"+
		"\16\23\u0123\3\24\5\24\u0127\n\24\3\24\6\24\u012a\n\24\r\24\16\24\u012b"+
		"\3\25\3\25\3\26\3\26\5\26\u0132\n\26\3\27\3\27\5\27\u0136\n\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0140\n\32\f\32\16\32\u0143\13"+
		"\32\5\32\u0145\n\32\3\32\3\32\3\33\3\33\3\33\2\5\n\26\34\34\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\7\3\2=>\3\2)+\3\2,-"+
		"\3\2.\61\3\2\62\63\u016e\29\3\2\2\2\4G\3\2\2\2\6K\3\2\2\2\b]\3\2\2\2\n"+
		"\u0089\3\2\2\2\f\u0096\3\2\2\2\16\u00b1\3\2\2\2\20\u00bd\3\2\2\2\22\u00c2"+
		"\3\2\2\2\24\u00c8\3\2\2\2\26\u00d3\3\2\2\2\30\u00dd\3\2\2\2\32\u00e8\3"+
		"\2\2\2\34\u00f7\3\2\2\2\36\u0110\3\2\2\2 \u0118\3\2\2\2\"\u011a\3\2\2"+
		"\2$\u011c\3\2\2\2&\u0126\3\2\2\2(\u012d\3\2\2\2*\u0131\3\2\2\2,\u0135"+
		"\3\2\2\2.\u0137\3\2\2\2\60\u0139\3\2\2\2\62\u013b\3\2\2\2\64\u0148\3\2"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2"+
		"\2;9\3\2\2\2<@\7\t\2\2=?\5\6\4\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2AC\3\2\2\2B@\3\2\2\2CD\5\n\6\2DE\7\n\2\2EF\7\2\2\3F\3\3\2\2\2GH\7\5"+
		"\2\2HI\t\2\2\2IJ\7\31\2\2J\5\3\2\2\2KL\5\22\n\2LM\5\"\22\2MV\7\3\2\2N"+
		"S\5\b\5\2OP\7\6\2\2PR\5\b\5\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"TW\3\2\2\2US\3\2\2\2VN\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\4\2\2YZ\7\13\2"+
		"\2Z[\5\n\6\2[\\\7\n\2\2\\\7\3\2\2\2]^\5\22\n\2^_\5\"\22\2_\t\3\2\2\2`"+
		"a\b\6\1\2a\u008a\7\7\2\2bc\5\22\n\2cd\5\"\22\2de\7\b\2\2ef\5\16\b\2f\u008a"+
		"\3\2\2\2gh\5\f\7\2hi\7\b\2\2ij\5\16\b\2j\u008a\3\2\2\2kl\7\f\2\2l\u008a"+
		"\5\f\7\2mn\7\r\2\2n\u008a\5\34\17\2op\7\16\2\2p\u008a\5\34\17\2qr\7\17"+
		"\2\2r\u008a\5\34\17\2st\7\20\2\2t\u008a\5\34\17\2uv\7\21\2\2v\u008a\5"+
		"\34\17\2wx\7\22\2\2xy\5\34\17\2yz\7\23\2\2z{\5\n\6\2{|\7\24\2\2|}\5\n"+
		"\6\2}~\7\25\2\2~\u008a\3\2\2\2\177\u0080\7\26\2\2\u0080\u0081\5\34\17"+
		"\2\u0081\u0082\7\27\2\2\u0082\u0083\5\n\6\2\u0083\u0084\7\30\2\2\u0084"+
		"\u008a\3\2\2\2\u0085\u0086\7\t\2\2\u0086\u0087\5\n\6\2\u0087\u0088\7\n"+
		"\2\2\u0088\u008a\3\2\2\2\u0089`\3\2\2\2\u0089b\3\2\2\2\u0089g\3\2\2\2"+
		"\u0089k\3\2\2\2\u0089m\3\2\2\2\u0089o\3\2\2\2\u0089q\3\2\2\2\u0089s\3"+
		"\2\2\2\u0089u\3\2\2\2\u0089w\3\2\2\2\u0089\177\3\2\2\2\u0089\u0085\3\2"+
		"\2\2\u008a\u0090\3\2\2\2\u008b\u008c\f\3\2\2\u008c\u008d\7\31\2\2\u008d"+
		"\u008f\5\n\6\4\u008e\u008b\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\13\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0097"+
		"\5\"\22\2\u0094\u0097\5$\23\2\u0095\u0097\5\20\t\2\u0096\u0093\3\2\2\2"+
		"\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\r\3\2\2\2\u0098\u00b2\5"+
		"\34\17\2\u0099\u00b2\5\62\32\2\u009a\u009b\7\32\2\2\u009b\u009c\7\3\2"+
		"\2\u009c\u009d\5\34\17\2\u009d\u009e\7\6\2\2\u009e\u009f\5\34\17\2\u009f"+
		"\u00a0\7\4\2\2\u00a0\u00b2\3\2\2\2\u00a1\u00b2\5\20\t\2\u00a2\u00a3\7"+
		"\33\2\2\u00a3\u00a4\5\"\22\2\u00a4\u00ad\7\3\2\2\u00a5\u00aa\5\34\17\2"+
		"\u00a6\u00a7\7\6\2\2\u00a7\u00a9\5\34\17\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b2\3\2\2\2\u00b1\u0098\3\2\2\2\u00b1"+
		"\u0099\3\2\2\2\u00b1\u009a\3\2\2\2\u00b1\u00a1\3\2\2\2\u00b1\u00a2\3\2"+
		"\2\2\u00b2\17\3\2\2\2\u00b3\u00b6\7\34\2\2\u00b4\u00b7\5\34\17\2\u00b5"+
		"\u00b7\5\20\t\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00be\3"+
		"\2\2\2\u00b8\u00bb\7\35\2\2\u00b9\u00bc\5\34\17\2\u00ba\u00bc\5\20\t\2"+
		"\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b3"+
		"\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be\21\3\2\2\2\u00bf\u00c3\5\24\13\2\u00c0"+
		"\u00c3\5\26\f\2\u00c1\u00c3\5\30\r\2\u00c2\u00bf\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\23\3\2\2\2\u00c4\u00c9\7\36\2\2\u00c5"+
		"\u00c9\7\37\2\2\u00c6\u00c9\7 \2\2\u00c7\u00c9\7!\2\2\u00c8\u00c4\3\2"+
		"\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\25\3\2\2\2\u00ca\u00cb\b\f\1\2\u00cb\u00cc\5\24\13\2\u00cc\u00cd\7\""+
		"\2\2\u00cd\u00ce\7#\2\2\u00ce\u00d4\3\2\2\2\u00cf\u00d0\5\30\r\2\u00d0"+
		"\u00d1\7\"\2\2\u00d1\u00d2\7#\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00ca\3\2"+
		"\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00da\3\2\2\2\u00d5\u00d6\f\3\2\2\u00d6"+
		"\u00d7\7\"\2\2\u00d7\u00d9\7#\2\2\u00d8\u00d5\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\27\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dd\u00de\7$\2\2\u00de\u00df\7\3\2\2\u00df\u00e0\5\32\16\2"+
		"\u00e0\u00e1\7\6\2\2\u00e1\u00e2\5\32\16\2\u00e2\u00e3\7\4\2\2\u00e3\31"+
		"\3\2\2\2\u00e4\u00e9\5\24\13\2\u00e5\u00e9\5\26\f\2\u00e6\u00e9\7$\2\2"+
		"\u00e7\u00e9\5\30\r\2\u00e8\u00e4\3\2\2\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\33\3\2\2\2\u00ea\u00eb\b\17\1\2\u00eb"+
		"\u00f8\5&\24\2\u00ec\u00f8\5,\27\2\u00ed\u00f8\5.\30\2\u00ee\u00f8\5\60"+
		"\31\2\u00ef\u00f8\5\64\33\2\u00f0\u00f8\5\"\22\2\u00f1\u00f8\5$\23\2\u00f2"+
		"\u00f8\5\36\20\2\u00f3\u00f4\7\3\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6"+
		"\7\4\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00ea\3\2\2\2\u00f7\u00ec\3\2\2\2\u00f7"+
		"\u00ed\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f0\3\2"+
		"\2\2\u00f7\u00f1\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8"+
		"\u010d\3\2\2\2\u00f9\u00fa\f\t\2\2\u00fa\u00fb\t\3\2\2\u00fb\u010c\5\34"+
		"\17\n\u00fc\u00fd\f\b\2\2\u00fd\u00fe\t\4\2\2\u00fe\u010c\5\34\17\t\u00ff"+
		"\u0100\f\7\2\2\u0100\u0101\t\5\2\2\u0101\u010c\5\34\17\b\u0102\u0103\f"+
		"\6\2\2\u0103\u0104\t\6\2\2\u0104\u010c\5\34\17\7\u0105\u0106\f\5\2\2\u0106"+
		"\u0107\7\64\2\2\u0107\u010c\5\34\17\6\u0108\u0109\f\4\2\2\u0109\u010a"+
		"\7\65\2\2\u010a\u010c\5\34\17\5\u010b\u00f9\3\2\2\2\u010b\u00fc\3\2\2"+
		"\2\u010b\u00ff\3\2\2\2\u010b\u0102\3\2\2\2\u010b\u0105\3\2\2\2\u010b\u0108"+
		"\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\35\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\5 \21\2\u0111\u0112\5\34\17"+
		"\2\u0112\37\3\2\2\2\u0113\u0119\7%\2\2\u0114\u0119\7-\2\2\u0115\u0119"+
		"\7&\2\2\u0116\u0119\7\'\2\2\u0117\u0119\7(\2\2\u0118\u0113\3\2\2\2\u0118"+
		"\u0114\3\2\2\2\u0118\u0115\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2"+
		"\2\2\u0119!\3\2\2\2\u011a\u011b\7=\2\2\u011b#\3\2\2\2\u011c\u0121\5\""+
		"\22\2\u011d\u011e\7\"\2\2\u011e\u011f\5\34\17\2\u011f\u0120\7#\2\2\u0120"+
		"\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124%\3\2\2\2\u0125\u0127\5*\26\2\u0126\u0125"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u012a\5(\25\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\'\3\2\2\2\u012d\u012e\7B\2\2\u012e)\3\2\2\2\u012f\u0132\7,"+
		"\2\2\u0130\u0132\7-\2\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2\2\2\u0132"+
		"+\3\2\2\2\u0133\u0136\7:\2\2\u0134\u0136\7;\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0134\3\2\2\2\u0136-\3\2\2\2\u0137\u0138\7\66\2\2\u0138/\3\2\2\2\u0139"+
		"\u013a\7\67\2\2\u013a\61\3\2\2\2\u013b\u0144\7\"\2\2\u013c\u0141\5\34"+
		"\17\2\u013d\u013e\7\6\2\2\u013e\u0140\5\34\17\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0144\u013c\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0147\7#\2\2\u0147\63\3\2\2\2\u0148\u0149\7<\2\2"+
		"\u0149\65\3\2\2\2\379@SV\u0089\u0090\u0096\u00aa\u00ad\u00b1\u00b6\u00bb"+
		"\u00bd\u00c2\u00c8\u00d3\u00da\u00e8\u00f7\u010b\u010d\u0118\u0123\u0126"+
		"\u012b\u0131\u0135\u0141\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}