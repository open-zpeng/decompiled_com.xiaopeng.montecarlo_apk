package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
import android.util.Log;
import com.autonavi.common.tool.FDManager;
/* loaded from: classes2.dex */
public class L {
    public static final int LEVEL_D = 1;
    public static final int LEVEL_E = 4;
    public static final int LEVEL_I = 2;
    public static final int LEVEL_S = 5;
    public static final int LEVEL_V = 0;
    public static final int LEVEL_W = 3;
    private static final int LOG_MAX_LEN = 3072;
    private static final String TAG_LOG_DAY_NIGHT_SWITCH = "DAY_NIGHT_SWITCH";
    private static final String TAG_LOG_SR = "SR_DATA";
    private static final String TAG_LOG_VOICE_FULL_SCENES = "VOICE_FULL_SCENES";
    private static final String TAG_PREFIX = "NAV_";
    private static final Tag TAG = new Tag("L");
    public static boolean ENABLE = false;

    public static boolean isLoggable() {
        return ENABLE;
    }

    public static boolean setLoggable(boolean z) {
        ENABLE = z && RootUtil.isLogcatEnabled();
        return ENABLE;
    }

    public static final void e(Tag tag, String str) {
        Log.e(tag.toString(), str);
    }

    public static final void d(Tag tag, String str) {
        if (isLoggable()) {
            Log.d(tag.toString(), str);
        }
    }

    public static final void w(Tag tag, String str) {
        Log.w(tag.toString(), str);
    }

    public static final void f(Tag tag, String str) {
        Log.d(tag.toString(), str);
    }

    public static final void v(Tag tag, String str) {
        if (isLoggable()) {
            Log.v(tag.toString(), str);
        }
    }

    public static final void i(Tag tag, String str) {
        Log.i(tag.toString(), str);
    }

    public static final String printStackTrace(Tag tag, Exception exc) {
        if (exc == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(exc.toString());
        sb.append(FDManager.LINE_SEPERATOR);
        e(tag, exc.toString());
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append(FDManager.LINE_SEPERATOR);
                e(tag, stackTraceElement.toString());
            }
        }
        for (Throwable th : exc.getSuppressed()) {
            sb.append(printRootStackTrace(tag, th));
        }
        Throwable cause = exc.getCause();
        if (cause != null) {
            sb.append(printRootStackTrace(tag, cause));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (ENABLE) {
            d(TAG, "printStackTrace cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return sb.toString();
    }

    public static final String printStackTrace(Tag tag, Error error) {
        if (error == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(error.toString());
        sb.append(FDManager.LINE_SEPERATOR);
        e(tag, error.toString());
        StackTraceElement[] stackTrace = error.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append(FDManager.LINE_SEPERATOR);
                e(tag, stackTraceElement.toString());
            }
        }
        for (Throwable th : error.getSuppressed()) {
            sb.append(printRootStackTrace(tag, th));
        }
        Throwable cause = error.getCause();
        if (cause != null) {
            sb.append(printRootStackTrace(tag, cause));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (ENABLE) {
            d(TAG, "printStackTrace cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return sb.toString();
    }

    public static final String printDebugStackTrace(Tag tag, Error error) {
        if (error == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(error.toString());
        sb.append(FDManager.LINE_SEPERATOR);
        d(tag, error.toString());
        StackTraceElement[] stackTrace = error.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                d(tag, stackTraceElement.toString());
            }
        }
        for (Throwable th : error.getSuppressed()) {
            sb.append(printRootStackTrace(tag, th));
        }
        Throwable cause = error.getCause();
        if (cause != null) {
            sb.append(printRootStackTrace(tag, cause));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (ENABLE) {
            d(TAG, "printDebugStackTrace cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return sb.toString();
    }

    public static String printRootStackTrace(Tag tag, Throwable th) {
        StackTraceElement[] stackTrace;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        sb.append(FDManager.LINE_SEPERATOR);
        e(tag, th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(FDManager.LINE_SEPERATOR);
            e(tag, stackTraceElement.toString());
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append("Caused by: ");
            sb.append(FDManager.LINE_SEPERATOR);
            e(tag, "Caused by: ");
            sb.append(printRootStackTrace(tag, cause));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (ENABLE) {
            d(TAG, "printRootStackTrace cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return sb.toString();
    }

    public static final String filterStackByTag(String str, String str2) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : str.split(FDManager.LINE_SEPERATOR)) {
            if (str3.contains(str2)) {
                String trim = str3.replaceAll(str2, "").trim();
                String[] split2 = trim.split("\\.");
                if (split2.length > 3) {
                    trim = trim.substring(trim.indexOf(split2[split2.length - 3]));
                }
                sb.append(trim);
                sb.append("<---|");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 5);
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static final class Tag {
        private static final int MAXLENGTH = 26;
        private static final int MAX_TAG_LENGTH = 30;
        private String mTag;

        public Tag(String str) {
            if (str.length() > MAXLENGTH) {
                if (L.ENABLE) {
                    Tag tag = L.TAG;
                    L.e(tag, "Tags max length must less that " + MAXLENGTH + " : " + str);
                }
                this.mTag = L.TAG_PREFIX + str.substring(0, MAXLENGTH);
                return;
            }
            this.mTag = L.TAG_PREFIX + str;
        }

        public String toString() {
            return this.mTag;
        }
    }

    public static String formatWithEngine(String str, int i) {
        return str + ",engineId:" + i;
    }

    public static String formatDayNightSwitchLog(String str) {
        return "DAY_NIGHT_SWITCH " + str;
    }

    public static String formatVoiceFullScenesLog(String str) {
        return "VOICE_FULL_SCENES " + str;
    }

    public static String formatSRLog(String str) {
        return "SR_DATA " + str;
    }

    public static void longLog(Tag tag, String str) {
        if (str == null) {
            return;
        }
        if (str.length() > LOG_MAX_LEN) {
            d(tag, str.substring(0, LOG_MAX_LEN));
            longLog(tag, str.substring(LOG_MAX_LEN));
            return;
        }
        d(tag, str);
    }
}
