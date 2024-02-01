package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingMetaToast implements Serializable {
    public String message;
    public int show;

    public WsShieldSearchRanklist_landingMetaToast() {
        this.show = 0;
        this.message = "";
    }

    public WsShieldSearchRanklist_landingMetaToast(int i, String str) {
        this.show = i;
        this.message = str;
    }
}
