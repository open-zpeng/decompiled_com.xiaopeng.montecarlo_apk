package com.xiaopeng.montecarlo.scenes.mapscene;

import android.location.Location;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.base.MapFragment;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class MapDelegate implements IMapDelegate {
    private WeakReference<MapFragment> mMapFragment;

    public MapDelegate(MapFragment mapFragment) {
        this.mMapFragment = new WeakReference<>(mapFragment);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setPoiToCenter(double d, double d2) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().setPoiToCenter(new XPCoordinate2DDouble(d, d2));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public CarLoc getCarLocation() {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().getBizControlManager().getCarLocation();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setCarLocation(Location location) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setCarLocation(location);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizRouteOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizRouteOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizUserOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_USER, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizAGroupOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_AGROUP, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizAGroupOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_AGROUP, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizAGroupOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_AGROUP, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizAreaOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_AREA, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizAreaOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_AREA, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizAreaOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_AREA, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizGuideEagleEyeOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().guideEagleEyeClearPath();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizGuideEagleEyeOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEEAGLEEYE, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizLabelOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_LABEL, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizLabelOverlayVisible(int i, boolean z) {
        this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_LABEL, i, z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizLabelOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_LABEL, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizRoadCrossOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_ROADCROSS, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizRoadFacilityOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizRoadFacilityOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizUserOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_USER, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizUserOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_USER, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizRouteOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizRoadFacilityOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizSearchOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizSearchOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizSearchOverlayVisible(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearBizCustomOverlay(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void addBizCustomOverlayItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        if (!isValid() || CollectionUtils.isEmpty(xPPointBaseDataArr)) {
            return;
        }
        this.mMapFragment.get().getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, i, xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setBizCustomOverlayVisible(int i, boolean z) {
        this.mMapFragment.get().getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_CUSTOM, i, z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public Coord2DDouble getLonLatFromCenter() {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().getLonLatFromCenter();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void initCruiseCar(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().initCruiseCar(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void initCruiseCar(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().initCruiseCar(i, true);
            this.mMapFragment.get().getMapView().getBizControlManager().initCruiseCar(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void initNaviCar(int i, int i2) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().initNaviCar(i2);
            this.mMapFragment.get().getMapView().getBizControlManager().initNaviCar(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void initRouteCar(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().initRouteCar(i);
            this.mMapFragment.get().getMapView().getBizControlManager().initRouteCar();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setTrafficState(boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().setTrafficState(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setTrafficLayerState(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().setTrafficEventLayerState(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void updateTrafficLayerState() {
        if (isValid()) {
            this.mMapFragment.get().getMapView().updateTrafficEventLayerState();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void removeRoute(int i, boolean z) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().removeRoute(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void removeRouteCache(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().getBizControlManager().removeRouteCache();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public Coord2DDouble transP20ToLonLat(int i, int i2) {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().p20ToLonLat(i, i2);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public Coord2DInt32 transLonLatToP20(double d, double d2) {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().lonLatToP20(d, d2);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void moveMapCenter(@NonNull CarLoc carLoc) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().moveMapCenter(carLoc, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public boolean isValid() {
        WeakReference<MapFragment> weakReference = this.mMapFragment;
        return (weakReference == null || weakReference.get() == null || this.mMapFragment.get().isDetached()) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public boolean canZoomIn() {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().canZoomIn();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public boolean canZoomOut() {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().canZoomOut();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public boolean isRoute() {
        if (isValid()) {
            return this.mMapFragment.get().getMapView().isBLRouteScene();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public int getMapMode() {
        return this.mMapFragment.get().getMapView().getMapMode();
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void setMapMode(int i) {
        if (isValid()) {
            this.mMapFragment.get().getMapView().setMapMode(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void syncMapMode() {
        if (isValid()) {
            this.mMapFragment.get().syncMapMode();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void clearEagleyeRoute() {
        this.mMapFragment.get().getMapView().getBizControlManager().clearEagleyeRoute();
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public MapViewWrapper getMapView() {
        return this.mMapFragment.get().getMapView();
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public void updateCarLocIcon() {
        if (isValid()) {
            this.mMapFragment.get().getMapView().updateCarLocIcon();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate
    public int getMapLevel() {
        return this.mMapFragment.get().getMapView().getMapLevel();
    }
}
