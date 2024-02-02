package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteCompareTipsLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteCompareTipsLayerItem extends IPointLayerItem {
    boolean getMIsNewRoute();

    String getMTipName();
}
