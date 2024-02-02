package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.RectInt;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VectorCrossAttr implements Serializable {
    public RectInt areaRect;
    public MapRGBA arrowBorderColor;
    public float arrowBorderWidth;
    public PolylineCapTextureInfo arrowHeaderCapTextureInfo;
    public MapRGBA arrowLineColor;
    public float arrowLineWidth;
    public PolylineCapTextureInfo arrowlineCapTextureInfo;
    public PolylineTextureInfo arrowlineTextureInfo;
    public boolean isDayMode;
    public boolean isUseStyleConfigure;

    public VectorCrossAttr() {
        this.isDayMode = false;
        this.isUseStyleConfigure = true;
        this.arrowBorderWidth = 0.0f;
        this.arrowLineWidth = 0.0f;
        this.arrowBorderColor = new MapRGBA();
        this.arrowLineColor = new MapRGBA();
        this.arrowlineCapTextureInfo = new PolylineCapTextureInfo();
        this.arrowHeaderCapTextureInfo = new PolylineCapTextureInfo();
        this.arrowlineTextureInfo = new PolylineTextureInfo();
        this.areaRect = new RectInt();
    }

    public VectorCrossAttr(boolean z, boolean z2, float f, float f2, MapRGBA mapRGBA, MapRGBA mapRGBA2, PolylineCapTextureInfo polylineCapTextureInfo, PolylineCapTextureInfo polylineCapTextureInfo2, PolylineTextureInfo polylineTextureInfo, RectInt rectInt) {
        this.isDayMode = z;
        this.isUseStyleConfigure = z2;
        this.arrowBorderWidth = f;
        this.arrowLineWidth = f2;
        this.arrowBorderColor = mapRGBA;
        this.arrowLineColor = mapRGBA2;
        this.arrowlineCapTextureInfo = polylineCapTextureInfo;
        this.arrowHeaderCapTextureInfo = polylineCapTextureInfo2;
        this.arrowlineTextureInfo = polylineTextureInfo;
        this.areaRect = rectInt;
    }
}
