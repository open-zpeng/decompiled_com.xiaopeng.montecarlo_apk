package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class RouteResult {
    public RouteLimitInfo mExternData;
    public boolean mIsChange;
    public boolean mIsLocal;
    public volatile IPathResult mPathResult;
    public int mRouteMode;
    public int mRouteType;
    public List<RouteInfo> mRouteInfos = Collections.synchronizedList(new ArrayList());
    public int mErrorCode = -1;

    /* loaded from: classes3.dex */
    public static class RouteInfo {
        public XPCoordinate2DDouble mLastPoint;
        public List<XPLightBarItem> mLightBarItems;
        public long mPathId;
        public long mPathLength;
        public XPRestrictionInfo mRestrictionInfo;
        public int mTollCost;
        public long mTrafficLightCount;
        public long mTravelTime;
        public String mContentName = "";
        public List<Long> mViasDisList = new ArrayList();
        public List<XPOddInfo> mOddInfos = new CopyOnWriteArrayList();
    }

    public void removeRouteInfo(long j) {
        List<RouteInfo> list = this.mRouteInfos;
        if (list != null) {
            for (RouteInfo routeInfo : list) {
                if (j == routeInfo.mPathId) {
                    this.mRouteInfos.remove(routeInfo);
                    return;
                }
            }
        }
    }

    public RouteInfo getRouteInfo(int i) {
        List<RouteInfo> list = this.mRouteInfos;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.mRouteInfos.get(i);
    }

    /* loaded from: classes3.dex */
    public static class LccPathSimpleInfo {
        @RoadClass.RoadClass1
        private int mRoadClass = -1;
        private int mOwnerShip = -1;

        public void setRoadClass(int i) {
            this.mRoadClass = i;
        }

        public int getRoadClass() {
            return this.mRoadClass;
        }

        public void setOwnerShip(int i) {
            this.mOwnerShip = i;
        }

        public int getOwnerShip() {
            return this.mOwnerShip;
        }
    }
}
