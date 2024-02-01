package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMAuthToken implements Serializable {
    private static final long serialVersionUID = 1291971559805740902L;
    public String accessToken;
    public String refreshToken;

    public AIMAuthToken(String str, String str2) {
        this.accessToken = str;
        this.refreshToken = str2;
    }

    public AIMAuthToken() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String toString() {
        return "AIMAuthToken{accessToken=" + this.accessToken + ",refreshToken=" + this.refreshToken + "}";
    }
}
