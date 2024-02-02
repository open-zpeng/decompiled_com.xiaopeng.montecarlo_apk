package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountAosResult implements Serializable {
    public int code;
    public String message;
    public String result;
    public String timestamp;
    public String version;

    public AccountAosResult() {
        this.code = 0;
        this.result = "";
        this.message = "";
        this.timestamp = "";
        this.version = "";
    }

    public AccountAosResult(int i, String str, String str2, String str3, String str4) {
        this.code = i;
        this.result = str;
        this.message = str2;
        this.timestamp = str3;
        this.version = str4;
    }
}
