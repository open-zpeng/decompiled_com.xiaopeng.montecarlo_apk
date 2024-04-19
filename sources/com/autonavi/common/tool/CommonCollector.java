package com.autonavi.common.tool;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemProperties;
import com.autonavi.common.tool.util.SystemUtils;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public class CommonCollector {
    private static Object s_activityThreadObject;

    private static String getdexPathListInfo(Application application) {
        File[] fileArr;
        StringBuilder sb = new StringBuilder();
        sb.append("\nDEXPATHLIST:\n");
        try {
            ClassLoader classLoader = application.getClassLoader();
            classLoader.getClass();
            Class.forName("dalvik.system.DexPathList", true, application.getClassLoader());
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element", true, application.getClassLoader());
            try {
                try {
                    Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(classLoader);
                    Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
                    Field declaredField3 = obj.getClass().getDeclaredField("dexElements");
                    declaredField3.setAccessible(true);
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    sb.append("LIBPATHS:\n");
                    if (obj2 instanceof File[]) {
                        for (File file : (File[]) obj2) {
                            sb.append("\t");
                            sb.append("libPath=");
                            sb.append(file.getPath());
                            sb.append(FDManager.LINE_SEPERATOR);
                        }
                    }
                    Field declaredField4 = cls.getDeclaredField("file");
                    declaredField4.setAccessible(true);
                    Field declaredField5 = cls.getDeclaredField("zipFile");
                    declaredField5.setAccessible(true);
                    Field declaredField6 = cls.getDeclaredField("dexFile");
                    declaredField6.setAccessible(true);
                    sb.append("ELEMENTS:\n");
                    Object obj3 = declaredField3.get(obj);
                    int length = Array.getLength(obj3);
                    for (int i = 0; i < length; i++) {
                        Object obj4 = Array.get(obj3, i);
                        ZipFile zipFile = (ZipFile) declaredField5.get(obj4);
                        DexFile dexFile = (DexFile) declaredField6.get(obj4);
                        sb.append("\t");
                        sb.append("file=");
                        sb.append((File) declaredField4.get(obj4));
                        sb.append(" zipFile=");
                        String str = null;
                        sb.append(zipFile == null ? null : zipFile.getName());
                        sb.append(" dexFile=");
                        if (dexFile != null) {
                            str = dexFile.getName();
                        }
                        sb.append(str);
                        sb.append(FDManager.LINE_SEPERATOR);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static void init(Application application) {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    try {
                        s_activityThreadObject = Class.forName("android.app.ActivityThread", true, application.getClassLoader()).getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getResourcesInfo43(android.app.Application r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "android.app.ActivityThread"
            java.lang.ClassLoader r4 = r7.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1e
            java.lang.Class r3 = java.lang.Class.forName(r3, r2, r4)     // Catch: java.lang.ClassNotFoundException -> L1e
            java.lang.String r4 = "android.app.ActivityThread$ResourcesKey"
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1c
            java.lang.Class r1 = java.lang.Class.forName(r4, r2, r7)     // Catch: java.lang.ClassNotFoundException -> L1c
            goto L23
        L1c:
            r7 = move-exception
            goto L20
        L1e:
            r7 = move-exception
            r3 = r1
        L20:
            r7.printStackTrace()
        L23:
            if (r3 != 0) goto L28
            java.lang.String r7 = ""
            return r7
        L28:
            java.lang.String r7 = "mActiveResources"
            java.lang.reflect.Field r7 = r3.getDeclaredField(r7)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            r7.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r3 = "mResDir"
            java.lang.reflect.Field r3 = r1.getDeclaredField(r3)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            r3.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.Object r2 = com.autonavi.common.tool.CommonCollector.s_activityThreadObject     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.Object r7 = r7.get(r2)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.util.Map r7 = (java.util.Map) r7     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.util.Set r2 = r7.keySet()     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
        L4a:
            boolean r4 = r2.hasNext()     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            if (r4 == 0) goto L8e
            java.lang.Object r4 = r2.next()     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            boolean r5 = r1.isInstance(r4)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            if (r5 == 0) goto L4a
            java.lang.Object r5 = r3.get(r4)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.Object r4 = r7.get(r4)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r6 = "\t"
            r0.append(r6)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r6 = "resDir="
            r0.append(r6)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            r0.append(r5)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r5 = " res="
            r0.append(r5)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.Object r4 = r4.get()     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            r0.append(r4)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch: java.lang.IllegalAccessException -> L85 java.lang.NoSuchFieldException -> L8a
            goto L4a
        L85:
            r7 = move-exception
            r7.printStackTrace()
            goto L8e
        L8a:
            r7 = move-exception
            r7.printStackTrace()
        L8e:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.CommonCollector.getResourcesInfo43(android.app.Application):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getResourcesInfo44(android.app.Application r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "android.app.ResourcesManager"
            java.lang.ClassLoader r4 = r7.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1e
            java.lang.Class r3 = java.lang.Class.forName(r3, r2, r4)     // Catch: java.lang.ClassNotFoundException -> L1e
            java.lang.String r4 = "android.content.res.ResourcesKey"
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L1c
            java.lang.Class r7 = java.lang.Class.forName(r4, r2, r7)     // Catch: java.lang.ClassNotFoundException -> L1c
            goto L24
        L1c:
            r7 = move-exception
            goto L20
        L1e:
            r7 = move-exception
            r3 = r1
        L20:
            r7.printStackTrace()
            r7 = r1
        L24:
            if (r3 != 0) goto L29
            java.lang.String r7 = ""
            return r7
        L29:
            java.lang.String r4 = "getInstance"
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r6)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r6 = "mActiveResources"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            r3.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r6 = "mResDir"
            java.lang.reflect.Field r6 = r7.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            r6.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.Object r1 = r4.invoke(r1, r2)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.Object r1 = r3.get(r1)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.util.Set r2 = r1.keySet()     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
        L58:
            boolean r3 = r2.hasNext()     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            if (r3 == 0) goto La6
            java.lang.Object r3 = r2.next()     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            boolean r4 = r7.isInstance(r3)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            if (r4 == 0) goto L58
            java.lang.Object r4 = r6.get(r3)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r5 = "\t"
            r0.append(r5)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r5 = "resDir="
            r0.append(r5)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            r0.append(r4)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r4 = " res="
            r0.append(r4)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.Object r3 = r3.get()     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            r0.append(r3)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch: java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L98 java.lang.NoSuchMethodException -> L9d java.lang.NoSuchFieldException -> La2
            goto L58
        L93:
            r7 = move-exception
            r7.printStackTrace()
            goto La6
        L98:
            r7 = move-exception
            r7.printStackTrace()
            goto La6
        L9d:
            r7 = move-exception
            r7.printStackTrace()
            goto La6
        La2:
            r7 = move-exception
            r7.printStackTrace()
        La6:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.CommonCollector.getResourcesInfo44(android.app.Application):java.lang.String");
    }

    public static String heapErrorLastAppendInfo(Application application, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\n\n");
            sb.append("VerifyDex:");
            sb.append(FDManager.LINE_SEPERATOR);
            try {
                str2 = new File(str).getCanonicalPath();
            } catch (Throwable unused) {
                str2 = null;
            }
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append("SOlib:");
            sb.append(str);
            sb.append(" -> ");
            sb.append(str2);
            sb.append(FDManager.LINE_SEPERATOR);
            ArrayList arrayList = new ArrayList();
            arrayList.add(application);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Application application2 = (Application) it.next();
                sb.append(FDManager.LINE_SEPERATOR);
                sb.append("apkInfo:");
                sb.append(FDManager.LINE_SEPERATOR);
                ApplicationInfo applicationInfo = application2.getApplicationInfo();
                if (applicationInfo != null) {
                    sb.append("\t");
                    sb.append("libDir=");
                    sb.append(applicationInfo.nativeLibraryDir);
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("\t");
                    sb.append("appUid=");
                    sb.append(applicationInfo.uid);
                    sb.append(" myUid=");
                    sb.append(Process.myUid());
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("\t");
                    sb.append("sourceDir=");
                    sb.append(applicationInfo.sourceDir);
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("\t");
                    sb.append("publicSourceDir=");
                    sb.append(applicationInfo.publicSourceDir);
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("\t");
                    sb.append("keystore=");
                    sb.append(Utils.getKeystoreInfo(application2));
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("\t");
                    sb.append(Utils.getApkInfo(applicationInfo.sourceDir, null));
                }
            }
            sb.append(getPhoneInfo());
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r10.hasTrimMaps == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String lastAppendInfo(android.app.Application r7, java.lang.String r8, java.lang.Thread r9, com.autonavi.common.tool.util.CrashFileManager.NativeErrorInfo r10) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.CommonCollector.lastAppendInfo(android.app.Application, java.lang.String, java.lang.Thread, com.autonavi.common.tool.util.CrashFileManager$NativeErrorInfo):java.lang.String");
    }

    private static void printMemoryInfo(StringBuilder sb, Debug.MemoryInfo memoryInfo) {
        sb.append("\tDalvikPSS: ");
        sb.append(memoryInfo.dalvikPss);
        sb.append('\n');
        sb.append("\tDalvikPrivateDirty: ");
        sb.append(memoryInfo.dalvikPrivateDirty);
        sb.append('\n');
        sb.append("\tDalvikShareDirty: ");
        sb.append(memoryInfo.dalvikSharedDirty);
        sb.append('\n');
        sb.append("\tNativePSS: ");
        sb.append(memoryInfo.nativePss);
        sb.append('\n');
        sb.append("\tNativePrivateDirty: ");
        sb.append(memoryInfo.nativePrivateDirty);
        sb.append('\n');
        sb.append("\tNativeShareDirty: ");
        sb.append(memoryInfo.nativeSharedDirty);
        sb.append('\n');
        sb.append("\tOtherPSS: ");
        sb.append(memoryInfo.otherPss);
        sb.append('\n');
        sb.append("\tOtherShareDirty: ");
        sb.append(memoryInfo.otherSharedDirty);
        sb.append('\n');
        sb.append("\tOtherPrivateDirty: ");
        sb.append(memoryInfo.otherPrivateDirty);
        sb.append('\n');
        sb.append("\tTotalPSS: ");
        sb.append(memoryInfo.getTotalPss());
        sb.append('\n');
        sb.append("\tTotalPrivateDirty: ");
        sb.append(memoryInfo.getTotalPrivateDirty());
        sb.append('\n');
        sb.append("\tTotalSharedDirty: ");
        sb.append(memoryInfo.getTotalSharedDirty());
        sb.append('\n');
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append("\tTotalPrivateClean: ");
            sb.append(memoryInfo.getTotalPrivateClean());
            sb.append('\n');
            sb.append("\tTotalSharedClean: ");
            sb.append(memoryInfo.getTotalSharedClean());
            sb.append('\n');
            sb.append("\tTotalSwappablePss: ");
            sb.append(memoryInfo.getTotalSwappablePss());
            sb.append('\n');
        }
        sb.append('\n');
        sb.append("Memory Summary (API 23+): ");
        sb.append('\n');
        if (Build.VERSION.SDK_INT >= 23) {
            for (Map.Entry<String, String> entry : memoryInfo.getMemoryStats().entrySet()) {
                sb.append("\t\t");
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append('\n');
            }
        }
    }

    public static String getPhoneInfo() {
        StringBuilder sb = new StringBuilder();
        String str = SystemProperties.get("ro.product.model", "unknown");
        String str2 = SystemProperties.get("ro.product.brand", "unknown");
        sb.append("product_model: ");
        sb.append(str);
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("product_brand: ");
        sb.append(str2);
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("emulator: ");
        sb.append(Utils.isEmulator(CrashLog.getApplication()));
        sb.append(FDManager.LINE_SEPERATOR);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS", Locale.getDefault());
        sb.append("BootTime: ");
        sb.append(simpleDateFormat.format(Long.valueOf(SystemUtils.getSystemBootTime())));
        sb.append('\n');
        return sb.toString();
    }
}
