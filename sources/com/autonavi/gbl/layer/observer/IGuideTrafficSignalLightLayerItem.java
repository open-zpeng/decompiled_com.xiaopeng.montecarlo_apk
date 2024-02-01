package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.router.GuideTrafficSignalLightLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideTrafficSignalLightLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGuideTrafficSignalLightLayerItem extends IQuadrantLayerItem {
    float getArrowDirectionAlpha();

    int getCrossManeuverID();

    float getLightAlpha();

    int getLightCountDown();

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    int getTrafficLightStatus();

    long getWaitRoundCount();
}
