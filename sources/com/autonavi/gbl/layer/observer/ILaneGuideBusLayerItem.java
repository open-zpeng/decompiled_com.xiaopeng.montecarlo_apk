package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideBusLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideBusLayerItemRouter.class, type = BuildType.JINTF)
@Deprecated
/* loaded from: classes2.dex */
public interface ILaneGuideBusLayerItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getBubbleSide();
}
