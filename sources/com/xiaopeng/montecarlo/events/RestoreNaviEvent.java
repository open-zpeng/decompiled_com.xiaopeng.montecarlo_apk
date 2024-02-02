package com.xiaopeng.montecarlo.events;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
/* loaded from: classes2.dex */
public class RestoreNaviEvent {
    public static final int ACTION_RESTORE_CRUISE_INIT_STATE = 4;
    public static final int ACTION_RESTORE_REQUEST_PLATENO_FROM_VIN = 5;
    public static final int ACTION_SHOW_RECOMMEND_HOME_COMPANY = 3;
    public static final int ACTION_SHOW_RESTORE_COM_FORECAST = 2;
    public static final int ACTION_SHOW_RESTORE_NAV = 1;
    public static final int ACTION_SHOW_STOP_NAV = 0;
    private int mAction;
    private boolean mIsNeedRestore;
    private long mLastLeftDistance;
    private boolean mNeedConfirm;
    private RouteParams mRestoreRouteParams;

    private RestoreNaviEvent(Builder builder) {
        this.mAction = -1;
        this.mIsNeedRestore = false;
        this.mRestoreRouteParams = null;
        this.mNeedConfirm = false;
        this.mAction = builder.mAction;
        setNeedRestore(builder.mIsNeedRestore);
        setRestoreRouteParams(builder.mRestoreRouteParams);
        setNeedConfirm(builder.mNeedConfirm);
        setLastLeftDistance(builder.mLastLeftDistance);
    }

    public int getAction() {
        return this.mAction;
    }

    public boolean isNeedRestore() {
        return this.mIsNeedRestore;
    }

    public void setNeedRestore(boolean z) {
        this.mIsNeedRestore = z;
    }

    public RouteParams getRestoreRouteParams() {
        return this.mRestoreRouteParams;
    }

    public void setRestoreRouteParams(RouteParams routeParams) {
        this.mRestoreRouteParams = routeParams;
    }

    public boolean isNeedConfirm() {
        return this.mNeedConfirm;
    }

    public void setNeedConfirm(boolean z) {
        this.mNeedConfirm = z;
    }

    public long getLastLeftDistance() {
        return this.mLastLeftDistance;
    }

    public void setLastLeftDistance(long j) {
        this.mLastLeftDistance = j;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private int mAction;
        private boolean mIsNeedRestore;
        private long mLastLeftDistance;
        private boolean mNeedConfirm;
        private RouteParams mRestoreRouteParams;

        public Builder(int i) {
            this.mAction = i;
        }

        public Builder setIsNeedRestore(boolean z) {
            this.mIsNeedRestore = z;
            return this;
        }

        public Builder setRestoreRouteParams(RouteParams routeParams) {
            this.mRestoreRouteParams = routeParams;
            return this;
        }

        public Builder setNeedConfirm(boolean z) {
            this.mNeedConfirm = z;
            return this;
        }

        public Builder setLastLeftDistance(long j) {
            this.mLastLeftDistance = j;
            return this;
        }

        public RestoreNaviEvent build() {
            return new RestoreNaviEvent(this);
        }
    }
}
