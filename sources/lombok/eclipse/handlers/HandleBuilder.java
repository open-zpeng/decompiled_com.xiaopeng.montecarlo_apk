package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.Singular;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Receiver;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
@HandlerPriority(-1024)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleBuilder.SCL.lombok */
public class HandleBuilder extends EclipseAnnotationHandler<Builder> {
    private HandleConstructor handleConstructor = new HandleConstructor();
    static final char[] CLEAN_FIELD_NAME = "$lombokUnclean".toCharArray();
    static final char[] CLEAN_METHOD_NAME = "$lombokClean".toCharArray();
    static final String TO_BUILDER_METHOD_NAME_STRING = "toBuilder";
    static final char[] TO_BUILDER_METHOD_NAME = TO_BUILDER_METHOD_NAME_STRING.toCharArray();
    static final char[] DEFAULT_PREFIX = {'$', 'd', 'e', 'f', 'a', 'u', 'l', 't', '$'};
    static final char[] SET_PREFIX = {'$', 's', 'e', 't'};
    static final char[] VALUE_PREFIX = {'$', 'v', 'a', 'l', 'u', 'e'};
    static final char[] BUILDER_TEMP_VAR = {'b', 'u', 'i', 'l', 'd', 'e', 'r'};
    static final AbstractMethodDeclaration[] EMPTY_METHODS = new AbstractMethodDeclaration[0];
    static final String TO_BUILDER_NOT_SUPPORTED = "@Builder(toBuilder=true) is only supported if you return your own type.";
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleBuilder$BuilderFieldData.SCL.lombok */
    public static class BuilderFieldData {
        Annotation[] annotations;
        TypeReference type;
        char[] rawName;
        char[] name;
        char[] builderFieldName;
        char[] nameOfDefaultProvider;
        char[] nameOfSetFlag;
        EclipseSingularsRecipes.SingularData singularData;
        Builder.ObtainVia obtainVia;
        EclipseNode obtainViaNode;
        EclipseNode originalFieldNode;
        List<EclipseNode> createdFields = new ArrayList();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toBoolean(Object expr, boolean defaultValue) {
        if (expr == null) {
            return defaultValue;
        }
        if (expr instanceof FalseLiteral) {
            return false;
        }
        if (expr instanceof TrueLiteral) {
            return true;
        }
        return ((Boolean) expr).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleBuilder$BuilderJob.SCL.lombok */
    public static class BuilderJob {
        CheckerFrameworkVersion checkerFramework;
        EclipseNode parentType;
        String builderMethodName;
        String buildMethodName;
        boolean isStatic;
        TypeParameter[] typeParams;
        TypeParameter[] builderTypeParams;
        ASTNode source;
        EclipseNode sourceNode;
        List<BuilderFieldData> builderFields;
        AccessLevel accessInners;
        AccessLevel accessOuters;
        boolean oldFluent;
        boolean oldChain;
        boolean toBuilder;
        EclipseNode builderType;
        String builderClassName;
        char[] builderClassNameArr;

        void setBuilderClassName(String builderClassName) {
            this.builderClassName = builderClassName;
            this.builderClassNameArr = builderClassName.toCharArray();
        }

        TypeParameter[] copyTypeParams() {
            return EclipseHandlerUtil.copyTypeParams(this.typeParams, this.source);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long getPos() {
            return (this.source.sourceStart << 32) | this.source.sourceEnd;
        }

        public TypeReference createBuilderTypeReference() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, !this.isStatic, this.builderTypeParams, getPos());
        }

        public TypeReference createBuilderTypeReferenceForceStatic() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.builderClassNameArr, false, this.builderTypeParams, getPos());
        }

