package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LaneLndsDataDistanceInfo implements Serializable {
    public ArrayList<LaneLndsDataDistance> distance;

    public LaneLndsDataDistanceInfo() {
        this.distance = new ArrayList<>();
    }

    public LaneLndsDataDistanceInfo(ArrayList<LaneLndsDataDistance> arrayList) {
        this.distance = arrayList;
    }
}
