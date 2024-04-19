package com.autonavi.gbl.util.exception;

import android.app.Application;
import com.autonavi.auto.intfauto.BindInfo;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.common.tool.ICrashLogController;
import com.autonavi.common.tool.dumpcrash;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.observer.IPlatformInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ExceptionDumpDataControler implements ICrashLogController {
    private static final String TAG = "[ExceptionDumpDataControler]";
    private static String mLogPath = "";
    private static String mRestKey = "";
    private static String mRestSecurityCode = "";
    private static int mServerType;
    private Application mApp;
    private IPlatformInterface mPlatformInterface = null;

    @Override // com.autonavi.common.tool.ICrashLogController
    public int crashCountForCrashMode() {
        return 2;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int crashTimeForCrashMode() {
        return 1;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public List<Class<?>> getAppLunchActivitys() {
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isMainProcess() {
        return true;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean needCrashModeCheck() {
        return false;
    }

    public ExceptionDumpDataControler(Application application) {
        this.mApp = null;
        this.mApp = application;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public Application getApplication() {
        LogUtils.d("[ExceptionDumpDataControler]getApplication");
        return this.mApp;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isDebug() {
        boolean z;
        String versionName = getVersionName();
        if (versionName.length() != 0) {
            String[] split = versionName.split("\\.");
            if (split.length == 5 && split[3].equals("0")) {
                z = false;
                LogUtils.d(TAG + String.format("isDebug=%b", Boolean.valueOf(z)));
                return z;
            }
        }
        z = true;
        LogUtils.d(TAG + String.format("isDebug=%b", Boolean.valueOf(z)));
        return z;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isInternetConnected() {
        IPlatformInterface hmiPlatformInterface = getHmiPlatformInterface();
        int netStatus = hmiPlatformInterface != null ? hmiPlatformInterface.getNetStatus() : Integer.MIN_VALUE;
        LogUtils.d(TAG + String.format("status=%d", Integer.valueOf(netStatus)));
        return netStatus > 1;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getOperatorName() {
        String param = getParam("operator");
        LogUtils.d(TAG + String.format("operatorName=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getCheckNetWork() {
        IPlatformInterface hmiPlatformInterface = getHmiPlatformInterface();
        int netStatus = hmiPlatformInterface != null ? hmiPlatformInterface.getNetStatus() : Integer.MIN_VALUE;
        LogUtils.d(TAG + String.format("network status=%d", Integer.valueOf(netStatus)));
        return netStatus;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getTaobaoID() {
        LogUtils.d("[ExceptionDumpDataControler]getTaobaoID");
        String param = getParam("tid");
        LogUtils.d(TAG + String.format("tid=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDic() {
        String exceptionData = ExceptionUtil.getExceptionData("dic");
        LogUtils.d(TAG + String.format("dic=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDiu() {
        String param = getParam("diu");
        LogUtils.d(TAG + String.format("diu=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDiu2() {
        String param = getParam("diu2");
        LogUtils.d(TAG + String.format("diu2=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDiu3() {
        String param = getParam("diu3");
        LogUtils.d(TAG + String.format("diu3=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getAdiu() {
        String param = getParam("adiu");
        LogUtils.d(TAG + String.format("adiu=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getSession() {
        String exceptionData = ExceptionUtil.getExceptionData("session_id");
        LogUtils.d(TAG + String.format("session=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDip() {
        return ExceptionUtil.getExceptionData("dip");
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getVersionCode() {
        LogUtils.d(TAG + String.format("versionCode=%d", 1));
        return 1;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getVersionName() {
        ServiceMgr.getServiceMgrInstance();
        String version = ServiceMgr.getVersion();
        if (version.startsWith("android.")) {
            version = version.substring(8);
        }
        LogUtils.d(TAG + String.format("versionName=%s", version));
        return version;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getLibSoPath() {
        String str = this.mApp.getApplicationInfo().nativeLibraryDir + File.separator;
        LogUtils.d(TAG + String.format("soPath=%s", str));
        return str;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getCurrentCity() {
        LogUtils.d(TAG + String.format("adcode=%s", 0));
        return 0;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getInternalStoragePath() {
        String autoLogRootPath = getAutoLogRootPath();
        LogUtils.d(TAG + String.format("internalStoragePath=%s", autoLogRootPath));
        return autoLogRootPath;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getExternalStoragePath() {
        LogUtils.d(TAG + String.format("externalStoragePath=%s", ""));
        return "";
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getAbi() {
        LogUtils.d(TAG + String.format("abi=%s", ""));
        return "";
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDiv() {
        String exceptionData = ExceptionUtil.getExceptionData("adiv");
        LogUtils.d(TAG + String.format("div=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getDibv() {
        String exceptionData = ExceptionUtil.getExceptionData("dibv");
        LogUtils.d(TAG + String.format("dibv=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getLogSpyId() {
        LogUtils.d(TAG + String.format("logSpyId=%s", ""));
        return "";
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getFeatureCode() {
        String param = getParam("featurecode");
        LogUtils.d(TAG + String.format("featurecode=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getManufacture() {
        String param = getParam("manufacture");
        LogUtils.d(TAG + String.format("manufacture=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getModel() {
        String param = getParam("model");
        LogUtils.d(TAG + String.format("model=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getCpu() {
        String param = getParam("cpu");
        LogUtils.d(TAG + String.format("cpu=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getMemorySize() {
        String param = getParam("memory");
        LogUtils.d(TAG + String.format("memory=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getResolution() {
        String param = getParam("resolution");
        LogUtils.d(TAG + String.format("resolution=%s", param));
        return param;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getBuildPlatform() {
        String exceptionData = ExceptionUtil.getExceptionData("platform");
        LogUtils.d(TAG + String.format("platform=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public Map<String, String> getCrashExtraInfo() {
        LogUtils.d(TAG + String.format("getCrashExtraInfo=%s", "null"));
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getNormalCrashExtraInfo() {
        LogUtils.d(TAG + String.format("getNormalCrashExtraInfo=%s", "null"));
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getHeapErrorExtraInfo() {
        LogUtils.d(TAG + String.format("getHeapErrorExtraInfo=%s", "null"));
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getBackgroundCrashLimitCount() {
        LogUtils.d(TAG + String.format("backgroundCrashLimitCount=%d", 30));
        return 30;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getForegroundCrashLimitCount() {
        LogUtils.d(TAG + String.format("foregroundCrashLimitCount=%d", 30));
        return 30;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getTamperCrashLimitCount() {
        LogUtils.d(TAG + String.format("tamperCrashLimitCount=%d", 10));
        return 10;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getAnrRecordLimitCount() {
        LogUtils.d(TAG + String.format("anrRecordLimitCount=%d", 5));
        return 5;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getAnrRecordProcessLimitCount() {
        LogUtils.d(TAG + String.format("anrRecordProcessLimitCount=%d", 2));
        return 2;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getLocalCrashRecordLimitCount() {
        LogUtils.d(TAG + String.format("localCrashRecordLimitCount=%d", 100));
        return 100;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isForceDumpHeap() {
        LogUtils.d(TAG + String.format("isForceDumpHeap=%b", false));
        return false;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public File getDumpHprofDataFile() {
        LogUtils.d("[ExceptionDumpDataControler]dumpHprofDataFile=null");
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isNeedForceDumpAllFdList() {
        LogUtils.d("[ExceptionDumpDataControler]isNeedForceDumpAllFdList=true");
        return true;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public File getUploadCrashDir() {
        File file = new File(getAutoLogRootPath(), "uploadcrash");
        if (!file.exists()) {
            file.mkdirs();
        }
        LogUtils.d(TAG + String.format("uploadCrashDir=%s", file.getAbsolutePath()));
        return file;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isNeedLocalRecord() {
        LogUtils.d("[ExceptionDumpDataControler]isNeedLocalRecord=true");
        return true;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getLocalCrashDir() {
        File file = new File(getAutoLogRootPath(), dumpcrash.LIB_DUMPCRASH);
        if (!file.exists()) {
            file.mkdirs();
        }
        LogUtils.d(TAG + String.format("localCrashDir=%s", file.getAbsolutePath()));
        return file.getAbsolutePath();
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public File getErrorSoUploadDir() {
        File file = new File(getLocalCrashDir(), "uploadsoerr");
        if (!file.exists()) {
            file.mkdirs();
        }
        LogUtils.d(TAG + String.format("errorSoUploadDir=%s", file.getAbsolutePath()));
        return file;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public File getExtraErrorLogFile() {
        LogUtils.d("[ExceptionDumpDataControler]getExtraErrorLogFile=null");
        return null;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public void onDumpStart() {
        ServiceMgr.logStop();
        LogUtils.d("[ExceptionDumpDataControler]onDumpStart enter");
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean onDumpStartEx(Thread thread, Throwable th, String str) {
        LogUtils.d("[ExceptionDumpDataControler]onDumpStartEx enter");
        return true;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public void onDumpEnd() {
        LogUtils.d("[ExceptionDumpDataControler]onDumpEnd enter");
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public void onUploadStart() {
        LogUtils.d("[ExceptionDumpDataControler]onUploadStart enter");
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public void onUploadFinish(boolean z) {
        LogUtils.d("[ExceptionDumpDataControler]onUploadFinish enter");
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean isNeedCertificateAuthority() {
        LogUtils.d("[ExceptionDumpDataControler]isNeedCertificateAuthority=false");
        return false;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getCaCertsPath() {
        LogUtils.d(TAG + String.format("CaCertsPath=%s", ""));
        return "";
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public boolean useRestUploadInterface() {
        LogUtils.d("[ExceptionDumpDataControler]useRestUploadInterface=true");
        return true;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getUploadUrl(File file) {
        LogUtils.d(TAG + String.format("uploadUrl=%s", ""));
        return "";
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getRestUploadUrl() {
        LogUtils.d("[ExceptionDumpDataControler]getRestUploadUrl");
        String str = (1 == mServerType ? "https://itest-autoapi.testing.amap.com:443" : "https://autoapi.amap.com:443") + "/ws/page/upload";
        LogUtils.d(TAG + String.format("uploadUrl=%s", str));
        return str;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public int getUploadParamProduct() {
        LogUtils.d(TAG + String.format("uploadParamProduct=%d", 12));
        return 12;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getUploadParamSecurityCode() {
        String exceptionData;
        if (1 == mServerType) {
            exceptionData = ExceptionUtil.getExceptionData("code_test");
        } else {
            exceptionData = ExceptionUtil.getExceptionData("code_public");
        }
        LogUtils.d(TAG + String.format("restSecurityCode=%s", exceptionData));
        return exceptionData;
    }

    @Override // com.autonavi.common.tool.ICrashLogController
    public String getUploadParamKey() {
        String exceptionData;
        if (1 == mServerType) {
            exceptionData = ExceptionUtil.getExceptionData("key_test");
        } else {
            exceptionData = ExceptionUtil.getExceptionData("key_public");
        }
        LogUtils.d(TAG + String.format("restKey=%s", exceptionData));
        return exceptionData;
    }

    private String getAutoLogRootPath() {
        File file = new File(mLogPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            LogUtils.d("[ExceptionDumpDataControler]getCrashBasePath: isMkDir = " + mkdirs);
        }
        return file.getAbsolutePath();
    }

    private IPlatformInterface getHmiPlatformInterface() {
        BindTable bindTable = TypeUtil.getBindTable(TypeUtil.getIntfAutoTarget(IPlatformInterface.class));
        if (bindTable != null) {
            for (BindInfo bindInfo : bindTable.getByTarget("BaseInitParam_")) {
                if (bindInfo.getJType().getType().equals(IPlatformInterface.class)) {
                    return (IPlatformInterface) bindInfo.getJTypeInst();
                }
            }
        }
        return null;
    }

    private String getParam(String str) {
        IPlatformInterface hmiPlatformInterface = getHmiPlatformInterface();
        if (hmiPlatformInterface != null) {
            ArrayList<KeyValue> arrayList = new ArrayList<>();
            hmiPlatformInterface.getAosNetworkParam(arrayList);
            Iterator<KeyValue> it = arrayList.iterator();
            while (it.hasNext()) {
                KeyValue next = it.next();
                if (next.key.equals(str)) {
                    return next.value;
                }
            }
        }
        return "";
    }

    public static void setExceptionParam(int i, String str) {
        mServerType = i;
        mLogPath = str;
    }
}
