package com.xiaopeng.montecarlo.root.carfeature;

import android.text.TextUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public enum CarFeatureManager {
    INSTANCE;
    
    private static final int AUTO_PILOT_IMU_GPS_STATUS_ENABLE = 1;
    private static final int AUTO_PILOT_IMU_GPS_STATUS_INVALID = -1;
    private static final int AUTO_PILOT_IMU_STATUS_ENABLE = 1;
    private static final int AUTO_PILOT_IMU_STATUS_INVALID = -1;
    public static final int CFC_CONFIGURE_HIGH = 3;
    public static final int CFC_CONFIGURE_LOW = 1;
    public static final int CFC_CONFIGURE_MIDDLE = 2;
    public static final int CFC_INVALID = 0;
    private static final String SCU_ENABLE = "1";
    private static final L.Tag TAG = new L.Tag("CarFeatureManager");
    private static final Boolean[] FULL_SCENES_VOICE = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] AUTOPOLIT_IMU = {false, false, false, false, false, false, true, true, true, false, false, true, true, false};
    private static final Boolean[] ESP_SCU_SPEED_FUSION = {false, false, false, false, false, false, true, true, true, false, false, true, true, false};
    private static final Boolean[] ICM_MAP = {false, false, false, false, false, false, true, true, true, false, false, true, true, false};
    private static final Boolean[] XUI_SERVICE_INFO_UPLOAD = {false, false, false, false, false, false, true, true, true, false, false, true, true, false};
    private static final Boolean[] ICM_INFO_UPLOAD = {false, true, true, true, true, true, false, false, false, false, true, false, false, false};
    private static final Boolean[] D2X_OPEN_ACC_LCC_TYPE = {false, true, true, true, true, true, false, false, false, false, true, false, false, false};
    private static final Boolean[] VOICE_FUSION = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] MAP_MARK = {false, false, false, false, false, false, true, false, false, false, false, false, false, false};
    private static final Boolean[] RECOMMEND_PARK = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] HAPPY_ENDING = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private static final Boolean[] VPA = {false, false, false, false, false, false, true, true, false, false, false, true, true, false};
    private static final Boolean[] SAPA_CHARGE = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final String[] CHANNEL_PATH = {null, null, null, null, null, null, "channel/D55/", "channel/E28/", "channel/E38/", null, null, "channel/E28a/", "channel/E28/", null};
    private static final Float[] MINIMAP_CAR_TOP_RATIO = {Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.55f), Float.valueOf(0.7f), Float.valueOf(0.55f), Float.valueOf(0.7f), Float.valueOf(0.55f), Float.valueOf(0.7f), Float.valueOf(0.7f), Float.valueOf(0.7f)};
    private static final Boolean[] IPC_EXCHANGE_2_APIROUTER = {false, false, false, false, false, false, false, true, false, false, false, true, true, false};
    private static final Boolean[] APIROUTER_GLOBAL_VOICE = {false, false, false, false, false, false, false, true, false, false, false, true, true, false};
    private static final Boolean[] BATTERY_PRE_HEAT = {false, false, false, false, false, false, false, false, true, false, false, true, true, false};
    private static final Boolean[] CURRENT_ROAD_SPEED_LIMIT = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] CURRENT_ELECTRONIC_EYE_SPEED_LIMIT = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] ROAD_ATTRIBUTES = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] NAVI_LOAD_LINK_TYPE = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] NAVI_ROAD_CONNECT_ATTRIB = {false, false, false, false, false, false, true, true, true, false, true, true, true, false};
    private static final Boolean[] NAVI_CHARGE_FILTER = {false, false, false, false, false, false, true, true, false, false, true, true, true, false};
    private static final Boolean[] VOICE_CONTROL_NAVI_SCALE_LEVEL = {false, false, false, false, false, false, true, true, false, false, true, true, true, false};
    private static final Boolean[] NGP_TTS_SOUND_TYPE_FILTER = {false, false, false, false, false, false, false, true, false, false, false, false, false, false};
    private static final Boolean[] LCC_GEO_FENCE = {false, false, false, false, false, false, true, true, false, false, false, false, false, false};
    private static final Boolean[] VOICE_CMD_SRVIEW_ANGLE = {false, false, false, false, false, false, true, true, false, false, false, false, false, false};
    private static final Boolean[] NGP_TTS_RANGETYPE_FILTER = {false, false, false, false, false, false, true, false, false, false, false, false, false, false};
    private static final Boolean[] TRAFFIC_EVENT_FROM_NAVI_TO_XPU = {false, false, false, false, false, false, true, true, false, false, false, false, false, false};
    private static final Boolean[] MAP_DATA_PRE_INSTALLED = {true, true, true, true, true, true, true, true, true, true, true, false, true, true};
    private static final Boolean[] ENABLE_OFFLINE_INCREMENT = {false, true, true, true, true, true, true, true, true, true, true, true, true, true};
    private int mAutoPilotImuStatus = -1;
    private int mAutoPilotImuGpsStatus = -1;
    private int mXpuStatus = -1;
    private String mScuStatus = null;
    private int mCarConfigCode = 0;

    CarFeatureManager() {
    }

    public void init() {
        this.mAutoPilotImuStatus = SystemPropertyUtil.getAutoPilotImu();
        this.mXpuStatus = SystemPropertyUtil.getAutoPilotXpu();
        this.mScuStatus = SystemPropertyUtil.getSCU();
        this.mCarConfigCode = SystemPropertyUtil.getConfigCode();
        int carType = CarServiceManager.getInstance().getCarType();
        L.Tag tag = TAG;
        L.i(tag, "Car type is " + carType + ",scu status is " + this.mScuStatus + ",xpu status is " + this.mXpuStatus + ",CFC:" + this.mCarConfigCode);
        this.mAutoPilotImuStatus = SystemPropertyUtil.getAutoPilotImu();
        this.mAutoPilotImuGpsStatus = SystemPropertyUtil.getAutoPilotImuGps();
        L.Tag tag2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Car AutoPilot imu status:");
        sb.append(this.mAutoPilotImuStatus);
        sb.append(",imuGps status:");
        sb.append(this.mAutoPilotImuGpsStatus);
        L.i(tag2, sb.toString());
        L.i(TAG, "FULL_SCENES_VOICE:" + FULL_SCENES_VOICE[carType] + ",AUTOPOLIT_IMU:" + AUTOPOLIT_IMU[carType] + ",ESP_SCU_SPEED_FUSION:" + ESP_SCU_SPEED_FUSION[carType] + ",ICM_MAP:" + ICM_MAP[carType] + ",XUI_SERVICE_INFO_UPLOAD:" + XUI_SERVICE_INFO_UPLOAD[carType] + ",ICM_INFO_UPLOAD:" + ICM_INFO_UPLOAD[carType] + ",D2X:" + D2X_OPEN_ACC_LCC_TYPE[carType] + ",VOICE_FUSION:" + VOICE_FUSION[carType]);
    }

    public boolean isRecommendParkSwitchEnable() {
        return RECOMMEND_PARK[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isChargeFilterEnable() {
        return NAVI_CHARGE_FILTER[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isNgpTTSFilterBySoundTypeEnable() {
        return NGP_TTS_SOUND_TYPE_FILTER[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isLccGeoFenceEnable() {
        return LCC_GEO_FENCE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isSapaChargeEnable() {
        return SAPA_CHARGE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isFullScenesVoiceEnable() {
        return FULL_SCENES_VOICE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isVoiceFusionEnable() {
        return VOICE_FUSION[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isVPAEnable() {
        return VPA[CarServiceManager.getInstance().getCarType()].booleanValue() && CarServiceManager.getInstance().hasXpuForNgp();
    }

    public boolean isMapMarkEnable() {
        return MAP_MARK[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isAutoPolitIMUEnable() {
        if (DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_USED_IMU_SENSOR, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_USED_IMU_SENSOR)) {
            return true;
        }
        return AUTOPOLIT_IMU[CarServiceManager.getInstance().getCarType()].booleanValue() && (1 == this.mAutoPilotImuStatus || 1 == this.mAutoPilotImuGpsStatus);
    }

    public boolean isEspAndScuAutoPilotSpeedFusionEnable() {
        return ESP_SCU_SPEED_FUSION[CarServiceManager.getInstance().getCarType()].booleanValue() && hasSCUorXPU();
    }

    private boolean hasSCUorXPU() {
        return (!TextUtils.isEmpty(this.mScuStatus) && "1".equals(this.mScuStatus)) || 1 == this.mXpuStatus;
    }

    public boolean isMiniMapEnable() {
        return ICM_MAP[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isXUIServiceInfoUploadEnable() {
        return XUI_SERVICE_INFO_UPLOAD[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isICMInfoUploadEnable() {
        return ICM_INFO_UPLOAD[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isACCLCCD2X() {
        return D2X_OPEN_ACC_LCC_TYPE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isIpcExchange2Apirouter() {
        return IPC_EXCHANGE_2_APIROUTER[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isApirouterGlobalVoice() {
        return APIROUTER_GLOBAL_VOICE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isBatteryPreHeatEnable() {
        return BATTERY_PRE_HEAT[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isCurrentRoadSpeedLimitOn() {
        return CURRENT_ROAD_SPEED_LIMIT[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isCurrentElectronicEyeSpeedLimitOn() {
        return CURRENT_ELECTRONIC_EYE_SPEED_LIMIT[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isRoadAttributesOn() {
        return ROAD_ATTRIBUTES[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isNaviLoadLinkTypeOn() {
        return NAVI_LOAD_LINK_TYPE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isNaviRoadConnectAttribOn() {
        return NAVI_ROAD_CONNECT_ATTRIB[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isVoiceCmdSRViewAngleEnable() {
        return VOICE_CMD_SRVIEW_ANGLE[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isVoiceControlNaviScaleLevelEnable() {
        return VOICE_CONTROL_NAVI_SCALE_LEVEL[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isNgpTtsFilterByRangetypeEnable() {
        return NGP_TTS_RANGETYPE_FILTER[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isTrafficEventFromNaviToXpuEnable() {
        return TRAFFIC_EVENT_FROM_NAVI_TO_XPU[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean hasAccCapacity() {
        if (isACCLCCD2X()) {
            int i = this.mCarConfigCode;
            return 2 == i || 3 == i;
        }
        return hasSCUorXPU();
    }

    public float getMiniMapCarUpRatio() {
        return MINIMAP_CAR_TOP_RATIO[CarServiceManager.getInstance().getCarType()].floatValue();
    }

    public String getConfigFolder() {
        return CHANNEL_PATH[CarServiceManager.getInstance().getCarType()];
    }

    public boolean isMapDataPreInstalled() {
        return MAP_DATA_PRE_INSTALLED[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isHappyEndingEnable() {
        return HAPPY_ENDING[CarServiceManager.getInstance().getCarType()].booleanValue();
    }

    public boolean isOfflineIncrementEnabled() {
        return ENABLE_OFFLINE_INCREMENT[CarServiceManager.getInstance().getCarType()].booleanValue();
    }
}
