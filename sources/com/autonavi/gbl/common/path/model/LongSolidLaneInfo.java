package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LongSolidLaneInfo implements Serializable {
    public short effectIntersection;
    public short laneNum;
    public int validLane;

    public LongSolidLaneInfo() {
        this.validLane = 0;
        this.laneNum = (short) 0;
        this.effectIntersection = (short) 0;
    }

    public LongSolidLaneInfo(int i, short s, short s2) {
        this.validLane = i;
        this.laneNum = s;
        this.effectIntersection = s2;
    }
}
