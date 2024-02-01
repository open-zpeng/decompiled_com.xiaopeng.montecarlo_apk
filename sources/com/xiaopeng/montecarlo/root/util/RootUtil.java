package com.xiaopeng.montecarlo.root.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.MapExceptionWatcher;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.ToIntFunction;
/* loaded from: classes3.dex */
public class RootUtil {
    public static String ACTIVATE_BACKUP_DIR = null;
    public static String ACTIVATE_SDCARD_DIR = null;
    public static final String AOS_DEVELOP_REST_KEY = "c4b9b7a36187e64bfd257c32b91c1488";
    public static final String AOS_DEVELOP_REST_SECURITY_CODE = "8ea67542fe1d62c8185daf27f4bfac52";
    public static final String AOS_PRODUCT_REST_KEY = "94c3febb4a95362b9badf8c3949e39f9";
    public static final String AOS_PRODUCT_REST_SECURITY_CODE = "c8d2b406ca2c6967169377e894b6ce2b";
    public static String DIR_BL_LOG = null;
    public static String DIR_BL_LOG_EHPCLOUD_LOG = null;
    public static String DIR_BL_LOG_EHPEXPORT_LOG = null;
    public static String DIR_BL_LOG_EHPIFC_LOG = null;
    public static String DIR_BL_LOG_EHPTRACE_LOG = null;
    public static String DIR_BL_LOG_GNET_STATS_LOG = null;
    public static String DIR_BL_LOG_IPC_LOG = null;
    public static String DIR_BL_LOG_LOG = null;
    public static String DIR_BL_LOG_NETWORK_LOG = null;
    public static String DIR_BL_LOG_ROUTE_DATA = null;
    public static String DIR_CAPTURE_PATH = null;
    public static String DIR_LOC_LANE_LOG = null;
    public static String DIR_LOC_LOG = null;
    public static String DIR_LOGCAT_LOG = null;
    public static String DIR_OFFLINE_RELATIVE_PATH = null;
    public static String DIR_PROTO_DATA_LOG = null;
    public static final String EXT_SD_CARD = "/mnt/extsd";
    private static final float FLOAT_ACCURACY = 1.0E-7f;
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static long KILL_NAVI_ALL_CITY_COMPILE_ERROR = 0;
    public static long KILL_NAVI_AMAP_POS_ENGINE_STOP = 0;
    public static long KILL_NAVI_BL_INIT_ERROR = 0;
    public static long KILL_NAVI_CLEAR_CALIBRATION = 0;
    public static long KILL_NAVI_CLOSE_AMAP_LOG = 0;
    public static long KILL_NAVI_COPY_AMAP_LOG_DONE = 0;
    public static long KILL_NAVI_DEBUG_CARSERVICE = 0;
    public static long KILL_NAVI_DEBUG_MENU = 0;
    public static long KILL_NAVI_DEBUG_SWITCH_GPS_MODE = 0;
    public static long KILL_NAVI_DEBUG_SWITCH_NGP = 0;
    public static long KILL_NAVI_LOST_CRUISE_SCENCE = 0;
    public static long KILL_NAVI_MAP_INIT_INTERRUPTED = 0;
    public static long KILL_NAVI_OFFLINE_DATA_BLOCK_IN_UNZIP = 0;
    public static long KILL_NAVI_RESET_BL_PROPERTY = 0;
    public static long KILL_NAVI_USER_LONG_CLICK = 0;
    public static String LAN_DIR_LOC_LOG = null;
    public static String LAN_DIR_OFFLINE_LANE_DATA_PATH = null;
    public static final String LAN_DIR_SD_CARD_NAVI_PATH;
    public static final String LAN_NAVI_ASSERT_RES_PATH = "lane/LaneResource";
    public static final long MB = 1048576;
    private static final int MINIMAP_HEIGHT = 550;
    public static final int MINIMAP_SCALE_MAX = 100;
    public static final int MINIMAP_SCALE_PERCENT = 70;
    private static final int MINIMAP_WIDTH = 610;
    public static final String MNT_VMAP = "/mnt/vmap";
    public static final String NAVI_LOG_DIR_BLLOG_EHPCLOUD_NAME = "ehpcloud";
    public static final String NAVI_LOG_DIR_BLLOG_EHPEXPORT_NAME = "ehpexport";
    public static final String NAVI_LOG_DIR_BLLOG_EHPIFC_NAME = "ehpifc";
    public static final String NAVI_LOG_DIR_BLLOG_EHPTRACE_NAME = "ehptrace";
    public static final String NAVI_LOG_DIR_BLLOG_GNET_STATS_NAME = "gnet_stats";
    public static final String NAVI_LOG_DIR_BLLOG_IPC_NAME = "ipcLopPath";
    public static final String NAVI_LOG_DIR_BLLOG_LOG_NAME = "log";
    public static final String NAVI_LOG_DIR_BLLOG_NAME = "bllog";
    public static final String NAVI_LOG_DIR_BLLOG_NETWORK_NAME = "network";
    public static final String NAVI_LOG_DIR_CKR_NAME = "laneckr";
    public static final String NAVI_LOG_DIR_LOC_NAME = "log";
    public static final String NAVI_LOG_DIR_NAME = "navi_log";
    public static final String NAVI_LOG_DIR_PROT_NAME = "proto_data";
    public static final String NAVI_LOG_DIR_ROUTE_DATA_NAME = "map-routedat";
    public static final String NAVI_LOG_DIR_SKG_NAME = "skg";
    public static final String NAVI_LOG_DIR_XPLOG_NAME = "logcat";
    public static String NAVI_LOG_PATH = null;
    public static String SD_CARD_DIR_ACCOUNT_BEHAVIOR_SERVICE_FILE_PATH = null;
    public static String SD_CARD_DIR_ACCOUNT_SERVICE_FILE_PATH = null;
    public static final String SD_CARD_DIR_CHARGE_DATA_PATH = "/chargedata";
    public static String SD_CARD_DIR_GUIDE = null;
    public static String SD_CARD_DIR_LANE_RECORD = null;
    public static final String SD_CARD_DIR_LCC_GEO_FENCE_DATA_PATH = "/lccgeofence";
    public static String SD_CARD_DIR_MAP_FONT_CACHE_PATH = null;
    public static String SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH = null;
    public static String SD_CARD_DIR_PC_CHECK = null;
    public static String SD_CARD_DIR_POS_320_CONTEXT = null;
    public static String SD_CARD_DIR_POS_430_CONTEXT = null;
    public static String SD_CARD_DIR_POS_520_CONTEXT = null;
    public static String SD_CARD_DIR_ROUTEDATA = null;
    public static final String SD_CARD_DIR_SCRATCH_SPOT_DATA_PATH = "/scratchspotdata";
    public static final String SD_CARD_DIR_SEAMLESS_ASSETS_DATA_PATH = "/seamlessassets";
    public static final String SD_CARD_DIR_SEAMLESS_DATA_PATH = "/seamless";
    public static final String SD_CARD_DIR_SERVICE_CENTER_DATA_PATH = "/servicecenterdata";
    public static final String SD_CARD_DIR_SR_CAR_MODEL_DATA_PATH = "/carmodel";
    public static String SD_CARD_FULL_MAP_PATH = null;
    public static String SD_CARD_ONLINEPATH = null;
    public static final int TF_CHECK_EXIST_EXTSD = 2;
    public static final int TF_CHECK_NO_EXTSD = 0;
    public static final int TF_CHECK_NO_MOUNT_EXTSD = 1;
    public static int extsd_status;
    private static MapExceptionWatcher sExceptionWatcher;
    private static int sHeight;
    public static boolean sIsDrTestMode;
    private static boolean sIsTabletApp;
    private static int sLeftPanelHeight;
    private static int sLeftPanelWidth;
    private static MapSize sMapSize;
    private static String sPackageName;
    private static String sVersionCode;
    private static String sVersionName;
    private static int sWidth;
    public static int sdcard_status;
    public static final String[] TO_CALIBRATION_FILE_LIST = {"GNaviPosConfig.dat"};
    public static final String[] BL_MAP_FONT_CACHE = {"am_font_model.dat", "am_font_model.ind", "am_font_model_ex.dat"};
    private static final L.Tag TAG = new L.Tag("RootUtil");
    public static String SD_CARD_DIR_PC_CHECK_NAME = "check";
    public static String SD_CARD_ONLINEPATH_NAME = "onlinedata/";
    public static String SD_CARD_DIR_POS_CONTEXT_VERSION_320_NAME = "res/";
    public static String SD_CARD_DIR_POS_CONTEXT_VERSION_430_NAME = "res/430/";
    public static String SD_CARD_DIR_POS_CONTEXT_VERSION_520_NAME = "res/520/";
    public static String SD_CARD_DIR_ROUTEDATA_NAME = "route/";
    public static String SD_CARD_DIR_GUIDE_NAME = "guide/";
    public static String SD_CARD_DIR_GUIDEROUTE_NAME = "/guideroute/";
    public static String SD_CARD_DIR_ACCOUNT_BEHAVIOR_SERVICE_FILE_PATH_NAME = "behavior";
    public static String SD_CARD_DIR_ACCOUNT_SERVICE_FILE_PATH_NAME = "account";
    public static String SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH_NAME = "msgpush";
    public static String EXT_SD_CARD_DEV = "/dev/block/mmcblk1";
    public static String NAVI_PATH = "/mnt/extsd/montecarlo";
    public static final String DATA_DIR_NAME = "montecarlo";
    public static String SD_CARD_NAVI_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + DATA_DIR_NAME;

