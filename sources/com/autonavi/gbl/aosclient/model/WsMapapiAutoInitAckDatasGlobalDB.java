package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiAutoInitAckDatasGlobalDB implements Serializable {
    public String dataformat;
    public String md5;
    public String path;
    public String size;
    public String version;

    public WsMapapiAutoInitAckDatasGlobalDB() {
        this.size = "";
        this.path = "";
        this.dataformat = "";
        this.version = "";
        this.md5 = "";
    }

    public WsMapapiAutoInitAckDatasGlobalDB(String str, String str2, String str3, String str4, String str5) {
        this.size = str;
        this.path = str2;
        this.dataformat = str3;
        this.version = str4;
        this.md5 = str5;
    }
}
