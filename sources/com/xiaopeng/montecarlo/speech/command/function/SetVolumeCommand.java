package com.xiaopeng.montecarlo.speech.command.function;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import com.xiaopeng.montecarlo.util.AudioUtil;
@CommandPriority(priority = 31)
@Deprecated
/* loaded from: classes3.dex */
public class SetVolumeCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SetVolumeCommand");
    private boolean mIsOpenVolume;

    public boolean isOpenVolume() {
        return this.mIsOpenVolume;
    }

    public SetVolumeCommand(boolean z) {
        this.mIsOpenVolume = z;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent;
        if (this.mIsOpenVolume) {
            speechNaviEvent = new SpeechNaviEvent(402);
        } else {
            speechNaviEvent = new SpeechNaviEvent(401);
        }
        executeSpeechEvent(speechNaviEvent);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        if (this.mIsOpenVolume) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(29, 2);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(30, 2);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        if (this.mIsOpenVolume) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(29, 3);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(30, 3);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        if (this.mIsOpenVolume) {
            return !AudioUtil.getInstance().isMute();
        }
        return AudioUtil.getInstance().isMute();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof SetVolumeCommand) {
            if (((SetVolumeCommand) t).isOpenVolume() == this.mIsOpenVolume) {
                return true;
            }
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }
}
