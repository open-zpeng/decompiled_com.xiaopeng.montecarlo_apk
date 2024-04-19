package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.location.Location;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
/* loaded from: classes3.dex */
public interface IMapDelegate {
    void addBizAGroupOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizAreaOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizCustomOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizLabelOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizRoadFacilityOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizRouteOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizSearchOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    void addBizUserOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr);

    boolean canZoomIn();

    boolean canZoomOut();

    void clearBizAGroupOverlay(int i);

    void clearBizAreaOverlay(int i);

    void clearBizCustomOverlay(int i);

    void clearBizGuideEagleEyeOverlay(int i);

    void clearBizLabelOverlay(int i);

    void clearBizRoadFacilityOverlay(int i);

    void clearBizRouteOverlay(int i);

    void clearBizSearchOverlay(int i);

    void clearBizUserOverlay(int i);

    void clearEagleyeRoute();

    CarLoc getCarLocation();

    Coord2DDouble getLonLatFromCenter();

    int getMapLevel();

    int getMapMode();

    MapViewWrapper getMapView();

    void initCruiseCar(int i);

    void initCruiseCar(int i, boolean z);

    void initNaviCar(int i, int i2);

    void initRouteCar(int i);

    boolean isRoute();

    boolean isValid();

    void moveMapCenter(@NonNull CarLoc carLoc);

    void removeRoute(int i, boolean z);

    void removeRouteCache(int i);

    void setBizAGroupOverlayVisible(int i, boolean z);

    void setBizAreaOverlayVisible(int i, boolean z);

    void setBizCustomOverlayVisible(int i, boolean z);

    void setBizGuideEagleEyeOverlayVisible(int i, boolean z);

    void setBizLabelOverlayVisible(int i, boolean z);

    void setBizRoadCrossOverlayVisible(int i, boolean z);

    void setBizRoadFacilityOverlayVisible(int i, boolean z);

    void setBizRouteOverlayVisible(int i, boolean z);

    void setBizSearchOverlayVisible(int i, boolean z);

    void setBizUserOverlayVisible(int i, boolean z);

    void setCarLocation(Location location);

    void setMapMode(int i);

    void setPoiToCenter(double d, double d2);

    void setTrafficLayerState(int i);

    void setTrafficState(boolean z);

    void syncMapMode();

    Coord2DInt32 transLonLatToP20(double d, double d2);

    Coord2DDouble transP20ToLonLat(int i, int i2);

    void updateCarLocIcon();

    void updateTrafficLayerState();
}
