package com.xiaopeng.montecarlo.navcore.download.constant;
/* loaded from: classes2.dex */
public enum CityTypeEnum {
    CITY_TYPE_CURRENT_CITY(1, "CURRENT_CITY", "当前城市"),
    CITY_TYPE_NEARBY_CITY(2, "NEARBY_CITY", "附近城市"),
    CITY_TYPE_NORMAL_CITY(3, "NORMAL_CITY", "城市"),
    CITY_TYPE_BASE_CITY(4, "BASE_CITY", "全国基础包");
    
    private String mChineseName;
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    CityTypeEnum(int i, String str, String str2) {
        this.mId = i;
        this.mName = str;
        this.mChineseName = str2;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static CityTypeEnum parse(int i) {
        CityTypeEnum[] values;
        for (CityTypeEnum cityTypeEnum : values()) {
            if (cityTypeEnum.getId() == i) {
                return cityTypeEnum;
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
