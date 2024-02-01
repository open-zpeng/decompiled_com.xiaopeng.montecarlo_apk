package com.xiaopeng.montecarlo.stat;

import android.content.Context;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
/* loaded from: classes3.dex */
public class NaviStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("NaviStatUtil");

    static /* synthetic */ float access$000() {
        return getCarSpeed();
    }

    public static void sendStatDataWhenSystemStartNavi(Context context, MainContext mainContext, XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble, final XPPoiInfo xPPoiInfo2, boolean z, final RouteParams routeParams) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSystemStartNavi mainContext:" + mainContext + ",poiInfo:" + xPPoiInfo + ",carLocation:" + xPCoordinate2DDouble + ",end:" + xPPoiInfo2);
        }
        if (mainContext == null || xPPoiInfo == null || xPCoordinate2DDouble == null || xPPoiInfo2 == null || routeParams == null) {
            return;
        }
        final PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenSystemStartNavi failure pageType:" + pageType);
                return;
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        final StringBuilder sb2 = new StringBuilder();
        sb.append(xPCoordinate2DDouble.mLon);
        sb.append(",");
        sb.append(xPCoordinate2DDouble.mLat);
        sb2.append(xPPoiInfo2.getDisplayLon());
        sb2.append(",");
        sb2.append(xPPoiInfo2.getDisplayLat());
        WorkThreadUtil workThreadUtil = WorkThreadUtil.getInstance();
        final int i = z ? 1 : 0;
        workThreadUtil.executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.NaviStatUtil.1
            @Override // java.lang.Runnable
            public void run() {
                DataLogUtil.sendStatData(PageType.this, BtnType.START_NAVI_SYSTEM, Integer.valueOf(routeParams.mRouteCalcType), Long.valueOf(NaviUtil.getTravelDistance()), Long.valueOf(NaviUtil.getTravelTime()), Integer.valueOf(StatUtil.getPoiType(xPPoiInfo2)), xPPoiInfo2.getPoiId(), StatUtil.getPoiCategory(xPPoiInfo2), sb, sb2, Integer.valueOf(TBTManager.getInstance().getCurrentNaviPathIndex() + 1), Integer.valueOf(i), Float.valueOf(NaviStatUtil.access$000()));
            }
        });
    }

    private static float getCarSpeed() {
        return TBTManager.getInstance().getCarSpeed();
    }

    public static void sendStatDataWhenDeviation(MainContext mainContext, XPPoiInfo xPPoiInfo) {
        final PageType pageType;
        final StringBuilder sb;
        if (mainContext != null && PageType.NAVI_GUIDANCE == (pageType = getPageType(mainContext))) {
            MapViewWrapper mapView = mainContext.getMapView();
            if (mapView == null) {
                L.e(TAG, "sendStatDataWhenDeviation mapViewWrapper is null.");
                return;
            }
            XPCarLocation xPCarLocation = mapView.getXPCarLocation();
            if (xPCarLocation == null) {
                L.e(TAG, "sendStatDataWhenDeviation getCarLocation is null.");
                return;
            }
            final Coord2DDouble coord2DDouble = new Coord2DDouble();
            coord2DDouble.lat = xPCarLocation.mLatitude;
            coord2DDouble.lon = xPCarLocation.mLongitude;
            if (xPPoiInfo == null) {
                sb = NaviUtil.getEndPosition();
            } else {
                sb = new StringBuilder();
                sb.append(xPPoiInfo.getDisplayLon());
                sb.append(",");
                sb.append(xPPoiInfo.getDisplayLat());
            }
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.NaviStatUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    DataLogUtil.sendStatData(PageType.this, BtnType.GUIDE_DEVIATION, Long.valueOf(NaviUtil.getTravelDistance()), Long.valueOf(NaviUtil.getTravelTime()), Integer.valueOf(NaviUtil.getTollCost()), Long.valueOf(NaviUtil.getTrafficLightCount()), coord2DDouble, sb);
                }
            });
        }
    }

    public static void sendStatDataWhenReroute(MainContext mainContext, final XPPoiInfo xPPoiInfo, final boolean z) {
        final PageType pageType;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenReroute mainContext:" + mainContext + ",end:" + xPPoiInfo);
        }
        if (mainContext != null && PageType.NAVI_GUIDANCE == (pageType = getPageType(mainContext))) {
            MapViewWrapper mapView = mainContext.getMapView();
            if (mapView == null) {
                L.e(TAG, "sendStatDataWhenReroute mapViewWrapper is null.");
                return;
            }
            XPCarLocation xPCarLocation = mapView.getXPCarLocation();
            if (xPCarLocation == null) {
                L.e(TAG, "sendStatDataWhenReroute getCarLocation is null.");
                return;
            }
            final Coord2DDouble coord2DDouble = new Coord2DDouble();
            coord2DDouble.lat = xPCarLocation.mLatitude;
            coord2DDouble.lon = xPCarLocation.mLongitude;
            final StringBuilder sb = new StringBuilder();
            sb.append(xPPoiInfo.getDisplayLon());
            sb.append(",");
            sb.append(xPPoiInfo.getDisplayLat());
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.stat.NaviStatUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    DataLogUtil.sendStatData(PageType.this, BtnType.GUIDE_REROUTE, Integer.valueOf(StatUtil.getPoiType(xPPoiInfo)), xPPoiInfo.getPoiId(), xPPoiInfo.getBlCategory(), coord2DDouble, sb, Integer.valueOf(z ? 1 : 0));
                }
            });
        }
    }

    public static void sendStatDataWhenContinueNavi(PageType pageType, int i, XPCarLocation xPCarLocation) {
        if (xPCarLocation == null) {
            L.e(TAG, "sendStatDataWhenContinueNavi carLocation is null.");
            return;
        }
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        coord2DDouble.lat = xPCarLocation.mLatitude;
        coord2DDouble.lon = xPCarLocation.mLongitude;
        DataLogUtil.sendStatData(pageType, BtnType.GUIDE_CONTINUE_NAVI, coord2DDouble, Integer.valueOf(i));
    }

    public static void sendStatDataWhenStopNavi(PageType pageType, MainContext mainContext, XPCoordinate2DDouble xPCoordinate2DDouble, float f, XPPoiInfo xPPoiInfo, BtnType btnType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenStopNavi mainContext:" + mainContext + ",carLocation:" + xPCoordinate2DDouble + ",remainDistance:" + f + ",end:" + xPPoiInfo);
        }
        if (mainContext == null || xPCoordinate2DDouble == null || xPPoiInfo == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(xPCoordinate2DDouble.mLon);
        sb.append(",");
        sb.append(xPCoordinate2DDouble.mLat);
        sb2.append(xPPoiInfo.getDisplayLon());
        sb2.append(",");
        sb2.append(xPPoiInfo.getDisplayLat());
        DataLogUtil.sendStatData(pageType, btnType, sb, Float.valueOf(f), sb2);
    }

    public static void sendStatDataWhenStopNaviByButton(MainContext mainContext, XPCoordinate2DDouble xPCoordinate2DDouble, float f, XPPoiInfo xPPoiInfo) {
        sendStatDataWhenStopNavi(PageType.NAVI_GUIDANCE, mainContext, xPCoordinate2DDouble, f, xPPoiInfo, BtnType.STOP_NAVI);
    }

    public static void sendStatDataWhenSystemStopNavi(MainContext mainContext, XPCoordinate2DDouble xPCoordinate2DDouble, float f, XPPoiInfo xPPoiInfo) {
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "sendStatDataWhenStopNavi failure pageType:" + pageType);
                return;
            }
            return;
        }
        sendStatDataWhenStopNavi(pageType, mainContext, xPCoordinate2DDouble, f, xPPoiInfo, BtnType.STOP_NAVI_SYSTEM);
    }

    public static void sendStatDataWhenRouteFailure(MainContext mainContext, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenRouteFailure mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenRouteFailure failure pageType:" + pageType);
            }
        } else if (PageType.NAVI_GUIDANCE == pageType || PageType.NAVI_ROUTING == pageType || PageType.NAVI_DETECT_ROUTE == pageType) {
            DataLogUtil.sendStatData(pageType, BtnType.ROUTE_FAILURE, Integer.valueOf(z ? 1 : 0));
        }
    }

    public static void sendStatDataWhenRouteFailureForWaypoint(MainContext mainContext, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenRouteFailureForWaypoint mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenRouteFailureForWaypoint failure pageType:" + pageType);
            }
        } else if (PageType.NAVI_GUIDANCE == pageType || PageType.NAVI_ROUTING == pageType || PageType.NAVI_DETECT_ROUTE == pageType) {
            DataLogUtil.sendStatData(pageType, BtnType.ROUTE_FAILURE_FOR_WAYPOINT, Integer.valueOf(z ? 1 : 0));
        }
    }

    private static boolean isValidatePageType(PageType pageType) {
        if (pageType == null || pageType == PageType.NONE) {
            return false;
        }
        return pageType == PageType.NAVI_ROUTING || pageType == PageType.NAVI_DETECT_ROUTE || pageType == PageType.NAVI_GUIDANCE || pageType == PageType.SEARCH_WAYPOINT_PAGE || pageType == PageType.SEARCH_WAYPOINT_RESULT || pageType == PageType.SEARCH_NEARBY_PAGE || pageType == PageType.SEARCH_NEARBY_RESULT;
    }

    public static void sendStatDataWhenNaviRestoreCardShow(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenNaviCardShow mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenNaviCardShow failure pageType:" + pageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.NAVI_RESTORE_CARD_SHOW, new Object[0]);
    }

    public static void sendStatDataWhenNaviRestoreStart(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenNaviRestoreStart mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenNaviRestoreStart failure pageType:" + pageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.NAVI_RESTORE_START, new Object[0]);
    }

    public static void sendStatDataWhenNaviRestoreClose(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenNaviRestoreClose mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "sendStatDataWhenNaviRestoreClose failure pageType:" + pageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.NAVI_RESTORE_CLOSE, new Object[0]);
    }

    public static void sendStatDataForOfflineView(PageType pageType, XPCoordinate2DDouble xPCoordinate2DDouble, BtnType btnType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenOfflineShow ,carLocation:" + xPCoordinate2DDouble);
        }
        if (xPCoordinate2DDouble == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xPCoordinate2DDouble.mLon);
        sb.append(",");
        sb.append(xPCoordinate2DDouble.mLat);
        DataLogUtil.sendStatData(pageType, btnType, sb, XPNetworkManager.INSTANCE.getNetworkType());
    }

    public static void sendStatDataClickEagleBtn(PageType pageType) {
        if (pageType == PageType.NONE) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "sendStatDataClickEagleBtn failure pageType:" + pageType);
                return;
            }
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.MAP_THUMB_OVERVIEW, new Object[0]);
    }
}
