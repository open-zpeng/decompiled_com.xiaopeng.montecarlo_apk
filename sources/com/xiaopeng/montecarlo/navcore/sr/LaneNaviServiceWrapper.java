package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.lane.LaneNaviService;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.lane.observer.ILaneNaviObserver;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class LaneNaviServiceWrapper {
    private static final L.Tag TAG = new L.Tag("LaneNaviServiceWrapper");
    private ILaneNaviObserver mLaneNaviObserver = new ILaneNaviObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneNaviServiceWrapper.1
        @Override // com.autonavi.gbl.lane.observer.ILaneNaviObserver
        public void onShowNaviCamera(ArrayList<LaneNaviCamera> arrayList, int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneNaviObserver
        public void onUpdateTMCCongestionInfo(LaneNaviCongestionInfo laneNaviCongestionInfo, int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneNaviObserver
        public void onUpdateTREvent(LanePathTrafficEventInfo lanePathTrafficEventInfo, int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneNaviObserver
        public void onUpdateTravelPointInfo(ArrayList<TravelPoint> arrayList, int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneNaviObserver
        public void onUpdateTurnBubbleInfo(TurnBubbleInfo turnBubbleInfo) {
        }
    };
    private LaneNaviService mLaneNaviService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneNaviServiceWrapper(LaneNaviService laneNaviService) {
        this.mLaneNaviService = laneNaviService;
        this.mLaneNaviService.addLaneNaviObserver(this.mLaneNaviObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLaneWork(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "openLaneWork " + z);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            return laneNaviService.openLaneWork(z);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enterLane(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "enterLane " + z);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            return laneNaviService.enterLane(z);
        }
        return false;
    }

    boolean openShowOccpyLane(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "openShowOccpyLane " + z);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            return laneNaviService.openShowOccpyLane(z);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openNaviLine(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "openNaviLine " + z);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            return laneNaviService.openNaviLine(z);
        }
        return false;
    }

    boolean openCalcRoadPolygon(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "openCalcRoadPolygon " + z);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            return laneNaviService.openCalcRoadPolygon(z);
        }
        return false;
    }

    void setPersonNum(int i) {
        L.Tag tag = TAG;
        L.i(tag, "setPersonNum " + i);
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            laneNaviService.setPersonNum(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unInit() {
        L.i(TAG, "unInit");
        LaneNaviService laneNaviService = this.mLaneNaviService;
        if (laneNaviService != null) {
            laneNaviService.removeLaneNaviObserver(this.mLaneNaviObserver);
        }
    }
}
