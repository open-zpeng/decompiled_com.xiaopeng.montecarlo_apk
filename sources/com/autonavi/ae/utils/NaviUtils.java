package com.autonavi.ae.utils;
/* loaded from: classes.dex */
public class NaviUtils {
    public static native String nativeGetDataPath();

    public static native String nativeGetDiffPath();

    public static native String nativeGetLogPath();

    public static native String nativeGetOfflineDataPath();

    public static native String nativeGetResPath();

    public static native synchronized int nativeSetConfigFile(String str, String str2);

    public static native synchronized int nativeSetConfigMem(String str, String str2);

    public static native int nativeSetLogMask(int i);

    public static native synchronized void nativeSetOfflineDataPath(String str);

    public static native void nativeShutdown();
}
