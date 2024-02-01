package com.xiaopeng.montecarlo.navcore.search.charge;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiChargeStationInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviChargeService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviChargeDataSetRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviChargeDownLockRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviChargeDataSetResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviChargeDownLockResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviQueryResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.CompositeRxAction;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ChargeDataProvider {
    public static final String BOOKING_TYPE_BOOKABLE = "1";
    public static final String BOOKING_TYPE_BOOKED_BY_OTHERS = "3";
    public static final String BOOKING_TYPE_BOOKED_BY_USER = "2";
    public static final String BOOKING_TYPE_UN_BOOKABLE = "0";
    public static final String DISCOUNT_TYPE_FAVOURABLE = "2";
    public static final String DISCOUNT_TYPE_XP_DRIVER_FREE = "3";
    public static final String DISCOUNT_TYPE_XP_DRIVER_ONLY = "1";
    private static final String FILTER_KEY_DISCOUNT_TYPE = "discount_type";
    private static final String FILTER_KEY_OPERATION_MODE = "operation_mode";
    public static final int MAX_SHOW_GUN_SIZE = 6;
    public static final String OPERATION_MODE_JOIN = "2";
    public static final String OPERATION_MODE_OTHER = "0";
    public static final String OPERATION_MODE_XP_COOPERATE = "3";
    public static final String OPERATION_MODE_XP_SELF = "1";
    private static final L.Tag TAG = new L.Tag("ChargeDataProvider");
    private String mKeywordFree;
    private String mKeywordSelfSale;
    private final INaviChargeService mNaviChargeService = (INaviChargeService) HttpClientManager.getInstance().getService(INaviChargeService.class);
    private final INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    CompositeRxAction mRxAction = new CompositeRxAction();

    public void cancelAllRequest() {
        this.mRxAction.unSubscribe();
    }

    public NaviChargeDataSetResponse queryChargeOfflineData(String str) {
        return this.mNaviChargeService.dataSet(new NaviChargeDataSetRequest().setVersionId(Long.valueOf(str)).setTs(Long.valueOf(System.currentTimeMillis())));
    }

    public void downLock(final String str, DisposableObserver<Boolean> disposableObserver) {
        this.mRxAction.addSubscription(Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.search.charge.-$$Lambda$ChargeDataProvider$NhtRGFnD4nr3Lsw3hrFv9xOIwuA
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                ChargeDataProvider.this.lambda$downLock$0$ChargeDataProvider(str, observableEmitter);
            }
        }).compose(applySchedulers()), disposableObserver);
    }

    public /* synthetic */ void lambda$downLock$0$ChargeDataProvider(String str, ObservableEmitter observableEmitter) throws Exception {
        if (TextUtils.isEmpty(str)) {
            observableEmitter.onError(new NullPointerException("downLock fail! lockNo is null!"));
            return;
        }
        ResponseWrapper<NaviChargeDownLockResponse> downLock = this.mNaviChargeService.downLock(new NaviChargeDownLockRequest().setLockNo(str));
        if (downLock == null || downLock.getData() == null) {
            observableEmitter.onError(new Throwable("down lock error! response is null!"));
        } else if (downLock.getCode() != 200 || downLock.getData().getCode() != 200) {
            observableEmitter.onError(new ChargeDataException(downLock.getData().getCode(), downLock.getData().getMsg()));
        } else {
            observableEmitter.onNext(true);
        }
        observableEmitter.onComplete();
    }

    public void queryChargeStation(@NonNull final GeneralChargeRequestParam generalChargeRequestParam, final String str, @NonNull DisposableObserver<XPSearchResult> disposableObserver) {
        this.mRxAction.addSubscription(Observable.create(new ObservableOnSubscribe() { // from class: com.xiaopeng.montecarlo.navcore.search.charge.-$$Lambda$ChargeDataProvider$uwZkG2h2rJizWHmgls-JNnNX0Q4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                ChargeDataProvider.this.lambda$queryChargeStation$1$ChargeDataProvider(generalChargeRequestParam, str, observableEmitter);
            }
        }).compose(applySchedulers()), disposableObserver);
    }

    public /* synthetic */ void lambda$queryChargeStation$1$ChargeDataProvider(@NonNull GeneralChargeRequestParam generalChargeRequestParam, String str, ObservableEmitter observableEmitter) throws Exception {
        XPSearchResult syncQueryChargeStation = syncQueryChargeStation(generalChargeRequestParam, str);
        if (syncQueryChargeStation == null || syncQueryChargeStation.getResultCode() == 1003) {
            observableEmitter.onError(new Throwable("queryChargeStation fail! searchResult is error!"));
        } else {
            observableEmitter.onNext(syncQueryChargeStation);
        }
        observableEmitter.onComplete();
    }

    public XPSearchResult syncQueryChargeStation(@NonNull GeneralChargeRequestParam generalChargeRequestParam, String str) {
        if (!TextUtils.equals(str, "100") && !TextUtils.equals(str, XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY)) {
            L.Tag tag = TAG;
            L.e(tag, "search type is not supported ,type：" + str);
            return null;
        }
        initKeyword();
        String filterOperationMode = generalChargeRequestParam.getFilterOperationMode();
        String filterDiscountType = generalChargeRequestParam.getFilterDiscountType();
        String query = generalChargeRequestParam.getQuery();
        if (!TextUtils.isEmpty(query)) {
            if (query.contains(this.mKeywordSelfSale)) {
                query = query.replace(this.mKeywordSelfSale, "");
                filterOperationMode = "1";
            }
            if (query.contains(this.mKeywordFree)) {
                query = query.replace(this.mKeywordFree, "");
                filterDiscountType = "3";
            }
        }
        NaviQueryRequest radius = new NaviQueryRequest().setQuery(query).setType(Integer.parseInt(str)).setRadius(generalChargeRequestParam.getRadius());
        NaviQueryRequest size = radius.setLocation(generalChargeRequestParam.getLng() + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + generalChargeRequestParam.getLat()).setCategory(XPNaviSearchParam.PARAM_CATEGORY_VALUE_CHARGE).setRadius(generalChargeRequestParam.getRadius()).setPage(generalChargeRequestParam.getPage()).setSize(generalChargeRequestParam.getSize());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(filterOperationMode)) {
            hashMap.put(FILTER_KEY_OPERATION_MODE, filterOperationMode);
        }
        if (!TextUtils.isEmpty(filterDiscountType)) {
            hashMap.put(FILTER_KEY_DISCOUNT_TYPE, filterDiscountType);
        }
        size.setFilter(hashMap);
        if (XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY.equalsIgnoreCase(str)) {
            size.setPath(generalChargeRequestParam.parsePath());
            size.setQuery(null);
        }
        NaviQueryResponse query2 = this.mNaviSearchService.query(size);
        XPSearchResult xPSearchResult = new XPSearchResult();
        if (query2 != null) {
            xPSearchResult.setResultCode(0);
            xPSearchResult.setXPPoiInfos(parseXpPoiInfoList(query2.getPois()));
        } else {
            xPSearchResult.setResultCode(1003);
        }
        return xPSearchResult;
    }

    public List<XPPoiInfo> syncQueryStationDetail(String str) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("gun_busi_status", "01");
        hashMap.put("gun_booking_type", "2;1;0");
        arrayList.add(new NaviDetailSearchRequest.PoiIdInfoForDetailRequest().setId(str).setFilter(hashMap).setSource(3));
        NaviDetailSearchResponse detailList = this.mNaviSearchService.detailList(new NaviDetailSearchRequest().setPoiIdList(arrayList));
        if (!CollectionUtils.isEmpty(detailList.getData())) {
            NaviPoiInfo naviPoiInfo = detailList.getData().get(0);
            if (naviPoiInfo.getChargeStation() != null && !CollectionUtils.isEmpty(naviPoiInfo.getChargeStation().getGunInfoList())) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<NaviPoiChargeStationInfo.GunInfo> it = naviPoiInfo.getChargeStation().getGunInfoList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    NaviPoiChargeStationInfo.GunInfo next = it.next();
                    if (!CollectionUtils.isEmpty(next.getLockList()) && !TextUtils.isEmpty(next.getLockList().get(0).getLockNo())) {
                        if (TextUtils.equals(next.getBookingType(), "2")) {
                            arrayList2.clear();
                            arrayList2.add(next);
                            break;
                        }
                        arrayList2.add(next);
                        if (arrayList2.size() == 6) {
                            break;
                        }
                    }
                }
                naviPoiInfo.getChargeStation().setGunInfoList(arrayList2);
            }
        }
        return parseXpPoiInfoList(detailList.getData());
    }

    private synchronized void initKeyword() {
        if (TextUtils.isEmpty(this.mKeywordSelfSale)) {
            this.mKeywordSelfSale = ContextUtils.getString(R.string.filter_self_sale);
        }
        if (TextUtils.isEmpty(this.mKeywordFree)) {
            this.mKeywordFree = ContextUtils.getString(R.string.filter_free);
        }
    }

    private List<XPPoiInfo> parseXpPoiInfoList(List<NaviPoiInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (NaviPoiInfo naviPoiInfo : list) {
            arrayList.add(generalChargeInfo2XPPoiInfo(naviPoiInfo));
        }
        HttpResponseConverter.sortByChargeWeight(arrayList);
        return arrayList;
    }

    private XPPoiInfo generalChargeInfo2XPPoiInfo(NaviPoiInfo naviPoiInfo) {
        if (naviPoiInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setKey(ContextUtils.getString(R.string.search_category_charge));
        xPPoiInfo.setPoiId(naviPoiInfo.getId());
        xPPoiInfo.setName(naviPoiInfo.getName());
        xPPoiInfo.setAddress(naviPoiInfo.getAddress());
        try {
            double doubleValue = naviPoiInfo.getLocation().getLon().doubleValue();
            double doubleValue2 = naviPoiInfo.getLocation().getLat().doubleValue();
            xPPoiInfo.setDisplayLon(doubleValue);
            xPPoiInfo.setDisplayLat(doubleValue2);
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(doubleValue, doubleValue2), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
        } catch (Exception e) {
            L.Tag tag = TAG;
            L.w(tag, "parse error" + e.toString());
        }
        NaviPoiChargeStationInfo chargeStation = naviPoiInfo.getChargeStation();
        if (chargeStation != null) {
            int operationMode = chargeStation.getOperationMode();
            if (operationMode == 1) {
                xPPoiInfo.setCategory(107);
            } else if (operationMode == 2) {
                xPPoiInfo.setCategory(116);
            } else if (operationMode == 3) {
                xPPoiInfo.setCategory(117);
            } else if (operationMode == 0) {
                xPPoiInfo.setCategory(108);
            }
            xPPoiInfo.setPrice(toPriceString(chargeStation));
            XPDeepCharging[] xPDeepChargingArr = {new XPDeepCharging()};
            xPDeepChargingArr[0].setNumFast(chargeStation.getFastNum());
            if (chargeStation.getFastNum() > 0) {
                xPDeepChargingArr[0].setNumFastFree(chargeStation.getFastFreeNum());
            } else {
                xPDeepChargingArr[0].setNumFastFree(-1);
            }
            xPDeepChargingArr[0].setNumSlow(chargeStation.getSlowNum());
            if (chargeStation.getSlowNum() > 0) {
                xPDeepChargingArr[0].setNumSlowFree(chargeStation.getSlowFreeNum());
            } else {
                xPDeepChargingArr[0].setNumSlowFree(-1);
            }
            xPDeepChargingArr[0].setChargeSrcName(naviPoiInfo.getBrandName());
            xPDeepChargingArr[0].setFreeStation(chargeStation.isFreeCharging());
            xPDeepChargingArr[0].setAllXpPile(chargeStation.isAllXpPile());
            xPDeepChargingArr[0].setGunInfoList(chargeStation.getGunInfoList());
            XPDeepInfoPoi xPDeepInfoPoi = new XPDeepInfoPoi();
            xPDeepInfoPoi.setChargeData(xPDeepChargingArr);
            xPPoiInfo.setXPDeepInfoPoi(xPDeepInfoPoi);
            xPPoiInfo.setVisitCount(chargeStation.getChargeCount().intValue());
            xPPoiInfo.setFreeParking(chargeStation.isFreeParking());
        } else {
            L.Tag tag2 = TAG;
            L.e(tag2, "generalChargeInfo2XPPoiInfo no chargeStation!!! id:" + naviPoiInfo.getId());
        }
        xPPoiInfo.setTag(naviPoiInfo.getBrandName());
        xPPoiInfo.setOpenTime(naviPoiInfo.getBusiTime());
        xPPoiInfo.setTel(naviPoiInfo.getPhone());
        xPPoiInfo.setOffline(false);
        xPPoiInfo.setPoiSource(3);
        if (CollectionUtils.isNotEmpty(naviPoiInfo.getImgs())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < naviPoiInfo.getImgs().size(); i++) {
                String str = naviPoiInfo.getImgs().get(i);
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
            xPPoiInfo.setImageUrlList(arrayList);
        }
        return xPPoiInfo;
    }

    private String toPriceString(@NonNull NaviPoiChargeStationInfo naviPoiChargeStationInfo) {
        int operationMode = naviPoiChargeStationInfo.getOperationMode();
        ArrayList<String> arrayList = new ArrayList();
        int i = 0;
        if (1 == operationMode || 2 == operationMode || 3 == operationMode) {
            if (CollectionUtils.isNotEmpty(naviPoiChargeStationInfo.getChargeFeeInfoList())) {
                for (int i2 = 0; i2 < naviPoiChargeStationInfo.getChargeFeeInfoList().size(); i2++) {
                    NaviPoiChargeStationInfo.ChargeFeeInfo chargeFeeInfo = naviPoiChargeStationInfo.getChargeFeeInfoList().get(i2);
                    if (chargeFeeInfo != null) {
                        String str = chargeFeeInfo.getStartTime() + "-" + chargeFeeInfo.getEndTime() + "," + chargeFeeInfo.getChargePrice() + ",";
                        arrayList.add(chargeFeeInfo.getServicePrice() > 0.0f ? str + chargeFeeInfo.getServicePrice() : str + naviPoiChargeStationInfo.getServiceFee());
                    }
                }
            } else {
                arrayList.add("00:00-24:00," + naviPoiChargeStationInfo.getElectricityFee() + "," + naviPoiChargeStationInfo.getServiceFee());
            }
            if (CollectionUtils.isNotEmpty(naviPoiChargeStationInfo.getIncrementFeeInfoList())) {
                while (i < naviPoiChargeStationInfo.getIncrementFeeInfoList().size()) {
                    NaviPoiChargeStationInfo.IncrementFeeInfo incrementFeeInfo = naviPoiChargeStationInfo.getIncrementFeeInfoList().get(i);
                    if (incrementFeeInfo != null && !TextUtils.isEmpty(incrementFeeInfo.getItemCode()) && !TextUtils.isEmpty(incrementFeeInfo.getItemDesc())) {
                        if (incrementFeeInfo.getItemCode().equalsIgnoreCase("1000002002")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_park) + "," + incrementFeeInfo.getItemDesc().replaceAll(",", "，"));
                        } else if (incrementFeeInfo.getItemCode().equalsIgnoreCase("1000003000")) {
                            arrayList.add(ContextUtils.getString(R.string.charge_desc_low_speed) + "," + incrementFeeInfo.getItemDesc().replaceAll(",", "，"));
                        }
                    }
                    i++;
                }
            }
        } else if (CollectionUtils.isNotEmpty(naviPoiChargeStationInfo.getChargeFeeInfoList())) {
            while (i < naviPoiChargeStationInfo.getChargeFeeInfoList().size()) {
                NaviPoiChargeStationInfo.ChargeFeeInfo chargeFeeInfo2 = naviPoiChargeStationInfo.getChargeFeeInfoList().get(i);
                if (chargeFeeInfo2 != null) {
                    String str2 = chargeFeeInfo2.getStartTime() + "-" + chargeFeeInfo2.getEndTime() + "," + chargeFeeInfo2.getChargePrice() + ",";
                    arrayList.add(chargeFeeInfo2.getServicePrice() > 0.0f ? str2 + chargeFeeInfo2.getServicePrice() : str2 + naviPoiChargeStationInfo.getServiceFee());
                }
                i++;
            }
        } else {
            arrayList.add("00:00-24:00," + naviPoiChargeStationInfo.getElectricityFee() + "," + naviPoiChargeStationInfo.getServiceFee());
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (String str3 : arrayList) {
                sb.append(str3);
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
        } catch (Exception e) {
            L.w(TAG, "Error : " + e.getMessage());
        }
        return sb.toString();
    }

    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer() { // from class: com.xiaopeng.montecarlo.navcore.search.charge.-$$Lambda$ChargeDataProvider$T7NzXeZLElr5cqRyhaefr7bYJ5w
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                ObservableSource observeOn;
                observeOn = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                return observeOn;
            }
        };
    }
}
