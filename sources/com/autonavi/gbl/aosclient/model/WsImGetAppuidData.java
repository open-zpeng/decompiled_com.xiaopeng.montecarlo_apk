package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsImGetAppuidData implements Serializable {
    public String appUid;

    public WsImGetAppuidData() {
        this.appUid = "";
    }

    public WsImGetAppuidData(String str) {
        this.appUid = str;
    }
}
