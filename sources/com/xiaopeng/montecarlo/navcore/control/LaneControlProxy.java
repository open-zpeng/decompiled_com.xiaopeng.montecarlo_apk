package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizLaneControl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class LaneControlProxy extends BaseControlProxy implements IBizControlProxy {
    private static final L.Tag TAG = new L.Tag(BizControlWrapper.BIZ_CONTROL_TYPE_LANE);
    private BizLaneControl mLaneControl;

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
    public boolean matchBizControl(long j) {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizLaneControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mLaneControl != null) {
            this.mLaneControl = null;
        }
    }

    public void updateStyle(int i) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer(i).updateStyle();
        }
    }

    private void setBizLaneControl() {
        if (this.mLaneControl == null) {
            this.mLaneControl = this.mBizService.getBizLaneControl(this.mMapView);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizLaneControl();
            updateStyle(10001);
            updateStyle(10004);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        L.Tag tag = TAG;
        L.i(tag, "clearAllItems bizType:" + j);
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer((int) j).clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer(i).setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            setVisible(10001, z);
            setVisible(10004, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer((int) j).setClickable(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer((int) j).setFocus(str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            this.mLaneControl.getLaneLayer((int) j).clearFocus();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizLaneControl();
            return this.mLaneControl.getLaneLayer(i);
        }
        return null;
    }
}
