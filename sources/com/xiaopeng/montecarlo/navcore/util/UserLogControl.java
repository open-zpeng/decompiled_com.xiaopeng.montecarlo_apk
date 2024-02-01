package com.xiaopeng.montecarlo.navcore.util;

import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.servicemanager.model.ALCLogLevel;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.util.RemoteLogSwitchMqttCmd;
import com.xiaopeng.montecarlo.navcore.bean.util.RemoteLogSwitchMqttResponse;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.DebugProperties;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogFileManager;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public enum UserLogControl {
    INSTANCE;
    
    private static final String APP_ID = "xmart:appid:002";
    private static final String FILE_LIST = "filelist.txt";
    private static final String MQTT_RESPONSE_ERROR_EMPTY_BUNDLE = "empty bundle";
    private static final String MQTT_RESPONSE_ERROR_NO_ERROR = "no error";
    private static final String MQTT_RESPONSE_ERROR_REQUEST_PARAM = "param error";
    private static final String MQTT_RESPONSE_UNSUPPORT_CMD = "unsupported cmd";
    private static final String SWITCH_CHECK = "check";
    private static final String SWITCH_OFF = "off";
    private static final String SWITCH_ON = "on";
    private IIpcService mService;
    private static final L.Tag TAG = new L.Tag("UserLogControl");
    private static final long ENG_VERSION_LOG_LEVEL = ALCLogLevel.LogLevelVerbose;
    private static final long USR_VERSION_LOG_LEVEL = ALCLogLevel.LogLevelNone;
    private static final long USR_DEBUG_VERSION_LOG_LEVEL = ALCLogLevel.LogLevelDebug;
    private static final ArrayList<String> REMOTE_LOG_FOLDERS = new ArrayList<String>() { // from class: com.xiaopeng.montecarlo.navcore.util.UserLogControl.1
        {
            add(RootUtil.getBLLogLogPath());
            add(RootUtil.getLocLogPath());
            add(RootUtil.LAN_DIR_LOC_LOG);
            add(RootUtil.DIR_BL_LOG_NETWORK_LOG);
            add(RootUtil.DIR_BL_LOG_EHPCLOUD_LOG);
            add(RootUtil.DIR_BL_LOG_EHPEXPORT_LOG);
            add(RootUtil.DIR_BL_LOG_EHPIFC_LOG);
            add(RootUtil.DIR_BL_LOG_EHPTRACE_LOG);
            add(RootUtil.DIR_LOGCAT_LOG);
        }
    };
    private boolean mNeedRebootClearLog = false;
    private ArrayList<LogFileObserver> mFileAttributeObserver = new ArrayList<>();

    UserLogControl() {
    }

    public static void resetBLLogAndLoc() {
        long bLLogLevel = getBLLogLevel();
        ServiceMgr.getServiceMgrInstance().switchLog(bLLogLevel);
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_LOC_LOG);
        L.i(TAG, "bllog level:" + bLLogLevel + z + RootUtil.canBllogAndLocBeOutput());
        boolean z2 = true;
        TBTManager.getInstance().setSignalRecordSwitch(z && RootUtil.canBllogAndLocBeOutput());
        SRNaviManager sRNaviManager = SRNaviManager.getInstance();
        if (!z || !RootUtil.canBllogAndLocBeOutput()) {
            z2 = false;
        }
        sRNaviManager.setSignalRecordSwitch(z2);
    }

    public static long getBLLogLevel() {
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_BL_LOG);
        long j = SystemProperties.get(DebugProperties.KEY_BLLOG_LEVEL, "debug").equals(DebugProperties.VALUE_BLLOG_LEVEL_VERBOSE) ? ENG_VERSION_LOG_LEVEL : USR_DEBUG_VERSION_LOG_LEVEL;
        if (!z || !RootUtil.canBllogAndLocBeOutput()) {
            j = USR_VERSION_LOG_LEVEL;
        }
        L.Tag tag = TAG;
        L.i(tag, " bl log level:" + j);
        return j;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onReceiveMqttCmd(IIpcService.IpcMessageEvent ipcMessageEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onReceiveMqttCmd:" + ipcMessageEvent);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onReceiveMqttCmd(IpcRouterUtil.IpcRouterEvent ipcRouterEvent) {
        L.Tag tag = TAG;
        L.i(tag, "onReceiveMqttCmd:" + ipcRouterEvent);
    }

    private void handleMqttCmdEvent(int i, String str, Bundle bundle) {
        RemoteLogSwitchMqttCmd remoteLogSwitchMqttCmd;
        if (TextUtils.isEmpty(str)) {
            L.w(TAG, "SenderPackageName is empty");
        } else if (bundle != null && str.equals(IpcConfig.App.DEVICE_COMMUNICATION) && i == 6006) {
            String string = bundle.getString(IpcConfig.IPCKey.STRING_MSG);
            L.i(TAG, "rev:" + string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Map<String, Object> map = null;
            try {
                remoteLogSwitchMqttCmd = (RemoteLogSwitchMqttCmd) GsonUtil.fromJson(string, (Class<Object>) RemoteLogSwitchMqttCmd.class);
            } catch (Exception e) {
                L.w(TAG, e.getMessage());
                remoteLogSwitchMqttCmd = null;
            }
            if (remoteLogSwitchMqttCmd == null) {
                L.w(TAG, "null == cmd");
                return;
            }
            final String msgId = remoteLogSwitchMqttCmd.getMsgId();
            RemoteLogSwitchMqttCmd.MsgContent msgContent = remoteLogSwitchMqttCmd.getMsgContent();
            if (msgContent == null) {
                L.w(TAG, "null == msgContent");
                sendMqttResponse(msgId, MQTT_RESPONSE_ERROR_EMPTY_BUNDLE, false);
                return;
            }
            String naviLog = msgContent.getNaviLog();
            if (naviLog == null) {
                L.w(TAG, "null == naviLog");
                sendMqttResponse(msgId, MQTT_RESPONSE_ERROR_REQUEST_PARAM, false);
                return;
            }
            try {
                map = GsonUtil.fromJson2Map(naviLog);
            } catch (Exception e2) {
                L.w(TAG, e2.getMessage());
            }
            if (map == null) {
                L.w(TAG, "null == map");
                sendMqttResponse(msgId, MQTT_RESPONSE_ERROR_REQUEST_PARAM, false);
                return;
            }
            Object obj = map.get("cduSwitch");
            if (obj == null) {
                L.w(TAG, "null == cduSwitch");
                sendMqttResponse(msgId, MQTT_RESPONSE_ERROR_REQUEST_PARAM, false);
                return;
            }
            if (!obj.toString().equals("on") && !obj.toString().equals("off")) {
                if (obj.toString().equals(SWITCH_CHECK)) {
                    sendMqttResponse(msgId, RootUtil.isRemoteOpenLog() ? "on" : "off", true);
                    return;
                } else {
                    sendMqttResponse(msgId, MQTT_RESPONSE_UNSUPPORT_CMD, false);
                    return;
                }
            }
            final boolean equals = obj.toString().equals("on");
            L.i(TAG, "WorkThreadUtil.getInstance().executeCachedTask");
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.util.UserLogControl.2
                @Override // java.lang.Runnable
                public void run() {
                    UserLogControl.this.switchRemoteLog(msgId, equals);
                }
            });
        }
    }

    private synchronized void sendMqttResponse(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(new RemoteLogSwitchMqttResponse(str, "xmart:appid:002", RootUtil.isRemoteOpenLog(), z, str2)));
        L.i(TAG, bundle.toString());
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(6006, bundle, IpcConfig.App.DEVICE_COMMUNICATION);
        } else {
            IIpcService service = getService();
            if (service != null) {
                service.sendData(6006, bundle, IpcConfig.App.DEVICE_COMMUNICATION);
            }
        }
    }

    private IIpcService getService() {
        if (this.mService == null) {
            this.mService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        }
        return this.mService;
    }

    public void switchRemoteLog(String str, boolean z) {
        if (z != RootUtil.isRemoteOpenLog()) {
            if (z) {
                L.i(TAG, "remote open log ");
                if (2 == DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 0)) {
                    DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 0);
                }
                initFolders();
                startWatchingLogFile();
                this.mNeedRebootClearLog = false;
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_REMOTE_OPEN_LOG, true);
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, true);
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, true);
                LogHelper.getInstance().initNaviLogFolder();
                resetBLLogAndLoc();
            } else {
                L.i(TAG, "remote close log ");
                stopWatchingLogFile();
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_REMOTE_OPEN_LOG, false);
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, false);
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, false);
                resetBLLogAndLoc();
                LogHelper.getInstance();
                LogHelper.clearAllLog(true);
                this.mNeedRebootClearLog = true;
            }
        }
        sendMqttResponse(str, MQTT_RESPONSE_ERROR_NO_ERROR, true);
    }

    public void check131NaviLog() {
        WorkThreadUtil.getInstance().executeScheduledIoTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.util.UserLogControl.3
            @Override // java.lang.Runnable
            public void run() {
                boolean isEnableNaviEngineLog = SystemPropertyUtil.isEnableNaviEngineLog();
                boolean isOpenNaviLogIn131 = RootUtil.isOpenNaviLogIn131();
                if (isEnableNaviEngineLog != isOpenNaviLogIn131) {
                    L.Tag tag = UserLogControl.TAG;
                    L.i(tag, "navi_log from:" + isOpenNaviLogIn131 + " to " + isEnableNaviEngineLog);
                    DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_USER_DEBUG_VERSION, isEnableNaviEngineLog);
                    if (isEnableNaviEngineLog) {
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, true);
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, true);
                        LogHelper.getInstance().initNaviLogFolder();
                        UserLogControl.resetBLLogAndLoc();
                    } else {
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, false);
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, false);
                        if (!RootUtil.isUserVersion()) {
                            UserLogControl.resetBLLogAndLoc();
                        }
                    }
                    LogHelper.getInstance().switchUserVersionNaviLog(isEnableNaviEngineLog);
                }
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public void checkAndRebootNavi() {
        if (this.mNeedRebootClearLog) {
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_CLOSE_AMAP_LOG);
        }
    }

    public void checkAndReportLogStatus() {
        if (RootUtil.isRemoteOpenLog()) {
            String string = DataSetHelper.GlobalSet.getString(DataSetHelper.GlobalSet.CACHE_LAST_REPORT_OPEN_BL_TIME, "");
            String format = new SimpleDateFormat(TimeFormatUtil.DATE_PATTERN_FORMAT, Locale.US).format(Long.valueOf(System.currentTimeMillis()));
            L.Tag tag = TAG;
            L.i(tag, "report REMOTE_LOG_OPEN at " + format + string);
            if (string.equals(format)) {
                return;
            }
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_LAST_REPORT_OPEN_BL_TIME, format);
            AfterSalesUtil.getInstance().recordDiagnosisError(9006, Double.valueOf(LogFileManager.getFsAvailaleSize(RootUtil.DIR_BL_LOG) / 1.073741824E9d).toString());
        }
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            L.i(TAG, "registerEventBus");
            EventBus.getDefault().register(this);
        }
        initFolders();
        if (RootUtil.isRemoteOpenLog()) {
            startWatchingLogFile();
        }
    }

    private void startWatchingLogFile() {
        if (this.mFileAttributeObserver == null) {
            this.mFileAttributeObserver = new ArrayList<>();
        }
        if (this.mFileAttributeObserver.isEmpty()) {
            Iterator<String> it = REMOTE_LOG_FOLDERS.iterator();
            while (it.hasNext()) {
                this.mFileAttributeObserver.add(new LogFileObserver(it.next()));
            }
        }
        Iterator<LogFileObserver> it2 = this.mFileAttributeObserver.iterator();
        while (it2.hasNext()) {
            it2.next().startWatching();
        }
        L.i(TAG, "startWatchingLogFile");
    }

    private void stopWatchingLogFile() {
        if (CollectionUtils.isNotEmpty(this.mFileAttributeObserver)) {
            Iterator<LogFileObserver> it = this.mFileAttributeObserver.iterator();
            while (it.hasNext()) {
                it.next().stopWatching();
            }
            L.i(TAG, "stopWatching");
        }
    }

    private void initFolders() {
        Iterator<String> it = REMOTE_LOG_FOLDERS.iterator();
        while (it.hasNext()) {
            String next = it.next();
            File file = new File(next);
            if (file.mkdirs()) {
                FileUtil.setFilePermissionRecursion(file);
            } else {
                if (file.exists()) {
                    L.w(TAG, "already exist");
                    FileUtil.setFilePermissionRecursion(file);
                }
                L.Tag tag = TAG;
                L.w(tag, "mkdirs false:" + next);
            }
        }
    }

    public void outputFileList(String str) {
        BufferedWriter bufferedWriter;
        File file = new File(RootUtil.DIR_LOGCAT_LOG);
        if (!file.exists()) {
            FileUtil.setFilePermissionRecursion(file);
        }
        File file2 = new File(RootUtil.DIR_LOGCAT_LOG + File.separatorChar + FILE_LIST);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(str + FDManager.LINE_SEPERATOR);
                bufferedWriter.close();
            } catch (Exception e2) {
                e = e2;
                bufferedWriter2 = bufferedWriter;
                e.printStackTrace();
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e3) {
                        L.w(TAG, e3.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            L.w(TAG, e4.getMessage());
        }
    }
}
