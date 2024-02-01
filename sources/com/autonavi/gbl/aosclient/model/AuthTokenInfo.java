package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AuthTokenInfo implements Serializable {
    public int errorCode;
    public String sid;
    public String sid_name;
    public int status;
    public String url;
    public String url_name;

    public AuthTokenInfo() {
        this.sid = "";
        this.sid_name = "";
        this.url_name = "";
        this.url = "";
        this.errorCode = -1;
        this.status = -1;
    }

    public AuthTokenInfo(String str, String str2, String str3, String str4, int i, int i2) {
        this.sid = str;
        this.sid_name = str2;
        this.url_name = str3;
        this.url = str4;
        this.errorCode = i;
        this.status = i2;
    }
}
