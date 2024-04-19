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
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.event.SRDebugEvent;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.DebugProperties;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import org.greenrobot.eventbus.EventBus;
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
            if (SRNaviManager.getInstance().isLaneEnabled()) {
                if (SRNaviManager.getInstance().getIsShowSRData()) {
                    SRDebugEvent sRDebugEvent = new SRDebugEvent(8);
                    sRDebugEvent.mTipsType = (int) f;
                    LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
                    if (currentLocInfo != null && CollectionUtils.isNotEmpty(currentLocInfo.matchInfo)) {
                        sRDebugEvent.mTipsType1 = currentLocInfo.matchInfo.get(0).formway;
                        EventBus.getDefault().post(sRDebugEvent);
                    }
                }
                if (RootUtil.compareFloat(f, 0.0f)) {
                    SRNaviManager.getInstance().laneDisplayStChanged(1);
                } else if (f < 150.0f) {
                    SRNaviManager.getInstance().laneDisplayStChanged(1);
                } else if (f < 250.0f) {
                    LocInfo currentLocInfo2 = TBTManager.getInstance().getCurrentLocInfo();
                    if (currentLocInfo2 == null || !CollectionUtils.isNotEmpty(currentLocInfo2.matchInfo)) {
                        return;
                    }
                    int i = currentLocInfo2.matchInfo.get(0).formway;
                    if (3 == i || 6 == i || 8 == i || 53 == i || 56 == i || 58 == i || 9 == i) {
                        SRNaviManager.getInstance().laneDisplayStChanged(1);
                    }
                } else if (LaneServiceManager.getInstance().isPlayAMapLaneData() || SRNaviManager.getInstance().isXpuShowSREnabled()) {
                    SRNaviManager.getInstance().laneDisplayStChanged(0);
                } else {
                    SRNaviManager.getInstance().laneDisplayStChanged(1);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServiceWrapper(ILaneResourceProxy iLaneResourceProxy) {
        init(iLaneResourceProxy);
    }

    private boolean init(ILaneResourceProxy iLaneResourceProxy) {
        if (this.mLaneService == null) {
            this.mLaneService = (LaneService) ServiceMgr.getServiceMgrInstance().getBLService(25);
            if (this.mLaneService == null) {
                L.e(TAG, "init LaneService failed");
                return false;
            }
        }
        this.mLaneServiceTool = this.mLaneService.getLaneServiceTool();
        this.mLaneService.setResourceProxy(iLaneResourceProxy);
        LaneInitParam laneInitParam = new LaneInitParam();
        boolean z = SystemProperties.getBoolean(DebugProperties.KEY_LANE_OFFLINE_MODE, false);
        boolean z2 = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DATA_DOUBLE_MODE, false);
        L.Tag tag = TAG;
        L.i(tag, "offlineDebug:" + z + ", dataModeDouble:" + z2);
        laneInitParam.offlineDebug = z;
        laneInitParam.dataMode = z2 ? 2 : 0;
        this.mLaneService.init(laneInitParam);
        this.mLaneService.addLaneObserver(this.mILaneObserver);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneRenderService createLaneRenderService(ILaneResourceProxy iLaneResourceProxy, int i) {
        LaneRenderParam laneRenderParam;
        L.Tag tag = TAG;
        L.i(tag, "engineId:" + i);
        if (1 == i) {
            laneRenderParam = new LaneRenderParam(0);
        } else {
            laneRenderParam = 3 == i ? new LaneRenderParam(1) : null;
        }
        if (laneRenderParam == null) {
            return null;
        }
        LaneRenderService createLaneRenderService = this.mLaneService.createLaneRenderService(laneRenderParam);
        LaneRenderInitParam laneRenderInitParam = new LaneRenderInitParam();
        createLaneRenderService.setResourceProxy(iLaneResourceProxy);
        createLaneRenderService.init(laneRenderInitParam);
        return createLaneRenderService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneNaviService createLaneRenderService() {
        return this.mLaneService.getLaneNaviService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServicePlayer createLaneServicePlayer() {
        return this.mLaneService.getLaneServicePlayer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneServiceRecorder createLaneServiceRecorder() {
        return this.mLaneService.getLaneServiceRecorder();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutopilotData(@NonNull byte[] bArr) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.setAutopilotData(new AutopilotData(new BinaryStream(bArr)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEHPVersion(String str) {
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
