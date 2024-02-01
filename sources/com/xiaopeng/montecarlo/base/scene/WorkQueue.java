package com.xiaopeng.montecarlo.base.scene;

import android.os.SystemClock;
import com.xiaopeng.montecarlo.lifecycle.Lifecycle;
import com.xiaopeng.montecarlo.lifecycle.LifecycleObserver;
import com.xiaopeng.montecarlo.lifecycle.LifecycleOwner;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class WorkQueue {
    private final XPHandler mHandler;
    private final LifecycleOwner mLifecycleOwner;
    private ArrayList<IQueueWorker> mPendingActions;
    private final L.Tag mTag;
    private Runnable mRunCommit = new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.WorkQueue.1
        @Override // java.lang.Runnable
        public void run() {
            WorkQueue.this.execPendingActions();
        }
    };
    private IQueueOwner mQueueOwner = new IQueueOwner() { // from class: com.xiaopeng.montecarlo.base.scene.WorkQueue.2
        IQueueWorker mTmpActions;
        WorkerLevel mWorkerLevel = WorkerLevel.EMPTY;

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public IQueueWorker current() {
            return this.mTmpActions;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public WorkerLevel getLevel() {
            return this.mWorkerLevel;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public void end() {
            this.mTmpActions = null;
            this.mWorkerLevel = WorkerLevel.EMPTY;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public void next() {
            if (this.mTmpActions == null) {
                this.mTmpActions = (IQueueWorker) WorkQueue.this.mPendingActions.remove(0);
                this.mWorkerLevel = WorkerLevel.START;
            }
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public void run() {
            this.mWorkerLevel = WorkerLevel.RUN;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public boolean hasNext() {
            return WorkQueue.this.mPendingActions != null && WorkQueue.this.mPendingActions.size() > 0;
        }

        @Override // com.xiaopeng.montecarlo.base.scene.IQueueOwner
        public String dump() {
            StringBuilder sb = new StringBuilder();
            sb.append("QueueOwner:{");
            sb.append("current:{");
            IQueueWorker iQueueWorker = this.mTmpActions;
            sb.append(iQueueWorker != null ? iQueueWorker.dump() : "null");
            sb.append("},");
            sb.append("WorkerLevel:{");
            sb.append(this.mWorkerLevel.name());
            sb.append("},");
            sb.append("},");
            return sb.toString();
        }
    };
    private final LifecycleObserver mLifecycleObserver = new LifecycleObserver() { // from class: com.xiaopeng.montecarlo.base.scene.WorkQueue.3
        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onCreate(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onPause(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            WorkQueue.this.mHandler.removeCallbacksAndMessages(WorkQueue.this);
        }
    };

    /* loaded from: classes.dex */
    class EndRunnable implements Runnable {
        IQueueWorker mWorker;

        EndRunnable(IQueueWorker iQueueWorker) {
            this.mWorker = iQueueWorker;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WorkQueue.this.mQueueOwner.current() == this.mWorker && WorkQueue.this.mQueueOwner.getLevel() == WorkerLevel.RUN) {
                WorkQueue.this.mQueueOwner.end();
            }
            if (WorkQueue.this.mQueueOwner.hasNext()) {
                WorkQueue.this.mQueueOwner.next();
                WorkQueue.this.mHandler.postAtTime(WorkQueue.this.mRunCommit, this, SystemClock.uptimeMillis());
            }
        }
    }

    public WorkQueue(LifecycleOwner lifecycleOwner, XPHandler xPHandler) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLifecycleOwner.getSceneLifecycle().addObserver(this.mLifecycleObserver);
        this.mHandler = xPHandler;
        this.mTag = new L.Tag(lifecycleOwner.getClass().getSimpleName() + "_WorkQueue");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execPendingActions() {
        this.mHandler.removeCallbacks(this.mRunCommit);
        IQueueWorker current = this.mQueueOwner.current();
        if (current != null) {
            if (this.mQueueOwner.getLevel() == WorkerLevel.START) {
                current.run();
                this.mQueueOwner.run();
            } else if (this.mQueueOwner.getLevel() == WorkerLevel.RUN) {
                this.mQueueOwner.end();
            }
        } else if (this.mQueueOwner.hasNext()) {
            this.mQueueOwner.next();
            this.mHandler.postAtTime(this.mRunCommit, this, SystemClock.uptimeMillis());
        }
    }

    public void enqueueWorker(IQueueWorker iQueueWorker) {
        L.Tag tag = this.mTag;
        L.i(tag, "enqueueWorker:" + iQueueWorker.getClass().getSimpleName());
        if (this.mLifecycleOwner.getSceneLifecycle().getCurrentState().isAtLeast(Lifecycle.State.PAUSED)) {
            return;
        }
        if (this.mPendingActions == null) {
            this.mPendingActions = new ArrayList<>();
        }
        this.mPendingActions.add(iQueueWorker);
        if (this.mPendingActions.size() == 1 && this.mQueueOwner.current() == null) {
            this.mHandler.removeCallbacks(this.mRunCommit);
            this.mHandler.postAtTime(this.mRunCommit, this, SystemClock.uptimeMillis());
        }
    }

    public void endWorker(IQueueWorker iQueueWorker) {
        L.Tag tag = this.mTag;
        L.i(tag, "endWorker:" + iQueueWorker.getClass().getSimpleName());
        if (this.mPendingActions != null) {
            this.mHandler.postAtTime(new EndRunnable(iQueueWorker), this, SystemClock.uptimeMillis());
        }
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkQueue:{");
        if (this.mPendingActions == null) {
            sb.append("Empty");
        } else {
            sb.append("mQueueOwner:{");
            sb.append(this.mQueueOwner.dump());
            sb.append("},");
            sb.append("mPendingActions:{");
            Iterator<IQueueWorker> it = this.mPendingActions.iterator();
            while (it.hasNext()) {
                sb.append("worker:");
                sb.append(it.next().dump());
                sb.append("},");
            }
            sb.append("},");
        }
        sb.append("},");
        return sb.toString();
    }
}
