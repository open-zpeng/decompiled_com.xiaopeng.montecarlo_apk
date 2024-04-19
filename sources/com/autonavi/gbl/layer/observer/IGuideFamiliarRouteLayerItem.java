package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideFamiliarRouteLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideFamiliarRouteLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideFamiliarRouteLayerItem extends IQuadrantLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getBoardStyle();

    long getPathId();
}
