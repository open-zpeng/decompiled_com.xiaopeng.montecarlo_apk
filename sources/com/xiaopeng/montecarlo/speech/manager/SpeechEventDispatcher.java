package com.xiaopeng.montecarlo.speech.manager;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
/* loaded from: classes3.dex */
public class SpeechEventDispatcher implements ISpeechEvent {
    private static final L.Tag TAG = new L.Tag("SpeechEventDispatcher");
    private ISpeechEvent mMainContext;
    private final ISpeechEvent mNonUiEvent = new SpeechEventDispatcherHelper();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpeechEventDispatcher(ISpeechEvent iSpeechEvent) {
        this.mMainContext = iSpeechEvent;
    }

    public void setMainContext(ISpeechEvent iSpeechEvent) {
        this.mMainContext = iSpeechEvent;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public final boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        boolean onInterceptSpeechEvent = this.mNonUiEvent.onInterceptSpeechEvent(speechNaviEvent, iCommandCallback);
        String simpleName = getClass().getSimpleName();
        String[] strArr = new String[1];
        strArr[0] = onInterceptSpeechEvent ? "intercept" : "do nothing";
        speechNaviEvent.record(simpleName, "onInterceptSpeechEvent", strArr);
        return onInterceptSpeechEvent;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        boolean onSpeechEvent = this.mNonUiEvent.onSpeechEvent(speechNaviEvent, iCommandCallback);
        String simpleName = getClass().getSimpleName();
        String[] strArr = new String[1];
        strArr[0] = onSpeechEvent ? "consume" : "";
        speechNaviEvent.record(simpleName, "onSpeechEvent", strArr);
        return onSpeechEvent;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        speechNaviEvent.record(getClass().getSimpleName(), "dispatchSpeechEvent", new String[0]);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "dispatchSpeechEvent " + speechNaviEvent.what);
        }
        if (onInterceptSpeechEvent(speechNaviEvent, iCommandCallback)) {
            return onSpeechEvent(speechNaviEvent, iCommandCallback);
        }
        return this.mMainContext.dispatchSpeechEvent(speechNaviEvent, iCommandCallback) || onSpeechEvent(speechNaviEvent, iCommandCallback);
    }
}
