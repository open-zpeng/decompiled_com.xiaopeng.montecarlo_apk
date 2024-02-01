package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneChangeGuidanceType;
import com.autonavi.gbl.layer.router.LaneGuideChangeLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideChangeLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideChangeLayerItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getBubbleSide();

    @LaneChangeGuidanceType.LaneChangeGuidanceType1
    int getSceneType();
}
