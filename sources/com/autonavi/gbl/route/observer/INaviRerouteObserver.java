package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.route.model.BLRerouteRequestInfo;
import com.autonavi.gbl.route.router.NaviRerouteObserverRouter;
@IntfAuto(target = NaviRerouteObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface INaviRerouteObserver {
    default void onModifyRerouteOption(RouteOption routeOption) {
    }

    default void onRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
    }

    default void onSwitchParallelRoadRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
    }
}
