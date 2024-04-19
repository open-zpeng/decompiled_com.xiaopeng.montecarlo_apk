package com.xiaopeng.montecarlo.speech.command.voicefusion;

import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.command.function.EnterActiveStateCommand;
import com.xiaopeng.montecarlo.speech.command.navi.lane.ExitSrOrLaneModeCommand;
import com.xiaopeng.montecarlo.util.SRUtil;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 51)
/* loaded from: classes3.dex */
public class VoiceSearchFusionDataFetchedCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("VoiceSearchFusionDataFetchedCommand");
    private boolean mIsExecuted = false;
    private String mVoiceSearchData;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public VoiceSearchFusionDataFetchedCommand(String str) {
        this.mVoiceSearchData = str;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        if (L.ENABLE) {
            L.d(TAG, "doSomething");
        }
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(2002);
        speechNaviEvent.setVoiceSearchData(this.mVoiceSearchData);
        executeSpeechEvent(speechNaviEvent);
        this.mIsExecuted = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuted && StatusConst.Mode.SEARCH_RESULT.name().equals(getCurrentTopMode(true));
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EnterActiveStateCommand.class);
        if (SRUtil.isLaneMode()) {
            if (L.ENABLE) {
                L.d(TAG, "getFixContextList add ExitSrOrLaneModeCommand to fix list");
            }
            arrayList.add(ExitSrOrLaneModeCommand.class);
        }
        return arrayList;
    }
}
