package com.xiaopeng.montecarlo.navcore.setting;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.setting.dto.NaviSettingInfo;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.TimeUtil;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SettingWrapper {
    public static final int AVOID_RESTRICTION_ROUTE = 512;
    public static final int BINDED_AMAP = 1;
    public static final int CHARGING_STATION_SHOW = 16384;
    public static final int CRUISE_AHEAD_TRAFFIC = 64;
    public static final int CRUISE_ELECTRONIC_EYE_BROADCAST = 128;
    public static final int CRUISE_SAFETY_BROADCAST = 256;
    public static final int DAY_NIGHT_MODE_AUTO = 2048;
    public static final int DAY_NIGHT_MODE_DAY = 4096;
    public static final int DAY_NIGHT_MODE_NIGHT = 8192;
    public static final long DEFAULT_VERSION = 0;
    public static final int MAP_DATA_UPDATE = 65536;
    public static final int MAP_DYNAMIC_LEVEL = 131072;
    public static final int MAP_LIGHTCOLUMN = 524288;
    public static final int MAP_THUMBNAIL = 262144;
    public static final int MINIMAP_MAPMODE_2D_CAR = 4194304;
    public static final int MINIMAP_MAPMODE_3D_CAR = 2097152;
    public static final int NAVI_DETAIL_BROADCAST = 16;
    public static final int NAVI_NORMAL_BROADCAST = 32;
    public static final int NAVI_ULTRA_SIMPLE_BROADCAST = 1048576;
    public static final int REAL_TIME_TRAFFIC = 32768;
    public static final int RECOMMEND_PARK = 16777216;
    public static final int ROUTE_PREF_AVOID_CHARGE = 2;
    public static final int ROUTE_PREF_AVOID_CONGESTION = 1;
    public static final int ROUTE_PREF_HIGHWAY_PRIORITY = 8;
    public static final int ROUTE_PREF_NO_FREEWAYS = 4;
    public static final int ROUTE_RADAR = 1024;
    public static final int SCRATCH_SPOT = 8388608;
    public static final int SETTING_VERSION_INDEX = 29;
    public static final int SETTING_VERSION_MAX = 7;
    public static final int TYPE_SHOW_NAVI_GUIDER = 1;
    public static final int TYPE_SHOW_SEC_BIND_AMAP = 2;
    public static final int WECHAT_SEND2CAR = 2;
    public static final int XP_APP_SEND2CAR = 4;
    @NonNull
    private static final L.Tag TAG = new L.Tag("SettingWrapper");
    @NonNull
    private static ArrayList sSettingList = new ArrayList();
    @NonNull
    private static ArrayList sSettingKeyList = new ArrayList();
    private static ArrayList<ISettingChangeNotify> sSettingChangeListener = new ArrayList<>();

    public static int getCurrentMinimapMapMode(int i) {
        return ((i & 2097152) != 2097152 && (i & 4194304) == 4194304) ? 1 : 2;
    }

    public static int getDefaultState() {
        return 27970592;
    }

    public static boolean isMapLightColumn() {
        return true;
    }

    public static int modifyAccountSettingVersion(int i, int i2) {
        return (i & 536870911) | ((i2 & 7) << 29);
    }

    public static int modifySettingPreference(int i, int i2, boolean z) {
        return z ? i | i2 : i & (~i2);
    }

    static {
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_NAVI);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_CRUISE);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE_RADER);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_CHARGING_STATION_SHOW);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_REAL_TIME_TRAFFIC);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_SCRATCH_SPOT);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_MAP_DATA_UPDATE);
        sSettingKeyList.add(DataSetHelper.AccountSet.KEY_SETTING_MAP_OVERVIEW);
        sSettingList.add(1);
        sSettingList.add(2);
        sSettingList.add(4);
        sSettingList.add(8);
        sSettingList.add(16);
        sSettingList.add(32);
        sSettingList.add(1048576);
        sSettingList.add(64);
        sSettingList.add(128);
        sSettingList.add(256);
        sSettingList.add(512);
        sSettingList.add(1024);
        sSettingList.add(2048);
        sSettingList.add(4096);
        sSettingList.add(8192);
        sSettingList.add(16384);
        sSettingList.add(32768);
        sSettingList.add(8388608);
        sSettingList.add(65536);
        sSettingList.add(262144);
        sSettingList.add(524288);
    }

    public static boolean isAvoidCongestionEnabled(int i) {
        return isSettingOptionSelected(i, 1);
    }

    public static boolean isAvoidChargeEnabled(int i) {
        return isSettingOptionSelected(i, 2);
    }

    public static boolean isNoFreewaysEnabled(int i) {
        return isSettingOptionSelected(i, 4);
    }

    public static boolean isHighwayPriorityEnabled(int i) {
        return isSettingOptionSelected(i, 8);
    }

    public static boolean isAutoDataDownloadEnabled(int i) {
        return isSettingOptionSelected(i, 65536);
    }

    public static boolean isDynamicLevelEnabled() {
        return isSettingOptionSelected(getAllSettingValue(), 131072);
    }

    public static boolean isRecommendParkEnabled() {
        return isSettingOptionSelected(getAllSettingValue(), 16777216);
    }

    public static boolean isSettingOptionSelected(int i, int i2) {
        if ((i & i2) == i2) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "isSettingOptionSelected source = [" + i + "], optionValue = [" + i2 + "]option is selected");
                return true;
            }
            return true;
        } else if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "isSettingOptionSelected source = [" + i + "], optionValue = [" + i2 + "]option is unSelected");
            return false;
        } else {
            return false;
        }
    }

    public static int resetDefaultSetting() {
        int defaultState = getDefaultState();
        saveSettingPreference(defaultState);
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CAR_LOGO, "carlocation_default");
        return defaultState;
    }

    public static void saveSettingPreference(int i) {
        saveSettingPreference(1, i);
    }

    public static void saveSettingPreference(int i, int i2) {
        if (i == 1) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, String.valueOf(i2));
        } else if (i == 2) {
            DataSetHelper.AccountSet.setBL(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, String.valueOf(i2));
        } else if (i == 3) {
            DataSetHelper.AccountSet.setXP(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, String.valueOf(i2));
        } else if (i == 0) {
            DataSetHelper.AccountSet.setNone(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, String.valueOf(i2));
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveSettingPreference  key_setting_preference value =" + i2);
        }
        ArrayList arrayList = sSettingKeyList;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str = (String) sSettingKeyList.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    saveItemGroupChangeSettingPref(i, i2, str);
                }
            }
        }
    }

    public static boolean isOpenPlateSwitch() {
        return isSettingOptionSelected(getAllSettingValue(), 512);
    }

    public static void openPlateSwitch() {
        int allSettingValue = getAllSettingValue() | 512;
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, allSettingValue);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveSettingPreference  key_setting_preference value =" + allSettingValue);
        }
        SettingBLManager.getInstance().setETARestriction();
    }

    public static void resetAllSettingState() {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, getDefaultState());
        if (L.ENABLE) {
            L.d(TAG, "save key_setting_preference reset default status");
        }
    }

    public static int getAllSettingValue() {
        int compatibleLowVersion = compatibleLowVersion(DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, getDefaultState()));
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " setting_preference value =" + compatibleLowVersion);
        }
        return compatibleLowVersion;
    }

    public static int getAccountSettingVersion() {
        int allSettingValue = (getAllSettingValue() >> 29) & 7;
        L.Tag tag = TAG;
        L.i(tag, "getAccountSettingVersion:" + allSettingValue);
        return allSettingValue;
    }

    private static int compatibleLowVersion(int i) {
        if ((i & 524288) == 0 && (262144 & i) == 0) {
            if (L.ENABLE) {
                L.d(TAG, "is contain map_light_column524288");
            }
            return i | 524288;
        }
        return i;
    }

    public static String getLicensePlate() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_SETTING_PREFERENCE_LICENCE_PLATE, null);
    }

    public static void saveLicensePlate(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveLicensePlate=" + str);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SETTING_PREFERENCE_LICENCE_PLATE, str);
        SettingBLManager.getInstance().setVehicleId(str);
    }

    public static void cleanRestrictStatus() {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_RESTRICT_NAME, "");
    }

    public static void saveBindAMapStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveBindAMapStatus=" + z);
        }
        DataSetHelper.AccountSet.set(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_BIND_AMAP_STATUS, getAccountUId()), z);
    }

    public static String getAccountUId() {
        String valueOf = String.valueOf(XPAccountServiceWrapper.getInstance().getUserId());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "accountUid =" + valueOf);
        }
        return valueOf;
    }

    public static void saveIsAMapAccount(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveBindAMapStatus=" + z);
        }
        DataSetHelper.AccountSet.set(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_IS_AMAP_ACCOUNT, getAccountUId()), z);
    }

    public static boolean isAMapAccount() {
        boolean z = DataSetHelper.AccountSet.getBoolean(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_IS_AMAP_ACCOUNT, getAccountUId()), false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap isAMapAccount =" + z);
        }
        return z;
    }

    public static boolean getBindAMapStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_BIND_AMAP_STATUS, getAccountUId()), false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindAmap getBindAMapStatus=" + z);
        }
        return z;
    }

    public static void setBindAMapStatusValue(int i) {
        DataSetHelper.AccountSet.set(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_BIND_AMAP_STATUS_INT, getAccountUId()), i);
    }

    public static int getBindAMapStatusValue() {
        int i = DataSetHelper.AccountSet.getInt(String.format("%s%s", DataSetHelper.AccountSet.KEY_CHECK_BIND_AMAP_STATUS_INT, getAccountUId()), -1);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap getBindAMapStatusValue=" + i);
        }
        return i;
    }

    private static void saveItemGroupChangeSettingPref(int i, int i2, @NonNull String str) {
        int itemGroupSelectedValue = i2 & getItemGroupSelectedValue(str);
        if (i == 1) {
            DataSetHelper.AccountSet.set(str, itemGroupSelectedValue);
        } else if (i == 3) {
            DataSetHelper.AccountSet.setXP(str, itemGroupSelectedValue);
        } else if (i == 2) {
            DataSetHelper.AccountSet.setBL(str, itemGroupSelectedValue);
        } else if (i == 0) {
            DataSetHelper.AccountSet.setNone(str, itemGroupSelectedValue);
        }
        if (DataSetHelper.AccountSet.KEY_SETTING_CHANGE_NAVI.equals(str)) {
            notifyBroadcastStyleChange();
        } else if (DataSetHelper.AccountSet.KEY_SETTING_CHANGE_CRUISE.equals(str)) {
            SettingBLManager.getInstance().setCruiseBroadcast();
        } else if (DataSetHelper.AccountSet.KEY_SETTING_REAL_TIME_TRAFFIC.equals(str)) {
            SettingBLManager.getInstance().setTrafficState();
        } else if (DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE_RADER.equals(str)) {
            SettingBLManager.getInstance().setRadarState();
        } else if (DataSetHelper.AccountSet.KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE.equals(str)) {
            SettingBLManager.getInstance().setETARestriction();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "saveItemGroupChangeSettingPref  options key=" + str + ";value=" + itemGroupSelectedValue);
        }
    }

    public static int getCurrentBroadcastStyle() {
        int allSettingValue = getAllSettingValue();
        if (isSettingOptionSelected(allSettingValue, 16)) {
            return 1;
        }
        return (!isSettingOptionSelected(allSettingValue, 32) && isSettingOptionSelected(allSettingValue, 1048576)) ? 3 : 2;
    }

    public static int getCurrentMinimapMapMode() {
        return getCurrentMinimapMapMode(getAllSettingValue());
    }

    public static void notifyBroadcastStyleChange() {
        int currentBroadcastStyle = getCurrentBroadcastStyle();
        Iterator<ISettingChangeNotify> it = sSettingChangeListener.iterator();
        while (it.hasNext()) {
            it.next().onPlayStyleChange(currentBroadcastStyle);
        }
    }

    public static void addSettingChangeListener(ISettingChangeNotify iSettingChangeNotify) {
        if (sSettingChangeListener.contains(iSettingChangeNotify)) {
            return;
        }
        sSettingChangeListener.add(iSettingChangeNotify);
    }

    public static void removeSettingChangeListener(ISettingChangeNotify iSettingChangeNotify) {
        sSettingChangeListener.remove(iSettingChangeNotify);
    }

    public static int getMapMode() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_SETTING_MAP_MODE, 0);
    }

    public static void saveMapMode(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_SETTING_MAP_MODE, i);
    }

    public static String getChargeDbVersion() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_CHARGE_DB_VERSION, "");
    }

    public static void setChargeDbVersion(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_CHARGE_DB_VERSION, str);
    }

    public static void setChargeDataUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.SEARCH_CHARGE_UPDATE_TIME, j);
    }

    public static String getKeywordConfigVersion() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_KEYWORD_CONFIG_VERSION, "");
    }

    public static void setKeywordConfigVersion(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_KEYWORD_CONFIG_VERSION, str);
    }

    public static void setKeywordConfigUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_KEYWORD_CONFIG_UPDATE_TIME, j);
    }

    public static String getXPServiceCenterDataVersion() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_XPSERVICE_CENTER_DATA_VERSION, "");
    }

    public static void setXPServiceCenterDataVersion(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_XPSERVICE_CENTER_DATA_VERSION, str);
    }

    public static void setXPServiceCenterUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_XPSERVICE_CENTER_UPDATE_TIME, j);
    }

    public static String getXPScratchSpotDataVersion() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_XPSCRATCH_SPOT_DATA_VERSION, "");
    }

    public static void setXPScratchSpotDataVersion(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_XPSCRATCH_SPOT_DATA_VERSION, str);
    }

    public static void setXPScratchSpotUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_XPSCRATCH_SPOT_UPDATE_TIME, j);
    }

    public static long getLccGeoFenceDataVersion() {
        return DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_LCC_GEO_FENCE_DATA_VERSION, 0L);
    }

    public static void setLccGeoFenceDataVersion(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_LCC_GEO_FENCE_DATA_VERSION, j);
    }

    public static long getLccGeoFenceUpdateTime() {
        return DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.LCC_GEO_FENCE_DATA_UPDATE_TIME, 0L);
    }

    public static void setLccGeoFenceUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.LCC_GEO_FENCE_DATA_UPDATE_TIME, j);
    }

    public static String getSeamlessDataVersion() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_SEAMLESS_DATA_VERSION, "");
    }

    public static void setSeamlessDataVersion(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SEAMLESS_DATA_VERSION, str);
    }

    public static void setSeamlessUpdateTime(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SEAMLESS_UPDATE_TIME, j);
    }

    public static void setSRCarModelVersion(long j) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SR_CAR_MODEL_VERSION, j);
    }

    public static long getSRCarModelVersion() {
        return DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_SR_CAR_MODEL_VERSION, 0L);
    }

    public static String getSeamlessDataPath() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_SEAMLESS_DATA_PATH, "");
    }

    public static void setSeamlessDataPath(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SEAMLESS_DATA_PATH, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getItemGroupSelectedValue(String str) {
        char c;
        switch (str.hashCode()) {
            case -2142702100:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1493812555:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_CRUISE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -683882410:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_CHARGING_STATION_SHOW)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -611187668:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE_RADER)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -409904021:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_MAP_OVERVIEW)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -214675075:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_REAL_TIME_TRAFFIC)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 173058438:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_NAVI)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1073954921:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1862362774:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_SCRATCH_SPOT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2070218444:
                if (str.equals(DataSetHelper.AccountSet.KEY_SETTING_MAP_DATA_UPDATE)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 15;
            case 1:
                return 1048624;
            case 2:
                return MarkUtils.MARKER_ID_DEBUG_GPS;
            case 3:
                return 512;
            case 4:
                return 1024;
            case 5:
                return 16384;
            case 6:
                return 8388608;
            case 7:
                return 32768;
            case '\b':
                return 65536;
            case '\t':
                return 786432;
            default:
                return -1;
        }
    }

    public static boolean isNaviDetailBroadcast() {
        return isSettingOptionSelected(getAllSettingValue(), 16);
    }

    public static boolean isNaviNormalBroadcast() {
        return isSettingOptionSelected(getAllSettingValue(), 32);
    }

    public static boolean isNaviUltraSimpleBroadcast() {
        return isSettingOptionSelected(getAllSettingValue(), 1048576);
    }

    public static boolean isMapThumbnail() {
        return isSettingOptionSelected(getAllSettingValue(), 262144);
    }

    public static boolean isCruiseSafetyBroadcast() {
        return isSettingOptionSelected(getAllSettingValue(), 256);
    }

    public static boolean isOpenRadar() {
        return isSettingOptionSelected(getAllSettingValue(), 1024);
    }

    public static void setRadarStatus(boolean z) {
        int allSettingValue = getAllSettingValue();
        if (isSettingOptionSelected(allSettingValue, 1024) != z) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE, z ? allSettingValue | 1024 : allSettingValue ^ 1024);
        }
        SettingBLManager.getInstance().setRadarState();
    }

    public static boolean isCruiseAheadTraffict() {
        return isSettingOptionSelected(getAllSettingValue(), 64);
    }

    public static boolean isCruiseElectronicEyeBroadcast() {
        return isSettingOptionSelected(getAllSettingValue(), 128);
    }

    public static boolean isDayNightModeAuto() {
        return isSettingOptionSelected(getAllSettingValue(), 2048);
    }

    public static boolean isDayNightModeNight() {
        return isSettingOptionSelected(getAllSettingValue(), 8192);
    }

    public static boolean isDayNightModeDay() {
        return isSettingOptionSelected(getAllSettingValue(), 4096);
    }

    public static boolean isRealTimeTraffic() {
        return isSettingOptionSelected(getAllSettingValue(), 32768);
    }

    public static boolean isChargeEnable() {
        return isSettingOptionSelected(getAllSettingValue(), 16384);
    }

    public static boolean isScratchSpotEnable() {
        return isSettingOptionSelected(getAllSettingValue(), 8388608);
    }

    public static long computerNextShowDate(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        if (i < 3 && i > 0) {
            calendar.add(5, 1);
        } else if (i >= 3 && i < 10) {
            calendar.add(5, 4);
            calendar.getTimeInMillis();
        } else if (i < 10 || i >= 20) {
            return -1L;
        } else {
            calendar.add(5, 31);
        }
        if (L.ENABLE) {
            String format = new SimpleDateFormat(TimeFormatUtil.DEFAULT_PATTERN).format(calendar.getTime());
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("showguider type= [");
            sb.append(i2 == 1 ? "TYPE_SHOW_NAVI_GUIDER" : "TYPE_SHOW_SEC_BIND_AMAP");
            sb.append("] next time=");
            sb.append(i);
            sb.append("<<<< calendar2.getTimeInMillis() = ");
            sb.append(calendar.getTimeInMillis());
            sb.append("format date=");
            sb.append(format);
            L.d(tag, sb.toString());
        }
        return calendar.getTimeInMillis();
    }

    public static void resetSeamlessGuideNextShow() {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_SHOW_RULE + getAccountUId(), "");
    }

    public static void saveSeamlessGuideNextShow(int i) {
        String seamlessGuideNextShow = getSeamlessGuideNextShow(i);
        if (TextUtils.isEmpty(seamlessGuideNextShow)) {
            if (i == 1) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_SHOW_RULE + getAccountUId(), "1," + computerNextShowDate(1, i));
                return;
            } else if (i == 2) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEC_BIND_AMAP_SHOW_RULE + getAccountUId(), "1," + computerNextShowDate(1, i));
                return;
            } else {
                return;
            }
        }
        String[] split = seamlessGuideNextShow.split(",");
        if (split == null || split.length != 2) {
            return;
        }
        int parseInt = Integer.parseInt(split[0]) + 1;
        if (i == 1) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_SHOW_RULE + getAccountUId(), parseInt + "," + computerNextShowDate(parseInt, i));
        } else if (i == 2) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEC_BIND_AMAP_SHOW_RULE + getAccountUId(), parseInt + "," + computerNextShowDate(parseInt, i));
        }
    }

    public static String getSeamlessGuideNextShow(int i) {
        if (i == 1) {
            return DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_SHOW_RULE + getAccountUId(), "");
        } else if (i == 2) {
            return DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_CHECK_SEC_BIND_AMAP_SHOW_RULE + getAccountUId(), "");
        } else {
            return "";
        }
    }

    public static boolean isShowEnterSeamlessNavi(int i) {
        String seamlessGuideNextShow = getSeamlessGuideNextShow(i);
        boolean z = true;
        if (!TextUtils.isEmpty(seamlessGuideNextShow)) {
            String[] split = seamlessGuideNextShow.split(",");
            if (split.length == 2) {
                int parseInt = Integer.parseInt(split[0]);
                z = (parseInt > 20 || parseInt <= 0) ? false : TimeUtil.isSameDayOrAfter(System.currentTimeMillis(), Long.parseLong(split[1]));
            }
        }
        if (z) {
            saveGuideFistTimeShow(Long.valueOf(System.currentTimeMillis()), i);
        }
        return z;
    }

    public static void saveGuideFistTimeShow(Long l, int i) {
        if (i == 1) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_FIST_TIME_SHOW + getAccountUId(), l.longValue());
        } else if (i == 2) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CHECK_SEC_BIND_AMAP_FIST_TIME_SHOW + getAccountUId(), l.longValue());
        }
    }

    public static Long getGuideFirstShowTime(int i) {
        if (i == 1) {
            return Long.valueOf(DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_CHECK_SEAMLESS_GUIDE_FIST_TIME_SHOW + getAccountUId(), -1L));
        } else if (i == 2) {
            return Long.valueOf(DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_CHECK_SEC_BIND_AMAP_FIST_TIME_SHOW + getAccountUId(), -1L));
        } else {
            return -1L;
        }
    }

    @Deprecated
    public static void saveSend2CarOrBindAmap(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_BIND_AMAP_OR_SEND2CAR, i);
    }

    @Deprecated
    public static int getSend2CarOrBindAmap() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_BIND_AMAP_OR_SEND2CAR, 0);
    }

    public static void saveFirstBindAmap(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_FIRST_BIND_AMAP + getAccountUId(), z);
    }

    public static boolean getFistBindAmap() {
        return DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_FIRST_BIND_AMAP + getAccountUId(), false);
    }

    public static boolean getAmapHomeConflictStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_AMAP_HOME_CONFLICT_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAmapHomeConflictStatus status =" + z);
        }
        return z;
    }

    public static void setAmapHomeConflictStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_HOME_CONFLICT_STATUS, z);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAmapHomeConflictStatus  KEY_AMAP_HOME_CONFLICT_STATUS status =" + z);
        }
    }

    public static void setAmapHomeConflictAddress(String str) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_HOME_CONFLICT_JSON, str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAmapHomeConflictAddress json =" + str);
        }
    }

    public static String getAMapHomeConflictAddress() {
        String string = DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_AMAP_HOME_CONFLICT_JSON, "");
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAMapHomeConflictAddress json =" + string);
        }
        return string;
    }

    public static boolean getAMapCompanyConflictStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_AMAP_COMPANY_CONFLICT_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAMapCompanyConflictStatus status =" + z);
        }
        return z;
    }

    public static void setAMapCompanyConflictStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_COMPANY_CONFLICT_STATUS, z);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAMapCompanyConflictStatus status =" + z);
        }
    }

    public static String getAMapCompanyConflictAddress() {
        String string = DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_AMAP_COMPANY_CONFLICT_JSON, "");
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAMapCompanyConflictAddress json =" + string);
        }
        return string;
    }

    public static void setAMapCompanyConflictAddress(String str) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_COMPANY_CONFLICT_JSON, str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAMapCompanyConflictAddress json =" + str);
        }
    }

    public static String getBlAccountProfile() {
        String string = DataSetHelper.AccountSet.getString(String.format("%s%s", DataSetHelper.AccountSet.KEY_BL_ACCOUNT_PROFILE_JSON, getAccountUId()), "");
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getBlAccountProfile json =" + string);
        }
        return string;
    }

    public static void setBlAccountProfile(String str) {
        DataSetHelper.AccountSet.set(String.format("%s%s", DataSetHelper.AccountSet.KEY_BL_ACCOUNT_PROFILE_JSON, getAccountUId()), str);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setBlAccountProfile profileJson = " + str);
        }
    }

    public static boolean getFavoriteSyncStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_FAVORITE_SYNC_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getFavoriteSyncStatus success = " + z);
        }
        return z;
    }

    public static void setFavoriteSyncStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_FAVORITE_SYNC_STATUS, z);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setFavoriteSyncStatus success = " + z);
        }
    }

    public static long getBlFavSyncTime() {
        long j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_BL_FAVORITE_SYNC_TIME, 0L);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getBlFavSyncTime time = " + j);
        }
        return j;
    }

    public static void setBlFavSyncTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_BL_FAVORITE_SYNC_TIME, j);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setBlFavSyncTime time = " + j);
        }
    }

    public static boolean getAccountDataUploadStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAccountDataUploadStatus success = " + z);
        }
        return z;
    }

    public static void setAccountDataUploadStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_STATUS, z);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountDataUploadStatus success = " + z);
        }
    }

    public static long getAccountDataUploadTime() {
        long j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_TIME, 0L);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAccountDataUploadTime time = " + j);
        }
        return j;
    }

    public static void setAccountDataUploadTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_TIME, j);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountDataUploadTime time = " + j);
        }
    }

    public static int getAccountDataUploadCount() {
        int i = DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_COUNT, 0);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAccountDataUploadCount count = " + i);
        }
        return i;
    }

    public static void setAccountDataUploadCount(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_UPLOAD_COUNT, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountDataUploadCount count = " + i);
        }
    }

    public static boolean getAccountDataPullStatus() {
        boolean z = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_PULL_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAccountDataPullStatus success = " + z);
        }
        return z;
    }

    public static void setAccountDataPullStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_PULL_STATUS, z);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountDataPullStatus success = " + z);
        }
    }

    public static long getAccountDataPullTime() {
        long j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_PULL_TIME, 0L);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getAccountDataPullTime time = " + j);
        }
        return j;
    }

    public static void setAccountDataPullTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_DATA_PULL_TIME, j);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountDataPullTime time = " + j);
        }
    }

    public static long getBlCookieLastTime() {
        long j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_BL_COOKIE_REFRESH_LAST_TIME, 0L);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getBlCookieLastTime lastTime =" + j);
        }
        return j;
    }

    public static void setBlCookieLastTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_BL_COOKIE_REFRESH_LAST_TIME, j);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setBlCookieLastTime lastTime =" + j);
        }
    }

    @Deprecated
    public static void saveAMapLoginStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap saveAMapLoginStatus=" + z);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_CHECK_AMAP_LOGIN_STATUS, z);
    }

    @Deprecated
    public static boolean getAMapLoginStatus() {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_CHECK_AMAP_LOGIN_STATUS, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap getAMapLoginStatus status =" + z);
        }
        return z;
    }

    public static void saveAccountSid(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_MAP_SERVER_ACCOUNT_SID, str);
    }

    public static void saveAccountOpenId(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_MAP_SERVER_ACCOUNT_OPENID, str);
    }

    public static String getAccountSid() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_MAP_SERVER_ACCOUNT_SID, "");
    }

    public static String getAccountOpenId() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_MAP_SERVER_ACCOUNT_OPENID, "");
    }

    public static void saveLastAccountOpenId(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_MAP_SERVER_LAST_ACCOUNT_OPENID, str);
    }

    public static void saveLastAccountSid(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_MAP_SERVER_LAST_ACCOUNT_SID, str);
    }

    public static String getLastAccountSid() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_MAP_SERVER_LAST_ACCOUNT_SID, "");
    }

    public static String getLastAccountOpenId() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_MAP_SERVER_LAST_ACCOUNT_OPENID, "");
    }

    public static String getTargetAccountUserId() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_ACCOUNT_CENTER_TARGET_USERID, "-1");
    }

    public static void setTargetAccountUserId(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ACCOUNT_CENTER_TARGET_USERID, str);
    }

    public static String getNaviAccountUserId() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.KEY_ACCOUNT_CENTER_NAVI_USERID, "");
    }

    public static void setNaviAccountUserId(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ACCOUNT_CENTER_NAVI_USERID, str);
    }

    public static boolean getAmapFirstSyncState() {
        return DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_IS_FIRST_AMAP_SYNC, true);
    }

    public static void setAmapFirstSyncState(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_IS_FIRST_AMAP_SYNC, z);
    }

    public static boolean getAmapLoginStatus() {
        return DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_AMAP_LOGIN_STATUS, false);
    }

    public static void setAmapLoginStatus(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_LOGIN_STATUS, z);
    }

    public static String getCurrentAMapLoginXpUserId() {
        return DataSetHelper.GlobalSet.getString(DataSetHelper.AccountSet.KEY_AMAP_LOGIN_XP_USER_ID, "");
    }

    public static void setCurrentAMapLoginXpUserId(String str) {
        DataSetHelper.GlobalSet.set(DataSetHelper.AccountSet.KEY_AMAP_LOGIN_XP_USER_ID, str);
    }

    public static boolean checkShowSecBindDialog() {
        if (XPAccountServiceWrapper.getInstance().isLoginXp() && isAMapAccount()) {
            if (L.ENABLE) {
                L.d(TAG, "showsecBinddialog xp logined  and netconnected");
            }
            if (getBindAMapStatusValue() != -1 || getBindAMapStatus()) {
                return false;
            }
            if (L.ENABLE) {
                L.d(TAG, "showsecBinddialog not bind amap ");
            }
            if (isShowEnterSeamlessNavi(2)) {
                if (L.ENABLE) {
                    L.d(TAG, "showsecBinddialog show navi_guider ");
                }
                saveSeamlessGuideNextShow(2);
                return true;
            }
            if (System.currentTimeMillis() > getGuideFirstShowTime(2).longValue() + XpCacheConsts.ONE_DAY || !L.ENABLE) {
                return false;
            }
            L.d(TAG, "showsecBinddialog one day one time");
            return false;
        }
        return false;
    }

    public static int getLocalVersion() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_DATA_SYNC_LOCAL_VERSION, 0);
    }

    public static void setLocalVersion(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_LOCAL_VERSION, i);
    }

    public static int getDeletedAllNormalFavVersion() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_DATA_SYNC_DELETED_ALL_NORMAL_FAV_VERSION, 0);
    }

    public static void setDeletedAllNormalFavVersion(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_DELETED_ALL_NORMAL_FAV_VERSION, i);
    }

    public static int getDeletedAllNormalHistoryVersion() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_DATA_SYNC_DELETED_ALL_HISTORY_VERSION, 0);
    }

    public static void setDeletedAllNormalHistoryVersion(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_DELETED_ALL_HISTORY_VERSION, i);
    }

    public static int getServerVersion() {
        return DataSetHelper.AccountSet.getInt(DataSetHelper.AccountSet.KEY_DATA_SYNC_SERVER_VERSION, 0);
    }

    public static void setServerVersion(int i) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_SERVER_VERSION, i);
    }

    public static long getDataSyncSuccessTime() {
        return DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_DATA_SYNC_SUCCESS_TIME, 0L);
    }

    public static void setDataSyncSuccessTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_SUCCESS_TIME, j);
    }

    public static long getDataSyncRecordTime() {
        return DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_DATA_SYNC_LASTEST_RECORD_TIME, 0L);
    }

    public static void setDataSyncRecordTime(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_LASTEST_RECORD_TIME, j);
    }

    public static boolean getVolumeMuteState() {
        return DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_MAP_VOLUME_MUTE_STATE, false);
    }

    public static void setVolumeMuteState(boolean z) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_MAP_VOLUME_MUTE_STATE, z);
    }

    public static void saveAMapCheckToken(String str) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_AMAP_CHECK_TOKEN_RESPONSE, str);
    }

    public static String getAMapCheckToken() {
        return DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_AMAP_CHECK_TOKEN_RESPONSE, "");
    }

    public static void saveCarLogo(String str) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_CAR_LOGO, str);
    }

    public static String getCarLogo() {
        return DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_CAR_LOGO, "carlocation_default");
    }

    public static NaviSettingInfo getCurrentSettingInfo() {
        NaviSettingInfo naviSettingInfo = new NaviSettingInfo();
        int allSettingValue = getAllSettingValue();
        boolean isAvoidCongestionEnabled = isAvoidCongestionEnabled(allSettingValue);
        boolean isAvoidChargeEnabled = isAvoidChargeEnabled(allSettingValue);
        naviSettingInfo.setAvoidChargeEnable(isAvoidChargeEnabled).setAvoidCongestionEnable(isAvoidCongestionEnabled).setHighwayPriorityEnable(isHighwayPriorityEnabled(allSettingValue)).setNoFreewaysEnable(isNoFreewaysEnabled(allSettingValue));
        return naviSettingInfo;
    }

    public static void saveAccountMaxFavoriteVersion(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_FAVORITE_MAX_VERSION, j);
    }

    public static long getAccountMaxFavoriteVersion() {
        return DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_ACCOUNT_FAVORITE_MAX_VERSION, 0L);
    }

    public static void saveAccountMaxHistoryVersion(long j) {
        DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ACCOUNT_HISTORY_MAX_VERSION, j);
    }

    public static long getAccountMaxHistoryVersion() {
        return DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.KEY_ACCOUNT_HISTORY_MAX_VERSION, 0L);
    }

    public static boolean isFirstTimeUserEnterSR() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_FIRST_USER_ENTER_SR, true);
    }

    public static void setFirstTimeUserEnterSR(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setIsFirstTimeEnterSR isFirstEnterSr:" + z);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_IS_FIRST_USER_ENTER_SR, z);
    }

    public static boolean needBroadEnterLaneWhenExitNgp() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_NEED_BROAD_ENTER_LANE_WHEN_QUIT_NGP, true) && DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_LANE_DISPLAY, true);
    }

    public static void setNeedBroadEnterLaneWhenExitNgp(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setNeedBroadEnterLaneWhenExitNgp needBroad:" + z);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NEED_BROAD_ENTER_LANE_WHEN_QUIT_NGP, z);
    }

    public static boolean canEnterSRWhenEnterHDArea() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_SHOULD_AUTO_ENTER_SR, false);
    }

    public static void setCanAutoEnterSRWhenEnterHDArea(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setShouldAutoEnterSR canAutoEnterSR:" + z);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_SHOULD_AUTO_ENTER_SR, z);
    }
}
