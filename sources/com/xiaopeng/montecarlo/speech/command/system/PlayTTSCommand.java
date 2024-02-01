package com.xiaopeng.montecarlo.speech.command.system;

import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
@CommandPriority(priority = 31)
@Deprecated
/* loaded from: classes3.dex */
public class PlayTTSCommand extends BaseSpeechCommand {
    private boolean mIsFinish = false;
    private String mText;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public PlayTTSCommand(String str) {
        this.mText = str;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        TTSProxy.getInstance().speak(this.mText, null);
        this.mIsFinish = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsFinish;
    }
}
