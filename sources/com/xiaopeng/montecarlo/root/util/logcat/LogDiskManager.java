package com.xiaopeng.montecarlo.root.util.logcat;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogDiskRecord;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class LogDiskManager {
    private static final String HISTORY_NAME = "list.txt";
    protected static final long MAX_LOG_FILE_SIZE = 1073741824;
    private static final long MAX_SIZE = 5368709120L;
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US);
    private String mDirPath;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogDiskManager(String str) {
        this.mDirPath = str + File.separator;
        File file = new File(this.mDirPath);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public String getWriteFileName(boolean z) {
        LogDiskRecord readLogDiskRecord = readLogDiskRecord();
        if (z || TextUtils.isEmpty(readLogDiskRecord.mCurrentLogName)) {
            readLogDiskRecord.mCurrentLogName = this.mDateFormat.format(new Date(System.currentTimeMillis())) + ".log";
            storeLogHistory(readLogDiskRecord);
        }
        return this.mDirPath + readLogDiskRecord.mCurrentLogName;
    }

    public void recordLogFile(final String str) {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.logcat.LogDiskManager.1
            @Override // java.lang.Runnable
            public void run() {
                LogDiskManager.this.recordLogFileLocked(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordLogFileLocked(String str) {
        LogDiskRecord readLogDiskRecord = readLogDiskRecord();
        CopyOnWriteArrayList<LogDiskRecord.LogOption> copyOnWriteArrayList = readLogDiskRecord.mLogOptionList;
        copyOnWriteArrayList.add(new LogDiskRecord.LogOption(2, str));
        updateLogOptionStatus(copyOnWriteArrayList);
        processLogFile(copyOnWriteArrayList);
        removeLogOption(copyOnWriteArrayList);
        storeLogHistory(readLogDiskRecord);
        cleanUp(copyOnWriteArrayList, readLogDiskRecord.mCurrentLogName);
    }

    private void updateLogOptionStatus(List<LogDiskRecord.LogOption> list) {
        long j = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            LogDiskRecord.LogOption logOption = list.get(size);
            if (!isFileExist(logOption.getFileName())) {
                logOption.setStatus(-1);
            } else if (logOption.getStatus() != 0) {
                j += new File(this.mDirPath + logOption.getFileName()).length();
            }
        }
        if (j > 5368709120L) {
            LogDiskRecord.LogOption logOption2 = list.get(0);
            if (logOption2.getStatus() == 4) {
                logOption2.setStatus(1);
            }
        }
    }

    private void processLogFile(List<LogDiskRecord.LogOption> list) {
        for (int i = 0; i < list.size(); i++) {
            LogDiskRecord.LogOption logOption = list.get(i);
            int status = logOption.getStatus();
            if (status == 0 || status == 1) {
                if (delFile(logOption.getFileName())) {
                    logOption.setStatus(-1);
                }
            } else if (status == 2) {
                String fileName = logOption.getFileName();
                if (zipFile(fileName)) {
                    logOption.setStatus(4);
                    logOption.setFileName(getZipName(fileName));
                    list.add(new LogDiskRecord.LogOption(0, fileName));
                }
            }
        }
    }

    private void removeLogOption(List<LogDiskRecord.LogOption> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getStatus() == -1) {
                list.remove(size);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cleanUp(java.util.List<com.xiaopeng.montecarlo.root.util.logcat.LogDiskRecord.LogOption> r7, java.lang.String r8) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.mDirPath
            r0.<init>(r1)
            java.lang.String[] r0 = r0.list()
            if (r0 == 0) goto L59
            int r1 = r0.length
            if (r1 <= 0) goto L59
            r1 = 0
            r2 = r1
        L12:
            int r3 = r0.length
            if (r2 >= r3) goto L59
            r3 = r0[r2]
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L4e
            r3 = r0[r2]
            java.lang.String r4 = "list.txt"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L28
            goto L4e
        L28:
            r3 = r1
        L29:
            int r4 = r7.size()
            if (r3 >= r4) goto L4c
            java.lang.Object r4 = r7.get(r3)
            com.xiaopeng.montecarlo.root.util.logcat.LogDiskRecord$LogOption r4 = (com.xiaopeng.montecarlo.root.util.logcat.LogDiskRecord.LogOption) r4
            java.lang.String r4 = r4.getFileName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L40
            goto L49
        L40:
            r5 = r0[r2]
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L49
            goto L4e
        L49:
            int r3 = r3 + 1
            goto L29
        L4c:
            r3 = 1
            goto L4f
        L4e:
            r3 = r1
        L4f:
            if (r3 == 0) goto L56
            r3 = r0[r2]
            r6.delFile(r3)
        L56:
            int r2 = r2 + 1
            goto L12
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.logcat.LogDiskManager.cleanUp(java.util.List, java.lang.String):void");
    }

    private void storeLogHistory(LogDiskRecord logDiskRecord) {
        new FileIOUtil().writeObject2SDCard(this.mDirPath, HISTORY_NAME, logDiskRecord);
    }

    private LogDiskRecord readLogDiskRecord() {
        FileIOUtil fileIOUtil = new FileIOUtil(LogDiskRecord.class);
        LogDiskRecord logDiskRecord = (LogDiskRecord) fileIOUtil.readObjectFromSDCard(this.mDirPath + HISTORY_NAME);
        return logDiskRecord == null ? new LogDiskRecord() : logDiskRecord;
    }

    private boolean delFile(String str) {
        File file = new File(this.mDirPath + str);
        return file.exists() && file.delete();
    }

    private boolean zipFile(String str) {
        return ZipUtil.zipFile(this.mDirPath + str, this.mDirPath + getZipName(str));
    }

    private String getZipName(String str) {
        return getPrefix(str) + ".zip";
    }

    private boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mDirPath);
        sb.append(str);
        return new File(sb.toString()).exists();
    }

    private String getPrefix(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
    }
}
