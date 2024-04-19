package com.xiaopeng.montecarlo.speech.command.function;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
@CommandPriority(priority = 31)
/* loaded from: classes3.dex */
public class SwitchToSlideRoadCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SwitchToSlideRoadCommand");
    private boolean mIsExecuted = false;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        executeSpeechEvent(new SpeechNaviEvent(SpeechNaviEvent.SPEECH_CMD_CONTROL_SWITCH_TO_SLID_ROAD));
        this.mIsExecuted = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuted;
    }
}