        public TypeReference createBuilderParentTypeReference() {
            return EclipseHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType, this.typeParams, getPos());
        }

        public EclipseNode getTopNode() {
            return this.parentType.top();
        }

        void init(AnnotationValues<Builder> annValues, Builder ann, EclipseNode node) {
            this.accessOuters = ann.access();
            if (this.accessOuters == null) {
                this.accessOuters = AccessLevel.PUBLIC;
            }
            if (this.accessOuters == AccessLevel.NONE) {
                this.sourceNode.addError("AccessLevel.NONE is not valid here");
                this.accessOuters = AccessLevel.PUBLIC;
            }
            this.accessInners = this.accessOuters == AccessLevel.PROTECTED ? AccessLevel.PUBLIC : this.accessOuters;
            this.oldFluent = HandleBuilder.toBoolean(annValues.getActualExpression("fluent"), true);
            this.oldChain = HandleBuilder.toBoolean(annValues.getActualExpression("chain"), true);
            this.builderMethodName = ann.builderMethodName();
            this.buildMethodName = ann.buildMethodName();
            setBuilderClassName(fixBuilderClassName(node, ann.builderClassName()));
            this.toBuilder = ann.toBuilder();
            if (this.builderMethodName == null) {
                this.builderMethodName = "builder";
            }
            if (this.buildMethodName == null) {
                this.buildMethodName = "build";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String fixBuilderClassName(EclipseNode node, String override) {
            if (override == null || override.isEmpty()) {
                String override2 = (String) node.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
                return (override2 == null || override2.isEmpty()) ? "*Builder" : override2;
            }
            return override;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MethodDeclaration createNewMethodDeclaration() {
            return new MethodDeclaration(getTopNode().get().compilationResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String replaceBuilderClassName(char[] name) {
            return this.builderClassName.indexOf(42) == -1 ? this.builderClassName : this.builderClassName.replace("*", new String(name));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String replaceBuilderClassName(String name) {
            return this.builderClassName.replace("*", name);
        }
    }

    private static boolean equals(String a, char[] b) {
        if (a.length() != b.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if (a.charAt(i) != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(String a, char[][] b) {
        if (a == null || a.isEmpty()) {
            return b.length == 0;
        }
        String[] aParts = a.split("\\.");
        if (aParts.length != b.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if (!equals(aParts[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    private static final char[] prefixWith(char[] prefix, char[] name) {
        char[] out = new char[prefix.length + name.length];
        System.arraycopy(prefix, 0, out, 0, prefix.length);
        System.arraycopy(name, 0, out, prefix.length, name.length);
        return out;
    }

    /* JADX WARN: Code restructure failed: missing block: B:221:0x0817, code lost:
        generateBuilderFields(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x081f, code lost:
        if (r23 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0822, code lost:
        r0 = new org.eclipse.jdt.internal.compiler.ast.FieldDeclaration(lombok.eclipse.handlers.HandleBuilder.CLEAN_FIELD_NAME, 0, -1);
        r0.declarationSourceEnd = -1;
        r0.modifiers = 2;
        r0.type = org.eclipse.jdt.internal.compiler.ast.TypeReference.baseTypeReference(5, 0);
        r0.traverse(new lombok.eclipse.handlers.SetGeneratedByVisitor(r12), (org.eclipse.jdt.internal.compiler.lookup.MethodScope) null);
        lombok.eclipse.handlers.EclipseHandlerUtil.injectFieldAndMarkGenerated(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x086a, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.constructorExists(r0.builderType) != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x086d, code lost:
        r0 = lombok.eclipse.handlers.HandleConstructor.createConstructor(lombok.AccessLevel.PACKAGE, r0.builderType, java.util.Collections.emptyList(), false, r13, java.util.Collections.emptyList());
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0884, code lost:
        if (r0 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0887, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0892, code lost:
        r0 = r0.builderFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x08a1, code lost:
        makePrefixedSetterMethodsForBuilder(r0, r0.next(), r0.setterPrefix());
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x08c3, code lost:
        if (r0.hasNext() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x08c6, code lost:
        r25 = lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(r0.buildMethodName, r0.builderType, -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x08db, code lost:
        if (r25 != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x08de, code lost:
        r25 = lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(r0.buildMethodName, r0.builderType, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x08f3, code lost:
        if (r25 != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x08f6, code lost:
        r0 = generateBuildMethod(r0, r21, r19, r20, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0908, code lost:
        if (r0 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x090b, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0925, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.methodExists("toString", r0.builderType, 0) != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0928, code lost:
        r0 = new java.util.ArrayList<>();
        r0 = r0.builderFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0940, code lost:
        r0 = r0.next().createdFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x095b, code lost:
        r0 = r0.next();
        r0.add(new lombok.core.handlers.InclusionExclusionUtils.Included<>(r0, null, true, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0982, code lost:
        if (r0.hasNext() != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x098c, code lost:
        if (r0.hasNext() != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x098f, code lost:
        r0 = lombok.eclipse.handlers.HandleToString.createToString(r0.builderType, r0, true, false, r12, lombok.core.handlers.HandlerUtil.FieldAccess.ALWAYS_FIELD);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x09a3, code lost:
        if (r0 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x09a6, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x09b3, code lost:
        if (r23 == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x09b6, code lost:
        r0 = generateCleanMethod(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x09c0, code lost:
        if (r0 == null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x09c3, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x09d0, code lost:
        if (r17 == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x09e4, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(r0.builderMethodName, r0.parentType, -1) == lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x09e7, code lost:
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x09ec, code lost:
        if (r17 == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x09ef, code lost:
        r0 = generateBuilderMethod(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x09f9, code lost:
        if (r0 == null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x09fc, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.parentType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0a0c, code lost:
        if (r0.toBuilder == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0a21, code lost:
        switch($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(lombok.eclipse.handlers.HandleBuilder.TO_BUILDER_METHOD_NAME_STRING, r0.parentType, 0).ordinal()]) {
            case 1: goto L147;
            case 2: goto L157;
            case 3: goto L146;
            default: goto L157;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0a3c, code lost:
        r13.addWarning("Not generating toBuilder() as it already exists.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0a46, code lost:
        r25 = r0.typeParams;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0a4f, code lost:
        if (r16 == null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0a52, code lost:
        r25 = new org.eclipse.jdt.internal.compiler.ast.TypeParameter[r16.size()];
        r26 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0a64, code lost:
        r25[r26] = new org.eclipse.jdt.internal.compiler.ast.TypeParameter();
        r25[r26].name = r16.get(r26);
        r26 = r26 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0a8c, code lost:
        if (r26 < r25.length) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0a8f, code lost:
        r0 = generateToBuilderMethod(r0, r25, r0.setterPrefix());
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0aa2, code lost:
        if (r0 == null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0aa5, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.parentType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0ab2, code lost:
        if (r24 == null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0ab7, code lost:
        if (r17 == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0aba, code lost:
        r0 = r24.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0ac6, code lost:
        r0.next().addWarning("@Builder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0ae1, code lost:
        if (r0.hasNext() != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0ae4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v156, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[]] */
    /* JADX WARN: Type inference failed for: r1v66, types: [char[][]] */
    /* JADX WARN: Type inference failed for: r2v51, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    /* JADX WARN: Type inference failed for: r2v62, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    @Override // lombok.eclipse.EclipseAnnotationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handle(lombok.core.AnnotationValues<lombok.Builder> r11, org.eclipse.jdt.internal.compiler.ast.Annotation r12, lombok.eclipse.EclipseNode r13) {
        /*
            Method dump skipped, instructions count: 2789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.eclipse.handlers.HandleBuilder.handle(lombok.core.AnnotationValues, org.eclipse.jdt.internal.compiler.ast.Annotation, lombok.eclipse.EclipseNode):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] returnTypeToBuilderClassName(EclipseNode annotationNode, MethodDeclaration md, TypeParameter[] typeParams) {
        char[] token;
        if (md.returnType instanceof QualifiedTypeReference) {
            char[][] tokens = md.returnType.tokens;
            token = tokens[tokens.length - 1];
        } else if (md.returnType instanceof SingleTypeReference) {
            token = md.returnType.token;
            if (!(md.returnType instanceof ParameterizedSingleTypeReference) && typeParams != null) {
                for (TypeParameter tp : typeParams) {
                    if (Arrays.equals(tp.name, token)) {
                        annotationNode.addError("@Builder requires specifying 'builderClassName' if used on methods with a type parameter as return type.");
                        return null;
                    }
                }
            }
        } else {
            annotationNode.addError("Unexpected kind of return type on annotated method. Specify 'builderClassName' to solve this problem.");
            return null;
        }
        if (Character.isLowerCase(token[0])) {
            char[] newToken = new char[token.length];
            System.arraycopy(token, 1, newToken, 1, token.length - 1);
            newToken[0] = Character.toTitleCase(token[0]);
            token = newToken;
        }
        return token;
    }

    /* JADX WARN: Type inference failed for: r1v88, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private MethodDeclaration generateToBuilderMethod(BuilderJob job, TypeParameter[] typeParameters, String prefix) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = job.getPos();
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = TO_BUILDER_METHOD_NAME;
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        out.bits |= 8388608;
        out.returnType = job.createBuilderTypeReference();
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len];
            Annotation[] annotationArr = new Annotation[1];
            annotationArr[0] = EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE);
            out.returnType.annotations[len - 1] = annotationArr;
        }
        AllocationExpression invoke = new AllocationExpression();
        invoke.type = job.createBuilderTypeReference();
        AllocationExpression allocationExpression = invoke;
        List<Statement> preStatements = null;
        List<Statement> postStatements = null;
        for (BuilderFieldData bfd : job.builderFields) {
            String setterName = new String(bfd.name);
            String setterPrefix = !prefix.isEmpty() ? prefix : job.oldFluent ? "" : "set";
            if (!setterPrefix.isEmpty()) {
                setterName = HandlerUtil.buildAccessorName(setterPrefix, setterName);
            }
            AllocationExpression messageSend = new MessageSend();
            Expression[] tgt = new Expression[bfd.singularData == null ? 1 : 2];
            if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
                char[] fieldName = bfd.obtainVia == null ? bfd.rawName : bfd.obtainVia.field().toCharArray();
                for (int i = 0; i < tgt.length; i++) {
                    FieldReference fr = new FieldReference(fieldName, 0L);
                    fr.receiver = new ThisReference(0, 0);
                    tgt[i] = fr;
                }
            } else {
                String obtainName = bfd.obtainVia.method();
                boolean obtainIsStatic = bfd.obtainVia.isStatic();
                MessageSend obtainExpr = new MessageSend();
                if (obtainIsStatic) {
                    if (typeParameters != null && typeParameters.length > 0) {
                        obtainExpr.typeArguments = new TypeReference[typeParameters.length];
                        for (int j = 0; j < typeParameters.length; j++) {
                            obtainExpr.typeArguments[j] = new SingleTypeReference(typeParameters[j].name, 0L);
                        }
                    }
                    obtainExpr.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, 0L);
                } else {
                    obtainExpr.receiver = new ThisReference(0, 0);
                }
                obtainExpr.selector = obtainName.toCharArray();
                if (obtainIsStatic) {
                    obtainExpr.arguments = new Expression[]{new ThisReference(0, 0)};
                }
                for (int i2 = 0; i2 < tgt.length; i2++) {
                    tgt[i2] = new SingleNameReference(bfd.name, 0L);
                }
                LocalDeclaration ld = new LocalDeclaration(bfd.name, 0, 0);
                ld.modifiers = 16;
                ld.type = EclipseHandlerUtil.copyType(bfd.type, job.source);
                ld.initialization = obtainExpr;
                if (preStatements == null) {
                    preStatements = new ArrayList<>();
                }
                preStatements.add(ld);
            }
            ((MessageSend) messageSend).selector = setterName.toCharArray();
            if (bfd.singularData == null) {
                ((MessageSend) messageSend).arguments = tgt;
                ((MessageSend) messageSend).receiver = allocationExpression;
                allocationExpression = messageSend;
            } else {
                ((MessageSend) messageSend).arguments = new Expression[]{tgt[1]};
                ((MessageSend) messageSend).receiver = new SingleNameReference(BUILDER_TEMP_VAR, p);
                EqualExpression isNotNull = new EqualExpression(tgt[0], new NullLiteral(pS, pE), 29);
                if (postStatements == null) {
                    postStatements = new ArrayList<>();
                }
                postStatements.add(new IfStatement(isNotNull, messageSend, pS, pE));
            }
        }
        int preSs = preStatements == null ? 0 : preStatements.size();
        int postSs = postStatements == null ? 0 : postStatements.size();
        if (postSs > 0) {
            out.statements = new Statement[preSs + postSs + 2];
            for (int i3 = 0; i3 < preSs; i3++) {
                out.statements[i3] = preStatements.get(i3);
            }
            for (int i4 = 0; i4 < postSs; i4++) {
                out.statements[preSs + 1 + i4] = postStatements.get(i4);
            }
            Statement localDeclaration = new LocalDeclaration(BUILDER_TEMP_VAR, pS, pE);
            out.statements[preSs] = localDeclaration;
            ((LocalDeclaration) localDeclaration).modifiers |= 16;
            ((LocalDeclaration) localDeclaration).type = job.createBuilderTypeReference();
            ((LocalDeclaration) localDeclaration).type.sourceStart = pS;
            ((LocalDeclaration) localDeclaration).type.sourceEnd = pE;
            ((LocalDeclaration) localDeclaration).initialization = allocationExpression;
            out.statements[preSs + postSs + 1] = new ReturnStatement(new SingleNameReference(BUILDER_TEMP_VAR, p), pS, pE);
        } else {
            out.statements = new Statement[preSs + 1];
            for (int i5 = 0; i5 < preSs; i5++) {
                out.statements[i5] = preStatements.get(i5);
            }
            out.statements[preSs] = new ReturnStatement(allocationExpression, pS, pE);
        }
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    private MethodDeclaration generateCleanMethod(BuilderJob job) {
        List<Statement> statements = new ArrayList<>();
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, job.builderType, statements);
            }
        }
        FieldReference thisUnclean = new FieldReference(CLEAN_FIELD_NAME, 0L);
        thisUnclean.receiver = new ThisReference(0, 0);
        statements.add(new Assignment(thisUnclean, new FalseLiteral(0, 0), 0));
        MethodDeclaration decl = job.createNewMethodDeclaration();
        decl.selector = CLEAN_METHOD_NAME;
        decl.modifiers = 2;
        decl.bits |= 8388608;
        decl.returnType = TypeReference.baseTypeReference(6, 0);
        decl.statements = (Statement[]) statements.toArray(new Statement[0]);
        decl.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return decl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    public static Receiver generateNotCalledReceiver(BuilderJob job, String setterName) {
        char[][] nameNotCalled = Eclipse.fromQualifiedName(CheckerFrameworkVersion.NAME__NOT_CALLED);
        Annotation singleMemberAnnotation = new SingleMemberAnnotation(new QualifiedTypeReference(nameNotCalled, Eclipse.poss(job.source, nameNotCalled.length)), job.source.sourceStart);
        ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = new StringLiteral(setterName.toCharArray(), 0, 0, 0);
        TypeReference typeReference = job.createBuilderTypeReference();
        int trLen = typeReference.getTypeName().length;
        typeReference.annotations = new Annotation[trLen];
        Annotation[] annotationArr = new Annotation[1];
        annotationArr[0] = singleMemberAnnotation;
        typeReference.annotations[trLen - 1] = annotationArr;
        return new Receiver(new char[]{'t', 'h', 'i', 's'}, 0L, typeReference, (NameReference) null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v15, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    public static Receiver generateBuildReceiver(BuilderJob job) {
        if (job.checkerFramework.generateCalledMethods()) {
            List<char[]> mandatories = new ArrayList<>();
            for (BuilderFieldData bfd : job.builderFields) {
                if (bfd.singularData == null && bfd.nameOfSetFlag == null) {
                    mandatories.add(bfd.name);
                }
            }
            if (mandatories.size() == 0) {
                return null;
            }
            int pS = job.source.sourceStart;
            int pE = job.source.sourceEnd;
            char[][] nameCalled = Eclipse.fromQualifiedName(CheckerFrameworkVersion.NAME__CALLED);
            Annotation singleMemberAnnotation = new SingleMemberAnnotation(new QualifiedTypeReference(nameCalled, Eclipse.poss(job.source, nameCalled.length)), pS);
            if (mandatories.size() == 1) {
                ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = new StringLiteral(mandatories.get(0), 0, 0, 0);
            } else {
                ArrayInitializer arr = new ArrayInitializer();
                arr.sourceStart = pS;
                arr.sourceEnd = pE;
                arr.expressions = new Expression[mandatories.size()];
                for (int i = 0; i < arr.expressions.length; i++) {
                    arr.expressions[i] = new StringLiteral(mandatories.get(i), pS, pE, 0);
                }
                ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = arr;
            }
            TypeReference typeReference = job.createBuilderTypeReference();
            int len = typeReference.getTypeName().length;
            typeReference.annotations = new Annotation[len];
            Annotation[] annotationArr = new Annotation[1];
            annotationArr[0] = singleMemberAnnotation;
            typeReference.annotations[len - 1] = annotationArr;
            return new Receiver(new char[]{'t', 'h', 'i', 's'}, 0L, typeReference, (NameReference) null, 0);
        }
        return null;
    }

    public MethodDeclaration generateBuildMethod(BuilderJob job, char[] staticName, TypeReference returnType, TypeReference[] thrownExceptions, boolean addCleaning) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        List<Statement> statements = new ArrayList<>();
        if (addCleaning) {
            FieldReference thisUnclean = new FieldReference(CLEAN_FIELD_NAME, 0L);
            thisUnclean.receiver = new ThisReference(0, 0);
            UnaryExpression unaryExpression = new UnaryExpression(thisUnclean, 11);
            MessageSend invokeClean = new MessageSend();
            invokeClean.selector = CLEAN_METHOD_NAME;
            statements.add(new IfStatement(unaryExpression, invokeClean, 0, 0));
        }
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendBuildCode(bfd.singularData, job.builderType, statements, bfd.builderFieldName, "this");
            }
        }
        List<Expression> args = new ArrayList<>();
        for (BuilderFieldData bfd2 : job.builderFields) {
            if (bfd2.nameOfSetFlag != null) {
                LocalDeclaration ld = new LocalDeclaration(bfd2.builderFieldName, 0, 0);
                ld.type = EclipseHandlerUtil.copyType(bfd2.type);
                FieldReference builderAssign = new FieldReference(bfd2.builderFieldName, 0L);
                builderAssign.receiver = new ThisReference(0, 0);
                ld.initialization = builderAssign;
                statements.add(ld);
                MessageSend inv = new MessageSend();
                inv.sourceStart = job.source.sourceStart;
                inv.sourceEnd = job.source.sourceEnd;
                inv.receiver = new SingleNameReference(job.parentType.get().name, 0L);
                inv.selector = bfd2.nameOfDefaultProvider;
                inv.typeArguments = typeParameterNames(job.builderType.get().typeParameters);
                Assignment defaultAssign = new Assignment(new SingleNameReference(bfd2.builderFieldName, 0L), inv, 0);
                FieldReference thisSet = new FieldReference(bfd2.nameOfSetFlag, 0L);
                thisSet.receiver = new ThisReference(0, 0);
                statements.add(new IfStatement(new UnaryExpression(thisSet, 11), defaultAssign, 0, 0));
            }
            if (bfd2.nameOfSetFlag != null || (bfd2.singularData != null && bfd2.singularData.getSingularizer().shadowedDuringBuild())) {
                args.add(new SingleNameReference(bfd2.builderFieldName, 0L));
            } else {
                FieldReference fr = new FieldReference(bfd2.builderFieldName, 0L);
                fr.receiver = new ThisReference(0, 0);
                args.add(fr);
            }
        }
        if (addCleaning) {
            FieldReference thisUnclean2 = new FieldReference(CLEAN_FIELD_NAME, 0L);
            thisUnclean2.receiver = new ThisReference(0, 0);
            statements.add(new Assignment(thisUnclean2, new TrueLiteral(0, 0), 0));
        }
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessInners);
        out.selector = job.buildMethodName.toCharArray();
        out.thrownExceptions = EclipseHandlerUtil.copyTypes(thrownExceptions);
        out.bits |= 8388608;
        out.returnType = returnType;
        if (staticName == null) {
            AllocationExpression allocationStatement = new AllocationExpression();
            allocationStatement.type = EclipseHandlerUtil.copyType(out.returnType);
            allocationStatement.arguments = args.isEmpty() ? null : (Expression[]) args.toArray(new Expression[0]);
            statements.add(new ReturnStatement(allocationStatement, 0, 0));
        } else {
            MessageSend invoke = new MessageSend();
            invoke.selector = staticName;
            if (job.isStatic) {
                invoke.receiver = new SingleNameReference(job.builderType.up().getName().toCharArray(), 0L);
            } else {
                invoke.receiver = new QualifiedThisReference(EclipseHandlerUtil.generateTypeReference(job.builderType.up(), 0L), 0, 0);
            }
            invoke.typeArguments = typeParameterNames(job.builderType.get().typeParameters);
            invoke.arguments = args.isEmpty() ? null : (Expression[]) args.toArray(new Expression[0]);
            if ((returnType instanceof SingleTypeReference) && Arrays.equals(TypeConstants.VOID, ((SingleTypeReference) returnType).token)) {
                statements.add(invoke);
            } else {
                statements.add(new ReturnStatement(invoke, 0, 0));
            }
        }
        out.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        if (job.checkerFramework.generateSideEffectFree()) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        out.receiver = generateBuildReceiver(job);
        if (staticName == null) {
            EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        }
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private TypeReference[] typeParameterNames(TypeParameter[] typeParameters) {
        if (typeParameters == null) {
            return null;
        }
        TypeReference[] trs = new TypeReference[typeParameters.length];
        for (int i = 0; i < trs.length; i++) {
            trs[i] = new SingleTypeReference(typeParameters[i].name, 0L);
        }
        return trs;
    }

    public static MethodDeclaration generateDefaultProvider(char[] methodName, TypeParameter[] typeParameters, EclipseNode fieldNode, ASTNode source) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        MethodDeclaration out = new MethodDeclaration(fieldNode.top().get().compilationResult);
        out.typeParameters = EclipseHandlerUtil.copyTypeParams(typeParameters, source);
        out.selector = methodName;
        out.modifiers = 10;
        out.bits |= 8388608;
        FieldDeclaration fd = fieldNode.get();
        out.returnType = EclipseHandlerUtil.copyType(fd.type, source);
        out.statements = new Statement[]{new ReturnStatement(fd.initialization, pS, pE)};
        fd.initialization = null;
        out.traverse(new SetGeneratedByVisitor(source), fieldNode.up().get().scope);
        return out;
    }

    /* JADX WARN: Type inference failed for: r1v30, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    public MethodDeclaration generateBuilderMethod(BuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = job.getPos();
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = job.builderMethodName.toCharArray();
        out.modifiers = EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        if (job.isStatic) {
            out.modifiers |= 8;
        }
        out.bits |= 8388608;
        out.returnType = job.createBuilderTypeReference();
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len];
            Annotation[] annotationArr = new Annotation[1];
            annotationArr[0] = EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE);
            out.returnType.annotations[len - 1] = annotationArr;
        }
        out.typeParameters = job.copyTypeParams();
        AllocationExpression invoke = new AllocationExpression();
        if (job.isStatic) {
            invoke.type = job.createBuilderTypeReferenceForceStatic();
            out.statements = new Statement[]{new ReturnStatement(invoke, pS, pE)};
        } else {
            QualifiedAllocationExpression qualifiedInvoke = new QualifiedAllocationExpression();
            qualifiedInvoke.enclosingInstance = new ThisReference(pS, pE);
            if (job.typeParams == null || job.typeParams.length == 0) {
                qualifiedInvoke.type = new SingleTypeReference(job.builderClassNameArr, p);
            } else {
                qualifiedInvoke.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(null, job.builderClassNameArr, false, job.typeParams, p);
            }
            out.statements = new Statement[]{new ReturnStatement(qualifiedInvoke, pS, pE)};
        }
        if (job.checkerFramework.generateSideEffectFree()) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE)};
        }
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.builderType.get().scope);
        return out;
    }

    public void generateBuilderFields(BuilderJob job) {
        List<EclipseNode> existing = new ArrayList<>();
        Iterator<EclipseNode> it = job.builderType.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.FIELD) {
                existing.add(child);
            }
        }
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.createdFields.addAll(bfd.singularData.getSingularizer().generateFields(bfd.singularData, job.builderType));
            } else {
                EclipseNode field = null;
                EclipseNode setFlag = null;
                for (EclipseNode exists : existing) {
                    char[] n = exists.get().name;
                    if (Arrays.equals(n, bfd.builderFieldName)) {
                        field = exists;
                    }
                    if (bfd.nameOfSetFlag != null && Arrays.equals(n, bfd.nameOfSetFlag)) {
                        setFlag = exists;
                    }
                }
                if (field == null) {
                    FieldDeclaration fd = new FieldDeclaration(bfd.builderFieldName, 0, 0);
                    fd.bits |= 8388608;
                    fd.modifiers = 2;
                    fd.type = EclipseHandlerUtil.copyType(bfd.type);
                    fd.traverse(new SetGeneratedByVisitor(job.source), (MethodScope) null);
                    field = EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, fd);
                }
                if (setFlag == null && bfd.nameOfSetFlag != null) {
                    FieldDeclaration fd2 = new FieldDeclaration(bfd.nameOfSetFlag, 0, 0);
                    fd2.bits |= 8388608;
                    fd2.modifiers = 2;
                    fd2.type = TypeReference.baseTypeReference(5, 0);
                    fd2.traverse(new SetGeneratedByVisitor(job.source), (MethodScope) null);
                    EclipseHandlerUtil.injectFieldAndMarkGenerated(job.builderType, fd2);
                }
                bfd.createdFields.add(field);
            }
        }
    }

    public void makePrefixedSetterMethodsForBuilder(BuilderJob job, BuilderFieldData bfd, String prefix) {
        boolean deprecate = EclipseHandlerUtil.isFieldDeprecated(bfd.originalFieldNode);
        if (bfd.singularData == null || bfd.singularData.getSingularizer() == null) {
            makePrefixedSetterMethodForBuilder(job, bfd, deprecate, prefix);
        } else {
            bfd.singularData.getSingularizer().generateMethods(job, bfd.singularData, deprecate);
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private void makePrefixedSetterMethodForBuilder(BuilderJob job, BuilderFieldData bfd, boolean deprecate, String prefix) {
        String setterName;
        TypeDeclaration td = (TypeDeclaration) job.builderType.get();
        EclipseNode fieldNode = bfd.createdFields.get(0);
        AbstractMethodDeclaration[] existing = td.methods;
        if (existing == null) {
            existing = EMPTY_METHODS;
        }
        int len = existing.length;
        String setterPrefix = prefix.isEmpty() ? "set" : prefix;
        if (job.oldFluent) {
            setterName = prefix.isEmpty() ? new String(bfd.name) : HandlerUtil.buildAccessorName(setterPrefix, new String(bfd.name));
        } else {
            setterName = HandlerUtil.buildAccessorName(setterPrefix, new String(bfd.name));
        }
        for (int i = 0; i < len; i++) {
            if (existing[i] instanceof MethodDeclaration) {
                char[] existingName = existing[i].selector;
                if (Arrays.equals(setterName.toCharArray(), existingName) && !EclipseHandlerUtil.isTolerate(fieldNode, existing[i])) {
                    return;
                }
            }
        }
        List<Annotation> methodAnnsList = Collections.emptyList();
        Annotation[] methodAnns = EclipseHandlerUtil.findCopyableToSetterAnnotations(bfd.originalFieldNode);
        if (methodAnns != null && methodAnns.length > 0) {
            methodAnnsList = Arrays.asList(methodAnns);
        }
        ASTNode source = job.sourceNode.get();
        MethodDeclaration setter = HandleSetter.createSetter(td, deprecate, fieldNode, setterName, bfd.name, bfd.nameOfSetFlag, job.oldChain, EclipseHandlerUtil.toEclipseModifier(job.accessInners), job.sourceNode, methodAnnsList, bfd.annotations != null ? Arrays.asList(EclipseHandlerUtil.copyAnnotations(source, new Annotation[]{bfd.annotations})) : Collections.emptyList());
        if (job.checkerFramework.generateCalledMethods()) {
            setter.receiver = generateNotCalledReceiver(job, setterName);
        }
        if (job.sourceNode.up().getKind() == AST.Kind.METHOD) {
            copyJavadocFromParam(bfd.originalFieldNode.up(), setter, td, bfd.name.toString());
        } else {
            EclipseHandlerUtil.copyJavadoc(bfd.originalFieldNode, setter, td, EclipseHandlerUtil.CopyJavadoc.SETTER, true);
        }
        EclipseHandlerUtil.injectMethod(job.builderType, setter);
    }

    private void copyJavadocFromParam(EclipseNode from, MethodDeclaration to, TypeDeclaration type, String param) {
        try {
            CompilationUnitDeclaration cud = from.top().get();
            String methodComment = EclipseHandlerUtil.getDocComment(cud, from.get());
            if (methodComment == null) {
                return;
            }
            Pattern pattern = Pattern.compile("@param " + param + " (\\S|\\s)+?(?=^ ?@)", 10);
            Matcher matcher = pattern.matcher(methodComment);
            if (matcher.find()) {
                String newJavadoc = HandlerUtil.addReturnsThisIfNeeded(matcher.group());
                EclipseHandlerUtil.setDocComment(cud, type, to, newJavadoc);
            }
        } catch (Exception unused) {
        }
    }

    public void makeBuilderClass(BuilderJob job) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= EclipseHandlerUtil.toEclipseModifier(job.accessOuters);
        if (job.isStatic) {
            builder.modifiers |= 8;
        }
        builder.typeParameters = job.copyTypeParams();
        builder.name = job.builderClassNameArr;
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        job.builderType = EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    private void addObtainVia(BuilderFieldData bfd, EclipseNode node) {
        Iterator<EclipseNode> it = node.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (EclipseHandlerUtil.annotationTypeMatches(Builder.ObtainVia.class, child)) {
                AnnotationValues<Builder.ObtainVia> ann = EclipseHandlerUtil.createAnnotation(Builder.ObtainVia.class, child);
                bfd.obtainVia = ann.getInstance();
                bfd.obtainViaNode = child;
                return;
            }
        }
    }

    private EclipseSingularsRecipes.SingularData getSingularData(EclipseNode node, ASTNode source, String setterPrefix) {
        String typeName;
        Iterator<EclipseNode> it = node.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (EclipseHandlerUtil.annotationTypeMatches(Singular.class, child)) {
                char[] pluralName = node.getKind() == AST.Kind.FIELD ? EclipseHandlerUtil.removePrefixFromField(node) : node.get().name;
                AnnotationValues<Singular> ann = EclipseHandlerUtil.createAnnotation(Singular.class, child);
                Singular singularInstance = ann.getInstance();
                String explicitSingular = singularInstance.value();
                if (explicitSingular.isEmpty()) {
                    if (Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_AUTO))) {
                        node.addError("The singular must be specified explicitly (e.g. @Singular(\"task\")) because auto singularization is disabled.");
                        explicitSingular = new String(pluralName);
                    } else {
                        explicitSingular = HandlerUtil.autoSingularize(new String(pluralName));
                        if (explicitSingular == null) {
                            node.addError("Can't singularize this name; please specify the singular explicitly (i.e. @Singular(\"sheep\"))");
                            explicitSingular = new String(pluralName);
                        }
                    }
                }
                char[] singularName = explicitSingular.toCharArray();
                ParameterizedSingleTypeReference parameterizedSingleTypeReference = node.get().type;
                if (parameterizedSingleTypeReference instanceof ParameterizedSingleTypeReference) {
                    typeArgs = parameterizedSingleTypeReference.typeArguments;
                    typeName = new String(parameterizedSingleTypeReference.token);
                } else if (parameterizedSingleTypeReference instanceof ParameterizedQualifiedTypeReference) {
                    TypeReference[][] tr = ((ParameterizedQualifiedTypeReference) parameterizedSingleTypeReference).typeArguments;
                    typeArgs = tr != null ? tr[tr.length - 1] : null;
                    char[][] tokens = ((ParameterizedQualifiedTypeReference) parameterizedSingleTypeReference).tokens;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tokens.length; i++) {
                        if (i > 0) {
                            sb.append(".");
                        }
                        sb.append(tokens[i]);
                    }
                    typeName = sb.toString();
                } else {
                    typeName = parameterizedSingleTypeReference.toString();
                }
                String targetFqn = EclipseSingularsRecipes.get().toQualified(typeName);
                EclipseSingularsRecipes.EclipseSingularizer singularizer = EclipseSingularsRecipes.get().getSingularizer(targetFqn);
                if (singularizer == null) {
                    node.addError("Lombok does not know how to create the singular-form builder methods for type '" + typeName + "'; they won't be generated.");
                    return null;
                }
                return new EclipseSingularsRecipes.SingularData(child, singularName, pluralName, typeArgs == null ? Collections.emptyList() : Arrays.asList(typeArgs), targetFqn, singularizer, source, singularInstance.ignoreNullCollections(), setterPrefix.toCharArray());
            }
        }
        return null;
    }
}
