lexer grammar BasicLexer;

OPEN_PARENTHESES  : '(' ;
CLOSE_PARENTHESES : ')' ;

IMPORT : 'import';

COMMA : ',' ;
SKIP  : 'skip' ;

EQUAL : '=' ;

BEGIN    : 'begin';
END: 'end' ;

IS   : 'is';

READ : 'read' ;
FREE : 'free' ;

RETURN : 'return' ;

EXIT : 'exit' ;

PRINT : 'print' ;

PRINTLN : 'println' ;

IF : 'if' ;

THEN : 'then' ;

ELSE : 'else' ;

FI : 'fi' ;

WHILE : 'while' ;

DO : 'do' ;

DONE : 'done' ;

SEMI_COLON : ';' ;

NEWPAIR : 'newpair' ;

CALL : 'call' ;

FST : 'fst' ;
SND : 'snd' ;

INT_TYPE  : 'int' ;
BOOL_TYPE : 'bool' ; 
CHAR_TYPE : 'char' ;
STRING_TYPE: 'string' ;

OPEN_SQUARE : '[' ;
CLOSE_SQUARE : ']' ;

PAIR : 'pair' ;

EXCLAMATION_MARK : '!' ;
LEN : 'len' ;
ORD : 'ord' ;
CHR : 'chr' ;

MUL : '*';
DIV : '/';
MOD : '%';
PLUS : '+';
MINUS : '-';
GREATER_THAN: '>';
GREATER_OR_EQUAL: '>=';
SMALLER_THAN: '<';
SMALLER_OR_EQUAL: '<=';
EQUALS_EQUALS: '==';
NOT_EQUALS: '!=';
LOGICAL_AND: '&&'; 
LOGICAL_OR: '||';

CHAR : '\'' ( ~('\\'|'\''|'"') | ('\\' ('0'|'b'|'r'|'n'|'t'|'f'|'\\'|'"'|'\'')) ) '\'' ;
STRING : '"' ( ~('\\'|'\''|'"') | ('\\' ('0'|'b'|'r'|'n'|'t'|'f'|'\\'|'"'|'\'')) )* '"' ;
// STRING : '"' ( ~('\\'|'\''|'"') | ('\\' 'r') )* '"' ;

COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip ;

WS : [ \n\t\r]+ -> skip;

TRUE : 'true' ;

FALSE : 'false' ;

NULL : 'null' ;

ID: [a-zA-Z_] [a-zA-Z_0-9]* ;

LIBNAME: [a-zA-Z_] [a-zA-Z_0-9.]* ;

UNDERSCORE : '_';

LOWERCASE : ('a'..'z');

UPPERCASE : ('A'..'Z');

DIGIT : ('0'..'9') ;
