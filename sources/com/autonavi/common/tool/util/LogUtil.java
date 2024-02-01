package com.autonavi.common.tool.util;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public class LogUtil {
    private static final String DEFAULT_TAG = "DumpCrash";
    public static final int LOG_SWITCH_ALL = 33791;
    public static final int LOG_SWITCH_BACKTRACE = 4;
    public static final int LOG_SWITCH_BASIC_INFO = 32768;
    public static final int LOG_SWITCH_EXTRA_INFO = 512;
    public static final int LOG_SWITCH_FD_LIST = 64;
    public static final int LOG_SWITCH_IMPORTANT_INFO = 1;
    public static final int LOG_SWITCH_MAPS = 32;
    public static final int LOG_SWITCH_MEMORY_NEARBY = 16;
    public static final int LOG_SWITCH_SIGNAL = 2;
    public static final int LOG_SWITCH_SO_INFO = 256;
    public static final int LOG_SWITCH_STACK = 8;
    public static final int LOG_SWITCH_SYSTEM_INFO = 128;
    private static int mLogSwitch;

    public static void setLogSwitch(int i) {
        mLogSwitch = i;
    }

    public static int getLogSwitch() {
        return mLogSwitch;
    }

    public static void log(String str) {
        log(32768, str);
    }

    public static void log(int i, String str) {
        log(i, DEFAULT_TAG, str);
    }

    public static void log(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2) || mLogSwitch == 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_TAG;
        }
        if ((i & mLogSwitch) > 0) {
            Log.e(str, str2);
        }
    }
}
