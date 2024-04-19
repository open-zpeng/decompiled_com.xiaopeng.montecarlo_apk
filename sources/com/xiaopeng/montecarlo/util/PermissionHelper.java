package com.xiaopeng.montecarlo.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class PermissionHelper {
    private static final String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.INTERNET", "android.permission.READ_SMS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE"};
    public static final int REQUEST_PERMISSION = 1;

    public static boolean hasPermissions(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = true;
            for (String str : PERMISSIONS) {
                if (activity.checkSelfPermission(str) != 0) {
                    z = false;
                }
            }
            if (Settings.canDrawOverlays(activity.getApplication())) {
                return z;
            }
            return false;
        }
        return true;
    }

    public static void verifyPermissions(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            for (String str : PERMISSIONS) {
                if (activity.checkSelfPermission(str) != 0) {
                    activity.requestPermissions(PERMISSIONS, 1);
                }
            }
            if (Settings.canDrawOverlays(activity.getApplication())) {
                return;
            }
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 1);
        }
    }
}
