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
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchSuggestParam;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
/* loaded from: classes2.dex */
public class SuggestSearchRequest extends Request<Builder> {
    protected static final int SUGGEST_TYPE_AROUND_SEARCH = 1;
    protected static final int SUGGEST_TYPE_BOX_SEARCH = 0;
    private XPSearchSuggestParam mSearchSuggestParam;

    public SuggestSearchRequest(Builder builder) {
        super(builder);
        Coord2DDouble lonLatFromCenter;
        this.mSearchSuggestParam = new XPSearchSuggestParam();
        this.mSearchSuggestParam.setKeyword(builder.mKeyword);
        setRequestId(builder.getRequestId());
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            this.mSearchSuggestParam.setUserLoc(new XPCoordinate2DDouble(currentLocation.mLon, currentLocation.mLat));
        }
        String mapKeywordsToCategory = SearchServiceWrapper.getInstance().mapKeywordsToCategory(builder.mKeyword);
        if (!TextUtils.isEmpty(mapKeywordsToCategory)) {
            this.mSearchSuggestParam.setCategory(mapKeywordsToCategory);
        }
        this.mSearchSuggestParam.setAdcode(true);
        if (builder.mPoiLocation == null) {
            IMapDelegate iMapDelegate = SearchClient.getInstance().getIMapDelegate();
            if (iMapDelegate != null && (lonLatFromCenter = iMapDelegate.getLonLatFromCenter()) != null) {
                XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble(lonLatFromCenter);
                this.mSearchSuggestParam.setPoiLoc(xPCoordinate2DDouble);
                int adCodeByLonLat = MapDataManager.getInstance().getAdCodeByLonLat(xPCoordinate2DDouble);
                this.mSearchSuggestParam.setCity(adCodeByLonLat);
                this.mSearchSuggestParam.setOfflineAdminCode(adCodeByLonLat);
            }
            this.mSearchSuggestParam.setSugType(0);
            return;
        }
        this.mSearchSuggestParam.setPoiLoc(builder.mPoiLocation);
        this.mSearchSuggestParam.setGeoobj(calcuGeoobj(builder.mPoiLocation));
        int adCodeByLonLat2 = MapDataManager.getInstance().getAdCodeByLonLat(builder.mPoiLocation);
        this.mSearchSuggestParam.setCity(adCodeByLonLat2);
        this.mSearchSuggestParam.setOfflineAdminCode(adCodeByLonLat2);
        this.mSearchSuggestParam.setSugType(1);
    }

    public XPSearchSuggestParam getSearchSuggestParam() {
        return this.mSearchSuggestParam;
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().suggestSearch(this.mSearchSuggestParam.toSearchSuggestParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseBuilder {
        private String mKeyword;
        private XPCoordinate2DDouble mPoiLocation = null;

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder keyword(String str) {
            this.mKeyword = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder poiLocation(@NonNull XPCoordinate2DDouble xPCoordinate2DDouble) {
            if (xPCoordinate2DDouble != null) {
                if (this.mPoiLocation == null) {
                    this.mPoiLocation = new XPCoordinate2DDouble();
                }
                this.mPoiLocation.mLat = xPCoordinate2DDouble.mLat;
                this.mPoiLocation.mLon = xPCoordinate2DDouble.mLon;
            }
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public Request build() {
            if (TextUtils.isEmpty(this.mKeyword)) {
                throw new IllegalStateException("mKeyword is null");
            }
            return new SuggestSearchRequest(this);
        }
    }
}
