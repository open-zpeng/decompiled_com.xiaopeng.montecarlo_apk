package com.xiaopeng.montecarlo.util;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MapUtil {
    private static int getDefaultMapLevel(int i, int i2) {
        if (i2 == 0 || i2 == 1) {
            return 15;
        }
        if (i2 != 2) {
            return i;
        }
        return 17;
    }

    private static int getDefaultMapMode() {
        return 2;
    }

    public static String getStoreKeyName(boolean z) {
        return z ? DataSetHelper.AccountSet.NAV_MODULE_DEFAULT_MAP_MODE : DataSetHelper.AccountSet.MAP_MODULE_DEFAULT_MAP_MODE;
    }

    public static void addMapOverLayItems(MainContext mainContext, XPCoordinate2DDouble... xPCoordinate2DDoubleArr) {
        addMapOverLayItems(mainContext, MarkUtils.MARKER_ID_DEBUG_DR_TRACE, xPCoordinate2DDoubleArr);
    }

    public static void addMapOverLayItems(MainContext mainContext, int i, XPCoordinate2DDouble... xPCoordinate2DDoubleArr) {
        if (mainContext == null || xPCoordinate2DDoubleArr == null || xPCoordinate2DDoubleArr.length == 0) {
            return;
        }
        MapViewWrapper mapView = mainContext.getMapView();
        XPPointBaseData[] xPPointBaseDataArr = new XPPointBaseData[xPCoordinate2DDoubleArr.length];
        for (int i2 = 0; i2 < xPCoordinate2DDoubleArr.length; i2++) {
            XPPointBaseData xPPointBaseData = new XPPointBaseData();
            if (xPCoordinate2DDoubleArr[i2] == null) {
                return;
            }
            xPPointBaseData.position.lon = xPCoordinate2DDoubleArr[i2].mLon;
            xPPointBaseData.position.lat = xPCoordinate2DDoubleArr[i2].mLat;
            xPPointBaseDataArr[i2] = xPPointBaseData;
        }
        mapView.getBizControlManager().addMapOverLayItems(xPPointBaseDataArr);
    }

    public static void drawPolygonByPoint(MainContext mainContext, XPCoordinate2DDouble... xPCoordinate2DDoubleArr) {
        if (mainContext == null || xPCoordinate2DDoubleArr == null || xPCoordinate2DDoubleArr.length == 0) {
            return;
        }
        MapViewWrapper mapView = mainContext.getMapView();
        ArrayList arrayList = new ArrayList();
        BizPolygonBusinessInfo bizPolygonBusinessInfo = new BizPolygonBusinessInfo();
        bizPolygonBusinessInfo.id = Integer.toString(xPCoordinate2DDoubleArr.hashCode());
        bizPolygonBusinessInfo.mDrawPolygonRim = true;
        ArrayList<Coord3DDouble> arrayList2 = new ArrayList<>();
        for (int i = 0; i < xPCoordinate2DDoubleArr.length; i++) {
            Coord3DDouble transformCoord2DDoubleToCoord3DDouble = NaviUtil.transformCoord2DDoubleToCoord3DDouble(xPCoordinate2DDoubleArr[i]);
            XPPointBaseData xPPointBaseData = new XPPointBaseData();
            xPPointBaseData.id = "" + i;
            xPPointBaseData.position = transformCoord2DDoubleToCoord3DDouble;
            arrayList.add(xPPointBaseData);
            arrayList2.add(transformCoord2DDoubleToCoord3DDouble);
        }
        bizPolygonBusinessInfo.mVecPoints = arrayList2;
        mapView.getBizControlManager().drawPolygonByPoint(bizPolygonBusinessInfo);
    }

    public static void updateMapLevel(MainContext mainContext) {
        updateMapLevel(mainContext, false);
    }

    public static void updateMapLevel(MainContext mainContext, boolean z) {
        MapViewWrapper mapView;
        int mapLevel;
        if (mainContext == null || (mapView = mainContext.getMapView()) == null) {
            return;
        }
        int mapLevel2 = mapView.getMapLevel();
        int mapMode = mapView.getMapMode();
        if (z) {
            mapLevel = getDefaultMapLevel(mapLevel2, mapMode);
        } else {
            mapLevel = getMapLevel(mapLevel2, mapMode);
        }
        if (mapLevel2 != mapLevel) {
            mapView.setMapLevel(mapLevel);
        }
    }

    public static void updateMapLevel(MapViewWrapper mapViewWrapper, boolean z) {
        int mapLevel;
        if (mapViewWrapper == null) {
            return;
        }
        int mapLevel2 = mapViewWrapper.getMapLevel();
        int mapMode = mapViewWrapper.getMapMode();
        if (z) {
            mapLevel = getDefaultMapLevel(mapLevel2, mapMode);
        } else {
            mapLevel = getMapLevel(mapLevel2, mapMode);
        }
        if (mapLevel2 != mapLevel) {
            mapViewWrapper.setMapLevel(mapLevel);
        }
    }

    private static int getMapLevel(int i, int i2) {
        return i < 11 ? getDefaultMapLevel(i, i2) : i;
    }

    public static void saveMapMode(int i, boolean z) {
        DataSetHelper.AccountSet.set(getStoreKeyName(z), i);
    }

    public static void saveDeaflutMapMode() {
        saveMapMode(getDefaultMapMode(), true);
        saveMapMode(getDefaultMapMode(), false);
    }

    public static int getSavedMapMode(boolean z) {
        return DataSetHelper.AccountSet.getInt(getStoreKeyName(z), getDefaultMapMode());
    }

    public static int[] getDefaultEagleLocation() {
        int[] iArr = new int[2];
        iArr[0] = ContextUtils.getDimensionPixelSize(R.dimen.guide_eagle_view_mask_x);
        iArr[1] = RootUtil.getStatusBarHeight() + ContextUtils.getDimensionPixelSize(R.dimen.guide_eagle_view_mask_y) + (RootUtil.isTabletApp() ? 0 : ContextUtils.getDimensionPixelSize(R.dimen.guide_eagle_view_top));
        return iArr;
    }
}
