package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDeviceAdiusRequestBody implements Serializable {
    public String data;
    public String key;

    public GWsDeviceAdiusRequestBody() {
        this.key = "";
        this.data = "";
    }

    public GWsDeviceAdiusRequestBody(String str, String str2) {
        this.key = str;
        this.data = str2;
    }
}
