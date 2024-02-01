package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneLineStyleInfo implements Serializable {
    public int fillResID;
    public float lineWidth;

    public LaneLineStyleInfo() {
        this.lineWidth = 0.0f;
        this.fillResID = -1;
    }

    public LaneLineStyleInfo(float f, int i) {
        this.lineWidth = f;
        this.fillResID = i;
    }
}
