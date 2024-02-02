package com.xiaopeng.montecarlo.mapoverlay.base;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.Utils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DecoratorDataProvider extends BaseDataProvider<DecoratorResponseData, DecoratorRequestParam, BaseCallBack> {
    private static final int ERROR_CODE_SEARCH = 2;
    private static final int ERROR_CODE_SEARCH_CANCELED = 1;
    private static final L.Tag TAG = new L.Tag("DecoratorDataProvider");
    private BaseCallBack mCallBack;
    private int mSearchTaskId = 0;
    private ConcurrentHashMap<Integer, DecoratorRequestParam> mSearchWrapperIdMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, SearchResponseEvent> mSearchResultMap = new ConcurrentHashMap<>();
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();
    private SearchServiceWrapper mSearchServiceWrapper = SearchServiceWrapper.getInstance();

    private boolean isValidSearchType(int i) {
        return i == 8 || i == 6 || i == 5 || i == 9 || i == 12;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return null;
    }

    public DecoratorDataProvider(BaseCallBack baseCallBack) {
        this.mCallBack = baseCallBack;
    }

    public BaseCallBack getCallBack() {
        return this.mCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(DecoratorRequestParam decoratorRequestParam) throws DataProviderException {
        if (decoratorRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        int searchType = decoratorRequestParam.getSearchType();
        if (searchType != 5) {
            if (searchType != 6) {
                if (searchType != 12) {
                    if (searchType == 13) {
                        return fetchCarServiceInfo(decoratorRequestParam);
                    }
                    throw new DataProviderException("param type error");
                }
                return fetchCPoiInfo(decoratorRequestParam);
            }
            return fetchNearestPoiInfo(decoratorRequestParam);
        }
        return fetchKeywordPoiInfo(decoratorRequestParam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(DecoratorRequestParam decoratorRequestParam) {
        super.onFetchStart((DecoratorDataProvider) decoratorRequestParam);
        if (isCharge(decoratorRequestParam) || decoratorRequestParam.getSearchType() == 12) {
            return;
        }
        updateSearchId(decoratorRequestParam);
    }

    public void cpSearchById(String str, String str2) {
        if (this.mCallBack == null) {
            L.w(TAG, "cpSearchById failure:mCallBack is null");
            return;
        }
        DecoratorRequestParam decoratorRequestParam = new DecoratorRequestParam();
        decoratorRequestParam.setPoiId(str);
        decoratorRequestParam.setCategory(str2);
        decoratorRequestParam.setSearchType(12);
        doFetchData(decoratorRequestParam, this.mCallBack);
    }

    public void carCenterSearchById(String str) {
        if (this.mCallBack == null) {
            L.w(TAG, "carCenterSearchById failure:mCallBack is null");
            return;
        }
        DecoratorRequestParam decoratorRequestParam = new DecoratorRequestParam();
        decoratorRequestParam.setPoiId(str);
        decoratorRequestParam.setSearchType(13);
        doFetchData(decoratorRequestParam, this.mCallBack);
    }

    public void nearestSearch(double d, double d2) {
        if (this.mCallBack == null) {
            L.w(TAG, "nearestSearch failure:mCallBack is null");
            return;
        }
        DecoratorRequestParam decoratorRequestParam = new DecoratorRequestParam();
        decoratorRequestParam.setLat(d2);
        decoratorRequestParam.setLon(d);
        decoratorRequestParam.setSearchType(6);
        doFetchData(decoratorRequestParam, this.mCallBack);
    }

    public void keywordPoiSearch(XPPoiInfo xPPoiInfo) {
        if (this.mCallBack == null) {
            L.w(TAG, "keywordPoiSearch failure:mCallBack is null");
            return;
        }
        DecoratorRequestParam decoratorRequestParam = new DecoratorRequestParam();
        decoratorRequestParam.setPoiInfo(xPPoiInfo);
        decoratorRequestParam.setSearchId(SearchClient.getInstance().getRequestId());
        decoratorRequestParam.setSearchType(5);
        doFetchData(decoratorRequestParam, this.mCallBack);
    }

    private DataProviderResponse<DecoratorResponseData> fetchCPoiInfo(DecoratorRequestParam decoratorRequestParam) {
        List<XPPoiInfo> syncQueryStationDetail = this.mChargeDataProvider.syncQueryStationDetail(decoratorRequestParam.getPoiId());
        DataProviderResponse<DecoratorResponseData> dataProviderResponse = new DataProviderResponse<>();
        DecoratorResponseData decoratorResponseData = new DecoratorResponseData();
        decoratorResponseData.setSearchType(decoratorRequestParam.getSearchType());
        decoratorResponseData.setList(syncQueryStationDetail);
        decoratorResponseData.setSearchPoiId(decoratorRequestParam.getPoiId());
        dataProviderResponse.setResultData(decoratorResponseData);
        return dataProviderResponse;
    }

    private DataProviderResponse<DecoratorResponseData> fetchCarServiceInfo(DecoratorRequestParam decoratorRequestParam) {
        String poiId = decoratorRequestParam.getPoiId();
        List<XPPoiInfo> query = ServiceCenterDataHelper.query(poiId);
        DataProviderResponse<DecoratorResponseData> dataProviderResponse = new DataProviderResponse<>();
        DecoratorResponseData decoratorResponseData = new DecoratorResponseData();
        decoratorResponseData.setSearchType(decoratorRequestParam.getSearchType());
        decoratorResponseData.setList(query);
        decoratorResponseData.setSearchPoiId(poiId);
        dataProviderResponse.setResultData(decoratorResponseData);
        return dataProviderResponse;
    }

    private DataProviderResponse<DecoratorResponseData> fetchNearestPoiInfo(final DecoratorRequestParam decoratorRequestParam) {
        L.i(TAG, "fetchNearestPoiInfo");
        final int searchId = decoratorRequestParam.getSearchId();
        Request build = new RequestFactory(5).newBuilder().requestId(searchId).poiLocation(new XPCoordinate2DDouble(decoratorRequestParam.getLon(), decoratorRequestParam.getLat())).build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        SearchClient.getInstance().execute(build, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.mapoverlay.base.DecoratorDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                DecoratorDataProvider.this.onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(decoratorRequestParam.getSearchType(), searchId, xPSearchResult));
                L.i(DecoratorDataProvider.TAG, "fetchNearestPoiInfo onResponse");
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(8L, TimeUnit.SECONDS);
            L.Tag tag = TAG;
            L.i(tag, "fetchKeywordPoiInfo isAborted =" + decoratorRequestParam.isAborted());
            if (decoratorRequestParam.isAborted()) {
                return createSearchCanceledResponse();
            }
            SearchResponseEvent remove = this.mSearchResultMap.remove(Integer.valueOf(decoratorRequestParam.getSearchId()));
            if (remove == null || !isValidSearchType(remove.getSearchType())) {
                return error();
            }
            if (Utils.isFoodOpen()) {
                searchForFood(remove);
            }
            DataProviderResponse<DecoratorResponseData> dataProviderResponse = new DataProviderResponse<>();
            DecoratorResponseData decoratorResponseData = new DecoratorResponseData();
            decoratorResponseData.setSearchType(remove.getSearchType());
            decoratorResponseData.setList(new ArrayList(remove.getList()));
            dataProviderResponse.setResultData(decoratorResponseData);
            return dataProviderResponse;
        } catch (InterruptedException e) {
            L.printStackTrace(TAG, e);
            return createSearchCanceledResponse();
        }
    }

    private DataProviderResponse<DecoratorResponseData> fetchKeywordPoiInfo(final DecoratorRequestParam decoratorRequestParam) {
        L.i(TAG, "fetchKeywordPoiInfo");
        XPPoiInfo poiInfo = decoratorRequestParam.getPoiInfo();
        Request build = new RequestFactory(1).newBuilder().requestId(decoratorRequestParam.getSearchId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_POI).poiId(poiInfo.getPoiId()).poiLocation(new XPCoordinate2DDouble(poiInfo.getDisplayLon(), poiInfo.getDisplayLat())).build();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        SearchClient.getInstance().enqueue(build, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.mapoverlay.base.DecoratorDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                DecoratorDataProvider.this.onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(decoratorRequestParam.getSearchType(), decoratorRequestParam.getSearchId(), xPSearchResult));
                L.i(DecoratorDataProvider.TAG, "fetchKeywordPoiInfo onResponse");
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(8L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            L.printStackTrace(TAG, e);
        }
        L.Tag tag = TAG;
        L.i(tag, "fetchKeywordPoiInfo isAborted =" + decoratorRequestParam.isAborted());
        if (decoratorRequestParam.isAborted()) {
            return createSearchCanceledResponse();
        }
        SearchResponseEvent remove = this.mSearchResultMap.remove(Integer.valueOf(decoratorRequestParam.getSearchId()));
        if (remove == null || !isValidSearchType(remove.getSearchType())) {
            return error();
        }
        if (Utils.isFoodOpen()) {
            searchForFood(remove);
        }
        DataProviderResponse<DecoratorResponseData> dataProviderResponse = new DataProviderResponse<>();
        DecoratorResponseData decoratorResponseData = new DecoratorResponseData();
        decoratorResponseData.setSearchType(remove.getSearchType());
        if (CollectionUtils.isNotEmpty(remove.getList())) {
            decoratorResponseData.setList(new ArrayList(remove.getList()));
        }
        dataProviderResponse.setResultData(decoratorResponseData);
        return dataProviderResponse;
    }

    private boolean isCharge(DecoratorRequestParam decoratorRequestParam) {
        XPPoiInfo poiInfo = decoratorRequestParam.getPoiInfo();
        if (poiInfo != null) {
            return XPPoiCategory.isCommonCharge(poiInfo.getCategory()) || XPPoiCategory.isXPSelfCharge(poiInfo.getCategory()) || XPPoiCategory.isXPJoinCharge(poiInfo.getCategory()) || XPPoiCategory.isXPCooperateCharge(poiInfo.getCategory());
        }
        return false;
    }

    private DataProviderResponse createSearchCanceledResponse() {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setErrorCode(1);
        return dataProviderResponse;
    }

    private DataProviderResponse error() {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setErrorCode(2);
        return dataProviderResponse;
    }

    private void updateSearchId(DecoratorRequestParam decoratorRequestParam) {
        DecoratorRequestParam remove;
        int i = this.mSearchTaskId;
        this.mSearchTaskId = SearchClient.getInstance().getRequestId();
        int abort = this.mSearchWrapperIdMap.containsKey(Integer.valueOf(i)) ? this.mSearchServiceWrapper.abort(i) : -1;
        this.mSearchWrapperIdMap.put(Integer.valueOf(this.mSearchTaskId), decoratorRequestParam);
        decoratorRequestParam.setSearchId(this.mSearchTaskId);
        if (abort != 0 || (remove = this.mSearchWrapperIdMap.remove(Integer.valueOf(i))) == null) {
            return;
        }
        remove.setAborted(true);
        synchronized (remove) {
            remove.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchDataResult(SearchResponseEvent searchResponseEvent) {
        Integer valueOf = Integer.valueOf(searchResponseEvent.getTaskId());
        this.mSearchResultMap.put(valueOf, searchResponseEvent);
        if (this.mSearchWrapperIdMap.get(valueOf) != null) {
            this.mSearchWrapperIdMap.remove(valueOf);
        }
    }

    private void searchForFood(SearchResponseEvent searchResponseEvent) {
        XPPoiInfo xPPoiInfo;
        if (searchResponseEvent == null || CollectionUtils.isEmpty(searchResponseEvent.getList())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < searchResponseEvent.getList().size(); i++) {
            XPPoiInfo xPPoiInfo2 = searchResponseEvent.getList().get(i);
            if (xPPoiInfo2 != null) {
                linkedHashMap.put(xPPoiInfo2.getPoiId(), xPPoiInfo2);
                if (115 == xPPoiInfo2.getCategory()) {
                    arrayList.add(new NaviDetailSearchRequest.PoiIdInfoForDetailRequest().setId(xPPoiInfo2.getPoiId()).setSource(1));
                }
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            NaviDetailSearchResponse detailList = this.mNaviSearchService.detailList(new NaviDetailSearchRequest().setCurrentLocation(null).setPoiIdList(arrayList));
            List<XPPoiInfo> fetchXPPoiInfoListFromNaviDetailSearchResponse = HttpResponseConverter.fetchXPPoiInfoListFromNaviDetailSearchResponse(detailList);
            if (detailList == null || CollectionUtils.isEmpty(fetchXPPoiInfoListFromNaviDetailSearchResponse)) {
                return;
            }
            for (XPPoiInfo xPPoiInfo3 : fetchXPPoiInfoListFromNaviDetailSearchResponse) {
                if (xPPoiInfo3 != null && (xPPoiInfo = (XPPoiInfo) linkedHashMap.get(xPPoiInfo3.getPoiId())) != null) {
                    xPPoiInfo.setPrice(xPPoiInfo3.getPrice());
                    xPPoiInfo.setRating(xPPoiInfo3.getRating());
                    xPPoiInfo.setImageUrlList(xPPoiInfo3.getImageUrlList());
                    linkedHashMap.put(xPPoiInfo3.getPoiId(), xPPoiInfo);
                }
            }
            searchResponseEvent.setList(new ArrayList<>(linkedHashMap.values()));
        }
    }

    public void setCallback(BaseCallBack baseCallBack) {
        this.mCallBack = baseCallBack;
    }
}
