package com.xiaopeng.montecarlo.navcore.util.comparator;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class SortRouteInfoByTrafficLightCount implements Comparator<RouteResult.RouteInfo> {
    @Override // java.util.Comparator
    public int compare(RouteResult.RouteInfo routeInfo, RouteResult.RouteInfo routeInfo2) {
        if (routeInfo == null || routeInfo2 == null) {
            return 0;
        }
        return routeInfo.mTrafficLightCount < routeInfo2.mTrafficLightCount ? -1 : 1;
    }
}
