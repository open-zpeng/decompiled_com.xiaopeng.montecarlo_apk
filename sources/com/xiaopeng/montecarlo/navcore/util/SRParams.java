package com.xiaopeng.montecarlo.navcore.util;
/* loaded from: classes3.dex */
public class SRParams {
    public static final int XPU_SR_DISPLAY_ST_CONTINUE = 3;
    public static final int XPU_SR_DISPLAY_ST_DISPLAY = 1;
    public static final int XPU_SR_DISPLAY_ST_ENTER_HD_NOT_IN_NGP = 4;
    public static final int XPU_SR_DISPLAY_ST_NO_DISPLAY = 2;
    public static final int XPU_SR_LC_VIEW_CONTINUE = 2;
    public static final int XPU_SR_LC_VIEW_LEFT = 1;
    public static final int XPU_SR_LC_VIEW_NORMAL = 0;
    public static final int XPU_SR_LC_VIEW_RIGHT = 2;
    public static final int XPU_SR_SPD_VIEW_LEVEL_1_SPEED = 0;
    public static final int XPU_SR_SPD_VIEW_LEVEL_2_SPEED = 1;
    public static final int XPU_SR_SPD_VIEW_LEVEL_3_SPEED = 2;
    public static final int XPU_SR_SPD_VIEW_LEVEL_4_SPEED = 3;

    /* loaded from: classes3.dex */
    public class LaneViewDisplayStatus {
        public static final int LANE_VIEW_DISPLAY_DISABLE = 1;
        public static final int LANE_VIEW_DISPLAY_ENABLE = 0;
        public static final int LANE_VIEW_DISPLAY_INVALID = -1;

