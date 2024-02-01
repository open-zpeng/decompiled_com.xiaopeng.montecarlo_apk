package com.xiaopeng.montecarlo.navcore.search.request;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchNearestParam;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes3.dex */
public class NearestSearchRequest extends Request<Builder> {
    private XPSearchNearestParam mSearchNearestParam;

    public NearestSearchRequest(Builder builder) {
        super(builder);
        this.mSearchNearestParam = new XPSearchNearestParam();
        setRequestId(builder.getRequestId());
        if (builder.mPoiLocation != null) {
            this.mSearchNearestParam.setPoiLocation(builder.mPoiLocation);
        }
    }

    public XPSearchNearestParam getSearchNearestParam() {
        return this.mSearchNearestParam;
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().nearestSearch(this.mSearchNearestParam.toSearchNearestParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseBuilder {
        private XPCoordinate2DDouble mPoiLocation = null;

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
            if (this.mPoiLocation == null) {
                throw new IllegalStateException("mPoiLocation is null");
            }
            return new NearestSearchRequest(this);
        }
    }
}
