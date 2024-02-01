package lombok.core.configuration;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/FlagUsageType.SCL.lombok */
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
