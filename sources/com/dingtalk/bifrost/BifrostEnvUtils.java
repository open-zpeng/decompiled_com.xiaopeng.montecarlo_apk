package com.dingtalk.bifrost;

import android.content.Context;
import android.os.Build;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public class BifrostEnvUtils {
    private static final String TAG = "bifrostEnvUtils";
    private static Context context;

    public static final void setContext(Context context2) {
        context = context2;
    }

    public static final Context getContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                context = (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                if (context != null) {
                    return context;
                }
                BifrostLogCatUtil.warn(TAG, "context from ActivityThread is null");
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "context from ActivityThread exception", th);
            }
        }
        return context;
    }
}
