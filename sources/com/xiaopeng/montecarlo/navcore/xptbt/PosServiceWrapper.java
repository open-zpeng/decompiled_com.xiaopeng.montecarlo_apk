package com.xiaopeng.montecarlo.navcore.xptbt;

import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.observer.IThreadObserver;
import com.autonavi.gbl.pos.PosService;
import com.autonavi.gbl.pos.model.LocAcce3d;
import com.autonavi.gbl.pos.model.LocAllFusionPos;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocDrPos;
import com.autonavi.gbl.pos.model.LocGnss;
import com.autonavi.gbl.pos.model.LocGpgsv;
import com.autonavi.gbl.pos.model.LocGyro;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocMatchInfo;
import com.autonavi.gbl.pos.model.LocModeType;
import com.autonavi.gbl.pos.model.LocMountAngle;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.pos.model.LocPulse;
import com.autonavi.gbl.pos.model.LocSensorOption;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.model.LocVision;
import com.autonavi.gbl.pos.model.LocVisualObj;
import com.autonavi.gbl.pos.model.PosWorkPath;
import com.autonavi.gbl.pos.observer.IPosLocInfoObserver;
import com.autonavi.gbl.pos.observer.IPosParallelRoadObserver;
import com.autonavi.gbl.pos.observer.IPosSensorParaObserver;
import com.autonavi.gbl.pos.observer.IPosSignInfoObserver;
import com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocMatchInfo;
import com.xiaopeng.montecarlo.navcore.bean.location.XPPosInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocAcce3d;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocGpgsv;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocGyro;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocPulse;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocVisualObj;
import com.xiaopeng.montecarlo.navcore.event.DRDebugEvent;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.location.DRLogService;
import com.xiaopeng.montecarlo.navcore.location.GnssLocation;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.location.NmeaGxgsvHelper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.drmountangle.MountAngleManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class PosServiceWrapper implements IPosLocInfoObserver, IPosParallelRoadObserver, IPosSwitchParallelRoadObserver, IPosSensorParaObserver, IPosSignInfoObserver, IThreadObserver {
    private static final long AMAP_GNSS_ALIVE_TIMEOUT = 10000;
    private static final long AMAP_POS_ENGINE_ALIVE_TIMEOUT = 120000;
    public static final double DEFAULT_ALT = 15.0d;
    public static final float DEFAULT_DIR = 0.0f;
    public static final double DEFAULT_LAT_GCJ02 = 23.1595867537d;
    public static final double DEFAULT_LON_GCJ02 = 113.3850753307d;
    public static final double DEFAULT_SCALE = 1000000.0d;
    private static final L.Tag TAG = new L.Tag("PosServiceWrapper");
    private static final int XP_FORMWAY_RD_NULL = 0;
    private static final int XP_NAVI_LINK_TYPE_BRIDGE = 4;
    private static final int XP_NAVI_LINK_TYPE_COMMON = 1;
    private static final int XP_NAVI_LINK_TYPE_ELEVATED_RD = 5;
    private static final int XP_NAVI_LINK_TYPE_FERRY = 2;
    private static final int XP_NAVI_LINK_TYPE_NULL = 0;
    private static final int XP_NAVI_LINK_TYPE_TUNNEL = 3;
    private static final int XP_OWER_SHIP_3D_PARK_ROAD = 4;
    private static final int XP_OWER_SHIP_INTERNAL_ROAD = 2;
    private static final int XP_OWER_SHIP_NOT_DEFINED = 0;
    private static final int XP_OWER_SHIP_PUBLIC_ROAD = 1;
    private static final int XP_OWER_SHIP_UNDERGROUND_PARK_ROAD = 3;
    private static final int XP_ROAD_CLASS_CITY_SPEEDWAY = 2;
    private static final int XP_ROAD_CLASS_FREEWAY = 1;
    private static final int XP_ROAD_CLASS_OTHER = 0;
    private LocSignData mLocAcce3d;
    private LocSignData mLocGnss;
    private LocSignData mLocGpgsv;
    private LocSignData mLocGyro;
    @Nullable
    private LocParallelRoadInfo mLocParallelRoadInfo;
    private LocSignData mLocPulse;
    @Nullable
    private PosService mPosService;
    private List<LocSignData> mSignDataList;
    private final Object mCarLocationMutex = new Object();
    private final Object mCarLocationDirMutex = new Object();
    private final Object mCarDrLocationMutex = new Object();
    @NonNull
    private final List<IPosUpdateOneShotCallback> mCallbackList = new ArrayList();
    private final List<IPosUpdateOneShotCallback> mCallbackCarLocationList = new ArrayList();
    private final List<IPosRoadChangedCallback> mListeners = new CopyOnWriteArrayList();
    @Nullable
    private XPCarLocation mCurrentLocation = null;
    private XPCoordinate2DDouble mCurrentDrLocation = null;
    private LocInfo mCurrentLocInfo = null;
    private int mCarType = 0;
    private DRLogService mRecorder = null;
    private boolean mIsFakeLocaiton = false;
    private AmapEngineAliveChecker mAmapEngineAliveChecker = new AmapEngineAliveChecker();
    private final XPPosInfo mPosInfo = new XPPosInfo();
    private LocSignData mLocSignData = new LocSignData();
    private LocSignData mSensorLocData = new LocSignData();
    private LocSignData mGsvLocData = new LocSignData();
    private LocSignData mLocationLocData = new LocSignData();

    /* loaded from: classes2.dex */
    public interface IPosRoadChangedCallback {
        void onPosUpdate(XPLocInfo xPLocInfo);
    }

    /* loaded from: classes2.dex */
    public interface IPosUpdateOneShotCallback {
        @MainThread
        void locationOneShotUpdated(XPCoordinate2DDouble xPCoordinate2DDouble);
    }

    @Override // com.autonavi.gbl.common.observer.IThreadObserver
    public void threadCallback(long j, byte b) {
    }

    public XPPosInfo getPosInfo() {
        return this.mPosInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AmapEngineAliveChecker {
        private long mLastUpdateGnssTime;
        private long mLastUpdateSensorTime;

        AmapEngineAliveChecker() {
            reset();
        }

        public void reset() {
            this.mLastUpdateSensorTime = SystemClock.uptimeMillis();
            this.mLastUpdateGnssTime = this.mLastUpdateSensorTime;
        }

        public boolean isTimeout(long j) {
            if (j > this.mLastUpdateSensorTime) {
                long j2 = this.mLastUpdateGnssTime;
                if (((j <= j2 || j - j2 >= 10000) && j >= this.mLastUpdateGnssTime) || j - this.mLastUpdateSensorTime <= 120000) {
                    return false;
                }
                L.Tag tag = PosServiceWrapper.TAG;
                L.w(tag, "amap engine is stopped !!" + j + ">" + this.mLastUpdateSensorTime + "," + this.mLastUpdateGnssTime);
                return true;
            }
            return false;
        }

        public void setLastUpdateSensorTime(long j) {
            this.mLastUpdateSensorTime = j;
        }

        public long getLastUpdateSensorTime() {
            return this.mLastUpdateSensorTime;
        }

        public void setLastUpdateGnssTime(long j) {
            this.mLastUpdateGnssTime = j;
        }

        public long getLastUpdateGnssTime() {
            return this.mLastUpdateGnssTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public PosService getPosService() {
        return this.mPosService;
    }

    private void checkGNaviPosConfigDat() {
        for (String str : RootUtil.TO_CALIBRATION_FILE_LIST) {
            if (new File(RootUtil.SD_CARD_DIR_POS_520_CONTEXT, str).exists()) {
                L.i(TAG, "Have a GNaviPosConfig.dat file");
            } else {
                L.i(TAG, "No GNaviPosConfig.dat file!!!");
            }
        }
    }

    public boolean initPos(boolean z, int i, boolean z2) {
        boolean z3;
        if (this.mPosService == null) {
            this.mPosService = (PosService) ServiceMgr.getServiceMgrInstance().getBLService(12);
            if (this.mPosService == null) {
                L.e(TAG, "init PosService failed");
                return false;
            }
        }
        if (this.mPosService.isInit() == 1) {
            LocModeType locModeType = new LocModeType();
            locModeType.laneAlgType = 3;
            if (12 == i) {
                z = false;
            }
            if (z) {
                locModeType.locType = 1;
                locModeType.funcs = 10451387;
                locModeType.mountAngle = new LocMountAngle();
                locModeType.mountAngle.isValid = true;
                MountAngleManager.MountAngle mountAngle = MountAngleManager.XP_CAR_MOUNT_ANGLE_MAP.get(Integer.valueOf(i));
                if (z2) {
                    locModeType.mountAngle.pitch = mountAngle.getAutoPolitIMU().getX();
                    locModeType.mountAngle.roll = mountAngle.getAutoPolitIMU().getY();
                    locModeType.mountAngle.yaw = mountAngle.getAutoPolitIMU().getZ();
                    L.i(TAG, "mountAngle from autoPilot IMU:" + locModeType.mountAngle.pitch + "," + locModeType.mountAngle.roll + "," + locModeType.mountAngle.yaw);
                } else {
                    locModeType.mountAngle.pitch = mountAngle.getRawIMU().getX();
                    locModeType.mountAngle.roll = mountAngle.getRawIMU().getY();
                    locModeType.mountAngle.yaw = mountAngle.getRawIMU().getZ();
                    L.i(TAG, "mountAngle from raw Imu:" + locModeType.mountAngle.pitch + "," + locModeType.mountAngle.roll + "," + locModeType.mountAngle.yaw);
                }
                this.mCarType = i;
                locModeType.sensorOption = new LocSensorOption();
                locModeType.sensorOption.accFreq = 10;
                locModeType.sensorOption.gpsFreq = 1;
                locModeType.sensorOption.gyroFreq = 10;
                locModeType.sensorOption.hasAcc = 3;
                locModeType.sensorOption.hasMag = 0;
                locModeType.sensorOption.hasGyro = 3;
                locModeType.sensorOption.hasPressure = 0;
                locModeType.sensorOption.hasTemp = 1;
                locModeType.sensorOption.hasW4m = 0;
                locModeType.sensorOption.hasGsv = 1;
                locModeType.sensorOption.pulseFreq = 10;
                locModeType.sensorOption.w4mFreq = 0;
                locModeType.platformType = 1;
                locModeType.signalTypes = 127;
            } else {
                locModeType.locType = 0;
                locModeType.funcs = 8848576;
            }
            PosWorkPath posWorkPath = new PosWorkPath();
            posWorkPath.locPath = RootUtil.getLocLogPath();
            posWorkPath.contextPath = RootUtil.SD_CARD_DIR_POS_520_CONTEXT;
            checkGNaviPosConfigDat();
            Coord2DDouble currentLonLat = LocationServiceManager.getInstance().getCurrentLonLat();
            this.mPosService.setDefaultPos(new Coord3DDouble(currentLonLat.lon, currentLonLat.lat, 15.0d));
            long init = this.mPosService.init(posWorkPath, locModeType, this);
            if (CarServiceManager.getInstance().hasXpuForNgp()) {
                this.mPosService.setLaneSwitch(true);
            }
            if (0 == init) {
                this.mPosService.addLocInfoObserver(this, 0);
                this.mPosService.addSignInfoObserver(this);
                this.mPosService.addParallelRoadObserver(this);
                this.mPosService.addSwitchParallelRoadObserver(this);
                this.mPosService.addSensorParaObserver(this);
                if (RootUtil.canBllogAndLocBeOutput()) {
                    setSignalRecordSwitch(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_LOC_LOG));
                }
                if (!RootUtil.isUserVersion() && (z3 = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_RECORD_SET_LOCATION, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_RECORD_SET_LOCATION))) {
                    setLocationRecordMode(z3);
                }
            } else {
                this.mPosService = null;
                return false;
            }
        }
        return true;
    }

    public void setAllPos(@NonNull XPPosInfo xPPosInfo) {
        if (this.mPosService == null) {
            L.w(TAG, "setAllFusionPos mPosService is null");
            return;
        }
        List<LocSignData> list = this.mSignDataList;
        if (list == null) {
            this.mSignDataList = new ArrayList();
        } else {
            list.clear();
        }
        if (this.mLocGnss == null) {
            this.mLocGnss = new LocSignData();
            this.mLocGnss.dataType = 16;
        }
        LocGnss gnss = xPPosInfo.getGnss();
        if (gnss != null && (this.mLocGnss.gnss == null || (gnss.tickTime != null && gnss.tickTime.compareTo(this.mLocGnss.gnss.tickTime) > 0))) {
            LocSignData locSignData = this.mLocGnss;
            locSignData.gnss = gnss;
            this.mSignDataList.add(locSignData);
        }
        if (this.mLocGyro == null) {
            this.mLocGyro = new LocSignData();
            this.mLocGyro.dataType = 4;
        }
        LocGyro gyro = xPPosInfo.getGyro();
        if (gyro != null && (this.mLocGyro.gyro == null || (gyro.tickTime != null && gyro.tickTime.compareTo(this.mLocGyro.gyro.tickTime) > 0))) {
            LocSignData locSignData2 = this.mLocGyro;
            locSignData2.gyro = gyro;
            this.mSignDataList.add(locSignData2);
        }
        if (this.mLocPulse == null) {
            this.mLocPulse = new LocSignData();
            this.mLocPulse.dataType = 8;
        }
        LocPulse pulse = xPPosInfo.getPulse();
        if (pulse != null && (this.mLocPulse.pulse == null || (pulse.tickTime != null && pulse.tickTime.compareTo(this.mLocPulse.pulse.tickTime) > 0))) {
            LocSignData locSignData3 = this.mLocPulse;
            locSignData3.pulse = pulse;
            this.mSignDataList.add(locSignData3);
        }
        if (this.mLocGpgsv == null) {
            this.mLocGpgsv = new LocSignData();
            this.mLocGpgsv.dataType = 64;
        }
        LocGpgsv gpgsv = xPPosInfo.getGpgsv();
        if (gpgsv != null && (this.mLocGpgsv.gpgsv == null || (gpgsv.tickTime != null && gpgsv.tickTime.compareTo(this.mLocGpgsv.gpgsv.tickTime) > 0))) {
            LocSignData locSignData4 = this.mLocGpgsv;
            locSignData4.gpgsv = gpgsv;
            this.mSignDataList.add(locSignData4);
        }
        if (this.mLocAcce3d == null) {
            this.mLocAcce3d = new LocSignData();
            this.mLocAcce3d.dataType = 2;
        }
        LocAcce3d acce3d = xPPosInfo.getAcce3d();
        if (acce3d != null && (this.mLocAcce3d.acce3D == null || (acce3d.tickTime != null && acce3d.tickTime.compareTo(this.mLocAcce3d.acce3D.tickTime) > 0))) {
            LocSignData locSignData5 = this.mLocAcce3d;
            locSignData5.acce3D = acce3d;
            this.mSignDataList.add(locSignData5);
        }
        List<LocSignData> list2 = this.mSignDataList;
        if (list2 != null && list2.size() > 0) {
            this.mSignDataList.sort(new Comparator() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$PosServiceWrapper$cLG1DpQvtBHQrtfNJQAnETEyH9s
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return PosServiceWrapper.this.lambda$setAllPos$0$PosServiceWrapper((LocSignData) obj, (LocSignData) obj2);
                }
            });
            for (LocSignData locSignData6 : this.mSignDataList) {
                this.mPosService.setSignInfo(locSignData6);
            }
            return;
        }
        this.mLocGnss = null;
        this.mLocGyro = null;
        this.mLocPulse = null;
        this.mLocGpgsv = null;
        this.mLocAcce3d = null;
        this.mSignDataList = null;
    }

    public /* synthetic */ int lambda$setAllPos$0$PosServiceWrapper(LocSignData locSignData, LocSignData locSignData2) {
        return getTime(locSignData).compareTo(getTime(locSignData2));
    }

    private BigInteger getTime(LocSignData locSignData) {
        int i = locSignData.dataType;
        if (i != 2) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 64) {
                            if (i != 512) {
                                if (i != 1073741825) {
                                    if (i == 1073741827) {
                                        return locSignData.allFusionPos.tickTime;
                                    }
                                    return BigInteger.ZERO;
                                }
                                return locSignData.locVision.localTickTime;
                            }
                            return locSignData.drPos.tickTime;
                        }
                        return locSignData.gpgsv.tickTime;
                    }
                    return locSignData.gnss.tickTime;
                }
                return locSignData.pulse.tickTime;
            }
            return locSignData.gyro.tickTime;
        }
        return locSignData.acce3D.tickTime;
    }

    public void setSignalRecordSwitch(boolean z) {
        if (checkPosServiceValid()) {
            this.mPosService.signalRecordSwitch(z, false, 1, NaviLogUtil.getBLLocLogType());
        }
    }

    public void unInit() {
        if (checkPosServiceValid()) {
            this.mPosService.removeLocInfoObserver(this);
            this.mPosService.removeSignInfoObserver(this);
            this.mPosService.removeParallelRoadObserver(this);
            this.mPosService.removeSwitchParallelRoadObserver(this);
            this.mPosService.removeSensorParaObserver(this);
            ServiceMgr.getServiceMgrInstance().removeBLService(12);
        }
    }

    public void setLocation(Location location, int i, float f, float f2, float f3, boolean z) {
        if (!checkPosServiceValid() || isFakeLocation() || location == null) {
            return;
        }
        if (this.mLocationLocData == null) {
            this.mLocationLocData = new LocSignData();
        }
        LocSignData locSignData = this.mLocationLocData;
        Date date = new Date(location.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (locSignData.gnss == null) {
            locSignData.gnss = new LocGnss();
        }
        locSignData.dataType = 16;
        locSignData.gnss.year = calendar.get(1);
        locSignData.gnss.month = calendar.get(2) + 1;
        locSignData.gnss.day = calendar.get(5);
        locSignData.gnss.hour = calendar.get(11);
        locSignData.gnss.minute = calendar.get(12);
        locSignData.gnss.second = calendar.get(13);
        locSignData.gnss.sourType = !location.getProvider().equals("gps");
        locSignData.gnss.mode = GnssLocation.LOC_VALID;
        locSignData.gnss.status = GnssLocation.LOC_VALID;
        locSignData.gnss.isEncrypted = z ? (short) 1 : (short) 0;
        locSignData.gnss.isNS = (byte) 78;
        locSignData.gnss.isEW = (byte) 69;
        locSignData.gnss.stPtS = new Coord2DDouble(location.getLongitude(), location.getLatitude());
        locSignData.gnss.stPt = locSignData.gnss.stPtS;
        locSignData.gnss.speed = location.getSpeed() * 3.6f;
        locSignData.gnss.course = location.getBearing();
        locSignData.gnss.alt = (float) location.getAltitude();
        locSignData.gnss.accuracy = location.getAccuracy();
        locSignData.gnss.tickTime = BigInteger.valueOf(SystemClock.elapsedRealtime());
        locSignData.gnss.num = i;
        locSignData.gnss.hdop = f;
        locSignData.gnss.vdop = f2;
        locSignData.gnss.pdop = f3;
        this.mPosService.setSignInfo(locSignData);
        this.mPosInfo.setGnss(locSignData.gnss);
        DRLogService dRLogService = this.mRecorder;
        if (dRLogService != null) {
            dRLogService.setLocation(locSignData);
        }
    }

    public void setLocation(GnssLocation gnssLocation, boolean z) {
        DRLogService dRLogService;
        if (checkPosServiceValid() && z == isFakeLocation()) {
            if (this.mLocationLocData == null) {
                this.mLocationLocData = new LocSignData();
            }
            LocSignData locSignData = this.mLocationLocData;
            if (locSignData.gnss != null) {
                locSignData.gnss = new LocGnss();
            }
            locSignData.dataType = 16;
            locSignData.gnss.year = gnssLocation.getYear();
            locSignData.gnss.month = gnssLocation.getMonth();
            locSignData.gnss.day = gnssLocation.getDay();
            locSignData.gnss.hour = gnssLocation.getHour();
            locSignData.gnss.minute = gnssLocation.getMinute();
            locSignData.gnss.second = gnssLocation.getSecond();
            locSignData.gnss.sourType = 0;
            locSignData.gnss.mode = GnssLocation.LOC_VALID;
            locSignData.gnss.status = gnssLocation.getStatus();
            locSignData.gnss.isEncrypted = (short) 0;
            locSignData.gnss.isNS = gnssLocation.getNorthSouth();
            locSignData.gnss.isEW = gnssLocation.getEastWest();
            locSignData.gnss.stPtS = new Coord2DDouble(gnssLocation.getLongitude(), gnssLocation.getLatitude());
            locSignData.gnss.stPt = locSignData.gnss.stPtS;
            locSignData.gnss.speed = gnssLocation.getSpeed();
            locSignData.gnss.course = gnssLocation.getCourse();
            locSignData.gnss.alt = gnssLocation.getAltitude();
            locSignData.gnss.accuracy = gnssLocation.getAccuracy();
            locSignData.gnss.tickTime = BigInteger.valueOf(SystemClock.elapsedRealtime());
            if (RootUtil.sIsDrTestMode) {
                StatisticDataUtil.setDRGnssTimestamp(locSignData.gnss.tickTime.longValue());
            }
            locSignData.gnss.num = gnssLocation.getNumSV();
            locSignData.gnss.hdop = gnssLocation.getHdop();
            locSignData.gnss.vdop = gnssLocation.getVdop();
            locSignData.gnss.pdop = gnssLocation.getPdop();
            this.mAmapEngineAliveChecker.setLastUpdateGnssTime(SystemClock.uptimeMillis());
            this.mPosService.setSignInfo(locSignData);
            this.mPosInfo.setGnss(locSignData.gnss);
            if (z || (dRLogService = this.mRecorder) == null) {
                return;
            }
            dRLogService.setLocation(locSignData);
        }
    }

    public void setA3D(float f, float f2, float f3, BigInteger bigInteger, int i, boolean z) {
        DRLogService dRLogService;
        if (checkPosServiceValid() && z == isFakeLocation()) {
            if (this.mSensorLocData == null) {
                this.mSensorLocData = new LocSignData();
            }
            LocSignData locSignData = this.mSensorLocData;
            locSignData.dataType = 2;
            if (locSignData.acce3D == null) {
                locSignData.acce3D = new LocAcce3d();
            }
            locSignData.acce3D.dataType = 2;
            locSignData.acce3D.axis = 4;
            locSignData.acce3D.acceX = f;
            locSignData.acce3D.acceY = f2;
            locSignData.acce3D.acceZ = f3;
            locSignData.acce3D.tickTime = bigInteger;
            locSignData.acce3D.interval = i;
            this.mPosService.setSignInfo(locSignData);
            this.mPosInfo.setAcce3d(locSignData.acce3D);
            if (z || (dRLogService = this.mRecorder) == null) {
                return;
            }
            dRLogService.setA3D(locSignData.acce3D);
        }
    }

    public void setGYR(float f, float f2, float f3, BigInteger bigInteger, float f4, int i, boolean z) {
        DRLogService dRLogService;
        if (checkPosServiceValid() && z == isFakeLocation()) {
            if (this.mSensorLocData == null) {
                this.mSensorLocData = new LocSignData();
            }
            LocSignData locSignData = this.mSensorLocData;
            locSignData.dataType = 4;
            if (locSignData.gyro == null) {
                locSignData.gyro = new LocGyro();
            }
            locSignData.gyro.dataType = 4;
            locSignData.gyro.axis = 4;
            locSignData.gyro.valueX = f;
            locSignData.gyro.valueY = f2;
            locSignData.gyro.valueZ = f3;
            locSignData.gyro.tickTime = bigInteger;
            locSignData.gyro.temperature = f4;
            locSignData.gyro.interval = i;
            this.mPosService.setSignInfo(locSignData);
            this.mPosInfo.setGyro(locSignData.gyro);
            if (z || (dRLogService = this.mRecorder) == null) {
                return;
            }
            dRLogService.setGYR(locSignData.gyro);
        }
    }

    public void setPulse(float f, BigInteger bigInteger, int i, boolean z) {
        DRLogService dRLogService;
        if (checkPosServiceValid() && z == isFakeLocation()) {
            if (this.mSensorLocData == null) {
                this.mSensorLocData = new LocSignData();
            }
            LocSignData locSignData = this.mSensorLocData;
            locSignData.dataType = 8;
            if (locSignData.gyro == null) {
                locSignData.gyro = new LocGyro();
            }
            locSignData.pulse.dataType = 8;
            locSignData.pulse.value = f;
            locSignData.pulse.tickTime = bigInteger;
            locSignData.pulse.interval = i;
            this.mPosService.setSignInfo(locSignData);
            this.mPosInfo.setPulse(this.mSensorLocData.pulse);
            if (z || (dRLogService = this.mRecorder) == null) {
                return;
            }
            dRLogService.setPulse(this.mSensorLocData);
        }
    }

    public void setSaveLocStorage() {
        if (checkPosServiceValid()) {
            this.mPosService.saveLocStorage();
        }
    }

    public void setFakeGSV(LocSignData locSignData) {
        if (checkPosServiceValid() && isFakeLocation()) {
            this.mPosService.setSignInfo(locSignData);
        }
    }

    public void setGSV(NmeaGxgsvHelper.Gxgsv gxgsv, boolean z) {
        if (!checkPosServiceValid() || isFakeLocation()) {
            return;
        }
        if (this.mGsvLocData == null) {
            this.mGsvLocData = new LocSignData();
        }
        LocSignData locSignData = this.mGsvLocData;
        locSignData.dataType = 64;
        if (locSignData.gpgsv == null) {
            locSignData.gpgsv = new LocGpgsv();
            locSignData.gpgsv.prn = new int[16];
            locSignData.gpgsv.elevation = new int[16];
            locSignData.gpgsv.azimuth = new int[16];
            locSignData.gpgsv.snr = new int[16];
        }
        locSignData.gpgsv.dataType = 64;
        locSignData.gpgsv.type = gxgsv.mType;
        for (int i = 0; i < gxgsv.mNum; i++) {
            locSignData.gpgsv.prn[i] = gxgsv.mSv[i];
            locSignData.gpgsv.elevation[i] = gxgsv.mElv[i];
            locSignData.gpgsv.azimuth[i] = gxgsv.mAz[i];
            locSignData.gpgsv.snr[i] = gxgsv.mCno[i];
        }
        locSignData.gpgsv.num = gxgsv.mNum;
        locSignData.gpgsv.tickTime = BigInteger.valueOf(gxgsv.mTickTime);
        if (z) {
            printGsvLog(locSignData);
        }
        this.mPosService.setSignInfo(locSignData);
        this.mPosInfo.setGpgsv(locSignData.gpgsv);
        DRLogService dRLogService = this.mRecorder;
        if (dRLogService != null) {
            dRLogService.setGSV(locSignData);
        }
    }

    public LocGpgsv getLastGSVdata() {
        return this.mGsvLocData.gpgsv;
    }

    private void printGsvLog(LocSignData locSignData) {
        StringBuilder sb = new StringBuilder();
        sb.append("Type:");
        sb.append(locSignData.gpgsv.type);
        sb.append(" svNum:");
        sb.append(locSignData.gpgsv.num);
        sb.append(" data:");
        for (int i = 0; i < locSignData.gpgsv.num; i++) {
            sb.append(locSignData.gpgsv.prn[i]);
            sb.append(",");
            sb.append(locSignData.gpgsv.elevation[i]);
            sb.append(",");
            sb.append(locSignData.gpgsv.azimuth[i]);
            sb.append(",");
            sb.append(locSignData.gpgsv.snr[i]);
            sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        }
        L.Tag tag = TAG;
        L.i(tag, "GPGSV data:\n" + sb.toString());
    }

    @Nullable
    public Coord3DDouble encryptLonLat(Coord3DDouble coord3DDouble) {
        if (checkPosServiceValid()) {
            PosService posService = this.mPosService;
            return PosService.encryptLonLat(coord3DDouble);
        }
        return null;
    }

    @Nullable
    public Coord3DDouble encryptLonLat(@NonNull Location location) {
        if (checkPosServiceValid()) {
            Coord3DDouble coord3DDouble = new Coord3DDouble();
            coord3DDouble.lat = location.getLatitude();
            coord3DDouble.lon = location.getLongitude();
            coord3DDouble.z = location.getAltitude();
            PosService posService = this.mPosService;
            return PosService.encryptLonLat(coord3DDouble);
        }
        return null;
    }

    @Nullable
    public XPCoordinate2DDouble getCurrentLocation(@Nullable IPosUpdateOneShotCallback iPosUpdateOneShotCallback) {
        XPCoordinate2DDouble xPCoordinate2DDouble;
        synchronized (this.mCarLocationMutex) {
            String str = null;
            if (this.mCurrentLocation != null) {
                xPCoordinate2DDouble = new XPCoordinate2DDouble(this.mCurrentLocation.mLongitude, this.mCurrentLocation.mLatitude);
            } else if (iPosUpdateOneShotCallback != null) {
                if (!this.mCallbackList.contains(iPosUpdateOneShotCallback)) {
                    this.mCallbackList.add(iPosUpdateOneShotCallback);
                }
                str = "get position service location with null and callback later!!!";
                xPCoordinate2DDouble = null;
            } else {
                str = "get position service location with last DataSetHelper location !!!";
                xPCoordinate2DDouble = new XPCoordinate2DDouble(DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L) / 1000000.0d, DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L) / 1000000.0d);
            }
            if (str != null) {
                L.i(TAG, str);
            }
        }
        return xPCoordinate2DDouble;
    }

    @NonNull
    public XPCoordinate2DDouble getCurrentLocation() {
        return getCurrentLocation(null);
    }

    public LocInfo getCurrentLocInfo() {
        return this.mCurrentLocInfo;
    }

    public void setMockCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        XPCarLocation xPCarLocation = this.mCurrentLocation;
        if (xPCarLocation == null) {
            return;
        }
        xPCarLocation.mLongitude = xPCoordinate2DDouble.mLon;
        this.mCurrentLocation.mLatitude = xPCoordinate2DDouble.mLat;
    }

    @Nullable
    public XPCarLocation getCurrentCarLocation(@Nullable IPosUpdateOneShotCallback iPosUpdateOneShotCallback) {
        XPCarLocation xPCarLocation;
        synchronized (this.mCarLocationDirMutex) {
            String str = null;
            if (this.mCurrentLocation != null) {
                xPCarLocation = new XPCarLocation(this.mCurrentLocation.mLongitude, this.mCurrentLocation.mLatitude, this.mCurrentLocation.mCarDir);
            } else if (iPosUpdateOneShotCallback != null) {
                if (!this.mCallbackCarLocationList.contains(iPosUpdateOneShotCallback)) {
                    this.mCallbackCarLocationList.add(iPosUpdateOneShotCallback);
                }
                str = "get position service location with null and callback later!!!";
                xPCarLocation = null;
            } else {
                str = "get position service location with last DataSetHelper location !!!";
                long j = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L);
                long j2 = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L);
                float f = 0.0f;
                try {
                    f = DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_DIR, 0.0f);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                xPCarLocation = new XPCarLocation(j / 1000000.0d, j2 / 1000000.0d, f);
            }
            if (str != null) {
                L.i(TAG, str);
            }
        }
        return xPCarLocation;
    }

    @NonNull
    public XPCarLocation getCurrentCarLocation() {
        return getCurrentCarLocation(null);
    }

    private void updateCurrentLocation(LocInfo locInfo) {
        synchronized (this.mCarLocationMutex) {
            double d = locInfo.matchInfo.get(0).stPos.lat;
            double d2 = locInfo.matchInfo.get(0).stPos.lon;
            float f = locInfo.matchInfo.get(0).course;
            if (this.mCurrentLocation == null) {
                this.mCurrentLocation = new XPCarLocation();
            }
            this.mCurrentLocation.mLatitude = d;
            this.mCurrentLocation.mLongitude = d2;
            this.mCurrentLocation.mCarDir = (int) f;
            final XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
            xPCoordinate2DDouble.mLat = d;
            xPCoordinate2DDouble.mLon = d2;
            final ArrayList arrayList = new ArrayList(this.mCallbackList);
            this.mCallbackList.clear();
            if (!CollectionUtils.isEmpty(arrayList)) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "update position service location : lat --- " + xPCoordinate2DDouble.mLat + " lon --- " + xPCoordinate2DDouble.mLon);
                }
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (IPosUpdateOneShotCallback iPosUpdateOneShotCallback : arrayList) {
                            iPosUpdateOneShotCallback.locationOneShotUpdated(xPCoordinate2DDouble);
                        }
                        arrayList.clear();
                    }
                });
            }
        }
    }

    private void sendLccSimpleInfo(LocInfo locInfo) {
        if (locInfo == null || CollectionUtils.isEmpty(locInfo.matchInfo)) {
            return;
        }
        LocMatchInfo locMatchInfo = locInfo.matchInfo.get(0);
        RouteResult.LccPathSimpleInfo lccPathSimpleInfo = new RouteResult.LccPathSimpleInfo();
        if (locMatchInfo != null) {
            lccPathSimpleInfo.setRoadClass(locMatchInfo.roadClass);
        }
        int roadClass = getRoadClass(lccPathSimpleInfo);
        int ownerShip = getOwnerShip(lccPathSimpleInfo);
        int detailRoadClass = getDetailRoadClass(lccPathSimpleInfo);
        int linkType = getLinkType(locMatchInfo);
        int formWay = getFormWay(locMatchInfo);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendLccSimpleInfo sendRoadClass = " + roadClass + ", sendOwnerShip = " + ownerShip + ", sendDetailRoadClass = " + detailRoadClass + ", linkType = " + linkType + ", formWay = " + formWay);
        }
        if (CarFeatureManager.INSTANCE.isRoadAttributesOn()) {
            CarServiceManager.getInstance().setRoadAttributes(ownerShip, roadClass);
        }
        CarServiceManager.getInstance().setDetailRoadClass(detailRoadClass);
        if (CarFeatureManager.INSTANCE.isNaviLoadLinkTypeOn()) {
            CarServiceManager.getInstance().sendNaviLoadLinkType(linkType);
        }
        if (CarFeatureManager.INSTANCE.isNaviRoadConnectAttribOn()) {
            CarServiceManager.getInstance().setNaviRoadConnectAttrib(formWay);
        }
    }

    private int getRoadClass(@NonNull RouteResult.LccPathSimpleInfo lccPathSimpleInfo) {
        int roadClass = lccPathSimpleInfo.getRoadClass();
        int i = roadClass == 0 ? 1 : roadClass == 6 ? 2 : 0;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getRoadClass for Lcc, roadClassInMap = " + roadClass);
        }
        return i;
    }

    private int getLinkType(LocMatchInfo locMatchInfo) {
        if (locMatchInfo == null || locMatchInfo.linkType <= -1) {
            return 0;
        }
        return locMatchInfo.linkType + 1;
    }

    private int getFormWay(LocMatchInfo locMatchInfo) {
        if (locMatchInfo != null) {
            return locMatchInfo.formway;
        }
        return 0;
    }

    private int getDetailRoadClass(@NonNull RouteResult.LccPathSimpleInfo lccPathSimpleInfo) {
        int roadClass = lccPathSimpleInfo.getRoadClass();
        int i = roadClass + 1;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getDetailRoadClass for Lcc, detailRoadClassInMap = " + roadClass);
        }
        return i;
    }

    private int getOwnerShip(@NonNull RouteResult.LccPathSimpleInfo lccPathSimpleInfo) {
        int ownerShip = lccPathSimpleInfo.getOwnerShip();
        int i = 4;
        if (ownerShip == 0) {
            i = 1;
        } else if (ownerShip == 1) {
            i = 2;
        } else if (ownerShip == 3) {
            i = 3;
        } else if (ownerShip != 4) {
            i = 0;
        }
        if (L.ENABLE) {
            L.d(TAG, "getOwnerShip for Parking ownerShipInMap = " + ownerShip);
        }
        return i;
    }

    @Override // com.autonavi.gbl.pos.observer.IPosLocInfoObserver
    public void onLocInfoUpdate(@NonNull LocInfo locInfo) {
        if (L.ENABLE) {
            L.d(TAG, ">>> onLocInfoUpdate ");
        }
        try {
            if (!checkLocationValid(locInfo)) {
                L.i(TAG, "invalid location !!!");
                return;
            }
            if (this.mCurrentLocInfo == null || this.mCurrentLocInfo.roadId != locInfo.roadId) {
                sendLccSimpleInfo(locInfo);
                XPLocInfo xPLocInfo = new XPLocInfo(locInfo);
                XPLocMatchInfo xPLocMatchInfo = xPLocInfo.getMatchInfoList().get(0);
                if (xPLocMatchInfo != null) {
                    int roadClass = xPLocMatchInfo.getRoadClass();
                    int linkType = xPLocMatchInfo.getLinkType();
                    int formway = xPLocMatchInfo.getFormway();
                    L.Tag tag = TAG;
                    L.i(tag, "pos updated RC:" + roadClass + " LT:" + linkType + " FW:" + formway);
                }
                if (xPLocInfo.getMatchInfoList().size() > 1) {
                    for (int i = 1; i < xPLocInfo.getMatchInfoList().size(); i++) {
                        XPLocMatchInfo xPLocMatchInfo2 = xPLocInfo.getMatchInfoList().get(i);
                        if (xPLocMatchInfo2 != null) {
                            int roadClass2 = xPLocMatchInfo2.getRoadClass();
                            int linkType2 = xPLocMatchInfo2.getLinkType();
                            int formway2 = xPLocMatchInfo2.getFormway();
                            L.Tag tag2 = TAG;
                            L.i(tag2, "MatchInfo:" + i + " RC:" + roadClass2 + " LT:" + linkType2 + " FW:" + formway2);
                        }
                    }
                }
                for (IPosRoadChangedCallback iPosRoadChangedCallback : this.mListeners) {
                    if (iPosRoadChangedCallback != null) {
                        iPosRoadChangedCallback.onPosUpdate(xPLocInfo);
                    }
                }
            }
            this.mCurrentLocInfo = locInfo;
            if (CarFeatureManager.INSTANCE.isXUIServiceInfoUploadEnable()) {
                TBTManager.getInstance().updateLocInfo(new XPLocInfo(this.mCurrentLocInfo));
            }
            updateCurrentLocation(locInfo);
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag3 = TAG;
            L.e(tag3, "onLocInfoUpdate error:" + e.getMessage());
        }
    }

    private boolean checkLocationValid(@Nullable LocInfo locInfo) {
        if (locInfo == null) {
            L.i(TAG, "locinfo is null");
            return false;
        } else if (CollectionUtils.isEmpty(locInfo.matchInfo)) {
            L.i(TAG, "matchInfoList is empty");
            return false;
        } else {
            LocMatchInfo locMatchInfo = locInfo.matchInfo.get(0);
            if (locMatchInfo.stPos == null) {
                L.i(TAG, "matchInfoList.stPos is empty");
                return false;
            } else if (NavCoreUtil.isInChina(locMatchInfo.stPos.lon, locMatchInfo.stPos.lat)) {
                return true;
            } else {
                L.i(TAG, "matchInfoList.stPos is 0,0");
                return false;
            }
        }
    }

    @Override // com.autonavi.gbl.pos.observer.IPosParallelRoadObserver
    public void onParallelRoadUpdate(@Nullable LocParallelRoadInfo locParallelRoadInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(">>> onParallelRoadUpdate locParallelRoadInfo status = ");
            sb.append(locParallelRoadInfo != null ? locParallelRoadInfo.status : 0);
            L.d(tag, sb.toString());
        }
        try {
            this.mLocParallelRoadInfo = locParallelRoadInfo;
            ParallelRoadEvent parallelRoadEvent = new ParallelRoadEvent(0);
            parallelRoadEvent.mLocParallelRoadInfo = locParallelRoadInfo;
            EventBus.getDefault().post(parallelRoadEvent);
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag2 = TAG;
            L.e(tag2, "onParallelRoadUpdate error:" + e.getMessage());
        }
    }

    @Override // com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver
    public void onSwitchParallelRoadFinished() {
        if (L.ENABLE) {
            L.d(TAG, ">>> onSwitchParallelRoadFinished ");
        }
        try {
            EventBus.getDefault().post(new ParallelRoadEvent(1));
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag = TAG;
            L.e(tag, "onSwitchParallelRoadFinished error" + e.getMessage());
        }
    }

    @Override // com.autonavi.gbl.pos.observer.IPosSensorParaObserver
    public void onSensorParaUpdate(String str) {
        this.mAmapEngineAliveChecker.setLastUpdateSensorTime(SystemClock.uptimeMillis());
        try {
            DRDebugEvent dRDebugEvent = new DRDebugEvent(0);
            dRDebugEvent.mDRMessage = str;
            EventBus.getDefault().post(dRDebugEvent);
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag = TAG;
            L.e(tag, "onSensorParaUpdate error" + e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String replaceAll = str.replaceAll("\n|\r|\t", "");
        L.Tag tag2 = TAG;
        L.i(tag2, ">>> onSensorParaUpdate " + replaceAll);
    }

    public void switchParallelRoad(int i, long j) {
        if (checkPosServiceValid()) {
            this.mPosService.switchParallelRoad(i, new BigInteger(String.valueOf(j)));
        }
    }

    @Nullable
    public LocParallelRoadInfo getLocParallelRoadInfo() {
        return this.mLocParallelRoadInfo;
    }

    public void updateLocParallelRoadInfo(LocParallelRoadInfo locParallelRoadInfo) {
        this.mLocParallelRoadInfo = locParallelRoadInfo;
    }

    private boolean isFakeLocation() {
        return this.mIsFakeLocaiton;
    }

    public void setFakeLocation(LocSignData locSignData) {
        if (checkPosServiceValid() && isFakeLocation()) {
            this.mPosService.setSignInfo(locSignData);
            this.mPosInfo.setGnss(locSignData.gnss);
            DRLogService dRLogService = this.mRecorder;
            if (dRLogService != null) {
                dRLogService.setLocation(locSignData);
            }
        }
    }

    public void setFakeLocation(boolean z) {
        this.mIsFakeLocaiton = z;
    }

    private boolean checkPosServiceValid() {
        if (this.mPosService != null) {
            return true;
        }
        throw new IllegalArgumentException("mPosService is null, init it first!");
    }

    private boolean checkDrLocationValid(@Nullable LocSignData locSignData) {
        if (locSignData == null) {
            L.i(TAG, "locSignData is null");
            return false;
        } else if (locSignData.drPos == null) {
            L.i(TAG, "locSignData.drPos is empty");
            return false;
        } else if (locSignData.drPos.stPos == null) {
            L.i(TAG, "locSignData.drPos.stPos is empty");
            return false;
        } else if (NavCoreUtil.isInChina(locSignData.drPos.stPos.lon, locSignData.drPos.stPos.lat)) {
            return true;
        } else {
            L.i(TAG, "locSignData.drPos.stPos is 0,0");
            return false;
        }
    }

    @Override // com.autonavi.gbl.pos.observer.IPosSignInfoObserver
    public void onSignInfoUpdate(LocSignData locSignData) {
        try {
            if (512 == locSignData.dataType) {
                if (!checkDrLocationValid(locSignData)) {
                    L.i(TAG, "invalid DrLocation !!!");
                    return;
                }
                synchronized (this.mCarDrLocationMutex) {
                    if (this.mCurrentDrLocation == null) {
                        this.mCurrentDrLocation = new XPCoordinate2DDouble();
                    }
                    this.mCurrentDrLocation.mLon = locSignData.drPos.stPos.lon;
                    this.mCurrentDrLocation.mLat = locSignData.drPos.stPos.lat;
                }
            }
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag = TAG;
            L.e(tag, "onSensorParaUpdate error" + e.getMessage());
        }
    }

    public XPCoordinate2DDouble getCurrentDrLocation() {
        XPCoordinate2DDouble xPCoordinate2DDouble;
        synchronized (this.mCarDrLocationMutex) {
            String str = null;
            if (this.mCurrentDrLocation == null) {
                str = "get position service location with default location !!!";
                xPCoordinate2DDouble = new XPCoordinate2DDouble(113.3850753307d, 23.1595867537d);
            } else {
                xPCoordinate2DDouble = new XPCoordinate2DDouble(this.mCurrentDrLocation.mLon, this.mCurrentDrLocation.mLat);
            }
            if (str != null) {
                L.i(TAG, str);
            }
        }
        return xPCoordinate2DDouble;
    }

    public void addPosRoadChangedListener(IPosRoadChangedCallback iPosRoadChangedCallback) {
        if (iPosRoadChangedCallback == null || this.mListeners.contains(iPosRoadChangedCallback)) {
            return;
        }
        this.mListeners.add(iPosRoadChangedCallback);
    }

    public void removePosRoadChangedListener(IPosRoadChangedCallback iPosRoadChangedCallback) {
        this.mListeners.remove(iPosRoadChangedCallback);
    }

    public void clearCalibrationAndReboot() {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr;
                for (String str : RootUtil.TO_CALIBRATION_FILE_LIST) {
                    L.i(PosServiceWrapper.TAG, "delete " + RootUtil.SD_CARD_DIR_POS_320_CONTEXT + str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(RootUtil.SD_CARD_DIR_POS_320_CONTEXT);
                    sb.append(str);
                    FileUtil.deleteFile(sb.toString());
                    L.i(PosServiceWrapper.TAG, "delete " + RootUtil.SD_CARD_DIR_POS_430_CONTEXT + str);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(RootUtil.SD_CARD_DIR_POS_430_CONTEXT);
                    sb2.append(str);
                    FileUtil.deleteFile(sb2.toString());
                    L.i(PosServiceWrapper.TAG, "delete " + RootUtil.SD_CARD_DIR_POS_520_CONTEXT + str);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(RootUtil.SD_CARD_DIR_POS_520_CONTEXT);
                    sb3.append(str);
                    FileUtil.deleteFile(sb3.toString());
                }
                RootUtil.delayExitApp(RootUtil.KILL_NAVI_CLEAR_CALIBRATION);
            }
        });
    }

    public boolean isLocationRecordMode() {
        DRLogService dRLogService = this.mRecorder;
        if (dRLogService == null) {
            return false;
        }
        return dRLogService.isRecorderRunning();
    }

    public void setLocationRecordMode(boolean z) {
        if (this.mRecorder == null && z) {
            L.i(TAG, "first time new SimulatedLogLocationService");
            this.mRecorder = new DRLogService(RootUtil.getLogPath());
            this.mRecorder.startLocationRecord();
        } else if (z) {
            L.i(TAG, "restart SimulatedLogLocationService");
            this.mRecorder.startLocationRecord();
        } else {
            L.i(TAG, "stop SimulatedLogLocationService");
            this.mRecorder.stopLocationRecord();
        }
    }

    public void setLocGpgsv(XPLocGpgsv xPLocGpgsv) {
        if (xPLocGpgsv == null) {
            L.w(TAG, "setLocGpgsv xpLocGpgsv null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocGpgsv mPosService not init");
            return;
        }
        LocGpgsv locGpgsv = new LocGpgsv();
        locGpgsv.type = xPLocGpgsv.getType();
        locGpgsv.num = xPLocGpgsv.getNum();
        locGpgsv.prn = xPLocGpgsv.getPrn();
        locGpgsv.elevation = xPLocGpgsv.getElevation();
        locGpgsv.azimuth = xPLocGpgsv.getAzimuth();
        locGpgsv.snr = xPLocGpgsv.getSnr();
        locGpgsv.tickTime = BigInteger.valueOf(xPLocGpgsv.getTickTime());
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = 64;
        locSignData.gpgsv = locGpgsv;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setLocGyro(XPLocGyro xPLocGyro) {
        if (xPLocGyro == null) {
            L.w(TAG, "setLocGyro xpLocGyro null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocGyro mPosService not init");
            return;
        }
        LocGyro locGyro = new LocGyro();
        locGyro.valueX = xPLocGyro.getValueX();
        locGyro.valueY = xPLocGyro.getValueY();
        locGyro.valueZ = xPLocGyro.getValueZ();
        locGyro.tickTime = BigInteger.valueOf(xPLocGyro.getTickTime());
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = 4;
        locSignData.gyro = locGyro;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setLocPulse(XPLocPulse xPLocPulse) {
        if (xPLocPulse == null) {
            L.w(TAG, "setLocPulse xpLocPulse null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocPulse mPosService not init");
            return;
        }
        LocPulse locPulse = new LocPulse();
        locPulse.value = xPLocPulse.getValue();
        locPulse.tickTime = BigInteger.valueOf(xPLocPulse.getTickTime());
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = 8;
        locSignData.pulse = locPulse;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setLocAcce3d(XPLocAcce3d xPLocAcce3d) {
        if (xPLocAcce3d == null) {
            L.w(TAG, "setLocAcce3d xpLocAcce3d null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocAcce3d mPosService not init");
            return;
        }
        LocAcce3d locAcce3d = new LocAcce3d();
        locAcce3d.acceX = xPLocAcce3d.getAcceX();
        locAcce3d.acceY = xPLocAcce3d.getAcceY();
        locAcce3d.acceZ = xPLocAcce3d.getAcceZ();
        locAcce3d.tickTime = BigInteger.valueOf(xPLocAcce3d.getTickTime());
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = 2;
        locSignData.acce3D = locAcce3d;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setLocVision(LocVision locVision) {
        if (locVision == null) {
            L.w(TAG, "setLocVision locVision null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocVision mPosService not init");
            return;
        }
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = LocDataType.LocDataVision;
        locSignData.locVision = locVision;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setLocVisualObj(XPLocVisualObj xPLocVisualObj) {
        if (xPLocVisualObj == null) {
            L.w(TAG, "setLocVisualObj xpLocVisualObj null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setLocVisualObj mPosService not init");
            return;
        }
        LocVisualObj locVisualObj = new LocVisualObj();
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = LocDataType.LocDataVisualObj;
        locSignData.locVisualObj = locVisualObj;
        this.mPosService.setSignInfo(locSignData);
    }

    public void setDrPos(LocDrPos locDrPos) {
        if (locDrPos == null) {
            L.w(TAG, "setDrPos posRTKImuResultExternal null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setDrPos mPosService not init");
            return;
        }
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = 512;
        locSignData.drPos = locDrPos;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setDrPos mLocSignData = " + getTime(this.mLocSignData));
        }
        this.mPosService.setSignInfo(this.mLocSignData);
    }

    public void setAllFusionPos(LocAllFusionPos locAllFusionPos) {
        if (locAllFusionPos == null) {
            L.w(TAG, "setAllFusionPos posFusionResultExternal null");
            return;
        }
        PosService posService = this.mPosService;
        if (posService == null || 3 != posService.isInit()) {
            L.w(TAG, "setAllFusionPos mPosService not init");
            return;
        }
        LocSignData locSignData = this.mLocSignData;
        locSignData.dataType = LocDataType.LocDataAllFusion;
        locSignData.allFusionPos = locAllFusionPos;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setDrPos setAllFusionPos = " + getTime(this.mLocSignData));
        }
        this.mPosService.setSignInfo(this.mLocSignData);
    }

    public boolean isAmapEngineTimeout(long j) {
        return this.mAmapEngineAliveChecker.isTimeout(j);
    }

    public void resetAmapEngineChecker() {
        this.mAmapEngineAliveChecker.reset();
    }

    public long getLastUpdateSensorTime() {
        return this.mAmapEngineAliveChecker.getLastUpdateSensorTime();
    }
}
