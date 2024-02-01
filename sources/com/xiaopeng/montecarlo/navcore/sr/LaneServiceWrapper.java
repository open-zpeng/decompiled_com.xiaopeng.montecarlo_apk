package com.xiaopeng.montecarlo.navcore.sr;

import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.lane.LaneNaviService;
import com.autonavi.gbl.lane.LaneRenderService;
import com.autonavi.gbl.lane.LaneService;
import com.autonavi.gbl.lane.LaneServicePlayer;
import com.autonavi.gbl.lane.LaneServiceRecorder;
import com.autonavi.gbl.lane.LaneServiceTool;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneRenderInitParam;
import com.autonavi.gbl.lane.model.LaneRenderParam;
import com.autonavi.gbl.lane.model.LaneStatusInfo;
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.root.util.DebugProperties;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class LaneServiceWrapper {
    private static final int LANE_LNDS_DIS_100 = 150;
    private static final int LANE_LNDS_DIS_200 = 250;
    private static final L.Tag TAG = new L.Tag("LaneServiceWrapper");
    private LaneService mLaneService;
    private LaneServiceTool mLaneServiceTool;
    private String mLastEHPVersion = "";
    private ILaneObserver mILaneObserver = new ILaneObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneServiceWrapper.1
        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onAnchorScaleChange(int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onLaneNaviEnterPointDistance(float f) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onLaneNaviStatus(int i) {
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onLanePositionStatus(int i) {
            L.Tag tag = LaneServiceWrapper.TAG;
            L.i(tag, "onLanePositionStatus " + i);
            SRNaviManager.getInstance().setLaneModeEnable(i == 0);
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onLaneLndsDataDistance(float f) {
            L.Tag tag = LaneServiceWrapper.TAG;
            L.i(tag, "onLaneLndsDataDistance " + f);
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onLaneStatus(LaneStatusInfo laneStatusInfo) {
            L.Tag tag = LaneServiceWrapper.TAG;
            L.i(tag, "onLaneStatus enter  " + laneStatusInfo.enter);
            if (!laneStatusInfo.enter) {
                SRNaviManager.getInstance().laneDisplayStChanged(1);
            } else {
                SRNaviManager.getInstance().laneDisplayStChanged(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServiceWrapper(ILaneResourceProxy iLaneResourceProxy) {
        init(iLaneResourceProxy);
    }

    private boolean init(ILaneResourceProxy iLaneResourceProxy) {
        if (this.mLaneService == null) {
            this.mLaneService = (LaneService) ServiceMgr.getServiceMgrInstance().getBLService(26);
            if (this.mLaneService == null) {
                L.e(TAG, "init LaneService failed");
                return false;
            }
        }
        this.mLaneServiceTool = this.mLaneService.getLaneServiceTool();
        this.mLaneService.setResourceProxy(iLaneResourceProxy);
        LaneInitParam laneInitParam = new LaneInitParam();
        boolean z = SystemProperties.getBoolean(DebugProperties.KEY_LANE_OFFLINE_MODE, false);
        L.Tag tag = TAG;
        L.i(tag, "offlineDebug:" + z);
        laneInitParam.offlineDebug = z;
        laneInitParam.dataMode = 0;
        this.mLaneService.init(laneInitParam);
        this.mLaneService.addLaneObserver(this.mILaneObserver);
        this.mLaneService.setLNDSDataLimit(true, 5120);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneRenderService createLaneRenderService(ILaneResourceProxy iLaneResourceProxy, int i) {
        LaneRenderParam laneRenderParam;
        LaneService laneService;
        L.Tag tag = TAG;
        L.i(tag, "engineId:" + i);
        if (1 == i) {
            laneRenderParam = new LaneRenderParam(0);
        } else {
            laneRenderParam = 3 == i ? new LaneRenderParam(1) : null;
        }
        if (laneRenderParam == null || (laneService = this.mLaneService) == null) {
            return null;
        }
        LaneRenderService createLaneRenderService = laneService.createLaneRenderService(laneRenderParam);
        LaneRenderInitParam laneRenderInitParam = new LaneRenderInitParam();
        createLaneRenderService.setResourceProxy(iLaneResourceProxy);
        createLaneRenderService.init(laneRenderInitParam);
        return createLaneRenderService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneNaviService createLaneRenderService() {
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            return null;
        }
        return laneService.getLaneNaviService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServicePlayer createLaneServicePlayer() {
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            return null;
        }
        return laneService.getLaneServicePlayer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServiceRecorder createLaneServiceRecorder() {
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            return null;
        }
        return laneService.getLaneServiceRecorder();
    }

    public boolean unInit(LaneRenderService laneRenderService) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.removeLaneObserver(this.mILaneObserver);
            this.mLaneService.destroyLaneRenderService(laneRenderService);
            this.mLaneService.unInit();
            return true;
        }
        return true;
    }

    void setAutopilotData(@NonNull byte[] bArr) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.setAutopilotData(new AutopilotData(new BinaryStream(bArr)));
        }
    }

    void setEHPVersion(String str) {
        if (this.mLaneServiceTool == null || TextUtils.equals(this.mLastEHPVersion, str)) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "setEHPVersion version : " + str + ", mLastEHPVersion : " + this.mLastEHPVersion);
        this.mLastEHPVersion = str;
        this.mLaneServiceTool.sendHdDataVersion(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDriveMode(int i) {
        L.Tag tag = TAG;
        L.i(tag, "setDriveMode " + i);
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.setDriveMode(i);
        }
    }
}
