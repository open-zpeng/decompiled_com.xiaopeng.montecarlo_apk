package com.xiaopeng.montecarlo.action.schedule;

import com.xiaopeng.montecarlo.action.IIntentActionContext;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class IntentTaskScheduler {
    private static final L.Tag TAG = new L.Tag("IntentTaskScheduler");
    private final BlockingQueue<IntentTask> mQueue = new LinkedBlockingQueue();
    private boolean mIsDestroy = false;
    private boolean mIsCustomerRun = false;

    public void executeTaskCustomer(final IIntentActionContext iIntentActionContext) {
        L.i(TAG, "executeTaskCustomer ");
        if (this.mIsCustomerRun) {
            return;
        }
        this.mIsCustomerRun = true;
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.action.schedule.-$$Lambda$IntentTaskScheduler$Xm1jkWRUsGxCbk13jr8gBN91iF0
            @Override // java.lang.Runnable
            public final void run() {
                IntentTaskScheduler.this.lambda$executeTaskCustomer$0$IntentTaskScheduler(iIntentActionContext);
            }
        });
    }

    public void executeTaskProduct(IntentTask intentTask) {
        L.Tag tag = TAG;
        L.i(tag, "executeTaskProduct : intentTask: " + intentTask.getName());
        try {
            this.mQueue.put(intentTask);
        } catch (InterruptedException e) {
            L.printStackTrace(TAG, e);
        }
    }

    /* renamed from: consumeUntilDestroy */
    public void lambda$executeTaskCustomer$0$IntentTaskScheduler(final IIntentActionContext iIntentActionContext) {
        final IntentTask take;
        while (!this.mIsDestroy) {
            try {
                take = this.mQueue.take();
                L.Tag tag = TAG;
                L.i(tag, "consume task: " + take.getName() + ", mIsDestroy=" + this.mIsDestroy);
            } catch (InterruptedException e) {
                L.printStackTrace(TAG, e);
            }
            if (this.mIsDestroy) {
                return;
            }
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.action.schedule.-$$Lambda$IntentTaskScheduler$n-dE0rXoYnCwvDhax02xX_ioUvM
                @Override // java.lang.Runnable
                public final void run() {
                    IntentTask.this.run(iIntentActionContext);
                }
            });
        }
    }

    public void destroy() {
        L.i(TAG, "destroy");
        this.mIsDestroy = true;
        this.mQueue.clear();
    }
}
