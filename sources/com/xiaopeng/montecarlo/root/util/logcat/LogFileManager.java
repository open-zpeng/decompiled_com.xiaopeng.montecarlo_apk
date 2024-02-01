package com.xiaopeng.montecarlo.root.util.logcat;

import android.os.StatFs;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogFileStatus;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes3.dex */
public class LogFileManager implements ILogFileOperationCallback {
    private static final String FILE_SUFFIX_SKG = ".skg";
    private static final L.Tag TAG = new L.Tag("LogFileManager");
    private static final String USB_LOG_FOLDER = "navi_log_";
    private volatile boolean mIsCopying = false;
    private ILogFileOperationCallback mUiListener = null;
    private ILogFileOperationCallback mZipListener = this;
    private long mLogFilesSize = 0;

    public void initNaviLogFolder() {
        FileUtil.createFileDir(RootUtil.getLogPath());
        String bLLogRootPath = RootUtil.getBLLogRootPath();
        if (!FileUtil.existFile(bLLogRootPath)) {
            FileUtil.createFileDir(bLLogRootPath);
            if (bLLogRootPath.startsWith(RootUtil.MNT_VMAP)) {
                String[] split = bLLogRootPath.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                StringBuilder sb = new StringBuilder();
                for (String str : split) {
                    sb.append(str);
                    sb.append(File.separator);
                    if (!RootUtil.MNT_VMAP.contains(str)) {
                        FileUtil.setFileWith755Permission(new File(sb.toString()));
                    }
                }
            }
            FileUtil.createFileWithByte(RootUtil.getBLLogRootPath(), "gnet_stat_a.txt", new byte[]{0});
        }
        FileUtil.createFileDir(RootUtil.getLocLogPath());
        L.i(TAG, "createNaviLogFolder : " + RootUtil.getBLLogRootPath());
    }

