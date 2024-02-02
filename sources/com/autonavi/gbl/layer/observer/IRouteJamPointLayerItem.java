package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.router.RouteJamPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteJamPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteJamPointLayerItem extends IPointLayerItem {
    AvoidJamCloudControl getMAvoidJamCloud();

    boolean getMbEnableCollision();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem, com.autonavi.gbl.layer.observer.IGuideLabelLayerItem
    void onVisible(boolean z);
}
