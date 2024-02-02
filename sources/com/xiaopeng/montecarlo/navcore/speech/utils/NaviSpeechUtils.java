package com.xiaopeng.montecarlo.navcore.speech.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.node.navi.NaviNode;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviSpeechUtils {
    private static final String INVALID_STRING = "";
    private static final L.Tag TAG = new L.Tag("NaviSpeechUtils");
    private static PageType sPageType = PageType.NONE;
    private static NaviNode sNaviNode = new NaviNode();

    @NonNull
    public static PageType getPageType() {
        return sPageType;
    }

    public static void setPageType(@NonNull PageType pageType) {
        sPageType = pageType;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPageType " + pageType);
        }
    }

    public static boolean isSelectRecommendParkEnable(int i) {
        return i > 0 && i <= TBTManager.getInstance().getRecommendParkingNum();
    }

    public static boolean isStartNaviEnable(int i) {
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult == null || routeResult.mPathResult == null) {
            return false;
        }
        return i > 0 && ((long) i) <= routeResult.mPathResult.getPathCount();
    }

    public static boolean isSelectRouteEnable(int i) {
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult == null || routeResult.mPathResult == null) {
            return false;
        }
        return i > 0 && ((long) i) <= routeResult.mPathResult.getPathCount();
    }

    public static int getPathIndex() {
        return TBTManager.getInstance().getCurrentRoutePathIndex();
    }

    @Nullable
    public static IVariantPath getCurrentVariantPath() {
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult == null || routeResult.mPathResult == null) {
            return null;
        }
        return routeResult.mPathResult.getPath(TBTManager.getInstance().getCurrentRoutePathIndex());
    }

    public static boolean isRouteSuccess() {
        return TBTManager.getInstance().getCurrentRouteRequestId() != -1;
    }

    public static int getCityAdCode(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return MapDataManager.getInstance().getAdCodeByLonLat(xPCoordinate2DDouble);
    }

    public static boolean isNavigation() {
        return TBTManager.getInstance().getCurrentStatus() != 0;
    }

    public static void selectRecommendParking(int i) {
        if (TBTManager.getInstance().getRecommendParkingHelper() != null) {
            TBTManager.getInstance().getRecommendParkingHelper().selectRecommendParking(i);
        }
    }

    public static int getMaxViaSize() {
        return TBTManager.getInstance().getMaxViaSize();
    }

    public static List<XPViaPoint> getViaInfos() {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        if (currentNaviId != -1) {
            return TBTManager.getInstance().getViaInfos(currentNaviId);
        }
        return null;
    }

    public static XPPoiInfo getEndInfo() {
        return TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
    }

    public static boolean isExistRoute() {
        return TBTManager.getInstance().isExistRoute();
    }

    public static void postWaypointSearchResult(String str, List<PoiBean> list) {
        sNaviNode.postWaypointSearchResult(str, list);
    }

    public static void postWaypointsNotExitRoute(String str) {
        sNaviNode.postWaypointsNotExitRoute(str);
    }

    public static void postWaypointListFull(String str) {
        sNaviNode.postWaypointsFull(str);
    }

    public static void postPoiResult(String str, List<PoiBean> list) {
        if (list == null) {
            sNaviNode.postPoiResult(str, new ArrayList());
        } else {
            sNaviNode.postPoiResult(str, list);
        }
    }

    public static void postNearbyResult(String str, List<PoiBean> list) {
        if (list == null) {
            sNaviNode.postNearbyResult(str, new ArrayList());
        } else {
            sNaviNode.postNearbyResult(str, list);
        }
    }

    public static void postRouteNearbyResult(String str, List<PoiBean> list) {
        if (list == null) {
            sNaviNode.postSearchPoiResult("native://navi.route.nearby.search", str, new ArrayList());
        } else {
            sNaviNode.postSearchPoiResult("native://navi.route.nearby.search", str, list);
        }
    }

    public static List<PoiBean> xpPoiInfos2PoiBeans(@NonNull ArrayList<XPPoiInfo> arrayList, XPCoordinate2DDouble xPCoordinate2DDouble) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            XPPoiInfo xPPoiInfo = arrayList.get(i);
            long j = 0;
            if (xPCoordinate2DDouble != null) {
                j = (long) LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), xPCoordinate2DDouble);
            }
            arrayList2.add(arrayList.get(i).toPoiBean(ContextUtils.getContext(), j));
        }
        return arrayList2;
    }
}
