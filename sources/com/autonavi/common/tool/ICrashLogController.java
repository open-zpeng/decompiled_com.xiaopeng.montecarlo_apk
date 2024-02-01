package com.autonavi.common.tool;

import android.app.Application;
import java.io.File;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface ICrashLogController {
    int crashCountForCrashMode();

    int crashTimeForCrashMode();

    String getAbi();

    String getAdiu();

    int getAnrRecordLimitCount();

    int getAnrRecordProcessLimitCount();

    List<Class<?>> getAppLunchActivitys();

    Application getApplication();

    int getBackgroundCrashLimitCount();

    String getBuildPlatform();

    String getCaCertsPath();

    int getCheckNetWork();

    String getCpu();

    Map<String, String> getCrashExtraInfo();

    int getCurrentCity();

    String getDibv();

    String getDic();

    String getDip();

    String getDiu();

    String getDiu2();

    String getDiu3();

    String getDiv();

    File getDumpHprofDataFile();

    File getErrorSoUploadDir();

    String getExternalStoragePath();

    File getExtraErrorLogFile();

    String getFeatureCode();

    int getForegroundCrashLimitCount();

    String getHeapErrorExtraInfo();

    String getInternalStoragePath();

    String getLibSoPath();

    String getLocalCrashDir();

    int getLocalCrashRecordLimitCount();

    String getLogSpyId();

    String getManufacture();

    String getMemorySize();

    String getModel();

    String getNormalCrashExtraInfo();

    String getOperatorName();

    String getResolution();

    String getRestUploadUrl();

    String getSession();

    int getTamperCrashLimitCount();

    String getTaobaoID();

    File getUploadCrashDir();

    String getUploadParamKey();

    int getUploadParamProduct();

    String getUploadParamSecurityCode();

    String getUploadUrl(File file);

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isForceDumpHeap();

    boolean isInternetConnected();

    boolean isMainProcess();

    boolean isNeedCertificateAuthority();

    boolean isNeedForceDumpAllFdList();

    boolean isNeedLocalRecord();

    boolean needCrashModeCheck();

    void onDumpEnd();

    void onDumpStart();

    boolean onDumpStartEx(Thread thread, Throwable th, String str);

    void onUploadFinish(boolean z);

    void onUploadStart();

    boolean useRestUploadInterface();
}
