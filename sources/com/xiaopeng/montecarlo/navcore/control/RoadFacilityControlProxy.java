package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.NaviCamera;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviIntervalCamera;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizRoadFacilityControl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RoadFacilityControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizRoadFacilityControl mRoadFacilityControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setRoadFacilityControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mRoadFacilityControl != null) {
            this.mRoadFacilityControl = null;
        }
    }

    private void setRoadFacilityControl() {
        if (this.mRoadFacilityControl == null) {
            this.mRoadFacilityControl = this.mBizService.getBizRoadFacilityControl(this.mMapView);
        }
    }

    public void updateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateCruiseFacility(arrayList);
        }
    }

    public void updateCruiseCamera(ArrayList<CruiseFacilityInfo> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateCruiseCamera(arrayList);
        }
    }

    public void updateCruiseCongestionEvent(ArrayList<SocolEventInfo> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateCruiseCongestionEvent(arrayList);
        }
    }

    public void updateGuideCamera(ArrayList<NaviCamera> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateGuideCamera(arrayList);
        }
    }

    public void updateGuideIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateGuideIntervalCamera(arrayList);
        }
    }

    public void updateGuideRoadFacility(ArrayList<NaviRoadFacility> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateGuideRoadFacility(arrayList);
        }
    }

    public void updateGuideTrafficEvent(ArrayList<TrafficEventInfo> arrayList, boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateGuideTrafficEvent(arrayList, z);
        }
    }

    public void updateTrafficLight(ArrayList<TrafficSignal> arrayList) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateTrafficLight(arrayList);
        }
    }

    public void updateRoadFacilityNaviInfo(NaviInfo naviInfo) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateNaviInfo(naviInfo);
        }
    }

    public void enableDistanceRefresh(boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.enableDistanceRefresh(z);
        }
    }

    public int parseGuideCameraLayerProperty(String str) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            return this.mRoadFacilityControl.parseGuideCameraLayerProperty(str);
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            return this.mRoadFacilityControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            this.mRoadFacilityControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setRoadFacilityControl();
            return this.mRoadFacilityControl.getFacilityLayer(i);
        }
        return null;
    }
}
