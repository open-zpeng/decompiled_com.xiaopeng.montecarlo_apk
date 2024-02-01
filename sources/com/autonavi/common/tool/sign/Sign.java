package com.autonavi.common.tool.sign;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.autonavi.common.tool.CrashLog;
import com.autonavi.common.tool.util.LogUtil;
import com.autonavi.common.tool.util.MessageDigestUtil;
/* loaded from: classes.dex */
public final class Sign {
    private static String signInfo;

    private static native boolean checkPackageSign(String str);

    public native String sign(String str);

    static {
        CrashLog.loadLibrary();
        signInfo = null;
    }

    public static boolean checkSign(Context context) {
        if (TextUtils.isEmpty(signInfo)) {
            getPackageSign(context);
        }
        return checkPackageSign(signInfo);
    }

    private static void getPackageSign(Context context) {
        try {
            signInfo = MessageDigestUtil.getByteArrayMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException unused) {
            LogUtil.log("getPackageSign error");
        }
    }
}
