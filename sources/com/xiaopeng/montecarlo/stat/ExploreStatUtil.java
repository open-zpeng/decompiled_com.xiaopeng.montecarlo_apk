package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class ExploreStatUtil extends StatUtil {
    private static final L.Tag TAG = new L.Tag("ExploreStatUtil");

    public static void sendStatDataWhenExitRoutingByButton(MainContext mainContext, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenExitRouting mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenExitRouting failure pageType:" + pageType);
            return;
        }
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.e(TAG, "sendStatData getCurrentLocation is null.");
        } else {
            DataLogUtil.sendStatData(pageType, BtnType.ROUTE_BTN_CLICK_EXIT, currentLocation, xPCoordinate2DDouble, Float.valueOf(getCarSpeed()));
        }
    }

    private static float getCarSpeed() {
        return TBTManager.getInstance().getCarSpeed();
    }

    public static void sendStatDataWhenExitRoutingByButton(MainContext mainContext) {
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams == null) {
            L.w(TAG, "sendStatDataWhenExitRouting failure routeParams null");
            return;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLat = currentNaviRouteParams.mEndInfo.getNaviLat();
        xPCoordinate2DDouble.mLon = currentNaviRouteParams.mEndInfo.getNaviLon();
        sendStatDataWhenExitRoutingByButton(mainContext, xPCoordinate2DDouble);
    }

    public static void sendStatDataWhenSystemExitRouting(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenExitRouting mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        sendStatDataWhenSystemExitRouting(getPageType(mainContext), mainContext, TBTManager.getInstance().getRouteLastPoint(TBTManager.getInstance().getCurrentRouteRequestId(), TBTManager.getInstance().getCurrentRoutePathIndex()));
    }

    public static void sendStatDataWhenSystemExitRouting(PageType pageType, MainContext mainContext, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenExitRouting mainContext:" + mainContext);
        }
        if (mainContext == null || xPCoordinate2DDouble == null) {
            return;
        }
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenExitRouting failure pageType:" + pageType);
            return;
        }
        mainContext.getMapView();
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.e(TAG, "sendStatData getCurrentLocation is null.");
        } else {
            DataLogUtil.sendStatData(pageType, BtnType.ROUTE_EXIT, currentLocation, xPCoordinate2DDouble, 0, Float.valueOf(getCarSpeed()));
        }
    }

    public static void sendStatDataWhenFirstCardShow(MainContext mainContext, String str, long j, long j2, long j3, long j4) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenFirstCardShow mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL1_SHOW, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
    }

    public static void sendStatDataWhenFirstCardSelected(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenFirstCardSelected mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL1_SELECTED, new Object[0]);
    }

    public static void sendStatDataWhenSecondCardShow(MainContext mainContext, String str, long j, long j2, long j3, long j4) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSecondCardShow mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL2_SHOW, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
    }

    public static void sendStatDataWhenSecondCardSelected(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenSecondCardSelected mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL2_SELECTED, new Object[0]);
    }

    public static void sendStatDataWhenThirdCardShow(MainContext mainContext, String str, long j, long j2, long j3, long j4) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenThirdCardShow mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL3_SHOW, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
    }

    public static void sendStatDataWhenThirdCardSelected(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenThirdCardSelected mainContext:" + mainContext);
        }
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.ROUTE_PANEL3_SELECTED, new Object[0]);
    }

    public static void sendStatDataWhenStartNavi(MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataWhenStartNavi mainContext:" + mainContext);
        }
        if (mainContext == null) {
            return;
        }
        PageType pageType = getPageType(mainContext);
        if (pageType == PageType.NONE) {
            L.Tag tag2 = TAG;
            L.w(tag2, "sendStatDataWhenStartNavi failure pageType:" + pageType);
            return;
        }
        DataLogUtil.sendStatData(pageType, BtnType.ROUTE_BTN_START_NAVI, Float.valueOf(getCarSpeed()));
    }
}
