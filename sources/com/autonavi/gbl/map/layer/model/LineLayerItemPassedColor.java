package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LineLayerItemPassedColor implements Serializable {
    public long passedColor;
    public long passedSideColor;

    public LineLayerItemPassedColor() {
        this.passedColor = 0L;
        this.passedSideColor = 0L;
    }

    public LineLayerItemPassedColor(long j, long j2) {
        this.passedColor = j;
        this.passedSideColor = j2;
    }
}
