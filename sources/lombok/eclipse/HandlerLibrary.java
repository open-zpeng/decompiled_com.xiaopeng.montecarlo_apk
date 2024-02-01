package lombok.eclipse;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.Lombok;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.core.TypeResolver;
import lombok.core.configuration.ConfigurationKeysLoader;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/HandlerLibrary.SCL.lombok */
public class HandlerLibrary {
    private TypeLibrary typeLibrary = new TypeLibrary();
    private Map<String, AnnotationHandlerContainer<?>> annotationHandlers = new HashMap();
    private Collection<VisitorContainer> visitorHandlers = new ArrayList();
    private SortedSet<Long> priorities;

    public HandlerLibrary() {
        ConfigurationKeysLoader.LoaderLoader.loadAllConfigurationKeys();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/HandlerLibrary$VisitorContainer.SCL.lombok */
    public static class VisitorContainer {
        private final EclipseASTVisitor visitor;
        private final long priority;
        private final boolean deferUntilPostDiet;

        VisitorContainer(EclipseASTVisitor visitor) {
            this.visitor = visitor;
            this.deferUntilPostDiet = visitor.getClass().isAnnotationPresent(DeferUntilPostDiet.class);
            HandlerPriority hp = (HandlerPriority) visitor.getClass().getAnnotation(HandlerPriority.class);
            this.priority = hp == null ? 0L : (hp.value() << 32) + hp.subValue();
        }

        public boolean deferUntilPostDiet() {
            return this.deferUntilPostDiet;
        }

        public long getPriority() {
            return this.priority;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/HandlerLibrary$AnnotationHandlerContainer.SCL.lombok */
    public static class AnnotationHandlerContainer<T extends Annotation> {
        private final EclipseAnnotationHandler<T> handler;
        private final Class<T> annotationClass;
        private final long priority;
        private final boolean deferUntilPostDiet;

        AnnotationHandlerContainer(EclipseAnnotationHandler<T> handler, Class<T> annotationClass) {
            this.handler = handler;
            this.annotationClass = annotationClass;
            this.deferUntilPostDiet = handler.getClass().isAnnotationPresent(DeferUntilPostDiet.class);
            HandlerPriority hp = (HandlerPriority) handler.getClass().getAnnotation(HandlerPriority.class);
            this.priority = hp == null ? 0L : (hp.value() << 32) + hp.subValue();
        }

        public void handle(org.eclipse.jdt.internal.compiler.ast.Annotation annotation, EclipseNode annotationNode) {
            AnnotationValues<T> annValues = EclipseHandlerUtil.createAnnotation(this.annotationClass, annotationNode);
            this.handler.handle(annValues, annotation, annotationNode);
        }

        public void preHandle(org.eclipse.jdt.internal.compiler.ast.Annotation annotation, EclipseNode annotationNode) {
            AnnotationValues<T> annValues = EclipseHandlerUtil.createAnnotation(this.annotationClass, annotationNode);
            this.handler.preHandle(annValues, annotation, annotationNode);
        }

        public boolean deferUntilPostDiet() {
            return this.deferUntilPostDiet;
        }

        public long getPriority() {
            return this.priority;
        }
    }

    public static HandlerLibrary load() {
        HandlerLibrary lib = new HandlerLibrary();
        loadAnnotationHandlers(lib);
        loadVisitorHandlers(lib);
        lib.calculatePriorities();
        return lib;
    }

    public SortedSet<Long> getPriorities() {
        return this.priorities;
    }

    private void calculatePriorities() {
        SortedSet<Long> set = new TreeSet<>();
        for (AnnotationHandlerContainer<?> container : this.annotationHandlers.values()) {
            set.add(Long.valueOf(container.getPriority()));
        }
        for (VisitorContainer container2 : this.visitorHandlers) {
            set.add(Long.valueOf(container2.getPriority()));
        }
        this.priorities = Collections.unmodifiableSortedSet(set);
    }

    private static void loadAnnotationHandlers(HandlerLibrary lib) {
        try {
            for (EclipseAnnotationHandler<?> handler : SpiLoadUtil.findServices(EclipseAnnotationHandler.class, EclipseAnnotationHandler.class.getClassLoader())) {
                AnnotationHandlerContainer<?> container = new AnnotationHandlerContainer<>(handler, handler.getAnnotationHandledByThisHandler());
                String annotationClassName = ((AnnotationHandlerContainer) container).annotationClass.getName().replace("$", ".");
                if (lib.annotationHandlers.put(annotationClassName, container) != null) {
                    EclipseHandlerUtil.error(null, "Duplicate handlers for annotation type: " + annotationClassName, null);
                }
                lib.typeLibrary.addType(((AnnotationHandlerContainer) container).annotationClass.getName());
            }
        } catch (IOException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private static void loadVisitorHandlers(HandlerLibrary lib) {
        try {
            for (EclipseASTVisitor visitor : SpiLoadUtil.findServices(EclipseASTVisitor.class, EclipseASTVisitor.class.getClassLoader())) {
                lib.visitorHandlers.add(new VisitorContainer(visitor));
            }
        } catch (Throwable t) {
            throw Lombok.sneakyThrow(t);
        }
    }

    private boolean checkAndSetHandled(ASTNode node) {
        return !EcjAugments.ASTNode_handled.getAndSet(node, true).booleanValue();
    }

    private boolean needsHandling(ASTNode node) {
        return !EcjAugments.ASTNode_handled.get(node).booleanValue();
    }

    public long handleAnnotation(CompilationUnitDeclaration ast, EclipseNode annotationNode, org.eclipse.jdt.internal.compiler.ast.Annotation annotation, long priority) {
        String fqn;
        AnnotationHandlerContainer<?> container;
        TypeResolver resolver = new TypeResolver(annotationNode.getImportList());
        TypeReference rawType = annotation.type;
        if (rawType == null || (fqn = resolver.typeRefToFullyQualifiedName(annotationNode, this.typeLibrary, Eclipse.toQualifiedName(annotation.type.getTypeName()))) == null || (container = this.annotationHandlers.get(fqn)) == null) {
            return Long.MAX_VALUE;
        }
        if (priority < container.getPriority()) {
            return container.getPriority();
        }
        if (priority > container.getPriority()) {
            return Long.MAX_VALUE;
        }
        if (!annotationNode.isCompleteParse() && container.deferUntilPostDiet()) {
            if (needsHandling(annotation)) {
                container.preHandle(annotation, annotationNode);
                return Long.MAX_VALUE;
            }
            return Long.MAX_VALUE;
        }
        try {
            if (checkAndSetHandled(annotation)) {
                container.handle(annotation, annotationNode);
                return Long.MAX_VALUE;
            }
            return Long.MAX_VALUE;
        } catch (AnnotationValues.AnnotationValueDecodeFail fail) {
            fail.owner.setError(fail.getMessage(), fail.idx);
            return Long.MAX_VALUE;
        } catch (Throwable t) {
            EclipseHandlerUtil.error(ast, String.format("Lombok annotation handler %s failed", ((AnnotationHandlerContainer) container).handler.getClass()), t);
            return Long.MAX_VALUE;
        }
    }

    public long callASTVisitors(EclipseAST ast, long priority, boolean isCompleteParse) {
        long nearestPriority = Long.MAX_VALUE;
        for (VisitorContainer container : this.visitorHandlers) {
            if (priority < container.getPriority()) {
                nearestPriority = Math.min(container.getPriority(), nearestPriority);
            }
            if (isCompleteParse || !container.deferUntilPostDiet()) {
                if (priority == container.getPriority()) {
                    try {
                        ast.traverse(container.visitor);
                    } catch (Throwable t) {
                        EclipseHandlerUtil.error(ast.top().get(), String.format("Lombok visitor handler %s failed", container.visitor.getClass()), t);
                    }
                }
            }
        }
        return nearestPriority;
    }
}
