package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DrivingLaneHighlightInfo implements Serializable {
    public boolean isShow;
    public float leftMargin;
    public float rightMargin;

    public DrivingLaneHighlightInfo() {
        this.isShow = false;
        this.leftMargin = 0.0f;
        this.rightMargin = 0.0f;
    }

    public DrivingLaneHighlightInfo(boolean z, float f, float f2) {
        this.isShow = z;
        this.leftMargin = f;
        this.rightMargin = f2;
    }
}
