package com.xiaopeng.montecarlo.speech.command;

import androidx.annotation.UiThread;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
/* loaded from: classes3.dex */
public interface ISpeechEvent {
    @UiThread
    boolean dispatchSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback);

    boolean onInterceptSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback);

    boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback);
}
