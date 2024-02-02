package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper;
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
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.BLDataModelUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class SearchDataProvider extends BaseDataProvider<SearchResultData, SearchRequestParam, BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("SearchDataProvider");
    private Request mRequest;
    private SearchServiceWrapper mSearchServiceWrapper = SearchServiceWrapper.getInstance();
    private ConcurrentHashMap<Integer, SearchRequestParam> mSearchWrapperIdMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, SearchResponseEvent> mSearchResultMap = new ConcurrentHashMap<>();
    private IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);
    private INaviSearchService mNaviSearchService = (INaviSearchService) HttpClientManager.getInstance().getService(INaviSearchService.class);
    protected ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(@NonNull SearchRequestParam searchRequestParam) throws DataProviderException {
        switch (searchRequestParam.mSearchType) {
            case 0:
                return getFavourite(searchRequestParam);
            case 1:
            case 12:
            default:
                return null;
            case 2:
                return fetchAlongWaySearchResult(searchRequestParam);
            case 3:
                if (searchRequestParam.isFromCached()) {
                    return fetchSuggestSearchResultFromCached(searchRequestParam);
                }
                return fetchSuggestSearchResult(searchRequestParam);
            case 4:
            case 13:
                return searchKeyword(searchRequestParam);
            case 5:
                return fetchCPSearchAroundResult(searchRequestParam);
            case 6:
                return fetchCPSearchAlongWayResult(searchRequestParam);
            case 7:
            case 8:
                return deleteItem(searchRequestParam);
            case 9:
            case 10:
                return deleteAllLocalItems(searchRequestParam);
            case 11:
                return loadDistance(searchRequestParam);
            case 14:
                return fetchNaviSearchResult(searchRequestParam);
            case 15:
                return getNormalFavouriteCount(searchRequestParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderException convertException(int i) {
        if (i == 1) {
            return new SearchDataException("Search task canceled");
        }
        return super.convertException(i);
    }

    public Request getRequest() {
        return this.mRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public void onFetchStart(SearchRequestParam searchRequestParam) {
        super.onFetchStart((SearchDataProvider) searchRequestParam);
        if (searchRequestParam.getSearchType() == 4 || searchRequestParam.getSearchType() == 13 || searchRequestParam.getSearchType() == 2 || searchRequestParam.getSearchType() == 3) {
            updateSearchId(searchRequestParam);
        }
    }

    protected void sortHistoryRecordInfo(List<HistoryRecordInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        Collections.sort(list, new Comparator<HistoryRecordInfo>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.1
            @Override // java.util.Comparator
            public int compare(HistoryRecordInfo historyRecordInfo, HistoryRecordInfo historyRecordInfo2) {
                if (historyRecordInfo == null && historyRecordInfo2 == null) {
                    return 0;
                }
                if (historyRecordInfo == null) {
                    return -1;
                }
                if (historyRecordInfo2 != null && historyRecordInfo.getCreateTime() >= historyRecordInfo2.getCreateTime()) {
                    return historyRecordInfo.getCreateTime() == historyRecordInfo2.getCreateTime() ? 0 : -1;
                }
                return 1;
            }
        });
    }

    public void keywordSearch(SearchKeywordParam searchKeywordParam, BaseCallBack baseCallBack) {
        doFetchData(searchKeywordParam, baseCallBack);
    }

    private Request startKeywordSearch(SearchKeywordParam searchKeywordParam, ResponseCallback responseCallback) {
        Request build = new RequestFactory(1).newBuilder().requestId(searchKeywordParam.getSearchId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD).keyword(searchKeywordParam.getText()).category(searchKeywordParam.getCategory()).poiLocation(searchKeywordParam.getPoiLoc()).build();
        SearchClient.getInstance().execute(build, responseCallback);
        return build;
    }

    private Request startAroundSearch(SearchKeywordParam searchKeywordParam, ResponseCallback responseCallback) {
        Request build = new RequestFactory(1).newBuilder().requestId(searchKeywordParam.getSearchId()).searchType(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND).keyword(searchKeywordParam.getText()).category(searchKeywordParam.getCategory()).poiLocation(searchKeywordParam.getPoiLoc()).radius(searchKeywordParam.getRange()).build();
        SearchClient.getInstance().execute(build, responseCallback);
        return build;
    }

    private Request startAlongWaySearch(AlongWaySearchRequestParam alongWaySearchRequestParam, ResponseCallback responseCallback) {
        Request build = new RequestFactory(2).newBuilder().requestId(alongWaySearchRequestParam.getSearchId()).keyword(alongWaySearchRequestParam.getText()).category(alongWaySearchRequestParam.getCategory()).orderPolicy(alongWaySearchRequestParam.getOrder()).build();
        SearchClient.getInstance().execute(build, responseCallback);
        return build;
    }

    private void startSuggestSearch(@NonNull SuggestSearchRequestParam suggestSearchRequestParam, ResponseCallback responseCallback) {
        SearchClient.getInstance().execute(new RequestFactory(4).newBuilder().requestId(suggestSearchRequestParam.getSearchId()).keyword(suggestSearchRequestParam.getKey()).poiLocation(suggestSearchRequestParam.getXPPoiInfo() != null ? new XPCoordinate2DDouble(suggestSearchRequestParam.getXPPoiInfo().getDisplayLon(), suggestSearchRequestParam.getXPPoiInfo().getDisplayLat()) : null).build(), responseCallback);
    }

    private XPSearchResult getChargeAroundSearchResult(CPSearchRequestParam cPSearchRequestParam) {
        if (cPSearchRequestParam == null || cPSearchRequestParam.getGeneralChargeRequestParam() == null) {
            return null;
        }
        GeneralChargeRequestParam generalChargeRequestParam = cPSearchRequestParam.getGeneralChargeRequestParam();
        generalChargeRequestParam.setFilterDiscountType(null);
        generalChargeRequestParam.setFilterOperationMode(null);
        return this.mChargeDataProvider.syncQueryChargeStation(generalChargeRequestParam, "100");
    }

    private XPSearchResult getChargeAlongWaySearchResult(CPSearchRequestParam cPSearchRequestParam) {
        if (cPSearchRequestParam == null || cPSearchRequestParam.getGeneralChargeRequestParam() == null) {
            return null;
        }
        GeneralChargeRequestParam generalChargeRequestParam = cPSearchRequestParam.getGeneralChargeRequestParam();
        generalChargeRequestParam.obtainPath();
        generalChargeRequestParam.setFilterDiscountType(null);
        generalChargeRequestParam.setFilterOperationMode(null);
        return this.mChargeDataProvider.syncQueryChargeStation(generalChargeRequestParam, XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY);
    }

    private List<XPPoiInfo> getCarServiceFromDb(Coord2DDouble coord2DDouble, int i, String str) {
        return ServiceCenterDataHelper.query(coord2DDouble, i, str);
    }

    public void deleteAllLocalItems(SearchRequestParam searchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(searchRequestParam, baseCallBack);
    }

    public void deleteFavouriteRecord(SearchDeleteFavouriteParam searchDeleteFavouriteParam, BaseCallBack baseCallBack) {
        doFetchData(searchDeleteFavouriteParam, baseCallBack);
    }

    public void deleteHistoryRecord(SearchDeleteHistoryParam searchDeleteHistoryParam, BaseCallBack baseCallBack) {
        doFetchData(searchDeleteHistoryParam, baseCallBack);
    }

    public void loadPoiDistance(SearchLoadDistanceParam searchLoadDistanceParam, BaseCallBack baseCallBack) {
        doFetchData(searchLoadDistanceParam, baseCallBack);
    }

    public void searchChargeAround(CPSearchRequestParam cPSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(cPSearchRequestParam, baseCallBack);
    }

    public void searchNaviServer(NaviSearchRequestParam naviSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(naviSearchRequestParam, baseCallBack);
    }

    public void searchChargeAlongWay(CPSearchRequestParam cPSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(cPSearchRequestParam, baseCallBack);
    }

    public void alongWaySearch(@NonNull SearchRequestParam searchRequestParam, @NonNull BaseCallBack baseCallBack) {
        doFetchData(searchRequestParam, baseCallBack);
    }

    public void suggestSearch(@NonNull SuggestSearchRequestParam suggestSearchRequestParam, BaseCallBack baseCallBack) {
        doFetchData(suggestSearchRequestParam, baseCallBack);
    }

    public void getFavouriteList(SearchFavouriteParam searchFavouriteParam, BaseCallBack baseCallBack) {
        doFetchData(searchFavouriteParam, baseCallBack);
    }

    public void getNormalFavoriteCount(SearchFavouriteParam searchFavouriteParam, BaseCallBack baseCallBack) {
        doFetchData(searchFavouriteParam, baseCallBack);
    }

    public String getCategoryByKeyword(String str) {
        return (this.mSearchServiceWrapper == null || TextUtils.isEmpty(str)) ? "" : this.mSearchServiceWrapper.mapKeywordToCategoryForAlongWay(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchDataResult(SearchResponseEvent searchResponseEvent) {
        SearchRequestParam remove;
        Integer valueOf = Integer.valueOf(searchResponseEvent.getTaskId());
        if (!this.mSearchWrapperIdMap.containsKey(valueOf) || (remove = this.mSearchWrapperIdMap.remove(valueOf)) == null) {
            return;
        }
        this.mSearchResultMap.put(valueOf, searchResponseEvent);
        synchronized (remove) {
            remove.notify();
        }
    }

    @VisibleForTesting
    protected void sortFavorite(List<FavoriteAddress> list) {
        FavoriteDataManager.sortFavoriteList(list);
    }

    private DataProviderResponse loadDistance(SearchRequestParam searchRequestParam) throws DataProviderException {
        if (searchRequestParam == null || !(searchRequestParam instanceof SearchLoadDistanceParam)) {
            throw new IllegalArgumentException();
        }
        final SearchLoadDistanceParam searchLoadDistanceParam = (SearchLoadDistanceParam) searchRequestParam;
        if (searchLoadDistanceParam.getStartPoi() == null || searchLoadDistanceParam.getEndPoi() == null) {
            throw new IllegalArgumentException();
        }
        double distance = LocationUtils.getDistance(new XPCoordinate2DDouble(searchLoadDistanceParam.getStartPoi()), new XPCoordinate2DDouble(searchLoadDistanceParam.getEndPoi()));
        L.Tag tag = TAG;
        L.i(tag, "is home= " + searchLoadDistanceParam.isHome() + " line distance= " + distance);
        if ((searchLoadDistanceParam.isHome() && distance > 120000.0d) || ((!searchLoadDistanceParam.isHome() && distance > 60000.0d) || distance < 10.0d)) {
            return generateLineDistanceResponse((long) distance, searchLoadDistanceParam);
        }
        long requestRoute = TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(searchLoadDistanceParam.getStartPoi()).setEndInfo(searchLoadDistanceParam.getEndPoi()).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.2
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                synchronized (searchLoadDistanceParam) {
                    searchLoadDistanceParam.notify();
                }
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                synchronized (searchLoadDistanceParam) {
                    if (routeResult != null) {
                        if (routeResult.mErrorCode == 37) {
                            return;
                        }
                    }
                    searchLoadDistanceParam.notify();
                }
            }
        });
        synchronized (searchLoadDistanceParam) {
            try {
                searchLoadDistanceParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(requestRoute);
        if (routeResult == null || routeResult.getRouteInfo(0) == null) {
            return generateLineDistanceResponse((long) distance, searchLoadDistanceParam);
        }
        RouteResult.RouteInfo routeInfo = routeResult.getRouteInfo(0);
        SearchLoadDistanceResult searchLoadDistanceResult = new SearchLoadDistanceResult();
        searchLoadDistanceResult.setDistance(routeInfo.mPathLength);
        searchLoadDistanceResult.setTravelTime(routeInfo.mTravelTime);
        searchLoadDistanceResult.setHome(searchLoadDistanceParam.isHome());
        searchLoadDistanceResult.setLightBarInfo(BLDataModelUtil.toXPLightBarInfo(routeInfo.mLightBarItems, routeInfo.mPathId));
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchLoadDistanceResult(searchLoadDistanceResult);
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        TBTManager.getInstance().clearRouteData(requestRoute);
        return dataProviderResponse;
    }

    private DataProviderResponse<SearchResultData> generateLineDistanceResponse(long j, SearchLoadDistanceParam searchLoadDistanceParam) {
        SearchLoadDistanceResult searchLoadDistanceResult = new SearchLoadDistanceResult();
        searchLoadDistanceResult.setDistance(j);
        searchLoadDistanceResult.setTravelTime(0L);
        searchLoadDistanceResult.setHome(searchLoadDistanceParam.isHome());
        DataProviderResponse<SearchResultData> dataProviderResponse = new DataProviderResponse<>();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchLoadDistanceResult(searchLoadDistanceResult);
        searchResultData.mSearchType = searchLoadDistanceParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse searchKeyword(SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof SearchKeywordParam)) {
            throw new IllegalArgumentException();
        }
        final SearchKeywordParam searchKeywordParam = (SearchKeywordParam) searchRequestParam;
        if (searchKeywordParam.isAborted()) {
            return createSearchCanceledResponse();
        }
        if (4 == searchKeywordParam.getSearchType()) {
            this.mRequest = startKeywordSearch(searchKeywordParam, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.3
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public void onResponse(Request request, XPSearchResult xPSearchResult) {
                    SearchDataProvider.this.convertAndNotify(searchKeywordParam.getSearchType(), request.getRequestId(), xPSearchResult);
                }
            });
        } else if (13 == searchKeywordParam.getSearchType()) {
            this.mRequest = startAroundSearch(searchKeywordParam, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.4
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public void onResponse(Request request, XPSearchResult xPSearchResult) {
                    SearchDataProvider.this.convertAndNotify(searchKeywordParam.getSearchType(), request.getRequestId(), xPSearchResult);
                }
            });
        }
        synchronized (searchKeywordParam) {
            try {
                searchKeywordParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (searchKeywordParam.isAborted()) {
            return createSearchCanceledResponse();
        }
        SearchResponseEvent remove = this.mSearchResultMap.remove(Integer.valueOf(searchKeywordParam.getSearchId()));
        if (Utils.isFoodOpen()) {
            searchForFood(remove);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(remove);
        searchResultData.mSearchType = searchKeywordParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private void searchForFood(SearchResponseEvent searchResponseEvent) {
        XPPoiInfo xPPoiInfo;
        if (searchResponseEvent == null || CollectionUtils.isEmpty(searchResponseEvent.getList())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList<XPPoiInfo> list = searchResponseEvent.getList();
        int size = list.size();
        boolean z = size > 20;
        int i = z ? 20 : size;
        for (int i2 = 0; i2 < i; i2++) {
            XPPoiInfo xPPoiInfo2 = list.get(i2);
            if (xPPoiInfo2 != null) {
                linkedHashMap.put(xPPoiInfo2.getPoiId(), xPPoiInfo2);
                if (115 == xPPoiInfo2.getCategory()) {
                    arrayList.add(new NaviDetailSearchRequest.PoiIdInfoForDetailRequest().setId(xPPoiInfo2.getPoiId()).setSource(1));
                }
            }
        }
        ArrayList arrayList2 = z ? new ArrayList(list.subList(20, size)) : null;
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
            ArrayList<XPPoiInfo> arrayList3 = new ArrayList<>(linkedHashMap.values());
            if (arrayList2 != null && !CollectionUtils.isEmpty(arrayList2)) {
                arrayList3.addAll(arrayList2);
            }
            searchResponseEvent.setList(arrayList3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertAndNotify(int i, int i2, XPSearchResult xPSearchResult) {
        onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(i, i2, xPSearchResult));
    }

    private DataProviderResponse createSearchCanceledResponse() {
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setErrorCode(1);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchAlongWaySearchResult(final SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof AlongWaySearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        int searchId = searchRequestParam.getSearchId();
        this.mRequest = startAlongWaySearch((AlongWaySearchRequestParam) searchRequestParam, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.5
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                SearchDataProvider.this.convertAndNotify(searchRequestParam.getSearchType(), request.getRequestId(), xPSearchResult);
            }
        });
        synchronized (searchRequestParam) {
            try {
                searchRequestParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SearchResponseEvent remove = this.mSearchResultMap.remove(Integer.valueOf(searchId));
        if (Utils.isFoodOpen()) {
            searchForFood(remove);
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(remove);
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchSuggestSearchResultFromCached(SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof SuggestSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        String key = ((SuggestSearchRequestParam) searchRequestParam).getKey();
        boolean z = false;
        if (100 == searchRequestParam.getSearchMode() && 1000 == searchRequestParam.getSearchDest()) {
            z = true;
        }
        List<HistoryRecordInfo> suggestHistoryRecords = FavoriteDataManager.getInstance().getSuggestHistoryRecords(key, z);
        if (suggestHistoryRecords == null) {
            suggestHistoryRecords = new ArrayList<>();
        }
        for (HistoryRecordInfo historyRecordInfo : suggestHistoryRecords) {
            if (historyRecordInfo != null && historyRecordInfo.getXPPoiInfo() != null) {
                historyRecordInfo.getXPPoiInfo().setKey(key);
            }
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSuggestSearchXpPoiInfosFromCached(suggestHistoryRecords);
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        searchResultData.setFromCached(true);
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchSuggestSearchResult(SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof SuggestSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        final SuggestSearchRequestParam suggestSearchRequestParam = (SuggestSearchRequestParam) searchRequestParam;
        if (TextUtils.isEmpty(suggestSearchRequestParam.getKey())) {
            throw new IllegalArgumentException();
        }
        if (searchRequestParam.isAborted()) {
            return createSearchCanceledResponse();
        }
        final int searchId = searchRequestParam.getSearchId();
        startSuggestSearch(suggestSearchRequestParam, new ResponseCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider.6
            @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
            public void onResponse(Request request, XPSearchResult xPSearchResult) {
                SearchDataProvider.this.onSearchDataResult(NavCoreUtil.convertXpResultToResponseEvent(suggestSearchRequestParam.getSearchType(), searchId, xPSearchResult));
            }
        });
        synchronized (searchRequestParam) {
            try {
                searchRequestParam.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (searchRequestParam.isAborted()) {
            return createSearchCanceledResponse();
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(this.mSearchResultMap.remove(Integer.valueOf(searchId)));
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse deleteAllLocalItems(@NonNull SearchRequestParam searchRequestParam) {
        int deleteAllNormalFavorites;
        int searchType = searchRequestParam.getSearchType();
        if (searchType == 9) {
            deleteAllNormalFavorites = FavoriteDataManager.getInstance().deleteAllNormalFavorites();
        } else if (searchType == 10) {
            deleteAllNormalFavorites = FavoriteDataManager.getInstance().deleteAllHistories();
        } else {
            throw new IllegalArgumentException();
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        SearchDeleteResult searchDeleteResult = new SearchDeleteResult();
        searchDeleteResult.setDeletedCount(deleteAllNormalFavorites);
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        searchResultData.mSearchDeleteResult = searchDeleteResult;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse deleteItem(@Nullable SearchRequestParam searchRequestParam) {
        int delete;
        int position;
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        SearchDeleteResult searchDeleteResult = new SearchDeleteResult();
        if (searchRequestParam instanceof SearchDeleteFavouriteParam) {
            List<FavoriteAddress> favoriteAddress = ((SearchDeleteFavouriteParam) searchRequestParam).getFavoriteAddress();
            delete = FavoriteDataManager.getInstance().deleteFavoriteList(favoriteAddress);
            r4 = delete > 0 ? favoriteAddress : null;
            position = 0;
        } else if (searchRequestParam instanceof SearchDeleteHistoryParam) {
            SearchDeleteHistoryParam searchDeleteHistoryParam = (SearchDeleteHistoryParam) searchRequestParam;
            delete = FavoriteDataManager.getInstance().delete(searchDeleteHistoryParam.getHistoryRecordInfo());
            searchDeleteResult.setDeletedHistoryRecord(searchDeleteHistoryParam.getHistoryRecordInfo());
            position = searchDeleteHistoryParam.getPosition();
        } else {
            throw new IllegalArgumentException();
        }
        searchDeleteResult.setDeletedCount(delete);
        searchDeleteResult.setDeletedPosition(position);
        searchDeleteResult.setDeleteFavoritesList(r4);
        searchResultData.setSearchDeleteResult(searchDeleteResult);
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse getFavourite(SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof SearchFavouriteParam)) {
            throw new IllegalArgumentException();
        }
        long showTime = searchRequestParam.getShowTime();
        long updateTime = searchRequestParam.getUpdateTime();
        if (!searchRequestParam.isPaging()) {
            long[] maxNormalFavTime = FavoriteDataManager.getInstance().getMaxNormalFavTime();
            if (maxNormalFavTime[0] > showTime) {
                showTime = maxNormalFavTime[0];
            }
            if (maxNormalFavTime[1] > updateTime) {
                updateTime = maxNormalFavTime[1];
            }
        }
        List<FavoriteAddress> listNormalFavoritesList = FavoriteDataManager.getInstance().listNormalFavoritesList(showTime, updateTime, searchRequestParam.getPoiIdList(), searchRequestParam.getPageSize());
        if (CollectionUtils.isNotEmpty(listNormalFavoritesList)) {
            sortFavorite(listNormalFavoritesList);
            L.Tag tag = TAG;
            L.i(tag, " getFavourite listNormalFavoritesList size:" + listNormalFavoritesList.size());
        } else {
            L.i(TAG, " getFavourite listNormalFavoritesList empty");
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.mFavouriteList = listNormalFavoritesList;
        searchResultData.mSearchType = searchRequestParam.mSearchType;
        searchResultData.mMaxRecordTime = showTime;
        searchResultData.mIsLoad = searchRequestParam.isLoad();
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse getNormalFavouriteCount(SearchRequestParam searchRequestParam) {
        if (!(searchRequestParam instanceof SearchFavouriteParam)) {
            throw new IllegalArgumentException();
        }
        int normalFavoriteCount = FavoriteDataManager.getInstance().getNormalFavoriteCount();
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchType(searchRequestParam.getSearchType());
        searchResultData.setNormalFavCount(normalFavoriteCount);
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse fetchCPSearchAroundResult(SearchRequestParam searchRequestParam) {
        if (searchRequestParam == null || !(searchRequestParam instanceof CPSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        CPSearchRequestParam cPSearchRequestParam = (CPSearchRequestParam) searchRequestParam;
        SearchResponseEvent convertXpResultToResponseEvent = NavCoreUtil.convertXpResultToResponseEvent(0, 0, getChargeAroundSearchResult(cPSearchRequestParam));
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(convertXpResultToResponseEvent);
        searchResultData.mSearchType = cPSearchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    @VisibleForTesting
    private DataProviderResponse fetchCPSearchAlongWayResult(SearchRequestParam searchRequestParam) {
        List<XPPoiInfo> xPPoiInfos;
        if (searchRequestParam == null || !(searchRequestParam instanceof CPSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        CPSearchRequestParam cPSearchRequestParam = (CPSearchRequestParam) searchRequestParam;
        XPSearchResult chargeAlongWaySearchResult = getChargeAlongWaySearchResult(cPSearchRequestParam);
        if (chargeAlongWaySearchResult != null && (xPPoiInfos = chargeAlongWaySearchResult.getXPPoiInfos()) != null && xPPoiInfos.size() > 50) {
            chargeAlongWaySearchResult.setXPPoiInfos(xPPoiInfos.subList(0, 50));
        }
        SearchResponseEvent convertXpResultToResponseEvent = NavCoreUtil.convertXpResultToResponseEvent(cPSearchRequestParam.getSearchType(), cPSearchRequestParam.getSearchId(), chargeAlongWaySearchResult);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(convertXpResultToResponseEvent);
        searchResultData.mSearchType = cPSearchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchNaviSearchResult(SearchRequestParam searchRequestParam) {
        if (searchRequestParam == null || !(searchRequestParam instanceof NaviSearchRequestParam)) {
            throw new IllegalArgumentException();
        }
        XPNaviSearchParam naviSearchParam = ((NaviSearchRequestParam) searchRequestParam).getNaviSearchParam();
        NaviQueryRequest type = new NaviQueryRequest().setQuery(naviSearchParam.is4SCategory() ? "" : naviSearchParam.getQuery()).setType(Integer.valueOf(naviSearchParam.getType()).intValue());
        NaviQueryRequest size = type.setLocation(naviSearchParam.getPoiLocation().mLon + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + naviSearchParam.getPoiLocation().mLat).setCategory(naviSearchParam.getCategory()).setRadius(naviSearchParam.getRadius()).setPage(naviSearchParam.getPage()).setSize(naviSearchParam.getSize());
        if (XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY.equalsIgnoreCase(naviSearchParam.getType())) {
            naviSearchParam.obtainPath();
            size.setPath(naviSearchParam.getPath());
        }
        if (naviSearchParam.getRemainDistance() > 1000) {
            size.setRemainingMileage(naviSearchParam.getRemainDistance());
        }
        SearchResponseEvent searchResponseEvent = new SearchResponseEvent(searchRequestParam.getSearchType(), new ArrayList(HttpResponseConverter.fetchXPPoiInfoListFromNaviQueryResponse(this.mNaviSearchService.query(size))), searchRequestParam.getSearchId(), 0);
        if (CollectionUtils.isEmpty(searchResponseEvent.getList()) && naviSearchParam.is4SCategory()) {
            List<XPPoiInfo> carServiceFromDb = getCarServiceFromDb(naviSearchParam.getPoiLocation().toBLCoord2D(), 50000, naviSearchParam.getCategory());
            if (CollectionUtils.isNotEmpty(carServiceFromDb)) {
                searchResponseEvent.setList(new ArrayList<>(carServiceFromDb));
            }
        }
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        SearchResultData searchResultData = new SearchResultData();
        searchResultData.setSearchResponseEvent(searchResponseEvent);
        searchResultData.mSearchType = searchRequestParam.getSearchType();
        dataProviderResponse.setResultData(searchResultData);
        return dataProviderResponse;
    }

    private void updateSearchId(SearchRequestParam searchRequestParam) {
        SearchRequestParam remove;
        if (searchRequestParam == null || this.mSearchWrapperIdMap == null) {
            return;
        }
        int searchType = searchRequestParam.getSearchType();
        for (SearchRequestParam searchRequestParam2 : this.mSearchWrapperIdMap.values()) {
            if (searchRequestParam2 != null && searchRequestParam2.getSearchType() == searchType) {
                int searchId = searchRequestParam2.getSearchId();
                if (this.mSearchServiceWrapper.abort(searchId) == 0 && (remove = this.mSearchWrapperIdMap.remove(Integer.valueOf(searchId))) != null) {
                    remove.setAborted(true);
                    if (remove.getSearchType() != 4) {
                        synchronized (remove) {
                            remove.notify();
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        int requestId = SearchClient.getInstance().getRequestId();
        searchRequestParam.setSearchId(requestId);
        this.mSearchWrapperIdMap.put(Integer.valueOf(requestId), searchRequestParam);
    }

    public boolean isCityLocation(SearchResponseEvent searchResponseEvent) {
        return searchResponseEvent != null && CollectionUtils.isNotEmpty(searchResponseEvent.getList()) && 1 == searchResponseEvent.getList().size() && searchResponseEvent.isCityLocation();
    }
}
