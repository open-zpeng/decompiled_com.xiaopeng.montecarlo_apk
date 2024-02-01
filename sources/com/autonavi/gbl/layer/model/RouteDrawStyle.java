package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteDrawStyle implements Serializable {
    public boolean mIsMultipleMode;
    public boolean mIsNavi;
    public boolean mIsOffLine;
    @BizRouteMapMode.BizRouteMapMode1
    public int mRouteMapMode;
    @RouteLayerScene.RouteLayerScene1
    public int mRouteScene;

    public RouteDrawStyle() {
        this.mIsOffLine = false;
        this.mIsNavi = false;
        this.mRouteMapMode = 0;
        this.mRouteScene = 0;
        this.mIsMultipleMode = false;
    }

    public RouteDrawStyle(boolean z, boolean z2, @BizRouteMapMode.BizRouteMapMode1 int i, @RouteLayerScene.RouteLayerScene1 int i2, boolean z3) {
        this.mIsOffLine = z;
        this.mIsNavi = z2;
        this.mRouteMapMode = i;
        this.mRouteScene = i2;
        this.mIsMultipleMode = z3;
    }
}
