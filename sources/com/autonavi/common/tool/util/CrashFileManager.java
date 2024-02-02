package com.autonavi.common.tool.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.common.tool.CommonCollector;
import com.autonavi.common.tool.CrashLog;
import com.autonavi.common.tool.CrashLogRecorder;
import com.autonavi.common.tool.FDManager;
import com.autonavi.common.tool.SoCollector;
import com.autonavi.common.tool.Utils;
import com.autonavi.common.tool.dumpcrash;
import com.autonavi.common.tool.util.IOUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class CrashFileManager {
    private static final String ANR_BAK_FILE_PREFIX = "anr_";
    private static final String COLLECTION_FILE_NAME = ".collection";
    private static final String COUNT_GAT = ":";
    private static final int COUNT_SIZE = 4;
    public static final String ERROR_BAK_FILE_NAME = "autonavi_error_log_";
    private static final String ERROR_BAK_FILE_NAME_DEBUG = "debug_";
    private static final String ERROR_BAK_FILE_NAME_SUFFIX = ".txt";
    private static final String HEAP_ERROR_BAK_FILE_NAME = "autonavi_heap_error_log.txt";
    private static final String NATIVE_ERROR_BAK_FILE_NAME = "autonavi_native_error_log.txt";
    private static final String RECORD_FILE_NAME = ".record";
    private static final String RECORD_FILE_PATH = "crash_limit";
    private static final String SO_CORRUPT_FLAG = "SO_CORRUPT_FLAG";
    private static final String SO_CORRUPT_FLAG_SP = "SO_CORRUPT_FLAG_SP";
    private static final String SPLITE_Symbol = "/";
    public static final String TAMPER_ANR_RECORD_FILE_NAME = ".tamper_anr";
    private static final String TAMPER_CRASH_RECORD_FILE_NAME = ".tamper_crash";
    private static CrashFileManager mInstance;
    private LocalRecordFileRemoveThread removeOldThread;
    private File saveDirFolder;
    private String todayVersion;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    private static final String[] TAMPER_STRINGS = {".xposed.", "com.txy.anywhere", "com.anywhere.", ".XposedMod."};
    private int maxTamperCount = 0;
    private int maxForegroundCount = 0;
    private int maxBackgroundCount = 0;
    private int maxAnrCount = 0;
    private int currentTamperCount = 0;
    private int currentForegroundCount = 0;
    private int currentBackgroundCount = 0;
    private int currentAnrCount = 0;
    private Date applicationInitTime = null;
    private boolean mAppIsLunchForeground = false;
    private boolean mWritingAnrInfo = false;

    /* loaded from: classes.dex */
    public enum CrashType {
        TAMPER_CRASH,
        FOREGROUND_CRASH,
        BACKGROUND_CRASH,
        ANR_CRASH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class HeapErrorInfo {
        String gHeapErrorPid = "";
        String gExceptionTime = "";
        String gApplicationInitTime = "";
        String gExceptionVersion = "";
        String gExceptionInfo = "";

        HeapErrorInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class NativeErrorInfo {
        public String initTime = "";
        public String crashTime = "";
        public String appVersion = "";
        public String errorInfo = "";
        public boolean hasTrimMaps = false;
        public boolean hasFdList = false;

        public NativeErrorInfo() {
        }

        public String toString() {
            return "NativeErrorInfo{initTime='" + this.initTime + "', crashTime='" + this.crashTime + "', appVersion='" + this.appVersion + "', errorInfo='" + this.errorInfo + "', hasTrimMaps=" + this.hasTrimMaps + ", hasFdList=" + this.hasFdList + '}';
        }
    }

    public static CrashFileManager getInstance() {
        if (mInstance == null) {
            synchronized (CrashFileManager.class) {
                mInstance = new CrashFileManager();
            }
        }
        return mInstance;
    }

    private CrashFileManager() {
    }

    public void init() {
        String localCrashDir = CrashLog.getControler().getLocalCrashDir();
        String versionName = CrashLog.getControler().getVersionName();
        this.saveDirFolder = new File(localCrashDir, RECORD_FILE_PATH);
        if (!this.saveDirFolder.exists()) {
            this.saveDirFolder.mkdirs();
        }
        this.todayVersion = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + versionName;
        this.maxTamperCount = CrashLog.getControler().getTamperCrashLimitCount();
        if (this.maxTamperCount < 0) {
            this.maxTamperCount = 0;
        }
        this.maxForegroundCount = CrashLog.getControler().getForegroundCrashLimitCount();
        if (this.maxForegroundCount < 0) {
            this.maxForegroundCount = 0;
        }
        this.maxBackgroundCount = CrashLog.getControler().getBackgroundCrashLimitCount();
        if (this.maxBackgroundCount < 0) {
            this.maxBackgroundCount = 0;
        }
        this.maxAnrCount = CrashLog.getControler().getAnrRecordLimitCount();
        if (this.maxAnrCount < 0) {
            this.maxAnrCount = 0;
        }
        LogUtil.logE("init maxTamperCount = " + this.maxTamperCount + ",maxForegroundCount = " + this.maxForegroundCount + ",maxBackgroundCount = " + this.maxBackgroundCount);
        checkWhenInit();
        this.applicationInitTime = new Date();
        this.mAppIsLunchForeground = SystemUtils.isAppForeground(CrashLog.getApplication().getApplicationContext());
    }

    public Date getApplicationInitTime() {
        return this.applicationInitTime;
    }

    public synchronized void startDelFileThread() {
        this.removeOldThread = new LocalRecordFileRemoveThread(CrashLog.getControler().isNeedLocalRecord(), CrashLog.getControler().getLocalCrashRecordLimitCount(), CrashLog.getControler().getLocalCrashDir());
        this.removeOldThread.start();
    }

    public synchronized void stopDelFileThread() {
        if (this.removeOldThread != null) {
            if (this.removeOldThread.isAlive() && !this.removeOldThread.isInterrupted()) {
                this.removeOldThread.interrupt();
            }
            this.removeOldThread = null;
        }
    }

    public void addCrashCount(CrashType crashType) throws IOException {
        if (isReachedLimitToday(crashType)) {
            return;
        }
        File file = new File(this.saveDirFolder, this.todayVersion);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, RECORD_FILE_NAME);
            if (file2.exists() || file2.createNewFile()) {
                int i = AnonymousClass3.$SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[crashType.ordinal()];
                if (i == 1) {
                    this.currentTamperCount++;
                } else if (i == 2) {
                    this.currentForegroundCount++;
                } else if (i == 3) {
                    this.currentBackgroundCount++;
                } else if (i == 4) {
                    this.currentAnrCount++;
                }
                IOUtil.writeStringToFile(this.currentTamperCount + ":" + this.currentForegroundCount + ":" + this.currentBackgroundCount + ":" + this.currentAnrCount, file2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.autonavi.common.tool.util.CrashFileManager$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType = new int[CrashType.values().length];

        static {
            try {
                $SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[CrashType.TAMPER_CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[CrashType.FOREGROUND_CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[CrashType.BACKGROUND_CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[CrashType.ANR_CRASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public boolean isReachedLimitToday(CrashType crashType) {
        Log.d(dumpcrash.LIB_DUMPCRASH, "isReachedLimitToday maxTamperCount = " + this.maxTamperCount + ",maxForegroundCount = " + this.maxForegroundCount + ",maxBackgroundCount = " + this.maxBackgroundCount);
        Log.d(dumpcrash.LIB_DUMPCRASH, "isReachedLimitToday currentTamperCount = " + this.currentTamperCount + ",currentForegroundCount = " + this.currentForegroundCount + ",currentBackgroundCount = " + this.currentBackgroundCount + ",currentAnrCount = " + this.currentAnrCount);
        if (CrashLog.getControler().isDebug()) {
            return false;
        }
        int i = AnonymousClass3.$SwitchMap$com$autonavi$common$tool$util$CrashFileManager$CrashType[crashType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i == 4 && this.currentAnrCount >= this.maxAnrCount : this.currentBackgroundCount >= this.maxBackgroundCount : this.currentForegroundCount >= this.maxForegroundCount : this.currentTamperCount >= this.maxTamperCount;
    }

    private void checkWhenInit() {
        File[] listFiles = this.saveDirFolder.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (!this.todayVersion.equals(file.getName())) {
                IOUtil.deleteFileOrDir(file);
            }
        }
        initTodayCrashCount();
    }

    private void initTodayCrashCount() {
        int[] todayCrashCount = getTodayCrashCount();
        this.currentTamperCount = todayCrashCount[0];
        this.currentForegroundCount = todayCrashCount[1];
        this.currentBackgroundCount = todayCrashCount[2];
        this.currentAnrCount = todayCrashCount[3];
    }

    private int[] getTodayCrashCount() {
        return getSomeDayCrashCount(this.todayVersion);
    }

    private int[] getSomeDayCrashCount(String str) {
        int[] iArr = new int[4];
        File file = new File(new File(this.saveDirFolder, str), RECORD_FILE_NAME);
        if (file.exists()) {
            String readStr = IOUtil.readStr(file);
            if (TextUtils.isEmpty(readStr)) {
                return iArr;
            }
            String[] split = readStr.split(":");
            for (int i = 0; i < 4; i++) {
                try {
                    if (split.length > i) {
                        iArr[i] = Integer.valueOf(split[i]).intValue();
                        if (iArr[i] < 0) {
                            iArr[i] = 0;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return iArr;
        }
        return iArr;
    }

    public synchronized void setAnrWriting() {
        this.mWritingAnrInfo = true;
    }

    public synchronized boolean isAnrWriting() {
        return this.mWritingAnrInfo;
    }

    public void appendUploadFlag(File[] fileArr, String str) {
        FileWriter fileWriter;
        try {
            for (File file : fileArr) {
                FileWriter fileWriter2 = null;
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.write(str + FDManager.LINE_SEPERATOR);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    th.printStackTrace();
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void appendUploadFlag(File[] fileArr) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("uploadtime=");
            sb.append(System.currentTimeMillis());
            sb.append(" pid:");
            sb.append(Process.myPid());
            sb.append(" NetworkType:");
            sb.append(CrashLog.getControler().getCheckNetWork());
        } catch (Throwable unused) {
        }
        appendUploadFlag(fileArr, sb.toString());
    }

    public void recordCrash(String str, Throwable th, Thread thread, boolean z, boolean z2) {
        recordCrash(str, th, false, null, thread, z, z2);
    }

    public void recordCrash(String str, Throwable th, boolean z, HeapErrorInfo heapErrorInfo, Thread thread, boolean z2, NativeErrorInfo nativeErrorInfo, boolean z3) {
        recordCrash(str, th, z, heapErrorInfo, thread, z2, nativeErrorInfo, z3, false, null, null, null);
    }

    public void recordCrash(String str, Throwable th, boolean z, HeapErrorInfo heapErrorInfo, Thread thread, boolean z2, boolean z3) {
        recordCrash(str, th, z, heapErrorInfo, thread, z2, null, z3, false, null, null, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void recordCrash(java.lang.String r19, java.lang.Throwable r20, boolean r21, com.autonavi.common.tool.util.CrashFileManager.HeapErrorInfo r22, java.lang.Thread r23, boolean r24, com.autonavi.common.tool.util.CrashFileManager.NativeErrorInfo r25, boolean r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 1025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.CrashFileManager.recordCrash(java.lang.String, java.lang.Throwable, boolean, com.autonavi.common.tool.util.CrashFileManager$HeapErrorInfo, java.lang.Thread, boolean, com.autonavi.common.tool.util.CrashFileManager$NativeErrorInfo, boolean, boolean, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private boolean isModifyDexError(boolean z, Throwable th) {
        if (z && th != null) {
            return ((th instanceof NoSuchMethodError) || (th instanceof VerifyError)) && th.getMessage().contains("UsbFillActivity");
        }
        return false;
    }

    private String getCrashLibName(String str, boolean z) {
        int indexOf;
        int indexOf2;
        if (z || (indexOf = str.indexOf("backtrace:")) == -1 || (indexOf2 = str.substring(indexOf).indexOf(SoCollector.LIB_SUFFIX)) == -1 || indexOf2 > 100) {
            return "";
        }
        String substring = str.substring(0, indexOf2 + 3);
        if (substring.contains("#00")) {
            LogUtil.logE("getCrashLibName crashStr:" + substring);
            String libNameWithPath = SystemUtils.getLibNameWithPath(substring);
            LogUtil.logE("getCrashLibName :" + libNameWithPath);
            return libNameWithPath;
        }
        return "";
    }

    private boolean checkTamperCrash(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : TAMPER_STRINGS) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void markSoCorrupt(boolean z) {
        if (z) {
            try {
                Application application = CrashLog.getApplication();
                if (application == null) {
                    return;
                }
                application.getSharedPreferences(SO_CORRUPT_FLAG_SP, 0).edit().putBoolean(SO_CORRUPT_FLAG, true).commit();
            } catch (Exception unused) {
            }
        }
    }

    public void removeSoCorruptFlag(Context context) {
        if (context == null && (context = CrashLog.getApplication()) == null) {
            return;
        }
        context.getSharedPreferences(SO_CORRUPT_FLAG_SP, 0).edit().putBoolean(SO_CORRUPT_FLAG, false).commit();
    }

    public boolean hasSoCorrupt(Context context) {
        if (context == null && (context = CrashLog.getApplication()) == null) {
            return false;
        }
        return context.getSharedPreferences(SO_CORRUPT_FLAG_SP, 0).getBoolean(SO_CORRUPT_FLAG, false);
    }

    public void removeLastCrashTime(Context context) {
        if (CrashLog.needCrashModeCheck()) {
            if (context == null && (context = CrashLog.getApplication()) == null) {
                return;
            }
            CrashSharePreference.setStringToSP(context, CrashSharePreference.LAST_CRASH_TIMES, "");
        }
    }

    public void updateLastCrashTime(Context context) {
        String[] split;
        int i;
        if (CrashLog.needCrashModeCheck()) {
            if (context == null && (context = CrashLog.getApplication()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                String stringFormSP = CrashSharePreference.getStringFormSP(context, CrashSharePreference.LAST_CRASH_TIMES, "");
                if (!TextUtils.isEmpty(stringFormSP) && (split = stringFormSP.split(":")) != null && split.length == 2) {
                    long parseLong = Long.parseLong(split[0]);
                    int parseInt = Integer.parseInt(split[1]);
                    if (currentTimeMillis <= parseLong || currentTimeMillis - parseLong >= CrashLog.crashTimeForCrashMode() * 1000) {
                        parseLong = currentTimeMillis;
                    } else if (parseInt > 0) {
                        i = parseInt + 1;
                        CrashSharePreference.setStringToSP(context, CrashSharePreference.LAST_CRASH_TIMES, parseLong + ":" + i);
                        return;
                    }
                    i = 1;
                    CrashSharePreference.setStringToSP(context, CrashSharePreference.LAST_CRASH_TIMES, parseLong + ":" + i);
                    return;
                }
            } catch (Exception unused) {
            }
            CrashSharePreference.setStringToSP(context, CrashSharePreference.LAST_CRASH_TIMES, currentTimeMillis + ":1");
        }
    }

    public boolean needEnterCrashMode(Context context) {
        String[] split;
        if (CrashLog.needCrashModeCheck()) {
            if (context == null && (context = CrashLog.getApplication()) == null) {
                return false;
            }
            System.currentTimeMillis();
            try {
                String stringFormSP = CrashSharePreference.getStringFormSP(context, CrashSharePreference.LAST_CRASH_TIMES, "");
                if (!TextUtils.isEmpty(stringFormSP) && (split = stringFormSP.split(":")) != null && split.length == 2) {
                    Long.parseLong(split[0]);
                    if (Integer.parseInt(split[1]) >= CrashLog.crashCountForCrashMode()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return false;
    }

    private String bringStatusAndLogToEnd(String str) {
        int indexOf = str.indexOf("===[START] KeyValue");
        int indexOf2 = str.indexOf("===[END] KeyValue & Log===");
        if (indexOf <= 0 || indexOf2 <= 0) {
            return str;
        }
        String substring = str.substring(indexOf, indexOf2 + 26);
        if (TextUtils.isEmpty(substring)) {
            return str;
        }
        return (str.replace(substring, "") + substring) + FDManager.LINE_SEPERATOR;
    }

    public boolean buildNativeHeapErrorException() {
        LogUtil.logE("begin buildNativeHeapErrorException");
        final File localHeapErrorFile = getLocalHeapErrorFile();
        if (localHeapErrorFile == null || !localHeapErrorFile.exists()) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.autonavi.common.tool.util.CrashFileManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (localHeapErrorFile.exists()) {
                    final HeapErrorInfo heapErrorInfo = new HeapErrorInfo();
                    final StringBuilder sb = new StringBuilder();
                    IOUtil.readFile(localHeapErrorFile, new IOUtil.ReadFileCallback() { // from class: com.autonavi.common.tool.util.CrashFileManager.1.1
                        @Override // com.autonavi.common.tool.util.IOUtil.ReadFileCallback
                        public boolean onLine(String str) {
                            if (TextUtils.isEmpty(str)) {
                                return false;
                            }
                            if (str.contains("heap_dump_pid:")) {
                                int indexOf = str.indexOf("heap_dump_pid:");
                                heapErrorInfo.gHeapErrorPid = str.substring(indexOf + 14);
                            } else if (str.contains("exceptionTime:")) {
                                int indexOf2 = str.indexOf("exceptionTime:");
                                heapErrorInfo.gExceptionTime = str.substring(indexOf2 + 14);
                            } else if (str.contains("app_init_time:")) {
                                int indexOf3 = str.indexOf("app_init_time:");
                                heapErrorInfo.gApplicationInitTime = str.substring(indexOf3 + 14);
                            } else if (str.contains("except_version:")) {
                                int indexOf4 = str.indexOf("except_version:");
                                heapErrorInfo.gExceptionVersion = str.substring(indexOf4 + 15);
                            } else {
                                StringBuilder sb2 = sb;
                                sb2.append(str);
                                sb2.append('\n');
                            }
                            return false;
                        }
                    });
                    localHeapErrorFile.delete();
                    heapErrorInfo.gExceptionInfo = sb.toString();
                    CrashFileManager.this.recordCrash(heapErrorInfo.gExceptionInfo, null, true, heapErrorInfo, null, false, false);
                }
            }
        }).start();
        return true;
    }

    public boolean buildNativeErrorInfoStart() {
        NativeErrorInfo buildNativeErrorInfo = buildNativeErrorInfo();
        if (buildNativeErrorInfo != null) {
            recordCrash(buildNativeErrorInfo.errorInfo, null, false, null, null, false, buildNativeErrorInfo, false);
            return true;
        }
        return false;
    }

    public NativeErrorInfo buildNativeErrorInfo() {
        String path = getLocalNativeErrorFile().getPath();
        File file = new File(path);
        if (file.exists()) {
            File file2 = new File(path + "_build");
            file.renameTo(file2);
            return buildNativeErrorInfoInner(file2);
        }
        return null;
    }

    public NativeErrorInfo buildNativeErrorInfoInner(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        final NativeErrorInfo nativeErrorInfo = new NativeErrorInfo();
        final StringBuilder sb = new StringBuilder();
        IOUtil.readFile(file, new IOUtil.ReadFileCallback() { // from class: com.autonavi.common.tool.util.CrashFileManager.2
            @Override // com.autonavi.common.tool.util.IOUtil.ReadFileCallback
            public boolean onLine(String str) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (str.contains("AppVersion:")) {
                    int indexOf = str.indexOf("AppVersion: ");
                    nativeErrorInfo.appVersion = str.substring(indexOf + 12);
                } else if (str.contains("CrashTime: ")) {
                    int indexOf2 = str.indexOf("CrashTime: ");
                    nativeErrorInfo.crashTime = str.substring(indexOf2 + 11);
                } else if (str.contains("StartTime: ")) {
                    int indexOf3 = str.indexOf("StartTime: ");
                    nativeErrorInfo.initTime = str.substring(indexOf3 + 11);
                } else if (str.contains("FD List:")) {
                    nativeErrorInfo.hasFdList = true;
                    StringBuilder sb2 = sb;
                    sb2.append(str);
                    sb2.append('\n');
                } else if (str.contains("TrimMaps:")) {
                    nativeErrorInfo.hasTrimMaps = true;
                    StringBuilder sb3 = sb;
                    sb3.append(str);
                    sb3.append('\n');
                } else {
                    StringBuilder sb4 = sb;
                    sb4.append(str);
                    sb4.append('\n');
                }
                return false;
            }
        });
        nativeErrorInfo.errorInfo = sb.toString();
        file.delete();
        return nativeErrorInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0477  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String buildExceptionHeaderInfo(java.lang.String r16, boolean r17, com.autonavi.common.tool.util.CrashFileManager.HeapErrorInfo r18, boolean r19, com.autonavi.common.tool.util.CrashFileManager.NativeErrorInfo r20, boolean r21) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.CrashFileManager.buildExceptionHeaderInfo(java.lang.String, boolean, com.autonavi.common.tool.util.CrashFileManager$HeapErrorInfo, boolean, com.autonavi.common.tool.util.CrashFileManager$NativeErrorInfo, boolean):java.lang.String");
    }

    public String appendCrashInfo(String str, boolean z, Thread thread, boolean z2, NativeErrorInfo nativeErrorInfo) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.append(FDManager.LINE_SEPERATOR);
            if (z) {
                sb.append(CommonCollector.heapErrorLastAppendInfo(CrashLog.getApplication(), CrashLog.getControler().getLibSoPath()));
            } else {
                if (!z2) {
                    sb.append(CommonCollector.lastAppendInfo(CrashLog.getApplication(), CrashLog.getControler().getLibSoPath(), thread, nativeErrorInfo));
                    if (nativeErrorInfo == null || !nativeErrorInfo.hasFdList) {
                        String fDListStr = FDManager.getInstance().getFDListStr();
                        if (!TextUtils.isEmpty(fDListStr)) {
                            sb.append(FDManager.LINE_SEPERATOR);
                            sb.append(fDListStr);
                            sb.append(FDManager.LINE_SEPERATOR);
                        }
                    }
                    String allThreadNameInfo = SystemUtils.getAllThreadNameInfo();
                    if (!TextUtils.isEmpty(allThreadNameInfo)) {
                        sb.append(FDManager.LINE_SEPERATOR);
                        sb.append(allThreadNameInfo);
                        sb.append(FDManager.LINE_SEPERATOR);
                    }
                    if (CrashLogRecorder.getCustomData() != null && CrashLogRecorder.getCustomData().size() > 0) {
                        sb.append("custom:");
                        sb.append(FDManager.LINE_SEPERATOR);
                        for (String str2 : CrashLogRecorder.getCustomData()) {
                            sb.append(str2);
                            sb.append(FDManager.LINE_SEPERATOR);
                        }
                    }
                }
                sb.append("CrashExtraInfo:\n");
                sb.append(Utils.getParamsString(CrashLog.getControler().getCrashExtraInfo()));
            }
            sb.append("IsHeapError: ");
            sb.append(z);
            sb.append('\n');
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public void addTamperCrashCollection(int i, int i2, int i3, Application application) {
        String str;
        if (application == null) {
            return;
        }
        try {
            str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = "unknown";
        }
        TamperCrashCollectionModel tamperCrashCollectionModel = new TamperCrashCollectionModel();
        tamperCrashCollectionModel.appVersion = str;
        if (this.applicationInitTime == null) {
            this.applicationInitTime = new Date();
        }
        tamperCrashCollectionModel.appStartTime = this.applicationInitTime.getTime();
        Date installedTime = SystemUtils.getInstalledTime(application);
        if (installedTime != null) {
            tamperCrashCollectionModel.installTime = installedTime.getTime();
        }
        tamperCrashCollectionModel.tamperType = i;
        tamperCrashCollectionModel.fixStatus = i2;
        tamperCrashCollectionModel.errorCode = i3;
        List<TamperCrashCollectionModel> tamperCrashCollections = getTamperCrashCollections(application);
        if (tamperCrashCollections.size() < 10) {
            tamperCrashCollections.add(tamperCrashCollectionModel);
        } else {
            tamperCrashCollections.remove(0);
            tamperCrashCollections.add(tamperCrashCollectionModel);
        }
        saveTamperCrashCollections(tamperCrashCollections, application);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
        if (r2 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.autonavi.common.tool.util.TamperCrashCollectionModel> getTamperCrashCollections(android.app.Application r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r5 != 0) goto L8
            return r0
        L8:
            java.io.File r5 = new java.io.File
            java.lang.String r1 = com.autonavi.common.tool.CrashLog.getLocalCrashDir()
            java.lang.String r2 = ".tamper_crash"
            r5.<init>(r1, r2)
            boolean r1 = r5.exists()
            if (r1 != 0) goto L1a
            return r0
        L1a:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L59
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L59
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5a
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5a
        L2a:
            java.lang.String r1 = r5.readLine()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            if (r3 == 0) goto L3b
            r5.close()     // Catch: java.lang.Exception -> L62
        L37:
            r2.close()     // Catch: java.lang.Exception -> L62
            goto L62
        L3b:
            com.autonavi.common.tool.util.TamperCrashCollectionModel r1 = com.autonavi.common.tool.util.TamperCrashCollectionModel.stringToModel(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            if (r1 == 0) goto L2a
            r0.add(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            goto L2a
        L45:
            r0 = move-exception
            r1 = r5
            goto L4e
        L48:
            r1 = r5
            goto L5a
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            r2 = r1
        L4e:
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.lang.Exception -> L58
        L53:
            if (r2 == 0) goto L58
            r2.close()     // Catch: java.lang.Exception -> L58
        L58:
            throw r0
        L59:
            r2 = r1
        L5a:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.lang.Exception -> L62
        L5f:
            if (r2 == 0) goto L62
            goto L37
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.CrashFileManager.getTamperCrashCollections(android.app.Application):java.util.List");
    }

    private void saveTamperCrashCollections(List<TamperCrashCollectionModel> list, Application application) {
        FileWriter fileWriter;
        if (list == null || list.isEmpty()) {
            removeAllTamperCrashCollections(application);
            return;
        }
        try {
            fileWriter = new FileWriter(new File(CrashLog.getLocalCrashDir(), TAMPER_CRASH_RECORD_FILE_NAME));
            try {
                Iterator<TamperCrashCollectionModel> it = list.iterator();
                while (it.hasNext()) {
                    fileWriter.write(it.next().toString() + "\r\n");
                }
                fileWriter.flush();
            } catch (Exception unused) {
                if (fileWriter == null) {
                    return;
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable th) {
                th = th;
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileWriter = null;
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused4) {
        }
    }

    public void removeAllTamperCrashCollections(Application application) {
        File file = new File(CrashLog.getLocalCrashDir(), TAMPER_CRASH_RECORD_FILE_NAME);
        if (file.exists()) {
            File file2 = new File(CrashLog.getLocalCrashDir(), ".tamper_crash0");
            file.renameTo(file2);
            file2.delete();
        }
    }

    public void addNormalCrashCollection(NormalCrashCollectionModel normalCrashCollectionModel) {
        List<NormalCrashCollectionModel> normalCrashCollections = getNormalCrashCollections();
        if (normalCrashCollections.size() < 10) {
            normalCrashCollections.add(normalCrashCollectionModel);
        } else {
            normalCrashCollections.remove(0);
            normalCrashCollections.add(normalCrashCollectionModel);
        }
        saveNormalCrashCollections(normalCrashCollections);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.autonavi.common.tool.util.NormalCrashCollectionModel> getNormalCrashCollections() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = com.autonavi.common.tool.CrashLog.getLocalCrashDir()
            java.lang.String r3 = ".collection"
            r1.<init>(r2, r3)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L17
            return r0
        L17:
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L56
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L56
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L57
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L57
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L57
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L57
        L27:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r4 == 0) goto L38
            r1.close()     // Catch: java.lang.Exception -> L5f
        L34:
            r3.close()     // Catch: java.lang.Exception -> L5f
            goto L5f
        L38:
            com.autonavi.common.tool.util.NormalCrashCollectionModel r2 = com.autonavi.common.tool.util.NormalCrashCollectionModel.stringToModel(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r2 == 0) goto L27
            r0.add(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            goto L27
        L42:
            r0 = move-exception
            r2 = r1
            goto L4b
        L45:
            r2 = r1
            goto L57
        L47:
            r0 = move-exception
            goto L4b
        L49:
            r0 = move-exception
            r3 = r2
        L4b:
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.lang.Exception -> L55
        L50:
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.lang.Exception -> L55
        L55:
            throw r0
        L56:
            r3 = r2
        L57:
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.lang.Exception -> L5f
        L5c:
            if (r3 == 0) goto L5f
            goto L34
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.util.CrashFileManager.getNormalCrashCollections():java.util.List");
    }

    private void saveNormalCrashCollections(List<NormalCrashCollectionModel> list) {
        FileWriter fileWriter;
        if (list == null || list.isEmpty()) {
            removeAllNormalCrashCollections();
            return;
        }
        try {
            fileWriter = new FileWriter(new File(CrashLog.getLocalCrashDir(), COLLECTION_FILE_NAME));
            try {
                Iterator<NormalCrashCollectionModel> it = list.iterator();
                while (it.hasNext()) {
                    fileWriter.write(it.next().toString() + "\r\n");
                }
                fileWriter.flush();
            } catch (Exception unused) {
                if (fileWriter == null) {
                    return;
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable th) {
                th = th;
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileWriter = null;
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused4) {
        }
    }

    public void removeAllNormalCrashCollections() {
        File file = new File(CrashLog.getLocalCrashDir(), COLLECTION_FILE_NAME);
        if (file.exists()) {
            File file2 = new File(CrashLog.getLocalCrashDir(), ".collection0");
            file.renameTo(file2);
            file2.delete();
        }
    }

    private String getLocalRecordFileName() {
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        StringBuilder sb = new StringBuilder(ERROR_BAK_FILE_NAME);
        if (CrashLog.debugMode()) {
            sb.append(ERROR_BAK_FILE_NAME_DEBUG);
        }
        sb.append(format);
        sb.append(ERROR_BAK_FILE_NAME_SUFFIX);
        return sb.toString();
    }

    private File getLocalRecordFile() {
        String localCrashDir = CrashLog.getLocalCrashDir();
        if (TextUtils.isEmpty(localCrashDir)) {
            return null;
        }
        return new File(localCrashDir, getLocalRecordFileName());
    }

    public File getLocalHeapErrorFile() {
        String localCrashDir = CrashLog.getLocalCrashDir();
        if (TextUtils.isEmpty(localCrashDir)) {
            return null;
        }
        return new File(localCrashDir, "autonavi_heap_error_log.txt");
    }

    public File getLocalNativeErrorFile() {
        String localCrashDir = CrashLog.getLocalCrashDir();
        if (TextUtils.isEmpty(localCrashDir)) {
            return null;
        }
        return new File(localCrashDir, NATIVE_ERROR_BAK_FILE_NAME);
    }
}
