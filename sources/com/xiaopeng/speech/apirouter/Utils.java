package com.xiaopeng.speech.apirouter;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaopeng.speech.vui.constants.Foo;
import com.xiaopeng.speech.vui.utils.VuiUtils;
/* loaded from: classes3.dex */
public class Utils {
    private static Boolean isXpDevice;

    public static boolean isCorrectObserver(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str2.contains(".")) {
            return false;
        }
        String substring = str2.substring(str2.lastIndexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(substring);
        return str2.equals(sb.toString());
    }

    public static boolean isXpDevice() {
        if (isXpDevice == null) {
            if (TextUtils.isEmpty(VuiUtils.getXpCduType())) {
                isXpDevice = false;
            } else {
                isXpDevice = true;
            }
        }
        return isXpDevice.booleanValue();
    }

    public static boolean checkApkExist(String str) {
        if (str != null && !"".equals(str)) {
            try {
                Foo.getContext().getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }
}
