package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.lane.LaneNaviService;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class LaneNaviServiceWrapper {
    private static final L.Tag TAG = new L.Tag("LaneNaviServiceWrapper");
    private LaneNaviService mLaneNaviService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneNaviServiceWrapper(LaneNaviService laneNaviService) {
        if (laneNaviService == null) {
            return;
        }
        this.mLaneNaviService = laneNaviService;
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
    }
}
