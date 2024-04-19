package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarTokenDataToken implements Serializable {
    public String access_token;
    public long expires_in;
    public String scope;
    public String token_type;

    public WsAuthcarTokenDataToken() {
        this.access_token = "";
        this.token_type = "";
        this.expires_in = 0L;
        this.scope = "";
    }

    public WsAuthcarTokenDataToken(String str, String str2, long j, String str3) {
        this.access_token = str;
        this.token_type = str2;
        this.expires_in = j;
        this.scope = str3;
    }
}
