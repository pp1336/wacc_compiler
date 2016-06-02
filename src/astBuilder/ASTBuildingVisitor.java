// Generated from ./BasicParser.g4 by ANTLR 4.4
package astBuilder;

import java.util.ArrayList;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import antlr.BasicParser;
import antlr.BasicParser.BoolTypeContext;
import antlr.BasicParser.CharTypeContext;
import antlr.BasicParser.ChrContext;
import antlr.BasicParser.ExclamationContext;
import antlr.BasicParser.ExprBinaryOperatorExprPrec1Context;
import antlr.BasicParser.ExprBinaryOperatorExprPrec2Context;
import antlr.BasicParser.ExprBinaryOperatorExprPrec3Context;
import antlr.BasicParser.ExprBinaryOperatorExprPrec4Context;
import antlr.BasicParser.ExprBinaryOperatorExprPrec5Context;
import antlr.BasicParser.ExprBinaryOperatorExprPrec6Context;
import antlr.BasicParser.ImportlibContext;
import antlr.BasicParser.IntTypeContext;
import antlr.BasicParser.LenContext;
import antlr.BasicParser.OrdContext;
import antlr.BasicParser.StringTypeContext;
import antlr.BasicParser.UnMinusContext;
import antlr.BasicParser.Unary_expContext;
import antlr.BasicParserVisitor;

import ast.decl.*;
import ast.expr.*;
import ast.expr.rhsexpr.*;
import ast.expr.rhsexpr.lhsexpr.*;
import ast.program.*;
import ast.stmt.*;
import ast.type.*;
import libExten.AstImport;
import ast.*;

