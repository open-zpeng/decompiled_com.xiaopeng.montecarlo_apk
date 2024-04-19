package com.xiaopeng.montecarlo.root.dataprovider;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.XpBaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public abstract class BaseDataProvider<T extends BaseResultData, P extends BaseParameter, C extends BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("BaseDataProvider");
    private C mCallBack;

    /* JADX INFO: Access modifiers changed from: protected */
    public int createTimeoutCode(int i, P p) {
        return 600;
    }

    protected boolean doFetchDataDelegate(@NonNull P p, @NonNull C c) {
        return false;
    }

    protected abstract DataProviderResponse fetchDataDelegate(P p) throws DataProviderException;

    protected abstract String getErrorMessage(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFetchComplete() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFetchError(Throwable th, P p) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFetchStart(P p) {
    }

    protected void onFetchUpdateUI(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSubscribe(Disposable disposable) {
    }

    public BaseDataProvider() {
    }

    public BaseDataProvider(C c) {
        this.mCallBack = c;
    }

    protected Observable createFetchObservable(ObservableOnSubscribe observableOnSubscribe, P p) {
        return Observable.create(observableOnSubscribe);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void getData(P p, ObservableEmitter observableEmitter) throws Exception {
        DataProviderResponse fetchDataDelegate = fetchDataDelegate(p);
        if (fetchDataDelegate == null) {
            handleError(convertException(0), observableEmitter);
        } else if (fetchDataDelegate.getErrorCode() != 0) {
            handleError(convertException(fetchDataDelegate.getErrorCode()), observableEmitter);
        } else {
            handleNext(fetchDataDelegate.getResultData(), observableEmitter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCallbackValid(C c) {
        return c != null && c.isLegal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Observable createObservable(@NonNull final P p) {
        return createFetchObservable(new ObservableOnSubscribe<T>() { // from class: com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                try {
                    BaseDataProvider.this.getData(p, observableEmitter);
                    if (p.mIsFromCache) {
                        p.mIsFromCache = false;
                        BaseDataProvider.this.getData(p, observableEmitter);
                    }
                    observableEmitter.onComplete();
                } catch (Throwable th) {
                    th.printStackTrace();
                    BaseDataProvider baseDataProvider = BaseDataProvider.this;
                    baseDataProvider.handleError(baseDataProvider.convertException(th.getMessage()), observableEmitter);
                }
            }
        }, p);
    }

    public final void doFetchData(@NonNull P p) {
        doFetchData(p, this.mCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doFetchData(@NonNull final P p, @NonNull C c) {
        Scheduler computation;
        if (doFetchDataDelegate(p, c)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(c);
        Observable observeOn = createObservable(p).observeOn(AndroidSchedulers.mainThread());
        if (p.mExecutor != null) {
            computation = Schedulers.from(p.getExecutor());
        } else {
            computation = p.mIsFromCache ? Schedulers.computation() : Schedulers.io();
        }
        observeOn.subscribeOn(computation).timeout(p.mTimeout, TimeUnit.MILLISECONDS).doOnSubscribe(new Consumer<Disposable>() { // from class: com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) throws Exception {
                BaseDataProvider.this.onFetchStart(p);
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BaseDataProvider.this.isCallbackValid(baseCallBack)) {
                    baseCallBack.onFetchStart(p);
                }
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe((Observer) new Observer<T>() { // from class: com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                onNext((AnonymousClass2) ((BaseResultData) obj));
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                BaseDataProvider.this.onSubscribe(disposable);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public void onNext(T t) {
                BaseDataProvider.this.onFetchUpdateUI(t);
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BaseDataProvider.this.isCallbackValid(baseCallBack)) {
                    baseCallBack.onDataFetched(t);
                } else if (baseCallBack != null) {
                    baseCallBack.onDataCache(t);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (th instanceof TimeoutException) {
                    BaseDataProvider.this.handleTimeoutError(th, p, (BaseCallBack) weakReference.get());
                    return;
                }
                BaseDataProvider.this.onFetchError(th, p);
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BaseDataProvider.this.isCallbackValid(baseCallBack)) {
                    if (th instanceof DataProviderException) {
                        if (baseCallBack instanceof XpBaseCallBack) {
                            ((XpBaseCallBack) baseCallBack).onError(p, ((DataProviderException) th).getErrorCode(), th.getMessage());
                            return;
                        } else {
                            baseCallBack.onError(((DataProviderException) th).getErrorCode(), th.getMessage());
                            return;
                        }
                    }
                    String message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = "unknown throwable";
                    }
                    L.w(BaseDataProvider.TAG, message);
                    if (baseCallBack instanceof XpBaseCallBack) {
                        ((XpBaseCallBack) baseCallBack).onError(p, 400, "");
                    } else {
                        baseCallBack.onError(400, "");
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public void onComplete() {
                BaseDataProvider.this.onFetchComplete();
                BaseCallBack baseCallBack = (BaseCallBack) weakReference.get();
                if (BaseDataProvider.this.isCallbackValid(baseCallBack)) {
                    baseCallBack.onFetchComplete(p);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeoutError(final Throwable th, final P p, final C c) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                BaseDataProvider.this.onFetchError(th, p);
                if (BaseDataProvider.this.isCallbackValid(c)) {
                    BaseCallBack baseCallBack = c;
                    if (baseCallBack instanceof XpBaseCallBack) {
                        BaseParameter baseParameter = p;
                        ((XpBaseCallBack) baseCallBack).onError(baseParameter, BaseDataProvider.this.createTimeoutCode(600, baseParameter), "");
                        return;
                    }
                    baseCallBack.onError(BaseDataProvider.this.createTimeoutCode(600, p), "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataProviderException convertException(int i) {
        return new DataProviderException(i, getErrorMessage(i));
    }

    protected DataProviderException convertException(String str) {
        return new DataProviderException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(@NonNull Throwable th, @NonNull ObservableEmitter observableEmitter) {
        if (observableEmitter.isDisposed()) {
            if (L.ENABLE) {
                L.d(TAG, "emitter is disposed");
                return;
            }
            return;
        }
        observableEmitter.onError(th);
    }

    private void handleNext(@NonNull T t, @NonNull ObservableEmitter observableEmitter) {
        if (observableEmitter.isDisposed()) {
            if (L.ENABLE) {
                L.d(TAG, "emitter is disposed");
                return;
            }
            return;
        }
        observableEmitter.onNext(t);
    }
}
