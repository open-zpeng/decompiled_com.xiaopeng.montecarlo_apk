package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviDetailSearchRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviQueryRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviDetailSearchResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.DetailInfoRequest;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
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
/* loaded from: classes3.dex */
public class SearchResultDataProvider extends BaseDataProvider<SearchResultReturnData, SearchRequestParam, BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("SearchResultDataProvider");
    private ConcurrentHashMap<Integer, SearchRequestParam> mSearchWrapperIdMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, SearchResponseEvent> mSearchResultMap = new ConcurrentHashMap<>();
    private int mSearchTaskId = -1;
    private List<XPPoiInfo> mDataList = null;
    private IChargeStationSearchService mChargeSearch = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    private ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();
    private SearchServiceWrapper mSearchServiceWrapper = SearchServiceWrapper.getInstance();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return "";
    }

    public void insertOrReplaceCompany(FavoriteAddress favoriteAddress) {
    }

    public void insertOrReplaceHome(FavoriteAddress favoriteAddress) {
    }

    public void keywordSearch(SearchResultRequestParam searchResultRequestParam, BaseCallBack baseCallBack) {
        doFetchData(searchResultRequestParam, baseCallBack);
    }

    public void alongRouteSearch(SearchResultRequestParam searchResultRequestParam, List<XPPoiInfo> list, BaseCallBack baseCallBack) {
        doFetchData(searchResultRequestParam, baseCallBack);
        this.mDataList = list;
    }

    public void detailInfoSearch(SearchResultRequestParam searchResultRequestParam, BaseCallBack baseCallBack) {
        doFetchData(searchResultRequestParam, baseCallBack);
    }

    public void keywordAroundSearch(SearchResultRequestParam searchResultRequestParam, BaseCallBack baseCallBack) {
        doFetchData(searchResultRequestParam, baseCallBack);
    }

    public void searchChargeAround(CPSearchRequestParam cPSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(cPSearchRequestParam, baseCallBack);
    }

    public void searchChargeAlongWay(CPSearchRequestParam cPSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(cPSearchRequestParam, baseCallBack);
    }

    public void searchNaviServer(NaviSearchRequestParam naviSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(naviSearchRequestParam, baseCallBack);
    }

    public XPPoiInfo getStartInfoFromCurrent() {
        return TBTManager.getInstance().getStartPOIFromCurrent();
    }

    public boolean setHome(FavoriteAddress favoriteAddress) {
        return FavoriteDataManager.getInstance().setHome(favoriteAddress);
    }

    public boolean setCompany(FavoriteAddress favoriteAddress) {
        return FavoriteDataManager.getInstance().setCompany(favoriteAddress);
    }

    public boolean switchOnTimer() {
        return StateManager.getInstance().getSwitchState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(SearchRequestParam searchRequestParam) throws DataProviderException {
        int i = searchRequestParam.mSearchType;
        if (i != 2) {
            if (i != 4) {
                if (i != 5) {
                    if (i == 6) {
                        return fetchCPSearchAlongWayResult(searchRequestParam);
                    }
                    switch (i) {
                        case 12:
                        case 13:
                            break;
                        case 14:
                            return fetchNaviSearchResult(searchRequestParam);
                        default:
                            return null;
                    }
                } else {
                    return fetchCPSearchAroundResult(searchRequestParam);
                }
            }
            return searchInfo(searchRequestParam);
        }
        return fetchAlongRoute(searchRequestParam);
    }

    private DataProviderResponse fetchAlongRoute(SearchRequestParam searchRequestParam) {
        SearchResponseEvent searchResponseEvent;
        if (this.mDataList != null) {
            ArrayList arrayList = new ArrayList();
            for (XPPoiInfo xPPoiInfo : this.mDataList) {
                if (xPPoiInfo != null) {
                    arrayList.add(xPPoiInfo);
                }
            }
            searchResponseEvent = new SearchResponseEvent(searchRequestParam.getSearchType(), arrayList, 0, 0);
        } else {
            searchResponseEvent = null;
        }
        if (searchResponseEvent != null && Utils.isFoodOpen()) {
            searchForFood(searchResponseEvent);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultReturnData searchResultReturnData = new SearchResultReturnData();
        searchResultReturnData.setSearchResponseEvent(searchResponseEvent);
        searchResultReturnData.mSearchType = searchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultReturnData);
        return dataProviderResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse searchInfo(com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultRequestParam
            if (r0 == 0) goto L8b
            com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultRequestParam r5 = (com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultRequestParam) r5
            boolean r0 = r5.isAborted()
            if (r0 == 0) goto L11
            com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse r5 = r4.createSearchCanceledResponse()
            return r5
        L11:
            int r0 = r5.mSearchType
            r1 = 4
            if (r0 == r1) goto L29
            r1 = 12
            if (r0 == r1) goto L25
            r1 = 13
            if (r0 != r1) goto L1f
            goto L29
        L1f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            r5.<init>()
            throw r5
        L25:
            r4.startDetailSearch(r5)
            goto L2c
        L29:
            r4.startKeywordSearch(r5)
        L2c:
            monitor-enter(r5)
            r5.wait()     // Catch: java.lang.Throwable -> L31 java.lang.InterruptedException -> L33
            goto L51
        L31:
            r0 = move-exception
            goto L89
        L33:
            r0 = move-exception
            com.xiaopeng.montecarlo.root.util.L$Tag r1 = com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultDataProvider.TAG     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "searchInfo wait error="
            r2.append(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L31
            r2.append(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L31
            com.xiaopeng.montecarlo.root.util.L.e(r1, r2)     // Catch: java.lang.Throwable -> L31
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L31
        L51:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L31
            boolean r0 = r5.isAborted()
            if (r0 == 0) goto L5d
            com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse r5 = r4.createSearchCanceledResponse()
            return r5
        L5d:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent> r0 = r4.mSearchResultMap
            int r1 = r5.mSearchId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.remove(r1)
            com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent r0 = (com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent) r0
            boolean r1 = com.xiaopeng.montecarlo.util.Utils.isFoodOpen()
            if (r1 == 0) goto L74
            r4.searchForFood(r0)
        L74:
            com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse r1 = new com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse
            r1.<init>()
            com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultReturnData r2 = new com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultReturnData
            r2.<init>()
            r2.setSearchResponseEvent(r0)
            int r5 = r5.mSearchType
            r2.mSearchType = r5
            r1.setResultData(r2)
            return r1
        L89:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L31
            throw r0
        L8b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultDataProvider.searchInfo(com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam):com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse");
    }

    private void startKeywordSearch(final SearchResultRequestParam searchResultRequestParam) {
        SearchClient.getInstance().execute(searchResultRequestParam.getKeywordQueryRequest(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                SearchResultDataProvider.this.onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(searchResultRequestParam.mSearchType, searchResultRequestParam.mSearchId, xPSearchResult));
            }
        });
    }

    private void startDetailSearch(final SearchResultRequestParam searchResultRequestParam) {
        DetailInfoRequest detailInfoRequest = searchResultRequestParam.getDetailInfoRequest();
        SearchClient.getInstance().execute(new RequestFactory(3).newBuilder().requestId(searchResultRequestParam.mSearchId).poiId(detailInfoRequest.mPoiId).poiName(detailInfoRequest.mPoiName).poiLocation(new XPCoordinate2DDouble(detailInfoRequest.mPoiLon, detailInfoRequest.mPoiLat)).build(), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                SearchResultDataProvider.this.onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(searchResultRequestParam.mSearchType, searchResultRequestParam.mSearchId, xPSearchResult));
            }
        });
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

    private void updateSearchKeywordId(SearchRequestParam searchRequestParam) {
        SearchRequestParam remove;
        int i = this.mSearchTaskId;
        this.mSearchTaskId = ((SearchResultRequestParam) searchRequestParam).mSearchId;
        L.Tag tag = TAG;
        L.i(tag, "updateSearchId:" + this.mSearchTaskId);
        int abort = this.mSearchWrapperIdMap.containsKey(Integer.valueOf(i)) ? this.mSearchServiceWrapper.abort(i) : -1;
        this.mSearchWrapperIdMap.put(Integer.valueOf(this.mSearchTaskId), searchRequestParam);
        if (abort != 0 || (remove = this.mSearchWrapperIdMap.remove(Integer.valueOf(i))) == null) {
            return;
        }
        remove.setAborted(true);
        synchronized (remove) {
            remove.notify();
        }
    }

    private DataProviderResponse createSearchCanceledResponse() {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setErrorCode(1);
        return dataProviderResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchDataResult(SearchResponseEvent searchResponseEvent) {
        Integer valueOf = Integer.valueOf(searchResponseEvent.getTaskId());
        L.Tag tag = TAG;
        L.i(tag, " onSearchDataResult taskId=" + valueOf + " responseEvent=" + searchResponseEvent.getSearchType());
        this.mSearchResultMap.put(valueOf, searchResponseEvent);
        if (this.mSearchWrapperIdMap.get(valueOf) != null) {
            SearchRequestParam remove = this.mSearchWrapperIdMap.remove(valueOf);
            synchronized (remove) {
                remove.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(SearchRequestParam searchRequestParam) {
        super.onFetchStart((SearchResultDataProvider) searchRequestParam);
        L.Tag tag = TAG;
        L.i(tag, " onFetchStart SearchType=" + searchRequestParam.getSearchType());
        if (searchRequestParam.getSearchType() == 4) {
            updateSearchKeywordId(searchRequestParam);
        }
    }

    protected DataProviderResponse fetchCPSearchAroundResult(SearchRequestParam searchRequestParam) {
        if (searchRequestParam == null || !(searchRequestParam instanceof CPSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        CPSearchRequestParam cPSearchRequestParam = (CPSearchRequestParam) searchRequestParam;
        GeneralChargeRequestParam generalChargeRequestParam = cPSearchRequestParam.getGeneralChargeRequestParam();
        generalChargeRequestParam.updateTs();
        SearchResponseEvent searchResponseEvent = new SearchResponseEvent(0, new ArrayList(this.mChargeDataProvider.syncQueryChargeStation(generalChargeRequestParam, "100").getXPPoiInfos()), 0, 0);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultReturnData searchResultReturnData = new SearchResultReturnData();
        searchResultReturnData.setSearchResponseEvent(searchResponseEvent);
        searchResultReturnData.mSearchType = cPSearchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultReturnData);
        return dataProviderResponse;
    }

    protected DataProviderResponse fetchCPSearchAlongWayResult(SearchRequestParam searchRequestParam) {
        if (searchRequestParam == null || !(searchRequestParam instanceof CPSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        CPSearchRequestParam cPSearchRequestParam = (CPSearchRequestParam) searchRequestParam;
        GeneralChargeRequestParam generalChargeRequestParam = cPSearchRequestParam.getGeneralChargeRequestParam();
        generalChargeRequestParam.updateTs();
        generalChargeRequestParam.obtainPath();
        SearchResponseEvent searchResponseEvent = new SearchResponseEvent(0, new ArrayList(this.mChargeDataProvider.syncQueryChargeStation(generalChargeRequestParam, XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY).getXPPoiInfos()), 0, 0);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultReturnData searchResultReturnData = new SearchResultReturnData();
        searchResultReturnData.setSearchResponseEvent(searchResponseEvent);
        searchResultReturnData.mSearchType = cPSearchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultReturnData);
        return dataProviderResponse;
    }

    protected DataProviderResponse fetchNaviSearchResult(SearchRequestParam searchRequestParam) {
        if (searchRequestParam == null || !(searchRequestParam instanceof NaviSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        XPNaviSearchParam naviSearchParam = ((NaviSearchRequestParam) searchRequestParam).getNaviSearchParam();
        NaviQueryRequest type = new NaviQueryRequest().setQuery(naviSearchParam.getQuery()).setType(Integer.valueOf(naviSearchParam.getType()).intValue());
        NaviQueryRequest size = type.setLocation(naviSearchParam.getPoiLocation().mLon + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + naviSearchParam.getPoiLocation().mLat).setCategory(naviSearchParam.getCategory()).setRadius(naviSearchParam.getRadius()).setPage(naviSearchParam.getPage()).setSize(naviSearchParam.getSize());
        if (XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY.equalsIgnoreCase(naviSearchParam.getType()) && CollectionUtils.isNotEmpty(naviSearchParam.getPath())) {
            size.setPath(naviSearchParam.getPath());
        }
        if (naviSearchParam.getRemainDistance() > 1000) {
            size.setRemainingMileage(naviSearchParam.getRemainDistance());
        }
        SearchResponseEvent searchResponseEvent = new SearchResponseEvent(searchRequestParam.getSearchType(), new ArrayList(HttpResponseConverter.fetchXPPoiInfoListFromNaviQueryResponse(this.mNaviSearchService.query(size))), searchRequestParam.getSearchId(), 0);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultReturnData searchResultReturnData = new SearchResultReturnData();
        searchResultReturnData.setSearchResponseEvent(searchResponseEvent);
        searchResultReturnData.mSearchType = searchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultReturnData);
        return dataProviderResponse;
    }
}
