package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteLayerHightLightParam implements Serializable {
    public long arrowColorNormal;
    public long borderColorHightLight;
    public long borderColorNormal;
    public long fillColorHightLight;
    public long fillColorNormal;

    public RouteLayerHightLightParam() {
        this.fillColorHightLight = 0L;
        this.borderColorHightLight = 0L;
        this.fillColorNormal = 0L;
        this.borderColorNormal = 0L;
        this.arrowColorNormal = 0L;
    }

    public RouteLayerHightLightParam(long j, long j2, long j3, long j4, long j5) {
        this.fillColorHightLight = j;
        this.borderColorHightLight = j2;
        this.fillColorNormal = j3;
        this.borderColorNormal = j4;
        this.arrowColorNormal = j5;
    }
}
