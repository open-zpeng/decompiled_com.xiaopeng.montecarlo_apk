package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsImGetLoginTokenData implements Serializable {
    public String accessToken;
    public int accessTokenExpiredTime;
    public String refreshToken;

    public WsImGetLoginTokenData() {
        this.accessToken = "";
        this.refreshToken = "";
        this.accessTokenExpiredTime = 0;
    }

    public WsImGetLoginTokenData(String str, String str2, int i) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.accessTokenExpiredTime = i;
    }
}
