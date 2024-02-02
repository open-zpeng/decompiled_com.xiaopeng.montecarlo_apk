package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.MapRouteTexture;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteLayerParam implements Serializable {
    public long borderColor;
    public int borderLineWidth;
    public int borderMarker;
    public boolean canBeCovered;
    public long fillColor;
    public int fillMarker;
    public PolylineCapTextureInfo lineCapTextureInfo;
    public boolean lineExtract;
    public PolylineTextureInfo lineSimple3DTextureInfo;
    public PolylineTextureInfo lineTextureInfo;
    public int lineWidth;
    public boolean needColorGradient;
    @MapRouteTexture.MapRouteTexture1
    public int routeTexture;
    public long selectBorderColor;
    public long selectFillColor;
    public boolean showArrow;
    public int simple3DFillMarker;
    public long unSelectBorderColor;
    public long unSelectFillColor;
    public boolean useCap;
    public boolean useColor;

    public RouteLayerParam() {
        this.lineExtract = false;
        this.useColor = false;
        this.useCap = false;
        this.canBeCovered = true;
        this.showArrow = true;
        this.needColorGradient = false;
        this.lineWidth = 0;
        this.borderLineWidth = 0;
        this.fillMarker = -1;
        this.simple3DFillMarker = -1;
        this.borderMarker = -1;
        this.fillColor = 0L;
        this.borderColor = 0L;
        this.selectFillColor = 0L;
        this.unSelectFillColor = 0L;
        this.selectBorderColor = 0L;
        this.unSelectBorderColor = 0L;
        this.routeTexture = 1;
        this.lineTextureInfo = new PolylineTextureInfo();
        this.lineSimple3DTextureInfo = new PolylineTextureInfo();
        this.lineCapTextureInfo = new PolylineCapTextureInfo();
    }

    public RouteLayerParam(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, long j4, long j5, long j6, @MapRouteTexture.MapRouteTexture1 int i6, PolylineTextureInfo polylineTextureInfo, PolylineTextureInfo polylineTextureInfo2, PolylineCapTextureInfo polylineCapTextureInfo) {
        this.lineExtract = z;
        this.useColor = z2;
        this.useCap = z3;
        this.canBeCovered = z4;
        this.showArrow = z5;
        this.needColorGradient = z6;
        this.lineWidth = i;
        this.borderLineWidth = i2;
        this.fillMarker = i3;
        this.simple3DFillMarker = i4;
        this.borderMarker = i5;
        this.fillColor = j;
        this.borderColor = j2;
        this.selectFillColor = j3;
        this.unSelectFillColor = j4;
        this.selectBorderColor = j5;
        this.unSelectBorderColor = j6;
        this.routeTexture = i6;
        this.lineTextureInfo = polylineTextureInfo;
        this.lineSimple3DTextureInfo = polylineTextureInfo2;
        this.lineCapTextureInfo = polylineCapTextureInfo;
    }
}
