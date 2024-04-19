package com.xiaopeng.montecarlo.root.account;

import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class AccountSyncHandlerThread extends HandlerThread {
    public static final int TYPE_ACCOUNT = 0;
    public static final int TYPE_GUEST = 1;
    public static final int TYPE_INCREMENT = 2;
    private final boolean[] mInterrupted;

    public AccountSyncHandlerThread(String str) {
        super(str);
        this.mInterrupted = new boolean[]{false, false, false};
    }

    public synchronized boolean isThreadInterrupted(int i) {
        return this.mInterrupted[i];
    }

    public synchronized void interruptThread(int i) {
        this.mInterrupted[i] = true;
    }

    public synchronized void resumeThread(int i) {
        this.mInterrupted[i] = false;
    }
}
