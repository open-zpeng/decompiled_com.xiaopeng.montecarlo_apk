package com.xiaopeng.montecarlo.navcore.account;

import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
/* loaded from: classes2.dex */
public abstract class BLAccountObserver extends DisposableObserver<AccountEvent> {
    private static final L.Tag TAG = new L.Tag("BLAccountObserver");

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
    }

    public abstract void onGetAccountResult(@NonNull AccountAosResult accountAosResult);

    @Override // io.reactivex.Observer
    public void onNext(@NonNull AccountEvent accountEvent) {
        AccountAosResult accountAosResult = accountEvent.getAccountAosResult();
        if (accountAosResult == null) {
            if (L.ENABLE) {
                L.d(TAG, "onAosAccountEvent accountAosResult is null");
                return;
            }
            return;
        }
        onGetAccountResult(accountAosResult);
    }
}
