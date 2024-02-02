package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiAutoInitAckDatasViceCommon implements Serializable {
    public String md5;
    public String path;
    public String version;

    public WsMapapiAutoInitAckDatasViceCommon() {
        this.path = "";
        this.md5 = "";
        this.version = "";
    }

    public WsMapapiAutoInitAckDatasViceCommon(String str, String str2, String str3) {
        this.path = str;
        this.md5 = str2;
        this.version = str3;
    }
}
