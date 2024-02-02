package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.option.CalcRouteRespType;
import com.autonavi.gbl.common.path.option.RouteMode;
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.route.model.RouteRespCategory;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PathResultData implements Serializable {
    @CalcRouteRespType.CalcRouteRespType1
    public int calcRouteResptype;
    public CalcRouteResultData calcRouteResultData;
    @RouteErrorcode.RouteErrorcode1
    public int errorCode;
    public boolean isChange;
    public boolean isLocal;
    @RouteMode.RouteMode1
    public int mode;
    public OddRespInfo oddRespInfo;
    public long requestId;
    @RouteRespCategory.RouteRespCategory1
    public int routeRespCategory;
    public RouteRestorationResultData routeRestorationData;
    @RouteType.RouteType1
    public int type;

    public PathResultData() {
        this.requestId = 0L;
        this.calcRouteResptype = 0;
        this.mode = 0;
        this.routeRespCategory = 0;
        this.type = 1;
        this.isLocal = false;
        this.errorCode = -1;
        this.isChange = false;
        this.calcRouteResultData = new CalcRouteResultData();
        this.routeRestorationData = new RouteRestorationResultData();
        this.oddRespInfo = new OddRespInfo();
    }

    public PathResultData(long j, @CalcRouteRespType.CalcRouteRespType1 int i, @RouteMode.RouteMode1 int i2, @RouteRespCategory.RouteRespCategory1 int i3, @RouteType.RouteType1 int i4, boolean z, @RouteErrorcode.RouteErrorcode1 int i5, boolean z2, CalcRouteResultData calcRouteResultData, RouteRestorationResultData routeRestorationResultData, OddRespInfo oddRespInfo) {
        this.requestId = j;
        this.calcRouteResptype = i;
        this.mode = i2;
        this.routeRespCategory = i3;
        this.type = i4;
        this.isLocal = z;
        this.errorCode = i5;
        this.isChange = z2;
        this.calcRouteResultData = calcRouteResultData;
        this.routeRestorationData = routeRestorationResultData;
        this.oddRespInfo = oddRespInfo;
    }
}
