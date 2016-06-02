// Generated from ./BasicParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code typeArrayType}
	 * labeled alternative in {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArrayType(@NotNull BasicParser.TypeArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(@NotNull BasicParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link BasicParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull BasicParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsCallExpr}
	 * labeled alternative in {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsCallExpr(@NotNull BasicParser.RhsCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintLnStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLnStmt(@NotNull BasicParser.PrintLnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link BasicParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull BasicParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsExpr}
	 * labeled alternative in {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsExpr(@NotNull BasicParser.RhsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link BasicParser#bool_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(@NotNull BasicParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(@NotNull BasicParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BeginStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginStmt(@NotNull BasicParser.BeginStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull BasicParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCharLitrExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCharLitrExpr(@NotNull BasicParser.ExprCharLitrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unMinus}
	 * labeled alternative in {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnMinus(@NotNull BasicParser.UnMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsPairVarRefExpr}
	 * labeled alternative in {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsPairVarRefExpr(@NotNull BasicParser.RhsPairVarRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lhsVarRefExpr}
	 * labeled alternative in {@link BasicParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhsVarRefExpr(@NotNull BasicParser.LhsVarRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclamation}
	 * labeled alternative in {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclamation(@NotNull BasicParser.ExclamationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVarRefExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVarRefExpr(@NotNull BasicParser.ExprVarRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemTypeArrayType}
	 * labeled alternative in {@link BasicParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemTypeArrayType(@NotNull BasicParser.PairElemTypeArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(@NotNull BasicParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(@NotNull BasicParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(@NotNull BasicParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull BasicParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemSnd}
	 * labeled alternative in {@link BasicParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemSnd(@NotNull BasicParser.PairElemSndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec5}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec5(@NotNull BasicParser.ExprBinaryOperatorExprPrec5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec6}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec6(@NotNull BasicParser.ExprBinaryOperatorExprPrec6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec3}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec3(@NotNull BasicParser.ExprBinaryOperatorExprPrec3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec4}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec4(@NotNull BasicParser.ExprBinaryOperatorExprPrec4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec1}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec1(@NotNull BasicParser.ExprBinaryOperatorExprPrec1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinaryOperatorExprPrec2}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryOperatorExprPrec2(@NotNull BasicParser.ExprBinaryOperatorExprPrec2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElemTypeArrayType}
	 * labeled alternative in {@link BasicParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElemTypeArrayType(@NotNull BasicParser.ArrayElemTypeArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FreeStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreeStmt(@NotNull BasicParser.FreeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(@NotNull BasicParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull BasicParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIntLitrExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIntLitrExpr(@NotNull BasicParser.ExprIntLitrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#array_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_elem(@NotNull BasicParser.Array_elemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExitStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStmt(@NotNull BasicParser.ExitStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPairLitrExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPairLitrExpr(@NotNull BasicParser.ExprPairLitrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#char_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_liter(@NotNull BasicParser.Char_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BasicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link BasicParser#bool_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(@NotNull BasicParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#int_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_liter(@NotNull BasicParser.Int_literContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lhsArrayVarIndexRefExpr}
	 * labeled alternative in {@link BasicParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhsArrayVarIndexRefExpr(@NotNull BasicParser.LhsArrayVarIndexRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chr}
	 * labeled alternative in {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChr(@NotNull BasicParser.ChrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArrayVarIndexRefExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArrayVarIndexRefExpr(@NotNull BasicParser.ExprArrayVarIndexRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBaseType}
	 * labeled alternative in {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBaseType(@NotNull BasicParser.TypeBaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemTypeBaseType}
	 * labeled alternative in {@link BasicParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemTypeBaseType(@NotNull BasicParser.PairElemTypeBaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_liter(@NotNull BasicParser.Pair_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull BasicParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ord}
	 * labeled alternative in {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrd(@NotNull BasicParser.OrdContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull BasicParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemFst}
	 * labeled alternative in {@link BasicParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemFst(@NotNull BasicParser.PairElemFstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclAssnStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclAssnStmt(@NotNull BasicParser.VarDeclAssnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBracketedExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBracketedExpr(@NotNull BasicParser.ExprBracketedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link BasicParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(@NotNull BasicParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link BasicParser#int_sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(@NotNull BasicParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link BasicParser#int_sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(@NotNull BasicParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElemTypePairType}
	 * labeled alternative in {@link BasicParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElemTypePairType(@NotNull BasicParser.ArrayElemTypePairTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsNewPairExpr}
	 * labeled alternative in {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsNewPairExpr(@NotNull BasicParser.RhsNewPairExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemTypePairType}
	 * labeled alternative in {@link BasicParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemTypePairType(@NotNull BasicParser.PairElemTypePairTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code len}
	 * labeled alternative in {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLen(@NotNull BasicParser.LenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsArrayLiterExpr}
	 * labeled alternative in {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsArrayLiterExpr(@NotNull BasicParser.RhsArrayLiterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeBaseType}
	 * labeled alternative in {@link BasicParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeBaseType(@NotNull BasicParser.ArrayTypeBaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_type(@NotNull BasicParser.Pair_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#str_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_liter(@NotNull BasicParser.Str_literContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lhsPairVarRefExpr}
	 * labeled alternative in {@link BasicParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhsPairVarRefExpr(@NotNull BasicParser.LhsPairVarRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typePairType}
	 * labeled alternative in {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePairType(@NotNull BasicParser.TypePairTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairElemTypeFullPairType}
	 * labeled alternative in {@link BasicParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemTypeFullPairType(@NotNull BasicParser.PairElemTypeFullPairTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipStmt}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStmt(@NotNull BasicParser.SkipStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBoolLitrExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBoolLitrExpr(@NotNull BasicParser.ExprBoolLitrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link BasicParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull BasicParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#unary_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_exp(@NotNull BasicParser.Unary_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#array_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_liter(@NotNull BasicParser.Array_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#importlib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportlib(@NotNull BasicParser.ImportlibContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStringLitrExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStringLitrExpr(@NotNull BasicParser.ExprStringLitrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnaryOperatorExpr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaryOperatorExpr(@NotNull BasicParser.ExprUnaryOperatorExprContext ctx);
}