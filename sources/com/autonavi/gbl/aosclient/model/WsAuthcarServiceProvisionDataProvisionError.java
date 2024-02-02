package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarServiceProvisionDataProvisionError implements Serializable {
    public String code;
    public String message;
    public String sid;

    public WsAuthcarServiceProvisionDataProvisionError() {
        this.sid = "";
        this.code = "";
        this.message = "";
    }

    public WsAuthcarServiceProvisionDataProvisionError(String str, String str2, String str3) {
        this.sid = str;
        this.code = str2;
        this.message = str3;
    }
}
