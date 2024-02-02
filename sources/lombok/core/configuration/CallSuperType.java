package lombok.core.configuration;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/configuration/CallSuperType.SCL.lombok */
public enum CallSuperType {
    CALL,
    SKIP,
    WARN;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static CallSuperType[] valuesCustom() {
        CallSuperType[] valuesCustom = values();
        int length = valuesCustom.length;
        CallSuperType[] callSuperTypeArr = new CallSuperType[length];
        System.arraycopy(valuesCustom, 0, callSuperTypeArr, 0, length);
        return callSuperTypeArr;
    }
}
