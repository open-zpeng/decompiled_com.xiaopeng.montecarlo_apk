package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneNotRecommendedType;
import com.autonavi.gbl.layer.router.LaneGuideNotRecommendedLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideNotRecommendedLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideNotRecommendedLayerItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getBubbleSide();

    @LaneNotRecommendedType.LaneNotRecommendedType1
    int getSceneType();
}
