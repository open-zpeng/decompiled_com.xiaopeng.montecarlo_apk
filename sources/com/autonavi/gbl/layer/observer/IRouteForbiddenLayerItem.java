package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.ForbiddenCloudControl;
import com.autonavi.gbl.layer.router.RouteForbiddenLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteForbiddenLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteForbiddenLayerItem extends IPointLayerItem {
    ForbiddenCloudControl getMForbiddenCloud();
}
