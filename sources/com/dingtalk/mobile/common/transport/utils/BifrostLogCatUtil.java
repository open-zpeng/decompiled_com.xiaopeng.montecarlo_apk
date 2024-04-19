package com.dingtalk.mobile.common.transport.utils;

import android.util.Log;
/* loaded from: classes2.dex */
public class BifrostLogCatUtil {
    public static void debug(String str, String str2) {
        Log.d(str, str2);
    }

    public static void info(String str, String str2) {
        Log.i(str, str2);
    }

    public static void warn(String str, String str2) {
        Log.w(str, str2);
    }

    public static void warn(String str, Throwable th) {
        Log.w(str, th.toString());
    }

    public static void error(String str, String str2) {
        Log.e(str, str2);
    }

    public static void error(String str, Throwable th) {
        Log.e(str, th.toString());
    }

    public static void error(String str, String str2, Throwable th) {
        Log.e(str, str2 + "(" + th.toString() + ")");
    }
}
