package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RouteLayerStyle implements Serializable {
    public int arrow3DTextureId;
    public RouteLayerHightLightParam highLightParam;
    public long[] mPassedColor;
    public RouteLayerShadowParam shadowParam;
    public ArrayList<RouteLayerParam> vecParam;

    public RouteLayerStyle() {
        this.vecParam = new ArrayList<>();
        this.arrow3DTextureId = -1;
        this.highLightParam = new RouteLayerHightLightParam();
        this.shadowParam = new RouteLayerShadowParam();
        this.mPassedColor = new long[3];
    }

    public RouteLayerStyle(ArrayList<RouteLayerParam> arrayList, int i, RouteLayerHightLightParam routeLayerHightLightParam, RouteLayerShadowParam routeLayerShadowParam, long[] jArr) {
        this.vecParam = arrayList;
        this.arrow3DTextureId = i;
        this.highLightParam = routeLayerHightLightParam;
        this.shadowParam = routeLayerShadowParam;
        this.mPassedColor = jArr;
    }
}
