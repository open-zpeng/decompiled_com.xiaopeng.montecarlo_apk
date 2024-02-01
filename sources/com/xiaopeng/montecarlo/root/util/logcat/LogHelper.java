package com.xiaopeng.montecarlo.root.util.logcat;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.root.R;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.storage.IUsbStorageListener;
import com.xiaopeng.montecarlo.root.util.storage.USBUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes3.dex */
public class LogHelper {
    private static final int CHECK_LOG_INTERVAL_SECONDS = 180;
    private static final int CHECK_LOG_SIZE_SECONDS = 1;
    private static final long LOGCAT_FILE_SIZE = 20971520;
    private static final long LOGCAT_FILE_TOTAL_SIZE = 4294967296L;
    private static final String LOG_FILE_EXTENSION = ".log";
    private static final float LOG_OUTPUT_SAFETY_RATE = 0.05f;
    private static volatile SimpleDateFormat sTimeFormat;
    private ScheduledFuture<?> mCheckLogFileSizeScheduledFuture;
    private String mCurrentLogPath;
    private static final L.Tag TAG = new L.Tag("LogHelper");
    private static final LogHelper sInstance = new LogHelper();
    private static final String[] IGNORE_TAGS = {"alc_android_appender", "libBugHunter"};
    private Process mLogProcess = null;
    private boolean mIsClearLogIdle = true;
    private USBUtil mUSBUtil = new USBUtil();
    private final LogFileManager mLogFileManager = new LogFileManager();

    private String convertLogLevel(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "S" : ICarService.CAR_STAGE_E : "W" : "I" : ICarService.CAR_STAGE_D : "V";
    }

    private LogHelper() {
    }

    public static LogHelper getInstance() {
        return sInstance;
    }

