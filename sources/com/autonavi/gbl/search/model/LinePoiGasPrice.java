package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiGasPrice implements Serializable {
    public String gasType;
    public float price;

    public LinePoiGasPrice() {
        this.gasType = "";
        this.price = 0.0f;
    }

    public LinePoiGasPrice(String str, float f) {
        this.gasType = str;
        this.price = f;
    }
}
