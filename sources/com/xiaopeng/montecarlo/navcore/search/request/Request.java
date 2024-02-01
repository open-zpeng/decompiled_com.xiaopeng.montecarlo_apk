package com.xiaopeng.montecarlo.navcore.search.request;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.BaseBuilder;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.response.XPSearchResponse;
/* loaded from: classes3.dex */
public abstract class Request<T extends BaseBuilder> {
    protected static final int DEFAULT_OFFLINE_SIZE = 50;
    protected static final int DEFAULT_PAGE_SIZE = 20;
    protected static final double SEARCH_RADIUS = 0.1d;
    private String mOrders;
    private int mRequestId;
    private int mRequestType;
    private int mSearchMode = -1;

    /* loaded from: classes3.dex */
    interface Runnable {
        void run(XPSearchResult xPSearchResult);
    }

    public abstract XPSearchResult execute(@NonNull XPSearchResponse xPSearchResponse);

    public Request(T t) {
        setRequestId(SearchClient.getInstance().getRequestId());
        if (t != null) {
            setRequestType(t.getRequestType());
            setSearchMode(t.getSearchMode());
        }
    }

    public void setSearchMode(int i) {
        this.mSearchMode = i;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(int i) {
        this.mRequestId = i;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void setRequestType(int i) {
        this.mRequestType = i;
    }

    public String getOrder() {
        return this.mOrders;
    }

    public void setOrder(String str) {
        this.mOrders = str;
    }

    public String calcuGeoobj(XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (xPCoordinate2DDouble == null) {
            return "";
        }
        return "" + (xPCoordinate2DDouble.mLon - SEARCH_RADIUS) + LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR + (xPCoordinate2DDouble.mLat - SEARCH_RADIUS) + LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR + (xPCoordinate2DDouble.mLon + SEARCH_RADIUS) + LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR + (xPCoordinate2DDouble.mLat + SEARCH_RADIUS);
    }
}
