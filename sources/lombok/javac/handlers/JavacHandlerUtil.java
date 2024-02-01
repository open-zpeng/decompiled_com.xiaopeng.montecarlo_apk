package lombok.javac.handlers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.gbl.consis.model.ChannelMessageGuideType;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Scope;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeScanner;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Options;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.jarvisproto.DMWait;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Data;
import lombok.Getter;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.CleanupTask;
import lombok.core.LombokImmutableList;
import lombok.core.TypeResolver;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.NullAnnotationLibrary;
import lombok.core.configuration.NullCheckExceptionType;
import lombok.core.configuration.TypeName;
import lombok.core.handlers.HandlerUtil;
import lombok.delombok.LombokOptionsFactory;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;
import lombok.javac.Javac;
import lombok.javac.JavacAugments;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.permit.Permit;
import org.tukaani.xz.common.Util;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil.SCL.lombok */
public class JavacHandlerUtil {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel;
    static final /* synthetic */ boolean $assertionsDisabled;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$MemberExistsResult.SCL.lombok */
    public enum MemberExistsResult {
        NOT_EXISTS,
        EXISTS_BY_LOMBOK,
        EXISTS_BY_USER;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static MemberExistsResult[] valuesCustom() {
            MemberExistsResult[] valuesCustom = values();
            int length = valuesCustom.length;
            MemberExistsResult[] memberExistsResultArr = new MemberExistsResult[length];
            System.arraycopy(valuesCustom, 0, memberExistsResultArr, 0, length);
            return memberExistsResultArr;
        }
    }

