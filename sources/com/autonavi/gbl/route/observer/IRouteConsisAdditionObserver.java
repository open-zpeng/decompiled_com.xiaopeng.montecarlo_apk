package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.route.model.ConsisPathIdentity;
import com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = RouteConsisAdditionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteConsisAdditionObserver {
    default void onGetNaviPath(ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfo> arrayList2) {
    }

    default void onSyncRouteError(long j, int i) {
    }

    default void onSyncRouteOption(RouteOption routeOption) {
    }

    default void onSyncRouteResult(long j, String str, ArrayList<PathInfo> arrayList, BinaryStream binaryStream, int i) {
    }

    default void onSyncRouteSuccess(long j, ArrayList<ConsisPathIdentity> arrayList) {
    }
}
