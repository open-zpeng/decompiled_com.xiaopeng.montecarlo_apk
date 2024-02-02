package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.utils.SpeechSettingUtil;
@CommandPriority(priority = 20)
/* loaded from: classes3.dex */
public class RouteParamCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("RouteParamCommand");
    private boolean mIsExecuted = false;
    private SpeechSettingUtil.RouteStrategy mStrategy;

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
    }

    public SpeechSettingUtil.RouteStrategy getStrategy() {
        return this.mStrategy;
    }

    public RouteParamCommand(SpeechSettingUtil.RouteStrategy routeStrategy) {
        this.mStrategy = routeStrategy;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        this.mIsExecuted = true;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuted;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if ((t instanceof RouteParamCommand) || (t instanceof RouteWithViasCommand) || (t instanceof RouteOrAddViaCommand)) {
            return true;
        }
        return super.canMergeCommand(t);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T, S extends BaseSpeechCommand> S mergeCommand(T t) {
        if (t instanceof RouteParamCommand) {
            this.mStrategy = SpeechSettingUtil.mergeStrategy(this.mStrategy, ((RouteParamCommand) t).getStrategy());
            return this;
        } else if (t instanceof RouteOrAddViaCommand) {
            return (S) ((RouteOrAddViaCommand) t).mergeCommand(this);
        } else {
            return t instanceof RouteWithViasCommand ? (S) ((RouteWithViasCommand) t).mergeCommand(this) : this;
        }
    }
}
