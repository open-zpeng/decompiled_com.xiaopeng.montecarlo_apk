package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideCameraLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideCameraLayerItem extends IPointLayerItem {
    ArrayList<NaviSubCameraExt> getAggregatedExts();

    @SubCameraExtType.SubCameraExtType1
    int getMCameraExtType();

    long getMCameraId();

    int getMCameraSpeed();

    @BubbleDirectionType.BubbleDirectionType1
    int getMDirectionType();

    int getMDistance();

    boolean getNeedShowNewCamera();

    boolean getNeedShowPenalty();

    boolean getShowRed();
}
