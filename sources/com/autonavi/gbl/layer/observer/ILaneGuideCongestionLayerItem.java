package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideCongestionLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = LaneGuideCongestionLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneGuideCongestionLayerItem extends IQuadrantLayerItem {
    CongestExtend getMCongestExtend();

    @BubbleDirectionType.BubbleDirectionType1
    int getMDirectionType();

    long getMPathID();

    long getMTotalRemainDist();

    long getMTotalTimeOfSeconds();
}
