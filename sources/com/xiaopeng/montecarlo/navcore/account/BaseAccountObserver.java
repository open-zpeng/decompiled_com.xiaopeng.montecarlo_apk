package com.xiaopeng.montecarlo.navcore.account;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
/* loaded from: classes2.dex */
public abstract class BaseAccountObserver<T> extends DisposableObserver<T> {
    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
    }

    public abstract void onSuccess(@NonNull T t);

    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        onSuccess(t);
        dispose();
    }
}
