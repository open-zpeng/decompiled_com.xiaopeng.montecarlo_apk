package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMError implements Serializable {
    private static final long serialVersionUID = -8353506546816417051L;
    public int code;
    public String developerMessage;
    public AIMErrDomain domain;
    public String extraInfo;
    public String reason;
    public String scope;

    public AIMError(AIMErrDomain aIMErrDomain, int i, String str, String str2, String str3, String str4) {
        this.domain = AIMErrDomain.AIM_ERR_DOMAIN_CLIENT;
        this.code = 0;
        if (aIMErrDomain != null) {
            this.domain = aIMErrDomain;
        }
        this.code = i;
        this.developerMessage = str;
        this.reason = str2;
        this.extraInfo = str3;
        this.scope = str4;
    }

    public AIMError() {
        this.domain = AIMErrDomain.AIM_ERR_DOMAIN_CLIENT;
        this.code = 0;
    }

    public AIMErrDomain getDomain() {
        return this.domain;
    }

    public int getCode() {
        return this.code;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public String getReason() {
        return this.reason;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getScope() {
        return this.scope;
    }

    public String toString() {
        return "AIMError{domain=" + this.domain + ",code=" + this.code + ",developerMessage=" + this.developerMessage + ",reason=" + this.reason + ",extraInfo=" + this.extraInfo + ",scope=" + this.scope + "}";
    }
}
