package com.xiaopeng.montecarlo.root.provider.dataset;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/* loaded from: classes2.dex */
public class DataSetHelper {
    private static List<DataSetChangeListener> sSetChangeListenerList = new ArrayList();

    /* loaded from: classes2.dex */
    public interface DataSetChangeListener {
        void dataChange(int i, boolean z, String str, String str2);

        void onAccountSetLoadComplete();
    }

    public static void registerDataSetChangeListener(DataSetChangeListener dataSetChangeListener) {
        sSetChangeListenerList.add(dataSetChangeListener);
    }

    public static void unRegisterDataSetChangeListener(DataSetChangeListener dataSetChangeListener) {
        sSetChangeListenerList.remove(dataSetChangeListener);
    }

    public static void invokeDataSetChangeListener(int i, boolean z, String str, String str2) {
        for (DataSetChangeListener dataSetChangeListener : sSetChangeListenerList) {
            dataSetChangeListener.dataChange(i, z, str, str2);
        }
    }

    public static void invokeAccountSetLoadComplete() {
        for (DataSetChangeListener dataSetChangeListener : sSetChangeListenerList) {
            dataSetChangeListener.onAccountSetLoadComplete();
        }
    }

    /* loaded from: classes2.dex */
    public static class AccountSet {
        public static final String ACCOUNT_CONFIG_WECHAT_QRCODE = "account.config.wechat.qrcode";
        public static final String ACC_USE_COUNTER = "key_acc_use_counter";
        public static final String AUTHORITY = "montecarlo.account";
        public static final String CACHE_ALERT_COUNT_FOR_SETTING_COMPANY_BY_SYSTEM = "CACHE_ALERT_COUNT_FOR_SETTING_COMPANY_BY_SYSTEM";
        public static final String CACHE_ALERT_COUNT_FOR_SETTING_HOME_BY_SYSTEM = "CACHE_ALERT_COUNT_FOR_SETTING_HOME_BY_SYSTEM";
        public static final String CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_COMPANY = "CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_COMPANY";
        public static final String CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_HOME = "CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_HOME";
        public static final String CACHE_IS_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM_IN_OFF_DAY = "CACHE_IS_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM_IN_OFF_DAY";
        public static final String CACHE_IS_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM_IN_WORKING_DAY = "CACHE_IS_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM_IN_WORKING_DAY";
        public static final String CACHE_IS_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM_IN_OFF_DAY = "CACHE_IS_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM_IN_OFF_DAY";
        public static final String CACHE_IS_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM_IN_WORKING_DAY = "CACHE_IS_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM_IN_WORKING_DAY";
        public static final String CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_CLOUD = "CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_CLOUD";
        public static final String CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM = "CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_SYSTEM";
        public static final String CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_CLOUD = "CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_CLOUD";
        public static final String CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM = "CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_SYSTEM";
        public static final String KEY_ACCOUNT_DATA_PULL_STATUS = "key_account_data_pull_status";
        public static final String KEY_ACCOUNT_DATA_PULL_TIME = "key_account_data_pull_time";
        public static final String KEY_ACCOUNT_DATA_UPLOAD_COUNT = "key_account_data_upload_count";
        public static final String KEY_ACCOUNT_DATA_UPLOAD_STATUS = "key_account_data_upload_status";
        public static final String KEY_ACCOUNT_DATA_UPLOAD_TIME = "key_account_data_upload_time";
        public static final String KEY_ACCOUNT_FAVORITE_MAX_VERSION = "key_favorite_max_version";
        public static final String KEY_ACCOUNT_HISTORY_MAX_VERSION = "key_history_max_version";
        public static final String KEY_AMAP_CHECK_TOKEN_RESPONSE = "key_amap_check_token_response";
        public static final String KEY_AMAP_COMPANY_CONFLICT_JSON = "key_amap_company_conflict_json";
        public static final String KEY_AMAP_COMPANY_CONFLICT_STATUS = "key_amap_company_conflict_status";
        public static final String KEY_AMAP_HOME_CONFLICT_JSON = "key_amap_home_conflict_json";
        public static final String KEY_AMAP_HOME_CONFLICT_STATUS = "key_amap_home_conflict_status";
        public static final String KEY_AMAP_LOGIN_STATUS = "key_amap_login_status";
        public static final String KEY_AMAP_LOGIN_XP_USER_ID = "key_amap_login_xp_user_id";
        public static final String KEY_BIND_AMAP_OR_SEND2CAR = "key_bind_amap_or_send2car";
        public static final String KEY_BL_ACCOUNT_PROFILE_JSON = "key_bl_account_profile_json";
        public static final String KEY_BL_COOKIE_REFRESH_LAST_TIME = "key_bl_cookie_refresh_last_time";
        public static final String KEY_BL_FAVORITE_SYNC_TIME = "key_bl_favorite_sync_time";
        public static final String KEY_CAR_LOGO = "key_car_logo";
        public static final String KEY_CHECK_BIND_AMAP_STATUS = "key_check_bind_amap_status";
        public static final String KEY_CHECK_BIND_AMAP_STATUS_INT = "key_check_bind_amap_status_int";
        public static final String KEY_CHECK_IS_AMAP_ACCOUNT = "key_check_is_amap_account";
        public static final String KEY_CHECK_SEAMLESS_GUIDE_FIST_TIME_SHOW = "key_check_seamless_guide_fist_time_show";
        public static final String KEY_CHECK_SEAMLESS_GUIDE_SHOW_RULE = "key_check_seamless_guide_show_rule";
        public static final String KEY_CHECK_SEC_BIND_AMAP_FIST_TIME_SHOW = "key_check_sec_bind_amap_fist_time_show";
        public static final String KEY_CHECK_SEC_BIND_AMAP_SHOW_RULE = "key_check_sec_bind_amap_show_rule";
        public static final String KEY_DATA_SYNC_DELETED_ALL_HISTORY_VERSION = "key_data_sync_deleted_version";
        public static final String KEY_DATA_SYNC_DELETED_ALL_NORMAL_FAV_VERSION = "key_data_sync_deleted_all_normal_fav_version";
        public static final String KEY_DATA_SYNC_LASTEST_RECORD_TIME = "key_data_sync_lastest_record_time";
        public static final String KEY_DATA_SYNC_LOCAL_VERSION = "key_data_sync_local_version";
        public static final String KEY_DATA_SYNC_SERVER_VERSION = "key_data_sync_server_version";
        public static final String KEY_DATA_SYNC_SUCCESS_TIME = "key_data_sync_success_time";
        public static final String KEY_FAVORITE_SYNC_STATUS = "key_favorite_sync_status";
        public static final String KEY_FIRST_BIND_AMAP = "key_first_bind_amap";
        private static final String KEY_INIT = "data.init";
        public static final String KEY_IS_FIRST_AMAP_SYNC = "key_is_first_amap_sync";
        public static final String KEY_MAP_VOLUME_MUTE_STATE = "key_map_volume_mute_state";
        public static final String KEY_ROUTE_CHARGE_FIRST_ENABLE = "key_route_charge_first_enable";
        public static final String KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE = "key_setting_change_avoid_restriction_route";
        public static final String KEY_SETTING_CHANGE_CHARGING_STATION_SHOW = "key_setting_change_charging_station_show";
        public static final String KEY_SETTING_CHANGE_CRUISE = "key_setting_change_cruise";
        public static final String KEY_SETTING_CHANGE_NAVI = "key_setting_change_navi";
        public static final String KEY_SETTING_CHANGE_ROUTE = "key_setting_change_route";
        public static final String KEY_SETTING_CHANGE_ROUTE_RADER = "key_setting_change_route_rader";
        public static final String KEY_SETTING_MAP_DATA_UPDATE = "key_setting_map_data_update";
        public static final String KEY_SETTING_MAP_MODE = "key_setting_map_mode";
        public static final String KEY_SETTING_MAP_OVERVIEW = "key_setting_map_overview";
        public static final String KEY_SETTING_PREFERENCE = "key_setting_preference";
        public static final String KEY_SETTING_REAL_TIME_TRAFFIC = "key_setting_real_time_traffic";
        public static final String KEY_SETTING_SCRATCH_SPOT = "key_setting_scratch_spot";
        public static final String KEY_USR_PROFILE_VISIT_CITIES = "key_visit_cities";
        public static final String MAP_MODULE_DEFAULT_MAP_MODE = "MAP_MODULE_DEFAULT_MAP_MODE";
        public static final String NAV_MODULE_DEFAULT_MAP_MODE = "NAV_MODULE_DEFAULT_MAP_MODE";
        public static final String URI_PATH_ALL = "all";
        public static final String URI_PATH_SET = "set";
        public static final String URI_PATH_SET_VALUE = "set/*";
        public static final Uri PERSON_CONTENT_URI = Uri.parse("content://montecarlo.account/set");
        private static final Hashtable<String, String> CACHED_MAP = new Hashtable<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (r3 != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
            if (r3 == null) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
            com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.invokeAccountSetLoadComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void loadUserData(android.database.Cursor r3) {
            /*
                java.util.Hashtable<java.lang.String, java.lang.String> r0 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP
                r0.clear()
                if (r3 == 0) goto L39
                boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                if (r0 == 0) goto L39
            Ld:
                java.lang.String r0 = "name"
                int r0 = r3.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                java.lang.String r1 = "value"
                int r1 = r3.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                if (r2 != 0) goto L33
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                if (r2 != 0) goto L33
                java.util.Hashtable<java.lang.String, java.lang.String> r2 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                r2.put(r0, r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            L33:
                boolean r0 = r3.moveToNext()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                if (r0 != 0) goto Ld
            L39:
                java.util.Hashtable<java.lang.String, java.lang.String> r0 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                java.lang.String r1 = "data.init"
                java.lang.String r2 = "True"
                r0.put(r1, r2)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
                if (r3 == 0) goto L50
                goto L4d
            L45:
                r0 = move-exception
                goto L54
            L47:
                r0 = move-exception
                com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r0)     // Catch: java.lang.Throwable -> L45
                if (r3 == 0) goto L50
            L4d:
                r3.close()
            L50:
                com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.invokeAccountSetLoadComplete()
                return
            L54:
                if (r3 == 0) goto L59
                r3.close()
            L59:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.loadUserData(android.database.Cursor):void");
        }

        public static void clearCache() {
            CACHED_MAP.clear();
        }

        public static Uri getUriFor(String str) {
            return getUriFor(PERSON_CONTENT_URI, str);
        }

        public static Uri getUriFor(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }

        private static void setString(final int i, final String str, final String str2) {
            String str3 = CACHED_MAP.get(str);
            if ((str3 != null) && str3.equals(str2)) {
                return;
            }
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.1
                @Override // java.lang.Runnable
                public void run() {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str2);
                    contentValues.put("name", str);
                    try {
                        Uri insert = ContextUtils.getContext().getContentResolver().insert(AccountSet.PERSON_CONTENT_URI, contentValues);
                        if (insert == null || ContentUris.parseId(insert) <= 0) {
                            return;
                        }
                        DataSetHelper.invokeDataSetChangeListener(i, false, str, str2);
                    } catch (Exception e) {
                        DatabaseExceptionUtil.handleException(e);
                    }
                }
            });
            CACHED_MAP.put(str, str2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
            if (r1 == null) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.String getString(java.lang.String r10) {
            /*
                java.util.Hashtable<java.lang.String, java.lang.String> r0 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP
                java.lang.Object r0 = r0.get(r10)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L5b
                java.util.Hashtable<java.lang.String, java.lang.String> r1 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP
                java.lang.String r2 = "data.init"
                java.lang.Object r1 = r1.get(r2)
                if (r1 != 0) goto L5b
                r1 = 0
                android.content.Context r2 = com.xiaopeng.montecarlo.root.util.ContextUtils.getContext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.net.Uri r2 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.PERSON_CONTENT_URI     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.net.Uri r4 = android.net.Uri.withAppendedPath(r2, r10)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                if (r1 == 0) goto L3f
                boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                if (r2 == 0) goto L3f
                java.lang.String r2 = "value"
                int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                java.lang.String r0 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            L3f:
                if (r0 == 0) goto L46
                java.util.Hashtable<java.lang.String, java.lang.String> r2 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.CACHED_MAP     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                r2.put(r10, r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            L46:
                if (r1 == 0) goto L5b
            L48:
                r1.close()
                goto L5b
            L4c:
                r10 = move-exception
                goto L55
            L4e:
                r10 = move-exception
                com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r10)     // Catch: java.lang.Throwable -> L4c
                if (r1 == 0) goto L5b
                goto L48
            L55:
                if (r1 == 0) goto L5a
                r1.close()
            L5a:
                throw r10
            L5b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.AccountSet.getString(java.lang.String):java.lang.String");
        }

        public static void set(String str, String str2) {
            setString(1, str, str2);
        }

        public static void set(String str, int i) {
            setString(1, str, String.valueOf(i));
        }

        public static void set(String str, boolean z) {
            setString(1, str, String.valueOf(z));
        }

        public static void set(String str, long j) {
            setString(1, str, String.valueOf(j));
        }

        public static void setBL(String str, String str2) {
            setString(2, str, str2);
        }

        public static void setBL(String str, int i) {
            setString(2, str, String.valueOf(i));
        }

        public static void setBL(String str, boolean z) {
            setString(2, str, String.valueOf(z));
        }

        public static void setBL(String str, long j) {
            setString(2, str, String.valueOf(j));
        }

        public static void setXP(String str, String str2) {
            setString(3, str, str2);
        }

        public static void setXP(String str, int i) {
            setString(3, str, String.valueOf(i));
        }

        public static void setXP(String str, boolean z) {
            setString(3, str, String.valueOf(z));
        }

        public static void setXP(String str, long j) {
            setString(3, str, String.valueOf(j));
        }

        public static void setNone(String str, String str2) {
            setString(0, str, str2);
        }

        public static void setNone(String str, int i) {
            setString(0, str, Integer.toString(i));
        }

        public static void setNone(String str, boolean z) {
            setString(0, str, String.valueOf(z));
        }

        public static void setNone(String str, long j) {
            setString(0, str, Long.toString(j));
        }

        public static String getString(String str, String str2) {
            String string = getString(str);
            if (string == null) {
                if (str2 != null) {
                    CACHED_MAP.put(str, str2);
                    return str2;
                }
                return str2;
            }
            return string;
        }

        public static int getInt(String str, int i) {
            String string = getString(str);
            if (string == null) {
                CACHED_MAP.put(str, String.valueOf(i));
                return i;
            }
            return Integer.parseInt(string);
        }

        public static boolean getBoolean(String str, boolean z) {
            String string = getString(str);
            if (string == null) {
                CACHED_MAP.put(str, String.valueOf(z));
                return z;
            }
            return Boolean.valueOf(string).booleanValue();
        }

        public static long getLong(String str, long j) {
            String string = getString(str);
            if (string == null) {
                CACHED_MAP.put(str, String.valueOf(j));
                return j;
            }
            return Long.parseLong(string);
        }
    }

    /* loaded from: classes2.dex */
    public static class GlobalSet {
        public static final String AUTHORITY = "montecarlo.global";
        public static final String CACHE_BL_LOG_IS_SYNC = "CACHE_BL_LOG_IS_SYNC";
        public static final String CACHE_DEBUG_ROOT = "CACHE_DEBUG_MONTECARLO";
        public static final String CACHE_FUCTION_ACCOUNT_SERVICE_ENV = "CACHE_FUCTION_ACCOUNT_SERVICE_ENV";
        public static final String CACHE_FUCTION_ASSISTANT_SERVICE_ENV = "CACHE_FUCTION_ASSISTANT_SERVICE_ENV";
        public static final String CACHE_FUCTION_BIZ_SERVICE_ENV = "CACHE_FUCTION_BIZ_SERVICE_ENV";
        public static final String CACHE_FUCTION_CHARGE_SERVICE_ENV = "CACHE_FUCTION_CHARGE_SERVICE_ENV";
        public static final String CACHE_FUCTION_CHARGE_STATION_SERVICE_ENV = "CACHE_FUCTION_CHARGE_STATION_SERVICE_ENV";
        public static final String CACHE_FUCTION_RECOMMEND_PARKING_SERVICE_ENV = "CACHE_FUCTION_RECOMMEND_PARKING_SERVICE_ENV";
        public static final String CACHE_FUCTION_XP_COMMON_CONFIG_SERVICE_ENV = "CACHE_FUCTION_XP_COMMON_CONFIG_SERVICE_ENV";
        public static final String CACHE_IS_COPY_EHP_LOG = "CACHE_IS_COPY_EHP_LOG";
        public static final String CACHE_IS_OPEN_BL_LOG = "CACHE_IS_OPEN_BL_LOG";
        public static final String CACHE_IS_OPEN_CAMERA_DEGREE = "CACHE_IS_OPEN_CAMERA_DEGREE";
        public static final String CACHE_IS_OPEN_CAPTURE = "CACHE_IS_OPEN_CAPTURE";
        public static final String CACHE_IS_OPEN_LANE_RECORD_PLAY = "CACHE_IS_OPEN_LANE_RECORD";
        public static final String CACHE_IS_OPEN_LOC_LOG = "CACHE_IS_OPEN_LOC_LOG";
        public static final String CACHE_IS_OPEN_XP_LOG = "CACHE_IS_OPEN_XP_LOG";
        public static final String CACHE_IS_OPEN_XP_RECOMMEND_PARK = "CACHE_IS_OPEN_XP_RECOMMEND_PARK";
        public static final String CACHE_IS_RECORD_SET_LOCATION = "CACHE_IS_RECORD_SET_LOCATION";
        public static final String CACHE_IS_REMOTE_OPEN_LOG = "CACHE_IS_REMOTE_OPEN_LOG";
        public static final String CACHE_IS_SHOW_VOLUME_PANEL = "CACHE_IS_SHOW_VOLUME_PANEL";
        public static final String CACHE_IS_USER_DEBUG_VERSION = "CACHE_IS_USER_DEBUG_VERSION";
        public static final String CACHE_LAST_REPORT_OPEN_BL_TIME = "CACHE_LAST_REPORT_OPEN_BL_TIME";
        public static final String CACHE_LAST_TIME_FOR_VIN_LICENSE_PLATE = "cache_last_time_for_vin_license_plate";
        public static final String CACHE_LAST_USER_VOLUME_VALUE = "CACHE_LAST_USER_VOLUME_VALUE";
        public static final String CACHE_MAP_SERVER_SERVICE_ENV = "CACHE_MAP_SERVER_SERVICE_ENV";
        public static final String CACHE_SERVICE_XP_XUI_SERVICE_ENV = "CACHE_SERVICE_XP_XUI_SERVICE_ENV";
        public static final String CLEAR_RUBBISH_FLAG = "CLEAR_RUBBISH_FLAG";
        public static final String DAY_NIGHT_MODE_SET = "DAY_NIGHT_MODE_SET";
        public static final String DEBUG_ASYNCTASK_THREADCOUNT = "debug_load_threads_count";
        public static final String DEBUG_FBO_CONTROL = "debug_fbo_control";
        public static final String DEBUG_MAP_CACHE_FACTOR = "debug_map_cache_factor";
        public static final String DEBUG_MAP_SAMPLES = "debug_anti_aliasing";
        public static final String DEBUG_MAP_TEXTSCALE_SETTING = "debug_map_display_setting";
        public static final String DEBUG_MAP_ZOOM_SCALE_RATIO = "debug_map_zoom_scale_ratio";
        public static final boolean DEFAULT_VALUE_IS_DEFAULT_ENABLE_LANE_DISPLAY = true;
        public static final boolean DEFAULT_VALUE_IS_DEFAULT_ENABLE_NGP = false;
        public static final boolean DEFAULT_VALUE_IS_DEFAULT_ENABLE_ODD_DISPLAY = false;
        public static final boolean DEFAULT_VALUE_IS_DEFAULT_PLAY_PROTO = false;
        public static final boolean DEFAULT_VALUE_IS_NAVI_DEBUG_BUTTON_ENABLE = false;
        public static final boolean DEFAULT_VALUE_IS_RESTORE_EXPLORE = false;
        public static final boolean DEFAULT_VALUE_IS_SEND_V2_DATA_BY_SOCKET = false;
        public static final boolean DEFAULT_VALUE_IS_SHOW_SR_DATA = false;
        public static final boolean DEFAULT_VALUE_IS_SR_DATA_RECORD = false;
        public static final String KEY_ACCOUNT_CENTER_NAVI_USERID = "key_account_center_navi_userid";
        public static final String KEY_ACCOUNT_CENTER_TARGET_USERID = "key_account_center_target_userid";
        public static final String KEY_BLSDK_ACTIVATE_RESULT = "key_blsdk_activate_result_new";
        public static final String KEY_CAR_WASH_DATA_UPDATE_TIME = "key_car_wash_data_update_time";
        public static final String KEY_CAR_WASH_DATA_VERSION = "key_car_wash_data_version";
        public static final String KEY_CHARGE_DB_VERSION = "key_charge_db_version";
        public static final String KEY_CHECK_AMAP_LOGIN_STATUS = "key_check_amap_login_status";
        public static final String KEY_CURRENT_CITY_AD_CODE = "key_current_adcode";
        public static final String KEY_ENABLE_LANE_DISPLAY = "key_enable_lane_display";
        public static final String KEY_ENABLE_LCC_GEO_FENCE = "key_enable_lcc_geo_fence";
        public static final String KEY_ENABLE_NGP = "key_enable_ngp";
        public static final String KEY_ENABLE_ODD_DISPLAY = "key-enable_odd_display";
        public static final String KEY_GNSS_OUTAGE_ERROR = "key_gnss_outage_error";
        public static final String KEY_GNSS_OUTAGE_WARNING = "key_gnss_outage_warning";
        private static final String KEY_INIT = "data.init";
        public static final String KEY_IS_DEFAULT_PLAY_PROTO = "key_is_default_play_proto";
        public static final String KEY_IS_FIRST_USER_ENTER_SR = "key_is_first_user_enter_sr";
        public static final String KEY_IS_NAVI_DEBUG_BUTTON_ENABLE = "key_is_navi_debug_button_enable";
        public static final String KEY_IS_RESTORE_EXPLORE_STATUS = "key_is_restore_explore_status";
        public static final String KEY_IS_SEND_V2_DATA_BY_SOCKET = "key_is_send_v2_data_by_socket";
        public static final String KEY_IS_SHOW_SR_DATA = "key_is_show_sr_data";
        public static final String KEY_IS_SR_DATA_RECORD = "key_is_sr_data_record";
        public static final String KEY_KEYWORD_CONFIG_UPDATE_TIME = "key_keyword_config_update_time";
        public static final String KEY_KEYWORD_CONFIG_VERSION = "key_keyword_config_version";
        public static final String KEY_LAST_SYS_VERSION = "last_key_system_version";
        public static final String KEY_LCC_GEO_FENCE_DATA_VERSION = "key_lcc_geo_fence_data_version";
        public static final String KEY_MAP_SERVER_ACCOUNT_OPENID = "key_map_server_account_openid";
        public static final String KEY_MAP_SERVER_ACCOUNT_SID = "key_map_server_account_sid";
        public static final String KEY_MAP_SERVER_LAST_ACCOUNT_OPENID = "key_map_server_last_account_openid";
        public static final String KEY_MAP_SERVER_LAST_ACCOUNT_SID = "key_map_server_last_account_sid";
        public static final String KEY_NAVIGATION_STATUS = "key_navigation_status";
        public static final String KEY_NAVI_REBOOT_CARSERVICE_MODE = "key_navi_reboot_carserive_mode";
        public static final String KEY_NAVI_REBOOT_DR_MODE = "key_navi_reboot_dr_mode";
        public static final String KEY_NAVI_VERSION = "key_navi_version";
        public static final String KEY_NAVI_VERSION_CODE = "key_navi_version_code";
        public static final String KEY_NAVI_VOLUME_LAST_USER_MUTE = "key_navi_volume_last_user_mute";
        public static final String KEY_NEED_BROAD_ENTER_LANE_WHEN_QUIT_NGP = "key_need_broad_enter_lane_quit_ngp";
        public static final String KEY_POWER_OFF_LAST_TIME_STAMP = "key_last_power_off_time";
        public static final String KEY_RELAUNCH_NAVI = "key_relaunch_navi";
        public static final String KEY_RESTRICT_NAME = "RESTRICT_TIPS";
        public static final String KEY_ROUTE_LAST_DISTANCE = "key_route_last_distance";
        public static final String KEY_ROUTE_LAST_LINEAR_DISTANCE = "key_route_last_linear_distance";
        public static final String KEY_SCRATCHSPOT_BOARDCAST_HISTORY = "key_scratchspot_boardcast_history";
        public static final String KEY_SEAMLESS_DATA_PATH = "key_seamless_data_path";
        public static final String KEY_SEAMLESS_DATA_VERSION = "key_seamless_data_version";
        public static final String KEY_SEAMLESS_UPDATE_TIME = "key_seamless_update_time";
        public static final String KEY_SETTING_PREFERENCE_LICENCE_PLATE = "key_setting_preference_Licence_plate";
        public static final String KEY_SHOULD_AUTO_ENTER_SR = "key_should_auto_enter_sr";
        public static final String KEY_SR_CAR_MODEL_VERSION = "key_sr_car_model_version";
        public static final String KEY_XPSCRATCH_SPOT_DATA_VERSION = "key_xpscratch_spot_data_version";
        public static final String KEY_XPSCRATCH_SPOT_UPDATE_TIME = "key_xpscratch_spot_update_time";
        public static final String KEY_XPSERVICE_CENTER_DATA_VERSION = "key_xpservice_center_data_version";
        public static final String KEY_XPSERVICE_CENTER_UPDATE_TIME = "key_xpservice_center_update_time";
        public static final String LANE_MAP_NUM_DATA = "LANE_MAP_NUM_DATA";
        public static final String LANE_MAP_NUM_LAST_UPDATE_TIME = "LANE_MAP_NUM_LAST_UPDATE_TIME";
        public static final String LCC_GEO_FENCE_DATA_UPDATE_TIME = "lcc_geo_fence_data_update_time";
        public static final String MAP_NUM_DATA = "MAP_NUM_DATA";
        public static final String MAP_NUM_LAST_UPDATE_MONTH = "MAP_NUM_LAST_UPDATE_MONTH";
        public static final String POWER_DIS_ENERGY = "POWER_DIS_ENERGY";
        public static final String POWER_DIS_LAST_UPDATE_TIME = "POWER_DIS_LAST_UPDATE_TIME";
        public static final String ROUTE_HISTORY_LINEAR_DISTANCE_KEY = "route_history_linear_distance";
        public static final String ROUTE_HISTROY_DISTANCE_KEY = "route_histroy_distance";
        public static final String ROUTE_HISTROY_LASTMODIFY_KEY = "route_histroy_lastmodify";
        public static final String SEARCH_CHARGE_UPDATE_TIME = "key_search_charge_update_time";
        public static final String SETTING_ALL_PROVINCE_SIZE = "setting_all_province_size";
        public static final String URI_PATH_ALL = "all";
        public static final String URI_PATH_SET = "set";
        public static final String URI_PATH_SET_VALUE = "set/*";
        public static final String VALUE_LAST_LOCAL_SAVE_DIR = "value_last_local_save_dir";
        public static final String VALUE_LAST_LOCAL_SAVE_LAT = "value_last_local_save_lat";
        public static final String VALUE_LAST_LOCAL_SAVE_LON = "value_last_local_save_lon";
        public static final int VALUE_NAVI_REBOOT_MODE_CAR_SERVICE = 3;
        public static final int VALUE_NAVI_REBOOT_MODE_CLEAR_LOG = 2;
        public static final int VALUE_NAVI_REBOOT_MODE_GPS = 1;
        public static final int VALUE_NAVI_REBOOT_MODE_NORMAL = 0;
        public static final String XP_MONTECARLO_NAVI_ACCOUNT_PROPERTY = "sys.xp.montecarlo_navi_account";
        public static final String XP_MONTECARLO_TARGET_ACCOUNT_PROPERTY = "sys.xp.montecarlo_target_account";
        public static final Uri PERSON_CONTENT_URI = Uri.parse("content://montecarlo.global/set");
        private static final Hashtable<String, String> CACHED_MAP = new Hashtable<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void loadApplicationData(Cursor cursor) {
            CACHED_MAP.clear();
            try {
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("name");
                                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("value");
                                String string = cursor.getString(columnIndexOrThrow);
                                String string2 = cursor.getString(columnIndexOrThrow2);
                                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                    CACHED_MAP.put(string, string2);
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (Exception e) {
                        DatabaseExceptionUtil.handleException(e);
                        if (cursor == null) {
                            return;
                        }
                    }
                }
                CACHED_MAP.put(KEY_INIT, "True");
                if (cursor == null) {
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public static Uri getUriFor(String str) {
            return getUriFor(PERSON_CONTENT_URI, str);
        }

        public static Uri getUriFor(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }

        private static void setString(final int i, final String str, final String str2) {
            String str3 = CACHED_MAP.get(str);
            if ((str3 != null) && str3.equals(str2)) {
                return;
            }
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.1
                @Override // java.lang.Runnable
                public void run() {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str2);
                    contentValues.put("name", str);
                    try {
                        Uri insert = ContextUtils.getContext().getContentResolver().insert(GlobalSet.PERSON_CONTENT_URI, contentValues);
                        if (insert == null || ContentUris.parseId(insert) <= 0) {
                            return;
                        }
                        DataSetHelper.invokeDataSetChangeListener(i, true, str, str2);
                    } catch (Exception e) {
                        DatabaseExceptionUtil.handleException(e);
                    }
                }
            });
            CACHED_MAP.put(str, str2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
            if (r1 == null) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.String getString(java.lang.String r10) {
            /*
                java.util.Hashtable<java.lang.String, java.lang.String> r0 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.CACHED_MAP
                java.lang.Object r0 = r0.get(r10)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L5b
                java.util.Hashtable<java.lang.String, java.lang.String> r1 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.CACHED_MAP
                java.lang.String r2 = "data.init"
                java.lang.Object r1 = r1.get(r2)
                if (r1 != 0) goto L5b
                r1 = 0
                android.content.Context r2 = com.xiaopeng.montecarlo.root.util.ContextUtils.getContext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.net.Uri r2 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.PERSON_CONTENT_URI     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                android.net.Uri r4 = android.net.Uri.withAppendedPath(r2, r10)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                if (r1 == 0) goto L3f
                boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                if (r2 == 0) goto L3f
                java.lang.String r2 = "value"
                int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                java.lang.String r0 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            L3f:
                if (r0 == 0) goto L46
                java.util.Hashtable<java.lang.String, java.lang.String> r2 = com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.CACHED_MAP     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
                r2.put(r10, r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            L46:
                if (r1 == 0) goto L5b
            L48:
                r1.close()
                goto L5b
            L4c:
                r10 = move-exception
                goto L55
            L4e:
                r10 = move-exception
                com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r10)     // Catch: java.lang.Throwable -> L4c
                if (r1 == 0) goto L5b
                goto L48
            L55:
                if (r1 == 0) goto L5a
                r1.close()
            L5a:
                throw r10
            L5b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper.GlobalSet.getString(java.lang.String):java.lang.String");
        }

        public static void set(String str, String str2) {
            setString(1, str, str2);
        }

        public static void set(String str, int i) {
            setString(1, str, Integer.toString(i));
        }

        public static void set(String str, double d) {
            setString(1, str, Double.toString(d));
        }

        public static void set(String str, boolean z) {
            setString(1, str, String.valueOf(z));
        }

        public static void set(String str, float f) {
            setString(1, str, String.valueOf(f));
        }

        public static void set(String str, long j) {
            setString(1, str, Long.toString(j));
        }

        public static void setBL(String str, String str2) {
            setString(2, str, str2);
        }

        public static void setBL(String str, int i) {
            setString(2, str, Integer.toString(i));
        }

        public static void setBL(String str, boolean z) {
            setString(2, str, String.valueOf(z));
        }

        public static void setBL(String str, long j) {
            setString(3, str, Long.toString(j));
        }

        public static void setXP(String str, String str2) {
            setString(3, str, str2);
        }

        public static void setXP(String str, int i) {
            setString(3, str, Integer.toString(i));
        }

        public static void setXP(String str, boolean z) {
            setString(3, str, String.valueOf(z));
        }

        public static void setXP(String str, long j) {
            setString(3, str, Long.toString(j));
        }

        public static void setNone(String str, String str2) {
            setString(0, str, str2);
        }

        public static void setNone(String str, int i) {
            setString(0, str, Integer.toString(i));
        }

        public static void setNone(String str, boolean z) {
            setString(0, str, String.valueOf(z));
        }

        public static void setNone(String str, long j) {
            setString(0, str, Long.toString(j));
        }

        public static String getString(String str, String str2) {
            String string = getString(str);
            return string == null ? str2 : string;
        }

        public static int getInt(String str, int i) {
            String string = getString(str);
            return string == null ? i : Integer.valueOf(string).intValue();
        }

        public static double getDouble(String str, double d) {
            String string = getString(str);
            return string == null ? d : Double.valueOf(string).doubleValue();
        }

        public static float getFloat(String str, float f) {
            String string = getString(str);
            return string == null ? f : Float.valueOf(string).floatValue();
        }

        public static boolean getBoolean(String str, boolean z) {
            String string = getString(str);
            return string == null ? z : Boolean.valueOf(string).booleanValue();
        }

        public static long getLong(String str, long j) {
            String string = getString(str);
            return string == null ? j : Long.valueOf(string).longValue();
        }
    }
}
