package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizAGroupControl;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
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
public class AGroupControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizAGroupControl mAGroupControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizAGroupControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mAGroupControl != null) {
            this.mAGroupControl = null;
        }
    }

    private void setBizAGroupControl() {
        if (this.mAGroupControl == null) {
            this.mAGroupControl = this.mBizService.getBizAGroupControl(this.mMapView);
        }
    }

    public boolean addAGroupMembers(ArrayList<BizAGroupBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.addAGroupMembers(arrayList);
        }
        return false;
    }

    public boolean updateAGroupMember(BizAGroupBusinessInfo bizAGroupBusinessInfo) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.updateAGroupMember(bizAGroupBusinessInfo);
        }
        return false;
    }

    public boolean removeAGroupMember(String str) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.removeAGroupMember(str);
        }
        return false;
    }

    public boolean setMemberVisible(String str, boolean z) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.setMemberVisible(str, z);
        }
        return false;
    }

    public boolean setEndPoint(BizPointBusinessInfo bizPointBusinessInfo) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.setEndPoint(bizPointBusinessInfo);
        }
        return false;
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        if (!checkMapViewValid()) {
            return new RectDouble();
        }
        setBizAGroupControl();
        return this.mAGroupControl.getPreviewRect(arrayList);
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            this.mAGroupControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizAGroupControl();
            return this.mAGroupControl.getAGroupLayer(i);
        }
        return null;
    }
}
