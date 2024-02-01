package com.xiaopeng.montecarlo.root.httpclient.constants;
/* loaded from: classes3.dex */
public enum ClientTypeEnum {
    XP_CLIENT_TYPE_WEB("0"),
    XP_CLIENT_TYPE_ANDROID("1"),
    XP_CLIENT_TYPE_IOS("2"),
    XP_CLIENT_TYPE_XMARTOS("3");
    
    String mValue;

    ClientTypeEnum(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public static ClientTypeEnum parse(String str) {
        ClientTypeEnum[] values;
        for (ClientTypeEnum clientTypeEnum : values()) {
            if (clientTypeEnum.getValue().equals(str)) {
                return clientTypeEnum;
            }
        }
        return XP_CLIENT_TYPE_XMARTOS;
    }
}
