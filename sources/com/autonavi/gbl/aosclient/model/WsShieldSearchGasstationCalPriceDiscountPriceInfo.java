package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceDiscountPriceInfo implements Serializable {
    public String price;
    public String text;

    public WsShieldSearchGasstationCalPriceDiscountPriceInfo() {
        this.price = "";
        this.text = "";
    }

    public WsShieldSearchGasstationCalPriceDiscountPriceInfo(String str, String str2) {
        this.price = str;
        this.text = str2;
    }
}
