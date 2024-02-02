package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import java.util.Iterator;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;
import lombok.javac.JavacASTAdapter;
import lombok.javac.JavacNode;
@HandlerPriority(-2048)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/HandleFieldDefaults.SCL.lombok */
public class HandleFieldDefaults extends JavacASTAdapter {
    public boolean generateFieldDefaultsForType(JavacNode typeNode, JavacNode errorNode, AccessLevel level, boolean makeFinal, boolean checkForTypeLevelFieldDefaults) {
        if (checkForTypeLevelFieldDefaults && JavacHandlerUtil.hasAnnotation(FieldDefaults.class, typeNode)) {
            return true;
        }
        JCTree.JCClassDecl typeDecl = null;
        if (typeNode.get() instanceof JCTree.JCClassDecl) {
            typeDecl = (JCTree.JCClassDecl) typeNode.get();
        }
        long modifiers = typeDecl == null ? 0L : typeDecl.mods.flags;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@FieldDefaults is only supported on a class or an enum.");
            return false;
        }
        Iterator<JavacNode> it = typeNode.down().iterator();
        while (it.hasNext()) {
            JavacNode field = it.next();
            if (field.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl fieldDecl = field.get();
                if (!fieldDecl.name.toString().startsWith("$")) {
                    setFieldDefaultsForField(field, level, makeFinal);
                }
            }
        }
        return true;
    }

    public void setFieldDefaultsForField(JavacNode fieldNode, AccessLevel level, boolean makeFinal) {
        JCTree.JCVariableDecl field = fieldNode.get();
        if (level != null && level != AccessLevel.NONE && (field.mods.flags & 7) == 0 && !JavacHandlerUtil.hasAnnotationAndDeleteIfNeccessary(PackagePrivate.class, fieldNode) && (field.mods.flags & 8) == 0) {
            field.mods.flags |= JavacHandlerUtil.toJavacModifier(level);
        }
        if (makeFinal && (field.mods.flags & 16) == 0 && !JavacHandlerUtil.hasAnnotationAndDeleteIfNeccessary(NonFinal.class, fieldNode) && (field.mods.flags & 8) == 0) {
            field.mods.flags |= 16;
        }
        fieldNode.rebuild();
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitType(JavacNode typeNode, JCTree.JCClassDecl type) {
        AnnotationValues<FieldDefaults> fieldDefaults = null;
        JavacNode source = typeNode;
        boolean levelIsExplicit = false;
        boolean makeFinalIsExplicit = false;
        FieldDefaults fd = null;
        Iterator<JavacNode> it = typeNode.down().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JavacNode jn = it.next();
            if (jn.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation ann = jn.get();
                JCTree typeTree = ann.annotationType;
                if (typeTree == null) {
                    continue;
                } else {
                    String typeTreeToString = typeTree.toString();
                    if (typeTreeToString.equals("FieldDefaults") || typeTreeToString.equals("lombok.experimental.FieldDefaults")) {
                        if (JavacHandlerUtil.typeMatches(FieldDefaults.class, jn, typeTree)) {
                            source = jn;
                            fieldDefaults = JavacHandlerUtil.createAnnotation(FieldDefaults.class, jn);
                            levelIsExplicit = fieldDefaults.isExplicit("level");
                            makeFinalIsExplicit = fieldDefaults.isExplicit("makeFinal");
                            HandlerUtil.handleExperimentalFlagUsage(jn, ConfigurationKeys.FIELD_DEFAULTS_FLAG_USAGE, "@FieldDefaults");
                            fd = fieldDefaults.getInstance();
                            if (!levelIsExplicit && !makeFinalIsExplicit) {
                                jn.addError("This does nothing; provide either level or makeFinal or both.");
                            }
                            if (levelIsExplicit && fd.level() == AccessLevel.NONE) {
                                jn.addError("AccessLevel.NONE doesn't mean anything here. Pick another value.");
                                levelIsExplicit = false;
                            }
                            JavacHandlerUtil.deleteAnnotationIfNeccessary(jn, FieldDefaults.class);
                            JavacHandlerUtil.deleteImportFromCompilationUnit(jn, "lombok.AccessLevel");
                        }
                    }
                }
            }
        }
        if (fd != null || (type.mods.flags & 8704) == 0) {
            boolean defaultToPrivate = levelIsExplicit ? false : Boolean.TRUE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.FIELD_DEFAULTS_PRIVATE_EVERYWHERE));
            boolean defaultToFinal = makeFinalIsExplicit ? false : Boolean.TRUE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.FIELD_DEFAULTS_FINAL_EVERYWHERE));
            if (defaultToPrivate || defaultToFinal || fieldDefaults != null) {
                AccessLevel fdAccessLevel = (fieldDefaults == null || !levelIsExplicit) ? defaultToPrivate ? AccessLevel.PRIVATE : null : fd.level();
                boolean fdToFinal = (fieldDefaults == null || !makeFinalIsExplicit) ? defaultToFinal : fd.makeFinal();
                generateFieldDefaultsForType(typeNode, source, fdAccessLevel, fdToFinal, false);
            }
        }
    }
}
