package com.xiaopeng.montecarlo.root.util.logcat;

import com.xiaopeng.montecarlo.root.util.logcat.LogFileStatus;
/* loaded from: classes2.dex */
public interface ILogFileOperationCallback {
    void onStatusChange(LogFileStatus.CopyLogFileStatus copyLogFileStatus, LogFileStatus.CopyLogFileErrCode copyLogFileErrCode, long j, String str);
}
