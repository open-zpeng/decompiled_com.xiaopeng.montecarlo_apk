package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
/* loaded from: classes.dex */
public abstract class AbstractBasePresenter implements IBasePresenter, ISpeechEvent {
    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBasePresenter
    public abstract void hide();

    @Override // com.xiaopeng.montecarlo.base.IBasePresenter
    public abstract void onDestroy();

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBasePresenter
    public abstract void onPause();

    @Override // com.xiaopeng.montecarlo.base.IBasePresenter
    public abstract void onResume();

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBasePresenter
    public abstract void show();
}
