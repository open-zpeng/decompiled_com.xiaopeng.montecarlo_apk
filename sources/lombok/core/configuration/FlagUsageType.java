package lombok.core.configuration;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/configuration/FlagUsageType.SCL.lombok */
public enum FlagUsageType {
    WARNING,
    ERROR,
    ALLOW;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static FlagUsageType[] valuesCustom() {
        FlagUsageType[] valuesCustom = values();
        int length = valuesCustom.length;
        FlagUsageType[] flagUsageTypeArr = new FlagUsageType[length];
        System.arraycopy(valuesCustom, 0, flagUsageTypeArr, 0, length);
        return flagUsageTypeArr;
    }
}
