package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizCarControl;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizCarType;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.CarMode;
import com.autonavi.gbl.map.layer.observer.ICarObserver;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
/* loaded from: classes3.dex */
public class CarControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizCarControl mCarControl;

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
    public void setFocus(long j, String str, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizCarControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mCarControl != null) {
            this.mCarControl = null;
        }
    }

    private void setBizCarControl() {
        if (this.mCarControl == null) {
            this.mCarControl = this.mBizService.getBizCarControl(this.mMapView);
        }
    }

    public void setCarStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setStyle(iPrepareLayerStyle);
        }
    }

    public void updateCarStyle(@BizCarType.BizCarType1 int i) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.updateStyle(i);
        }
    }

    public void updateCarStyle() {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.updateStyle();
        }
    }

    public void setCarMode(@CarMode.CarMode1 int i, boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setCarMode(i, z);
        }
    }

    public int getCarMode() {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.getCarMode();
        }
        return 0;
    }

    public boolean getFollowMode() {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.getFollowMode();
        }
        return false;
    }

    public boolean isFollowMode() {
        return getFollowMode();
    }

    public void setFollowMode(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setFollowMode(z);
            if (this.mMapListener != null) {
                this.mMapListener.onMapFollowModeChanged(z);
            }
        }
    }

    public boolean getCarUpMode() {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.getCarUpMode();
        }
        return false;
    }

    public void setCarUpMode(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setCarUpMode(z);
        }
    }

    public boolean getPreviewMode() {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.getPreviewMode();
        }
        return false;
    }

    public void setPreviewMode(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setPreviewMode(z);
        }
    }

    public CarLoc getCarPosition() {
        if (!checkMapViewValid()) {
            return new CarLoc();
        }
        setBizCarControl();
        return this.mCarControl.getCarPosition();
    }

    public void setCarPosition(CarLoc carLoc) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setCarPosition(carLoc);
        }
    }

    public void setOcclusionCar(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setOcclusionCar(z);
        }
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.setCarScaleByMapLevel(fArr);
        }
        return false;
    }

    public void setMaxCameraDegree(float f) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setMaxPitchAngle(f);
        }
    }

    public void setCarAnimationSwitch(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setCarAnimationSwitch(z);
        }
    }

    public boolean addCarObserver(ICarObserver iCarObserver) {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.addCarObserver(iCarObserver);
        }
        return false;
    }

    public boolean removeCarObserver(ICarObserver iCarObserver) {
        if (checkMapViewValid()) {
            setBizCarControl();
            return this.mCarControl.removeCarObserver(iCarObserver);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setClickable(z);
        }
    }

    public void setClickable(boolean z) {
        if (checkMapViewValid()) {
            setBizCarControl();
            this.mCarControl.setClickable(z);
        }
    }
}
