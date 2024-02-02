package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.EnergyEndPoint;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ElecVehicleETAInfo implements Serializable {
    public ArrayList<ChargingStation> chargeStationInfo;
    public ArrayList<Integer> elecLinkConsume;
    public boolean energyEndFlag;
    public EnergyEndPoint energyEndPoint;
    public ArrayList<Long> energySum;
    public long pathID;

    public ElecVehicleETAInfo() {
        this.energyEndFlag = false;
        this.energyEndPoint = new EnergyEndPoint();
        this.pathID = 0L;
        this.elecLinkConsume = new ArrayList<>();
        this.energySum = new ArrayList<>();
        this.chargeStationInfo = new ArrayList<>();
    }

    public ElecVehicleETAInfo(boolean z, EnergyEndPoint energyEndPoint, long j, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, ArrayList<ChargingStation> arrayList3) {
        this.energyEndFlag = z;
        this.energyEndPoint = energyEndPoint;
        this.pathID = j;
        this.elecLinkConsume = arrayList;
        this.energySum = arrayList2;
        this.chargeStationInfo = arrayList3;
    }
}
