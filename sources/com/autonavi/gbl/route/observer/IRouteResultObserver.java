package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.router.RouteResultObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = RouteResultObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteResultObserver {
    void onNewRoute(PathResultData pathResultData, ArrayList<PathInfo> arrayList, RouteLimitInfo routeLimitInfo);

    void onNewRouteError(PathResultData pathResultData, RouteLimitInfo routeLimitInfo);
}
