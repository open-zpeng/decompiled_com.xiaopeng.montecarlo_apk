package com.xiaopeng.montecarlo.root.carservice;

import android.content.Context;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class CarServiceManager implements ICarService.ICarStateListener {
    public static final int DRIVE_SEAT_STATE_OFF = 0;
    public static final int DRIVE_SEAT_STATE_ON = 1;
    public static final int XPU_STATUS_ENABLE = 1;
    public static final int XPU_STATUS_INVALID = -1;
    private CarServiceWrapper mCarServiceWrapper;
    private static final L.Tag TAG = new L.Tag("CarServiceManager");
    private static final CarServiceManager sInstance = new CarServiceManager();
    private final List<IXPCarStateListener> mListeners = new CopyOnWriteArrayList();
    private boolean mIsInitialized = false;
    private int mCarType = ICarService.CAR_INVALID;
    private XPolitDriveMode mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE;
    private int mXpuStatus = -1;

    /* loaded from: classes3.dex */
    public interface IXPCarStateListener {
        default void onBCMDriveSeatStateChange(int i) {
        }

        default void onBcmBonnetStateChange(int i) {
        }

        default void onBcmPowerModeChange(int i) {
        }

        default void onBrakeLightStateChange(int i) {
        }

        default void onCarRemainDistanceChange(int i) {
        }

        default void onCarSpeedChange(float f) {
        }

        default void onDayLightStateChange(int i) {
        }

        default void onDrivingModeChange(int i) {
        }

        default void onEnduranceMileageModeChange(int i) {
        }

        default void onEnergyRecycleLevelChange(int i) {
        }

        default void onFactoryModeChange(int i) {
        }

        default void onFarLampStateChange(int i) {
        }

        default void onGearLevelChange(int i) {
        }

        default void onHVACPowerModeChange(boolean z) {
        }

        default void onIcmConnectionStateChange(boolean z) {
        }

        default void onIcmMapDisplayStateChange(boolean z) {
        }

        default void onIcmMapFpsChange(int i) {
        }

        default void onIcmMapImageTypeChange(int i) {
        }

        default void onIcmMapSizeChange(int i, int i2) {
        }

        default void onIcmSrMapFpsChange(int i) {
        }

        default void onIcmSrMapSizeChange(int i, int i2) {
        }

        default void onIgStatusChange(int i) {
        }

        default void onImuNavDataChange(float[] fArr) {
        }

        default void onImuRawDataChange(boolean z, boolean z2, float[] fArr, long j) {
        }

        default void onLBDoorStateChange(int i) {
        }

        default void onLFDoorStateChange(int i) {
        }

        default void onLeftTurnLampActiveChange(int i) {
        }

        default void onLocationLampStateChange(int i) {
        }

        default void onNGPSwitchTranstionChange(int i) {
        }

        default void onNaviDestInfoReq() {
        }

        default void onNearLampStateChange(int i) {
        }

        default void onRBDoorStateChange(int i) {
        }

        default void onRFDoorStateChange(int i) {
        }

        default void onRawCarSpeedChange(float f) {
        }

        default void onRearFogLampStateChange(int i) {
        }

        default void onRightTurnLampActiveChange(int i) {
        }

        default void onScuBsdLeftWarning(int i) {
        }

        default void onScuBsdRightWarning(int i) {
        }

        default void onScuCarSpeedChange(float f) {
        }

        default void onScuCruiseSpeedByCan(int i) {
        }

        default void onScuDowLeftWarning(int i) {
        }

        default void onScuDowRightWarning(int i) {
        }

        default void onScuFishEyeCamFail(int i) {
        }

        default void onScuMainCamFail(int i) {
        }

        default void onScuMrrAssist(int i, int i2, int i3, int i4) {
        }

        default void onScuMrrFail(int i) {
        }

        default void onScuNarrowCamFail(int i) {
        }

        default void onScuNgpInfoTips1ByCan(int i) {
        }

        default void onScuNgpLcTips1(int i) {
        }

        default void onScuNgpOpeButtonByCan(int i) {
        }

        default void onScuNgpTipsWindowByCan(int i) {
        }

        default void onScuQuitNgpOdd(int i) {
        }

        default void onScuRctaLeftWarning(int i) {
        }

        default void onScuRctaRightWarning(int i) {
        }

        default void onScuRcwWarning(int i) {
        }

        default void onScuSideCamFail(int i, int i2, int i3, int i4, int i5) {
        }

        default void onSrrFLFail(int i) {
        }

        default void onSrrFRFail(int i) {
        }

        default void onSrrRLFail(int i) {
        }

        default void onSrrRRFail(int i) {
        }

        default void onTrunkStateChange(int i) {
        }

        default void onVpmLdwLeftWarning(int i) {
        }

        default void onVpmLdwRightWarning(int i) {
        }

        default void onXPolitDriveModeStatusChange(XPolitDriveMode xPolitDriveMode) {
        }

        default void onXpuNedcStatusChange(int i) {
        }
    }

    public boolean isBcmPowerOn(int i) {
        return i == 1;
    }

    private CarServiceManager() {
    }

    public static CarServiceManager getInstance() {
        return sInstance;
    }

    public void init(ICarService iCarService) {
        if (this.mIsInitialized) {
            return;
        }
        L.i(TAG, "init");
        this.mCarServiceWrapper = new CarServiceWrapper(iCarService);
        this.mCarServiceWrapper.setListener(this);
        this.mIsInitialized = true;
    }

    public void connectSystemCarService() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.connectSystemCarService();
        }
    }

    public void reinit(ICarService iCarService) {
        if (!this.mIsInitialized) {
            init(iCarService);
            return;
        }
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.reInit(iCarService);
        }
    }

    public void release() {
        L.i(TAG, "release");
        if (this.mIsInitialized) {
            CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
            if (carServiceWrapper != null) {
                carServiceWrapper.release();
                this.mCarServiceWrapper.setListener(null);
            }
            this.mCarServiceWrapper = null;
            this.mIsInitialized = false;
        }
    }

    public void mockScuCarSpeed(Float[] fArr, long j) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.mockScuCarSpeed(fArr, j);
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public float getCarSpeed() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper == null || !carServiceWrapper.isCarServiceAvailable()) {
            return 0.0f;
        }
        return this.mCarServiceWrapper.getCarSpeed();
    }

    public void setNaviDestInfo(String str) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviDestInfo(str);
        }
    }

    public void setNaviDestType(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviDestType(i);
        }
    }

    public void setNaviRemainDistance(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviRemainDistance(i);
        }
    }

    public void setNaviRemainTime(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviRemainTime(i);
        }
    }

    public void setNaviPathId(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviPathId(i);
        }
    }

    public void setNaviType(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviType(i);
        }
    }

    public void setNaviKValue(float f) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviKValue(f);
        }
    }

    public int getEnduranceMileageMode() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getEnduranceMileageMode();
        }
        return 0;
    }

    public int getCarRemainDistance() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            int enduranceMileageMode = carServiceWrapper.getEnduranceMileageMode();
            if (enduranceMileageMode == 0) {
                return this.mCarServiceWrapper.getCarNedcRemainDistance();
            }
            if (1 == enduranceMileageMode) {
                return this.mCarServiceWrapper.getCarWltpRemainDistance();
            }
            if (2 == enduranceMileageMode) {
                return this.mCarServiceWrapper.getCarCltcRemainDistance();
            }
            return 0;
        }
        return 0;
    }

    public float getBatteryPercent() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getBatteryPercent();
        }
        return 0.0f;
    }

    public int getMaxMileAge() {
        if (this.mCarServiceWrapper != null) {
            float batteryPercent = getBatteryPercent();
            if (!RootUtil.compareFloat(batteryPercent, 0.0f)) {
                return (int) ((getCarRemainDistance() / batteryPercent) * 100.0f);
            }
        }
        return 0;
    }

    public boolean isCarServiceAvailable() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.isCarServiceAvailable();
        }
        return false;
    }

    public int getIgStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIgStatus();
        }
        return -1;
    }

    public int getDriveSeatState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getDriveSeatState();
        }
        return -1;
    }

    public int getFarLampState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getFarLampState();
        }
        return -1;
    }

    public int getNearLampState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getNearLampState();
        }
        return -1;
    }

    public int getLeftTurnLampActiveStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getLeftTurnLampActiveStatus();
        }
        return -1;
    }

    public int getRightTurnLampActiveStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getRightTurnLampActiveStatus();
        }
        return -1;
    }

    public int getBrakeLightState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getBrakeLightState();
        }
        return -1;
    }

    public int isBcmBonnetOpened() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.isBcmBonnetOpened();
        }
        return -1;
    }

    public int getTrunk() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getTrunk();
        }
        return -1;
    }

    public int[] getDoorsState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getDoorsState();
        }
        return null;
    }

    public int getGearLevel() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getGearLevel();
        }
        return -1;
    }

    public void setWeatherInfo(byte[] bArr) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setWeatherInfo(bArr);
        }
    }

    public void setNavigationInfo(byte[] bArr) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNavigationInfo(bArr);
        }
    }

    public String getHardwareCarType() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        return carServiceWrapper != null ? carServiceWrapper.getHardwareCarType() : "UNKNOWN";
    }

    public int getNedcSwitchStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getNedcSwitchStatus();
        }
        return -1;
    }

    public int getNgpSwitchStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getNgpSwitchStatus();
        }
        return -1;
    }

    private String getXpCduType() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        return carServiceWrapper != null ? carServiceWrapper.getXpCduType() : "UNKNOWN";
    }

    private String getHardwareCarStage() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        return carServiceWrapper != null ? carServiceWrapper.getHardwareCarStage() : "UNKNOWN";
    }

    private String getCarStage() {
        final Context context = ContextUtils.getContext();
        String hardwareCarStage = getHardwareCarStage();
        if (hardwareCarStage.equals("UNKNOWN")) {
            L.Tag tag = TAG;
            L.w(tag, "unknown car stage:" + hardwareCarStage);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.CarServiceManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtils.showToast(context, "carStage不确定，导航须适配");
                }
            });
        }
        return hardwareCarStage;
    }

    private String getCarCduType() {
        final Context context = ContextUtils.getContext();
        String xpCduType = getXpCduType();
        if ("UNKNOWN".equals(xpCduType)) {
            L.Tag tag = TAG;
            L.w(tag, "unknown car cdu type:" + xpCduType);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.CarServiceManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtils.showToast(context, "CDU版本不确定，导航须适配");
                }
            });
        }
        return xpCduType;
    }

    public String getServiceName() {
        return this.mCarServiceWrapper.getServiceName();
    }

    public int getCarType() {
        if (29947 == this.mCarType) {
            final Context context = ContextUtils.getContext();
            String hardwareCarType = getHardwareCarType();
            if (ICarService.CAR_TYPE_D10.equals(hardwareCarType)) {
                this.mCarType = 1;
            } else if (ICarService.CAR_TYPE_D20.equals(hardwareCarType)) {
                if ("A2".equals(getCarCduType())) {
                    this.mCarType = 3;
                } else if ("Q5".equals(getCarCduType())) {
                    this.mCarType = 5;
                } else if ("Q6".equals(getCarCduType())) {
                    return 10;
                } else {
                    this.mCarType = 2;
                }
            } else if (ICarService.CAR_TYPE_D21.equals(hardwareCarType)) {
                if ("A3".equals(getCarCduType())) {
                    this.mCarType = 4;
                } else if ("Q2".equals(getCarCduType()) || "Q5".equals(getCarCduType())) {
                    this.mCarType = 5;
                }
            } else if (ICarService.CAR_TYPE_D22.equals(hardwareCarType)) {
                return 10;
            } else {
                if (ICarService.CAR_TYPE_D55.equals(hardwareCarType)) {
                    this.mCarType = 6;
                } else if (ICarService.CAR_TYPE_E28.equals(hardwareCarType)) {
                    if ("Q8".equals(getCarCduType())) {
                        this.mCarType = 11;
                    } else {
                        this.mCarType = 7;
                    }
                } else if (ICarService.CAR_TYPE_E36.equals(hardwareCarType)) {
                    this.mCarType = 9;
                } else if (ICarService.CAR_TYPE_E38.equals(hardwareCarType)) {
                    this.mCarType = 8;
                } else if (ICarService.CAR_TYPE_F30.equals(hardwareCarType)) {
                    this.mCarType = 12;
                } else if (ICarService.CAR_TYPE_MOCK.equals(hardwareCarType)) {
                    this.mCarType = 13;
                } else {
                    L.Tag tag = TAG;
                    L.w(tag, "unknown car type:" + hardwareCarType);
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.root.carservice.CarServiceManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ToastUtils.showToast(context, "车型不确定，导航须适配");
                        }
                    });
                    this.mCarType = 0;
                }
            }
        }
        return this.mCarType;
    }

    public void addCarStateListener(IXPCarStateListener iXPCarStateListener) {
        if (iXPCarStateListener == null || this.mListeners.contains(iXPCarStateListener)) {
            return;
        }
        this.mListeners.add(iXPCarStateListener);
    }

    public void removeCarStateListener(IXPCarStateListener iXPCarStateListener) {
        this.mListeners.remove(iXPCarStateListener);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onCarSpeedChange(float f) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onCarSpeedChange(f);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onRawCarSpeedChange(float f) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onRawCarSpeedChange(f);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIgStatusChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIgStatusChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onBCMDriveSeatStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onBCMDriveSeatStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onHVACPowerModeChange(boolean z) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onHVACPowerModeChange(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onDrivingModeChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onDrivingModeChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onEnergyRecycleLevelChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onEnergyRecycleLevelChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onGearLevelChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onGearLevelChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onCarRemainDistanceChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onCarRemainDistanceChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onEnduranceMileageModeChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onEnduranceMileageModeChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onNaviDestInfoReq() {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onNaviDestInfoReq();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onTboxApnConntectionChange(boolean z) {
        XPNetworkManager.INSTANCE.updateTboxApnConnected(z);
    }

    public int getCarConfigType() {
        return CFCHelper.getConfigCode();
    }

    public XPolitDriveMode getXPolitDriveMode() {
        if (this.mCarServiceWrapper != null) {
            if (this.mCarType == 0) {
                this.mCarType = getCarType();
            }
            if (CarFeatureManager.INSTANCE.isACCLCCD2X()) {
                switch (this.mCarServiceWrapper.getScuModeIndex()) {
                    case 4:
                        this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC;
                        break;
                    default:
                        this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE;
                        break;
                }
            } else {
                boolean isAccOnByStatus = this.mCarServiceWrapper.isAccOnByStatus();
                boolean isLccOnByXPilotStatus = this.mCarServiceWrapper.isLccOnByXPilotStatus();
                this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE;
                if (isAccOnByStatus) {
                    this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_ACC;
                }
                if (isLccOnByXPilotStatus) {
                    this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_LCC;
                }
            }
            return this.mXPolitDriveMode;
        }
        this.mXPolitDriveMode = XPolitDriveMode.XPOLIT_DRIVE_MODE_NONE;
        return this.mXPolitDriveMode;
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmConnectionStateChange(boolean z) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmConnectionStateChange(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmMapDisplayStateChange(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmMapSizeChange(i, i2);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmMapFpsChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmMapFpsChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmSrMapSizeChange(int i, int i2) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmSrMapSizeChange(i, i2);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmSrMapFpsChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmSrMapFpsChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onIcmMapImageTypeChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onIcmMapImageTypeChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuCarSpeedChange(float f) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuCarSpeedChange(f);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onImuRawDataChange(boolean z, boolean z2, float[] fArr, long j) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onImuRawDataChange(z, z2, fArr, j);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onImuNavDataChange(float[] fArr) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onImuNavDataChange(fArr);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onXPolitDriveModeChange() {
        if (this.mXPolitDriveMode != getXPolitDriveMode()) {
            for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
                iXPCarStateListener.onXPolitDriveModeStatusChange(this.mXPolitDriveMode);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onXpuNedcStatusChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onXpuNedcStatusChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onVpmLdwLeftWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onVpmLdwLeftWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onVpmLdwRightWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onVpmLdwRightWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuMrrAssist(int i, int i2, int i3, int i4) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuMrrAssist(i, i2, i3, i4);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuMrrFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuMrrFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuBsdLeftWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuBsdLeftWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuBsdRightWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuBsdRightWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuDowRightWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuDowRightWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuDowLeftWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuDowLeftWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuRctaLeftWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuRctaLeftWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuRctaRightWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuRctaRightWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuRcwWarning(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuRcwWarning(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onSrrFLFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onSrrFLFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onSrrFRFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onSrrFRFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onSrrRLFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onSrrRLFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onSrrRRFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onSrrRRFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuFishEyeCamFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuFishEyeCamFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuMainCamFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuMainCamFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuNarrowCamFail(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuNarrowCamFail(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuSideCamFail(int i, int i2, int i3, int i4, int i5) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuSideCamFail(i, i2, i3, i4, i5);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuCruiseSpeed(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuCruiseSpeedByCan(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuQuitNgpOdd(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuQuitNgpOdd(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuNgpOpeButton(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuNgpOpeButtonByCan(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuNgpLcTips1(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuNgpLcTips1(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuNgpInfoTips1(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuNgpInfoTips1ByCan(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onScuNgpTipsWindowByCan(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onScuNgpTipsWindowByCan(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onFarLampStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onFarLampStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onNearLampStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onNearLampStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onDayLightStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onDayLightStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onLeftTurnLampActiveChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onLeftTurnLampActiveChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onRightTurnLampActiveChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onRightTurnLampActiveChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onRearFogLampStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onRearFogLampStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onLocationLampStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onLocationLampStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onBcmBonnetStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onBcmBonnetStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onTrunkStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onTrunkStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onLFDoorStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onLFDoorStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onRFDoorStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onRFDoorStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onLBDoorStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onLBDoorStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onRBDoorStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onRBDoorStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onBrakeLightStateChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onBrakeLightStateChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onBcmPowerModeChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onBcmPowerModeChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onFactoryModeChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onFactoryModeChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarStateListener
    public void onNGPSwitchTranstionChange(int i) {
        for (IXPCarStateListener iXPCarStateListener : this.mListeners) {
            iXPCarStateListener.onNGPSwitchTranstionChange(i);
        }
    }

    public int getCruiseSpeed() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getCruiseSpeed();
        }
        return -1;
    }

    public int getScuQuitNgpOddStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getScuQuitNgpOddStatus();
        }
        return -1;
    }

    public int getScuNgpOpeButtonStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getScuNgpOpeButtonStatus();
        }
        return -1;
    }

    public void setScuNgpOpeButtonStatus(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setScuNgpOpeButtonStatus(i);
        }
    }

    public int getScuNgpLcTips1Status() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getScuNgpLcTips1Status();
        }
        return -1;
    }

    public int getScuNgpInfoTips1Status() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getScuNgpInfoTips1Status();
        }
        return -1;
    }

    public int getScuNgpTipsWindowStatus() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getScuNgpTipsWindowStatus();
        }
        return -1;
    }

    public void setScuNgpTipsWindowStatus(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setScuNgpTipsWindowStatus(i);
        }
    }

    public boolean getHVACPowerMode() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper == null || !carServiceWrapper.isCarServiceAvailable()) {
            return false;
        }
        return this.mCarServiceWrapper.getHVACPowerMode();
    }

    public void setRoadAttributes(int i, int i2) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setRoadAttributes(i, i2);
        }
    }

    public void sendNaviLoadLinkType(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.sendNaviLoadLinkType(i);
        }
    }

    public void setDetailRoadClass(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setDetailRoadClass(i);
        }
    }

    public boolean getIcmConnectionState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper == null || !carServiceWrapper.isCarServiceAvailable()) {
            return false;
        }
        return this.mCarServiceWrapper.getIcmConnectionState();
    }

    public void setIcmNavigationBmp(byte[] bArr) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setIcmNavigationBmp(bArr);
        }
    }

    public void setGpsReset(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setGpsReset(i);
        }
    }

    public boolean getIcmMapDisplayState() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmMapDisplayState();
        }
        return false;
    }

    public int getIcmMapWidth() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmMapWidth();
        }
        return 0;
    }

    public int getIcmMapHeight() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmMapHeight();
        }
        return 0;
    }

    public int getIcmMapFps() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmMapFps();
        }
        return 0;
    }

    public int getIcmSrMapWidth() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmSrMapWidth();
        }
        return 0;
    }

    public int getIcmSrMapHeight() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmSrMapHeight();
        }
        return 0;
    }

    public int getIcmSrMapFps() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmSrMapFps();
        }
        return 0;
    }

    public int getIcmMapImageType() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getIcmMapImageType();
        }
        return -1;
    }

    private boolean hasXpu() {
        if (-1 == this.mXpuStatus) {
            this.mXpuStatus = SystemPropertyUtil.getAutoPilotXpu();
            L.Tag tag = TAG;
            L.i(tag, "mXpuStatus:" + this.mXpuStatus);
        }
        return 1 == this.mXpuStatus;
    }

    public boolean hasXpuForNgp() {
        if (hasXpu()) {
            return true;
        }
        if (RootUtil.isUserVersion()) {
            return false;
        }
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_NGP, false);
    }

    public boolean isNGPOn() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        boolean isNGPOn = carServiceWrapper != null ? carServiceWrapper.isNGPOn() : false;
        return !isNGPOn ? DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_NGP, false) : isNGPOn;
    }

    public void setFakeData(String str, String str2) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setFakeData(str, str2);
        }
    }

    public void swtichTBOXGpsLog(boolean z) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.swtichTBOXGpsLog(z);
        }
    }

    public boolean isTBOXGpsLogOperSucceed() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.isTBOXGpsLogOperSucceed();
        }
        return false;
    }

    public ICarService getCarService() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.getCarService();
        }
        return null;
    }

    public int sendSrRdCdu2XpuNgpTrajectoryV2Data(byte[] bArr) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.sendSrRdCdu2XpuNgpTrajectoryV2Data(bArr);
        }
        return -1;
    }

    public void stopNaviRoutingInfoRequest(long j) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.stopNaviRoutingInfoRequest(j);
        }
    }

    public void updateNaviPathNaviRoutingInfoRequest(long j) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.updateNaviPathNaviRoutingInfoRequest(j);
        }
    }

    public void setICarXPUDataCallBack(ICarService.ICarXPUDataCallBack iCarXPUDataCallBack) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setICarXPUDataCallBack(iCarXPUDataCallBack);
        }
    }

    public void setCurrentRoadSpeedLimit(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setCurrentRoadSpeedLimit(i);
        }
    }

    public void setCurrentElectronicEyeSpeedLimitAndDistance(int i, int i2) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setCurrentElectronicEyeSpeedLimitAndDistance(i, i2);
        }
    }

    public void setIntelligentSpeedLimitValue(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setIntelligentSpeedLimitValue(i);
        }
    }

    public void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviDangerAreaRDInfo(i, i2, i3, i4, i5, i6, i7);
        }
    }

    public void setEventInfoRD(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setEventInfoRD(i);
        }
    }

    public boolean isD22() {
        return 10 == getCarType();
    }

    public boolean isD55() {
        return 6 == getCarType();
    }

    public boolean isD55a() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return carServiceWrapper.isD55a();
        }
        return false;
    }

    public boolean isE28() {
        return 7 == getCarType();
    }

    public boolean isBcmPowerOn() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            return isBcmPowerOn(carServiceWrapper.getBcmPowerMode()) || isFactoryMode();
        }
        return false;
    }

    public boolean isFactoryMode() {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        return carServiceWrapper != null && carServiceWrapper.getFactoryMode() == 1;
    }

    public void setNaviRoadConnectAttrib(int i) {
        CarServiceWrapper carServiceWrapper = this.mCarServiceWrapper;
        if (carServiceWrapper != null) {
            carServiceWrapper.setNaviRoadConnectAttrib(i);
        }
    }

    /* loaded from: classes3.dex */
    public enum XPolitDriveMode {
        XPOLIT_DRIVE_MODE_NONE(0),
        XPOLIT_DRIVE_MODE_ACC(1),
        XPOLIT_DRIVE_MODE_LCC(2);
        
        private final int mStatValue;

        XPolitDriveMode(int i) {
            this.mStatValue = i;
        }

        public int getStatValue() {
            return this.mStatValue;
        }
    }
}
