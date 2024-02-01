package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DrivingLaneHighlightStyle implements Serializable {
    public float backwardLength;
    public float forwardLength;
    public int textureResID;

    public DrivingLaneHighlightStyle() {
        this.textureResID = -1;
        this.forwardLength = 0.0f;
        this.backwardLength = 0.0f;
    }

    public DrivingLaneHighlightStyle(int i, float f, float f2) {
        this.textureResID = i;
        this.forwardLength = f;
        this.backwardLength = f2;
    }
}
