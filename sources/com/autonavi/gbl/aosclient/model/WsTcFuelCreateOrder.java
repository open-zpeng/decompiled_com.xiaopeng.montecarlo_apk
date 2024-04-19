package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcFuelCreateOrder implements Serializable {
    public double priceOrder;
    public double priceOrig;
    public double serviceFee;
    public double unitPrice;

    public WsTcFuelCreateOrder() {
        this.priceOrder = 0.0d;
        this.priceOrig = 0.0d;
        this.unitPrice = 0.0d;
        this.serviceFee = 0.0d;
    }

    public WsTcFuelCreateOrder(double d, double d2, double d3, double d4) {
        this.priceOrder = d;
        this.priceOrig = d2;
        this.unitPrice = d3;
        this.serviceFee = d4;
    }
}
