package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.experimental.WithBy;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleWithBy.SCL.lombok */
public class HandleWithBy extends EclipseAnnotationHandler<WithBy> {
    private static final char[][] NAME_JUF_FUNCTION = Eclipse.fromQualifiedName("java.util.function.Function");
    private static final char[][] NAME_JUF_OP = Eclipse.fromQualifiedName("java.util.function.UnaryOperator");
    private static final char[][] NAME_JUF_DOUBLEOP = Eclipse.fromQualifiedName("java.util.function.DoubleUnaryOperator");
    private static final char[][] NAME_JUF_INTOP = Eclipse.fromQualifiedName("java.util.function.IntUnaryOperator");
    private static final char[][] NAME_JUF_LONGOP = Eclipse.fromQualifiedName("java.util.function.LongUnaryOperator");
    private static final char[] NAME_CHAR = {'c', 'h', 'a', 'r'};
    private static final char[] NAME_SHORT = {'s', 'h', 'o', 'r', 't'};
    private static final char[] NAME_BYTE = {'b', 'y', 't', 'e'};
    private static final char[] NAME_INT = {'i', 'n', 't'};
    private static final char[] NAME_LONG = {'l', 'o', 'n', 'g'};
    private static final char[] NAME_DOUBLE = {'d', 'o', 'u', 'b', 'l', 'e'};
    private static final char[] NAME_FLOAT = {'f', 'l', 'o', 'a', 't'};
    private static final char[] NAME_BOOLEAN = {'b', 'o', 'o', 'l', 'e', 'a', 'n'};
    private static final char[][] NAME_JAVA_LANG_BOOLEAN = Eclipse.fromQualifiedName("java.lang.Boolean");
    private static final char[] NAME_APPLY = {'a', 'p', 'p', 'l', 'y'};
    private static final char[] NAME_APPLY_AS_INT = {'a', 'p', 'p', 'l', 'y', 'A', 's', 'I', 'n', 't'};
    private static final char[] NAME_APPLY_AS_LONG = {'a', 'p', 'p', 'l', 'y', 'A', 's', 'L', 'o', 'n', 'g'};
    private static final char[] NAME_APPLY_AS_DOUBLE = {'a', 'p', 'p', 'l', 'y', 'A', 's', 'D', 'o', 'u', 'b', 'l', 'e'};
    private static final char[] NAME_TRANSFORMER = {'t', 'r', 'a', 'n', 's', 'f', 'o', 'r', 'm', 'e', 'r'};
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[EclipseHandlerUtil.MemberExistsResult.valuesCustom().length];
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    public boolean generateWithByForType(EclipseNode typeNode, EclipseNode pos, AccessLevel level, boolean checkForTypeLevelWithBy) {
        if (checkForTypeLevelWithBy && EclipseHandlerUtil.hasAnnotation(WithBy.class, typeNode)) {
            return true;
        }
        TypeDeclaration typeDecl = null;
        if (typeNode.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) typeNode.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            pos.addError("@WithBy is only supported on a class or a field.");
            return false;
        }
        Iterator<EclipseNode> it = typeNode.down().iterator();
        while (it.hasNext()) {
            EclipseNode field = it.next();
            if (field.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fieldDecl = field.get();
                if (EclipseHandlerUtil.filterField(fieldDecl) && ((fieldDecl.modifiers & 16) == 0 || fieldDecl.initialization == null)) {
                    generateWithByForField(field, pos, level);
                }
            }
        }
        return true;
    }

    public void generateWithByForField(EclipseNode fieldNode, EclipseNode sourceNode, AccessLevel level) {
        Iterator<EclipseNode> it = fieldNode.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION && EclipseHandlerUtil.annotationTypeMatches(WithBy.class, child)) {
                return;
            }
        }
        List<Annotation> empty = Collections.emptyList();
        createWithByForField(level, fieldNode, sourceNode, false, empty);
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<WithBy> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.WITHBY_FLAG_USAGE, "@WithBy");
        EclipseNode node = annotationNode.up();
        AccessLevel level = annotation.getInstance().value();
        if (level == AccessLevel.NONE || node == null) {
            return;
        }
        List<Annotation> onMethod = EclipseHandlerUtil.unboxAndRemoveAnnotationParameter(ast, "onMethod", "@WithBy(onMethod", annotationNode);
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
                if (!onMethod.isEmpty()) {
                    annotationNode.addError("'onMethod' is not supported for @WithBy on a type.");
                }
                generateWithByForType(node, annotationNode, level, false);
                return;
            case 3:
                createWithByForFields(level, annotationNode.upFromAnnotationToFields(), annotationNode, true, onMethod);
                return;
            default:
                return;
        }
    }

    public void createWithByForFields(AccessLevel level, Collection<EclipseNode> fieldNodes, EclipseNode sourceNode, boolean whineIfExists, List<Annotation> onMethod) {
        for (EclipseNode fieldNode : fieldNodes) {
            createWithByForField(level, fieldNode, sourceNode, whineIfExists, onMethod);
        }
    }

    public void createWithByForField(AccessLevel level, EclipseNode fieldNode, EclipseNode sourceNode, boolean whineIfExists, List<Annotation> onMethod) {
        ASTNode source = sourceNode.get();
        if (fieldNode.getKind() != AST.Kind.FIELD) {
            sourceNode.addError("@WithBy is only supported on a class or a field.");
            return;
        }
        EclipseNode typeNode = fieldNode.up();
        boolean makeAbstract = (typeNode == null || typeNode.getKind() != AST.Kind.TYPE || (typeNode.get().modifiers & 1024) == 0) ? false : true;
        FieldDeclaration field = fieldNode.get();
        TypeReference fieldType = EclipseHandlerUtil.copyType(field.type, source);
        boolean isBoolean = EclipseHandlerUtil.isBoolean(fieldType);
        String withName = EclipseHandlerUtil.toWithByName(fieldNode, isBoolean);
        if (withName == null) {
            fieldNode.addWarning("Not generating a withXBy method for this field: It does not fit your @Accessors prefix list.");
        } else if ((field.modifiers & 8) != 0) {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for static fields.");
        } else if ((field.modifiers & 16) != 0 && field.initialization != null) {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for final, initialized fields.");
        } else if (field.name != null && field.name.length > 0 && field.name[0] == '$') {
            fieldNode.addWarning("Not generating " + withName + " for this field: With methods cannot be generated for fields starting with $.");
        } else {
            for (String altName : EclipseHandlerUtil.toAllWithByNames(fieldNode, isBoolean)) {
                switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists(altName, fieldNode, false, 1).ordinal()]) {
                    case 2:
                        return;
                    case 3:
                        if (whineIfExists) {
                            String altNameExpl = altName.equals(withName) ? "" : String.format(" (%s)", altName);
                            fieldNode.addWarning(String.format("Not generating %s(): A method with that name already exists%s", withName, altNameExpl));
                            return;
                        }
                        return;
                }
            }
            int modifier = EclipseHandlerUtil.toEclipseModifier(level);
            MethodDeclaration method = createWithBy((TypeDeclaration) fieldNode.up().get(), fieldNode, withName, modifier, sourceNode, onMethod, makeAbstract);
            EclipseHandlerUtil.injectMethod(fieldNode.up(), method);
        }
    }

    /* JADX WARN: Type inference failed for: r0v132, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    /* JADX WARN: Type inference failed for: r0v145, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    public MethodDeclaration createWithBy(TypeDeclaration parent, EclipseNode fieldNode, String name, int modifier, EclipseNode sourceNode, List<Annotation> onMethod, boolean makeAbstract) {
        Statement nullCheck;
        ASTNode source = sourceNode.get();
        if (name == null) {
            return null;
        }
        FieldDeclaration field = fieldNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        MethodDeclaration method = new MethodDeclaration(parent.compilationResult);
        if (makeAbstract) {
            modifier = modifier | 1024 | 16777216;
        }
        method.modifiers = modifier;
        method.returnType = EclipseHandlerUtil.cloneSelfType(fieldNode, source);
        if (method.returnType == null) {
            return null;
        }
        Annotation[] deprecated = null;
        Annotation[] checkerFramework = null;
        if (EclipseHandlerUtil.isFieldDeprecated(fieldNode)) {
            deprecated = new Annotation[]{EclipseHandlerUtil.generateDeprecatedAnnotation(source)};
        }
        if (EclipseHandlerUtil.getCheckerFrameworkVersion(fieldNode).generateSideEffectFree()) {
            checkerFramework = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        char[][] functionalInterfaceName = null;
        int requiredCast = -1;
        TypeReference parameterizer = null;
        boolean superExtendsStyle = true;
        char[] applyMethodName = NAME_APPLY;
        if (field.type instanceof SingleTypeReference) {
            char[] token = field.type.token;
            if (Arrays.equals(token, NAME_CHAR)) {
                requiredCast = 2;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (Arrays.equals(token, NAME_SHORT)) {
                requiredCast = 4;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (Arrays.equals(token, NAME_BYTE)) {
                requiredCast = 3;
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (Arrays.equals(token, NAME_INT)) {
                functionalInterfaceName = NAME_JUF_INTOP;
            } else if (Arrays.equals(token, NAME_LONG)) {
                functionalInterfaceName = NAME_JUF_LONGOP;
            } else if (Arrays.equals(token, NAME_FLOAT)) {
                requiredCast = 9;
                functionalInterfaceName = NAME_JUF_DOUBLEOP;
            } else if (Arrays.equals(token, NAME_DOUBLE)) {
                functionalInterfaceName = NAME_JUF_DOUBLEOP;
            } else if (Arrays.equals(token, NAME_BOOLEAN)) {
                functionalInterfaceName = NAME_JUF_OP;
                parameterizer = new QualifiedTypeReference(NAME_JAVA_LANG_BOOLEAN, new long[3]);
                superExtendsStyle = false;
            }
        }
        if (functionalInterfaceName == NAME_JUF_INTOP) {
            applyMethodName = NAME_APPLY_AS_INT;
        }
        if (functionalInterfaceName == NAME_JUF_LONGOP) {
            applyMethodName = NAME_APPLY_AS_LONG;
        }
        if (functionalInterfaceName == NAME_JUF_DOUBLEOP) {
            applyMethodName = NAME_APPLY_AS_DOUBLE;
        }
        if (functionalInterfaceName == null) {
            functionalInterfaceName = NAME_JUF_FUNCTION;
            parameterizer = EclipseHandlerUtil.copyType(field.type, source);
        }
        method.annotations = EclipseHandlerUtil.copyAnnotations(source, new Annotation[]{(Annotation[]) onMethod.toArray(new Annotation[0]), checkerFramework, deprecated});
        TypeReference fType = null;
        if (parameterizer != null && superExtendsStyle) {
            TypeReference wildcard = new Wildcard(2);
            ((Wildcard) wildcard).bound = parameterizer;
            TypeReference wildcard2 = new Wildcard(1);
            ((Wildcard) wildcard2).bound = EclipseHandlerUtil.copyType(field.type, source);
            ?? r0 = new TypeReference[functionalInterfaceName.length];
            TypeReference[] typeReferenceArr = new TypeReference[2];
            typeReferenceArr[0] = wildcard;
            typeReferenceArr[1] = wildcard2;
            r0[functionalInterfaceName.length - 1] = typeReferenceArr;
            long[] ps = new long[functionalInterfaceName.length];
            fType = new ParameterizedQualifiedTypeReference(functionalInterfaceName, (TypeReference[][]) r0, 0, ps);
        }
        if (parameterizer != null && !superExtendsStyle) {
            ?? r02 = new TypeReference[functionalInterfaceName.length];
            TypeReference[] typeReferenceArr2 = new TypeReference[1];
            typeReferenceArr2[0] = parameterizer;
            r02[functionalInterfaceName.length - 1] = typeReferenceArr2;
            long[] ps2 = new long[functionalInterfaceName.length];
            fType = new ParameterizedQualifiedTypeReference(functionalInterfaceName, (TypeReference[][]) r02, 0, ps2);
        }
        if (parameterizer == null) {
            long[] ps3 = new long[functionalInterfaceName.length];
            fType = new QualifiedTypeReference(functionalInterfaceName, ps3);
        }
        Argument param = new Argument(NAME_TRANSFORMER, p, fType, 16);
        param.sourceStart = pS;
        param.sourceEnd = pE;
        method.arguments = new Argument[]{param};
        method.selector = name.toCharArray();
        method.binding = null;
        method.thrownExceptions = null;
        method.typeParameters = null;
        method.bits |= 8388608;
        if (!makeAbstract) {
            List<Expression> args = new ArrayList<>();
            Iterator<EclipseNode> it = fieldNode.up().down().iterator();
            while (it.hasNext()) {
                EclipseNode child = it.next();
                if (child.getKind() == AST.Kind.FIELD) {
                    FieldDeclaration childDecl = child.get();
                    if (childDecl.name == null || childDecl.name.length <= 0 || childDecl.name[0] != '$') {
                        long fieldFlags = childDecl.modifiers;
                        if ((fieldFlags & 8) == 0 && ((fieldFlags & 16) == 0 || childDecl.initialization == null)) {
                            if (child.get() == fieldNode.get()) {
                                MessageSend ms = new MessageSend();
                                ms.receiver = new SingleNameReference(NAME_TRANSFORMER, 0L);
                                ms.selector = applyMethodName;
                                ms.arguments = new Expression[]{EclipseHandlerUtil.createFieldAccessor(child, HandlerUtil.FieldAccess.ALWAYS_FIELD, source)};
                                if (requiredCast != -1) {
                                    args.add(EclipseHandlerUtil.makeCastExpression(ms, TypeReference.baseTypeReference(requiredCast, 0), source));
                                } else {
                                    args.add(ms);
                                }
                            } else {
                                args.add(EclipseHandlerUtil.createFieldAccessor(child, HandlerUtil.FieldAccess.ALWAYS_FIELD, source));
                            }
                        }
                    }
                }
            }
            AllocationExpression constructorCall = new AllocationExpression();
            constructorCall.arguments = (Expression[]) args.toArray(new Expression[0]);
            constructorCall.type = EclipseHandlerUtil.cloneSelfType(fieldNode, source);
            ReturnStatement returnStatement = new ReturnStatement(constructorCall, pS, pE);
            int i = source.sourceStart;
            method.sourceStart = i;
            method.declarationSourceStart = i;
            method.bodyStart = i;
            int i2 = source.sourceEnd;
            method.sourceEnd = i2;
            method.declarationSourceEnd = i2;
            method.bodyEnd = i2;
            List<Statement> statements = new ArrayList<>(5);
            if (EclipseHandlerUtil.hasNonNullAnnotations(fieldNode) && (nullCheck = EclipseHandlerUtil.generateNullCheck(field, sourceNode, null)) != null) {
                statements.add(nullCheck);
            }
            statements.add(returnStatement);
            method.statements = (Statement[]) statements.toArray(new Statement[0]);
        }
        EclipseHandlerUtil.createRelevantNonNullAnnotation(sourceNode, param);
        EclipseHandlerUtil.createRelevantNonNullAnnotation(fieldNode, method);
        method.traverse(new SetGeneratedByVisitor(source), parent.scope);
        EclipseHandlerUtil.copyJavadoc(fieldNode, method, EclipseHandlerUtil.CopyJavadoc.WITH_BY);
        return method;
    }
}
