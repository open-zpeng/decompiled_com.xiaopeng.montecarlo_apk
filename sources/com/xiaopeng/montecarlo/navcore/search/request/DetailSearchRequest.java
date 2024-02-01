package com.xiaopeng.montecarlo.navcore.search.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchDetailParam;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes3.dex */
public class DetailSearchRequest extends Request<Builder> {
    private XPSearchDetailParam mSearchDetailParam;

    public DetailSearchRequest(Builder builder) {
        super(builder);
        this.mSearchDetailParam = new XPSearchDetailParam();
        setRequestId(builder.getRequestId());
        this.mSearchDetailParam.setPoiId(builder.mPoiId);
        this.mSearchDetailParam.setPoiName(builder.mPoiName);
        if (builder.mPoiLocation != null) {
            this.mSearchDetailParam.setPoiLocation(new XPCoordinate2DDouble(builder.mPoiLocation.mLon, builder.mPoiLocation.mLat));
            this.mSearchDetailParam.setUserLocation(new XPCoordinate2DDouble(builder.mPoiLocation.mLon, builder.mPoiLocation.mLat));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().detailInfoSearch(this.mSearchDetailParam.toSearchDetailInfoParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseBuilder {
        private String mPoiId;
        private String mPoiName;
        private XPCoordinate2DDouble mUserLocation = null;
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

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder poiId(String str) {
            this.mPoiId = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder poiName(String str) {
            this.mPoiName = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public Request build() {
            if (TextUtils.isEmpty(this.mPoiId)) {
                throw new IllegalStateException("mPoiId is null");
            }
            return new DetailSearchRequest(this);
        }
    }
}
