package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalMetaToast implements Serializable {
    public String message;
    public int show;

    public WsShieldSearchRanklistPortalMetaToast() {
        this.show = 0;
        this.message = "";
    }

    public WsShieldSearchRanklistPortalMetaToast(int i, String str) {
        this.show = i;
        this.message = str;
    }
}
