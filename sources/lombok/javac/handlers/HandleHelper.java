package lombok.javac.handlers;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Helper;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleHelper.SCL.lombok */
public class HandleHelper extends JavacAnnotationHandler<Helper> {
    private List<JCTree.JCStatement> getStatementsFromJcNode(JCTree tree) {
        if (tree instanceof JCTree.JCBlock) {
            return ((JCTree.JCBlock) tree).stats;
        }
        if (tree instanceof JCTree.JCCase) {
            return ((JCTree.JCCase) tree).stats;
        }
        return null;
    }

    private void setStatementsOfJcNode(JCTree tree, List<JCTree.JCStatement> statements) {
        if (!(tree instanceof JCTree.JCBlock)) {
            if (!(tree instanceof JCTree.JCCase)) {
                throw new IllegalArgumentException("Can't set statements on node type: " + tree.getClass());
            }
            ((JCTree.JCCase) tree).stats = statements;
            return;
        }
        ((JCTree.JCBlock) tree).stats = statements;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Helper> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        String n;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.HELPER_FLAG_USAGE, "@Helper");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, Helper.class);
        JavacNode annotatedType = annotationNode.up();
        JavacNode containingBlock = annotatedType == null ? null : annotatedType.directUp();
        List<JCTree.JCStatement> origStatements = getStatementsFromJcNode(containingBlock == null ? null : containingBlock.get());
        if (annotatedType == null || annotatedType.getKind() != AST.Kind.TYPE || origStatements == null) {
            annotationNode.addError("@Helper is legal only on method-local classes.");
            return;
        }
        JCTree.JCStatement jCStatement = (JCTree.JCClassDecl) annotatedType.get();
        Iterator<JCTree.JCStatement> it = origStatements.iterator();
        while (it.hasNext() && it.next() != jCStatement) {
        }
        java.util.List<String> knownMethodNames = new ArrayList<>();
        Iterator<JavacNode> it2 = annotatedType.down().iterator();
        while (it2.hasNext()) {
            JavacNode ch = it2.next();
            if (ch.getKind() == AST.Kind.METHOD && (n = ch.getName()) != null && !n.isEmpty() && n.charAt(0) != '<') {
                knownMethodNames.add(n);
            }
        }
        Collections.sort(knownMethodNames);
        final String[] knownMethodNames_ = (String[]) knownMethodNames.toArray(new String[0]);
        final Name helperName = annotationNode.toName("$" + ((JCTree.JCClassDecl) jCStatement).name);
        final boolean[] helperUsed = new boolean[1];
        final JavacTreeMaker maker = annotationNode.getTreeMaker();
        TreeScanner<Void, Void> treeScanner = new TreeScanner<Void, Void>() { // from class: lombok.javac.handlers.HandleHelper.1
            public Void visitMethodInvocation(MethodInvocationTree node, Void p) {
                JCTree.JCMethodInvocation jcmi = (JCTree.JCMethodInvocation) node;
                apply(jcmi);
                return (Void) super.visitMethodInvocation(node, p);
            }

            private void apply(JCTree.JCMethodInvocation jcmi) {
                if (jcmi.meth instanceof JCTree.JCIdent) {
                    JCTree.JCIdent jci = jcmi.meth;
                    if (Arrays.binarySearch(knownMethodNames_, jci.name.toString()) < 0) {
                        return;
                    }
                    jcmi.meth = maker.Select(maker.Ident(helperName), jci.name);
                    helperUsed[0] = true;
                }
            }
        };
        while (it.hasNext()) {
            it.next().accept(treeScanner, (Object) null);
        }
        if (!helperUsed[0]) {
            annotationNode.addWarning("No methods of this helper class are ever used.");
            return;
        }
        ListBuffer<JCTree.JCStatement> newStatements = new ListBuffer<>();
        boolean mark = false;
        Iterator it3 = origStatements.iterator();
        while (it3.hasNext()) {
            JCTree.JCStatement stat = (JCTree.JCStatement) it3.next();
            newStatements.append(stat);
            if (!mark && stat == jCStatement) {
                mark = true;
                JCTree.JCVariableDecl decl = maker.VarDef(maker.Modifiers(16L), helperName, maker.Ident(((JCTree.JCClassDecl) jCStatement).name), maker.NewClass(null, List.nil(), maker.Ident(((JCTree.JCClassDecl) jCStatement).name), List.nil(), null));
                newStatements.append(decl);
            }
        }
        setStatementsOfJcNode(containingBlock.get(), newStatements.toList());
    }
}
