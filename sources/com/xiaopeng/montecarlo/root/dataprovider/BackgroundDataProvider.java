package com.xiaopeng.montecarlo.root.dataprovider;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public abstract class BackgroundDataProvider<T extends BaseResultData, P extends BaseParameter, C extends BaseCallBack> extends BaseDataProvider<T, P, C> {
    private static final L.Tag TAG = new L.Tag("BackgroundDataProvider");
    private boolean mIsSync;

    protected abstract void addRef(P p);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: delRef */
    public abstract void lambda$doFetchDataDelegate$1$BackgroundDataProvider(P p);

    public boolean isSync() {
        return this.mIsSync;
    }

    public void setSync(boolean z) {
        this.mIsSync = z;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected boolean doFetchDataDelegate(@NonNull final P p, @NonNull C c) {
        Scheduler computation;
        final WeakReference weakReference = new WeakReference(c);
        Observable createObservable = createObservable(p);
        if (p.mExecutor != null) {
            computation = Schedulers.from(p.getExecutor());
        } else if (this.mIsSync) {
            computation = Schedulers.trampoline();
        } else {
            computation = p.mIsFromCache ? Schedulers.computation() : Schedulers.io();
        }
        createObservable.subscribeOn(computation).timeout(p.mTimeout, TimeUnit.MILLISECONDS).doOnSubscribe(new Consumer() { // from class: com.xiaopeng.montecarlo.root.dataprovider.-$$Lambda$BackgroundDataProvider$NMeoexGOI2q0o8fsiqvgINKyHKg
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BackgroundDataProvider.this.lambda$doFetchDataDelegate$0$BackgroundDataProvider(p, obj);
            }
        }).doFinally(new Action() { // from class: com.xiaopeng.montecarlo.root.dataprovider.-$$Lambda$BackgroundDataProvider$YrLt2aTOX2_hbohazym3GFQRrTk
            @Override // io.reactivex.functions.Action
            public final void run() {
                BackgroundDataProvider.this.lambda$doFetchDataDelegate$1$BackgroundDataProvider(p);
            }
        }).subscribe((Observer) new Observer<T>() { // from class: com.xiaopeng.montecarlo.root.dataprovider.BackgroundDataProvider.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                onNext((AnonymousClass1) ((BaseResultData) obj));
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                BackgroundDataProvider.this.onSubscribe(disposable);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public void onNext(T t) {
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BackgroundDataProvider.this.isCallbackValid(baseCallBack)) {
                    baseCallBack.onDataFetched(t);
                } else if (baseCallBack != null) {
                    baseCallBack.onDataCache(t);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                BackgroundDataProvider.this.onFetchError(th, p);
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BackgroundDataProvider.this.isCallbackValid(baseCallBack)) {
                    if (th instanceof TimeoutException) {
                        baseCallBack.onError(BackgroundDataProvider.this.createTimeoutCode(600, p), "");
                    } else if (th instanceof DataProviderException) {
                        baseCallBack.onError(((DataProviderException) th).getErrorCode(), th.getMessage());
                    } else {
                        String message = th.getMessage();
                        baseCallBack.onError(400, TextUtils.isEmpty(message) ? "unknown throwable" : message);
                        L.w(BackgroundDataProvider.TAG, message);
                    }
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                BackgroundDataProvider.this.onFetchComplete();
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$doFetchDataDelegate$0$BackgroundDataProvider(@NonNull BaseParameter baseParameter, Object obj) throws Exception {
        addRef(baseParameter);
    }
}
