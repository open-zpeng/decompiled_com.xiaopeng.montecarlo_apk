package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.layer.router.RouteRestAreaLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteRestAreaLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteRestAreaLayerItem extends IPointLayerItem {
    RestAreaInfo getMRestAreaInfo();
}
