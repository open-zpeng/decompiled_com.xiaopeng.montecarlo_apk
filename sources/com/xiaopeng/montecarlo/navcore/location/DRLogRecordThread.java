package com.xiaopeng.montecarlo.navcore.location;

import android.os.Environment;
import android.os.SystemClock;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class DRLogRecordThread implements Runnable {
    public static final String FILE_NAME = "/xploc.txt";
    private static final L.Tag TAG = new L.Tag("DebugLocationRecordThread");
    private static final long WORK_GAP = 60000;
    private final String mSimulatedLogFilePath;
    private volatile Map<Long, String> mRecordDataA = new ConcurrentHashMap();
    private volatile Map<Long, String> mRecordDataB = new ConcurrentHashMap();
    private volatile boolean mIsRecordA = true;
    private volatile WorkStatus mWorkStatus = WorkStatus.WorkStatusIdle;

    /* loaded from: classes3.dex */
    enum WorkStatus {
        WorkStatusIdle,
        WorkStatusBusy,
        WorkStatusToClose
    }

    public DRLogRecordThread(String str) {
        this.mSimulatedLogFilePath = str;
    }

    public void addRecord(String str) {
        Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
        if (this.mIsRecordA) {
            this.mRecordDataA.put(valueOf, str);
        } else {
            this.mRecordDataB.put(valueOf, str);
        }
    }

    public void addRecord(Long l, String str) {
        if (this.mIsRecordA) {
            this.mRecordDataA.put(l, str);
        } else {
            this.mRecordDataB.put(l, str);
        }
    }

    public void stopThread() {
        this.mWorkStatus = WorkStatus.WorkStatusToClose;
    }

    public WorkStatus getWorkStatus() {
        return this.mWorkStatus;
    }

    public void restartThread() {
        L.i(TAG, "restart thread");
        if (this.mWorkStatus == WorkStatus.WorkStatusToClose) {
            this.mWorkStatus = WorkStatus.WorkStatusBusy;
            return;
        }
        L.Tag tag = TAG;
        L.w(tag, "restartThread is illegal current status:" + this.mWorkStatus);
    }

    @Override // java.lang.Runnable
    public void run() {
        FileWriter fileWriter;
        this.mWorkStatus = WorkStatus.WorkStatusBusy;
        L.i(TAG, "start run");
        while (WorkStatus.WorkStatusBusy == this.mWorkStatus) {
            try {
                Thread.sleep(60000L);
            } catch (InterruptedException e) {
                L.e(TAG, e.getMessage());
            }
            L.i(TAG, "start output isRecordA:" + this.mIsRecordA);
            this.mIsRecordA = this.mIsRecordA ^ true;
            Map<Long, String> map = this.mIsRecordA ? this.mRecordDataB : this.mRecordDataA;
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<Long, String>>() { // from class: com.xiaopeng.montecarlo.navcore.location.DRLogRecordThread.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<Long, String> entry, Map.Entry<Long, String> entry2) {
                    if (entry == null || entry2 == null || entry.getKey() == null || entry2.getKey() == null) {
                        return 0;
                    }
                    return (int) (entry.getKey().longValue() - entry2.getKey().longValue());
                }
            });
            if (Environment.getExternalStorageState().equals("mounted")) {
                FileWriter fileWriter2 = null;
                try {
                    try {
                        String str = this.mSimulatedLogFilePath;
                        File file = new File(str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str2 = str + FILE_NAME;
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            fileWriter = new FileWriter(str2, true);
                        } else {
                            file2.createNewFile();
                            fileWriter = new FileWriter(str2, false);
                        }
                        for (Map.Entry entry : arrayList) {
                            fileWriter.write(String.format(((Long) entry.getKey()).longValue() + LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR + ((String) entry.getValue()) + FDManager.LINE_SEPERATOR, new Object[0]));
                        }
                        fileWriter.flush();
                        map.clear();
                        L.i(TAG, "flush over");
                        fileWriter.close();
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                fileWriter2.close();
                            } catch (IOException e2) {
                                L.e(TAG, e2.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    L.e(TAG, e3.getMessage());
                    if (0 != 0) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e4) {
                            L.e(TAG, e4.getMessage());
                        }
                    }
                }
            }
        }
        this.mWorkStatus = WorkStatus.WorkStatusIdle;
        L.i(TAG, "end thread");
    }
}
