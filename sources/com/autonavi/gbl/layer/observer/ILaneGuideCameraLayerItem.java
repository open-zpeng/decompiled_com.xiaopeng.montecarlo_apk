package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.BreakRuleCameraSubType;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideCameraLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneGuideCameraLayerItem extends IPointLayerItem {
    @BreakRuleCameraSubType.BreakRuleCameraSubType1
    int getMBreakSubType();

    long getMCameraId();

    int getMCameraSpeed();

    @CameraType.CameraType1
    int getMCameraType();

    @BubbleDirectionType.BubbleDirectionType1
    int getMDirectionType();

    int getMDistance();
}