/**
 * This class provides an empty implementation of {@link BasicParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T>
 *            The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public class ASTBuildingVisitor extends AbstractParseTreeVisitor<AstNode>
        implements BasicParserVisitor<AstNode> {
    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */

    @Override
    public AstNode visitPairElemTypeFullPairType (
            @NotNull BasicParser.PairElemTypeFullPairTypeContext ctx) {
        return visit(ctx.pair_type());
    }


    @Override
    public AstNode visitTypeArrayType(
            @NotNull BasicParser.TypeArrayTypeContext ctx) {
        return visit(ctx.array_type());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitCompoundStmt(
            @NotNull BasicParser.CompoundStmtContext ctx) {
        return new CompoundStmt((Statement) visit(ctx.head),
                (Statement) visit(ctx.tail));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitRhsCallExpr(@NotNull BasicParser.RhsCallExprContext ctx) {
        List<BasicParser.ExprContext> exprs = ctx.expr();
        List<Expr> exprList = new ArrayList<Expr>();
        for (BasicParser.ExprContext e : exprs) {
            exprList.add((Expr) visit(e));
        }
        return new CallExpr((IdentExpr) visit(ctx.ident()), exprList);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPrintLnStmt(@NotNull BasicParser.PrintLnStmtContext ctx) {
        return new PrintlnStmt((Expr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitRhsExpr(@NotNull BasicParser.RhsExprContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitFalse(@NotNull BasicParser.FalseContext ctx) {
        return new BoolLitrExpr(false);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitAssignmentStmt(
            @NotNull BasicParser.AssignmentStmtContext ctx) {
        LhsExpr lhs = (LhsExpr) visit(ctx.assign_lhs());
        RhsExpr rhs = (RhsExpr) visit(ctx.assign_rhs());
        return new AssignmentStmt(lhs, rhs);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitBeginStmt(@NotNull BasicParser.BeginStmtContext ctx) {
        return new BeginStmt((Statement) visit(ctx.stat()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitFunction(@NotNull BasicParser.FunctionContext ctx) {
        Type returnType = (Type) visit(ctx.type());
        IdentExpr id = (IdentExpr) visit(ctx.ident());
        List<BasicParser.ParamContext> params = ctx.param();
        ArrayList<VarDecl> paramList = new ArrayList<VarDecl>();
        for (BasicParser.ParamContext p : params) {
            paramList.add((VarDecl) visit(p));
        }

        Statement funcBody = (Statement) visit(ctx.stat());
		/*
		 * int numReturnStmt = checkIfItHasReturnStmt(funcBody); if
		 * (numReturnStmt != -1) { System.err.println("No return statement");
		 * System.exit(100); }
		 */
        return new FunctionDecl(returnType, id, paramList, funcBody);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprCharLitrExpr(
            @NotNull BasicParser.ExprCharLitrExprContext ctx) {
        return visit(ctx.char_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitRhsPairVarRefExpr(
            @NotNull BasicParser.RhsPairVarRefExprContext ctx) {
        return visit(ctx.pair_elem());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitLhsVarRefExpr(
            @NotNull BasicParser.LhsVarRefExprContext ctx) {
        return new VarRefExpr((IdentExpr) visit(ctx.ident()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprVarRefExpr(
            @NotNull BasicParser.ExprVarRefExprContext ctx) {
        return new VarRefExpr((IdentExpr) visit(ctx.ident()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPairElemTypeArrayType(
            @NotNull BasicParser.PairElemTypeArrayTypeContext ctx) {
        return visit(ctx.array_type());
        // ???
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPrintStmt(@NotNull BasicParser.PrintStmtContext ctx) {
        return new PrintStmt((Expr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitReturnStmt(@NotNull BasicParser.ReturnStmtContext ctx) {
        return new ReturnStmt((Expr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitReadStmt(@NotNull BasicParser.ReadStmtContext ctx) {
        return new ReadStmt((LhsExpr) visit(ctx.assign_lhs()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitWhileStmt(@NotNull BasicParser.WhileStmtContext ctx) {
        return new WhileStmt((Expr) visit(ctx.expr()),
                (Statement) visit(ctx.stat()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPairElemSnd(@NotNull BasicParser.PairElemSndContext ctx) {
        if (ctx.expr() == null) {
            return new PairVarRefExpr(PairEnum.SND, (LhsExpr) visit(ctx.pair_elem()));
        }
        return new PairVarRefExpr(PairEnum.SND, (LhsExpr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitArrayElemTypeArrayType(
            @NotNull BasicParser.ArrayElemTypeArrayTypeContext ctx) {
        return new ArrayType((Type) visit(ctx.array_type()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitFreeStmt(@NotNull BasicParser.FreeStmtContext ctx) {
        return new FreeStmt((Expr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitDigit(@NotNull BasicParser.DigitContext ctx) {
        return new DigitExpr(Integer.parseInt(ctx.DIGIT().getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitIfStmt(@NotNull BasicParser.IfStmtContext ctx) {
        return new IfStmt((Expr) visit(ctx.expr()),
                (Statement) visit(ctx.ifbranch),
                (Statement) visit(ctx.elsebranch));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprIntLitrExpr(
            @NotNull BasicParser.ExprIntLitrExprContext ctx) {
        return visit(ctx.int_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitArray_elem(@NotNull BasicParser.Array_elemContext ctx) {
        List<BasicParser.ExprContext> exprs = ctx.expr();
        ArrayVarIndexRefExpr topLevel = null;
        if (exprs.size() > 0) {
            topLevel = new ArrayVarIndexRefExpr(new VarRefExpr(
                    (IdentExpr) visit(ctx.ident())), (Expr) visit(exprs.get(0)));
            for (int i = 1; i < exprs.size(); i++) {
                topLevel = new ArrayVarIndexRefExpr(topLevel,
                        (Expr) visit(exprs.get(i)));
            }
        }
        return topLevel;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExitStmt(@NotNull BasicParser.ExitStmtContext ctx) {
        return new ExitStmt((Expr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprPairLitrExpr(
            @NotNull BasicParser.ExprPairLitrExprContext ctx) {
        return visit(ctx.pair_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitChar_liter(@NotNull BasicParser.Char_literContext ctx) {
        char c = (char) ctx.getText().charAt(1);
        if (c == '\\') {
            c = (char) ctx.getText().charAt(2);
        }
        return new CharLitrExpr(c);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitProgram(@NotNull BasicParser.ProgramContext ctx) {
        Statement body = (Statement) visit(ctx.stat());
        List<BasicParser.FunctionContext> funcs = ctx.function();
        List<BasicParser.ImportlibContext> impts = ctx.importlib();
        ArrayList<AstImport> imports = new ArrayList<AstImport>();
        for (BasicParser.ImportlibContext impt : impts) {
            imports.add(new AstImport(impt.id.getText()));
        }
        ArrayList<FunctionDecl> funcDeclList = new ArrayList<FunctionDecl>();
        for (BasicParser.FunctionContext fctx : funcs) {
            funcDeclList.add((FunctionDecl) visit(fctx));
        }
        return new Program(imports, funcDeclList, body);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitTrue(@NotNull BasicParser.TrueContext ctx) {
        return new BoolLitrExpr(true);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitInt_liter(@NotNull BasicParser.Int_literContext ctx) {
        IntSignExpr sign;
        if (ctx.int_sign() == null) {
            sign = new IntSignExpr(IntSign.POSITIVE);
        } else {
            sign = (IntSignExpr) visit(ctx.int_sign());
        }
        List<BasicParser.DigitContext> digits = ctx.digit();
        int exp = digits.size() - 1;
        long value = 0;
        for (BasicParser.DigitContext d : digits) {
            value += ((int) Math.pow(10, exp))
                    * ((DigitExpr) visit(d)).getValue();
            exp--;
        }
        IntLitrExpr intLitrExpr = new IntLitrExpr(sign, value);
        checkForIntegerOverflow(intLitrExpr.getValue());
        return intLitrExpr;
    }

    private void checkForIntegerOverflow(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            System.err.println("Integer Overflow");
            System.exit(100);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitLhsArrayVarIndexRefExpr(
            @NotNull BasicParser.LhsArrayVarIndexRefExprContext ctx) {
        return visit(ctx.array_elem());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprArrayVarIndexRefExpr(
            @NotNull BasicParser.ExprArrayVarIndexRefExprContext ctx) {
        return visit(ctx.array_elem());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitTypeBaseType(
            @NotNull BasicParser.TypeBaseTypeContext ctx) {
        return visit(ctx.base_type());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPairElemTypeBaseType(
            @NotNull BasicParser.PairElemTypeBaseTypeContext ctx) {
        return visit(ctx.base_type());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPair_liter(@NotNull BasicParser.Pair_literContext ctx) {
        return new PairLitrExpr();
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitParam(@NotNull BasicParser.ParamContext ctx) {
        return new VarDecl((IdentExpr) visit(ctx.ident()),
                (Type) visit(ctx.type()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitIdent(@NotNull BasicParser.IdentContext ctx) {
        return new IdentExpr(ctx.ID().toString());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPairElemFst(@NotNull BasicParser.PairElemFstContext ctx) {
        if (ctx.expr() == null) {
            return new PairVarRefExpr(PairEnum.FST, (LhsExpr) visit(ctx.pair_elem()));
        }
        return new PairVarRefExpr(PairEnum.FST, (LhsExpr) visit(ctx.expr()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitVarDeclAssnStmt(
            @NotNull BasicParser.VarDeclAssnStmtContext ctx) {
        Type t = (Type) visit(ctx.t);
        IdentExpr id = (IdentExpr) visit(ctx.id);
        RhsExpr rhs = (RhsExpr) visit(ctx.rhs);
        return new VarDeclStmt(t, id, rhs);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprBracketedExpr(
            @NotNull BasicParser.ExprBracketedExprContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPlus(@NotNull BasicParser.PlusContext ctx) {
        return new IntSignExpr(IntSign.POSITIVE);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitMinus(@NotNull BasicParser.MinusContext ctx) {
        return new IntSignExpr(IntSign.NEGATIVE);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitArrayElemTypePairType(
            @NotNull BasicParser.ArrayElemTypePairTypeContext ctx) {
        return new ArrayType((Type) visit(ctx.pair_type()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitRhsNewPairExpr(
            @NotNull BasicParser.RhsNewPairExprContext ctx) {
        return new NewPairExpr(new Pair<Expr, Expr>((Expr) visit(ctx.valueLhs),
                (Expr) visit(ctx.valueRhs)));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPairElemTypePairType(
            @NotNull BasicParser.PairElemTypePairTypeContext ctx) {
        return new PairType(null, null);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitRhsArrayLiterExpr(
            @NotNull BasicParser.RhsArrayLiterExprContext ctx) {
        return visit(ctx.array_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitArrayTypeBaseType(
            @NotNull BasicParser.ArrayTypeBaseTypeContext ctx) {
        return new ArrayType((Type) visit(ctx.base_type()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitPair_type(@NotNull BasicParser.Pair_typeContext ctx) {
        Type t1 = (Type) visit(ctx.fstType);
        Type t2 = (Type) visit(ctx.sndType);
        return new PairType(t1, t2);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitStr_liter(@NotNull BasicParser.Str_literContext ctx) {
        return new StringLitrExpr(ctx.STRING().getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitLhsPairVarRefExpr(
            @NotNull BasicParser.LhsPairVarRefExprContext ctx) {
        return visit(ctx.pair_elem());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of callingimport
     * ast.expr.rhsexpr.lhsexpr.VarRefExpr; {@link #visitChildren} on
     * {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitTypePairType(
            @NotNull BasicParser.TypePairTypeContext ctx) {
        return visit(ctx.pair_type());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitSkipStmt(@NotNull BasicParser.SkipStmtContext ctx) {
        return new SkipStmt();
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprBoolLitrExpr(
            @NotNull BasicParser.ExprBoolLitrExprContext ctx) {
        return visit(ctx.bool_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitArray_liter(@NotNull BasicParser.Array_literContext ctx) {
        List<Expr> exprs = new ArrayList<Expr>();
        List<BasicParser.ExprContext> innerExprs = ctx.expr();
        for (BasicParser.ExprContext e : innerExprs) {
            exprs.add((Expr) visit(e));
        }
        return new ArrayLitrExpr(exprs);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     *
     * @Override public AstNode visitExprBinaryOperatorExpr(@NotNull
     *           BasicParser.ExprBinaryOperatorExprContext ctx) {
     *           BinaryOperatorExpr binop = (BinaryOperatorExpr)
     *           visit(ctx.binary_oper()); binop.setLeftExpr((Expr)
     *           visit(ctx.lhs)); binop.setRightExpr((Expr) visit(ctx.rhs));
     *           return binop; }
     */
    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprStringLitrExpr(
            @NotNull BasicParser.ExprStringLitrExprContext ctx) {
        return visit(ctx.str_liter());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     * </p>
     */
    @Override
    public AstNode visitExprUnaryOperatorExpr(
            @NotNull BasicParser.ExprUnaryOperatorExprContext ctx) {
        return visit(ctx.unary_exp());
    }

    @Override
    public AstNode visitStringType(StringTypeContext ctx) {
        return new ArrayType(new BaseType(BaseTypeEnum.CHAR));
    }

    @Override
    public AstNode visitIntType(IntTypeContext ctx) {
        return new BaseType(BaseTypeEnum.INT);
    }

    @Override
    public AstNode visitCharType(CharTypeContext ctx) {
        return new BaseType(BaseTypeEnum.CHAR);
    }

    @Override
    public AstNode visitBoolType(BoolTypeContext ctx) {
        return new BaseType(BaseTypeEnum.BOOL);
    }

    @Override
    public AstNode visitUnMinus(UnMinusContext ctx) {
        return new UnaryOperatorExpr(UnaryOperator.MINUS);
    }

    @Override
    public AstNode visitExclamation(ExclamationContext ctx) {
        return new UnaryOperatorExpr(UnaryOperator.EXCLAMATION);
    }

    @Override
    public AstNode visitChr(ChrContext ctx) {
        return new UnaryOperatorExpr(UnaryOperator.CHR);
    }

    @Override
    public AstNode visitOrd(OrdContext ctx) {
        return new UnaryOperatorExpr(UnaryOperator.ORD);
    }

    @Override
    public AstNode visitLen(LenContext ctx) {
        return new UnaryOperatorExpr(UnaryOperator.LEN);
    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec5(
            ExprBinaryOperatorExprPrec5Context ctx) {
        BinaryOperator op = null;
        if (ctx.LOGICAL_AND() != null) {
            op = BinaryOperator.LOGICAL_AND;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }

        BinaryOperatorExpr binOp = new BinaryOperatorExpr(op);
        binOp.setLeftExpr((Expr) visit(ctx.lhs));
        binOp.setRightExpr((Expr) visit(ctx.rhs));

        return binOp;
    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec6(
            ExprBinaryOperatorExprPrec6Context ctx) {
        BinaryOperator op = null;
        if (ctx.LOGICAL_OR() != null) {
            op = BinaryOperator.LOGICAL_OR;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }

        BinaryOperatorExpr binOp = new BinaryOperatorExpr(op);
        binOp.setLeftExpr((Expr) visit(ctx.lhs));
        binOp.setRightExpr((Expr) visit(ctx.rhs));

        return binOp;
    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec3(
            ExprBinaryOperatorExprPrec3Context ctx) {
        BinaryOperator op = null;
        if (ctx.SMALLER_OR_EQUAL() != null) {
            op = BinaryOperator.SMALLER_OR_EQUAL;
        } else if (ctx.SMALLER_THAN() != null) {
            op = BinaryOperator.SMALLER_THAN;
        } else if (ctx.GREATER_OR_EQUAL() != null) {
            op = BinaryOperator.GREATER_OR_EQUAL;
        } else if (ctx.GREATER_THAN() != null) {
            op = BinaryOperator.GREATER_THAN;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }
        BinaryOperatorExpr binop = new BinaryOperatorExpr(op);
        binop.setLeftExpr((Expr) visit(ctx.lhs));
        binop.setRightExpr((Expr) visit(ctx.rhs));
        return binop;
    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec4(
            ExprBinaryOperatorExprPrec4Context ctx) {
        BinaryOperator op = null;
        if (ctx.EQUALS_EQUALS() != null) {
            op = BinaryOperator.EQUALS_EQUALS;
        } else if (ctx.NOT_EQUALS() != null) {
            op = BinaryOperator.NOT_EQUALS;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }

        BinaryOperatorExpr binOp = new BinaryOperatorExpr(op);
        binOp.setLeftExpr((Expr) visit(ctx.lhs));
        binOp.setRightExpr((Expr) visit(ctx.rhs));

        return binOp;
    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec1(
            ExprBinaryOperatorExprPrec1Context ctx) {
        BinaryOperator op = null;
        if (ctx.DIV() != null) {
            op = BinaryOperator.DIVIDE;
        } else if (ctx.MUL() != null) {
            op = BinaryOperator.MULTIPLY;
        } else if (ctx.MOD() != null) {
            op = BinaryOperator.MODULAR;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }
        BinaryOperatorExpr binop = new BinaryOperatorExpr(op);
        binop.setLeftExpr((Expr) visit(ctx.lhs));
        binop.setRightExpr((Expr) visit(ctx.rhs));
        return binop;

    }

    @Override
    public AstNode visitExprBinaryOperatorExprPrec2(
            ExprBinaryOperatorExprPrec2Context ctx) {
        BinaryOperator op = null;
        if (ctx.PLUS() != null) {
            op = BinaryOperator.PLUS;
        } else if (ctx.MINUS() != null) {
            op = BinaryOperator.MINUS;
        } else {
            System.err.println("Unsupported binary operator");
            System.exit(100);
        }

        BinaryOperatorExpr binOp = new BinaryOperatorExpr(op);
        binOp.setLeftExpr((Expr) visit(ctx.lhs));
        binOp.setRightExpr((Expr) visit(ctx.rhs));

        return binOp;
    }

    @Override
    public AstNode visitUnary_exp(Unary_expContext ctx) {
        UnaryOperatorExpr uop = (UnaryOperatorExpr) visit(ctx.unary_oper());
        uop.setExpr((Expr) visit(ctx.expr()));
        return uop;
    }

    @Override
    public AstNode visitImportlib(ImportlibContext ctx) {
        // not needed
        return null;
    }
}