        public LaneViewDisplayStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class VpmLdwStatus {
        public static final int VPM_LDW_STATUS_NO_DISPLAY = 0;
        public static final int VPM_LDW_STATUS_TRACKING = 1;
        public static final int VPM_LDW_STATUS_WARNING = 2;

        public VpmLdwStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuFcwAebStatus {
        public static final int SCU_FCWAEB_PERMANENT_BLOCK = 4;
        public static final int SCU_FCWAEB_PERMANENT_FAIL = 3;
        public static final int SCU_FCWAEB_SW_OFF = 0;
        public static final int SCU_FCWAEB_SW_ON = 1;
        public static final int SCU_FCWAEB_TEMPORARY_FAIL = 2;

        public ScuFcwAebStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class FcwStatus {
        public static final int FCW_STATUS_ACUTE_WARNING_TO_CAR = 4;
        public static final int FCW_STATUS_LATENT_WARNING = 1;
        public static final int FCW_STATUS_NO_WARNING = 0;
        public static final int FCW_STATUS_PREWARNING_TO_CAR = 2;
        public static final int FCW_STATUS_PREWARNING_TO_PED = 3;

        public FcwStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class EbaStatus {
        public static final int EBA_STATUS_ACTIVE_TO_CAR = 1;
        public static final int EBA_STATUS_ACTIVE_TO_PED = 2;
        public static final int EBA_STATUS_INACTIVE = 0;

        public EbaStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class AebStatus {
        public static final int AEB_STATUS_ACTIVE_TO_CAR = 1;
        public static final int AEB_STATUS_ACTIVE_TO_PED = 2;
        public static final int AEB_STATUS_INACTIVE = 0;

        public AebStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class MrrFailureStatus {
        public static final int MRR_FAILURE_STATUS_BLINDNESS = 2;
        public static final int MRR_FAILURE_STATUS_FAILURE = 1;
        public static final int MRR_FAILURE_STATUS_MISALIGNMENT = 3;
        public static final int MRR_FAILURE_STATUS_NO_FAILURE = 0;

        public MrrFailureStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuBsdStatus {
        public static final int SCU_NO_WARNING = 0;
        public static final int SCU_WARNING_LEVEL1 = 1;
        public static final int SCU_WARNING_LEVEL2 = 2;

        public ScuBsdStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuDowStatus {
        public static final int SCU_NO_WARNING = 0;
        public static final int SCU_WARNING_LEVEL1 = 1;
        public static final int SCU_WARNING_LEVEL2 = 2;

        public ScuDowStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuRctaStatus {
        public static final int SCU_NO_WARNING = 0;
        public static final int SCU_WARNING_LEVEL1 = 1;

        public ScuRctaStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuRcwStatus {
        public static final int SCU_NO_WARNING = 0;
        public static final int SCU_WARNING_LEVEL1 = 1;

        public ScuRcwStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class SrrStatus {
        public static final int SRR_STATUS_BLOCKED = 1;
        public static final int SRR_STATUS_DYNAMIC_CAILBRATION_RUNNING = 3;
        public static final int SRR_STATUS_FAILURE = 2;
        public static final int SRR_STATUS_NO_FAILURE = 0;

        public SrrStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuCamStatus {
        public static final int CAM_FAILURE_STATUS_BLOCKED = 1;
        public static final int CAM_FAILURE_STATUS_FAILURE = 2;
        public static final int CAM_FAILURE_STATUS_MISALIGNMENT = 3;
        public static final int CAM_FAILURE_STATUS_NO_FAILURE = 0;

        public ScuCamStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuQuitNgpOddStatus {
        public static final int QUIT_NGP_ODD_STATUS_NO_DISPLAY = 0;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_100M = 3;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_150M = 2;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_200M = 1;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_25M = 6;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_50M = 5;
        public static final int QUIT_NGP_ODD_STATUS_WILL_EXIST_ODD_BY_75M = 4;

        public ScuQuitNgpOddStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuNgpOpeButtonStStatus {
        public static final int NGP_OPERATION_BUTTON_STATUS_CANCEL_LANE_CHANGE = 3;
        public static final int NGP_OPERATION_BUTTON_STATUS_LOADING = 4;
        public static final int NGP_OPERATION_BUTTON_STATUS_NO_DISPLAY = 0;
        public static final int NGP_OPERATION_BUTTON_STATUS_OPERATION_5 = 5;
        public static final int NGP_OPERATION_BUTTON_STATUS_OPERATION_6 = 6;
        public static final int NGP_OPERATION_BUTTON_STATUS_OPERATION_7 = 7;
        public static final int NGP_OPERATION_BUTTON_STATUS_QUIT_NGP = 2;
        public static final int NGP_OPERATION_BUTTON_STATUS_START_NGP = 1;

        public ScuNgpOpeButtonStStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuNgpLcTips1Status {
        public static final int NGP_LC_TIPS_AVOID_REAR_VEHICLE_AND_BACK_LANE = 32;
        public static final int NGP_LC_TIPS_CONSTRUCTION = 41;
        public static final int NGP_LC_TIPS_CONTROL_DIRECTION = 65;
        public static final int NGP_LC_TIPS_CUT_IN_LINE = 70;
        public static final int NGP_LC_TIPS_DEGRADE_TO_ACC_AND_TAKE_OVER = 34;
        public static final int NGP_LC_TIPS_DEGRADE_TO_LCC_MAIN_ROAD = 33;
        public static final int NGP_LC_TIPS_DEGRADE_TO_LCC_RAMP = 57;
        public static final int NGP_LC_TIPS_DOWN_THE_SPEED = 46;
        public static final int NGP_LC_TIPS_DRIVER_MODE_AND_TAKE_OVER = 35;
        public static final int NGP_LC_TIPS_ENTER_NGP_ODD = 2;
        public static final int NGP_LC_TIPS_ENTER_TUNNEL = 79;
        public static final int NGP_LC_TIPS_EXIT_NGP = 47;
        public static final int NGP_LC_TIPS_EXIT_NGP_500M = 62;
        public static final int NGP_LC_TIPS_EXIT_NGP_BY_RAIN = 63;
        public static final int NGP_LC_TIPS_EXIT_NGP_ONE_KM = 45;
        public static final int NGP_LC_TIPS_FATAL_EXIT_NGP = 48;
        public static final int NGP_LC_TIPS_FCW = 53;
        public static final int NGP_LC_TIPS_FIND_LANE_CHANGE_SPACE = 42;
        public static final int NGP_LC_TIPS_FRONT_CAR_ERROR = 78;
        public static final int NGP_LC_TIPS_FUZZY_LANE_LINE = 69;
        public static final int NGP_LC_TIPS_HAVE_TRUCK = 54;
        public static final int NGP_LC_TIPS_IN_RAMP_SPEED_UP = 52;
        public static final int NGP_LC_TIPS_KEEP_AWAY_FROM_TRUCKS = 72;
        public static final int NGP_LC_TIPS_LANE_CHANGED_UNABLE_TO_AVOID = 60;
        public static final int NGP_LC_TIPS_LANE_CHANGE_CANCEL = 28;
        public static final int NGP_LC_TIPS_LANE_CHANGE_MANUAL = 40;
        public static final int NGP_LC_TIPS_LANE_CHANGE_MANUAL_BY_TRAFFIC = 39;
        public static final int NGP_LC_TIPS_LANE_CHANGE_TO_FAST_LANE = 38;
        public static final int NGP_LC_TIPS_LANE_CHANGE_TO_MAIN_ROAD = 37;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_LEFT_BY_MERGE = 23;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_LEFT_BY_SLOW_CAR = 11;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_LEFT_FAST_LANE = 6;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_RIGHT_BY_MERGE = 24;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_RIGHT_BY_RAMP = 17;
        public static final int NGP_LC_TIPS_LC_ACTIVE_TO_RIGHT_BY_SLOW_CAR = 12;
        public static final int NGP_LC_TIPS_LC_NEED_CFM_2_LEFT_BY_SLOW_CAR = 9;
        public static final int NGP_LC_TIPS_LC_NEED_CFM_TO_LEFT_BY_MERGE = 21;
        public static final int NGP_LC_TIPS_LC_NEED_CFM_TO_RIGHT_BY_MERGE = 22;
        public static final int NGP_LC_TIPS_LC_NEED_CFM_TO_RIGHT_BY_RAMP = 16;
        public static final int NGP_LC_TIPS_LC_NEED_CFM_TO_RIGHT_BY_SLOW_CAR = 10;
        public static final int NGP_LC_TIPS_LC_TRIGGER_BY_2KM_FAST_LANE = 30;
        public static final int NGP_LC_TIPS_LC_WAIT_SIDE_CAR_2_LEFT_FAST_LANE = 7;
        public static final int NGP_LC_TIPS_LC_WAIT_SIDE_CAR_BY_MERGE = 25;
        public static final int NGP_LC_TIPS_LC_WAIT_SIDE_CAR_BY_RAMP = 18;
        public static final int NGP_LC_TIPS_LC_WAIT_SIDE_CAR_BY_SLOW_CAR = 13;
        public static final int NGP_LC_TIPS_LC_WAIT_SOLID_LANE_BY_MERGE = 26;
        public static final int NGP_LC_TIPS_LC_WAIT_SOLID_LANE_BY_RAMP = 19;
        public static final int NGP_LC_TIPS_LC_WAIT_SOLID_LANE_BY_SLOW_CAR = 14;
        public static final int NGP_LC_TIPS_LC_WAIT_SOLID_LANE_LEFT_FAST_LANE = 8;
        public static final int NGP_LC_TIPS_LC_WILL_TRIGGER_BY_2KM_RAMP = 15;
        public static final int NGP_LC_TIPS_LC_WILL_TRIGGER_BY_2KM_TUNNEL = 29;
        public static final int NGP_LC_TIPS_LEAVE_CONSTRUCTION_SECTION = 59;
        public static final int NGP_LC_TIPS_MANUAL_CHANGE_LANE = 36;
        public static final int NGP_LC_TIPS_MANUAL_DEGRADE_TO_ACC = 4;
        public static final int NGP_LC_TIPS_MANUAL_DEGRADE_TO_MANUAL = 5;
        public static final int NGP_LC_TIPS_MAX = 82;
        public static final int NGP_LC_TIPS_MISS_EXIT_RAMP_BY_100M = 49;
        public static final int NGP_LC_TIPS_MISS_EXIT_RAMP_BY_300M = 50;
        public static final int NGP_LC_TIPS_NEED_TAKEOVER_BY_NOT_ENTER_RAMP = 20;
        public static final int NGP_LC_TIPS_NGP_IS_ACTIVE = 3;
        public static final int NGP_LC_TIPS_NGP_STANDBY = 1;
        public static final int NGP_LC_TIPS_NIGHT = 81;
        public static final int NGP_LC_TIPS_NO_CLOSE_TURN_LIGHT_LONG_TIME = 58;
        public static final int NGP_LC_TIPS_NO_DISPLAY = 0;
        public static final int NGP_LC_TIPS_RIGHT_LANE_NEAD_RAMP_EXIT = 51;
        public static final int NGP_LC_TIPS_SHARP_TURN = 68;
        public static final int NGP_LC_TIPS_SINGLE_UNKOWN = 61;
        public static final int NGP_LC_TIPS_TO_RAMP_LONG_TIME = 43;
        public static final int NGP_LC_TIPS_TO_RAMP_MAY_FAIL = 44;
        public static final int NGP_LC_TIPS_TURN_LEFT = 76;
        public static final int NGP_LC_TIPS_TURN_RIGHT = 77;
        public static final int NGP_LC_TIPS_WARN_PEDESTRIAN = 64;
        public static final int NGP_LC_TIPS_WILL_CHANGE_TO_RIGHT = 66;
        public static final int NGP_LC_TIPS_WILL_EXIST_ODD_BY_200M = 27;
        public static final int NGP_LC_TIPS_WILL_LEAVE_NGP_ODD_AND_TAKE_OVER = 31;

        public ScuNgpLcTips1Status() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuNgpInfoTips1Status {
        public static final int NGP_INFO_TIPS_ACC_SPEED_DEL = 9;
        public static final int NGP_INFO_TIPS_ACC_SPEED_INC = 8;
        public static final int NGP_INFO_TIPS_ATTENTION_BY_LONG_TIME_NOT_LC = 4;
        public static final int NGP_INFO_TIPS_ATTENTION_BY_WORK_ROAD = 7;
        public static final int NGP_INFO_TIPS_BLOCKED_ROAD_AND_PLS_MANUAL_LC = 6;
        public static final int NGP_INFO_TIPS_END_POINT_AND_PLS_MANUAL_LC = 5;
        public static final int NGP_INFO_TIPS_NO_DISPLAY = 0;
        public static final int NGP_INFO_TIPS_PLS_EYES_ON = 2;
        public static final int NGP_INFO_TIPS_PLS_HANDS_ON = 1;
        public static final int NGP_INFO_TIPS_PLS_TAKE_OVER_CAR = 3;
        public static final int NGP_INFO_TIPS_TIPS_A = 10;
        public static final int NGP_INFO_TIPS_TIPS_B = 11;
        public static final int NGP_INFO_TIPS_TIPS_C = 12;
        public static final int NGP_INFO_TIPS_TIPS_D = 13;
        public static final int NGP_INFO_TIPS_TIPS_E = 14;
        public static final int NGP_INFO_TIPS_TIPS_F = 15;

        public ScuNgpInfoTips1Status() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuNgpTipsWindowsStStatus {
        public static final int SCU_BUTTON_OFF = 0;
        public static final int SCU_BUTTON_ON = 1;

        public ScuNgpTipsWindowsStStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class ScuNgpLaneChangedStatus {
        public static final int NGP_LANE_CHANGED_LEFT = 1;
        public static final int NGP_LANE_CHANGED_NONE = 0;
        public static final int NGP_LANE_CHANGED_RIGHT = 2;

        public ScuNgpLaneChangedStatus() {
        }
    }

    /* loaded from: classes3.dex */
    public class DriveMode {
        public static final int MODE_ACC = 2;
        public static final int MODE_LCC_1 = 3;
        public static final int MODE_LCC_2 = 4;
        public static final int MODE_MANUAL = 1;
        public static final int MODE_NGP_1 = 5;
        public static final int MODE_NGP_2 = 6;

        public DriveMode() {
        }
    }

    /* loaded from: classes3.dex */
    public class XPULaneType {
        public static final int TYPE_BOTTSDOTS = 10;
        public static final int TYPE_DASHED = 1;
        public static final int TYPE_DOTSOLID = 3;
        public static final int TYPE_DOUBLEMARK_DASHED = 2;
        public static final int TYPE_DOUBLEMARK_SOLID = 5;
        public static final int TYPE_ROADEDGE = 11;
        public static final int TYPE_SOLID = 0;
        public static final int TYPE_SOLIDDOT = 4;

        public XPULaneType() {
        }
    }

    /* loaded from: classes3.dex */
    public class BLLaneType {
        public static final int TYPE_BOTTSDOTS = 6;
        public static final int TYPE_DASHED = 2;
        public static final int TYPE_DOTSOLID = 7;
        public static final int TYPE_DOUBLEMARK_DASHED = 5;
        public static final int TYPE_DOUBLEMARK_SOLID = 4;
        public static final int TYPE_INVALID = 10;
        public static final int TYPE_ROADEDGE = 3;
        public static final int TYPE_SLOWDOWN = 9;
        public static final int TYPE_SOLID = 1;
        public static final int TYPE_SOLIDDOT = 8;
        public static final int TYPE_UNDECIDED = 0;

        public BLLaneType() {
        }
    }

    /* loaded from: classes3.dex */
    public class SRObjectColor {
        public static final int COLOR_BLUE = 4;
        public static final int COLOR_DARK_GRAY = 6;
        public static final int COLOR_FLASH_BLUE = 5;
        public static final int COLOR_GRAY = 0;
        public static final int COLOR_GREEN = 2;
        public static final int COLOR_LIGHT_RED = 1;
        public static final int COLOR_RED = 3;

        public SRObjectColor() {
        }
    }

    /* loaded from: classes3.dex */
    public class LaneChangeType {
        public static final int TYPE_LEFT_SIDE_ROAD = 3;
        public static final int TYPE_NONE_SR = 4;
        public static final int TYPE_NORMAL = 1;
        public static final int TYPE_RIGHT_SIDE_ROAD = 2;

        public LaneChangeType() {
        }
    }
}