    static {
        $assertionsDisabled = !JavacHandlerUtil.class.desiredAssertionStatus();
    }

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel() {
        int[] iArr = $SWITCH_TABLE$lombok$AccessLevel;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AccessLevel.valuesCustom().length];
        try {
            iArr2[AccessLevel.MODULE.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AccessLevel.NONE.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AccessLevel.PACKAGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AccessLevel.PRIVATE.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AccessLevel.PROTECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AccessLevel.PUBLIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$lombok$AccessLevel = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind() {
        int[] iArr = $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Tree.Kind.values().length];
        try {
            iArr2[Tree.Kind.AND.ordinal()] = 64;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Tree.Kind.AND_ASSIGNMENT.ordinal()] = 77;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Tree.Kind.ANNOTATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_ACCESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_TYPE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Tree.Kind.ASSERT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Tree.Kind.ASSIGNMENT.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Tree.Kind.BITWISE_COMPLEMENT.ordinal()] = 48;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Tree.Kind.BLOCK.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[Tree.Kind.BOOLEAN_LITERAL.ordinal()] = 84;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[Tree.Kind.BREAK.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[Tree.Kind.CASE.ordinal()] = 8;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[Tree.Kind.CATCH.ordinal()] = 9;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[Tree.Kind.CHAR_LITERAL.ordinal()] = 85;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[Tree.Kind.CLASS.ordinal()] = 10;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[Tree.Kind.COMPILATION_UNIT.ordinal()] = 11;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_AND.ordinal()] = 67;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_EXPRESSION.ordinal()] = 12;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_OR.ordinal()] = 68;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[Tree.Kind.CONTINUE.ordinal()] = 13;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE.ordinal()] = 51;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE_ASSIGNMENT.ordinal()] = 70;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[Tree.Kind.DOUBLE_LITERAL.ordinal()] = 83;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[Tree.Kind.DO_WHILE_LOOP.ordinal()] = 14;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[Tree.Kind.EMPTY_STATEMENT.ordinal()] = 32;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[Tree.Kind.ENHANCED_FOR_LOOP.ordinal()] = 15;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[Tree.Kind.EQUAL_TO.ordinal()] = 62;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[Tree.Kind.ERRONEOUS.ordinal()] = 91;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[Tree.Kind.EXPRESSION_STATEMENT.ordinal()] = 16;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[Tree.Kind.EXTENDS_WILDCARD.ordinal()] = 89;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[Tree.Kind.FLOAT_LITERAL.ordinal()] = 82;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[Tree.Kind.FOR_LOOP.ordinal()] = 18;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN.ordinal()] = 59;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN_EQUAL.ordinal()] = 61;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[Tree.Kind.IDENTIFIER.ordinal()] = 19;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[Tree.Kind.IF.ordinal()] = 20;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[Tree.Kind.IMPORT.ordinal()] = 21;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[Tree.Kind.INSTANCE_OF.ordinal()] = 22;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[Tree.Kind.INT_LITERAL.ordinal()] = 80;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[Tree.Kind.LABELED_STATEMENT.ordinal()] = 23;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT.ordinal()] = 55;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT_ASSIGNMENT.ordinal()] = 74;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN.ordinal()] = 58;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN_EQUAL.ordinal()] = 60;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[Tree.Kind.LOGICAL_COMPLEMENT.ordinal()] = 49;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[Tree.Kind.LONG_LITERAL.ordinal()] = 81;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[Tree.Kind.MEMBER_SELECT.ordinal()] = 17;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[Tree.Kind.METHOD.ordinal()] = 24;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[Tree.Kind.METHOD_INVOCATION.ordinal()] = 25;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[Tree.Kind.MINUS.ordinal()] = 54;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[Tree.Kind.MINUS_ASSIGNMENT.ordinal()] = 73;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[Tree.Kind.MODIFIERS.ordinal()] = 26;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY.ordinal()] = 50;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY_ASSIGNMENT.ordinal()] = 69;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[Tree.Kind.NEW_ARRAY.ordinal()] = 27;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[Tree.Kind.NEW_CLASS.ordinal()] = 28;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[Tree.Kind.NOT_EQUAL_TO.ordinal()] = 63;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[Tree.Kind.NULL_LITERAL.ordinal()] = 87;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[Tree.Kind.OR.ordinal()] = 66;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[Tree.Kind.OR_ASSIGNMENT.ordinal()] = 79;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[Tree.Kind.OTHER.ordinal()] = 92;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[Tree.Kind.PARAMETERIZED_TYPE.ordinal()] = 37;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[Tree.Kind.PARENTHESIZED.ordinal()] = 29;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[Tree.Kind.PLUS.ordinal()] = 53;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[Tree.Kind.PLUS_ASSIGNMENT.ordinal()] = 72;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_DECREMENT.ordinal()] = 43;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_INCREMENT.ordinal()] = 42;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_DECREMENT.ordinal()] = 45;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_INCREMENT.ordinal()] = 44;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[Tree.Kind.PRIMITIVE_TYPE.ordinal()] = 30;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER.ordinal()] = 52;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER_ASSIGNMENT.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[Tree.Kind.RETURN.ordinal()] = 31;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT.ordinal()] = 56;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 75;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[Tree.Kind.STRING_LITERAL.ordinal()] = 86;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[Tree.Kind.SUPER_WILDCARD.ordinal()] = 90;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[Tree.Kind.SWITCH.ordinal()] = 33;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[Tree.Kind.SYNCHRONIZED.ordinal()] = 34;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[Tree.Kind.THROW.ordinal()] = 35;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[Tree.Kind.TRY.ordinal()] = 36;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[Tree.Kind.TYPE_CAST.ordinal()] = 38;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[Tree.Kind.TYPE_PARAMETER.ordinal()] = 39;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[Tree.Kind.UNARY_MINUS.ordinal()] = 47;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[Tree.Kind.UNARY_PLUS.ordinal()] = 46;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[Tree.Kind.UNBOUNDED_WILDCARD.ordinal()] = 88;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT.ordinal()] = 57;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 76;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[Tree.Kind.VARIABLE.ordinal()] = 40;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[Tree.Kind.WHILE_LOOP.ordinal()] = 41;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[Tree.Kind.XOR.ordinal()] = 65;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[Tree.Kind.XOR_ASSIGNMENT.ordinal()] = 78;
        } catch (NoSuchFieldError unused92) {
        }
        $SWITCH_TABLE$com$sun$source$tree$Tree$Kind = iArr2;
        return iArr2;
    }

    private JavacHandlerUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$MarkingScanner.SCL.lombok */
    public static class MarkingScanner extends TreeScanner {
        private final JCTree source;
        private final Context context;

        MarkingScanner(JCTree source, Context context) {
            this.source = source;
            this.context = context;
        }

        public void scan(JCTree tree) {
            if (tree == null) {
                return;
            }
            JavacHandlerUtil.setGeneratedBy(tree, this.source, this.context);
            super.scan(tree);
        }
    }

    public static boolean inNetbeansEditor(JavacNode node) {
        return inNetbeansEditor(node.getContext());
    }

    public static boolean inNetbeansEditor(Context context) {
        Options options = Options.instance(context);
        return options.keySet().contains("ide") && !options.keySet().contains("backgroundCompilation");
    }

    public static boolean inNetbeansCompileOnSave(Context context) {
        Options options = Options.instance(context);
        return options.keySet().contains("ide") && options.keySet().contains("backgroundCompilation");
    }

    public static JCTree getGeneratedBy(JCTree node) {
        return JavacAugments.JCTree_generatedNode.get(node);
    }

    public static boolean isGenerated(JCTree node) {
        return getGeneratedBy(node) != null;
    }

    public static <T extends JCTree> T recursiveSetGeneratedBy(T node, JCTree source, Context context) {
        if (node == null) {
            return null;
        }
        setGeneratedBy(node, source, context);
        node.accept(new MarkingScanner(source, context));
        return node;
    }

    public static <T extends JCTree> T setGeneratedBy(T node, JCTree source, Context context) {
        if (node == null) {
            return null;
        }
        if (source == null) {
            JavacAugments.JCTree_generatedNode.clear(node);
        } else {
            JavacAugments.JCTree_generatedNode.set(node, source);
        }
        if (source != null && (!inNetbeansEditor(context) || ((node instanceof JCTree.JCVariableDecl) && (((JCTree.JCVariableDecl) node).mods.flags & 8589934592L) != 0))) {
            ((JCTree) node).pos = source.pos;
        }
        return node;
    }

    public static boolean hasAnnotation(String type, JavacNode node) {
        return hasAnnotation(type, node, false);
    }

    public static boolean hasAnnotation(Class<? extends Annotation> type, JavacNode node) {
        return hasAnnotation(type, node, false);
    }

    public static boolean hasAnnotationAndDeleteIfNeccessary(Class<? extends Annotation> type, JavacNode node) {
        return hasAnnotation(type, node, true);
    }

    private static boolean hasAnnotation(Class<? extends Annotation> type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<JavacNode> it = node.down().iterator();
                while (it.hasNext()) {
                    JavacNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                            return true;
                        }
                        return true;
                    }
                }
                return false;
            case 4:
            case 6:
            default:
                return false;
        }
    }

    private static boolean hasAnnotation(String type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<JavacNode> it = node.down().iterator();
                while (it.hasNext()) {
                    JavacNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                            return true;
                        }
                        return true;
                    }
                }
                return false;
            case 4:
            case 6:
            default:
                return false;
        }
    }

    public static JavacNode findInnerClass(JavacNode parent, String name) {
        Iterator<JavacNode> it = parent.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.TYPE) {
                JCTree.JCClassDecl td = child.get();
                if (td.name.contentEquals(name)) {
                    return child;
                }
            }
        }
        return null;
    }

    public static JavacNode findAnnotation(Class<? extends Annotation> type, JavacNode node) {
        return findAnnotation(type, node, false);
    }

    public static JavacNode findAnnotation(Class<? extends Annotation> type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return null;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<JavacNode> it = node.down().iterator();
                while (it.hasNext()) {
                    JavacNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                        }
                        return child;
                    }
                }
                return null;
            case 4:
            case 6:
            default:
                return null;
        }
    }

    public static boolean annotationTypeMatches(Class<? extends Annotation> type, JavacNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().annotationType);
    }

    public static boolean annotationTypeMatches(String type, JavacNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().annotationType);
    }

    public static boolean typeMatches(Class<?> type, JavacNode node, JCTree typeNode) {
        return typeMatches(type.getName(), node, typeNode);
    }

    public static boolean typeMatches(String type, JavacNode node, JCTree typeNode) {
        String typeName = typeNode == null ? null : typeNode.toString();
        if (typeName == null || typeName.length() == 0) {
            return false;
        }
        int lastIndexA = typeName.lastIndexOf(46) + 1;
        int lastIndexB = Math.max(type.lastIndexOf(46), type.lastIndexOf(36)) + 1;
        int len = typeName.length() - lastIndexA;
        if (len != type.length() - lastIndexB) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (typeName.charAt(i + lastIndexA) != type.charAt(i + lastIndexB)) {
                return false;
            }
        }
        TypeResolver resolver = node.getImportListAsTypeResolver();
        return resolver.typeMatches(node, type, typeName);
    }

    public static boolean isFieldDeprecated(JavacNode field) {
        if (field.get() instanceof JCTree.JCVariableDecl) {
            JCTree.JCVariableDecl fieldNode = field.get();
            if ((fieldNode.mods.flags & 131072) != 0) {
                return true;
            }
            Iterator<JavacNode> it = field.down().iterator();
            while (it.hasNext()) {
                JavacNode child = it.next();
                if (annotationTypeMatches(Deprecated.class, child)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static CheckerFrameworkVersion getCheckerFrameworkVersion(JavacNode node) {
        CheckerFrameworkVersion cfv = (CheckerFrameworkVersion) node.getAst().readConfiguration(ConfigurationKeys.CHECKER_FRAMEWORK);
        return cfv == null ? CheckerFrameworkVersion.NONE : cfv;
    }

    public static boolean nodeHasDeprecatedFlag(JCTree node) {
        return node instanceof JCTree.JCVariableDecl ? (((JCTree.JCVariableDecl) node).mods.flags & 131072) != 0 : node instanceof JCTree.JCMethodDecl ? (((JCTree.JCMethodDecl) node).mods.flags & 131072) != 0 : (node instanceof JCTree.JCClassDecl) && (((JCTree.JCClassDecl) node).mods.flags & 131072) != 0;
    }

    public static <A extends Annotation> AnnotationValues<A> createAnnotation(Class<A> type, JavacNode node) {
        return createAnnotation(type, node.get(), node);
    }

    public static <A extends Annotation> AnnotationValues<A> createAnnotation(Class<A> type, JCTree.JCAnnotation anno, final JavacNode node) {
        Method[] declaredMethods;
        Object rhs;
        String mName;
        Map<String, AnnotationValues.AnnotationValue> values = new HashMap<>();
        List<JCTree.JCExpression> arguments = anno.getArguments();
        Iterator it = arguments.iterator();
        while (it.hasNext()) {
            Object obj = (JCTree.JCExpression) it.next();
            java.util.List<String> raws = new ArrayList<>();
            java.util.List<Object> guesses = new ArrayList<>();
            java.util.List<Object> expressions = new ArrayList<>();
            final java.util.List<JCDiagnostic.DiagnosticPosition> positions = new ArrayList<>();
            if (obj instanceof JCTree.JCAssign) {
                JCTree.JCAssign assign = (JCTree.JCAssign) obj;
                mName = assign.lhs.toString();
                rhs = assign.rhs;
            } else {
                rhs = obj;
                mName = "value";
            }
            if (rhs instanceof JCTree.JCNewArray) {
                List<JCTree.JCExpression> elems = ((JCTree.JCNewArray) rhs).elems;
                Iterator it2 = elems.iterator();
                while (it2.hasNext()) {
                    JCTree.JCAnnotation jCAnnotation = (JCTree.JCExpression) it2.next();
                    raws.add(jCAnnotation.toString());
                    expressions.add(jCAnnotation);
                    if (jCAnnotation instanceof JCTree.JCAnnotation) {
                        try {
                            guesses.add(createAnnotation(Class.forName(((JCTree.JCExpression) jCAnnotation).type.toString()), jCAnnotation, node));
                        } catch (ClassNotFoundException unused) {
                            guesses.add(Javac.calculateGuess(jCAnnotation));
                        }
                    } else {
                        guesses.add(Javac.calculateGuess(jCAnnotation));
                    }
                    positions.add(jCAnnotation.pos());
                }
            } else {
                raws.add(rhs.toString());
                expressions.add(rhs);
                if (rhs instanceof JCTree.JCAnnotation) {
                    try {
                        guesses.add(createAnnotation(Class.forName(rhs.type.toString()), rhs, node));
                    } catch (ClassNotFoundException unused2) {
                        guesses.add(Javac.calculateGuess(rhs));
                    }
                } else {
                    guesses.add(Javac.calculateGuess(rhs));
                }
                positions.add(rhs.pos());
            }
            values.put(mName, new AnnotationValues.AnnotationValue(node, raws, expressions, guesses, true) { // from class: lombok.javac.handlers.JavacHandlerUtil.1
                @Override // lombok.core.AnnotationValues.AnnotationValue
                public void setError(String message, int valueIdx) {
                    if (valueIdx >= 0) {
                        node.addError(message, (JCDiagnostic.DiagnosticPosition) positions.get(valueIdx));
                    } else {
                        node.addError(message);
                    }
                }

                @Override // lombok.core.AnnotationValues.AnnotationValue
                public void setWarning(String message, int valueIdx) {
                    if (valueIdx >= 0) {
                        node.addWarning(message, (JCDiagnostic.DiagnosticPosition) positions.get(valueIdx));
                    } else {
                        node.addWarning(message);
                    }
                }
            });
        }
        for (Method m : type.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                String name = m.getName();
                if (!values.containsKey(name)) {
                    values.put(name, new AnnotationValues.AnnotationValue(node, new ArrayList(), new ArrayList(), new ArrayList(), false) { // from class: lombok.javac.handlers.JavacHandlerUtil.2
                        @Override // lombok.core.AnnotationValues.AnnotationValue
                        public void setError(String message, int valueIdx) {
                            node.addError(message);
                        }

                        @Override // lombok.core.AnnotationValues.AnnotationValue
                        public void setWarning(String message, int valueIdx) {
                            node.addWarning(message);
                        }
                    });
                }
            }
        }
        return new AnnotationValues<>(type, values, node);
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, String annotationType) {
        deleteAnnotationIfNeccessary0(annotation, annotationType);
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType) {
        deleteAnnotationIfNeccessary0(annotation, annotationType.getName());
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType1, Class<? extends Annotation> annotationType2) {
        deleteAnnotationIfNeccessary0(annotation, annotationType1.getName(), annotationType2.getName());
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType1, String annotationType2) {
        deleteAnnotationIfNeccessary0(annotation, annotationType1.getName(), annotationType2);
    }

    private static void deleteAnnotationIfNeccessary0(JavacNode annotation, String... annotationTypes) {
        if (!inNetbeansEditor(annotation) && annotation.shouldDeleteLombokAnnotations()) {
            JavacNode parentNode = annotation.directUp();
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[parentNode.getKind().ordinal()]) {
                case 2:
                    try {
                        JCTree.JCClassDecl type = parentNode.get();
                        type.mods.annotations = filterList(type.mods.annotations, annotation.get());
                        break;
                    } catch (ClassCastException unused) {
                        break;
                    }
                case 3:
                case 7:
                case 8:
                    JCTree.JCVariableDecl variable = parentNode.get();
                    variable.mods.annotations = filterList(variable.mods.annotations, annotation.get());
                    break;
                case 4:
                case 6:
                default:
                    return;
                case 5:
                    JCTree.JCMethodDecl method = parentNode.get();
                    method.mods.annotations = filterList(method.mods.annotations, annotation.get());
                    break;
            }
            parentNode.getAst().setChanged();
            for (String annotationType : annotationTypes) {
                deleteImportFromCompilationUnit(annotation, annotationType);
            }
        }
    }

    public static void deleteImportFromCompilationUnit(JavacNode node, String name) {
        if (!inNetbeansEditor(node) && node.shouldDeleteLombokAnnotations()) {
            ListBuffer<JCTree> newDefs = new ListBuffer<>();
            JCTree.JCCompilationUnit unit = node.top().get();
            Iterator it = unit.defs.iterator();
            while (it.hasNext()) {
                JCTree.JCImport jCImport = (JCTree) it.next();
                boolean delete = false;
                if (jCImport instanceof JCTree.JCImport) {
                    JCTree.JCImport imp0rt = jCImport;
                    delete = !imp0rt.staticImport && imp0rt.qualid.toString().equals(name);
                }
                if (!delete) {
                    newDefs.append(jCImport);
                }
            }
            unit.defs = newDefs.toList();
        }
    }

    private static List<JCTree.JCAnnotation> filterList(List<JCTree.JCAnnotation> annotations, JCTree jcTree) {
        ListBuffer<JCTree.JCAnnotation> newAnnotations = new ListBuffer<>();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
            if (jcTree != ann) {
                newAnnotations.append(ann);
            }
        }
        return newAnnotations.toList();
    }

    public static java.util.List<String> toAllGetterNames(JavacNode field) {
        return HandlerUtil.toAllGetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toGetterName(JavacNode field) {
        return HandlerUtil.toGetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllSetterNames(JavacNode field) {
        return HandlerUtil.toAllSetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toSetterName(JavacNode field) {
        return HandlerUtil.toSetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithNames(JavacNode field) {
        return HandlerUtil.toAllWithNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithByNames(JavacNode field) {
        return HandlerUtil.toAllWithByNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toWithName(JavacNode field) {
        return HandlerUtil.toWithName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toWithByName(JavacNode field) {
        return HandlerUtil.toWithByName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static boolean shouldReturnThis(JavacNode field) {
        if ((field.get().mods.flags & 8) != 0) {
            return false;
        }
        AnnotationValues<Accessors> accessors = getAccessorsForField(field);
        return HandlerUtil.shouldReturnThis0(accessors, field.getAst());
    }

    public static JCTree.JCExpression cloneSelfType(JavacNode childOfType) {
        JavacNode typeNode = childOfType;
        JavacTreeMaker maker = childOfType.getTreeMaker();
        while (typeNode != null && typeNode.getKind() != AST.Kind.TYPE) {
            typeNode = typeNode.up();
        }
        return namePlusTypeParamsToTypeReference(maker, typeNode, typeNode.get().typarams);
    }

    public static boolean isBoolean(JavacNode field) {
        JCTree.JCExpression varType = field.get().vartype;
        return isBoolean(varType);
    }

    public static boolean isBoolean(JCTree.JCExpression varType) {
        return varType != null && varType.toString().equals(TypedValues.Custom.S_BOOLEAN);
    }

    public static Name removePrefixFromField(JavacNode field) {
        CharSequence newName;
        java.util.List<String> prefixes = null;
        Iterator<JavacNode> it = field.down().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JavacNode node = it.next();
            if (annotationTypeMatches(Accessors.class, node)) {
                AnnotationValues<Accessors> ann = createAnnotation(Accessors.class, node);
                if (ann.isExplicit(RequestParameters.PREFIX)) {
                    prefixes = Arrays.asList(ann.getInstance().prefix());
                }
            }
        }
        if (prefixes == null) {
            JavacNode up = field.up();
            while (true) {
                JavacNode current = up;
                if (current == null) {
                    break;
                }
                Iterator<JavacNode> it2 = current.down().iterator();
                while (it2.hasNext()) {
                    JavacNode node2 = it2.next();
                    if (annotationTypeMatches(Accessors.class, node2)) {
                        AnnotationValues<Accessors> ann2 = createAnnotation(Accessors.class, node2);
                        if (ann2.isExplicit(RequestParameters.PREFIX)) {
                            prefixes = Arrays.asList(ann2.getInstance().prefix());
                        }
                    }
                }
                up = current.up();
            }
        }
        if (prefixes == null) {
            prefixes = (java.util.List) field.getAst().readConfiguration(ConfigurationKeys.ACCESSORS_PREFIX);
        }
        return (prefixes.isEmpty() || (newName = HandlerUtil.removePrefix(field.getName(), prefixes)) == null) ? field.get().name : field.toName(newName.toString());
    }

    public static AnnotationValues<Accessors> getAccessorsForField(JavacNode field) {
        Iterator<JavacNode> it = field.down().iterator();
        while (it.hasNext()) {
            JavacNode node = it.next();
            if (annotationTypeMatches(Accessors.class, node)) {
                return createAnnotation(Accessors.class, node);
            }
        }
        JavacNode up = field.up();
        while (true) {
            JavacNode current = up;
            if (current != null) {
                Iterator<JavacNode> it2 = current.down().iterator();
                while (it2.hasNext()) {
                    JavacNode node2 = it2.next();
                    if (annotationTypeMatches(Accessors.class, node2)) {
                        return createAnnotation(Accessors.class, node2);
                    }
                }
                up = current.up();
            } else {
                return AnnotationValues.of(Accessors.class, field);
            }
        }
    }

    public static MemberExistsResult fieldExists(String fieldName, JavacNode node) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            Iterator it = node2.get().defs.iterator();
            while (it.hasNext()) {
                JCTree.JCVariableDecl jCVariableDecl = (JCTree) it.next();
                if ((jCVariableDecl instanceof JCTree.JCVariableDecl) && jCVariableDecl.name.contentEquals(fieldName)) {
                    return getGeneratedBy(jCVariableDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static MemberExistsResult methodExists(String methodName, JavacNode node, int params) {
        return methodExists(methodName, node, true, params);
    }

    public static MemberExistsResult methodExists(String methodName, JavacNode node, boolean caseSensitive, int params) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            Iterator it = node2.get().defs.iterator();
            while (it.hasNext()) {
                JCTree.JCMethodDecl jCMethodDecl = (JCTree) it.next();
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    String name = md.name.toString();
                    boolean matches = caseSensitive ? name.equals(methodName) : name.equalsIgnoreCase(methodName);
                    if (matches) {
                        if (params > -1) {
                            List<JCTree.JCVariableDecl> ps = md.params;
                            int minArgs = 0;
                            int maxArgs = 0;
                            if (ps != null && ps.length() > 0) {
                                minArgs = ps.length();
                                if ((((JCTree.JCVariableDecl) ps.last()).mods.flags & Util.BACKWARD_SIZE_MAX) != 0) {
                                    maxArgs = Integer.MAX_VALUE;
                                    minArgs--;
                                } else {
                                    maxArgs = minArgs;
                                }
                            }
                            if (params >= minArgs && params <= maxArgs) {
                            }
                        }
                        if (!isTolerate(node2, md)) {
                            return getGeneratedBy(jCMethodDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static boolean isTolerate(JavacNode node, JCTree.JCMethodDecl md) {
        List<JCTree.JCAnnotation> annotations = md.getModifiers().getAnnotations();
        if (annotations != null) {
            Iterator it = annotations.iterator();
            while (it.hasNext()) {
                JCTree.JCAnnotation anno = (JCTree.JCAnnotation) it.next();
                if (typeMatches(Tolerate.class, node, anno.getAnnotationType())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static MemberExistsResult constructorExists(JavacNode node) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            Iterator it = node2.get().defs.iterator();
            while (it.hasNext()) {
                JCTree.JCMethodDecl jCMethodDecl = (JCTree) it.next();
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    if (md.name.contentEquals("<init>") && (md.mods.flags & 68719476736L) == 0 && !isTolerate(node2, md)) {
                        return getGeneratedBy(jCMethodDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static boolean isConstructorCall(JCTree.JCStatement statement) {
        String name;
        if (statement instanceof JCTree.JCExpressionStatement) {
            JCTree.JCMethodInvocation jCMethodInvocation = ((JCTree.JCExpressionStatement) statement).expr;
            if (jCMethodInvocation instanceof JCTree.JCMethodInvocation) {
                JCTree.JCFieldAccess jCFieldAccess = jCMethodInvocation.meth;
                if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                    name = jCFieldAccess.name.toString();
                } else if (jCFieldAccess instanceof JCTree.JCIdent) {
                    name = ((JCTree.JCIdent) jCFieldAccess).name.toString();
                } else {
                    name = "";
                }
                return "super".equals(name) || "this".equals(name);
            }
            return false;
        }
        return false;
    }

    public static int toJavacModifier(AccessLevel accessLevel) {
        switch ($SWITCH_TABLE$lombok$AccessLevel()[accessLevel.ordinal()]) {
            case 1:
            default:
                return 1;
            case 2:
            case 4:
                return 0;
            case 3:
                return 4;
            case 5:
            case 6:
                return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$GetterMethod.SCL.lombok */
    public static class GetterMethod {
        private final Name name;
        private final JCTree.JCExpression type;

        GetterMethod(Name name, JCTree.JCExpression type) {
            this.name = name;
            this.type = type;
        }
    }

    private static GetterMethod findGetter(JavacNode field) {
        String getterName;
        JavacNode containingType;
        JCTree.JCVariableDecl decl = field.get();
        JavacNode typeNode = field.up();
        for (String potentialGetterName : toAllGetterNames(field)) {
            Iterator<JavacNode> it = typeNode.down().iterator();
            while (it.hasNext()) {
                JavacNode potentialGetter = it.next();
                if (potentialGetter.getKind() == AST.Kind.METHOD) {
                    JCTree.JCMethodDecl method = potentialGetter.get();
                    if (method.name.toString().equalsIgnoreCase(potentialGetterName) && (method.mods.flags & 8) == 0 && (method.params == null || method.params.size() <= 0)) {
                        return new GetterMethod(method.name, method.restype);
                    }
                }
            }
        }
        boolean hasGetterAnnotation = false;
        Iterator<JavacNode> it2 = field.down().iterator();
        while (it2.hasNext()) {
            JavacNode child = it2.next();
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches(Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().value() == AccessLevel.NONE) {
                    return null;
                }
                hasGetterAnnotation = true;
            }
        }
        if (!hasGetterAnnotation && HandleGetter.fieldQualifiesForGetterGeneration(field) && (containingType = field.up()) != null) {
            Iterator<JavacNode> it3 = containingType.down().iterator();
            while (it3.hasNext()) {
                JavacNode child2 = it3.next();
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches(Data.class, child2)) {
                    hasGetterAnnotation = true;
                }
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches(Getter.class, child2)) {
                    AnnotationValues<Getter> ann2 = createAnnotation(Getter.class, child2);
                    if (ann2.getInstance().value() == AccessLevel.NONE) {
                        return null;
                    }
                    hasGetterAnnotation = true;
                }
            }
        }
        if (!hasGetterAnnotation || (getterName = toGetterName(field)) == null) {
            return null;
        }
        return new GetterMethod(field.toName(getterName), decl.vartype);
    }

    static boolean lookForGetter(JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        if (fieldAccess == HandlerUtil.FieldAccess.GETTER) {
            return true;
        }
        if (fieldAccess == HandlerUtil.FieldAccess.ALWAYS_FIELD) {
            return false;
        }
        Iterator<JavacNode> it = field.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches(Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().lazy()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCExpression getFieldType(JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        if (field.getKind() == AST.Kind.METHOD) {
            return field.get().restype;
        }
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        if (getter != null) {
            return getter.type;
        }
        return field.get().vartype;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCExpression createFieldAccessor(JavacTreeMaker maker, JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        return createFieldAccessor(maker, field, fieldAccess, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCExpression createFieldAccessor(JavacTreeMaker maker, JavacNode field, HandlerUtil.FieldAccess fieldAccess, JCTree.JCExpression receiver) {
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        JCTree.JCVariableDecl fieldDecl = field.get();
        if (getter == null) {
            if (receiver == null) {
                if ((fieldDecl.mods.flags & 8) == 0) {
                    receiver = maker.Ident(field.toName("this"));
                } else {
                    JavacNode containerNode = field.up();
                    if (containerNode != null && (containerNode.get() instanceof JCTree.JCClassDecl)) {
                        JCTree.JCClassDecl container = field.up().get();
                        receiver = maker.Ident(container.name);
                    }
                }
            }
            return receiver == null ? maker.Ident(fieldDecl.name) : maker.Select(receiver, fieldDecl.name);
        }
        if (receiver == null) {
            receiver = maker.Ident(field.toName("this"));
        }
        JCTree.JCMethodInvocation call = maker.Apply(List.nil(), maker.Select(receiver, getter.name), List.nil());
        return call;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCExpression createMethodAccessor(JavacTreeMaker maker, JavacNode method) {
        return createMethodAccessor(maker, method, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCExpression createMethodAccessor(JavacTreeMaker maker, JavacNode method, JCTree.JCExpression receiver) {
        JavacNode containerNode;
        JCTree.JCMethodDecl methodDecl = method.get();
        if (receiver == null && (methodDecl.mods.flags & 8) == 0) {
            receiver = maker.Ident(method.toName("this"));
        } else if (receiver == null && (containerNode = method.up()) != null && (containerNode.get() instanceof JCTree.JCClassDecl)) {
            JCTree.JCClassDecl container = method.up().get();
            receiver = maker.Ident(container.name);
        }
        JCTree.JCMethodInvocation call = maker.Apply(List.nil(), receiver == null ? maker.Ident(methodDecl.name) : maker.Select(receiver, methodDecl.name), List.nil());
        return call;
    }

    public static Type getMirrorForFieldType(JavacNode fieldNode) {
        Symbol.VarSymbol element = fieldNode.getElement();
        if (element instanceof Symbol.VarSymbol) {
            return element.type;
        }
        return null;
    }

    public static JavacNode injectFieldAndMarkGenerated(JavacNode typeNode, JCTree.JCVariableDecl field) {
        return injectField(typeNode, field, true);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field) {
        return injectField(typeNode, field, false);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field, boolean addGenerated) {
        return injectField(typeNode, field, addGenerated, false);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field, boolean addGenerated, boolean specialEnumHandling) {
        List<JCTree> insertBefore;
        JCTree.JCClassDecl type = typeNode.get();
        if (addGenerated) {
            addSuppressWarningsAll(field.mods, typeNode, field.pos, getGeneratedBy(field), typeNode.getContext());
            addGenerated(field.mods, typeNode, field.pos, getGeneratedBy(field), typeNode.getContext());
        }
        List<JCTree> insertAfter = null;
        List<JCTree> list = type.defs;
        while (true) {
            insertBefore = list;
            boolean skip = false;
            if (insertBefore.head instanceof JCTree.JCVariableDecl) {
                JCTree.JCVariableDecl f = (JCTree.JCVariableDecl) insertBefore.head;
                if ((!specialEnumHandling && isEnumConstant(f)) || isGenerated(f)) {
                    skip = true;
                }
            } else if ((insertBefore.head instanceof JCTree.JCMethodDecl) && (((JCTree.JCMethodDecl) insertBefore.head).mods.flags & 68719476736L) != 0) {
                skip = true;
            }
            if (!skip) {
                break;
            }
            insertAfter = insertBefore;
            list = insertBefore.tail;
        }
        List<JCTree> fieldEntry = List.of(field);
        fieldEntry.tail = insertBefore;
        if (insertAfter == null) {
            type.defs = fieldEntry;
        } else {
            insertAfter.tail = fieldEntry;
        }
        return typeNode.add(field, AST.Kind.FIELD);
    }

    public static boolean isEnumConstant(JCTree.JCVariableDecl field) {
        return (field.mods.flags & 16384) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotatedTypeReflect.SCL.lombok */
    public static class JCAnnotatedTypeReflect {
        private static Class<?> TYPE;
        private static Constructor<?> CONSTRUCTOR;
        private static Field ANNOTATIONS;
        private static Field UNDERLYING_TYPE;

        JCAnnotatedTypeReflect() {
        }

        private static void initByLoader(ClassLoader classLoader) {
            if (TYPE != null) {
                return;
            }
            try {
                Class<?> c = classLoader.loadClass("com.sun.tools.javac.tree.JCTree$JCAnnotatedType");
                init(c);
            } catch (Exception unused) {
            }
        }

        private static void init(Class<?> in) {
            if (TYPE == null && in.getName().equals("com.sun.tools.javac.tree.JCTree$JCAnnotatedType")) {
                try {
                    CONSTRUCTOR = Permit.getConstructor(in, List.class, JCTree.JCExpression.class);
                    ANNOTATIONS = Permit.getField(in, "annotations");
                    UNDERLYING_TYPE = Permit.getField(in, "underlyingType");
                    TYPE = in;
                } catch (Exception unused) {
                }
            }
        }

        static boolean is(JCTree obj) {
            if (obj == null) {
                return false;
            }
            init(obj.getClass());
            return obj.getClass() == TYPE;
        }

        static List<JCTree.JCAnnotation> getAnnotations(JCTree obj) {
            init(obj.getClass());
            try {
                return (List) ANNOTATIONS.get(obj);
            } catch (Exception unused) {
                return List.nil();
            }
        }

        static void setAnnotations(JCTree obj, List<JCTree.JCAnnotation> anns) {
            init(obj.getClass());
            try {
                ANNOTATIONS.set(obj, anns);
            } catch (Exception unused) {
            }
        }

        static JCTree.JCExpression getUnderlyingType(JCTree obj) {
            init(obj.getClass());
            try {
                return (JCTree.JCExpression) UNDERLYING_TYPE.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }

        static JCTree.JCExpression create(List<JCTree.JCAnnotation> annotations, JCTree.JCExpression underlyingType) {
            initByLoader(underlyingType.getClass().getClassLoader());
            try {
                return (JCTree.JCExpression) CONSTRUCTOR.newInstance(annotations, underlyingType);
            } catch (Exception unused) {
                return underlyingType;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotationReflect.SCL.lombok */
    public static class JCAnnotationReflect {
        private static Field ATTRIBUTE;

        JCAnnotationReflect() {
        }

        static {
            try {
                ATTRIBUTE = Permit.getField(JCTree.JCAnnotation.class, "attribute");
            } catch (Exception unused) {
            }
        }

        static Attribute.Compound getAttribute(JCTree.JCAnnotation jcAnnotation) {
            try {
                return (Attribute.Compound) ATTRIBUTE.get(jcAnnotation);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$ClassSymbolMembersField.SCL.lombok */
    public static class ClassSymbolMembersField {
        private static final Field membersField;
        private static final Method removeMethod;
        private static final Method enterMethod;

        ClassSymbolMembersField() {
        }

        static {
            Field f = null;
            Method r = null;
            Method e = null;
            try {
                f = Permit.getField(Symbol.ClassSymbol.class, "members_field");
                r = Permit.getMethod(f.getType(), "remove", Symbol.class);
                e = Permit.getMethod(f.getType(), DMWait.STATUS_ENTER, Symbol.class);
            } catch (Exception unused) {
            }
            membersField = f;
            removeMethod = r;
            enterMethod = e;
        }

        static void remove(Symbol.ClassSymbol from, Symbol toRemove) {
            if (from == null) {
                return;
            }
            try {
                Scope scope = (Scope) membersField.get(from);
                if (scope == null) {
                    return;
                }
                removeMethod.invoke(scope, toRemove);
            } catch (Exception unused) {
            }
        }

        static void enter(Symbol.ClassSymbol from, Symbol toEnter) {
            if (from == null) {
                return;
            }
            try {
                Scope scope = (Scope) membersField.get(from);
                if (scope == null) {
                    return;
                }
                enterMethod.invoke(scope, toEnter);
            } catch (Exception unused) {
            }
        }
    }

    public static void injectMethod(JavacNode typeNode, JCTree.JCMethodDecl method) {
        injectMethod(typeNode, method, null, null);
    }

    public static void injectMethod(JavacNode typeNode, JCTree.JCMethodDecl method, List<Type> paramTypes, Type returnType) {
        Context context = typeNode.getContext();
        Symtab symtab = Symtab.instance(context);
        JCTree.JCClassDecl type = typeNode.get();
        if (method.getName().contentEquals("<init>")) {
            int idx = 0;
            Iterator it = type.defs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JCTree.JCMethodDecl jCMethodDecl = (JCTree) it.next();
                if ((jCMethodDecl instanceof JCTree.JCMethodDecl) && (jCMethodDecl.mods.flags & 68719476736L) != 0) {
                    JavacNode tossMe = typeNode.getNodeFor(jCMethodDecl);
                    if (tossMe != null) {
                        tossMe.up().removeChild(tossMe);
                    }
                    type.defs = addAllButOne(type.defs, idx);
                    ClassSymbolMembersField.remove(type.sym, jCMethodDecl.sym);
                } else {
                    idx++;
                }
            }
        }
        addSuppressWarningsAll(method.mods, typeNode, method.pos, getGeneratedBy(method), typeNode.getContext());
        addGenerated(method.mods, typeNode, method.pos, getGeneratedBy(method), typeNode.getContext());
        type.defs = type.defs.append(method);
        List<Symbol.VarSymbol> params = null;
        if (method.getParameters() != null && !method.getParameters().isEmpty()) {
            ListBuffer<Symbol.VarSymbol> newParams = new ListBuffer<>();
            for (int i = 0; i < method.getParameters().size(); i++) {
                JCTree.JCVariableDecl param = (JCTree.JCVariableDecl) method.getParameters().get(i);
                if (param.sym == null) {
                    Type paramType = paramTypes == null ? param.getType().type : (Type) paramTypes.get(i);
                    Symbol.VarSymbol varSymbol = new Symbol.VarSymbol(param.mods.flags, param.name, paramType, symtab.noSymbol);
                    List<JCTree.JCAnnotation> annotations = param.getModifiers().getAnnotations();
                    if (annotations != null && !annotations.isEmpty()) {
                        ListBuffer<Attribute.Compound> newAnnotations = new ListBuffer<>();
                        Iterator it2 = annotations.iterator();
                        while (it2.hasNext()) {
                            JCTree.JCAnnotation jcAnnotation = (JCTree.JCAnnotation) it2.next();
                            Attribute.Compound attribute = JCAnnotationReflect.getAttribute(jcAnnotation);
                            if (attribute != null) {
                                newAnnotations.append(attribute);
                            }
                        }
                        if (annotations.length() == newAnnotations.length()) {
                            varSymbol.appendAttributes(newAnnotations.toList());
                        }
                    }
                    newParams.append(varSymbol);
                } else {
                    newParams.append(param.sym);
                }
            }
            params = newParams.toList();
            if (params.length() != method.getParameters().length()) {
                params = null;
            }
        }
        fixMethodMirror(typeNode.getContext(), typeNode.getElement(), method.getModifiers().flags, method.getName(), paramTypes, params, returnType);
        typeNode.add(method, AST.Kind.METHOD);
    }

    private static void fixMethodMirror(Context context, Element typeMirror, long access, Name methodName, List<Type> paramTypes, List<Symbol.VarSymbol> params, Type returnType) {
        if (typeMirror == null || paramTypes == null || returnType == null) {
            return;
        }
        Symbol.ClassSymbol cs = (Symbol.ClassSymbol) typeMirror;
        Symbol.MethodSymbol methodSymbol = new Symbol.MethodSymbol(access, methodName, new Type.MethodType(paramTypes, returnType, List.nil(), Symtab.instance(context).methodClass), cs);
        if (params != null && !params.isEmpty()) {
            methodSymbol.params = params;
        }
        ClassSymbolMembersField.enter(cs, methodSymbol);
    }

    public static JavacNode injectType(JavacNode typeNode, JCTree.JCClassDecl type) {
        JCTree.JCClassDecl typeDecl = typeNode.get();
        addSuppressWarningsAll(type.mods, typeNode, type.pos, getGeneratedBy(type), typeNode.getContext());
        addGenerated(type.mods, typeNode, type.pos, getGeneratedBy(type), typeNode.getContext());
        typeDecl.defs = typeDecl.defs.append(type);
        return typeNode.add(type, AST.Kind.TYPE);
    }

    public static long addFinalIfNeeded(long flags, Context context) {
        boolean addFinal = LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateFinalParams();
        if (addFinal) {
            flags |= 16;
        }
        return flags;
    }

    public static JCTree.JCExpression genTypeRef(JavacNode node, String complexName) {
        String[] parts = complexName.split("\\.");
        if (parts.length > 2 && parts[0].equals("java") && parts[1].equals("lang")) {
            String[] subParts = new String[parts.length - 2];
            System.arraycopy(parts, 2, subParts, 0, subParts.length);
            return genJavaLangTypeRef(node, subParts);
        }
        return chainDots(node, parts);
    }

    public static JCTree.JCExpression genJavaLangTypeRef(JavacNode node, String... simpleNames) {
        if (LombokOptionsFactory.getDelombokOptions(node.getContext()).getFormatPreferences().javaLangAsFqn()) {
            return chainDots(node, "java", "lang", simpleNames);
        }
        return chainDots(node, null, null, simpleNames);
    }

    public static JCTree.JCExpression genJavaLangTypeRef(JavacNode node, int pos, String... simpleNames) {
        if (LombokOptionsFactory.getDelombokOptions(node.getContext()).getFormatPreferences().javaLangAsFqn()) {
            return chainDots(node, pos, "java", "lang", simpleNames);
        }
        return chainDots(node, pos, null, null, simpleNames);
    }

    public static void addSuppressWarningsAll(JCTree.JCModifiers mods, JavacNode node, int pos, JCTree source, Context context) {
        if (LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateSuppressWarnings()) {
            boolean addJLSuppress = !Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_SUPPRESSWARNINGS_ANNOTATIONS));
            if (addJLSuppress) {
                Iterator it = mods.annotations.iterator();
                while (it.hasNext()) {
                    JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
                    JCTree.JCIdent annotationType = ann.getAnnotationType();
                    Name n = null;
                    if (annotationType instanceof JCTree.JCIdent) {
                        n = annotationType.name;
                    } else if (annotationType instanceof JCTree.JCFieldAccess) {
                        n = ((JCTree.JCFieldAccess) annotationType).name;
                    }
                    if (n != null && n.contentEquals("SuppressWarnings")) {
                        addJLSuppress = false;
                    }
                }
            }
            if (addJLSuppress) {
                addAnnotation(mods, node, pos, source, context, "java.lang.SuppressWarnings", node.getTreeMaker().Literal("all"));
            }
            if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS))) {
                JavacTreeMaker maker = node.getTreeMaker();
                addAnnotation(mods, node, pos, source, context, "edu.umd.cs.findbugs.annotations.SuppressFBWarnings", maker.Assign(maker.Ident(node.toName("justification")), maker.Literal("generated code")));
            }
        }
    }

    public static void addGenerated(JCTree.JCModifiers mods, JavacNode node, int pos, JCTree source, Context context) {
        if (LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateGenerated()) {
            if (HandlerUtil.shouldAddGenerated(node)) {
                addAnnotation(mods, node, pos, source, context, "javax.annotation.Generated", node.getTreeMaker().Literal("lombok"));
            }
            if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_LOMBOK_GENERATED_ANNOTATIONS))) {
                addAnnotation(mods, node, pos, source, context, "lombok.Generated", null);
            }
        }
    }

    public static void addAnnotation(JCTree.JCModifiers mods, JavacNode node, int pos, JCTree source, Context context, String annotationTypeFqn, JCTree.JCExpression arg) {
        int idx = annotationTypeFqn.lastIndexOf(46);
        String simpleName = idx == -1 ? annotationTypeFqn : annotationTypeFqn.substring(idx + 1);
        boolean isJavaLangBased = idx == 9 && annotationTypeFqn.regionMatches(0, "java.lang.", 0, 10);
        Iterator it = mods.annotations.iterator();
        while (it.hasNext()) {
            JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
            JCTree.JCIdent annotationType = ann.getAnnotationType();
            if (annotationType instanceof JCTree.JCIdent) {
                Name lastPart = annotationType.name;
                if (lastPart.contentEquals(simpleName)) {
                    return;
                }
            }
            if ((annotationType instanceof JCTree.JCFieldAccess) && annotationType.toString().equals(annotationTypeFqn)) {
                return;
            }
        }
        JavacTreeMaker maker = node.getTreeMaker();
        JCTree.JCExpression annType = isJavaLangBased ? genJavaLangTypeRef(node, simpleName) : chainDotsString(node, annotationTypeFqn);
        annType.pos = pos;
        if (arg != null) {
            arg.pos = pos;
            if (arg instanceof JCTree.JCAssign) {
                ((JCTree.JCAssign) arg).lhs.pos = pos;
                ((JCTree.JCAssign) arg).rhs.pos = pos;
            }
        }
        List<JCTree.JCExpression> argList = arg != null ? List.of(arg) : List.nil();
        JCTree.JCAnnotation annotation = recursiveSetGeneratedBy(maker.Annotation(annType, argList), source, context);
        annotation.pos = pos;
        mods.annotations = mods.annotations.append(annotation);
    }

    private static List<JCTree> addAllButOne(List<JCTree> defs, int idx) {
        ListBuffer<JCTree> out = new ListBuffer<>();
        int i = 0;
        Iterator it = defs.iterator();
        while (it.hasNext()) {
            JCTree def = (JCTree) it.next();
            int i2 = i;
            i++;
            if (i2 != idx) {
                out.append(def);
            }
        }
        return out.toList();
    }

    public static JCTree.JCExpression chainDots(JavacNode node, String elem1, String elem2, String... elems) {
        return chainDots(node, -1, elem1, elem2, elems);
    }

    public static JCTree.JCExpression chainDots(JavacNode node, String[] elems) {
        return chainDots(node, -1, null, null, elems);
    }

    public static JCTree.JCExpression chainDots(JavacNode node, LombokImmutableList<String> elems) {
        if ($assertionsDisabled || elems != null) {
            JavacTreeMaker maker = node.getTreeMaker();
            JCTree.JCFieldAccess jCFieldAccess = null;
            Iterator<String> it = elems.iterator();
            while (it.hasNext()) {
                String elem = it.next();
                jCFieldAccess = jCFieldAccess == null ? maker.Ident(node.toName(elem)) : maker.Select(jCFieldAccess, node.toName(elem));
            }
            return jCFieldAccess;
        }
        throw new AssertionError();
    }

    public static JCTree.JCExpression chainDots(JavacNode node, int pos, String elem1, String elem2, String... elems) {
        if ($assertionsDisabled || elems != null) {
            JavacTreeMaker maker = node.getTreeMaker();
            if (pos != -1) {
                maker = maker.at(pos);
            }
            JCTree.JCIdent Ident = elem1 != null ? maker.Ident(node.toName(elem1)) : null;
            if (elem2 != null) {
                Ident = Ident == null ? maker.Ident(node.toName(elem2)) : maker.Select(Ident, node.toName(elem2));
            }
            for (int i = 0; i < elems.length; i++) {
                Ident = Ident == null ? maker.Ident(node.toName(elems[i])) : maker.Select(Ident, node.toName(elems[i]));
            }
            if ($assertionsDisabled || Ident != null) {
                return Ident;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static JCTree.JCExpression chainDotsString(JavacNode node, String elems) {
        return chainDots(node, null, null, elems.split("\\."));
    }

    public static List<JCTree.JCAnnotation> findAnnotations(JavacNode fieldNode, Pattern namePattern) {
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        Iterator<JavacNode> it = fieldNode.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation = child.get();
                String name = annotation.annotationType.toString();
                int idx = name.lastIndexOf(".");
                String suspect = idx == -1 ? name : name.substring(idx + 1);
                if (namePattern.matcher(suspect).matches()) {
                    result.append(annotation);
                }
            }
        }
        return result.toList();
    }

    public static String scanForNearestAnnotation(JavacNode node, String... anns) {
        while (node != null) {
            Iterator<JavacNode> it = node.down().iterator();
            while (it.hasNext()) {
                JavacNode ann = it.next();
                if (ann.getKind() == AST.Kind.ANNOTATION) {
                    JCTree.JCAnnotation a = ann.get();
                    for (String annToFind : anns) {
                        if (typeMatches(annToFind, node, a.annotationType)) {
                            return annToFind;
                        }
                    }
                    continue;
                }
            }
            node = node.up();
        }
        return null;
    }

    public static boolean hasNonNullAnnotations(JavacNode node) {
        Iterator<JavacNode> it = node.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation = child.get();
                for (String nn : HandlerUtil.NONNULL_ANNOTATIONS) {
                    if (typeMatches(nn, node, annotation.annotationType)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean hasNonNullAnnotations(JavacNode node, List<JCTree.JCAnnotation> anns) {
        if (anns == null) {
            return false;
        }
        Iterator it = anns.iterator();
        while (it.hasNext()) {
            JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
            for (String nn : HandlerUtil.NONNULL_ANNOTATIONS) {
                if (typeMatches(nn, node, (JCTree) ann)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<JCTree.JCAnnotation> findCopyableAnnotations(JavacNode node) {
        JCTree.JCAnnotation anno = null;
        String annoName = null;
        Iterator<JavacNode> it = node.down().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                if (anno != null) {
                    annoName = "";
                    break;
                }
                JCTree.JCAnnotation annotation = (JCTree.JCAnnotation) child.get();
                annoName = annotation.annotationType.toString();
                anno = annotation;
            }
        }
        if (annoName == null) {
            return List.nil();
        }
        java.util.List<TypeName> configuredCopyable = (java.util.List) node.getAst().readConfiguration(ConfigurationKeys.COPYABLE_ANNOTATIONS);
        if (!annoName.isEmpty()) {
            for (TypeName cn : configuredCopyable) {
                if (cn != null && typeMatches(cn.toString(), node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
            for (String bn : HandlerUtil.BASE_COPYABLE_ANNOTATIONS) {
                if (typeMatches(bn, node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
        }
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        Iterator<JavacNode> it2 = node.down().iterator();
        while (it2.hasNext()) {
            JavacNode child2 = it2.next();
            if (child2.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation2 = child2.get();
                boolean match = false;
                Iterator<TypeName> it3 = configuredCopyable.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    TypeName cn2 = it3.next();
                    if (cn2 != null && typeMatches(cn2.toString(), node, annotation2.annotationType)) {
                        result.append(annotation2);
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    Iterator<String> it4 = HandlerUtil.BASE_COPYABLE_ANNOTATIONS.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        String bn2 = it4.next();
                        if (typeMatches(bn2, node, annotation2.annotationType)) {
                            result.append(annotation2);
                            break;
                        }
                    }
                }
            }
        }
        return result.toList();
    }

    public static List<JCTree.JCAnnotation> findCopyableToSetterAnnotations(JavacNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_SETTER_ANNOTATIONS);
    }

    public static List<JCTree.JCAnnotation> findCopyableToBuilderSingularSetterAnnotations(JavacNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_BUILDER_SINGULAR_SETTER_ANNOTATIONS);
    }

    private static List<JCTree.JCAnnotation> findAnnotationsInList(JavacNode node, java.util.List<String> annotationsToFind) {
        JCTree.JCAnnotation anno = null;
        String annoName = null;
        Iterator<JavacNode> it = node.down().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                if (anno != null) {
                    annoName = "";
                    break;
                }
                JCTree.JCAnnotation annotation = (JCTree.JCAnnotation) child.get();
                annoName = annotation.annotationType.toString();
                anno = annotation;
            }
        }
        if (annoName == null) {
            return List.nil();
        }
        if (!annoName.isEmpty()) {
            for (String bn : annotationsToFind) {
                if (typeMatches(bn, node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
        }
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        Iterator<JavacNode> it2 = node.down().iterator();
        while (it2.hasNext()) {
            JavacNode child2 = it2.next();
            if (child2.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation2 = child2.get();
                if (0 == 0) {
                    Iterator<String> it3 = annotationsToFind.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        String bn2 = it3.next();
                        if (typeMatches(bn2, node, annotation2.annotationType)) {
                            result.append(annotation2);
                            break;
                        }
                    }
                }
            }
        }
        return result.toList();
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JavacNode variable, JavacNode source) {
        return generateNullCheck(maker, variable.get(), source);
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JCTree.JCExpression typeNode, Name varName, JavacNode source, String customMessage) {
        NullCheckExceptionType exceptionType = (NullCheckExceptionType) source.getAst().readConfiguration(ConfigurationKeys.NON_NULL_EXCEPTION_TYPE);
        if (exceptionType == null) {
            exceptionType = NullCheckExceptionType.NULL_POINTER_EXCEPTION;
        }
        if (typeNode == null || !Javac.isPrimitive(typeNode)) {
            JCTree.JCLiteral message = maker.Literal(exceptionType.toExceptionMessage(varName.toString(), customMessage));
            LombokImmutableList<String> method = exceptionType.getMethod();
            if (method != null) {
                return maker.Exec(maker.Apply(List.nil(), chainDots(source, method), List.of(maker.Ident(varName), message)));
            }
            if (exceptionType == NullCheckExceptionType.ASSERTION) {
                return maker.Assert(maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(varName), maker.Literal(Javac.CTC_BOT, null)), message);
            }
            JCTree.JCExpression exType = genTypeRef(source, exceptionType.getExceptionType());
            JCTree.JCBlock throwBlock = maker.Block(0L, List.of(maker.Throw(maker.NewClass(null, List.nil(), exType, List.of(message), null))));
            return maker.If(maker.Binary(Javac.CTC_EQUAL, maker.Ident(varName), maker.Literal(Javac.CTC_BOT, null)), throwBlock, null);
        }
        return null;
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JCTree.JCVariableDecl varDecl, JavacNode source) {
        return generateNullCheck(maker, varDecl.vartype, varDecl.name, source, null);
    }

    public static List<Integer> createListOfNonExistentFields(List<String> list, JavacNode type, boolean excludeStandard, boolean excludeTransient) {
        boolean[] matched = new boolean[list.size()];
        Iterator<JavacNode> it = type.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (list.isEmpty()) {
                break;
            } else if (child.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl field = child.get();
                if (!excludeStandard || ((field.mods.flags & 8) == 0 && !field.name.toString().startsWith("$"))) {
                    if (!excludeTransient || (field.mods.flags & 128) == 0) {
                        int idx = list.indexOf(child.getName());
                        if (idx > -1) {
                            matched[idx] = true;
                        }
                    }
                }
            }
        }
        ListBuffer<Integer> problematic = new ListBuffer<>();
        for (int i = 0; i < list.size(); i++) {
            if (!matched[i]) {
                problematic.append(Integer.valueOf(i));
            }
        }
        return problematic.toList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<JCTree.JCAnnotation> unboxAndRemoveAnnotationParameter(JCTree.JCAnnotation ast, String parameterName, String errorName, JavacNode annotationNode) {
        ListBuffer<JCTree.JCExpression> params = new ListBuffer<>();
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        Iterator it = ast.args.iterator();
        while (it.hasNext()) {
            JCTree.JCAssign jCAssign = (JCTree.JCExpression) it.next();
            String nameOfParam = "value";
            JCTree.JCAnnotation jCAnnotation = null;
            if (jCAssign instanceof JCTree.JCAssign) {
                JCTree.JCAssign assign = jCAssign;
                if (assign.lhs instanceof JCTree.JCIdent) {
                    JCTree.JCIdent ident = assign.lhs;
                    nameOfParam = ident.name.toString();
                }
                jCAnnotation = assign.rhs;
            }
            int lastIdx = nameOfParam.length();
            while (lastIdx > 0 && nameOfParam.charAt(lastIdx - 1) == '_') {
                lastIdx--;
            }
            boolean allowRaw = lastIdx < nameOfParam.length();
            if (!parameterName.equals(nameOfParam.substring(0, lastIdx))) {
                params.append(jCAssign);
            } else {
                int endPos = Javac.getEndPosition(jCAssign.pos(), annotationNode.top().get());
                annotationNode.getAst().removeFromDeferredDiagnostics(((JCTree.JCExpression) jCAssign).pos, endPos);
                if (jCAnnotation instanceof JCTree.JCAnnotation) {
                    String dummyAnnotationName = jCAnnotation.annotationType.toString();
                    if (dummyAnnotationName.replace(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT, "").replace("$", "").replace("x", "").replace("X", "").length() > 0) {
                        if (allowRaw) {
                            result.append(jCAnnotation);
                        } else {
                            addError(errorName, annotationNode);
                        }
                    } else {
                        Iterator it2 = jCAnnotation.args.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            JCTree.JCAssign expr = (JCTree.JCExpression) it2.next();
                            if ((expr instanceof JCTree.JCAssign) && (expr.lhs instanceof JCTree.JCIdent)) {
                                JCTree.JCIdent id = expr.lhs;
                                if ("value".equals(id.name.toString())) {
                                    expr = expr.rhs;
                                } else {
                                    addError(errorName, annotationNode);
                                }
                            }
                            if (!(expr instanceof JCTree.JCAnnotation)) {
                                if (expr instanceof JCTree.JCNewArray) {
                                    Iterator it3 = ((JCTree.JCNewArray) expr).elems.iterator();
                                    while (it3.hasNext()) {
                                        JCTree.JCAnnotation jCAnnotation2 = (JCTree.JCExpression) it3.next();
                                        if (jCAnnotation2 instanceof JCTree.JCAnnotation) {
                                            result.append(jCAnnotation2);
                                        } else {
                                            addError(errorName, annotationNode);
                                            break;
                                        }
                                    }
                                    continue;
                                } else {
                                    addError(errorName, annotationNode);
                                    break;
                                }
                            } else {
                                result.append((JCTree.JCAnnotation) expr);
                            }
                        }
                    }
                } else if (jCAnnotation instanceof JCTree.JCNewArray) {
                    JCTree.JCNewArray arr = jCAnnotation;
                    if (!arr.elems.isEmpty()) {
                        if (allowRaw) {
                            Iterator it4 = arr.elems.iterator();
                            while (it4.hasNext()) {
                                JCTree.JCAnnotation jCAnnotation3 = (JCTree.JCExpression) it4.next();
                                if (jCAnnotation3 instanceof JCTree.JCAnnotation) {
                                    result.append(jCAnnotation3);
                                } else {
                                    addError(errorName, annotationNode);
                                }
                            }
                        } else {
                            addError(errorName, annotationNode);
                        }
                    }
                } else {
                    addError(errorName, annotationNode);
                }
            }
        }
        ast.args = params.toList();
        return result.toList();
    }

    private static void addError(String errorName, JavacNode node) {
        if (node.getLatestJavaSpecSupported() < 8) {
            node.addError("The correct format up to JDK7 is " + errorName + "=@__({@SomeAnnotation, @SomeOtherAnnotation}))");
        } else {
            node.addError("The correct format for JDK8+ is " + errorName + "_={@SomeAnnotation, @SomeOtherAnnotation})");
        }
    }

    public static List<JCTree.JCTypeParameter> copyTypeParams(JavacNode source, List<JCTree.JCTypeParameter> params) {
        if (params == null || params.isEmpty()) {
            return params;
        }
        ListBuffer<JCTree.JCTypeParameter> out = new ListBuffer<>();
        JavacTreeMaker maker = source.getTreeMaker();
        Context context = source.getContext();
        Iterator it = params.iterator();
        while (it.hasNext()) {
            JCTree.JCTypeParameter tp = (JCTree.JCTypeParameter) it.next();
            List<JCTree.JCExpression> bounds = tp.bounds;
            if (bounds != null && !bounds.isEmpty()) {
                ListBuffer<JCTree.JCExpression> boundsCopy = new ListBuffer<>();
                Iterator it2 = tp.bounds.iterator();
                while (it2.hasNext()) {
                    JCTree.JCExpression expr = (JCTree.JCExpression) it2.next();
                    boundsCopy.append(cloneType(maker, expr, source.get(), context));
                }
                bounds = boundsCopy.toList();
            }
            out.append(maker.TypeParameter(tp.name, bounds));
        }
        return out.toList();
    }

    public static List<JCTree.JCAnnotation> getTypeUseAnnotations(JCTree.JCExpression from) {
        return !JCAnnotatedTypeReflect.is(from) ? List.nil() : JCAnnotatedTypeReflect.getAnnotations(from);
    }

    public static JCTree.JCExpression removeTypeUseAnnotations(JCTree.JCExpression from) {
        return !JCAnnotatedTypeReflect.is(from) ? from : JCAnnotatedTypeReflect.getUnderlyingType(from);
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode type, List<JCTree.JCTypeParameter> params) {
        JCTree.JCClassDecl td = type.get();
        boolean instance = (td.mods.flags & 8) == 0;
        return namePlusTypeParamsToTypeReference(maker, type.up(), td.name, instance, params, List.nil());
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode type, List<JCTree.JCTypeParameter> params, List<JCTree.JCAnnotation> annotations) {
        JCTree.JCClassDecl td = type.get();
        boolean instance = (td.mods.flags & 8) == 0;
        return namePlusTypeParamsToTypeReference(maker, type.up(), td.name, instance, params, annotations);
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode parentType, Name typeName, boolean instance, List<JCTree.JCTypeParameter> params) {
        return namePlusTypeParamsToTypeReference(maker, parentType, typeName, instance, params, List.nil());
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode parentType, Name typeName, boolean instance, List<JCTree.JCTypeParameter> params, List<JCTree.JCAnnotation> annotations) {
        JCTree.JCExpression r = null;
        if (parentType != null && parentType.getKind() == AST.Kind.TYPE) {
            JCTree.JCClassDecl td = parentType.get();
            boolean outerInstance = instance && (td.mods.flags & 8) == 0;
            List<JCTree.JCTypeParameter> outerParams = instance ? td.typarams : List.nil();
            r = namePlusTypeParamsToTypeReference(maker, parentType.up(), td.name, outerInstance, outerParams, List.nil());
        }
        JCTree.JCIdent Ident = r == null ? maker.Ident(typeName) : maker.Select(r, typeName);
        if (!annotations.isEmpty()) {
            Ident = JCAnnotatedTypeReflect.create(annotations, Ident);
        }
        if (!params.isEmpty()) {
            Ident = maker.TypeApply(Ident, typeParameterNames(maker, params));
        }
        return Ident;
    }

    public static List<JCTree.JCExpression> typeParameterNames(JavacTreeMaker maker, List<JCTree.JCTypeParameter> params) {
        ListBuffer<JCTree.JCExpression> typeArgs = new ListBuffer<>();
        Iterator it = params.iterator();
        while (it.hasNext()) {
            JCTree.JCTypeParameter param = (JCTree.JCTypeParameter) it.next();
            typeArgs.append(maker.Ident(param.name));
        }
        return typeArgs.toList();
    }

    public static void sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(JavacNode typeNode, JavacNode errorNode) {
        List<String> disallowed = List.nil();
        Iterator<JavacNode> it = typeNode.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            for (String annType : HandlerUtil.INVALID_ON_BUILDERS) {
                if (annotationTypeMatches(annType, child)) {
                    int lastIndex = annType.lastIndexOf(46);
                    disallowed = disallowed.append(lastIndex == -1 ? annType : annType.substring(lastIndex + 1));
                }
            }
        }
        int size = disallowed.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            errorNode.addError("@" + ((String) disallowed.head) + " is not allowed on builder classes.");
            return;
        }
        StringBuilder out = new StringBuilder();
        Iterator it2 = disallowed.iterator();
        while (it2.hasNext()) {
            String a = (String) it2.next();
            out.append("@").append(a).append(", ");
        }
        out.setLength(out.length() - 2);
        errorNode.addError(out.append(" are not allowed on builder classes.").toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<JCTree.JCAnnotation> copyAnnotations(List<? extends JCTree.JCExpression> in) {
        ListBuffer<JCTree.JCAnnotation> out = new ListBuffer<>();
        Iterator it = in.iterator();
        while (it.hasNext()) {
            JCTree.JCExpression expr = (JCTree.JCExpression) it.next();
            if (expr instanceof JCTree.JCAnnotation) {
                out.append((JCTree.JCAnnotation) expr.clone());
            }
        }
        return out.toList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<JCTree.JCAnnotation> mergeAnnotations(List<JCTree.JCAnnotation> a, List<JCTree.JCAnnotation> b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        ListBuffer<JCTree.JCAnnotation> out = new ListBuffer<>();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
            out.append(ann);
        }
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            JCTree.JCAnnotation ann2 = (JCTree.JCAnnotation) it2.next();
            out.append(ann2);
        }
        return out.toList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isClass(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, 25088);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isClassOrEnum(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, ChannelMessageGuideType.MessageGuideOnSapaInfo);
    }

    public static boolean isClassAndDoesNotHaveFlags(JavacNode typeNode, int flags) {
        if (!(typeNode.get() instanceof JCTree.JCClassDecl)) {
            return false;
        }
        JCTree.JCClassDecl typeDecl = typeNode.get();
        long typeDeclflags = typeDecl == null ? 0L : typeDecl.mods.flags;
        return (typeDeclflags & ((long) flags)) == 0;
    }

    public static JavacNode upToTypeNode(JavacNode node) {
        if (node == null) {
            throw new NullPointerException("node");
        }
        while (node != null && !(node.get() instanceof JCTree.JCClassDecl)) {
            node = node.up();
        }
        return node;
    }

    public static List<JCTree.JCExpression> cloneTypes(JavacTreeMaker maker, List<JCTree.JCExpression> in, JCTree source, Context context) {
        if (in.isEmpty()) {
            return List.nil();
        }
        if (in.size() == 1) {
            return List.of(cloneType(maker, (JCTree.JCExpression) in.get(0), source, context));
        }
        ListBuffer<JCTree.JCExpression> lb = new ListBuffer<>();
        Iterator it = in.iterator();
        while (it.hasNext()) {
            JCTree.JCExpression expr = (JCTree.JCExpression) it.next();
            lb.append(cloneType(maker, expr, source, context));
        }
        return lb.toList();
    }

    public static JCTree.JCExpression cloneType(JavacTreeMaker maker, JCTree.JCExpression in, JCTree source, Context context) {
        JCTree.JCExpression out = cloneType0(maker, in);
        if (out != null) {
            recursiveSetGeneratedBy(out, source, context);
        }
        return out;
    }

    private static JCTree.JCExpression cloneType0(JavacTreeMaker maker, JCTree in) {
        JCTree.TypeBoundKind newKind;
        if (in == null) {
            return null;
        }
        if (in instanceof JCTree.JCPrimitiveTypeTree) {
            return (JCTree.JCExpression) in;
        }
        if (in instanceof JCTree.JCIdent) {
            return maker.Ident(((JCTree.JCIdent) in).name);
        }
        if (in instanceof JCTree.JCFieldAccess) {
            JCTree.JCFieldAccess fa = (JCTree.JCFieldAccess) in;
            return maker.Select(cloneType0(maker, fa.selected), fa.name);
        } else if (in instanceof JCTree.JCArrayTypeTree) {
            JCTree.JCArrayTypeTree att = (JCTree.JCArrayTypeTree) in;
            return maker.TypeArray(cloneType0(maker, att.elemtype));
        } else if (in instanceof JCTree.JCTypeApply) {
            JCTree.JCTypeApply ta = (JCTree.JCTypeApply) in;
            ListBuffer<JCTree.JCExpression> lb = new ListBuffer<>();
            Iterator it = ta.arguments.iterator();
            while (it.hasNext()) {
                JCTree.JCExpression typeArg = (JCTree.JCExpression) it.next();
                lb.append(cloneType0(maker, typeArg));
            }
            return maker.TypeApply(cloneType0(maker, ta.clazz), lb.toList());
        } else if (in instanceof JCTree.JCWildcard) {
            JCTree.JCWildcard w = (JCTree.JCWildcard) in;
            JCTree.JCExpression newInner = cloneType0(maker, w.inner);
            switch ($SWITCH_TABLE$com$sun$source$tree$Tree$Kind()[w.getKind().ordinal()]) {
                case 88:
                default:
                    newKind = maker.TypeBoundKind(BoundKind.UNBOUND);
                    break;
                case 89:
                    newKind = maker.TypeBoundKind(BoundKind.EXTENDS);
                    break;
                case 90:
                    newKind = maker.TypeBoundKind(BoundKind.SUPER);
                    break;
            }
            return maker.Wildcard(newKind, newInner);
        } else if (JCAnnotatedTypeReflect.is(in)) {
            JCTree.JCExpression underlyingType = cloneType0(maker, JCAnnotatedTypeReflect.getUnderlyingType(in));
            List<JCTree.JCAnnotation> anns = copyAnnotations(JCAnnotatedTypeReflect.getAnnotations(in));
            return JCAnnotatedTypeReflect.create(anns, underlyingType);
        } else {
            return (JCTree.JCExpression) in;
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc.SCL.lombok */
    public enum CopyJavadoc {
        VERBATIM { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.1
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return Javac.getDocComment(cu, node.get());
            }
        },
        GETTER { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.2
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(final JCTree.JCCompilationUnit cu, JavacNode node) {
                final JCTree n = node.get();
                String javadoc = Javac.getDocComment(cu, n);
                String out = HandlerUtil.getJavadocSection(javadoc, "GETTER");
                final boolean sectionBased = out != null;
                if (!sectionBased) {
                    out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@param(?:eter)?\\s+.*");
                }
                node.getAst().cleanupTask("javadocfilter-getter", n, new CleanupTask() { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.2.1
                    @Override // lombok.core.CleanupTask
                    public void cleanup() {
                        String javadoc2 = Javac.getDocComment(cu, n);
                        if (javadoc2 == null || javadoc2.isEmpty()) {
                            return;
                        }
                        String javadoc3 = HandlerUtil.stripSectionsFromJavadoc(javadoc2);
                        if (!sectionBased) {
                            javadoc3 = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc3), "@returns?\\s+.*");
                        }
                        Javac.setDocComment(cu, n, javadoc3);
                    }
                });
                return out;
            }
        },
        SETTER { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.3
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return CopyJavadoc.applySetter(cu, node, "SETTER");
            }
        },
        WITH { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.4
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return HandlerUtil.addReturnsUpdatedSelfIfNeeded(CopyJavadoc.applySetter(cu, node, "WITH|WITHER"));
            }
        },
        WITH_BY { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.5
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return CopyJavadoc.applySetter(cu, node, "WITHBY|WITH_BY");
            }
        };

        public abstract String apply(JCTree.JCCompilationUnit jCCompilationUnit, JavacNode javacNode);

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CopyJavadoc[] valuesCustom() {
            CopyJavadoc[] valuesCustom = values();
            int length = valuesCustom.length;
            CopyJavadoc[] copyJavadocArr = new CopyJavadoc[length];
            System.arraycopy(valuesCustom, 0, copyJavadocArr, 0, length);
            return copyJavadocArr;
        }

        /* synthetic */ CopyJavadoc(CopyJavadoc copyJavadoc) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String applySetter(final JCTree.JCCompilationUnit cu, JavacNode node, String sectionName) {
            final JCTree n = node.get();
            String javadoc = Javac.getDocComment(cu, n);
            String out = HandlerUtil.getJavadocSection(javadoc, sectionName);
            final boolean sectionBased = out != null;
            if (!sectionBased) {
                out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@returns?\\s+.*");
            }
            node.getAst().cleanupTask("javadocfilter-setter", n, new CleanupTask() { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.6
                @Override // lombok.core.CleanupTask
                public void cleanup() {
                    String javadoc2 = Javac.getDocComment(cu, n);
                    if (javadoc2 == null || javadoc2.isEmpty()) {
                        return;
                    }
                    String javadoc3 = HandlerUtil.stripSectionsFromJavadoc(javadoc2);
                    if (!sectionBased) {
                        javadoc3 = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc3), "@param(?:eter)?\\s+.*");
                    }
                    Javac.setDocComment(cu, n, javadoc3);
                }
            });
            return JavacHandlerUtil.shouldReturnThis(node) ? HandlerUtil.addReturnsThisIfNeeded(out) : out;
        }
    }

    public static void copyJavadoc(JavacNode from, JCTree to, CopyJavadoc copyMode) {
        copyJavadoc(from, to, copyMode, false);
    }

    public static void copyJavadoc(JavacNode from, JCTree to, CopyJavadoc copyMode, boolean forceAddReturn) {
        if (copyMode == null) {
            copyMode = CopyJavadoc.VERBATIM;
        }
        try {
            JCTree.JCCompilationUnit cu = (JCTree.JCCompilationUnit) from.top().get();
            String newJavadoc = copyMode.apply(cu, from);
            if (newJavadoc != null) {
                if (forceAddReturn) {
                    newJavadoc = HandlerUtil.addReturnsThisIfNeeded(newJavadoc);
                }
                Javac.setDocComment(cu, to, newJavadoc);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isDirectDescendantOfObject(JavacNode typeNode) {
        if (typeNode.get() instanceof JCTree.JCClassDecl) {
            JCTree extending = Javac.getExtendsClause(typeNode.get());
            if (extending == null) {
                return true;
            }
            String p = extending.toString();
            return p.equals("Object") || p.equals("java.lang.Object");
        }
        throw new IllegalArgumentException("not a type node");
    }

    public static void createRelevantNullableAnnotation(JavacNode typeNode, JCTree.JCMethodDecl mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(JavacNode typeNode, JCTree.JCMethodDecl mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(JavacNode typeNode, JCTree.JCVariableDecl arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNullableAnnotation(JavacNode typeNode, JCTree.JCVariableDecl arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    private static void applyAnnotationToMethodDecl(JavacNode typeNode, JCTree.JCMethodDecl mth, String annType, boolean typeUse) {
        if (annType == null) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCAnnotation m = maker.Annotation(genTypeRef(typeNode, annType), List.nil());
        if (typeUse) {
            JCTree.JCTypeApply resType = mth.restype;
            if (resType instanceof JCTree.JCTypeApply) {
                JCTree.JCTypeApply ta = resType;
                resType = ta.clazz;
            }
            if ((resType instanceof JCTree.JCFieldAccess) || (resType instanceof JCTree.JCArrayTypeTree)) {
                mth.restype = maker.AnnotatedType(List.of(m), resType);
                return;
            } else if (JCAnnotatedTypeReflect.is(resType)) {
                List<JCTree.JCAnnotation> annotations = JCAnnotatedTypeReflect.getAnnotations(resType);
                JCAnnotatedTypeReflect.setAnnotations(resType, annotations.prepend(m));
                return;
            } else if ((resType instanceof JCTree.JCPrimitiveTypeTree) || (resType instanceof JCTree.JCIdent)) {
                mth.mods.annotations = mth.mods.annotations == null ? List.of(m) : mth.mods.annotations.prepend(m);
                return;
            } else {
                return;
            }
        }
        mth.mods.annotations = mth.mods.annotations == null ? List.of(m) : mth.mods.annotations.prepend(m);
    }

    private static void applyAnnotationToVarDecl(JavacNode typeNode, JCTree.JCVariableDecl arg, String annType, boolean typeUse) {
        if (annType == null) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCAnnotation m = maker.Annotation(genTypeRef(typeNode, annType), List.nil());
        if (typeUse) {
            JCTree.JCTypeApply varType = arg.vartype;
            JCTree.JCTypeApply ta = null;
            if (varType instanceof JCTree.JCTypeApply) {
                ta = varType;
                varType = ta.clazz;
            }
            if ((varType instanceof JCTree.JCFieldAccess) || (varType instanceof JCTree.JCArrayTypeTree)) {
                JCTree.JCExpression varType2 = maker.AnnotatedType(List.of(m), varType);
                if (ta == null) {
                    arg.vartype = varType2;
                    return;
                } else {
                    ta.clazz = varType2;
                    return;
                }
            } else if (JCAnnotatedTypeReflect.is(varType)) {
                List<JCTree.JCAnnotation> annotations = JCAnnotatedTypeReflect.getAnnotations(varType);
                JCAnnotatedTypeReflect.setAnnotations(varType, annotations.prepend(m));
                return;
            } else if ((varType instanceof JCTree.JCPrimitiveTypeTree) || (varType instanceof JCTree.JCIdent)) {
                arg.mods.annotations = arg.mods.annotations == null ? List.of(m) : arg.mods.annotations.prepend(m);
                return;
            } else {
                return;
            }
        }
        arg.mods.annotations = arg.mods.annotations == null ? List.of(m) : arg.mods.annotations.prepend(m);
    }
}
