package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMUploadFileParam implements Serializable {
    private static final long serialVersionUID = 7137000970352401736L;
    public AIMFileAuthType authType;
    public String bizType;
    public int expiredTime;
    public String mimeType;
    public String path;

    public AIMUploadFileParam(String str, String str2, String str3, AIMFileAuthType aIMFileAuthType, int i) {
        this.authType = AIMFileAuthType.STRICT_AUTH;
        this.expiredTime = 0;
        this.path = str;
        this.mimeType = str2;
        this.bizType = str3;
        if (aIMFileAuthType != null) {
            this.authType = aIMFileAuthType;
        }
        this.expiredTime = i;
    }

    public AIMUploadFileParam() {
        this.authType = AIMFileAuthType.STRICT_AUTH;
        this.expiredTime = 0;
    }

    public String getPath() {
        return this.path;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getBizType() {
        return this.bizType;
    }

    public AIMFileAuthType getAuthType() {
        return this.authType;
    }

    public int getExpiredTime() {
        return this.expiredTime;
    }

    public String toString() {
        return "AIMUploadFileParam{path=" + this.path + ",mimeType=" + this.mimeType + ",bizType=" + this.bizType + ",authType=" + this.authType + ",expiredTime=" + this.expiredTime + "}";
    }
}
