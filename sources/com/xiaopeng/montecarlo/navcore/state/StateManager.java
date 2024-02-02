package com.xiaopeng.montecarlo.navcore.state;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StateManager implements Handler.Callback {
    public static final int MSG_SPEED_STATE = 1001;
    public static final int MSG_TIMER_STATE = 1000;
    public static final int NORMAL_TO_IMMERSION_DELAY = 10000;
    public static final int OVERVIEW_TO_IMMERSION_DELAY = 10000;
    public static final int SPEED_CHECK_COUNT_MAX = 5;
    public static final int SPEED_CHECK_DELAY = 1000;
    public static final int SPEED_LEVEL_1 = 5;
    public static final int SPEED_LEVEL_2 = 15;
    public static final int SPEED_LEVEL_3 = 40;
    public static final int SR_TO_IMMERSION_DELAY = 5000;
    public static final int STATE_ACTIVE = 0;
    public static final boolean STATE_FUC_ENABLE = true;
    public static final int STATE_IMMERSION = 1;
    public static final int STATE_MODE_ONLY_TIME = 1;
    public static final int STATE_MODE_TIME_AND_SPEED = 0;
    public static final int SWITCH_OFF = 1;
    public static final int SWITCH_ON = 0;
    private static final L.Tag TAG = new L.Tag("StateManager");
    public static final int TIME_LEVEL_1 = 10;
    public static final int TIME_LEVEL_2 = 20;
    public static final int TIME_LEVEL_3 = 5;
    private int mDelayTime;
    private final Handler mHandler;
    private boolean mIsSpeedEnter;
    private boolean mIsSpeedWhenLevel1;
    private boolean mIsTimerEnter;
    private final List<IStateListener> mListeners;
    private int mSpeedCheckCount;
    private int mStateMode;
    private int mStatus;
    private int mSwitchStatus;
    private int mTickTime;

    private StateManager() {
        this.mTickTime = 10;
        this.mIsSpeedWhenLevel1 = false;
        this.mSwitchStatus = 1;
        this.mStatus = 0;
        this.mDelayTime = 10000;
        this.mIsTimerEnter = false;
        this.mIsSpeedEnter = false;
        this.mSpeedCheckCount = 0;
        this.mStateMode = 0;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mListeners = new ArrayList();
    }

    @NonNull
    public static StateManager getInstance() {
        return Singleton.sInstance;
    }

    public void addListener(IStateListener iStateListener) {
        if (iStateListener == null || this.mListeners.contains(iStateListener)) {
            return;
        }
        this.mListeners.add(iStateListener);
        L.Tag tag = TAG;
        L.i(tag, "add listener: " + iStateListener.getClass().getSimpleName());
    }

    public void removeListener(IStateListener iStateListener) {
        if (iStateListener != null) {
            this.mListeners.remove(iStateListener);
            L.Tag tag = TAG;
            L.i(tag, "remove listener: " + iStateListener.getClass().getSimpleName());
        }
    }

    public void switchActiveState() {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            beginActiveState();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.state.-$$Lambda$StateManager$5K45irDi8Xy-6OImffY4-VtswU8
                @Override // java.lang.Runnable
                public final void run() {
                    StateManager.this.beginActiveState();
                }
            });
        }
    }

    public void switchImmersionState() {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            beginImmersionState();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.state.-$$Lambda$StateManager$iYCzNwEJZAo4Mg949RCU1D-6PgM
                @Override // java.lang.Runnable
                public final void run() {
                    StateManager.this.beginImmersionState();
                }
            });
        }
    }

    public void resetTimer() {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.state.StateManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (1 != StateManager.this.mStatus) {
                    StateManager stateManager = StateManager.this;
                    stateManager.start(stateManager.mStateMode);
                }
            }
        });
    }

    public int getState() {
        return this.mStatus;
    }

    public int getSwitchState() {
        return this.mSwitchStatus;
    }

    public int getStateMode() {
        return this.mStateMode;
    }

    public void setStateMode(int i) {
        this.mStateMode = i;
    }

    public void setStateModeAndTime(int i, int i2, boolean z) {
        if (z) {
            start(i, i2);
            return;
        }
        this.mStateMode = i;
        this.mDelayTime = i2;
    }

    public void start(int i) {
        start(i, this.mDelayTime);
    }

    public void start(int i, int i2) {
        start(i, i2, false);
    }

    public void start(int i, int i2, boolean z) {
        this.mSwitchStatus = 0;
        this.mStateMode = i;
        if (!z) {
            this.mDelayTime = i2;
        }
        startTimer(z ? i2 : 0L);
    }

    public void stop() {
        this.mSwitchStatus = 1;
        stopTimer();
    }

    @MainThread
    public void switchState(int i) {
        if (i == 0) {
            beginActiveState();
        } else {
            beginImmersionState();
        }
    }

    private void stopTimer() {
        this.mHandler.removeMessages(1000);
        this.mHandler.removeMessages(1001);
        this.mIsTimerEnter = false;
        this.mIsSpeedEnter = false;
        this.mSpeedCheckCount = 0;
        this.mTickTime = 10;
        this.mIsSpeedWhenLevel1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginActiveState() {
        if (this.mStatus != 0) {
            L.i(TAG, ">>> beginActiveState");
            this.mStatus = 0;
            for (IStateListener iStateListener : this.mListeners) {
                if (iStateListener != null) {
                    iStateListener.onStateChange(0);
                }
            }
        }
        if (this.mSwitchStatus == 0) {
            startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginImmersionState() {
        L.i(TAG, ">>> beginImmersionState");
        this.mStatus = 1;
        for (IStateListener iStateListener : this.mListeners) {
            if (iStateListener != null) {
                iStateListener.onStateChange(1);
            }
        }
        stopTimer();
    }

    private void startTimer() {
        startTimer(0L);
    }

    private void startTimer(long j) {
        stopTimer();
        Handler handler = this.mHandler;
        if (j <= 0) {
            j = this.mDelayTime;
        }
        handler.sendEmptyMessageDelayed(1000, j);
    }

    private void checkImmersionEnter() {
        if (1 == this.mStateMode) {
            if (this.mIsTimerEnter) {
                beginImmersionState();
            }
        } else if (this.mIsSpeedEnter && this.mIsTimerEnter) {
            beginImmersionState();
        }
    }

    private void updateSpeedState() {
        int i;
        float carSpeed = TBTManager.getInstance().getCarSpeed();
        float simulationSpeed = TBTManager.getInstance().getSimulationSpeed();
        float locationSpeed = LocationServiceManager.getInstance().getCurrentStatus() == 2 ? LocationServiceManager.getInstance().getLocationSpeed() : 0.0f;
        if (L.ENABLE) {
            L.d(TAG, ">>> updateSpeedState carSpeed = " + carSpeed + "  locSimulationSpeed = " + locationSpeed + " blSimulationNaviSpeed = " + simulationSpeed);
        }
        if (carSpeed > 40.0f || ((carSpeed <= 0.0f && locationSpeed > 40.0f) || (i <= 0 && simulationSpeed > 40.0f))) {
            this.mIsSpeedEnter = true;
            return;
        }
        if (carSpeed > 15.0f || ((i <= 0 && locationSpeed > 15.0f) || (i <= 0 && simulationSpeed > 15.0f))) {
            this.mSpeedCheckCount++;
            if (this.mSpeedCheckCount > 5) {
                this.mIsSpeedEnter = true;
                return;
            }
        } else {
            this.mSpeedCheckCount = 0;
        }
        this.mTickTime++;
        if (carSpeed > 5.0f || ((i <= 0 && locationSpeed > 5.0f) || (i <= 0 && simulationSpeed > 5.0f))) {
            this.mIsSpeedWhenLevel1 = true;
        }
        if (this.mTickTime >= 20 && this.mIsSpeedWhenLevel1) {
            this.mIsSpeedEnter = true;
        } else {
            this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i != 1000) {
            if (i != 1001) {
                return false;
            }
            updateSpeedState();
            checkImmersionEnter();
            return false;
        }
        this.mIsTimerEnter = true;
        if (this.mStateMode == 0) {
            this.mHandler.sendEmptyMessageDelayed(1001, 0L);
        }
        checkImmersionEnter();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Singleton {
        @NonNull
        private static StateManager sInstance = new StateManager();

        private Singleton() {
        }
    }
}
