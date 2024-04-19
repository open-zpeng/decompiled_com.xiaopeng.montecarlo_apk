package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.lane.router.LaneNaviObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = LaneNaviObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneNaviObserver {
    void onShowNaviCamera(ArrayList<LaneNaviCamera> arrayList, int i);

    void onUpdateTMCCongestionInfo(LaneNaviCongestionInfo laneNaviCongestionInfo, int i);

    void onUpdateTREvent(LanePathTrafficEventInfo lanePathTrafficEventInfo, int i);

    void onUpdateTravelPointInfo(ArrayList<TravelPoint> arrayList, int i);

    void onUpdateTurnBubbleInfo(TurnBubbleInfo turnBubbleInfo);
}
