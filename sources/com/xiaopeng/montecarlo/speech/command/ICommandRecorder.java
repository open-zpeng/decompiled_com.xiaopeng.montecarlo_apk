package com.xiaopeng.montecarlo.speech.command;
/* loaded from: classes3.dex */
public interface ICommandRecorder {
    void doSomething();

    boolean isAchieveGoals();

    boolean isInterrupted();

    void noNeedToExecute();

    void onFailed();

    void onFinish();

    void onInterrupt();

    void onSuccess();

    void onTimeOut();
}
