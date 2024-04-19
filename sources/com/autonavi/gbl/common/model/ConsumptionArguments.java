package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ConsumptionArguments implements Serializable {
    public VehicleChargingParameter chargingVehicleParam;
    public String id;

    public ConsumptionArguments() {
        this.id = "";
        this.chargingVehicleParam = new VehicleChargingParameter();
    }

    public ConsumptionArguments(String str, VehicleChargingParameter vehicleChargingParameter) {
        this.id = str;
        this.chargingVehicleParam = vehicleChargingParameter;
    }
}
