package com.xiaopeng.montecarlo.navcore.sr;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.SparseArray;
import com.autonavi.gbl.lane.LaneService;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneLineStyleInfo;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfo;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLDWInfo;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPWarnInfo;
import com.xiaopeng.montecarlo.navcore.event.SRDebugEvent;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class LaneServiceWrapper {
    private static final float DEFAULT_ANCHOR_IN_LEVEL = 18.7f;
    private static final float DEFAULT_ANCHOR_OUT_LEVEL = 19.0f;
    private static final float DEFAULT_HIGH_SPEED_LEVEL = 19.3f;
    private static final float DEFAULT_LOW_SPEED_LEVEL = 19.6f;
    private static final int LANE_LNDS_DIS_100 = 150;
    private static final int LANE_LNDS_DIS_200 = 250;
    private static final int TEXTURE_CONFIGURABLE_COUNT = 13;
    private static final int TEXTURE_CONFIGURABLE_START = 102;
    private static final int TEXTURE_ID_BICYCLE = 14;
    private static final int TEXTURE_ID_BICYCLE_BLUE = 15;
    private static final int TEXTURE_ID_BICYCLE_BLUE_NIGHT = 19;
    private static final int TEXTURE_ID_BICYCLE_GRAY = 16;
    private static final int TEXTURE_ID_BICYCLE_GRAY_NIGHT = 20;
    private static final int TEXTURE_ID_BICYCLE_MODEL = 13;
    private static final int TEXTURE_ID_BICYCLE_NIGHT = 18;
    private static final int TEXTURE_ID_BICYCLE_RED = 17;
    private static final int TEXTURE_ID_BICYCLE_RED_NIGHT = 21;
    private static final int TEXTURE_ID_BSD_LEFT = 112;
    private static final int TEXTURE_ID_BSD_RIGHT = 113;
    private static final int TEXTURE_ID_BUS = 23;
    private static final int TEXTURE_ID_BUS_BLUE = 24;
    private static final int TEXTURE_ID_BUS_BLUE_NIGHT = 28;
    private static final int TEXTURE_ID_BUS_GRAY = 25;
    private static final int TEXTURE_ID_BUS_GRAY_NIGHT = 29;
    private static final int TEXTURE_ID_BUS_MODEL = 22;
    private static final int TEXTURE_ID_BUS_NIGHT = 27;
    private static final int TEXTURE_ID_BUS_RED = 26;
    private static final int TEXTURE_ID_BUS_RED_NIGHT = 30;
    private static final int TEXTURE_ID_CAR = 32;
    private static final int TEXTURE_ID_CAR_BLUE = 33;
    private static final int TEXTURE_ID_CAR_BLUE_NIGHT = 37;
    private static final int TEXTURE_ID_CAR_DOOR_AND_TIRE = 105;
    private static final int TEXTURE_ID_CAR_DOOR_AND_TIRE_NIGHT = 107;
    private static final int TEXTURE_ID_CAR_FAR_LIGHT = 108;
    private static final int TEXTURE_ID_CAR_FRAME = 104;
    private static final int TEXTURE_ID_CAR_FRAME_NIGHT = 106;
    private static final int TEXTURE_ID_CAR_GRAY = 34;
    private static final int TEXTURE_ID_CAR_GRAY_NIGHT = 38;
    private static final int TEXTURE_ID_CAR_MODEL = 31;
    private static final int TEXTURE_ID_CAR_NEAR_LIGHT = 109;
    private static final int TEXTURE_ID_CAR_NIGHT = 36;
    private static final int TEXTURE_ID_CAR_RED = 35;
    private static final int TEXTURE_ID_CAR_RED_NIGHT = 39;
    private static final int TEXTURE_ID_CHEWEI = 5;
    private static final int TEXTURE_ID_CHEWEI_NIGHT = 11;
    private static final int TEXTURE_ID_CONEBARREL = 41;
    private static final int TEXTURE_ID_CONEBARREL_MODEL = 40;
    private static final int TEXTURE_ID_CONEBARREL_NIGHT = 42;
    private static final int TEXTURE_ID_CRASH_BARRELS = 44;
    private static final int TEXTURE_ID_CRASH_BARRELS_MODEL = 43;
    private static final int TEXTURE_ID_CRASH_BARRELS_NIGHT = 45;
    private static final int TEXTURE_ID_DENGDAI = 1;
    private static final int TEXTURE_ID_DENGDAI_NIGHT = 7;
    private static final int TEXTURE_ID_FCW_AND_AEB = 111;
    private static final int TEXTURE_ID_GUIDE = 3;
    private static final int TEXTURE_ID_GUIDE_NIGHT = 9;
    private static final int TEXTURE_ID_HIGHLIGHT = 2;
    private static final int TEXTURE_ID_HIGHLIGHT_NIGHT = 8;
    private static final int TEXTURE_ID_LCC = 6;
    private static final int TEXTURE_ID_LCC_NIGHT = 12;
    private static final int TEXTURE_ID_MIAOBIAN = 4;
    private static final int TEXTURE_ID_MIAOBIAN_NIGHT = 10;
    private static final int TEXTURE_ID_MOTORCYCLE = 50;
    private static final int TEXTURE_ID_MOTORCYCLE_BLUE = 51;
    private static final int TEXTURE_ID_MOTORCYCLE_BLUE_NIGHT = 55;
    private static final int TEXTURE_ID_MOTORCYCLE_GRAY = 52;
    private static final int TEXTURE_ID_MOTORCYCLE_GRAY_NIGHT = 56;
    private static final int TEXTURE_ID_MOTORCYCLE_MODEL = 49;
    private static final int TEXTURE_ID_MOTORCYCLE_NIGHT = 54;
    private static final int TEXTURE_ID_MOTORCYCLE_RED = 53;
    private static final int TEXTURE_ID_MOTORCYCLE_RED_NIGHT = 57;
    private static final int TEXTURE_ID_PEDDESTRIAN = 59;
    private static final int TEXTURE_ID_PEDDESTRIAN_BLUE = 60;
    private static final int TEXTURE_ID_PEDDESTRIAN_BLUE_NIGHT = 64;
    private static final int TEXTURE_ID_PEDDESTRIAN_GRAY = 61;
    private static final int TEXTURE_ID_PEDDESTRIAN_GRAY_NIGHT = 65;
    private static final int TEXTURE_ID_PEDDESTRIAN_MODEL = 58;
    private static final int TEXTURE_ID_PEDDESTRIAN_NIGHT = 63;
    private static final int TEXTURE_ID_PEDDESTRIAN_RED = 62;
    private static final int TEXTURE_ID_PEDDESTRIAN_RED_NIGHT = 66;
    private static final int TEXTURE_ID_PICKUP = 68;
    private static final int TEXTURE_ID_PICKUP_BLUE = 69;
    private static final int TEXTURE_ID_PICKUP_BLUE_NIGHT = 73;
    private static final int TEXTURE_ID_PICKUP_GRAY = 70;
    private static final int TEXTURE_ID_PICKUP_GRAY_NIGHT = 74;
    private static final int TEXTURE_ID_PICKUP_MODEL = 67;
    private static final int TEXTURE_ID_PICKUP_NIGHT = 72;
    private static final int TEXTURE_ID_PICKUP_RED = 71;
    private static final int TEXTURE_ID_PICKUP_RED_NIGHT = 75;
    private static final int TEXTURE_ID_RCW = 114;
    private static final int TEXTURE_ID_ROAD_BARRIER = 47;
    private static final int TEXTURE_ID_ROAD_BARRIER_MODEL = 46;
    private static final int TEXTURE_ID_ROAD_BARRIER_NIGHT = 48;
    private static final int TEXTURE_ID_SHADOW = 110;
    private static final int TEXTURE_ID_SHADOW_NIGHT = 115;
    private static final int TEXTURE_ID_SUV = 77;
    private static final int TEXTURE_ID_SUV_BLUE = 78;
    private static final int TEXTURE_ID_SUV_BLUE_NIGHT = 82;
    private static final int TEXTURE_ID_SUV_GRAY = 79;
    private static final int TEXTURE_ID_SUV_GRAY_NIGHT = 83;
    private static final int TEXTURE_ID_SUV_MODEL = 76;
    private static final int TEXTURE_ID_SUV_NIGHT = 81;
    private static final int TEXTURE_ID_SUV_RED = 80;
    private static final int TEXTURE_ID_SUV_RED_NIGHT = 84;
    private static final int TEXTURE_ID_TRICYCLE = 95;
    private static final int TEXTURE_ID_TRICYCLE_BLUE = 96;
    private static final int TEXTURE_ID_TRICYCLE_BLUE_NIGHT = 100;
    private static final int TEXTURE_ID_TRICYCLE_GRAY = 97;
    private static final int TEXTURE_ID_TRICYCLE_GRAY_NIGHT = 101;
    private static final int TEXTURE_ID_TRICYCLE_MODEL = 94;
    private static final int TEXTURE_ID_TRICYCLE_NIGHT = 99;
    private static final int TEXTURE_ID_TRICYCLE_RED = 98;
    private static final int TEXTURE_ID_TRICYCLE_RED_NIGHT = 102;
    private static final int TEXTURE_ID_TRUCK = 86;
    private static final int TEXTURE_ID_TRUCK_BLUE = 87;
    private static final int TEXTURE_ID_TRUCK_BLUE_NIGHT = 91;
    private static final int TEXTURE_ID_TRUCK_GRAY = 88;
    private static final int TEXTURE_ID_TRUCK_GRAY_NIGHT = 92;
    private static final int TEXTURE_ID_TRUCK_MODEL = 85;
    private static final int TEXTURE_ID_TRUCK_NIGHT = 90;
    private static final int TEXTURE_ID_TRUCK_RED = 89;
    private static final int TEXTURE_ID_TRUCK_RED_NIGHT = 93;
    private static final int TEXTURE_ID_ZICHE_MODEL = 103;
    private LaneService mLaneService;
    private IPlayerListener mPlayerListener;
    private static final AtomicInteger mUpdateTimes = new AtomicInteger(0);
    private static int mOffset = 0;
    private static final L.Tag TAG = new L.Tag("LaneServiceWrapper");
    public static final int BODY_COLOR = SystemProperties.getInt("persist.sys.xiaopeng.bodyColor", 0);
    public static final int SCISSORS_GATE = SystemProperties.getInt("persist.sys.xiaopeng.scissorsGate", 0);
    private static final String PATH = "/scissorsGate-" + SCISSORS_GATE + "/color-" + BODY_COLOR;
    private final SparseArray<String> mResourceList = new SparseArray<>();
    private boolean mIsPlayAMapLaneData = false;
    private boolean mIsDay = true;
    private final ILaneResourceProxy mILaneResourceProxy = new ILaneResourceProxy() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneServiceWrapper.1
        @Override // com.autonavi.gbl.lane.observer.ILaneResourceProxy
        public LaneResourceResponse onRequestResource(LaneResourceRequest laneResourceRequest) {
            String str;
            LaneResourceResponse laneResourceResponse = new LaneResourceResponse();
            int i = laneResourceRequest.resID;
            if (i > 102) {
                i -= LaneServiceWrapper.mOffset;
                if (L.ENABLE) {
                    L.d(LaneServiceWrapper.TAG, "ILaneResourceProxy  resID = " + laneResourceRequest.resID + ", mOffset = " + LaneServiceWrapper.mOffset + " , id = " + i);
                }
                if (!TextUtils.isEmpty((String) LaneServiceWrapper.this.mResourceList.get(i))) {
                    String str2 = RootUtil.getDataPath() + RootUtil.SD_CARD_DIR_SR_CAR_MODEL_DATA_PATH + File.separator + SettingWrapper.getSRCarModelVersion() + File.separator + str.replace(LaneServiceWrapper.PATH, "");
                    byte[] file2byte = FileUtil.file2byte(str2);
                    if (file2byte == null) {
                        L.w(LaneServiceWrapper.TAG, "loadDataFromConfigurableResFile data is null resID = " + laneResourceRequest.resID + ", path = " + str2 + " , id = " + i);
                    } else {
                        laneResourceResponse.resource.buffer = new BinaryStream(file2byte);
                        if (L.ENABLE) {
                            L.d(LaneServiceWrapper.TAG, "loadDataFromConfigurableResFile path = " + str2 + " , id = " + i);
                        }
                        return laneResourceResponse;
                    }
                }
            }
            String str3 = (String) LaneServiceWrapper.this.mResourceList.get(i);
            if (TextUtils.isEmpty(str3)) {
                L.w(LaneServiceWrapper.TAG, "mResourceList not contain id " + i);
            } else {
                String str4 = RootUtil.LAN_NAVI_ASSERT_RES_PATH + File.separator + str3;
                byte[] loadDataFromAssets = FileUtil.loadDataFromAssets(str4);
                if (loadDataFromAssets == null && str4.contains(LaneServiceWrapper.PATH)) {
                    str4 = str4.replace(LaneServiceWrapper.PATH, "");
                    if (L.ENABLE) {
                        L.d(LaneServiceWrapper.TAG, "loadDataFromAssets  fileName = " + str3 + " is not in assets, use default file in " + str4);
                    }
                    loadDataFromAssets = FileUtil.loadDataFromAssets(str4);
                }
                if (loadDataFromAssets == null) {
                    L.w(LaneServiceWrapper.TAG, "loadDataFromAssets data is null resID = " + i + ", path = " + str4 + " , fileName = " + str3);
                } else {
                    laneResourceResponse.resource.buffer = new BinaryStream(loadDataFromAssets);
                    if (L.ENABLE) {
                        L.d(LaneServiceWrapper.TAG, "loadDataFromAssets resID = " + i + ", path = " + str4 + " , fileName = " + str3);
                    }
                }
            }
            return laneResourceResponse;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneResourceProxy
        public LaneResourceResponse onRequestResourceFile(LaneResourceRequestFile laneResourceRequestFile) {
            String str;
            LaneResourceResponse laneResourceResponse = new LaneResourceResponse();
            String str2 = RootUtil.SD_CARD_NAVI_PATH + "/LaneResource/";
            if (laneResourceRequestFile.requestSource == 0) {
                str = str2 + laneResourceRequestFile.resourceFile;
            } else if (laneResourceRequestFile.requestSource == 1) {
                str = str2 + "laneRender/" + laneResourceRequestFile.resourceFile;
            } else {
                str = str2 + "lane/" + laneResourceRequestFile.resourceFile;
            }
            try {
                byte[] file2byte = FileUtil.file2byte(str);
                int length = file2byte == null ? 0 : file2byte.length;
                L.d(LaneServiceWrapper.TAG, "path=" + str + ",bufferLen=" + length + ",resFile=" + laneResourceRequestFile.resourceFile + ",requestSource=" + laneResourceRequestFile.requestSource);
                if (length > 0) {
                    laneResourceResponse.resource.buffer = new BinaryStream(file2byte);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return laneResourceResponse;
        }
    };
    private ILaneObserver mILaneObserver = new ILaneObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneServiceWrapper.2
        @Override // com.autonavi.gbl.lane.observer.ILaneObserver
        public void onAnchorScaleChange(int i) {
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
                    }
                    EventBus.getDefault().post(sRDebugEvent);
                }
                if (RootUtil.compareFloat(f, 0.0f)) {
                    SRNaviManager.getInstance().laneDisplayStChanged(1);
                } else if (f < 150.0f) {
                    SRNaviManager.getInstance().laneDisplayStChanged(1);
                } else if (f >= 250.0f) {
                    if (LaneServiceWrapper.this.mIsPlayAMapLaneData || SRNaviManager.getInstance().isXpuShowSREnabled()) {
                        SRNaviManager.getInstance().laneDisplayStChanged(0);
                    } else {
                        SRNaviManager.getInstance().laneDisplayStChanged(1);
                    }
                } else {
                    LocInfo currentLocInfo2 = TBTManager.getInstance().getCurrentLocInfo();
                    if (currentLocInfo2 == null || !CollectionUtils.isNotEmpty(currentLocInfo2.matchInfo)) {
                        return;
                    }
                    int i = currentLocInfo2.matchInfo.get(0).formway;
                    if (3 == i || 6 == i || 8 == i || 53 == i || 56 == i || 58 == i || 9 == i) {
                        SRNaviManager.getInstance().laneDisplayStChanged(1);
                    }
                }
            }
        }
    };
    private ILaneServicePlayerObserver mILaneServicePlayerObserver = new ILaneServicePlayerObserver() { // from class: com.xiaopeng.montecarlo.navcore.sr.LaneServiceWrapper.3
        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onCarHW(CarHWInfo carHWInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onCarStyle(CarStyleInfo carStyleInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecision(Decision decision) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLDW(LDWInfo lDWInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onLocSignData(LocSignData locSignData) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenDynamicViewAngle(boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenLCC(boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onOpenLNDSDataDownload(boolean z) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onSRObject(SRObjects sRObjects) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onWarn(WarnInfos warnInfos) {
            return false;
        }

        @Override // com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver
        public boolean onPlayProgress(long j, long j2, String str, long j3, long j4) {
            if (LaneServiceWrapper.this.mPlayerListener != null) {
                LaneServiceWrapper.this.mPlayerListener.onPlayProgress(j, j2, str, j3, j4);
                return false;
            }
            return false;
        }
    };

    /* loaded from: classes2.dex */
    public interface IPlayerListener {
        void onPlayProgress(long j, long j2, String str, long j3, long j4);
    }

    public float getDefaultAnchorInLevel() {
        return DEFAULT_ANCHOR_IN_LEVEL;
    }

    public float getDefaultAnchorOutLevel() {
        return DEFAULT_ANCHOR_OUT_LEVEL;
    }

    public float getDefaultHighSpeedLevel() {
        return DEFAULT_HIGH_SPEED_LEVEL;
    }

    public float getDefaultLowSpeedLevel() {
        return DEFAULT_LOW_SPEED_LEVEL;
    }

    public int getModelResId(int i) {
        switch (i) {
            case 1:
                return 58;
            case 2:
                return -1;
            case 3:
                return 31;
            case 4:
                return 76;
            case 5:
            case 9:
                return 85;
            case 6:
                return 13;
            case 7:
                return 94;
            case 8:
                return 49;
            case 10:
                return 22;
            case 11:
                return 67;
            default:
                switch (i) {
                    case 80:
                        return 43;
                    case 81:
                        return 46;
                    case 82:
                        return 40;
                    default:
                        return -1;
                }
        }
    }

    public boolean init() {
        if (this.mLaneService == null) {
            this.mLaneService = (LaneService) ServiceMgr.getServiceMgrInstance().getBLService(25);
            if (this.mLaneService == null) {
                L.e(TAG, "init LaneService failed");
                return false;
            }
        }
        initRes();
        this.mLaneService.setResourceProxy(this.mILaneResourceProxy);
        this.mLaneService.init(new LaneInitParam());
        this.mLaneService.openLaneWork(true);
        this.mLaneService.addLaneObserver(this.mILaneObserver);
        this.mLaneService.openNaviLine(false);
        this.mLaneService.openNaviLineFishbone(true);
        this.mLaneService.openNaviLineOutline(true);
        this.mLaneService.setNaviLineLength(2000.0f);
        this.mLaneService.openCalcRoadPolygon(SRNaviManager.getInstance().isLaneEnabled());
        this.mLaneService.openShowRoadPolygon(SRNaviManager.getInstance().isLaneEnabled());
        updateDynamicViewAngle(false);
        openFollowMode(false);
        return true;
    }

    public void attachToMapView() {
        LaneMapViewParam laneMapViewParam = new LaneMapViewParam();
        laneMapViewParam.mapEngineId = 1;
        this.mLaneService.attachMapView(laneMapViewParam);
        setCarHWInfo();
        updateStyle();
        CarServiceManager.getInstance().getCarType();
        setLaneDynamicLevel(1, DEFAULT_HIGH_SPEED_LEVEL);
        setLaneDynamicLevel(0, DEFAULT_LOW_SPEED_LEVEL);
        setLaneDynamicLevel(2, DEFAULT_ANCHOR_IN_LEVEL);
        setLaneDynamicLevel(3, DEFAULT_ANCHOR_OUT_LEVEL);
    }

    public boolean unInit() {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.detachMapView();
            this.mLaneService.removeLaneObserver(this.mILaneObserver);
            this.mLaneService.unInit();
            return true;
        }
        return true;
    }

    public void openNaviLine(boolean z) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.openNaviLine(z);
        }
    }

    public void enterLane(boolean z) {
        if (this.mLaneService != null) {
            boolean isNgpState = SRNaviManager.getInstance().isNgpState();
            if (z && !isNgpState && SRNaviManager.getInstance().isLaneEnabled()) {
                this.mLaneService.openNaviLine(true);
            } else {
                this.mLaneService.openNaviLine(false);
            }
            if (z) {
                setDynamicViewMode(isNgpState);
            }
            this.mLaneService.openDynamicViewAngle(z);
            this.mLaneService.openFollowMode(z);
            this.mLaneService.enterLane(z);
        }
    }

    public void setDynamicViewMode(boolean z) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.setDynamicViewMode(z ? 1 : 0);
        }
    }

    public void startRecord(boolean z) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.getLaneServiceRecorder().setRecordPath(RootUtil.SD_CARD_DIR_LANE_RECORD);
            if (z) {
                this.mLaneService.getLaneServiceRecorder().startRecord();
            } else {
                this.mLaneService.getLaneServiceRecorder().stopRecord();
            }
        }
    }

    public void startPlay(boolean z) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            this.mIsPlayAMapLaneData = z;
            if (z) {
                laneService.getLaneServicePlayer().startPlay();
                this.mLaneService.getLaneServicePlayer().registerServicePlayer(this.mILaneServicePlayerObserver);
                return;
            }
            laneService.getLaneServicePlayer().stopPlay();
            this.mLaneService.getLaneServicePlayer().unRegisterServicePlayer(this.mILaneServicePlayerObserver);
        }
    }

    public void resetPlay(boolean z) {
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.getLaneServicePlayer().setPlayerPath(RootUtil.SD_CARD_DIR_LANE_RECORD, 1);
            this.mIsPlayAMapLaneData = z;
            if (z) {
                this.mLaneService.getLaneServicePlayer().startPlay();
                this.mLaneService.getLaneServicePlayer().registerServicePlayer(this.mILaneServicePlayerObserver);
                return;
            }
            this.mLaneService.getLaneServicePlayer().stopPlay();
            this.mLaneService.getLaneServicePlayer().unRegisterServicePlayer(this.mILaneServicePlayerObserver);
        }
    }

    public boolean isPlayAMapLaneData() {
        return this.mIsPlayAMapLaneData;
    }

    public void setPlayIndex(long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPlayIndex playIndex:" + j);
        }
        LaneService laneService = this.mLaneService;
        if (laneService != null) {
            laneService.getLaneServicePlayer().setPlayIndex(j);
        }
    }

    public void setPlayerListener(IPlayerListener iPlayerListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPlayerListener " + iPlayerListener);
        }
        this.mPlayerListener = iPlayerListener;
    }

    public void onSwitchTheme(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onSwitchTheme isDay:" + z + ", mIsDay:" + this.mIsDay);
        if (this.mIsDay == z) {
            return;
        }
        this.mIsDay = z;
        updateStyle();
    }

    public void updateStyle() {
        setCarStyleInfo();
        setDecisionLineStyle();
        setDecisionDirectionStyle();
        setLDWLineStyle();
    }

    private boolean setCarHWInfo() {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setCarHWInfo mLaneService is null");
            }
            return false;
        }
        new CarHWInfo().posToCenterDistance = 1.45f;
        return false;
    }

    public boolean updateCarStyleInfo() {
        mOffset = mUpdateTimes.incrementAndGet() * 13;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateCarStyleInfo mOffset = " + mOffset);
        }
        return setCarStyleInfo();
    }

    public boolean setCarStyleInfo() {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setCarStyleInfo mLaneService is null");
                return false;
            }
            return false;
        }
        CarStyleInfo carStyleInfo = new CarStyleInfo();
        carStyleInfo.modelResID = mOffset + 103;
        carStyleInfo.carFrameTextureResID = (this.mIsDay ? 104 : 106) + mOffset;
        carStyleInfo.carDoorAndTireTextureResID = (this.mIsDay ? 105 : 107) + mOffset;
        carStyleInfo.carLightTextureResID = getCarLightResId();
        carStyleInfo.shadowTextureResID = (this.mIsDay ? 110 : 115) + mOffset;
        carStyleInfo.fcwAndAEBtextureResID = -1;
        carStyleInfo.bsdLeftTextureResID = -1;
        carStyleInfo.bsdRightTextureResID = -1;
        carStyleInfo.rcwTextureResID = -1;
        return this.mLaneService.setCarStyleInfo(carStyleInfo);
    }

    public boolean setDecision(Decision decision) {
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setDecision mLaneService is null");
            }
            return false;
        } else if (decision == null) {
            if (L.ENABLE) {
                L.d(TAG, "setDecision xpDecision is null");
            }
            return false;
        } else {
            return laneService.setDecision(decision);
        }
    }

    private int getCarLightResId() {
        int farLampState = CarServiceManager.getInstance().getFarLampState();
        int nearLampState = CarServiceManager.getInstance().getNearLampState();
        if (1 == farLampState) {
            return mOffset + 108;
        }
        if (1 == nearLampState) {
            return mOffset + 109;
        }
        return -1;
    }

    private boolean setDecisionLineStyle() {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setDecisionLineStyle mLaneService is null");
                return false;
            }
            return false;
        }
        DecisionLineStyleInfo decisionLineStyleInfo = new DecisionLineStyleInfo();
        LaneLineStyleInfo laneLineStyleInfo = new LaneLineStyleInfo();
        laneLineStyleInfo.lineWidth = 64.0f;
        laneLineStyleInfo.fillResID = this.mIsDay ? 1 : 7;
        decisionLineStyleInfo.warningStyle = laneLineStyleInfo;
        decisionLineStyleInfo.highLightResID = this.mIsDay ? 2 : 8;
        LaneLineStyleInfo laneLineStyleInfo2 = new LaneLineStyleInfo();
        laneLineStyleInfo2.lineWidth = 1.4f;
        laneLineStyleInfo2.fillResID = this.mIsDay ? 3 : 9;
        decisionLineStyleInfo.decisionStyle = laneLineStyleInfo2;
        LaneLineStyleInfo laneLineStyleInfo3 = new LaneLineStyleInfo();
        laneLineStyleInfo3.lineWidth = 30.0f;
        laneLineStyleInfo3.fillResID = -1;
        decisionLineStyleInfo.arrowStyle = laneLineStyleInfo3;
        LaneLineStyleInfo laneLineStyleInfo4 = new LaneLineStyleInfo();
        laneLineStyleInfo4.fillResID = this.mIsDay ? 6 : 12;
        laneLineStyleInfo4.lineWidth = 0.601344f;
        decisionLineStyleInfo.lccStyle = laneLineStyleInfo4;
        return this.mLaneService.setDecisionLineStyle(decisionLineStyleInfo);
    }

    private boolean setDecisionDirectionStyle() {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setDecisionDirectionStyle mLaneService is null");
                return false;
            }
            return false;
        }
        DecisionDirectionStyle decisionDirectionStyle = new DecisionDirectionStyle();
        decisionDirectionStyle.resID = this.mIsDay ? 5 : 11;
        return this.mLaneService.setDecisionDirectionStyle(decisionDirectionStyle);
    }

    public boolean setLDWInfo(XPLDWInfo xPLDWInfo) {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setLDWInfo mLaneService is null");
            }
            return false;
        } else if (xPLDWInfo == null) {
            if (L.ENABLE) {
                L.d(TAG, "setLDWInfo xpldwInfo is null");
            }
            return false;
        } else {
            LDWInfo lDWInfo = new LDWInfo();
            lDWInfo.direction = xPLDWInfo.getDirection();
            lDWInfo.status = xPLDWInfo.getStatus();
            return this.mLaneService.setLDWInfo(lDWInfo);
        }
    }

    private boolean setLDWLineStyle() {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setLDWLineStyle mLaneService is null");
                return false;
            }
            return false;
        }
        return this.mLaneService.setLDWLineStyle(new LDWLineStyleInfo());
    }

    public boolean setSRObject(SRObjects sRObjects) {
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setSRObject mLaneService is null");
            }
            return false;
        } else if (sRObjects == null) {
            if (L.ENABLE) {
                L.d(TAG, "setSRObject srObjects is null");
            }
            return false;
        } else {
            return laneService.setSRObject(sRObjects);
        }
    }

    public boolean setWarnInfo(ArrayList<XPWarnInfo> arrayList) {
        if (this.mLaneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "setWarnInfo mLaneService is null");
            }
            return false;
        } else if (CollectionUtils.isEmpty(arrayList)) {
            if (L.ENABLE) {
                L.d(TAG, "setWarnInfo xpWarnInfos is null");
            }
            return false;
        } else {
            WarnInfos warnInfos = new WarnInfos();
            Iterator<XPWarnInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                XPWarnInfo next = it.next();
                if (next != null) {
                    WarnInfo warnInfo = new WarnInfo();
                    warnInfo.bsdDirection = next.getBsdDirection();
                    warnInfo.warnType = next.getWarnType();
                    warnInfo.warnStatus = next.getWarnStatus();
                    warnInfo.warnGrade = next.getWarnGrade();
                    warnInfos.info.add(warnInfo);
                }
            }
            return this.mLaneService.setWarnInfo(warnInfos);
        }
    }

    public void openLCC(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "openLCC enable:" + z);
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "openLCC mLaneService is null");
                return;
            }
            return;
        }
        laneService.openLCC(z);
    }

    public void updateDynamicViewAngle(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "updateDynamicViewAngle " + z);
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            if (L.ENABLE) {
                L.d(TAG, "updateDynamicViewAngle mLaneService is null");
                return;
            }
            return;
        }
        laneService.openDynamicViewAngle(z);
    }

    public void openFollowMode(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openFollowMode " + z);
        }
        LaneService laneService = this.mLaneService;
        if (laneService == null) {
            L.w(TAG, "updateDynamicViewAngle mLaneService is null");
        } else {
            laneService.openFollowMode(z);
        }
    }

    private void initRes() {
        this.mResourceList.put(103, "ziche.dat");
        SparseArray<String> sparseArray = this.mResourceList;
        sparseArray.put(104, "Texture" + PATH + "/cheshen_day.png");
        SparseArray<String> sparseArray2 = this.mResourceList;
        sparseArray2.put(105, "Texture" + PATH + "/color_men_day.png");
        SparseArray<String> sparseArray3 = this.mResourceList;
        sparseArray3.put(106, "Texture" + PATH + "/cheshen_night.png");
        SparseArray<String> sparseArray4 = this.mResourceList;
        sparseArray4.put(107, "Texture" + PATH + "/color_men_night.png");
        this.mResourceList.put(108, "Texture/carlight_hb.png");
        this.mResourceList.put(109, "Texture/carlight_lb.png");
        this.mResourceList.put(110, "Texture/jiaoche_shadow_day.png");
        this.mResourceList.put(111, "Texture/qian.png");
        this.mResourceList.put(112, "Texture/zuohou.png");
        this.mResourceList.put(113, "Texture/youhou.png");
        this.mResourceList.put(114, "Texture/hou.png");
        this.mResourceList.put(115, "Texture/jiaoche_shadow_night.png");
        this.mResourceList.put(1, "DecisionLine/dengdaibiandao_day.png");
        this.mResourceList.put(2, "DecisionLine/gaoliangchedao_day.png");
        this.mResourceList.put(3, "DecisionLine/guide_day.png");
        this.mResourceList.put(4, "DecisionLine/lujingmiaobian_day.png");
        this.mResourceList.put(5, "DecisionLine/mubiaochewei_day.png");
        this.mResourceList.put(6, "DecisionLine/LCC_day.png");
        this.mResourceList.put(7, "DecisionLine/dengdaibiandao_night.png");
        this.mResourceList.put(8, "DecisionLine/gaoliangchedao_night.png");
        this.mResourceList.put(9, "DecisionLine/guide_night.png");
        this.mResourceList.put(10, "DecisionLine/lujingmiaobian_night.png");
        this.mResourceList.put(11, "DecisionLine/mubiaochewei_night.png");
        this.mResourceList.put(12, "DecisionLine/LCC_night.png");
        this.mResourceList.put(13, "Bicycle/zixingche.dat");
        this.mResourceList.put(14, "Bicycle/Texture/piczixingche_day.png");
        this.mResourceList.put(15, "Bicycle/Texture/piczixingche_blue_day.png");
        this.mResourceList.put(16, "Bicycle/Texture/piczixingche_gray_day.png");
        this.mResourceList.put(17, "Bicycle/Texture/piczixingche_red_day.png");
        this.mResourceList.put(18, "Bicycle/Texture/piczixingche_night.png");
        this.mResourceList.put(19, "Bicycle/Texture/piczixingche_blue_night.png");
        this.mResourceList.put(20, "Bicycle/Texture/piczixingche_gray_night.png");
        this.mResourceList.put(21, "Bicycle/Texture/piczixingche_red_night.png");
        this.mResourceList.put(22, "Bus/daba.dat");
        this.mResourceList.put(23, "Bus/Texture/daba_day.png");
        this.mResourceList.put(24, "Bus/Texture/daba_blue_day.png");
        this.mResourceList.put(25, "Bus/Texture/daba_gray_day.png");
        this.mResourceList.put(26, "Bus/Texture/daba_red_day.png");
        this.mResourceList.put(27, "Bus/Texture/daba_night.png");
        this.mResourceList.put(28, "Bus/Texture/daba_blue_night.png");
        this.mResourceList.put(29, "Bus/Texture/daba_gray_night.png");
        this.mResourceList.put(30, "Bus/Texture/daba_red_night.png");
        this.mResourceList.put(31, "Car/jiaoche.dat");
        this.mResourceList.put(32, "Car/Texture/jiaoche_day.png");
        this.mResourceList.put(33, "Car/Texture/jiaoche_blue_day.png");
        this.mResourceList.put(34, "Car/Texture/jiaoche_gray_day.png");
        this.mResourceList.put(35, "Car/Texture/jiaoche_red_day.png");
        this.mResourceList.put(36, "Car/Texture/jiaoche_night.png");
        this.mResourceList.put(37, "Car/Texture/jiaoche_blue_night.png");
        this.mResourceList.put(38, "Car/Texture/jiaoche_gray_night.png");
        this.mResourceList.put(39, "Car/Texture/jiaoche_red_night.png");
        this.mResourceList.put(40, "ConeBarrel/xuegaotong.dat");
        this.mResourceList.put(41, "ConeBarrel/Texture/traffic_cones_day.png");
        this.mResourceList.put(42, "ConeBarrel/Texture/traffic_cones_night.png");
        this.mResourceList.put(43, "Crash_Barrels/Crash_Barrels.dat");
        this.mResourceList.put(44, "Crash_Barrels/Texture/Crash_Barrels_day.png");
        this.mResourceList.put(45, "Crash_Barrels/Texture/Crash_Barrels_night.png");
        this.mResourceList.put(46, "Road_Barrier/Road_Barrier.dat");
        this.mResourceList.put(47, "Road_Barrier/Texture/Road_Barrier_day.png");
        this.mResourceList.put(48, "Road_Barrier/Texture/Road_Barrier_day.png");
        this.mResourceList.put(49, "Motorcycle/motuo.dat");
        this.mResourceList.put(50, "Motorcycle/Texture/moto_day.png");
        this.mResourceList.put(51, "Motorcycle/Texture/moto_blue_day.png");
        this.mResourceList.put(52, "Motorcycle/Texture/moto_gray_day.png");
        this.mResourceList.put(53, "Motorcycle/Texture/moto_red_day.png");
        this.mResourceList.put(54, "Motorcycle/Texture/moto_night.png");
        this.mResourceList.put(55, "Motorcycle/Texture/moto_blue_night.png");
        this.mResourceList.put(56, "Motorcycle/Texture/moto_gray_night.png");
        this.mResourceList.put(57, "Motorcycle/Texture/moto_red_night.png");
        this.mResourceList.put(58, "Pedestrian/xingren.dat");
        this.mResourceList.put(59, "Pedestrian/Texture/map_man_day.png");
        this.mResourceList.put(60, "Pedestrian/Texture/map_man_blue_day.png");
        this.mResourceList.put(61, "Pedestrian/Texture/map_man_gray_day.png");
        this.mResourceList.put(62, "Pedestrian/Texture/map_man_red_day.png");
        this.mResourceList.put(63, "Pedestrian/Texture/map_man_night.png");
        this.mResourceList.put(64, "Pedestrian/Texture/map_man_blue_night.png");
        this.mResourceList.put(65, "Pedestrian/Texture/map_man_gray_night.png");
        this.mResourceList.put(66, "Pedestrian/Texture/map_man_red_night.png");
        this.mResourceList.put(67, "Pick-upTruck/pika.dat");
        this.mResourceList.put(68, "Pick-upTruck/Texture/pika_map_day.png");
        this.mResourceList.put(69, "Pick-upTruck/Texture/pika_map_blue_day.png");
        this.mResourceList.put(70, "Pick-upTruck/Texture/pika_map_gray_day.png");
        this.mResourceList.put(71, "Pick-upTruck/Texture/pika_map_red_day.png");
        this.mResourceList.put(72, "Pick-upTruck/Texture/pika_map_night.png");
        this.mResourceList.put(73, "Pick-upTruck/Texture/pika_map_blue_night.png");
        this.mResourceList.put(74, "Pick-upTruck/Texture/pika_map_gray_night.png");
        this.mResourceList.put(75, "Pick-upTruck/Texture/pika_map_red_night.png");
        this.mResourceList.put(76, "SUV/suv.dat");
        this.mResourceList.put(77, "SUV/Texture/SUV_day.png");
        this.mResourceList.put(78, "SUV/Texture/SUV_blue_day.png");
        this.mResourceList.put(79, "SUV/Texture/SUV_gray_day.png");
        this.mResourceList.put(80, "SUV/Texture/SUV_red_day.png");
        this.mResourceList.put(81, "SUV/Texture/SUV_night.png");
        this.mResourceList.put(82, "SUV/Texture/SUV_blue_night.png");
        this.mResourceList.put(83, "SUV/Texture/SUV_gray_night.png");
        this.mResourceList.put(84, "SUV/Texture/SUV_red_night.png");
        this.mResourceList.put(85, "Truck/huoche.dat");
        this.mResourceList.put(86, "Truck/Texture/huoche_day.png");
        this.mResourceList.put(87, "Truck/Texture/huoche_blue_day.png");
        this.mResourceList.put(88, "Truck/Texture/huoche_gray_day.png");
        this.mResourceList.put(89, "Truck/Texture/huoche_red_day.png");
        this.mResourceList.put(90, "Truck/Texture/huoche_night.png");
        this.mResourceList.put(91, "Truck/Texture/huoche_blue_night.png");
        this.mResourceList.put(92, "Truck/Texture/huoche_gray_night.png");
        this.mResourceList.put(93, "Truck/Texture/huoche_red_night.png");
        this.mResourceList.put(94, "tricycle/tricycle.dat");
        this.mResourceList.put(95, "tricycle/Texture/tricycle_day.png");
        this.mResourceList.put(96, "tricycle/Texture/tricycle_blue_day.png");
        this.mResourceList.put(97, "tricycle/Texture/tricycle_gray_day.png");
        this.mResourceList.put(98, "tricycle/Texture/tricycle_red_day.png");
        this.mResourceList.put(99, "tricycle/Texture/tricycle_night.png");
        this.mResourceList.put(100, "tricycle/Texture/tricycle_blue_night.png");
        this.mResourceList.put(101, "tricycle/Texture/tricycle_gray_night.png");
        this.mResourceList.put(102, "tricycle/Texture/tricycle_red_night.png");
    }

    public int getTextureResId(int i, int i2) {
        int i3;
        switch (i) {
            case 1:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 65;
                                break;
                            } else {
                                i3 = 61;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 63;
                            break;
                        } else {
                            i3 = 59;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 66;
                        break;
                    } else {
                        i3 = 62;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 64;
                    break;
                } else {
                    i3 = 60;
                    break;
                }
            case 2:
                return -1;
            case 3:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 38;
                                break;
                            } else {
                                i3 = 34;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 36;
                            break;
                        } else {
                            i3 = 32;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 39;
                        break;
                    } else {
                        i3 = 35;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 37;
                    break;
                } else {
                    i3 = 33;
                    break;
                }
            case 4:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 83;
                                break;
                            } else {
                                i3 = 79;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 81;
                            break;
                        } else {
                            i3 = 77;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 84;
                        break;
                    } else {
                        i3 = 80;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 82;
                    break;
                } else {
                    i3 = 78;
                    break;
                }
            case 5:
            case 9:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 92;
                                break;
                            } else {
                                i3 = 88;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 90;
                            break;
                        } else {
                            i3 = 86;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 93;
                        break;
                    } else {
                        i3 = 89;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 91;
                    break;
                } else {
                    i3 = 87;
                    break;
                }
            case 6:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 20;
                                break;
                            } else {
                                i3 = 16;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 18;
                            break;
                        } else {
                            i3 = 14;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 21;
                        break;
                    } else {
                        i3 = 17;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 19;
                    break;
                } else {
                    i3 = 15;
                    break;
                }
            case 7:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 101;
                                break;
                            } else {
                                i3 = 97;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 99;
                            break;
                        } else {
                            i3 = 95;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 102;
                        break;
                    } else {
                        i3 = 98;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 100;
                    break;
                } else {
                    i3 = 96;
                    break;
                }
            case 8:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 56;
                                break;
                            } else {
                                i3 = 52;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 54;
                            break;
                        } else {
                            i3 = 50;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 57;
                        break;
                    } else {
                        i3 = 53;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 55;
                    break;
                } else {
                    i3 = 51;
                    break;
                }
            case 10:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 29;
                                break;
                            } else {
                                i3 = 25;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 27;
                            break;
                        } else {
                            i3 = 23;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 30;
                        break;
                    } else {
                        i3 = 26;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 28;
                    break;
                } else {
                    i3 = 24;
                    break;
                }
            case 11:
                if (4 != i2 && 5 != i2) {
                    if (3 != i2) {
                        if (6 == i2) {
                            if (!this.mIsDay) {
                                i3 = 74;
                                break;
                            } else {
                                i3 = 70;
                                break;
                            }
                        } else if (!this.mIsDay) {
                            i3 = 72;
                            break;
                        } else {
                            i3 = 68;
                            break;
                        }
                    } else if (!this.mIsDay) {
                        i3 = 75;
                        break;
                    } else {
                        i3 = 71;
                        break;
                    }
                } else if (!this.mIsDay) {
                    i3 = 73;
                    break;
                } else {
                    i3 = 69;
                    break;
                }
            default:
                switch (i) {
                    case 80:
                        if (!this.mIsDay) {
                            i3 = 45;
                            break;
                        } else {
                            i3 = 44;
                            break;
                        }
                    case 81:
                        if (!this.mIsDay) {
                            i3 = 48;
                            break;
                        } else {
                            i3 = 47;
                            break;
                        }
                    case 82:
                        if (!this.mIsDay) {
                            i3 = 42;
                            break;
                        } else {
                            i3 = 41;
                            break;
                        }
                    default:
                        return -1;
                }
        }
        return i3;
    }

    public void setLaneDynamicLevel(int i, float f) {
        this.mLaneService.setLaneDynamicLevel(i, f);
    }
}
