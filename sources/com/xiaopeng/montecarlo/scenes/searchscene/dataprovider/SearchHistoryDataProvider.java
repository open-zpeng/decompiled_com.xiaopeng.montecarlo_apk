package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.account.CompositeRxAction;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class SearchHistoryDataProvider {
    private static final L.Tag TAG = new L.Tag("SearchHistoryDataProvider");
    private List<String> mHisPoiIdList;
    private long mHisRecordUpdateTime;
    private long mHistoryShowTime;
    SearchPresenter mSearchPresenter;
    private boolean mNeedCorrectTime = true;
    CompositeRxAction mRxAction = new CompositeRxAction();
    AtomicInteger mPendingRequestCount = new AtomicInteger(0);

    public SearchHistoryDataProvider(@NonNull SearchPresenter searchPresenter) {
        this.mSearchPresenter = searchPresenter;
    }

    public synchronized void delayRequestHistoryList(final int i, int i2, @NonNull final BaseCallBack<SearchRequestParam, SearchResultData> baseCallBack) {
        Observable create;
        this.mPendingRequestCount.incrementAndGet();
        if (i2 > 0) {
            create = Observable.timer(i2, TimeUnit.MILLISECONDS, Schedulers.single()).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.-$$Lambda$SearchHistoryDataProvider$L8NBL6JHKxrrDIlsyuvKfmJWm2w
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SearchHistoryDataProvider.this.lambda$delayRequestHistoryList$1$SearchHistoryDataProvider(i, (Long) obj);
                }
            });
        } else {
            create = Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.-$$Lambda$SearchHistoryDataProvider$gQH51YWN9Gx_htXGwT44XV-mTt0
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    SearchHistoryDataProvider.this.lambda$delayRequestHistoryList$2$SearchHistoryDataProvider(i, observableEmitter);
                }
            });
        }
        this.mRxAction.addSubscription(create.compose(applySchedulers()), new DisposableObserver<SearchResultData>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchHistoryDataProvider.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(@NonNull SearchResultData searchResultData) {
                SearchHistoryDataProvider.this.onRequestSuccess(searchResultData, baseCallBack);
                SearchHistoryDataProvider.this.mPendingRequestCount.decrementAndGet();
            }

            @Override // io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                SearchHistoryDataProvider.this.onRequestFailed(th, baseCallBack);
                SearchHistoryDataProvider.this.mPendingRequestCount.decrementAndGet();
            }
        });
    }

    public /* synthetic */ ObservableSource lambda$delayRequestHistoryList$1$SearchHistoryDataProvider(final int i, Long l) throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.-$$Lambda$SearchHistoryDataProvider$8YauQlanmRxZAsPN-WAFKNhkLWw
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SearchHistoryDataProvider.this.lambda$null$0$SearchHistoryDataProvider(i, observableEmitter);
            }
        });
    }

    public void requestHistoryList(int i, @NonNull BaseCallBack<SearchRequestParam, SearchResultData> baseCallBack) {
        delayRequestHistoryList(i, 0, baseCallBack);
    }

    public boolean hasPendingRequest() {
        return this.mPendingRequestCount.get() > 0;
    }

    public synchronized void resetHisRecordRequest() {
        L.i(TAG, "resetHisRecordRequest");
        this.mRxAction.unSubscribe();
        this.mPendingRequestCount.set(0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mHistoryShowTime = currentTimeMillis;
        this.mHisRecordUpdateTime = currentTimeMillis;
        if (this.mHisPoiIdList != null) {
            this.mHisPoiIdList.clear();
        }
        this.mNeedCorrectTime = true;
    }

    public void updateParamByList(final List<HistoryRecordInfo> list) {
        this.mRxAction.addSubscription(Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.-$$Lambda$SearchHistoryDataProvider$tio9E2oYhIWxJgVgWAtuX7f8H94
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SearchHistoryDataProvider.this.lambda$updateParamByList$3$SearchHistoryDataProvider(list, observableEmitter);
            }
        }).compose(applySchedulers()).subscribe());
    }

    public /* synthetic */ void lambda$updateParamByList$3$SearchHistoryDataProvider(List list, ObservableEmitter observableEmitter) throws Exception {
        if (!CollectionUtils.isEmpty(list)) {
            HistoryRecordInfo historyRecordInfo = (HistoryRecordInfo) list.get(list.size() - 1);
            this.mHisRecordUpdateTime = historyRecordInfo.getCreateTime();
            this.mHisPoiIdList = getHisPoiIdList(list, historyRecordInfo);
            this.mNeedCorrectTime = false;
        }
        observableEmitter.onNext(true);
        observableEmitter.onComplete();
    }

    private void updateParamByRequestResult(@NonNull SearchResultData searchResultData) {
        this.mHistoryShowTime = searchResultData.getMaxRecordTime();
        List<HistoryRecordInfo> historyList = searchResultData.getHistoryList();
        if (!CollectionUtils.isEmpty(historyList)) {
            HistoryRecordInfo historyRecordInfo = historyList.get(historyList.size() - 1);
            this.mHisRecordUpdateTime = historyRecordInfo.getCreateTime();
            this.mHisPoiIdList = getHisPoiIdList(historyList, historyRecordInfo);
        }
        this.mNeedCorrectTime = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: executeHistoryListRequest */
    public void lambda$null$0$SearchHistoryDataProvider(int i, @NonNull ObservableEmitter<SearchResultData> observableEmitter) {
        try {
            SearchResultData innerRequestHistoryList = innerRequestHistoryList(this.mSearchPresenter.getSearchMode(), this.mSearchPresenter.getSearchDest(), i);
            updateParamByRequestResult(innerRequestHistoryList);
            observableEmitter.onNext(innerRequestHistoryList);
            observableEmitter.onComplete();
        } catch (Exception e) {
            e.printStackTrace();
            observableEmitter.onError(e);
        }
    }

    @NonNull
    private SearchResultData innerRequestHistoryList(int i, int i2, int i3) {
        L.Tag tag = TAG;
        L.i(tag, "innerRequestHistoryList pageSize:" + i3);
        SearchHistoryParam searchHistoryParam = new SearchHistoryParam();
        searchHistoryParam.setSearchType(1);
        searchHistoryParam.setShowTime(this.mHistoryShowTime);
        searchHistoryParam.setUpdateTime(this.mHisRecordUpdateTime);
        searchHistoryParam.setPoiIdList(this.mHisPoiIdList);
        searchHistoryParam.setSearchMode(i);
        searchHistoryParam.setSearchDest(i2);
        searchHistoryParam.setPageSize(i3);
        searchHistoryParam.setLoad(i3 != 1);
        searchHistoryParam.setLocation(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
        return getHistoryRecord(searchHistoryParam);
    }

    @NonNull
    private SearchResultData getHistoryRecord(SearchRequestParam searchRequestParam) {
        long showTime = searchRequestParam.getShowTime();
        long updateTime = searchRequestParam.getUpdateTime();
        if (this.mNeedCorrectTime) {
            long[] maxHistoryTime = FavoriteDataManager.getInstance().getMaxHistoryTime();
            if (maxHistoryTime[0] > showTime) {
                showTime = maxHistoryTime[0];
            }
            if (maxHistoryTime[1] > updateTime) {
                updateTime = maxHistoryTime[1];
            }
        }
        List<HistoryRecordInfo> lastestHistoryRecords = FavoriteDataManager.getInstance().getLastestHistoryRecords(showTime, updateTime, searchRequestParam.getPoiIdList(), searchRequestParam.getPageSize(), 100 == searchRequestParam.getSearchMode() && 1000 == searchRequestParam.getSearchDest());
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.mHistoryList = lastestHistoryRecords;
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        searchResultData.mMaxRecordTime = showTime;
        searchResultData.setFromCached(true);
        searchResultData.mIsLoad = searchRequestParam.isLoad();
        if (L.ENABLE) {
            L.d(TAG, GsonUtil.toJson(lastestHistoryRecords));
        }
        return searchResultData;
    }

    private List<String> getHisPoiIdList(List<HistoryRecordInfo> list, HistoryRecordInfo historyRecordInfo) {
        if (!CollectionUtils.isNotEmpty(list) || historyRecordInfo == null) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            HistoryRecordInfo historyRecordInfo2 = list.get(i);
            if (historyRecordInfo2 != null && historyRecordInfo2.getCreateTime() == historyRecordInfo.getCreateTime()) {
                arrayList.add(historyRecordInfo2.getXPPoiInfo().getPoiId());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestSuccess(@NonNull SearchResultData searchResultData, @NonNull BaseCallBack<SearchRequestParam, SearchResultData> baseCallBack) {
        if (baseCallBack.isLegal()) {
            baseCallBack.onDataFetched(searchResultData);
        } else {
            baseCallBack.onDataCache(searchResultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestFailed(@NonNull Throwable th, @NonNull BaseCallBack<SearchRequestParam, SearchResultData> baseCallBack) {
        baseCallBack.onError(400, th.getMessage());
    }

    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.-$$Lambda$SearchHistoryDataProvider$SRB05r2zezq4U38jDWQIHWeo55Q
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                ObservableSource observeOn;
                observeOn = observable.subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread());
                return observeOn;
            }
        };
    }
}
