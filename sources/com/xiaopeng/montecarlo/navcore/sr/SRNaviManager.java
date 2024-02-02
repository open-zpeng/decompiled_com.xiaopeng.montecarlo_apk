package com.xiaopeng.montecarlo.navcore.sr;

import android.os.SystemClock;
import android.util.SparseArray;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.pos.model.LocAllFusionPos;
import com.autonavi.gbl.pos.model.LocDrPos;
import com.autonavi.gbl.pos.model.LocVision;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLDWInfo;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocAcce3d;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocGpgsv;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocGyro;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocPulse;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocVisualObj;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPWarnInfo;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.listener.SrRecordDataStrategyConfigListener;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xpilot.sr.proto.Overall;
/* loaded from: classes2.dex */
public class SRNaviManager {
    public static final int MAX_DATA_DELAY_TIME = 100;
    public static final int NGP_PANEL_STATUS_AUTO = 1;
    public static final int NGP_PANEL_STATUS_AUTO_SMALL = 2;
    public static final int NGP_PANEL_STATUS_LOADING = 5;
    public static final int NGP_PANEL_STATUS_NONE = -1;
    public static final int NGP_PANEL_STATUS_NORMAL = 0;
    public static final int NGP_PANEL_STATUS_NORMAL_CLICK = 4;
    public static final int NGP_PANEL_STATUS_NORMAL_CLOSE = 3;
    public static final long SR_DATA_INTERVAL_LEVEL1 = 20000;
    public static final int SR_DATA_INTERVAL_LEVEL2 = 1000;
    public static final int SR_DATA_INTERVAL_LEVEL3 = 45;
    public static final int SR_LOG_PRINT_FREQUENCY = 100;
    public static final int SR_START_PROCESS_TIME = 20000;
    public static final int TIME_DEALY_REGIST_SR_CARSERVICE = 5000;
    public static final int WARNING_TYPE_AEB = 4;
    public static final int WARNING_TYPE_BSD_LEFT = 6;
    public static final int WARNING_TYPE_BSD_RIGHT = 7;
    public static final int WARNING_TYPE_DOW_LEFT = 9;
    public static final int WARNING_TYPE_DOW_RIGHT = 8;
    public static final int WARNING_TYPE_EBA = 3;
    public static final int WARNING_TYPE_FCW = 2;
    public static final int WARNING_TYPE_LDW_LEFT = 0;
    public static final int WARNING_TYPE_LDW_RIGHT = 1;
    public static final int WARNING_TYPE_MRR = 5;
    public static final int WARNING_TYPE_RCTA_LEFT = 10;
    public static final int WARNING_TYPE_RCTA_RIGHT = 11;
    public static final int WARNING_TYPE_RCW = 12;
    private SrRecordDataStrategyConfigListener mConfigListener;
    private float mCurrentAnchorInLevel;
    private float mCurrentAnchorOutLevel;
    private float mCurrentHighSpeedLevel;
    private float mCurrentLowSpeedLevel;
    private PosServiceWrapper mLanePosServiceWrapper;
    private LaneServiceWrapper mLaneServiceWrapper;
    private static final SRNaviManager sInstance = new SRNaviManager();
    private static final L.Tag TAG = new L.Tag("SRNaviManager");
    private static final String SR_REPORTER_FOLDER = RootUtil.DIR_PROTO_DATA_LOG;
    public int mLastAlertType = -1;
    boolean mIsBackground = false;
    boolean mIsSrResumed = false;
    private SparseArray<XPWarnInfo> mXPWarnInfoSparseArray = new SparseArray<>();
    private boolean mIsShowSRData = false;
    private boolean mIsDay = true;
    private boolean mLaneModeEnable = false;
    private volatile int mLaneDisplayState = 1;
    private long mDataCount = 0;
    private long mLastAcceptTime = 0;
    private int mNgpPanelStatus = -1;
    private final SRNaviDataHelper mDataHelper = new SRNaviDataHelper(this);
    private final SRNaviCanDataHelper mSRNaviCanDataHelper = new SRNaviCanDataHelper(this);
    private final CopyOnWriteArrayList<ISRInfoChangedListener> mSRInfoChangedListeners = new CopyOnWriteArrayList<>();

