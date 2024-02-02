package com.xiaopeng.montecarlo.navcore.event;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.ExitDirectionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.ManeuverInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SuggestChangePathReason;
import com.autonavi.gbl.guide.model.TMCIncidentReport;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideWrapperNaviEvent<T> {
    public static final int CHANGE_NAVI_PATH = 21;
    public static final int DELETE_PATH = 20;
    public static final int HIDE_CROSS_IMAGE = 3;
    public static final int HIDE_LANE_INFO = 7;
    public static final int HIDE_RECOMMEND_PARKING = 24;
    public static final int PASS_LAST_3D_SEGMENT = 5;
    public static final int PATH_TRAFFIC_EVENT = 26;
    public static final int REROUTE = 17;
    public static final int SELECTED_MAIN_PATH = 19;
    public static final int SHOW_ASYNC_MANEUVER_INFO = 25;
    public static final int SHOW_CROSS_IMAGE = 2;
    public static final int SHOW_CROSS_TMC = 4;
    public static final int SHOW_LANE_INFO = 6;
    public static final int SHOW_LOCK_SCREEN_TIP = 15;
    public static final int SHOW_MANEUVER_INFO = 8;
    public static final int SHOW_NAVI_CAMERA = 9;
    public static final int SHOW_NAVI_INTERNAL_CAMERA = 10;
    public static final int SHOW_RECOMMEND_PARKING = 23;
    public static final int SHOW_SAME_DIR_MIX_FORK = 16;
    public static final int STOP_NAVI = 13;
    public static final int SUGGEST_CHANGE_PATH = 22;
    public static final int UPDATE_EXIT_DIRECTION_INFO = 1;
    public static final int UPDATE_NAVI_CAMERA_DYNAMIC_INFO = 11;
    public static final int UPDATE_NAVI_INFO = 0;
    public static final int UPDATE_SAPA = 12;
    public static final int UPDATE_TMC_LIGHT_BAR = 18;
    public static final int UPDATE_TOLLGATE_LANE = 27;
    public static final int UPDATE_VIAS_PASS = 14;
    public boolean mBooleanValue;
    public byte[] mCrosTMC;
    public CrossImageInfo mCrossImageInfo;
    public ExitDirectionInfo mExitDirectionInfo;
    public int mIntValue;
    public LaneInfo mLaneInfo;
    public List<T> mList;
    private long[] mLongValue;
    ManeuverInfo mManeuverInfo;
    public NaviCongestionInfo mNaviCongestionInfo;
    private RouteOption mRerouteOption;
    public RouteTrafficEventInfo mRouteTrafficEventInfo;
    public String mStringValue;
    public SuggestChangePathReason mSuggestChangePathReason;
    public TMCIncidentReport mTmcIncidentReport;
    private TollGateInfo mTollGateInfo;
    private int mType;

    public GuideWrapperNaviEvent(int i) {
        this.mType = i;
    }

    private GuideWrapperNaviEvent(Builder builder) {
        this.mList = builder.mList;
        this.mExitDirectionInfo = builder.mExitDirectionInfo;
        this.mCrossImageInfo = builder.mCrossImageInfo;
        this.mIntValue = builder.mIntValue;
        this.mBooleanValue = builder.mBooleanValue;
        this.mNaviCongestionInfo = builder.mNaviCongestionInfo;
        this.mRouteTrafficEventInfo = builder.mRouteTrafficEventInfo;
        this.mTmcIncidentReport = builder.mTmcIncidentReport;
        this.mStringValue = builder.mStringValue;
        this.mLongValue = builder.mLongValue;
        this.mSuggestChangePathReason = builder.mSuggestChangePathReason;
        this.mCrosTMC = builder.mCrosTMC;
        this.mLaneInfo = builder.mLaneInfo;
        this.mTollGateInfo = builder.mTollGateInfo;
        this.mManeuverInfo = builder.mManeuverInfo;
        this.mType = builder.mType;
        this.mRerouteOption = builder.mRerouteOption;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public List<T> getList() {
        return this.mList;
    }

    public void setList(List<T> list) {
        this.mList = list;
    }

    public ExitDirectionInfo getExitDirectionInfo() {
        return this.mExitDirectionInfo;
    }

    public void setExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
        this.mExitDirectionInfo = exitDirectionInfo;
    }

    public CrossImageInfo getCrossImageInfo() {
        return this.mCrossImageInfo;
    }

    public void setCrossImageInfo(CrossImageInfo crossImageInfo) {
        this.mCrossImageInfo = crossImageInfo;
    }

    public int getIntValue() {
        return this.mIntValue;
    }

    public void setIntValue(int i) {
        this.mIntValue = i;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public void setBooleanValue(boolean z) {
        this.mBooleanValue = z;
    }

    public NaviCongestionInfo getNaviCongestionInfo() {
        return this.mNaviCongestionInfo;
    }

    public void setNaviCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
        this.mNaviCongestionInfo = naviCongestionInfo;
    }

    public RouteTrafficEventInfo getRouteTrafficEventInfo() {
        return this.mRouteTrafficEventInfo;
    }

    public void setRouteTrafficEventInfo(RouteTrafficEventInfo routeTrafficEventInfo) {
        this.mRouteTrafficEventInfo = routeTrafficEventInfo;
    }

    public TMCIncidentReport getTmcIncidentReport() {
        return this.mTmcIncidentReport;
    }

    public void setTmcIncidentReport(TMCIncidentReport tMCIncidentReport) {
        this.mTmcIncidentReport = tMCIncidentReport;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public long[] getLongValue() {
        return this.mLongValue;
    }

    public void setLongValue(long... jArr) {
        this.mLongValue = jArr;
    }

    public SuggestChangePathReason getSuggestChangePathReason() {
        return this.mSuggestChangePathReason;
    }

    public void setSuggestChangePathReason(SuggestChangePathReason suggestChangePathReason) {
        this.mSuggestChangePathReason = suggestChangePathReason;
    }

    public byte[] getCrosTMC() {
        return this.mCrosTMC;
    }

    public void setCrosTMC(byte[] bArr) {
        this.mCrosTMC = bArr;
    }

    public LaneInfo getLaneInfo() {
        return this.mLaneInfo;
    }

    public void setLaneInfo(LaneInfo laneInfo) {
        this.mLaneInfo = laneInfo;
    }

    public TollGateInfo getTollGateInfo() {
        return this.mTollGateInfo;
    }

    public void setTollGateInfo(TollGateInfo tollGateInfo) {
        this.mTollGateInfo = tollGateInfo;
    }

    public ManeuverInfo getManeuverInfo() {
        return this.mManeuverInfo;
    }

    public void setManeuverInfo(ManeuverInfo maneuverInfo) {
        this.mManeuverInfo = maneuverInfo;
    }

    public RouteOption getRerouteOption() {
        return this.mRerouteOption;
    }

    public void setRerouteOption(RouteOption routeOption) {
        this.mRerouteOption = routeOption;
    }

    /* loaded from: classes2.dex */
    public static final class Builder<T> {
        private boolean mBooleanValue;
        private byte[] mCrosTMC;
        private CrossImageInfo mCrossImageInfo;
        private ExitDirectionInfo mExitDirectionInfo;
        private int mIntValue;
        private LaneInfo mLaneInfo;
        private List<T> mList;
        private long[] mLongValue;
        private ManeuverInfo mManeuverInfo;
        private NaviCongestionInfo mNaviCongestionInfo;
        private RouteOption mRerouteOption;
        private RouteTrafficEventInfo mRouteTrafficEventInfo;
        private String mStringValue;
        private SuggestChangePathReason mSuggestChangePathReason;
        private TMCIncidentReport mTmcIncidentReport;
        private TollGateInfo mTollGateInfo;
        private int mType;

        public Builder(int i) {
            this.mType = i;
        }

        @NonNull
        public Builder setList(List<T> list) {
            this.mList = list;
            return this;
        }

        @NonNull
        public Builder setExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
            this.mExitDirectionInfo = exitDirectionInfo;
            return this;
        }

        @NonNull
        public Builder setCrossImageInfo(CrossImageInfo crossImageInfo) {
            this.mCrossImageInfo = crossImageInfo;
            return this;
        }

        @NonNull
        public Builder setIntValue(int i) {
            this.mIntValue = i;
            return this;
        }

        @NonNull
        public Builder setBooleanValue(boolean z) {
            this.mBooleanValue = z;
            return this;
        }

        @NonNull
        public Builder setNaviCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
            this.mNaviCongestionInfo = naviCongestionInfo;
            return this;
        }

        @NonNull
        public Builder setRouteTrafficEventInfo(RouteTrafficEventInfo routeTrafficEventInfo) {
            this.mRouteTrafficEventInfo = routeTrafficEventInfo;
            return this;
        }

        @NonNull
        public Builder setTmcIncidentReport(TMCIncidentReport tMCIncidentReport) {
            this.mTmcIncidentReport = tMCIncidentReport;
            return this;
        }

        @NonNull
        public Builder setStringValue(String str) {
            this.mStringValue = str;
            return this;
        }

        @NonNull
        public Builder setLongValue(long... jArr) {
            this.mLongValue = jArr;
            return this;
        }

        @NonNull
        public Builder setSuggestChangePathReason(SuggestChangePathReason suggestChangePathReason) {
            this.mSuggestChangePathReason = suggestChangePathReason;
            return this;
        }

        @NonNull
        public Builder setCrosTMC(byte[] bArr) {
            this.mCrosTMC = bArr;
            return this;
        }

        @NonNull
        public Builder setLaneInfo(LaneInfo laneInfo) {
            this.mLaneInfo = laneInfo;
            return this;
        }

        @NonNull
        public Builder setTollGateInfo(TollGateInfo tollGateInfo) {
            this.mTollGateInfo = tollGateInfo;
            return this;
        }

        @NonNull
        public Builder setManeuverInfo(ManeuverInfo maneuverInfo) {
            this.mManeuverInfo = maneuverInfo;
            return this;
        }

        @NonNull
        public Builder setType(int i) {
            this.mType = i;
            return this;
        }

        @NonNull
        public Builder setRerouteOption(RouteOption routeOption) {
            this.mRerouteOption = routeOption;
            return this;
        }

        public GuideWrapperNaviEvent build() {
            return new GuideWrapperNaviEvent(this);
        }
    }
}
