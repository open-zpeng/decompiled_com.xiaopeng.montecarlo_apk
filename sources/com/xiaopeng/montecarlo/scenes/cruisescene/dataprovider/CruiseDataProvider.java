package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviVehicleService;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetVehicleInfoResponse;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseSceneDataHelper;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CruiseDataProvider extends BaseDataProvider<CruiseReturnData, CruiseRequestParam, BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("CruiseDataProvider");
    private Disposable mCommutingDisposable;
    private Disposable mDisposable;
    private Disposable mLicensePlateNoDisposable;
    private Disposable mRecognitionDisposable;
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private INaviVehicleService mNaviVehicleService = (INaviVehicleService) HttpClientManager.getInstance().getService(INaviVehicleService.class);
    private ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();
    private DateService mDateService = new DateService();
    private CruiseSceneDataHelper mCruiseSceneDataHelper = new CruiseSceneDataHelper();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(CruiseRequestParam cruiseRequestParam) throws DataProviderException {
        if (cruiseRequestParam == null) {
            throw new DataProviderException("cruise request param is null");
        }
        L.Tag tag = TAG;
        L.i(tag, "fetchDataDelegate getCruiseType =" + cruiseRequestParam.getCruiseType());
        switch (cruiseRequestParam.getCruiseType()) {
            case 0:
                return fetchCommutingForecast(cruiseRequestParam);
            case 1:
            case 6:
                return loadDistance(cruiseRequestParam);
            case 2:
                return fetchHomeByBigData(cruiseRequestParam);
            case 3:
                return fetchCompanyByBigData(cruiseRequestParam);
            case 4:
                return fetchLicensePlateByVinCode(cruiseRequestParam);
            case 5:
                return fetchChargeData(cruiseRequestParam);
            default:
                throw new DataProviderException("cruise request param type error");
        }
    }

    public boolean isCruise() {
        return TBTManager.getInstance().getCurrentStatus() == 0;
    }

    public boolean isBindAccount() {
        return XPAccountServiceWrapper.getInstance().isLoginXp();
    }

    public boolean isInADay(int i) {
        return this.mCruiseSceneDataHelper.isInADay(i);
    }

    public void saveCommutingforecastLastShowTime(int i) {
        this.mCruiseSceneDataHelper.saveCommutingForecastLastShowTime(i);
    }

    public boolean isChargeEnable() {
        return SettingWrapper.isChargeEnable();
    }

    private DataProviderResponse fetchCommutingForecast(CruiseRequestParam cruiseRequestParam) throws DataProviderException {
        L.i(TAG, "COMMUTING_FORECAST fetchCommutingForecast");
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setCruisType(((CommutingForecastParam) cruiseRequestParam).getCruiseType());
        CommutingForecastResult commutingForecastResult = new CommutingForecastResult();
        commutingForecastResult.setCommutingForecastType(fetchDate());
        cruiseReturnData.setCommutingForecastResult(commutingForecastResult);
        dataProviderResponse.setResultData(cruiseReturnData);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchHomeByBigData(CruiseRequestParam cruiseRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setCruisType(((RecognitionHomeCompanyParam) cruiseRequestParam).getCruiseType());
        dataProviderResponse.setResultData(cruiseReturnData);
        SearchSceneDataHelper.fetchHomeFromCloud();
        return dataProviderResponse;
    }

    private DataProviderResponse fetchCompanyByBigData(CruiseRequestParam cruiseRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setCruisType(((RecognitionHomeCompanyParam) cruiseRequestParam).getCruiseType());
        dataProviderResponse.setResultData(cruiseReturnData);
        SearchSceneDataHelper.fetchCompanyFromCloud();
        return dataProviderResponse;
    }

    private DataProviderResponse fetchLicensePlateByVinCode(CruiseRequestParam cruiseRequestParam) {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setCruisType(((LicensePlateFromVinParam) cruiseRequestParam).getCruiseType());
        dataProviderResponse.setResultData(cruiseReturnData);
        NaviGetVehicleInfoResponse vehicleInfoByVin = this.mNaviVehicleService.getVehicleInfoByVin(RootUtil.getVin());
        if (vehicleInfoByVin != null) {
            L.Tag tag = TAG;
            L.i(tag, "vin get license plate response:" + GsonUtil.toJson(vehicleInfoByVin));
            String plateNo = vehicleInfoByVin.getPlateNo();
            if (plateNo != null && !"null".equals(plateNo)) {
                SettingWrapper.saveLicensePlate(plateNo);
                SettingWrapper.openPlateSwitch();
                AccountManager.getInstance().getAccountSyncSession().startSync(2);
                L.Tag tag2 = TAG;
                L.i(tag2, "plateNo:" + plateNo);
            }
            CruiseSceneDataHelper.saveLastGetLicensePlateSuccessTime();
        }
        return dataProviderResponse;
    }

    private DataProviderResponse loadDistance(CruiseRequestParam cruiseRequestParam) throws DataProviderException {
        if (cruiseRequestParam == null || !(cruiseRequestParam instanceof CruiseLoadDistanceParam)) {
            throw new IllegalArgumentException();
        }
        L.i(TAG, "loadDistance ");
        final CruiseLoadDistanceParam cruiseLoadDistanceParam = (CruiseLoadDistanceParam) cruiseRequestParam;
        if (cruiseLoadDistanceParam.getStartPoi() == null || cruiseLoadDistanceParam.getEndPoi() == null) {
            throw new IllegalArgumentException();
        }
        long requestRoute = TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(cruiseLoadDistanceParam.getStartPoi()).setEndInfo(cruiseLoadDistanceParam.getEndPoi()).setRouteLevel(2).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                synchronized (cruiseLoadDistanceParam) {
                    cruiseLoadDistanceParam.notify();
                    L.i(CruiseDataProvider.TAG, "loadDistance onNewRouteSuccess");
                }
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                if (routeResult.mErrorCode != 37) {
                    synchronized (cruiseLoadDistanceParam) {
                        cruiseLoadDistanceParam.notify();
                        L.i(CruiseDataProvider.TAG, "loadDistance onNewRouteError");
                    }
                }
            }
        });
        synchronized (cruiseLoadDistanceParam) {
            try {
                cruiseLoadDistanceParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestCarGreetingRouters___mCurrentRequestId" + requestRoute);
        }
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(requestRoute);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "requestCarGreetingRouters___result" + routeResult);
        }
        if (routeResult == null) {
            TBTManager.getInstance().clearRouteData(requestRoute);
            throw new DataProviderException(200, "Request route failed");
        }
        RouteResult.RouteInfo routeInfo = routeResult.getRouteInfo(0);
        if (routeInfo == null) {
            TBTManager.getInstance().clearRouteData(requestRoute);
            throw new DataProviderException(400, "routeInfo invalid");
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        CruiseDistanceResult cruiseDistanceResult = new CruiseDistanceResult();
        cruiseDistanceResult.setRequestId(requestRoute);
        cruiseDistanceResult.setDistance(routeInfo.mPathLength);
        cruiseDistanceResult.setTravelTime(routeInfo.mTravelTime);
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setCruisType(cruiseRequestParam.getCruiseType());
        cruiseReturnData.setCruiseDistanceResult(cruiseDistanceResult);
        dataProviderResponse.setResultData(cruiseReturnData);
        return dataProviderResponse;
    }

    private int fetchDate() {
        return this.mDateService.requestDate(new DateParam());
    }

    private DataProviderResponse fetchChargeData(CruiseRequestParam cruiseRequestParam) {
        if (cruiseRequestParam == null || !(cruiseRequestParam instanceof CruiseChargeParam)) {
            throw new IllegalArgumentException();
        }
        CruiseChargeParam cruiseChargeParam = (CruiseChargeParam) cruiseRequestParam;
        CruiseReturnData cruiseReturnData = new CruiseReturnData();
        cruiseReturnData.setList(queryChargeData(cruiseChargeParam, cruiseReturnData));
        cruiseReturnData.setCruisType(cruiseChargeParam.getCruiseType());
        cruiseReturnData.setRadius(cruiseChargeParam.getRadius());
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setResultData(cruiseReturnData);
        return dataProviderResponse;
    }

    private List<XPPoiInfo> queryChargeData(CruiseChargeParam cruiseChargeParam, CruiseReturnData cruiseReturnData) {
        List<XPPoiInfo> searchXPCharge;
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        boolean isNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "queryChargeData remainDis:" + carRemainDistance + ",hasNetwork:" + isNetworkConnected);
        }
        if (carRemainDistance <= 0) {
            L.Tag tag2 = TAG;
            L.i(tag2, "queryChargeData remainDis:" + carRemainDistance);
            return null;
        } else if (isNetworkConnected) {
            GeneralChargeRequestParam createXpChargeSearchParam = createXpChargeSearchParam(cruiseChargeParam);
            if (carRemainDistance <= 3000) {
                createXpChargeSearchParam.setRadius(carRemainDistance);
                searchXPCharge = searchXPCharge(createXpChargeSearchParam);
            } else if (carRemainDistance <= 5000) {
                createXpChargeSearchParam.setRadius(3000);
                searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                if (CollectionUtils.isEmpty(searchXPCharge)) {
                    createXpChargeSearchParam.setRadius(carRemainDistance);
                    searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                }
            } else if (carRemainDistance <= 10000) {
                createXpChargeSearchParam.setRadius(3000);
                searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                if (CollectionUtils.isEmpty(searchXPCharge)) {
                    createXpChargeSearchParam.setRadius(5000);
                    searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                    if (CollectionUtils.isEmpty(searchXPCharge)) {
                        createXpChargeSearchParam.setRadius(carRemainDistance);
                        searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                    }
                }
            } else {
                createXpChargeSearchParam.setRadius(3000);
                searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                if (CollectionUtils.isEmpty(searchXPCharge)) {
                    createXpChargeSearchParam.setRadius(5000);
                    searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                    if (CollectionUtils.isEmpty(searchXPCharge)) {
                        createXpChargeSearchParam.setRadius(10000);
                        searchXPCharge = searchXPCharge(createXpChargeSearchParam);
                    }
                }
            }
            if (CollectionUtils.isEmpty(searchXPCharge)) {
                cruiseChargeParam.setRadius(Math.min(carRemainDistance, 10000));
                return searchAMapCharge(cruiseChargeParam, cruiseReturnData);
            }
            cruiseChargeParam.setRadius(createXpChargeSearchParam.getRadius());
            cruiseReturnData.setGeneralChargeRequestParam(createXpChargeSearchParam);
            return searchXPCharge;
        } else {
            cruiseChargeParam.setRadius(Math.min(carRemainDistance, 10000));
            return searchAMapCharge(cruiseChargeParam, cruiseReturnData);
        }
    }

    private GeneralChargeRequestParam createXpChargeSearchParam(CruiseChargeParam cruiseChargeParam) {
        if (cruiseChargeParam == null) {
            return null;
        }
        GeneralChargeRequestParam generalChargeRequestParam = new GeneralChargeRequestParam();
        generalChargeRequestParam.setLng(cruiseChargeParam.getCarLocation().mLon);
        generalChargeRequestParam.setLat(cruiseChargeParam.getCarLocation().mLat);
        generalChargeRequestParam.setRadius(cruiseChargeParam.getRadius());
        generalChargeRequestParam.setDetail(true);
        generalChargeRequestParam.setOrder("DISTANCE");
        generalChargeRequestParam.setSize(50);
        generalChargeRequestParam.setPage(1);
        return generalChargeRequestParam;
    }

    private List<XPPoiInfo> searchXPCharge(GeneralChargeRequestParam generalChargeRequestParam) {
        if (generalChargeRequestParam == null) {
            return null;
        }
        return this.mChargeDataProvider.syncQueryChargeStation(generalChargeRequestParam, "100").getXPPoiInfos();
    }

    private List<XPPoiInfo> searchAMapCharge(final CruiseChargeParam cruiseChargeParam, final CruiseReturnData cruiseReturnData) {
        if (cruiseChargeParam == null || cruiseReturnData == null) {
            return null;
        }
        SearchClient.getInstance().execute(new RequestFactory(1).newBuilder().requestId(SearchClient.getInstance().getRequestId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).keyword(cruiseChargeParam.getKeyword()).poiLocation(cruiseChargeParam.getCarLocation()).radius(String.valueOf(cruiseChargeParam.getRadius())).pageSize(50).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                synchronized (cruiseChargeParam) {
                    cruiseReturnData.setList(xPSearchResult.getXPPoiInfos());
                    cruiseChargeParam.notify();
                }
            }
        });
        synchronized (cruiseChargeParam) {
            try {
                cruiseChargeParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("searchAMapCharge radius:");
            sb.append(cruiseChargeParam.getRadius());
            sb.append(" result:");
            sb.append(cruiseReturnData.getList() == null ? 0 : cruiseReturnData.getList().size());
            L.d(tag, sb.toString());
        }
        return cruiseReturnData.getList();
    }

    public void requestCommutingForecast(final CommutingForecastParam commutingForecastParam, final BaseCallBack baseCallBack) {
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            doFetchData(commutingForecastParam, baseCallBack);
            return;
        }
        Disposable disposable = this.mCommutingDisposable;
        if (disposable == null || disposable.isDisposed()) {
            Observable.intervalRange(commutingForecastParam.getStart(), commutingForecastParam.getCount(), commutingForecastParam.getInitialDelay(), commutingForecastParam.getPeriod(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider.3
                @Override // io.reactivex.Observer
                public void onSubscribe(Disposable disposable2) {
                    CruiseDataProvider.this.mCommutingDisposable = disposable2;
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                        CruiseDataProvider.this.doFetchData(commutingForecastParam, baseCallBack);
                        CruiseDataProvider.this.mCommutingDisposable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    CruiseDataProvider.this.mCommutingDisposable.dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    CruiseDataProvider.this.mCommutingDisposable.dispose();
                }
            });
            this.mCompositeDisposable.add(this.mCommutingDisposable);
        }
    }

    public void requestDistance(CruiseLoadDistanceParam cruiseLoadDistanceParam, BaseCallBack baseCallBack) {
        doFetchData(cruiseLoadDistanceParam, baseCallBack);
    }

    public void requestRouters(CruiseLoadDistanceParam cruiseLoadDistanceParam, BaseCallBack baseCallBack) {
        doFetchData(cruiseLoadDistanceParam, baseCallBack);
    }

    public void requestRecognitionHome(RecognitionHomeCompanyParam recognitionHomeCompanyParam, BaseCallBack baseCallBack) {
        if (SearchSceneDataHelper.isSettingHome() || SearchSceneDataHelper.isInADay(1)) {
            return;
        }
        requestRecognition(recognitionHomeCompanyParam, baseCallBack);
    }

    public void requestRecognitionCompany(RecognitionHomeCompanyParam recognitionHomeCompanyParam, BaseCallBack baseCallBack) {
        if (SearchSceneDataHelper.isSettingCompany() || SearchSceneDataHelper.isInADay(2)) {
            return;
        }
        requestRecognition(recognitionHomeCompanyParam, baseCallBack);
    }

    public void requestLicensePlate(LicensePlateFromVinParam licensePlateFromVinParam, BaseCallBack baseCallBack) {
        if (TextUtils.isEmpty(SettingWrapper.getLicensePlate()) && !this.mCruiseSceneDataHelper.isInADay(3) && 1 == CarServiceManager.getInstance().getIgStatus()) {
            requestLicensePlateFromVin(licensePlateFromVinParam, baseCallBack);
        }
    }

    public void searchCharge(CruiseChargeParam cruiseChargeParam, BaseCallBack baseCallBack) {
        doFetchData(cruiseChargeParam, baseCallBack);
    }

    private void requestRecognition(final RecognitionHomeCompanyParam recognitionHomeCompanyParam, final BaseCallBack baseCallBack) {
        boolean isNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestRecognition" + GsonUtil.toJson(recognitionHomeCompanyParam));
        }
        if (isNetworkConnected) {
            doFetchData(recognitionHomeCompanyParam, baseCallBack);
            return;
        }
        Disposable disposable = this.mRecognitionDisposable;
        if (disposable == null || disposable.isDisposed()) {
            Observable.interval(recognitionHomeCompanyParam.getPeriod(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).takeUntil(Observable.timer(recognitionHomeCompanyParam.getCount(), TimeUnit.MILLISECONDS)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider.4
                @Override // io.reactivex.Observer
                public void onSubscribe(Disposable disposable2) {
                    CruiseDataProvider.this.mRecognitionDisposable = disposable2;
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                        CruiseDataProvider.this.doFetchData(recognitionHomeCompanyParam, baseCallBack);
                        CruiseDataProvider.this.mRecognitionDisposable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    CruiseDataProvider.this.mRecognitionDisposable.dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    CruiseDataProvider.this.mRecognitionDisposable.dispose();
                }
            });
            this.mCompositeDisposable.add(this.mRecognitionDisposable);
        }
    }

    private void requestLicensePlateFromVin(final LicensePlateFromVinParam licensePlateFromVinParam, final BaseCallBack baseCallBack) {
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            doFetchData(licensePlateFromVinParam, baseCallBack);
            return;
        }
        Disposable disposable = this.mLicensePlateNoDisposable;
        if (disposable == null || disposable.isDisposed()) {
            Observable.interval(licensePlateFromVinParam.getPeriod(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).takeUntil(Observable.timer(licensePlateFromVinParam.getCount(), TimeUnit.MILLISECONDS)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDataProvider.5
                @Override // io.reactivex.Observer
                public void onSubscribe(Disposable disposable2) {
                    CruiseDataProvider.this.mLicensePlateNoDisposable = disposable2;
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                        CruiseDataProvider.this.doFetchData(licensePlateFromVinParam, baseCallBack);
                        CruiseDataProvider.this.mLicensePlateNoDisposable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    CruiseDataProvider.this.mLicensePlateNoDisposable.dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    CruiseDataProvider.this.mLicensePlateNoDisposable.dispose();
                }
            });
            this.mCompositeDisposable.add(this.mLicensePlateNoDisposable);
        }
    }

    public void cancleRecognition() {
        Disposable disposable = this.mRecognitionDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void cancleLicensePlateNo() {
        Disposable disposable = this.mLicensePlateNoDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void cancleCommutingForecast() {
        Disposable disposable = this.mCommutingDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void unSubDisposable() {
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
