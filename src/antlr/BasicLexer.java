// Generated from ./BasicLexer.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_PARENTHESES=1, CLOSE_PARENTHESES=2, IMPORT=3, COMMA=4, SKIP=5, EQUAL=6, 
		BEGIN=7, END=8, IS=9, READ=10, FREE=11, RETURN=12, EXIT=13, PRINT=14, 
		PRINTLN=15, IF=16, THEN=17, ELSE=18, FI=19, WHILE=20, DO=21, DONE=22, 
		SEMI_COLON=23, NEWPAIR=24, CALL=25, FST=26, SND=27, INT_TYPE=28, BOOL_TYPE=29, 
		CHAR_TYPE=30, STRING_TYPE=31, OPEN_SQUARE=32, CLOSE_SQUARE=33, PAIR=34, 
		EXCLAMATION_MARK=35, LEN=36, ORD=37, CHR=38, MUL=39, DIV=40, MOD=41, PLUS=42, 
		MINUS=43, GREATER_THAN=44, GREATER_OR_EQUAL=45, SMALLER_THAN=46, SMALLER_OR_EQUAL=47, 
		EQUALS_EQUALS=48, NOT_EQUALS=49, LOGICAL_AND=50, LOGICAL_OR=51, CHAR=52, 
		STRING=53, COMMENT=54, WS=55, TRUE=56, FALSE=57, NULL=58, ID=59, LIBNAME=60, 
		UNDERSCORE=61, LOWERCASE=62, UPPERCASE=63, DIGIT=64;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'"
	};
	public static final String[] ruleNames = {
		"OPEN_PARENTHESES", "CLOSE_PARENTHESES", "IMPORT", "COMMA", "SKIP", "EQUAL", 
		"BEGIN", "END", "IS", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
		"IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "SEMI_COLON", "NEWPAIR", 
		"CALL", "FST", "SND", "INT_TYPE", "BOOL_TYPE", "CHAR_TYPE", "STRING_TYPE", 
		"OPEN_SQUARE", "CLOSE_SQUARE", "PAIR", "EXCLAMATION_MARK", "LEN", "ORD", 
		"CHR", "MUL", "DIV", "MOD", "PLUS", "MINUS", "GREATER_THAN", "GREATER_OR_EQUAL", 
		"SMALLER_THAN", "SMALLER_OR_EQUAL", "EQUALS_EQUALS", "NOT_EQUALS", "LOGICAL_AND", 
		"LOGICAL_OR", "CHAR", "STRING", "COMMENT", "WS", "TRUE", "FALSE", "NULL", 
		"ID", "LIBNAME", "UNDERSCORE", "LOWERCASE", "UPPERCASE", "DIGIT"
	};


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2B\u0197\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\5\65\u014e"+
		"\n\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0156\n\66\f\66\16\66\u0159\13"+
		"\66\3\66\3\66\3\67\3\67\7\67\u015f\n\67\f\67\16\67\u0162\13\67\3\67\5"+
		"\67\u0165\n\67\3\67\3\67\3\67\3\67\38\68\u016c\n8\r8\168\u016d\38\38\3"+
		"9\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\7<\u0184\n<\f<\16"+
		"<\u0187\13<\3=\3=\7=\u018b\n=\f=\16=\u018e\13=\3>\3>\3?\3?\3@\3@\3A\3"+
		"A\2\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66"+
		"k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\3\2\t\5\2$$))^^\13\2$$))\62\62^^dd"+
		"hhppttvv\4\2\f\f\17\17\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\7"+
		"\2\60\60\62;C\\aac|\u019e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\3\u0083\3\2\2\2\5\u0085\3\2\2\2\7\u0087\3\2\2\2\t\u008e\3\2\2\2\13"+
		"\u0090\3\2\2\2\r\u0095\3\2\2\2\17\u0097\3\2\2\2\21\u009d\3\2\2\2\23\u00a1"+
		"\3\2\2\2\25\u00a4\3\2\2\2\27\u00a9\3\2\2\2\31\u00ae\3\2\2\2\33\u00b5\3"+
		"\2\2\2\35\u00ba\3\2\2\2\37\u00c0\3\2\2\2!\u00c8\3\2\2\2#\u00cb\3\2\2\2"+
		"%\u00d0\3\2\2\2\'\u00d5\3\2\2\2)\u00d8\3\2\2\2+\u00de\3\2\2\2-\u00e1\3"+
		"\2\2\2/\u00e6\3\2\2\2\61\u00e8\3\2\2\2\63\u00f0\3\2\2\2\65\u00f5\3\2\2"+
		"\2\67\u00f9\3\2\2\29\u00fd\3\2\2\2;\u0101\3\2\2\2=\u0106\3\2\2\2?\u010b"+
		"\3\2\2\2A\u0112\3\2\2\2C\u0114\3\2\2\2E\u0116\3\2\2\2G\u011b\3\2\2\2I"+
		"\u011d\3\2\2\2K\u0121\3\2\2\2M\u0125\3\2\2\2O\u0129\3\2\2\2Q\u012b\3\2"+
		"\2\2S\u012d\3\2\2\2U\u012f\3\2\2\2W\u0131\3\2\2\2Y\u0133\3\2\2\2[\u0135"+
		"\3\2\2\2]\u0138\3\2\2\2_\u013a\3\2\2\2a\u013d\3\2\2\2c\u0140\3\2\2\2e"+
		"\u0143\3\2\2\2g\u0146\3\2\2\2i\u0149\3\2\2\2k\u0151\3\2\2\2m\u015c\3\2"+
		"\2\2o\u016b\3\2\2\2q\u0171\3\2\2\2s\u0176\3\2\2\2u\u017c\3\2\2\2w\u0181"+
		"\3\2\2\2y\u0188\3\2\2\2{\u018f\3\2\2\2}\u0191\3\2\2\2\177\u0193\3\2\2"+
		"\2\u0081\u0195\3\2\2\2\u0083\u0084\7*\2\2\u0084\4\3\2\2\2\u0085\u0086"+
		"\7+\2\2\u0086\6\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7o\2\2\u0089\u008a"+
		"\7r\2\2\u008a\u008b\7q\2\2\u008b\u008c\7t\2\2\u008c\u008d\7v\2\2\u008d"+
		"\b\3\2\2\2\u008e\u008f\7.\2\2\u008f\n\3\2\2\2\u0090\u0091\7u\2\2\u0091"+
		"\u0092\7m\2\2\u0092\u0093\7k\2\2\u0093\u0094\7r\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7?\2\2\u0096\16\3\2\2\2\u0097\u0098\7d\2\2\u0098\u0099\7g\2\2\u0099"+
		"\u009a\7i\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\20\3\2\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7f\2\2\u00a0\22\3\2\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7u\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7f\2\2\u00a8\26\3\2\2\2\u00a9"+
		"\u00aa\7h\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7g\2\2"+
		"\u00ad\30\3\2\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7"+
		"v\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7p\2\2\u00b4\32"+
		"\3\2\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7z\2\2\u00b7\u00b8\7k\2\2\u00b8"+
		"\u00b9\7v\2\2\u00b9\34\3\2\2\2\u00ba\u00bb\7r\2\2\u00bb\u00bc\7t\2\2\u00bc"+
		"\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7v\2\2\u00bf\36\3\2\2\2\u00c0"+
		"\u00c1\7r\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2"+
		"\u00c4\u00c5\7v\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7p\2\2\u00c7 \3\2\2"+
		"\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7h\2\2\u00ca\"\3\2\2\2\u00cb\u00cc\7"+
		"v\2\2\u00cc\u00cd\7j\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7p\2\2\u00cf$"+
		"\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7u\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4&\3\2\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7k\2\2\u00d7"+
		"(\3\2\2\2\u00d8\u00d9\7y\2\2\u00d9\u00da\7j\2\2\u00da\u00db\7k\2\2\u00db"+
		"\u00dc\7n\2\2\u00dc\u00dd\7g\2\2\u00dd*\3\2\2\2\u00de\u00df\7f\2\2\u00df"+
		"\u00e0\7q\2\2\u00e0,\3\2\2\2\u00e1\u00e2\7f\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\u00e4\7p\2\2\u00e4\u00e5\7g\2\2\u00e5.\3\2\2\2\u00e6\u00e7\7=\2\2\u00e7"+
		"\60\3\2\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7y\2\2\u00eb"+
		"\u00ec\7r\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7t\2\2"+
		"\u00ef\62\3\2\2\2\u00f0\u00f1\7e\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7"+
		"n\2\2\u00f3\u00f4\7n\2\2\u00f4\64\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7"+
		"\7u\2\2\u00f7\u00f8\7v\2\2\u00f8\66\3\2\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb"+
		"\7p\2\2\u00fb\u00fc\7f\2\2\u00fc8\3\2\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff"+
		"\7p\2\2\u00ff\u0100\7v\2\2\u0100:\3\2\2\2\u0101\u0102\7d\2\2\u0102\u0103"+
		"\7q\2\2\u0103\u0104\7q\2\2\u0104\u0105\7n\2\2\u0105<\3\2\2\2\u0106\u0107"+
		"\7e\2\2\u0107\u0108\7j\2\2\u0108\u0109\7c\2\2\u0109\u010a\7t\2\2\u010a"+
		">\3\2\2\2\u010b\u010c\7u\2\2\u010c\u010d\7v\2\2\u010d\u010e\7t\2\2\u010e"+
		"\u010f\7k\2\2\u010f\u0110\7p\2\2\u0110\u0111\7i\2\2\u0111@\3\2\2\2\u0112"+
		"\u0113\7]\2\2\u0113B\3\2\2\2\u0114\u0115\7_\2\2\u0115D\3\2\2\2\u0116\u0117"+
		"\7r\2\2\u0117\u0118\7c\2\2\u0118\u0119\7k\2\2\u0119\u011a\7t\2\2\u011a"+
		"F\3\2\2\2\u011b\u011c\7#\2\2\u011cH\3\2\2\2\u011d\u011e\7n\2\2\u011e\u011f"+
		"\7g\2\2\u011f\u0120\7p\2\2\u0120J\3\2\2\2\u0121\u0122\7q\2\2\u0122\u0123"+
		"\7t\2\2\u0123\u0124\7f\2\2\u0124L\3\2\2\2\u0125\u0126\7e\2\2\u0126\u0127"+
		"\7j\2\2\u0127\u0128\7t\2\2\u0128N\3\2\2\2\u0129\u012a\7,\2\2\u012aP\3"+
		"\2\2\2\u012b\u012c\7\61\2\2\u012cR\3\2\2\2\u012d\u012e\7\'\2\2\u012eT"+
		"\3\2\2\2\u012f\u0130\7-\2\2\u0130V\3\2\2\2\u0131\u0132\7/\2\2\u0132X\3"+
		"\2\2\2\u0133\u0134\7@\2\2\u0134Z\3\2\2\2\u0135\u0136\7@\2\2\u0136\u0137"+
		"\7?\2\2\u0137\\\3\2\2\2\u0138\u0139\7>\2\2\u0139^\3\2\2\2\u013a\u013b"+
		"\7>\2\2\u013b\u013c\7?\2\2\u013c`\3\2\2\2\u013d\u013e\7?\2\2\u013e\u013f"+
		"\7?\2\2\u013fb\3\2\2\2\u0140\u0141\7#\2\2\u0141\u0142\7?\2\2\u0142d\3"+
		"\2\2\2\u0143\u0144\7(\2\2\u0144\u0145\7(\2\2\u0145f\3\2\2\2\u0146\u0147"+
		"\7~\2\2\u0147\u0148\7~\2\2\u0148h\3\2\2\2\u0149\u014d\7)\2\2\u014a\u014e"+
		"\n\2\2\2\u014b\u014c\7^\2\2\u014c\u014e\t\3\2\2\u014d\u014a\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\7)\2\2\u0150j\3\2\2\2\u0151"+
		"\u0157\7$\2\2\u0152\u0156\n\2\2\2\u0153\u0154\7^\2\2\u0154\u0156\t\3\2"+
		"\2\u0155\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u015b\7$\2\2\u015bl\3\2\2\2\u015c\u0160\7%\2\2\u015d\u015f\n\4\2\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0165\7\17\2\2\u0164"+
		"\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\7\f"+
		"\2\2\u0167\u0168\3\2\2\2\u0168\u0169\b\67\2\2\u0169n\3\2\2\2\u016a\u016c"+
		"\t\5\2\2\u016b\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\b8\2\2\u0170p\3\2\2\2\u0171"+
		"\u0172\7v\2\2\u0172\u0173\7t\2\2\u0173\u0174\7w\2\2\u0174\u0175\7g\2\2"+
		"\u0175r\3\2\2\2\u0176\u0177\7h\2\2\u0177\u0178\7c\2\2\u0178\u0179\7n\2"+
		"\2\u0179\u017a\7u\2\2\u017a\u017b\7g\2\2\u017bt\3\2\2\2\u017c\u017d\7"+
		"p\2\2\u017d\u017e\7w\2\2\u017e\u017f\7n\2\2\u017f\u0180\7n\2\2\u0180v"+
		"\3\2\2\2\u0181\u0185\t\6\2\2\u0182\u0184\t\7\2\2\u0183\u0182\3\2\2\2\u0184"+
		"\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186x\3\2\2\2"+
		"\u0187\u0185\3\2\2\2\u0188\u018c\t\6\2\2\u0189\u018b\t\b\2\2\u018a\u0189"+
		"\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"z\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7a\2\2\u0190|\3\2\2\2\u0191"+
		"\u0192\4c|\2\u0192~\3\2\2\2\u0193\u0194\4C\\\2\u0194\u0080\3\2\2\2\u0195"+
		"\u0196\4\62;\2\u0196\u0082\3\2\2\2\13\2\u014d\u0155\u0157\u0160\u0164"+
		"\u016d\u0185\u018c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}