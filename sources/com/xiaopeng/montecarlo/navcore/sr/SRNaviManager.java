package com.xiaopeng.montecarlo.navcore.sr;

import android.os.SystemClock;
import com.autonavi.gbl.pos.model.LocAllFusionPos;
import com.autonavi.gbl.pos.model.LocDrPos;
import com.autonavi.gbl.pos.model.LocVision;
import com.xiaopeng.montecarlo.navcore.bean.sr.SRInfo;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.listener.SrRecordDataStrategyConfigListener;
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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
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
    private static final SRNaviManager sInstance = new SRNaviManager();
    private static final L.Tag TAG = new L.Tag("SRNaviManager");
    private static final String SR_REPORTER_FOLDER = RootUtil.DIR_PROTO_DATA_LOG;
    public int mLastAlertType = -1;
    boolean mIsBackground = false;
    boolean mIsMainMapSrResumed = false;
    boolean mIsMiniMapSrResumed = false;
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

    public void setLevelDown(int i) {
    }

    public void setLevelUp(int i) {
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

    public boolean isLaneEnabled() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, true);
    }

    private void initPosService() {
        if (this.mLanePosServiceWrapper == null) {
            int carType = CarServiceManager.getInstance().getCarType();
            boolean isAutoPolitIMUEnable = CarFeatureManager.INSTANCE.isAutoPolitIMUEnable();
            this.mLanePosServiceWrapper = TBTManager.getInstance().getPosServiceWrapper();
            this.mLanePosServiceWrapper.initPos(!NavCoreUtil.isGpsDebugMode(), carType, isAutoPolitIMUEnable);
        }
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

    public SRInfo getSRInfo() {
        return this.mDataHelper.getSRInfo();
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
        return LaneServiceManager.getInstance().isPlayAMapLaneData() ? this.mLaneDisplayState == 0 : this.mLaneDisplayState == 0 && isXpuShowSREnabled();
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

    public void setSignalRecordSwitch(boolean z) {
        PosServiceWrapper posServiceWrapper = this.mLanePosServiceWrapper;
        if (posServiceWrapper != null) {
            posServiceWrapper.setSignalRecordSwitch(z);
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
        } else if (!this.mIsBackground && ((this.mIsMainMapSrResumed || this.mIsMiniMapSrResumed) && j2 - j < 100)) {
            j3 = 45;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mDataCount++;
        if (0 == this.mDataCount % 100) {
            L.i(TAG, "analysisSRData ngp:" + CarServiceManager.getInstance().isNGPOn() + ", dataCount:" + this.mDataCount + ", minInterval:" + j3 + ", mIsMainMapSrResumed:" + this.mIsMainMapSrResumed + ", mIsMiniMapSrResumed:" + this.mIsMiniMapSrResumed + ", mIsBackground:" + this.mIsBackground);
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

    public void srDisplayStChangedTo4() {
        if (L.ENABLE) {
            L.d(TAG, "srDisplayStChangedTo4");
        }
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onLaneViewDisplayChanged(this.mLaneDisplayState);
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

    void onScuNgpTipsWindow(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onScuNgpTipsWindow status:" + i);
        Iterator<ISRInfoChangedListener> it = this.mSRInfoChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScuNgpTipsWindow(i);
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

    public void setMainMapSrResume(boolean z) {
        this.mIsMainMapSrResumed = z;
        L.Tag tag = TAG;
        L.i(tag, "setMainMapSrResume isResumed:" + this.mIsMainMapSrResumed);
    }

    public void setMiniMapSrResume(boolean z) {
        this.mIsMiniMapSrResumed = z;
        L.Tag tag = TAG;
        L.i(tag, "setMiniMapSrResume isResumed:" + this.mIsMiniMapSrResumed);
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
}
