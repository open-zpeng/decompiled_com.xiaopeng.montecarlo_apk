package com.xiaopeng.montecarlo.base.scene;

import android.os.SystemClock;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class BasePresenter extends AbstractBasePresenter {
    private static final long MULTI_CLICK_INTERVAL = 500;
    private long mLastClickTime;
    protected ConcurrentMap<SpeechNaviEvent, ICommandCallback> mPendingEventMap = new ConcurrentHashMap();

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        executePendingEvent();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        this.mPendingEventMap.clear();
    }

    private void executePendingEvent() {
        if (this.mPendingEventMap.isEmpty()) {
            return;
        }
        for (Map.Entry<SpeechNaviEvent, ICommandCallback> entry : this.mPendingEventMap.entrySet()) {
            onSpeechEvent(entry.getKey(), entry.getValue());
            this.mPendingEventMap.remove(entry.getKey());
        }
    }

    public boolean preventMultiClick() {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < MULTI_CLICK_INTERVAL) {
            return false;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        return true;
    }
}
