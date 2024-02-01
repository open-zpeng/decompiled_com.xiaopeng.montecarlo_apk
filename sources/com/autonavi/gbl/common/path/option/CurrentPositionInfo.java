package com.autonavi.gbl.common.path.option;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CurrentPositionInfo implements Serializable {
    public int linkIndex;
    public short overheadFlag;
    public short parallelRoadFlag;
    public int pointIndex;
    public int segmentIndex;

    public CurrentPositionInfo() {
        this.segmentIndex = -1;
        this.linkIndex = -1;
        this.pointIndex = -1;
        this.overheadFlag = (short) 0;
        this.parallelRoadFlag = (short) 0;
    }

    public CurrentPositionInfo(int i, int i2, int i3, short s, short s2) {
        this.segmentIndex = i;
        this.linkIndex = i2;
        this.pointIndex = i3;
        this.overheadFlag = s;
        this.parallelRoadFlag = s2;
    }
}
