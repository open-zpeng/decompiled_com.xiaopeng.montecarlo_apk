package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderVehicleElecCostlist implements Serializable {
    public double aux;
    public GRangeSpiderVehicleElecCostlistCurve curve;
    public double ferryrate;
    public int id;
    public ArrayList<GRangeSpiderVehicleElecCostlistPowertrainloss> powertrainloss;
    public ArrayList<GRangeSpiderVehicleElecCostlistRange> range;
    public GRangeSpiderVehicleElecCostlistSlope slope;
    public ArrayList<GRangeSpiderVehicleElecCostlistSpeed> speed;
    public GRangeSpiderVehicleElecCostlistTrans trans;
    public int type;

    public GRangeSpiderVehicleElecCostlist() {
        this.id = 0;
        this.type = 0;
        this.range = new ArrayList<>();
        this.speed = new ArrayList<>();
        this.powertrainloss = new ArrayList<>();
        this.trans = new GRangeSpiderVehicleElecCostlistTrans();
        this.curve = new GRangeSpiderVehicleElecCostlistCurve();
        this.slope = new GRangeSpiderVehicleElecCostlistSlope();
        this.aux = 0.0d;
        this.ferryrate = 0.0d;
    }

    public GRangeSpiderVehicleElecCostlist(int i, int i2, ArrayList<GRangeSpiderVehicleElecCostlistRange> arrayList, ArrayList<GRangeSpiderVehicleElecCostlistSpeed> arrayList2, ArrayList<GRangeSpiderVehicleElecCostlistPowertrainloss> arrayList3, GRangeSpiderVehicleElecCostlistTrans gRangeSpiderVehicleElecCostlistTrans, GRangeSpiderVehicleElecCostlistCurve gRangeSpiderVehicleElecCostlistCurve, GRangeSpiderVehicleElecCostlistSlope gRangeSpiderVehicleElecCostlistSlope, double d, double d2) {
        this.id = i;
        this.type = i2;
        this.range = arrayList;
        this.speed = arrayList2;
        this.powertrainloss = arrayList3;
        this.trans = gRangeSpiderVehicleElecCostlistTrans;
        this.curve = gRangeSpiderVehicleElecCostlistCurve;
        this.slope = gRangeSpiderVehicleElecCostlistSlope;
        this.aux = d;
        this.ferryrate = d2;
    }
}
