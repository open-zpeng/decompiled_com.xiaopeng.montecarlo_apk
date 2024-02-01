package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.Delegate;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleDelegate.SCL.lombok */
public class HandleDelegate extends EclipseAnnotationHandler<Delegate> {
    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Delegate> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.DELEGATE_FLAG_USAGE, "@Delegate");
    }
}
