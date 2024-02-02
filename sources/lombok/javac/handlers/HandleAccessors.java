package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Accessors;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
@HandlerPriority(65536)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleAccessors.SCL.lombok */
public class HandleAccessors extends JavacAnnotationHandler<Accessors> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Accessors> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.ACCESSORS_FLAG_USAGE, "@Accessors");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, Accessors.class);
    }
}
