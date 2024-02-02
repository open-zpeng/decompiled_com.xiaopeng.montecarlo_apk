package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RoadSlopeInfo implements Serializable {
    public short pointCnt;
    public SlopePoint slopePoint;
    public short slopeType;

    public RoadSlopeInfo() {
        this.pointCnt = (short) 0;
        this.slopeType = (short) 0;
        this.slopePoint = new SlopePoint();
    }

    public RoadSlopeInfo(short s, short s2, SlopePoint slopePoint) {
        this.pointCnt = s;
        this.slopeType = s2;
        this.slopePoint = slopePoint;
    }
}
