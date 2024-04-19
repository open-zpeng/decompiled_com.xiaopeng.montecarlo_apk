package com.autonavi.gbl.user.forcast.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EnergyCollect implements Serializable {
    public float avgEnergy;
    public ArrayList<EnergyPoint> data;

    public EnergyCollect() {
        this.avgEnergy = 0.0f;
        this.data = new ArrayList<>();
    }

    public EnergyCollect(float f, ArrayList<EnergyPoint> arrayList) {
        this.avgEnergy = f;
        this.data = arrayList;
    }
}
