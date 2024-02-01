package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.RouteViaRoadLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteViaRoadLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteViaRoadLayerItem extends IPointLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    ViaRoadInfo getMViaRoadInfo();
}
