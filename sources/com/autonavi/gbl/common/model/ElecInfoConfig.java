package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ElecInfoConfig implements Serializable {
    public int arrivingPercent;
    public ArrayList<ElecCostList> costList;
    public short costModelSwitch;
    public short costUnit;
    public ElecCustomization customization;
    public short driveTrain;
    public short fesMode;
    public short hasTraffic;
    public int leavingPercent;
    public float maxVechicleCharge;
    public String orgaName;
    public int powerflag;
    public short topSpeed;
    public float vehicleCharge;
    public short vehiclelMass;

    public ElecInfoConfig() {
        this.orgaName = "";
        this.driveTrain = (short) 0;
        this.fesMode = (short) 0;
        this.costModelSwitch = (short) 0;
        this.hasTraffic = (short) 0;
        this.costUnit = (short) 1;
        this.topSpeed = (short) 120;
        this.vehiclelMass = (short) -1;
        this.maxVechicleCharge = 0.0f;
        this.vehicleCharge = 0.0f;
        this.powerflag = 0;
        this.arrivingPercent = 0;
        this.leavingPercent = 0;
        this.costList = new ArrayList<>();
        this.customization = new ElecCustomization();
    }

    public ElecInfoConfig(String str, short s, short s2, short s3, short s4, short s5, short s6, short s7, float f, float f2, int i, int i2, int i3, ArrayList<ElecCostList> arrayList, ElecCustomization elecCustomization) {
        this.orgaName = str;
        this.driveTrain = s;
        this.fesMode = s2;
        this.costModelSwitch = s3;
        this.hasTraffic = s4;
        this.costUnit = s5;
        this.topSpeed = s6;
        this.vehiclelMass = s7;
        this.maxVechicleCharge = f;
        this.vehicleCharge = f2;
        this.powerflag = i;
        this.arrivingPercent = i2;
        this.leavingPercent = i3;
        this.costList = arrayList;
        this.customization = elecCustomization;
    }
}
