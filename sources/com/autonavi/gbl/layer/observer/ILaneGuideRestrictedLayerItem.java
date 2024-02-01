package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.ForbiddenTurnType;
import com.autonavi.gbl.lane.model.LaneRestrictedType;
import com.autonavi.gbl.lane.model.LimitTimeType;
import com.autonavi.gbl.layer.router.LaneGuideRestrictedLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = LaneGuideRestrictedLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideRestrictedLayerItem extends IQuadrantLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getBubbleSide();

    @ForbiddenTurnType.ForbiddenTurnType1
    int getForbiddenType();

    @LimitTimeType.LimitTimeType1
    int getLimitType();

    @LaneRestrictedType.LaneRestrictedType1
    int getSceneType();
}
