package com.xiaopeng.montecarlo.navcore.util.comparator;

import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class SortRouteInfoByTollCost implements Comparator<RouteDetailInfo> {
    @Override // java.util.Comparator
    public int compare(RouteDetailInfo routeDetailInfo, RouteDetailInfo routeDetailInfo2) {
        if (routeDetailInfo == null || routeDetailInfo2 == null) {
            return 0;
        }
        return routeDetailInfo.getTrafficCostValue() < routeDetailInfo2.getTrafficCostValue() ? -1 : 1;
    }
}