    public static long getTotalSpaceSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return new StatFs(str).getTotalBytes();
        } catch (Exception e) {
            L.e(TAG, e.toString());
            return 0L;
        }
    }

    public static long getFsAvailaleSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (Exception e) {
            L.e(TAG, e.toString());
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishCopy() {
        this.mIsCopying = false;
        this.mUiListener = null;
    }

    public boolean copyLogToUsb(final String str, final String str2, ILogFileOperationCallback iLogFileOperationCallback) {
        this.mUiListener = iLogFileOperationCallback;
        if (this.mIsCopying) {
            L.i(TAG, "already under copy process");
            this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_START, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR, this.mLogFilesSize, "");
            return false;
        }
        L.i(TAG, "copy log start executeIOTask");
        this.mIsCopying = true;
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogFileManager.1
            @Override // java.lang.Runnable
            public void run() {
                L.i(LogFileManager.TAG, "executeIOTask start check usb" + str);
                if (TextUtils.isEmpty(str)) {
                    if (LogFileManager.this.mUiListener != null) {
                        LogFileManager.this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_DONE, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_USB, 0L, "");
                    }
                    LogFileManager.this.finishCopy();
                    return;
                }
                if (LogFileManager.this.mUiListener != null) {
                    LogFileManager.this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_PREPARE, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR, 0L, "");
                }
                L.i(LogFileManager.TAG, "start calculate space");
                String vin = RootUtil.getVin();
                StringBuilder sb = new StringBuilder();
                boolean isEmpty = TextUtils.isEmpty(vin);
                String str3 = LogFileManager.USB_LOG_FOLDER;
                if (!isEmpty) {
                    str3 = vin + '_' + LogFileManager.USB_LOG_FOLDER;
                }
                sb.append(str3);
                sb.append(str2);
                String sb2 = sb.toString();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_BLLOG_NAME, RootUtil.DIR_BL_LOG, false));
                arrayList.add(new LogDir("log", RootUtil.DIR_BL_LOG_LOG, false));
                arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_SKG_NAME, RootUtil.DIR_LOC_LOG, false));
                arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_CKR_NAME, RootUtil.DIR_LOC_LANE_LOG, true));
                arrayList.add(new LogDir("network", RootUtil.DIR_BL_LOG_NETWORK_LOG, false));
                if (DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_XP_LOG)) {
                    L.i(LogFileManager.TAG, "CopyXPlog:" + RootUtil.DIR_LOGCAT_LOG);
                    arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_XPLOG_NAME, RootUtil.DIR_LOGCAT_LOG, false));
                }
                if (DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_BL_LOG)) {
                    L.i(LogFileManager.TAG, "Copyehp:" + RootUtil.DIR_BL_LOG_EHPCLOUD_LOG);
                    arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_BLLOG_EHPCLOUD_NAME, RootUtil.DIR_BL_LOG_EHPCLOUD_LOG, false));
                    L.i(LogFileManager.TAG, "Copyehp:" + RootUtil.DIR_BL_LOG_IPC_LOG);
                    arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_BLLOG_IPC_NAME, RootUtil.DIR_BL_LOG_IPC_LOG, false));
                    L.i(LogFileManager.TAG, "Copyehp:" + RootUtil.DIR_BL_LOG_EHPEXPORT_LOG);
                    arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_BLLOG_EHPEXPORT_NAME, RootUtil.DIR_BL_LOG_EHPEXPORT_LOG, false));
                    L.i(LogFileManager.TAG, "Copyehp:" + RootUtil.DIR_BL_LOG_EHPIFC_LOG);
                    arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_BLLOG_EHPIFC_NAME, RootUtil.DIR_BL_LOG_EHPIFC_LOG, false));
                }
                L.i(LogFileManager.TAG, "CopyProtoBuffer:" + RootUtil.DIR_PROTO_DATA_LOG);
                arrayList.add(new LogDir(RootUtil.NAVI_LOG_DIR_PROT_NAME, RootUtil.DIR_PROTO_DATA_LOG, false));
                File filesDir = ContextUtils.getContext().getFilesDir();
                arrayList.add(new LogDir("database", filesDir.getParent() + File.separator + "databases", false));
                arrayList.add(new LogDir("gnetstats", RootUtil.DIR_BL_LOG_GNET_STATS_LOG, true));
                arrayList.add(new LogDir("sdcardmontecarlo", RootUtil.SD_CARD_NAVI_PATH, true));
                LogFileManager.this.mLogFilesSize = 0L;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    LogDir logDir = (LogDir) it.next();
                    long dirSize = FileUtil.getDirSize(new File(logDir.getAbsSourcePath()), logDir.isNeedRecursive());
                    LogFileManager.this.mLogFilesSize += dirSize;
                    L.i(LogFileManager.TAG, logDir.getAbsSourcePath() + " size:" + dirSize + ", Recursive:" + logDir.isNeedRecursive());
                }
                long fsAvailaleSize = LogFileManager.getFsAvailaleSize(str);
                L.i(LogFileManager.TAG, "need size:" + LogFileManager.this.mLogFilesSize + " usbAvailableSize size:" + fsAvailaleSize);
                if (LogFileManager.this.mLogFilesSize > fsAvailaleSize) {
                    if (LogFileManager.this.mUiListener != null) {
                        LogFileManager.this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_DONE, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ENOUGH_SPACE, LogFileManager.this.mLogFilesSize - fsAvailaleSize, "");
                    }
                    LogFileManager.this.finishCopy();
                    L.i(LogFileManager.TAG, "no enough usb space");
                    return;
                }
                if (LogFileManager.this.mUiListener != null) {
                    LogFileManager.this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_START, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR, LogFileManager.this.mLogFilesSize, "");
                }
                boolean zipFolders2SingleFile = ZipUtil.zipFolders2SingleFile(arrayList, str + File.separator, sb2, LogFileManager.this.mZipListener);
                if (LogFileManager.this.mUiListener != null) {
                    LogFileManager.this.mUiListener.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_DONE, zipFolders2SingleFile ? LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR : LogFileStatus.CopyLogFileErrCode.LOG_FILE_COPY_FAILED, 0L, "");
                }
                LogFileManager.this.finishCopy();
            }
        });
        return true;
    }

    private String convertTargetFileName(File file) {
        String name = file.getName();
        if (file.getName().endsWith(FILE_SUFFIX_SKG)) {
            String[] split = name.split("\\.");
            if (2 == split.length) {
                String str = split[0];
                try {
                    long longValue = Long.valueOf(str).longValue();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss", Locale.getDefault());
                    return simpleDateFormat.format(new Date(longValue / 1000)) + FILE_SUFFIX_SKG;
                } catch (NumberFormatException unused) {
                    L.Tag tag = TAG;
                    L.w(tag, "conver error:" + str);
                }
            }
        }
        return name;
    }

    private LogFileStatus.CopyLogFileErrCode zipAndCopyFile(File file, String str) {
        boolean z = !ZipUtil.isZipFile(file);
        LogFileStatus.CopyLogFileErrCode copyLogFileErrCode = LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR;
        if (z) {
            if (ZipUtil.zipFile(file, str, file.getName())) {
                L.i(TAG, "zip&copy " + file.getName() + " succeed");
                return copyLogFileErrCode;
            }
            L.w(TAG, "zip&copy " + file.getName() + " failed");
            return LogFileStatus.CopyLogFileErrCode.LOG_FILE_ZIP_FAILED;
        }
        String convertTargetFileName = convertTargetFileName(file);
        if (FileUtil.copyFile(file.getParent(), str, file.getName(), convertTargetFileName)) {
            L.i(TAG, "copy " + convertTargetFileName + " succeed");
            return copyLogFileErrCode;
        }
        L.w(TAG, "copy " + convertTargetFileName + " failed");
        return LogFileStatus.CopyLogFileErrCode.LOG_FILE_COPY_FAILED;
    }

    @Override // com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback
    public void onStatusChange(LogFileStatus.CopyLogFileStatus copyLogFileStatus, LogFileStatus.CopyLogFileErrCode copyLogFileErrCode, long j, String str) {
        ILogFileOperationCallback iLogFileOperationCallback = this.mUiListener;
        if (iLogFileOperationCallback != null) {
            iLogFileOperationCallback.onStatusChange(copyLogFileStatus, copyLogFileErrCode, j, str);
        }
    }
}
