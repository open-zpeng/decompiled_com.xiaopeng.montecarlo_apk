package com.autonavi.common.tool;

import android.app.Application;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Looper;
import android.util.Log;
import com.autonavi.common.tool.util.CrashFileManager;
import com.autonavi.common.tool.util.LogUtil;
import com.autonavi.common.tool.util.SystemUtils;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ErrorHandler implements Thread.UncaughtExceptionHandler {
    public static final String HEAP_ERROR_FILE_NAME = "autonavi_heap_error_log.txt";
    private static int anr_count;
    private static volatile Thread processingThread;
    private static volatile boolean recordCrash;
    static Thread.UncaughtExceptionHandler superHandler;

    ErrorHandler() {
    }

    private static boolean needContinue(Throwable th) {
        boolean z;
        if (Utils.checkAnrException(th)) {
            int i = anr_count;
            if (i > 3) {
                return false;
            }
            anr_count = i + 1;
            return true;
        }
        synchronized (ErrorHandler.class) {
            z = recordCrash;
            if (!recordCrash) {
                recordCrash = true;
                processingThread = Thread.currentThread();
            }
        }
        if (z) {
            if (CrashLog.debugMode()) {
                Log.w("CrashAgain", Thread.currentThread().toString(), th);
            }
            if (processingThread != null && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                loop();
                return false;
            } else if (processingThread == null && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                Utils.exitProcess();
                return false;
            } else {
                if (th == null) {
                    hangupCurrentThread();
                }
                return false;
            }
        }
        return true;
    }

    private static void hangupCurrentThread() {
        synchronized (ErrorHandler.class) {
            try {
                ErrorHandler.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nativeException(String str, Thread thread, boolean z) {
        Thread thread2;
        boolean z2;
        CrashFileManager.NativeErrorInfo buildNativeErrorInfoInner;
        if (needContinue(null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("begin java native exception crashThread: ");
            sb.append(thread == null ? "null" : thread.toString());
            LogUtil.logE(sb.toString());
            SystemUtils.dumpHeapInfo();
            boolean z3 = true;
            if (thread == null) {
                thread2 = Thread.currentThread();
                z2 = true;
            } else {
                thread2 = thread;
                z2 = false;
            }
            StackTraceElement[] stackTrace = z ? null : thread2.getStackTrace();
            try {
                CrashLog.getControler().onDumpStart();
                LogUtil.logE("exception info file " + str);
                buildNativeErrorInfoInner = CrashFileManager.getInstance().buildNativeErrorInfoInner(new File(str));
            } catch (Throwable unused) {
            }
            if (buildNativeErrorInfoInner != null) {
                String str2 = buildNativeErrorInfoInner.errorInfo;
                try {
                    if (!CrashLog.getControler().onDumpStartEx(null, null, str2)) {
                        CrashLog.getControler().onDumpEnd();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                CrashFileManager crashFileManager = CrashFileManager.getInstance();
                if (CrashLog.getJniReportOtherThread() && z2) {
                    z3 = false;
                }
                crashFileManager.recordCrash(dumpcrash.collectMoreInfo(str2, thread2, stackTrace, z3), null, false, null, thread2, z, buildNativeErrorInfoInner, false);
                LogUtil.logE("finish CrashLog.recordCrash");
                CrashLog.getControler().onDumpEnd();
                LogUtil.logE("on Dump end");
                LogUtil.logE("finish native Exception");
                processingThread = null;
                return;
            }
            CrashLog.getControler().onDumpEnd();
            LogUtil.logE("on Dump end");
            LogUtil.logE("finish native Exception");
            processingThread = null;
        }
    }

    public static void javaException(final Thread thread, final Throwable th) {
        if (th != null && th.getClass().equals(TimeoutException.class)) {
            Log.e("uncaught_ex", th.getMessage(), th);
            if (thread == Looper.getMainLooper().getThread()) {
                loop();
            }
        } else if (needContinue(th)) {
            SystemUtils.dumpHeapInfo();
            Runnable runnable = new Runnable() { // from class: com.autonavi.common.tool.ErrorHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (!Utils.checkAnrException(th)) {
                                CrashLog.getControler().onDumpStart();
                                if (!CrashLog.getControler().onDumpStartEx(thread, th, null)) {
                                    Thread unused = ErrorHandler.processingThread = null;
                                    if (Utils.checkAnrException(th)) {
                                        return;
                                    }
                                    try {
                                        if (ErrorHandler.superHandler != null) {
                                            ErrorHandler.superHandler.uncaughtException(thread, th);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                    Utils.exitProcess();
                                    return;
                                }
                            }
                            CrashFileManager.getInstance().recordCrash(SystemUtils.getExceptionString(th), th, false, null, thread, false, true);
                            Thread unused3 = ErrorHandler.processingThread = null;
                        } catch (Exception unused4) {
                        }
                        if (Utils.checkAnrException(th)) {
                            return;
                        }
                        if (ErrorHandler.superHandler != null) {
                            ErrorHandler.superHandler.uncaughtException(thread, th);
                        }
                        Utils.exitProcess();
                    } finally {
                        CrashLog.getControler().onDumpEnd();
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                new Thread(runnable, "CrashTask").start();
                loop();
                return;
            }
            runnable.run();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        javaException(thread, th);
    }

    private static boolean isSpaceInsuffToCrash(Throwable th) {
        String localizedMessage;
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2.toString().contains("No space left on device")) {
                return true;
            }
        }
        Throwable th3 = null;
        while (th != null) {
            if (th instanceof SQLiteException) {
                th3 = th;
            }
            th = th.getCause();
        }
        if (th3 == null) {
            return false;
        }
        if ((th3 instanceof SQLiteFullException) || (th3 instanceof SQLiteDiskIOException)) {
            return true;
        }
        return (th3 instanceof SQLiteException) && (localizedMessage = th3.getLocalizedMessage()) != null && localizedMessage.contains("cannot rollback - no transaction is active");
    }

    private static void loop() {
        try {
            Looper.loop();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void bindDefault(Application application) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == null || (defaultUncaughtExceptionHandler instanceof ErrorHandler)) {
            return;
        }
        superHandler = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(new ErrorHandler());
    }
}
