package com.autonavi.common.tool;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.autonavi.amapauto.utils.AutoLibraryLoader;
import com.autonavi.common.tool.util.LogUtil;
import com.autonavi.common.tool.util.SystemUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dumpcrash {
    public static final int GETMAPS_FLAG_1 = 1;
    public static final int GETMAPS_FLAG_10 = 16;
    public static final int GETMAPS_FLAG_2 = 2;
    public static final int GETMAPS_FLAG_4 = 4;
    public static final int GETMAPS_FLAG_8 = 8;
    public static final String LIB_DUMPCRASH = "dumpcrash";
    public static final String LIB_DUMPCRASH_FULL_NAME = "libdumpcrash.so";
    public static boolean hasLoadLibrary;

    public static native int[] getApkInfo(String str, String str2);

    public static native String getMaps(int i);

    public static native void getNativeAnrThreadInfo(String str, String str2, String str3);

    public static native String getNativeThreadBacktrace(int i);

    public static native String getThreadInfos();

    public static native long getUsableSpace(String str);

    private static native void install(int i, String str, String str2);

    public static native void recordKeyValue(String str, String str2);

    public static native void recordLog(String str);

    public static native void setAppVersion(String str);

    public static native void setCrashNotifyDir(String str);

    public static native void setCrashNotifyFilePath(String str);

    public static native void setRepotOtherThread(boolean z);

    public static native void testNativeCrash();

    public static native void uninstall();

    dumpcrash() {
    }

    static {
        loadLibrary();
        hasLoadLibrary = false;
    }

    public static void install(String str) {
        install(Build.VERSION.SDK_INT, CrashLog.getApplication().getApplicationInfo().nativeLibraryDir + File.separator, str);
    }

    public static synchronized void loadLibrary() {
        synchronized (dumpcrash.class) {
            LogUtil.logE("dumpcrash loadLibrary");
            if (hasLoadLibrary) {
                return;
            }
            AutoLibraryLoader.loadLibrary(LIB_DUMPCRASH);
            hasLoadLibrary = true;
        }
    }

    static void recordInLocal(String str, boolean z) {
        ErrorHandler.nativeException(str, null, z);
    }

    static void recordInLocal(String str, long j, boolean z) {
        if (z) {
            ErrorHandler.nativeException(str, null, z);
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTracesOfThreads = SystemUtils.getAllStackTracesOfThreads();
        if (allStackTracesOfThreads == null || allStackTracesOfThreads.size() == 0) {
            ErrorHandler.nativeException(str, null, z);
            return;
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTracesOfThreads.entrySet()) {
            if (getThreadNativePeerValue(entry.getKey()) == j) {
                ErrorHandler.nativeException(str, entry.getKey(), z);
                return;
            }
        }
        ErrorHandler.nativeException(str, null, z);
    }

    private static long getThreadNativePeerValue(Thread thread) {
        if (thread == null) {
            return -1L;
        }
        try {
            Field declaredField = Thread.class.getDeclaredField("nativePeer");
            declaredField.setAccessible(true);
            return declaredField.getLong(thread);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String collectMoreInfo(String str, Thread thread, StackTraceElement[] stackTraceElementArr, boolean z) {
        try {
            StringBuffer stringBuffer = new StringBuffer(str);
            if (z) {
                String currentJavaStackTrace = getCurrentJavaStackTrace(thread, stackTraceElementArr);
                if (!TextUtils.isEmpty(currentJavaStackTrace)) {
                    stringBuffer.append(currentJavaStackTrace);
                }
            }
            if (str.contains("(SIGABRT)")) {
                stringBuffer.append(getOtherJavaStackTrace(thread));
                stringBuffer.append(SystemUtils.getLogcat());
                if (str.contains("(SI_USER)")) {
                    stringBuffer.append(readAnrTraces());
                }
            } else if (str.contains("(SIGSEGV)") || str.contains("(SIGBUS)") || str.contains("(SIGILL)")) {
                stringBuffer.append(SystemUtils.getLogcat());
                FDManager.getInstance().releaseFd();
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String getCurrentJavaStackTrace(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return "\nJavaStack:\n" + getJavaStackTrace(thread, thread, stackTraceElementArr);
    }

    private static String getJavaStackTrace(Thread thread, Thread thread2, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            if (thread != null) {
                LogUtil.logE("dc: TN: " + thread.toString());
            }
            if (stackTraceElementArr == null) {
                LogUtil.logE("dc: element null");
                return "";
            }
            LogUtil.logE("dc: element length 0");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (thread == thread2) {
            int i2 = 0;
            while (true) {
                if (i2 >= stackTraceElementArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                if (stackTraceElementArr[i2].getMethodName().equals("recordInLocal")) {
                    i2 = i3;
                    break;
                }
                i2 = i3;
            }
            if (i2 < stackTraceElementArr.length) {
                i = i2;
            }
        } else {
            sb.append(thread2.toString());
            sb.append(" ");
            sb.append(thread2.getState());
            sb.append(FDManager.LINE_SEPERATOR);
        }
        while (i < stackTraceElementArr.length) {
            sb.append("  ");
            sb.append(stackTraceElementArr[i].toString());
            sb.append(FDManager.LINE_SEPERATOR);
            i++;
        }
        return sb.toString();
    }

    private static String getOtherJavaStackTrace(Thread thread) {
        Map<Thread, StackTraceElement[]> allStackTracesOfThreads = SystemUtils.getAllStackTracesOfThreads();
        if (allStackTracesOfThreads == null || allStackTracesOfThreads.size() < 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\nOtherJavaStack:\n");
        for (Thread thread2 : allStackTracesOfThreads.keySet()) {
            if (!thread2.equals(thread) && thread2 == Looper.getMainLooper().getThread()) {
                sb.append(getJavaStackTrace(thread, thread2, allStackTracesOfThreads.get(thread2)));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String readAnrTraces() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.dumpcrash.readAnrTraces():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.common.tool.dumpcrash$1FileInfo  reason: invalid class name */
    /* loaded from: classes.dex */
    public class C1FileInfo {
        File file;
        long lastModified;

        public C1FileInfo(File file, long j) {
            this.file = file;
            this.lastModified = j;
        }
    }
}
