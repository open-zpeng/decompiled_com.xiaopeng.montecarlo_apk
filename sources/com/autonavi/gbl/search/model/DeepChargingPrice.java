package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepChargingPrice implements Serializable {
    public String ele_price;
    public String ser_price;
    public String time;

    public DeepChargingPrice() {
        this.time = "";
        this.ele_price = "";
        this.ser_price = "";
    }

    public DeepChargingPrice(String str, String str2, String str3) {
        this.time = str;
        this.ele_price = str2;
        this.ser_price = str3;
    }
}
