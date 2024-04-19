package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.BizAreaControl;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizRouteEndAreaInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteEndAreaType;
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
public class AreaControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizAreaControl mAreaControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizAreaControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mAreaControl != null) {
            this.mAreaControl = null;
        }
    }

    private void setBizAreaControl() {
        if (this.mAreaControl == null) {
            this.mAreaControl = this.mBizService.getBizAreaControl(this.mMapView);
        }
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.updateRangeOnMapPolygon(arrayList);
        }
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.updateRangeOnMapCircle(bizCircleBusinessInfo);
        }
    }

    public void clearRangeOnMapLayer() {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.clearRangeOnMapLayer();
        }
    }

    public void updateRouteRestrict(BizRouteRestrictInfo bizRouteRestrictInfo) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.updateRouteRestrict(bizRouteRestrictInfo);
        }
    }

    public void updateRouteEndArea(BizRouteEndAreaInfo bizRouteEndAreaInfo, RectInt rectInt) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.updateRouteEndArea(bizRouteEndAreaInfo, rectInt);
        }
    }

    public void clearRouteEndArea(@RouteEndAreaType.RouteEndAreaType1 int i) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.clearRouteEndArea(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            return this.mAreaControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            this.mAreaControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizAreaControl();
            return this.mAreaControl.getAreaLayer(i);
        }
        return null;
    }
}
