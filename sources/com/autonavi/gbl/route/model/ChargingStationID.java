package com.autonavi.gbl.route.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChargingStationID implements Serializable {
    public ArrayList<PoiStationPair> pairList;
    public long pathId;

    public ChargingStationID() {
        this.pathId = 0L;
        this.pairList = new ArrayList<>();
    }

    public ChargingStationID(long j, ArrayList<PoiStationPair> arrayList) {
        this.pathId = j;
        this.pairList = arrayList;
    }
}
