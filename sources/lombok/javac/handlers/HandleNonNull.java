package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import lombok.NonNull;
import lombok.core.AST;
import lombok.core.HandlerPriority;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacTreeMaker;
@HandlerPriority(512)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleNonNull.SCL.lombok */
public class HandleNonNull extends JavacAnnotationHandler<NonNull> {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cd A[LOOP:2: B:57:0x01e2->B:56:0x01cd, LOOP_END] */
    @Override // lombok.javac.JavacAnnotationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handle(lombok.core.AnnotationValues<lombok.NonNull> r5, com.sun.tools.javac.tree.JCTree.JCAnnotation r6, lombok.javac.JavacNode r7) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.javac.handlers.HandleNonNull.handle(lombok.core.AnnotationValues, com.sun.tools.javac.tree.JCTree$JCAnnotation, lombok.javac.JavacNode):void");
    }

    public boolean isNullCheck(JCTree.JCStatement stat) {
        return returnVarNameIfNullCheck(stat) != null;
    }

    public String returnVarNameIfNullCheck(JCTree.JCStatement stat) {
        JCTree.JCExpression cond;
        boolean isIf = stat instanceof JCTree.JCIf;
        boolean isExpression = stat instanceof JCTree.JCExpressionStatement;
        if (isIf || (stat instanceof JCTree.JCAssert) || isExpression) {
            if (isExpression) {
                JCTree.JCAssign expression = ((JCTree.JCExpressionStatement) stat).expr;
                if (expression instanceof JCTree.JCAssign) {
                    expression = expression.rhs;
                }
                if (expression instanceof JCTree.JCMethodInvocation) {
                    JCTree.JCMethodInvocation invocation = (JCTree.JCMethodInvocation) expression;
                    JCTree.JCFieldAccess jCFieldAccess = invocation.meth;
                    Name name = null;
                    if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                        name = jCFieldAccess.name;
                    } else if (jCFieldAccess instanceof JCTree.JCIdent) {
                        name = ((JCTree.JCIdent) jCFieldAccess).name;
                    }
                    if (name != null) {
                        if ((name.contentEquals("checkNotNull") || name.contentEquals("requireNonNull")) && !invocation.args.isEmpty()) {
                            JCTree.JCIdent jCIdent = (JCTree.JCExpression) invocation.args.head;
                            if (jCIdent instanceof JCTree.JCIdent) {
                                return jCIdent.toString();
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            if (isIf) {
                JCTree.JCStatement then = ((JCTree.JCIf) stat).thenpart;
                if (then instanceof JCTree.JCBlock) {
                    List<JCTree.JCStatement> stats = ((JCTree.JCBlock) then).stats;
                    if (stats.length() == 0) {
                        return null;
                    }
                    then = (JCTree.JCStatement) stats.get(0);
                }
                if (!(then instanceof JCTree.JCThrow)) {
                    return null;
                }
            }
            JCTree.JCExpression jCExpression = isIf ? ((JCTree.JCIf) stat).cond : ((JCTree.JCAssert) stat).cond;
            while (true) {
                cond = jCExpression;
                if (!(cond instanceof JCTree.JCParens)) {
                    break;
                }
                jCExpression = ((JCTree.JCParens) cond).expr;
            }
            if (cond instanceof JCTree.JCBinary) {
                JCTree.JCBinary bin = (JCTree.JCBinary) cond;
                if (isIf) {
                    if (!Javac.CTC_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
                        return null;
                    }
                } else if (!Javac.CTC_NOT_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
                    return null;
                }
                if ((bin.lhs instanceof JCTree.JCIdent) && (bin.rhs instanceof JCTree.JCLiteral) && Javac.CTC_BOT.equals(JavacTreeMaker.TypeTag.typeTag((JCTree) bin.rhs))) {
                    return bin.lhs.name.toString();
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
