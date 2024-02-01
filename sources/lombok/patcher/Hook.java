package lombok.patcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/Hook.SCL.lombok */
public class Hook {
    private final String className;
    private final String methodName;
    private final String returnType;
    private final List<String> parameterTypes;
    private static final Map<String, String> PRIMITIVES;

    public Hook(String className, String methodName, String returnType, String... parameterTypes) {
        if (className == null) {
            throw new NullPointerException("classSpec");
        }
        if (methodName == null) {
            throw new NullPointerException("methodName");
        }
        if (returnType == null) {
            throw new NullPointerException("returnType");
        }
        if (parameterTypes == null) {
            throw new NullPointerException("parameterTypes");
        }
        this.className = className;
        this.methodName = methodName;
        this.returnType = returnType;
        List<String> params = new ArrayList<>();
        for (String param : parameterTypes) {
            params.add(param);
        }
        this.parameterTypes = Collections.unmodifiableList(params);
    }

    public boolean isConstructor() {
        return "<init>".equals(this.methodName);
    }

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public List<String> getParameterTypes() {
        return this.parameterTypes;
    }

    public String getClassSpec() {
        return convertType(this.className);
    }

    public String getMethodDescriptor() {
        StringBuilder out = new StringBuilder();
        out.append("(");
        for (String p : this.parameterTypes) {
            out.append(toSpec(p));
        }
        out.append(")");
        out.append(toSpec(this.returnType));
        return out.toString();
    }

    static {
        Map<String, String> m = new HashMap<>();
        m.put("int", "I");
        m.put("long", "J");
        m.put("short", "S");
        m.put("byte", ICarService.CAR_STAGE_B);
        m.put("char", ICarService.CAR_STAGE_C);
        m.put("double", ICarService.CAR_STAGE_D);
        m.put(TypedValues.Custom.S_FLOAT, ICarService.CAR_STAGE_F);
        m.put("void", "V");
        m.put(TypedValues.Custom.S_BOOLEAN, "Z");
        PRIMITIVES = Collections.unmodifiableMap(m);
    }

    public static String toSpec(String type) {
        StringBuilder out = new StringBuilder();
        while (type.endsWith("[]")) {
            type = type.substring(0, type.length() - 2);
            out.append("[");
        }
        String p = PRIMITIVES.get(type);
        if (p != null) {
            out.append(p);
            return out.toString();
        }
        out.append("L");
        out.append(convertType(type));
        out.append(';');
        return out.toString();
    }

    public static String convertType(String type) {
        String[] split;
        StringBuilder out = new StringBuilder();
        for (String part : type.split("\\.")) {
            if (out.length() > 0) {
                out.append('/');
            }
            out.append(part);
        }
        return out.toString();
    }

    public int hashCode() {
        int result = (31 * 1) + (this.className == null ? 0 : this.className.hashCode());
        return (31 * ((31 * ((31 * result) + (this.methodName == null ? 0 : this.methodName.hashCode()))) + (this.parameterTypes == null ? 0 : this.parameterTypes.hashCode()))) + (this.returnType == null ? 0 : this.returnType.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Hook other = (Hook) obj;
            if (this.className == null) {
                if (other.className != null) {
                    return false;
                }
            } else if (!this.className.equals(other.className)) {
                return false;
            }
            if (this.methodName == null) {
                if (other.methodName != null) {
                    return false;
                }
            } else if (!this.methodName.equals(other.methodName)) {
                return false;
            }
            if (this.parameterTypes == null) {
                if (other.parameterTypes != null) {
                    return false;
                }
            } else if (!this.parameterTypes.equals(other.parameterTypes)) {
                return false;
            }
            return this.returnType == null ? other.returnType == null : this.returnType.equals(other.returnType);
        }
        return false;
    }

    public String toString() {
        return "Hook [className=" + this.className + ", methodName=" + this.methodName + ", returnType=" + this.returnType + ", parameterTypes=" + this.parameterTypes + "]";
    }
}
