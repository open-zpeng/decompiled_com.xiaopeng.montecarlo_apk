package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.model.RouteLayerStyleType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteLayerDrawParam implements Serializable {
    public boolean mIsHighLightRoadName;
    public boolean mIsMultipleMode;
    public boolean mIsNavi;
    public boolean mIsSelected;
    @RouteLayerScene.RouteLayerScene1
    public int mRouteScene;
    @RouteLayerStyleType.RouteLayerStyleType1
    public int mRouteStyleType;

    public RouteLayerDrawParam() {
        this.mIsSelected = false;
        this.mIsNavi = false;
        this.mRouteScene = 0;
        this.mRouteStyleType = 0;
        this.mIsHighLightRoadName = true;
        this.mIsMultipleMode = false;
    }

    public RouteLayerDrawParam(boolean z, boolean z2, @RouteLayerScene.RouteLayerScene1 int i, @RouteLayerStyleType.RouteLayerStyleType1 int i2, boolean z3, boolean z4) {
        this.mIsSelected = z;
        this.mIsNavi = z2;
        this.mRouteScene = i;
        this.mRouteStyleType = i2;
        this.mIsHighLightRoadName = z3;
        this.mIsMultipleMode = z4;
    }
}
