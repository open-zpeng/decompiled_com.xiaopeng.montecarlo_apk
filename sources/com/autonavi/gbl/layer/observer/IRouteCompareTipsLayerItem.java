package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = RouteCompareTipsLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteCompareTipsLayerItem extends IQuadrantLayerItem {
    boolean getMIsFaster();

    String getMLabelContent();

    int getMTravelTimeDiff();
}
