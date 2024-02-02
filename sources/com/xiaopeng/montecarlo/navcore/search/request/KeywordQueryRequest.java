package com.xiaopeng.montecarlo.navcore.search.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchKeywordParam;
import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
/* loaded from: classes2.dex */
public class KeywordQueryRequest extends Request<Builder> {
    protected static final int KEYWORD_SEARCH_OPERATE_AROUND = 2;
    protected static final int KEYWORD_SEARCH_OPERATE_SEARCH_ALL = 1;
    protected static final int KEYWORD_SEARCH_OPERATE_UNKNOWN = 0;
    protected static final int KEYWORD_SEARCH_SORT_DISTANCE = 1;
    protected static final int KEYWORD_SEARCH_SORT_MIX = 0;
    protected XPSearchKeywordParam mKeywordParam;

    public KeywordQueryRequest(Builder builder) {
        super(builder);
        Coord2DDouble lonLatFromCenter;
        this.mKeywordParam = new XPSearchKeywordParam();
        setRequestId(builder.getRequestId());
        this.mKeywordParam.setQueryType(builder.mSearchType);
        this.mKeywordParam.setKeywords(builder.mKeyword);
        this.mKeywordParam.setCategory(builder.mCategory);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            this.mKeywordParam.setUserLoc(new XPCoordinate2DDouble(currentLocation.mLon, currentLocation.mLat));
        }
        if (this.mKeywordParam.getQueryType().equals(KeywordSearchType.KEYWORD_SEARCH_TYPE_AROUND)) {
            this.mKeywordParam.setSearchOperate(2);
            if (builder.mPoiLocation != null) {
                this.mKeywordParam.setPoiLoc(builder.mPoiLocation);
                this.mKeywordParam.setAdCode(MapDataManager.getInstance().getAdCodeByLonLat(builder.mPoiLocation));
            }
            this.mKeywordParam.setRange(builder.mRadius);
            if (builder.mSize <= 0) {
                this.mKeywordParam.setPageSize(20);
            } else {
                this.mKeywordParam.setPageSize(builder.mSize);
            }
            this.mKeywordParam.setSortRule(1);
            this.mKeywordParam.setAddrPoiMerge(true);
            this.mKeywordParam.setOfflineResultMaxCount(50);
        } else if (this.mKeywordParam.getQueryType().equals(KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD)) {
            IMapDelegate iMapDelegate = SearchClient.getInstance().getIMapDelegate();
            if (iMapDelegate != null && (lonLatFromCenter = iMapDelegate.getLonLatFromCenter()) != null) {
                this.mKeywordParam.setPoiLoc(new XPCoordinate2DDouble(lonLatFromCenter));
                XPSearchKeywordParam xPSearchKeywordParam = this.mKeywordParam;
                xPSearchKeywordParam.setGeoobj(calcuGeoobj(xPSearchKeywordParam.getPoiLoc()));
                int adCodeByLonLat = MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(lonLatFromCenter));
                this.mKeywordParam.setCity(String.valueOf(adCodeByLonLat));
                this.mKeywordParam.setAdCode(adCodeByLonLat);
            }
            this.mKeywordParam.setSearchOperate(1);
            this.mKeywordParam.setSortRule(0);
            if (builder.mSize <= 0) {
                this.mKeywordParam.setPageSize(20);
            } else {
                this.mKeywordParam.setPageSize(builder.mSize);
            }
            this.mKeywordParam.setOfflineResultMaxCount(50);
        } else if (this.mKeywordParam.getQueryType().equals(KeywordSearchType.KEYWORD_SEARCH_TYPE_POI)) {
            this.mKeywordParam.setId(builder.mPoiId);
            this.mKeywordParam.setPoiLoc(builder.mPoiLocation);
        }
    }

    public KeywordQueryRequest(int i, XPSearchKeywordParam xPSearchKeywordParam) {
        super(null);
        this.mKeywordParam = new XPSearchKeywordParam();
        setRequestType(1);
        setRequestId(i);
        this.mKeywordParam = xPSearchKeywordParam;
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().keywordSearch(this.mKeywordParam.toSearchKeywordParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    public XPSearchKeywordParam getKeywordParam() {
        return this.mKeywordParam;
    }

    public void nextPage() {
        XPSearchKeywordParam xPSearchKeywordParam = this.mKeywordParam;
        if (xPSearchKeywordParam != null) {
            xPSearchKeywordParam.autoIncrementPageNum();
        }
    }

    public boolean isPaging() {
        XPSearchKeywordParam xPSearchKeywordParam = this.mKeywordParam;
        return xPSearchKeywordParam != null && xPSearchKeywordParam.getPageNum() > 1;
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseBuilder {
        private String mCategory;
        private String mKeyword;
        private String mPoiId;
        private XPCoordinate2DDouble mPoiLocation = null;
        private String mRadius;
        private String mSearchType;
        private int mSize;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder searchType(String str) {
            this.mSearchType = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public BaseBuilder keyword(String str) {
            this.mKeyword = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public BaseBuilder category(String str) {
            this.mCategory = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder poiId(String str) {
            this.mPoiId = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder radius(String str) {
            this.mRadius = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder poiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
            this.mPoiLocation = xPCoordinate2DDouble;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder pageSize(int i) {
            this.mSize = i;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public Request build() {
            if (TextUtils.isEmpty(this.mSearchType)) {
                throw new IllegalStateException("searchType can not be empty");
            }
            return new KeywordQueryRequest(this);
        }
    }
}
