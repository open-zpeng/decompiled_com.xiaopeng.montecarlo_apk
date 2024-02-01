package com.xiaopeng.montecarlo.root.util.config;
/* loaded from: classes3.dex */
public class DebugConfiguration {
    private static final SettingProperties sSettings = SettingProperties.getInstance();

    /* loaded from: classes3.dex */
    public static final class Debug {
        public static final boolean DEBUG_RECEIVER = DebugConfiguration.sSettings.getBoolean("debug.receiver", false);
        public static final boolean DEBUG_TRACE = DebugConfiguration.sSettings.getBoolean("debug.trace", false);
    }

    /* loaded from: classes3.dex */
    public static final class DebugActionExtra {
        public static final String CRUISE_CONGESTION_LENGTH = "length";
        public static final String CRUISE_CONGESTION_ROAD_NAME = "road_name";
        public static final String CRUISE_CONGESTION_STATUS = "status";
        public static final String CRUISE_CONGESTION_TIME = "time";
        public static final String PM_STATUS_INT = "pm_status";
        public static final String SEAT_STATUS_INT = "seat_status";
        public static final String TEST_ACTION = "Action";
        public static final String TEST_ACTION_EXTRA_ACC = "acc";
        public static final String TEST_ACTION_EXTRA_DRIVING_MODE = "driving_mode";
        public static final String TEST_ACTION_EXTRA_ELECTRICIT_PERCENT = "electricit_percent";
        public static final String TEST_ACTION_EXTRA_ENERGY_REGEN = "energy_regen";
        public static final String TEST_ACTION_EXTRA_ETA_REROUTE_TYPE = "eta_reroute_type";
        public static final String TEST_ACTION_EXTRA_GEAR = "gear";
        public static final String TEST_ACTION_EXTRA_HVAC = "hvac";
        public static final String TEST_ACTION_EXTRA_LANE_COUNT = "lane_count";
        public static final String TEST_ACTION_EXTRA_LCC = "lcc";
        public static final String TEST_ACTION_EXTRA_NEDC = "nedc";
        public static final String TEST_ACTION_EXTRA_OFF = "off";
        public static final String TEST_ACTION_EXTRA_ON = "on";
        public static final String TEST_ACTION_EXTRA_OPERATE_TYPE = "operate_type";
        public static final String TEST_ACTION_EXTRA_SPEED = "speed";
        public static final String TEST_LANE_INFO_BACK_TYPE = "backType";
        public static final String TEST_LANE_INFO_FRONT_TYPE = "frontType";
        public static final String TEST_LANE_INFO_IS_NAVI = "isNavi";
        public static final String TEST_RD_MODULE_COM = "rd_module_com";
        public static final String TEST_RD_MODULE_COM_START = "start";
        public static final String TEST_RD_MODULE_COM_VALUE = "value";
    }

    /* loaded from: classes3.dex */
    public static final class DebugIntentActionExtra {
        public static final String DEST = "dest";
        public static final String LAT_LON_SPLIT = ",";
        public static final String ORIG = "orig";
        public static final String POINT_SPLIT = "_";
        public static final String START_TYPE = "start_type";
        public static final String STRATEGY = "strategy";
        public static final String VIAS = "vias";
    }

    /* loaded from: classes3.dex */
    public static final class RegisterAction {
        public static final String AI_MSG_SHOWN_TEST_ACTION = "com.xiaopeng.montecarlo.AI_MSG_SHOWN";
        public static final String CRUISE_CONGESTION_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_NAV_CRUISE_CONGESTION";
        public static final String FLUSH_BLLOG = "com.xiaopeng.montecarlo.FLUSH_BLLOG";
        public static final String GET_OFF_TEST_ACTION = "com.xiaopeng.montecarlo.GET_OFF";
        public static final String GET_ON_TEST_ACTION = "com.xiaopeng.montecarlo.GET_ON";
        public static final String MOUNTED_USB = "com.xiaopeng.montecarlo.MOUNTED_USB";
        public static final String NAVI_CAR_SERVICE_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_CAR_SERVICE";
        public static final String NAVI_ETA_REROUTE_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_ETA_REROUTE";
        public static final String NAVI_LANE_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_NAV_LANE";
        public static final String POWERDIS_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_POWERDIS";
        public static final String POWER_ON_OFF_TEST_ACTION = "com.xiaopeng.broadcast.ACTION_PM_STATUS_CHANGE";
        public static final String PRINT_SCENES_STACKS_ACTION = "com.xiaopeng.montecarlo.DUMP_SCENEMANAGER";
        public static final String REMAIN_DISTANCE_TEST_ACTION = "com.xiaopeng.montecarlo.SET_CAR_REMAIN_DISTANCE";
        public static final String SEND_LANE_INFO = "com.xiaopeng.montecarlog.SEND_LANE_INFO";
        public static final String SEND_RD_MODULE = "com.xiaopeng.montecarlo.SEND_RD_MODULE";
        public static final String SPEECH_TEST_ACTION = "com.xiaopeng.montecarlo.TEST_SPEECH";
        public static final String START_RD_MODULE = "com.xiaopeng.montecarlo.START_RD_MODULE";
        public static final String VOLUME_CHANGED_TEST_ACTION = "android.media.VOLUME_CHANGED_ACTION_TEST";
    }
}
