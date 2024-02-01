package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
@CommandPriority(priority = 22)
/* loaded from: classes3.dex */
public class StopNaviCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("StopNaviCommand");

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        executeSpeechEvent(new SpeechNaviEvent(305));
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(1, 2);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(1, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return !TBTManager.getInstance().isExistRoute();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof StartNaviCommand) {
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }
}
