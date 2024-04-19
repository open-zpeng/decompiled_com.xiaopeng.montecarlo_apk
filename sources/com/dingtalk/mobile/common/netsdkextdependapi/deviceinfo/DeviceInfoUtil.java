package com.dingtalk.mobile.common.netsdkextdependapi.deviceinfo;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class DeviceInfoUtil {
    private static String deviceId;

    public static void setDeviceId(String str) {
        if (str == null) {
            return;
        }
        deviceId = str;
    }

    public static final String getDeviceId() {
        String str;
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        try {
            str = Build.SERIAL;
        } catch (Throwable unused) {
            str = "";
        }
        return TextUtils.isEmpty(str) ? "abcedfghijklmnopqrstuvwxyz" : str;
    }
}
