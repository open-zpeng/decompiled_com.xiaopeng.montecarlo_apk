package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizLabelControl;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPopPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
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
public class LabelControlProxy extends BaseControlProxy implements IBizControlProxy {
    private BizLabelControl mLabelControl;

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setLabelControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mLabelControl != null) {
            this.mLabelControl = null;
        }
    }

    private void setLabelControl() {
        if (this.mLabelControl == null) {
            this.mLabelControl = this.mBizService.getBizLabelControl(this.mMapView);
        }
    }

    public void updateCruiseLane(LaneInfo laneInfo) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateCruiseLane(laneInfo);
        }
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, int i, int i2, int i3) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateCruiseCongestion(cruiseCongestionInfo, i, i2, i3);
        }
    }

    public void previewCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, boolean z, boolean z2) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.previewCruiseCongestion(cruiseCongestionInfo, z, z2);
        }
    }

    public void exitPreviewCruiseCongestion() {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.exitPreviewCruiseCongestion();
        }
    }

    public void updateLabelNaviInfo(NaviInfo naviInfo) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateNaviInfo(naviInfo);
        }
    }

    public void updateGuideMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateGuideMixForkInfo(arrayList);
        }
    }

    public void updatePopAddViaPointInfo(ArrayList<BizSearchAlongWayPoint> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updatePopAddViaPointInfo(arrayList);
        }
    }

    public void updatePopRemoveViaPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updatePopRemoveViaPointInfo(arrayList);
        }
    }

    public void updatePopTrafficEventInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updatePopTrafficEventInfo(arrayList);
        }
    }

    public void updatePopSearchPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updatePopSearchPointInfo(arrayList);
        }
    }

    public void updatePopEndAreaPointBoxInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updatePopEndAreaPointBoxInfo(arrayList);
        }
    }

    public void updateGpsPointsInfo(ArrayList<BizPointBusinessInfo> arrayList) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateGpsPointsInfo(arrayList);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.setStyle(iPrepareLayerStyle);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.updateStyle();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public boolean matchBizControl(long j) {
        if (checkMapViewValid()) {
            setLabelControl();
            return this.mLabelControl.matchBizControl(j);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems(long j) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.clearAllItems(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearAllItems() {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.clearAllItems();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.setVisible(i, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.setVisible(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setClickable(long j, boolean z) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.setClickable(j, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.setFocus(j, str, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void clearFocus(long j) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.clearFocus(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.addClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.removeClickObserver(iLayerClickObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.addFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        if (checkMapViewValid()) {
            setLabelControl();
            this.mLabelControl.removeFocusChangeObserver(iLayerFocusChangeObserver);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public BaseLayer getBaseLayer(int i) {
        if (checkMapViewValid()) {
            setLabelControl();
            return this.mLabelControl.getLabelLayer(i);
        }
        return null;
    }
}
