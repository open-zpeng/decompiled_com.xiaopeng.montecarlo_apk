package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
/* loaded from: classes2.dex */
public class NaviPresenterData {
    private boolean mIsFilterCharge;
    private boolean mIsFirstEnter;
    private boolean mIsFromCommuting;
    private boolean mIsManual;
    private boolean mIsNeedStartNavi;
    private boolean mIsNeedTTSProxySpeak;
    private boolean mIsNeedToSrNav;
    private boolean mIsRequestRestrict;
    private long mNaviId;
    private int mOfflineRemainCount;
    private int mPathIndex;
    private int mRequestType;
    private RouteRequest mRouteRequest;

    private NaviPresenterData(Builder builder) {
        this.mIsFilterCharge = true;
        this.mIsRequestRestrict = true;
        this.mIsNeedToSrNav = false;
        this.mRouteRequest = builder.mRouteRequest;
        this.mNaviId = builder.mNaviId;
        this.mPathIndex = builder.mPathIndex;
        this.mIsFromCommuting = builder.mIsFromCommuting;
        this.mOfflineRemainCount = builder.mOfflineRemainCount;
        this.mIsFirstEnter = builder.mIsFirstEnter;
        this.mIsNeedStartNavi = builder.mIsNeedStartNavi;
        this.mIsManual = builder.mIsManual;
        this.mIsNeedTTSProxySpeak = builder.mIsNeedTTSProxySpeak;
        this.mIsRequestRestrict = builder.mIsRequestRestrict;
        this.mRequestType = builder.mRequestType;
        this.mIsFilterCharge = builder.mIsFilterCharge;
        this.mIsNeedToSrNav = builder.mIsNeedToSrNav;
    }

    public RouteRequest getRouteRequest() {
        return this.mRouteRequest;
    }

    public long getNaviId() {
        return this.mNaviId;
    }

    public int getPathIndex() {
        return this.mPathIndex;
    }

    public boolean getIsFromCommuting() {
        return this.mIsFromCommuting;
    }

    public int getOfflineRemainCount() {
        return this.mOfflineRemainCount;
    }

    public boolean getIsFirstEnter() {
        return this.mIsFirstEnter;
    }

    public boolean getIsNeedStartNavi() {
        return this.mIsNeedStartNavi;
    }

    public boolean getIsManual() {
        return this.mIsManual;
    }

    public boolean getIsNeedTTSProxySpeak() {
        return this.mIsNeedTTSProxySpeak;
    }

    public boolean getIsFilterCharge() {
        return this.mIsFilterCharge;
    }

    public boolean getIsReqRestrict() {
        return this.mIsRequestRestrict;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public boolean getIsNeedToSrNav() {
        return this.mIsNeedToSrNav;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private int mRequestType;
        public int mOfflineRemainCount = -1;
        private RouteRequest mRouteRequest = null;
        private long mNaviId = -1;
        private int mPathIndex = 0;
        private boolean mIsFromCommuting = false;
        private boolean mIsFirstEnter = true;
        private boolean mIsNeedStartNavi = true;
        private boolean mIsManual = false;
        private boolean mIsNeedTTSProxySpeak = false;
        private boolean mIsFilterCharge = true;
        private boolean mIsRequestRestrict = true;
        private boolean mIsNeedToSrNav = false;

        public NaviPresenterData build() {
            return new NaviPresenterData(this);
        }

        public Builder setRouterRequest(RouteRequest routeRequest) {
            this.mRouteRequest = routeRequest;
            return this;
        }

        public Builder setNaviId(long j) {
            this.mNaviId = j;
            return this;
        }

        public Builder setPathIndex(int i) {
            this.mPathIndex = i;
            return this;
        }

        public Builder setCommutingState(boolean z) {
            this.mIsFromCommuting = z;
            return this;
        }

        public Builder setOfflineRemainCount(int i) {
            this.mOfflineRemainCount = i;
            return this;
        }

        public Builder setIsFirstEnter(boolean z) {
            this.mIsFirstEnter = z;
            return this;
        }

        public Builder setIsNeedStartNavi(boolean z) {
            this.mIsNeedStartNavi = z;
            return this;
        }

        public Builder setIsManual(boolean z) {
            this.mIsManual = z;
            return this;
        }

        public Builder setIsNeedTTSProxySpeak(boolean z) {
            this.mIsNeedTTSProxySpeak = z;
            return this;
        }

        public Builder setIsFilterCharge(boolean z) {
            this.mIsFilterCharge = z;
            return this;
        }

        public Builder setIsRequestRestrict(boolean z) {
            this.mIsRequestRestrict = z;
            return this;
        }

        public Builder setRequestType(int i) {
            this.mRequestType = i;
            return this;
        }

        public Builder setIsNeedToSrNav(boolean z) {
            this.mIsNeedToSrNav = z;
            return this;
        }
    }
}
