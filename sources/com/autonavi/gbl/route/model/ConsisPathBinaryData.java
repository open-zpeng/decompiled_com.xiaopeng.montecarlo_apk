package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.CalcRouteResultData;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ConsisPathBinaryData implements Serializable {
    public long binaryType;
    public CalcRouteResultData calcRouteResultData;
    public RouteRestorationResultData routeRestorationData;

    public ConsisPathBinaryData() {
        this.binaryType = 0L;
        this.calcRouteResultData = new CalcRouteResultData();
        this.routeRestorationData = new RouteRestorationResultData();
    }

    public ConsisPathBinaryData(long j, CalcRouteResultData calcRouteResultData, RouteRestorationResultData routeRestorationResultData) {
        this.binaryType = j;
        this.calcRouteResultData = calcRouteResultData;
        this.routeRestorationData = routeRestorationResultData;
    }
}
