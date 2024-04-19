package com.xiaopeng.montecarlo.root.util;

import android.content.Intent;
import com.xiaopeng.montecarlo.root.util.L;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MapExceptionWatcher implements Runnable {
    private static final long CHECK_INTERNAL = 1000;
    private static final long MINI_MAP_TIME_OUT = 10000;
    private static final long OPERATION_TIME_OUT = 1000;
    private static final L.Tag sTAG = new L.Tag("MapExceptionWatcher");
    private volatile long mLastMiniMapUpdateTime = 0;
    private volatile long mFirstMapOperationBeforeLastMiniMapUpdateTime = 0;
    private volatile WorkStatus mWorkStatus = WorkStatus.WorkStatusIdle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum WorkStatus {
        WorkStatusIdle,
        WorkStatusBusy,
        WorkStatusToClose
    }

    public WorkStatus getWorkStatus() {
        return this.mWorkStatus;
    }

    public void stopWatcher() {
        this.mWorkStatus = WorkStatus.WorkStatusToClose;
        this.mLastMiniMapUpdateTime = 0L;
        this.mFirstMapOperationBeforeLastMiniMapUpdateTime = 0L;
    }

    public void updateMiniMapTime() {
        if (WorkStatus.WorkStatusBusy == this.mWorkStatus) {
            this.mLastMiniMapUpdateTime = System.currentTimeMillis();
            if (L.ENABLE) {
                L.Tag tag = sTAG;
                L.d(tag, "mLastMiniMapUpdateTime:" + this.mLastMiniMapUpdateTime);
            }
        }
    }

    public void updateMapOperationTime() {
        if (WorkStatus.WorkStatusBusy != this.mWorkStatus || this.mFirstMapOperationBeforeLastMiniMapUpdateTime > this.mLastMiniMapUpdateTime) {
            return;
        }
        this.mFirstMapOperationBeforeLastMiniMapUpdateTime = System.currentTimeMillis();
        if (L.ENABLE) {
            L.Tag tag = sTAG;
            L.d(tag, "mFirstMapOperationBeforeLastMiniMapUpdateTime:" + this.mFirstMapOperationBeforeLastMiniMapUpdateTime);
        }
    }

    public void restartWatcher() {
        L.i(sTAG, "restartWatcher");
        if (this.mWorkStatus == WorkStatus.WorkStatusToClose) {
            this.mWorkStatus = WorkStatus.WorkStatusBusy;
            return;
        }
        L.Tag tag = sTAG;
        L.w(tag, "restartWatcher is illegal current status:" + this.mWorkStatus);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkStatus = WorkStatus.WorkStatusBusy;
        this.mLastMiniMapUpdateTime = 0L;
        this.mFirstMapOperationBeforeLastMiniMapUpdateTime = 0L;
        L.i(sTAG, "start run");
        while (WorkStatus.WorkStatusBusy == this.mWorkStatus) {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                L.w(sTAG, e.getMessage());
            }
            if (0 != this.mLastMiniMapUpdateTime && 0 != this.mFirstMapOperationBeforeLastMiniMapUpdateTime && this.mFirstMapOperationBeforeLastMiniMapUpdateTime > this.mLastMiniMapUpdateTime) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - this.mLastMiniMapUpdateTime;
                if (j >= 10000) {
                    if (L.ENABLE) {
                        L.Tag tag = sTAG;
                        L.d(tag, "mini map update has stopped for:" + j);
                    }
                    long j2 = currentTimeMillis - this.mFirstMapOperationBeforeLastMiniMapUpdateTime;
                    if (j2 >= 1000) {
                        L.Tag tag2 = sTAG;
                        L.w(tag2, "catch surface exception miniMapStopTime:" + j + " mapOperationStopTime" + j2);
                        Intent intent = new Intent();
                        intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
                        intent.setAction("com.xiaopeng.montecarlo.minimap.RESET");
                        ContextUtils.getContext().startService(intent);
                        L.i(sTAG, "MiniMapService startService RESET in MapExceptionWatcher");
                        this.mWorkStatus = WorkStatus.WorkStatusToClose;
                    }
                }
            }
        }
        this.mWorkStatus = WorkStatus.WorkStatusIdle;
        this.mLastMiniMapUpdateTime = 0L;
        this.mFirstMapOperationBeforeLastMiniMapUpdateTime = 0L;
        L.i(sTAG, "end thread");
    }
}
