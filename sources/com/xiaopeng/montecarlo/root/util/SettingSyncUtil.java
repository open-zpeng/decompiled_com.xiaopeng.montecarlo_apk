package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class SettingSyncUtil {
    public static final String ACCOUNT_KEY_SETTING_PREFERENCE = "account_key_setting_preference";
    private static final String GLOBAL_KEY_LICENCE_PLATE = "account_key_licence_plate";
    public static final String SYNC_CAR_LOGO_KEY = "sync_car_logo_key";
    public static final String SYNC_CRUISE_ANGLE_KEY = "sync_cruise_angle_key";
    public static final String SYNC_NAVI_ANGLE_KEY = "sync_navi_angle_key";
    public static final String SYNC_VOLUME_ON_KEY = "sync_volume_on_key";
    public static final HashMap<String, String> sAccountKeysMap = new HashMap<>();
    public static final HashMap<String, String> sGlobalKeysMap = new HashMap<>();
    public static final String[] sExcludeSettingKeys = {DataSetHelper.GlobalSet.KEY_SETTING_PREFERENCE_LICENCE_PLATE};

    static {
        sAccountKeysMap.put(ACCOUNT_KEY_SETTING_PREFERENCE, DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE);
        sAccountKeysMap.put(SYNC_CRUISE_ANGLE_KEY, DataSetHelper.AccountSet.MAP_MODULE_DEFAULT_MAP_MODE);
        sAccountKeysMap.put(SYNC_NAVI_ANGLE_KEY, DataSetHelper.AccountSet.NAV_MODULE_DEFAULT_MAP_MODE);
        sAccountKeysMap.put(SYNC_VOLUME_ON_KEY, DataSetHelper.AccountSet.KEY_MAP_VOLUME_MUTE_STATE);
        sAccountKeysMap.put(SYNC_CAR_LOGO_KEY, DataSetHelper.AccountSet.KEY_CAR_LOGO);
        sGlobalKeysMap.put(GLOBAL_KEY_LICENCE_PLATE, DataSetHelper.GlobalSet.KEY_SETTING_PREFERENCE_LICENCE_PLATE);
    }

    public static boolean isExcludeSettingKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = sExcludeSettingKeys;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static boolean isAccountSettingKeys(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return sAccountKeysMap.containsValue(str);
    }

    public static boolean isGlobalSettingKeys(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return sGlobalKeysMap.containsValue(str);
    }

    public static String getOriginKey(@NonNull String str, boolean z) {
        if (z) {
            return sGlobalKeysMap.get(str);
        }
        return sAccountKeysMap.get(str);
    }

    public static String getCustomKey(@NonNull String str, boolean z) {
        Set<Map.Entry<String, String>> entrySet;
        if (z) {
            entrySet = sGlobalKeysMap.entrySet();
        } else {
            entrySet = sAccountKeysMap.entrySet();
        }
        for (Map.Entry<String, String> entry : entrySet) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
