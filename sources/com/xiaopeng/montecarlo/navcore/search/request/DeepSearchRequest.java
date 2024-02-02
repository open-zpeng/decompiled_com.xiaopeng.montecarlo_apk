package com.xiaopeng.montecarlo.navcore.search.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchDeepParam;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes2.dex */
public class DeepSearchRequest extends Request<Builder> {
    private XPSearchDeepParam mSearchDeepParam;

    public DeepSearchRequest(Builder builder) {
        super(builder);
        this.mSearchDeepParam = new XPSearchDeepParam();
        setRequestId(builder.getRequestId());
        this.mSearchDeepParam.setPoiId(builder.mPoiId);
        if (builder.mPoiLocation != null) {
            this.mSearchDeepParam.setPoiLocation(new XPCoordinate2DDouble(builder.mPoiLocation.mLon, builder.mPoiLocation.mLat));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().deepInfoSearch(this.mSearchDeepParam.toSearchDeepInfoParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseBuilder {
        private String mPoiId;
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

        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public Request build() {
            if (TextUtils.isEmpty(this.mPoiId)) {
                throw new IllegalStateException("mPoiId is null");
            }
            return new DeepSearchRequest(this);
        }
    }
}
