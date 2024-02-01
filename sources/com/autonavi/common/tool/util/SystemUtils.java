package com.autonavi.common.tool.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.autonavi.common.tool.CrashLog;
import com.autonavi.common.tool.DatabaseCollector;
import com.autonavi.common.tool.FDManager;
import com.autonavi.common.tool.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class SystemUtils {
    private static final String LIB_PREFIX = "lib";
    private static final int LIB_PREFIX_LENGTH = 3;
    private static final String memInfoFmt = "%21s %8s\n";
    private static final String memInfoFmt2 = "%21s %8s %21s %8s\n";
    private static final String[] suPathname = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getDeviceId(Context context) {
        return "";
    }

    public static String getMemoryUsage(Context context) {
        try {
            long j = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            return Formatter.formatFileSize(context, j - freeMemory) + MqttTopic.TOPIC_LEVEL_SEPARATOR + Formatter.formatFileSize(context, j);
        } catch (Exception e) {
            return Utils.makeThrowableText(e);
        }
    }

    public static Debug.MemoryInfo getMemoryInfoByPid(Context context, int i) {
        try {
            int[] iArr = {i};
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            Debug.MemoryInfo[] memoryInfoArr = new Debug.MemoryInfo[0];
            if (activityManager != null) {
                memoryInfoArr = activityManager.getProcessMemoryInfo(iArr);
            }
            if (memoryInfoArr == null || memoryInfoArr.length <= 0) {
                return null;
            }
            return memoryInfoArr[0];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurrentProcessName(Context context) {
        return context == null ? "" : context.getApplicationInfo().packageName;
    }

    public static String getProcessNameByPid(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == i) {
                        str = next.processName;
                        break;
                    }
                }
            }
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e) {
            return Utils.makeThrowableText(e);
        }
    }

    public static long getSystemBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static Map<Thread, StackTraceElement[]> getAllStackTracesOfThreads() {
        final HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Callable<Object>() { // from class: com.autonavi.common.tool.util.SystemUtils.1
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                hashMap.putAll(Thread.getAllStackTraces());
                return null;
            }
        });
        Utils.excCallables(arrayList, 2000L, 1);
        return hashMap;
    }

    public static String getProcessMemoryInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Process Summary (From: android.os.Debug.MemoryInfo)\n");
        sb.append(String.format(Locale.US, memInfoFmt, "", "Pss(KB)"));
        sb.append(String.format(Locale.US, memInfoFmt, "", "------"));
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 23) {
                sb.append(String.format(Locale.US, memInfoFmt, "Java Heap:", memoryInfo.getMemoryStat("summary.java-heap")));
                sb.append(String.format(Locale.US, memInfoFmt, "Native Heap:", memoryInfo.getMemoryStat("summary.native-heap")));
                sb.append(String.format(Locale.US, memInfoFmt, "Code:", memoryInfo.getMemoryStat("summary.code")));
                sb.append(String.format(Locale.US, memInfoFmt, "Stack:", memoryInfo.getMemoryStat("summary.stack")));
                sb.append(String.format(Locale.US, memInfoFmt, "Graphics:", memoryInfo.getMemoryStat("summary.graphics")));
                sb.append(String.format(Locale.US, memInfoFmt, "Private Other:", memoryInfo.getMemoryStat("summary.private-other")));
                sb.append(String.format(Locale.US, memInfoFmt, "System:", memoryInfo.getMemoryStat("summary.system")));
                sb.append(String.format(Locale.US, memInfoFmt2, "TOTAL:", memoryInfo.getMemoryStat("summary.total-pss"), "TOTAL SWAP:", memoryInfo.getMemoryStat("summary.total-swap")));
            } else {
                Locale locale = Locale.US;
                sb.append(String.format(locale, memInfoFmt, "Java Heap:", "~ " + memoryInfo.dalvikPrivateDirty));
                sb.append(String.format(Locale.US, memInfoFmt, "Native Heap:", String.valueOf(memoryInfo.nativePrivateDirty)));
                Locale locale2 = Locale.US;
                sb.append(String.format(locale2, memInfoFmt, "Private Other:", "~ " + memoryInfo.otherPrivateDirty));
                if (Build.VERSION.SDK_INT >= 19) {
                    sb.append(String.format(Locale.US, memInfoFmt, "System:", String.valueOf((memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty()) - memoryInfo.getTotalPrivateClean())));
                } else {
                    Locale locale3 = Locale.US;
                    sb.append(String.format(locale3, memInfoFmt, "System:", "~ " + (memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty())));
                }
                sb.append(String.format(Locale.US, memInfoFmt, "TOTAL:", String.valueOf(memoryInfo.getTotalPss())));
            }
        } catch (Exception unused) {
            LogUtil.log("Util getProcessMemoryInfo failed");
        }
        return sb.toString();
    }

    private static String getFileContent(String str) {
        return getFileContent(str, 0);
    }

    private static String getFileContent(String str, int i) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(str));
                    int i2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String trim = readLine.trim();
                            if (trim.length() > 0) {
                                i2++;
                                if (i == 0 || i2 <= i) {
                                    sb.append("  ");
                                    sb.append(trim);
                                    sb.append(FDManager.LINE_SEPERATOR);
                                }
                            }
                        } catch (Exception unused) {
                            bufferedReader2 = bufferedReader;
                            LogUtil.log("Util getInfo(" + str + ") failed");
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (i > 0 && i2 > i) {
                        sb.append("  ......\n");
                        sb.append("  (number of records: ");
                        sb.append(i2);
                        sb.append(")\n");
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
        }
    }

    public static boolean isRoot() {
        try {
            for (String str : suPathname) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getLogcat() {
        final StringBuffer stringBuffer = new StringBuffer();
        final StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Callable<Object>() { // from class: com.autonavi.common.tool.util.SystemUtils.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    stringBuffer.append("-----main log-----\n");
                    Process exec = Runtime.getRuntime().exec("logcat -d -v threadtime -b main -t 1000");
                    exec.waitFor();
                    stringBuffer.append(IOUtil.readStr(exec.getInputStream()));
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        arrayList.add(new Callable<Object>() { // from class: com.autonavi.common.tool.util.SystemUtils.3
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    stringBuffer2.append("-----system log-----\n");
                    Process exec = Runtime.getRuntime().exec("logcat -d -v threadtime -b system -t 1000");
                    exec.waitFor();
                    stringBuffer2.append(IOUtil.readStr(exec.getInputStream()));
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        Utils.excCallables(arrayList, 2000L, arrayList.size());
        return "\nLogcat:\n" + stringBuffer + stringBuffer2;
    }

    public static String getAllThreadNameInfo() {
        try {
            Map<Thread, StackTraceElement[]> allStackTracesOfThreads = getAllStackTracesOfThreads();
            if (allStackTracesOfThreads != null && !allStackTracesOfThreads.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("AllThreadName:");
                sb.append(FDManager.LINE_SEPERATOR);
                for (Thread thread : allStackTracesOfThreads.keySet()) {
                    sb.append("name:");
                    sb.append(thread.getName());
                    sb.append("\t");
                    sb.append("tid:");
                    sb.append(thread.getId());
                    sb.append(FDManager.LINE_SEPERATOR);
                }
                return sb.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String getExceptionString(java.lang.Throwable r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L2d
            r2.<init>()     // Catch: java.lang.Throwable -> L2d
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2d
            r4.printStackTrace(r3)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2e
            r0.append(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = getAppendInfo(r4)     // Catch: java.lang.Throwable -> L2e
            r0.append(r4)     // Catch: java.lang.Throwable -> L2e
            goto L2e
        L22:
            r4 = move-exception
            goto L26
        L24:
            r4 = move-exception
            r3 = r1
        L26:
            com.autonavi.common.tool.util.IOUtil.closeQuietly(r3)
            com.autonavi.common.tool.util.IOUtil.deleteFileOrDir(r1)
            throw r4
        L2d:
            r3 = r1
        L2e:
            com.autonavi.common.tool.util.IOUtil.closeQuietly(r3)
            com.autonavi.common.tool.util.IOUtil.deleteFileOrDir(r1)
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.SystemUtils.getExceptionString(java.lang.Throwable):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    private static String getAppendInfo(Throwable th) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(getLogcat());
            if (Utils.isSqliteException(th)) {
                sb.append(DatabaseCollector.getDatabaseInfo(th, CrashLog.getApplication()));
            } else if (Utils.checkException(th, Resources.NotFoundException.class)) {
                FDManager.getInstance().releaseFd();
                sb.append("FDinfo:\n");
                for (String str : FDManager.getFDList(true)) {
                    sb.append("\t");
                    sb.append(str);
                    sb.append(FDManager.LINE_SEPERATOR);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String GetMemoryInfoString() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            Field declaredField = memoryInfo.getClass().getDeclaredField("otherStats");
            declaredField.setAccessible(true);
            int[] iArr = (int[]) declaredField.get(memoryInfo);
            if (iArr != null && iArr.length > 0) {
                for (int i = 0; i < iArr.length; i++) {
                    stringBuffer.append(iArr[i]);
                    if (i < iArr.length - 1) {
                        stringBuffer.append(',');
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return memoryInfo.getTotalPss() + MqttTopic.TOPIC_LEVEL_SEPARATOR + memoryInfo.dalvikPss + MqttTopic.TOPIC_LEVEL_SEPARATOR + memoryInfo.nativePss + MqttTopic.TOPIC_LEVEL_SEPARATOR + memoryInfo.otherPss + MqttTopic.TOPIC_LEVEL_SEPARATOR + Runtime.getRuntime().maxMemory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + stringBuffer.toString();
    }

    public static String getMIUIVersion() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/system/build.prop")));
            String readLine = bufferedReader.readLine();
            while (true) {
                if (readLine == null) {
                    break;
                } else if (readLine.contains("ro.miui.ui.version.name")) {
                    str = readLine.substring(readLine.indexOf("=") + 1);
                    break;
                } else {
                    readLine = bufferedReader.readLine();
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String getProcessStartTime() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L78
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r4.<init>()     // Catch: java.lang.Throwable -> L78
            java.lang.String r5 = "ls -ld /proc/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L78
            r4.append(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L78
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L78
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Throwable -> L79
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L79
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L79
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L79
            r2.waitFor()     // Catch: java.lang.Throwable -> L79
            java.lang.String r3 = r3.readLine()     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)"
            r5 = 10
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4, r5)     // Catch: java.lang.Throwable -> L79
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch: java.lang.Throwable -> L79
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L79
            if (r3 != 0) goto L5e
            boolean r3 = r4.find()     // Catch: java.lang.Throwable -> L79
            if (r3 == 0) goto L5e
            int r3 = r4.groupCount()     // Catch: java.lang.Throwable -> L79
            r5 = 1
            if (r3 <= r5) goto L5e
            java.lang.String r3 = r4.group()     // Catch: java.lang.Throwable -> L79
            r0.append(r3)     // Catch: java.lang.Throwable -> L79
        L5e:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.lang.Throwable -> L63
        L63:
            if (r2 == 0) goto L81
        L65:
            r2.destroy()     // Catch: java.lang.Throwable -> L81
            goto L81
        L69:
            r0 = move-exception
            goto L6d
        L6b:
            r0 = move-exception
            r2 = r1
        L6d:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.lang.Throwable -> L72
        L72:
            if (r2 == 0) goto L77
            r2.destroy()     // Catch: java.lang.Throwable -> L77
        L77:
            throw r0
        L78:
            r2 = r1
        L79:
            if (r1 == 0) goto L7e
            r1.close()     // Catch: java.lang.Throwable -> L7e
        L7e:
            if (r2 == 0) goto L81
            goto L65
        L81:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.SystemUtils.getProcessStartTime():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r3.pid != r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isMainProcess(android.content.Context r5) {
        /*
            java.lang.String r0 = r5.getPackageName()
            int r1 = android.os.Process.myPid()
            r2 = 0
            java.lang.String r3 = "activity"
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch: java.lang.Exception -> L37
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch: java.lang.Exception -> L37
            if (r5 == 0) goto L37
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch: java.lang.Exception -> L37
            if (r5 == 0) goto L37
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L37
        L1d:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Exception -> L37
            if (r3 == 0) goto L37
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Exception -> L37
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Exception -> L37
            java.lang.String r4 = r3.processName     // Catch: java.lang.Exception -> L37
            boolean r4 = r4.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> L37
            if (r4 == 0) goto L1d
            int r5 = r3.pid     // Catch: java.lang.Exception -> L37
            if (r5 != r1) goto L37
            r5 = 1
            return r5
        L37:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.SystemUtils.isMainProcess(android.content.Context):boolean");
    }

    public static boolean isAppForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        LogUtil.log("此appimportace =" + runningAppProcessInfo.importance + ",context.getClass().getName()=" + context.getClass().getName());
                        if (runningAppProcessInfo.importance != 100) {
                            LogUtil.log("处于后台" + runningAppProcessInfo.processName);
                            return false;
                        }
                        LogUtil.log("处于前台" + runningAppProcessInfo.processName);
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static Date getInstalledTime(Application application) {
        Date date;
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= 9) {
                date = new Date(packageInfo.lastUpdateTime);
            } else {
                ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 0);
                if (applicationInfo == null) {
                    return null;
                }
                date = new Date(new File(applicationInfo.sourceDir).lastModified());
            }
            return date;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void dumpHeapInfo() {
        if (CrashLog.getControler().isForceDumpHeap()) {
            try {
                File dumpHprofDataFile = CrashLog.getControler().getDumpHprofDataFile();
                if (dumpHprofDataFile != null) {
                    if (dumpHprofDataFile.exists()) {
                        dumpHprofDataFile.delete();
                    }
                    Debug.dumpHprofData(dumpHprofDataFile.getAbsolutePath());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String getLibNameWithPath(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            int i = lastIndexOf + 1;
            return str.regionMatches(i, "lib", 0, 3) ? str.substring(i) : "";
        }
        return "";
    }

    public static String getAnrJavaStack() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nJavaStack:\r\n");
        sb.append(getThreadStack(Looper.getMainLooper().getThread()));
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().contains("AutoMainThread") || "AutoMainThread".contains(thread.getName())) {
                sb.append(getThreadStack(thread));
            } else if (thread.getName().contains("MainScreen") || "MainScreen".contains(thread.getName())) {
                sb.append(getThreadStack(thread));
            }
        }
        return sb.toString();
    }

    public static String getThreadStack(Thread thread) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder();
        if (thread == null) {
            return sb.toString();
        }
        sb.append("Thread name :" + thread.getName() + "\tid :" + thread.getId() + "\tstate :" + thread.getState() + "\r\n");
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append("\t" + stackTraceElement + "\r\n");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public static boolean clearApplicationData(Context context, boolean z, boolean z2, File... fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                cleanCustomCache(file);
            }
        }
        return !z || clearApplicationPrivateData(context, z2);
    }

    public static boolean clearApplicationPrivateData(Context context, boolean z) {
        if (context == null) {
            return false;
        }
        if (z && clearApplicationPrivateDataByCmd(context.getApplicationInfo().packageName)) {
            return true;
        }
        return clearApplicationPrivateDataByDelete(context);
    }

    public static boolean clearApplicationPrivateDataByCmd(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("pm clear " + str);
            if (exec.waitFor() == 0) {
                String readStr = IOUtil.readStr(exec.getInputStream());
                if (TextUtils.isEmpty(readStr)) {
                    return true;
                }
                if (readStr.equalsIgnoreCase("success")) {
                    return true;
                }
            }
        } catch (IOException | InterruptedException unused) {
        }
        return false;
    }

    public static boolean clearApplicationPrivateDataByDelete(Context context) {
        cleanInternalCache(context);
        cleanExternalCache(context);
        cleanDatabases(context);
        cleanSharedPreference(context);
        cleanFiles(context);
        return true;
    }

    private static void deleteFileInternal(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (File file2 : file.listFiles()) {
                deleteFileInternal(file2);
            }
            file.delete();
        }
    }

    public static void cleanInternalCache(Context context) {
        deleteFileInternal(context.getCacheDir());
    }

    public static void cleanDatabases(Context context) {
        deleteFileInternal(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    public static void cleanSharedPreference(Context context) {
        deleteFileInternal(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    public static void cleanFiles(Context context) {
        deleteFileInternal(context.getFilesDir());
    }

    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            deleteFileInternal(context.getExternalCacheDir());
        }
    }

    public static void cleanCustomCache(String str) {
        cleanCustomCache(new File(str));
    }

    public static void cleanCustomCache(File file) {
        deleteFileInternal(file);
    }
}
