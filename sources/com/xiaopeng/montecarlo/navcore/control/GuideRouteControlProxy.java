package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoutePoints;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizGuideRouteControl;
import com.autonavi.gbl.layer.DynamicLevelCustomCalculator;
import com.autonavi.gbl.layer.model.BizGuideETAEventInfo;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.BizPathInfoAttrs;
import com.autonavi.gbl.layer.model.BizRouteWeatherInfo;
import com.autonavi.gbl.layer.model.DynamicLevelParam;
import com.autonavi.gbl.layer.model.DynamicLevelType;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GuideRouteControlProxy extends BaseControlProxy implements IBizControlProxy {
    private static final L.Tag TAG = new L.Tag(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE);
    private BizGuideRouteControl mGuideRouteControl;
    private volatile boolean mIsOpenNavDynamicLevel = false;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizGuideRouteControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mGuideRouteControl != null) {
            this.mGuideRouteControl = null;
        }
    }

    private void setBizGuideRouteControl() {
        if (this.mGuideRouteControl == null) {
            this.mGuideRouteControl = this.mBizService.getBizGuideRouteControl(this.mMapView);
        }
    }

    public void clearPaths() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.clearPaths();
        }
    }

    public void clearPathsCacheData() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.clearPathsCacheData();
        }
    }

    public void updatePathsTmc(ArrayList<LightBarInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateTmcLightBar(arrayList);
        }
    }

    public void setPathArrowSegment(ArrayList<Long> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setPathArrowSegment(arrayList);
        }
    }

    public void updatePathArrow() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updatePathArrow();
        }
    }

    public void updateGuideRouteNaviInfo(ArrayList<NaviInfo> arrayList, int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateNaviInfo(arrayList, i);
        }
    }

    public void updateNaviInfo(ArrayList<NaviInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateNaviInfo(arrayList);
        }
    }

    public void initDynamicLevel(DynamicLevelParam dynamicLevelParam) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.initDynamicLevel(dynamicLevelParam);
        }
    }

    public void openDynamicLevel(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            if (i == 0) {
                this.mIsOpenNavDynamicLevel = z;
            }
            this.mGuideRouteControl.openDynamicLevel(z, i);
            this.mGuideRouteControl.openDynamicCenter(false);
        }
    }

    public void openDynamicLevel(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mIsOpenNavDynamicLevel = z;
            this.mGuideRouteControl.openDynamicLevel(z);
            this.mGuideRouteControl.openDynamicCenter(false);
        }
    }

    public boolean isOpenDynamicLevel() {
        return this.mIsOpenNavDynamicLevel;
    }

    public void resetDynamicLevel(@DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.resetDynamicLevel(i);
        }
    }

    public void resetDynamicLevel() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.resetDynamicLevel();
        }
    }

    public float getDynamicLevelMapHeadDegree(@DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getDynamicLevelMapHeadDegree(i);
        }
        return -9999.0f;
    }

    public float getDynamicLevelMapHeadDegree() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getDynamicLevelMapHeadDegree();
        }
        return 0.0f;
    }

    public boolean getDynamicLevelLock(@DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getDynamicLevelLock(i);
        }
        return false;
    }

    public boolean getDynamicLevelLock() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getDynamicLevelLock();
        }
        return false;
    }

    public void setDynamicLevelLock(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setDynamicLevelLock(z);
        }
    }

    public void setDynamicLevelLock(boolean z, @DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setDynamicLevelLock(z, i);
        }
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculator dynamicLevelCustomCalculator, @DynamicLevelType.DynamicLevelType1 int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setDynamicLevelCustomCalculator(dynamicLevelCustomCalculator, i);
        }
    }

    public void setDynamicLevelCustomCalculator(DynamicLevelCustomCalculator dynamicLevelCustomCalculator) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setDynamicLevelCustomCalculator(dynamicLevelCustomCalculator);
        }
    }

    public void updateGuideETAEvent(BizGuideETAEventInfo bizGuideETAEventInfo) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateGuideETAEvent(bizGuideETAEventInfo);
        }
    }

    public void updateGuideCongestionBoard(NaviCongestionInfo naviCongestionInfo) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateGuideCongestionBoard(naviCongestionInfo);
        }
    }

    public void setDisplayScale(int i, LayerScale layerScale) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.getRouteLayer(i).setDisplayScale(layerScale);
        }
    }

    public void setRouteControlPassGreyMode(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setPassGreyMode(z);
        }
    }

    public void setCompareRouteMode(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setCompareRouteMode(z);
        }
    }

    public void setPathInfos(ArrayList<BizPathInfoAttrs> arrayList, int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setPathInfos(arrayList, i);
        }
    }

    public void setPathPoints(RoutePoints routePoints) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setPathPoints(routePoints);
        }
    }

    public int getSelectedPathIndex() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getSelectedPathIndex();
        }
        return 0;
    }

    public void setSelectedPathIndex(int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setSelectedPathIndex(i);
        }
    }

    public void updatePaths() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updatePaths();
        }
    }

    public void updateTmcLightBar(ArrayList<LightBarInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateTmcLightBar(arrayList);
        }
    }

    public Coord3DDouble getPathArrowPreviewCenter(int i) {
        if (!checkMapViewValid()) {
            return new Coord3DDouble();
        }
        setBizGuideRouteControl();
        return this.mGuideRouteControl.getPathArrowPreviewCenter(i);
    }

    public Coord3DDouble getPathSegPreviewPoint(int i) {
        if (!checkMapViewValid()) {
            return new Coord3DDouble();
        }
        setBizGuideRouteControl();
        return this.mGuideRouteControl.getPathSegPreviewPoint(i);
    }

    public void moveToPathSegment(int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.moveToPathSegment(i);
        }
    }

    public void setPathDrawStyle(RouteDrawStyle routeDrawStyle) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setPathDrawStyle(routeDrawStyle);
        }
    }

    public void updateRouteWeatherInfo(ArrayList<BizRouteWeatherInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateRouteWeatherInfo(arrayList);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "addClickObserver pObserver:" + iLayerClickObserver);
            }
            setBizGuideRouteControl();
            this.mGuideRouteControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "removeClickObserver pObserver:" + iLayerClickObserver);
            }
            setBizGuideRouteControl();
            this.mGuideRouteControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            return this.mGuideRouteControl.getRouteLayer(i);
        }
        return null;
    }

    public void updateOddInfo(ArrayList<BizOddInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.updateOddInfo(arrayList);
        }
    }

    public void setODDDrawMode(int i) {
        if (checkMapViewValid()) {
            setBizGuideRouteControl();
            this.mGuideRouteControl.setODDDrawMode(i);
        }
    }
}