    public static boolean isLogPathChanged(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.equals(str2)) ? false : true;
    }

    public void addUsbStorageListener(IUsbStorageListener iUsbStorageListener) {
        this.mUSBUtil.addUsbStorageListener(iUsbStorageListener);
    }

    public void removeUsbStorageListener(IUsbStorageListener iUsbStorageListener) {
        this.mUSBUtil.removeUsbStorageListener(iUsbStorageListener);
    }

    public synchronized void release() {
        if (this.mCheckLogFileSizeScheduledFuture != null) {
            this.mCheckLogFileSizeScheduledFuture.cancel(false);
            this.mCheckLogFileSizeScheduledFuture = null;
        }
        if (this.mLogProcess != null) {
            this.mLogProcess.destroy();
            this.mLogProcess = null;
        }
    }

    public synchronized void init(@NonNull String str, int i) {
        Process process;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!FileIOUtil.makeDirs(str)) {
            Log.e("LogHelper", "log file path does not exist: " + str);
            return;
        }
        int i2 = 0;
        if (str.startsWith(RootUtil.MNT_VMAP)) {
            String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                sb.append(str2);
                sb.append(File.separator);
                if (!RootUtil.MNT_VMAP.contains(str2)) {
                    FileUtil.setFileWith755Permission(new File(sb.toString()));
                }
            }
        }
        if (this.mLogProcess != null) {
            process = this.mLogProcess;
            this.mLogProcess = null;
        } else {
            process = null;
        }
        if (this.mCheckLogFileSizeScheduledFuture != null) {
            this.mCheckLogFileSizeScheduledFuture.cancel(false);
            this.mCheckLogFileSizeScheduledFuture = null;
        }
        sTimeFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        String generateLogFileName = generateLogFileName(str + File.separator + sTimeFormat.format(new Date()), 0);
        File createNewFileWith755Permission = FileUtil.createNewFileWith755Permission(generateLogFileName);
        String str3 = (("logcat -f " + generateLogFileName + " ") + "-v threadtime ") + "*:" + convertLogLevel(i) + " ";
        String str4 = str3;
        for (String str5 : IGNORE_TAGS) {
            str4 = str4 + str5 + ":S ";
        }
        this.mLogProcess = Runtime.getRuntime().exec((str4 + "-b main ") + "| grep " + Process.myPid() + " ");
        if (process != null) {
            process.destroy();
        }
        if (!isLogPathChanged(this.mCurrentLogPath, str)) {
            i2 = 180;
        }
        this.mCheckLogFileSizeScheduledFuture = WorkThreadUtil.getInstance().executeScheduledIoTask(new CheckLogFileSize(createNewFileWith755Permission, this.mCurrentLogPath, str), i2, TimeUnit.SECONDS);
        this.mCurrentLogPath = str;
    }

    private String generateLogFileName(String str, int i) {
        String str2 = str + LOG_FILE_EXTENSION;
        if (new File(str2).exists()) {
            int lastIndexOf = str.lastIndexOf("(");
            StringBuilder sb = new StringBuilder();
            if (lastIndexOf < 0) {
                lastIndexOf = str.length();
            }
            sb.append(str.substring(0, lastIndexOf));
            sb.append("(");
            int i2 = i + 1;
            sb.append(i);
            sb.append(")");
            return generateLogFileName(sb.toString(), i2);
        }
        return str2;
    }

    public synchronized void init(@NonNull String str) {
        init(str, RootUtil.isLogcatEnabled() ? 0 : 3);
    }

    public void quickSwitchXPLog(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_LOG, z);
        if (z) {
            getInstance().init(RootUtil.getLogcatLogPath());
        } else {
            getInstance().release();
        }
    }

    public boolean isUsbAvailable() {
        return !TextUtils.isEmpty(this.mUSBUtil.getUsbPath());
    }

    public void checkLogDiskSize(final boolean z) {
        if (RootUtil.isUserVersion() && this.mIsClearLogIdle) {
            WorkThreadUtil.getInstance().executeScheduledIoTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    LogHelper.this.mIsClearLogIdle = false;
                    LogFileManager unused = LogHelper.this.mLogFileManager;
                    long fsAvailaleSize = LogFileManager.getFsAvailaleSize(RootUtil.DIR_BL_LOG);
                    LogFileManager unused2 = LogHelper.this.mLogFileManager;
                    long totalSpaceSize = LogFileManager.getTotalSpaceSize(RootUtil.DIR_BL_LOG);
                    float f = ((float) fsAvailaleSize) / ((float) totalSpaceSize);
                    L.Tag tag = LogHelper.TAG;
                    L.i(tag, RootUtil.DIR_BL_LOG + " remain:" + fsAvailaleSize + " total:" + totalSpaceSize + " " + f);
                    if (LogHelper.LOG_OUTPUT_SAFETY_RATE > f) {
                        if (z) {
                            L.Tag tag2 = LogHelper.TAG;
                            L.i(tag2, "AutoClear vmap:" + fsAvailaleSize);
                            AfterSalesUtil afterSalesUtil = AfterSalesUtil.getInstance();
                            afterSalesUtil.recordDiagnosisError(9004, "vmap free space:" + fsAvailaleSize);
                            LogHelper.clearAllLogSync();
                        } else {
                            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ToastUtils.showToast(ContextUtils.getContext(), R.string.low_vmap_space_warning);
                                }
                            }, 0L);
                        }
                    }
                    LogHelper.this.mIsClearLogIdle = true;
                }
            }, 1L, TimeUnit.SECONDS);
        } else {
            L.i(TAG, "ignore TF card size check");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CheckLogFileSize implements Runnable {
        private File mCurrentLogFile;
        private String mCurrentLogFilePath;
        private String mPreviousLogFilePath;

        protected CheckLogFileSize(File file, String str, String str2) {
            this.mCurrentLogFile = file;
            this.mCurrentLogFilePath = str2;
            this.mPreviousLogFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("LogHelper", "CheckLogFileSize start ...");
            checkLogPathChange();
            clearLogFiles();
            File file = this.mCurrentLogFile;
            if (file != null) {
                if (file.length() > 20971520 || !this.mCurrentLogFile.exists()) {
                    LogHelper.getInstance().init(this.mCurrentLogFilePath);
                } else {
                    WorkThreadUtil.getInstance().executeScheduledIoTask(this, 180L, TimeUnit.SECONDS);
                }
            }
            Log.i("LogHelper", "CheckLogFileSize end ...");
        }

        private void checkLogPathChange() {
            if (LogHelper.isLogPathChanged(this.mPreviousLogFilePath, this.mCurrentLogFilePath)) {
                try {
                    File[] listFiles = new File(this.mPreviousLogFilePath).listFiles();
                    if (listFiles == null) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (file.isFile() && file.getName().endsWith(LogHelper.LOG_FILE_EXTENSION)) {
                            File file2 = new File(this.mCurrentLogFilePath + File.separator + file.getName());
                            while (file2.exists()) {
                                file2 = new File(this.mCurrentLogFilePath + File.separator + file.getName() + 0);
                            }
                            file.renameTo(file2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void clearLogFiles() {
            File[] listFiles = new File(this.mCurrentLogFilePath).listFiles();
            if (listFiles == null) {
                return;
            }
            Pair[] pairArr = new Pair[listFiles.length];
            for (int i = 0; i < listFiles.length; i++) {
                pairArr[i] = new Pair(listFiles[i]);
            }
            Arrays.sort(pairArr);
            long j = 0;
            for (int i2 = 1; i2 < listFiles.length; i2++) {
                File file = pairArr[i2].mFile;
                j += file.length();
                if (j > LogHelper.LOGCAT_FILE_TOTAL_SIZE) {
                    file.delete();
                    Log.i("LogHelper", "File deleted --> lastModify time : " + LogHelper.sTimeFormat.format(new Date(pairArr[i2].mLastModifyTime)) + " path : " + file.getAbsolutePath() + FDManager.LINE_SEPERATOR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Pair implements Comparable<Pair> {
        public File mFile;
        public long mLastModifyTime;

        public Pair(File file) {
            this.mFile = file;
            this.mLastModifyTime = file.lastModified();
        }

        @Override // java.lang.Comparable
        public int compareTo(Pair pair) {
            long j = pair.mLastModifyTime;
            long j2 = this.mLastModifyTime;
            if (j2 > j) {
                return -1;
            }
            return j2 == j ? 0 : 1;
        }
    }

    public boolean copyLogToUsb(ILogFileOperationCallback iLogFileOperationCallback) {
        if (sTimeFormat == null) {
            sTimeFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        }
        return this.mLogFileManager.copyLogToUsb(this.mUSBUtil.getUsbPath(), sTimeFormat.format(new Date()), iLogFileOperationCallback);
    }

    public void initNaviLogFolder() {
        this.mLogFileManager.initNaviLogFolder();
    }

    public void switchUserVersionNaviLog(boolean z) {
        if (z) {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtils.showToast(ContextUtils.getContext(), R.string.log_find_usb_open_key);
                }
            }, 0L);
        } else if (RootUtil.isUserVersion()) {
            clearAllLog(true);
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtils.showToast(ContextUtils.getContext(), R.string.log_find_usb_close_key);
                }
            }, 0L);
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_CLOSE_AMAP_LOG);
        }
    }

    public static void clearAllLog(boolean z) {
        if (z) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 2);
        } else {
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    LogHelper.clearAllLogSync();
                }
            });
        }
    }

    public static void clearAllLogSync() {
        FileUtil.deleteDir(new File(RootUtil.getLogPath()));
        getInstance().initNaviLogFolder();
    }

    public static void clearBLUselessLogFile() {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogHelper.5
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.deleteDir(new File(RootUtil.DIR_BL_LOG_ROUTE_DATA));
            }
        });
    }

    public static String getLogHead(String str) {
        int length;
        return (TextUtils.isEmpty(str) || (length = str.length()) < 20) ? str : str.substring(length - 20, length - 1);
    }

    public static String appendLogLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" len:" + str.length());
        return sb.toString();
    }
}
