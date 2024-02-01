package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.Singular;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.EclipseSingularsRecipes;
import lombok.eclipse.handlers.HandleBuilder;
import lombok.experimental.SuperBuilder;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
@HandlerPriority(-1024)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleSuperBuilder.SCL.lombok */
public class HandleSuperBuilder extends EclipseAnnotationHandler<SuperBuilder> {
    private static final char[] SELF_METHOD_NAME = "self".toCharArray();
    private static final char[] FILL_VALUES_METHOD_NAME = "$fillValuesFrom".toCharArray();
    private static final char[] FILL_VALUES_STATIC_METHOD_NAME = "$fillValuesFromInstanceIntoBuilder".toCharArray();
    private static final char[] INSTANCE_VARIABLE_NAME = "instance".toCharArray();
    private static final String BUILDER_VARIABLE_NAME_STRING = "b";
    private static final char[] BUILDER_VARIABLE_NAME = BUILDER_VARIABLE_NAME_STRING.toCharArray();
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/handlers/HandleSuperBuilder$SuperBuilderJob.SCL.lombok */
    public class SuperBuilderJob extends HandleBuilder.BuilderJob {
        EclipseNode builderAbstractType;
        String builderAbstractClassName;
        char[] builderAbstractClassNameArr;
        EclipseNode builderImplType;
        String builderImplClassName;
        char[] builderImplClassNameArr;
        private TypeParameter[] builderTypeParams_;

        SuperBuilderJob() {
        }

        void init(AnnotationValues<SuperBuilder> annValues, SuperBuilder ann, EclipseNode node) {
            AccessLevel accessLevel = AccessLevel.PUBLIC;
            this.accessInners = accessLevel;
            this.accessOuters = accessLevel;
            this.oldFluent = true;
            this.oldChain = true;
            this.builderMethodName = ann.builderMethodName();
            this.buildMethodName = ann.buildMethodName();
            this.toBuilder = ann.toBuilder();
            if (this.builderMethodName == null) {
                this.builderMethodName = "builder";
            }
            if (this.buildMethodName == null) {
                this.buildMethodName = "build";
            }
            this.builderClassName = fixBuilderClassName(node, "");
        }

        void setBuilderToImpl() {
            this.builderType = this.builderImplType;
            this.builderClassName = this.builderImplClassName;
            this.builderClassNameArr = this.builderImplClassNameArr;
            this.builderTypeParams = this.typeParams;
        }

