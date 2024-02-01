package lombok.core.configuration;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/ConfigurationDataType.SCL.lombok */
public final class ConfigurationDataType {
    private static final Map<Class<?>, ConfigurationValueParser> SIMPLE_TYPES;
    private final boolean isList;
    private final ConfigurationValueParser parser;

    static {
        Map<Class<?>, ConfigurationValueParser> map = new HashMap<>();
        map.put(String.class, new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.1
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return value;
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return TypedValues.Custom.S_STRING;
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return "<text>";
            }
        });
        map.put(Integer.class, new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.2
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return Integer.valueOf(Integer.parseInt(value));
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return "int";
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return "<int>";
            }
        });
        map.put(Long.class, new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.3
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return Long.valueOf(Long.parseLong(value));
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return "long";
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return "<long>";
            }
        });
        map.put(Double.class, new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.4
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return Double.valueOf(Double.parseDouble(value));
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return "double";
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return "<double>";
            }
        });
        map.put(Boolean.class, new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.5
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return Boolean.valueOf(Boolean.parseBoolean(value));
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return TypedValues.Custom.S_BOOLEAN;
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return "[false | true]";
            }
        });
        SIMPLE_TYPES = map;
    }

    private static ConfigurationValueParser enumParser(Type enumType) {
        final Class<?> type = (Class) enumType;
        return new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.6
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                try {
                    return Enum.valueOf(type, value);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < value.length(); i++) {
                        char c = value.charAt(i);
                        if (Character.isUpperCase(c) && i > 0) {
                            sb.append(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT);
                        }
                        sb.append(Character.toUpperCase(c));
                    }
                    return Enum.valueOf(type, sb.toString());
                }
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return "enum (" + type.getName() + ")";
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                ExampleValueString evs = (ExampleValueString) type.getAnnotation(ExampleValueString.class);
                return evs != null ? evs.value() : Arrays.toString(type.getEnumConstants()).replace(",", " |");
            }
        };
    }

    private static ConfigurationValueParser valueTypeParser(Type argumentType) {
        Class<?> type = (Class) argumentType;
        final Method valueOfMethod = getMethod(type, "valueOf", String.class);
        final Method descriptionMethod = getMethod(type, "description", new Class[0]);
        final Method exampleValueMethod = getMethod(type, "exampleValue", new Class[0]);
        return new ConfigurationValueParser() { // from class: lombok.core.configuration.ConfigurationDataType.7
            @Override // lombok.core.configuration.ConfigurationValueParser
            public Object parse(String value) {
                return invokeStaticMethod(valueOfMethod, value);
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String description() {
                return (String) invokeStaticMethod(descriptionMethod, new Object[0]);
            }

            @Override // lombok.core.configuration.ConfigurationValueParser
            public String exampleValue() {
                return (String) invokeStaticMethod(exampleValueMethod, new Object[0]);
            }

            private <R> R invokeStaticMethod(Method method, Object... arguments) {
                try {
                    return (R) method.invoke(null, arguments);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("The method " + method.getName() + " ", e);
                } catch (InvocationTargetException e2) {
                    throw ((RuntimeException) e2.getTargetException());
                }
            }
        };
    }

    public static ConfigurationDataType toDataType(Class<? extends ConfigurationKey<?>> keyClass) {
        if (keyClass.getSuperclass() != ConfigurationKey.class) {
            throw new IllegalArgumentException("No direct subclass of ConfigurationKey: " + keyClass.getName());
        }
        Type type = keyClass.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Missing type parameter in " + type);
        }
        ParameterizedType parameterized = (ParameterizedType) type;
        Type argumentType = parameterized.getActualTypeArguments()[0];
        boolean isList = false;
        if (argumentType instanceof ParameterizedType) {
            ParameterizedType parameterizedArgument = (ParameterizedType) argumentType;
            if (parameterizedArgument.getRawType() == List.class) {
                isList = true;
                argumentType = parameterizedArgument.getActualTypeArguments()[0];
            }
        }
        if (SIMPLE_TYPES.containsKey(argumentType)) {
            return new ConfigurationDataType(isList, SIMPLE_TYPES.get(argumentType));
        }
        if (isEnum(argumentType)) {
            return new ConfigurationDataType(isList, enumParser(argumentType));
        }
        if (isConfigurationValueType(argumentType)) {
            return new ConfigurationDataType(isList, valueTypeParser(argumentType));
        }
        throw new IllegalArgumentException("Unsupported type parameter in " + type);
    }

    private ConfigurationDataType(boolean isList, ConfigurationValueParser parser) {
        this.isList = isList;
        this.parser = parser;
    }

    public boolean isList() {
        return this.isList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurationValueParser getParser() {
        return this.parser;
    }

    public String toString() {
        return this.isList ? "list of " + this.parser.description() : this.parser.description();
    }

    private static boolean isEnum(Type argumentType) {
        return (argumentType instanceof Class) && ((Class) argumentType).isEnum();
    }

    private static boolean isConfigurationValueType(Type argumentType) {
        return (argumentType instanceof Class) && ConfigurationValueType.class.isAssignableFrom((Class) argumentType);
    }

    private static Method getMethod(Class<?> argumentType, String name, Class<?>... clsArr) {
        try {
            return argumentType.getMethod(name, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method " + name + " with parameters " + Arrays.toString(clsArr) + " was not found.", e);
        } catch (SecurityException e2) {
            throw new IllegalStateException("Cannot inspect methods of type " + argumentType, e2);
        }
    }
}
