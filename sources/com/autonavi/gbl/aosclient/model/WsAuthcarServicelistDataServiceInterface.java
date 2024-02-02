package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAuthcarServicelistDataServiceInterface implements Serializable {
    public String name;
    public String url;

    public WsAuthcarServicelistDataServiceInterface() {
        this.name = "";
        this.url = "";
    }

    public WsAuthcarServicelistDataServiceInterface(String str, String str2) {
        this.name = str;
        this.url = str2;
    }
}
