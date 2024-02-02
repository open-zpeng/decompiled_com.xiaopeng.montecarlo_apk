package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteLayerPassedColor implements Serializable {
    public long arrowColor;
    public long borderColor;
    public long fillColor;

    public RouteLayerPassedColor() {
        this.fillColor = 0L;
        this.borderColor = 0L;
        this.arrowColor = 0L;
    }

    public RouteLayerPassedColor(long j, long j2, long j3) {
        this.fillColor = j;
        this.borderColor = j2;
        this.arrowColor = j3;
    }
}
