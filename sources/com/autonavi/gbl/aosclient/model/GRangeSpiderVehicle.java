package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderVehicle implements Serializable {
    public GRangeSpiderVehicleElec elec;
    public int type;

    public GRangeSpiderVehicle() {
        this.type = 0;
        this.elec = new GRangeSpiderVehicleElec();
    }

    public GRangeSpiderVehicle(int i, GRangeSpiderVehicleElec gRangeSpiderVehicleElec) {
        this.type = i;
        this.elec = gRangeSpiderVehicleElec;
    }
}
