package com.xiaopeng.montecarlo.speech.command.voicefusion;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
/* loaded from: classes3.dex */
public class InfoflowCardHeightChangedCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("InfoflowCarHeiChaCom");
    private int mInfoflowCardHeight;
    private boolean mIsFinished = false;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public InfoflowCardHeightChangedCommand(String str) {
        this.mInfoflowCardHeight = 0;
        try {
            this.mInfoflowCardHeight = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(2007);
        speechNaviEvent.setInfoflowCardHeight(this.mInfoflowCardHeight);
        executeSpeechEvent(speechNaviEvent);
        this.mIsFinished = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsFinished;
    }
}
