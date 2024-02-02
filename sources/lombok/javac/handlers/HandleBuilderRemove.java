package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import lombok.Builder;
import lombok.core.AlreadyHandledAnnotations;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
@HandlerPriority(65536)
@AlreadyHandledAnnotations
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleBuilderRemove.SCL.lombok */
public class HandleBuilderRemove extends JavacAnnotationHandler<Builder> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Builder> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, Builder.class, "lombok.experimental.Builder");
    }
}
