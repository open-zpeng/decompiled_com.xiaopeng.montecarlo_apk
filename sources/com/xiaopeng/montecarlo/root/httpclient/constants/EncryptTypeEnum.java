package com.xiaopeng.montecarlo.root.httpclient.constants;
/* loaded from: classes3.dex */
public enum EncryptTypeEnum {
    XP_ENCRYPT_TYPE_NONE("0", "无数据加密"),
    XP_ENCRYPT_TYPE_IRDETO("1", "爱迪德加密"),
    XP_ENCRYPT_TYPE_TEE("2", "TEE加密"),
    G3_NO_ENCRYPTION("3", "G3无加密");
    
    String mChineseDescription;
    String mValue;

    EncryptTypeEnum(String str, String str2) {
        this.mValue = str;
        this.mChineseDescription = str2;
    }

    public String getValue() {
        return this.mValue;
    }

    public static EncryptTypeEnum parse(String str) {
        EncryptTypeEnum[] values;
        for (EncryptTypeEnum encryptTypeEnum : values()) {
            if (encryptTypeEnum.getValue().equals(str)) {
                return encryptTypeEnum;
            }
        }
        return XP_ENCRYPT_TYPE_NONE;
    }
}
