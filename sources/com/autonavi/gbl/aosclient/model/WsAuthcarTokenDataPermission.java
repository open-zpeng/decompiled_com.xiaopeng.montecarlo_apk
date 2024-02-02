package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarTokenDataPermission implements Serializable {
    public String description;
    public String end_time;
    public String sid;
    public int status;
    public long time_left_ms;

    public WsAuthcarTokenDataPermission() {
        this.sid = "";
        this.end_time = "";
        this.time_left_ms = 0L;
        this.status = 0;
        this.description = "";
    }

    public WsAuthcarTokenDataPermission(String str, String str2, long j, int i, String str3) {
        this.sid = str;
        this.end_time = str2;
        this.time_left_ms = j;
        this.status = i;
        this.description = str3;
    }
}
