package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizCustomControl;
import com.autonavi.gbl.layer.model.BizCustomPointInfo;
import com.autonavi.gbl.layer.model.BizCustomTypePoint;
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
public class CustomControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizCustomControl mBizCustomControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizCustomControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mBizCustomControl != null) {
            this.mBizCustomControl = null;
        }
    }

    private void setBizCustomControl() {
        if (this.mBizCustomControl == null) {
            this.mBizCustomControl = this.mBizService.getBizCustomControl(this.mMapView);
        }
    }

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.updateCustomPoint(arrayList, i);
        }
    }

    public void addCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.addCustomPoint(arrayList, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            return this.mBizCustomControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            this.mBizCustomControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizCustomControl();
            return this.mBizCustomControl.getCustomLayer(i);
        }
        return null;
    }
}
