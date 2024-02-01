package com.xiaopeng.montecarlo.stat;

import android.graphics.Point;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
/* loaded from: classes3.dex */
public class MapOpStatUtil {
    private static final L.Tag TAG = new L.Tag("PoiPopStatUtil");
    private static boolean sLastSystemVolumeStatus = false;

    public static void sendStatDataWhenMapExposure() {
        sendStatData(BtnType.EXPOSURE);
    }

    public static void sendStatDataWhenMapGotoforeground() {
        sendStatData(BtnType.GOTOFOREGROUND);
    }

    public static void sendStatDataWhenMapGotobackground() {
        sendStatData(BtnType.GOTOBACKGROUND);
    }

    public static void sendStatDataWhenMapExit() {
        sendStatData(BtnType.EXIT);
    }

    public static void sendStatDataWhenMapTouchDown(MainContext mainContext, int i, int i2) {
        sendStatData(mainContext, BtnType.TOUCHDOWN, i, i2);
    }

    public static void sendStatDataWhenMapTouchUp(MainContext mainContext, int i, int i2) {
        sendStatData(mainContext, BtnType.TOUCHUP, i, i2);
    }

    public static void sendStatDataWhenMapZoomin(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ONCLICKZOOMIN);
    }

    public static void sendStatDataWhenMapZoomout(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ONCLICKZOOMOUT);
    }

    public static void sendStatDataForVolumeBtn(MainContext mainContext, boolean z) {
        sendStatDataForVolume(mainContext, BtnType.VOLUME_BUTTON, z);
    }

    public static void sendStatDataForVolumeSystem(MainContext mainContext, boolean z) {
        if (sLastSystemVolumeStatus != z) {
            sLastSystemVolumeStatus = z;
            sendStatDataForVolume(mainContext, BtnType.VOLUME_SYSTEM, z);
        }
    }

    public static void sendStatDataForVolumeWhenCruise(MainContext mainContext, BtnType btnType, Object... objArr) {
        PageType pageTypeByCurScene;
        if (mainContext != null && (pageTypeByCurScene = DataLogHelper.getPageTypeByCurScene(mainContext)) == PageType.NAVI_CRUISE) {
            DataLogUtil.sendStatData(pageTypeByCurScene, btnType, objArr);
        }
    }

    public static void sendStatDataForVolumeRestoreByPowerOn(MainContext mainContext, boolean z) {
        sendStatDataForVolumeWhenCruise(mainContext, BtnType.VOLUME_RESTORE_BY_POWERON, Integer.valueOf(z ? 1 : 0));
    }

    public static void sendStatDataForShowPanel(MainContext mainContext, boolean z) {
        sendStatDataForVolume(mainContext, BtnType.VOLUME_SHOW_PANEL_BUTTON, z);
    }

    public static void sendStatDataForVolumeLongPress(MainContext mainContext, boolean z) {
        sendStatDataForVolume(mainContext, BtnType.VOLUME_LONG_PRESSED, z);
    }

    public static void sendStatDataForPowOn(MainContext mainContext) {
        sendStatDataForVolumeWhenCruise(mainContext, BtnType.RESTORE_BY_POWER_ON, TimeFormatUtil.getCurrentFormatTimeString());
    }

    public static void sendStatDataForPowOff(MainContext mainContext, int i, double d, double d2) {
        if (mainContext == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d2);
        sb.append(",");
        sb.append(d);
        sendStatDataForVolumeOnSomePage(mainContext, BtnType.RESTORE_BY_POWER_OFF, Integer.valueOf(i), sb, TimeFormatUtil.getCurrentFormatTimeString());
    }

    public static void sendStatDataForVolSet(MainContext mainContext, boolean z, int i) {
        sendStatDataForVolumeOnSomePage(mainContext, z ? BtnType.VOLUME_CHANGE_WITH_USER_OPERATE : BtnType.VOLUME_CHANGE_FOLLOW_SYSTEM, Integer.valueOf(i));
    }

    public static void sendStatDataWhenMapRoadChange(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ROAD_CHANGE_BUTTON);
    }

    public static void sendStatDataWhenOnClickOverview(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ONCLICKOVERVIEW);
    }

    public static void sendStatDataWhenOnClickMapmode(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ONCLICKMAPMODE);
    }

    public static void sendStatDataWhenOnClickMapRecenter(MainContext mainContext) {
        sendStatData(mainContext, BtnType.ONCLICKMAPRECENTER);
    }

    public static void sendStatDataWhenMapClick(MainContext mainContext, int i, int i2, double d, double d2) {
        PageType pageTypeByCurScene = DataLogHelper.getPageTypeByCurScene(mainContext);
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLat = d2;
        xPCoordinate2DDouble.mLon = d;
        if (isValidatePageType(pageTypeByCurScene)) {
            DataLogUtil.sendStatData(pageTypeByCurScene, BtnType.CLICK, Integer.valueOf(i), Integer.valueOf(i2), xPCoordinate2DDouble);
        }
    }

    private static boolean isValidatePageType(PageType pageType) {
        if (pageType == null || pageType == PageType.NONE) {
            return false;
        }
        return pageType == PageType.NAVI_CRUISE || pageType == PageType.NAVI_ROUTING || pageType == PageType.NAVI_DETECT_ROUTE || pageType == PageType.NAVI_GUIDANCE || pageType == PageType.Navi_Search_Main_Result || pageType == PageType.SEARCH_WAYPOINT_RESULT || pageType == PageType.SEARCH_HOME_RESULT || pageType == PageType.SEARCH_OFFICE_RESULT || pageType == PageType.SEARCH_NEARBY_RESULT || pageType == PageType.SEARCH_CHARGINGSTATION_RESULT;
    }

    private static void sendStatData(BtnType btnType) {
        PageType pageType;
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if (currentStatus == 0) {
            pageType = PageType.NAVI_CRUISE;
        } else if (currentStatus != 1) {
            return;
        } else {
            pageType = PageType.NAVI_GUIDANCE;
        }
        DataLogUtil.sendStatData(pageType, btnType, 1 == StateManager.getInstance().getState() ? "1" : "0");
    }

    private static void sendStatData(MainContext mainContext, BtnType btnType) {
        if (mainContext == null) {
            return;
        }
        MapViewWrapper mapView = mainContext.getMapView();
        CarLoc carLocation = mapView.getBizControlManager().getCarLocation();
        if (carLocation == null || carLocation.vecPathMatchInfo == null || carLocation.vecPathMatchInfo.size() == 0 || carLocation.vecPathMatchInfo.get(0) == null) {
            L.e(TAG, "sendStatData getCarLocation is null.");
            return;
        }
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        coord2DDouble.lat = carLocation.vecPathMatchInfo.get(0).latitude;
        coord2DDouble.lon = carLocation.vecPathMatchInfo.get(0).longitude;
        DataLogUtil.sendStatData(DataLogHelper.getPageTypeByCurScene(mainContext), btnType, coord2DDouble, Integer.valueOf(mapView.getMapLevel()), Integer.valueOf(mapView.getMapMode()), Float.valueOf(carLocation.vecPathMatchInfo.get(0).carDir));
    }

    private static void sendStatData(MainContext mainContext, BtnType btnType, int i, int i2) {
        if (mainContext == null) {
            return;
        }
        MapViewWrapper mapView = mainContext.getMapView();
        CarLoc carLocation = mapView.getBizControlManager().getCarLocation();
        if (carLocation == null || carLocation.vecPathMatchInfo == null || carLocation.vecPathMatchInfo.size() == 0 || carLocation.vecPathMatchInfo.get(0) == null) {
            L.e(TAG, "sendStatData getCarLocation is null.");
            return;
        }
        Point point = new Point();
        point.x = i;
        point.y = i2;
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        coord2DDouble.lat = carLocation.vecPathMatchInfo.get(0).latitude;
        coord2DDouble.lon = carLocation.vecPathMatchInfo.get(0).longitude;
        DataLogUtil.sendStatData(DataLogHelper.getPageTypeByCurScene(mainContext), btnType, point, coord2DDouble, Integer.valueOf(mapView.getMapLevel()), Integer.valueOf(mapView.getMapMode()), Float.valueOf(carLocation.vecPathMatchInfo.get(0).carDir));
    }

    private static void sendStatDataForVolume(MainContext mainContext, BtnType btnType, boolean z) {
        sendStatDataForVolumeOnSomePage(mainContext, btnType, Integer.valueOf(z ? 1 : 0));
    }

    private static void sendStatDataForVolumeOnSomePage(MainContext mainContext, BtnType btnType, Object... objArr) {
        if (mainContext == null) {
            return;
        }
        PageType pageTypeByCurScene = DataLogHelper.getPageTypeByCurScene(mainContext);
        if (isValidatePageType(pageTypeByCurScene)) {
            DataLogUtil.sendStatData(pageTypeByCurScene, btnType, objArr);
        }
    }
}
