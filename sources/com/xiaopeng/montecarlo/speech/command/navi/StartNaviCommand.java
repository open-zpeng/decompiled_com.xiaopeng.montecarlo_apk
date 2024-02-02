package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
@CommandPriority(priority = 22)
/* loaded from: classes3.dex */
public class StartNaviCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("StartNaviCommand");
    private int mIndex;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public int getIndex() {
        return this.mIndex;
    }

    public StartNaviCommand(int i) {
        this.mIndex = 0;
        if (NaviSpeechUtils.isStartNaviEnable(i)) {
            this.mIndex = i;
        } else {
            this.mIndex = NaviSpeechUtils.getPathIndex();
        }
    }

    public StartNaviCommand() {
        this.mIndex = 0;
        this.mIndex = NaviSpeechUtils.getPathIndex();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(304);
        speechNaviEvent.setIndex(this.mIndex);
        executeSpeechEvent(speechNaviEvent);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return TBTManager.getInstance().getCurrentStatus() == 1;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof StopNaviCommand) {
            throw new MergeException();
        }
        if (t instanceof StartNaviCommand) {
            if (((StartNaviCommand) t).getIndex() == this.mIndex) {
                return true;
            }
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }
}
