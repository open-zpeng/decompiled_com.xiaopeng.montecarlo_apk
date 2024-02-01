package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class NaviResourceInfo implements Serializable {
    public int dirIndicatorResID;
    public float dirIndicatorScale;
    public int endResID;
    public float endScale;
    public int naviDirectionResID;
    public float naviDirectionScale;
    public int shineResID;
    public float shineScale;
    public int trackArcResID;
    public float trackArcScale;
    public int trackResID;
    public float trackScale;

    public NaviResourceInfo() {
        this.naviDirectionResID = -1;
        this.naviDirectionScale = 1.0f;
        this.dirIndicatorResID = -1;
        this.dirIndicatorScale = 1.0f;
        this.trackResID = -1;
        this.trackScale = 1.0f;
        this.trackArcResID = -1;
        this.trackArcScale = 1.0f;
        this.shineResID = -1;
        this.shineScale = 1.0f;
        this.endResID = -1;
        this.endScale = 1.0f;
    }

    public NaviResourceInfo(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4, int i5, float f5, int i6, float f6) {
        this.naviDirectionResID = i;
        this.naviDirectionScale = f;
        this.dirIndicatorResID = i2;
        this.dirIndicatorScale = f2;
        this.trackResID = i3;
        this.trackScale = f3;
        this.trackArcResID = i4;
        this.trackArcScale = f4;
        this.shineResID = i5;
        this.shineScale = f5;
        this.endResID = i6;
        this.endScale = f6;
    }
}
