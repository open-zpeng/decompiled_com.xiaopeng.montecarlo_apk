package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideCameraLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideCameraLayerItem extends IQuadrantLayerItem {
    int getMBreakSubType();

    long getMCameraId();

    int getMCameraSpeed();

    @CameraType.CameraType1
    int getMCameraType();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMDistance();

    boolean getMNeedShowNewCamera();

    boolean getMNeedShowPenalty();

    Coord3DDouble getMPosition();

    @BizDirectionStyle.BizDirectionStyle1
    int getMWantDirectionStyle();

    boolean getMbContinuous();
}
