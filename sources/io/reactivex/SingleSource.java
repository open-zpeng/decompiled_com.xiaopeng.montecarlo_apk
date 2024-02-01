package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes3.dex */
public interface SingleSource<T> {
    void subscribe(@NonNull SingleObserver<? super T> singleObserver);
}
