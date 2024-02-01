package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideSolidLineLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideSolidLineLayerItemRouter.class, type = BuildType.JINTF)
@Deprecated
/* loaded from: classes2.dex */
public interface ILaneGuideSolidLineLayerItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getBubbleSide();
}
