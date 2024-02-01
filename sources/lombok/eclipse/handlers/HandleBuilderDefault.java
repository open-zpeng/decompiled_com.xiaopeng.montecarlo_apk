package lombok.eclipse.handlers;

import lombok.Builder;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.SuperBuilder;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
@HandlerPriority(-1025)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleBuilderDefault.SCL.lombok */
public class HandleBuilderDefault extends EclipseAnnotationHandler<Builder.Default> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Builder.Default> annotation, Annotation ast, EclipseNode annotationNode) {
        EclipseNode annotatedField = annotationNode.up();
        if (annotatedField.getKind() != AST.Kind.FIELD) {
            return;
        }
        EclipseNode classWithAnnotatedField = annotatedField.up();
        if (!EclipseHandlerUtil.hasAnnotation(Builder.class, classWithAnnotatedField) && !EclipseHandlerUtil.hasAnnotation("lombok.experimental.Builder", classWithAnnotatedField) && !EclipseHandlerUtil.hasAnnotation(SuperBuilder.class, classWithAnnotatedField)) {
            annotationNode.addWarning("@Builder.Default requires @Builder or @SuperBuilder on the class for it to mean anything.");
        }
    }
}
