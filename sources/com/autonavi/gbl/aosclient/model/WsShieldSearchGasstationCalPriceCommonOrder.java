package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceCommonOrder implements Serializable {
    public String icon;
    public WsShieldSearchGasstationCalPriceCommonOrderLog log;
    public String scheme;
    public String show_guide;
    public String text;
    public String type;

    public WsShieldSearchGasstationCalPriceCommonOrder() {
        this.icon = "";
        this.text = "";
        this.scheme = "";
        this.show_guide = "";
        this.type = "";
        this.log = new WsShieldSearchGasstationCalPriceCommonOrderLog();
    }

    public WsShieldSearchGasstationCalPriceCommonOrder(String str, String str2, String str3, String str4, String str5, WsShieldSearchGasstationCalPriceCommonOrderLog wsShieldSearchGasstationCalPriceCommonOrderLog) {
        this.icon = str;
        this.text = str2;
        this.scheme = str3;
        this.show_guide = str4;
        this.type = str5;
        this.log = wsShieldSearchGasstationCalPriceCommonOrderLog;
    }
}
