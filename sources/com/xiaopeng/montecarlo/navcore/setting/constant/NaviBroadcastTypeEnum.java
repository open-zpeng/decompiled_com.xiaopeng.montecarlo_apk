package com.xiaopeng.montecarlo.navcore.setting.constant;
/* loaded from: classes2.dex */
public enum NaviBroadcastTypeEnum {
    NAVI_DETAIL_BROADCAST(0, "navi_detail_broadcast", "详细播报"),
    NAVI_NORMAL_BROADCAST(1, "navi_normal_broadcast", "一般播报"),
    NAVI_SIMPLE_BROADCAST(2, "navi_simple_broadcast", "超简洁播报");
    
    private String mChineseName;
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    NaviBroadcastTypeEnum(int i, String str, String str2) {
        this.mId = i;
        this.mName = str;
        this.mChineseName = str2;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static NaviBroadcastTypeEnum parse(int i) {
        NaviBroadcastTypeEnum[] values;
        for (NaviBroadcastTypeEnum naviBroadcastTypeEnum : values()) {
            if (naviBroadcastTypeEnum.getId() == i) {
                return naviBroadcastTypeEnum;
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
