package com.xiaopeng.montecarlo.navcore.search;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.search.SearchService;
import com.autonavi.gbl.search.model.RecommendCategory;
import com.autonavi.gbl.search.model.RecommendPoi;
import com.autonavi.gbl.search.model.SearchAlongWayParam;
import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.autonavi.gbl.search.model.SearchAroundRecommendParam;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.model.SearchDeepInfoParam;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.autonavi.gbl.search.model.SearchDetailInfoParam;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.autonavi.gbl.search.model.SearchKeywordParam;
import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.autonavi.gbl.search.model.SearchNearestParam;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.autonavi.gbl.search.model.SearchSuggestParam;
import com.autonavi.gbl.search.model.SearchSuggestResult;
import com.autonavi.gbl.search.observer.IGSearchAlongWayObserver;
import com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver;
import com.autonavi.gbl.search.observer.IGSearchDeepInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchDetailInfoObserver;
import com.autonavi.gbl.search.observer.IGSearchKeyWordObserver;
import com.autonavi.gbl.search.observer.IGSearchNearestObserver;
import com.autonavi.gbl.search.observer.IGSearchSuggestionObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Hashtable;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes3.dex */
public class SearchServiceWrapper {
    public static final int DEFAULT_ALONG_WAY_SIZE = 50;
    public static final int DEFAULT_OFFLINE_SIZE = 50;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_SUG_SIZE = 10;
    public static final int ERROR_CODE_OFFLINE_NO_DATA = 515;
    public static final int ERROR_CODE_OK = 0;
    public static final String SEARCH_AROUND_RANGE = "10000";
    public static final int SEARCH_MODE_MAX = 4;
    public static final int SEARCH_MODE_NONE = -1;
    public static final int SEARCH_MODE_OFFLINE_ADVANCED = 1;
    public static final int SEARCH_MODE_OFFLINE_ONLY = 3;
    public static final int SEARCH_MODE_ONLINE_ADVANCED = 0;
    public static final int SEARCH_MODE_ONLINE_ONLY = 2;
    private static final int SEARCH_RESULT_TYPE_OFFLINE = 0;
    private static final int SEARCH_RESULT_TYPE_ONLINE = 1;
    private static final L.Tag TAG = new L.Tag("SearchServiceWrapper");
    @NonNull
    private static SearchServiceWrapper sInstance = new SearchServiceWrapper();
    private SearchService mSearchService;
    private String[] mKeywordArray = null;
    private String[] mCategoryArray = null;
    private String[] mBlKeywordArray = null;
    private Hashtable<Integer, XPSearchResponse> mResponseTable = new Hashtable<>();
    final IGSearchSuggestionObserver mSuggestObserver = new IGSearchSuggestionObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.1
        @Override // com.autonavi.gbl.search.observer.IGSearchSuggestionObserver
        public void onGetSuggestionResult(int i, int i2, @Nullable SearchSuggestResult searchSuggestResult) {
            L.Tag tag = SearchServiceWrapper.TAG;
            L.i(tag, "onGetSuggestionResult " + i + "," + i2);
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetSuggestionResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchSuggestResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };
    final IGSearchKeyWordObserver mKeyWordObserver = new IGSearchKeyWordObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.2
        @Override // com.autonavi.gbl.search.observer.IGSearchKeyWordObserver
        public void onGetKeyWordResult(int i, int i2, @Nullable SearchKeywordResult searchKeywordResult) {
            L.Tag tag = SearchServiceWrapper.TAG;
            L.i(tag, "onGetKeyWordResult " + i + "," + i2);
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetKeyWordResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchKeywordResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };
    final IGSearchNearestObserver mNearestObserver = new IGSearchNearestObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.3
        @Override // com.autonavi.gbl.search.observer.IGSearchNearestObserver
        public void onGetNearestResult(int i, int i2, @Nullable SearchNearestResult searchNearestResult) {
            L.Tag tag = SearchServiceWrapper.TAG;
            L.i(tag, "onGetNearestResult " + i + "," + i2);
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetNearestResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchNearestResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };
    final IGSearchAroundRecommendObserver mAroundRecommendObserver = new IGSearchAroundRecommendObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.4
        @Override // com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver
        public void onGetAroundRecommendResult(int i, int i2, @Nullable SearchAroundRecommendResult searchAroundRecommendResult) {
            RecommendCategory recommendCategory;
            L.i(SearchServiceWrapper.TAG, "onGetAroundRecommendResult " + i + " " + i2);
            SearchResponseEvent searchResponseEvent = new SearchResponseEvent(10, null, i, i2);
            if (searchAroundRecommendResult == null) {
                L.i(SearchServiceWrapper.TAG, "searchAroundRecommendResult is NULL");
                EventBus.getDefault().post(searchResponseEvent);
                return;
            }
            ArrayList<RecommendCategory> arrayList = searchAroundRecommendResult.categories;
            if (arrayList == null) {
                L.i(SearchServiceWrapper.TAG, "recommendCategories is NULL");
                EventBus.getDefault().post(searchResponseEvent);
                return;
            }
            ArrayList<XPPoiInfo> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size() && (recommendCategory = arrayList.get(i3)) != null; i3++) {
                ArrayList<RecommendPoi> arrayList3 = recommendCategory.pois;
                if (arrayList3 != null) {
                    for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                        XPPoiInfo xPPoiInfo = new XPPoiInfo();
                        xPPoiInfo.setAdCode(Integer.valueOf(arrayList3.get(i3).adcode).intValue());
                        arrayList2.add(xPPoiInfo);
                    }
                }
            }
            searchResponseEvent.setList(arrayList2);
            EventBus.getDefault().post(searchResponseEvent);
        }
    };
    final IGSearchAlongWayObserver mAlonWayObserver = new IGSearchAlongWayObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.5
        @Override // com.autonavi.gbl.search.observer.IGSearchAlongWayObserver
        public void onGetAlongWayResult(int i, int i2, @Nullable SearchAlongWayResult searchAlongWayResult) {
            L.Tag tag = SearchServiceWrapper.TAG;
            L.i(tag, "onGetAlongWayResult " + i + "," + i2);
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetAlongWayResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchAlongWayResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };
    final IGSearchDeepInfoObserver mDeepInfoObserver = new IGSearchDeepInfoObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.6
        @Override // com.autonavi.gbl.search.observer.IGSearchDeepInfoObserver
        public void onGetDeepInfoResult(int i, int i2, @Nullable SearchDeepInfoResult searchDeepInfoResult) {
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetDeepInfoResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchDeepInfoResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };
    final IGSearchDetailInfoObserver mDetailInfoObserver = new IGSearchDetailInfoObserver() { // from class: com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper.7
        @Override // com.autonavi.gbl.search.observer.IGSearchDetailInfoObserver
        public void onGetDetailInfoResult(int i, int i2, @Nullable SearchDetailInfoResult searchDetailInfoResult) {
            XPSearchResponse xPSearchResponse = (XPSearchResponse) SearchServiceWrapper.this.mResponseTable.get(Integer.valueOf(i));
            if (xPSearchResponse == null) {
                L.w(SearchServiceWrapper.TAG, "onGetDetailInfoResult xpSearchResponse is null");
                return;
            }
            xPSearchResponse.parseBody(i, i2, searchDetailInfoResult);
            xPSearchResponse.release();
            SearchServiceWrapper.this.mResponseTable.remove(Integer.valueOf(i));
        }
    };

    public void init() {
    }

    private SearchServiceWrapper() {
        initService();
    }

    public static SearchServiceWrapper getInstance() {
        return sInstance;
    }

    private void initService() {
        if (this.mSearchService == null) {
            this.mSearchService = (SearchService) ServiceMgr.getServiceMgrInstance().getBLService(11);
            if (this.mSearchService == null) {
                L.e(TAG, "mSearchService init failed !");
                return;
            }
        }
        int isInit = this.mSearchService.isInit();
        if (isInit == 1) {
            L.i(TAG, "initService start Init!");
            this.mSearchService.init();
        } else if (isInit == 2) {
            L.w(TAG, "initService mSearchService is InitDoing!");
        } else {
            L.i(TAG, "initService mSearchService is InitDone!");
        }
    }

    private boolean isInit() {
        SearchService searchService = this.mSearchService;
        return searchService != null && searchService.isInit() == 3;
    }

    public void suggestSearch(@NonNull SearchSuggestParam searchSuggestParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        if (searchSuggestParam == null || xPSearchResponse == null) {
            return;
        }
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (i == -1) {
            i = getSearchMode();
        }
        int suggestionSearch = this.mSearchService.suggestionSearch(searchSuggestParam, this.mSuggestObserver, i, i2);
        L.Tag tag = TAG;
        L.i(tag, "suggestSearch " + searchSuggestParam.keyword + "," + i2 + "," + suggestionSearch);
    }

    public void keywordSearch(@NonNull SearchKeywordParam searchKeywordParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        if (searchKeywordParam == null || xPSearchResponse == null) {
            return;
        }
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (TextUtils.isEmpty(searchKeywordParam.category)) {
            String mapKeywordsToCategory = mapKeywordsToCategory(searchKeywordParam.keywords);
            if (!TextUtils.isEmpty(mapKeywordsToCategory)) {
                searchKeywordParam.category = mapKeywordsToCategory;
            }
        } else {
            String mapCategoryToKeyword = mapCategoryToKeyword(searchKeywordParam.category);
            if (!TextUtils.isEmpty(mapCategoryToKeyword)) {
                searchKeywordParam.keywords = mapCategoryToKeyword;
            }
        }
        if (i == -1) {
            i = getSearchMode();
        }
        int keyWordSearch = this.mSearchService.keyWordSearch(searchKeywordParam, this.mKeyWordObserver, i, i2);
        L.Tag tag = TAG;
        L.i(tag, "keywordSearch " + searchKeywordParam.keywords + "," + searchKeywordParam.category + "," + i2 + "," + keyWordSearch);
    }

    public void nearestSearch(SearchNearestParam searchNearestParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (i == -1) {
            i = getSearchMode();
        }
        this.mSearchService.nearestSearch(searchNearestParam, this.mNearestObserver, i, i2);
    }

    public void aroundRecommendSearch(String str, double d, double d2, int i, int i2) {
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "aroundRecommendSearch " + str + " " + d + " " + d2 + " " + i2);
        SearchAroundRecommendParam searchAroundRecommendParam = new SearchAroundRecommendParam();
        searchAroundRecommendParam.category = str;
        searchAroundRecommendParam.user_loc.lon = d;
        searchAroundRecommendParam.user_loc.lat = d2;
        searchAroundRecommendParam.range = i;
        searchAroundRecommendParam.pagesize = 20;
        this.mSearchService.aroundRecommendSearch(searchAroundRecommendParam, this.mAroundRecommendObserver, getSearchMode(), i2);
    }

    public void alongWaySearch(@NonNull SearchAlongWayParam searchAlongWayParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        if (searchAlongWayParam == null || xPSearchResponse == null) {
            return;
        }
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (i == -1) {
            i = getSearchMode();
        }
        int alongWaySearch = this.mSearchService.alongWaySearch(searchAlongWayParam, this.mAlonWayObserver, i, i2);
        L.Tag tag = TAG;
        L.i(tag, "alongWaySearch " + searchAlongWayParam.keyword + "," + searchAlongWayParam.category + "," + alongWaySearch);
    }

    @Nullable
    public String mapCategoryToKeyword(@NonNull String str) {
        if (CollectionUtils.isEmpty(this.mBlKeywordArray)) {
            this.mBlKeywordArray = ContextUtils.getStringArray(R.array.common_search_bl_keywords);
        }
        if (CollectionUtils.isEmpty(this.mCategoryArray)) {
            this.mCategoryArray = ContextUtils.getStringArray(R.array.common_search_keyword_categories);
        }
        if (!CollectionUtils.isEmpty(this.mBlKeywordArray) && !CollectionUtils.isEmpty(this.mCategoryArray) && this.mBlKeywordArray.length == this.mCategoryArray.length) {
            int i = 0;
            while (true) {
                String[] strArr = this.mCategoryArray;
                if (i >= strArr.length) {
                    break;
                } else if (strArr[i].equalsIgnoreCase(str)) {
                    return this.mBlKeywordArray[i];
                } else {
                    i++;
                }
            }
        }
        return null;
    }

    @Nullable
    public String mapKeywordsToCategory(@NonNull String str) {
        if (CollectionUtils.isEmpty(this.mKeywordArray) || CollectionUtils.isEmpty(this.mCategoryArray)) {
            this.mKeywordArray = ContextUtils.getStringArray(R.array.common_search_keywords);
            this.mCategoryArray = ContextUtils.getStringArray(R.array.common_search_keyword_categories);
        }
        if (!CollectionUtils.isEmpty(this.mKeywordArray) && !CollectionUtils.isEmpty(this.mCategoryArray)) {
            int i = 0;
            while (true) {
                String[] strArr = this.mKeywordArray;
                if (i >= strArr.length) {
                    break;
                }
                for (String str2 : strArr[i].split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                    if (str2.equalsIgnoreCase(str)) {
                        return this.mCategoryArray[i];
                    }
                }
                i++;
            }
        }
        return null;
    }

    @Nullable
    public String mapKeywordToCategoryForAlongWay(@NonNull String str) {
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            return mapKeywordToCategoryForAlongWayOnline(str);
        }
        return mapKeywordToCategoryForAlongWayOffline(str);
    }

    public String mapKeywordToCategoryForAlongWayOffline(@NonNull String str) {
        String[] stringArray = ContextUtils.getStringArray(R.array.along_way_offline_search_keywords);
        for (int i = 0; i < stringArray.length; i++) {
            for (String str2 : stringArray[i].split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                if (str2.equalsIgnoreCase(str)) {
                    return ContextUtils.getStringArray(R.array.along_way_offline_search_keyword_categories)[i];
                }
            }
        }
        return "";
    }

    public String mapKeywordToCategoryForAlongWayOnline(@NonNull String str) {
        String[] stringArray = ContextUtils.getStringArray(R.array.along_way_search_keywords);
        for (int i = 0; i < stringArray.length; i++) {
            for (String str2 : stringArray[i].split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                if (str2.equalsIgnoreCase(str)) {
                    return ContextUtils.getStringArray(R.array.along_way_search_keyword_categories)[i];
                }
            }
        }
        return "";
    }

    public void deepInfoSearch(SearchDeepInfoParam searchDeepInfoParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        if (searchDeepInfoParam == null || xPSearchResponse == null) {
            return;
        }
        if (!isInit()) {
            L.w(TAG, "search service not init");
            initService();
            return;
        }
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (i == -1) {
            i = getSearchMode();
        }
        this.mSearchService.deepInfoSearch(searchDeepInfoParam, this.mDeepInfoObserver, i, i2);
    }

    public void detailInfoSearch(SearchDetailInfoParam searchDetailInfoParam, int i, int i2, XPSearchResponse xPSearchResponse) {
        this.mResponseTable.put(Integer.valueOf(i2), xPSearchResponse);
        if (i == -1) {
            i = getSearchMode();
        }
        this.mSearchService.detailInfoSearch(searchDetailInfoParam, this.mDetailInfoObserver, i, i2);
    }

    public int abort(int i) {
        if (isInit()) {
            this.mResponseTable.remove(Integer.valueOf(i));
            return this.mSearchService.abort(i);
        }
        initService();
        return 0;
    }

    public int abortAll() {
        if (isInit()) {
            this.mResponseTable.clear();
            return this.mSearchService.abortAll();
        }
        initService();
        return 0;
    }

    private int getSearchMode() {
        return XPNetworkManager.INSTANCE.isNetworkConnected() ? 0 : 3;
    }
}
