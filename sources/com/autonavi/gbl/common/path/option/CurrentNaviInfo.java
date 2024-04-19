package com.autonavi.gbl.common.path.option;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CurrentNaviInfo implements Serializable {
    public int drivingRouteDist;
    public int remainRouteDist;
    public int remainRouteTime;
    public int remainSegmentDist;
    public int rerouteCount;

    public CurrentNaviInfo() {
        this.remainRouteTime = 0;
        this.remainSegmentDist = 0;
        this.remainRouteDist = 0;
        this.drivingRouteDist = 0;
        this.rerouteCount = 0;
    }

    public CurrentNaviInfo(int i, int i2, int i3, int i4, int i5) {
        this.remainRouteTime = i;
        this.remainSegmentDist = i2;
        this.remainRouteDist = i3;
        this.drivingRouteDist = i4;
        this.rerouteCount = i5;
    }
}
