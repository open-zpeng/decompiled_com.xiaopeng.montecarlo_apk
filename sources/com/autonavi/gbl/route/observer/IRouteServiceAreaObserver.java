package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.RouteAlongServiceAreaInfo;
import com.autonavi.gbl.route.model.RouteServiceArea;
import com.autonavi.gbl.route.router.RouteServiceAreaObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = RouteServiceAreaObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteServiceAreaObserver {
    @Deprecated
    default void onServiceAreaUpdated(ArrayList<RouteServiceArea> arrayList) {
    }

    default void onUpdateAlongServiceArea(ArrayList<RouteAlongServiceAreaInfo> arrayList) {
    }
}
