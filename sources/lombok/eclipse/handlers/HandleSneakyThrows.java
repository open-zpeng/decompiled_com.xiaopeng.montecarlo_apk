package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.SneakyThrows;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.DeferUntilPostDiet;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
@DeferUntilPostDiet
@HandlerPriority(1024)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleSneakyThrows.SCL.lombok */
public class HandleSneakyThrows extends EclipseAnnotationHandler<SneakyThrows> {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleSneakyThrows$DeclaredException.SCL.lombok */
    public static class DeclaredException {
        final String exceptionName;
        final ASTNode node;

        DeclaredException(String exceptionName, ASTNode node) {
            this.exceptionName = exceptionName;
            this.node = node;
        }
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<SneakyThrows> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SNEAKY_THROWS_FLAG_USAGE, "@SneakyThrows");
        List<String> exceptionNames = annotation.getRawExpressions("value");
        List<DeclaredException> exceptions = new ArrayList<>();
        MemberValuePair[] memberValuePairs = source.memberValuePairs();
        if (memberValuePairs == null || memberValuePairs.length == 0) {
            exceptions.add(new DeclaredException("java.lang.Throwable", source));
        } else {
            ArrayInitializer arrayInitializer = memberValuePairs[0].value;
            Expression[] exceptionNameNodes = arrayInitializer instanceof ArrayInitializer ? arrayInitializer.expressions : new Expression[]{arrayInitializer};
            if (exceptionNames.size() != exceptionNameNodes.length) {
                annotationNode.addError("LOMBOK BUG: The number of exception classes in the annotation isn't the same pre- and post- guessing.");
            }
            int idx = 0;
            for (String exceptionName : exceptionNames) {
                if (exceptionName.endsWith(".class")) {
                    exceptionName = exceptionName.substring(0, exceptionName.length() - 6);
                }
                int i = idx;
                idx++;
                exceptions.add(new DeclaredException(exceptionName, exceptionNameNodes[i]));
            }
        }
        EclipseNode owner = annotationNode.up();
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[owner.getKind().ordinal()]) {
            case 5:
                handleMethod(annotationNode, (AbstractMethodDeclaration) owner.get(), exceptions);
                return;
            default:
                annotationNode.addError("@SneakyThrows is legal only on methods and constructors.");
                return;
        }
    }

    public void handleMethod(EclipseNode annotation, AbstractMethodDeclaration method, List<DeclaredException> exceptions) {
        if (method.isAbstract()) {
            annotation.addError("@SneakyThrows can only be used on concrete methods.");
        } else if (method.statements == null || method.statements.length == 0) {
            boolean hasConstructorCall = false;
            if (method instanceof ConstructorDeclaration) {
                ExplicitConstructorCall constructorCall = ((ConstructorDeclaration) method).constructorCall;
                hasConstructorCall = (constructorCall == null || constructorCall.isImplicitSuper() || constructorCall.isImplicitThis()) ? false : true;
            }
            if (hasConstructorCall) {
                annotation.addWarning("Calls to sibling / super constructors are always excluded from @SneakyThrows; @SneakyThrows has been ignored because there is no other code in this constructor.");
            } else {
                annotation.addWarning("This method or constructor is empty; @SneakyThrows has been ignored.");
            }
        } else {
            Statement[] contents = method.statements;
            for (DeclaredException exception : exceptions) {
                contents = new Statement[]{buildTryCatchBlock(contents, exception, exception.node, method)};
            }
            method.statements = contents;
            annotation.up().rebuild();
        }
    }

    /* JADX WARN: Type inference failed for: r0v29, types: [char[], char[][]] */
    /* JADX WARN: Type inference failed for: r3v12, types: [char[], char[][]] */
    public Statement buildTryCatchBlock(Statement[] contents, DeclaredException exception, ASTNode source, AbstractMethodDeclaration method) {
        QualifiedTypeReference qualifiedTypeReference;
        int methodStart = method.bodyStart;
        int methodEnd = method.bodyEnd;
        long methodPosEnd = (methodEnd << 32) | (methodEnd & 4294967295L);
        TryStatement tryStatement = new TryStatement();
        EclipseHandlerUtil.setGeneratedBy(tryStatement, source);
        tryStatement.tryBlock = new Block(0);
        tryStatement.tryBlock.sourceStart = methodStart;
        tryStatement.tryBlock.sourceEnd = methodEnd;
        EclipseHandlerUtil.setGeneratedBy(tryStatement.tryBlock, source);
        tryStatement.tryBlock.statements = contents;
        if (exception.exceptionName.indexOf(46) == -1) {
            qualifiedTypeReference = new SingleTypeReference(exception.exceptionName.toCharArray(), methodPosEnd);
            ((TypeReference) qualifiedTypeReference).statementEnd = methodEnd;
        } else {
            String[] x = exception.exceptionName.split("\\.");
            ?? r0 = new char[x.length];
            long[] poss = new long[x.length];
            Arrays.fill(poss, methodPosEnd);
            for (int i = 0; i < x.length; i++) {
                r0[i] = x[i].trim().toCharArray();
            }
            qualifiedTypeReference = new QualifiedTypeReference((char[][]) r0, poss);
        }
        EclipseHandlerUtil.setGeneratedBy(qualifiedTypeReference, source);
        Argument catchArg = new Argument("$ex".toCharArray(), methodPosEnd, qualifiedTypeReference, 16);
        EclipseHandlerUtil.setGeneratedBy(catchArg, source);
        catchArg.sourceEnd = methodEnd;
        catchArg.declarationEnd = methodEnd;
        catchArg.declarationSourceEnd = methodEnd;
        catchArg.sourceStart = methodEnd;
        catchArg.modifiersSourceStart = methodEnd;
        catchArg.declarationSourceStart = methodEnd;
        tryStatement.catchArguments = new Argument[]{catchArg};
        MessageSend sneakyThrowStatement = new MessageSend();
        EclipseHandlerUtil.setGeneratedBy(sneakyThrowStatement, source);
        sneakyThrowStatement.receiver = new QualifiedNameReference((char[][]) new char[]{"lombok".toCharArray(), "Lombok".toCharArray()}, new long[2], methodEnd, methodEnd);
        EclipseHandlerUtil.setGeneratedBy(sneakyThrowStatement.receiver, source);
        sneakyThrowStatement.receiver.statementEnd = methodEnd;
        sneakyThrowStatement.selector = "sneakyThrow".toCharArray();
        Expression singleNameReference = new SingleNameReference("$ex".toCharArray(), methodPosEnd);
        EclipseHandlerUtil.setGeneratedBy(singleNameReference, source);
        ((SingleNameReference) singleNameReference).statementEnd = methodEnd;
        sneakyThrowStatement.arguments = new Expression[]{singleNameReference};
        sneakyThrowStatement.nameSourcePosition = -2L;
        sneakyThrowStatement.sourceStart = methodEnd;
        sneakyThrowStatement.statementEnd = methodEnd;
        sneakyThrowStatement.sourceEnd = methodEnd;
        Statement rethrowStatement = new ThrowStatement(sneakyThrowStatement, methodEnd, methodEnd);
        EclipseHandlerUtil.setGeneratedBy(rethrowStatement, source);
        Block block = new Block(0);
        block.sourceStart = methodEnd;
        block.sourceEnd = methodEnd;
        EclipseHandlerUtil.setGeneratedBy(block, source);
        block.statements = new Statement[]{rethrowStatement};
        tryStatement.catchBlocks = new Block[]{block};
        tryStatement.sourceStart = method.bodyStart;
        tryStatement.sourceEnd = method.bodyEnd;
        return tryStatement;
    }
}
