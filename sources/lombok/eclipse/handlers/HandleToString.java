package lombok.eclipse.handlers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.ToString;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.CallSuperType;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.InclusionExclusionUtils;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleToString.SCL.lombok */
public class HandleToString extends EclipseAnnotationHandler<ToString> {
    private static final Set<String> BUILT_IN_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList("byte", "short", "int", "long", "char", TypedValues.Custom.S_BOOLEAN, "double", TypedValues.Custom.S_FLOAT)));
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$CallSuperType;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$CallSuperType() {
        int[] iArr = $SWITCH_TABLE$lombok$core$configuration$CallSuperType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CallSuperType.valuesCustom().length];
        try {
            iArr2[CallSuperType.CALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CallSuperType.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CallSuperType.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$core$configuration$CallSuperType = iArr2;
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

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<ToString> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.TO_STRING_FLAG_USAGE, "@ToString");
        ToString ann = annotation.getInstance();
        List<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> members = InclusionExclusionUtils.handleToStringMarking(annotationNode.up(), annotation, annotationNode);
        if (members == null) {
            return;
        }
        Boolean callSuper = Boolean.valueOf(ann.callSuper());
        if (!annotation.isExplicit("callSuper")) {
            callSuper = null;
        }
        Boolean doNotUseGettersConfiguration = (Boolean) annotationNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_DO_NOT_USE_GETTERS);
        boolean doNotUseGetters = (annotation.isExplicit("doNotUseGetters") || doNotUseGettersConfiguration == null) ? ann.doNotUseGetters() : doNotUseGettersConfiguration.booleanValue();
        HandlerUtil.FieldAccess fieldAccess = doNotUseGetters ? HandlerUtil.FieldAccess.PREFER_FIELD : HandlerUtil.FieldAccess.GETTER;
        Boolean fieldNamesConfiguration = (Boolean) annotationNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_INCLUDE_FIELD_NAMES);
        boolean includeFieldNames = (annotation.isExplicit("includeFieldNames") || fieldNamesConfiguration == null) ? ann.includeFieldNames() : fieldNamesConfiguration.booleanValue();
        generateToString(annotationNode.up(), annotationNode, members, includeFieldNames, callSuper, true, fieldAccess);
    }

    public void generateToStringForType(EclipseNode typeNode, EclipseNode errorNode) {
        if (EclipseHandlerUtil.hasAnnotation(ToString.class, typeNode)) {
            return;
        }
        boolean includeFieldNames = true;
        try {
            Boolean configuration = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_INCLUDE_FIELD_NAMES);
            includeFieldNames = configuration != null ? configuration.booleanValue() : ((Boolean) ToString.class.getMethod("includeFieldNames", new Class[0]).getDefaultValue()).booleanValue();
        } catch (Exception unused) {
        }
        Boolean doNotUseGettersConfiguration = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_DO_NOT_USE_GETTERS);
        HandlerUtil.FieldAccess access = (doNotUseGettersConfiguration == null || !doNotUseGettersConfiguration.booleanValue()) ? HandlerUtil.FieldAccess.GETTER : HandlerUtil.FieldAccess.PREFER_FIELD;
        List<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> members = InclusionExclusionUtils.handleToStringMarking(typeNode, null, null);
        generateToString(typeNode, errorNode, members, includeFieldNames, null, false, access);
    }

    public void generateToString(EclipseNode typeNode, EclipseNode errorNode, List<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> members, boolean includeFieldNames, Boolean callSuper, boolean whineIfExists, HandlerUtil.FieldAccess fieldAccess) {
        TypeDeclaration typeDecl = null;
        if (typeNode.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) typeNode.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            errorNode.addError("@ToString is only supported on a class or enum.");
            return;
        }
        switch ($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[EclipseHandlerUtil.methodExists("toString", typeNode, 0).ordinal()]) {
            case 1:
                if (callSuper == null) {
                    if (EclipseHandlerUtil.isDirectDescendantOfObject(typeNode)) {
                        callSuper = false;
                    } else {
                        CallSuperType cst = (CallSuperType) typeNode.getAst().readConfiguration(ConfigurationKeys.TO_STRING_CALL_SUPER);
                        if (cst == null) {
                            cst = CallSuperType.SKIP;
                        }
                        switch ($SWITCH_TABLE$lombok$core$configuration$CallSuperType()[cst.ordinal()]) {
                            case 1:
                                callSuper = true;
                                break;
                            case 2:
                            default:
                                callSuper = false;
                                break;
                            case 3:
                                errorNode.addWarning("Generating toString implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this intentional, add '@ToString(callSuper=false)' to your type.");
                                callSuper = false;
                                break;
                        }
                    }
                }
                MethodDeclaration toString = createToString(typeNode, members, includeFieldNames, callSuper.booleanValue(), errorNode.get(), fieldAccess);
                EclipseHandlerUtil.injectMethod(typeNode, toString);
                return;
            case 2:
                return;
            case 3:
            default:
                if (whineIfExists) {
                    errorNode.addWarning("Not generating toString(): A method with that name already exists");
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r2v34, types: [char[], char[][]] */
    public static MethodDeclaration createToString(EclipseNode type, Collection<InclusionExclusionUtils.Included<EclipseNode, ToString.Include>> members, boolean includeNames, boolean callSuper, ASTNode source, HandlerUtil.FieldAccess fieldAccess) {
        String prefix;
        BinaryExpression binaryExpression;
        Expression memberAccessor;
        Expression ex;
        StringLiteral stringLiteral;
        String typeName = getTypeName(type);
        boolean isEnum = type.isEnumType();
        char[] suffix = ")".toCharArray();
        char[] infix = ", ".toCharArray();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        if (callSuper) {
            prefix = "(super=";
        } else if (members.isEmpty()) {
            prefix = isEnum ? "" : "()";
        } else if (includeNames) {
            InclusionExclusionUtils.Included<EclipseNode, ToString.Include> firstMember = members.iterator().next();
            String name = firstMember.getInc() == null ? "" : firstMember.getInc().name();
            if (name.isEmpty()) {
                name = firstMember.getNode().getName();
            }
            prefix = "(" + name + "=";
        } else {
            prefix = "(";
        }
        boolean first = true;
        if (!isEnum) {
            binaryExpression = new StringLiteral((String.valueOf(typeName) + prefix).toCharArray(), pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
        } else {
            StringLiteral stringLiteral2 = new StringLiteral((String.valueOf(typeName) + ".").toCharArray(), pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(stringLiteral2, source);
            MessageSend thisName = new MessageSend();
            thisName.sourceStart = pS;
            thisName.sourceEnd = pE;
            EclipseHandlerUtil.setGeneratedBy(thisName, source);
            thisName.receiver = new ThisReference(pS, pE);
            EclipseHandlerUtil.setGeneratedBy(thisName.receiver, source);
            thisName.selector = "name".toCharArray();
            binaryExpression = new BinaryExpression(stringLiteral2, thisName, 14);
            EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
            if (!prefix.isEmpty()) {
                StringLiteral px = new StringLiteral(prefix.toCharArray(), pS, pE, 0);
                EclipseHandlerUtil.setGeneratedBy(px, source);
                binaryExpression = new BinaryExpression(binaryExpression, px, 14);
                ((Expression) binaryExpression).sourceStart = pS;
                ((Expression) binaryExpression).sourceEnd = pE;
                EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
            }
        }
        if (callSuper) {
            MessageSend callToSuper = new MessageSend();
            callToSuper.sourceStart = pS;
            callToSuper.sourceEnd = pE;
            EclipseHandlerUtil.setGeneratedBy(callToSuper, source);
            callToSuper.receiver = new SuperReference(pS, pE);
            EclipseHandlerUtil.setGeneratedBy(callToSuper.receiver, source);
            callToSuper.selector = "toString".toCharArray();
            binaryExpression = new BinaryExpression(binaryExpression, callToSuper, 14);
            EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
            first = false;
        }
        for (InclusionExclusionUtils.Included<EclipseNode, ToString.Include> member : members) {
            EclipseNode memberNode = member.getNode();
            TypeReference fieldType = EclipseHandlerUtil.getFieldType(memberNode, fieldAccess);
            if (memberNode.getKind() == AST.Kind.METHOD) {
                memberAccessor = EclipseHandlerUtil.createMethodAccessor(memberNode, source);
            } else {
                memberAccessor = EclipseHandlerUtil.createFieldAccessor(memberNode, fieldAccess, source);
            }
            boolean fieldBaseTypeIsPrimitive = BUILT_IN_TYPES.contains(new String(fieldType.getLastToken()));
            if (fieldType.dimensions() == 0) {
            }
            boolean fieldIsPrimitiveArray = fieldType.dimensions() == 1 && fieldBaseTypeIsPrimitive;
            boolean fieldIsObjectArray = fieldType.dimensions() > 0 && !fieldIsPrimitiveArray;
            if (fieldIsPrimitiveArray || fieldIsObjectArray) {
                Expression messageSend = new MessageSend();
                ((MessageSend) messageSend).sourceStart = pS;
                ((MessageSend) messageSend).sourceEnd = pE;
                ((MessageSend) messageSend).receiver = generateQualifiedNameRef(source, new char[]{TypeConstants.JAVA, TypeConstants.UTIL, "Arrays".toCharArray()});
                ((MessageSend) messageSend).arguments = new Expression[]{memberAccessor};
                EclipseHandlerUtil.setGeneratedBy(((MessageSend) messageSend).arguments[0], source);
                ((MessageSend) messageSend).selector = (fieldIsObjectArray ? "deepToString" : "toString").toCharArray();
                ex = messageSend;
            } else {
                ex = memberAccessor;
            }
            EclipseHandlerUtil.setGeneratedBy(ex, source);
            if (first) {
                binaryExpression = new BinaryExpression(binaryExpression, ex, 14);
                ((Expression) binaryExpression).sourceStart = pS;
                ((Expression) binaryExpression).sourceEnd = pE;
                EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
                first = false;
            } else {
                if (includeNames) {
                    String n = member.getInc() == null ? "" : member.getInc().name();
                    if (n.isEmpty()) {
                        n = memberNode.getName();
                    }
                    char[] namePlusEqualsSign = (String.valueOf(", ") + n + "=").toCharArray();
                    stringLiteral = new StringLiteral(namePlusEqualsSign, pS, pE, 0);
                } else {
                    stringLiteral = new StringLiteral(infix, pS, pE, 0);
                }
                StringLiteral fieldNameLiteral = stringLiteral;
                EclipseHandlerUtil.setGeneratedBy(fieldNameLiteral, source);
                BinaryExpression binaryExpression2 = new BinaryExpression(binaryExpression, fieldNameLiteral, 14);
                EclipseHandlerUtil.setGeneratedBy(binaryExpression2, source);
                binaryExpression = new BinaryExpression(binaryExpression2, ex, 14);
                EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
            }
        }
        if (!first) {
            StringLiteral suffixLiteral = new StringLiteral(suffix, pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(suffixLiteral, source);
            binaryExpression = new BinaryExpression(binaryExpression, suffixLiteral, 14);
            EclipseHandlerUtil.setGeneratedBy(binaryExpression, source);
        }
        Statement returnStatement = new ReturnStatement(binaryExpression, pS, pE);
        EclipseHandlerUtil.setGeneratedBy(returnStatement, source);
        MethodDeclaration method = new MethodDeclaration(type.top().get().compilationResult);
        EclipseHandlerUtil.setGeneratedBy(method, source);
        method.modifiers = EclipseHandlerUtil.toEclipseModifier(AccessLevel.PUBLIC);
        method.returnType = new QualifiedTypeReference(TypeConstants.JAVA_LANG_STRING, new long[]{p, p, p});
        EclipseHandlerUtil.setGeneratedBy(method.returnType, source);
        Annotation overrideAnnotation = EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, source);
        if (EclipseHandlerUtil.getCheckerFrameworkVersion(type).generateSideEffectFree()) {
            method.annotations = new Annotation[]{overrideAnnotation, EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        } else {
            method.annotations = new Annotation[]{overrideAnnotation};
        }
        method.arguments = null;
        method.selector = "toString".toCharArray();
        method.thrownExceptions = null;
        method.typeParameters = null;
        method.bits |= 8388608;
        int i = source.sourceStart;
        method.sourceStart = i;
        method.declarationSourceStart = i;
        method.bodyStart = i;
        int i2 = source.sourceEnd;
        method.sourceEnd = i2;
        method.declarationSourceEnd = i2;
        method.bodyEnd = i2;
        method.statements = new Statement[]{returnStatement};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(type, method);
        return method;
    }

    public static String getTypeName(EclipseNode type) {
        String typeName = getSingleTypeName(type);
        EclipseNode up = type.up();
        while (true) {
            EclipseNode upType = up;
            if (upType.getKind() == AST.Kind.TYPE) {
                typeName = String.valueOf(getSingleTypeName(upType)) + "." + typeName;
                up = upType.up();
            } else {
                return typeName;
            }
        }
    }

    public static String getSingleTypeName(EclipseNode type) {
        TypeDeclaration typeDeclaration = type.get();
        char[] rawTypeName = typeDeclaration.name;
        return rawTypeName == null ? "" : new String(rawTypeName);
    }

    public static NameReference generateQualifiedNameRef(ASTNode source, char[]... varNames) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        SingleNameReference qualifiedNameReference = varNames.length > 1 ? new QualifiedNameReference(varNames, new long[varNames.length], pS, pE) : new SingleNameReference(varNames[0], p);
        EclipseHandlerUtil.setGeneratedBy(qualifiedNameReference, source);
        return qualifiedNameReference;
    }
}
