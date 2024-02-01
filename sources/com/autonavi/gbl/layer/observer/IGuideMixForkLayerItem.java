package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideMixForkLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = GuideMixForkLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGuideMixForkLayerItem extends IPointLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMDistance();

    int getMRoadClass();
}
