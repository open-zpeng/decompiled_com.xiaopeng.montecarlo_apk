package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizRoadCrossControl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
/* loaded from: classes3.dex */
public class RoadCrossControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizRoadCrossControl mRoadCrossControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizRoadCrossControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mRoadCrossControl != null) {
            this.mRoadCrossControl = null;
        }
    }

    private void setBizRoadCrossControl() {
        if (this.mRoadCrossControl == null) {
            this.mRoadCrossControl = this.mBizService.getBizRoadCrossControl(this.mMapView);
        }
    }

    public void setRoadCrossStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.setStyle(iPrepareLayerStyle);
        }
    }

    public void updateRoadCrossStyle(@CrossType.CrossType1 int i) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.updateStyle(i);
        }
    }

    public boolean setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            return this.mRoadCrossControl.setRasterImageData(layerTexture, layerTexture2);
        }
        return false;
    }

    public boolean updateCross(byte[] bArr, @CrossType.CrossType1 int i) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            return this.mRoadCrossControl.updateCross(bArr, i);
        }
        return false;
    }

    public void hideCross(@CrossType.CrossType1 int i) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.hideCross(i);
        }
    }

    public void set3DCrossCarMode(boolean z) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.set3DCrossCarMode(z);
        }
    }

    public void updateRoadCrossNaviInfo(NaviInfo naviInfo) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.updateNaviInfo(naviInfo);
        }
    }

    public void setRoadCrossVisible(@CrossType.CrossType1 int i, boolean z) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.setStyle(iPrepareLayerStyle);
        }
    }

    public void updateStyle(@CrossType.CrossType1 int i) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.updateStyle(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            return this.mRoadCrossControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.setVisible(i, z);
        }
    }

    public void setViewPostureEvent(int i, int i2) {
        if (checkMapViewValid()) {
            setBizRoadCrossControl();
            this.mRoadCrossControl.setViewPostureEvent(i, i2);
        }
    }
}
