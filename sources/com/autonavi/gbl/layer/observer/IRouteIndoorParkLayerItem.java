package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.RouteIndoorParkLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = RouteIndoorParkLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteIndoorParkLayerItem extends IQuadrantLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getBoardStyle();

    int getCurFloorNumber();

    boolean getIsUpstairs();

    int getToFloorNumber();
}
