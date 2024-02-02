package com.xiaopeng.montecarlo.account;

import android.os.Looper;
/* loaded from: classes2.dex */
public interface IThreadOperation {
    Looper getLooper();

    void interruptThread();

    boolean isThreadInterrupted();

    void resumeThread();
}
