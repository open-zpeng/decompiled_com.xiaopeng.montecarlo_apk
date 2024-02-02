package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.LanePositionStatus;
import com.autonavi.gbl.lane.router.LaneObserverRouter;
@IntfAuto(target = LaneObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneObserver {
    void onAnchorScaleChange(@AnchorScaleTime.AnchorScaleTime1 int i);

    void onLaneLndsDataDistance(float f);

    void onLanePositionStatus(@LanePositionStatus.LanePositionStatus1 int i);
}
