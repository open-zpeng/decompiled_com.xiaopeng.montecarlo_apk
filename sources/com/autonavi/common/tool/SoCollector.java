package com.autonavi.common.tool;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.common.tool.util.IOUtil;
import com.autonavi.common.tool.util.LogUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public class SoCollector {
    public static final String APK_LIB = "lib/";
    public static final String DUMP_CRASH_ERROR = "Lcom/autonavi/common/tool/dumpcrash";
    public static final String DUMP_CRASH_ERROR2 = "libdumpcrash.so";
    public static final String LIB_BASE_NAME = "version";
    public static final String LIB_PREFIX = "lib";
    public static final int LIB_PREFIX_LENGTH = 3;
    public static final String LIB_SUFFIX = ".so";
    public static final int MIN_ENTRY_LENGTH = 4;
    public static final String NO_CLASS_DEF_FOUND_CRASH_ERROR = "NoClassDefFoundError";
    public static final String NO_SUCH_METHOD_CRASH_ERROR = "NoSuchMethodError";
    public static final int OPERATE_ERROR_COPY_EXCEPTION = 3;
    public static final int OPERATE_ERROR_NO_INIT = 1;
    public static final int OPERATE_ERROR_NO_SPACE = 2;
    public static final int OPERATE_SUCCESS = 0;
    public static final String UNSATISFIED_LINK_CRASH_ERROR = "UnsatisfiedLinkError";
    public static final String LIBDVM_PATH = "/system/lib/libdvm.so";
    public static final String LIBART_PATH = "/system/lib/libart.so";
    private static final String[] SYSTEM_LIBS = {"/system/lib/libEGL.so", "/system/lib/libc.so", "/system/lib/libc++.so", "/system/lib/libandroid_runtime.so", "/system/lib/libui.so", "/system/lib/libhwui.so", "/system/lib/libgui.so", LIBDVM_PATH, LIBART_PATH, "/system/lib/libandroid.so", "/system/bin/linker", "/system/lib/libhwaps.so", "/system/lib/egl/libEGL_VIVANTE.so"};
    private static final String[] SYSTEM_PATH = {"/system/vendor/lib/egl/"};
    public static String BASE_APK_VERSION = "";
    public static String BASE_LIB_PATH = "";
    public static List<String> exceptLibPath = new ArrayList();

    /* loaded from: classes.dex */
    public interface TamperLibraryCallBack {
        void complete(int i);
    }

    public static synchronized void removeOtherTamerFixLibPath(Context context) {
        synchronized (SoCollector.class) {
            initBasePath(context);
            LogUtil.log("BASE_APK_VERSION = " + BASE_APK_VERSION + ",BASE_LIB_PATH" + BASE_LIB_PATH);
            if (!TextUtils.isEmpty(BASE_APK_VERSION) && !TextUtils.isEmpty(BASE_LIB_PATH)) {
                File file = new File(BASE_LIB_PATH);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        if (!BASE_APK_VERSION.equals(file2.getName())) {
                            IOUtil.deleteFileOrDir(file2);
                        }
                    }
                }
            }
        }
    }

    public static String getLibPath(Context context) {
        initBasePath(context);
        if (TextUtils.isEmpty(BASE_APK_VERSION) || TextUtils.isEmpty(BASE_LIB_PATH)) {
            return "";
        }
        return BASE_LIB_PATH + File.separator + BASE_APK_VERSION;
    }

    private static synchronized void initBasePath() {
        synchronized (SoCollector.class) {
            initBasePath(null);
        }
    }

    private static synchronized void initBasePath(Context context) {
        synchronized (SoCollector.class) {
            if (TextUtils.isEmpty(BASE_APK_VERSION)) {
                if (context == null) {
                    Application application = CrashLog.getApplication();
                    if (application == null) {
                        return;
                    }
                    context = application.getApplicationContext();
                }
                try {
                    BASE_APK_VERSION = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    BASE_LIB_PATH = context.getDir("version", 0).getAbsolutePath();
                } catch (PackageManager.NameNotFoundException unused) {
                    LogUtil.log("get version name error");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SoFileEntry {
        public long crc32;
        public File file;
        public long fileLength;
        public String fileName;

        public boolean equals(Object obj) {
            if (obj instanceof SoCollector) {
                return this.fileName.equals(((SoFileEntry) obj).fileName);
            }
            return false;
        }

        public String toString() {
            return "SoFile:" + this.file + "\tSoFileLength:" + this.fileLength + "\tSoFileCrc32:" + this.crc32;
        }
    }

    private static Map<String, SoFileEntry> dumpLibs(Application application, String str) {
        HashMap hashMap = new HashMap();
        dumpMainAppSoLibs(application, str, hashMap);
        return hashMap;
    }

    private static void dumpMainAppSoLibs(Application application, String str, Map<String, SoFileEntry> map) {
        try {
            File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: com.autonavi.common.tool.SoCollector.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().endsWith(SoCollector.LIB_SUFFIX);
                }
            });
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file != null && file.exists()) {
                        SoFileEntry soFileEntry = new SoFileEntry();
                        soFileEntry.file = file;
                        soFileEntry.fileName = file.getName();
                        map.put(soFileEntry.fileName, soFileEntry);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAbi() {
        String abi = CrashLog.getControler().getAbi();
        if (!TextUtils.isEmpty(abi)) {
            LogUtil.log("getDefaultAbi:" + abi);
            return abi;
        }
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str)) {
            LogUtil.log("supportAbi is null");
            return "armeabi";
        }
        return str;
    }

    public static void saveFileToUpload(File file) {
        FileInputStream fileInputStream;
        try {
            File file2 = new File(CrashLog.getControler().getErrorSoUploadDir(), file.getName());
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, false);
                    try {
                        IOUtil.copy(fileInputStream, fileOutputStream2);
                        IOUtil.closeQuietly(fileInputStream);
                        IOUtil.closeQuietly(fileOutputStream2);
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        IOUtil.closeQuietly(fileInputStream);
                        IOUtil.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (Throwable unused) {
        }
    }

    private static Map<String, SoFileEntry> calcCrc32(Map<String, SoFileEntry> map) {
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (final SoFileEntry soFileEntry : map.values()) {
                arrayList.add(new Callable<Integer>() { // from class: com.autonavi.common.tool.SoCollector.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Integer call() throws Exception {
                        if (SoFileEntry.this.fileLength == 0) {
                            SoFileEntry soFileEntry2 = SoFileEntry.this;
                            soFileEntry2.fileLength = (int) soFileEntry2.file.length();
                        }
                        if (SoFileEntry.this.crc32 == 0) {
                            SoFileEntry soFileEntry3 = SoFileEntry.this;
                            soFileEntry3.crc32 = Utils.getCrc32(soFileEntry3.file);
                            return null;
                        }
                        return null;
                    }
                });
            }
            Utils.excCallables(arrayList, 0L, 2);
        }
        return map;
    }

    private static Map<String, SoFileEntry> dumpInApkLibsByJava(Context context) {
        int lastIndexOf;
        HashMap hashMap = new HashMap();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            LogUtil.log("start dumpInApkLibsByJava");
            String str = context.getApplicationInfo().sourceDir;
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!name.startsWith("..") && !name.startsWith(".") && name.length() >= 4 && name.endsWith(LIB_SUFFIX) && name.startsWith(APK_LIB) && (lastIndexOf = name.lastIndexOf(47)) >= 0) {
                        int i = lastIndexOf + 1;
                        if (name.regionMatches(i, LIB_PREFIX, 0, 3)) {
                            String substring = name.substring(i);
                            SoFileEntry soFileEntry = new SoFileEntry();
                            soFileEntry.fileName = substring;
                            soFileEntry.fileLength = nextElement.getSize();
                            soFileEntry.crc32 = nextElement.getCrc();
                            soFileEntry.file = new File(str, substring);
                            hashMap.put(substring, soFileEntry);
                        }
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            zipFile.close();
            LogUtil.log("end dumpInApkLibsByJava time :" + (currentTimeMillis2 - currentTimeMillis));
        } catch (Exception e) {
            LogUtil.log("dumpInApkLibsByJava error " + e.getMessage());
        }
        return hashMap;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:49:0x01cc
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String getSoInfo(android.app.Application r18, boolean[] r19) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.SoCollector.getSoInfo(android.app.Application, boolean[]):java.lang.String");
    }

    private static boolean checkSoNoMatchException(Throwable th) {
        if (th == null) {
            return false;
        }
        return Utils.checkException(th, UnsatisfiedLinkError.class) || Utils.checkException(th, NoClassDefFoundError.class) || Utils.checkException(th, NoSuchMethodError.class);
    }

    private static boolean checkSoNoMatchException(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(UNSATISFIED_LINK_CRASH_ERROR) || str.contains(NO_SUCH_METHOD_CRASH_ERROR) || str.contains(NO_CLASS_DEF_FOUND_CRASH_ERROR);
    }

    private static boolean checkDumpCrashException(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(DUMP_CRASH_ERROR) || str.contains("libdumpcrash.so");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
        r10 = new com.autonavi.common.tool.SoCollector.SoFileEntry();
        r10.file = r5;
        r10.fileName = r5.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r19 = r7;
        r20 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
        r10.crc32 = com.autonavi.common.tool.Utils.getCrc32(r5);
        r10.fileLength = r5.length();
        r2.append("\t");
        r2.append("SORight.");
        r2.append("file=");
        r2.append(r10.file);
        r2.append("\t len=");
        r2.append(r10.fileLength);
        r2.append("\t crc32=");
        r2.append(com.autonavi.common.tool.Utils.formatCrc32(r10.crc32));
        r2.append(com.autonavi.common.tool.FDManager.LINE_SEPERATOR);
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0222, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0224, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0231, code lost:
        r16 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0237, code lost:
        r3 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0264 A[Catch: all -> 0x0284, TRY_LEAVE, TryCatch #3 {all -> 0x0284, blocks: (B:89:0x0246, B:91:0x0264, B:20:0x0031), top: B:103:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getSoInfo(java.lang.Throwable r17, java.lang.String r18, android.app.Application r19, boolean r20, boolean[] r21) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.SoCollector.getSoInfo(java.lang.Throwable, java.lang.String, android.app.Application, boolean, boolean[]):java.lang.String");
    }

    public static String getSysLibSoInfo() {
        LogUtil.log("getSysLibSoInfo");
        StringBuilder sb = new StringBuilder();
        int length = SYSTEM_LIBS.length;
        for (int i = 0; i < length; i++) {
            File file = new File(SYSTEM_LIBS[i]);
            if (file.exists()) {
                LogUtil.log(SYSTEM_LIBS[i] + " exists");
                appendSystemLibInfo(sb, file);
            } else {
                sb.append("\tfile=");
                sb.append(SYSTEM_LIBS[i]);
                sb.append(" no exists");
                sb.append(FDManager.LINE_SEPERATOR);
            }
        }
        int length2 = SYSTEM_PATH.length;
        for (int i2 = 0; i2 < length2; i2++) {
            File file2 = new File(SYSTEM_PATH[i2]);
            if (!file2.exists() || !file2.isDirectory()) {
                sb.append("\tpath=");
                sb.append(SYSTEM_PATH[i2]);
                sb.append(" no exists");
                sb.append(FDManager.LINE_SEPERATOR);
            } else {
                File[] listFiles = file2.listFiles(new FilenameFilter() { // from class: com.autonavi.common.tool.SoCollector.3
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file3, String str) {
                        return str.endsWith(SoCollector.LIB_SUFFIX);
                    }
                });
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (file3.exists() && file3.isFile()) {
                            appendSystemLibInfo(sb, file3);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private static void appendSystemLibInfo(StringBuilder sb, File file) {
        try {
            long length = file.length();
            String formatCrc32 = Utils.formatCrc32(Utils.getCrc32(file));
            sb.append("\tfile=");
            sb.append(file.getAbsolutePath());
            sb.append("\tlen=");
            sb.append(length);
            sb.append("\tcrc_value=");
            sb.append(formatCrc32);
            sb.append(FDManager.LINE_SEPERATOR);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void getSystemNativeList() {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            getV23SystemNativeList();
        } else {
            getV14SystemNativeList();
        }
    }

    private static void getV14SystemNativeList() {
        Object pathList;
        Application application = CrashLog.getApplication();
        if (application == null || (pathList = getPathList((PathClassLoader) application.getClassLoader())) == null) {
            return;
        }
        try {
            Field declaredField = pathList.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(pathList);
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    Log.d("wkzcc", obj2.toString());
                }
            } else if (obj instanceof File[]) {
                File[] fileArr = new File[((File[]) obj).length];
                System.arraycopy(obj, 0, fileArr, 0, ((File[]) obj).length);
                for (File file : fileArr) {
                    Log.d("wkzcc", file.getAbsolutePath());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private static void getV23SystemNativeList() {
        Object pathList;
        Application application = CrashLog.getApplication();
        if (application == null || (pathList = getPathList((PathClassLoader) application.getClassLoader())) == null) {
            return;
        }
        try {
            Field declaredField = pathList.getClass().getDeclaredField("nativeLibraryPathElements");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(pathList);
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    Log.d("wkzcc", obj2.toString());
                }
            } else if (obj instanceof Object[]) {
                Object[] objArr = new Object[((Object[]) obj).length];
                System.arraycopy(obj, 0, objArr, 0, ((Object[]) obj).length);
                for (Object obj3 : objArr) {
                    Log.d("wkzcc", obj3.toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private static Object getPathList(Object obj) {
        try {
            Field declaredField = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void dumpInApkLibs(TamperLibraryCallBack tamperLibraryCallBack, Context context, long j) {
        dumpInApkLibs(tamperLibraryCallBack, context, j, "");
    }

    public static void dumpInApkLibs(TamperLibraryCallBack tamperLibraryCallBack, Context context, long j, String str) {
        if (context == null) {
            Application application = CrashLog.getApplication();
            if (application == null) {
                LogUtil.log("dumpInApkLibs error as application = null");
                tamperLibraryCallBack.complete(1);
                return;
            }
            context = application.getApplicationContext();
        }
        initBasePath(context);
        if (TextUtils.isEmpty(BASE_APK_VERSION) || TextUtils.isEmpty(BASE_LIB_PATH)) {
            LogUtil.log("dumpInApkLibs error as application = null");
            tamperLibraryCallBack.complete(1);
            return;
        }
        File file = new File(BASE_LIB_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, BASE_APK_VERSION);
        if (file2.exists()) {
            LogUtil.log("has filedir and delete");
            IOUtil.deleteFileOrDir(file2);
        }
        file2.mkdirs();
        try {
            long usableSpace = file2.getUsableSpace();
            LogUtil.log("libpath = " + file2 + ",usableSpace = " + usableSpace);
            if (usableSpace < j) {
                tamperLibraryCallBack.complete(2);
                return;
            }
            boolean copyLibFromApkToDest = copyLibFromApkToDest(context.getApplicationInfo().nativeLibraryDir, true, context, str);
            if (!copyLibFromApkToDest) {
                copyLibFromApkToDest = copyLibFromApkToDest(file2.getAbsolutePath(), false, context, str);
            }
            if (!copyLibFromApkToDest) {
                tamperLibraryCallBack.complete(3);
            } else {
                tamperLibraryCallBack.complete(0);
            }
        } catch (Exception unused) {
            LogUtil.log("dumpInApkLibs error as usableSpace exception");
            tamperLibraryCallBack.complete(2);
        }
    }

    public static boolean copyLibFromApkToDest(String str, boolean z, Context context, String str2) {
        String str3;
        boolean z2;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        int lastIndexOf;
        boolean z3 = false;
        if (context == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
            z2 = true;
        } else {
            str3 = System.mapLibraryName(str2);
            z2 = false;
        }
        InputStream inputStream = null;
        try {
            zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                fileOutputStream = null;
                while (true) {
                    try {
                        try {
                            if (!entries.hasMoreElements()) {
                                break;
                            }
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                if (!name.startsWith("..") && !name.startsWith(".") && name.length() >= 4 && name.endsWith(LIB_SUFFIX) && name.startsWith(APK_LIB) && (lastIndexOf = name.lastIndexOf(47)) >= 0) {
                                    int i = lastIndexOf + 1;
                                    if (name.regionMatches(i, LIB_PREFIX, 0, 3)) {
                                        String substring = name.substring(i);
                                        if (z2 || TextUtils.isEmpty(str3) || str3.equals(substring)) {
                                            inputStream = zipFile.getInputStream(nextElement);
                                            File file = new File(str, URLEncoder.encode(substring, "UTF-8"));
                                            if (!file.exists()) {
                                                File parentFile = file.getParentFile();
                                                if (!parentFile.exists()) {
                                                    parentFile.mkdirs();
                                                }
                                            }
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                            try {
                                                byte[] bArr = new byte[1048576];
                                                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                                                    fileOutputStream2.write(bArr, 0, read);
                                                }
                                                fileOutputStream2.close();
                                                inputStream.close();
                                                if (!z2 && !TextUtils.isEmpty(str3) && str3.equals(substring)) {
                                                    fileOutputStream = fileOutputStream2;
                                                    break;
                                                }
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception e) {
                                                e = e;
                                                fileOutputStream = fileOutputStream2;
                                                LogUtil.log("dump file error " + e.getMessage());
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (zipFile != null) {
                                                    zipFile.close();
                                                }
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                LogUtil.log("all copy time = " + (currentTimeMillis2 - currentTimeMillis));
                                                return z3;
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = fileOutputStream2;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception unused2) {
                                                        throw th;
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (zipFile != null) {
                                                    zipFile.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                zipFile.close();
                z3 = true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            zipFile = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            fileOutputStream = null;
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        LogUtil.log("all copy time = " + (currentTimeMillis22 - currentTimeMillis));
        return z3;
    }
}
