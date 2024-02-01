package lombok.patcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.autonavi.gbl.guide.model.RangeType;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/MethodTarget.SCL.lombok */
public final class MethodTarget implements TargetMatcher {
    private final String classSpec;
    private final String methodName;
    private final String returnSpec;
    private final List<String> parameterSpec;
    private boolean hasDescription;
    private static final String JVM_TYPE_SPEC = "\\[*(?:[BCDFIJSZ]|L[^;]+;)";
    private static final Pattern PARAM_SPEC = Pattern.compile(JVM_TYPE_SPEC);
    private static final Pattern COMPLETE_SPEC = Pattern.compile("^\\(((?:\\[*(?:[BCDFIJSZ]|L[^;]+;))*)\\)(V|\\[*(?:[BCDFIJSZ]|L[^;]+;))$");
    private static final Pattern BRACE_PAIRS = Pattern.compile("^(?:\\[\\])*$");

    @Override // lombok.patcher.TargetMatcher
    public String describe() {
        int sci1 = this.classSpec.lastIndexOf(46);
        int sci2 = this.classSpec.lastIndexOf(36);
        int sci3 = this.classSpec.lastIndexOf(47);
        int sci = sci1 > sci2 ? sci1 : sci2;
        if (sci < sci3) {
            sci = sci3;
        }
        return String.valueOf(sci == -1 ? this.classSpec : this.classSpec.substring(sci + 1)) + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + this.methodName;
    }

