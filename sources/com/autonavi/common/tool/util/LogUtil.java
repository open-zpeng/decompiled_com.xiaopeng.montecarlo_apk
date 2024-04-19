package com.autonavi.common.tool.util;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public class LogUtil {
    private static final String DEFAULT_TAG = "DumpCrash";
    private static boolean gEnable = true;

    public static void setLogSwitch(boolean z) {
        gEnable = z;
    }

    public static void logE(String str) {
        logE(null, str);
    }

    public static void logE(String str, String str2) {
        if (gEnable) {
            if (TextUtils.isEmpty(str)) {
                str = DEFAULT_TAG;
            }
            Log.e(str, str2);
        }
    }
}
