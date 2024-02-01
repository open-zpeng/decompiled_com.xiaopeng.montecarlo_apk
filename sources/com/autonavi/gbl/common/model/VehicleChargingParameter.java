package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class VehicleChargingParameter implements Serializable {
    public long baseLoadPower;
    public long chargingTimeOffset;
    public long maxBatteryAmpere;
    public long maxBatteryVoltage;
    public long maxChargingPower400V;
    public long maxPowerDc;
    public ArrayList<ChargingSocCurve> socCurve;

    public VehicleChargingParameter() {
        this.socCurve = new ArrayList<>();
        this.maxPowerDc = 0L;
        this.baseLoadPower = 0L;
        this.maxChargingPower400V = 0L;
        this.maxBatteryVoltage = 0L;
        this.maxBatteryAmpere = 0L;
        this.chargingTimeOffset = 0L;
    }

    public VehicleChargingParameter(ArrayList<ChargingSocCurve> arrayList, long j, long j2, long j3, long j4, long j5, long j6) {
        this.socCurve = arrayList;
        this.maxPowerDc = j;
        this.baseLoadPower = j2;
        this.maxChargingPower400V = j3;
        this.maxBatteryVoltage = j4;
        this.maxBatteryAmpere = j5;
        this.chargingTimeOffset = j6;
    }
}
