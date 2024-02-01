package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.mapoverlay.base.DecoratorDataProvider;
import com.xiaopeng.montecarlo.mapoverlay.base.DecoratorRequestParam;
import com.xiaopeng.montecarlo.mapoverlay.base.DecoratorResponseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
/* loaded from: classes3.dex */
public class RouteChargeDetailProvider implements IRouteChargeDetailContract.IRouteChargeDetailProvider {
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_detailP");
    private IRouteChargeDetailContract.IChargeDetailCallBack mCallBack;
    private volatile boolean mIsStop = false;
    private final DecoratorDataProvider mDecoratorDataProvider = new DecoratorDataProvider(new BaseCallBack<DecoratorRequestParam, DecoratorResponseData>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.1
        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public boolean isLegal() {
            return true;
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onDataCache(@NonNull DecoratorResponseData decoratorResponseData) {
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onError(int i, @NonNull String str) {
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onFetchComplete(DecoratorRequestParam decoratorRequestParam) {
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onFetchStart(DecoratorRequestParam decoratorRequestParam) {
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onDataFetched(@NonNull DecoratorResponseData decoratorResponseData) {
            if (RouteChargeDetailProvider.this.mIsStop) {
                return;
            }
            List<XPPoiInfo> list = decoratorResponseData.getList();
            XPPoiInfo xPPoiInfo = CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
            L.Tag tag = RouteChargeDetailProvider.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("on charge detail fetched:");
            sb.append(xPPoiInfo == null ? "" : xPPoiInfo.getPoiId());
            L.i(tag, sb.toString());
            if (xPPoiInfo == null || RouteChargeDetailProvider.this.mCallBack == null) {
                return;
            }
            RouteChargeDetailProvider.this.mCallBack.onChargeDetailFetched(decoratorResponseData.getSearchPoiId(), xPPoiInfo);
        }
    });

    public RouteChargeDetailProvider(IRouteChargeDetailContract.IChargeDetailCallBack iChargeDetailCallBack) {
        this.mCallBack = iChargeDetailCallBack;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void startRequestDetail(String str) {
        this.mIsStop = false;
        this.mDecoratorDataProvider.cpSearchById(str, XPPoiCategory.BL_CATEGORY_INVALID);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void route(String str, double d, double d2) {
        this.mIsStop = false;
        final XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(d2);
        xPPoiInfo.setDisplayLat(d);
        xPPoiInfo.setPoiId(str);
        TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(TBTManager.getInstance().getStartInfo(TBTManager.getInstance().getCurrentRouteRequestId())).setEndInfo(xPPoiInfo).setRouteLevel(0).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                if (routeResult == null || routeResult.mRouteInfos == null) {
                    return;
                }
                int i = 0;
                IVariantPath path = routeResult.mPathResult.getPath(0);
                long j2 = 0;
                int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
                if (path == null) {
                    i = (int) (carRemainDistance - 0);
                } else {
                    j2 = path.getPathLength();
                }
                long j3 = j2;
                TBTManager.getInstance().clearRouteData(j);
                if (RouteChargeDetailProvider.this.mIsStop) {
                    return;
                }
                RouteChargeDetailProvider.this.mCallBack.onDistanceFetched(xPPoiInfo.getPoiId(), j3, i);
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                if (routeResult.mErrorCode != 822083620) {
                    TBTManager.getInstance().clearRouteData(j);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void renderExternalStatusOnNavi(String str, double d, double d2, int i) {
        L.Tag tag = TAG;
        L.i(tag, "renderExternalStatusOnNavi,  stationID: " + str + ", index: " + i);
        this.mIsStop = false;
        ChargeDetailRequestParam chargeDetailRequestParam = new ChargeDetailRequestParam();
        chargeDetailRequestParam.mLat = d2;
        chargeDetailRequestParam.mLon = d;
        chargeDetailRequestParam.mStationId = str;
        chargeDetailRequestParam.mIndex = i;
        doTransferData(chargeDetailRequestParam);
    }

    private void doTransferData(final ChargeDetailRequestParam chargeDetailRequestParam) {
        Observable.create(new ObservableOnSubscribe<ChargeDetailRequestParam>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.5
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<ChargeDetailRequestParam> observableEmitter) throws Exception {
                observableEmitter.onNext(chargeDetailRequestParam);
                observableEmitter.onComplete();
            }
        }).map(new Function<ChargeDetailRequestParam, ChargeDetailRequestData>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.4
            @Override // io.reactivex.functions.Function
            public ChargeDetailRequestData apply(ChargeDetailRequestParam chargeDetailRequestParam2) throws Exception {
                return RouteChargeDetailProvider.this.doAction(chargeDetailRequestParam2);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ChargeDetailRequestData>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(ChargeDetailRequestData chargeDetailRequestData) {
                if (RouteChargeDetailProvider.this.mIsStop || chargeDetailRequestData == null || RouteChargeDetailProvider.this.mCallBack == null) {
                    return;
                }
                L.Tag tag = RouteChargeDetailProvider.TAG;
                L.i(tag, "callback  mStationId: " + chargeDetailRequestData.mStationId + ", mNavDis: " + chargeDetailRequestData.mNavDis);
                RouteChargeDetailProvider.this.mCallBack.onExternalDataFetched(chargeDetailRequestData.mStationId, chargeDetailRequestData.mIsExternalValid, chargeDetailRequestData.mIsReachable, chargeDetailRequestData.mIsNeedCharging, chargeDetailRequestData.mIsFirstCharging, chargeDetailRequestData.mNavDis, chargeDetailRequestData.mRemainDis, chargeDetailRequestData.mNextDisGap, chargeDetailRequestData.mReachNext, chargeDetailRequestData.mIsLast);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0176 A[EDGE_INSN: B:111:0x0176->B:70:0x0176 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.ChargeDetailRequestData doAction(com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.ChargeDetailRequestParam r26) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider.doAction(com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider$ChargeDetailRequestParam):com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider$ChargeDetailRequestData");
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void stop() {
        if (L.ENABLE) {
            L.d(TAG, "stop");
        }
        this.mIsStop = true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void setCallBack(IRouteChargeDetailContract.IChargeDetailCallBack iChargeDetailCallBack) {
        this.mCallBack = iChargeDetailCallBack;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IRouteChargeDetailProvider
    public void unInit() {
        stop();
        this.mCallBack = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ChargeDetailRequestParam {
        int mIndex;
        double mLat;
        double mLon;
        String mStationId;

        ChargeDetailRequestParam() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ChargeDetailRequestData {
        boolean mIsExternalValid = false;
        boolean mIsFirstCharging;
        boolean mIsLast;
        boolean mIsNeedCharging;
        boolean mIsReachable;
        long mNavDis;
        long mNextDisGap;
        boolean mReachNext;
        long mRemainDis;
        String mStationId;

        ChargeDetailRequestData() {
        }
    }
}
