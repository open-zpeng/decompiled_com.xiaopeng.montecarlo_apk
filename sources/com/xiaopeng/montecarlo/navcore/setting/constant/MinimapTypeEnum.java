package com.xiaopeng.montecarlo.navcore.setting.constant;
/* loaded from: classes3.dex */
public enum MinimapTypeEnum {
    MINIMAP_MAPMODE_3D_CAR(0, "minimap_mapmode_3d_car", "仪表地图3D车上模式"),
    MINIMAP_MAPMODE_2D_CAR(1, "minimap_mapmode_2d_car", "仪表地图2D车上模式");
    
    private String mChineseName;
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    MinimapTypeEnum(int i, String str, String str2) {
        this.mId = i;
        this.mName = str;
        this.mChineseName = str2;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static MinimapTypeEnum parse(int i) {
        MinimapTypeEnum[] values;
        for (MinimapTypeEnum minimapTypeEnum : values()) {
            if (minimapTypeEnum.getId() == i) {
                return minimapTypeEnum;
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