    public String getClassSpec() {
        return this.classSpec;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getReturnSpec() {
        return this.returnSpec;
    }

    public List<String> getParameterSpec() {
        return this.parameterSpec;
    }

    public boolean isHasDescription() {
        return this.hasDescription;
    }

    public MethodTarget(String classSpec, String methodName) {
        this(classSpec, methodName, false, null, null);
    }

    public MethodTarget(String classSpec, String methodName, String returnSpec, String... parameterSpecs) {
        this(classSpec, methodName, true, returnSpec, parameterSpecs);
    }

    public Boolean returnTypeIsVoid() {
        if (this.hasDescription) {
            return Boolean.valueOf(this.returnSpec.equals("void"));
        }
        return null;
    }

    private MethodTarget(String classSpec, String methodName, boolean hasDescription, String returnSpec, String[] parameterSpecs) {
        if (classSpec == null) {
            throw new NullPointerException("classSpec");
        }
        if (methodName == null) {
            throw new NullPointerException("methodName");
        }
        if (hasDescription && returnSpec == null) {
            throw new NullPointerException("returnSpec");
        }
        if (hasDescription && parameterSpecs == null) {
            throw new NullPointerException("parameterSpecs");
        }
        if (methodName.contains("[") || methodName.contains(".")) {
            throw new IllegalArgumentException("Your method name contained dots or braces. Perhaps you switched return type and method name around?");
        }
        this.hasDescription = hasDescription;
        this.classSpec = classSpec;
        this.methodName = methodName;
        this.returnSpec = returnSpec;
        this.parameterSpec = parameterSpecs == null ? null : Collections.unmodifiableList(Arrays.asList(parameterSpecs));
    }

    public static List<String> decomposeFullDesc(String desc) {
        Matcher descMatcher = COMPLETE_SPEC.matcher(desc);
        if (descMatcher.matches()) {
            List<String> out = new ArrayList<>();
            out.add(descMatcher.group(2));
            Matcher paramMatcher = PARAM_SPEC.matcher(descMatcher.group(1));
            while (paramMatcher.find()) {
                out.add(paramMatcher.group(0));
            }
            return out;
        }
        throw new IllegalArgumentException("This isn't a valid spec: " + desc);
    }

    public boolean classMatches(String classSpec) {
        return typeMatches(classSpec, this.classSpec);
    }

    @Override // lombok.patcher.TargetMatcher
    public Collection<String> getAffectedClasses() {
        return Collections.singleton(this.classSpec);
    }

    @Override // lombok.patcher.TargetMatcher
    public boolean matches(String classSpec, String methodName, String descriptor) {
        if (methodName.equals(this.methodName) && classMatches(classSpec)) {
            return descriptorMatch(descriptor);
        }
        return false;
    }

    private boolean descriptorMatch(String descriptor) {
        if (this.returnSpec == null) {
            return true;
        }
        Iterator<String> targetSpecs = decomposeFullDesc(descriptor).iterator();
        if (typeSpecMatch(targetSpecs.next(), this.returnSpec)) {
            Iterator<String> patternSpecs = this.parameterSpec.iterator();
            while (targetSpecs.hasNext() && patternSpecs.hasNext()) {
                if (!typeSpecMatch(targetSpecs.next(), patternSpecs.next())) {
                    return false;
                }
            }
            return (targetSpecs.hasNext() || patternSpecs.hasNext()) ? false : true;
        }
        return false;
    }

    public static boolean typeSpecMatch(String type, String pattern) {
        if (type.equals("V")) {
            return pattern.equals("void");
        }
        int dimsInType = 0;
        while (dimsInType < type.length() && type.charAt(dimsInType) == '[') {
            dimsInType++;
        }
        String type2 = type.substring(dimsInType);
        int start = pattern.length() - (dimsInType * 2);
        if (start < 0) {
            return false;
        }
        String braces = pattern.substring(start);
        if (BRACE_PAIRS.matcher(braces).matches()) {
            String pattern2 = pattern.substring(0, start);
            switch (type2.charAt(0)) {
                case 'B':
                    return pattern2.equals("byte");
                case 'C':
                    return pattern2.equals("char");
                case 'D':
                    return pattern2.equals("double");
                case 'F':
                    return pattern2.equals(TypedValues.Custom.S_FLOAT);
                case 'I':
                    return pattern2.equals("int");
                case 'J':
                    return pattern2.equals("long");
                case 'L':
                    return typeMatches(type2.substring(1, type2.length() - 1), pattern2);
                case 'S':
                    return pattern2.equals("short");
                case 'Z':
                    return pattern2.equals(TypedValues.Custom.S_BOOLEAN);
                default:
                    return false;
            }
        }
        return false;
    }

    public static boolean typeMatches(String type, String pattern) {
        return type.replace(MqttTopic.TOPIC_LEVEL_SEPARATOR, ".").equals(pattern);
    }

    public int hashCode() {
        int result = (31 * 1) + (this.classSpec == null ? 0 : this.classSpec.hashCode());
        return (31 * ((31 * ((31 * ((31 * result) + (this.hasDescription ? RangeType.RANGETYPE_CAMERA_SPEED_PROMPT : 1237))) + (this.methodName == null ? 0 : this.methodName.hashCode()))) + (this.parameterSpec == null ? 0 : this.parameterSpec.hashCode()))) + (this.returnSpec == null ? 0 : this.returnSpec.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MethodTarget other = (MethodTarget) obj;
            if (this.classSpec == null) {
                if (other.classSpec != null) {
                    return false;
                }
            } else if (!this.classSpec.equals(other.classSpec)) {
                return false;
            }
            if (this.hasDescription != other.hasDescription) {
                return false;
            }
            if (this.methodName == null) {
                if (other.methodName != null) {
                    return false;
                }
            } else if (!this.methodName.equals(other.methodName)) {
                return false;
            }
            if (this.parameterSpec == null) {
                if (other.parameterSpec != null) {
                    return false;
                }
            } else if (!this.parameterSpec.equals(other.parameterSpec)) {
                return false;
            }
            return this.returnSpec == null ? other.returnSpec == null : this.returnSpec.equals(other.returnSpec);
        }
        return false;
    }

    public String toString() {
        return "MethodTarget[classSpec=" + this.classSpec + ", methodName=" + this.methodName + ", returnSpec=" + this.returnSpec + ", parameterSpec=" + this.parameterSpec + ", hasDescription=" + this.hasDescription + "]";
    }
}
