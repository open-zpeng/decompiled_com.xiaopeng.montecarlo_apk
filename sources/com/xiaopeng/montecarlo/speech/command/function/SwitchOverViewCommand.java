package com.xiaopeng.montecarlo.speech.command.function;

import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 31)
/* loaded from: classes3.dex */
public class SwitchOverViewCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("SwitchOverViewCommand");
    private boolean mIsOpenOverview;

    public boolean isOpenOverview() {
        return this.mIsOpenOverview;
    }

    public SwitchOverViewCommand(boolean z) {
        this.mIsOpenOverview = z;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        SpeechNaviEvent speechNaviEvent;
        if (this.mIsOpenOverview) {
            speechNaviEvent = new SpeechNaviEvent(202);
        } else {
            speechNaviEvent = new SpeechNaviEvent(203);
        }
        executeSpeechEvent(speechNaviEvent);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        if (this.mIsOpenOverview) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(6, 2);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(7, 2);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        if (this.mIsOpenOverview) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(6, 3);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(7, 3);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        if (this.mIsOpenOverview) {
            return isOpenOverViewMode();
        }
        return !isOpenOverViewMode();
    }

    private boolean isOpenOverViewMode() {
        Object postRequestForResult = SpeechRequestFactory.getInstance().postRequestForResult(10011);
        L.Tag tag = TAG;
        L.i(tag, "isOpenOverViewMode " + postRequestForResult);
        if (postRequestForResult == null || !(postRequestForResult instanceof Boolean)) {
            return false;
        }
        return ((Boolean) postRequestForResult).booleanValue();
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(super.getFixContextList())) {
            arrayList.addAll(super.getFixContextList());
        }
        arrayList.add(ExitCross3DCommand.class);
        arrayList.add(EnterActiveStateCommand.class);
        return arrayList;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof SwitchOverViewCommand) {
            if (((SwitchOverViewCommand) t).isOpenOverview() == this.mIsOpenOverview) {
                return true;
            }
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }
}
