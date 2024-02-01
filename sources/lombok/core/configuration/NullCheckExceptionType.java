package lombok.core.configuration;

import lombok.core.LombokImmutableList;
import lombok.core.handlers.HandlerUtil;
@ExampleValueString("[NullPointerException | IllegalArgumentException | Assertion | JDK | Guava]")
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/NullCheckExceptionType.SCL.lombok */
public enum NullCheckExceptionType {
    ILLEGAL_ARGUMENT_EXCEPTION { // from class: lombok.core.configuration.NullCheckExceptionType.1
        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return "java.lang.IllegalArgumentException";
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    },
    NULL_POINTER_EXCEPTION { // from class: lombok.core.configuration.NullCheckExceptionType.2
        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return HandlerUtil.DEFAULT_EXCEPTION_FOR_NON_NULL;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    },
    ASSERTION { // from class: lombok.core.configuration.NullCheckExceptionType.3
        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    },
    JDK { // from class: lombok.core.configuration.NullCheckExceptionType.4
        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.METHOD_JDK;
        }
    },
    GUAVA { // from class: lombok.core.configuration.NullCheckExceptionType.5
        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.METHOD_GUAVA;
        }
    };
    
    private static final LombokImmutableList<String> METHOD_JDK = LombokImmutableList.of("java", "util", "Objects", "requireNonNull");
    private static final LombokImmutableList<String> METHOD_GUAVA = LombokImmutableList.of("com", "google", "common", "base", "Preconditions", "checkNotNull", new String[0]);

    public abstract String getExceptionType();

    public abstract LombokImmutableList<String> getMethod();

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static NullCheckExceptionType[] valuesCustom() {
        NullCheckExceptionType[] valuesCustom = values();
        int length = valuesCustom.length;
        NullCheckExceptionType[] nullCheckExceptionTypeArr = new NullCheckExceptionType[length];
        System.arraycopy(valuesCustom, 0, nullCheckExceptionTypeArr, 0, length);
        return nullCheckExceptionTypeArr;
    }

    /* synthetic */ NullCheckExceptionType(NullCheckExceptionType nullCheckExceptionType) {
        this();
    }

    public String toExceptionMessage(String fieldName, String customMessage) {
        return customMessage == null ? String.valueOf(fieldName) + " is marked non-null but is null" : customMessage.replace("%s", fieldName);
    }
}
