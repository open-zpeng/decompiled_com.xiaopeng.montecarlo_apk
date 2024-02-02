package com.xiaopeng.montecarlo.util;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class BackgroundJobHelper {
    private static final L.Tag TAG = new L.Tag("BackgroundJobHelper");
    private IBackgroundJob mBgService;
    private int mCount = 0;
    private boolean mIsCanceled = false;
    private int mMaxTimes;
    private int mPerDelay;

    public BackgroundJobHelper(int i, int i2) {
        this.mMaxTimes = 0;
        this.mPerDelay = 0;
        this.mMaxTimes = i;
        this.mPerDelay = i2;
    }

    public static BackgroundJobHelper getInstance(int i, int i2) {
        return new BackgroundJobHelper(i, i2);
    }

    public void setBackgroundService(IBackgroundJob iBackgroundJob) {
        this.mBgService = iBackgroundJob;
    }

    public void stop() {
        this.mIsCanceled = true;
        this.mCount = 0;
    }

    public void execute() {
        if (this.mBgService == null) {
            L.i(TAG, "execute mBgService is null");
        } else {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.BackgroundJobHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    while (!BackgroundJobHelper.this.mIsCanceled) {
                        BackgroundJobHelper.this.executeMainTask();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeMainTask() {
        this.mCount++;
        boolean onExecute = this.mBgService.onExecute();
        L.i(TAG, String.format("retry times %d--%d", Integer.valueOf(this.mCount), Integer.valueOf(this.mMaxTimes)));
        if (onExecute) {
            this.mIsCanceled = true;
            this.mCount = 0;
            L.i(TAG, "executeMainTask success");
            this.mBgService.onSuccess();
        } else if (this.mCount >= this.mMaxTimes) {
            L.i(TAG, "already the max retry times：" + this.mMaxTimes);
            this.mIsCanceled = true;
            this.mCount = 1;
            this.mBgService.onFailure();
        } else {
            mySleep();
            L.i(TAG, "executeMainTask retry");
            this.mBgService.onRetry(this.mCount);
        }
    }

    private void mySleep() {
        try {
            Thread.sleep(this.mPerDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
