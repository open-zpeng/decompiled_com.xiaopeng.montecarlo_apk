package com.autonavi.common.tool;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.common.tool.util.IOUtil;
import com.autonavi.common.tool.util.MessageDigestUtil;
import com.autonavi.gbl.multi.model.MultiModelConstants;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class Utils {
    private static final String[] mapThreadName = {MultiModelConstants.DISP_TYPE_NAME_MAIN_DISP, "GNaviMap-0", "GNaviMap-1", "GNaviMap-GL-0", "Map-Logical-0"};
    private static int sCpuCount;

    public static boolean isSqliteException(Throwable th) {
        return checkException(th, SQLiteException.class);
    }

    public static boolean checkException(Throwable th, Class<?> cls) {
        while (!cls.isInstance(th)) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAnrException(Throwable th) {
        return th != null && th.getMessage().contains("auto anr");
    }

    public static Throwable getException(Throwable th, Class<?> cls) {
        while (!cls.isInstance(th)) {
            th = th.getCause();
            if (th == null) {
                return null;
            }
        }
        return th;
    }

    public static String makeThrowableText(Throwable th) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder();
        if (th != null && th.getStackTrace().length > 0) {
            if (th.getLocalizedMessage() != null) {
                return th.getLocalizedMessage();
            }
            if (th.getMessage() != null) {
                return th.getMessage();
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append("[");
                sb.append(stackTraceElement.getLineNumber());
                sb.append("]");
                sb.append(stackTraceElement.getClassName());
                sb.append(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
                sb.append(stackTraceElement.getMethodName());
                sb.append("###");
            }
        }
        return sb.toString();
    }

    public static String exec(String str) {
        try {
            Process exec = Runtime.getRuntime().exec(str);
            exec.waitFor();
            return IOUtil.readStr(exec.getInputStream());
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isEmptyArray(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static void exitProcess() {
        System.exit(0);
    }

    public static String getApkInfo(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        try {
            sb.append("APK=");
            sb.append(str);
            sb.append(" size=");
            sb.append(file.length());
            sb.append("  md5=");
            sb.append(MessageDigestUtil.getFileMD5(file));
            sb.append(FDManager.LINE_SEPERATOR);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String getKeystoreInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                for (int i = 0; i < packageInfo.signatures.length; i++) {
                    sb.append(MessageDigestUtil.getByteArrayMD5(packageInfo.signatures[i].toByteArray()));
                    if (packageInfo.signatures.length - i > 1) {
                        sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static int getCpuCount() {
        if (sCpuCount != 0) {
            return sCpuCount;
        }
        File file = new File("/sys/devices/system/cpu");
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(new FilenameFilter() { // from class: com.autonavi.common.tool.Utils.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return Pattern.matches("cpu\\d+", str);
                }
            });
            if (list != null && list.length != 0) {
                sCpuCount = list.length;
                int i = sCpuCount;
                sCpuCount = i > 0 ? i : 1;
                return sCpuCount;
            }
            sCpuCount = 1;
            return sCpuCount;
        }
        sCpuCount = 1;
        return sCpuCount;
    }

    public static <T> List<Future<T>> excCallables(List<Callable<T>> list, long j, int i) {
        if (i <= 0) {
            i = 0;
        }
        if (i <= 0) {
            i = getCpuCount() + 1;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: com.autonavi.common.tool.Utils.2
            int count = 1;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                StringBuilder sb = new StringBuilder();
                sb.append("DC-SOINF#");
                int i2 = this.count;
                this.count = i2 + 1;
                sb.append(i2);
                return new Thread(runnable, sb.toString());
            }
        });
        try {
            if (j > 0) {
                return newFixedThreadPool.invokeAll(list, j, TimeUnit.MILLISECONDS);
            }
            return newFixedThreadPool.invokeAll(list);
        } catch (Throwable th) {
            th.printStackTrace();
            newFixedThreadPool.shutdownNow();
            return null;
        }
    }

    public static long getCrc32(File file) {
        try {
            CRC32 crc32 = new CRC32();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    crc32.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return crc32.getValue();
                }
            }
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String formatCrc32(long j) {
        return String.format("0x%08X", Integer.valueOf((int) j));
    }

    public static boolean isEmulator(Application application) {
        try {
            if (TextUtils.equals("000000000000000", "")) {
                return true;
            }
            if (!Build.MODEL.equals("sdk")) {
                if (!Build.MODEL.equals("google_sdk")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<Integer> getAllThreadIds(int i) {
        ArrayList arrayList = new ArrayList();
        File file = new File("/proc/" + i + "/task/");
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            for (String str : list) {
                try {
                    Integer valueOf = Integer.valueOf(str);
                    if (valueOf.intValue() > 0) {
                        arrayList.add(valueOf);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static boolean matchThreadName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = mapThreadName;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].contains(str) || str.contains(mapThreadName[i])) {
                return true;
            }
            i++;
        }
    }

    public static List<Integer> getAutoNeedThreadIds(int i) {
        List<Integer> allThreadIds = getAllThreadIds(i);
        if (allThreadIds.isEmpty()) {
            return allThreadIds;
        }
        Iterator<Integer> it = allThreadIds.iterator();
        while (it.hasNext()) {
            String threadName = getThreadName(it.next().intValue());
            if (TextUtils.isEmpty(threadName)) {
                it.remove();
            } else if (!matchThreadName(threadName)) {
                it.remove();
            }
        }
        return allThreadIds;
    }

    public static String getThreadName(int i) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file = new File("/proc/" + i + "/comm");
        if (file.exists() && file.canRead()) {
            BufferedReader bufferedReader2 = null;
            try {
                fileReader = new FileReader(file);
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                    fileReader.close();
                    return readLine;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return readLine;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return "";
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        }
        return "";
    }

    public static String getParamsString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            sb.append(entry.getValue());
            sb.append('\n');
        }
        return sb.toString();
    }
}
