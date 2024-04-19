package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BizRouteDrawCtrlAttrs implements Serializable {
    public boolean mIsDrawArrow;
    public boolean mIsDrawPath;
    public boolean mIsDrawPathCamera;
    public boolean mIsDrawPathTrafficLight;
    public boolean mIsHighLightRoadName;
    public boolean mIsNewRouteForCompareRoute;
    public boolean mIsTrafficEventOpen;
    public boolean mIsVisible;

    public BizRouteDrawCtrlAttrs() {
        this.mIsDrawPath = true;
        this.mIsVisible = true;
        this.mIsDrawPathCamera = false;
        this.mIsDrawPathTrafficLight = true;
        this.mIsNewRouteForCompareRoute = false;
        this.mIsTrafficEventOpen = true;
        this.mIsDrawArrow = true;
        this.mIsHighLightRoadName = false;
    }

    public BizRouteDrawCtrlAttrs(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.mIsDrawPath = z;
        this.mIsVisible = z2;
        this.mIsDrawPathCamera = z3;
        this.mIsDrawPathTrafficLight = z4;
        this.mIsNewRouteForCompareRoute = z5;
        this.mIsTrafficEventOpen = z6;
        this.mIsDrawArrow = z7;
        this.mIsHighLightRoadName = z8;
    }
}
