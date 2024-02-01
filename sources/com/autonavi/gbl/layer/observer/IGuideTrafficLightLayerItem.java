package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.TrafficLight;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideTrafficLightLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideTrafficLightLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGuideTrafficLightLayerItem extends IQuadrantLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMLightCountDown();

    @TrafficLight.TrafficLight1
    int getMLightStatus();
}
