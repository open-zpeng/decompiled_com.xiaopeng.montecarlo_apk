package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.autonavi.gbl.common.path.option.RouteOption;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class RouteParams implements Serializable {
    public static final int REQUEST_PRIORITY_DEST_OR_WAYPOINT = 2;
    public static final int REQUEST_PRIORITY_NORMAL = 0;
    public static final int REQUEST_PRIORITY_REROUTE = 1;
    public static final int ROUTE_NETWORK_PROPERTY_OFFLINE = 0;
    public static final int ROUTE_NETWORK_PROPERTY_ONLINE = 1;
    public static final int ROUTE_NETWORK_PROPERTY_ONLINE_FIRST = 2;
    private static final long serialVersionUID = 7899910264017717976L;
    public boolean mChargeFiltered;
    public int mConstrainCode;
    public boolean mCurRequestIsOnline;
    public XPPoiInfo mEndInfo;
    public int mFakeRerouteType;
    public boolean mHaveOddInfo;
    public boolean mIsCanCancel;
    public boolean mIsFakeReroute;
    public boolean mIsFilterCharge;
    public boolean mIsOddMergeResp;
    public boolean mIsRequestOdd;
    public int mNetworkProperty;
    public transient RouteOption mRerouteOption;
    public int mRerouteType;
    public XPRestoreRouteData mRestoreRouteData;
    public boolean mRestoring;
    public int mRouteCalcType;
    public String mRouteContent;
    public int mRoutePreference;
    public int mRoutePriority;
    public XPPoiInfo mStartInfo;
    public List<XPViaPoint> mViaInfos;

    public String toString() {
        return "RouteParams{mStartInfo=" + this.mStartInfo + ", mEndInfo=" + this.mEndInfo + ", mViaInfos=" + this.mViaInfos + ", mRouteCalcType=" + this.mRouteCalcType + ", mConstrainCode=" + this.mConstrainCode + ", mRerouteType=" + this.mRerouteType + ", mRouteContent='" + this.mRouteContent + "', mNetworkProperty=" + this.mNetworkProperty + ", mRoutePreference=" + this.mRoutePreference + ", mRoutePriority=" + this.mRoutePriority + ", mCurRequestIsOnline=" + this.mCurRequestIsOnline + ", mIsCanCancel=" + this.mIsCanCancel + ", mRerouteOption=" + this.mRerouteOption + ", mIsFakeReroute=" + this.mIsFakeReroute + ", mFakeRerouteType=" + this.mFakeRerouteType + ", mChargeFiltered=" + this.mChargeFiltered + ", mIsFilterCharge=" + this.mIsFilterCharge + ", mIsRequestOdd=" + this.mIsRequestOdd + ", mIsOddMergeResp=" + this.mIsOddMergeResp + '}';
    }

    private RouteParams(Builder builder) {
        this.mHaveOddInfo = false;
        this.mRestoring = false;
        this.mRestoreRouteData = new XPRestoreRouteData();
        this.mIsFakeReroute = false;
        this.mFakeRerouteType = -1;
        this.mChargeFiltered = false;
        this.mIsFilterCharge = true;
        this.mIsRequestOdd = false;
        this.mIsOddMergeResp = false;
        this.mStartInfo = builder.mStartXP;
        this.mEndInfo = builder.mEndXP;
        this.mViaInfos = builder.mViaInfos;
        this.mRouteCalcType = builder.mRouteCalcType;
        this.mConstrainCode = builder.mConstrainCode;
        this.mRerouteType = builder.mRerouteType;
        this.mRouteContent = builder.mRouteContent;
        this.mNetworkProperty = builder.mNetworkProperty;
        this.mRoutePreference = builder.mRoutePreference;
        this.mRoutePriority = builder.mRouteLevel;
        this.mCurRequestIsOnline = builder.mCurRequestIsOnline;
        this.mIsCanCancel = builder.mIsCanCancel;
        this.mRerouteOption = builder.mRerouteOption;
        this.mIsFilterCharge = builder.mIsFilterCharge;
        this.mIsRequestOdd = builder.mIsRequestOdd;
        this.mIsOddMergeResp = builder.mIsOddMergeResp;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean mIsOddMergeResp;
        private boolean mIsRequestOdd;
        private boolean mIsFilterCharge = true;
        private XPPoiInfo mStartXP = null;
        private XPPoiInfo mEndXP = null;
        private List<XPViaPoint> mViaInfos = null;
        private int mRouteCalcType = -1;
        private int mConstrainCode = -1;
        private int mRerouteType = 1;
        private String mRouteContent = "";
        private int mNetworkProperty = 2;
        private int mRoutePreference = -1;
        private int mRouteLevel = 0;
        private boolean mCurRequestIsOnline = true;
        private boolean mIsCanCancel = true;
        private RouteOption mRerouteOption = null;

        public Builder() {
            this.mIsRequestOdd = false;
            this.mIsOddMergeResp = false;
            this.mIsRequestOdd = false;
            this.mIsOddMergeResp = false;
        }

        public Builder setStartInfo(XPPoiInfo xPPoiInfo) {
            this.mStartXP = xPPoiInfo;
            return this;
        }

        public Builder setEndInfo(XPPoiInfo xPPoiInfo) {
            this.mEndXP = xPPoiInfo;
            return this;
        }

        public Builder setViaInfos(List<XPViaPoint> list) {
            this.mViaInfos = list;
            return this;
        }

        public Builder setRouteCalcType(int i) {
            this.mRouteCalcType = i;
            return this;
        }

        public Builder setConstrainCode(int i) {
            this.mConstrainCode = i;
            return this;
        }

        public Builder setRerouteType(int i) {
            this.mRerouteType = i;
            return this;
        }

        public Builder setNetworkProperty(int i) {
            this.mNetworkProperty = i;
            return this;
        }

        public Builder setRoutePreference(int i) {
            if (i <= 0) {
                i = -1;
            }
            this.mRoutePreference = i;
            return this;
        }

        public Builder setRouteLevel(int i) {
            this.mRouteLevel = i;
            return this;
        }

        public Builder setCurRequestIsOnline(boolean z) {
            this.mCurRequestIsOnline = z;
            return this;
        }

        public Builder setCanCancel(boolean z) {
            this.mIsCanCancel = z;
            return this;
        }

        public Builder setRouteContent(String str) {
            this.mRouteContent = str;
            return this;
        }

        public Builder setRerouteOption(RouteOption routeOption) {
            this.mRerouteOption = routeOption;
            return this;
        }

        public Builder setIsFilterCharge(boolean z) {
            this.mIsFilterCharge = z;
            return this;
        }

        public Builder setIsRequestOdd(boolean z) {
            this.mIsRequestOdd = z;
            return this;
        }

        public Builder setIsOddMergeResp(boolean z) {
            this.mIsOddMergeResp = z;
            return this;
        }

        public RouteParams build() {
            return new RouteParams(this);
        }
    }
}
