package com.xiaopeng.montecarlo.speech.command.voicefusion;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
/* loaded from: classes3.dex */
public class ItemFocusedCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("ItemFocusedCommand");
    private int mFocusIndex;
    private boolean mIsFinished = false;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public ItemFocusedCommand(String str) {
        try {
            this.mFocusIndex = Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(2003);
        speechNaviEvent.setFocusIndex(this.mFocusIndex);
        executeSpeechEvent(speechNaviEvent);
        this.mIsFinished = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsFinished;
    }
}
