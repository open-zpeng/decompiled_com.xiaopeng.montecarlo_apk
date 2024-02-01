package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargingArguments implements Serializable {
    public VehicleChargingParameter chargingVehicleParam;
    public String id;

    public ChargingArguments() {
        this.id = "";
        this.chargingVehicleParam = new VehicleChargingParameter();
    }

    public ChargingArguments(String str, VehicleChargingParameter vehicleChargingParameter) {
        this.id = str;
        this.chargingVehicleParam = vehicleChargingParameter;
    }
}
