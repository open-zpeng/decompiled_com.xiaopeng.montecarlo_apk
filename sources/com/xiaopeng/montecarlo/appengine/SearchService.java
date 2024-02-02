package com.xiaopeng.montecarlo.appengine;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.ResponseCallback;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SearchService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("SearchService");

    @Publish
    public String searchByBL(String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            L.Tag tag = TAG;
            L.i(tag, "searchByBL requestJson:" + str);
            int requestId = SearchClient.getInstance().getRequestId();
            SearchClient.getInstance().enqueue(buildSearchRequest((SearchParam) GsonUtil.fromJson(str, (Class<Object>) SearchParam.class), requestId), new ResponseCallback() { // from class: com.xiaopeng.montecarlo.appengine.-$$Lambda$SearchService$dZsRYuw9ZXMKPxtQTClKC-AMw0Q
                @Override // com.xiaopeng.montecarlo.navcore.search.ResponseCallback
                public final void onResponse(Request request, XPSearchResult xPSearchResult) {
                    SearchService.lambda$searchByBL$0(str2, request, xPSearchResult);
                }
            });
            return String.valueOf(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$searchByBL$0(String str, Request request, XPSearchResult xPSearchResult) {
        SearchResponse parseSearchResult = SearchResponse.parseSearchResult(request.getRequestId(), xPSearchResult);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "fetchKeywordPoiInfo onResponse：" + GsonUtil.toJson(parseSearchResult));
        }
        try {
            ApiRouter.route(Uri.parse(str).buildUpon().appendQueryParameter("requestId", String.valueOf(request.getRequestId())).appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, GsonUtil.toJson(parseSearchResult)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Request<BaseBuilder> buildSearchRequest(@NonNull SearchParam searchParam, int i) {
        String str;
        if (TextUtils.isEmpty(searchParam.keyword)) {
            str = null;
        } else if (searchParam.searchType == 4) {
            str = generateCategoryForAlongWaySearch(searchParam.keyword, searchParam.offline);
            if (TextUtils.isEmpty(str)) {
                searchParam.searchType = 2;
            }
        } else {
            str = XPOfflineDataManager.getInstance().keyword2Category(searchParam.keyword);
        }
        int transformRequestType = SearchParam.transformRequestType(searchParam.searchType);
        if (transformRequestType == -1) {
            throw new IllegalArgumentException("unSupported searchType:" + searchParam.searchType);
        }
        BaseBuilder newBuilder = new RequestFactory(transformRequestType).newBuilder();
        newBuilder.requestId(i);
        newBuilder.keyword(searchParam.keyword);
        newBuilder.category(str);
        if (transformRequestType == 1) {
            newBuilder.searchType(SearchParam.transformKeywordSearchType(searchParam.searchType));
        }
        if (searchParam.poi != null) {
            newBuilder.poiId(searchParam.poi.id);
            newBuilder.poiName(searchParam.poi.name);
            if (searchParam.poi.lat != 0.0d && searchParam.poi.lon != 0.0d) {
                newBuilder.poiLocation(new XPCoordinate2DDouble(searchParam.poi.lon, searchParam.poi.lat));
            }
        } else if (searchParam.searchType == 2) {
            XPCarLocation currentCarLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation();
            if (currentCarLocation == null) {
                L.e(TAG, "no currentCarLocation!");
            } else {
                newBuilder.poiLocation(new XPCoordinate2DDouble(currentCarLocation.mLongitude, currentCarLocation.mLatitude));
            }
        }
        if (searchParam.pageSize > 0) {
            newBuilder.pageSize(searchParam.pageSize);
        }
        if (searchParam.radius > 0) {
            newBuilder.radius(String.valueOf(searchParam.radius));
        }
        newBuilder.searchMode(searchParam.offline);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.i(tag, "buildSearchRequest:" + GsonUtil.toJson(newBuilder));
        }
        return newBuilder.build();
    }

    private String generateCategoryForAlongWaySearch(String str, int i) {
        if (i == 3) {
            return SearchServiceWrapper.getInstance().mapKeywordToCategoryForAlongWayOffline(str);
        }
        return SearchServiceWrapper.getInstance().mapKeywordToCategoryForAlongWay(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SearchParam {
        public static final int TYPE_ALONG_WAY_SEARCH = 4;
        public static final int TYPE_KEYWORD_AROUND_SEARCH = 2;
        public static final int TYPE_KEYWORD_SEARCH = 1;
        public static final int TYPE_NEAREST_SEARCH = 6;
        public static final int TYPE_POI_DETAIL_SEARCH = 3;
        public static final int TYPE_PRE_SEARCH = 5;
        String keyword;
        int offline;
        int order;
        int pageSize;
        Poi poi;
        int radius;
        int searchType;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface SearchType {
        }

        public static String transformKeywordSearchType(int i) {
            return i == 1 ? KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD : i == 2 ? KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND : "";
        }

        public static int transformRequestType(int i) {
            if (i == 1 || i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
            if (i == 5) {
                return 4;
            }
            return i == 6 ? 5 : -1;
        }

        SearchParam() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Poi {
        String address;
        double disLat;
        double disLon;
        double distance;
        String id;
        double lat;
        double lon;
        String name;
        double navLat;
        double navLon;

        Poi() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SearchResponse {
        List<Poi> poiList;
        int requestId;
        int responseCode;

        SearchResponse() {
        }

        public static SearchResponse parseSearchResult(int i, @Nullable XPSearchResult xPSearchResult) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.requestId = i;
            if (xPSearchResult == null) {
                searchResponse.responseCode = 0;
            } else {
                searchResponse.responseCode = xPSearchResult.getResultCode();
                List<XPPoiInfo> xPPoiInfos = xPSearchResult.getXPPoiInfos();
                if (xPPoiInfos != null) {
                    searchResponse.poiList = new ArrayList();
                    for (XPPoiInfo xPPoiInfo : xPPoiInfos) {
                        Poi poi = new Poi();
                        poi.id = xPPoiInfo.getPoiId();
                        poi.name = xPPoiInfo.getName();
                        poi.address = xPPoiInfo.getAddress();
                        poi.disLon = xPPoiInfo.getDisplayLon();
                        poi.disLat = xPPoiInfo.getDisplayLat();
                        poi.navLon = xPPoiInfo.getNaviLon();
                        poi.navLat = xPPoiInfo.getNaviLat();
                        poi.distance = xPPoiInfo.getDistance();
                        searchResponse.poiList.add(poi);
                    }
                }
            }
            return searchResponse;
        }
    }
}
