package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RealCityFlyLineParam implements Serializable {
    public int arrowTexId;
    public int fillTexId;
    public PolylineTextureInfo flylineArrowTexInfo;
    public PolylineTextureInfo flylineTexInfo;
    public int sideWidth;
    public int width;

    public RealCityFlyLineParam() {
        this.fillTexId = 0;
        this.arrowTexId = 0;
        this.width = 0;
        this.sideWidth = 0;
        this.flylineTexInfo = new PolylineTextureInfo();
        this.flylineArrowTexInfo = new PolylineTextureInfo();
    }

    public RealCityFlyLineParam(int i, int i2, int i3, int i4, PolylineTextureInfo polylineTextureInfo, PolylineTextureInfo polylineTextureInfo2) {
        this.fillTexId = i;
        this.arrowTexId = i2;
        this.width = i3;
        this.sideWidth = i4;
        this.flylineTexInfo = polylineTextureInfo;
        this.flylineArrowTexInfo = polylineTextureInfo2;
    }
}
