package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarServiceEnableDataEnableError implements Serializable {
    public String code;
    public String message;
    public String sid;

    public WsAuthcarServiceEnableDataEnableError() {
        this.sid = "";
        this.code = "";
        this.message = "";
    }

    public WsAuthcarServiceEnableDataEnableError(String str, String str2, String str3) {
        this.sid = str;
        this.code = str2;
        this.message = str3;
    }
}
