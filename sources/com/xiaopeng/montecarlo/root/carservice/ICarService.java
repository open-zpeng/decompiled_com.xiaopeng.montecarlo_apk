package com.xiaopeng.montecarlo.root.carservice;

import android.car.hardware.xpu.XpuProtoMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface ICarService {
    public static final int AEB_STATUS_ACTIVE_TO_CAR = 1;
    public static final int AEB_STATUS_ACTIVE_TO_PED = 2;
    public static final int AEB_STATUS_INACTIVE = 0;
    public static final int BCM_BONNECT_CLOSED = 0;
    public static final int BCM_BONNECT_OPENED = 1;
    public static final int BCM_DOOR_CLOSE = 0;
    public static final int BCM_DOOR_OPEN = 1;
    public static final int BCM_LIGHT_STATUS_OFF = 0;
    public static final int BCM_LIGHT_STATUS_ON = 1;
    public static final int BCM_POWERMODE_CRANK = 2;
    public static final int BCM_POWERMODE_OFF = 0;
    public static final int BCM_POWERMODE_ON = 1;
    public static final int CAR_D10 = 1;
    public static final int CAR_D20 = 2;
    public static final int CAR_D20P = 3;
    public static final int CAR_D21A = 4;
    public static final int CAR_D21B = 5;
    public static final int CAR_D22 = 10;
    public static final int CAR_D55 = 6;
    public static final int CAR_E28 = 7;
    public static final int CAR_E28a = 11;
    public static final int CAR_E36 = 9;
    public static final int CAR_E38 = 8;
    public static final int CAR_F30 = 12;
    public static final int CAR_INVALID = 29947;
    public static final int CAR_MOCK = 13;
    public static final String CAR_SERVICE_TYPE_AOSP = "aosp";
    public static final String CAR_SERVICE_TYPE_MOCK = "mock";
    public static final String CAR_SERVICE_TYPE_XP = "xp";
    public static final String CAR_STAGE_A = "A";
    public static final String CAR_STAGE_B = "B";
    public static final String CAR_STAGE_C = "C";
    public static final String CAR_STAGE_D = "D";
    public static final String CAR_STAGE_E = "E";
    public static final String CAR_STAGE_F = "F";
    public static final String CAR_STAGE_UNKNOWN = "UNKNOWN";
    public static final String CAR_TYPE_D10 = "D10";
    public static final String CAR_TYPE_D20 = "D20";
    public static final String CAR_TYPE_D21 = "D21";
    public static final String CAR_TYPE_D22 = "D22";
    public static final String CAR_TYPE_D55 = "D55";
    public static final String CAR_TYPE_E28 = "E28";
    public static final String CAR_TYPE_E36 = "E36";
    public static final String CAR_TYPE_E38 = "E38";
    public static final String CAR_TYPE_F30 = "F30";
    public static final int CAR_TYPE_LENGTH = 13;
    public static final String CAR_TYPE_MOCK = "MOCK";
    public static final String CAR_TYPE_UNKNOWN = "UNKNOWN";
    public static final int CAR_UNKNOWN = 0;
    public static final String CDU_TYPE_D20 = "A1";
    public static final String CDU_TYPE_D20P = "A2";
    public static final String CDU_TYPE_D21_A = "A3";
    public static final String CDU_TYPE_D21_B = "Q2";
    public static final String CDU_TYPE_D22 = "Q6";
    public static final String CDU_TYPE_D55 = "Q3";
    public static final String CDU_TYPE_D55A = "Q3A";
    public static final String CDU_TYPE_E28 = "Q1";
    public static final String CDU_TYPE_E28_A = "Q8";
    public static final String CDU_TYPE_E38 = "Q7";
    public static final String CDU_TYPE_E38A = "Q7A";
    public static final String CDU_TYPE_F30 = "Q9";
    public static final String CDU_TYPE_QCOM_820A_B = "Q5";
    public static final String CDU_TYPE_UNKNOWN = "UNKNOWN";
    public static final int DEFAULT_XPU_NEDC_STATUS = -1;
    public static final int EBA_STATUS_ACTIVE_TO_CAR = 1;
    public static final int EBA_STATUS_ACTIVE_TO_PED = 2;
    public static final int EBA_STATUS_INACTIVE = 0;
    public static final int ENDURANCE_MILEAGE_MODE_CLTC = 2;
    public static final int ENDURANCE_MILEAGE_MODE_NEDC = 0;
    public static final int ENDURANCE_MILEAGE_MODE_WLTP = 1;
    public static final int FCW_STATUS_ACUTE_WARNING_TO_CAR = 4;
    public static final int FCW_STATUS_LATENT_WARNING = 1;
    public static final int FCW_STATUS_NO_WARNING = 0;
    public static final int FCW_STATUS_PREWARNING_TO_CAR = 2;
    public static final int FCW_STATUS_PREWARNING_TO_PED = 3;
    public static final int ICM_CONNECTED = 1;
    public static final int ICM_DISCONNECT = 0;
    public static final int IG_DEFAULT_STATUS = -1;
    public static final int IG_OFF = 0;
    public static final int IG_ON = 1;
    public static final int IG_REMOTE_ON = 2;
    public static final int INTELLIGENT_SPEED_LIMIT_NO_DISPLAY = 31;
    public static final int MCU_FACTORYMODE_OFF = 0;
    public static final int MCU_FACTORYMODE_ON = 1;
    public static final int REV01 = 1;
    public static final int REV02 = 2;
    public static final int REV03 = 3;
    public static final int REV04 = 4;
    public static final int REV05 = 5;
    public static final int REV06 = 6;
    public static final int REV07 = 7;
    public static final int REV08 = 8;
    public static final int REV09 = 9;
    public static final int REV10 = 10;
    public static final int REV_UNKNOWN = 0;
    public static final int ROAD_SPEED_LIMIT_ZERO = 0;
    public static final int SCU_MODE_INDEX_ACC_STATUS_ACTIVATED = 4;
    public static final int SCU_MODE_INDEX_LCC_STATUS_ACTIVATED_5 = 5;
    public static final int SCU_MODE_INDEX_LCC_STATUS_ACTIVATED_6 = 6;
    public static final int SCU_MODE_INDEX_LCC_STATUS_ACTIVATED_7 = 7;
    public static final int SCU_MODE_INDEX_LCC_STATUS_ACTIVATED_8 = 8;
    public static final int SCU_NO_WARNING = 0;
    public static final int SCU_WARNING_LEVEL1 = 1;
    public static final int SCU_WARNING_LEVEL2 = 2;
    public static final int SEND_MAP_IMAGE_ARGB_8888 = 5;
    public static final int SEND_MAP_IMAGE_JPG = 2;
    public static final int SEND_MAP_IMAGE_RAW = 1;
    public static final int SEND_MAP_IMAGE_RGB_565 = 3;
    public static final int SEND_MAP_IMAGE_RGB_888 = 4;
    public static final int SEND_MAP_INVALID = -1;
    public static final int SEND_MAP_SURFACE = 6;
    public static final int TBOX_APN_CONNECTED = 1;
    public static final int TRUNK_STATUS_CLOSED = 0;
    public static final int TRUNK_STATUS_CLOSING = 3;
    public static final int TRUNK_STATUS_OPENED = 2;
    public static final int TRUNK_STATUS_OPENING = 1;
    public static final int VPM_RDP_ELK_LDW_WARNING = 2;
    public static final int VPM_RDP_LKA_WARNING_1 = 3;
    public static final int VPM_RDP_LKA_WARNING_2 = 1;
    public static final int VPM_RDP_NODISPLAY = 0;
    public static final int XPU_CITY_TO_HIGHWAY = 3;
    public static final int XPU_HIGHWAY_TO_CITY = 4;
    public static final int XPU_NAVI_CONFIRM_PROTO_NOT = 1;
    public static final int XPU_NEDC_STATUS_OFF = 0;
    public static final int XPU_NEDC_STATUS_ON = 1;
    public static final int XPU_NGP_SWITCH_NONE = 0;
    public static final int XPU_TRANS_TO_CITY = 1;
    public static final int XPU_TRANS_TO_HIGHWAY = 2;
    public static final boolean isD55a = false;

    /* loaded from: classes3.dex */
    public interface ICarStateListener {
        void onBCMDriveSeatStateChange(int i);

        void onBcmBonnetStateChange(int i);

        void onBcmPowerModeChange(int i);

        void onBrakeLightStateChange(int i);

        void onCarRemainDistanceChange(int i);

        void onCarSpeedChange(float f);

        void onDayLightStateChange(int i);

        void onDrivingModeChange(int i);

        void onEnduranceMileageModeChange(int i);

        void onEnergyRecycleLevelChange(int i);

        void onFactoryModeChange(int i);

        void onFarLampStateChange(int i);

        void onGearLevelChange(int i);

        void onHVACPowerModeChange(boolean z);

        void onIcmConnectionStateChange(boolean z);

        void onIcmMapDisplayStateChange(boolean z);

        void onIcmMapFpsChange(int i);

        void onIcmMapImageTypeChange(int i);

        void onIcmMapSizeChange(int i, int i2);

        void onIcmSrMapFpsChange(int i);

        void onIcmSrMapSizeChange(int i, int i2);

        void onIgStatusChange(int i);

        void onImuNavDataChange(float[] fArr);

        void onImuRawDataChange(boolean z, boolean z2, float[] fArr, long j);

        void onLBDoorStateChange(int i);

        void onLFDoorStateChange(int i);

        void onLeftTurnLampActiveChange(int i);

        void onLocationLampStateChange(int i);

        void onNGPSwitchTranstionChange(int i);

        void onNaviDestInfoReq();

        void onNearLampStateChange(int i);

        void onRBDoorStateChange(int i);

        void onRFDoorStateChange(int i);

        void onRawCarSpeedChange(float f);

        void onRearFogLampStateChange(int i);

        void onRightTurnLampActiveChange(int i);

        void onScuBsdLeftWarning(int i);

        void onScuBsdRightWarning(int i);

        void onScuCarSpeedChange(float f);

        void onScuCruiseSpeed(int i);

        void onScuDowLeftWarning(int i);

        void onScuDowRightWarning(int i);

        void onScuFishEyeCamFail(int i);

        void onScuMainCamFail(int i);

        void onScuMrrAssist(int i, int i2, int i3, int i4);

        void onScuMrrFail(int i);

        void onScuNarrowCamFail(int i);

        void onScuNgpInfoTips1(int i);

        void onScuNgpLcTips1(int i);

        void onScuNgpOpeButton(int i);

        void onScuNgpTipsWindowByCan(int i);

        void onScuQuitNgpOdd(int i);

        void onScuRctaLeftWarning(int i);

        void onScuRctaRightWarning(int i);

        void onScuRcwWarning(int i);

        void onScuSideCamFail(int i, int i2, int i3, int i4, int i5);

        void onSrrFLFail(int i);

        void onSrrFRFail(int i);

        void onSrrRLFail(int i);

        void onSrrRRFail(int i);

        void onTboxApnConntectionChange(boolean z);

        void onTrunkStateChange(int i);

        void onVpmLdwLeftWarning(int i);

        void onVpmLdwRightWarning(int i);

        void onXPolitDriveModeChange();

        void onXpuNedcStatusChange(int i);
    }

    /* loaded from: classes3.dex */
    public interface ICarXPUDataCallBack {
        ArrayList<XpuProtoMessage.V2_Point> getCurrentRouteAllPoints();
    }

    float getBatteryPercent();

    int getBcmPowerMode();

    int getBrakeLightState();

    int getCarCltcRemainDistance();

    int getCarNedcRemainDistance();

    float getCarSpeed();

    int getCarWltpRemainDistance();

    int getCruiseSpeed();

    int getDayLightMode();

    int[] getDoorsState();

    int getDriveSeatState();

    int getEnduranceMileageMode();

    int getFactoryMode();

    int getFarLampState();

    int[] getFcwState();

    int getGearLevel();

    String getHardwareCarStage();

    String getHardwareCarType();

    int getHardwareVersion();

    boolean getIcmConnectionState();

    boolean getIcmMapDisplayState();

    int getIcmMapFps();

    int getIcmMapHeight();

    int getIcmMapImageType();

    int getIcmMapWidth();

    int getIcmSrMapFps();

    int getIcmSrMapHeight();

    int getIcmSrMapWidth();

    int getIgStatus();

    int getLeftBSDState();

    int getLeftLDWState();

    int getLeftTurnLampActiveStatus();

    int getLocationLampState();

    int getNearLampState();

    int getNedcSwitchStatus();

    int getNgpSwitchStatus();

    float getRawCarSpeed();

    int getRcwState();

    int getRearFogLamp();

    int getRightBSDState();

    int getRightLDWState();

    int getRightTurnLampActiveStatus();

    int getScuModeIndex();

    int getScuNgpInfoTips1Status();

    int getScuNgpLcTips1Status();

    int getScuNgpOpeButtonStatus();

    int getScuNgpTipsWindowStatus();

    int getScuQuitNgpOddStatus();

    String getServiceName();

    int getTrunk();

    String getXpCduType();

    void init();

    boolean isAccOnByStatus();

    boolean isApnConnected();

    int isBcmBonnetOpened();

    boolean isCarServiceAvailable();

    boolean isD55a();

    boolean isHVACPowerModeOn();

    boolean isLccOnByXPilotStatus();

    boolean isNGPOn();

    boolean isTBOXGpsLogOperSucceed();

    default void mockScuCarSpeed(Float[] fArr, long j) {
    }

    void registerObserver(ICarStateListener iCarStateListener);

    void release();

    void sendNaviLoadLinkType(int i);

    int sendSrRdCdu2XpuNgpTrajectoryV2Data(byte[] bArr);

    void setCurrentElectronicEyeSpeedLimitAndDistance(int i, int i2);

    void setCurrentRoadSpeedLimit(int i);

    void setDetailRoadClass(int i);

    void setEnduranceMileageMode(int i);

    void setEventInfoRD(int i);

    void setFakeData(String str, String str2);

    void setGpsReset(int i);

    void setICarXPUDataCallBack(ICarXPUDataCallBack iCarXPUDataCallBack);

    void setIcmNavigationBmp(byte[] bArr);

    void setIntelligentSpeedLimitValue(int i);

    void setNaviDangerAreaRDInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    void setNaviDestInfo(String str);

    void setNaviDestType(int i);

    void setNaviKValue(float f);

    void setNaviPathId(int i);

    void setNaviRemainDistance(int i);

    void setNaviRemainTime(int i);

    void setNaviRoadConnectAttrib(int i);

    void setNaviType(int i);

    void setNavigationInfo(byte[] bArr);

    void setRoadAttributes(int i, int i2);

    void setScuNgpOpeButtonStatus(int i);

    void setScuNgpTipsWindowStatus(int i);

    void setWeatherInfo(byte[] bArr);

    void stopNaviRoutingInfoRequest(long j);

    void swtichTBOXGpsLog(boolean z);

    void updateNaviPathNaviRoutingInfoRequest(long j);
}
