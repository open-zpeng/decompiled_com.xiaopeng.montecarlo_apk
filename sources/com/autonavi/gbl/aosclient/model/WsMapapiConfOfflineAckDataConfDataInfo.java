package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiConfOfflineAckDataConfDataInfo implements Serializable {
    public String data;
    public String key;
    public String version;

    public WsMapapiConfOfflineAckDataConfDataInfo() {
        this.key = "";
        this.version = "";
        this.data = "";
    }

    public WsMapapiConfOfflineAckDataConfDataInfo(String str, String str2, String str3) {
        this.key = str;
        this.version = str2;
        this.data = str3;
    }
}
