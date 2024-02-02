package com.xiaopeng.montecarlo.root.carservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
/* loaded from: classes2.dex */
public class MockCarService implements ICarService {
    public static final int ACC_STATUS_ACTIVATED = 3;
    public static final int ACC_STATUS_NON_ACTIVATED = 0;
    private static final int DEFAULT_MOCK_MAX_REMAIN_DISTANCE = 380000;
    private static final int GEAR_LEVEL_INVALID = 0;
    private static final String KEY_MOCK_CAR_REMAIN_DISTANCE = "mock_distance";
    public static final int LCC_STATUS_ACTIVATTED = 9;
    public static final int LCC_STATUS_NON_ACTIVATTED = 0;
    private static final int MSG_CHECK_REMAIN_DISTANCE = 0;
    private static final int MSG_SET_MOCK_ACC_STATUS = 2;
    private static final int MSG_SET_MOCK_DRIVING_MODE = 7;
    private static final int MSG_SET_MOCK_ELECTRICIT_PERCENT = 9;
    private static final int MSG_SET_MOCK_ENERGY_REGEN_MODE = 8;
    private static final int MSG_SET_MOCK_GEAR_LEVEL = 10;
    private static final int MSG_SET_MOCK_HVAC_POWER_MODE = 6;
    private static final int MSG_SET_MOCK_LCC_STATUS = 12;
    private static final int MSG_SET_MOCK_NEDC_STATUS = 13;
    private static final int MSG_SET_MOCK_POWER_ON_OFF = 3;
    private static final int MSG_SET_MOCK_REMAIN_DISTANCE = 1;
    private static final int MSG_SET_MOCK_SEAT_GET_OFF = 5;
    private static final int MSG_SET_MOCK_SEAT_GET_ON = 4;
    private static final int MSG_SET_MOCK_SPEED = 11;
    private static final int MSG_TRUE_VALUE = 1;
    public static final String SERVICE_NAME = "MockCarService";
    private static final L.Tag TAG = new L.Tag(SERVICE_NAME);
    private static final String VALUE = "value";
    private Handler mHandler;
    private ICarService.ICarStateListener mListener;
    private boolean mIsDebugMode = false;
    private BroadcastReceiver mDebugReceiver = null;
    private boolean mIsInitialized = false;
    private int mCarRemainDistance = 0;
    private int mEnduranceMileageMode = 0;
    private float mElectricityPercent = 0.0f;
    private float mCarSpeed = 0.0f;
    private float mRawCarSpeed = 0.0f;
    private int mGearLevel = 0;
    private boolean mIsAccOn = false;
    private boolean mIsLccOn = false;
    private int mNedcSwitchStatus = -1;
    private int mLocalIgStatus = -1;
    private int mDriveSeatState = 0;
    private boolean mIsHVACPowerMode = false;

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getBcmPowerMode() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCruiseSpeed() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getFactoryMode() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getFarLampState() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getHardwareCarStage() {
        return "UNKNOWN";
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getHardwareCarType() {
        return ICarService.CAR_TYPE_MOCK;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getHardwareVersion() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean getIcmConnectionState() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean getIcmMapDisplayState() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapFps() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapHeight() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapImageType() {
        return 2;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIcmMapWidth() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getNearLampState() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuModeIndex() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpInfoTips1Status() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpLcTips1Status() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpOpeButtonStatus() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuNgpTipsWindowStatus() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getScuQuitNgpOddStatus() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public String getXpCduType() {
        return "UNKNOWN";
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isApnConnected() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isCarServiceAvailable() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isNGPOn() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isTBOXGpsLogOperSucceed() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void sendNaviLoadLinkType(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int sendSrRdCdu2XpuNgpTrajectoryV2Data(byte[] bArr) {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setCurrentElectronicEyeSpeedLimitAndDistance(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setCurrentRoadSpeedLimit(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setDetailRoadClass(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setEventInfoRD(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setGpsReset(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setICarXPUDataCallBack(ICarService.ICarXPUDataCallBack iCarXPUDataCallBack) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setIcmNavigationBmp(byte[] bArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setIntelligentSpeedLimitValue(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDestInfo(String str) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviDestType(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviKValue(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviPathId(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRemainDistance(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRemainTime(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviRoadConnectAttrib(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNaviType(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setNavigationInfo(byte[] bArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setRoadAttributes(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setScuNgpOpeButtonStatus(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setScuNgpTipsWindowStatus(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setWeatherInfo(byte[] bArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void stopNaviRoutingInfoRequest(long j) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void swtichTBOXGpsLog(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void updateNaviPathNaviRoutingInfoRequest(long j) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void init() {
        if (this.mIsInitialized) {
            return;
        }
        L.i(TAG, "init");
        this.mHandler = new Handler(WorkThreadUtil.getInstance().getCommonCarServiceThreadLooper()) { // from class: com.xiaopeng.montecarlo.root.carservice.MockCarService.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                L.Tag tag = MockCarService.TAG;
                L.i(tag, "msg=" + message.what + " arg1=" + message.arg1);
                switch (message.what) {
                    case 1:
                        MockCarService.this.onCarRemainDistanceChange(message.arg1);
                        return;
                    case 2:
                    case 12:
                    default:
                        return;
                    case 3:
                        MockCarService.this.onBCMDriveSeatStateChange(message.arg2);
                        MockCarService.this.onPmStatusChange(message.arg1);
                        return;
                    case 4:
                        MockCarService.this.onBCMDriveSeatStateChange(1);
                        return;
                    case 5:
                        MockCarService.this.onBCMDriveSeatStateChange(0);
                        return;
                    case 6:
                        MockCarService.this.onHVACPowerModeChange(message.arg1 == 1);
                        return;
                    case 7:
                        MockCarService.this.onDrivingModeChange(message.arg1);
                        return;
                    case 8:
                        MockCarService.this.onEnergyRecycleLevelChange(message.arg1);
                        return;
                    case 9:
                        MockCarService.this.mElectricityPercent = message.arg1;
                        return;
                    case 10:
                        MockCarService.this.onGearLevelChange(message.arg1);
                        return;
                    case 11:
                        MockCarService.this.onCarSpeedChange(message.arg1);
                        MockCarService.this.onRawCarSpeedChange(message.arg1 / 3.6f);
                        return;
                    case 13:
                        MockCarService.this.onXpuNedcStatusChange(message.arg1);
                        return;
                }
            }
        };
        test();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void release() {
        this.mIsInitialized = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
        }
        untest();
    }

    private void untest() {
        BroadcastReceiver broadcastReceiver;
        Context context = ContextUtils.getContext();
        if (context == null || (broadcastReceiver = this.mDebugReceiver) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
    }

    private void test() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DebugConfiguration.RegisterAction.REMAIN_DISTANCE_TEST_ACTION);
        intentFilter.addAction(DebugConfiguration.RegisterAction.NAVI_CAR_SERVICE_TEST_ACTION);
        intentFilter.addAction("com.xiaopeng.broadcast.ACTION_PM_STATUS_CHANGE");
        intentFilter.addAction(DebugConfiguration.RegisterAction.GET_OFF_TEST_ACTION);
        intentFilter.addAction(DebugConfiguration.RegisterAction.GET_ON_TEST_ACTION);
        intentFilter.addAction(DebugConfiguration.RegisterAction.POWERDIS_TEST_ACTION);
        Context context = ContextUtils.getContext();
        if (context != null) {
            if (this.mDebugReceiver == null) {
                this.mDebugReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.root.carservice.MockCarService.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (L.ENABLE) {
                            L.d(MockCarService.TAG, "onReceive action: " + intent.getAction());
                        }
                        if (intent.getAction() == null) {
                            return;
                        }
                        if (DebugConfiguration.RegisterAction.REMAIN_DISTANCE_TEST_ACTION.equals(intent.getAction())) {
                            int intExtra = intent.getIntExtra(MockCarService.KEY_MOCK_CAR_REMAIN_DISTANCE, 0);
                            if (L.ENABLE) {
                                L.d(MockCarService.TAG, "received action: com.xiaopeng.montecarlo.SET_CAR_REMAIN_DISTANCE, " + intExtra);
                            }
                            MockCarService.this.mHandler.obtainMessage(1, intExtra, 0).sendToTarget();
                            return;
                        }
                        char c = 65535;
                        if (DebugConfiguration.RegisterAction.NAVI_CAR_SERVICE_TEST_ACTION.equals(intent.getAction())) {
                            String action = intent.getAction();
                            Bundle extras = intent.getExtras();
                            String string = extras.getString("operate_type");
                            L.i(MockCarService.TAG, "action: " + action + " type: " + string);
                            intent.getStringExtra(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ACC);
                            switch (string.hashCode()) {
                                case 96385:
                                    if (string.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ACC)) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 106956:
                                    if (string.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_LCC)) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 3168655:
                                    if (string.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_GEAR)) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 3377270:
                                    if (string.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_NEDC)) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 109641799:
                                    if (string.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_SPEED)) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            if (c == 0) {
                                MockCarService.this.mHandler.obtainMessage(2, extras.getBoolean("value", false) ? 3 : 0, 0).sendToTarget();
                            } else if (c == 1) {
                                MockCarService.this.mHandler.obtainMessage(12, extras.getBoolean("value", false) ? 9 : 0, 0).sendToTarget();
                            } else if (c == 2) {
                                MockCarService.this.mHandler.obtainMessage(10, extras.getInt("value", 0), 0).sendToTarget();
                            } else if (c == 3) {
                                MockCarService.this.mHandler.obtainMessage(11, extras.getInt("value", 0), 0).sendToTarget();
                            } else if (c != 4) {
                            } else {
                                MockCarService.this.mHandler.obtainMessage(13, extras.getInt("value", 0), 0).sendToTarget();
                            }
                        } else if (intent.getAction().equals("com.xiaopeng.broadcast.ACTION_PM_STATUS_CHANGE")) {
                            MockCarService.this.mHandler.obtainMessage(3, intent.getIntExtra(DebugConfiguration.DebugActionExtra.PM_STATUS_INT, -1), intent.getIntExtra(DebugConfiguration.DebugActionExtra.SEAT_STATUS_INT, -1)).sendToTarget();
                        } else if (intent.getAction().equals(DebugConfiguration.RegisterAction.GET_ON_TEST_ACTION)) {
                            MockCarService.this.mHandler.obtainMessage(4, 0, 0).sendToTarget();
                        } else if (intent.getAction().equals(DebugConfiguration.RegisterAction.GET_OFF_TEST_ACTION)) {
                            MockCarService.this.mHandler.obtainMessage(5, 0, 0).sendToTarget();
                        } else if (intent.getAction().equals(DebugConfiguration.RegisterAction.POWERDIS_TEST_ACTION)) {
                            String action2 = intent.getAction();
                            Bundle extras2 = intent.getExtras();
                            if (extras2 == null) {
                                return;
                            }
                            String string2 = extras2.getString("operate_type");
                            L.i(MockCarService.TAG, "action: " + action2 + " type: " + string2);
                            switch (string2.hashCode()) {
                                case -540311610:
                                    if (string2.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ENERGY_REGEN)) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case -463422693:
                                    if (string2.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_DRIVING_MODE)) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 3214768:
                                    if (string2.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_HVAC)) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 1677619726:
                                    if (string2.equals(DebugConfiguration.DebugActionExtra.TEST_ACTION_EXTRA_ELECTRICIT_PERCENT)) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            if (c == 0) {
                                MockCarService.this.mHandler.obtainMessage(6, extras2.getBoolean("value", false) ? 1 : 0, 0).sendToTarget();
                            } else if (c == 1) {
                                MockCarService.this.mHandler.obtainMessage(7, extras2.getInt("value", 0), 0).sendToTarget();
                            } else if (c == 2) {
                                MockCarService.this.mHandler.obtainMessage(8, extras2.getInt("value", 0), 0).sendToTarget();
                            } else if (c != 3) {
                            } else {
                                MockCarService.this.mHandler.obtainMessage(9, extras2.getInt("value", 0), 0).sendToTarget();
                            }
                        }
                    }
                };
            }
            context.registerReceiver(this.mDebugReceiver, intentFilter);
            L.i(TAG, "register receiver");
            return;
        }
        L.w(TAG, "context == null");
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarNedcRemainDistance() {
        return this.mCarRemainDistance;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarWltpRemainDistance() {
        return this.mCarRemainDistance;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getCarCltcRemainDistance() {
        return this.mCarRemainDistance;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getEnduranceMileageMode() {
        return this.mEnduranceMileageMode;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setEnduranceMileageMode(int i) {
        if (i != 0 && 1 != i && 2 != i) {
            L.Tag tag = TAG;
            L.w(tag, "setEnduranceMileageMode mode error:" + i);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "setEnduranceMileageMode :" + i);
        }
        this.mEnduranceMileageMode = i;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getBatteryPercent() {
        return this.mElectricityPercent;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getCarSpeed() {
        return this.mCarSpeed;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public float getRawCarSpeed() {
        return this.mRawCarSpeed;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getIgStatus() {
        return this.mLocalIgStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getDriveSeatState() {
        return this.mDriveSeatState;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getGearLevel() {
        return this.mGearLevel;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public int getNedcSwitchStatus() {
        return this.mNedcSwitchStatus;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void registerObserver(ICarService.ICarStateListener iCarStateListener) {
        this.mListener = iCarStateListener;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isAccOnByStatus() {
        return this.mIsAccOn;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isLccOnByXPilotStatus() {
        return this.mIsLccOn;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public boolean isHVACPowerModeOn() {
        return this.mIsHVACPowerMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCarRemainDistanceChange(int i) {
        if (i >= 0) {
            this.mCarRemainDistance = i;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "remain distance = " + this.mCarRemainDistance);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPmStatusChange(int i) {
        if (this.mLocalIgStatus != i) {
            if (1 == i) {
                L.i(TAG, "ig on!");
            } else if (i == 0) {
                L.i(TAG, "screen off!");
            }
        }
        this.mLocalIgStatus = i;
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onIgStatusChange(this.mLocalIgStatus);
        }
    }

    public void onBCMDriveSeatStateChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "seat status = " + i);
        }
        this.mDriveSeatState = i;
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onBCMDriveSeatStateChange(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHVACPowerModeChange(boolean z) {
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onHVACPowerModeChange(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrivingModeChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "DrivingModeEventMsg msg = " + i);
        }
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onDrivingModeChange(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnergyRecycleLevelChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onEnergyRecycleLevelChange msg = " + i);
        }
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onEnergyRecycleLevelChange(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGearLevelChange(int i) {
        this.mGearLevel = i;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "GearLevel = " + this.mGearLevel);
        }
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onGearLevelChange(this.mGearLevel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCarSpeedChange(int i) {
        this.mCarSpeed = i;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speed = " + this.mCarSpeed);
        }
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onCarSpeedChange(this.mCarSpeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onXpuNedcStatusChange(int i) {
        this.mNedcSwitchStatus = i;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "nedc = " + this.mNedcSwitchStatus);
        }
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onXpuNedcStatusChange(this.mNedcSwitchStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRawCarSpeedChange(float f) {
        this.mRawCarSpeed = f;
        ICarService.ICarStateListener iCarStateListener = this.mListener;
        if (iCarStateListener != null) {
            iCarStateListener.onRawCarSpeedChange(this.mRawCarSpeed);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService
    public void setFakeData(String str, String str2) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1205571667:
                    if (str.equals("hvacpm")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3184:
                    if (str.equals("cs")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3209:
                    if (str.equals("dm")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3215:
                    if (str.equals("ds")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3301:
                    if (str.equals("gl")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3634:
                    if (str.equals("rd")) {
                        c = 5;
                        break;
                    }
                    break;
                case 100703:
                    if (str.equals("erl")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 111126:
                    if (str.equals("pms")) {
                        c = 2;
                        break;
                    }
                    break;
                case 112738:
                    if (str.equals("rcs")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    onCarSpeedChange((int) Float.parseFloat(str2));
                    return;
                case 1:
                    onRawCarSpeedChange(Float.parseFloat(str2));
                    return;
                case 2:
                    onPmStatusChange(Integer.parseInt(str2));
                    return;
                case 3:
                    onBCMDriveSeatStateChange(Integer.parseInt(str2));
                    return;
                case 4:
                    onGearLevelChange(Integer.parseInt(str2));
                    return;
                case 5:
                    onCarRemainDistanceChange(Integer.parseInt(str2));
                    return;
                case 6:
                    onHVACPowerModeChange(Boolean.parseBoolean(str2));
                    return;
                case 7:
                    onDrivingModeChange(Integer.parseInt(str2));
                    return;
                case '\b':
                    onEnergyRecycleLevelChange(Integer.parseInt(str2));
                    return;
                default:
                    L.Tag tag = TAG;
                    L.w(tag, "unknown tag:" + str + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + str2);
                    return;
            }
        } catch (Exception e) {
            L.w(TAG, e.getMessage());
        }
    }
}
