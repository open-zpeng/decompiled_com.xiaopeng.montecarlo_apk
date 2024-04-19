package com.xiaopeng.montecarlo.root.dataprovider;

import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class BaseParameter {
    public static long DEFAULT_TIMEOUT = 35000;
    protected boolean mIsFromCache = false;
    protected long mTimeout = DEFAULT_TIMEOUT;
    protected Executor mExecutor = null;

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    public boolean isFromCached() {
        return this.mIsFromCache;
    }

    public long getTimeout() {
        return this.mTimeout;
    }

    public void setTimeout(long j) {
        this.mTimeout = j;
    }
}
