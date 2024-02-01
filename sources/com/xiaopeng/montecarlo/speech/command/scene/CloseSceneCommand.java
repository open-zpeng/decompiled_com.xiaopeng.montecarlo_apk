package com.xiaopeng.montecarlo.speech.command.scene;

import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
@CommandPriority(priority = 51)
/* loaded from: classes3.dex */
public class CloseSceneCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("CloseSceneCommand");
    private boolean mIsExecute = false;
    private StatusConst.Mode mMode;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public StatusConst.Mode getMode() {
        return this.mMode;
    }

    public CloseSceneCommand(StatusConst.Mode mode) {
        this.mMode = mode;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(905);
        speechNaviEvent.setSceneMode(this.mMode.ordinal());
        executeSpeechEvent(speechNaviEvent);
        this.mIsExecute = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecute;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if ((t instanceof OpenSceneCommand) && ((OpenSceneCommand) t).getMode() == this.mMode) {
            throw new MergeException();
        }
        if (t instanceof CloseSceneCommand) {
            return ((CloseSceneCommand) t).getMode() == this.mMode;
        }
        return super.canMergeCommand(t);
    }
}
