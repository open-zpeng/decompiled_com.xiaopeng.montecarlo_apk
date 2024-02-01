package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiAutoInitAckDatasTbtFile implements Serializable {
    public WsMapapiAutoInitAckDatasTbtFileMd5Inner md5_inner;
    public String md5_zip;
    public String path;
    public String size;
    public String version;

    public WsMapapiAutoInitAckDatasTbtFile() {
        this.version = "";
        this.md5_inner = new WsMapapiAutoInitAckDatasTbtFileMd5Inner();
        this.path = "";
        this.md5_zip = "";
        this.size = "";
    }

    public WsMapapiAutoInitAckDatasTbtFile(String str, WsMapapiAutoInitAckDatasTbtFileMd5Inner wsMapapiAutoInitAckDatasTbtFileMd5Inner, String str2, String str3, String str4) {
        this.version = str;
        this.md5_inner = wsMapapiAutoInitAckDatasTbtFileMd5Inner;
        this.path = str2;
        this.md5_zip = str3;
        this.size = str4;
    }
}
