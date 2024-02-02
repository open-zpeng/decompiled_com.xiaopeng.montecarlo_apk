package lombok.eclipse.handlers;

import java.lang.annotation.Annotation;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.CustomLog;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.configuration.IdentifierName;
import lombok.core.configuration.LogDeclaration;
import lombok.core.handlers.HandlerUtil;
import lombok.core.handlers.LoggingFramework;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.flogger.Flogger;
import lombok.extern.java.Log;
import lombok.extern.jbosslog.JBossLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog.SCL.lombok */
public class HandleLog {
    private static final IdentifierName LOG = IdentifierName.valueOf("log");
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter;

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter() {
        int[] iArr = $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[LogDeclaration.LogFactoryParameter.valuesCustom().length];
        try {
            iArr2[LogDeclaration.LogFactoryParameter.NAME.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.TOPIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[LogDeclaration.LogFactoryParameter.TYPE.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter = iArr2;
        return iArr2;
    }

    private HandleLog() {
        throw new UnsupportedOperationException();
    }

    public static void processAnnotation(LoggingFramework framework, AnnotationValues<? extends Annotation> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
        EclipseNode owner = annotationNode.up();
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[owner.getKind().ordinal()]) {
            case 2:
                IdentifierName logFieldName = (IdentifierName) annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_ANY_FIELD_NAME);
                if (logFieldName == null) {
                    logFieldName = LOG;
                }
                boolean useStatic = !Boolean.FALSE.equals(annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_ANY_FIELD_IS_STATIC));
                TypeDeclaration typeDecl = null;
                if (owner.get() instanceof TypeDeclaration) {
                    typeDecl = (TypeDeclaration) owner.get();
                }
                int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
                boolean notAClass = (modifiers & 8704) != 0;
                if (typeDecl == null || notAClass) {
                    annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " is legal only on classes and enums.");
                    return;
                } else if (EclipseHandlerUtil.fieldExists(logFieldName.getName(), owner) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
                    annotationNode.addWarning("Field '" + logFieldName + "' already exists.");
                    return;
                } else {
                    Object valueGuess = annotation.getValueGuess("topic");
                    Expression loggerTopic = (Expression) annotation.getActualExpression("topic");
                    if ((valueGuess instanceof String) && ((String) valueGuess).trim().isEmpty()) {
                        loggerTopic = null;
                    }
                    if (framework.getDeclaration().getParametersWithTopic() == null && loggerTopic != null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " does not allow a topic.");
                        loggerTopic = null;
                    }
                    if (framework.getDeclaration().getParametersWithoutTopic() == null && loggerTopic == null) {
                        annotationNode.addError(String.valueOf(framework.getAnnotationAsString()) + " requires a topic.");
                        loggerTopic = new StringLiteral(new char[0], 0, 0, 0);
                    }
                    ClassLiteralAccess loggingType = selfType(owner, source);
                    FieldDeclaration fieldDeclaration = createField(framework, source, loggingType, logFieldName.getName(), useStatic, loggerTopic);
                    fieldDeclaration.traverse(new SetGeneratedByVisitor(source), typeDecl.staticInitializerScope);
                    EclipseHandlerUtil.injectField(owner, fieldDeclaration);
                    owner.rebuild();
                    return;
                }
            default:
                return;
        }
    }

    public static ClassLiteralAccess selfType(EclipseNode type, org.eclipse.jdt.internal.compiler.ast.Annotation source) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        TypeDeclaration typeDeclaration = type.get();
        SingleTypeReference singleTypeReference = new SingleTypeReference(typeDeclaration.name, p);
        EclipseHandlerUtil.setGeneratedBy(singleTypeReference, source);
        ClassLiteralAccess result = new ClassLiteralAccess(source.sourceEnd, singleTypeReference);
        EclipseHandlerUtil.setGeneratedBy(result, source);
        return result;
    }

    private static FieldDeclaration createField(LoggingFramework framework, org.eclipse.jdt.internal.compiler.ast.Annotation source, ClassLiteralAccess loggingType, String logFieldName, boolean useStatic, Expression loggerTopic) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        FieldDeclaration fieldDecl = new FieldDeclaration(logFieldName.toCharArray(), 0, -1);
        EclipseHandlerUtil.setGeneratedBy(fieldDecl, source);
        fieldDecl.declarationSourceEnd = -1;
        fieldDecl.modifiers = 2 | (useStatic ? 8 : 0) | 16;
        LogDeclaration logDeclaration = framework.getDeclaration();
        fieldDecl.type = EclipseHandlerUtil.createTypeReference(logDeclaration.getLoggerType().getName(), source);
        MessageSend factoryMethodCall = new MessageSend();
        EclipseHandlerUtil.setGeneratedBy(factoryMethodCall, source);
        factoryMethodCall.receiver = EclipseHandlerUtil.createNameReference(logDeclaration.getLoggerFactoryType().getName(), source);
        factoryMethodCall.selector = logDeclaration.getLoggerFactoryMethod().getCharArray();
        List<LogDeclaration.LogFactoryParameter> parameters = loggerTopic != null ? logDeclaration.getParametersWithTopic() : logDeclaration.getParametersWithoutTopic();
        factoryMethodCall.arguments = createFactoryParameters(loggingType, source, parameters, loggerTopic);
        factoryMethodCall.nameSourcePosition = p;
        factoryMethodCall.sourceStart = pS;
        factoryMethodCall.statementEnd = pE;
        factoryMethodCall.sourceEnd = pE;
        fieldDecl.initialization = factoryMethodCall;
        return fieldDecl;
    }

    private static final Expression[] createFactoryParameters(ClassLiteralAccess loggingType, org.eclipse.jdt.internal.compiler.ast.Annotation source, List<LogDeclaration.LogFactoryParameter> parameters, Expression loggerTopic) {
        Expression[] expressions = new Expression[parameters.size()];
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        for (int i = 0; i < parameters.size(); i++) {
            LogDeclaration.LogFactoryParameter parameter = parameters.get(i);
            switch ($SWITCH_TABLE$lombok$core$configuration$LogDeclaration$LogFactoryParameter()[parameter.ordinal()]) {
                case 1:
                    expressions[i] = createFactoryTypeParameter(loggingType, source);
                    break;
                case 2:
                    long p = (pS << 32) | pE;
                    MessageSend factoryParameterCall = new MessageSend();
                    EclipseHandlerUtil.setGeneratedBy(factoryParameterCall, source);
                    factoryParameterCall.receiver = createFactoryTypeParameter(loggingType, source);
                    factoryParameterCall.selector = "getName".toCharArray();
                    factoryParameterCall.nameSourcePosition = p;
                    factoryParameterCall.sourceStart = pS;
                    factoryParameterCall.statementEnd = pE;
                    factoryParameterCall.sourceEnd = pE;
                    expressions[i] = factoryParameterCall;
                    break;
                case 3:
                    expressions[i] = EclipseHandlerUtil.copyAnnotationMemberValue(loggerTopic);
                    break;
                case 4:
                    expressions[i] = new NullLiteral(pS, pE);
                    break;
                default:
                    throw new IllegalStateException("Unknown logger factory parameter type: " + parameter);
            }
        }
        return expressions;
    }

    private static final Expression createFactoryTypeParameter(ClassLiteralAccess loggingType, org.eclipse.jdt.internal.compiler.ast.Annotation source) {
        TypeReference copy = EclipseHandlerUtil.copyType(loggingType.type, source);
        ClassLiteralAccess result = new ClassLiteralAccess(source.sourceEnd, copy);
        EclipseHandlerUtil.setGeneratedBy(result, source);
        return result;
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleCommonsLog.SCL.lombok */
    public static class HandleCommonsLog extends EclipseAnnotationHandler<CommonsLog> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<CommonsLog> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_COMMONS_FLAG_USAGE, "@apachecommons.CommonsLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.COMMONS, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleJulLog.SCL.lombok */
    public static class HandleJulLog extends EclipseAnnotationHandler<Log> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<Log> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JUL_FLAG_USAGE, "@java.Log", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.JUL, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleLog4jLog.SCL.lombok */
    public static class HandleLog4jLog extends EclipseAnnotationHandler<Log4j> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<Log4j> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J_FLAG_USAGE, "@Log4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.LOG4J, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleLog4j2Log.SCL.lombok */
    public static class HandleLog4j2Log extends EclipseAnnotationHandler<Log4j2> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<Log4j2> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_LOG4J2_FLAG_USAGE, "@Log4j2", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.LOG4J2, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleSlf4jLog.SCL.lombok */
    public static class HandleSlf4jLog extends EclipseAnnotationHandler<Slf4j> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<Slf4j> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_SLF4J_FLAG_USAGE, "@Slf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.SLF4J, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleXSlf4jLog.SCL.lombok */
    public static class HandleXSlf4jLog extends EclipseAnnotationHandler<XSlf4j> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<XSlf4j> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_XSLF4J_FLAG_USAGE, "@XSlf4j", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.XSLF4J, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleJBossLog.SCL.lombok */
    public static class HandleJBossLog extends EclipseAnnotationHandler<JBossLog> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<JBossLog> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_JBOSSLOG_FLAG_USAGE, "@JBossLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.JBOSSLOG, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleFloggerLog.SCL.lombok */
    public static class HandleFloggerLog extends EclipseAnnotationHandler<Flogger> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<Flogger> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_FLOGGER_FLAG_USAGE, "@Flogger", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            HandleLog.processAnnotation(LoggingFramework.FLOGGER, annotation, source, annotationNode);
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/handlers/HandleLog$HandleCustomLog.SCL.lombok */
    public static class HandleCustomLog extends EclipseAnnotationHandler<CustomLog> {
        @Override // lombok.eclipse.EclipseAnnotationHandler
        public void handle(AnnotationValues<CustomLog> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation source, EclipseNode annotationNode) {
            HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.LOG_CUSTOM_FLAG_USAGE, "@CustomLog", ConfigurationKeys.LOG_ANY_FLAG_USAGE, "any @Log");
            LogDeclaration logDeclaration = (LogDeclaration) annotationNode.getAst().readConfiguration(ConfigurationKeys.LOG_CUSTOM_DECLARATION);
            if (logDeclaration == null) {
                annotationNode.addError("The @CustomLog annotation is not configured; please set log.custom.declaration in lombok.config.");
                return;
            }
            LoggingFramework framework = new LoggingFramework(CustomLog.class, logDeclaration);
            HandleLog.processAnnotation(framework, annotation, source, annotationNode);
        }
    }
}
