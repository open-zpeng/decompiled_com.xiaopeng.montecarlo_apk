package com.xiaopeng.montecarlo.navcore.search.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchServiceWrapper;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchAlongWayParam;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class AlongWayRequest extends Request<Builder> {
    private static final L.Tag TAG = new L.Tag("AlongWayRequest");
    private XPSearchAlongWayParam mSearchAlongWayParam;

    public AlongWayRequest(Builder builder) {
        super(builder);
        this.mSearchAlongWayParam = new XPSearchAlongWayParam();
        setRequestId(builder.getRequestId());
        this.mSearchAlongWayParam.setKeyword(builder.mKeyword);
        if (!TextUtils.isEmpty(builder.mCategory)) {
            this.mSearchAlongWayParam.setCategory(builder.mCategory);
        }
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            this.mSearchAlongWayParam.mUserLoc.mLon = currentLocation.mLon;
            this.mSearchAlongWayParam.mUserLoc.mLat = currentLocation.mLat;
        }
        this.mSearchAlongWayParam.setGeoLine(getPathPoints());
        this.mSearchAlongWayParam.setGuideRoads(getPathIds());
        if (TextUtils.isEmpty(builder.mOrder)) {
            return;
        }
        setOrder(builder.mOrder);
    }

    public AlongWayRequest(int i, XPSearchAlongWayParam xPSearchAlongWayParam) {
        super(null);
        this.mSearchAlongWayParam = new XPSearchAlongWayParam();
        setRequestType(2);
        setRequestId(i);
        this.mSearchAlongWayParam = xPSearchAlongWayParam;
        if (TextUtils.isEmpty(this.mSearchAlongWayParam.getOrder())) {
            return;
        }
        setOrder(this.mSearchAlongWayParam.getOrder());
    }

    private String getPathPoints() {
        List<XPCoordinate2DDouble> currentRoutePoints = TBTManager.getInstance().getCurrentRoutePoints();
        if (CollectionUtils.isNotEmpty(currentRoutePoints)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentRoutePoints.size(); i++) {
                sb.append(currentRoutePoints.get(i).mLon);
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                sb.append(currentRoutePoints.get(i).mLat);
                if (i != currentRoutePoints.size() - 1) {
                    sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                }
            }
            String sb2 = sb.toString();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "getPathPoints result:" + sb2);
            }
            return sb2;
        }
        return null;
    }

    private XPSearchRoadId[] getPathIds() {
        return TBTManager.getInstance().getCurrentRoadIds();
    }

    public XPSearchAlongWayParam getSearchAlongWayParam() {
        return this.mSearchAlongWayParam;
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.request.Request
    public XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse) {
        SearchServiceWrapper.getInstance().alongWaySearch(this.mSearchAlongWayParam.toSearchAlongWayParam(), getSearchMode(), getRequestId(), xPSearchResponse);
        return null;
    }

    public void nextPage() {
        XPSearchAlongWayParam xPSearchAlongWayParam = this.mSearchAlongWayParam;
        if (xPSearchAlongWayParam != null) {
            xPSearchAlongWayParam.autoIncrementPageNum();
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseBuilder {
        private String mCategory;
        private String mKeyword;
        private String mOrder;

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

        @Override // com.xiaopeng.montecarlo.navcore.search.BaseBuilder, com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        public BaseBuilder orderPolicy(String str) {
            this.mOrder = str;
            return this;
        }

        @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
        @NonNull
        public Request build() {
            if (TextUtils.isEmpty(this.mKeyword)) {
                throw new IllegalStateException("mKeyword is null");
            }
            return new AlongWayRequest(this);
        }
    }
}
