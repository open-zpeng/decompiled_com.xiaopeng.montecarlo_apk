package com.xiaopeng.montecarlo.navcore.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Deque<AsyncCall> mReadyAsyncCalls = new ArrayDeque();
    private final Deque<AsyncCall> mRunningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> mRunningSyncCalls = new ArrayDeque();
    private int mMaxRequests = 64;
    private int mMaxRequestsPerRequestType = 10;

    public void enqueue(AsyncCall asyncCall) {
        synchronized (this) {
            this.mReadyAsyncCalls.add(asyncCall);
        }
        promoteAndExecute();
    }

    public XPSearchResult execute(RealCall realCall) {
        synchronized (this) {
            this.mRunningSyncCalls.add(realCall);
        }
        try {
            try {
                return realCall.executeOn();
            } catch (Exception e) {
                e.printStackTrace();
                finished(realCall);
                return null;
            }
        } finally {
            finished(realCall);
        }
    }

    private void promoteAndExecute() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<AsyncCall> it = this.mReadyAsyncCalls.iterator();
            while (it.hasNext()) {
                AsyncCall next = it.next();
                if (this.mRunningAsyncCalls.size() >= this.mMaxRequests) {
                    break;
                } else if (runningCallsPerRequestType(next) < this.mMaxRequestsPerRequestType) {
                    it.remove();
                    arrayList.add(next);
                    this.mRunningAsyncCalls.add(next);
                }
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AsyncCall) arrayList.get(i)).execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finished(AsyncCall asyncCall) {
        finished(this.mRunningAsyncCalls, asyncCall);
    }

    protected void finished(RealCall realCall) {
        finished(this.mRunningSyncCalls, realCall);
    }

    private <T> void finished(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        promoteAndExecute();
    }

    private int runningCallsPerRequestType(AsyncCall asyncCall) {
        int i = 0;
        if (asyncCall.getRequest() == null) {
            return 0;
        }
        int requestType = asyncCall.getRequest().getRequestType();
        for (AsyncCall asyncCall2 : this.mRunningAsyncCalls) {
            if (asyncCall2.getRequest() != null && asyncCall2.getRequest().getRequestType() == requestType) {
                i++;
            }
        }
        return i;
    }
}
