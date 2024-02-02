package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.layer.router.RoutePathPointItemRouter;
import com.autonavi.gbl.map.layer.model.PathPointType;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RoutePathPointItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRoutePathPointItem extends IPointLayerItem {
    boolean getMIsNavi();

    int getMLeftEnergy();

    @BizRouteMapMode.BizRouteMapMode1
    int getMMode();

    @RouteLayerScene.RouteLayerScene1
    int getMScene();

    int getMTotalCount();

    @PathPointType.PathPointType1
    int getMType();
}
