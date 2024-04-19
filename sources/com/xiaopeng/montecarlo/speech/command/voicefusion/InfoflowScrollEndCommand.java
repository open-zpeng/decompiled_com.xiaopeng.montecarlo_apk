package com.xiaopeng.montecarlo.speech.command.voicefusion;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
/* loaded from: classes3.dex */
public class InfoflowScrollEndCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("InfoflowScrollEndCommand");
    private int mFirstVisibleIndex;
    private boolean mIsFinished = false;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public InfoflowScrollEndCommand(String str) {
        try {
            this.mFirstVisibleIndex = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(2004);
        speechNaviEvent.setFirstVisibleIndex(this.mFirstVisibleIndex);
        executeSpeechEvent(speechNaviEvent);
        this.mIsFinished = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsFinished;
    }
}
