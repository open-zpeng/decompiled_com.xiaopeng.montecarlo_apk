package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.speech.protocol.bean.FeedListUIValue;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class LogDiskCacheUtil {
    private static final String LOC_DIR = "log";
    private static final long MAX_SIZE = 2147483648L;
    private static final L.Tag TAG = new L.Tag("LogDiskCacheUtil");

    public static void asyncClearRubbish() {
        if (RootUtil.isLogFileEnable()) {
            L.i(TAG, "clearRubbish");
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.LogDiskCacheUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    LogDiskCacheUtil.clearRubbish();
                    DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CLEAR_RUBBISH_FLAG, true);
                }
            });
        }
    }

    public static void clearRubbish() {
        String[] strArr = {RootUtil.NAVI_LOG_DIR_BLLOG_NAME, "log", RootUtil.NAVI_LOG_DIR_XPLOG_NAME, "res", "GNaviConfig.xml", "GRestConfig.ini", "aosinfo.db", "check", FeedListUIValue.TYPE_ROUTE, "all_city_compile.json"};
        String[] strArr2 = {RootUtil.NAVI_LOG_DIR_BLLOG_NAME, "log", RootUtil.NAVI_LOG_DIR_XPLOG_NAME};
        for (int i = 0; i < strArr2.length; i++) {
            String str = RootUtil.SD_CARD_NAVI_PATH + File.separator + strArr2[i];
            if (L.ENABLE) {
                L.d(TAG, "clearRubbish sdpath:" + str);
            }
            FileUtil.deleteDir(new File(str));
        }
        if (RootUtil.isTfExtSdExist()) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str2 = RootUtil.getNaviPath() + File.separator + strArr[i2];
                if (L.ENABLE) {
                    L.d(TAG, "clearRubbish tfpath:" + str2);
                }
                FileUtil.deleteDir(new File(str2));
            }
        }
    }

    public static void clearDiskCache() {
        asyncClearLocDiskCache();
        if (DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CLEAR_RUBBISH_FLAG, false)) {
            return;
        }
        asyncClearRubbish();
    }

    public static void asyncClearLocDiskCache() {
        if (RootUtil.isLogFileEnable()) {
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.LogDiskCacheUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    LogDiskCacheUtil.clearLocDiskCache();
                }
            });
        }
    }

    public static void clearLocDiskCache() {
        File[] orderByDate;
        if (TextUtils.isEmpty(RootUtil.getLocLogPath())) {
            return;
        }
        File file = new File(RootUtil.getLocLogPath() + File.separator + "log");
        if (!file.exists() || getTotalSizeOfFilesInDir(file) <= MAX_SIZE || (orderByDate = orderByDate(file)) == null || orderByDate.length <= 0) {
            return;
        }
        long j = 0;
        int length = orderByDate.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            j += orderByDate[length].length();
            if (j > MAX_SIZE) {
                break;
            }
            length--;
        }
        if (length >= 0) {
            for (int i = 0; i <= length; i++) {
                orderByDate[i].delete();
            }
        }
    }

    private static File[] orderByDate(File file) {
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.xiaopeng.montecarlo.root.util.LogDiskCacheUtil.3
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return true;
            }

            @Override // java.util.Comparator
            public int compare(@NonNull File file2, @NonNull File file3) {
                int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                if (i > 0) {
                    return 1;
                }
                return i == 0 ? 0 : -1;
            }
        });
        return listFiles;
    }

    private static long getTotalSizeOfFilesInDir(File file) {
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j += getTotalSizeOfFilesInDir(file2);
            }
        }
        return j;
    }
}
