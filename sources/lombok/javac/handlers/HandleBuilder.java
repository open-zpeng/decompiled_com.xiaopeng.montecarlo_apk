package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.ConfigurationKeys;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.InclusionExclusionUtils;
import lombok.experimental.NonFinal;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.HandleConstructor;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;
@HandlerPriority(-1024)
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleBuilder.SCL.lombok */
public class HandleBuilder extends JavacAnnotationHandler<Builder> {
    private HandleConstructor handleConstructor = new HandleConstructor();
    static final String CLEAN_FIELD_NAME = "$lombokUnclean";
    static final String CLEAN_METHOD_NAME = "$lombokClean";
    static final String TO_BUILDER_METHOD_NAME = "toBuilder";
    static final String DEFAULT_PREFIX = "$default$";
    static final String SET_PREFIX = "$set";
    static final String VALUE_PREFIX = "$value";
    static final String BUILDER_TEMP_VAR = "builder";
    static final String TO_BUILDER_NOT_SUPPORTED = "@Builder(toBuilder=true) is only supported if you return your own type.";
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleBuilder$BuilderFieldData.SCL.lombok */
    public static class BuilderFieldData {
        List<JCTree.JCAnnotation> annotations;
        JCTree.JCExpression type;
        Name rawName;
        Name name;
        Name builderFieldName;
        Name nameOfDefaultProvider;
        Name nameOfSetFlag;
        JavacSingularsRecipes.SingularData singularData;
        Builder.ObtainVia obtainVia;
        JavacNode obtainViaNode;
        JavacNode originalFieldNode;
        java.util.List<JavacNode> createdFields = new ArrayList();
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult() {
        int[] iArr = $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[JavacHandlerUtil.MemberExistsResult.valuesCustom().length];
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.EXISTS_BY_USER.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[JavacHandlerUtil.MemberExistsResult.NOT_EXISTS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult = iArr2;
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toBoolean(Object expr, boolean defaultValue) {
        if (expr == null) {
            return defaultValue;
        }
        if (expr instanceof JCTree.JCLiteral) {
            return ((Integer) ((JCTree.JCLiteral) expr).value).intValue() != 0;
        }
        return ((Boolean) expr).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleBuilder$BuilderJob.SCL.lombok */
    public static class BuilderJob {
        CheckerFrameworkVersion checkerFramework;
        JavacNode parentType;
        String builderMethodName;
        String buildMethodName;
        boolean isStatic;
        List<JCTree.JCTypeParameter> typeParams;
        List<JCTree.JCTypeParameter> builderTypeParams;
        JCTree source;
        JavacNode sourceNode;
        java.util.List<BuilderFieldData> builderFields;
        AccessLevel accessInners;
        AccessLevel accessOuters;
        boolean oldFluent;
        boolean oldChain;
        boolean toBuilder;
        JavacNode builderType;
        String builderClassName;

        void init(AnnotationValues<Builder> annValues, Builder ann, JavacNode node) {
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
            this.builderClassName = fixBuilderClassName(node, ann.builderClassName());
            this.toBuilder = ann.toBuilder();
            if (this.builderMethodName == null) {
                this.builderMethodName = HandleBuilder.BUILDER_TEMP_VAR;
            }
            if (this.buildMethodName == null) {
                this.buildMethodName = "build";
            }
            if (this.builderClassName == null) {
                this.builderClassName = "";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String fixBuilderClassName(JavacNode node, String override) {
            if (override == null || override.isEmpty()) {
                String override2 = (String) node.getAst().readConfiguration(ConfigurationKeys.BUILDER_CLASS_NAME);
                return (override2 == null || override2.isEmpty()) ? "*Builder" : override2;
            }
            return override;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String replaceBuilderClassName(Name name) {
            return this.builderClassName.indexOf(42) == -1 ? this.builderClassName : this.builderClassName.replace("*", name.toString());
        }

        JCTree.JCExpression createBuilderParentTypeReference() {
            return JavacHandlerUtil.namePlusTypeParamsToTypeReference(this.parentType.getTreeMaker(), this.parentType, this.typeParams);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Name getBuilderClassName() {
            return this.parentType.toName(this.builderClassName);
        }

        List<JCTree.JCTypeParameter> copyTypeParams() {
            return JavacHandlerUtil.copyTypeParams(this.sourceNode, this.typeParams);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Name toName(String name) {
            return this.parentType.toName(name);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context getContext() {
            return this.parentType.getContext();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public JavacTreeMaker getTreeMaker() {
            return this.parentType.getTreeMaker();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Builder> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        boolean generateBuilderMethod;
        JCTree.JCExpression buildMethodReturnType;
        List<JCTree.JCExpression> buildMethodThrownExceptions;
        Name nameOfBuilderMethod;
        Name simpleName;
        String pkg;
        JavacSingularsRecipes.JavacSingularizer singularizer;
        JCTree.JCMethodDecl md;
        JCTree.JCMethodDecl cd;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.BUILDER_FLAG_USAGE, "@Builder");
        BuilderJob job = new BuilderJob();
        job.sourceNode = annotationNode;
        job.source = ast;
        job.checkerFramework = JavacHandlerUtil.getCheckerFrameworkVersion(annotationNode);
        job.isStatic = true;
        Builder annInstance = annotation.getInstance();
        job.init(annotation, annInstance, annotationNode);
        java.util.List<Name> typeArgsForToBuilder = null;
        if (job.builderMethodName.isEmpty()) {
            generateBuilderMethod = false;
        } else if (!HandlerUtil.checkName("builderMethodName", job.builderMethodName, annotationNode)) {
            return;
        } else {
            generateBuilderMethod = true;
        }
        if (HandlerUtil.checkName("buildMethodName", job.buildMethodName, annotationNode)) {
            JavacNode parent = annotationNode.up();
            job.builderFields = new ArrayList();
            job.typeParams = List.nil();
            JavacNode fillParametersFrom = parent.get() instanceof JCTree.JCMethodDecl ? parent : null;
            boolean addCleaning = false;
            ArrayList<JavacNode> nonFinalNonDefaultedFields = null;
            if (parent.get() instanceof JCTree.JCClassDecl) {
                job.parentType = parent;
                JCTree.JCClassDecl td = parent.get();
                ListBuffer<JavacNode> allFields = new ListBuffer<>();
                boolean valuePresent = JavacHandlerUtil.hasAnnotation(Value.class, parent) || JavacHandlerUtil.hasAnnotation("lombok.experimental.Value", parent);
                Iterator it = HandleConstructor.findAllFields(parent, true).iterator();
                while (it.hasNext()) {
                    JavacNode fieldNode = (JavacNode) it.next();
                    JCTree.JCVariableDecl fd = fieldNode.get();
                    JavacNode isDefault = JavacHandlerUtil.findAnnotation(Builder.Default.class, fieldNode, false);
                    boolean isFinal = (fd.mods.flags & 16) != 0 || (valuePresent && !JavacHandlerUtil.hasAnnotation(NonFinal.class, fieldNode));
                    BuilderFieldData bfd = new BuilderFieldData();
                    bfd.rawName = fd.name;
                    bfd.name = JavacHandlerUtil.removePrefixFromField(fieldNode);
                    bfd.builderFieldName = bfd.name;
                    bfd.annotations = JavacHandlerUtil.findCopyableAnnotations(fieldNode);
                    bfd.type = fd.vartype;
                    bfd.singularData = getSingularData(fieldNode, annInstance.setterPrefix());
                    bfd.originalFieldNode = fieldNode;
                    if (bfd.singularData != null && isDefault != null) {
                        isDefault.addError("@Builder.Default and @Singular cannot be mixed.");
                        JavacHandlerUtil.findAnnotation(Builder.Default.class, fieldNode, true);
                        isDefault = null;
                    }
                    if (fd.init == null && isDefault != null) {
                        isDefault.addWarning("@Builder.Default requires an initializing expression (' = something;').");
                        JavacHandlerUtil.findAnnotation(Builder.Default.class, fieldNode, true);
                        isDefault = null;
                    }
                    if (fd.init != null && isDefault == null) {
                        if (!isFinal) {
                            if (nonFinalNonDefaultedFields == null) {
                                nonFinalNonDefaultedFields = new ArrayList<>();
                            }
                            nonFinalNonDefaultedFields.add(fieldNode);
                        }
                    }
                    if (isDefault != null) {
                        bfd.nameOfDefaultProvider = parent.toName(DEFAULT_PREFIX + bfd.name);
                        bfd.nameOfSetFlag = parent.toName(bfd.name + SET_PREFIX);
                        bfd.builderFieldName = parent.toName(bfd.name + VALUE_PREFIX);
                        JCTree.JCMethodDecl md2 = generateDefaultProvider(bfd.nameOfDefaultProvider, fieldNode, td.typarams);
                        JavacHandlerUtil.recursiveSetGeneratedBy(md2, ast, annotationNode.getContext());
                        if (md2 != null) {
                            JavacHandlerUtil.injectMethod(parent, md2);
                        }
                    }
                    addObtainVia(bfd, fieldNode);
                    job.builderFields.add(bfd);
                    allFields.append(fieldNode);
                }
                this.handleConstructor.generateConstructor(parent, AccessLevel.PACKAGE, List.nil(), allFields.toList(), false, null, HandleConstructor.SkipIfConstructorExists.I_AM_BUILDER, annotationNode);
                buildMethodReturnType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(parent.getTreeMaker(), parent, td.typarams);
                List<JCTree.JCTypeParameter> list = td.typarams;
                job.builderTypeParams = list;
                job.typeParams = list;
                buildMethodThrownExceptions = List.nil();
                nameOfBuilderMethod = null;
                job.builderClassName = job.replaceBuilderClassName(td.name);
                if (!HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                    return;
                }
            } else if (fillParametersFrom != null && fillParametersFrom.getName().toString().equals("<init>")) {
                JCTree.JCMethodDecl jmd = fillParametersFrom.get();
                if (!jmd.typarams.isEmpty()) {
                    annotationNode.addError("@Builder is not supported on constructors with constructor type parameters.");
                    return;
                }
                job.parentType = parent.up();
                JCTree.JCClassDecl td2 = job.parentType.get();
                List<JCTree.JCTypeParameter> list2 = td2.typarams;
                job.builderTypeParams = list2;
                job.typeParams = list2;
                buildMethodReturnType = job.createBuilderParentTypeReference();
                buildMethodThrownExceptions = jmd.thrown;
                nameOfBuilderMethod = null;
                job.builderClassName = job.replaceBuilderClassName(td2.name);
                if (!HandlerUtil.checkName("builderClassName", job.builderClassName, annotationNode)) {
                    return;
                }
            } else if (fillParametersFrom != null) {
                job.parentType = parent.up();
                JCTree.JCClassDecl td3 = job.parentType.get();
                JCTree.JCMethodDecl jmd2 = fillParametersFrom.get();
                job.isStatic = (jmd2.mods.flags & 8) != 0;
                JCTree.JCTypeApply jCTypeApply = jmd2.restype;
                buildMethodReturnType = jCTypeApply;
                List<JCTree.JCTypeParameter> list3 = jmd2.typarams;
                job.builderTypeParams = list3;
                job.typeParams = list3;
                buildMethodThrownExceptions = jmd2.thrown;
                nameOfBuilderMethod = jmd2.name;
                if (buildMethodReturnType instanceof JCTree.JCTypeApply) {
                    buildMethodReturnType = JavacHandlerUtil.cloneType(job.getTreeMaker(), buildMethodReturnType, ast, annotationNode.getContext());
                }
                if (job.builderClassName.indexOf(42) > -1) {
                    String replStr = returnTypeToBuilderClassName(annotationNode, td3, buildMethodReturnType, job.typeParams);
                    if (replStr == null) {
                        return;
                    }
                    job.builderClassName = job.builderClassName.replace("*", replStr);
                }
                if (job.toBuilder) {
                    if (jCTypeApply instanceof JCTree.JCArrayTypeTree) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    }
                    List<JCTree.JCExpression> tpOnRet = List.nil();
                    if (jCTypeApply instanceof JCTree.JCTypeApply) {
                        tpOnRet = jCTypeApply.arguments;
                    }
                    JCTree.JCExpression namingType = jCTypeApply;
                    if (buildMethodReturnType instanceof JCTree.JCTypeApply) {
                        namingType = ((JCTree.JCTypeApply) buildMethodReturnType).clazz;
                    }
                    if (namingType instanceof JCTree.JCIdent) {
                        simpleName = namingType.name;
                        pkg = null;
                    } else if (namingType instanceof JCTree.JCFieldAccess) {
                        JCTree.JCFieldAccess jcfa = namingType;
                        simpleName = jcfa.name;
                        pkg = unpack(jcfa.selected);
                        if (pkg.startsWith("ERR:")) {
                            String err = pkg.substring(4, pkg.indexOf("__ERR__"));
                            annotationNode.addError(err);
                            return;
                        }
                    } else {
                        annotationNode.addError("Expected a (parameterized) type here instead of a " + namingType.getClass().getName());
                        return;
                    }
                    if (pkg != null && !parent.getPackageDeclaration().equals(pkg)) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    } else if (!job.parentType.getName().contentEquals((CharSequence) simpleName)) {
                        annotationNode.addError(TO_BUILDER_NOT_SUPPORTED);
                        return;
                    } else {
                        List<JCTree.JCTypeParameter> tpOnMethod = jmd2.typarams;
                        List<JCTree.JCTypeParameter> tpOnType = job.builderType.get().typarams;
                        typeArgsForToBuilder = new ArrayList<>();
                        Iterator it2 = tpOnMethod.iterator();
                        while (it2.hasNext()) {
                            JCTree.JCTypeParameter tp = (JCTree.JCTypeParameter) it2.next();
                            int pos = -1;
                            int idx = -1;
                            Iterator it3 = tpOnRet.iterator();
                            while (it3.hasNext()) {
                                JCTree.JCIdent jCIdent = (JCTree.JCExpression) it3.next();
                                idx++;
                                if ((jCIdent instanceof JCTree.JCIdent) && jCIdent.name == tp.name) {
                                    pos = idx;
                                }
                            }
                            if (pos == -1 || tpOnType.size() <= pos) {
                                annotationNode.addError("@Builder(toBuilder=true) requires that each type parameter on the static method is part of the typeargs of the return value. Type parameter " + tp.name + " is not part of the return type.");
                                return;
                            }
                            typeArgsForToBuilder.add(((JCTree.JCTypeParameter) tpOnType.get(pos)).name);
                        }
                    }
                }
            } else {
                annotationNode.addError("@Builder is only supported on types, constructors, and methods.");
                return;
            }
            if (fillParametersFrom != null) {
                Iterator<JavacNode> it4 = fillParametersFrom.down().iterator();
                while (it4.hasNext()) {
                    JavacNode param = it4.next();
                    if (param.getKind() == AST.Kind.ARGUMENT) {
                        BuilderFieldData bfd2 = new BuilderFieldData();
                        JCTree.JCVariableDecl raw = param.get();
                        bfd2.name = raw.name;
                        bfd2.builderFieldName = bfd2.name;
                        bfd2.rawName = raw.name;
                        bfd2.annotations = JavacHandlerUtil.findCopyableAnnotations(param);
                        bfd2.type = raw.vartype;
                        bfd2.singularData = getSingularData(param, annInstance.setterPrefix());
                        bfd2.originalFieldNode = param;
                        addObtainVia(bfd2, param);
                        job.builderFields.add(bfd2);
                    }
                }
            }
            job.builderType = JavacHandlerUtil.findInnerClass(job.parentType, job.builderClassName);
            if (job.builderType == null) {
                job.builderType = makeBuilderClass(job);
                JavacHandlerUtil.recursiveSetGeneratedBy(job.builderType.get(), ast, annotationNode.getContext());
            } else {
                JCTree.JCClassDecl builderTypeDeclaration = job.builderType.get();
                if (job.isStatic && !builderTypeDeclaration.getModifiers().getFlags().contains(Modifier.STATIC)) {
                    annotationNode.addError("Existing Builder must be a static inner class.");
                    return;
                } else if (!job.isStatic && builderTypeDeclaration.getModifiers().getFlags().contains(Modifier.STATIC)) {
                    annotationNode.addError("Existing Builder must be a non-static inner class.");
                    return;
                } else {
                    JavacHandlerUtil.sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(job.builderType, annotationNode);
                    for (BuilderFieldData bfd3 : job.builderFields) {
                        JavacSingularsRecipes.SingularData sd = bfd3.singularData;
                        if (sd != null && (singularizer = sd.getSingularizer()) != null && singularizer.checkForAlreadyExistingNodesAndGenerateError(job.builderType, sd)) {
                            bfd3.singularData = null;
                        }
                    }
                }
            }
            Iterator<BuilderFieldData> it5 = job.builderFields.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                BuilderFieldData bfd4 = it5.next();
                if (bfd4.singularData != null && bfd4.singularData.getSingularizer() != null && bfd4.singularData.getSingularizer().requiresCleaning()) {
                    addCleaning = true;
                    break;
                } else if (bfd4.obtainVia != null) {
                    if (bfd4.obtainVia.field().isEmpty() == bfd4.obtainVia.method().isEmpty()) {
                        bfd4.obtainViaNode.addError("The syntax is either @ObtainVia(field = \"fieldName\") or @ObtainVia(method = \"methodName\").");
                        return;
                    } else if (bfd4.obtainVia.method().isEmpty() && bfd4.obtainVia.isStatic()) {
                        bfd4.obtainViaNode.addError("@ObtainVia(isStatic = true) is not valid unless 'method' has been set.");
                        return;
                    }
                }
            }
            generateBuilderFields(job);
            if (addCleaning) {
                JavacTreeMaker maker = job.getTreeMaker();
                JCTree.JCVariableDecl uncleanField = maker.VarDef(maker.Modifiers(2L), job.builderType.toName(CLEAN_FIELD_NAME), maker.TypeIdent(Javac.CTC_BOOLEAN), null);
                JavacHandlerUtil.injectFieldAndMarkGenerated(job.builderType, uncleanField);
                JavacHandlerUtil.recursiveSetGeneratedBy(uncleanField, ast, annotationNode.getContext());
            }
            if (JavacHandlerUtil.constructorExists(job.builderType) == JavacHandlerUtil.MemberExistsResult.NOT_EXISTS && (cd = HandleConstructor.createConstructor(AccessLevel.PACKAGE, List.nil(), job.builderType, List.nil(), false, annotationNode)) != null) {
                JavacHandlerUtil.injectMethod(job.builderType, cd);
            }
            for (BuilderFieldData bfd5 : job.builderFields) {
                makePrefixedSetterMethodsForBuilder(job, bfd5, annInstance.setterPrefix());
            }
            JavacHandlerUtil.MemberExistsResult methodExists = JavacHandlerUtil.methodExists(job.buildMethodName, job.builderType, -1);
            if (methodExists == JavacHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK) {
                methodExists = JavacHandlerUtil.methodExists(job.buildMethodName, job.builderType, 0);
            }
            if (methodExists == JavacHandlerUtil.MemberExistsResult.NOT_EXISTS && (md = generateBuildMethod(job, nameOfBuilderMethod, buildMethodReturnType, buildMethodThrownExceptions, addCleaning)) != null) {
                JavacHandlerUtil.injectMethod(job.builderType, md);
                JavacHandlerUtil.recursiveSetGeneratedBy(md, ast, annotationNode.getContext());
            }
            if (JavacHandlerUtil.methodExists("toString", job.builderType, 0) == JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                java.util.List<InclusionExclusionUtils.Included<JavacNode, ToString.Include>> fieldNodes = new ArrayList<>();
                for (BuilderFieldData bfd6 : job.builderFields) {
                    for (JavacNode f : bfd6.createdFields) {
                        fieldNodes.add(new InclusionExclusionUtils.Included<>(f, null, true, false));
                    }
                }
                JCTree.JCMethodDecl md3 = HandleToString.createToString(job.builderType, fieldNodes, true, false, HandlerUtil.FieldAccess.ALWAYS_FIELD, ast);
                if (md3 != null) {
                    JavacHandlerUtil.injectMethod(job.builderType, md3);
                }
            }
            if (addCleaning) {
                JavacHandlerUtil.injectMethod(job.builderType, generateCleanMethod(job));
            }
            if (generateBuilderMethod && JavacHandlerUtil.methodExists(job.builderMethodName, job.parentType, -1) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                generateBuilderMethod = false;
            }
            if (generateBuilderMethod) {
                JCTree.JCMethodDecl md4 = generateBuilderMethod(job);
                JavacHandlerUtil.recursiveSetGeneratedBy(md4, ast, annotationNode.getContext());
                if (md4 != null) {
                    JavacHandlerUtil.injectMethod(job.parentType, md4);
                }
            }
            if (job.toBuilder) {
                switch ($SWITCH_TABLE$lombok$javac$handlers$JavacHandlerUtil$MemberExistsResult()[JavacHandlerUtil.methodExists(TO_BUILDER_METHOD_NAME, job.parentType, 0).ordinal()]) {
                    case 1:
                        List<JCTree.JCTypeParameter> tps = job.typeParams;
                        if (typeArgsForToBuilder != null) {
                            ListBuffer<JCTree.JCTypeParameter> lb = new ListBuffer<>();
                            JavacTreeMaker maker2 = job.getTreeMaker();
                            for (Name n : typeArgsForToBuilder) {
                                lb.append(maker2.TypeParameter(n, List.nil()));
                            }
                            tps = lb.toList();
                        }
                        JCTree.JCMethodDecl md5 = generateToBuilderMethod(job, tps, annInstance.setterPrefix());
                        if (md5 != null) {
                            JavacHandlerUtil.recursiveSetGeneratedBy(md5, ast, annotationNode.getContext());
                            JavacHandlerUtil.injectMethod(job.parentType, md5);
                            break;
                        }
                        break;
                    case 3:
                        annotationNode.addWarning("Not generating toBuilder() as it already exists.");
                        return;
                }
            }
            if (nonFinalNonDefaultedFields != null && generateBuilderMethod) {
                Iterator<JavacNode> it6 = nonFinalNonDefaultedFields.iterator();
                while (it6.hasNext()) {
                    it6.next().addWarning("@Builder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String returnTypeToBuilderClassName(JavacNode annotationNode, JCTree.JCClassDecl td, JCTree.JCExpression returnType, List<JCTree.JCTypeParameter> typeParams) {
        String replStr = null;
        if (returnType instanceof JCTree.JCFieldAccess) {
            replStr = ((JCTree.JCFieldAccess) returnType).name.toString();
        } else if (returnType instanceof JCTree.JCIdent) {
            Name n = ((JCTree.JCIdent) returnType).name;
            Iterator it = typeParams.iterator();
            while (it.hasNext()) {
                JCTree.JCTypeParameter tp = (JCTree.JCTypeParameter) it.next();
                if (tp.name.equals(n)) {
                    annotationNode.addError("@Builder requires specifying 'builderClassName' if used on methods with a type parameter as return type.");
                    return null;
                }
            }
            replStr = n.toString();
        } else if (returnType instanceof JCTree.JCPrimitiveTypeTree) {
            replStr = returnType.toString();
            if (Character.isLowerCase(replStr.charAt(0))) {
                replStr = String.valueOf(Character.toTitleCase(replStr.charAt(0))) + replStr.substring(1);
            }
        } else if (returnType instanceof JCTree.JCTypeApply) {
            JCTree.JCFieldAccess jCFieldAccess = ((JCTree.JCTypeApply) returnType).clazz;
            if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                replStr = jCFieldAccess.name.toString();
            } else if (jCFieldAccess instanceof JCTree.JCIdent) {
                replStr = ((JCTree.JCIdent) jCFieldAccess).name.toString();
            }
        }
        if (replStr == null || replStr.isEmpty()) {
            System.err.println("Lombok bug ID#20140614-1651: javac HandleBuilder: return type to name conversion failed: " + returnType.getClass());
            replStr = td.name.toString();
        }
        return replStr;
    }

    private static String unpack(JCTree.JCExpression expr) {
        StringBuilder sb = new StringBuilder();
        unpack(sb, expr);
        return sb.toString();
    }

    private static void unpack(StringBuilder sb, JCTree.JCExpression expr) {
        if (expr instanceof JCTree.JCIdent) {
            sb.append(((JCTree.JCIdent) expr).name.toString());
        } else if (expr instanceof JCTree.JCFieldAccess) {
            JCTree.JCFieldAccess jcfa = (JCTree.JCFieldAccess) expr;
            unpack(sb, jcfa.selected);
            sb.append(".").append(jcfa.name.toString());
        } else if (expr instanceof JCTree.JCTypeApply) {
            sb.setLength(0);
            sb.append("ERR:");
            sb.append("@Builder(toBuilder=true) is not supported if returning a type with generics applied to an intermediate.");
            sb.append("__ERR__");
        } else {
            sb.setLength(0);
            sb.append("ERR:");
            sb.append("Expected a type of some sort, not a " + expr.getClass().getName());
            sb.append("__ERR__");
        }
    }

    private JCTree.JCMethodDecl generateToBuilderMethod(BuilderJob job, List<JCTree.JCTypeParameter> typeParameters, String prefix) {
        JCTree.JCMethodInvocation inv;
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree.JCExpression> typeArgs = new ListBuffer<>();
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            JCTree.JCTypeParameter typeParam = (JCTree.JCTypeParameter) it.next();
            typeArgs.append(maker.Ident(typeParam.name));
        }
        JCTree.JCNewClass NewClass = maker.NewClass(null, List.nil(), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderClassName), !job.isStatic, job.builderTypeParams), List.nil(), null);
        ListBuffer<JCTree.JCStatement> preStatements = null;
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        for (BuilderFieldData bfd : job.builderFields) {
            String setterPrefix = !prefix.isEmpty() ? prefix : job.oldFluent ? "" : "set";
            String prefixedSetterName = bfd.name.toString();
            if (!setterPrefix.isEmpty()) {
                prefixedSetterName = HandlerUtil.buildAccessorName(setterPrefix, prefixedSetterName);
            }
            Name setterName = job.toName(prefixedSetterName);
            JCTree.JCExpression[] tgt = new JCTree.JCExpression[bfd.singularData == null ? 1 : 2];
            if (bfd.obtainVia == null || !bfd.obtainVia.field().isEmpty()) {
                for (int i = 0; i < tgt.length; i++) {
                    tgt[i] = maker.Select(maker.Ident(job.toName("this")), bfd.obtainVia == null ? bfd.rawName : job.toName(bfd.obtainVia.field()));
                }
            } else {
                String name = bfd.obtainVia.method();
                if (bfd.obtainVia.isStatic()) {
                    inv = maker.Apply(JavacHandlerUtil.typeParameterNames(maker, typeParameters), maker.Select(maker.Ident(job.toName(job.parentType.getName())), job.toName(name)), List.of(maker.Ident(job.toName("this"))));
                } else {
                    inv = maker.Apply(List.nil(), maker.Select(maker.Ident(job.toName("this")), job.toName(name)), List.nil());
                }
                for (int i2 = 0; i2 < tgt.length; i2++) {
                    tgt[i2] = maker.Ident(bfd.name);
                }
                JCTree.JCExpression varType = JavacHandlerUtil.cloneType(maker, bfd.type, job.source, job.getContext());
                if (preStatements == null) {
                    preStatements = new ListBuffer<>();
                }
                preStatements.append(maker.VarDef(maker.Modifiers(16L), bfd.name, varType, inv));
            }
            if (bfd.singularData == null) {
                JCTree.JCExpression arg = tgt[0];
                NewClass = maker.Apply(List.nil(), maker.Select(NewClass, setterName), List.of(arg));
            } else {
                statements.append(maker.If(maker.Binary(Javac.CTC_NOT_EQUAL, tgt[0], maker.Literal(Javac.CTC_BOT, null)), maker.Exec(maker.Apply(List.nil(), maker.Select(maker.Ident(job.toName(BUILDER_TEMP_VAR)), setterName), List.of(tgt[1]))), null));
            }
        }
        if (!statements.isEmpty()) {
            JCTree.JCExpression tempVarType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), !job.isStatic, typeParameters);
            statements.prepend(maker.VarDef(maker.Modifiers(16L), job.toName(BUILDER_TEMP_VAR), tempVarType, NewClass));
            statements.append(maker.Return(maker.Ident(job.toName(BUILDER_TEMP_VAR))));
        } else {
            statements.append(maker.Return(NewClass));
        }
        if (preStatements != null) {
            preStatements.appendList(statements);
            statements = preStatements;
        }
        JCTree.JCBlock body = maker.Block(0L, statements.toList());
        List<JCTree.JCAnnotation> annsOnParamType = List.nil();
        if (job.checkerFramework.generateUnique()) {
            annsOnParamType = List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__UNIQUE), List.nil()));
        }
        JCTree.JCMethodDecl methodDef = maker.MethodDef(maker.Modifiers(JavacHandlerUtil.toJavacModifier(job.accessOuters)), job.toName(TO_BUILDER_METHOD_NAME), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), !job.isStatic, typeParameters, annsOnParamType), List.nil(), List.nil(), List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(job.parentType, methodDef);
        return methodDef;
    }

    private JCTree.JCMethodDecl generateCleanMethod(BuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendCleaningCode(bfd.singularData, job.builderType, job.source, statements);
            }
        }
        statements.append(maker.Exec(maker.Assign(maker.Select(maker.Ident(job.toName("this")), job.toName(CLEAN_FIELD_NAME)), maker.Literal(Javac.CTC_BOOLEAN, 0))));
        JCTree.JCBlock body = maker.Block(0L, statements.toList());
        JCTree.JCMethodDecl method = maker.MethodDef(maker.Modifiers(JavacHandlerUtil.toJavacModifier(AccessLevel.PRIVATE)), job.toName(CLEAN_METHOD_NAME), maker.Type(Javac.createVoidType(job.builderType.getSymbolTable(), Javac.CTC_VOID)), List.nil(), List.nil(), List.nil(), body, null);
        JavacHandlerUtil.recursiveSetGeneratedBy(method, job.source, job.getContext());
        return method;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JCTree.JCVariableDecl generateReceiver(BuilderJob job) {
        JCTree.JCLiteral NewArray;
        if (job.checkerFramework.generateCalledMethods()) {
            ArrayList<String> mandatories = new ArrayList<>();
            for (BuilderFieldData bfd : job.builderFields) {
                if (bfd.singularData == null && bfd.nameOfSetFlag == null) {
                    mandatories.add(bfd.name.toString());
                }
            }
            JavacTreeMaker maker = job.getTreeMaker();
            if (mandatories.size() == 0) {
                return null;
            }
            if (mandatories.size() == 1) {
                NewArray = maker.Literal(mandatories.get(0));
            } else {
                List<JCTree.JCExpression> elems = List.nil();
                for (int i = mandatories.size() - 1; i >= 0; i--) {
                    elems = elems.prepend(maker.Literal(mandatories.get(i)));
                }
                NewArray = maker.NewArray(null, List.nil(), elems);
            }
            JCTree.JCAnnotation recvAnno = maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__CALLED), List.of(NewArray));
            JCTree.JCClassDecl builderTypeNode = job.builderType.get();
            JCTree.JCVariableDecl recv = maker.VarDef(maker.Modifiers(8589934592L, List.nil()), job.toName("this"), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.builderType, builderTypeNode.typarams, List.of(recvAnno)), null);
            return recv;
        }
        return null;
    }

    private JCTree.JCMethodDecl generateBuildMethod(BuilderJob job, Name staticName, JCTree.JCExpression returnType, List<JCTree.JCExpression> thrownExceptions, boolean addCleaning) {
        JCTree.JCMethodDecl methodDef;
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        if (addCleaning) {
            JCTree.JCIf ifUnclean = maker.If(maker.Unary(Javac.CTC_NOT, maker.Select(maker.Ident(job.toName("this")), job.toName(CLEAN_FIELD_NAME))), maker.Exec(maker.Apply(List.nil(), maker.Ident(job.toName(CLEAN_METHOD_NAME)), List.nil())), null);
            statements.append(ifUnclean);
        }
        for (BuilderFieldData bfd : job.builderFields) {
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.singularData.getSingularizer().appendBuildCode(bfd.singularData, job.builderType, job.source, statements, bfd.builderFieldName, "this");
            }
        }
        ListBuffer<JCTree.JCExpression> args = new ListBuffer<>();
        Name thisName = job.toName("this");
        for (BuilderFieldData bfd2 : job.builderFields) {
            if (bfd2.nameOfSetFlag != null) {
                statements.append(maker.VarDef(maker.Modifiers(0L), bfd2.builderFieldName, JavacHandlerUtil.cloneType(maker, bfd2.type, job.source, job.getContext()), maker.Select(maker.Ident(thisName), bfd2.builderFieldName)));
                statements.append(maker.If(maker.Unary(Javac.CTC_NOT, maker.Select(maker.Ident(thisName), bfd2.nameOfSetFlag)), maker.Exec(maker.Assign(maker.Ident(bfd2.builderFieldName), maker.Apply(JavacHandlerUtil.typeParameterNames(maker, job.parentType.get().typarams), maker.Select(maker.Ident(job.parentType.get().name), bfd2.nameOfDefaultProvider), List.nil()))), null));
            }
            if (bfd2.nameOfSetFlag != null || (bfd2.singularData != null && bfd2.singularData.getSingularizer().shadowedDuringBuild())) {
                args.append(maker.Ident(bfd2.builderFieldName));
            } else {
                args.append(maker.Select(maker.Ident(thisName), bfd2.builderFieldName));
            }
        }
        if (addCleaning) {
            statements.append(maker.Exec(maker.Assign(maker.Select(maker.Ident(job.toName("this")), job.toName(CLEAN_FIELD_NAME)), maker.Literal(Javac.CTC_BOOLEAN, 1))));
        }
        if (staticName == null) {
            statements.append(maker.Return(maker.NewClass(null, List.nil(), returnType, args.toList(), null)));
        } else {
            ListBuffer<JCTree.JCExpression> typeParams = new ListBuffer<>();
            Iterator it = job.builderType.get().typarams.iterator();
            while (it.hasNext()) {
                JCTree.JCTypeParameter tp = (JCTree.JCTypeParameter) it.next();
                typeParams.append(maker.Ident(tp.name));
            }
            JCTree.JCIdent Ident = maker.Ident(job.parentType.get().name);
            if (!job.isStatic) {
                Ident = maker.Select(Ident, job.toName("this"));
            }
            JCTree.JCMethodInvocation Apply = maker.Apply(typeParams.toList(), maker.Select(Ident, staticName), args.toList());
            if ((returnType instanceof JCTree.JCPrimitiveTypeTree) && Javac.CTC_VOID.equals(JavacTreeMaker.TypeTag.typeTag((JCTree) returnType))) {
                statements.append(maker.Exec(Apply));
            } else {
                statements.append(maker.Return(Apply));
            }
        }
        JCTree.JCBlock body = maker.Block(0L, statements.toList());
        List<JCTree.JCAnnotation> annsOnMethod = job.checkerFramework.generateSideEffectFree() ? List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.builderType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil())) : List.nil();
        JCTree.JCVariableDecl recv = generateReceiver(job);
        if (recv != null && maker.hasMethodDefWithRecvParam()) {
            methodDef = maker.MethodDefWithRecvParam(maker.Modifiers(JavacHandlerUtil.toJavacModifier(job.accessInners), annsOnMethod), job.toName(job.buildMethodName), returnType, List.nil(), recv, List.nil(), thrownExceptions, body, null);
        } else {
            methodDef = maker.MethodDef(maker.Modifiers(JavacHandlerUtil.toJavacModifier(job.accessInners), annsOnMethod), job.toName(job.buildMethodName), returnType, List.nil(), List.nil(), thrownExceptions, body, null);
        }
        if (staticName == null) {
            JavacHandlerUtil.createRelevantNonNullAnnotation(job.builderType, methodDef);
        }
        return methodDef;
    }

    public static JCTree.JCMethodDecl generateDefaultProvider(Name methodName, JavacNode fieldNode, List<JCTree.JCTypeParameter> params) {
        JavacTreeMaker maker = fieldNode.getTreeMaker();
        JCTree.JCVariableDecl field = fieldNode.get();
        JCTree.JCReturn Return = maker.Return(field.init);
        field.init = null;
        JCTree.JCBlock body = maker.Block(0L, List.of(Return));
        return maker.MethodDef(maker.Modifiers(10), methodName, JavacHandlerUtil.cloneType(maker, field.vartype, field, fieldNode.getContext()), JavacHandlerUtil.copyTypeParams(fieldNode, params), List.nil(), List.nil(), body, null);
    }

    public JCTree.JCMethodDecl generateBuilderMethod(BuilderJob job) {
        JCTree.JCNewClass NewClass;
        JavacTreeMaker maker = job.getTreeMaker();
        ListBuffer<JCTree.JCExpression> typeArgs = new ListBuffer<>();
        Iterator it = job.typeParams.iterator();
        while (it.hasNext()) {
            JCTree.JCTypeParameter typeParam = (JCTree.JCTypeParameter) it.next();
            typeArgs.append(maker.Ident(typeParam.name));
        }
        if (job.isStatic) {
            NewClass = maker.NewClass(null, List.nil(), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.toName(job.builderClassName), false, job.typeParams), List.nil(), null);
        } else {
            NewClass = maker.NewClass(null, List.nil(), JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, null, job.toName(job.builderClassName), false, job.typeParams), List.nil(), null);
            NewClass.encl = maker.Ident(job.toName("this"));
        }
        JCTree.JCBlock body = maker.Block(0L, List.of(maker.Return(NewClass)));
        int modifiers = JavacHandlerUtil.toJavacModifier(job.accessOuters);
        if (job.isStatic) {
            modifiers |= 8;
        }
        List<JCTree.JCAnnotation> annsOnMethod = List.nil();
        if (job.checkerFramework.generateSideEffectFree()) {
            annsOnMethod = List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__SIDE_EFFECT_FREE), List.nil()));
        }
        List<JCTree.JCAnnotation> annsOnParamType = List.nil();
        if (job.checkerFramework.generateUnique()) {
            annsOnParamType = List.of(maker.Annotation(JavacHandlerUtil.genTypeRef(job.parentType, CheckerFrameworkVersion.NAME__UNIQUE), List.nil()));
        }
        JCTree.JCExpression returnType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.parentType, job.getBuilderClassName(), !job.isStatic, job.builderTypeParams, annsOnParamType);
        JCTree.JCMethodDecl methodDef = maker.MethodDef(maker.Modifiers(modifiers, annsOnMethod), job.toName(job.builderMethodName), returnType, job.copyTypeParams(), List.nil(), List.nil(), body, null);
        JavacHandlerUtil.createRelevantNonNullAnnotation(job.parentType, methodDef);
        return methodDef;
    }

    public void generateBuilderFields(BuilderJob job) {
        int len = job.builderFields.size();
        java.util.List<JavacNode> existing = new ArrayList<>();
        Iterator<JavacNode> it = job.builderType.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.FIELD) {
                existing.add(child);
            }
        }
        java.util.List<JCTree.JCVariableDecl> generated = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            BuilderFieldData bfd = job.builderFields.get(i);
            if (bfd.singularData != null && bfd.singularData.getSingularizer() != null) {
                bfd.createdFields.addAll(bfd.singularData.getSingularizer().generateFields(bfd.singularData, job.builderType, job.source));
            } else {
                JavacNode field = null;
                JavacNode setFlag = null;
                for (JavacNode exists : existing) {
                    Name n = exists.get().name;
                    if (n.equals(bfd.builderFieldName)) {
                        field = exists;
                    }
                    if (n.equals(bfd.nameOfSetFlag)) {
                        setFlag = exists;
                    }
                }
                JavacTreeMaker maker = job.getTreeMaker();
                if (field == null) {
                    JCTree.JCModifiers mods = maker.Modifiers(2L);
                    JCTree.JCVariableDecl newField = maker.VarDef(mods, bfd.builderFieldName, JavacHandlerUtil.cloneType(maker, bfd.type, job.source, job.getContext()), null);
                    field = JavacHandlerUtil.injectFieldAndMarkGenerated(job.builderType, newField);
                    generated.add(newField);
                }
                if (setFlag == null && bfd.nameOfSetFlag != null) {
                    JCTree.JCModifiers mods2 = maker.Modifiers(2L);
                    JCTree.JCVariableDecl newField2 = maker.VarDef(mods2, bfd.nameOfSetFlag, maker.TypeIdent(Javac.CTC_BOOLEAN), null);
                    JavacHandlerUtil.injectFieldAndMarkGenerated(job.builderType, newField2);
                    generated.add(newField2);
                }
                bfd.createdFields.add(field);
            }
        }
        for (JCTree.JCVariableDecl gen : generated) {
            JavacHandlerUtil.recursiveSetGeneratedBy(gen, job.source, job.getContext());
        }
    }

    public void makePrefixedSetterMethodsForBuilder(BuilderJob job, BuilderFieldData bfd, String prefix) {
        boolean deprecate = JavacHandlerUtil.isFieldDeprecated(bfd.originalFieldNode);
        if (bfd.singularData == null || bfd.singularData.getSingularizer() == null) {
            makePrefixedSetterMethodForBuilder(job, bfd, deprecate, prefix);
        } else {
            bfd.singularData.getSingularizer().generateMethods(job, bfd.singularData, deprecate);
        }
    }

    private void makePrefixedSetterMethodForBuilder(BuilderJob job, BuilderFieldData bfd, boolean deprecate, String prefix) {
        JavacNode fieldNode = bfd.createdFields.get(0);
        String setterPrefix = !prefix.isEmpty() ? prefix : job.oldFluent ? "" : "set";
        String setterName = HandlerUtil.buildAccessorName(setterPrefix, bfd.name.toString());
        Name setterName_ = job.builderType.toName(setterName);
        Iterator<JavacNode> it = job.builderType.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (child.getKind() == AST.Kind.METHOD) {
                JCTree.JCMethodDecl methodDecl = child.get();
                Name existingName = methodDecl.name;
                if (existingName.equals(setterName_) && !JavacHandlerUtil.isTolerate(fieldNode, methodDecl)) {
                    return;
                }
            }
        }
        JavacTreeMaker maker = fieldNode.getTreeMaker();
        List<JCTree.JCAnnotation> methodAnns = JavacHandlerUtil.findCopyableToSetterAnnotations(bfd.originalFieldNode);
        JCTree.JCMethodDecl newMethod = null;
        if (job.checkerFramework.generateCalledMethods() && maker.hasMethodDefWithRecvParam()) {
            JCTree.JCAnnotation ncAnno = maker.Annotation(JavacHandlerUtil.genTypeRef(job.sourceNode, CheckerFrameworkVersion.NAME__NOT_CALLED), List.of(maker.Literal(setterName.toString())));
            JCTree.JCClassDecl builderTypeNode = job.builderType.get();
            JCTree.JCExpression selfType = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, job.builderType, builderTypeNode.typarams, List.of(ncAnno));
            JCTree.JCVariableDecl recv = maker.VarDef(maker.Modifiers(8589934592L, List.nil()), job.builderType.toName("this"), selfType, null);
            newMethod = HandleSetter.createSetterWithRecv(JavacHandlerUtil.toJavacModifier(job.accessInners), deprecate, fieldNode, maker, setterName, bfd.name, bfd.nameOfSetFlag, job.oldChain, job.sourceNode, methodAnns, bfd.annotations, recv);
        }
        if (newMethod == null) {
            newMethod = HandleSetter.createSetter(JavacHandlerUtil.toJavacModifier(job.accessInners), deprecate, fieldNode, maker, setterName, bfd.name, bfd.nameOfSetFlag, job.oldChain, job.sourceNode, methodAnns, bfd.annotations);
        }
        JavacHandlerUtil.recursiveSetGeneratedBy(newMethod, job.source, job.getContext());
        if (job.sourceNode.up().getKind() == AST.Kind.METHOD) {
            copyJavadocFromParam(bfd.originalFieldNode.up(), newMethod, bfd.name.toString());
        } else {
            JavacHandlerUtil.copyJavadoc(bfd.originalFieldNode, newMethod, JavacHandlerUtil.CopyJavadoc.SETTER, true);
        }
        JavacHandlerUtil.injectMethod(job.builderType, newMethod);
    }

    private void copyJavadocFromParam(JavacNode from, JCTree.JCMethodDecl to, String param) {
        try {
            JCTree.JCCompilationUnit cu = from.top().get();
            String methodComment = Javac.getDocComment(cu, from.get());
            if (methodComment == null) {
                return;
            }
            Pattern pattern = Pattern.compile("@param " + param + " (\\S|\\s)+?(?=^ ?@)", 10);
            Matcher matcher = pattern.matcher(methodComment);
            if (matcher.find()) {
                String newJavadoc = HandlerUtil.addReturnsThisIfNeeded(matcher.group());
                Javac.setDocComment(cu, to, newJavadoc);
            }
        } catch (Exception unused) {
        }
    }

    public JavacNode makeBuilderClass(BuilderJob job) {
        JavacTreeMaker maker = job.getTreeMaker();
        int modifiers = JavacHandlerUtil.toJavacModifier(job.accessOuters);
        if (job.isStatic) {
            modifiers |= 8;
        }
        JCTree.JCModifiers mods = maker.Modifiers(modifiers);
        JCTree.JCClassDecl builder = maker.ClassDef(mods, job.getBuilderClassName(), job.copyTypeParams(), null, List.nil(), List.nil());
        return JavacHandlerUtil.injectType(job.parentType, builder);
    }

    private void addObtainVia(BuilderFieldData bfd, JavacNode node) {
        Iterator<JavacNode> it = node.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (JavacHandlerUtil.annotationTypeMatches(Builder.ObtainVia.class, child)) {
                AnnotationValues<Builder.ObtainVia> ann = JavacHandlerUtil.createAnnotation(Builder.ObtainVia.class, child);
                bfd.obtainVia = ann.getInstance();
                bfd.obtainViaNode = child;
                JavacHandlerUtil.deleteAnnotationIfNeccessary(child, Builder.ObtainVia.class);
                return;
            }
        }
    }

    private JavacSingularsRecipes.SingularData getSingularData(JavacNode node, String setterPrefix) {
        Iterator<JavacNode> it = node.down().iterator();
        while (it.hasNext()) {
            JavacNode child = it.next();
            if (JavacHandlerUtil.annotationTypeMatches(Singular.class, child)) {
                Name pluralName = node.getKind() == AST.Kind.FIELD ? JavacHandlerUtil.removePrefixFromField(node) : node.get().name;
                AnnotationValues<Singular> ann = JavacHandlerUtil.createAnnotation(Singular.class, child);
                Singular singularInstance = ann.getInstance();
                JavacHandlerUtil.deleteAnnotationIfNeccessary(child, Singular.class);
                String explicitSingular = singularInstance.value();
                if (explicitSingular.isEmpty()) {
                    if (Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.SINGULAR_AUTO))) {
                        node.addError("The singular must be specified explicitly (e.g. @Singular(\"task\")) because auto singularization is disabled.");
                        explicitSingular = pluralName.toString();
                    } else {
                        explicitSingular = HandlerUtil.autoSingularize(pluralName.toString());
                        if (explicitSingular == null) {
                            node.addError("Can't singularize this name; please specify the singular explicitly (i.e. @Singular(\"sheep\"))");
                            explicitSingular = pluralName.toString();
                        }
                    }
                }
                Name singularName = node.toName(explicitSingular);
                JCTree.JCTypeApply type = null;
                if (node.get() instanceof JCTree.JCVariableDecl) {
                    type = node.get().vartype;
                }
                List<JCTree.JCExpression> typeArgs = List.nil();
                if (type instanceof JCTree.JCTypeApply) {
                    typeArgs = type.arguments;
                    type = type.clazz;
                }
                String name = type.toString();
                String targetFqn = JavacSingularsRecipes.get().toQualified(name);
                JavacSingularsRecipes.JavacSingularizer singularizer = JavacSingularsRecipes.get().getSingularizer(targetFqn, node);
                if (singularizer == null) {
                    node.addError("Lombok does not know how to create the singular-form builder methods for type '" + name + "'; they won't be generated.");
                    return null;
                }
                return new JavacSingularsRecipes.SingularData(child, singularName, pluralName, typeArgs, targetFqn, singularizer, singularInstance.ignoreNullCollections(), setterPrefix);
            }
        }
        return null;
    }
}
