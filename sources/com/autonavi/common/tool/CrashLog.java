package com.autonavi.common.tool;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.common.tool.SoCollector;
import com.autonavi.common.tool.sign.Sign;
import com.autonavi.common.tool.upload.UploadFileManager;
import com.autonavi.common.tool.util.CrashFileManager;
import com.autonavi.common.tool.util.LogUtil;
import com.autonavi.common.tool.util.NormalCrashCollectionModel;
import com.autonavi.common.tool.util.SystemUtils;
import com.autonavi.common.tool.util.TamperCrashCollectionModel;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class CrashLog {
    public static String Tag = "";
    private static String adiu;
    private static long anrCost;
    private static int anrCount;
    private static String appVersion;
    private static Application application;
    private static ICrashLogController controler;
    private static int crashCountForCrashMode;
    private static int crashTimeForCrashMode;
    private static String dibv;
    private static String dic;
    private static String diu;
    private static String diu2;
    private static String diu3;
    private static String div;
    private static boolean hasInit;
    private static boolean isNeedCrashModeCheck;
    private static volatile boolean jniReportOtherThread;
    private static String logSpyId;
    private static boolean mIsDebugMode;
    private static boolean mNeedBuildHeapError;
    private static String session;
    private static String tid;

    public static void loadLibrary() {
        dumpcrash.loadLibrary();
    }

    public static ICrashLogController getControler() {
        return controler;
    }

    public static synchronized void initCrashLog(ICrashLogController iCrashLogController) {
        synchronized (CrashLog.class) {
            if (hasInit) {
                return;
            }
            if (iCrashLogController == null) {
                throw new RuntimeException("CrashLog.initCrashLog controllerParam == null!");
            }
            controler = iCrashLogController;
            anrCount = 0;
            application = controler.getApplication();
            mIsDebugMode = controler.isDebug();
            ErrorHandler.bindDefault(controler.getApplication());
            CrashFileManager.getInstance().init();
            if (controler.isMainProcess()) {
                buildHeapError();
                buildNativeError();
                CrashFileManager.getInstance().startDelFileThread();
            }
            File localNativeErrorFile = CrashFileManager.getInstance().getLocalNativeErrorFile();
            dumpcrash.install(localNativeErrorFile != null ? localNativeErrorFile.getAbsolutePath() : "");
            String versionName = controler.getVersionName();
            if (TextUtils.isEmpty(versionName)) {
                versionName = "";
            }
            setAppVersion(versionName);
            if (Build.VERSION.SDK_INT >= 21) {
                setJniRepotOtherThread(true);
            }
            UploadFileManager.getInstance(controler);
            CommonCollector.init(controler.getApplication());
            FDManager.getInstance().init(controler.getLocalCrashDir());
            SoCollector.removeOtherTamerFixLibPath(controler.getApplication());
            initCrashModeInfo();
            hasInit = true;
            setLogSwitch(LogUtil.getLogSwitch());
        }
    }

    private static void initCrashModeInfo() {
        ICrashLogController iCrashLogController = controler;
        if (iCrashLogController == null) {
            return;
        }
        isNeedCrashModeCheck = iCrashLogController.needCrashModeCheck();
        crashCountForCrashMode = controler.crashCountForCrashMode();
        crashTimeForCrashMode = controler.crashTimeForCrashMode();
        if (crashCountForCrashMode < 1) {
            crashTimeForCrashMode = 1;
        }
        if (crashTimeForCrashMode < 1) {
            crashTimeForCrashMode = 1;
        }
    }

    private static void buildHeapError() {
        mNeedBuildHeapError = CrashFileManager.getInstance().buildNativeHeapErrorException();
    }

    private static void buildNativeError() {
        boolean buildNativeErrorInfoStart = CrashFileManager.getInstance().buildNativeErrorInfoStart();
        if (buildNativeErrorInfoStart) {
            mNeedBuildHeapError = buildNativeErrorInfoStart;
        }
    }

    public static boolean needBuildHeapError() {
        return mNeedBuildHeapError;
    }

    public static synchronized void setLogSwitch(int i) {
        synchronized (CrashLog.class) {
            LogUtil.setLogSwitch(i);
            if (hasInit) {
                dumpcrash.logSwitch(i);
            }
        }
    }

    public static void setAppVersion(String str) {
        appVersion = str;
        dumpcrash.setAppVersion(str);
    }

    public static void setDiu(String str) {
        diu = str;
    }

    public static void setDiu2(String str) {
        diu2 = str;
    }

    public static void setDiu3(String str) {
        diu3 = str;
    }

    public static void setAdiu(String str) {
        adiu = str;
    }

    public static void setSession(String str) {
        session = str;
    }

    public static void setDic(String str) {
        dic = str;
    }

    public static void setTid(String str) {
        tid = str;
    }

    public static void setDiv(String str) {
        div = str;
    }

    public static void setDibv(String str) {
        dibv = str;
    }

    public static void setLogSpyId(String str) {
        logSpyId = str;
    }

    public static String getNativeThreadBacktrace(int i) {
        return dumpcrash.getNativeThreadBacktrace(i);
    }

    public static void triggerAnrTraces(String str) {
        Log.d("CrashLog", "triggerAnrTraces whiteList = " + str);
        if (getApplication() == null) {
            return;
        }
        anrCost = -1L;
        if (str == null) {
            str = "";
        }
        String str2 = getApplication().getApplicationInfo().nativeLibraryDir + File.separator;
        String str3 = getControler().getLocalCrashDir() + File.separator + CrashFileManager.TAMPER_ANR_RECORD_FILE_NAME;
        File file = new File(str3);
        if (file.exists()) {
            File file2 = new File(str3 + "0");
            file.renameTo(file2);
            file2.delete();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        dumpcrash.getNativeAnrThreadInfo(str, str2, str3);
        anrCost = SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    public static void triggerAnrTraces(String str, String str2, String str3) {
        LogUtil.log("triggerAnrTraces whiteList = " + str + ",anrInfo = " + str2 + ",anrInfoPath = " + str3);
        if (CrashFileManager.getInstance().isAnrWriting()) {
            Log.d("CrashLog", "triggerAnrTraces return as writing = true");
        } else if (anrCount >= getControler().getAnrRecordProcessLimitCount()) {
            Log.d("CrashLog", "triggerAnrTraces reach process limit count");
        } else if (CrashFileManager.getInstance().isReachedLimitToday(CrashFileManager.CrashType.ANR_CRASH)) {
            Log.d("CrashLog", "triggerAnrTraces reach today limit count");
        } else {
            CrashFileManager.getInstance().setAnrWriting();
            anrCount++;
            Exception exc = new Exception("auto anr");
            CrashFileManager.getInstance().recordCrash(SystemUtils.getExceptionString(exc), exc, false, null, null, false, null, true, true, str, str2, str3);
        }
    }

    public static void setJniRepotOtherThread(boolean z) {
        jniReportOtherThread = z;
        dumpcrash.setRepotOtherThread(jniReportOtherThread);
    }

    public static boolean getJniReportOtherThread() {
        return jniReportOtherThread;
    }

    public static boolean debugMode() {
        ICrashLogController iCrashLogController = controler;
        return iCrashLogController != null && iCrashLogController.isDebug();
    }

    public static boolean isNeedForceDumpAllFdList() {
        ICrashLogController iCrashLogController = controler;
        return iCrashLogController != null && iCrashLogController.isNeedForceDumpAllFdList();
    }

    public static boolean isInited() {
        return controler != null;
    }

    public static Application getApplication() {
        return application;
    }

    public static boolean isNeedCertificateAuthority() {
        ICrashLogController iCrashLogController = controler;
        return iCrashLogController != null && iCrashLogController.isNeedCertificateAuthority();
    }

    public static String getCaCertsPath() {
        ICrashLogController iCrashLogController = controler;
        if (iCrashLogController == null) {
            return null;
        }
        return iCrashLogController.getCaCertsPath();
    }

    public static String getLocalCrashDir() {
        ICrashLogController iCrashLogController = controler;
        if (iCrashLogController == null) {
            return null;
        }
        String localCrashDir = iCrashLogController.getLocalCrashDir();
        LogUtil.log(1, "getLocalCrashDir filePath = " + localCrashDir);
        if (TextUtils.isEmpty(localCrashDir)) {
            return null;
        }
        File file = new File(localCrashDir);
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
                file.mkdir();
            }
        } else {
            file.mkdirs();
        }
        return localCrashDir;
    }

    public static void setTag(String str) {
        Tag = str;
    }

    public static String getDic() {
        if (!TextUtils.isEmpty(dic)) {
            return dic;
        }
        try {
            return controler.getDic();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppVersion() {
        if (!TextUtils.isEmpty(appVersion)) {
            return appVersion;
        }
        try {
            return controler.getVersionName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDiu() {
        if (!TextUtils.isEmpty(diu)) {
            return diu;
        }
        try {
            return controler.getDiu();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDiu2() {
        if (!TextUtils.isEmpty(diu2)) {
            return diu2;
        }
        try {
            return controler.getDiu2();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDiu3() {
        if (!TextUtils.isEmpty(diu3)) {
            return diu3;
        }
        try {
            return controler.getDiu3();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAdiu() {
        if (!TextUtils.isEmpty(adiu)) {
            return adiu;
        }
        try {
            return controler.getAdiu();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSession() {
        if (!TextUtils.isEmpty(session)) {
            return session;
        }
        try {
            return controler.getSession();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getTid() {
        if (!TextUtils.isEmpty(tid)) {
            return tid;
        }
        try {
            return controler.getTaobaoID();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDiv() {
        if (!TextUtils.isEmpty(div)) {
            return div;
        }
        try {
            return controler.getDiv();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDibv() {
        if (!TextUtils.isEmpty(dibv)) {
            return dibv;
        }
        try {
            return controler.getDibv();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getLogSpyId() {
        if (!TextUtils.isEmpty(logSpyId)) {
            return logSpyId;
        }
        try {
            return controler.getLogSpyId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getFeatureCode() {
        try {
            return controler.getFeatureCode();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getManufacture() {
        try {
            return controler.getManufacture();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getModel() {
        try {
            return controler.getModel();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getCpu() {
        try {
            return controler.getCpu();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getMemorySize() {
        try {
            return controler.getMemorySize();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getResolution() {
        try {
            return controler.getResolution();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getBuildPlatform() {
        try {
            return controler.getBuildPlatform();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static long getAnrCost() {
        return anrCost;
    }

    public static boolean needCrashModeCheck() {
        return isNeedCrashModeCheck;
    }

    public static int crashCountForCrashMode() {
        return crashCountForCrashMode;
    }

    public static int crashTimeForCrashMode() {
        return crashTimeForCrashMode;
    }

    public static void uploadCrash(boolean z) {
        if (z) {
            UploadFileManager.getInstance(null).uploadAllCrash();
        } else {
            UploadFileManager.getInstance(null).uploadSingleCrash();
        }
    }

    static File getErrorSoUploadDir() {
        return getControler().getErrorSoUploadDir();
    }

    public static void uninstall() {
        dumpcrash.uninstall();
    }

    public static void addCustomData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CrashLogRecorder.mCustomData.add(str);
    }

    public static boolean needTamperCrashFix(Context context) {
        return CrashFileManager.getInstance().hasSoCorrupt(context);
    }

    public static void removeTamperCrashFixFlag(Context context) {
        CrashFileManager.getInstance().removeSoCorruptFlag(context);
    }

    public static void doTramperCrashFix(SoCollector.TamperLibraryCallBack tamperLibraryCallBack, Context context, long j, String str) {
        SoCollector.dumpInApkLibs(tamperLibraryCallBack, context, j, str);
    }

    public static void doTramperCrashFix(SoCollector.TamperLibraryCallBack tamperLibraryCallBack, Context context, long j) {
        SoCollector.dumpInApkLibs(tamperLibraryCallBack, context, j);
    }

    public static void addSoCollectExceptDir(String str) {
        SoCollector.exceptLibPath.add(str);
    }

    public static boolean checkSign(Context context) {
        return Sign.checkSign(context);
    }

    public static String getTamerFixLibPath(Context context) {
        return SoCollector.getLibPath(context);
    }

    public static void addTamperCrashCollection(int i, int i2, int i3, Application application2) {
        CrashFileManager.getInstance().addTamperCrashCollection(i, i2, i3, application2);
    }

    public static List<TamperCrashCollectionModel> getTamperCrashCollections(Application application2) {
        return CrashFileManager.getInstance().getTamperCrashCollections(application2);
    }

    public static void removeAllTamperCrashCollections(Application application2) {
        CrashFileManager.getInstance().removeAllTamperCrashCollections(application2);
    }

    public static List<NormalCrashCollectionModel> getNormalCrashCollections() {
        return CrashFileManager.getInstance().getNormalCrashCollections();
    }

    public static void removeAllNormalCrashCollections() {
        CrashFileManager.getInstance().removeAllNormalCrashCollections();
    }

    public static void testNativeCrash() {
        dumpcrash.testNativeCrash();
    }

    public static void removeLastCrashTime(Context context) {
        CrashFileManager.getInstance().removeLastCrashTime(context);
    }

    public static boolean needEnterCrashMode(Context context) {
        return CrashFileManager.getInstance().needEnterCrashMode(context);
    }

    public static boolean clearApplicationData(Context context, boolean z, boolean z2, File... fileArr) {
        return SystemUtils.clearApplicationData(context, z, z2, fileArr);
    }
}
