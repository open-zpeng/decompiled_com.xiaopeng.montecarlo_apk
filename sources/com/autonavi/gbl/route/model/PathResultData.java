package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.path.option.CalcRouteRespType;
import com.autonavi.gbl.common.path.option.RouteMode;
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.route.model.RouteRespCategory;
import com.autonavi.gbl.util.errorcode.Route;
import com.autonavi.gbl.util.model.BLSubErrorDetail;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PathResultData implements Serializable {
    @CalcRouteRespType.CalcRouteRespType1
    public int calcRouteResptype;
    public CalcRouteResultData calcRouteResultData;
    public int errorCode;
    public boolean isChange;
    public boolean isLocal;
    public boolean isPriorityCollisionAbort;
    @RouteMode.RouteMode1
    public int mode;
    public OddRespInfo oddRespInfo;
    public Online2OfflineInfo online2OfflineInfo;
    public String planChannelId;
    public long requestId;
    public boolean respDone;
    @RouteRespCategory.RouteRespCategory1
    public int routeRespCategory;
    public RouteRestorationResultData routeRestorationData;
    @RouteType.RouteType1
    public int type;
    public ArrayList<BLSubErrorDetail> vecDetail;

    public PathResultData() {
        this.requestId = 0L;
        this.calcRouteResptype = 0;
        this.mode = 0;
        this.routeRespCategory = 0;
        this.type = 1;
        this.isLocal = false;
        this.errorCode = Route.ErrorCodeUnknown;
        this.vecDetail = new ArrayList<>();
        this.isChange = false;
        this.respDone = false;
        this.isPriorityCollisionAbort = false;
        this.online2OfflineInfo = new Online2OfflineInfo();
        this.calcRouteResultData = new CalcRouteResultData();
        this.routeRestorationData = new RouteRestorationResultData();
        this.oddRespInfo = new OddRespInfo();
        this.planChannelId = "";
    }

    public PathResultData(long j, @CalcRouteRespType.CalcRouteRespType1 int i, @RouteMode.RouteMode1 int i2, @RouteRespCategory.RouteRespCategory1 int i3, @RouteType.RouteType1 int i4, boolean z, int i5, ArrayList<BLSubErrorDetail> arrayList, boolean z2, boolean z3, boolean z4, Online2OfflineInfo online2OfflineInfo, CalcRouteResultData calcRouteResultData, RouteRestorationResultData routeRestorationResultData, OddRespInfo oddRespInfo, String str) {
        this.requestId = j;
        this.calcRouteResptype = i;
        this.mode = i2;
        this.routeRespCategory = i3;
        this.type = i4;
        this.isLocal = z;
        this.errorCode = i5;
        this.vecDetail = arrayList;
        this.isChange = z2;
        this.respDone = z3;
        this.isPriorityCollisionAbort = z4;
        this.online2OfflineInfo = online2OfflineInfo;
        this.calcRouteResultData = calcRouteResultData;
        this.routeRestorationData = routeRestorationResultData;
        this.oddRespInfo = oddRespInfo;
        this.planChannelId = str;
    }
}
