package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class BasePresenter extends AbstractBasePresenter {
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
}
