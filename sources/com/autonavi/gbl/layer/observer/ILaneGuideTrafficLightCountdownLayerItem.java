package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.router.LaneGuideTrafficLightCountdownLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = LaneGuideTrafficLightCountdownLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideTrafficLightCountdownLayerItem extends IQuadrantLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getDirectionType();

    long getLightAnimationBeginTimeMS();

    float getLightBodyAlpha();

    String getLightDirection();

    float getLightDirectionAlpha();

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    int getLightStatus();

    int getRemainSeconds();

    int getWaitRound();
}
