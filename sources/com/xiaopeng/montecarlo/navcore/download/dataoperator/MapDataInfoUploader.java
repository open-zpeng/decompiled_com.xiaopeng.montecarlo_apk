package com.xiaopeng.montecarlo.navcore.download.dataoperator;

import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.CityRecordBean;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IMapDataService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.MapDataRequest;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.CompositeRxAction;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class MapDataInfoUploader {
    private static final L.Tag TAG = new L.Tag("tMapDataInfoUploader");
    private final MapDataOperator mMapDataOperator;
    private final IMapDataService mNaviChargeService = (IMapDataService) HttpClientManager.getInstance().getService(IMapDataService.class);
    CompositeRxAction mRxAction = new CompositeRxAction();

    public MapDataInfoUploader(@NonNull MapDataOperator mapDataOperator) {
        this.mMapDataOperator = mapDataOperator;
    }

    public void uploadCityVisitInfo() {
        List<CityRecordBean> mapDataRecordListDescByRecordCount = this.mMapDataOperator.getMapDataRecordListDescByRecordCount();
        if (mapDataRecordListDescByRecordCount.isEmpty()) {
            return;
        }
        if (L.ENABLE) {
            Iterator<CityRecordBean> it = mapDataRecordListDescByRecordCount.iterator();
            while (it.hasNext()) {
                L.Tag tag = TAG;
                L.d(tag, "uploadCityVisitInfo bean:" + GsonUtil.toJson(it.next()));
            }
        }
        if (mapDataRecordListDescByRecordCount.size() > 2) {
            mapDataRecordListDescByRecordCount = mapDataRecordListDescByRecordCount.subList(0, 2);
        }
        DataLogUtil.sendStatData(TBTManager.getInstance().isInNaviMode() ? PageType.NAVI_GUIDANCE : PageType.NAVI_CRUISE, BtnType.MAP_DATA_UPLOAD, mapDataRecordListDescByRecordCount);
    }

    public void uploadMapDataInfo(final List<CityRecordBean> list) {
        this.mRxAction.unSubscribe();
        this.mRxAction.addSubscription(Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataInfoUploader$7CJyXiTrirChLr8f084SHzD-B64
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                MapDataInfoUploader.this.lambda$uploadMapDataInfo$0$MapDataInfoUploader(list, observableEmitter);
            }
        }).compose(applyRetry()).subscribeOn(Schedulers.io()), new DisposableObserver<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataInfoUploader.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(@NonNull Boolean bool) {
                L.i(MapDataInfoUploader.TAG, "upload success");
            }

            @Override // io.reactivex.Observer
            public void onError(@NonNull Throwable th) {
                L.Tag tag = MapDataInfoUploader.TAG;
                L.e(tag, "upload onError:" + th);
            }
        });
    }

    public /* synthetic */ void lambda$uploadMapDataInfo$0$MapDataInfoUploader(List list, ObservableEmitter observableEmitter) throws Exception {
        MapDataRequest mapDataRequest = new MapDataRequest();
        mapDataRequest.setContent(GsonUtil.toJson(list));
        mapDataRequest.setTimeStamp(findLatestTimeStamp(list));
        L.Tag tag = TAG;
        L.i(tag, "uploadMapDataInfo timeStamp:" + mapDataRequest.getTimeStamp() + ",content:" + mapDataRequest.getContent());
        ResponseWrapper<Object> uploadMapDataInfo = this.mNaviChargeService.uploadMapDataInfo(mapDataRequest);
        L.Tag tag2 = TAG;
        L.i(tag2, "uploadMapDataInfo response:" + GsonUtil.toJson(uploadMapDataInfo));
        if (uploadMapDataInfo == null || uploadMapDataInfo.getData() == null) {
            observableEmitter.onError(new Throwable("uploadMapDataInfo error! response is null!"));
        } else if (uploadMapDataInfo.getCode() != 200) {
            observableEmitter.onError(new Throwable("uploadMapDataInfo error! code :" + uploadMapDataInfo.getCode()));
        } else {
            observableEmitter.onNext(true);
        }
        observableEmitter.onComplete();
    }

    public <T> ObservableTransformer<T, T> applyRetry() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataInfoUploader$dp76FauxJGuJb2nATLvOQMRbI8A
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                ObservableSource retryWhen;
                retryWhen = observable.retryWhen(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataInfoUploader$btYN7xyvP2hQJZoxfDvMVg6aP6Y
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return MapDataInfoUploader.lambda$null$2((Observable) obj);
                    }
                });
                return retryWhen;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$null$2(Observable observable) throws Exception {
        L.i(TAG, "  applyRetry create retry logic ");
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        return observable.take(2147483647L).flatMap(new Function() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataInfoUploader$EnfYoLtEV_CzMMxIvhoni4WQU-U
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MapDataInfoUploader.lambda$null$1(atomicInteger, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$null$1(AtomicInteger atomicInteger, Throwable th) throws Exception {
        int incrementAndGet = atomicInteger.incrementAndGet();
        L.Tag tag = TAG;
        L.i(tag, "********** uploadMapDataInfo  applyRetry  ,  try again count =>>" + incrementAndGet + "  error:" + th.toString());
        if (incrementAndGet < 3) {
            return Observable.timer(incrementAndGet * 20, TimeUnit.SECONDS);
        }
        return Observable.error(th);
    }

    private long findLatestTimeStamp(List<CityRecordBean> list) {
        long j = -1;
        if (list == null || list.isEmpty()) {
            L.e(TAG, "findLatestTimeStamp fail, list is empty!");
            return -1L;
        }
        for (CityRecordBean cityRecordBean : list) {
            if (cityRecordBean.isDataDeleted()) {
                if (cityRecordBean.getDeleteTimeInMillis() > j) {
                    j = cityRecordBean.getDeleteTimeInMillis();
                }
            } else if (cityRecordBean.getLastOperateTime() > j) {
                j = cityRecordBean.getLastOperateTime();
            }
        }
        return j;
    }
}
