package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideIntervalCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideIntervalCameraLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideIntervalCameraLayerItem extends IQuadrantLayerItem {
    @CameraType.CameraType1
    int getMCameraType();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMSpeed();
}
