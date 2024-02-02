package com.xiaopeng.montecarlo.root.util;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class XpThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final String mNamePrefix;
    private final int mPriority;
    private final AtomicInteger mThreadNumber = new AtomicInteger(1);

    public XpThreadFactory(String str, int i) {
        str = (str == null || str.isEmpty()) ? "pool" : "pool";
        this.mNamePrefix = str + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
        this.mPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread(runnable, this.mNamePrefix + this.mThreadNumber.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i = this.mPriority;
        if (priority != i) {
            thread.setPriority(i);
        }
        return thread;
    }
}
