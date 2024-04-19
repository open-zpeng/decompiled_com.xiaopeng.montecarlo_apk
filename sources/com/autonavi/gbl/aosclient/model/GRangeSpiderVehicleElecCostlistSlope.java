package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderVehicleElecCostlistSlope implements Serializable {
    public double down;
    public double up;

    public GRangeSpiderVehicleElecCostlistSlope() {
        this.up = 0.0d;
        this.down = 0.0d;
    }

    public GRangeSpiderVehicleElecCostlistSlope(double d, double d2) {
        this.up = d;
        this.down = d2;
    }
}
