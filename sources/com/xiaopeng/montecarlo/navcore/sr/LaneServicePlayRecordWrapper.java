package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.lane.LaneServicePlayer;
import com.autonavi.gbl.lane.LaneServiceRecorder;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.ELKLineInfo;
import com.autonavi.gbl.lane.model.ELKLineStyle;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LKALineInfo;
import com.autonavi.gbl.lane.model.LKALineStyle;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.pos.model.GPSDatetime;
import com.autonavi.gbl.pos.model.LocSignData;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes3.dex */
public class LaneServicePlayRecordWrapper {
    private static final L.Tag TAG = new L.Tag("LaneServiceWrapper");
    private String mDateTime = "";
    private ILaneServicePlayerObserver mILaneServicePlayerObserver = new ILaneServicePlayerObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneServicePlayRecordWrapper.1
        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onAutopilotData(AutopilotData autopilotData) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onCarHW(int i, CarHWInfo carHWInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onCarStyle(int i, CarStyleInfo carStyleInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecision(int i, Decision decision) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecisionDirectionStyle(int i, DecisionDirectionStyle decisionDirectionStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecisionLineStyle(int i, DecisionLineStyleInfo decisionLineStyleInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onELKLineInfo(int i, ELKLineInfo eLKLineInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onELKLineStyle(int i, ELKLineStyle eLKLineStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLDWLineInfo(int i, LDWLineInfo lDWLineInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLDWLineStyle(int i, LDWLineStyle lDWLineStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLKALineInfo(int i, LKALineInfo lKALineInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLKALineStyle(int i, LKALineStyle lKALineStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLaneChangeFocusing(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLaneSideLineInfo(int i, LaneSideLineInfo laneSideLineInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLaneSideStyle(int i, LaneSideLineStyle laneSideLineStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenDynamicViewAngle(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenLCC(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenLNDSDataDownload(boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onRequestRoute(RouteOption routeOption) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onSRObject(int i, SRObjects sRObjects) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onSRRangeFilterParam(int i, LaneSRRangeFilterParam laneSRRangeFilterParam) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onShowNaviLine(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onShowNaviLineFishbone(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onShowNaviLineOutline(int i, boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onWarn(int i, WarnInfos warnInfos) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onPlayProgress(long j, long j2, String str, long j3, long j4) {
            if (LaneServicePlayRecordWrapper.this.mPlayerListener != null) {
                LaneServicePlayRecordWrapper.this.mPlayerListener.onPlayProgress(j, j2, str, j3, j4);
                return false;
            }
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLocSignData(LocSignData locSignData) {
            if (locSignData == null || locSignData.allFusionPos == null || locSignData.allFusionPos.dateTime == null) {
                return false;
            }
            GPSDatetime gPSDatetime = locSignData.allFusionPos.dateTime;
            String str = gPSDatetime.year + "-" + gPSDatetime.month + "-" + gPSDatetime.day + " " + gPSDatetime.hour + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + gPSDatetime.minute + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + gPSDatetime.second;
            if (str.equalsIgnoreCase(LaneServicePlayRecordWrapper.this.mDateTime)) {
                return false;
            }
            LaneServicePlayRecordWrapper.this.mDateTime = str;
            if (LaneServicePlayRecordWrapper.this.mPlayerListener != null) {
                LaneServicePlayRecordWrapper.this.mPlayerListener.onTimeChanged(LaneServicePlayRecordWrapper.this.mDateTime);
                return false;
            }
            return false;
        }
    };
    private LaneServicePlayer mLaneServicePlayer;
    private LaneServiceRecorder mLaneServiceRecorder;
    private IPlayerListener mPlayerListener;

    /* loaded from: classes3.dex */
    public interface IPlayerListener {
        void onPlayProgress(long j, long j2, String str, long j3, long j4);

        void onTimeChanged(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServicePlayRecordWrapper(LaneServicePlayer laneServicePlayer, LaneServiceRecorder laneServiceRecorder) {
        this.mLaneServicePlayer = laneServicePlayer;
        this.mLaneServiceRecorder = laneServiceRecorder;
        this.mLaneServiceRecorder.setRecordPath(RootUtil.SD_CARD_DIR_LANE_RECORD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPlay(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "startPlay " + z);
        LaneServicePlayer laneServicePlayer = this.mLaneServicePlayer;
        if (laneServicePlayer != null) {
            if (z) {
                laneServicePlayer.startPlay();
                this.mLaneServicePlayer.registerServicePlayer(this.mILaneServicePlayerObserver);
                return;
            }
            laneServicePlayer.stopPlay();
            this.mLaneServicePlayer.unRegisterServicePlayer(this.mILaneServicePlayerObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetPlay(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "resetPlay " + z);
        LaneServicePlayer laneServicePlayer = this.mLaneServicePlayer;
        if (laneServicePlayer != null) {
            laneServicePlayer.setPlayerPath(RootUtil.SD_CARD_DIR_LANE_RECORD, 1);
            if (z) {
                this.mLaneServicePlayer.startPlay();
                this.mLaneServicePlayer.registerServicePlayer(this.mILaneServicePlayerObserver);
                return;
            }
            this.mLaneServicePlayer.stopPlay();
            this.mLaneServicePlayer.unRegisterServicePlayer(this.mILaneServicePlayerObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlayIndex(long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPlayIndex playIndex:" + j);
        }
        LaneServicePlayer laneServicePlayer = this.mLaneServicePlayer;
        if (laneServicePlayer != null) {
            laneServicePlayer.setPlayIndex(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaySpeed(float f) {
        L.Tag tag = TAG;
        L.i(tag, "setPlaySpeed speed:" + f);
        LaneServicePlayer laneServicePlayer = this.mLaneServicePlayer;
        if (laneServicePlayer != null) {
            laneServicePlayer.setPlaySpeed(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecord(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "startRecord " + z);
        LaneServiceRecorder laneServiceRecorder = this.mLaneServiceRecorder;
        if (laneServiceRecorder != null) {
            if (z) {
                laneServiceRecorder.startRecord();
            } else {
                laneServiceRecorder.stopRecord();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlayerListener(IPlayerListener iPlayerListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPlayerListener " + iPlayerListener);
        }
        this.mPlayerListener = iPlayerListener;
    }
}
