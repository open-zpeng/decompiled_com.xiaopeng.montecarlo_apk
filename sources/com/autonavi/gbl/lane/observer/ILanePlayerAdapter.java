package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.LanePlayerMessage;
import com.autonavi.gbl.lane.router.LanePlayerAdapterRouter;
@IntfAuto(target = LanePlayerAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILanePlayerAdapter {
    boolean onLaneData(LanePlayerMessage lanePlayerMessage);
}
