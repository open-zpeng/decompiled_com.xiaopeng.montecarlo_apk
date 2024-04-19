package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EnergyConsume implements Serializable {
    public boolean energyEndFlag;
    public EnergyEndPoint energyEndPoint;
    public ArrayList<Integer> vehiclechargeleft;

    public EnergyConsume() {
        this.energyEndFlag = false;
        this.energyEndPoint = new EnergyEndPoint();
        this.vehiclechargeleft = new ArrayList<>();
    }

    public EnergyConsume(boolean z, EnergyEndPoint energyEndPoint, ArrayList<Integer> arrayList) {
        this.energyEndFlag = z;
        this.energyEndPoint = energyEndPoint;
        this.vehiclechargeleft = arrayList;
    }
}
