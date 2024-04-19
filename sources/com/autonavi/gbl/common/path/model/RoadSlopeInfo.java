package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoadSlopeInfo implements Serializable {
    public ArrayList<SlopePoint> slopePoint;
    public short slopeType;

    public RoadSlopeInfo() {
        this.slopeType = (short) 0;
        this.slopePoint = new ArrayList<>();
    }

    public RoadSlopeInfo(short s, ArrayList<SlopePoint> arrayList) {
        this.slopeType = s;
        this.slopePoint = arrayList;
    }
}
