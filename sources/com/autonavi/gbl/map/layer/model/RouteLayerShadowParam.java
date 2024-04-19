package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteLayerShadowParam implements Serializable {
    public int routeOffsetPixels;
    public long shadowColor;
    public int shadowMarker;
    public long shadowPassColor;

    public RouteLayerShadowParam() {
        this.shadowColor = 0L;
        this.shadowPassColor = 0L;
        this.shadowMarker = 0;
        this.routeOffsetPixels = 5;
    }

    public RouteLayerShadowParam(long j, long j2, int i, int i2) {
        this.shadowColor = j;
        this.shadowPassColor = j2;
        this.shadowMarker = i;
        this.routeOffsetPixels = i2;
    }
}
