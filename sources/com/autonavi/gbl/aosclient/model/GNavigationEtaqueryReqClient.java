package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqClient implements Serializable {
    public String div;
    public String source;
    public String uuid;

    public GNavigationEtaqueryReqClient() {
        this.uuid = "";
        this.div = "";
        this.source = "";
    }

    public GNavigationEtaqueryReqClient(String str, String str2, String str3) {
        this.uuid = str;
        this.div = str2;
        this.source = str3;
    }
}
