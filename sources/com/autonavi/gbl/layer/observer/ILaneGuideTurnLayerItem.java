package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideTurnLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideTurnLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneGuideTurnLayerItem extends IPointLayerItem {
    @BubbleDirectionType.BubbleDirectionType1
    int getMDirectionType();

    short getMMainAction();

    long getMPathID();

    long getMRemainDist();

    int getMSegmentID();
}
