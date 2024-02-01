package lombok;

import java.util.List;
import lombok.core.configuration.CallSuperType;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.FlagUsageType;
import lombok.core.configuration.IdentifierName;
import lombok.core.configuration.LogDeclaration;
import lombok.core.configuration.NullAnnotationLibrary;
import lombok.core.configuration.NullCheckExceptionType;
import lombok.core.configuration.TypeName;
/* loaded from: classes3.dex */
public class ConfigurationKeys {
    public static final ConfigurationKey<Boolean> LOMBOK_DISABLE = new ConfigurationKey<Boolean>("dangerousconfig.lombok.disable", "Disables lombok transformers. It does not flag any lombok mentions (so, @Cleanup silently does nothing), and does not disable patched operations in eclipse either. Don't use this unless you know what you're doing. (default: false).", true) { // from class: lombok.ConfigurationKeys.1
    };
    @Deprecated
    public static final ConfigurationKey<Boolean> ADD_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("lombok.addGeneratedAnnotation", "Generate @javax.annotation.Generated on all generated code (default: false). Deprecated, use 'lombok.addJavaxGeneratedAnnotation' instead.") { // from class: lombok.ConfigurationKeys.2
    };
    public static final ConfigurationKey<Boolean> ADD_JAVAX_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("lombok.addJavaxGeneratedAnnotation", "Generate @javax.annotation.Generated on all generated code (default: follow lombok.addGeneratedAnnotation).") { // from class: lombok.ConfigurationKeys.3
    };
    public static final ConfigurationKey<Boolean> ADD_LOMBOK_GENERATED_ANNOTATIONS = new ConfigurationKey<Boolean>("lombok.addLombokGeneratedAnnotation", "Generate @lombok.Generated on all generated code (default: false).") { // from class: lombok.ConfigurationKeys.4
    };
    public static final ConfigurationKey<Boolean> ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS = new ConfigurationKey<Boolean>("lombok.extern.findbugs.addSuppressFBWarnings", "Generate @edu.umd.cs.findbugs.annotations.SuppressFBWarnings on all generated code (default: false).") { // from class: lombok.ConfigurationKeys.5
    };
    public static final ConfigurationKey<Boolean> ADD_SUPPRESSWARNINGS_ANNOTATIONS = new ConfigurationKey<Boolean>("lombok.addSuppressWarnings", "Generate @java.lang.SuppressWarnings(\"all\") on all generated code (default: true).") { // from class: lombok.ConfigurationKeys.6
    };
    public static final ConfigurationKey<NullAnnotationLibrary> ADD_NULL_ANNOTATIONS = new ConfigurationKey<NullAnnotationLibrary>("lombok.addNullAnnotations", "Generate some style of null annotation for generated code where this is relevant. (default: none).") { // from class: lombok.ConfigurationKeys.7
    };
    public static final ConfigurationKey<FlagUsageType> ANY_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.anyConstructor.flagUsage", "Emit a warning or error if any of the XxxArgsConstructor annotations are used.") { // from class: lombok.ConfigurationKeys.8
    };
    @Deprecated
    public static final ConfigurationKey<Boolean> ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES = new ConfigurationKey<Boolean>("lombok.anyConstructor.suppressConstructorProperties", "Suppress the generation of @ConstructorProperties for generated constructors (default: false).") { // from class: lombok.ConfigurationKeys.9
    };
    public static final ConfigurationKey<Boolean> ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES = new ConfigurationKey<Boolean>("lombok.anyConstructor.addConstructorProperties", "Generate @ConstructorProperties for generated constructors (default: false).") { // from class: lombok.ConfigurationKeys.10
    };
    public static final ConfigurationKey<FlagUsageType> ALL_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.allArgsConstructor.flagUsage", "Emit a warning or error if @AllArgsConstructor is used.") { // from class: lombok.ConfigurationKeys.11
    };
    public static final ConfigurationKey<FlagUsageType> NO_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.noArgsConstructor.flagUsage", "Emit a warning or error if @NoArgsConstructor is used.") { // from class: lombok.ConfigurationKeys.12
    };
    public static final ConfigurationKey<Boolean> NO_ARGS_CONSTRUCTOR_EXTRA_PRIVATE = new ConfigurationKey<Boolean>("lombok.noArgsConstructor.extraPrivate", "Generate a private no-args constructor for @Data and @Value (default: false).") { // from class: lombok.ConfigurationKeys.13
    };
    public static final ConfigurationKey<FlagUsageType> REQUIRED_ARGS_CONSTRUCTOR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.requiredArgsConstructor.flagUsage", "Emit a warning or error if @RequiredArgsConstructor is used.") { // from class: lombok.ConfigurationKeys.14
    };
    public static final ConfigurationKey<FlagUsageType> DATA_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.data.flagUsage", "Emit a warning or error if @Data is used.") { // from class: lombok.ConfigurationKeys.15
    };
    public static final ConfigurationKey<FlagUsageType> VALUE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.value.flagUsage", "Emit a warning or error if @Value is used.") { // from class: lombok.ConfigurationKeys.16
    };
    public static final ConfigurationKey<FlagUsageType> GETTER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.getter.flagUsage", "Emit a warning or error if @Getter is used.") { // from class: lombok.ConfigurationKeys.17
    };
    public static final ConfigurationKey<FlagUsageType> GETTER_LAZY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.getter.lazy.flagUsage", "Emit a warning or error if @Getter(lazy=true) is used.") { // from class: lombok.ConfigurationKeys.18
    };
    public static final ConfigurationKey<Boolean> GETTER_CONSEQUENT_BOOLEAN = new ConfigurationKey<Boolean>("lombok.getter.noIsPrefix", "If true, generate and use getFieldName() for boolean getters instead of isFieldName().") { // from class: lombok.ConfigurationKeys.19
    };
    public static final ConfigurationKey<FlagUsageType> SETTER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.setter.flagUsage", "Emit a warning or error if @Setter is used.") { // from class: lombok.ConfigurationKeys.20
    };
    public static final ConfigurationKey<Boolean> EQUALS_AND_HASH_CODE_DO_NOT_USE_GETTERS = new ConfigurationKey<Boolean>("lombok.equalsAndHashCode.doNotUseGetters", "Don't call the getters but use the fields directly in the generated equals and hashCode method (default = false).") { // from class: lombok.ConfigurationKeys.21
    };
    public static final ConfigurationKey<CallSuperType> EQUALS_AND_HASH_CODE_CALL_SUPER = new ConfigurationKey<CallSuperType>("lombok.equalsAndHashCode.callSuper", "When generating equals and hashCode for classes that extend something (other than Object), either automatically take into account superclass implementation (call), or don't (skip), or warn and don't (warn). (default = warn).") { // from class: lombok.ConfigurationKeys.22
    };
    public static final ConfigurationKey<FlagUsageType> EQUALS_AND_HASH_CODE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.equalsAndHashCode.flagUsage", "Emit a warning or error if @EqualsAndHashCode is used.") { // from class: lombok.ConfigurationKeys.23
    };
    public static final ConfigurationKey<Boolean> TO_STRING_DO_NOT_USE_GETTERS = new ConfigurationKey<Boolean>("lombok.toString.doNotUseGetters", "Don't call the getters but use the fields directly in the generated toString method (default = false).") { // from class: lombok.ConfigurationKeys.24
    };
    public static final ConfigurationKey<CallSuperType> TO_STRING_CALL_SUPER = new ConfigurationKey<CallSuperType>("lombok.toString.callSuper", "When generating toString for classes that extend something (other than Object), either automatically take into account superclass implementation (call), or don't (skip), or warn and don't (warn). (default = warn).") { // from class: lombok.ConfigurationKeys.25
    };
    public static final ConfigurationKey<FlagUsageType> TO_STRING_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.toString.flagUsage", "Emit a warning or error if @ToString is used.") { // from class: lombok.ConfigurationKeys.26
    };
    public static final ConfigurationKey<Boolean> TO_STRING_INCLUDE_FIELD_NAMES = new ConfigurationKey<Boolean>("lombok.toString.includeFieldNames", "Include the field names in the generated toString method (default = true).") { // from class: lombok.ConfigurationKeys.27
    };
    public static final ConfigurationKey<String> BUILDER_CLASS_NAME = new ConfigurationKey<String>("lombok.builder.className", "Default name of the generated builder class. A * is replaced with the name of the relevant type (default = *Builder).") { // from class: lombok.ConfigurationKeys.28
    };
    public static final ConfigurationKey<FlagUsageType> BUILDER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.builder.flagUsage", "Emit a warning or error if @Builder is used.") { // from class: lombok.ConfigurationKeys.29
    };
    public static final ConfigurationKey<Boolean> SINGULAR_USE_GUAVA = new ConfigurationKey<Boolean>("lombok.singular.useGuava", "Generate backing immutable implementations for @Singular on java.util.* types by using guava's ImmutableList, etc. Normally java.util's mutable types are used and wrapped to make them immutable.") { // from class: lombok.ConfigurationKeys.30
    };
    public static final ConfigurationKey<Boolean> SINGULAR_AUTO = new ConfigurationKey<Boolean>("lombok.singular.auto", "If true (default): Automatically singularize the assumed-to-be-plural name of your variable/parameter when using @Singular.") { // from class: lombok.ConfigurationKeys.31
    };
    public static final ConfigurationKey<FlagUsageType> CLEANUP_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.cleanup.flagUsage", "Emit a warning or error if @Cleanup is used.") { // from class: lombok.ConfigurationKeys.32
    };
    public static final ConfigurationKey<FlagUsageType> DELEGATE_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.delegate.flagUsage", "Emit a warning or error if @Delegate is used.") { // from class: lombok.ConfigurationKeys.33
    };
    public static final ConfigurationKey<NullCheckExceptionType> NON_NULL_EXCEPTION_TYPE = new ConfigurationKey<NullCheckExceptionType>("lombok.nonNull.exceptionType", "The type of the exception to throw if a passed-in argument is null (Default: NullPointerException).") { // from class: lombok.ConfigurationKeys.34
    };
    public static final ConfigurationKey<FlagUsageType> NON_NULL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.nonNull.flagUsage", "Emit a warning or error if @NonNull is used.") { // from class: lombok.ConfigurationKeys.35
    };
    public static final ConfigurationKey<FlagUsageType> SNEAKY_THROWS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.sneakyThrows.flagUsage", "Emit a warning or error if @SneakyThrows is used.") { // from class: lombok.ConfigurationKeys.36
    };
    public static final ConfigurationKey<FlagUsageType> SYNCHRONIZED_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.synchronized.flagUsage", "Emit a warning or error if @Synchronized is used.") { // from class: lombok.ConfigurationKeys.37
    };
    public static final ConfigurationKey<FlagUsageType> VAL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.val.flagUsage", "Emit a warning or error if 'val' is used.") { // from class: lombok.ConfigurationKeys.38
    };
    public static final ConfigurationKey<FlagUsageType> VAR_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.var.flagUsage", "Emit a warning or error if 'var' is used.") { // from class: lombok.ConfigurationKeys.39
    };
    public static final ConfigurationKey<FlagUsageType> WITH_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.with.flagUsage", "Emit a warning or error if @With is used.") { // from class: lombok.ConfigurationKeys.40
    };
    public static final ConfigurationKey<FlagUsageType> LOG_ANY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.flagUsage", "Emit a warning or error if any of the log annotations is used.") { // from class: lombok.ConfigurationKeys.41
    };
    public static final ConfigurationKey<FlagUsageType> LOG_COMMONS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.apacheCommons.flagUsage", "Emit a warning or error if @CommonsLog is used.") { // from class: lombok.ConfigurationKeys.42
    };
    public static final ConfigurationKey<FlagUsageType> LOG_JUL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.javaUtilLogging.flagUsage", "Emit a warning or error if @Log is used.") { // from class: lombok.ConfigurationKeys.43
    };
    public static final ConfigurationKey<FlagUsageType> LOG_LOG4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.log4j.flagUsage", "Emit a warning or error if @Log4j is used.") { // from class: lombok.ConfigurationKeys.44
    };
    public static final ConfigurationKey<FlagUsageType> LOG_LOG4J2_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.log4j2.flagUsage", "Emit a warning or error if @Log4j2 is used.") { // from class: lombok.ConfigurationKeys.45
    };
    public static final ConfigurationKey<FlagUsageType> LOG_SLF4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.slf4j.flagUsage", "Emit a warning or error if @Slf4j is used.") { // from class: lombok.ConfigurationKeys.46
    };
    public static final ConfigurationKey<FlagUsageType> LOG_XSLF4J_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.xslf4j.flagUsage", "Emit a warning or error if @XSlf4j is used.") { // from class: lombok.ConfigurationKeys.47
    };
    public static final ConfigurationKey<FlagUsageType> LOG_JBOSSLOG_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.jbosslog.flagUsage", "Emit a warning or error if @JBossLog is used.") { // from class: lombok.ConfigurationKeys.48
    };
    public static final ConfigurationKey<FlagUsageType> LOG_FLOGGER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.flogger.flagUsage", "Emit a warning or error if @Flogger is used.") { // from class: lombok.ConfigurationKeys.49
    };
    public static final ConfigurationKey<IdentifierName> LOG_ANY_FIELD_NAME = new ConfigurationKey<IdentifierName>("lombok.log.fieldName", "Use this name for the generated logger fields (default: 'log').") { // from class: lombok.ConfigurationKeys.50
    };
    public static final ConfigurationKey<Boolean> LOG_ANY_FIELD_IS_STATIC = new ConfigurationKey<Boolean>("lombok.log.fieldIsStatic", "Make the generated logger fields static (default: true).") { // from class: lombok.ConfigurationKeys.51
    };
    public static final ConfigurationKey<FlagUsageType> LOG_CUSTOM_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.log.custom.flagUsage", "Emit a warning or error if @CustomLog is used.") { // from class: lombok.ConfigurationKeys.52
    };
    public static final ConfigurationKey<LogDeclaration> LOG_CUSTOM_DECLARATION = new ConfigurationKey<LogDeclaration>("lombok.log.custom.declaration", "Define the generated custom logger field.") { // from class: lombok.ConfigurationKeys.53
    };
    public static final ConfigurationKey<FlagUsageType> EXPERIMENTAL_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.experimental.flagUsage", "Emit a warning or error if an experimental feature is used.") { // from class: lombok.ConfigurationKeys.54
    };
    public static final ConfigurationKey<FlagUsageType> ACCESSORS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.accessors.flagUsage", "Emit a warning or error if @Accessors is used.") { // from class: lombok.ConfigurationKeys.55
    };
    public static final ConfigurationKey<List<String>> ACCESSORS_PREFIX = new ConfigurationKey<List<String>>("lombok.accessors.prefix", "Strip this field prefix, like 'f' or 'm_', from the names of generated getters and setters.") { // from class: lombok.ConfigurationKeys.56
    };
    public static final ConfigurationKey<Boolean> ACCESSORS_CHAIN = new ConfigurationKey<Boolean>("lombok.accessors.chain", "Generate setters that return 'this' instead of 'void' (default: false).") { // from class: lombok.ConfigurationKeys.57
    };
    public static final ConfigurationKey<Boolean> ACCESSORS_FLUENT = new ConfigurationKey<Boolean>("lombok.accessors.fluent", "Generate getters and setters using only the field name (no get/set prefix) (default: false).") { // from class: lombok.ConfigurationKeys.58
    };
    public static final ConfigurationKey<FlagUsageType> EXTENSION_METHOD_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.extensionMethod.flagUsage", "Emit a warning or error if @ExtensionMethod is used.") { // from class: lombok.ConfigurationKeys.59
    };
    public static final ConfigurationKey<Boolean> FIELD_DEFAULTS_PRIVATE_EVERYWHERE = new ConfigurationKey<Boolean>("lombok.fieldDefaults.defaultPrivate", "If true, fields without any access modifier, in any file (lombok annotated or not) are marked as private. Use @PackagePrivate or an explicit modifier to override this.") { // from class: lombok.ConfigurationKeys.60
    };
    public static final ConfigurationKey<Boolean> FIELD_DEFAULTS_FINAL_EVERYWHERE = new ConfigurationKey<Boolean>("lombok.fieldDefaults.defaultFinal", "If true, fields, in any file (lombok annotated or not) are marked as final. Use @NonFinal to override this.") { // from class: lombok.ConfigurationKeys.61
    };
    public static final ConfigurationKey<FlagUsageType> FIELD_DEFAULTS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.fieldDefaults.flagUsage", "Emit a warning or error if @FieldDefaults is used.") { // from class: lombok.ConfigurationKeys.62
    };
    public static final ConfigurationKey<FlagUsageType> HELPER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.helper.flagUsage", "Emit a warning or error if @Helper is used.") { // from class: lombok.ConfigurationKeys.63
    };
    public static final ConfigurationKey<FlagUsageType> ON_X_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.onX.flagUsage", "Emit a warning or error if onX is used.") { // from class: lombok.ConfigurationKeys.64
    };
    public static final ConfigurationKey<FlagUsageType> UTILITY_CLASS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.utilityClass.flagUsage", "Emit a warning or error if @UtilityClass is used.") { // from class: lombok.ConfigurationKeys.65
    };
    public static final ConfigurationKey<FlagUsageType> FIELD_NAME_CONSTANTS_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.fieldNameConstants.flagUsage", "Emit a warning or error if @FieldNameConstants is used.") { // from class: lombok.ConfigurationKeys.66
    };
    public static final ConfigurationKey<IdentifierName> FIELD_NAME_CONSTANTS_INNER_TYPE_NAME = new ConfigurationKey<IdentifierName>("lombok.fieldNameConstants.innerTypeName", "The default name of the inner type generated by @FieldNameConstants. (default: 'Fields').") { // from class: lombok.ConfigurationKeys.67
    };
    public static final ConfigurationKey<Boolean> FIELD_NAME_CONSTANTS_UPPERCASE = new ConfigurationKey<Boolean>("lombok.fieldNameConstants.uppercase", "The default name of the constants inside the inner type generated by @FieldNameConstants follow the variable name precisely. If this config key is true, lombok will uppercase them as best it can. (default: false).") { // from class: lombok.ConfigurationKeys.68
    };
    public static final ConfigurationKey<FlagUsageType> SUPERBUILDER_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.superBuilder.flagUsage", "Emit a warning or error if @SuperBuilder is used.") { // from class: lombok.ConfigurationKeys.69
    };
    public static final ConfigurationKey<FlagUsageType> WITHBY_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.withBy.flagUsage", "Emit a warning or error if @WithBy is used.") { // from class: lombok.ConfigurationKeys.70
    };
    public static final ConfigurationKey<FlagUsageType> JACKSONIZED_FLAG_USAGE = new ConfigurationKey<FlagUsageType>("lombok.jacksonized.flagUsage", "Emit a warning or error if @Jacksonized is used.") { // from class: lombok.ConfigurationKeys.71
    };
    public static final ConfigurationKey<Boolean> STOP_BUBBLING = new ConfigurationKey<Boolean>("config.stopBubbling", "Tell the configuration system it should stop looking for other configuration files (default: false).") { // from class: lombok.ConfigurationKeys.72
    };
    public static final ConfigurationKey<List<TypeName>> COPYABLE_ANNOTATIONS = new ConfigurationKey<List<TypeName>>("lombok.copyableAnnotations", "Copy these annotations to getters, setters, with methods, builder-setters, etc.") { // from class: lombok.ConfigurationKeys.73
    };
    public static final ConfigurationKey<CheckerFrameworkVersion> CHECKER_FRAMEWORK = new ConfigurationKey<CheckerFrameworkVersion>("checkerframework", "If set with the version of checkerframework.org (in major.minor, or just 'true' for the latest supported version), create relevant checkerframework.org annotations for code lombok generates (default: false).") { // from class: lombok.ConfigurationKeys.74
    };

    private ConfigurationKeys() {
    }
}