        void setBuilderToAbstract() {
            this.builderType = this.builderAbstractType;
            this.builderClassName = this.builderAbstractClassName;
            this.builderClassNameArr = this.builderAbstractClassNameArr;
            this.builderTypeParams = this.builderTypeParams_;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0634, code lost:
        r0.setBuilderToAbstract();
        generateBuilderFields(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0641, code lost:
        if (r18 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0644, code lost:
        r0 = new org.eclipse.jdt.internal.compiler.ast.FieldDeclaration(lombok.eclipse.handlers.HandleBuilder.CLEAN_FIELD_NAME, 0, -1);
        r0.declarationSourceEnd = -1;
        r0.modifiers = 2;
        r0.type = org.eclipse.jdt.internal.compiler.ast.TypeReference.baseTypeReference(5, 0);
        lombok.eclipse.handlers.EclipseHandlerUtil.injectFieldAndMarkGenerated(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0678, code lost:
        if (r0.toBuilder == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x067b, code lost:
        r0 = r0.builderType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0685, code lost:
        if (r28 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0688, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x068c, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x068d, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0, generateFillValuesMethod(r0, r3, r0, r0));
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, generateStaticFillValuesMethod(r0, r0.setterPrefix()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x06ae, code lost:
        r0 = r0.builderType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x06b8, code lost:
        if (r28 == null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x06bb, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x06bf, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x06c0, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0, generateAbstractSelfMethod(r0, r3, r0));
        r0.setBuilderToAbstract();
        r0 = r0.builderType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x06d8, code lost:
        if (r28 == null) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x06db, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x06df, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x06e0, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0, generateAbstractBuildMethod(r0, r3, r0));
        r0 = r0.builderFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x06f8, code lost:
        generateSetterMethodsForBuilder(r0, r0.next(), r0, r0.setterPrefix());
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x071c, code lost:
        if (r0.hasNext() != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x072e, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.methodExists("toString", r0.builderType, 0) != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0731, code lost:
        r0 = new java.util.ArrayList<>();
        r0 = r0.builderFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0749, code lost:
        r0 = r0.next().createdFields.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0764, code lost:
        r0 = r0.next();
        r0.add(new lombok.core.handlers.InclusionExclusionUtils.Included<>(r0, null, true, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x078b, code lost:
        if (r0.hasNext() != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0795, code lost:
        if (r0.hasNext() != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0798, code lost:
        r0 = r0.builderType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x07a2, code lost:
        if (r28 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x07a5, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x07a9, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x07aa, code lost:
        r0 = lombok.eclipse.handlers.HandleToString.createToString(r0, r0, true, r3, r11, lombok.core.handlers.HandlerUtil.FieldAccess.ALWAYS_FIELD);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x07b5, code lost:
        if (r0 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x07b8, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x07c5, code lost:
        if (r18 == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x07c8, code lost:
        r0.setBuilderToAbstract();
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderType, generateCleanMethod(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x07e5, code lost:
        if ((r0.modifiers & 1024) == 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x07e8, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x07ec, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x07ed, code lost:
        r30 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x07f1, code lost:
        if (r30 == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x07f4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x07f5, code lost:
        r0.builderImplType = findInnerClass(r0, r0.builderImplClassName);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x080a, code lost:
        if (r0.builderImplType != null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x080d, code lost:
        r0.builderImplType = generateBuilderImplClass(r0, r0.builderImplClassName);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0820, code lost:
        r0 = r0.builderImplType.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0836, code lost:
        if ((r0.modifiers & 1024) != 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0841, code lost:
        if ((r0.modifiers & 8) != 0) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0844, code lost:
        r12.addError("Existing BuilderImpl must be a non-abstract static inner class.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x084b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x084c, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(r0.builderImplType, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0855, code lost:
        r0.setBuilderToImpl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x085f, code lost:
        if (r0.toBuilder == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0875, code lost:
        switch($SWITCH_TABLE$lombok$eclipse$handlers$EclipseHandlerUtil$MemberExistsResult()[lombok.eclipse.handlers.EclipseHandlerUtil.methodExists("toBuilder", r0.parentType, 0).ordinal()]) {
            case 1: goto L143;
            case 2: goto L144;
            case 3: goto L144;
            default: goto L144;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0893, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0, generateToBuilderMethod(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x089f, code lost:
        r0.setBuilderToImpl();
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderImplType, generateSelfMethod(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x08c4, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(r0.buildMethodName, r0.builderImplType, -1) != lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x08c7, code lost:
        r0.setBuilderToImpl();
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0.builderImplType, generateBuildMethod(r0, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x08df, code lost:
        if (r15 == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x08f0, code lost:
        if (lombok.eclipse.handlers.EclipseHandlerUtil.methodExists(r0.builderMethodName, r0, -1) == lombok.eclipse.handlers.EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x08f3, code lost:
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x08f8, code lost:
        if (r15 == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x08fb, code lost:
        r0 = generateBuilderMethod(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0905, code lost:
        if (r0 == null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0908, code lost:
        lombok.eclipse.handlers.EclipseHandlerUtil.injectMethod(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0912, code lost:
        if (r19 == null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0917, code lost:
        if (r15 == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x091a, code lost:
        r0 = r19.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0926, code lost:
        r0.next().addWarning("@SuperBuilder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0941, code lost:
        if (r0.hasNext() != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0944, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:?, code lost:
        return;
     */
    /* JADX WARN: Type inference failed for: r0v319, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    /* JADX WARN: Type inference failed for: r0v84, types: [char[], char[][]] */
    /* JADX WARN: Type inference failed for: r0v93, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    /* JADX WARN: Type inference failed for: r2v77, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    @Override // lombok.eclipse.EclipseAnnotationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handle(lombok.core.AnnotationValues<lombok.experimental.SuperBuilder> r10, org.eclipse.jdt.internal.compiler.ast.Annotation r11, lombok.eclipse.EclipseNode r12) {
        /*
            Method dump skipped, instructions count: 2373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.eclipse.handlers.HandleSuperBuilder.handle(lombok.core.AnnotationValues, org.eclipse.jdt.internal.compiler.ast.Annotation, lombok.eclipse.EclipseNode):void");
    }

    private EclipseNode generateBuilderAbstractClass(HandleBuilder.BuilderJob job, TypeReference superclassBuilderClass, String classGenericName, String builderGenericName) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= 1033;
        builder.name = job.builderClassNameArr;
        builder.typeParameters = (TypeParameter[]) Arrays.copyOf(EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source), job.typeParams.length + 2);
        TypeParameter o = new TypeParameter();
        o.name = classGenericName.toCharArray();
        o.type = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
        builder.typeParameters[builder.typeParameters.length - 2] = o;
        TypeParameter o2 = new TypeParameter();
        o2.name = builderGenericName.toCharArray();
        TypeReference[] typerefs = appendBuilderTypeReferences(job.typeParams, classGenericName, builderGenericName);
        o2.type = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, typerefs, 0L);
        builder.typeParameters[builder.typeParameters.length - 1] = o2;
        if (superclassBuilderClass != null) {
            builder.superclass = EclipseHandlerUtil.copyType(superclassBuilderClass, job.source);
        }
        builder.createDefaultConstructor(false, true);
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    private EclipseNode generateBuilderImplClass(HandleBuilder.BuilderJob job, String builderImplClass) {
        TypeDeclaration parent = job.parentType.get();
        TypeDeclaration builder = new TypeDeclaration(parent.compilationResult);
        builder.bits |= 8388608;
        builder.modifiers |= 26;
        builder.name = builderImplClass.toCharArray();
        if (job.typeParams != null && job.typeParams.length > 0) {
            builder.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        if (job.builderClassName != null) {
            TypeReference[] typeArgs = new TypeReference[job.typeParams.length + 2];
            for (int i = 0; i < job.typeParams.length; i++) {
                typeArgs[i] = new SingleTypeReference(job.typeParams[i].name, 0L);
            }
            typeArgs[typeArgs.length - 2] = EclipseHandlerUtil.cloneSelfType(job.parentType, job.source);
            typeArgs[typeArgs.length - 1] = createTypeReferenceWithTypeParameters(job.parentType, builderImplClass, job.typeParams);
            builder.superclass = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, typeArgs, 0L);
        }
        builder.createDefaultConstructor(false, true);
        builder.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return EclipseHandlerUtil.injectType(job.parentType, builder);
    }

    /* JADX WARN: Type inference failed for: r0v50, types: [char[], char[][]] */
    /* JADX WARN: Type inference failed for: r0v71, types: [char[], char[][]] */
    private void generateBuilderBasedConstructor(HandleBuilder.BuilderJob job, boolean callBuilderBasedSuperConstructor) {
        QualifiedNameReference qualifiedNameReference;
        Statement nullCheck;
        TypeDeclaration typeDeclaration = job.parentType.get();
        long p = job.getPos();
        ConstructorDeclaration constructor = new ConstructorDeclaration(job.parentType.top().get().compilationResult);
        constructor.modifiers = EclipseHandlerUtil.toEclipseModifier(AccessLevel.PROTECTED);
        constructor.selector = typeDeclaration.name;
        if (callBuilderBasedSuperConstructor) {
            constructor.constructorCall = new ExplicitConstructorCall(2);
            constructor.constructorCall.arguments = new Expression[]{new SingleNameReference(BUILDER_VARIABLE_NAME, p)};
        } else {
            constructor.constructorCall = new ExplicitConstructorCall(1);
        }
        constructor.constructorCall.sourceStart = job.source.sourceStart;
        constructor.constructorCall.sourceEnd = job.source.sourceEnd;
        constructor.thrownExceptions = null;
        constructor.typeParameters = null;
        constructor.bits |= 8388608;
        int i = job.source.sourceStart;
        constructor.sourceStart = i;
        constructor.declarationSourceStart = i;
        constructor.bodyStart = i;
        int i2 = job.source.sourceEnd;
        constructor.sourceEnd = i2;
        constructor.declarationSourceEnd = i2;
        constructor.bodyEnd = i2;
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        TypeReference builderType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        constructor.arguments = new Argument[]{new Argument(BUILDER_VARIABLE_NAME, p, builderType, 16)};
        List<Statement> statements = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData fieldNode : job.builderFields) {
            FieldReference fieldInThis = new FieldReference(fieldNode.rawName, p);
            int s = (int) (p >> 32);
            int e = (int) p;
            fieldInThis.receiver = new ThisReference(s, e);
            if (fieldNode.singularData != null && fieldNode.singularData.getSingularizer() != null) {
                fieldNode.singularData.getSingularizer().appendBuildCode(fieldNode.singularData, job.parentType, statements, fieldNode.builderFieldName, BUILDER_VARIABLE_NAME_STRING);
                qualifiedNameReference = new SingleNameReference(fieldNode.builderFieldName, p);
            } else {
                ?? r0 = {BUILDER_VARIABLE_NAME, fieldNode.builderFieldName};
                long[] positions = {p, p};
                qualifiedNameReference = new QualifiedNameReference((char[][]) r0, positions, s, e);
            }
            Assignment assignment = new Assignment(fieldInThis, qualifiedNameReference, (int) p);
            if (fieldNode.nameOfSetFlag != null) {
                ?? r02 = {BUILDER_VARIABLE_NAME, fieldNode.nameOfSetFlag};
                long[] positions2 = {p, p};
                QualifiedNameReference setVariableInBuilderRef = new QualifiedNameReference((char[][]) r02, positions2, s, e);
                MessageSend defaultMethodCall = new MessageSend();
                defaultMethodCall.sourceStart = job.source.sourceStart;
                defaultMethodCall.sourceEnd = job.source.sourceEnd;
                defaultMethodCall.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, 0L);
                defaultMethodCall.selector = fieldNode.nameOfDefaultProvider;
                defaultMethodCall.typeArguments = typeParameterNames(job.parentType.get().typeParameters);
                IfStatement ifBlockForDefault = new IfStatement(setVariableInBuilderRef, assignment, new Assignment(fieldInThis, defaultMethodCall, (int) p), s, e);
                statements.add(ifBlockForDefault);
            } else {
                statements.add(assignment);
            }
            if (EclipseHandlerUtil.hasNonNullAnnotations(fieldNode.originalFieldNode) && (nullCheck = EclipseHandlerUtil.generateNullCheck(fieldNode.originalFieldNode.get(), job.sourceNode, null)) != null) {
                statements.add(nullCheck);
            }
        }
        constructor.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        constructor.traverse(new SetGeneratedByVisitor(job.source), typeDeclaration.scope);
        EclipseHandlerUtil.injectMethod(job.parentType, constructor);
    }

    /* JADX WARN: Type inference failed for: r1v24, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private MethodDeclaration generateBuilderMethod(SuperBuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = (pS << 32) | pE;
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = job.builderMethodName.toCharArray();
        out.modifiers = 9;
        out.bits |= 8388608;
        if (job.typeParams != null && job.typeParams.length > 0) {
            out.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        out.returnType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderAbstractClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len];
            Annotation[] annotationArr = new Annotation[1];
            annotationArr[0] = EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE);
            out.returnType.annotations[len - 1] = annotationArr;
        }
        AllocationExpression invoke = new AllocationExpression();
        invoke.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.parentType, job.builderImplClassNameArr, false, job.typeParams, p);
        out.statements = new Statement[]{new ReturnStatement(invoke, pS, pE)};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    /* JADX WARN: Type inference failed for: r1v27, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private MethodDeclaration generateToBuilderMethod(SuperBuilderJob job) {
        int pS = job.source.sourceStart;
        int pE = job.source.sourceEnd;
        long p = (pS << 32) | pE;
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = HandleBuilder.TO_BUILDER_METHOD_NAME;
        out.modifiers = 1;
        out.bits |= 8388608;
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        out.returnType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderAbstractClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), p);
        if (job.checkerFramework.generateUnique()) {
            int len = out.returnType.getTypeName().length;
            out.returnType.annotations = new Annotation[len];
            Annotation[] annotationArr = new Annotation[1];
            annotationArr[0] = EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__UNIQUE);
            out.returnType.annotations[len - 1] = annotationArr;
        }
        AllocationExpression newClass = new AllocationExpression();
        newClass.type = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.parentType, job.builderImplClassNameArr, false, job.typeParams, p);
        MessageSend invokeFillMethod = new MessageSend();
        invokeFillMethod.receiver = newClass;
        invokeFillMethod.selector = FILL_VALUES_METHOD_NAME;
        invokeFillMethod.arguments = new Expression[]{new ThisReference(0, 0)};
        out.statements = new Statement[]{new ReturnStatement(invokeFillMethod, pS, pE)};
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.parentType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), job.parentType.get().scope);
        return out;
    }

    private MethodDeclaration generateFillValuesMethod(SuperBuilderJob job, boolean inherited, String builderGenericName, String classGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = FILL_VALUES_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 4;
        if (inherited) {
            out.annotations = new Annotation[]{EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.parentType.get())};
        }
        out.returnType = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        out.arguments = new Argument[]{new Argument(INSTANCE_VARIABLE_NAME, 0L, new SingleTypeReference(classGenericName.toCharArray(), 0L), 16)};
        List<Statement> body = new ArrayList<>();
        if (inherited) {
            MessageSend callToSuper = new MessageSend();
            callToSuper.receiver = new SuperReference(0, 0);
            callToSuper.selector = FILL_VALUES_METHOD_NAME;
            callToSuper.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L)};
            body.add(callToSuper);
        }
        MessageSend callStaticFillValuesMethod = new MessageSend();
        callStaticFillValuesMethod.receiver = EclipseHandlerUtil.generateNameReference(job.parentType, job.builderAbstractClassNameArr, 0L);
        callStaticFillValuesMethod.selector = FILL_VALUES_STATIC_METHOD_NAME;
        callStaticFillValuesMethod.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L), new ThisReference(0, 0)};
        body.add(callStaticFillValuesMethod);
        MessageSend returnCall = new MessageSend();
        returnCall.receiver = ThisReference.implicitThis();
        returnCall.selector = SELF_METHOD_NAME;
        body.add(new ReturnStatement(returnCall, 0, 0));
        out.statements = body.isEmpty() ? null : (Statement[]) body.toArray(new Statement[0]);
        return out;
    }

    private MethodDeclaration generateStaticFillValuesMethod(HandleBuilder.BuilderJob job, String setterPrefix) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = FILL_VALUES_STATIC_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 10;
        out.returnType = TypeReference.baseTypeReference(6, 0);
        TypeReference[] wildcards = {new Wildcard(0), new Wildcard(0)};
        TypeReference builderType = EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, job.builderClassNameArr, false, mergeToTypeReferences(job.typeParams, wildcards), 0L);
        Argument builderArgument = new Argument(BUILDER_VARIABLE_NAME, 0L, builderType, 16);
        TypeReference[] typerefs = null;
        if (job.typeParams.length > 0) {
            typerefs = new TypeReference[job.typeParams.length];
            for (int i = 0; i < job.typeParams.length; i++) {
                typerefs[i] = new SingleTypeReference(job.typeParams[i].name, 0L);
            }
        }
        long p = job.getPos();
        TypeReference parentArgument = typerefs == null ? EclipseHandlerUtil.generateTypeReference(job.parentType, p) : EclipseHandlerUtil.generateParameterizedTypeReference(job.parentType, typerefs, p);
        out.arguments = new Argument[]{new Argument(INSTANCE_VARIABLE_NAME, 0L, parentArgument, 16), builderArgument};
        if (job.typeParams.length > 0) {
            out.typeParameters = EclipseHandlerUtil.copyTypeParams(job.typeParams, job.source);
        }
        List<Statement> body = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
            MessageSend exec = createSetterCallWithInstanceValue(bfd, job.parentType, job.source, setterPrefix);
            body.add(exec);
        }
        out.statements = body.isEmpty() ? null : (Statement[]) body.toArray(new Statement[0]);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MessageSend createSetterCallWithInstanceValue(HandleBuilder.BuilderFieldData bfd, EclipseNode type, ASTNode source, String setterPrefix) {
        char[] setterName = HandlerUtil.buildAccessorName(setterPrefix, String.valueOf(bfd.name)).toCharArray();
        MessageSend ms = new MessageSend();
        Expression[] tgt = new Expression[bfd.singularData == null ? 1 : 2];
        if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
            char[] fieldName = bfd.obtainVia == null ? bfd.rawName : bfd.obtainVia.field().toCharArray();
            for (int i = 0; i < tgt.length; i++) {
                FieldReference fr = new FieldReference(fieldName, 0L);
                fr.receiver = new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L);
                tgt[i] = fr;
            }
        } else {
            String obtainName = bfd.obtainVia.method();
            boolean obtainIsStatic = bfd.obtainVia.isStatic();
            for (int i2 = 0; i2 < tgt.length; i2++) {
                MessageSend obtainExpr = new MessageSend();
                obtainExpr.receiver = obtainIsStatic ? EclipseHandlerUtil.generateNameReference(type, 0L) : new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L);
                obtainExpr.selector = obtainName.toCharArray();
                if (obtainIsStatic) {
                    obtainExpr.arguments = new Expression[]{new SingleNameReference(INSTANCE_VARIABLE_NAME, 0L)};
                }
                tgt[i2] = obtainExpr;
            }
        }
        if (bfd.singularData == null) {
            ms.arguments = tgt;
        } else {
            EqualExpression equalExpression = new EqualExpression(tgt[0], new NullLiteral(0, 0), 18);
            MessageSend emptyCollection = new MessageSend();
            emptyCollection.receiver = EclipseHandlerUtil.generateQualifiedNameRef(source, bfd.singularData.getSingularizer().getEmptyMakerReceiver(bfd.singularData.getTargetFqn()));
            emptyCollection.selector = bfd.singularData.getSingularizer().getEmptyMakerSelector(bfd.singularData.getTargetFqn());
            ms.arguments = new Expression[]{new ConditionalExpression(equalExpression, emptyCollection, tgt[1])};
        }
        ms.receiver = new SingleNameReference(BUILDER_VARIABLE_NAME, 0L);
        ms.selector = setterName;
        return ms;
    }

    private MethodDeclaration generateAbstractSelfMethod(HandleBuilder.BuilderJob job, boolean override, String builderGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = SELF_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 16778244;
        MarkerAnnotation makeMarkerAnnotation = override ? EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.parentType.get()) : null;
        MarkerAnnotation generateNamedAnnotation = job.checkerFramework.generateReturnsReceiver() ? EclipseHandlerUtil.generateNamedAnnotation(job.parentType.get(), CheckerFrameworkVersion.NAME__RETURNS_RECEIVER) : null;
        MarkerAnnotation generateNamedAnnotation2 = job.checkerFramework.generatePure() ? EclipseHandlerUtil.generateNamedAnnotation(job.parentType.get(), CheckerFrameworkVersion.NAME__PURE) : null;
        if (makeMarkerAnnotation != null && generateNamedAnnotation != null && generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation, generateNamedAnnotation, generateNamedAnnotation2};
        } else if (makeMarkerAnnotation != null && generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation, generateNamedAnnotation};
        } else if (makeMarkerAnnotation != null && generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation, generateNamedAnnotation2};
        } else if (makeMarkerAnnotation != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation};
        } else if (generateNamedAnnotation != null && generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{generateNamedAnnotation, generateNamedAnnotation2};
        } else if (generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{generateNamedAnnotation};
        } else if (generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{generateNamedAnnotation2};
        }
        out.returnType = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        return out;
    }

    private MethodDeclaration generateSelfMethod(HandleBuilder.BuilderJob job) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.selector = SELF_METHOD_NAME;
        out.bits |= 8388608;
        out.modifiers = 4;
        Annotation overrideAnn = EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.builderType.get());
        MarkerAnnotation generateNamedAnnotation = job.checkerFramework.generateReturnsReceiver() ? EclipseHandlerUtil.generateNamedAnnotation(job.builderType.get(), CheckerFrameworkVersion.NAME__RETURNS_RECEIVER) : null;
        MarkerAnnotation generateNamedAnnotation2 = job.checkerFramework.generatePure() ? EclipseHandlerUtil.generateNamedAnnotation(job.builderType.get(), CheckerFrameworkVersion.NAME__PURE) : null;
        if (generateNamedAnnotation != null && generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{overrideAnn, generateNamedAnnotation, generateNamedAnnotation2};
        } else if (generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{overrideAnn, generateNamedAnnotation};
        } else if (generateNamedAnnotation2 != null) {
            out.annotations = new Annotation[]{overrideAnn, generateNamedAnnotation2};
        } else {
            out.annotations = new Annotation[]{overrideAnn};
        }
        out.returnType = EclipseHandlerUtil.namePlusTypeParamsToTypeReference(job.builderType, job.typeParams, job.getPos());
        out.statements = new Statement[]{new ReturnStatement(new ThisReference(0, 0), 0, 0)};
        return out;
    }

    private MethodDeclaration generateAbstractBuildMethod(HandleBuilder.BuilderJob job, boolean override, String classGenericName) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        out.modifiers = 16778241;
        out.selector = job.buildMethodName.toCharArray();
        out.bits |= 8388608;
        out.returnType = new SingleTypeReference(classGenericName.toCharArray(), 0L);
        MarkerAnnotation makeMarkerAnnotation = override ? EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.source) : null;
        MarkerAnnotation generateNamedAnnotation = job.checkerFramework.generateSideEffectFree() ? EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE) : null;
        if (makeMarkerAnnotation != null && generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation, generateNamedAnnotation};
        } else if (makeMarkerAnnotation != null) {
            out.annotations = new Annotation[]{makeMarkerAnnotation};
        } else if (generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{generateNamedAnnotation};
        }
        out.receiver = HandleBuilder.generateBuildReceiver(job);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MethodDeclaration generateBuildMethod(HandleBuilder.BuilderJob job, TypeReference returnType) {
        MethodDeclaration out = job.createNewMethodDeclaration();
        out.bits |= 8388608;
        List<Statement> statements = new ArrayList<>();
        out.modifiers = 1;
        out.selector = job.buildMethodName.toCharArray();
        out.bits |= 8388608;
        out.returnType = returnType;
        Annotation overrideAnn = EclipseHandlerUtil.makeMarkerAnnotation(TypeConstants.JAVA_LANG_OVERRIDE, job.source);
        MarkerAnnotation generateNamedAnnotation = job.checkerFramework.generateSideEffectFree() ? EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE) : null;
        if (generateNamedAnnotation != null) {
            out.annotations = new Annotation[]{overrideAnn, generateNamedAnnotation};
        } else {
            out.annotations = new Annotation[]{overrideAnn};
        }
        AllocationExpression allocationStatement = new AllocationExpression();
        allocationStatement.type = EclipseHandlerUtil.copyType(out.returnType);
        allocationStatement.arguments = new Expression[]{new ThisReference(0, 0)};
        statements.add(new ReturnStatement(allocationStatement, 0, 0));
        out.statements = statements.isEmpty() ? null : (Statement[]) statements.toArray(new Statement[0]);
        out.receiver = HandleBuilder.generateBuildReceiver(job);
        EclipseHandlerUtil.createRelevantNonNullAnnotation(job.builderType, out);
        out.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return out;
    }

    private MethodDeclaration generateCleanMethod(HandleBuilder.BuilderJob job) {
        List<Statement> statements = new ArrayList<>();
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, job.builderType, statements);
            }
        }
        FieldReference thisUnclean = new FieldReference(HandleBuilder.CLEAN_FIELD_NAME, 0L);
        thisUnclean.receiver = new ThisReference(0, 0);
        statements.add(new Assignment(thisUnclean, new FalseLiteral(0, 0), 0));
        MethodDeclaration decl = job.createNewMethodDeclaration();
        decl.selector = HandleBuilder.CLEAN_METHOD_NAME;
        decl.modifiers = 2;
        decl.bits |= 8388608;
        decl.returnType = TypeReference.baseTypeReference(6, 0);
        decl.statements = (Statement[]) statements.toArray(new Statement[0]);
        decl.traverse(new SetGeneratedByVisitor(job.source), (ClassScope) null);
        return decl;
    }

    private void generateBuilderFields(HandleBuilder.BuilderJob job) {
        List<EclipseNode> existing = new ArrayList<>();
        Iterator<EclipseNode> it = job.builderType.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.FIELD) {
                existing.add(child);
            }
        }
        for (HandleBuilder.BuilderFieldData bfd : job.builderFields) {
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

    private void generateSetterMethodsForBuilder(HandleBuilder.BuilderJob job, HandleBuilder.BuilderFieldData bfd, final String builderGenericName, String setterPrefix) {
        boolean deprecate = EclipseHandlerUtil.isFieldDeprecated(bfd.originalFieldNode);
        EclipseSingularsRecipes.TypeReferenceMaker returnTypeMaker = new EclipseSingularsRecipes.TypeReferenceMaker() { // from class: lombok.eclipse.handlers.HandleSuperBuilder.1
            @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.TypeReferenceMaker
            public TypeReference make() {
                return new SingleTypeReference(builderGenericName.toCharArray(), 0L);
            }
        };
        EclipseSingularsRecipes.StatementMaker returnStatementMaker = new EclipseSingularsRecipes.StatementMaker() { // from class: lombok.eclipse.handlers.HandleSuperBuilder.2
            @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.StatementMaker
            /* renamed from: make */
            public ReturnStatement mo191make() {
                MessageSend returnCall = new MessageSend();
                returnCall.receiver = ThisReference.implicitThis();
                returnCall.selector = HandleSuperBuilder.SELF_METHOD_NAME;
                return new ReturnStatement(returnCall, 0, 0);
            }
        };
        if (bfd.singularData == null || bfd.singularData.getSingularizer() == null) {
            generateSimpleSetterMethodForBuilder(job, deprecate, bfd.createdFields.get(0), bfd.name, bfd.nameOfSetFlag, returnTypeMaker.make(), returnStatementMaker.mo191make(), bfd.annotations, bfd.originalFieldNode, setterPrefix);
        } else {
            bfd.singularData.getSingularizer().generateMethods(job.checkerFramework, bfd.singularData, deprecate, job.builderType, true, returnTypeMaker, returnStatementMaker, AccessLevel.PUBLIC);
        }
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private void generateSimpleSetterMethodForBuilder(HandleBuilder.BuilderJob job, boolean deprecate, EclipseNode fieldNode, char[] paramName, char[] nameOfSetFlag, TypeReference returnType, Statement returnStatement, Annotation[] annosOnParam, EclipseNode originalFieldNode, String setterPrefix) {
        TypeDeclaration td = job.builderType.get();
        AbstractMethodDeclaration[] existing = td.methods;
        if (existing == null) {
            existing = HandleBuilder.EMPTY_METHODS;
        }
        int len = existing.length;
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, new String(paramName));
        for (int i = 0; i < len; i++) {
            if (existing[i] instanceof MethodDeclaration) {
                char[] existingName = existing[i].selector;
                if (Arrays.equals(setterName.toCharArray(), existingName) && !EclipseHandlerUtil.isTolerate(fieldNode, existing[i])) {
                    return;
                }
            }
        }
        List<Annotation> methodAnnsList = Arrays.asList(EclipseHandlerUtil.findCopyableToSetterAnnotations(originalFieldNode));
        List<Annotation> methodAnnsList2 = methodAnnsList;
        if (job.checkerFramework.generateReturnsReceiver()) {
            List<Annotation> methodAnnsList3 = new ArrayList<>(methodAnnsList);
            methodAnnsList3.add(EclipseHandlerUtil.generateNamedAnnotation(job.source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER));
            methodAnnsList2 = methodAnnsList3;
        }
        MethodDeclaration setter = HandleSetter.createSetter(td, deprecate, fieldNode, setterName, paramName, nameOfSetFlag, returnType, returnStatement, 1, job.sourceNode, methodAnnsList2, annosOnParam != null ? Arrays.asList(EclipseHandlerUtil.copyAnnotations(job.source, new Annotation[]{annosOnParam})) : Collections.emptyList());
        if (job.checkerFramework.generateCalledMethods()) {
            setter.receiver = HandleBuilder.generateNotCalledReceiver(job, setterName);
        }
        EclipseHandlerUtil.injectMethod(job.builderType, setter);
    }

    private void addObtainVia(HandleBuilder.BuilderFieldData bfd, EclipseNode node) {
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

    private Set<String> gatherUsedTypeNames(TypeParameter[] typeParams, TypeDeclaration td) {
        FieldDeclaration[] fieldDeclarationArr;
        HashSet<String> usedNames = new HashSet<>();
        for (TypeParameter typeParam : typeParams) {
            usedNames.add(typeParam.toString());
        }
        usedNames.add(String.valueOf(td.name));
        if (td.fields != null) {
            for (FieldDeclaration field : td.fields) {
                char[][] typeName = field.type.getTypeName();
                if (typeName.length >= 1) {
                    usedNames.add(String.valueOf(typeName[0]));
                }
            }
        }
        return usedNames;
    }

    private String generateNonclashingNameFor(String classGenericName, Set<String> typeParamStrings) {
        if (typeParamStrings.contains(classGenericName)) {
            int counter = 2;
            while (typeParamStrings.contains(String.valueOf(classGenericName) + counter)) {
                counter++;
            }
            return String.valueOf(classGenericName) + counter;
        }
        return classGenericName;
    }

    private TypeReference[] appendBuilderTypeReferences(TypeParameter[] typeParams, String classGenericName, String builderGenericName) {
        TypeReference[] typeReferencesToAppend = new TypeReference[2];
        typeReferencesToAppend[typeReferencesToAppend.length - 2] = new SingleTypeReference(classGenericName.toCharArray(), 0L);
        typeReferencesToAppend[typeReferencesToAppend.length - 1] = new SingleTypeReference(builderGenericName.toCharArray(), 0L);
        return mergeToTypeReferences(typeParams, typeReferencesToAppend);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[]] */
    private TypeReference[] getTypeParametersFrom(TypeReference typeRef) {
        TypeReference[][] typeArgss = null;
        if (typeRef instanceof ParameterizedQualifiedTypeReference) {
            typeArgss = ((ParameterizedQualifiedTypeReference) typeRef).typeArguments;
        } else if (typeRef instanceof ParameterizedSingleTypeReference) {
            typeArgss = new TypeReference[]{((ParameterizedSingleTypeReference) typeRef).typeArguments};
        }
        TypeReference[] typeArgs = new TypeReference[0];
        if (typeArgss != null && typeArgss.length > 0) {
            typeArgs = typeArgss[typeArgss.length - 1];
        }
        return typeArgs;
    }

    private static TypeReference createTypeReferenceWithTypeParameters(EclipseNode parent, String referenceName, TypeParameter[] typeParams) {
        if (typeParams.length > 0) {
            TypeReference[] typerefs = new TypeReference[typeParams.length];
            for (int i = 0; i < typeParams.length; i++) {
                typerefs[i] = new SingleTypeReference(typeParams[i].name, 0L);
            }
            return EclipseHandlerUtil.generateParameterizedTypeReference(parent, referenceName.toCharArray(), false, typerefs, 0L);
        }
        return EclipseHandlerUtil.generateTypeReference(parent, referenceName.toCharArray(), false, 0L);
    }

    private TypeReference[] mergeToTypeReferences(TypeParameter[] typeParams, TypeReference[] typeReferencesToAppend) {
        TypeReference[] typerefs = new TypeReference[typeParams.length + typeReferencesToAppend.length];
        for (int i = 0; i < typeParams.length; i++) {
            typerefs[i] = new SingleTypeReference(typeParams[i].name, 0L);
        }
        for (int i2 = 0; i2 < typeReferencesToAppend.length; i2++) {
            typerefs[typeParams.length + i2] = typeReferencesToAppend[i2];
        }
        return typerefs;
    }

    private TypeReference[] mergeTypeReferences(TypeReference[] refs1, TypeReference[] refs2) {
        TypeReference[] result = new TypeReference[refs1.length + refs2.length];
        for (int i = 0; i < refs1.length; i++) {
            result[i] = refs1[i];
        }
        for (int i2 = 0; i2 < refs2.length; i2++) {
            result[refs1.length + i2] = refs2[i2];
        }
        return result;
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

    private EclipseNode findInnerClass(EclipseNode parent, String name) {
        char[] c = name.toCharArray();
        Iterator<EclipseNode> it = parent.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.TYPE) {
                TypeDeclaration td = child.get();
                if (Arrays.equals(td.name, c)) {
                    return child;
                }
            }
        }
        return null;
    }

    private static final char[] prefixWith(char[] prefix, char[] name) {
        char[] out = new char[prefix.length + name.length];
        System.arraycopy(prefix, 0, out, 0, prefix.length);
        System.arraycopy(name, 0, out, prefix.length, name.length);
        return out;
    }

    private boolean constructorExists(EclipseNode type, String builderClassName) {
        AbstractMethodDeclaration[] abstractMethodDeclarationArr;
        if (type != null && (type.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = type.get();
            if (typeDecl.methods != null) {
                for (AbstractMethodDeclaration def : typeDecl.methods) {
                    if ((def instanceof ConstructorDeclaration) && (def.bits & 128) == 0 && def.isConstructor() && !EclipseHandlerUtil.isTolerate(type, def) && def.arguments.length == 1) {
                        char[] typeName = def.arguments[0].type.getLastToken();
                        if (builderClassName.equals(String.valueOf(typeName))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