    public static int getMiniMapHeight() {
        return 550;
    }

    public static int getMiniMapWidth() {
        return 610;
    }

    public static boolean isDebugMode() {
        return false;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(SD_CARD_NAVI_PATH);
        sb.append("/record/");
        SD_CARD_DIR_LANE_RECORD = sb.toString();
        SD_CARD_FULL_MAP_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + "fullmap";
        extsd_status = 0;
        sdcard_status = 0;
        LAN_DIR_SD_CARD_NAVI_PATH = SD_CARD_NAVI_PATH + "/lane";
        sExceptionWatcher = null;
        sMapSize = null;
        KILL_NAVI_MAP_INIT_INTERRUPTED = 0L;
        KILL_NAVI_COPY_AMAP_LOG_DONE = 1000L;
        KILL_NAVI_CLEAR_CALIBRATION = 1001L;
        KILL_NAVI_ALL_CITY_COMPILE_ERROR = 1002L;
        KILL_NAVI_USER_LONG_CLICK = 1003L;
        KILL_NAVI_DEBUG_MENU = 1004L;
        KILL_NAVI_DEBUG_SWITCH_GPS_MODE = 1005L;
        KILL_NAVI_RESET_BL_PROPERTY = 1006L;
        KILL_NAVI_DEBUG_SWITCH_NGP = 1007L;
        KILL_NAVI_DEBUG_CARSERVICE = 1008L;
        KILL_NAVI_BL_INIT_ERROR = 1009L;
        KILL_NAVI_AMAP_POS_ENGINE_STOP = 1010L;
        KILL_NAVI_LOST_CRUISE_SCENCE = 2000L;
        KILL_NAVI_CLOSE_AMAP_LOG = 1011L;
        KILL_NAVI_OFFLINE_DATA_BLOCK_IN_UNZIP = 3000L;
        sIsDrTestMode = false;
    }

