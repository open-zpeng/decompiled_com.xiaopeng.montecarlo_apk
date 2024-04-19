package com.xiaopeng.montecarlo.speech.command;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class CommandRunnable implements Runnable {
    private static final int MAX_TIMES = 160;
    public static final int MAX_WAIT_TIME_MS = 8000;
    private static final L.Tag TAG = new L.Tag("CommandRunnable");
    public static final int WAIT_STEP_MS = 50;
    private ICommandRecorder mCommand;
    @NonNull
    private Handler mHandlerInnerRunnable = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper());
    private int mTimes;

    public CommandRunnable(@NonNull ICommandRecorder iCommandRecorder) {
        this.mCommand = iCommandRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mTimes > 160) {
            L.w(TAG, "wait until time out(8000ms)");
            this.mHandlerInnerRunnable.removeCallbacks(this);
            this.mCommand.onTimeOut();
        } else if (this.mCommand.isInterrupted()) {
            this.mCommand.onFailed();
            L.i(TAG, "interrupt, aready cost " + (this.mTimes * 50) + " ms");
            this.mTimes = 0;
            this.mHandlerInnerRunnable.removeCallbacks(this);
            this.mHandlerInnerRunnable.sendEmptyMessage(0);
            this.mCommand.onFinish();
        } else if (this.mCommand.isAchieveGoals()) {
            this.mCommand.onSuccess();
            L.i(TAG, "cost " + (this.mTimes * 50) + " ms to doSomething");
            this.mTimes = 0;
            this.mHandlerInnerRunnable.removeCallbacks(this);
            this.mHandlerInnerRunnable.sendEmptyMessage(0);
            this.mCommand.onFinish();
        } else {
            this.mHandlerInnerRunnable.postDelayed(this, 50L);
            this.mTimes++;
        }
    }
}
