package com.xiaopeng.montecarlo.navcore.account;
/* loaded from: classes2.dex */
public interface ICallback<T, K> {
    void onFail(K k);

    void onSuccess(T t);
}
