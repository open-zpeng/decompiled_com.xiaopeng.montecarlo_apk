package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.LaneLndsDataDistanceInfo;
import com.autonavi.gbl.lane.model.LaneNaviStatus;
import com.autonavi.gbl.lane.model.LanePositionStatus;
import com.autonavi.gbl.lane.model.LaneStatusInfo;
import com.autonavi.gbl.lane.router.LaneObserverRouter;
@IntfAuto(target = LaneObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneObserver {
    default void onAnchorScaleChange(@AnchorScaleTime.AnchorScaleTime1 int i) {
    }

    @Deprecated
    default void onLaneLndsDataDistance(float f) {
    }

    default void onLaneLndsDataDistance(LaneLndsDataDistanceInfo laneLndsDataDistanceInfo) {
    }

    default void onLaneNaviEnterPointDistance(float f) {
    }

    default void onLaneNaviStatus(@LaneNaviStatus.LaneNaviStatus1 int i) {
    }

    default void onLanePositionStatus(@LanePositionStatus.LanePositionStatus1 int i) {
    }

    default void onLaneStatus(LaneStatusInfo laneStatusInfo) {
    }
}
