package com.xiaopeng.montecarlo.root.httpclient.constants;

import com.xiaopeng.montecarlo.root.util.GsonEnum;
/* loaded from: classes2.dex */
public enum RemoteServiceNameEnum implements GsonEnum<RemoteServiceNameEnum> {
    SERVICE_MAP_NAVI_SERVER("xp-navigation-boot"),
    SERVICE_XP_CHARGE_SEARCH("xp-charge-station-search-boot"),
    SERVICE_CHARGE("xp-search-boot"),
    SERVICE_CHARGE_STATION("xp-charge-boot"),
    SERVICE_ASSISTANT("xp-assistant-boot"),
    SERVICE_XP_XUI("xp-xui-boot"),
    SERVICE_XP_BIZ("xp-biz-boot");
    
    String mValue;

    RemoteServiceNameEnum(String str) {
        this.mValue = str;
    }

    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public String getValue() {
        return this.mValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.root.util.GsonEnum
    public RemoteServiceNameEnum parse(String str) {
        RemoteServiceNameEnum[] values;
        for (RemoteServiceNameEnum remoteServiceNameEnum : values()) {
            if (remoteServiceNameEnum.getValue().equals(str)) {
                return remoteServiceNameEnum;
            }
        }
        return null;
    }
}
