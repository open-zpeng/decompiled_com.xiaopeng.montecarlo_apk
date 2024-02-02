package com.autonavi.gbl.ehp.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EHPInitParam implements Serializable {
    public String configPath;
    public boolean enableNoRouteSendOnInit;
    public boolean enableSimulatedNavi;

    public EHPInitParam() {
        this.configPath = "";
        this.enableSimulatedNavi = false;
        this.enableNoRouteSendOnInit = true;
    }

    public EHPInitParam(String str, boolean z, boolean z2) {
        this.configPath = str;
        this.enableSimulatedNavi = z;
        this.enableNoRouteSendOnInit = z2;
    }
}
