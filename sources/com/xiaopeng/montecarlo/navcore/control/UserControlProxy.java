package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizUserControl;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UserControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizUserControl mUserControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizUserControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mUserControl != null) {
            this.mUserControl = null;
        }
    }

    private void setBizUserControl() {
        if (this.mUserControl == null) {
            this.mUserControl = this.mBizService.getBizUserControl(this.mMapView);
        }
    }

    public void updateGpsTrack(GpsTrackDepthInfo gpsTrackDepthInfo) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.updateGpsTrack(gpsTrackDepthInfo);
        }
    }

    public void updateSendToCar(BizPointBusinessInfo bizPointBusinessInfo, int i, int i2) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.updateSendToCar(bizPointBusinessInfo, i, i2);
        }
    }

    public void updateFavoriteMain(ArrayList<BizUserFavoritePoint> arrayList) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.updateFavoriteMain(arrayList);
        }
    }

    public void updateFavoritePoi(BizUserFavoritePoint bizUserFavoritePoint) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.updateFavoritePoi(bizUserFavoritePoint);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setBizUserControl();
            return this.mUserControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setBizUserControl();
            this.mUserControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setBizUserControl();
            return this.mUserControl.getUserLayer(i);
        }
        return null;
    }
}
