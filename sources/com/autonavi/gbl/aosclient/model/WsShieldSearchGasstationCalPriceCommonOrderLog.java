package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceCommonOrderLog implements Serializable {
    public WsShieldSearchGasstationCalPriceLogShow click;
    public WsShieldSearchGasstationCalPriceLogShow show;

    public WsShieldSearchGasstationCalPriceCommonOrderLog() {
        this.show = new WsShieldSearchGasstationCalPriceLogShow();
        this.click = new WsShieldSearchGasstationCalPriceLogShow();
    }

    public WsShieldSearchGasstationCalPriceCommonOrderLog(WsShieldSearchGasstationCalPriceLogShow wsShieldSearchGasstationCalPriceLogShow, WsShieldSearchGasstationCalPriceLogShow wsShieldSearchGasstationCalPriceLogShow2) {
        this.show = wsShieldSearchGasstationCalPriceLogShow;
        this.click = wsShieldSearchGasstationCalPriceLogShow2;
    }
}
