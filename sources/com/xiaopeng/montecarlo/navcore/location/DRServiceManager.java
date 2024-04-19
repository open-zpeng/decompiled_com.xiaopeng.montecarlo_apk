package com.xiaopeng.montecarlo.navcore.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.pos.model.LocGpgsv;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocSignData;
import com.xiaopeng.montecarlo.navcore.bean.location.TestLocInfo;
import com.xiaopeng.montecarlo.navcore.bean.location.XPPosInfo;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.event.DRDebugEvent;
import com.xiaopeng.montecarlo.navcore.location.NmeaGxgsvHelper;
import com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor;
import com.xiaopeng.montecarlo.navcore.location.sensor.ImuSensor;
import com.xiaopeng.montecarlo.navcore.location.sensor.UbxSensor;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.sr.SRDataUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.SpatialUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.drmountangle.MountAngleManager;
import com.xiaopeng.montecarlo.root.network.UbxDebugUDPClient;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.LocationDataUploader;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes3.dex */
public class DRServiceManager implements IXPLocationListener, CarServiceManager.IXPCarStateListener, PosServiceWrapper.IPosUpdateOneShotCallback {
    private static final int A3D_END_CNT_NUM = 1600;
    private static final int A3D_START_CNT_NUM = 600;
    private static final float ACCURACY_THRESHOLD = 5.0f;
    public static final int BCM_POWER_MODE_NO_USED = 1;
    public static final int BCM_POWER_MODE_NULL = -1;
    public static final int BCM_POWER_MODE_OFF = 0;
    public static final int BCM_POWER_MODE_ON = 2;
    private static final float CALIBRATION_CYCLE = 1.0f;
    private static final int CAR_DISTANCE_CNT_NUM = 300;
    private static final int CAR_MAX_DISTANCE = 100;
    private static final int CAR_MAX_DISTANCE_CNT = 5;
    private static final int CAR_SPEED_END_CNT_NUM = 1600;
    private static final int CAR_SPEED_START_CNT_NUM = 600;
    private static final float CUR_SPEED_ZERO_THRESHOLD = 0.1f;
    private static final int CYCLE_MAX_NUM = 120;
    private static final long DEFAULT_PM_TIME = 7258089600000L;
    private static final float DEGREE_ROAD2GNSS = 15.0f;
    private static final double DEGREE_ROAD2GNSSCAR = 80.0d;
    private static final double DELTA_LATITUDE_THRESHOLD = 9.999999974752427E-7d;
    private static final int GEAR_LEVEL_D = 1;
    private static final int GEAR_LEVEL_INVALID = 0;
    private static final int GEAR_LEVEL_N = 2;
    private static final int GEAR_LEVEL_P = 4;
    private static final int GEAR_LEVEL_R = 3;
    private static final int GNSS_OUTAGE_CAR_SPEED_MAX_NUM = 300;
    private static final int GNSS_OUTAGE_COUNT_DEFAULT_VALUE = 0;
    private static final int GNSS_OUTAGE_LINK_TYPE_MAX_NUM = 300;
    private static final int GNSS_OUTAGE_MAX_CAR_SPEED = 30;
    private static final long GNSS_OUTAGE_NUM = 300000;
    private static final long GNSS_REPORT_TIME_UNIT = 60000;
    private static final float GNSS_TO_CAR_COURSE_DEFAULT = 0.0f;
    private static final int GSV_LOG_OUTPUT_LIMIT_TIME = 60;
    private static final int GYR_END_CNT_NUM = 1600;
    private static final int GYR_START_CNT_NUM = 600;
    private static final float HDOP_THRESHOLD = 0.8f;
    private static final long INVALID_LOG_TEMPERATURE_INTERVAL = 10000;
    private static final int MAX_GPS_DEBUG_DIS = 1000;
    private static final float MPS_TO_KMPHR = 3.6f;
    private static final int NUM_SV_THRESHOLD = 10;
    private static final long OPEN_SENSOR_STATISTIC_MIN_GAP = 600000;
    private static final String PATH_TEMP_1 = "sys/class/thermal/thermal_zone0/temp";
    private static final String PATH_TEMP_2 = "sys/class/thermal/thermal_zone1/temp";
    private static final int PM_RESET_UBX_TIME = 300000;
    private static final int POLL_MON_HW_AGC_CYCLE_MAX_NUM = 10;
    private static final float REAL_CAR_SPEED_SCALE_FACTOR = 1.05f;
    private static final int RESET_UBX_GNSS_LOCATION_ERROR = 1;
    private static final int RESET_UBX_GNSS_OUTAGE = 3;
    private static final int RESET_UBX_PM_OFF = 2;
    private static final int ROAD_CLASS_NULL = -1;
    private static final float SCU_SPEED_ERROR_GAP = 10.0f;
    private static final int SEND_DR_LOCATION_INFO_TO_SYSTEM_THREAD_INTERVAL = 1000;
    private static final int SENSOR_STATISTIC_MAX_COUNT = 120;
    private static final int SET_SAVE_LOC_STORAGE_THREAD_INTERVAL = 100000;
    private static final float SIGMA_1 = 0.68f;
    private static final float SPEED_LOWER_LIMIT = 26.0f;
    private static final float SPEED_UPPER_LIMIT = 36.0f;
    private static final float SPEED_WEIGHT_COEFFICIENT = 0.1f;
    private static final byte STATUS_INVALID = 86;
    private static final byte STATUS_VALID = 65;
    private static final long TBOX_LOG_OPEN_MIN_GAP = 3600000;
    private static final long UBX_DEBUG_NEED_RESET_UBLOX_DOUBLE_CHECK_TIME = 60000;
    private static final int UBX_DEBUG_UDP_CLOSE = 0;
    private static final int UBX_DEBUG_UDP_CNT_MAX_NUM = 120;
    private static final int UBX_DEBUG_UDP_OPEN = 1;
    private Handler mCheckDataCityAdCodeHandler;
    private GnssDataProcessHelper mGnssDataProcessHelper;
    private LocationDataUploader mLocationDataUploader;
    private LocationServiceManager mLocationManager;
    private IMapDelegate mMapDelegate;
    MountAngleManager.MountAngle mMountAngle;
    private NmeaGxgsvHelper mNmeaGxgsvHelper;
    private PosServiceWrapper mPosServiceWrapper;
    private Handler mSendDRLocationInfoToSystemHandler;
    private IXpSensor mSensor;
    private SensorDataProcessHelper mSensorDataProcessHelper;
    private Handler mSetSaveLocStorageHandler;
    private UbxDebugUDPClient mUbxDebugUDPClient;
    private static final L.Tag TAG = new L.Tag("DRServiceManager");
    private static final DRServiceManager sInstance = new DRServiceManager();
    public ArrayList<IAdCodeChangedListener> mIAdCodeChangedListeners = new ArrayList<>();
    boolean mIsBackground = false;
    boolean mHasReportAmapEngineStop = false;
    private boolean mStarted = false;
    private boolean mUserExpectToEnableBLDR = false;
    private boolean mEnableBLDR = false;
    private boolean mUbloxADR = false;
    private int mSatelliteNum = 0;
    private float mLatestHdop = -1.0f;
    private float mLatestPdop = -1.0f;
    private float mLatestVdop = -1.0f;
    private long mLogCnt = 0;
    private float mScuSpeed = 0.0f;
    private int mCarGearLevel = 0;
    private float mCarForward = 1.0f;
    private float mLastTemperature = 60.0f;
    private int mInvalidTemperaturePathCount1 = 0;
    private int mInvalidTemperaturePathCount2 = 0;
    private long mLastInvalidTemperatureTime = 0;
    private long mPreviousScuTime = 0;
    private int mUbxDebugUDPClientOpenFlag = 0;
    private long mUbxDebugUDPClientOpenCnt = 0;
    private long mPreviousA3DTime = 0;
    private int mA3dTickCnt = 0;
    private float mA3dTimeChip = 0.0f;
    private float mA3dTimeChipFloat = 0.0f;
    private int mA3dTimeChipInt = 0;
    private boolean mSetA3dInterpolationFlag = false;
    private long mA3dStartTime = 0;
    private long mA3dEndTime = 1;
    private int mA3dDataCnt = 0;
    private boolean mA3dDataCntStartFlag = true;
    private boolean mA3dDataCntEndFlag = false;
    private int mA3dDataCntStart = 0;
    private int mA3dDataCntEnd = 0;
    private float mA3dLossRate = 0.0f;
    private float mA3dDataFreq = 0.0f;
    private int mA3dCycleNum = 100;
    private long mPreviousAccelLogTime = 0;
    private long mPreviousGYRTime = 0;
    private int mGyrTickCnt = 0;
    private float mGyrTimeChip = 0.0f;
    private float mGyrTimeChipFloat = 0.0f;
    private int mGyrTimeChipInt = 0;
    private boolean mSetGyrInterpolationFlag = false;
    private long mGyrStartTime = 0;
    private long mGyrEndTime = 1;
    private int mGyrDataCnt = 0;
    private boolean mGyrDataCntStartFlag = true;
    private boolean mGyrDataCntEndFlag = false;
    private int mGyrDataCntStart = 0;
    private int mGyrDataCntEnd = 0;
    private float mGyrLossRate = 0.0f;
    private float mGyrDataFreq = 0.0f;
    private int mGyrCycleNum = 100;
    private long mPreviousGyrLogTime = 0;
    private long mPreviousCarSpeedTime = 0;
    private int mCarSpeedTickCnt = 0;
    private float mCarSpeedTimeChip = 0.0f;
    private float mCarSpeedTimeChipFloat = 0.0f;
    private int mCarSpeedTimeChipInt = 0;
    private boolean mSetCarSpeedInterpolationFlag = false;
    private long mCarSpeedStartTime = 0;
    private long mCarSpeedEndTime = 1;
    private int mCarSpeedDataCnt = 0;
    private boolean mCarSpeedDataCntStartFlag = true;
    private boolean mCarSpeedDataCntEndFlag = false;
    private int mCarSpeedDataCntStart = 0;
    private int mCarSpeedDataCntEnd = 0;
    private float mCarSpeedLossRate = 0.0f;
    private float mCarSpeedDataFreq = 0.0f;
    private int mCarSpeedCycleNum = 100;
    private LinkedList<Byte> mSpeedCollection = new LinkedList<>();
    private int mSpeedSum = 0;
    private long mPreviousEspTime = 0;
    private float mEspRawSpeed = 0.0f;
    private boolean mCarSpeedInitStatus = false;
    private long mPreviousScuAutoPilotTime = 0;
    private float mScuAutoPilotSpeed = 0.0f;
    private float mCarSpeedTemp = 0.0f;
    private long mPreviousCarSpeedLogTime = 0;
    private long mGnssOutageReportCheckTime = SystemClock.uptimeMillis();
    private long mLastRealGnssTime = this.mGnssOutageReportCheckTime;
    private boolean mPowerOnFlagForLossRate = false;
    private LinkedList<Integer> mDistanceCollection = new LinkedList<>();
    private LinkedList<Byte> mLinkTypeCollection = new LinkedList<>();
    private int mLinkTypeSum = 0;
    private boolean mIsLastLinkTunnel = false;
    private XPCoordinate2DDouble mPreviousCarLocation = null;
    private int mDistanceSum = 0;
    @NonNull
    private Integer mGpsDebugCount = 0;
    private int mCityAdCode = -1;
    private int mCheckDataCityAdCodeThreadInterval = 30000;
    @Nullable
    private String mCityName = null;
    private int mPreAdCode = -1;
    private volatile int mGsvLogOutputCount = 0;
    private long mPollMonHwAgcCnt = 0;
    private LocDebugHelper mLocDebugHelper = null;
    private ILocDebugSwitchListener mILocDebugSwitchListener = null;
    private boolean mIsInTboxUbloxDebugLogOutput = false;
    private long mLastStartTBOXLogTime = 0;
    private boolean mNeedStartSensorStatistic = false;
    private long mStartSensorStatisticTimeTick = 0;
    private long mStartSensorStatisticCount = 0;
    private long mStartGnssStatisticCount = 0;
    private int mSensorStatisticCount = 0;
    private boolean mGnssSignalQuality = false;
    private boolean mGnssForward = false;
    private int mZeroSpeedCnt = 0;
    private boolean mNeedResetGnssOutageStatistic = false;
    private DRLogService mSimulator = null;
    private long mSensorUpdateTime = 0;
    @NonNull
    private Runnable mSetSaveLocStorageRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.DRServiceManager.1
        @Override // java.lang.Runnable
        public void run() {
            DRServiceManager.this.mSetSaveLocStorageHandler.removeCallbacks(DRServiceManager.this.mSetSaveLocStorageRunnable);
            if (DRServiceManager.this.mEnableBLDR && CarServiceManager.getInstance().isBcmPowerOn()) {
                DRServiceManager.this.mPosServiceWrapper.setSaveLocStorage();
                L.i(DRServiceManager.TAG, "save last location to Gnaviposconfig.dat");
            }
            DRServiceManager.this.mSetSaveLocStorageHandler.postDelayed(DRServiceManager.this.mSetSaveLocStorageRunnable, 100000L);
        }
    };
    @NonNull
    private Runnable mSendDRLocationInfoToSystemRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.DRServiceManager.2
        @Override // java.lang.Runnable
        public void run() {
            DRServiceManager.this.mSendDRLocationInfoToSystemHandler.removeCallbacks(DRServiceManager.this.mSendDRLocationInfoToSystemRunnable);
            DRServiceManager.this.sendDRLocationInfoToSystem();
            boolean onCheckGnssLocationError = DRServiceManager.this.onCheckGnssLocationError(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
            if (onCheckGnssLocationError) {
                DRServiceManager.this.sendEnableUbxReset(true);
                L.w(DRServiceManager.TAG, "GNSS location error and reset ubx");
                DRServiceManager.this.sendStatData(1, 0.0f);
                DRServiceManager.this.mDistanceCollection.clear();
                DRServiceManager.this.mDistanceSum = 0;
            }
            LocInfo currentLocInfo = DRServiceManager.this.mPosServiceWrapper.getCurrentLocInfo();
            int i = currentLocInfo != null ? currentLocInfo.matchInfo.get(0).linkType : -1;
            if (!DRServiceManager.this.mIsLastLinkTunnel || i == -1 || i == 2) {
                if (DRServiceManager.this.mIsLastLinkTunnel && i == -1) {
                    i = 2;
                } else {
                    DRServiceManager.this.mIsLastLinkTunnel = i == 2;
                }
            } else {
                DRServiceManager.this.mNeedResetGnssOutageStatistic = true;
            }
            if (DRServiceManager.this.mNeedResetGnssOutageStatistic) {
                DRServiceManager.this.mNeedResetGnssOutageStatistic = false;
                DRServiceManager.this.resetUbxGnssOutageStatistic();
                if (DRServiceManager.this.mPosServiceWrapper != null) {
                    DRServiceManager.this.mPosServiceWrapper.resetAmapEngineChecker();
                }
                DRServiceManager.this.mSensorUpdateTime = SystemClock.uptimeMillis();
            }
            if (DRServiceManager.this.isGnssOutage(true, i)) {
                DRServiceManager.this.startTboxDebugUbloxLog();
            } else if (DRServiceManager.this.mUbxDebugUDPClientOpenFlag == 0 && DRServiceManager.this.mIsInTboxUbloxDebugLogOutput) {
                L.i(DRServiceManager.TAG, "cancel ublox log");
                DRServiceManager.this.stopTboxDebugUbloxLog();
            }
            boolean isGnssOutage = DRServiceManager.this.isGnssOutage(false, i);
            if (isGnssOutage) {
                if (DRServiceManager.this.mUbxDebugUDPClient == null && DRServiceManager.this.mUbxDebugUDPClientOpenFlag == 0) {
                    DRServiceManager.this.mUbxDebugUDPClient = new UbxDebugUDPClient();
                    DRServiceManager.this.mUbxDebugUDPClient.open();
                    DRServiceManager.this.mUbxDebugUDPClientOpenFlag = 1;
                }
                if (!DRServiceManager.this.mIsInTboxUbloxDebugLogOutput) {
                    DRServiceManager.this.mLastStartTBOXLogTime = 0L;
                    DRServiceManager.this.startTboxDebugUbloxLog();
                }
                L.w(DRServiceManager.TAG, "GNSS outage");
                DRServiceManager.this.resetUbxGnssOutageStatistic();
            }
            if (DRServiceManager.this.isLocDebugSwitch() && DRServiceManager.this.mLocDebugHelper != null && (isGnssOutage || onCheckGnssLocationError)) {
                DRServiceManager.this.mLocDebugHelper.sendGnssOutageErorMsg(isGnssOutage, onCheckGnssLocationError);
            }
            if (1 == DRServiceManager.this.mUbxDebugUDPClientOpenFlag && DRServiceManager.this.mUbxDebugUDPClient != null) {
                DRServiceManager.access$2508(DRServiceManager.this);
                if (DRServiceManager.this.mUbxDebugUDPClientOpenCnt >= 120) {
                    DRServiceManager.this.mUbxDebugUDPClientOpenCnt = 0L;
                    DRServiceManager.this.mPollMonHwAgcCnt = 0L;
                    float sumAGC = DRServiceManager.this.mUbxDebugUDPClient.getSumAGC();
                    int sumAGCCnt = DRServiceManager.this.mUbxDebugUDPClient.getSumAGCCnt();
                    float f = sumAGCCnt > 0 ? sumAGC / sumAGCCnt : 0.0f;
                    DRServiceManager.this.mUbxDebugUDPClient.setSumAGC(0.0f);
                    DRServiceManager.this.mUbxDebugUDPClient.setSumAGCCnt(0);
                    DRServiceManager.this.sendStatData(3, f);
                    L.i(DRServiceManager.TAG, "sendStatData, GNSS outage and mean AGC is:" + f + "%");
                    DRServiceManager.this.stopTboxDebugUbloxLog();
                    long uptimeMillis = SystemClock.uptimeMillis() - DRServiceManager.this.mGnssOutageReportCheckTime;
                    if (uptimeMillis >= 60000) {
                        DRServiceManager.this.sendEnableUbxReset(true);
                        AfterSalesUtil.getInstance().recordDiagnosisError(9000, DRServiceManager.this.generateGnssOutageInfo(DataSetHelper.GlobalSet.KEY_GNSS_OUTAGE_ERROR));
                    } else {
                        L.i(DRServiceManager.TAG, "catch gnss data abort reset ublox:" + uptimeMillis);
                    }
                    L.w(DRServiceManager.TAG, "GNSS outage and reset ubx");
                    DRServiceManager.this.mUbxDebugUDPClient.close();
                    DRServiceManager.this.mUbxDebugUDPClient = null;
                    DRServiceManager.this.mUbxDebugUDPClientOpenFlag = 0;
                } else {
                    DRServiceManager.access$2608(DRServiceManager.this);
                    if (DRServiceManager.this.mPollMonHwAgcCnt >= 10) {
                        DRServiceManager.this.mPollMonHwAgcCnt = 0L;
                        DRServiceManager.this.sendEnablePollMonHwAgc(true);
                    }
                }
            }
            DRServiceManager.access$3008(DRServiceManager.this);
            if (DRServiceManager.this.mLogCnt >= 120) {
                DRServiceManager.this.mLogCnt = 0L;
                L.i(DRServiceManager.TAG, "DR diagonsis system heart beat check");
            }
            if (DRServiceManager.this.mPosServiceWrapper != null && CarServiceManager.getInstance().isBcmPowerOn() && DRServiceManager.this.mPosServiceWrapper.isAmapEngineTimeout(DRServiceManager.this.mSensorUpdateTime)) {
                if (!DRServiceManager.this.mHasReportAmapEngineStop) {
                    DRServiceManager dRServiceManager = DRServiceManager.this;
                    dRServiceManager.mHasReportAmapEngineStop = true;
                    long lastUpdateSensorTime = dRServiceManager.mPosServiceWrapper.getLastUpdateSensorTime();
                    AfterSalesUtil.getInstance().recordDiagnosisError(9005, DRServiceManager.this.mSensorUpdateTime + ">" + lastUpdateSensorTime);
                }
                if (DRServiceManager.this.mIsBackground) {
                    RootUtil.delayExitApp(RootUtil.KILL_NAVI_AMAP_POS_ENGINE_STOP);
                }
            }
            if (RootUtil.sIsDrTestMode && !RootUtil.isUserVersion()) {
                DRServiceManager.this.drStatistic();
            }
            if (DRServiceManager.this.mNeedStartSensorStatistic) {
                if (DRServiceManager.this.mSensorStatisticCount == 0) {
                    long currentTimeMillis = System.currentTimeMillis() - DRServiceManager.this.mStartSensorStatisticTimeTick;
                    if (currentTimeMillis > DRServiceManager.OPEN_SENSOR_STATISTIC_MIN_GAP) {
                        L.i(DRServiceManager.TAG, "open SensorStatistic");
                        StatisticDataUtil.resetDRStatistic();
                        RootUtil.sIsDrTestMode = true;
                        DRServiceManager.this.mStartSensorStatisticTimeTick = System.currentTimeMillis();
                        DRServiceManager.access$3308(DRServiceManager.this);
                    } else {
                        L.w(DRServiceManager.TAG, "ignore SensorStatistic:" + currentTimeMillis);
                        DRServiceManager.this.mNeedStartSensorStatistic = false;
                    }
                } else if (DRServiceManager.this.mSensorStatisticCount > 120) {
                    RootUtil.sIsDrTestMode = false;
                    DRServiceManager.this.mSensorStatisticCount = 0;
                    DRServiceManager.this.mNeedStartSensorStatistic = false;
                    L.i(DRServiceManager.TAG, "sensor:" + StatisticDataUtil.getDRImuSensorInputCount() + "gnss:" + StatisticDataUtil.getDRGnssInputCount());
                } else {
                    DRServiceManager.access$3308(DRServiceManager.this);
                }
            }
            DRServiceManager.this.mSendDRLocationInfoToSystemHandler.postDelayed(DRServiceManager.this.mSendDRLocationInfoToSystemRunnable, 1000L);
        }
    };
    @NonNull
    private Runnable mCheckDataCityAdCodeRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.DRServiceManager.3
        @Override // java.lang.Runnable
        public void run() {
            DRServiceManager.this.mCheckDataCityAdCodeHandler.removeCallbacks(DRServiceManager.this.mCheckDataCityAdCodeRunnable);
            if (-1 == DRServiceManager.this.mCityAdCode) {
                DRServiceManager.this.checkDataCityAdCode();
                DRServiceManager.this.mCheckDataCityAdCodeThreadInterval = 60000;
            } else {
                DRServiceManager.this.checkDataCityAdCode();
            }
            DRServiceManager.this.mCheckDataCityAdCodeHandler.postDelayed(DRServiceManager.this.mCheckDataCityAdCodeRunnable, DRServiceManager.this.mCheckDataCityAdCodeThreadInterval);
        }
    };
    private GnssLocation mGnssLocation = new GnssLocation();
    @Nullable
    private IXpSensor.ISensorListener mUDPClientListener = new IXpSensor.ISensorListener() { // from class: com.xiaopeng.montecarlo.navcore.location.DRServiceManager.4
        @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor.ISensorListener
        public void onSensorChanged(int i, @Nullable float[] fArr, long j, float f, int i2, int i3, IXpSensor.XPSensorType xPSensorType) {
            String str;
            boolean z;
            boolean z2;
            DRServiceManager dRServiceManager;
            DRServiceManager dRServiceManager2;
            DRServiceManager dRServiceManager3;
            DRServiceManager dRServiceManager4;
            DRServiceManager dRServiceManager5;
            DRServiceManager dRServiceManager6;
            boolean z3;
            int i4;
            float f2;
            DRServiceManager dRServiceManager7;
            DRServiceManager dRServiceManager8;
            DRServiceManager dRServiceManager9;
            if (CarServiceManager.getInstance().isBcmPowerOn() && DRServiceManager.this.mEnableBLDR && fArr != null && fArr.length >= 3) {
                long millis = TimeUnit.NANOSECONDS.toMillis(j);
                long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                DRServiceManager.this.checkUDPFailureAndResetCnt(i2, i3);
                if (DRServiceManager.this.mSensorDataProcessHelper != null) {
                    DRServiceManager.this.mSensorDataProcessHelper.onDetectTrafficAccident(i, fArr, f, millis, currentTimeMillis);
                }
                if (i != 1) {
                    if (i != 4) {
                        return;
                    }
                    DRServiceManager.access$8408(DRServiceManager.this);
                    if (DRServiceManager.this.mPreviousGyrLogTime >= 300) {
                        DRServiceManager.this.mPreviousGyrLogTime = 0L;
                        L.i(DRServiceManager.TAG, "gyro value[" + fArr[0] + "," + fArr[1] + "," + fArr[2] + "],temperature[" + f + "]");
                    }
                    if (DRServiceManager.this.isLocDebugSwitch() && DRServiceManager.this.mLocDebugHelper != null) {
                        DRServiceManager.this.mLocDebugHelper.sendGyrMsg(TestLocInfo.isGyrXyzNormal(fArr[0], fArr[1], fArr[2]), TestLocInfo.isGyrTempNormal(f));
                    }
                    if (DRServiceManager.this.mGyrDataCnt >= 600 && DRServiceManager.this.mGyrDataCntStartFlag) {
                        DRServiceManager.this.mGyrDataCntStartFlag = false;
                        DRServiceManager.this.mGyrDataCntEndFlag = true;
                        DRServiceManager.this.mGyrStartTime = millis - currentTimeMillis;
                        DRServiceManager dRServiceManager10 = DRServiceManager.this;
                        dRServiceManager10.mGyrDataCntStart = dRServiceManager10.mGyrDataCnt;
                    }
                    if (DRServiceManager.this.mGyrDataCnt >= 1600 && DRServiceManager.this.mGyrDataCntEndFlag) {
                        DRServiceManager.this.mGyrDataCntEndFlag = false;
                        DRServiceManager.this.mGyrEndTime = millis - currentTimeMillis;
                        DRServiceManager dRServiceManager11 = DRServiceManager.this;
                        dRServiceManager11.mGyrDataCntEnd = dRServiceManager11.mGyrDataCnt;
                        DRServiceManager.this.mGyrLossRate = 1.0f - ((dRServiceManager7.mGyrDataCntEnd - DRServiceManager.this.mGyrDataCntStart) / (((float) (DRServiceManager.this.mGyrEndTime - DRServiceManager.this.mGyrStartTime)) * 0.01f));
                        DRServiceManager.this.mGyrDataFreq = (dRServiceManager8.mGyrDataCntEnd - DRServiceManager.this.mGyrDataCntStart) / (((float) (DRServiceManager.this.mGyrEndTime - DRServiceManager.this.mGyrStartTime)) * 0.001f);
                        DRServiceManager dRServiceManager12 = DRServiceManager.this;
                        dRServiceManager12.mGyrCycleNum = (int) Math.abs(0.1f / (0.1f - (1.0f / dRServiceManager12.mGyrDataFreq)));
                        DRServiceManager.this.mGyrTimeChip = 100.0f / dRServiceManager9.mGyrCycleNum;
                        L.i(DRServiceManager.TAG, "GYR LossRate is " + DRServiceManager.this.mGyrLossRate + ", CycleNum is " + DRServiceManager.this.mGyrCycleNum + ", TimeChip is " + DRServiceManager.this.mGyrTimeChip);
                    }
                    if (DRServiceManager.this.mGyrDataCntStartFlag || DRServiceManager.this.mGyrDataCntEndFlag) {
                        DRServiceManager.access$8508(DRServiceManager.this);
                    }
                    if (DRServiceManager.this.mGyrLossRate < -0.001f) {
                        if (DRServiceManager.this.mSetGyrInterpolationFlag) {
                            DRServiceManager.this.mSetGyrInterpolationFlag = false;
                            if (IXpSensor.XPSensorType.SENSOR_TYPE_UBX == xPSensorType) {
                                z3 = true;
                                i4 = 0;
                                f2 = 0.0f;
                            } else {
                                DRServiceManager dRServiceManager13 = DRServiceManager.this;
                                z3 = true;
                                i4 = 0;
                                f2 = 0.0f;
                                dRServiceManager13.onGyroUpdate(fArr, f, millis, currentTimeMillis, dRServiceManager13.mGyrTimeChipInt, xPSensorType);
                            }
                        } else {
                            DRServiceManager dRServiceManager14 = DRServiceManager.this;
                            dRServiceManager14.onGyroUpdate(fArr, f, millis, currentTimeMillis, dRServiceManager14.mGyrTimeChipInt, xPSensorType);
                            i4 = 0;
                            z3 = true;
                            f2 = 0.0f;
                        }
                        DRServiceManager.access$9908(DRServiceManager.this);
                        DRServiceManager.this.mGyrTimeChipFloat += DRServiceManager.this.mGyrTimeChip;
                        DRServiceManager dRServiceManager15 = DRServiceManager.this;
                        dRServiceManager15.mGyrTimeChipInt = (int) dRServiceManager15.mGyrTimeChipFloat;
                        if (DRServiceManager.this.mGyrCycleNum == DRServiceManager.this.mGyrTickCnt) {
                            DRServiceManager.this.mGyrTickCnt = i4;
                            DRServiceManager.this.mGyrTimeChipFloat = f2;
                            DRServiceManager.this.mGyrTimeChipInt = i4;
                            DRServiceManager.this.mSetGyrInterpolationFlag = z3;
                            return;
                        }
                        return;
                    } else if (DRServiceManager.this.mGyrLossRate <= 0.001f) {
                        DRServiceManager.this.onGyroUpdate(fArr, f, millis, currentTimeMillis, 0, xPSensorType);
                        return;
                    } else {
                        DRServiceManager dRServiceManager16 = DRServiceManager.this;
                        dRServiceManager16.onGyroUpdate(fArr, f, millis, currentTimeMillis, -dRServiceManager16.mGyrTimeChipInt, xPSensorType);
                        DRServiceManager.access$9908(DRServiceManager.this);
                        DRServiceManager.this.mGyrTimeChipFloat += DRServiceManager.this.mGyrTimeChip;
                        DRServiceManager dRServiceManager17 = DRServiceManager.this;
                        dRServiceManager17.mGyrTimeChipInt = (int) dRServiceManager17.mGyrTimeChipFloat;
                        if (DRServiceManager.this.mGyrCycleNum == DRServiceManager.this.mGyrTickCnt) {
                            DRServiceManager.this.mGyrTickCnt = 0;
                            DRServiceManager.this.mGyrTimeChipFloat = 0.0f;
                            DRServiceManager.this.mGyrTimeChipInt = 0;
                            DRServiceManager.this.mSetGyrInterpolationFlag = true;
                            if (DRServiceManager.this.mSetGyrInterpolationFlag && IXpSensor.XPSensorType.SENSOR_TYPE_UBX == xPSensorType) {
                                DRServiceManager.this.onGyroUpdate(fArr, f, millis, currentTimeMillis, 0, xPSensorType);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                DRServiceManager.access$4208(DRServiceManager.this);
                if (DRServiceManager.this.mPreviousAccelLogTime >= 300) {
                    DRServiceManager.this.mPreviousAccelLogTime = 0L;
                    L.i(DRServiceManager.TAG, "accel value[" + fArr[0] + "," + fArr[1] + "," + fArr[2] + "]");
                }
                if (DRServiceManager.this.isLocDebugSwitch() && DRServiceManager.this.mLocDebugHelper != null) {
                    if (L.ENABLE) {
                        L.d(DRServiceManager.TAG, "TYPE_ACCELEROMETER values[0]: " + fArr[0] + ", values[1]:" + fArr[1] + ", values[2]:" + fArr[2]);
                    }
                    if (!TestLocInfo.isAccelXyzNormal(fArr[0], fArr[1], fArr[2])) {
                        DRServiceManager.this.mLocDebugHelper.sendAccelSpeedMsg();
                    }
                }
                if (DRServiceManager.this.mA3dDataCnt >= 600 && DRServiceManager.this.mA3dDataCntStartFlag) {
                    DRServiceManager.this.mA3dDataCntStartFlag = false;
                    DRServiceManager.this.mA3dDataCntEndFlag = true;
                    DRServiceManager.this.mA3dStartTime = millis - currentTimeMillis;
                    DRServiceManager dRServiceManager18 = DRServiceManager.this;
                    dRServiceManager18.mA3dDataCntStart = dRServiceManager18.mA3dDataCnt;
                }
                if (DRServiceManager.this.mA3dDataCnt >= 1600 && DRServiceManager.this.mA3dDataCntEndFlag) {
                    DRServiceManager.this.mA3dDataCntEndFlag = false;
                    DRServiceManager.this.mA3dEndTime = millis - currentTimeMillis;
                    DRServiceManager dRServiceManager19 = DRServiceManager.this;
                    dRServiceManager19.mA3dDataCntEnd = dRServiceManager19.mA3dDataCnt;
                    DRServiceManager.this.mA3dLossRate = 1.0f - ((dRServiceManager4.mA3dDataCntEnd - DRServiceManager.this.mA3dDataCntStart) / (((float) (DRServiceManager.this.mA3dEndTime - DRServiceManager.this.mA3dStartTime)) * 0.01f));
                    DRServiceManager.this.mA3dDataFreq = (dRServiceManager5.mA3dDataCntEnd - DRServiceManager.this.mA3dDataCntStart) / (((float) (DRServiceManager.this.mA3dEndTime - DRServiceManager.this.mA3dStartTime)) * 0.001f);
                    DRServiceManager dRServiceManager20 = DRServiceManager.this;
                    dRServiceManager20.mA3dCycleNum = (int) Math.abs(0.1f / (0.1f - (1.0f / dRServiceManager20.mA3dDataFreq)));
                    DRServiceManager.this.mA3dTimeChip = 100.0f / dRServiceManager6.mA3dCycleNum;
                    L.i(DRServiceManager.TAG, "A3D LossRate is " + DRServiceManager.this.mA3dLossRate + ", CycleNum is " + DRServiceManager.this.mA3dCycleNum + ", TimeChip is " + DRServiceManager.this.mA3dTimeChip);
                }
                if (DRServiceManager.this.mA3dDataCntStartFlag || DRServiceManager.this.mA3dDataCntEndFlag) {
                    DRServiceManager.access$4308(DRServiceManager.this);
                }
                if (DRServiceManager.this.mA3dLossRate < -0.001f) {
                    if (DRServiceManager.this.mSetA3dInterpolationFlag) {
                        str = ", CycleNum is ";
                        DRServiceManager.this.mSetA3dInterpolationFlag = false;
                        if (IXpSensor.XPSensorType.SENSOR_TYPE_UBX != xPSensorType) {
                            DRServiceManager dRServiceManager21 = DRServiceManager.this;
                            dRServiceManager21.onAccelUpdate(fArr, millis, currentTimeMillis, dRServiceManager21.mA3dTimeChipInt, xPSensorType);
                        }
                    } else {
                        DRServiceManager dRServiceManager22 = DRServiceManager.this;
                        str = ", CycleNum is ";
                        dRServiceManager22.onAccelUpdate(fArr, millis, currentTimeMillis, dRServiceManager22.mA3dTimeChipInt, xPSensorType);
                    }
                    DRServiceManager.access$5708(DRServiceManager.this);
                    DRServiceManager.this.mA3dTimeChipFloat += DRServiceManager.this.mA3dTimeChip;
                    DRServiceManager dRServiceManager23 = DRServiceManager.this;
                    dRServiceManager23.mA3dTimeChipInt = (int) dRServiceManager23.mA3dTimeChipFloat;
                    if (DRServiceManager.this.mA3dCycleNum == DRServiceManager.this.mA3dTickCnt) {
                        DRServiceManager.this.mA3dTickCnt = 0;
                        DRServiceManager.this.mA3dTimeChipFloat = 0.0f;
                        DRServiceManager.this.mA3dTimeChipInt = 0;
                        z2 = true;
                        DRServiceManager.this.mSetA3dInterpolationFlag = true;
                        z = z2;
                    }
                    z = true;
                } else {
                    str = ", CycleNum is ";
                    if (DRServiceManager.this.mA3dLossRate <= 0.001f) {
                        z = true;
                        DRServiceManager.this.onAccelUpdate(fArr, millis, currentTimeMillis, 0, xPSensorType);
                    } else {
                        DRServiceManager dRServiceManager24 = DRServiceManager.this;
                        dRServiceManager24.onAccelUpdate(fArr, millis, currentTimeMillis, -dRServiceManager24.mA3dTimeChipInt, xPSensorType);
                        DRServiceManager.access$5708(DRServiceManager.this);
                        DRServiceManager.this.mA3dTimeChipFloat += DRServiceManager.this.mA3dTimeChip;
                        DRServiceManager dRServiceManager25 = DRServiceManager.this;
                        dRServiceManager25.mA3dTimeChipInt = (int) dRServiceManager25.mA3dTimeChipFloat;
                        if (DRServiceManager.this.mA3dCycleNum == DRServiceManager.this.mA3dTickCnt) {
                            DRServiceManager.this.mA3dTickCnt = 0;
                            DRServiceManager.this.mA3dTimeChipFloat = 0.0f;
                            DRServiceManager.this.mA3dTimeChipInt = 0;
                            z2 = true;
                            DRServiceManager.this.mSetA3dInterpolationFlag = true;
                            if (DRServiceManager.this.mSetA3dInterpolationFlag && IXpSensor.XPSensorType.SENSOR_TYPE_UBX == xPSensorType) {
                                z = true;
                                DRServiceManager.this.onAccelUpdate(fArr, millis, currentTimeMillis, 0, xPSensorType);
                            }
                            z = z2;
                        }
                        z = true;
                    }
                }
                if (DRServiceManager.this.mEnableBLDR) {
                    if (DRServiceManager.this.mCarSpeedDataCnt >= 600 && DRServiceManager.this.mCarSpeedDataCntStartFlag) {
                        DRServiceManager.this.mCarSpeedDataCntStartFlag = false;
                        DRServiceManager.this.mCarSpeedDataCntEndFlag = z;
                        DRServiceManager.this.mCarSpeedStartTime = millis - currentTimeMillis;
                        DRServiceManager dRServiceManager26 = DRServiceManager.this;
                        dRServiceManager26.mCarSpeedDataCntStart = dRServiceManager26.mCarSpeedDataCnt;
                    }
                    if (DRServiceManager.this.mCarSpeedDataCnt >= 1600 && DRServiceManager.this.mCarSpeedDataCntEndFlag) {
                        DRServiceManager.this.mCarSpeedDataCntEndFlag = false;
                        DRServiceManager.this.mCarSpeedEndTime = millis - currentTimeMillis;
                        DRServiceManager dRServiceManager27 = DRServiceManager.this;
                        dRServiceManager27.mCarSpeedDataCntEnd = dRServiceManager27.mCarSpeedDataCnt;
                        DRServiceManager.this.mCarSpeedLossRate = 1.0f - ((dRServiceManager.mCarSpeedDataCntEnd - DRServiceManager.this.mCarSpeedDataCntStart) / (((float) (DRServiceManager.this.mCarSpeedEndTime - DRServiceManager.this.mCarSpeedStartTime)) * 0.01f));
                        DRServiceManager.this.mCarSpeedDataFreq = (dRServiceManager2.mCarSpeedDataCntEnd - DRServiceManager.this.mCarSpeedDataCntStart) / (((float) (DRServiceManager.this.mCarSpeedEndTime - DRServiceManager.this.mCarSpeedStartTime)) * 0.001f);
                        DRServiceManager dRServiceManager28 = DRServiceManager.this;
                        dRServiceManager28.mCarSpeedCycleNum = (int) Math.abs(0.1f / (0.1f - (1.0f / dRServiceManager28.mCarSpeedDataFreq)));
                        DRServiceManager.this.mCarSpeedTimeChip = 100.0f / dRServiceManager3.mCarSpeedCycleNum;
                        L.i(DRServiceManager.TAG, "CarSpeed LossRate is " + DRServiceManager.this.mCarSpeedLossRate + str + DRServiceManager.this.mCarSpeedCycleNum + ", TimeChip is " + DRServiceManager.this.mCarSpeedTimeChip);
                    }
                    if (DRServiceManager.this.mCarSpeedDataCntStartFlag || DRServiceManager.this.mCarSpeedDataCntEndFlag) {
                        DRServiceManager.access$5908(DRServiceManager.this);
                    }
                    if (((int) DRServiceManager.this.mEspRawSpeed) != 0 && !DRServiceManager.this.mCarSpeedInitStatus) {
                        DRServiceManager.this.mCarSpeedInitStatus = z;
                    }
                    if (!CarFeatureManager.INSTANCE.isEspAndScuAutoPilotSpeedFusionEnable()) {
                        if (DRServiceManager.this.mCarSpeedInitStatus) {
                            DRServiceManager dRServiceManager29 = DRServiceManager.this;
                            dRServiceManager29.mCarSpeedTemp = dRServiceManager29.mCarForward * DRServiceManager.this.mEspRawSpeed;
                        } else {
                            DRServiceManager dRServiceManager30 = DRServiceManager.this;
                            dRServiceManager30.mCarSpeedTemp = (dRServiceManager30.mCarForward * DRServiceManager.this.mScuSpeed) / DRServiceManager.REAL_CAR_SPEED_SCALE_FACTOR;
                        }
                    } else {
                        DRServiceManager dRServiceManager31 = DRServiceManager.this;
                        dRServiceManager31.mCarSpeedTemp = dRServiceManager31.espAndScuAutoPilotSpeedFusion(dRServiceManager31.mCarForward * DRServiceManager.this.mEspRawSpeed, DRServiceManager.this.mScuAutoPilotSpeed);
                    }
                    if (!RootUtil.isUserVersion()) {
                        DRServiceManager dRServiceManager32 = DRServiceManager.this;
                        float onZeroSpeedCalibration = dRServiceManager32.onZeroSpeedCalibration(dRServiceManager32.mCarSpeedTemp);
                        DRServiceManager.this.mCarSpeedTemp += onZeroSpeedCalibration;
                        if (RootUtil.sIsDrTestMode && Math.abs(onZeroSpeedCalibration) > 0.1f) {
                            L.i(DRServiceManager.TAG, "calibration speed is " + onZeroSpeedCalibration + " km/hr");
                            DRDebugEvent dRDebugEvent = new DRDebugEvent(4);
                            dRDebugEvent.mCalibrationSpeed = onZeroSpeedCalibration;
                            EventBus.getDefault().post(dRDebugEvent);
                        }
                    }
                    DRServiceManager.access$7808(DRServiceManager.this);
                    if (DRServiceManager.this.mPreviousCarSpeedLogTime >= 300) {
                        DRServiceManager.this.mPreviousCarSpeedLogTime = 0L;
                        if (CarFeatureManager.INSTANCE.isEspAndScuAutoPilotSpeedFusionEnable()) {
                            L.i(DRServiceManager.TAG, "Car speed from Fusion: " + DRServiceManager.this.mCarSpeedTemp);
                        } else if (DRServiceManager.this.mCarSpeedInitStatus) {
                            L.i(DRServiceManager.TAG, "Car speed from ESP: " + DRServiceManager.this.mCarSpeedTemp);
                        } else {
                            L.i(DRServiceManager.TAG, "Car speed from ICM: " + DRServiceManager.this.mCarSpeedTemp);
                        }
                    }
                    if (DRServiceManager.this.mCarSpeedLossRate < -0.001f) {
                        if (DRServiceManager.this.mSetCarSpeedInterpolationFlag) {
                            DRServiceManager.this.mSetCarSpeedInterpolationFlag = false;
                            if (IXpSensor.XPSensorType.SENSOR_TYPE_UBX != xPSensorType) {
                                DRServiceManager dRServiceManager33 = DRServiceManager.this;
                                dRServiceManager33.onSpeedUpdate(millis, currentTimeMillis, dRServiceManager33.mCarSpeedTemp, DRServiceManager.this.mCarSpeedTimeChipInt);
                            }
                        } else {
                            DRServiceManager dRServiceManager34 = DRServiceManager.this;
                            dRServiceManager34.onSpeedUpdate(millis, currentTimeMillis, dRServiceManager34.mCarSpeedTemp, DRServiceManager.this.mCarSpeedTimeChipInt);
                        }
                        DRServiceManager.access$8208(DRServiceManager.this);
                        DRServiceManager.this.mCarSpeedTimeChipFloat += DRServiceManager.this.mCarSpeedTimeChip;
                        DRServiceManager dRServiceManager35 = DRServiceManager.this;
                        dRServiceManager35.mCarSpeedTimeChipInt = (int) dRServiceManager35.mCarSpeedTimeChipFloat;
                        if (DRServiceManager.this.mCarSpeedCycleNum == DRServiceManager.this.mCarSpeedTickCnt) {
                            DRServiceManager.this.mCarSpeedTickCnt = 0;
                            DRServiceManager.this.mCarSpeedTimeChipFloat = 0.0f;
                            DRServiceManager.this.mCarSpeedTimeChipInt = 0;
                            DRServiceManager.this.mSetCarSpeedInterpolationFlag = z;
                        }
                    } else if (DRServiceManager.this.mCarSpeedLossRate > 0.001f) {
                        DRServiceManager dRServiceManager36 = DRServiceManager.this;
                        dRServiceManager36.onSpeedUpdate(millis, currentTimeMillis, dRServiceManager36.mCarSpeedTemp, -DRServiceManager.this.mCarSpeedTimeChipInt);
                        DRServiceManager.access$8208(DRServiceManager.this);
                        DRServiceManager.this.mCarSpeedTimeChipFloat += DRServiceManager.this.mCarSpeedTimeChip;
                        DRServiceManager dRServiceManager37 = DRServiceManager.this;
                        dRServiceManager37.mCarSpeedTimeChipInt = (int) dRServiceManager37.mCarSpeedTimeChipFloat;
                        if (DRServiceManager.this.mCarSpeedCycleNum == DRServiceManager.this.mCarSpeedTickCnt) {
                            DRServiceManager.this.mCarSpeedTickCnt = 0;
                            DRServiceManager.this.mCarSpeedTimeChipFloat = 0.0f;
                            DRServiceManager.this.mCarSpeedTimeChipInt = 0;
                            DRServiceManager.this.mSetCarSpeedInterpolationFlag = z;
                            if (DRServiceManager.this.mSetCarSpeedInterpolationFlag && IXpSensor.XPSensorType.SENSOR_TYPE_UBX == xPSensorType) {
                                DRServiceManager dRServiceManager38 = DRServiceManager.this;
                                dRServiceManager38.onSpeedUpdate(millis, currentTimeMillis, dRServiceManager38.mCarSpeedTemp, 0);
                            }
                        }
                    } else {
                        DRServiceManager dRServiceManager39 = DRServiceManager.this;
                        dRServiceManager39.onSpeedUpdate(millis, currentTimeMillis, dRServiceManager39.mCarSpeedTemp, 0);
                    }
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface ILocChangeTestListener {
        void locChange(TestLocInfo testLocInfo);
    }

    /* loaded from: classes3.dex */
    public interface ILocDebugSwitchListener {
        void locDebugSwitch(boolean z);
    }

    private boolean isValidTemperature(float f) {
        return f > -100.0f && f < 100.0f;
    }

    private boolean onCheckGnssSignalQuality(byte b, float f, float f2, int i) {
        return 65 == b && f < 0.8f && f2 < 5.0f && i > 10;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPProviderDisabled(String str) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPProviderEnabled(String str) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPStatusChanged(String str, int i, Bundle bundle) {
    }

    static /* synthetic */ long access$2508(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mUbxDebugUDPClientOpenCnt;
        dRServiceManager.mUbxDebugUDPClientOpenCnt = 1 + j;
        return j;
    }

    static /* synthetic */ long access$2608(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mPollMonHwAgcCnt;
        dRServiceManager.mPollMonHwAgcCnt = 1 + j;
        return j;
    }

    static /* synthetic */ long access$3008(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mLogCnt;
        dRServiceManager.mLogCnt = 1 + j;
        return j;
    }

    static /* synthetic */ int access$3308(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mSensorStatisticCount;
        dRServiceManager.mSensorStatisticCount = i + 1;
        return i;
    }

    static /* synthetic */ long access$4208(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mPreviousAccelLogTime;
        dRServiceManager.mPreviousAccelLogTime = 1 + j;
        return j;
    }

    static /* synthetic */ int access$4308(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mA3dDataCnt;
        dRServiceManager.mA3dDataCnt = i + 1;
        return i;
    }

    static /* synthetic */ int access$5708(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mA3dTickCnt;
        dRServiceManager.mA3dTickCnt = i + 1;
        return i;
    }

    static /* synthetic */ int access$5908(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mCarSpeedDataCnt;
        dRServiceManager.mCarSpeedDataCnt = i + 1;
        return i;
    }

    static /* synthetic */ long access$7808(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mPreviousCarSpeedLogTime;
        dRServiceManager.mPreviousCarSpeedLogTime = 1 + j;
        return j;
    }

    static /* synthetic */ int access$8208(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mCarSpeedTickCnt;
        dRServiceManager.mCarSpeedTickCnt = i + 1;
        return i;
    }

    static /* synthetic */ long access$8408(DRServiceManager dRServiceManager) {
        long j = dRServiceManager.mPreviousGyrLogTime;
        dRServiceManager.mPreviousGyrLogTime = 1 + j;
        return j;
    }

    static /* synthetic */ int access$8508(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mGyrDataCnt;
        dRServiceManager.mGyrDataCnt = i + 1;
        return i;
    }

    static /* synthetic */ int access$9908(DRServiceManager dRServiceManager) {
        int i = dRServiceManager.mGyrTickCnt;
        dRServiceManager.mGyrTickCnt = i + 1;
        return i;
    }

    @NonNull
    public static DRServiceManager getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUbxGnssOutageStatistic() {
        L.w(TAG, "resetUbxGnssOutageStatistic");
        this.mGnssOutageReportCheckTime = SystemClock.uptimeMillis();
        this.mSpeedCollection.clear();
        this.mSpeedSum = 0;
        this.mLinkTypeCollection.clear();
        this.mLinkTypeSum = 0;
        this.mDistanceCollection.clear();
        this.mDistanceSum = 0;
        this.mIsLastLinkTunnel = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float onZeroSpeedCalibration(float f) {
        LocInfo currentLocInfo;
        this.mZeroSpeedCnt++;
        if (Math.abs(f) > 0.1f) {
            this.mZeroSpeedCnt = 0;
            return 0.0f;
        }
        if (this.mZeroSpeedCnt >= 10) {
            this.mZeroSpeedCnt = 0;
            if (!this.mGnssSignalQuality || !this.mGnssForward || this.mGnssLocation == null || (currentLocInfo = this.mPosServiceWrapper.getCurrentLocInfo()) == null) {
                return 0.0f;
            }
            float f2 = currentLocInfo.matchInfo.get(0).roadCourse;
            Coord3DDouble coord3DDouble = new Coord3DDouble();
            coord3DDouble.lon = this.mGnssLocation.getLongitude();
            coord3DDouble.lat = this.mGnssLocation.getLatitude();
            coord3DDouble.z = this.mGnssLocation.getAltitude();
            Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(coord3DDouble);
            if (encryptLonLat == null) {
                return 0.0f;
            }
            double d = currentLocInfo.matchInfo.get(0).stPos.lon;
            double d2 = currentLocInfo.matchInfo.get(0).stPos.lat;
            double d3 = encryptLonLat.lon - d;
            double d4 = encryptLonLat.lat - d2;
            return (((float) (LocationUtils.getDistance(new XPCoordinate2DDouble(encryptLonLat.lon, encryptLonLat.lat), new XPCoordinate2DDouble(d, d2)) * Math.cos((Math.abs(f2 - (0.0d != d4 ? Math.toDegrees(Math.atan2(d3, d4)) : 0.0d)) * 3.141592653589793d) / 180.0d))) * MPS_TO_KMPHR) / 1.0f;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float espAndScuAutoPilotSpeedFusion(float f, float f2) {
        if (Math.abs(f - f2) > SCU_SPEED_ERROR_GAP) {
            return f;
        }
        if (Math.abs(f) <= SPEED_UPPER_LIMIT && Math.abs(f) >= SPEED_LOWER_LIMIT) {
            return ((1.0f - ((Math.abs(f) - SPEED_LOWER_LIMIT) * 0.1f)) * f2) + ((Math.abs(f) - SPEED_LOWER_LIMIT) * 0.1f * f);
        }
        if (Math.abs(f) < SPEED_LOWER_LIMIT) {
            return f2;
        }
        if (Math.abs(f) > SPEED_UPPER_LIMIT) {
            return f;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatData(int i, float f) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.e(TAG, "sendStatData getCurrentLocation is null.");
        } else {
            DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.LOCATION_RESET_UBX, Integer.valueOf(i), currentLocation, Float.valueOf(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEnablePollMonHwAgc(boolean z) {
        UbxDebugUDPClient ubxDebugUDPClient = this.mUbxDebugUDPClient;
        if (ubxDebugUDPClient == null) {
            return;
        }
        ubxDebugUDPClient.enablePollMonHwAgc(z);
    }

    private void sendStatData(int i) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.e(TAG, "sendStatData getCurrentLocation is null.");
        } else {
            DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.LOCATION_RESET_UBX, Integer.valueOf(i), currentLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAccelUpdate(float[] fArr, long j, long j2, int i, IXpSensor.XPSensorType xPSensorType) {
        if (this.mMountAngle != null) {
            if (CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                sendLocAcce3dData((this.mMountAngle.getAutoPolitIMUConvertRatio().getX() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getX()]) / 9.8f, (this.mMountAngle.getAutoPolitIMUConvertRatio().getY() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getY()]) / 9.8f, (this.mMountAngle.getAutoPolitIMUConvertRatio().getZ() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getZ()]) / 9.8f, (j - j2) + i);
            } else {
                sendLocAcce3dData((this.mMountAngle.getRawIMUConvertRatio().getX() * fArr[this.mMountAngle.getRawIMUConvertType().getX()]) / 9.8f, (this.mMountAngle.getRawIMUConvertRatio().getY() * fArr[this.mMountAngle.getRawIMUConvertType().getY()]) / 9.8f, (this.mMountAngle.getRawIMUConvertRatio().getZ() * fArr[this.mMountAngle.getRawIMUConvertType().getZ()]) / 9.8f, (j - j2) + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSpeedUpdate(long j, long j2, float f, int i) {
        sendLocPulse(f, (j - j2) + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGyroUpdate(float[] fArr, float f, long j, long j2, int i, IXpSensor.XPSensorType xPSensorType) {
        this.mSensorUpdateTime = SystemClock.uptimeMillis();
        if (this.mMountAngle != null) {
            if (CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                sendLocGyroData(this.mMountAngle.getAutoPolitIMUConvertRatio().getX() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getX()], this.mMountAngle.getAutoPolitIMUConvertRatio().getY() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getY()], this.mMountAngle.getAutoPolitIMUConvertRatio().getZ() * fArr[this.mMountAngle.getAutoPolitIMUConvertType().getZ()], (j - j2) + i, f);
            } else {
                sendLocGyroData(this.mMountAngle.getRawIMUConvertRatio().getX() * fArr[this.mMountAngle.getRawIMUConvertType().getX()], this.mMountAngle.getRawIMUConvertRatio().getY() * fArr[this.mMountAngle.getRawIMUConvertType().getY()], this.mMountAngle.getRawIMUConvertRatio().getZ() * fArr[this.mMountAngle.getRawIMUConvertType().getZ()], (j - j2) + i, f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUDPFailureAndResetCnt(int i, int i2) {
        if (i == 0 && i2 == 0 && !this.mPowerOnFlagForLossRate) {
            return;
        }
        this.mA3dStartTime = 0L;
        this.mA3dEndTime = 1L;
        this.mA3dDataCnt = 0;
        this.mA3dDataCntStartFlag = true;
        this.mA3dDataCntEndFlag = false;
        this.mA3dDataCntStart = 0;
        this.mA3dDataCntEnd = 0;
        this.mSetA3dInterpolationFlag = false;
        this.mA3dLossRate = 0.0f;
        this.mA3dDataFreq = 0.0f;
        this.mA3dCycleNum = 100;
        this.mA3dTickCnt = 0;
        this.mA3dTimeChip = 0.0f;
        this.mA3dTimeChipFloat = 0.0f;
        this.mA3dTimeChipInt = 0;
        this.mCarSpeedStartTime = 0L;
        this.mCarSpeedEndTime = 1L;
        this.mCarSpeedDataCnt = 0;
        this.mCarSpeedDataCntStartFlag = true;
        this.mCarSpeedDataCntEndFlag = false;
        this.mCarSpeedDataCntStart = 0;
        this.mCarSpeedDataCntEnd = 0;
        this.mSetCarSpeedInterpolationFlag = false;
        this.mCarSpeedLossRate = 0.0f;
        this.mCarSpeedDataFreq = 0.0f;
        this.mCarSpeedCycleNum = 100;
        this.mCarSpeedTickCnt = 0;
        this.mCarSpeedTimeChip = 0.0f;
        this.mCarSpeedTimeChipFloat = 0.0f;
        this.mCarSpeedTimeChipInt = 0;
        this.mGyrStartTime = 0L;
        this.mGyrEndTime = 1L;
        this.mGyrDataCnt = 0;
        this.mGyrDataCntStartFlag = true;
        this.mGyrDataCntEndFlag = false;
        this.mGyrDataCntStart = 0;
        this.mGyrDataCntEnd = 0;
        this.mSetGyrInterpolationFlag = false;
        this.mGyrLossRate = 0.0f;
        this.mGyrDataFreq = 0.0f;
        this.mGyrCycleNum = 100;
        this.mGyrTickCnt = 0;
        this.mGyrTimeChip = 0.0f;
        this.mGyrTimeChipFloat = 0.0f;
        this.mGyrTimeChipInt = 0;
        if (this.mPowerOnFlagForLossRate) {
            this.mPowerOnFlagForLossRate = false;
            L.i(TAG, "screen on and reCompute LossRate cnt");
        }
    }

    public boolean isStart() {
        return this.mStarted;
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        this.mMapDelegate = iMapDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onCheckGnssLocationError(XPCoordinate2DDouble xPCoordinate2DDouble) {
        XPCoordinate2DDouble xPCoordinate2DDouble2 = this.mPreviousCarLocation;
        if (xPCoordinate2DDouble2 == null) {
            this.mPreviousCarLocation = xPCoordinate2DDouble;
            return false;
        }
        double distance = LocationUtils.getDistance(xPCoordinate2DDouble, xPCoordinate2DDouble2);
        this.mPreviousCarLocation = xPCoordinate2DDouble;
        this.mDistanceCollection.add(Integer.valueOf((int) distance));
        if (distance > 100.0d) {
            this.mDistanceSum++;
        }
        if (this.mDistanceCollection.size() > 300) {
            if (this.mDistanceCollection.get(0).intValue() > 100) {
                this.mDistanceSum--;
            }
            this.mDistanceCollection.remove(0);
            if (this.mDistanceSum > 5) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGnssOutage(boolean z, int i) {
        return isGnssTimeout(SystemClock.uptimeMillis(), z ? 204000L : 300000L) && isHighSpeedMode(this.mScuSpeed, z ? 204 : 300) && !isInTunnel(z ? 204 : 300, i);
    }

    private boolean isGnssTimeout(long j, long j2) {
        return j - this.mGnssOutageReportCheckTime > j2;
    }

    private boolean isInTunnel(int i, int i2) {
        if (2 == i2) {
            this.mLinkTypeCollection.add((byte) 1);
            this.mLinkTypeSum++;
        } else {
            this.mLinkTypeCollection.add((byte) 0);
        }
        if (this.mLinkTypeCollection.size() > i) {
            if (1 == this.mLinkTypeCollection.get(0).byteValue()) {
                this.mLinkTypeSum--;
            }
            this.mLinkTypeCollection.remove(0);
        }
        return ((float) this.mLinkTypeSum) > ((float) i) * SIGMA_1;
    }

    private boolean isHighSpeedMode(float f, int i) {
        if (f >= 30.0f) {
            this.mSpeedCollection.add((byte) 1);
            this.mSpeedSum++;
        } else {
            this.mSpeedCollection.add((byte) 0);
        }
        if (this.mSpeedCollection.size() > i) {
            if (1 == this.mSpeedCollection.get(0).byteValue()) {
                this.mSpeedSum--;
            }
            this.mSpeedCollection.remove(0);
        }
        return ((float) this.mSpeedSum) > ((float) i) * SIGMA_1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mScuSpeed = f;
        long j = this.mPreviousScuTime;
        int i = 0 == j ? 100 : (int) (elapsedRealtime - j);
        this.mPreviousScuTime = elapsedRealtime;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Car speed received " + this.mScuSpeed + "km/h, with interval " + i + "ms");
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mEspRawSpeed = f;
        int i = (0L > this.mPreviousEspTime ? 1 : (0L == this.mPreviousEspTime ? 0 : -1));
        this.mPreviousEspTime = elapsedRealtime;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBcmPowerModeChange(int i) {
        if (CarServiceManager.getInstance().isBcmPowerOn()) {
            this.mPowerOnFlagForLossRate = true;
            this.mSensor.setPowerOnTime(SystemClock.uptimeMillis());
        } else {
            this.mSensor.setPowerOnTime(0L);
        }
        this.mNeedResetGnssOutageStatistic = true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Car PowerModeStatus received " + i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
        if (1 == i) {
            this.mPowerOnFlagForLossRate = true;
        }
        this.mNeedResetGnssOutageStatistic = true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Car IgStatusChange received " + i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
        this.mCarGearLevel = i;
        if (this.mCarGearLevel == 3) {
            this.mCarForward = -1.0f;
        } else {
            this.mCarForward = 1.0f;
        }
        if (4 == this.mCarGearLevel) {
            this.mPosServiceWrapper.setSaveLocStorage();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Car Gear Level is " + this.mCarGearLevel);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mScuAutoPilotSpeed = f * MPS_TO_KMPHR;
        int i = (0L > this.mPreviousScuAutoPilotTime ? 1 : (0L == this.mPreviousScuAutoPilotTime ? 0 : -1));
        this.mPreviousScuAutoPilotTime = elapsedRealtime;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuRawDataChange(boolean z, boolean z2, float[] fArr, long j) {
        IXpSensor iXpSensor = this.mSensor;
        if (iXpSensor != null) {
            iXpSensor.setRawData(z, z2, fArr, j);
        }
    }

    private void sendLocAcce3dData(float f, float f2, float f3, long j) {
        long j2 = this.mPreviousA3DTime;
        int i = 0 == j2 ? 100 : (int) (j - j2);
        this.mPreviousA3DTime = j;
        this.mPosServiceWrapper.setA3D(f, f2, f3, BigInteger.valueOf(j), i, false);
    }

    private void sendLocGyroData(float f, float f2, float f3, long j, float f4) {
        if (!isValidTemperature(f4)) {
            float readSystemTemperature = readSystemTemperature();
            if (!isValidTemperature(readSystemTemperature)) {
                L.Tag tag = TAG;
                L.e(tag, "Invalid sensor temperature[" + f4 + "], and system temperature[" + readSystemTemperature + "], return null and skip this transmission");
                return;
            }
        }
        long j2 = this.mPreviousGYRTime;
        int i = 0 == j2 ? 100 : (int) (j - j2);
        this.mPreviousGYRTime = j;
        this.mPosServiceWrapper.setGYR(f, f2, f3, BigInteger.valueOf(j), f4, i, false);
    }

    void sendLocPulse(float f, long j) {
        long j2 = this.mPreviousCarSpeedTime;
        int i = 0 == j2 ? 100 : (int) (j - j2);
        this.mPreviousCarSpeedTime = j;
        this.mPosServiceWrapper.setPulse(f, BigInteger.valueOf(j), i, false);
    }

    private void sendLocationInfoToSystem(@Nullable Location location) {
        if (location == null) {
            return;
        }
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lat = location.getLatitude();
        coord3DDouble.lon = location.getLongitude();
        coord3DDouble.z = location.getAltitude();
        Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(coord3DDouble);
        if (encryptLonLat == null) {
            L.e(TAG, "sendLocationInfoToSystem get encryptLonLat is null.");
            return;
        }
        Location location2 = new Location(location);
        location2.setLongitude(encryptLonLat.lon);
        location2.setLatitude(encryptLonLat.lat);
        this.mLocationDataUploader.uploadGPSLocation(location, location2, this.mSatelliteNum, this.mCityName, this.mCityAdCode);
    }

    private void sendGnssLocationInfoToSystem(@Nullable GnssLocation gnssLocation, long j) {
        if (gnssLocation == null) {
            return;
        }
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lat = gnssLocation.getLatitude();
        coord3DDouble.lon = gnssLocation.getLongitude();
        coord3DDouble.z = gnssLocation.getAltitude();
        Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(coord3DDouble);
        if (encryptLonLat == null) {
            L.e(TAG, "sendGnssLocationInfoToSystem get gcjLonLat is null.");
        } else {
            this.mLocationDataUploader.uploadGnssLocation(encryptLonLat.lat, encryptLonLat.lon, gnssLocation.getLatitude(), gnssLocation.getLongitude(), gnssLocation.getCourse(), gnssLocation.getSpeed(), gnssLocation.getAccuracy(), gnssLocation.getNumSV(), gnssLocation.getAltitude(), j, this.mCityName, this.mCityAdCode);
        }
    }

    private XPCoordinate2DDouble getCarLocation() {
        XPCoordinate2DDouble currentLocation;
        if (this.mPosServiceWrapper.getCurrentLocation(this) == null || (currentLocation = this.mPosServiceWrapper.getCurrentLocation(this)) == null) {
            return null;
        }
        if (NavCoreUtil.isInChina(currentLocation.mLon, currentLocation.mLat)) {
            return currentLocation;
        }
        L.Tag tag = TAG;
        L.w(tag, "Car location has INVALID lat and lon: (" + currentLocation.mLat + ", " + currentLocation.mLon + ")");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDRLocationInfoToSystem() {
        LocInfo currentLocInfo = this.mPosServiceWrapper.getCurrentLocInfo();
        if (currentLocInfo == null) {
            L.w(TAG, "currentLocInfo = null");
        } else if (!NavCoreUtil.isInChina(currentLocInfo.matchInfo.get(0).stPos.lon, currentLocInfo.matchInfo.get(0).stPos.lat)) {
            L.Tag tag = TAG;
            L.w(tag, "Car location has INVALID lat and lon: (" + currentLocInfo.matchInfo.get(0).stPos.lat + ", " + currentLocInfo.matchInfo.get(0).stPos.lon + ")");
        } else {
            this.mLocationDataUploader.uploadDRLocation((float) currentLocInfo.matchInfo.get(0).stPos.lat, (float) currentLocInfo.matchInfo.get(0).stPos.lon, currentLocInfo.matchInfo.get(0).course, currentLocInfo.speed, this.mCityName, this.mCityAdCode);
        }
    }

    private boolean onCheckGnssForward(double d, double d2, double d3, float f) {
        LocInfo currentLocInfo = this.mPosServiceWrapper.getCurrentLocInfo();
        if (currentLocInfo == null || -1 == currentLocInfo.matchInfo.get(0).roadClass) {
            return false;
        }
        float f2 = currentLocInfo.matchInfo.get(0).roadCourse;
        float abs = Math.abs(f2 - f);
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lon = d;
        coord3DDouble.lat = d2;
        coord3DDouble.z = d3;
        Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(coord3DDouble);
        double d4 = currentLocInfo.matchInfo.get(0).stPos.lon;
        double d5 = currentLocInfo.matchInfo.get(0).stPos.lat;
        if (encryptLonLat == null) {
            return false;
        }
        double d6 = encryptLonLat.lon - d4;
        double d7 = encryptLonLat.lat - d5;
        return abs < DEGREE_ROAD2GNSS && Math.abs(((double) f2) - (Math.abs(d7) > DELTA_LATITUDE_THRESHOLD ? Math.toDegrees(Math.atan2(d6, d7)) : 0.0d)) < DEGREE_ROAD2GNSSCAR;
    }

    private void sendNmeaLocData(GnssLocation gnssLocation, long j) {
        this.mPosServiceWrapper.setLocation(gnssLocation, false, j);
        this.mGnssSignalQuality = onCheckGnssSignalQuality(gnssLocation.getStatus(), gnssLocation.getHdop(), gnssLocation.getAccuracy(), gnssLocation.getNumSV());
        this.mGnssForward = onCheckGnssForward(gnssLocation.getLongitude(), gnssLocation.getLatitude(), gnssLocation.getAltitude(), gnssLocation.getCourse());
        this.mGnssOutageReportCheckTime = SystemClock.uptimeMillis();
        this.mLastRealGnssTime = this.mGnssOutageReportCheckTime;
        sendGnssLocationInfoToSystem(gnssLocation, utcDateToStamp(gnssLocation));
        if (RootUtil.sIsDrTestMode) {
            StatisticDataUtil.updateDRGnssInputTime();
            if (RootUtil.isUserVersion()) {
                return;
            }
            drawGPSandDRData(gnssLocation);
        }
    }

    private long utcDateToStamp(GnssLocation gnssLocation) {
        String str = gnssLocation.getYear() + "-" + gnssLocation.getMonth() + "-" + gnssLocation.getDay() + " " + gnssLocation.getHour() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + gnssLocation.getMinute() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + gnssLocation.getSecond();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeFormatUtil.DEFAULT_PATTERN);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    private void sendLocData(Location location) {
        sendLocationInfoToSystem(location);
        this.mPosServiceWrapper.setLocation(location, this.mSatelliteNum, this.mLatestHdop, this.mLatestVdop, this.mLatestPdop, false);
    }

    private void sendCarDebugLocData(Location location) {
        sendLocationInfoToSystem(location);
        this.mPosServiceWrapper.setLocation(location, this.mSatelliteNum, this.mLatestHdop, this.mLatestVdop, this.mLatestPdop, true);
    }

    @NonNull
    @Deprecated
    private LocSignData constructGsvData(GpsStatus gpsStatus, long j) {
        LocSignData locSignData = new LocSignData();
        locSignData.dataType = 64;
        locSignData.gpgsv = new LocGpgsv();
        locSignData.gpgsv.dataType = 64;
        int i = 0;
        locSignData.gpgsv.type = 0;
        locSignData.gpgsv.prn = new int[16];
        locSignData.gpgsv.elevation = new int[16];
        locSignData.gpgsv.azimuth = new int[16];
        locSignData.gpgsv.snr = new int[16];
        for (GpsSatellite gpsSatellite : gpsStatus.getSatellites()) {
            if (i == 16) {
                break;
            } else if (gpsSatellite.usedInFix()) {
                locSignData.gpgsv.prn[i] = gpsSatellite.getPrn();
                locSignData.gpgsv.elevation[i] = (int) gpsSatellite.getElevation();
                locSignData.gpgsv.azimuth[i] = (int) gpsSatellite.getAzimuth();
                locSignData.gpgsv.snr[i] = (int) gpsSatellite.getSnr();
                i++;
            }
        }
        locSignData.gpgsv.num = i;
        locSignData.gpgsv.tickTime = BigInteger.valueOf(j);
        printGsvLog();
        return locSignData;
    }

    private void drawGPSandDRData(@NonNull GnssLocation gnssLocation) {
        if (this.mGpsDebugCount.intValue() >= 1000) {
            if (isMapValid()) {
                this.mMapDelegate.getMapView().getBizControlManager().drawGPSandDRDataClearOverlay();
            }
            this.mGpsDebugCount = 0;
        }
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lat = gnssLocation.getLatitude();
        coord3DDouble.lon = gnssLocation.getLongitude();
        coord3DDouble.z = gnssLocation.getAltitude();
        Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(coord3DDouble);
        if (encryptLonLat == null) {
            L.e(TAG, "drawGPSandDRData get encryptLonLat is null.");
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "Draw DrTest Point.");
        }
        XPPointBaseData[] xPPointBaseDataArr = new XPPointBaseData[2];
        xPPointBaseDataArr[0] = new XPPointBaseData();
        XPPointBaseData xPPointBaseData = xPPointBaseDataArr[0];
        xPPointBaseData.id = "gps" + this.mGpsDebugCount.toString();
        xPPointBaseDataArr[0].position.lat = encryptLonLat.lat;
        xPPointBaseDataArr[0].position.lon = encryptLonLat.lon;
        if (isMapValid()) {
            XPCoordinate2DDouble currentDrLocation = this.mPosServiceWrapper.getCurrentDrLocation();
            xPPointBaseDataArr[1] = new XPPointBaseData();
            XPPointBaseData xPPointBaseData2 = xPPointBaseDataArr[1];
            xPPointBaseData2.id = "dr" + this.mGpsDebugCount.toString();
            xPPointBaseDataArr[1].position.lat = currentDrLocation.mLat;
            xPPointBaseDataArr[1].position.lon = currentDrLocation.mLon;
        }
        XPPointBaseData[] xPPointBaseDataArr2 = new XPPointBaseData[2];
        xPPointBaseDataArr2[0] = new XPPointBaseData();
        XPPointBaseData xPPointBaseData3 = xPPointBaseDataArr2[0];
        xPPointBaseData3.id = "gpstrace" + this.mGpsDebugCount.toString();
        xPPointBaseDataArr2[0].position.lat = encryptLonLat.lat;
        xPPointBaseDataArr2[0].position.lon = encryptLonLat.lon;
        if (isMapValid()) {
            XPCoordinate2DDouble currentDrLocation2 = this.mPosServiceWrapper.getCurrentDrLocation();
            xPPointBaseDataArr2[1] = new XPPointBaseData();
            XPPointBaseData xPPointBaseData4 = xPPointBaseDataArr2[1];
            xPPointBaseData4.id = "drtrace" + this.mGpsDebugCount.toString();
            xPPointBaseDataArr2[1].position.lat = currentDrLocation2.mLat;
            xPPointBaseDataArr2[1].position.lon = currentDrLocation2.mLon;
        }
        this.mGpsDebugCount = Integer.valueOf(this.mGpsDebugCount.intValue() + 1);
        if (isMapValid()) {
            this.mMapDelegate.getMapView().getBizControlManager().drawGPSandDRDataAddIOverlay(xPPointBaseDataArr, xPPointBaseDataArr2);
        }
    }

    public void init(boolean z, @NonNull PosServiceWrapper posServiceWrapper, @NonNull LocationDataUploader locationDataUploader) {
        L.Tag tag = TAG;
        L.i(tag, "DRServiceManager init enable dr:" + z);
        this.mPosServiceWrapper = posServiceWrapper;
        this.mEnableBLDR = z;
        this.mUserExpectToEnableBLDR = z;
        this.mLocationDataUploader = locationDataUploader;
        start();
        this.mLocationManager = LocationServiceManager.getInstance();
        this.mLocationManager.addXPLocationListener(this);
    }

    public boolean isDREnabled() {
        return this.mEnableBLDR;
    }

    public boolean isTestModeEnabled() {
        return RootUtil.sIsDrTestMode;
    }

    public void setTestMode(boolean z) {
        if (z == RootUtil.sIsDrTestMode) {
            return;
        }
        this.mGpsDebugCount = 0;
        if (isMapValid()) {
            this.mMapDelegate.getMapView().getBizControlManager().setTestMode();
        }
        RootUtil.sIsDrTestMode = z;
    }

    public boolean start() {
        if (L.ENABLE) {
            L.d(TAG, "Start DRServiceManager's services");
        }
        if (this.mStarted) {
            return true;
        }
        this.mStarted = true;
        this.mSetSaveLocStorageHandler = new Handler(WorkThreadUtil.getInstance().getSetSaveLocStorageThreadLooper());
        this.mSetSaveLocStorageHandler.postDelayed(this.mSetSaveLocStorageRunnable, 100000L);
        this.mSendDRLocationInfoToSystemHandler = new Handler(WorkThreadUtil.getInstance().getSendDRLocationInfoToSystemThreadLooper());
        this.mSendDRLocationInfoToSystemHandler.postDelayed(this.mSendDRLocationInfoToSystemRunnable, 1000L);
        this.mCheckDataCityAdCodeHandler = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper());
        this.mCheckDataCityAdCodeHandler.postDelayed(this.mCheckDataCityAdCodeRunnable, this.mCheckDataCityAdCodeThreadInterval);
        this.mNmeaGxgsvHelper = new NmeaGxgsvHelper(this);
        this.mLocDebugHelper = new LocDebugHelper();
        if (this.mUserExpectToEnableBLDR) {
            this.mSensorDataProcessHelper = new SensorDataProcessHelper();
            this.mGnssDataProcessHelper = new GnssDataProcessHelper();
            this.mMountAngle = MountAngleManager.XP_CAR_MOUNT_ANGLE_MAP.get(Integer.valueOf(CarServiceManager.getInstance().getCarType()));
            if (this.mMountAngle != null) {
                L.Tag tag = TAG;
                L.i(tag, this.mMountAngle.getRawIMU().getX() + "," + this.mMountAngle.getRawIMU().getY() + "," + this.mMountAngle.getRawIMU().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + this.mMountAngle.getRawIMUConvertType().getX() + "," + this.mMountAngle.getRawIMUConvertType().getY() + "," + this.mMountAngle.getRawIMUConvertType().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + this.mMountAngle.getRawIMUConvertRatio().getX() + "," + this.mMountAngle.getRawIMUConvertRatio().getY() + "," + this.mMountAngle.getRawIMUConvertRatio().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + this.mMountAngle.getAutoPolitIMU().getX() + "," + this.mMountAngle.getAutoPolitIMU().getY() + "," + this.mMountAngle.getAutoPolitIMU().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + this.mMountAngle.getAutoPolitIMUConvertType().getX() + "," + this.mMountAngle.getAutoPolitIMUConvertType().getY() + "," + this.mMountAngle.getAutoPolitIMUConvertType().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + this.mMountAngle.getAutoPolitIMUConvertRatio().getX() + "," + this.mMountAngle.getAutoPolitIMUConvertRatio().getY() + "," + this.mMountAngle.getAutoPolitIMUConvertRatio().getZ() + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
            if (!CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                L.Tag tag2 = TAG;
                L.i(tag2, "isRawIMUFromCan:" + this.mMountAngle.isRawIMUFromCan());
                this.mSensor = this.mMountAngle.isRawIMUFromCan() ? new ImuSensor() : new UbxSensor();
            } else {
                L.Tag tag3 = TAG;
                L.i(tag3, "isAutoPolitIMUFromCan:" + this.mMountAngle.isAutoPolitIMUFromCan());
                this.mSensor = this.mMountAngle.isAutoPolitIMUFromCan() ? new ImuSensor() : new UbxSensor();
            }
            this.mSensor.setClientListener(this.mUDPClientListener);
            this.mSensor.open();
            CarServiceManager.getInstance().addCarStateListener(this);
            if (CarServiceManager.getInstance().isBcmPowerOn()) {
                this.mSensor.setPowerOnTime(SystemClock.uptimeMillis());
            }
        }
        return true;
    }

    public void stop() {
        if (L.ENABLE) {
            L.d(TAG, "Stop DRServiceManager's services");
        }
        if (this.mStarted) {
            CarServiceManager.getInstance().removeCarStateListener(this);
            this.mLocationManager.removeXPLocationListener(this);
            this.mStarted = false;
            this.mSensor.close();
            this.mScuSpeed = 0.0f;
            this.mEspRawSpeed = 0.0f;
            this.mSetSaveLocStorageHandler.removeCallbacks(null);
            this.mSendDRLocationInfoToSystemHandler.removeCallbacks(null);
            this.mCheckDataCityAdCodeHandler.removeCallbacks(null);
            this.mNmeaGxgsvHelper.unInit();
        }
    }

    private float readSystemTemperature() {
        float valueFromFilePath = valueFromFilePath(PATH_TEMP_1);
        float valueFromFilePath2 = valueFromFilePath(PATH_TEMP_2);
        boolean z = !Float.isNaN(valueFromFilePath);
        boolean z2 = !Float.isNaN(valueFromFilePath2);
        if (z && z2) {
            valueFromFilePath = (valueFromFilePath + valueFromFilePath2) / 2.0f;
        } else if (z) {
            logInvalidTemperature(2);
        } else if (z2) {
            logInvalidTemperature(1);
            valueFromFilePath = valueFromFilePath2;
        } else {
            valueFromFilePath = this.mLastTemperature;
            logInvalidTemperature(3);
        }
        this.mLastTemperature = valueFromFilePath;
        return valueFromFilePath;
    }

    private void logInvalidTemperature(int i) {
        if (i == 1) {
            this.mInvalidTemperaturePathCount1++;
        } else if (i == 2) {
            this.mInvalidTemperaturePathCount2++;
        } else if (i == 3) {
            this.mInvalidTemperaturePathCount1++;
            this.mInvalidTemperaturePathCount2++;
        }
        if (System.currentTimeMillis() - this.mLastInvalidTemperatureTime >= 10000) {
            L.w(TAG, "Path 1 invalid count is : " + this.mInvalidTemperaturePathCount1 + "\nPath 2 invalid count is : " + this.mInvalidTemperaturePathCount2 + "\nTotal invalid count is : " + (this.mInvalidTemperaturePathCount1 + this.mInvalidTemperaturePathCount2));
            this.mInvalidTemperaturePathCount1 = 0;
            this.mInvalidTemperaturePathCount2 = 0;
            this.mLastInvalidTemperatureTime = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:33:0x0041). Please submit an issue!!! */
    private float valueFromFilePath(@NonNull String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            r5 = fileInputStream.read(bArr) != -1 ? Float.parseFloat(new String(bArr).trim()) : Float.NaN;
            fileInputStream.close();
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return r5;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return r5;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPLocationChanged(@NonNull Location location) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onLocationChanged() called with: location = [" + location.getTime() + "]");
        }
        DRDebugEvent dRDebugEvent = new DRDebugEvent(2);
        dRDebugEvent.mLocation = location;
        EventBus.getDefault().post(dRDebugEvent);
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPDebugLocationChanged(@NonNull Location location) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onXPDebugLocationChanged location=" + location.toString());
        }
        sendLocData(location);
        DRDebugEvent dRDebugEvent = new DRDebugEvent(2);
        dRDebugEvent.mLocation = location;
        EventBus.getDefault().post(dRDebugEvent);
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onXPDebugCarLocationChanged(@NonNull Location location) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onXPDebugCarLocationChanged location=" + location.toString());
        }
        sendCarDebugLocData(location);
        DRDebugEvent dRDebugEvent = new DRDebugEvent(2);
        dRDebugEvent.mLocation = location;
        EventBus.getDefault().post(dRDebugEvent);
        if (isMapValid()) {
            this.mMapDelegate.setCarLocation(location);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onMockNmeaReceived(long j, String str, long j2) {
        LocDebugHelper locDebugHelper;
        L.Tag tag = TAG;
        L.i(tag, "onNmeaReceived() called with: timestamp = [" + j + "], elapsedTime = [" + j2 + "],nmeaSentence = [" + str + "] ");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NmeaSentence nmeaSentence = new NmeaSentence(str, j);
        if (isLocDebugSwitch() && (locDebugHelper = this.mLocDebugHelper) != null) {
            locDebugHelper.sendNmeaReceiveMsg(nmeaSentence);
        }
        if (this.mGnssDataProcessHelper != null && CarServiceManager.getInstance().isBcmPowerOn() && !this.mGnssDataProcessHelper.getTtffTimeFlag()) {
            this.mGnssDataProcessHelper.sendNmeaReceiveMsg(nmeaSentence);
        }
        nmeaSentence.getGnssLocation(this.mGnssLocation);
        if (nmeaSentence.isLocationSentence()) {
            if (nmeaSentence.getLatestHdop() != null) {
                try {
                    this.mLatestHdop = Float.parseFloat(nmeaSentence.getLatestHdop());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            if (nmeaSentence.getLatestPdop() != null) {
                try {
                    this.mLatestPdop = Float.parseFloat(nmeaSentence.getLatestPdop());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            if (nmeaSentence.getLatestVdop() != null) {
                try {
                    this.mLatestVdop = Float.parseFloat(nmeaSentence.getLatestVdop());
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
            }
            if (nmeaSentence.getValidSatelliteNumber() != null) {
                try {
                    this.mSatelliteNum = Integer.parseInt(nmeaSentence.getValidSatelliteNumber());
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                }
            }
        } else if (nmeaSentence.isGSV() != -1) {
            this.mNmeaGxgsvHelper.onNmeaGxgsvReceived(j, str);
        }
        GnssLocation gnssLocation = this.mGnssLocation;
        if (gnssLocation != null && gnssLocation.getRmcUtcTime() == this.mGnssLocation.getGgaUtcTime() && this.mGnssLocation.isRmcEnable() && this.mGnssLocation.isGgaEnable() && this.mGnssLocation.isGsaEnable() && this.mGnssLocation.isGstEnable()) {
            this.mGnssLocation.setRmcEnable(false);
            this.mGnssLocation.setGgaEnable(false);
            this.mGnssLocation.setGsaEnable(false);
            this.mGnssLocation.setGstEnable(false);
            sendNmeaLocData(this.mGnssLocation, j2);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onNmeaReceived(long j, String str) {
        LocDebugHelper locDebugHelper;
        if (CarServiceManager.getInstance().isBcmPowerOn() && !TextUtils.isEmpty(str)) {
            NmeaSentence nmeaSentence = new NmeaSentence(str, j);
            if (isLocDebugSwitch() && (locDebugHelper = this.mLocDebugHelper) != null) {
                locDebugHelper.sendNmeaReceiveMsg(nmeaSentence);
            }
            if (this.mGnssDataProcessHelper != null && CarServiceManager.getInstance().isBcmPowerOn() && !this.mGnssDataProcessHelper.getTtffTimeFlag()) {
                this.mGnssDataProcessHelper.sendNmeaReceiveMsg(nmeaSentence);
            }
            nmeaSentence.getGnssLocation(this.mGnssLocation);
            if (nmeaSentence.isLocationSentence()) {
                if (nmeaSentence.getLatestHdop() != null) {
                    try {
                        this.mLatestHdop = Float.parseFloat(nmeaSentence.getLatestHdop());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                if (nmeaSentence.getLatestPdop() != null) {
                    try {
                        this.mLatestPdop = Float.parseFloat(nmeaSentence.getLatestPdop());
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                if (nmeaSentence.getLatestVdop() != null) {
                    try {
                        this.mLatestVdop = Float.parseFloat(nmeaSentence.getLatestVdop());
                    } catch (NumberFormatException e3) {
                        e3.printStackTrace();
                    }
                }
                if (nmeaSentence.getValidSatelliteNumber() != null) {
                    try {
                        this.mSatelliteNum = Integer.parseInt(nmeaSentence.getValidSatelliteNumber());
                    } catch (NumberFormatException e4) {
                        e4.printStackTrace();
                    }
                }
            } else if (nmeaSentence.isGSV() != -1) {
                this.mNmeaGxgsvHelper.onNmeaGxgsvReceived(j, str);
            }
            GnssLocation gnssLocation = this.mGnssLocation;
            if (gnssLocation != null && gnssLocation.getRmcUtcTime() == this.mGnssLocation.getGgaUtcTime() && this.mGnssLocation.isRmcEnable() && this.mGnssLocation.isGgaEnable() && this.mGnssLocation.isGsaEnable() && this.mGnssLocation.isGstEnable()) {
                this.mGnssLocation.setRmcEnable(false);
                this.mGnssLocation.setGgaEnable(false);
                this.mGnssLocation.setGsaEnable(false);
                this.mGnssLocation.setGstEnable(false);
                sendNmeaLocData(this.mGnssLocation, SystemClock.elapsedRealtime());
            }
        }
    }

    public void setDriveMode(int i) {
        if (this.mPosServiceWrapper != null) {
            if (SRDataUtil.isNgpDriveMode(i)) {
                this.mPosServiceWrapper.setViaductRecognizeSwitch(false);
                return;
            } else {
                this.mPosServiceWrapper.setViaductRecognizeSwitch(true);
                return;
            }
        }
        L.w(TAG, "mPosServiceWrapper still null,when SrDriveMode Called");
    }

    private boolean isMapValid() {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        return iMapDelegate != null && iMapDelegate.isValid();
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.IXPLocationListener
    public void onGpsStatusChanged(int i) {
        boolean z = this.mEnableBLDR;
    }

    public float getCarSpeed() {
        return this.mScuSpeed;
    }

    public float getRawCarSpeed() {
        return this.mEspRawSpeed;
    }

    private void sendEnableADR(boolean z) {
        IXpSensor iXpSensor = this.mSensor;
        if (iXpSensor == null) {
            return;
        }
        iXpSensor.enableADR(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEnableUbxReset(boolean z) {
        IXpSensor iXpSensor = this.mSensor;
        if (iXpSensor == null) {
            return;
        }
        iXpSensor.enableUbxReset(z);
        CarServiceManager.getInstance().setGpsReset(2);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper.IPosUpdateOneShotCallback
    public void locationOneShotUpdated(XPCoordinate2DDouble xPCoordinate2DDouble) {
        checkDataCityAdCode();
    }

    private void checkIfDispatchCityAdCodeChange() {
        if (this.mPreAdCode != this.mCityAdCode) {
            AreaExtraInfo areaExtraInfo = MapDataManager.getInstance().getAreaExtraInfo(this.mCityAdCode);
            String str = areaExtraInfo != null ? areaExtraInfo.cityName : null;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mPreAdCode = this.mCityAdCode;
            Iterator<IAdCodeChangedListener> it = this.mIAdCodeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onAdCodeChanged(this.mCityAdCode, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDataCityAdCode() {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            return;
        }
        this.mCityAdCode = MapDataManager.getInstance().getAdCodeByLonLat(currentLocation);
        checkIfDispatchCityAdCodeChange();
        int currentCityAdCode = MapDataManager.getInstance().getCurrentCityAdCode();
        int i = this.mCityAdCode;
        if ((-1 == i || i == currentCityAdCode) && !TextUtils.isEmpty(this.mCityName)) {
            return;
        }
        AreaExtraInfo areaExtraInfo = MapDataManager.getInstance().getAreaExtraInfo(this.mCityAdCode);
        if (areaExtraInfo != null) {
            this.mCityName = areaExtraInfo.cityName;
        } else {
            L.Tag tag = TAG;
            L.w(tag, "GPS location is [ " + currentLocation.mLon + ", " + currentLocation.mLat + " ] , City AdCode changed from " + currentCityAdCode + " to " + this.mCityAdCode + ", the city name is " + ((Object) null));
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "GPS location is [ " + currentLocation.mLon + ", " + currentLocation.mLat + " ] , City AdCode changed from " + currentCityAdCode + " to " + this.mCityAdCode + ", the city name is " + this.mCityName);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_CURRENT_CITY_AD_CODE, this.mCityAdCode);
        if (this.mCityAdCode != currentCityAdCode) {
            MapDataManager.getInstance().onCarLocationChange();
        }
        if (MapDataManager.getInstance().getMapDataOperator() != null) {
            MapDataManager.getInstance().getMapDataOperator().onAdCodeChanged(this.mCityAdCode);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_CURRENT_CITY_AD_CODE, this.mCityAdCode);
    }

    public void addAdCodeChangedListener(IAdCodeChangedListener iAdCodeChangedListener) {
        if (this.mIAdCodeChangedListeners.contains(iAdCodeChangedListener)) {
            return;
        }
        this.mIAdCodeChangedListeners.add(iAdCodeChangedListener);
    }

    public void removeAdCodeChangedListener(IAdCodeChangedListener iAdCodeChangedListener) {
        if (this.mIAdCodeChangedListeners.contains(iAdCodeChangedListener)) {
            this.mIAdCodeChangedListeners.remove(iAdCodeChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onGnssStatusChanged(NmeaGxgsvHelper.Gxgsv gxgsv) {
        if (!this.mEnableBLDR || gxgsv == null) {
            return;
        }
        sendGsvData(gxgsv);
    }

    private boolean printGsvLog() {
        if (this.mGsvLogOutputCount > 60) {
            this.mGsvLogOutputCount = 0;
            return true;
        }
        this.mGsvLogOutputCount++;
        return false;
    }

    private void sendGsvData(NmeaGxgsvHelper.Gxgsv gxgsv) {
        this.mPosServiceWrapper.setGSV(gxgsv, printGsvLog());
    }

    public void addLocChangeTestListener(ILocChangeTestListener iLocChangeTestListener) {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            locDebugHelper.addLocChangeTestListener(iLocChangeTestListener);
        }
    }

    public void removeLocChangeTestListener(ILocChangeTestListener iLocChangeTestListener) {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            locDebugHelper.removeLocChangeTestListener(iLocChangeTestListener);
        }
    }

    public boolean isLocDebugSwitch() {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            return locDebugHelper.isLocDebugSwitch();
        }
        return false;
    }

    public void setLocDebugSwitch(boolean z) {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            locDebugHelper.setLocDebugSwitch(z);
            ILocDebugSwitchListener iLocDebugSwitchListener = this.mILocDebugSwitchListener;
            if (iLocDebugSwitchListener != null) {
                iLocDebugSwitchListener.locDebugSwitch(this.mLocDebugHelper.isLocDebugSwitch());
            }
        }
    }

    public int getLocDebugMode() {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            return locDebugHelper.getLocDebugMode();
        }
        return 1;
    }

    public void setLocDebugMode(int i) {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            locDebugHelper.setLocDebugMode(i);
        }
    }

    public void resetLocDebugTtff() {
        LocDebugHelper locDebugHelper = this.mLocDebugHelper;
        if (locDebugHelper != null) {
            locDebugHelper.resetLocDebugTtff();
        }
    }

    public void setLocDebugSwitchListener(ILocDebugSwitchListener iLocDebugSwitchListener) {
        this.mILocDebugSwitchListener = iLocDebugSwitchListener;
    }

    public String getCityName() {
        return TextUtils.isEmpty(this.mCityName) ? "" : this.mCityName;
    }

    public boolean isLocationRecordMode() {
        return this.mPosServiceWrapper.isLocationRecordMode();
    }

    public void setLocationRecordMode(boolean z) {
        this.mPosServiceWrapper.setLocationRecordMode(z);
    }

    public boolean isLocationSimluateMode() {
        DRLogService dRLogService = this.mSimulator;
        if (dRLogService == null) {
            return false;
        }
        return dRLogService.isRecorderRunning();
    }

    public void setLocationSimluateMode(boolean z) {
        if (this.mSimulator == null && z) {
            L.i(TAG, "first time new SimulatedLogLocationService");
            this.mSimulator = new DRLogService(RootUtil.getLogPath(), this.mPosServiceWrapper);
            this.mSimulator.startDebugLocationSimulate();
            this.mPosServiceWrapper.setFakeLocation(true);
        } else if (z) {
            L.i(TAG, "restart SimulatedLogLocationService");
            this.mSimulator.startDebugLocationSimulate();
            this.mPosServiceWrapper.setFakeLocation(true);
        } else {
            L.i(TAG, "stop SimulatedLogLocationService");
            this.mSimulator.stopLocationSimulate();
            this.mPosServiceWrapper.setFakeLocation(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTboxDebugUbloxLog() {
        if (this.mIsInTboxUbloxDebugLogOutput) {
            return;
        }
        if (this.mLastStartTBOXLogTime == 0 || SystemClock.elapsedRealtime() - this.mLastStartTBOXLogTime >= TBOX_LOG_OPEN_MIN_GAP) {
            this.mIsInTboxUbloxDebugLogOutput = true;
            CarServiceManager.getInstance().swtichTBOXGpsLog(true);
            this.mLastStartTBOXLogTime = SystemClock.elapsedRealtime();
            L.Tag tag = TAG;
            L.i(tag, "start tbox log result:" + CarServiceManager.getInstance().isTBOXGpsLogOperSucceed());
            AfterSalesUtil.getInstance().recordDiagnosisError(9003, generateGnssOutageInfo(DataSetHelper.GlobalSet.KEY_GNSS_OUTAGE_WARNING));
            return;
        }
        L.i(TAG, "skip open tbox log due to MIN_GAP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTboxDebugUbloxLog() {
        if (this.mIsInTboxUbloxDebugLogOutput) {
            this.mIsInTboxUbloxDebugLogOutput = false;
            CarServiceManager.getInstance().swtichTBOXGpsLog(false);
            L.Tag tag = TAG;
            L.i(tag, "stop tbox log result:" + CarServiceManager.getInstance().isTBOXGpsLogOperSucceed());
        }
    }

    public void setAppBackground(boolean z) {
        this.mIsBackground = z;
    }

    public boolean isImuSensor() {
        if (this.mSensor != null) {
            return IXpSensor.XPSensorType.SENSOR_TYPE_IMU == this.mSensor.getSensorType();
        }
        L.w(TAG, "Sensor is not initialized");
        return false;
    }

    public void switchSensor(boolean z) {
        IXpSensor iXpSensor = this.mSensor;
        if (iXpSensor != null) {
            if (z && iXpSensor.getSensorType() != IXpSensor.XPSensorType.SENSOR_TYPE_IMU) {
                this.mSensor.close();
                this.mSensor = new ImuSensor();
                this.mSensor.setClientListener(this.mUDPClientListener);
                this.mSensor.open();
                return;
            } else if (z || IXpSensor.XPSensorType.SENSOR_TYPE_IMU != this.mSensor.getSensorType()) {
                return;
            } else {
                this.mSensor.close();
                this.mSensor = new UbxSensor();
                this.mSensor.setClientListener(this.mUDPClientListener);
                this.mSensor.open();
                return;
            }
        }
        L.w(TAG, "sensor is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateGnssOutageInfo(String str) {
        int i = DataSetHelper.GlobalSet.getInt(str, 0) + 1;
        DataSetHelper.GlobalSet.set(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append("count:");
        sb.append(i);
        sb.append(";dur:");
        sb.append((SystemClock.uptimeMillis() - this.mLastRealGnssTime) / 60000);
        sb.append("min;");
        LocGpgsv lastGSVdata = this.mPosServiceWrapper.getLastGSVdata();
        if (lastGSVdata != null) {
            sb.append("gsv:");
            for (int i2 = 0; i2 < lastGSVdata.num; i2++) {
                sb.append(lastGSVdata.snr[i2]);
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drStatistic() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long dRIMUTimestamp = StatisticDataUtil.getDRIMUTimestamp();
        long currentTimeMillis = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - StatisticDataUtil.getDRGnssTimestamp());
        int i = dRIMUTimestamp > currentTimeMillis ? (int) (dRIMUTimestamp - currentTimeMillis) : ((int) (currentTimeMillis - dRIMUTimestamp)) * (-1);
        long dRImuSensorInputCount = StatisticDataUtil.getDRImuSensorInputCount();
        long dRImuSensorInputTotalDelayTime = StatisticDataUtil.getDRImuSensorInputTotalDelayTime();
        if (dRImuSensorInputCount != 0) {
            long j6 = dRImuSensorInputTotalDelayTime / dRImuSensorInputCount;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - StatisticDataUtil.getDRLastImuSensorInputTime();
        if (CarFeatureManager.INSTANCE.isEspAndScuAutoPilotSpeedFusionEnable()) {
            long dRScuSpeedInputCount = StatisticDataUtil.getDRScuSpeedInputCount();
            long dRScuSpeedInputTotalDelayTime = StatisticDataUtil.getDRScuSpeedInputTotalDelayTime();
            if (dRScuSpeedInputCount != 0) {
                long j7 = dRScuSpeedInputTotalDelayTime / dRScuSpeedInputCount;
            }
            j = System.currentTimeMillis() - StatisticDataUtil.getDRLastScuSpeedInputTime();
        } else {
            j = 0;
        }
        long dREspSpeedInputCount = StatisticDataUtil.getDREspSpeedInputCount();
        long dREspSpeedInputTotalDelayTime = StatisticDataUtil.getDREspSpeedInputTotalDelayTime();
        if (dREspSpeedInputCount != 0) {
            long j8 = dREspSpeedInputTotalDelayTime / dREspSpeedInputCount;
        }
        long currentTimeMillis3 = System.currentTimeMillis() - StatisticDataUtil.getDRLastEspSpeedInputTime();
        long dRGnssInputCount = StatisticDataUtil.getDRGnssInputCount();
        long dRLastGnssInputTotalDelayTime = StatisticDataUtil.getDRLastGnssInputTotalDelayTime();
        if (dRGnssInputCount != 0) {
            long j9 = dRLastGnssInputTotalDelayTime / dRGnssInputCount;
        }
        long currentTimeMillis4 = System.currentTimeMillis() - StatisticDataUtil.getDRLastGnssInputTime();
        if (this.mNeedStartSensorStatistic) {
            j2 = currentTimeMillis2;
            j3 = currentTimeMillis4;
            j4 = j;
            j5 = currentTimeMillis3;
        } else {
            j3 = currentTimeMillis4;
            if (this.mSensorStatisticCount > 120) {
                this.mSensorStatisticCount = 0;
                j4 = j;
                long currentTimeMillis5 = System.currentTimeMillis() - this.mStartSensorStatisticTimeTick;
                float f = (float) (dRGnssInputCount - this.mStartGnssStatisticCount);
                j5 = currentTimeMillis3;
                float f2 = (float) (dRImuSensorInputCount - this.mStartSensorStatisticCount);
                float f3 = (float) (currentTimeMillis5 / 1000);
                j2 = currentTimeMillis2;
                float f4 = (float) ((currentTimeMillis5 / 100) * 3);
                L.i(TAG, "drStatistic: timeGap" + currentTimeMillis5 + "," + f + "," + f2 + " gnss loss rate:" + (((f3 - f) / f3) * 1000.0f) + ", imu loss rate:" + (((f4 - f2) / f4) * 1000.0f));
                this.mStartSensorStatisticTimeTick = System.currentTimeMillis();
                this.mStartGnssStatisticCount = dRGnssInputCount;
                this.mStartSensorStatisticCount = dRImuSensorInputCount;
            } else {
                j2 = currentTimeMillis2;
                j4 = j;
                j5 = currentTimeMillis3;
            }
            this.mSensorStatisticCount++;
        }
        if (RootUtil.isUserVersion()) {
            return;
        }
        try {
            DRDebugEvent dRDebugEvent = new DRDebugEvent(3);
            StringBuilder sb = new StringBuilder();
            sb.append("GnssImuDelta:");
            sb.append(i);
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append("LastImuGap:");
            sb.append(j2);
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append("LastESpeedGap:");
            sb.append(j5);
            sb.append(FDManager.LINE_SEPERATOR);
            if (CarFeatureManager.INSTANCE.isEspAndScuAutoPilotSpeedFusionEnable()) {
                sb.append("LastSCUSpeedGap:");
                sb.append(j4);
                sb.append(FDManager.LINE_SEPERATOR);
            }
            sb.append("LastGnssGap:");
            sb.append(j3);
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append("车速:");
            sb.append(this.mEspRawSpeed);
            sb.append("档位:");
            sb.append(CarServiceManager.getInstance().getGearLevel());
            dRDebugEvent.mADRMessage = sb.toString();
            EventBus.getDefault().post(dRDebugEvent);
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            L.e(TAG, "drStatistic error" + e.getMessage());
        }
    }

    public void reportYaw(double d, double d2) {
        Coord3DDouble encryptLonLat = this.mPosServiceWrapper.encryptLonLat(new Coord3DDouble(this.mGnssLocation.getLongitude(), this.mGnssLocation.getLatitude(), 0.0d));
        this.mLocationDataUploader.forceOutputGnssLog();
        if (encryptLonLat == null) {
            return;
        }
        Coord2DDouble coord2DDouble = new Coord2DDouble(encryptLonLat.lon, encryptLonLat.lat);
        Coord2DDouble coord2DDouble2 = new Coord2DDouble(d2, d);
        if (SystemClock.uptimeMillis() - this.mLastRealGnssTime < 60000) {
            int calculateDistance = SpatialUtils.calculateDistance(coord2DDouble, coord2DDouble2);
            L.Tag tag = TAG;
            L.i(tag, "gnss dr dis gap:" + calculateDistance);
            if (calculateDistance > 100) {
                this.mNeedStartSensorStatistic = true;
            }
        }
    }

    public XPPosInfo getPosInfo() {
        return this.mPosServiceWrapper.getPosInfo();
    }
}
