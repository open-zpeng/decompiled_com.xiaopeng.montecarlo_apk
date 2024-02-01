package com.autonavi.gbl.ehp.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EHPInitParam implements Serializable {
    public String address;
    @Deprecated
    public String configPath;
    public boolean enableNoRouteSendOnInit;
    public boolean enableSimulatedNavi;
    public int port;

    public EHPInitParam() {
        this.configPath = "";
        this.enableSimulatedNavi = false;
        this.enableNoRouteSendOnInit = true;
        this.address = "";
        this.port = 0;
    }

    public EHPInitParam(String str, boolean z, boolean z2, String str2, int i) {
        this.configPath = str;
        this.enableSimulatedNavi = z;
        this.enableNoRouteSendOnInit = z2;
        this.address = str2;
        this.port = i;
    }
}
