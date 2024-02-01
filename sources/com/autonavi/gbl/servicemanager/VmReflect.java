package com.autonavi.gbl.servicemanager;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class VmReflect {
    private static int registerCnt;

    public static boolean registerNativeSize(int i) {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("registerNativeAllocation", Integer.TYPE)) == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("registerNativeAllocation,size=");
            sb.append(String.valueOf(i));
            sb.append(",registerNativeCnt=");
            int i2 = registerCnt + 1;
            registerCnt = i2;
            sb.append(String.valueOf(i2));
            Log.d("refMgr", sb.toString());
            declaredMethod2.invoke(invoke, Integer.valueOf(i));
            return true;
        } catch (Throwable th) {
            Log.d("refMgr", th.getMessage());
            return false;
        }
    }

    public static boolean registerFreeSize(int i) {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("registerNativeFree", Integer.TYPE)) == null) {
                return false;
            }
            declaredMethod2.invoke(invoke, Integer.valueOf(i));
            StringBuilder sb = new StringBuilder();
            sb.append("registerNativeFree,size=");
            sb.append(String.valueOf(i));
            sb.append(",registerNativeCnt=");
            int i2 = registerCnt - 1;
            registerCnt = i2;
            sb.append(String.valueOf(i2));
            Log.d("refMgr", sb.toString());
            return true;
        } catch (Throwable th) {
            Log.d("refMgr", th.getMessage());
            return false;
        }
    }
}
