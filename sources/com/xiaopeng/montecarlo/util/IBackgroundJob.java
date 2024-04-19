package com.xiaopeng.montecarlo.util;
/* loaded from: classes3.dex */
public interface IBackgroundJob {
    boolean onExecute();

    void onFailure();

    void onRetry(int i);

    void onSuccess();
}
