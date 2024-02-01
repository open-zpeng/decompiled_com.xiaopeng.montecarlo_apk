package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizSearchControl;
import com.autonavi.gbl.layer.model.BizLineBusinessInfo;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.BizSearchBeginEndPoint;
import com.autonavi.gbl.layer.model.BizSearchChildPoint;
import com.autonavi.gbl.layer.model.BizSearchExitEntrancePoint;
import com.autonavi.gbl.layer.model.BizSearchParentPoint;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SearchControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizSearchControl mSearchControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizSearchControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mSearchControl != null) {
            this.mSearchControl = null;
        }
    }

    private void setBizSearchControl() {
        if (this.mSearchControl == null) {
            this.mSearchControl = this.mBizService.getBizSearchControl(this.mMapView);
        }
    }

    public void updateSearchLine(ArrayList<BizLineBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.updateSearchLine(arrayList);
        }
    }

    public void updateSearchPolygon(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.updateSearchPolygon(bizPolygonBusinessInfo);
        }
    }

    public boolean updateSearchParentPoi(ArrayList<BizSearchParentPoint> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchParentPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchChildPoi(ArrayList<BizSearchChildPoint> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchChildPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchCentralPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchCentralPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchExitEntrancePoi(ArrayList<BizSearchExitEntrancePoint> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchExitEntrancePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchBeginEndPoi(ArrayList<BizSearchBeginEndPoint> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchBeginEndPoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchAlongRoutePoi(ArrayList<BizSearchAlongWayPoint> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchAlongRoutePoi(arrayList);
        }
        return false;
    }

    public boolean updateSearchParkPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.updateSearchParkPoi(arrayList);
        }
        return false;
    }

    public void setCollisionSwitch(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.getSearchLayer(i).enableCollision(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            this.mSearchControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizSearchControl();
            return this.mSearchControl.getSearchLayer(i);
        }
        return null;
    }
}
