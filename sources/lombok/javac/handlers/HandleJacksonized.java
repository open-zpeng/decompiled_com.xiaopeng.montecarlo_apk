package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import java.util.Iterator;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
@HandlerPriority(-512)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleJacksonized.SCL.lombok */
public class HandleJacksonized extends JavacAnnotationHandler<Jacksonized> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Jacksonized> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacNode tdNode;
        AnnotationValues<Builder> annotationValues;
        AnnotationValues<SuperBuilder> annotationValues2;
        String str;
        String buildMethodName;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.JACKSONIZED_FLAG_USAGE, "@Jacksonized");
        JavacNode annotatedNode = annotationNode.up();
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, Jacksonized.class);
        if (annotatedNode.getKind() != AST.Kind.TYPE) {
            tdNode = annotatedNode.up();
        } else {
            tdNode = annotatedNode;
        }
        JCTree.JCClassDecl td = (JCTree.JCClassDecl) tdNode.get();
        JavacNode builderAnnotationNode = JavacHandlerUtil.findAnnotation(Builder.class, annotatedNode);
        JavacNode superBuilderAnnotationNode = JavacHandlerUtil.findAnnotation(SuperBuilder.class, annotatedNode);
        if (builderAnnotationNode == null && superBuilderAnnotationNode == null) {
            annotationNode.addWarning("@Jacksonized requires @Builder or @SuperBuilder for it to mean anything.");
        } else if (builderAnnotationNode != null && superBuilderAnnotationNode != null) {
            annotationNode.addError("@Jacksonized cannot process both @Builder and @SuperBuilder on the same class.");
        } else {
            boolean isAbstract = (td.mods.flags & 1024) != 0;
            if (isAbstract) {
                annotationNode.addError("Builders on abstract classes cannot be @Jacksonized (the builder would never be used).");
                return;
            }
            if (builderAnnotationNode != null) {
                annotationValues = JavacHandlerUtil.createAnnotation(Builder.class, builderAnnotationNode);
            } else {
                annotationValues = null;
            }
            AnnotationValues<Builder> builderAnnotation = annotationValues;
            if (superBuilderAnnotationNode != null) {
                annotationValues2 = JavacHandlerUtil.createAnnotation(SuperBuilder.class, superBuilderAnnotationNode);
            } else {
                annotationValues2 = null;
            }
            AnnotationValues<SuperBuilder> superBuilderAnnotation = annotationValues2;
            if (builderAnnotation != null) {
                str = builderAnnotation.getInstance().setterPrefix();
            } else {
                str = superBuilderAnnotation.getInstance().setterPrefix();
            }
            String setPrefix = str;
            if (builderAnnotation != null) {
                buildMethodName = builderAnnotation.getInstance().buildMethodName();
            } else {
                buildMethodName = superBuilderAnnotation.getInstance().buildMethodName();
            }
            String buildMethodName2 = buildMethodName;
            JavacTreeMaker maker = annotatedNode.getTreeMaker();
            String builderClassName = getBuilderClassName(ast, annotationNode, annotatedNode, td, builderAnnotation, maker);
            JCTree.JCClassDecl builderClass = null;
            Iterator it = td.getMembers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JCTree.JCClassDecl jCClassDecl = (JCTree) it.next();
                if ((jCClassDecl instanceof JCTree.JCClassDecl) && jCClassDecl.getSimpleName().contentEquals(builderClassName)) {
                    builderClass = jCClassDecl;
                    break;
                }
            }
            if (builderClass == null) {
                annotationNode.addError("Could not find @(Super)Builder's generated builder class for @Jacksonized processing. If there are other compiler errors, fix them first.");
            } else if (JavacHandlerUtil.hasAnnotation("com.fasterxml.jackson.databind.annotation.JsonDeserialize", tdNode)) {
                annotationNode.addError("@JsonDeserialize already exists on class. Either delete @JsonDeserialize, or remove @Jacksonized and manually configure Jackson.");
            } else {
                JCTree.JCExpression jsonDeserializeType = JavacHandlerUtil.chainDots(annotatedNode, "com", "fasterxml", "jackson", "databind", "annotation", "JsonDeserialize");
                JCTree.JCExpression builderClassExpression = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, tdNode, annotationNode.toName(builderClassName), false, List.nil());
                JCTree.JCFieldAccess builderClassReference = maker.Select(builderClassExpression, annotatedNode.toName("class"));
                JCTree.JCAnnotation annotationJsonDeserialize = maker.Annotation(jsonDeserializeType, List.of(maker.Assign(maker.Ident(annotationNode.toName("builder")), builderClassReference)));
                td.mods.annotations = td.mods.annotations.append(annotationJsonDeserialize);
                List<JCTree.JCAnnotation> copyableAnnotations = findJacksonAnnotationsOnClass(tdNode);
                List<JCTree.JCAnnotation> copiedAnnotations = JavacHandlerUtil.copyAnnotations(copyableAnnotations);
                builderClass.mods.annotations = builderClass.mods.annotations.appendList(copiedAnnotations);
                JCTree.JCExpression jsonPOJOBuilderType = JavacHandlerUtil.chainDots(annotatedNode, "com", "fasterxml", "jackson", "databind", "annotation", "JsonPOJOBuilder");
                JCTree.JCAnnotation annotationJsonPOJOBuilder = maker.Annotation(jsonPOJOBuilderType, List.of(maker.Assign(maker.Ident(annotationNode.toName("withPrefix")), maker.Literal(setPrefix)), maker.Assign(maker.Ident(annotationNode.toName("buildMethodName")), maker.Literal(buildMethodName2))));
                builderClass.mods.annotations = builderClass.mods.annotations.append(annotationJsonPOJOBuilder);
                if (superBuilderAnnotationNode != null) {
                    builderClass.mods.flags &= -3;
                }
            }
        }
    }

    private String getBuilderClassName(JCTree.JCAnnotation ast, JavacNode annotationNode, JavacNode annotatedNode, JCTree.JCClassDecl td, AnnotationValues<Builder> builderAnnotation, JavacTreeMaker maker) {
        String replacement;
        String builderClassName = builderAnnotation != null ? builderAnnotation.getInstance().builderClassName() : null;
        if (builderClassName == null || builderClassName.isEmpty()) {
            String builderClassName2 = (String) annotationNode.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
            builderClassName2 = (builderClassName2 == null || builderClassName2.isEmpty()) ? "*Builder" : "*Builder";
            JCTree.JCMethodDecl fillParametersFrom = annotatedNode.get() instanceof JCTree.JCMethodDecl ? (JCTree.JCMethodDecl) annotatedNode.get() : null;
            if (fillParametersFrom != null && !fillParametersFrom.getName().toString().equals("<init>")) {
                JCTree.JCExpression returnType = fillParametersFrom.restype;
                List<JCTree.JCTypeParameter> typeParams = fillParametersFrom.typarams;
                if (returnType instanceof JCTree.JCTypeApply) {
                    returnType = JavacHandlerUtil.cloneType(maker, returnType, ast, annotationNode.getContext());
                }
                replacement = HandleBuilder.returnTypeToBuilderClassName(annotationNode, td, returnType, typeParams);
            } else {
                replacement = td.name.toString();
            }
            builderClassName = builderClassName2.replace("*", replacement);
        }
        if (builderAnnotation == null) {
            builderClassName = String.valueOf(builderClassName) + "Impl";
        }
        return builderClassName;
    }

    private static List<JCTree.JCAnnotation> findJacksonAnnotationsOnClass(JavacNode node) {
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        Iterator<JavacNode> it = node.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation = child.get();
                Iterator<String> it2 = HandlerUtil.JACKSON_COPY_TO_BUILDER_ANNOTATIONS.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String bn = it2.next();
                    if (JavacHandlerUtil.typeMatches(bn, node, annotation.annotationType)) {
                        result.append(annotation);
                        break;
                    }
                }
            }
        }
        return result.toList();
    }
}
