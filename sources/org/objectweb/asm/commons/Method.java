package org.objectweb.asm.commons;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.Type;
/* loaded from: xp_Montecarlo-benchDavid55.apk:org/objectweb/asm/commons/Method.SCL.lombok */
public class Method {
    private final String name;
    private final String descriptor;
    private static final Map<String, String> PRIMITIVE_TYPE_DESCRIPTORS;

    static {
        HashMap<String, String> descriptors = new HashMap<>();
        descriptors.put("void", "V");
        descriptors.put("byte", ICarService.CAR_STAGE_B);
        descriptors.put("char", ICarService.CAR_STAGE_C);
        descriptors.put("double", ICarService.CAR_STAGE_D);
        descriptors.put(TypedValues.Custom.S_FLOAT, ICarService.CAR_STAGE_F);
        descriptors.put("int", "I");
        descriptors.put("long", "J");
        descriptors.put("short", "S");
        descriptors.put(TypedValues.Custom.S_BOOLEAN, "Z");
        PRIMITIVE_TYPE_DESCRIPTORS = descriptors;
    }

    public Method(String name, String descriptor) {
        this.name = name;
        this.descriptor = descriptor;
    }

    public Method(String name, Type returnType, Type[] argumentTypes) {
        this(name, Type.getMethodDescriptor(returnType, argumentTypes));
    }

    public static Method getMethod(java.lang.reflect.Method method) {
        return new Method(method.getName(), Type.getMethodDescriptor(method));
    }

    public static Method getMethod(Constructor<?> constructor) {
        return new Method("<init>", Type.getConstructorDescriptor(constructor));
    }

    public static Method getMethod(String method) {
        return getMethod(method, false);
    }

    public static Method getMethod(String method, boolean defaultPackage) {
        int currentArgumentEndIndex;
        String argumentDescriptor;
        int spaceIndex = method.indexOf(32);
        int currentArgumentStartIndex = method.indexOf(40, spaceIndex) + 1;
        int endIndex = method.indexOf(41, currentArgumentStartIndex);
        if (spaceIndex == -1 || currentArgumentStartIndex == 0 || endIndex == -1) {
            throw new IllegalArgumentException();
        }
        String returnType = method.substring(0, spaceIndex);
        String methodName = method.substring(spaceIndex + 1, currentArgumentStartIndex - 1).trim();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        do {
            currentArgumentEndIndex = method.indexOf(44, currentArgumentStartIndex);
            if (currentArgumentEndIndex == -1) {
                argumentDescriptor = getDescriptorInternal(method.substring(currentArgumentStartIndex, endIndex).trim(), defaultPackage);
            } else {
                argumentDescriptor = getDescriptorInternal(method.substring(currentArgumentStartIndex, currentArgumentEndIndex).trim(), defaultPackage);
                currentArgumentStartIndex = currentArgumentEndIndex + 1;
            }
            stringBuilder.append(argumentDescriptor);
        } while (currentArgumentEndIndex != -1);
        stringBuilder.append(')').append(getDescriptorInternal(returnType, defaultPackage));
        return new Method(methodName, stringBuilder.toString());
    }

    private static String getDescriptorInternal(String type, boolean defaultPackage) {
        if ("".equals(type)) {
            return type;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int arrayBracketsIndex = 0;
        while (true) {
            int indexOf = type.indexOf("[]", arrayBracketsIndex) + 1;
            arrayBracketsIndex = indexOf;
            if (indexOf <= 0) {
                break;
            }
            stringBuilder.append('[');
        }
        String elementType = type.substring(0, type.length() - (stringBuilder.length() * 2));
        String descriptor = PRIMITIVE_TYPE_DESCRIPTORS.get(elementType);
        if (descriptor != null) {
            stringBuilder.append(descriptor);
        } else {
            stringBuilder.append('L');
            if (elementType.indexOf(46) < 0) {
                if (!defaultPackage) {
                    stringBuilder.append("java/lang/");
                }
                stringBuilder.append(elementType);
            } else {
                stringBuilder.append(elementType.replace('.', '/'));
            }
            stringBuilder.append(';');
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return this.name;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public Type getReturnType() {
        return Type.getReturnType(this.descriptor);
    }

    public Type[] getArgumentTypes() {
        return Type.getArgumentTypes(this.descriptor);
    }

    public String toString() {
        return this.name + this.descriptor;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Method)) {
            return false;
        }
        Method otherMethod = (Method) other;
        return this.name.equals(otherMethod.name) && this.descriptor.equals(otherMethod.descriptor);
    }

    public int hashCode() {
        return this.name.hashCode() ^ this.descriptor.hashCode();
    }
}
