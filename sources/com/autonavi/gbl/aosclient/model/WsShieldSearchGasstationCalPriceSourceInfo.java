package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceSourceInfo implements Serializable {
    public String desc;
    public String from;

    public WsShieldSearchGasstationCalPriceSourceInfo() {
        this.from = "";
        this.desc = "";
    }

    public WsShieldSearchGasstationCalPriceSourceInfo(String str, String str2) {
        this.from = str;
        this.desc = str2;
    }
}
