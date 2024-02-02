package com.autonavi.common.tool.util;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
public class LocalRecordFileRemoveThread extends Thread {
    private int mLimitCount;
    private String mLocalRecordDirPath;
    private boolean mNeedLocalRecord;

    public LocalRecordFileRemoveThread(boolean z, int i, String str) {
        this.mNeedLocalRecord = z;
        this.mLimitCount = i;
        this.mLocalRecordDirPath = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File[] listFiles;
        if (TextUtils.isEmpty(this.mLocalRecordDirPath)) {
            return;
        }
        File file = new File(this.mLocalRecordDirPath);
        if ((!file.exists() && !file.isDirectory()) || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.autonavi.common.tool.util.LocalRecordFileRemoveThread.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.contains(CrashFileManager.ERROR_BAK_FILE_NAME);
            }
        })) == null || listFiles.length == 0) {
            return;
        }
        try {
            Thread.sleep(SRNaviManager.SR_DATA_INTERVAL_LEVEL1);
            int i = 0;
            if (!this.mNeedLocalRecord) {
                int length = listFiles.length;
                while (i < length) {
                    listFiles[i].delete();
                    i++;
                }
            } else if (listFiles.length > this.mLimitCount) {
                Arrays.sort(listFiles, new FileModifyTimeComparator());
                int length2 = listFiles.length - this.mLimitCount;
                while (i < length2) {
                    listFiles[i].delete();
                    i++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* loaded from: classes.dex */
    public static class FileModifyTimeComparator implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }
}
