package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceLogShow implements Serializable {
    public String btnId;
    public WsShieldSearchGasstationCalPriceShowConstParam constParam;

    public WsShieldSearchGasstationCalPriceLogShow() {
        this.btnId = "";
        this.constParam = new WsShieldSearchGasstationCalPriceShowConstParam();
    }

    public WsShieldSearchGasstationCalPriceLogShow(String str, WsShieldSearchGasstationCalPriceShowConstParam wsShieldSearchGasstationCalPriceShowConstParam) {
        this.btnId = str;
        this.constParam = wsShieldSearchGasstationCalPriceShowConstParam;
    }
}
