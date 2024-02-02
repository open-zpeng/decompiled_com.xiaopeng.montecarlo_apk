package com.xiaopeng.montecarlo.navcore.download.constant;
/* loaded from: classes2.dex */
public enum ProvinceTypeEnum {
    PROVINCE_TYPE_PROVINCE(1, "PROVINCE", "省"),
    PROVINCE_TYPE_DIRECT_CITY(2, "DIRECT_CITY", "直辖市"),
    PROVINCE_TYPE_NEARBY_CITY(3, "NEARBY_CITY", "附近城市"),
    PROVINCE_TYPE_SPECIAL_CITY(4, "SPECIAL_CITY", "特别行政区");
    
    private String mChineseName;
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    ProvinceTypeEnum(int i, String str, String str2) {
        this.mId = i;
        this.mName = str;
        this.mChineseName = str2;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static ProvinceTypeEnum parse(int i) {
        ProvinceTypeEnum[] values;
        for (ProvinceTypeEnum provinceTypeEnum : values()) {
            if (provinceTypeEnum.getId() == i) {
                return provinceTypeEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }

    public String getChineseName() {
        return this.mChineseName;
    }
}
