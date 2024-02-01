package lombok.eclipse.handlers;

import java.util.Arrays;
import lombok.Cleanup;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleCleanup.SCL.lombok */
public class HandleCleanup extends EclipseAnnotationHandler<Cleanup> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Cleanup> annotation, Annotation ast, EclipseNode annotationNode) {
        boolean isSwitch;
        LocalDeclaration[] localDeclarationArr;
        int end;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.CLEANUP_FLAG_USAGE, "@Cleanup");
        String cleanupName = annotation.getInstance().value();
        if (cleanupName.length() == 0) {
            annotationNode.addError("cleanupName cannot be the empty string.");
        } else if (annotationNode.up().getKind() != AST.Kind.LOCAL) {
            annotationNode.addError("@Cleanup is legal only on local variable declarations.");
        } else {
            LocalDeclaration decl = annotationNode.up().get();
            if (decl.initialization == null) {
                annotationNode.addError("@Cleanup variable declarations need to be initialized.");
                return;
            }
            EclipseNode ancestor = annotationNode.up().directUp();
            AbstractMethodDeclaration abstractMethodDeclaration = (ASTNode) ancestor.get();
            if (abstractMethodDeclaration instanceof AbstractMethodDeclaration) {
                isSwitch = false;
                localDeclarationArr = abstractMethodDeclaration.statements;
            } else if (abstractMethodDeclaration instanceof Block) {
                isSwitch = false;
                localDeclarationArr = ((Block) abstractMethodDeclaration).statements;
            } else if (abstractMethodDeclaration instanceof SwitchStatement) {
                isSwitch = true;
                localDeclarationArr = ((SwitchStatement) abstractMethodDeclaration).statements;
            } else {
                annotationNode.addError("@Cleanup is legal only on a local variable declaration inside a block.");
                return;
            }
            if (localDeclarationArr == null) {
                annotationNode.addError("LOMBOK BUG: Parent block does not contain any statements.");
                return;
            }
            int start = 0;
            while (start < localDeclarationArr.length && localDeclarationArr[start] != decl) {
                start++;
            }
            if (start == localDeclarationArr.length) {
                annotationNode.addError("LOMBOK BUG: Can't find this local variable declaration inside its parent.");
                return;
            }
            int start2 = start + 1;
            if (isSwitch) {
                end = start2 + 1;
                while (end < localDeclarationArr.length && !(localDeclarationArr[end] instanceof CaseStatement)) {
                    end++;
                }
            } else {
                end = localDeclarationArr.length;
            }
            Statement[] tryBlock = new Statement[end - start2];
            System.arraycopy(localDeclarationArr, start2, tryBlock, 0, end - start2);
            int newStatementsLength = localDeclarationArr.length - (end - start2);
            Statement[] newStatements = new Statement[newStatementsLength + 1];
            System.arraycopy(localDeclarationArr, 0, newStatements, 0, start2);
            System.arraycopy(localDeclarationArr, end, newStatements, start2 + 1, localDeclarationArr.length - end);
            doAssignmentCheck(annotationNode, tryBlock, decl.name);
            TryStatement tryStatement = new TryStatement();
            EclipseHandlerUtil.setGeneratedBy(tryStatement, ast);
            tryStatement.tryBlock = new Block(0);
            tryStatement.tryBlock.statements = tryBlock;
            EclipseHandlerUtil.setGeneratedBy(tryStatement.tryBlock, ast);
            int ss = decl.declarationSourceEnd + 1;
            if (tryBlock.length > 0) {
                int se = tryBlock[tryBlock.length - 1].sourceEnd + 1;
                tryStatement.sourceStart = ss;
                tryStatement.sourceEnd = se;
                tryStatement.tryBlock.sourceStart = ss;
                tryStatement.tryBlock.sourceEnd = se;
            }
            newStatements[start2] = tryStatement;
            Statement[] finallyBlock = new Statement[1];
            Statement messageSend = new MessageSend();
            EclipseHandlerUtil.setGeneratedBy(messageSend, ast);
            ((MessageSend) messageSend).sourceStart = ast.sourceStart;
            ((MessageSend) messageSend).sourceEnd = ast.sourceEnd;
            SingleNameReference receiver = new SingleNameReference(decl.name, 0L);
            EclipseHandlerUtil.setGeneratedBy(receiver, ast);
            ((MessageSend) messageSend).receiver = receiver;
            long nameSourcePosition = (ast.sourceStart << 32) | ast.sourceEnd;
            if (ast.memberValuePairs() != null) {
                MemberValuePair[] memberValuePairs = ast.memberValuePairs();
                int length = memberValuePairs.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        MemberValuePair pair = memberValuePairs[i];
                        if (pair.name == null || !new String(pair.name).equals("value")) {
                            i++;
                        } else {
                            nameSourcePosition = (pair.value.sourceStart << 32) | pair.value.sourceEnd;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            ((MessageSend) messageSend).nameSourcePosition = nameSourcePosition;
            ((MessageSend) messageSend).selector = cleanupName.toCharArray();
            int pS = ast.sourceStart;
            int pE = ast.sourceEnd;
            long p = (pS << 32) | pE;
            SingleNameReference varName = new SingleNameReference(decl.name, p);
            EclipseHandlerUtil.setGeneratedBy(varName, ast);
            NullLiteral nullLiteral = new NullLiteral(pS, pE);
            EclipseHandlerUtil.setGeneratedBy(nullLiteral, ast);
            MessageSend preventNullAnalysis = preventNullAnalysis(ast, varName);
            EqualExpression equalExpression = new EqualExpression(preventNullAnalysis, nullLiteral, 29);
            equalExpression.sourceStart = pS;
            equalExpression.sourceEnd = pE;
            EclipseHandlerUtil.setGeneratedBy(equalExpression, ast);
            Block closeBlock = new Block(0);
            closeBlock.statements = new Statement[1];
            closeBlock.statements[0] = messageSend;
            EclipseHandlerUtil.setGeneratedBy(closeBlock, ast);
            IfStatement ifStatement = new IfStatement(equalExpression, closeBlock, 0, 0);
            EclipseHandlerUtil.setGeneratedBy(ifStatement, ast);
            finallyBlock[0] = ifStatement;
            tryStatement.finallyBlock = new Block(0);
            if (!isSwitch) {
                tryStatement.finallyBlock.sourceStart = ((ASTNode) abstractMethodDeclaration).sourceEnd;
                tryStatement.finallyBlock.sourceEnd = ((ASTNode) abstractMethodDeclaration).sourceEnd;
            }
            EclipseHandlerUtil.setGeneratedBy(tryStatement.finallyBlock, ast);
            tryStatement.finallyBlock.statements = finallyBlock;
            tryStatement.catchArguments = null;
            tryStatement.catchBlocks = null;
            if (abstractMethodDeclaration instanceof AbstractMethodDeclaration) {
                abstractMethodDeclaration.statements = newStatements;
            } else if (abstractMethodDeclaration instanceof Block) {
                ((Block) abstractMethodDeclaration).statements = newStatements;
            } else if (abstractMethodDeclaration instanceof SwitchStatement) {
                ((SwitchStatement) abstractMethodDeclaration).statements = newStatements;
            }
            ancestor.rebuild();
        }
    }

    public MessageSend preventNullAnalysis(Annotation ast, Expression expr) {
        MessageSend singletonList = new MessageSend();
        EclipseHandlerUtil.setGeneratedBy(singletonList, ast);
        int pS = ast.sourceStart;
        int pE = ast.sourceEnd;
        long p = (pS << 32) | pE;
        singletonList.receiver = EclipseHandlerUtil.createNameReference("java.util.Collections", ast);
        singletonList.selector = "singletonList".toCharArray();
        singletonList.arguments = new Expression[]{expr};
        singletonList.nameSourcePosition = p;
        singletonList.sourceStart = pS;
        singletonList.statementEnd = pE;
        singletonList.sourceEnd = pE;
        MessageSend preventNullAnalysis = new MessageSend();
        EclipseHandlerUtil.setGeneratedBy(preventNullAnalysis, ast);
        preventNullAnalysis.receiver = singletonList;
        preventNullAnalysis.selector = "get".toCharArray();
        preventNullAnalysis.arguments = new Expression[]{EclipseHandlerUtil.makeIntLiteral("0".toCharArray(), ast)};
        preventNullAnalysis.nameSourcePosition = p;
        preventNullAnalysis.sourceStart = pS;
        singletonList.statementEnd = pE;
        preventNullAnalysis.sourceEnd = pE;
        return preventNullAnalysis;
    }

    public void doAssignmentCheck(EclipseNode node, Statement[] tryBlock, char[] varName) {
        for (Statement statement : tryBlock) {
            doAssignmentCheck0(node, statement, varName);
        }
    }

    private void doAssignmentCheck0(EclipseNode node, Statement statement, char[] varName) {
        EclipseNode problemNode;
        if (statement instanceof Assignment) {
            doAssignmentCheck0(node, ((Assignment) statement).expression, varName);
        } else if (statement instanceof LocalDeclaration) {
            doAssignmentCheck0(node, ((LocalDeclaration) statement).initialization, varName);
        } else if (statement instanceof CastExpression) {
            doAssignmentCheck0(node, ((CastExpression) statement).expression, varName);
        } else if ((statement instanceof SingleNameReference) && Arrays.equals(((SingleNameReference) statement).token, varName) && (problemNode = node.getNodeFor(statement)) != null) {
            problemNode.addWarning("You're assigning an auto-cleanup variable to something else. This is a bad idea.");
        }
    }
}