    public static void initStoragePath(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(!z ? NAVI_PATH : SD_CARD_NAVI_PATH);
        sb.append(File.separator);
        sb.append(NAVI_LOG_DIR_NAME);
        NAVI_LOG_PATH = sb.toString();
        DIR_BL_LOG = NAVI_LOG_PATH + File.separator + NAVI_LOG_DIR_BLLOG_NAME;
        DIR_BL_LOG_LOG = DIR_BL_LOG + File.separator + "log";
        DIR_BL_LOG_NETWORK_LOG = DIR_BL_LOG + File.separator + "network" + File.separator + "log";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DIR_BL_LOG);
        sb2.append(File.separator);
        sb2.append(NAVI_LOG_DIR_BLLOG_GNET_STATS_NAME);
        DIR_BL_LOG_GNET_STATS_LOG = sb2.toString();
        DIR_BL_LOG_IPC_LOG = DIR_BL_LOG + File.separator + NAVI_LOG_DIR_BLLOG_IPC_NAME + File.separator + "log";
        DIR_BL_LOG_EHPCLOUD_LOG = DIR_BL_LOG + File.separator + NAVI_LOG_DIR_BLLOG_EHPCLOUD_NAME + File.separator + "log";
        DIR_BL_LOG_EHPEXPORT_LOG = DIR_BL_LOG + File.separator + NAVI_LOG_DIR_BLLOG_EHPEXPORT_NAME + File.separator + "log";
        DIR_BL_LOG_EHPIFC_LOG = DIR_BL_LOG + File.separator + NAVI_LOG_DIR_BLLOG_EHPIFC_NAME + File.separator + "log";
        DIR_BL_LOG_EHPTRACE_LOG = DIR_BL_LOG + File.separator + NAVI_LOG_DIR_BLLOG_EHPTRACE_NAME + File.separator + "log";
        StringBuilder sb3 = new StringBuilder();
        sb3.append(NAVI_LOG_PATH);
        sb3.append(File.separator);
        sb3.append("log");
        sb3.append(File.separator);
        DIR_LOC_LOG = sb3.toString();
        DIR_LOC_LANE_LOG = DIR_LOC_LOG + NAVI_LOG_DIR_CKR_NAME;
        DIR_BL_LOG_ROUTE_DATA = DIR_BL_LOG_LOG + File.separator + NAVI_LOG_DIR_ROUTE_DATA_NAME;
        DIR_LOGCAT_LOG = NAVI_LOG_PATH + File.separator + NAVI_LOG_DIR_XPLOG_NAME;
        DIR_PROTO_DATA_LOG = NAVI_LOG_PATH + File.separator + NAVI_LOG_DIR_PROT_NAME;
        DIR_CAPTURE_PATH = NAVI_LOG_PATH + File.separator + "capture";
        StringBuilder sb4 = new StringBuilder();
        sb4.append(NAVI_PATH);
        sb4.append("/data/navi/compile_v2/chn/");
        DIR_OFFLINE_RELATIVE_PATH = sb4.toString();
        ACTIVATE_SDCARD_DIR = SD_CARD_NAVI_PATH + File.separator + "activate";
        ACTIVATE_BACKUP_DIR = NAVI_PATH + File.separator + "activate";
        extsd_status = isExSDCardExist();
        sdcard_status = getSDCardState();
        LAN_DIR_OFFLINE_LANE_DATA_PATH = NAVI_PATH + "/lane/data/navi/ld/chn";
        LAN_DIR_LOC_LOG = DIR_LOC_LANE_LOG + File.separator + "pos_43/";
        SD_CARD_DIR_PC_CHECK = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_PC_CHECK_NAME;
        SD_CARD_ONLINEPATH = SD_CARD_NAVI_PATH + File.separator + SD_CARD_ONLINEPATH_NAME;
        SD_CARD_DIR_POS_320_CONTEXT = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_POS_CONTEXT_VERSION_320_NAME;
        SD_CARD_DIR_POS_430_CONTEXT = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_POS_CONTEXT_VERSION_430_NAME;
        SD_CARD_DIR_POS_520_CONTEXT = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_POS_CONTEXT_VERSION_520_NAME;
        SD_CARD_DIR_ROUTEDATA = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_ROUTEDATA_NAME;
        SD_CARD_DIR_GUIDE = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_GUIDE_NAME;
        SD_CARD_DIR_ACCOUNT_BEHAVIOR_SERVICE_FILE_PATH = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_ACCOUNT_BEHAVIOR_SERVICE_FILE_PATH_NAME;
        SD_CARD_DIR_ACCOUNT_SERVICE_FILE_PATH = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_ACCOUNT_SERVICE_FILE_PATH_NAME;
        SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH = SD_CARD_NAVI_PATH + File.separator + SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH_NAME;
        SD_CARD_DIR_MAP_FONT_CACHE_PATH = SD_CARD_NAVI_PATH + File.separator + "data/mapcache";
    }

    public static String getNaviPath() {
        return NAVI_PATH;
    }

    public static String getCapturePath() {
        return DIR_CAPTURE_PATH;
    }

    public static String getBLLogRootPath() {
        L.Tag tag = TAG;
        L.i(tag, "getBLLogRootPath : " + DIR_BL_LOG);
        return DIR_BL_LOG;
    }

    public static String getLogcatLogPath() {
        return DIR_LOGCAT_LOG;
    }

    public static String getBLLogLogPath() {
        return DIR_BL_LOG_LOG;
    }

    public static String getLocLogPath() {
        return DIR_LOC_LOG;
    }

    public static String getLogPath() {
        return NAVI_LOG_PATH;
    }

    public static String getDataPath() {
        return isTfExtSdExist() ? getNaviPath() : SD_CARD_NAVI_PATH;
    }

    public static boolean isTfExtSdExist() {
        return 2 == extsd_status;
    }

    public static boolean isWriteLogToFile() {
        return isTabletApp() || isTfExtSdExist();
    }

    public static int isExSDCardExist() {
        if (!new File(EXT_SD_CARD_DEV).exists()) {
            L.e(TAG, "Warning, no extsd card!!!!!");
            return 0;
        }
        File file = new File(getNaviPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            return 2;
        }
        L.e(TAG, "Warning, no external extsd !!!!!");
        return 1;
    }

    public static boolean isSdCardMount() {
        return 2 == sdcard_status;
    }

    public static int getSDCardState() {
        if (!new File(EXT_SD_CARD_DEV).exists()) {
            L.e(TAG, "Warning, no sd card!!!!!");
            return 0;
        }
        File file = new File(SD_CARD_NAVI_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            return 2;
        }
        L.e(TAG, "Warning, no external sd card!!!!!");
        return 1;
    }

    public static boolean isSdcardExist() {
        if (SD_CARD_NAVI_PATH.contains(Environment.getExternalStorageDirectory().getPath())) {
            return Environment.getExternalStorageState().equals("mounted");
        }
        return isTfExtSdExist();
    }

    public static String string2Unicode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            sb.append("\\u" + Integer.toHexString(charAt));
        }
        return sb.toString();
    }

    public static void init() {
        Context context = ContextUtils.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        sWidth = displayMetrics.widthPixels;
        sHeight = displayMetrics.heightPixels;
        sIsTabletApp = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            sPackageName = packageInfo.packageName;
            if ("com.xiaopeng.montecarlo.tablet".equals(sPackageName)) {
                sIsTabletApp = true;
            }
            sVersionName = packageInfo.versionName;
            sVersionCode = String.valueOf(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getScreenWidth() {
        return sWidth;
    }

    public static int getScreenHeight() {
        return sHeight;
    }

    public static int getLeftPanelWidth() {
        return sLeftPanelWidth;
    }

    public static void setLeftPanelWidth(int i) {
        sLeftPanelWidth = i;
    }

    public static int getLeftPanelHeight() {
        return sLeftPanelHeight;
    }

    public static void setLeftPanelHeight(int i) {
        sLeftPanelHeight = i;
    }

    public static String getFormatSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j / 1073741824 >= 1) {
            return decimalFormat.format(((float) j) / 1.0737418E9f) + "GB";
        } else if (j / 1048576 >= 1) {
            return decimalFormat.format(((float) j) / 1048576.0f) + "MB";
        } else if (j / 1024 >= 1) {
            return decimalFormat.format(((float) j) / 1024.0f) + "KB";
        } else {
            return j + ICarService.CAR_STAGE_B;
        }
    }

    public static boolean isEmptyString(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean canBllogAndLocBeOutput() {
        return isLogFileEnable() && isWriteLogToFile();
    }

    public static boolean isRemoteOpenLog() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_REMOTE_OPEN_LOG, false);
    }

    public static boolean isOpenNaviLogIn131() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_USER_DEBUG_VERSION, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_USER_DEBUG_VERSION);
    }

    public static boolean isLogcatEnabled() {
        return isTabletApp() || !isUserVersion() || (isUserVersion() && isSofrWareDev()) || isOpenNaviLogIn131();
    }

    public static boolean isDebugMenuEnabled() {
        if (isTabletApp() || !isUserVersion() || isOpenNaviLogIn131()) {
            return true;
        }
        return isUserVersion() && isSofrWareDev();
    }

    public static boolean isLogFileEnable() {
        return isTabletApp() || !isUserVersion() || isOpenNaviLogIn131();
    }

    public static boolean isUserVersion() {
        return BuildInfoUtils.isUserVersion();
    }

    public static boolean isSofrWareDev() {
        return CarFeatureManager.getSoftwareStage().equals("DEV");
    }

    public static boolean isTabletApp() {
        return sIsTabletApp;
    }

    public static String getVersionName() {
        return sVersionName;
    }

    public static int[] listToArray(Collection<Integer> collection) {
        if (collection == null) {
            L.w(TAG, "listToArray, list is null");
            return null;
        }
        return collection.stream().mapToInt(new ToIntFunction() { // from class: com.xiaopeng.montecarlo.root.util.-$$Lambda$UV1wDVoVlbcxpr8zevj_aMFtUGw
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Integer) obj).intValue();
            }
        }).toArray();
    }

    public static int[] listToArray(int i) {
        return new int[]{i};
    }

    public static ArrayList<Integer> intToList(int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(i));
        return arrayList;
    }

    public static boolean compareDouble(double d, double d2) {
        return Math.abs(d - d2) < 1.0000000116860974E-7d;
    }

    public static boolean compareFloat(float f, float f2) {
        return Math.abs(f - f2) < FLOAT_ACCURACY;
    }

    public static int getNavigationPanelHeight() {
        Context context = ContextUtils.getContext();
        if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return 0;
    }

    public static int getStatusBarHeight() {
        Context context = ContextUtils.getContext();
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int getVisibleBottom() {
        return getScreenHeight() - getNavigationPanelHeight();
    }

    public static int getViewHeight(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static int getViewWidth(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    public static String getVersionCode() {
        return sVersionCode;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static void saveTargetAccountProperty(Context context, UserInfo.UserType userType) {
        int type = AccountObservable.getType(userType);
        L.Tag tag = TAG;
        L.i(tag, "RootUtil saveTargetAccountProperty userType = " + userType + ", userHandle = " + type);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.XP_MONTECARLO_TARGET_ACCOUNT_PROPERTY, type);
    }

    public static UserInfo.UserType getTargetAccountProperty(Context context) {
        int i = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.XP_MONTECARLO_TARGET_ACCOUNT_PROPERTY, AccountObservable.getType(UserInfo.UserType.TEMP));
        L.Tag tag = TAG;
        L.i(tag, "RootUtil getTargetAccountProperty userHandle = " + i);
        return AccountObservable.getUserType(i);
    }

    public static void saveNaviAccountProperty(Context context, UserInfo.UserType userType) {
        int type = AccountObservable.getType(userType);
        L.Tag tag = TAG;
        L.i(tag, "RootUtil saveNaviAccountProperty userType = " + userType + ", userHandle = " + type);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.XP_MONTECARLO_NAVI_ACCOUNT_PROPERTY, type);
    }

    public static UserInfo.UserType getNaviAccountProperty(Context context) {
        int i = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.XP_MONTECARLO_NAVI_ACCOUNT_PROPERTY, AccountObservable.getType(UserInfo.UserType.TEMP));
        L.Tag tag = TAG;
        L.i(tag, "RootUtil getNaviAccountProperty userHandle = " + i);
        return AccountObservable.getUserType(i);
    }

    public static <T> List<T> deepCopy(List<T> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            List<T> list2 = (List) objectInputStream.readObject();
            objectOutputStream.close();
            objectInputStream.close();
            return list2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getUUID() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getUUID str:" + replaceAll);
        }
        return replaceAll;
    }

    public static String formatIntegerToString(int i, int i2) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumIntegerDigits(i2);
        decimalFormat.setMinimumIntegerDigits(i2);
        decimalFormat.setGroupingUsed(false);
        return decimalFormat.format(i);
    }

    public static String formatDoubleToString(double d, int i, int i2) {
        DecimalFormat decimalFormat = new DecimalFormat();
        if (i != -1) {
            decimalFormat.setMaximumIntegerDigits(i);
            decimalFormat.setMinimumIntegerDigits(i);
        }
        if (i2 != -1) {
            decimalFormat.setMaximumFractionDigits(i2);
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setGroupingUsed(false);
        return decimalFormat.format(d);
    }

    public static String getDoubleDecimal(double d, int i) {
        double floor = d - Math.floor(d);
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumIntegerDigits(i);
        decimalFormat.setMinimumFractionDigits(i);
        decimalFormat.setMaximumFractionDigits(0);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(false);
        decimalFormat.setMultiplier((int) Math.pow(10.0d, i));
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(floor);
    }

    public static String getAppVersionName(Context context) {
        return sVersionName;
    }

    public static void setCarSerivceDebugMode(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_CARSERVICE_MODE, z ? 3 : 0);
    }

    public static boolean isCarServiceDebugMode() {
        return DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_CARSERVICE_MODE, 0) == 3;
    }

    public static void delayExitApp(long j) {
        L.Tag tag = TAG;
        L.i(tag, "delayExitApp:" + j);
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.RootUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Process.killProcess(Process.myPid());
            }
        }, j);
    }

    public static void setStatusBarTransparent(Window window) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(0);
        }
    }

    public static String getTopActivityName() {
        try {
            return ((ActivityManager) ContextUtils.getContext().getSystemService("activity")).getRunningTasks(Integer.MAX_VALUE).get(0).topActivity.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isTopActivity(String str) {
        String topActivityName = getTopActivityName();
        boolean z = !TextUtils.isEmpty(topActivityName) && topActivityName.contains(str);
        L.Tag tag = TAG;
        L.i(tag, "isTopActivity mainName：" + str + ", topActivity:" + topActivityName + ", isTop: " + z);
        return z;
    }

    public static void startExceptionWatcher() {
        synchronized (TAG) {
            if (sExceptionWatcher == null) {
                L.i(TAG, "create ExceptionWatcher");
                sExceptionWatcher = new MapExceptionWatcher();
                WorkThreadUtil.getInstance().executeCachedTask(sExceptionWatcher);
            } else {
                MapExceptionWatcher.WorkStatus workStatus = sExceptionWatcher.getWorkStatus();
                if (MapExceptionWatcher.WorkStatus.WorkStatusIdle == workStatus) {
                    L.i(TAG, "start ExceptionWatcher");
                    WorkThreadUtil.getInstance().executeCachedTask(sExceptionWatcher);
                } else if (MapExceptionWatcher.WorkStatus.WorkStatusToClose == workStatus) {
                    sExceptionWatcher.restartWatcher();
                } else {
                    L.w(TAG, "RecordThread is running");
                }
            }
        }
    }

    public static void stopExceptionWatcher() {
        synchronized (TAG) {
            if (sExceptionWatcher != null) {
                L.i(TAG, "stop ExceptionWatcher");
                sExceptionWatcher.stopWatcher();
            }
        }
    }

    public static void updateMiniMapTimeTick() {
        synchronized (TAG) {
            if (sExceptionWatcher != null) {
                sExceptionWatcher.updateMiniMapTime();
            }
        }
    }

    public static void updateMapOperationTimeTick() {
        synchronized (TAG) {
            if (sExceptionWatcher != null) {
                sExceptionWatcher.updateMapOperationTime();
            }
        }
    }

    public static byte[] bitmap2Byte(@NonNull Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static void dumpOpenGLBuffer() {
        int width = sMapSize.getWidth();
        int height = sMapSize.getHeight();
        L.i(TAG, "dump surface begin: " + width + " x " + height);
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        GLES20.glReadPixels(0, 0, width, height, 6408, 5121, wrap);
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[(i2 * width) + i3];
                iArr2[(((height - i2) - 1) * width) + i3] = (i4 & (-16711936)) | ((i4 << 16) & 16711680) | ((i4 >> 16) & 255);
            }
        }
        Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).copyPixelsFromBuffer(wrap);
        saveBitmap(Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.ARGB_8888));
    }

    private static void saveBitmap(Bitmap bitmap) {
        File file = new File(DIR_BL_LOG_LOG);
        if (!file.exists()) {
            file.mkdir();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        String str = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + ".jpg";
        File file2 = new File(file, str);
        L.i(TAG, "dump:" + file + File.separator + str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static MapSize getMapSize() {
        return sMapSize;
    }

    public static void setMapSize(MapSize mapSize) {
        sMapSize = mapSize;
    }

    public static void testPing() {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.RootUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Process process;
                BufferedReader bufferedReader;
                BufferedReader bufferedReader2 = null;
                try {
                    process = Runtime.getRuntime().exec("/system/bin/ping -c 5 autoapi.amap.com");
                    try {
                        try {
                            if (!process.waitFor(10L, TimeUnit.SECONDS)) {
                                L.w(RootUtil.TAG, "/system/bin/ping -c 5 autoapi.amap.com timeout");
                                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                            } else if (process.exitValue() == 0) {
                                L.w(RootUtil.TAG, "testPing: succeed");
                                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                            } else {
                                bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                                try {
                                    L.w(RootUtil.TAG, "testPing: failed");
                                } catch (Exception e) {
                                    e = e;
                                    bufferedReader2 = bufferedReader;
                                    L.w(RootUtil.TAG, "testPing:" + e.getMessage());
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e2) {
                                            L.w(RootUtil.TAG, "BufferedReader close:" + e2.getMessage());
                                        }
                                    }
                                    if (process == null) {
                                        return;
                                    }
                                    process.destroy();
                                    L.w(RootUtil.TAG, "force stop:/system/bin/ping -c 5 autoapi.amap.com");
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e3) {
                                            L.w(RootUtil.TAG, "BufferedReader close:" + e3.getMessage());
                                        }
                                    }
                                    if (process != null) {
                                        process.destroy();
                                        L.w(RootUtil.TAG, "force stop:/system/bin/ping -c 5 autoapi.amap.com");
                                    }
                                    throw th;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                            int i = 0;
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null && i < 10) {
                                    L.i(RootUtil.TAG, readLine);
                                    i++;
                                } else {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e4) {
                                        L.w(RootUtil.TAG, "BufferedReader close:" + e4.getMessage());
                                    }
                                    if (process == null) {
                                        return;
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e6) {
                    e = e6;
                    process = null;
                } catch (Throwable th3) {
                    th = th3;
                    process = null;
                }
            }
        });
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static String getVin() {
        return isTabletApp() ? "TESTDAVID2ETSH005" : SystemPropertyUtil.getVIN();
    }

    public static String getHardwareId() {
        return isTabletApp() ? "1234567890" : SystemPropertyUtil.getHardwareId();
    }
}
