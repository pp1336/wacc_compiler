parser grammar BasicParser ; 


options {
  tokenVocab=BasicLexer ;
}

program		: (importlib)* BEGIN (funcs+=function)* body=stat END EOF;

importlib   : IMPORT id=(LIBNAME | ID) SEMI_COLON;


function	: t=type id=ident OPEN_PARENTHESES 
                  (params+=param (COMMA params+=param)*)? 
		  CLOSE_PARENTHESES IS body=stat END ; 

param		: t=type id=ident ; 

stat		:  SKIP						#SkipStmt
		| t=type id=ident EQUAL rhs=assign_rhs		#VarDeclAssnStmt
		| lhs=assign_lhs EQUAL rhs=assign_rhs		#AssignmentStmt
		| READ lhs=assign_lhs				#ReadStmt
		| FREE child=expr				#FreeStmt
		| RETURN child=expr				#ReturnStmt
		| EXIT child=expr				#ExitStmt
		| PRINT child=expr				#PrintStmt
		| PRINTLN child=expr				#PrintLnStmt
		| IF cond=expr THEN ifbranch=stat 
		  ELSE elsebranch=stat FI			#IfStmt
		| WHILE cond=expr DO body=stat DONE 		#WhileStmt
		| BEGIN body=stat END 				#BeginStmt
		| head=stat SEMI_COLON tail=stat 		#CompoundStmt 
		; 

assign_lhs	: id=ident 					#lhsVarRefExpr 
		| elem=array_elem 				#lhsArrayVarIndexRefExpr 
		| elem=pair_elem 				#lhsPairVarRefExpr 
		; 

assign_rhs	:  value=expr 					#rhsExpr                        
		| value=array_liter  				#rhsArrayLiterExpr
		| NEWPAIR OPEN_PARENTHESES valueLhs=expr 
		  COMMA valueRhs=expr CLOSE_PARENTHESES		#rhsNewPairExpr
		| value=pair_elem  				#rhsPairVarRefExpr
		| CALL id=ident OPEN_PARENTHESES 
                  (args+=expr (COMMA args+=expr)*)?
		  CLOSE_PARENTHESES  				#rhsCallExpr
		;

pair_elem	: FST (expr | pair_elem)				#pairElemFst 
		| SND (expr | pair_elem)				#pairElemSnd 
		; 

type		: base_type 					#typeBaseType 
		| array_type 					#typeArrayType 
		| pair_type 					#typePairType
		; 

base_type	: INT_TYPE     #intType
		| BOOL_TYPE     #boolType
		| CHAR_TYPE     #charType
		| STRING_TYPE    #stringType
		; 

array_type	: innerType=base_type  OPEN_SQUARE CLOSE_SQUARE	#arrayTypeBaseType
		| innerType=pair_type OPEN_SQUARE CLOSE_SQUARE	#arrayElemTypePairType
		| innerType=array_type OPEN_SQUARE CLOSE_SQUARE	#arrayElemTypeArrayType; 

pair_type	: PAIR OPEN_PARENTHESES fstType=pair_elem_type 
		  COMMA  sndType=pair_elem_type CLOSE_PARENTHESES ; 

pair_elem_type	: base_type 					#pairElemTypeBaseType 
		| array_type 					#pairElemTypeArrayType 
  | PAIR 						#pairElemTypePairType
  | pair_type					#pairElemTypeFullPairType
  ; 

expr		: int_liter					#exprIntLitrExpr
		| bool_liter 					#exprBoolLitrExpr
		| char_liter 					#exprCharLitrExpr
		| str_liter  					#exprStringLitrExpr
		| pair_liter 					#exprPairLitrExpr
		| ident      					#exprVarRefExpr
		| array_elem 					#exprArrayVarIndexRefExpr
		| unary_exp 			#exprUnaryOperatorExpr 
		| lhs=expr op=(MUL | DIV | MOD) rhs=expr		#exprBinaryOperatorExprPrec1
        | lhs=expr op=(PLUS | MINUS) rhs=expr #exprBinaryOperatorExprPrec2
        | lhs=expr op=(GREATER_THAN | GREATER_OR_EQUAL | SMALLER_THAN | SMALLER_OR_EQUAL) rhs=expr #exprBinaryOperatorExprPrec3
        | lhs=expr op=(EQUALS_EQUALS | NOT_EQUALS) rhs=expr #exprBinaryOperatorExprPrec4
        | lhs=expr LOGICAL_AND rhs=expr #exprBinaryOperatorExprPrec5
        | lhs=expr LOGICAL_OR rhs=expr #exprBinaryOperatorExprPrec6
		| OPEN_PARENTHESES body=expr CLOSE_PARENTHESES	#exprBracketedExpr ;  

unary_exp : unary_oper operand=expr;

unary_oper	: EXCLAMATION_MARK    #exclamation
		| MINUS  #unMinus
		| LEN    #len
		| ORD    #ord
		| CHR    #chr
		; 

ident		: ID ; 

array_elem	: id=ident (OPEN_SQUARE expr CLOSE_SQUARE)+ ;  

int_liter	: int_sign? (digit)+ ;  

digit		: DIGIT ; 

int_sign	: PLUS 						#Plus
		| MINUS 					#Minus
		; 

bool_liter	: TRUE 						#True 
		| FALSE 					#False	
		; 

char_liter	: CHAR ; 

str_liter	: STRING ; 

array_liter	: OPEN_SQUARE (elems+=expr (COMMA elems+=expr)*)? CLOSE_SQUARE ; 

pair_liter	: NULL ;  
