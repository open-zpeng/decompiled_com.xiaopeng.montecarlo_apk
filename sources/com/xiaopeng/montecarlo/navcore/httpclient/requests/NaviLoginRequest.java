package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviLoginRequest {
    @SerializedName("code")
    private String mCode;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviLoginRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviLoginRequest) {
            NaviLoginRequest naviLoginRequest = (NaviLoginRequest) obj;
            if (naviLoginRequest.canEqual(this)) {
                String code = getCode();
                String code2 = naviLoginRequest.getCode();
                return code != null ? code.equals(code2) : code2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String code = getCode();
        return 59 + (code == null ? 43 : code.hashCode());
    }

    public NaviLoginRequest setCode(String str) {
        this.mCode = str;
        return this;
    }

    public String toString() {
        return "NaviLoginRequest(mCode=" + getCode() + ")";
    }

    public String getCode() {
        return this.mCode;
    }
}
