package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.router.RouteJamLineLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
@IntfAuto(target = RouteJamLineLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteJamLineLayerItem extends ILineLayerItem {
    AvoidJamCloudControl getMAvoidJamCloud();
}
