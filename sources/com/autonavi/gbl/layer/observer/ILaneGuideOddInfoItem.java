package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.model.LaneODDPointType;
import com.autonavi.gbl.layer.router.LaneGuideOddInfoItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideOddInfoItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideOddInfoItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getDirectionType();

    @LaneODDPointType.LaneODDPointType1
    int getType();
}
