package com.xiaopeng.montecarlo.lifecycle;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public abstract class Lifecycle {
    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    /* loaded from: classes.dex */
    public enum Event {
        ON_ANY,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_DESTROY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dispatch(LifecycleOwner lifecycleOwner, LifecycleObserver lifecycleObserver) {
            if (this == ON_CREATE) {
                lifecycleObserver.onCreate(lifecycleOwner);
            } else if (this == ON_RESUME) {
                lifecycleObserver.onResume(lifecycleOwner);
            } else if (this == ON_PAUSE) {
                lifecycleObserver.onPause(lifecycleOwner);
            } else if (this == ON_DESTROY) {
                lifecycleObserver.onDestroy(lifecycleOwner);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public State toState() {
            return State.values()[ordinal()];
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        INITIALIZED,
        CREATED,
        RESUMED,
        PAUSED,
        DESTROYED;

        public boolean isAtLeast(@NonNull State state) {
            return ordinal() >= state.ordinal();
        }

        public boolean isLess(@NonNull State state) {
            return ordinal() < state.ordinal();
        }
    }
}
