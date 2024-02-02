package com.xiaopeng.montecarlo.root.httpclient.constants;
/* loaded from: classes2.dex */
public enum ClientEncodingTypeEnum {
    XP_CLIENT_ENCODING_NONE("None"),
    XP_CLIENT_ENCODING_GZIP_BASE64(HttpConst.XP_CLIENT_ENCODING_GZIP_BASE64),
    XP_CLIENT_ENCODING_GZIP_HEX(HttpConst.XP_CLIENT_ENCODING_GZIP_HEX),
    XP_CLIENT_ENCODING_XPZIP_BASE64(HttpConst.XP_CLIENT_ENCODING_XPZIP_BASE64),
    XP_CLIENT_ENCODING_XPZIP_HEX(HttpConst.XP_CLIENT_ENCODING_XPZIP_HEX);
    
    String mValue;

    ClientEncodingTypeEnum(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public static ClientEncodingTypeEnum parse(String str) {
        ClientEncodingTypeEnum[] values;
        for (ClientEncodingTypeEnum clientEncodingTypeEnum : values()) {
            if (clientEncodingTypeEnum.getValue().equals(str)) {
                return clientEncodingTypeEnum;
            }
        }
        return XP_CLIENT_ENCODING_NONE;
    }
}
