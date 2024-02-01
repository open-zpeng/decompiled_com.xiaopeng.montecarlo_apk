package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderVehicleElec implements Serializable {
    public ArrayList<GRangeSpiderVehicleElecCostlist> costlist;
    public int costmodelswitch;
    public int costunit;
    public int drivetrain;
    public int fesmode;
    public double maxvehiclecharge;
    public String orga;
    public int topspeed;
    public double vehiclecharge;
    public int vehiclemass;

    public GRangeSpiderVehicleElec() {
        this.orga = "";
        this.drivetrain = 0;
        this.fesmode = 0;
        this.costmodelswitch = 0;
        this.topspeed = 0;
        this.vehiclemass = 0;
        this.maxvehiclecharge = 0.0d;
        this.vehiclecharge = 0.0d;
        this.costunit = 0;
        this.costlist = new ArrayList<>();
    }

    public GRangeSpiderVehicleElec(String str, int i, int i2, int i3, int i4, int i5, double d, double d2, int i6, ArrayList<GRangeSpiderVehicleElecCostlist> arrayList) {
        this.orga = str;
        this.drivetrain = i;
        this.fesmode = i2;
        this.costmodelswitch = i3;
        this.topspeed = i4;
        this.vehiclemass = i5;
        this.maxvehiclecharge = d;
        this.vehiclecharge = d2;
        this.costunit = i6;
        this.costlist = arrayList;
    }
}
