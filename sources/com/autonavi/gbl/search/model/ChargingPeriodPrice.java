package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ChargingPeriodPrice implements Serializable {
    public double elePrice;
    public double serPrice;
    public String time;

    public ChargingPeriodPrice() {
        this.elePrice = 0.0d;
        this.serPrice = 0.0d;
        this.time = "";
    }

    public ChargingPeriodPrice(double d, double d2, String str) {
        this.elePrice = d;
        this.serPrice = d2;
        this.time = str;
    }
}
