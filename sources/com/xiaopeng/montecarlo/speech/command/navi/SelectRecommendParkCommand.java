package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
@CommandPriority(priority = 22)
/* loaded from: classes3.dex */
public class SelectRecommendParkCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SelectRecommentParkCommand");
    private int mIndex;
    private boolean mIsExecuted;

    public SelectRecommendParkCommand(int i) {
        this.mIsExecuted = false;
        if (NaviSpeechUtils.isSelectRecommendParkEnable(i)) {
            this.mIndex = i - 1;
        } else {
            this.mIndex = 0;
        }
    }

    public SelectRecommendParkCommand() {
        this.mIsExecuted = false;
        this.mIndex = 0;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        NaviSpeechUtils.selectRecommendParking(this.mIndex);
        this.mIsExecuted = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(32, 2);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(32, 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuted;
    }
}
