package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarServiceEnableData implements Serializable {
    public String end_time;
    public String sid;
    public int status;

    public WsAuthcarServiceEnableData() {
        this.sid = "";
        this.end_time = "";
        this.status = -1;
    }

    public WsAuthcarServiceEnableData(String str, String str2, int i) {
        this.sid = str;
        this.end_time = str2;
        this.status = i;
    }
}
