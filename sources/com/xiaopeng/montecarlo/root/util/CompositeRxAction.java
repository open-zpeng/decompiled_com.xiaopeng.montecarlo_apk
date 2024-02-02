package com.xiaopeng.montecarlo.root.util;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
/* loaded from: classes2.dex */
public class CompositeRxAction {
    protected CompositeDisposable mComposite;

    public synchronized <T> void addSubscription(Observable<T> observable, DisposableObserver<T> disposableObserver) {
        if (this.mComposite == null) {
            this.mComposite = new CompositeDisposable();
        }
        this.mComposite.add((Disposable) observable.subscribeWith(disposableObserver));
    }

    public synchronized void addSubscription(@NonNull Disposable disposable) {
        if (this.mComposite == null) {
            this.mComposite = new CompositeDisposable();
        }
        this.mComposite.add(disposable);
    }

    public synchronized void remove(@NonNull Disposable disposable) {
        if (this.mComposite != null) {
            this.mComposite.remove(disposable);
        }
    }

    public synchronized void unSubscribe() {
        if (this.mComposite != null && !this.mComposite.isDisposed()) {
            this.mComposite.clear();
        }
        this.mComposite = null;
    }
}
