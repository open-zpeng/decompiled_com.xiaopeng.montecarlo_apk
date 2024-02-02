package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import lombok.core.AlreadyHandledAnnotations;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.experimental.SuperBuilder;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
@HandlerPriority(65536)
@AlreadyHandledAnnotations
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleSuperBuilderRemove.SCL.lombok */
public class HandleSuperBuilderRemove extends JavacAnnotationHandler<SuperBuilder> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<SuperBuilder> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, SuperBuilder.class);
    }
}
