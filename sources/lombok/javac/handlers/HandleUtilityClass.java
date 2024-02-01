package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.util.Iterator;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.UtilityClass;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
@HandlerPriority(-4096)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleUtilityClass.SCL.lombok */
public class HandleUtilityClass extends JavacAnnotationHandler<UtilityClass> {
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

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<UtilityClass> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.UTILITY_CLASS_FLAG_USAGE, "@UtilityClass");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, UtilityClass.class);
        JavacNode typeNode = annotationNode.up();
        if (checkLegality(typeNode, annotationNode)) {
            changeModifiersAndGenerateConstructor(annotationNode.up(), annotationNode);
        }
    }

    private static boolean checkLegality(JavacNode typeNode, JavacNode errorNode) {
        JCTree.JCClassDecl typeDef;
        JCTree.JCClassDecl typeDecl = null;
        if (typeNode.get() instanceof JCTree.JCClassDecl) {
            typeDecl = (JCTree.JCClassDecl) typeNode.get();
        }
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@UtilityClass is only supported on a class (can't be an interface, enum, or annotation).");
            return false;
        }
        JavacNode typeWalk = typeNode;
        do {
            typeWalk = typeWalk.up();
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[typeWalk.getKind().ordinal()]) {
                case 1:
                    return true;
                case 2:
                    typeDef = typeWalk.get();
                    break;
                default:
                    errorNode.addError("@UtilityClass cannot be placed on a method local or anonymous inner class, or any class nested in such a class.");
                    return false;
            }
        } while ((typeDef.mods.flags & 25096) != 0);
        if (typeWalk.up().getKind() == AST.Kind.COMPILATION_UNIT) {
            return true;
        }
        errorNode.addError("@UtilityClass automatically makes the class static, however, this class cannot be made static.");
        return false;
    }

    private void changeModifiersAndGenerateConstructor(JavacNode typeNode, JavacNode errorNode) {
        JCTree.JCClassDecl classDecl = typeNode.get();
        boolean makeConstructor = true;
        classDecl.mods.flags |= 16;
        boolean markStatic = true;
        if (typeNode.up().getKind() == AST.Kind.COMPILATION_UNIT) {
            markStatic = false;
        }
        if (markStatic && typeNode.up().getKind() == AST.Kind.TYPE) {
            JCTree.JCClassDecl typeDecl = typeNode.up().get();
            if ((typeDecl.mods.flags & 8704) != 0) {
                markStatic = false;
            }
        }
        if (markStatic) {
            classDecl.mods.flags |= 8;
        }
        Iterator<JavacNode> it = typeNode.down().iterator();
        while (it.hasNext()) {
            JavacNode element = it.next();
            if (element.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl fieldDecl = element.get();
                fieldDecl.mods.flags |= 8;
            } else if (element.getKind() == AST.Kind.METHOD) {
                JCTree.JCMethodDecl methodDecl = element.get();
                if (methodDecl.name.contentEquals("<init>") && JavacHandlerUtil.getGeneratedBy(methodDecl) == null && (methodDecl.mods.flags & 68719476736L) == 0) {
                    element.addError("@UtilityClasses cannot have declared constructors.");
                    makeConstructor = false;
                } else {
                    methodDecl.mods.flags |= 8;
                }
            } else if (element.getKind() == AST.Kind.TYPE) {
                JCTree.JCClassDecl innerClassDecl = element.get();
                innerClassDecl.mods.flags |= 8;
            }
        }
        if (makeConstructor) {
            createPrivateDefaultConstructor(typeNode);
        }
    }

    private void createPrivateDefaultConstructor(JavacNode typeNode) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCModifiers mods = maker.Modifiers(2L, List.nil());
        Name name = typeNode.toName("<init>");
        JCTree.JCBlock block = maker.Block(0L, createThrowStatement(typeNode, maker));
        JCTree.JCMethodDecl methodDef = maker.MethodDef(mods, name, null, List.nil(), List.nil(), List.nil(), block, null);
        JCTree.JCMethodDecl constructor = JavacHandlerUtil.recursiveSetGeneratedBy(methodDef, typeNode.get(), typeNode.getContext());
        JavacHandlerUtil.injectMethod(typeNode, constructor, List.nil(), Javac.createVoidType(typeNode.getSymbolTable(), Javac.CTC_VOID));
    }

    private List<JCTree.JCStatement> createThrowStatement(JavacNode typeNode, JavacTreeMaker maker) {
        JCTree.JCExpression exceptionType = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "UnsupportedOperationException");
        List<JCTree.JCExpression> jceBlank = List.nil();
        return List.of(maker.Throw(maker.NewClass(null, jceBlank, exceptionType, List.of(maker.Literal("This is a utility class and cannot be instantiated")), null)));
    }
}
