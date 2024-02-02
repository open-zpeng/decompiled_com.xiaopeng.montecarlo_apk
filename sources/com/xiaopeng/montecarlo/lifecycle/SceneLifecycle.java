package com.xiaopeng.montecarlo.lifecycle;

import com.xiaopeng.montecarlo.lifecycle.Lifecycle;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class SceneLifecycle extends Lifecycle {
    Lifecycle.State mState = Lifecycle.State.INITIALIZED;
    List<LifecycleObserver> mObservers = new CopyOnWriteArrayList();

    public void handlerDispatch(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.mState = event.toState();
        for (LifecycleObserver lifecycleObserver : this.mObservers) {
            event.dispatch(lifecycleOwner, lifecycleObserver);
        }
    }

    public void removeAllObserver() {
        this.mObservers.clear();
    }

    @Override // com.xiaopeng.montecarlo.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        CollectionUtils.listAdd(this.mObservers, lifecycleObserver);
    }

    @Override // com.xiaopeng.montecarlo.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    @Override // com.xiaopeng.montecarlo.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.mObservers.remove(lifecycleObserver);
    }
}
