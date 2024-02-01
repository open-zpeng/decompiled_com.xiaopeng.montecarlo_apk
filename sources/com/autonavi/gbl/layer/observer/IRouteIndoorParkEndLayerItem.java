package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.RouteIndoorParkEndLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteIndoorParkEndLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteIndoorParkEndLayerItem extends IPointLayerItem {
    int getFloorNumber();
}
