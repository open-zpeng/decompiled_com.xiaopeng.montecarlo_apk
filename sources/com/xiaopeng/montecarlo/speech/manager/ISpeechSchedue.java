package com.xiaopeng.montecarlo.speech.manager;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import java.util.List;
/* loaded from: classes3.dex */
public interface ISpeechSchedue {
    List<BaseSpeechCommand> createCommands(String str);

    boolean executeSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback);

    void onNextCommand();

    void scheduleCommands(List<BaseSpeechCommand> list);
}
