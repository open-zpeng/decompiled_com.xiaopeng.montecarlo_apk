package com.xiaopeng.montecarlo.navcore.event;

import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
import com.autonavi.gbl.guide.model.LaneInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class CruiseUpdateEvent {
    public static final int CRUISE_HIDE_LANE_INFO = 6;
    public static final int CRUISE_SHOW_LANE_INFO = 5;
    public static final int CRUISE_UPDATE_CRUISE_CONGESTION_INFO = 4;
    public static final int CRUISE_UPDATE_CRUISE_FACILITY = 0;
    public static final int CRUISE_UPDATE_CRUISE_INFO = 2;
    public static final int CRUISE_UPDATE_CRUISE_TIME_AND_DIST = 3;
    public static final int CRUISE_UPDATE_ELEC_CAMERA_INFO = 1;
    public List<CruiseFacilityInfo> mCruiseCameraInfos;
    public CruiseCongestionInfo mCruiseCongestionInfo;
    public List<CruiseFacilityInfo> mCruiseFacilityInfos;
    public CruiseInfo mCruiseInfo;
    public CruiseTimeAndDist mCruiseTimeAndDist;
    public LaneInfo mLaneInfo;
    private int mType;

    public CruiseUpdateEvent(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
