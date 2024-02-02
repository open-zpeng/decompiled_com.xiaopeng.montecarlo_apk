package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderVehicleElecCostlistSpeed implements Serializable {
    public int speed;
    public double value;

    public GRangeSpiderVehicleElecCostlistSpeed() {
        this.speed = 0;
        this.value = 0.0d;
    }

    public GRangeSpiderVehicleElecCostlistSpeed(int i, double d) {
        this.speed = i;
        this.value = d;
    }
}
