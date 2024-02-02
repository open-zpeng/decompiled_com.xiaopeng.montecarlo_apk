package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes2.dex */
public interface IQueueOwner {
    IQueueWorker current();

    String dump();

    void end();

    WorkerLevel getLevel();

    boolean hasNext();

    void next();

    void run();
}
