package com.xiaopeng.montecarlo.root.carservice;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.diagnostic.XpDiagnosticManager;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.bcm.CarBcmManager;
import android.car.hardware.hvac.CarHvacManager;
import android.car.hardware.icm.CarIcmManager;
import android.car.hardware.imu.CarImuManager;
import android.car.hardware.mcu.CarMcuManager;
import android.car.hardware.scu.CarScuManager;
import android.car.hardware.tbox.CarTboxManager;
import android.car.hardware.vcu.CarVcuManager;
import android.car.hardware.xpu.CarXpuManager;
import android.car.hardware.xpu.XpuProtoMessage;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XpCarService implements ICarService {
    private static final int BCM_DRIVER_SEAT_OCCUPIED_CHANGE_EVENT = 14;
    private static final int BCM_HEAD_BEAM_EVENT = 45;
    private static final int BCM_LOW_BEAM_EVENT = 46;
    private static final int BCM_POWER_MODE_EVENT = 48;
    private static final int ESP_CAR_SPEED_EVENT = 1;
    private static final int GEAR_LEVEL_EVENT = 2;
    private static final int GEAR_LEVEL_INVALID = 0;
    private static final int HVAC_POWER_MODE_CHANGE_EVENT = 13;
    private static final int ICM_CONNECT_EVENT = 4;
    private static final int ICM_NEED_NAVI_EVENT = 6;
    private static final int IG_STATUS_EVENT = 3;
    private static final int IMU_AP_CAN_RAW_DATA_EVENT = 47;
    private static final int IMU_CAN_MIX_DATA_LENGTH = 10;
    private static final int IMU_CAN_RAW_DATA_LENGTH = 8;
    private static final int IMU_MIX_DATA_LENGTH = 37;
    private static final int IMU_NAV_DATA_EVENT = 10;
    private static final int IMU_NAV_DATA_LENGTH = 29;
    private static final int IMU_RAW_DATA_EVENT = 9;
    private static final int IMU_RAW_DATA_LENGTH = 35;
    private static final int IMU_TBOX_CAN_RAW_DATA_EVENT = 49;
    private static final int INVALID_REMAIN_DISTANCE_VALUE = 1023;
    public static final long INVALID_REQUEST_ID = -1;
    private static final int MAX_COUNT = 2;
    private static final int MCU_FACTORYMODE_EVENT = 51;
    private static final int MSG_GET_NAVI_CONFIRM_PROTO = 100099;
    private static final int MSG_SET_NAVI_ROUTING_INFO_REQUEST = 100100;
    private static final int PROP_VALUE_DEFAULT = 0;
    private static final int PROP_VALUE_INVALID = -1;
    private static final int SCU_BSD_LEFTWARNING_EVENT = 22;
    private static final int SCU_BSD_RIGHTWARNING_EVNET = 23;
    private static final int SCU_CAR_SPEED_EVENT = 8;
    private static final int SCU_CRUISE_SPEEED_EVENT = 37;
    private static final int SCU_DOW_LEFTWARNING_EVNET = 25;
    private static final int SCU_DOW_RIGHTWARNING_EVENT = 24;
    private static final int SCU_FISHEYECAM_FAIL_EVENT = 33;
    private static final int SCU_MAINCAM_FAIL_EVENT = 34;
    private static final int SCU_MODE_INDEX_CHANGE_EVENT = 12;
    private static final int SCU_MRR_ASSIST_EVENT = 20;
    private static final int SCU_MRR_FAIL_EVENT = 21;
    private static final int SCU_NARROWCAM_FAIL_EVENT = 35;
    private static final int SCU_NGP_INFOTIPS1_EVENT = 41;
    private static final int SCU_NGP_LCTIPS1_EVENT = 40;
    private static final int SCU_NGP_OPE_BUTTON_EVNET = 39;
    private static final int SCU_NGP_STATUS_CHANGE_EVENT = 44;
    private static final int SCU_NGP_TIPS_WINDOW_EVENT = 42;
    private static final int SCU_PURE_DRIVE_MODE_ACC_STATUS_CHANGE_EVENT = 5;
    private static final int SCU_PURE_DRIVE_MODE_LCC_STATUS_CHANGE_EVENT = 7;
    private static final int SCU_QUIT_NGP_ODD_EVENT = 38;
    private static final int SCU_RCTA_LEFTWARNING_EVENT = 26;
    private static final int SCU_RCTA_RIGHTWARNING_EVENT = 27;
    private static final int SCU_RCW_WARNING_EVENT = 28;
    private static final int SCU_SIDECAM_FAIL_EVENT = 36;
    private static final int SRR_FLFAIL_EVENT = 29;
    private static final int SRR_FRFAIL_EVENT = 30;
    private static final int SRR_RLFAIL_EVENT = 31;
    private static final int SRR_RRFAIL_EVENT = 32;
    private static final int TBOX_APN_CONNECTION_STATUS_EVENT = 11;
    private static final int VCU_ENDURANCE_MILEAGE_MODE_CHANGE_EVENT = 16;
    private static final int VCU_MILEAGE_NUMBER_CHANGE_EVENT = 15;
    private static final int VCU_NAVI_DEST_INFO_REQ_EVENT = 50;
    private static final int VPM_LDW_LEFTWARNING_EVENT = 18;
    private static final int VPM_LDW_RIGHTWARNING_EVENT = 19;
    private static final int XPU_NEDC_STATUS_CHANGE_EVENT = 17;
    private static final int XPU_SR_RD_PERIOD_DATA_EVENT = 43;
    private Car mCarApiClient;
    private CarBcmManager mCarBcmManager;
    private CarHvacManager mCarHvacManager;
    private CarIcmManager mCarIcmManager;
    private CarImuManager mCarImuManager;
    private CarMcuManager mCarMcuManager;
    private CarScuManager mCarScuManager;
    private CarServiceHelper mCarServiceHelper;
    private CarTboxManager mCarTboxManager;
    private CarVcuManager mCarVcuManager;
    private CarXpuManager mCarXpuManager;
    private ICarService.ICarXPUDataCallBack mICarXPUDataCallBack;
    private ICarService.ICarStateListener mListener;
    private static final String SERVICE_NAME = "XpCarService";
    private static final L.Tag TAG = new L.Tag(SERVICE_NAME);
    private static final Collection<Integer> TBOX_IDS = new ArrayList(Arrays.asList(554700817));
    private static final Collection<Integer> BCM_IDS = new ArrayList(Arrays.asList(557849607, 289410561, 557849633, 557849700));
    private static Collection<Integer> sVcuIds = new ArrayList(Arrays.asList(557847045, 557847042, 557847057, 557847128, 557847127, 557847140));
    private static Collection<Integer> sScuIds = new ArrayList(Arrays.asList(557852200, 557852212, 557852235, 557852318, 557852311));
    private static final Collection<Integer> MCU_IDS = new ArrayList(Arrays.asList(557847561, 557847658));
    private static final Collection<Integer> HVAC_IDS = new ArrayList(Arrays.asList(557849130));
    private static final Collection<Integer> ICM_IDS = new ArrayList(Arrays.asList(557848078, 554702405));
    private static Collection<Integer> sImuIds = new ArrayList();
    private static final Collection<Integer> XPU_IDS = new ArrayList(Arrays.asList(557856775, 561002576));
    private static final Float INVALID_SPEED_VALUE = Float.valueOf(-1.0f);
    private static final Float DEFAULT_SPEED_VALUE = Float.valueOf(0.0f);
    private HashSet<Integer> mValidTboxIds = new HashSet<>();
    private HashSet<Integer> mValidBcmIds = new HashSet<>();
    private HashSet<Integer> mValidVcuIds = new HashSet<>();
    private HashSet<Integer> mValidScuIds = new HashSet<>();
    private HashSet<Integer> mValidMcuIds = new HashSet<>();
    private HashSet<Integer> mValidHvacIds = new HashSet<>();
    private HashSet<Integer> mValidIcmIds = new HashSet<>();
    private HashSet<Integer> mValidImuIds = new HashSet<>();
    private HashSet<Integer> mValidXpuIds = new HashSet<>();
    private boolean mIsCarServiceAvailable = true;
    private int mNedcSwitchStatus = -1;
    private int mEnduranceMileageMode = -1;
    private int mNedcRemainDistance = 1023;
    private int mWltpRemainDistance = 1023;
    private int mCltcRemainDistance = 1023;
    private int mRemainPercent = -1;
    private float mEspCarSpeed = INVALID_SPEED_VALUE.floatValue();
    private int mAccStatus = -1;
    private int mXPilotStatus = -1;
    private int mScuModeIndex = -1;
    private int mNGPStatus = -1;
    private int mIgStatus = -1;
    private int mGearLevel = 0;
    private int mHvacPowerMode = -1;
    private int mCruiseSpeed = -1;
    private int mScuQuitNgpOddStatus = -1;
    private int mScuNgpOpeButtonStatus = -1;
    private int mScuNgpLcTips1Status = -1;
    private int mScuNgpInfoTips1Status = -1;
    private int mScuNgpTipsWindowStatus = -1;
    private int mDriverSeatOccupied = -1;
    private int mFarLampState = -1;
    private int mNearLampState = -1;
    private float[] mImuNavData = new float[29];
    private boolean mIsIcmConnected = true;
    private boolean mIcmMapDisplayState = false;
    private int mIcmMapFps = 0;
    private volatile int mIcmMapWidth = 0;
    private volatile int mIcmMapHeight = 0;
    private int mIcmMapImageType = 2;
    private int mBcmPowerMode = -1;
    private boolean mIsApnConnected = false;
    private int mFactoryMode = -1;
    private long mLastNaviPathId = -1;
    private final CarHvacManager.CarHvacEventCallback mCarHvacEventCallback = new CarHvacManager.CarHvacEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.1
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int intValue;
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            if (propertyId == 557849130 && (value instanceof Integer) && XpCarService.this.mHvacPowerMode != (intValue = ((Integer) value).intValue())) {
                XpCarService.this.mHvacPowerMode = intValue;
                CarServiceHelper carServiceHelper = XpCarService.this.mCarServiceHelper;
                XpCarService xpCarService = XpCarService.this;
                carServiceHelper.notifyCarStateChanged(13, Boolean.valueOf(xpCarService.isHvacPowerOn(xpCarService.mHvacPowerMode)));
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i == 557849130 && -1 != XpCarService.this.mHvacPowerMode) {
                L.e(XpCarService.TAG, "CarHvacManager.ID_ZONED_HVAC_POWER_ON onErrorEvent");
                XpCarService.this.mHvacPowerMode = -1;
                CarServiceHelper carServiceHelper = XpCarService.this.mCarServiceHelper;
                XpCarService xpCarService = XpCarService.this;
                carServiceHelper.notifyCarStateChanged(13, Boolean.valueOf(xpCarService.isHvacPowerOn(xpCarService.mHvacPowerMode)));
            }
        }
    };
    private final CarBcmManager.CarBcmEventCallback mCarBcmEventCallback = new CarBcmManager.CarBcmEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.2
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int intValue;
            int intValue2;
            int intValue3;
            Integer num;
            int intValue4;
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            switch (propertyId) {
                case 289410561:
                    if (!(value instanceof Integer) || XpCarService.this.mFarLampState == (intValue = ((Integer) value).intValue())) {
                        return;
                    }
                    XpCarService.this.mFarLampState = intValue;
                    L.Tag tag = XpCarService.TAG;
                    L.i(tag, "mFarLampState:" + XpCarService.this.mFarLampState);
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(45, Integer.valueOf(XpCarService.this.mFarLampState));
                    return;
                case 557849607:
                    if (!(value instanceof Integer) || XpCarService.this.mDriverSeatOccupied == (intValue2 = ((Integer) value).intValue())) {
                        return;
                    }
                    XpCarService.this.mDriverSeatOccupied = intValue2;
                    L.Tag tag2 = XpCarService.TAG;
                    L.i(tag2, "DriverSeatOccupied:" + XpCarService.this.mDriverSeatOccupied);
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(14, Integer.valueOf(XpCarService.this.mDriverSeatOccupied));
                    return;
                case 557849633:
                    if (!(value instanceof Integer) || XpCarService.this.mNearLampState == (intValue3 = ((Integer) value).intValue())) {
                        return;
                    }
                    XpCarService.this.mNearLampState = intValue3;
                    L.Tag tag3 = XpCarService.TAG;
                    L.i(tag3, "mNearLampState:" + XpCarService.this.mNearLampState);
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(46, Integer.valueOf(XpCarService.this.mNearLampState));
                    return;
                case 557849700:
                    if (!(value instanceof Integer) || (intValue4 = (num = (Integer) value).intValue()) == XpCarService.this.mBcmPowerMode) {
                        return;
                    }
                    XpCarService.this.mBcmPowerMode = intValue4;
                    L.Tag tag4 = XpCarService.TAG;
                    L.i(tag4, "ID_BCM_POWERMODE:" + num.intValue());
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(48, Integer.valueOf(XpCarService.this.mBcmPowerMode));
                    return;
                default:
                    return;
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i == 289410561) {
                if (-1 != XpCarService.this.mFarLampState) {
                    L.e(XpCarService.TAG, "CarBcmManager.ID_BCM_HEAD_BEAM onErrorEvent");
                    XpCarService.this.mFarLampState = -1;
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(45, Integer.valueOf(XpCarService.this.mFarLampState));
                }
            } else if (i != 557849607) {
                if (i == 557849633 && -1 != XpCarService.this.mNearLampState) {
                    L.e(XpCarService.TAG, "CarBcmManager.ID_BCM_LOW_BEAM onErrorEvent");
                    XpCarService.this.mNearLampState = -1;
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(46, Integer.valueOf(XpCarService.this.mNearLampState));
                }
            } else if (-1 != XpCarService.this.mDriverSeatOccupied) {
                L.e(XpCarService.TAG, "CarBcmManager.ID_BCM_DRIVERSEAT_OCCUPIED onErrorEvent");
                XpCarService.this.mDriverSeatOccupied = -1;
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(14, Integer.valueOf(XpCarService.this.mDriverSeatOccupied));
            }
        }
    };
    private final CarTboxManager.CarTboxEventCallback mCarTboxCallback = new CarTboxManager.CarTboxEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.3
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            XpCarService.this.handleTboxEvent(carPropertyValue);
        }

        public void onErrorEvent(int i, int i2) {
            if (L.ENABLE) {
                L.Tag tag = XpCarService.TAG;
                L.d(tag, "onErrorEvent:" + i + "," + i2);
            }
        }
    };
    private final CarScuManager.CarScuEventCallback mCarScuEventCallback = new CarScuManager.CarScuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.4
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int intValue;
            int intValue2;
            Object[] objArr;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int intValue7;
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            switch (propertyId) {
                case 557852195:
                    if (value instanceof Integer) {
                        int intValue8 = ((Integer) value).intValue();
                        L.Tag tag = XpCarService.TAG;
                        L.i(tag, L.formatSRLog("SCU_BSD_RIGHT_WARNING:" + intValue8));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(23, Integer.valueOf(intValue8));
                        return;
                    }
                    return;
                case 557852196:
                    if (value instanceof Integer) {
                        int intValue9 = ((Integer) value).intValue();
                        L.Tag tag2 = XpCarService.TAG;
                        L.i(tag2, L.formatSRLog("SCU_BSD_LEFT_WARNING:" + intValue9));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(22, Integer.valueOf(intValue9));
                        return;
                    }
                    return;
                case 557852197:
                    if (value instanceof Integer) {
                        int intValue10 = ((Integer) value).intValue();
                        L.Tag tag3 = XpCarService.TAG;
                        L.i(tag3, L.formatSRLog("SCU_RCTA_LEFT_WARNING:" + intValue10));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(26, Integer.valueOf(intValue10));
                        return;
                    }
                    return;
                case 557852198:
                    if (value instanceof Integer) {
                        int intValue11 = ((Integer) value).intValue();
                        L.Tag tag4 = XpCarService.TAG;
                        L.i(tag4, L.formatSRLog("SCU_RCTA_RIGHT_WARNING:" + intValue11));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(27, Integer.valueOf(intValue11));
                        return;
                    }
                    return;
                default:
                    switch (propertyId) {
                        case 557852200:
                            if (value instanceof Integer) {
                                int intValue12 = ((Integer) value).intValue();
                                XpCarService xpCarService = XpCarService.this;
                                if (xpCarService.isLccOnByXPilotStatus(xpCarService.mXPilotStatus) != XpCarService.this.isLccOnByXPilotStatus(intValue12)) {
                                    L.Tag tag5 = XpCarService.TAG;
                                    L.i(tag5, "ID_SCU_XPILOT_ST:" + intValue12);
                                    XpCarService.this.mXPilotStatus = intValue12;
                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(7, Integer.valueOf(XpCarService.this.mXPilotStatus));
                                    return;
                                }
                                return;
                            }
                            return;
                        case 557852212:
                            if (value instanceof Integer) {
                                int intValue13 = ((Integer) value).intValue();
                                XpCarService xpCarService2 = XpCarService.this;
                                if (xpCarService2.isAccOnByStatus(xpCarService2.mAccStatus) != XpCarService.this.isAccOnByStatus(intValue13)) {
                                    L.Tag tag6 = XpCarService.TAG;
                                    L.i(tag6, "ID_SCU_ACC_ST:" + intValue13);
                                    XpCarService.this.mAccStatus = intValue13;
                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(5, Integer.valueOf(XpCarService.this.mAccStatus));
                                    return;
                                }
                                return;
                            }
                            return;
                        case 557852235:
                            if (!(value instanceof Integer) || XpCarService.this.mScuModeIndex == (intValue = ((Integer) value).intValue())) {
                                return;
                            }
                            L.Tag tag7 = XpCarService.TAG;
                            L.i(tag7, "ID_SCU_MODE_INDEX:" + intValue);
                            XpCarService.this.mScuModeIndex = intValue;
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(12, Integer.valueOf(XpCarService.this.mScuModeIndex));
                            return;
                        case 557852283:
                            if (value instanceof Integer) {
                                int intValue14 = ((Integer) value).intValue();
                                L.Tag tag8 = XpCarService.TAG;
                                L.i(tag8, L.formatSRLog("SCU_RCW_WARNING:" + intValue14));
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(28, Integer.valueOf(intValue14));
                                return;
                            }
                            return;
                        case 557852318:
                            if (!(value instanceof Integer) || XpCarService.this.mNGPStatus == (intValue2 = ((Integer) value).intValue())) {
                                return;
                            }
                            if (1 == intValue2 || 2 == intValue2) {
                                L.Tag tag9 = XpCarService.TAG;
                                L.i(tag9, "ID_SCU_NGP_XPILOTST:" + intValue2);
                                XpCarService.this.mNGPStatus = intValue2;
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(44, Integer.valueOf(XpCarService.this.mNGPStatus));
                                return;
                            }
                            return;
                        case 557917818:
                            if (value instanceof Integer[]) {
                                Integer[] numArr = (Integer[]) value;
                                if (numArr.length >= 4) {
                                    L.Tag tag10 = XpCarService.TAG;
                                    L.i(tag10, L.formatSRLog("SCU_MRR_ASSIST_SYSST:" + numArr[0] + ", " + numArr[1] + "," + numArr[2] + "," + numArr[3]));
                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(20, numArr);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 557917844:
                            if (value instanceof Integer[]) {
                                Integer[] numArr2 = (Integer[]) value;
                                if (numArr2.length >= 5) {
                                    L.Tag tag11 = XpCarService.TAG;
                                    L.i(tag11, L.formatSRLog("SIDECAM_FAILURE_ST data:" + numArr2[0] + ", " + numArr2[1] + "," + numArr2[2] + "," + numArr2[3] + "," + numArr2[4]));
                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(36, numArr2);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 560014911:
                            if (!(value instanceof Float[]) || (objArr = (Object[]) value) == null) {
                                return;
                            }
                            float[] fArr = new float[objArr.length];
                            for (int i = 0; i < objArr.length; i++) {
                                Object obj = objArr[i];
                                if (obj instanceof Float) {
                                    fArr[i] = ((Float) obj).floatValue();
                                }
                            }
                            if (fArr.length > 8) {
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(8, Float.valueOf(fArr[8]));
                                if (RootUtil.sIsDrTestMode) {
                                    StatisticDataUtil.updateDRScuSpeedInputTime();
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            switch (propertyId) {
                                case 557852286:
                                    if (value instanceof Integer) {
                                        int intValue15 = ((Integer) value).intValue();
                                        L.Tag tag12 = XpCarService.TAG;
                                        L.i(tag12, L.formatSRLog("SCU_DOW_LWARNING:" + intValue15));
                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(25, Integer.valueOf(intValue15));
                                        return;
                                    }
                                    return;
                                case 557852287:
                                    if (value instanceof Integer) {
                                        int intValue16 = ((Integer) value).intValue();
                                        L.Tag tag13 = XpCarService.TAG;
                                        L.i(tag13, L.formatSRLog("SCU_DOW_RWARNING:" + intValue16));
                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(24, Integer.valueOf(intValue16));
                                        return;
                                    }
                                    return;
                                default:
                                    switch (propertyId) {
                                        case 557852304:
                                            if (value instanceof Integer) {
                                                int intValue17 = ((Integer) value).intValue();
                                                L.Tag tag14 = XpCarService.TAG;
                                                L.i(tag14, L.formatSRLog("SCU_MRR_FAILURE_ST:" + intValue17));
                                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(21, Integer.valueOf(intValue17));
                                                return;
                                            }
                                            return;
                                        case 557852305:
                                            if (value instanceof Integer) {
                                                int intValue18 = ((Integer) value).intValue();
                                                L.Tag tag15 = XpCarService.TAG;
                                                L.i(tag15, L.formatSRLog("SCU_FISHEYECAM_FAILURE_ST:" + intValue18));
                                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(33, Integer.valueOf(intValue18));
                                                return;
                                            }
                                            return;
                                        case 557852306:
                                            if (value instanceof Integer) {
                                                int intValue19 = ((Integer) value).intValue();
                                                L.Tag tag16 = XpCarService.TAG;
                                                L.i(tag16, L.formatSRLog("SCU_MAINCAM_FAILURE_ST:" + intValue19));
                                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(34, Integer.valueOf(intValue19));
                                                return;
                                            }
                                            return;
                                        case 557852307:
                                            if (value instanceof Integer) {
                                                int intValue20 = ((Integer) value).intValue();
                                                L.Tag tag17 = XpCarService.TAG;
                                                L.i(tag17, L.formatSRLog("SCU_NARROWCAM_FAILURE_ST:" + intValue20));
                                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(35, Integer.valueOf(intValue20));
                                                return;
                                            }
                                            return;
                                        default:
                                            switch (propertyId) {
                                                case 557852309:
                                                    if (value instanceof Integer) {
                                                        int intValue21 = ((Integer) value).intValue();
                                                        if (L.ENABLE) {
                                                            L.Tag tag18 = XpCarService.TAG;
                                                            L.d(tag18, L.formatSRLog("SCU_CRUISESPD_SET_DISP:" + intValue21));
                                                        }
                                                        if (XpCarService.this.mCruiseSpeed != intValue21) {
                                                            XpCarService.this.mCruiseSpeed = intValue21;
                                                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(37, Integer.valueOf(XpCarService.this.mCruiseSpeed));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                case 557852310:
                                                    if (!(value instanceof Integer) || XpCarService.this.mScuQuitNgpOddStatus == (intValue3 = ((Integer) value).intValue())) {
                                                        return;
                                                    }
                                                    L.Tag tag19 = XpCarService.TAG;
                                                    L.i(tag19, L.formatSRLog("SCU_QUIT_NGP_ODD:" + intValue3));
                                                    XpCarService.this.mScuQuitNgpOddStatus = intValue3;
                                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(38, Integer.valueOf(XpCarService.this.mScuQuitNgpOddStatus));
                                                    return;
                                                case 557852311:
                                                    if (!(value instanceof Integer) || XpCarService.this.mScuNgpOpeButtonStatus == (intValue4 = ((Integer) value).intValue())) {
                                                        return;
                                                    }
                                                    L.Tag tag20 = XpCarService.TAG;
                                                    L.i(tag20, L.formatSRLog("SCU_NGP_OPEBUTTON_ST:" + intValue4));
                                                    XpCarService.this.mScuNgpOpeButtonStatus = intValue4;
                                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(39, Integer.valueOf(XpCarService.this.mScuNgpOpeButtonStatus));
                                                    return;
                                                case 557852312:
                                                    if (!(value instanceof Integer) || XpCarService.this.mScuNgpLcTips1Status == (intValue5 = ((Integer) value).intValue())) {
                                                        return;
                                                    }
                                                    L.Tag tag21 = XpCarService.TAG;
                                                    L.i(tag21, L.formatSRLog("SCU_NGP_LC_TIPS1:" + intValue5));
                                                    XpCarService.this.mScuNgpLcTips1Status = intValue5;
                                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(40, Integer.valueOf(XpCarService.this.mScuNgpLcTips1Status));
                                                    return;
                                                case 557852313:
                                                    if (!(value instanceof Integer) || XpCarService.this.mScuNgpInfoTips1Status == (intValue6 = ((Integer) value).intValue())) {
                                                        return;
                                                    }
                                                    L.Tag tag22 = XpCarService.TAG;
                                                    L.i(tag22, L.formatSRLog("SCU_NGP_INFO_TIPS1:" + intValue6));
                                                    XpCarService.this.mScuNgpInfoTips1Status = intValue6;
                                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(41, Integer.valueOf(XpCarService.this.mScuNgpInfoTips1Status));
                                                    return;
                                                case 557852314:
                                                    if (!(value instanceof Integer) || XpCarService.this.mScuNgpTipsWindowStatus == (intValue7 = ((Integer) value).intValue())) {
                                                        return;
                                                    }
                                                    L.Tag tag23 = XpCarService.TAG;
                                                    L.i(tag23, L.formatSRLog("SCU_NGP_TIPS_WINDOWS_ST:" + intValue7));
                                                    XpCarService.this.mScuNgpTipsWindowStatus = intValue7;
                                                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(42, Integer.valueOf(XpCarService.this.mScuNgpTipsWindowStatus));
                                                    return;
                                                default:
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        }

        public void onErrorEvent(int i, int i2) {
            switch (i) {
                case 557852195:
                case 557852196:
                case 557852197:
                case 557852198:
                    return;
                default:
                    switch (i) {
                        case 557852200:
                            if (-1 != XpCarService.this.mXPilotStatus) {
                                XpCarService.this.mXPilotStatus = -1;
                                L.e(XpCarService.TAG, "CarScuManager.ID_SCU_XPILOT_ST onErrorEvent");
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(7, -1);
                                return;
                            }
                            return;
                        case 557852212:
                            if (-1 != XpCarService.this.mAccStatus) {
                                XpCarService.this.mAccStatus = -1;
                                L.e(XpCarService.TAG, "CarScuManager.ID_SCU_ACC_ST onErrorEvent");
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(5, Integer.valueOf(XpCarService.this.mAccStatus));
                                return;
                            }
                            return;
                        case 557852235:
                            if (-1 != XpCarService.this.mScuModeIndex) {
                                XpCarService.this.mScuModeIndex = -1;
                                L.e(XpCarService.TAG, "CarScuManager.ID_SCU_MODE_INDEX onErrorEvent");
                                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(12, Integer.valueOf(XpCarService.this.mScuModeIndex));
                                return;
                            }
                            return;
                        case 557852283:
                        case 557917818:
                        case 557917844:
                            return;
                        case 557852318:
                            if (-1 != XpCarService.this.mNGPStatus) {
                                L.e(XpCarService.TAG, "CarScuManager.ID_SCU_NGP_XPILOTST onErrorEvent");
                                return;
                            }
                            return;
                        case 560014911:
                            L.e(XpCarService.TAG, "CarScuManager.ID_SCU_LOCAT_DATA onErrorEvent");
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(8, XpCarService.DEFAULT_SPEED_VALUE);
                            return;
                        default:
                            switch (i) {
                                case 557852286:
                                case 557852287:
                                    return;
                                default:
                                    switch (i) {
                                        case 557852304:
                                        case 557852305:
                                        case 557852306:
                                        case 557852307:
                                            return;
                                        default:
                                            switch (i) {
                                                case 557852309:
                                                    if (-1 != XpCarService.this.mCruiseSpeed) {
                                                        XpCarService.this.mCruiseSpeed = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_CRUISESPD_SET_DISP onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(37, Integer.valueOf(XpCarService.this.mCruiseSpeed));
                                                        return;
                                                    }
                                                    return;
                                                case 557852310:
                                                    if (-1 != XpCarService.this.mScuQuitNgpOddStatus) {
                                                        XpCarService.this.mScuQuitNgpOddStatus = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_QUIT_NGP_ODD onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(38, Integer.valueOf(XpCarService.this.mScuQuitNgpOddStatus));
                                                        return;
                                                    }
                                                    return;
                                                case 557852311:
                                                    if (-1 != XpCarService.this.mScuNgpOpeButtonStatus) {
                                                        XpCarService.this.mScuNgpOpeButtonStatus = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_NGP_OPEBUTTON_ST onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(39, Integer.valueOf(XpCarService.this.mScuNgpOpeButtonStatus));
                                                        return;
                                                    }
                                                    return;
                                                case 557852312:
                                                    if (-1 != XpCarService.this.mScuNgpLcTips1Status) {
                                                        XpCarService.this.mScuNgpLcTips1Status = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_NGP_LC_TIPS1 onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(40, Integer.valueOf(XpCarService.this.mScuNgpLcTips1Status));
                                                        return;
                                                    }
                                                    return;
                                                case 557852313:
                                                    if (-1 != XpCarService.this.mScuNgpInfoTips1Status) {
                                                        XpCarService.this.mScuNgpInfoTips1Status = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_NGP_INFO_TIPS1 onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(41, Integer.valueOf(XpCarService.this.mScuNgpInfoTips1Status));
                                                        return;
                                                    }
                                                    return;
                                                case 557852314:
                                                    if (-1 != XpCarService.this.mScuNgpTipsWindowStatus) {
                                                        XpCarService.this.mScuNgpTipsWindowStatus = -1;
                                                        L.e(XpCarService.TAG, "CarScuManager.ID_SCU_NGP_TIPS_WINDOWS_ST onErrorEvent");
                                                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(42, Integer.valueOf(XpCarService.this.mScuNgpTipsWindowStatus));
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        }
    };
    private final XpDiagnosticManager.XpDiagnosticEventCallback mXpDiagnosticEventCallback = new XpDiagnosticManager.XpDiagnosticEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.5
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            switch (propertyId) {
                case 557852276:
                    if (value instanceof Integer) {
                        int intValue = ((Integer) value).intValue();
                        L.Tag tag = XpCarService.TAG;
                        L.i(tag, L.formatSRLog("SRR_FLFAIL_ST:" + intValue));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(29, Integer.valueOf(intValue));
                        return;
                    }
                    return;
                case 557852277:
                    if (value instanceof Integer) {
                        int intValue2 = ((Integer) value).intValue();
                        L.Tag tag2 = XpCarService.TAG;
                        L.i(tag2, L.formatSRLog("SRR_FRFAIL_ST:" + intValue2));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(30, Integer.valueOf(intValue2));
                        return;
                    }
                    return;
                case 557852278:
                    if (value instanceof Integer) {
                        int intValue3 = ((Integer) value).intValue();
                        L.Tag tag3 = XpCarService.TAG;
                        L.i(tag3, L.formatSRLog("SRR_RLFAIL_ST:" + intValue3));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(31, Integer.valueOf(intValue3));
                        return;
                    }
                    return;
                case 557852279:
                    if (value instanceof Integer) {
                        int intValue4 = ((Integer) value).intValue();
                        L.Tag tag4 = XpCarService.TAG;
                        L.i(tag4, L.formatSRLog("SRR_RRFAIL_ST:" + intValue4));
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(32, Integer.valueOf(intValue4));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onErrorEvent(int i, int i2) {
            switch (i) {
                case 557852276:
                case 557852277:
                case 557852278:
                case 557852279:
                    if (L.ENABLE) {
                        L.Tag tag = XpCarService.TAG;
                        L.d(tag, L.formatSRLog("mXpDiagnosticEventCallback onErrorEvent:" + i));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final CarMcuManager.CarMcuEventCallback mCarMcuEventCallback = new CarMcuManager.CarMcuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.6
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int intValue;
            int intValue2;
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            if (propertyId == 557847561) {
                if (L.ENABLE) {
                    L.Tag tag = XpCarService.TAG;
                    L.d(tag, "onChangeEvent CarMcuManager.ID_MCU_IG_STATUS propertyValue:" + value);
                }
                if (!(value instanceof Integer) || XpCarService.this.mIgStatus == (intValue = ((Integer) value).intValue())) {
                    return;
                }
                XpCarService.this.mIgStatus = intValue;
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(3, Integer.valueOf(XpCarService.this.mIgStatus));
                L.Tag tag2 = XpCarService.TAG;
                L.i(tag2, "onChangeEvent mIgStatus:" + XpCarService.this.mIgStatus);
            } else if (propertyId == 557847658 && (value instanceof Integer) && XpCarService.this.mFactoryMode != (intValue2 = ((Integer) value).intValue())) {
                XpCarService.this.mFactoryMode = intValue2;
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(51, Integer.valueOf(XpCarService.this.mFactoryMode));
                L.Tag tag3 = XpCarService.TAG;
                L.i(tag3, "onChangeEvent mFactoryMode:" + XpCarService.this.mFactoryMode);
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i != 557847561) {
                if (i == 557847658 && -1 != XpCarService.this.mFactoryMode) {
                    XpCarService.this.mFactoryMode = -1;
                    L.e(XpCarService.TAG, "CarMcuManager.ID_MCU_FACTORY_MODE onErrorEvent");
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(51, Integer.valueOf(XpCarService.this.mFactoryMode));
                }
            } else if (-1 != XpCarService.this.mIgStatus) {
                XpCarService.this.mIgStatus = -1;
                L.e(XpCarService.TAG, "CarMcuManager.ID_MCU_IG_STATUS onErrorEvent");
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(-1, Integer.valueOf(XpCarService.this.mIgStatus));
            }
        }
    };
    private final CarImuManager.CarImuEventCallback mCarImuEventCallback = new CarImuManager.CarImuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.7
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            int i = 0;
            if (propertyId == 560018945) {
                if (value instanceof Float[]) {
                    Object[] objArr = (Object[]) value;
                    if (objArr == null || objArr.length != 35) {
                        L.Tag tag = XpCarService.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("error imu sysst value = ");
                        sb.append(objArr != null ? Integer.valueOf(objArr.length) : null);
                        L.w(tag, sb.toString());
                        return;
                    }
                    float[] fArr = new float[objArr.length];
                    while (i < objArr.length) {
                        Object obj = objArr[i];
                        if (obj instanceof Float) {
                            fArr[i] = ((Float) obj).floatValue();
                        }
                        i++;
                    }
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(9, fArr);
                    if (RootUtil.sIsDrTestMode) {
                        StatisticDataUtil.updateDRImuSensorInputTime();
                    }
                }
            } else if (propertyId != 560018953) {
                switch (propertyId) {
                    case 560018957:
                        if (value instanceof Float[]) {
                            Object[] objArr2 = (Object[]) value;
                            if (objArr2 == null || objArr2.length != 37) {
                                L.Tag tag2 = XpCarService.TAG;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("error ID_IMU_SCULOCAT_CARSPEED = ");
                                sb2.append(objArr2 != null ? Integer.valueOf(objArr2.length) : null);
                                L.w(tag2, sb2.toString());
                                return;
                            }
                            float[] fArr2 = new float[objArr2.length];
                            while (i < objArr2.length) {
                                Object obj2 = objArr2[i];
                                if (obj2 instanceof Float) {
                                    fArr2[i] = ((Float) obj2).floatValue();
                                }
                                i++;
                            }
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(9, fArr2);
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(8, Float.valueOf(fArr2[35]));
                            XpCarService.this.updateRawCarSpeed(fArr2[36]);
                            if (RootUtil.sIsDrTestMode) {
                                StatisticDataUtil.updateDRImuSensorInputTime();
                                StatisticDataUtil.updateDRScuSpeedInputTime();
                                StatisticDataUtil.updateDREspSpeedInputTime();
                                return;
                            }
                            return;
                        }
                        return;
                    case 560018958:
                        if (value instanceof Float[]) {
                            Object[] objArr3 = (Object[]) value;
                            if (objArr3 == null || objArr3.length != 8) {
                                L.Tag tag3 = XpCarService.TAG;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("error ID_IMU_SYSST_CAN value = ");
                                sb3.append(objArr3 != null ? Integer.valueOf(objArr3.length) : null);
                                L.w(tag3, sb3.toString());
                                return;
                            }
                            float[] fArr3 = new float[objArr3.length];
                            while (i < objArr3.length) {
                                Object obj3 = objArr3[i];
                                if (obj3 instanceof Float) {
                                    fArr3[i] = ((Float) obj3).floatValue();
                                }
                                i++;
                            }
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(49, fArr3);
                            if (RootUtil.sIsDrTestMode) {
                                StatisticDataUtil.updateDRImuSensorInputTime();
                                return;
                            }
                            return;
                        }
                        return;
                    case 560018959:
                        if (value instanceof Float[]) {
                            Object[] objArr4 = (Object[]) value;
                            if (objArr4 == null || objArr4.length != 10) {
                                L.Tag tag4 = XpCarService.TAG;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("error ID_IMU_SCULOCAT_CARSPEED_CAN value = ");
                                sb4.append(objArr4 != null ? Integer.valueOf(objArr4.length) : null);
                                L.w(tag4, sb4.toString());
                                return;
                            }
                            float[] fArr4 = new float[objArr4.length];
                            while (i < objArr4.length) {
                                Object obj4 = objArr4[i];
                                if (obj4 instanceof Float) {
                                    fArr4[i] = ((Float) obj4).floatValue();
                                }
                                i++;
                            }
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(47, fArr4);
                            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(8, Float.valueOf(fArr4[8]));
                            XpCarService.this.updateRawCarSpeed(fArr4[9]);
                            if (RootUtil.sIsDrTestMode) {
                                StatisticDataUtil.updateDRImuSensorInputTime();
                                StatisticDataUtil.updateDRScuSpeedInputTime();
                                StatisticDataUtil.updateDREspSpeedInputTime();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i == 560018953) {
                L.e(XpCarService.TAG, "CarImuManager.ID_IMU_NAVDATA onErrorEvent");
            } else if (i != 560018957) {
            } else {
                L.e(XpCarService.TAG, "CarImuManager.ID_IMU_SCULOCAT_CARSPEED onErrorEvent");
            }
        }
    };
    private final CarXpuManager.CarXpuEventCallback mCarXpuEventCallback = new CarXpuManager.CarXpuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.8
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            if (propertyId == 557856775) {
                if (value instanceof Integer) {
                    int intValue = ((Integer) value).intValue();
                    XpCarService.this.mNedcSwitchStatus = intValue;
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(17, Integer.valueOf(XpCarService.this.mNedcSwitchStatus));
                    L.Tag tag = XpCarService.TAG;
                    L.i(tag, "onChangeEvent XPU_NEDC_STATUS_CHANGE_EVENT:" + intValue);
                }
            } else if (propertyId != 561002576) {
            } else {
                try {
                    long navigationId = CarXpuManager.getNaviConfirmProto((byte[]) value).getNavigationId();
                    L.Tag tag2 = XpCarService.TAG;
                    L.i(tag2, "ID_XPU_NAVI_CONFIRM_PROTO id :" + navigationId);
                    if (navigationId != 1) {
                        return;
                    }
                    if (XpCarService.this.mLastNaviPathId == -1) {
                        L.i(XpCarService.TAG, "ID_XPU_NAVI_CONFIRM_PROTO NaviPathId is  -1:");
                    } else {
                        XpCarService.this.setNaviRoutingInfoRequestAsyn(XpuProtoMessage.NaviStatus.NAVI_STATUS_START, XpCarService.this.mLastNaviPathId);
                    }
                } catch (Throwable th) {
                    L.Tag tag3 = XpCarService.TAG;
                    L.e(tag3, "getNaviConfirmProto is not ready:" + th.getMessage());
                }
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i != 557856775) {
                return;
            }
            L.e(XpCarService.TAG, "CarXpuManager.ID_XPU_NEDC_STATUS onErrorEvent");
            XpCarService.this.mNedcSwitchStatus = -1;
            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(17, Integer.valueOf(XpCarService.this.mNedcSwitchStatus));
        }
    };
    private final CarVcuManager.CarVcuEventCallback mCarVcuEventCallback = new CarVcuManager.CarVcuEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.9
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            switch (propertyId) {
                case 557847042:
                    if (!(value instanceof Integer) || XpCarService.this.mRemainPercent == (intValue = ((Integer) value).intValue())) {
                        return;
                    }
                    XpCarService.this.mRemainPercent = intValue;
                    return;
                case 557847045:
                    if (!(value instanceof Integer) || XpCarService.this.mGearLevel == (intValue2 = ((Integer) value).intValue())) {
                        return;
                    }
                    XpCarService.this.mGearLevel = intValue2;
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(2, Integer.valueOf(XpCarService.this.mGearLevel));
                    return;
                case 557847057:
                    if (!(value instanceof Integer) || XpCarService.this.getEnduranceMileageMode() != 0 || XpCarService.this.mNedcRemainDistance == (intValue3 = ((Integer) value).intValue()) || intValue3 == 1023) {
                        return;
                    }
                    XpCarService.this.mNedcRemainDistance = intValue3;
                    CarServiceHelper carServiceHelper = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService = XpCarService.this;
                    carServiceHelper.notifyCarStateChanged(15, Integer.valueOf(xpCarService.getCarRemainDistanceWithoutInvalid(xpCarService.mNedcRemainDistance)));
                    return;
                case 557847127:
                    if (!(value instanceof Integer) || XpCarService.this.mEnduranceMileageMode == (intValue4 = ((Integer) value).intValue())) {
                        return;
                    }
                    L.Tag tag = XpCarService.TAG;
                    L.i(tag, "onChangeEvent mode:" + intValue4);
                    XpCarService.this.mEnduranceMileageMode = intValue4;
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(16, Integer.valueOf(XpCarService.this.mEnduranceMileageMode));
                    return;
                case 557847128:
                    if (!(value instanceof Integer) || 1 != XpCarService.this.getEnduranceMileageMode() || XpCarService.this.mWltpRemainDistance == (intValue5 = ((Integer) value).intValue()) || intValue5 == 1023) {
                        return;
                    }
                    XpCarService.this.mWltpRemainDistance = intValue5;
                    CarServiceHelper carServiceHelper2 = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService2 = XpCarService.this;
                    carServiceHelper2.notifyCarStateChanged(15, Integer.valueOf(xpCarService2.getCarRemainDistanceWithoutInvalid(xpCarService2.mWltpRemainDistance)));
                    return;
                case 557847140:
                    if (!(value instanceof Integer) || 2 != XpCarService.this.getEnduranceMileageMode() || XpCarService.this.mCltcRemainDistance == (intValue6 = ((Integer) value).intValue()) || intValue6 == 1023) {
                        return;
                    }
                    XpCarService.this.mCltcRemainDistance = intValue6;
                    CarServiceHelper carServiceHelper3 = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService3 = XpCarService.this;
                    carServiceHelper3.notifyCarStateChanged(15, Integer.valueOf(xpCarService3.getCarRemainDistanceWithoutInvalid(xpCarService3.mCltcRemainDistance)));
                    return;
                case 557847151:
                    L.i(XpCarService.TAG, "ID_VCU_NAVI_DEST_INFO_REQ");
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(50, null);
                    return;
                case 559944229:
                    if (value instanceof Float) {
                        XpCarService.this.updateRawCarSpeed(((Float) value).floatValue());
                        if (RootUtil.sIsDrTestMode) {
                            StatisticDataUtil.updateDREspSpeedInputTime();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onErrorEvent(int i, int i2) {
            switch (i) {
                case 557847042:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_ELECTRICIT_PERCENT onErrorEvent");
                    XpCarService.this.mRemainPercent = -1;
                    return;
                case 557847045:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_GEAR_LEVEL onErrorEvent");
                    if (XpCarService.this.mGearLevel != 0) {
                        XpCarService.this.mGearLevel = 0;
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(2, Integer.valueOf(XpCarService.this.mGearLevel));
                        return;
                    }
                    return;
                case 557847057:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_MILEAGE_NUMBER onErrorEvent");
                    if (1023 == XpCarService.this.mNedcRemainDistance || XpCarService.this.getEnduranceMileageMode() != 0) {
                        return;
                    }
                    XpCarService.this.mNedcRemainDistance = 1023;
                    CarServiceHelper carServiceHelper = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService = XpCarService.this;
                    carServiceHelper.notifyCarStateChanged(15, Integer.valueOf(xpCarService.getCarRemainDistanceWithoutInvalid(xpCarService.mNedcRemainDistance)));
                    return;
                case 557847127:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_RANDIS_MODE onErrorEvent");
                    if (-1 != XpCarService.this.mEnduranceMileageMode) {
                        XpCarService.this.mEnduranceMileageMode = -1;
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(16, Integer.valueOf(XpCarService.this.mEnduranceMileageMode));
                        return;
                    }
                    return;
                case 557847128:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_WLTP_AVAILABLE_MILEAGE onErrorEvent");
                    if (1023 == XpCarService.this.mWltpRemainDistance || 1 != XpCarService.this.getEnduranceMileageMode()) {
                        return;
                    }
                    XpCarService.this.mWltpRemainDistance = 1023;
                    CarServiceHelper carServiceHelper2 = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService2 = XpCarService.this;
                    carServiceHelper2.notifyCarStateChanged(15, Integer.valueOf(xpCarService2.getCarRemainDistanceWithoutInvalid(xpCarService2.mWltpRemainDistance)));
                    return;
                case 557847140:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_DSTBAT_DISP_CLTC onErrorEvent");
                    if (1023 == XpCarService.this.mCltcRemainDistance || 2 != XpCarService.this.getEnduranceMileageMode()) {
                        return;
                    }
                    XpCarService.this.mCltcRemainDistance = 1023;
                    CarServiceHelper carServiceHelper3 = XpCarService.this.mCarServiceHelper;
                    XpCarService xpCarService3 = XpCarService.this;
                    carServiceHelper3.notifyCarStateChanged(15, Integer.valueOf(xpCarService3.getCarRemainDistanceWithoutInvalid(xpCarService3.mCltcRemainDistance)));
                    return;
                case 557847151:
                    L.e(XpCarService.TAG, "ID_VCU_NAVI_DEST_INFO_REQ onErrorEvent");
                    return;
                case 559944229:
                    L.e(XpCarService.TAG, "CarVcuManager.ID_VCU_RAW_CAR_SPEED onErrorEvent");
                    if (Float.compare(XpCarService.INVALID_SPEED_VALUE.floatValue(), XpCarService.this.mEspCarSpeed) != 0) {
                        XpCarService.this.mEspCarSpeed = XpCarService.INVALID_SPEED_VALUE.floatValue();
                        XpCarService.this.mCarServiceHelper.notifyCarStateChanged(1, XpCarService.DEFAULT_SPEED_VALUE);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final CarIcmManager.CarIcmEventCallback mCarIcmEventCallback = new CarIcmManager.CarIcmEventCallback() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.10
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            int propertyId = carPropertyValue.getPropertyId();
            Object value = carPropertyValue.getValue();
            if (propertyId == 554702405) {
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(6, value);
            } else if (propertyId != 557848078) {
            } else {
                XpCarService.this.mIsIcmConnected = true;
                if (value instanceof Integer) {
                    int intValue = ((Integer) value).intValue();
                    L.Tag tag = XpCarService.TAG;
                    L.i(tag, "ID_ICM_CONNECTED:" + intValue);
                    if (1 == intValue) {
                        XpCarService.this.mIsIcmConnected = true;
                    } else if (intValue == 0) {
                        XpCarService.this.mIsIcmConnected = false;
                    }
                }
                XpCarService.this.mCarServiceHelper.notifyCarStateChanged(4, Boolean.valueOf(XpCarService.this.mIsIcmConnected));
                try {
                    XpCarService.this.mCarServiceHelper.notifyCarStateChanged(6, XpCarService.this.mCarIcmManager.getNaviBmpInfoRequiredByIcm());
                } catch (Exception | NoSuchMethodError unused) {
                    L.e(XpCarService.TAG, "can not getNaviBmpInfoRequiredByIcm");
                }
            }
        }

        public void onErrorEvent(int i, int i2) {
            if (i != 557848078) {
                return;
            }
            XpCarService.this.mIsIcmConnected = false;
            L.e(XpCarService.TAG, "CarIcmManager.ID_ICM_CONNECTED onErrorEvent");
            XpCarService.this.mCarServiceHelper.notifyCarStateChanged(4, Boolean.valueOf(XpCarService.this.mIsIcmConnected));
        }
    };
    private final Handler mXPUServiceHandler = new Handler(WorkThreadUtil.getInstance().getXPUServiceThread());
    private volatile int mSetV2Count = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public int getCarRemainDistanceWithoutInvalid(int i) {
        if (1023 == i) {
            return 0;
        }
        return i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAccOnByStatus(int i) {
        return 3 == i || 5 == i || 6 == i || 7 == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHvacPowerOn(int i) {
        return i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLccOnByXPilotStatus(int i) {
        return 4 == i || 5 == i || 10 == i || 11 == i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getHardwareVersion() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setFakeData(String str, String str2) {
    }

    public void setLocationInfo(float f, float f2, float f3, float f4, float f5, long j) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setWeatherInfo(byte[] bArr) {
    }

    static /* synthetic */ int access$5008(XpCarService xpCarService) {
        int i = xpCarService.mSetV2Count;
        xpCarService.mSetV2Count = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTboxEvent(CarPropertyValue carPropertyValue) {
        if (carPropertyValue == null || carPropertyValue.getValue() == null || carPropertyValue.getPropertyId() != 554700817) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(carPropertyValue.getValue().toString());
            int i = jSONObject.getInt("apn1");
            int i2 = jSONObject.getInt("apn2");
            int i3 = jSONObject.getInt("apn3");
            boolean z = true;
            if (1 != i && 1 != i2) {
                z = false;
            }
            if (this.mIsApnConnected != z) {
                this.mIsApnConnected = z;
                this.mCarServiceHelper.notifyCarStateChanged(11, Boolean.valueOf(z));
                L.Tag tag = TAG;
                L.i(tag, "apn status change:" + i + i2 + i3);
            }
        } catch (Exception e) {
            L.Tag tag2 = TAG;
            L.w(tag2, "handleTboxEvent ID_TBOX_CDU_APN e=" + e);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isApnConnected() {
        return this.mIsApnConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTboxCarManager() {
        try {
            this.mCarTboxManager = (CarTboxManager) this.mCarApiClient.getCarManager("xp_tbox");
            this.mCarTboxManager.registerPropCallback(TBOX_IDS, this.mCarTboxCallback);
            if (this.mValidTboxIds.isEmpty()) {
                for (Integer num : TBOX_IDS) {
                    if (this.mCarTboxManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidTboxIds.add(num);
                    }
                }
            }
            this.mCarTboxManager.getSimStatusAsync();
            this.mCarTboxManager.requestTboxModemStatus();
        } catch (Exception e) {
            L.Tag tag = TAG;
            L.e(tag, "initTboxManager e=" + e);
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "init TboxCarManager done:" + this.mValidTboxIds.size());
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void init() {
        Car car = this.mCarApiClient;
        if (car != null && car.isConnected()) {
            L.w(TAG, "has connected to car service skip");
        }
        L.i(TAG, "init start");
        this.mCarServiceHelper = new CarServiceHelper();
        this.mCarApiClient = Car.createCar(ContextUtils.getContext(), new ServiceConnection() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.11
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                L.i(XpCarService.TAG, "onServiceConnected");
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        XpCarService.this.initBcmCarManager();
                        XpCarService.this.initVcuCarManager();
                        XpCarService.this.initScuCarManager();
                        XpCarService.this.initMcuCarManager();
                        XpCarService.this.initHvacCarManager();
                        XpCarService.this.initIcmCarManager();
                        XpCarService.this.initImuCarManager();
                        XpCarService.this.initTboxCarManager();
                        XpCarService.this.initXpuCarManager();
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                L.i(XpCarService.TAG, "onServiceDisconnected");
                XpCarService.this.release();
            }
        }, new Handler(WorkThreadUtil.getInstance().getCarServiceThreadLooper()));
        this.mCarApiClient.connect();
        L.i(TAG, "init end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initIcmCarManager() {
        try {
            this.mCarIcmManager = (CarIcmManager) this.mCarApiClient.getCarManager("xp_icm");
            if (this.mValidIcmIds.isEmpty()) {
                for (Integer num : ICM_IDS) {
                    if (this.mCarIcmManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidIcmIds.add(num);
                    }
                }
            }
            this.mCarIcmManager.registerPropCallback(ICM_IDS, this.mCarIcmEventCallback);
            if (getIcmConnectionState()) {
                this.mCarServiceHelper.notifyCarStateChanged(6, this.mCarIcmManager.getNaviBmpInfoRequiredByIcm());
            }
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarIcmManager");
        } catch (Exception | NoSuchMethodError unused2) {
            L.e(TAG, "Can not getNaviBmpInfoRequiredByIcm");
        }
        L.Tag tag = TAG;
        L.i(tag, "init CarIcmManager done:" + this.mValidIcmIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImuCarManager() {
        try {
            this.mCarImuManager = (CarImuManager) this.mCarApiClient.getCarManager("xp_imu");
            if (CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                if (this.mCarImuManager.isPropertySupportedOrDefault(560018959, false)) {
                    sImuIds.add(560018959);
                    L.i(TAG, "add ID_IMU_SCULOCAT_CARSPEED_CAN");
                } else {
                    sImuIds.add(560018957);
                    L.i(TAG, "add ID_IMU_SCULOCAT_CARSPEED");
                }
            } else if (this.mCarImuManager.isPropertySupportedOrDefault(560018958, false)) {
                sImuIds.add(560018958);
                L.i(TAG, "add ID_IMU_SYSST_CAN");
            } else {
                L.w(TAG, "ID_IMU_SYSST_CAN is not supported");
            }
            this.mCarImuManager.registerPropCallback(sImuIds, this.mCarImuEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarImuManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init ImuCarManager done:" + sImuIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initXpuCarManager() {
        try {
            this.mCarXpuManager = (CarXpuManager) this.mCarApiClient.getCarManager("xp_xpu");
            if (this.mValidXpuIds.isEmpty()) {
                for (Integer num : XPU_IDS) {
                    if (this.mCarXpuManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidXpuIds.add(num);
                    }
                }
            }
            this.mCarXpuManager.registerPropCallback(XPU_IDS, this.mCarXpuEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarXpuManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init XpuCarManager done:" + this.mValidXpuIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHvacCarManager() {
        try {
            this.mCarHvacManager = (CarHvacManager) this.mCarApiClient.getCarManager(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_HVAC);
            if (this.mValidHvacIds.isEmpty()) {
                for (Integer num : HVAC_IDS) {
                    if (this.mCarHvacManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidHvacIds.add(num);
                    }
                }
            }
            this.mCarHvacManager.registerPropCallback(HVAC_IDS, this.mCarHvacEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarHvacManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init CarHvacManager done:" + this.mValidHvacIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMcuCarManager() {
        try {
            this.mCarMcuManager = (CarMcuManager) this.mCarApiClient.getCarManager("xp_mcu");
            if (this.mValidMcuIds.isEmpty()) {
                for (Integer num : MCU_IDS) {
                    if (this.mCarMcuManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidMcuIds.add(num);
                    }
                }
            }
            this.mCarMcuManager.registerPropCallback(MCU_IDS, this.mCarMcuEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarMcuManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init McuCarManager done:" + this.mValidMcuIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initScuCarManager() {
        try {
            this.mCarScuManager = (CarScuManager) this.mCarApiClient.getCarManager("xp_scu");
            if (!CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                sScuIds.add(560014911);
                if (L.ENABLE) {
                    L.d(TAG, "add ID_SCU_LOCAT_DATA");
                }
            }
            if (this.mValidScuIds.isEmpty()) {
                for (Integer num : sScuIds) {
                    if (this.mCarScuManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidScuIds.add(num);
                    }
                }
            }
            this.mCarScuManager.registerPropCallback(sScuIds, this.mCarScuEventCallback);
            initScuManagerState();
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarScuManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init ScuCarManager done:" + this.mValidScuIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVcuCarManager() {
        try {
            this.mCarVcuManager = (CarVcuManager) this.mCarApiClient.getCarManager("xp_vcu");
            if (!CarFeatureManager.INSTANCE.isAutoPolitIMUEnable()) {
                L.i(TAG, "add ID_VCU_RAW_CAR_SPEED");
                sVcuIds.add(559944229);
            }
            if (CarFeatureManager.INSTANCE.isBatteryPreHeatEnable()) {
                L.i(TAG, "add Battery PreHeat signal");
                sVcuIds.add(554701424);
                sVcuIds.add(557847151);
                sVcuIds.add(557847153);
                sVcuIds.add(557847154);
                sVcuIds.add(557847158);
                sVcuIds.add(557847155);
                sVcuIds.add(557847156);
                sVcuIds.add(559944309);
            }
            if (this.mValidVcuIds.isEmpty()) {
                for (Integer num : sVcuIds) {
                    if (this.mCarVcuManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidVcuIds.add(num);
                    }
                }
            }
            this.mCarVcuManager.registerPropCallback(sVcuIds, this.mCarVcuEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarVcuManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init VcuCarManager done:" + this.mValidVcuIds.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBcmCarManager() {
        try {
            this.mCarBcmManager = (CarBcmManager) this.mCarApiClient.getCarManager("xp_bcm");
            if (this.mValidBcmIds.isEmpty()) {
                for (Integer num : BCM_IDS) {
                    if (this.mCarBcmManager.isPropertySupportedOrDefault(num.intValue(), false)) {
                        this.mValidBcmIds.add(num);
                    }
                }
            }
            this.mCarBcmManager.registerPropCallback(BCM_IDS, this.mCarBcmEventCallback);
        } catch (CarNotConnectedException unused) {
            L.e(TAG, "Can not get CarBcmManager");
        }
        L.Tag tag = TAG;
        L.i(tag, "init BcmCarManager done:" + this.mValidBcmIds.size());
    }

    private void initScuManagerState() {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                this.mNGPStatus = carScuManager.getXpilot3St();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "mNGPStatus = " + this.mNGPStatus);
                }
            } catch (Exception e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "get mNGPStatus error " + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void release() {
        if (this.mCarBcmManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarBcmManager.unregisterCallback;");
            }
            try {
                this.mCarBcmManager.unregisterPropCallback(BCM_IDS, this.mCarBcmEventCallback);
            } catch (CarNotConnectedException e) {
                e.printStackTrace();
            }
        }
        if (this.mCarVcuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarVcuManager.unregisterCallback;");
            }
            try {
                this.mCarVcuManager.unregisterPropCallback(sVcuIds, this.mCarVcuEventCallback);
            } catch (CarNotConnectedException e2) {
                e2.printStackTrace();
            }
        }
        if (this.mCarScuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarScuManager.unregisterCallback;");
            }
            try {
                this.mCarScuManager.unregisterPropCallback(sScuIds, this.mCarScuEventCallback);
            } catch (CarNotConnectedException e3) {
                e3.printStackTrace();
            }
        }
        if (this.mCarHvacManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarHvacManager.unregisterCallback");
            }
            try {
                this.mCarHvacManager.unregisterPropCallback(HVAC_IDS, this.mCarHvacEventCallback);
            } catch (CarNotConnectedException e4) {
                e4.printStackTrace();
            }
        }
        if (this.mCarMcuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarHvacManager.unregisterCallback");
            }
            try {
                this.mCarMcuManager.unregisterPropCallback(MCU_IDS, this.mCarMcuEventCallback);
            } catch (CarNotConnectedException e5) {
                e5.printStackTrace();
            }
        }
        if (this.mCarIcmManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarHvacManager.unregisterCallback");
            }
            try {
                this.mCarIcmManager.unregisterPropCallback(ICM_IDS, this.mCarIcmEventCallback);
            } catch (CarNotConnectedException e6) {
                e6.printStackTrace();
            }
        }
        if (this.mCarImuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarImuManager.unregisterCallback");
            }
            try {
                this.mCarImuManager.unregisterPropCallback(sImuIds, this.mCarImuEventCallback);
                this.mIsIcmConnected = false;
            } catch (CarNotConnectedException e7) {
                e7.printStackTrace();
            }
        }
        if (this.mCarTboxManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarTboxManager.unregisterCallback");
            }
            try {
                this.mCarTboxManager.unregisterPropCallback(TBOX_IDS, this.mCarTboxCallback);
            } catch (CarNotConnectedException e8) {
                e8.printStackTrace();
            }
        }
        if (this.mCarXpuManager != null) {
            if (L.ENABLE) {
                L.d(TAG, "CarXpuManager.unregisterCallback");
            }
            try {
                this.mCarXpuManager.unregisterPropCallback(XPU_IDS, this.mCarXpuEventCallback);
            } catch (CarNotConnectedException e9) {
                e9.printStackTrace();
            }
        }
        Car car = this.mCarApiClient;
        if (car != null) {
            car.disconnect();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isCarServiceAvailable() {
        return this.mIsCarServiceAvailable;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarNedcRemainDistance() {
        CarVcuManager carVcuManager;
        if (this.mNedcRemainDistance == 1023 && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mNedcRemainDistance = carVcuManager.getAvalibleDrivingDistance();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getCarNedcRemainDistance :" + this.mNedcRemainDistance);
                }
            } catch (Exception | NoSuchMethodError unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
        return getCarRemainDistanceWithoutInvalid(this.mNedcRemainDistance);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarWltpRemainDistance() {
        CarVcuManager carVcuManager;
        if (this.mWltpRemainDistance == 1023 && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mWltpRemainDistance = carVcuManager.getWltpAvailableDrivingDistance();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getCarWltpRemainDistance :" + this.mWltpRemainDistance);
                }
            } catch (Exception | NoSuchMethodError unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
        return getCarRemainDistanceWithoutInvalid(this.mWltpRemainDistance);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarCltcRemainDistance() {
        CarVcuManager carVcuManager;
        if (this.mCltcRemainDistance == 1023 && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mCltcRemainDistance = carVcuManager.getCltcAvailableDrivingDistance();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getCarCltcRemainDistance :" + this.mCltcRemainDistance);
                }
            } catch (Exception | NoSuchMethodError unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
        return getCarRemainDistanceWithoutInvalid(this.mCltcRemainDistance);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setEnduranceMileageMode(int i) {
        if (!this.mValidVcuIds.contains(557847127) || (i != 0 && 1 != i && 2 != i)) {
            L.Tag tag = TAG;
            L.w(tag, "setEnduranceMileageMode mode error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setEnduranceMileageMode(i);
                L.Tag tag2 = TAG;
                L.i(tag2, "setEnduranceMileageMode :" + i);
                this.mEnduranceMileageMode = i;
            } catch (Exception | NoSuchMethodError unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getEnduranceMileageMode() {
        if (this.mEnduranceMileageMode == -1 && this.mCarVcuManager != null && this.mValidVcuIds.contains(557847127)) {
            try {
                this.mEnduranceMileageMode = this.mCarVcuManager.getEnduranceMileageMode();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getEnduranceMileageMode :" + this.mEnduranceMileageMode);
                }
            } catch (Exception | NoSuchMethodError unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
        int i = this.mEnduranceMileageMode;
        if (-1 == i) {
            return 0;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getBatteryPercent() {
        CarVcuManager carVcuManager;
        if (this.mRemainPercent == -1 && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mRemainPercent = carVcuManager.getElectricityPercent();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getBatteryPercent :" + this.mRemainPercent);
                }
            } catch (Exception | NoSuchMethodError e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getBatteryPercent is not ready:" + e.getMessage());
            }
        }
        int i = this.mRemainPercent;
        if (i == -1) {
            return 0.0f;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getCarSpeed() {
        return getRawCarSpeed();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getRawCarSpeed() {
        CarVcuManager carVcuManager;
        if (INVALID_SPEED_VALUE.equals(Float.valueOf(this.mEspCarSpeed)) && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mEspCarSpeed = carVcuManager.getRawCarSpeed();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getRawCarSpeed " + this.mEspCarSpeed);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                this.mEspCarSpeed = INVALID_SPEED_VALUE.floatValue();
                L.Tag tag2 = TAG;
                L.e(tag2, "getRawCarSpeed is not ready:" + e.getMessage());
            }
        }
        return INVALID_SPEED_VALUE.equals(Float.valueOf(this.mEspCarSpeed)) ? DEFAULT_SPEED_VALUE.floatValue() : this.mEspCarSpeed;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDestInfo(String str) {
        if (!this.mValidVcuIds.contains(554701424)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviDestInfo error:" + str);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviDestInfo(str);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviDestInfo" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDestType(int i) {
        if (!this.mValidVcuIds.contains(557847153)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviDestType error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviDestType(i);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviDestType" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRemainDistance(int i) {
        if (!this.mValidVcuIds.contains(557847154)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviRemainDistance error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviRemainDistance(i);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviRemainDistance" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRemainTime(int i) {
        if (!this.mValidVcuIds.contains(557847158)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviRemainTime error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviRemainTime(i);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviRemainTime" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviPathId(int i) {
        if (!this.mValidVcuIds.contains(557847155)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviPathId error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviPathId(i);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviPathId" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviType(int i) {
        if (!this.mValidVcuIds.contains(557847156)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviType error:" + i);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviType(i);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviType" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviKValue(float f) {
        if (!this.mValidVcuIds.contains(559944309)) {
            L.Tag tag = TAG;
            L.w(tag, "setNaviKValue error:" + f);
            return;
        }
        CarVcuManager carVcuManager = this.mCarVcuManager;
        if (carVcuManager != null) {
            try {
                carVcuManager.setNaviKValue(f);
            } catch (Exception | NoSuchMethodError e) {
                L.Tag tag2 = TAG;
                L.w(tag2, "setNaviKValue" + e.getMessage());
                this.mIsCarServiceAvailable = false;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setGpsReset(int i) {
        CarTboxManager carTboxManager = this.mCarTboxManager;
        if (carTboxManager != null) {
            try {
                carTboxManager.setGpsReset(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setGpsReset, the data " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setGpsReset is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getDriveSeatState() {
        CarBcmManager carBcmManager;
        if (this.mDriverSeatOccupied == -1 && (carBcmManager = this.mCarBcmManager) != null) {
            try {
                this.mDriverSeatOccupied = carBcmManager.getDriverOnSeat();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getDriveSeatState " + this.mDriverSeatOccupied);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getDriveSeatState is not ready:" + e.getMessage());
            }
        }
        int i = this.mDriverSeatOccupied;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getFarLampState() {
        CarBcmManager carBcmManager;
        if (this.mFarLampState == -1 && (carBcmManager = this.mCarBcmManager) != null) {
            try {
                this.mFarLampState = carBcmManager.getFarLampState();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getFarLampState " + this.mFarLampState);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getFarLampState is not ready:" + e.getMessage());
            }
        }
        int i = this.mFarLampState;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getNearLampState() {
        CarBcmManager carBcmManager;
        if (this.mNearLampState == -1 && (carBcmManager = this.mCarBcmManager) != null) {
            try {
                this.mNearLampState = carBcmManager.getNearLampState();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getNearLampState " + this.mNearLampState);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getNearLampState is not ready:" + e.getMessage());
            }
        }
        int i = this.mNearLampState;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getGearLevel() {
        CarVcuManager carVcuManager;
        if (this.mGearLevel == 0 && (carVcuManager = this.mCarVcuManager) != null) {
            try {
                this.mGearLevel = carVcuManager.getDisplayGearLevel();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getGearLever " + this.mGearLevel);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getGearLever is not ready:" + e.getMessage());
            }
        }
        return this.mGearLevel;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isAccOnByStatus() {
        CarScuManager carScuManager;
        if (this.mAccStatus == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mAccStatus = carScuManager.getAccStatus();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getAccStatus mAccStatus = " + this.mAccStatus);
                }
            } catch (Exception unused) {
                L.e(TAG, "getAccStatus error");
            }
        }
        return isAccOnByStatus(this.mAccStatus);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isLccOnByXPilotStatus() {
        CarScuManager carScuManager;
        if (this.mXPilotStatus == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mXPilotStatus = carScuManager.getXpilotStatus();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "XPilotStatus = " + this.mXPilotStatus);
                }
            } catch (Exception unused) {
                L.e(TAG, "get XPilotStatus error");
            }
        }
        return isLccOnByXPilotStatus(this.mXPilotStatus);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuModeIndex() {
        CarScuManager carScuManager;
        if (this.mScuModeIndex == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mScuModeIndex = carScuManager.getScuModeIndex();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "ScuModeIndex = " + this.mScuModeIndex);
                }
            } catch (Exception unused) {
                L.e(TAG, "get ScuModeIndex error");
            }
        }
        return this.mScuModeIndex;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isNGPOn() {
        return 1 == this.mNGPStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean getIcmConnectionState() {
        CarIcmManager carIcmManager;
        if (!this.mIsIcmConnected && (carIcmManager = this.mCarIcmManager) != null) {
            try {
                boolean z = true;
                if (carIcmManager.getIcmConnectionState() != 1) {
                    z = false;
                }
                this.mIsIcmConnected = z;
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getIcmConnectionState mIsIcmConnected = " + this.mIsIcmConnected);
                }
            } catch (Exception e) {
                e.printStackTrace();
                L.e(TAG, "getIcmConnectionState error");
            }
        }
        return this.mIsIcmConnected;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setIcmNavigationBmp(byte[] bArr) {
        CarIcmManager carIcmManager = this.mCarIcmManager;
        if (carIcmManager != null) {
            try {
                carIcmManager.setIcmNavigationBmp(bArr);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setIcmNavigationBmp, the data " + bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setIcmNavigationBmp is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean getIcmMapDisplayState() {
        return this.mIcmMapDisplayState;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapWidth() {
        return this.mIcmMapWidth;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapHeight() {
        return this.mIcmMapHeight;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapFps() {
        return this.mIcmMapFps;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapImageType() {
        return this.mIcmMapImageType;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isHVACPowerModeOn() {
        CarHvacManager carHvacManager;
        if (this.mHvacPowerMode == -1 && (carHvacManager = this.mCarHvacManager) != null) {
            try {
                this.mHvacPowerMode = carHvacManager.getHvacPowerMode();
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag = TAG;
                L.e(tag, "getHVACPowerMode is not ready:" + e.getMessage());
            }
        }
        return isHvacPowerOn(this.mHvacPowerMode);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getHardwareCarType() {
        String str = "UNKNOWN";
        try {
            String xpCduType = Car.getXpCduType();
            str = cduType2HardWareType(xpCduType);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "getHardwareCarType, the carCduType is " + xpCduType + " type is:" + str);
            }
        } catch (Exception e) {
            this.mIsCarServiceAvailable = false;
            L.Tag tag2 = TAG;
            L.e(tag2, "carCduType is not ready:" + e.getMessage());
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String cduType2HardWareType(String str) {
        char c;
        int hashCode = str.hashCode();
        switch (hashCode) {
            case 2064:
                if (str.equals("A1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2065:
                if (str.equals("A2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2066:
                if (str.equals("A3")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                switch (hashCode) {
                    case 2560:
                        if (str.equals("Q1")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2561:
                        if (str.equals("Q2")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2562:
                        if (str.equals("Q3")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        switch (hashCode) {
                            case 2564:
                                if (str.equals("Q5")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2565:
                                if (str.equals("Q6")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2566:
                                if (str.equals("Q7")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2567:
                                if (str.equals(ICarService.CDU_TYPE_E28_A)) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                }
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return ICarService.CAR_TYPE_D20;
            case 3:
            case 4:
                return ICarService.CAR_TYPE_D21;
            case 5:
            case 6:
                return ICarService.CAR_TYPE_E28;
            case 7:
                return ICarService.CAR_TYPE_D55;
            case '\b':
                return ICarService.CAR_TYPE_D22;
            case '\t':
                return ICarService.CAR_TYPE_E38;
            default:
                return "UNKNOWN";
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIgStatus() {
        CarMcuManager carMcuManager;
        if (this.mIgStatus == -1 && (carMcuManager = this.mCarMcuManager) != null) {
            try {
                this.mIgStatus = carMcuManager.getIgStatusFromMcu();
            } catch (Exception unused) {
                this.mIsCarServiceAvailable = false;
            }
        }
        return this.mIgStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getFactoryMode() {
        CarMcuManager carMcuManager;
        if (-1 == this.mFactoryMode && (carMcuManager = this.mCarMcuManager) != null) {
            try {
                this.mFactoryMode = carMcuManager.getFactoryModeSwitchStatus();
                L.Tag tag = TAG;
                L.i(tag, "mFactoryMode = " + this.mFactoryMode);
            } catch (Exception e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "get getFactoryMode error:" + e.getMessage());
            }
        }
        return this.mFactoryMode;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getNedcSwitchStatus() {
        CarXpuManager carXpuManager;
        if (ICarService.CAR_TYPE_E28.equals(getHardwareCarType())) {
            if (-1 == this.mNedcSwitchStatus && (carXpuManager = this.mCarXpuManager) != null) {
                try {
                    this.mNedcSwitchStatus = carXpuManager.getNedcSwitchStatus();
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "getNedcSwitchStatus " + this.mNedcSwitchStatus);
                    }
                } catch (Exception e) {
                    this.mIsCarServiceAvailable = false;
                    this.mNedcSwitchStatus = -1;
                    L.Tag tag2 = TAG;
                    L.e(tag2, "getNedcSwitchStaus is not ready:" + e.getMessage());
                }
            }
            return this.mNedcSwitchStatus;
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getXpCduType() {
        String str;
        try {
            str = Car.getXpCduType();
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getXpCduType, the Cdu Type is " + str);
                }
            } catch (Exception e) {
                e = e;
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getXpCduType is not ready:" + e.getMessage());
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "UNKNOWN";
        }
        return str;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getHardwareCarStage() {
        String str;
        try {
            str = Car.getHardwareCarStage();
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getHardwareCarStage, the stage is " + str);
                }
            } catch (Exception e) {
                e = e;
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "getHardwareCarStage is not ready:" + e.getMessage());
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "UNKNOWN";
        }
        return str;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void registerObserver(ICarService.ICarStateListener iCarStateListener) {
        this.mListener = iCarStateListener;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNavigationInfo(byte[] bArr) {
        CarIcmManager carIcmManager = this.mCarIcmManager;
        if (carIcmManager != null) {
            try {
                carIcmManager.setNavigationInfo(bArr);
                if (L.ENABLE) {
                    L.d(TAG, "setNavigationInfo ");
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag = TAG;
                L.e(tag, "setNavigationInfo is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setRoadAttributes(int i, int i2) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setRoadAttributes(i, i2);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setRoadAttributes roadClass = " + i2 + ", ownerShip = " + i);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setRoadAttributes is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void sendNaviLoadLinkType(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.sendNaviLoadLinkType(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "sendNaviLoadLinkType linkType = " + i);
                }
            } catch (Error e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "sendNaviLoadLinkType is error:" + e.getMessage());
            } catch (Exception e2) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag3 = TAG;
                L.e(tag3, "sendNaviLoadLinkType is not ready:" + e2.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRoadConnectAttrib(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setNaviRoadConnectAttrib(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setNaviRoadConnectAttrib formway = " + i);
                }
            } catch (Error e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "setNaviRoadConnectAttrib is error:" + e.getMessage());
            } catch (Exception e2) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag3 = TAG;
                L.e(tag3, "setNaviRoadConnectAttrib is not ready:" + e2.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        L.Tag tag = TAG;
        L.i(tag, "setNaviDangerAreaRDInfo:" + i + "," + i2 + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + i7);
        try {
            this.mCarScuManager.setNaviDangerAreaRDInfo(i, i2, i3, i4, i5, i6, i7);
        } catch (Exception | NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setEventInfoRD(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setEventInfoRD(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setEventInfoRD type = " + i);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setEventInfoRD is not ready:" + e.getMessage());
            } catch (NoSuchMethodError e2) {
                L.Tag tag3 = TAG;
                L.e(tag3, "setEventInfoRD is error:" + e2.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void stopNaviRoutingInfoRequest(long j) {
        try {
            if (this.mLastNaviPathId == j) {
                L.Tag tag = TAG;
                L.i(tag, "stopNaviRoutingInfoRequest currentNaviPathId" + j);
                this.mLastNaviPathId = -1L;
                setNaviRoutingInfoRequestAsyn(XpuProtoMessage.NaviStatus.NAVI_STATUS_FINISH, j);
            } else if (this.mLastNaviPathId != -1) {
                L.Tag tag2 = TAG;
                L.i(tag2, "stopNaviRoutingInfoRequest is not -1. currentNaviPathId" + j);
                this.mLastNaviPathId = -1L;
                setNaviRoutingInfoRequestAsyn(XpuProtoMessage.NaviStatus.NAVI_STATUS_FINISH, j);
            }
        } catch (Throwable th) {
            L.Tag tag3 = TAG;
            L.e(tag3, "stopNaviRoutingInfoRequest is not ready:" + th.getMessage());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void updateNaviPathNaviRoutingInfoRequest(long j) {
        if (this.mLastNaviPathId == j) {
            L.Tag tag = TAG;
            L.i(tag, "updateNaviPathNaviRoutingInfoRequest Same as last time. pathId" + j);
            return;
        }
        this.mLastNaviPathId = j;
        L.Tag tag2 = TAG;
        L.i(tag2, "updateNaviPathNaviRoutingInfoRequest currentNaviPathId :" + j);
        try {
            setNaviRoutingInfoRequestAsyn(XpuProtoMessage.NaviStatus.NAVI_STATUS_START, j);
        } catch (Throwable th) {
            L.Tag tag3 = TAG;
            L.e(tag3, "updateNaviPathNaviRoutingInfoRequest is not ready:" + th.getMessage());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setICarXPUDataCallBack(ICarService.ICarXPUDataCallBack iCarXPUDataCallBack) {
        this.mICarXPUDataCallBack = iCarXPUDataCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNaviRoutingInfoRequestAsyn(final XpuProtoMessage.NaviStatus naviStatus, final long j) {
        WorkThreadUtil.getInstance().removeMessages(this.mXPUServiceHandler, MSG_GET_NAVI_CONFIRM_PROTO);
        WorkThreadUtil.getInstance().removeMessages(this.mXPUServiceHandler, MSG_SET_NAVI_ROUTING_INFO_REQUEST);
        WorkThreadUtil.getInstance().runOnBizThread(this.mXPUServiceHandler, MSG_SET_NAVI_ROUTING_INFO_REQUEST, new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.12
            @Override // java.lang.Runnable
            public void run() {
                XpCarService.this.setNaviRoutingInfoRequest(naviStatus, j);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNaviRoutingInfoRequest(XpuProtoMessage.NaviStatus naviStatus, long j) {
        if (j == -1) {
            L.i(TAG, "setNaviRoutingInfoRequest pathId is null");
            return;
        }
        this.mSetV2Count = 0;
        WorkThreadUtil.getInstance().removeMessages(this.mXPUServiceHandler, MSG_GET_NAVI_CONFIRM_PROTO);
        if (this.mCarXpuManager != null) {
            try {
                ArrayList<XpuProtoMessage.V2_Point> currentRouteAllPoints = this.mICarXPUDataCallBack.getCurrentRouteAllPoints();
                if (CollectionUtils.isEmpty(currentRouteAllPoints)) {
                    L.i(TAG, "setNaviRoutingInfoRequest currentRouteAllPoints is null");
                    return;
                }
                setNaviRoutingInfoRequest(naviStatus, j, currentRouteAllPoints);
                if (L.ENABLE) {
                    L.d(TAG, "setNaviRoutingInfoRequest ");
                }
            } catch (Throwable th) {
                L.Tag tag = TAG;
                L.e(tag, "setNaviRoutingInfoRequest is not ready:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNaviRoutingInfoRequest(final XpuProtoMessage.NaviStatus naviStatus, final long j, final List<XpuProtoMessage.V2_Point> list) {
        try {
            WorkThreadUtil.getInstance().removeMessages(this.mXPUServiceHandler, MSG_GET_NAVI_CONFIRM_PROTO);
            this.mCarXpuManager.setNaviRoutingInfoRequest(naviStatus, j, list);
            WorkThreadUtil.getInstance().runOnBizThread(this.mXPUServiceHandler, MSG_GET_NAVI_CONFIRM_PROTO, new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.XpCarService.13
                @Override // java.lang.Runnable
                public void run() {
                    if (XpCarService.this.mSetV2Count > 2) {
                        L.i(XpCarService.TAG, "Polling has reached 3 times");
                        return;
                    }
                    XpCarService.access$5008(XpCarService.this);
                    L.Tag tag = XpCarService.TAG;
                    L.i(tag, "poll count is :" + XpCarService.this.mSetV2Count + ", navigation_id : " + j);
                    try {
                        if (XpCarService.this.mCarXpuManager.getNaviConfirmProto().getNavigationId() != 1) {
                            return;
                        }
                        XpCarService.this.setNaviRoutingInfoRequest(naviStatus, j, list);
                    } catch (Exception e) {
                        L.Tag tag2 = XpCarService.TAG;
                        L.e(tag2, "getNaviConfirmProto is not ready:" + e.getMessage());
                    }
                }
            }, UILooperObserver.ANR_TRIGGER_TIME);
        } catch (Throwable th) {
            L.Tag tag = TAG;
            L.e(tag, "setNaviRoutingInfoRequest is not ready:" + th.getMessage());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setCurrentRoadSpeedLimit(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setCurrentRoadSpeedLimit(i / 5);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setCurrentRoadSpeedLimit speed = " + i);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setCurrentRoadSpeedLimit is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setCurrentElectronicEyeSpeedLimitAndDistance(int i, int i2) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setCurrentElectronicEyeSpeedLimitAndDistance(i / 5, i2);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setCurrentElectronicEyeSpeedLimitAndDistance speed = " + i + " distance = " + i2);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setCurrentElectronicEyeSpeedLimitAndDistance is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setIntelligentSpeedLimitValue(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setIntelligentSpeedLimitValue(i);
                L.Tag tag = TAG;
                L.i(tag, "setIntelligentSpeedLimitValue speed = " + i);
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setIntelligentSpeedLimitValue is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setDetailRoadClass(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setDetailRoadClass(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setDetailRoadClass detailRoadClass = " + i);
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setDetailRoadClass is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void swtichTBOXGpsLog(boolean z) {
        if (this.mCarTboxManager != null) {
            int i = z ? 1 : 0;
            try {
                L.Tag tag = TAG;
                L.i(tag, "setGpslog, tbox_log_active " + i);
                this.mCarTboxManager.setGpsLogSwitch(i);
            } catch (Exception e) {
                e.printStackTrace();
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "setGpslog is not ready:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isTBOXGpsLogOperSucceed() {
        CarTboxManager carTboxManager = this.mCarTboxManager;
        if (carTboxManager != null) {
            try {
                int toggleGpsLogSwitchResult = carTboxManager.getToggleGpsLogSwitchResult();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "getToggleGpsLogSwitchResult " + toggleGpsLogSwitchResult);
                }
                return toggleGpsLogSwitchResult == 0;
            } catch (Exception e) {
                e.printStackTrace();
                this.mIsCarServiceAvailable = false;
                L.Tag tag2 = TAG;
                L.e(tag2, "isTBOXGpsLogOpen is not ready:" + e.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCruiseSpeed() {
        CarScuManager carScuManager;
        if (this.mCruiseSpeed == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mCruiseSpeed = carScuManager.getDisplayCruiseSpeed();
                L.Tag tag = TAG;
                L.i(tag, "mCruiseSpeed = " + this.mCruiseSpeed);
            } catch (Exception unused) {
                L.e(TAG, "get mCruiseSpeed error");
            }
        }
        return this.mCruiseSpeed;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuQuitNgpOddStatus() {
        CarScuManager carScuManager;
        if (this.mScuQuitNgpOddStatus == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mScuQuitNgpOddStatus = carScuManager.getQuitNgpOddSt();
                L.Tag tag = TAG;
                L.i(tag, "mScuQuitNgpOddStatus = " + this.mScuQuitNgpOddStatus);
            } catch (Exception unused) {
                L.e(TAG, "get mScuQuitNgpOddStatus error");
            }
        }
        return this.mScuQuitNgpOddStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpOpeButtonStatus() {
        CarScuManager carScuManager;
        if (this.mScuNgpOpeButtonStatus == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mScuNgpOpeButtonStatus = carScuManager.getNgpOperationButtonSt();
                L.Tag tag = TAG;
                L.i(tag, "mScuNgpOpeButtonStatus = " + this.mScuNgpOpeButtonStatus);
            } catch (Exception unused) {
                L.e(TAG, "get mScuNgpOpeButtonStatus error");
            }
        }
        return this.mScuNgpOpeButtonStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setScuNgpOpeButtonStatus(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setNgpOperationButton(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setScuNgpOpeButtonStatus status = " + i);
                }
            } catch (Exception e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "setScuNgpOpeButtonStatus error:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpLcTips1Status() {
        CarScuManager carScuManager;
        if (this.mScuNgpLcTips1Status == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mScuNgpLcTips1Status = carScuManager.getNgpLcTips1();
                L.Tag tag = TAG;
                L.i(tag, "mScuNgpLcTips1Status = " + this.mScuNgpLcTips1Status);
            } catch (Exception unused) {
                L.e(TAG, "get mScuNgpLcTips1Status error");
            }
        }
        return this.mScuNgpLcTips1Status;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpInfoTips1Status() {
        CarScuManager carScuManager;
        if (this.mScuNgpInfoTips1Status == -1 && (carScuManager = this.mCarScuManager) != null) {
            try {
                this.mScuNgpInfoTips1Status = carScuManager.getNgpInfoTips1();
                L.Tag tag = TAG;
                L.i(tag, "mScuNgpInfoTips1Status = " + this.mScuNgpInfoTips1Status);
            } catch (Exception unused) {
                L.e(TAG, "get mScuNgpInfoTips1Status error");
            }
        }
        return this.mScuNgpInfoTips1Status;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpTipsWindowStatus() {
        return this.mScuNgpTipsWindowStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setScuNgpTipsWindowStatus(int i) {
        CarScuManager carScuManager = this.mCarScuManager;
        if (carScuManager != null) {
            try {
                carScuManager.setNgpTipsWindowsSw(i);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setScuNgpTipsWindowStatus status = " + i);
                }
            } catch (Exception e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "setScuNgpTipsWindowStatus error:" + e.getMessage());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int sendSrRdCdu2XpuNgpTrajectoryV2Data(byte[] bArr) {
        CarXpuManager carXpuManager = this.mCarXpuManager;
        int i = -1;
        if (carXpuManager != null) {
            try {
                i = carXpuManager.sendSrRdCdu2XpuNgpTrajectoryV2Data(bArr);
                if (L.ENABLE) {
                    L.d(TAG, "sendSrRdCdu2XpuNgpTrajectoryV2Data ");
                }
            } catch (Exception e) {
                this.mIsCarServiceAvailable = false;
                L.Tag tag = TAG;
                L.e(tag, "sendSrRdCdu2XpuNgpTrajectoryV2Data is not ready:" + e.getMessage());
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRawCarSpeed(float f) {
        if (Float.compare(this.mEspCarSpeed, f) != 0) {
            this.mEspCarSpeed = f;
            this.mCarServiceHelper.notifyCarStateChanged(1, Float.valueOf(this.mEspCarSpeed));
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getBcmPowerMode() {
        CarBcmManager carBcmManager;
        if (-1 == this.mBcmPowerMode && (carBcmManager = this.mCarBcmManager) != null) {
            try {
                this.mBcmPowerMode = carBcmManager.getBcmPowerMode();
                L.Tag tag = TAG;
                L.i(tag, "mBcmPowerMode = " + this.mBcmPowerMode);
            } catch (Exception e) {
                L.Tag tag2 = TAG;
                L.e(tag2, "get getBcmPowerMode error:" + e.getMessage());
            }
        }
        return this.mBcmPowerMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class CarServiceHelper {
        private CarServiceHandler mCarServiceHandler = new CarServiceHandler(WorkThreadUtil.getInstance().getCommonCarServiceThreadLooper());

        public CarServiceHelper() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyCarStateChanged(int i, Object obj) {
            Message obtainMessage = this.mCarServiceHandler.obtainMessage();
            obtainMessage.obj = obj;
            obtainMessage.what = i;
            this.mCarServiceHandler.sendMessage(obtainMessage);
        }

        public Handler getHandle() {
            return this.mCarServiceHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class CarServiceHandler extends Handler {
            public CarServiceHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                if (L.ENABLE && 9 != message.what && 49 != message.what && 47 != message.what) {
                    L.Tag tag = XpCarService.TAG;
                    L.d(tag, "CarServiceHandler handleMessage, what:  " + message.what + ", content: " + message.obj);
                }
                switch (message.what) {
                    case 1:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onRawCarSpeedChange(((Float) message.obj).floatValue());
                            XpCarService.this.mListener.onCarSpeedChange(((Float) message.obj).floatValue());
                            return;
                        }
                        return;
                    case 2:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onGearLevelChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 3:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onIgStatusChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 4:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onIcmConnectionStateChange(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 5:
                    case 7:
                    case 12:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onXPolitDriveModeChange();
                            return;
                        }
                        return;
                    case 6:
                        String str = (String) message.obj;
                        L.Tag tag2 = XpCarService.TAG;
                        L.i(tag2, ">>> ICM_NEED_NAVI_EVENT msg = " + str);
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            JsonObject jsonObject = (JsonObject) new JsonParser().parse(str);
                            boolean asBoolean = jsonObject.get("Need").getAsBoolean();
                            int asInt = jsonObject.get("Size-w").getAsInt();
                            int asInt2 = jsonObject.get("Size-h").getAsInt();
                            int asInt3 = jsonObject.get("Fps").getAsInt();
                            int asInt4 = jsonObject.has("Format") ? jsonObject.get("Format").getAsInt() : 2;
                            XpCarService.this.mIcmMapDisplayState = asBoolean;
                            if (XpCarService.this.mListener != null) {
                                XpCarService.this.mListener.onIcmMapDisplayStateChange(XpCarService.this.mIcmMapDisplayState);
                            }
                            if (XpCarService.this.mIcmMapWidth != asInt || XpCarService.this.mIcmMapHeight != asInt2) {
                                XpCarService.this.mIcmMapWidth = asInt;
                                XpCarService.this.mIcmMapHeight = asInt2;
                            }
                            if (XpCarService.this.mListener != null) {
                                XpCarService.this.mListener.onIcmMapSizeChange(XpCarService.this.mIcmMapWidth, XpCarService.this.mIcmMapHeight);
                            }
                            if (XpCarService.this.mIcmMapFps != asInt3) {
                                XpCarService.this.mIcmMapFps = asInt3;
                                if (XpCarService.this.mListener != null) {
                                    XpCarService.this.mListener.onIcmMapFpsChange(XpCarService.this.mIcmMapFps);
                                }
                            }
                            if (XpCarService.this.mIcmMapImageType != asInt4) {
                                XpCarService.this.mIcmMapImageType = asInt4;
                                if (XpCarService.this.mListener != null) {
                                    XpCarService.this.mListener.onIcmMapImageTypeChange(XpCarService.this.mIcmMapImageType);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            L.w(XpCarService.TAG, "ICM_NEED_NAVI_EVENT parse error");
                            return;
                        }
                    case 8:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuCarSpeedChange(((Float) message.obj).floatValue());
                            return;
                        }
                        return;
                    case 9:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onImuRawDataChange(false, false, (float[]) message.obj);
                            return;
                        }
                        return;
                    case 10:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onImuNavDataChange((float[]) message.obj);
                            return;
                        }
                        return;
                    case 11:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onTboxApnConntectionChange(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 13:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onHVACPowerModeChange(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 14:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onBCMDriveSeatStateChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 15:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onCarRemainDistanceChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 16:
                        int enduranceMileageMode = XpCarService.this.getEnduranceMileageMode();
                        if (enduranceMileageMode == 0) {
                            XpCarService.this.mNedcRemainDistance = 1023;
                            XpCarService.this.getCarNedcRemainDistance();
                        } else if (1 == enduranceMileageMode) {
                            XpCarService.this.mWltpRemainDistance = 1023;
                            XpCarService.this.getCarWltpRemainDistance();
                        } else if (2 == enduranceMileageMode) {
                            XpCarService.this.mCltcRemainDistance = 1023;
                            XpCarService.this.getCarCltcRemainDistance();
                        }
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onEnduranceMileageModeChange(enduranceMileageMode);
                            return;
                        }
                        return;
                    case 17:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onXpuNedcStatusChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 18:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onVpmLdwLeftWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 19:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onVpmLdwRightWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 20:
                        if (XpCarService.this.mListener != null) {
                            Integer[] numArr = (Integer[]) message.obj;
                            XpCarService.this.mListener.onScuMrrAssist(numArr[0].intValue(), numArr[1].intValue(), numArr[2].intValue(), numArr[3].intValue());
                            return;
                        }
                        return;
                    case 21:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuMrrFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 22:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuBsdLeftWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 23:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuBsdRightWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 24:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuDowRightWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 25:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuDowLeftWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 26:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuRctaLeftWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 27:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuRctaRightWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 28:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuRcwWarning(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 29:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onSrrFLFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 30:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onSrrFRFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 31:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onSrrRLFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 32:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onSrrRRFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 33:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuFishEyeCamFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 34:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuMainCamFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 35:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuNarrowCamFail(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 36:
                        if (XpCarService.this.mListener != null) {
                            Integer[] numArr2 = (Integer[]) message.obj;
                            XpCarService.this.mListener.onScuSideCamFail(numArr2[0].intValue(), numArr2[1].intValue(), numArr2[2].intValue(), numArr2[3].intValue(), numArr2[4].intValue());
                            return;
                        }
                        return;
                    case 37:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuCruiseSpeed(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 38:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuQuitNgpOdd(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 39:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuNgpOpeButton(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 40:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuNgpLcTips1(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 41:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuNgpInfoTips1(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 42:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onScuNgpTipsWindowByCan(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 43:
                    case 44:
                    default:
                        return;
                    case 45:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onFarLampStateChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 46:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onNearLampStateChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 47:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onImuRawDataChange(true, false, (float[]) message.obj);
                            return;
                        }
                        return;
                    case 48:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onBcmPowerModeChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                    case 49:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onImuRawDataChange(true, true, (float[]) message.obj);
                            return;
                        }
                        return;
                    case 50:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onNaviDestInfoReq();
                            return;
                        }
                        return;
                    case 51:
                        if (XpCarService.this.mListener != null) {
                            XpCarService.this.mListener.onFactoryModeChange(((Integer) message.obj).intValue());
                            return;
                        }
                        return;
                }
            }
        }
    }
}
