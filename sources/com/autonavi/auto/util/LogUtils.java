package com.autonavi.auto.util;

import android.util.Log;
import com.autonavi.auto.intfauto.DebugTool;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
/* loaded from: classes.dex */
public class LogUtils {
    private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char BOTTOM_LEFT_CORNER = 9492;
    private static final int CHUNK_SIZE = 4000;
    public static final int DEBUG = 3;
    private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    public static final int ERROR = 6;
    private static final char HORIZONTAL_LINE = 9474;
    public static final int INFO = 4;
    private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final char MIDDLE_CORNER = 9500;
    private static final int MIN_STACK_OFFSET = 5;
    public static final int None = 7;
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String TAG = "BL_JNI_LOG";
    private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char TOP_LEFT_CORNER = 9484;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    static String className = null;
    static int lineNumber = 0;
    private static LogAdaptor mAdaptor = new LogAndroidAdaptor();
    private static boolean mOpenLog = false;
    private static final int methodCount = 3;
    static String methodName = null;
    private static final int methodOffset = 0;
    private static final boolean showThreadInfo = true;

    private static void logByLevel(int i, String str) {
        if (i == 2) {
            Log.v(TAG, str);
        } else if (i == 3) {
            Log.d(TAG, str);
        } else if (i == 4) {
            Log.i(TAG, str);
        } else if (i == 5) {
            Log.w(TAG, str);
        } else if (i == 6) {
            Log.e(TAG, str);
        } else {
            Log.v(TAG, str);
        }
    }

    private static int getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className2 = stackTraceElementArr[i].getClassName();
            if (!className2.equals(LogUtils.class.getName()) && !className2.equals(DebugTool.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    private static String getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private static void logHeaderContent(int i, int i2) {
        int i3;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        logByLevel(i, "│ Thread: " + Thread.currentThread().getName());
        logByLevel(i, MIDDLE_BORDER);
        int stackOffset = getStackOffset(stackTrace) + 0;
        if (i2 + stackOffset > stackTrace.length) {
            i2 = (stackTrace.length - stackOffset) - 1;
        }
        while (i2 > 0) {
            if (i2 + stackOffset < stackTrace.length) {
                logByLevel(i, HORIZONTAL_LINE + " " + getSimpleClassName(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    private static void log(int i, String str) {
        logByLevel(i, TOP_BORDER);
        logHeaderContent(i, 3);
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            logByLevel(i, MIDDLE_BORDER);
            logByLevel(i, "│ " + str);
            logByLevel(i, BOTTOM_BORDER);
            return;
        }
        logByLevel(i, MIDDLE_BORDER);
        for (int i2 = 0; i2 < length; i2 += 4000) {
            int min = Math.min(length - i2, 4000);
            logByLevel(i, "│ " + new String(bytes, i2, min));
        }
        logByLevel(i, BOTTOM_BORDER);
    }

    public static void setAdaptor(LogAdaptor logAdaptor) {
        mAdaptor = logAdaptor;
    }

    private static int getLogLevel() {
        return mAdaptor.getLogLevel();
    }

    public static void e(String str) {
        if (getLogLevel() > 6) {
            return;
        }
        log(6, str);
    }

    public static void i(String str) {
        if (getLogLevel() > 4) {
            return;
        }
        log(4, str);
    }

    public static void d(String str) {
        if (getLogLevel() > 3) {
            return;
        }
        log(3, str);
    }

    public static void v(String str) {
        if (getLogLevel() > 2) {
            return;
        }
        log(2, str);
    }

    public static void w(String str) {
        if (getLogLevel() > 5) {
            return;
        }
        log(5, str);
    }
}
