package com.autonavi.auto.intfauto;

import com.autonavi.auto.util.LogUtils;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class DebugTool {
    private static final String TAG = "INTFAUTO_DEBUG";

    public static void v(String str, Object... objArr) {
        LogUtils.v(String.format(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        LogUtils.d(String.format(str, objArr));
    }

    public static void i(String str, Object... objArr) {
        LogUtils.i(String.format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        LogUtils.w(String.format(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        LogUtils.e(String.format(str, objArr));
    }

    public static void printCurrentStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            i("printCurrentStackTrace = null", new Object[0]);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" <- ");
                stringBuffer.append(System.getProperty("line.separator"));
            }
            stringBuffer.append(MessageFormat.format("{0}.{1}() {2}", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        i(stringBuffer.toString(), new Object[0]);
    }

    public static void printStackTrace(Exception exc) {
        if (exc != null) {
            i("printStackTrace: " + exc.getMessage() + " failed", new Object[0]);
        }
    }
}
