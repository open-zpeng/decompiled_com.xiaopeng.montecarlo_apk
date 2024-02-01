package com.autonavi.common.tool.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
/* loaded from: classes.dex */
public class CrashSharePreference {
    private static final String CRASH_SP = "CRASH_SP";
    public static final String LAST_CRASH_TIMES = "LAST_CRASH_TIMES";
    private static SharedPreferences mSharePreference;

    private static SharedPreferences getInstance(Context context) {
        if (mSharePreference == null) {
            mSharePreference = context.getApplicationContext().getSharedPreferences(CRASH_SP, 0);
        }
        return mSharePreference;
    }

    public static int getIntFormSP(Context context, String str, int i) {
        return getInstance(context).getInt(str, i);
    }

    public static void setIntToSP(Context context, String str, int i) {
        getInstance(context).edit().putInt(str, i).commit();
    }

    public static String getStringFormSP(Context context, String str, String str2) {
        return getInstance(context).getString(str, str2);
    }

    public static void setStringToSP(Context context, String str, String str2) {
        getInstance(context).edit().putString(str, str2).commit();
    }

    public static Set<String> getStringSetFormSP(Context context, String str, Set<String> set) {
        return getInstance(context).getStringSet(str, set);
    }

    public static void setStringSetToSP(Context context, String str, Set<String> set) {
        getInstance(context).edit().putStringSet(str, set).commit();
    }

    public static boolean getBooleanFormSP(Context context, String str, boolean z) {
        return getInstance(context).getBoolean(str, z);
    }

    public static void setBooleanToSP(Context context, String str, boolean z) {
        getInstance(context).edit().putBoolean(str, z).commit();
    }
}
