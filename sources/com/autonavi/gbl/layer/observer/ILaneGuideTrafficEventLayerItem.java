package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.router.LaneGuideTrafficEventLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LaneGuideTrafficEventLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILaneGuideTrafficEventLayerItem extends IPointLayerItem {
    String getLaneDetail();

    int getLength();

    @BubbleDirectionType.BubbleDirectionType1
    int getMDirectionType();

    int getMId();

    int getMIndex();

    String getMLane();

    int getMLayer();

    int getMLayerTag();

    long getPathId();
}