    private int getNgpStrongAlertTypeByLcTips(int i) {
        if (34 == i || 35 == i || 40 == i || 47 == i || 57 == i || 60 == i || 59 == i || 63 == i) {
            return 1;
        }
        return 53 == i ? 2 : 0;
    }

    private int getNgpStrongAlertTypeByQuitNgpOddStatus(int i) {
        return 6 == i ? 1 : 0;
    }

    private SRNaviManager() {
    }

    public static SRNaviManager getInstance() {
        return sInstance;
    }

    public void resetSRNaviDataInfo() {
        this.mLaneDisplayState = 1;
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            sRNaviDataHelper.resetSRInfo();
        }
    }

    public void resetLaneDisplayStateInvalid() {
        L.i(TAG, "resetLaneDisplayStateInvalid");
        this.mLaneDisplayState = -1;
    }

    public boolean init() {
        if (CarServiceManager.getInstance().hasXpuForNgp()) {
            initLaneService();
            initPosService();
            this.mDataHelper.start();
            this.mSRNaviCanDataHelper.start();
            this.mIsShowSRData = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_SHOW_SR_DATA, false);
            initRecordStrategy();
            this.mConfigListener = new SrRecordDataStrategyConfigListener();
            ConfigurationModuleManager.getInstance().registerWebConfigurationListener(this.mConfigListener);
            return true;
        }
        return false;
    }

    public boolean unInit() {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper != null) {
            posServiceWrapper.unInit();
        }
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.unInit();
        }
        this.mSRInfoChangedListeners.clear();
        this.mDataHelper.stop();
        this.mSRNaviCanDataHelper.stop();
        this.mDataCount = 0L;
        this.mLastAcceptTime = 0L;
        ConfigurationModuleManager.getInstance().unregisterWebConfigurationListener(this.mConfigListener);
        this.mConfigListener = null;
        SRDataForceRecordUtil.getInstance().stopRecord();
        return true;
    }

    public void initLaneService() {
        L.Tag tag = TAG;
        L.i(tag, "initLaneService " + this.mIsDay);
        if (this.mLaneServiceWrapper == null) {
            this.mLaneServiceWrapper = new LaneServiceWrapper();
            this.mLaneServiceWrapper.init();
            this.mLaneServiceWrapper.onSwitchTheme(this.mIsDay);
        }
    }

    public void attachToMapView() {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.attachToMapView();
        }
    }

    public boolean isLaneEnabled() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, true);
    }

    public void updateLaneStyle() {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.updateStyle();
        }
    }

    public void enterLane(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.enterLane(z);
            isSrSceneExsit(z);
        }
    }

    public void startRecord(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.startRecord(z);
        }
    }

    public void resetPlay(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.resetPlay(z);
        }
    }

    public boolean isPlayAMapLaneData() {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.isPlayAMapLaneData();
        }
        return false;
    }

    public void openNaviLine(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.openNaviLine(z);
        }
    }

    public void startPlay(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startPlay play = " + z);
        }
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.startPlay(z);
        }
    }

    public void setPlayIndex(long j) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setPlayIndex(j);
        }
    }

    public void setPlayerListener(LaneServiceWrapper.IPlayerListener iPlayerListener) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setPlayerListener(iPlayerListener);
        }
    }

    private void initPosService() {
        if (this.mLanePosServiceWrapper == null) {
            int carType = CarServiceManager.getInstance().getCarType();
            boolean isAutoPolitIMUEnable = CarFeatureManager.INSTANCE.isAutoPolitIMUEnable();
            this.mLanePosServiceWrapper = TBTManager.getInstance().getPosServiceWrapper();
            this.mLanePosServiceWrapper.initPos(!NavCoreUtil.isGpsDebugMode(), carType, isAutoPolitIMUEnable);
        }
    }

    public boolean updateCarStyle() {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.updateCarStyleInfo();
        }
        return false;
    }

    public boolean getIsShowSRData() {
        return this.mIsShowSRData;
    }

    public void setIsShowSRData(boolean z) {
        this.mIsShowSRData = z;
    }

    public void setIsSrDataRecord(boolean z) {
        if (z && !SRDataForceRecordUtil.getInstance().isTestMode()) {
            File file = new File(SR_REPORTER_FOLDER);
            if (!file.exists()) {
                file.mkdirs();
                FileUtil.setFileWith755Permission(file);
            }
        }
        SRDataForceRecordUtil.getInstance().setIsTestMode(z);
    }

    public boolean isLaneModeEnable() {
        return this.mLaneModeEnable;
    }

    public void setLaneModeEnable(boolean z) {
        if (z) {
            this.mLaneModeEnable = true;
        }
    }

    public void onSwitchTheme(boolean z) {
        this.mIsDay = z;
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.onSwitchTheme(this.mIsDay);
        }
    }

    public boolean isXpuSRDisplay() {
        return getXpuSRDisplayState() == 1;
    }

    public int getXpuSRDisplayState() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getSRInfo().getSRDisplayState();
        }
        return 2;
    }

    public boolean isXpuShowSREnabled() {
        int xpuSRDisplayState = getXpuSRDisplayState();
        return xpuSRDisplayState == 4 || xpuSRDisplayState == 1;
    }

    public synchronized boolean canShowSRScene() {
        if (L.ENABLE) {
            L.d(TAG, "isLaneEnabled:" + isLaneEnabled() + " isXpuShowSREnabled :" + isXpuShowSREnabled() + " mLaneDisplayState:" + this.mLaneDisplayState);
        }
        boolean z = false;
        if (CarServiceManager.getInstance().isNGPOn()) {
            if (isLaneEnabled()) {
                if (isLaneDisplayed() || (isXpuSRDisplay() && isLaneModeEnable())) {
                    z = true;
                }
                return z;
            }
            if (isXpuSRDisplay() && isLaneModeEnable()) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public boolean isLaneDisplayed() {
        return isPlayAMapLaneData() ? this.mLaneDisplayState == 0 : this.mLaneDisplayState == 0 && isXpuShowSREnabled();
    }

    public synchronized void addSRInfoChangedListener(ISRInfoChangedListener iSRInfoChangedListener) {
        if (this.mSRInfoChangedListeners.contains(iSRInfoChangedListener)) {
            L.Tag tag = TAG;
            L.w(tag, "addSRInfoChangedListener already added,listener:" + iSRInfoChangedListener);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "addSRInfoChangedListener listener:" + iSRInfoChangedListener);
        }
        this.mSRInfoChangedListeners.add(iSRInfoChangedListener);
    }

    public synchronized void removeSRInfoChangedListener(ISRInfoChangedListener iSRInfoChangedListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "removeSRInfoChangedListener listener:" + iSRInfoChangedListener);
        }
        this.mSRInfoChangedListeners.remove(iSRInfoChangedListener);
    }

    public void sendCanWarningInfo(int i, int i2) {
        if (L.ENABLE) {
            L.d(TAG, L.formatSRLog("sendCanWarningInfo " + i + ", " + i2));
        }
        if (i == 0 || i == 1) {
            XPLDWInfo xPLDWInfo = new XPLDWInfo();
            if (1 == i) {
                xPLDWInfo.setDirection(1);
            } else {
                xPLDWInfo.setDirection(0);
            }
            xPLDWInfo.setStatus(2 == i2 ? 1 : 0);
            LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
            if (laneServiceWrapper != null) {
                laneServiceWrapper.setLDWInfo(xPLDWInfo);
            }
        } else if (i == 2 || i == 4 || i == 12 || i == 6 || i == 7) {
            XPWarnInfo xPWarnInfo = new XPWarnInfo();
            if (2 == i) {
                xPWarnInfo.setBsdDirection(0);
                xPWarnInfo.setWarnType(0);
                xPWarnInfo.setWarnStatus(i2 == 0 ? 0 : 1);
            } else if (4 == i) {
                xPWarnInfo.setBsdDirection(0);
                xPWarnInfo.setWarnType(1);
                xPWarnInfo.setWarnStatus(i2 == 0 ? 0 : 1);
            } else if (12 == i) {
                xPWarnInfo.setBsdDirection(0);
                xPWarnInfo.setWarnType(2);
                xPWarnInfo.setWarnStatus(i2 == 0 ? 0 : 1);
            } else if (6 == i) {
                xPWarnInfo.setBsdDirection(1);
                xPWarnInfo.setWarnType(3);
                xPWarnInfo.setWarnStatus(i2 == 0 ? 0 : 1);
            } else {
                xPWarnInfo.setBsdDirection(2);
                xPWarnInfo.setWarnType(3);
                xPWarnInfo.setWarnStatus(i2 == 0 ? 0 : 1);
            }
            if (i2 > 2) {
                i2 = 2;
            }
            xPWarnInfo.setWarnGrade(i2);
            this.mXPWarnInfoSparseArray.put(i, xPWarnInfo);
            ArrayList<XPWarnInfo> arrayList = new ArrayList<>();
            while (r1 < this.mXPWarnInfoSparseArray.size()) {
                arrayList.add(this.mXPWarnInfoSparseArray.get(r1));
                r1++;
            }
            LaneServiceWrapper laneServiceWrapper2 = this.mLaneServiceWrapper;
            if (laneServiceWrapper2 != null) {
                laneServiceWrapper2.setWarnInfo(arrayList);
            }
            if (xPWarnInfo.getWarnGrade() == 0) {
                this.mXPWarnInfoSparseArray.delete(i);
            }
        }
    }

    public boolean setSRObject(SRObjects sRObjects) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.setSRObject(sRObjects);
        }
        return false;
    }

    public boolean setDecisionInfo(Decision decision) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.setDecision(decision);
        }
        return false;
    }

    public int getModelResId(int i) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.getModelResId(i);
        }
        return -1;
    }

    public int getTextureResId(int i, int i2) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            return laneServiceWrapper.getTextureResId(i, i2);
        }
        return -1;
    }

    public void setSignalRecordSwitch(boolean z) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper != null) {
            posServiceWrapper.setSignalRecordSwitch(z);
        }
    }

    public void setLocGpgsv(XPLocGpgsv xPLocGpgsv) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocGpgsv mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocGpgsv(xPLocGpgsv);
        }
    }

    public void setLocGyro(XPLocGyro xPLocGyro) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocGyro mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocGyro(xPLocGyro);
        }
    }

    public void setLocPulse(XPLocPulse xPLocPulse) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocPulse mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocPulse(xPLocPulse);
        }
    }

    public void setLocAcce3d(XPLocAcce3d xPLocAcce3d) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocAcce3d mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocAcce3d(xPLocAcce3d);
        }
    }

    public void setLocVision(LocVision locVision) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocVision mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocVision(locVision);
        }
    }

    public void setLocVisualObj(XPLocVisualObj xPLocVisualObj) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setLocVisualObj mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setLocVisualObj(xPLocVisualObj);
        }
    }

    public void setDrPos(LocDrPos locDrPos) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setDrPos mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setDrPos(locDrPos);
        }
    }

    public void setAllFusionPos(LocAllFusionPos locAllFusionPos) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper == null) {
            L.w(TAG, "setAllFusionPos mLanePosServiceWrapper is null");
        } else {
            posServiceWrapper.setAllFusionPos(locAllFusionPos);
        }
    }

    public void onSrRdPeriodDataComing(byte[] bArr, long j) {
        analysisSRData(bArr, j, SystemClock.uptimeMillis());
    }

    public void simulatorProto(final Overall.overall overallVar) {
        WorkThreadUtil.getInstance().executeSRTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$SRNaviManager$7EjG4U0nu7U5N_i9P0cLSwe1k_I
            @Override // java.lang.Runnable
            public final void run() {
                SRNaviManager.this.lambda$simulatorProto$0$SRNaviManager(overallVar);
            }
        });
    }

    public /* synthetic */ void lambda$simulatorProto$0$SRNaviManager(Overall.overall overallVar) {
        if (this.mDataHelper != null) {
            try {
                this.mDataHelper.routeSr2RdXpuDataV1(overallVar, TBTManager.getInstance().getCurrentStatus() == 0, -1L, -1L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void analysisSRData(final byte[] bArr, final long j, final long j2) {
        final boolean z = TBTManager.getInstance().getCurrentStatus() == 0;
        long j3 = 1000;
        if (z || !CarServiceManager.getInstance().isNGPOn() || (j > 0 && j <= SR_DATA_INTERVAL_LEVEL1)) {
            j3 = 20000;
        } else if (!this.mIsBackground && this.mIsSrResumed && j2 - j < 100) {
            j3 = 45;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mDataCount++;
        if (0 == this.mDataCount % 100) {
            L.i(TAG, "analysisSRData ngp:" + CarServiceManager.getInstance().isNGPOn() + ", dataCount:" + this.mDataCount + ", minInterval:" + j3 + ", mIsSrResumed:" + this.mIsSrResumed + ", mIsBackground:" + this.mIsBackground);
        }
        if (uptimeMillis - this.mLastAcceptTime < j3) {
            return;
        }
        this.mLastAcceptTime = uptimeMillis;
        WorkThreadUtil.getInstance().executeSRTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$SRNaviManager$k1F9qAPcoWWN85SIoJhGMGUUDTg
            @Override // java.lang.Runnable
            public final void run() {
                SRNaviManager.this.lambda$analysisSRData$1$SRNaviManager(bArr, z, j, j2);
            }
        });
    }

    public /* synthetic */ void lambda$analysisSRData$1$SRNaviManager(byte[] bArr, boolean z, long j, long j2) {
        if (this.mDataHelper != null) {
            try {
                Overall.overall parseFrom = Overall.overall.parseFrom(bArr);
                recordData(parseFrom);
                this.mDataHelper.routeSr2RdXpuDataV1(parseFrom, z, j, j2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void recordData(final Overall.overall overallVar) {
        if (ProtoSimulator.getInstance().isRunning() || overallVar == null) {
            return;
        }
        int saveProtoSignal = overallVar.getSaveProtoSignal();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "recordData saveProtoSignal:" + saveProtoSignal);
        }
        if (SRDataForceRecordUtil.getInstance().isTestMode() || 1 == saveProtoSignal || 2 == saveProtoSignal) {
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$SRNaviManager$xQO5zdib4r6OyTF5UnezE7JXyXw
                @Override // java.lang.Runnable
                public final void run() {
                    SRDataForceRecordUtil.getInstance().record(Overall.overall.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void srSpdViewChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "srSpdViewChanged level:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onXpuSRSpdViewChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void srLCViewChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "srLCViewChanged mode:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onXpuSRLCViewChanged(i);
        }
    }

    public void srDisplayStChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "srDisplayStChanged state:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onXpuSRDisplayStChanged(i);
        }
    }

    public synchronized void laneDisplayStChanged(int i) {
        if (i == this.mLaneDisplayState) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "laneDisplayStChanged state:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        this.mLaneDisplayState = i;
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onLaneViewDisplayChanged(i);
        }
    }

    public void setDynamicViewMode(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setDynamicViewMode(z);
        }
    }

    public void onDriveModeChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onDriveModeChange mode:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDriveModeChanged(i);
        }
    }

    public void onLccLightChange(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.openLCC(z);
        }
    }

    public void updateDynamicViewAngle(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.updateDynamicViewAngle(z);
        }
    }

    public void openFollowMode(boolean z) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.openFollowMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void srVehSpeedChanged(float f) {
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onXpuVehSpeedChanged(f);
        }
    }

    public float getVehSpeed() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getVehSpeed();
        }
        return 0.0f;
    }

    public int getSRDisplayState() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getSRDisplayState();
        }
        return 2;
    }

    public int getSRSpdViewMode() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getSRSpdViewMode();
        }
        return 0;
    }

    public int getSRLcViewMode() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getSRLcViewMode();
        }
        return 0;
    }

    public int getDriveMode() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getDriveMode();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLimitSpeed(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onLimitSpeed speed:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuLimitSpeed(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCruiseSpeed(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onCruiseSpeed speed:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuCruiseSpeed(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScuNgpOpeButton(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onScuNgpOpeButton status:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpOpeButton(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScuNgpLcTips1AndNgpOddStatus(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "onScuNgpLcTips1AndNgpOddStatus lcTipsStatus:" + i + " ngpQuitOddStatus:" + i2);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpLcTips1AndNgpOddStatus(i, i2);
        }
    }

    private void sendNgpStrongAlertToXUI(int i, int i2) {
        int ngpStrongAlertTypeByQuitNgpOddStatus = getNgpStrongAlertTypeByQuitNgpOddStatus(i2);
        if (ngpStrongAlertTypeByQuitNgpOddStatus == 0) {
            ngpStrongAlertTypeByQuitNgpOddStatus = getNgpStrongAlertTypeByLcTips(i);
        }
        if (ngpStrongAlertTypeByQuitNgpOddStatus != this.mLastAlertType) {
            this.mLastAlertType = ngpStrongAlertTypeByQuitNgpOddStatus;
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.SRNaviManager.1
                @Override // java.lang.Runnable
                public void run() {
                    XUIServiceManager.getInstance().sendXPilotStrongAlert(SRNaviManager.this.mLastAlertType);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScuNgpLcTips1TTS(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onScuNgpLcTips1TTS status:" + i);
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpLcTips1TTS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScuNgpInfoTips1(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onScuNgpInfoTips1 status:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpInfoTips1(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScuNgpTipsWindow(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onScuNgpTipsWindow status:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpTipsWindow(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFarLampStateChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onFarLampStateChange status:" + i);
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setCarStyleInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNearLampStateChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onNearLampStateChange status:" + i);
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setCarStyleInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void srNgpLaneChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "srNgpLaneChanged mode:" + i + ",mSRInfoChangedListeners:" + this.mSRInfoChangedListeners.size());
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpLaneChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void outBLRenderFPS() {
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().outBLRenderFPS();
        }
    }

    public int getLimitSpeed() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getLimitSpeed();
        }
        return 0;
    }

    public int getCruiseSpeed() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getCruiseSpeed();
        }
        return 0;
    }

    public int getScuQuitNgpOddStatus() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getQuitNGPODDStatus();
        }
        return -1;
    }

    public int getNGPLCTips1TTSStatus() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getNGPLCTips1TTSStatus();
        }
        return 0;
    }

    public int getScuNgpOpeButtonStatus() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getNGPOpeButtonStatus();
        }
        return -1;
    }

    public void setScuNgpOpeButtonStatus(int i) {
        SRNaviCanDataHelper sRNaviCanDataHelper = this.mSRNaviCanDataHelper;
        if (sRNaviCanDataHelper != null) {
            sRNaviCanDataHelper.setScuNgpOpeButtonStatus(i);
        }
    }

    public int getScuNgpLcTips1Status() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getNGPLCTips1Status();
        }
        return -1;
    }

    public int getScuNgpInfoTips1Status() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getNGPInfoTips1Status();
        }
        return -1;
    }

    public int getScuNgpTipsWindowStatus() {
        SRNaviCanDataHelper sRNaviCanDataHelper = this.mSRNaviCanDataHelper;
        if (sRNaviCanDataHelper != null) {
            return sRNaviCanDataHelper.getScuNgpTipsWindowStatus();
        }
        return -1;
    }

    public void setScuNgpTipsWindowStatus(int i) {
        SRNaviCanDataHelper sRNaviCanDataHelper = this.mSRNaviCanDataHelper;
        if (sRNaviCanDataHelper != null) {
            sRNaviCanDataHelper.setScuNgpTipsWindowStatus(i);
        }
    }

    public int getNGPLaneChangedStatus() {
        SRNaviDataHelper sRNaviDataHelper = this.mDataHelper;
        if (sRNaviDataHelper != null) {
            return sRNaviDataHelper.getNGPLaneChangedStatus();
        }
        return 0;
    }

    public void setAppBackground(boolean z) {
        this.mIsBackground = z;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAppBackground isBackground:" + this.mIsBackground);
        }
    }

    private void isSrSceneExsit(boolean z) {
        this.mIsSrResumed = z;
        L.Tag tag = TAG;
        L.i(tag, "isSrSceneExsit isResumed:" + this.mIsSrResumed);
    }

    public void updateNgpPanelStatus(int i) {
        this.mNgpPanelStatus = i;
    }

    public int getNgpPanelStatus() {
        return this.mNgpPanelStatus;
    }

    public void updateRecordStrategy() {
        SRDataForceRecordUtil.getInstance().updateRecordStrategy();
    }

    public void initRecordStrategy() {
        SRDataForceRecordUtil.getInstance().initRecordStrategy();
    }

    public boolean isNgpState() {
        int driveMode = getDriveMode();
        return 5 == driveMode || 6 == driveMode;
    }

    public void setLevelUp(int i) {
        if (i == 0) {
            this.mCurrentLowSpeedLevel += 0.1f;
            this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentLowSpeedLevel);
        } else if (i == 1) {
            this.mCurrentHighSpeedLevel += 0.1f;
            this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentHighSpeedLevel);
        } else if (i == 2) {
            this.mCurrentAnchorInLevel += 0.1f;
            this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentAnchorInLevel);
        } else if (i != 3) {
        } else {
            this.mCurrentAnchorOutLevel += 0.1f;
            this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentAnchorOutLevel);
        }
    }

    public void setLevelDown(int i) {
        if (i == 0) {
            float f = this.mCurrentLowSpeedLevel;
            if (f > 0.0f) {
                this.mCurrentLowSpeedLevel = f - 0.1f;
                this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentLowSpeedLevel);
            }
        } else if (i == 1) {
            float f2 = this.mCurrentHighSpeedLevel;
            if (f2 > 0.0f) {
                this.mCurrentHighSpeedLevel = f2 - 0.1f;
                this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentHighSpeedLevel);
            }
        } else if (i == 2) {
            float f3 = this.mCurrentAnchorInLevel;
            if (f3 > 0.0f) {
                this.mCurrentAnchorInLevel = f3 - 0.1f;
                this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentAnchorInLevel);
            }
        } else if (i != 3) {
        } else {
            float f4 = this.mCurrentAnchorOutLevel;
            if (f4 > 0.0f) {
                this.mCurrentAnchorOutLevel = f4 - 0.1f;
                this.mLaneServiceWrapper.setLaneDynamicLevel(i, this.mCurrentAnchorOutLevel);
            }
        }
    }

    public void initSRLevel(boolean z) {
        this.mCurrentHighSpeedLevel = this.mLaneServiceWrapper.getDefaultHighSpeedLevel();
        this.mCurrentLowSpeedLevel = this.mLaneServiceWrapper.getDefaultLowSpeedLevel();
        this.mCurrentAnchorInLevel = this.mLaneServiceWrapper.getDefaultAnchorInLevel();
        this.mCurrentAnchorOutLevel = this.mLaneServiceWrapper.getDefaultAnchorOutLevel();
        if (z) {
            return;
        }
        this.mLaneServiceWrapper.setLaneDynamicLevel(0, this.mCurrentLowSpeedLevel);
        this.mLaneServiceWrapper.setLaneDynamicLevel(1, this.mCurrentHighSpeedLevel);
        this.mLaneServiceWrapper.setLaneDynamicLevel(2, this.mCurrentAnchorInLevel);
        this.mLaneServiceWrapper.setLaneDynamicLevel(3, this.mCurrentAnchorOutLevel);
    }

    public float getCurrentHighSpeedLevel() {
        return this.mCurrentHighSpeedLevel;
    }

    public float getCurrentLowSpeedLevel() {
        return this.mCurrentLowSpeedLevel;
    }

    public float getCurrentAnchorOutLevel() {
        return this.mCurrentAnchorOutLevel;
    }

    public float getCurrentAnchorInLevel() {
        return this.mCurrentAnchorInLevel;
    }

    public void resetLevel() {
        initSRLevel(false);
    }
}
