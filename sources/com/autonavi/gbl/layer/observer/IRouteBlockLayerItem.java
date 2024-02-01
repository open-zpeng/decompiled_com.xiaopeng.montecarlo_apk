package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.EventCloudControl;
import com.autonavi.gbl.layer.router.RouteBlockLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteBlockLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteBlockLayerItem extends IPointLayerItem {
    EventCloudControl getMEventCloud();

    boolean getMbEnableCollision();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    default void onVisible(boolean z) {
    }
}
