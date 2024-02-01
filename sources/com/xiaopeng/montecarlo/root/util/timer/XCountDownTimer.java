package com.xiaopeng.montecarlo.root.util.timer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class XCountDownTimer {
    private static final long DEFAULT_INTERVAL = 1000;
    static final int MESSAGE_TIME_RESUME = 2;
    static final int MESSAGE_TIME_START = 0;
    static final int MESSAGE_TIME_TICK = 1;
    private static final L.Tag TAG = new L.Tag("XCountDownTimer");
    private ITimerCallback mCallback;
    private boolean mCancelled;
    private TimerHandler mHandler;
    private final long mInterval;
    private long mMillisInFuture;

    /* loaded from: classes3.dex */
    public interface ITimerCallback {
        void onTick(long j);

        void onTimeOut();
    }

    public XCountDownTimer(long j, ITimerCallback iTimerCallback) {
        this(j, 1000L, iTimerCallback);
    }

    public XCountDownTimer(long j, long j2, ITimerCallback iTimerCallback) {
        this.mHandler = new TimerHandler();
        this.mCancelled = false;
        this.mMillisInFuture = j;
        this.mInterval = j2;
        this.mCallback = iTimerCallback;
    }

    public synchronized long getLeftTickTime() {
        return this.mHandler.mMillisLeft;
    }

    public void setMillisInFuture(long j) {
        this.mMillisInFuture = j;
    }

    public synchronized void start() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "start: " + this.mMillisInFuture + ", mInterval: " + this.mInterval + ", callback: " + this.mCallback);
        }
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0 && this.mCallback != null) {
            this.mCallback.onTimeOut();
            return;
        }
        removeMessages();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public synchronized void stop() {
        if (!this.mCancelled) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "stop: callback: " + this.mCallback);
            }
            this.mCancelled = true;
            removeMessages();
        }
        this.mHandler.mMillisLeft = 0L;
    }

    public synchronized void reset() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "reset: callback: " + this.mCallback);
        }
        if (this.mMillisInFuture <= 0 && this.mCallback != null) {
            this.mCallback.onTimeOut();
            return;
        }
        removeMessages();
        this.mHandler.sendEmptyMessage(0);
    }

    public synchronized void pause() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "pause: callback: " + this.mCallback);
        }
        removeMessages();
    }

    public synchronized void resume() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "resume: " + this.mHandler.mMillisLeft + ", callback: " + this.mCallback);
        }
        removeMessages();
        this.mHandler.sendEmptyMessage(2);
    }

    protected void removeMessages() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TimerHandler extends Handler {
        private long mMillisLeft;
        private long mStopTimeInFuture;

        TimerHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (XCountDownTimer.this) {
                if (XCountDownTimer.this.mCancelled) {
                    return;
                }
                int i = message.what;
                if (i == 0) {
                    this.mStopTimeInFuture = SystemClock.elapsedRealtime() + XCountDownTimer.this.mMillisInFuture;
                    tick();
                } else if (i == 1) {
                    tick();
                } else if (i == 2) {
                    this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisLeft;
                    tick();
                }
            }
        }

        private void tick() {
            this.mMillisLeft = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            if (this.mMillisLeft <= 0) {
                if (XCountDownTimer.this.mCallback != null) {
                    if (L.ENABLE) {
                        L.Tag tag = XCountDownTimer.TAG;
                        L.v(tag, "onTimeOut: " + XCountDownTimer.this.mCallback);
                    }
                    XCountDownTimer.this.mCallback.onTimeOut();
                    return;
                }
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (XCountDownTimer.this.mCallback != null) {
                if (L.ENABLE) {
                    L.Tag tag2 = XCountDownTimer.TAG;
                    L.v(tag2, "tick: " + Math.round((((float) this.mMillisLeft) * 1.0f) / 1000.0f) + ", callback: " + XCountDownTimer.this.mCallback);
                }
                XCountDownTimer.this.mCallback.onTick(Math.round((((float) this.mMillisLeft) * 1.0f) / 1000.0f));
            }
            long elapsedRealtime2 = (elapsedRealtime + XCountDownTimer.this.mInterval) - SystemClock.elapsedRealtime();
            while (elapsedRealtime2 < 0) {
                elapsedRealtime2 += XCountDownTimer.this.mInterval;
            }
            sendMessageDelayed(obtainMessage(1), elapsedRealtime2);
        }
    }
}
