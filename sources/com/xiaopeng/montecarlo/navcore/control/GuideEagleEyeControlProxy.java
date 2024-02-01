package com.xiaopeng.montecarlo.navcore.control;

import androidx.annotation.NonNull;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.BizGuideEagleEyeControl;
import com.autonavi.gbl.layer.model.EagleEyeParam;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy;
import com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
/* loaded from: classes3.dex */
public class GuideEagleEyeControlProxy extends BaseControlProxy implements IBizControlProxy {
    private static final L.Tag TAG = new L.Tag(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEEAGLEEYE);
    private BizGuideEagleEyeControl mGuideEagleEyeControl;

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
    public void setClickable(long j, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setFocus(long j, String str, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        super.init(bizControlService, mapView, iMapListener);
        setBizGuideEagleEyeControl();
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.BaseControlProxy
    public void unInit() {
        if (this.mGuideEagleEyeControl != null) {
            this.mGuideEagleEyeControl = null;
        }
    }

    private void setBizGuideEagleEyeControl() {
        if (this.mGuideEagleEyeControl == null) {
            this.mGuideEagleEyeControl = this.mBizService.getBizGuideEagleEyeControl(this.mMapView.getDeviceId());
        }
    }

    public int initEagleEye(EagleEyeStyle eagleEyeStyle, IPrepareLayerStyle iPrepareLayerStyle) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            if (!this.mGuideEagleEyeControl.isInitialized()) {
                int init = this.mGuideEagleEyeControl.init(eagleEyeStyle, iPrepareLayerStyle);
                L.Tag tag = TAG;
                L.i(tag, "initEagle: " + init);
                eagleShowPath();
                if (this.mGuideEagleEyeControl.isInitialized()) {
                    return 0;
                }
            }
            return -1;
        }
        return -1;
    }

    public void eagleShowPath() {
        RouteDrawStyle routeDrawStyle = new RouteDrawStyle();
        routeDrawStyle.mIsMultipleMode = true;
        routeDrawStyle.mIsOffLine = false;
        routeDrawStyle.mIsNavi = true;
        routeDrawStyle.mRouteMapMode = 1;
        routeDrawStyle.mRouteScene = 0;
        setEaglePassGreyMode(true);
        drawPath(routeDrawStyle);
    }

    public boolean unInitEagleEye() {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            return this.mGuideEagleEyeControl.unInit();
        }
        return false;
    }

    public boolean isInitialized() {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            return this.mGuideEagleEyeControl.isInitialized();
        }
        return false;
    }

    public boolean getEagleVisible() {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            return this.mGuideEagleEyeControl.getVisible();
        }
        return false;
    }

    public void setEagleVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.setVisible(z);
        }
    }

    public void setEaglePassGreyMode(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.setPassGreyMode(z);
        }
    }

    public void drawPath(RouteDrawStyle routeDrawStyle) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.drawPath(routeDrawStyle);
        }
    }

    public void clearPath() {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.clearPath();
        }
    }

    public void updateEagleStyle(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateStyle(z);
        }
    }

    public void updateEagleNaviInfo(NaviInfo naviInfo) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateNaviInfo(naviInfo);
        }
    }

    public void updateEagleCarLocation(CarLoc carLoc) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateCarLocation(carLoc);
        }
    }

    public void updateMapViewPort(MapViewPortParam mapViewPortParam, boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateMapViewPort(mapViewPortParam);
        }
    }

    public void updateEagleEyeParam(EagleEyeParam eagleEyeParam) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateEagleEyeParam(eagleEyeParam);
        }
    }

    public void destroyEagleEye() {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.clearPath();
            this.mGuideEagleEyeControl.unInit();
        }
    }

    public EagleEyeStyle getEagleEyeStyle(int i, int[] iArr, boolean z) {
        EagleEyeStyle eagleEyeStyle = new EagleEyeStyle();
        eagleEyeStyle.isNightMode = !z;
        eagleEyeStyle.mapViewParam.deviceId = 0;
        eagleEyeStyle.mapViewParam.engineId = 2L;
        eagleEyeStyle.mapViewParam.screenWidth = RootUtil.getScreenWidth();
        eagleEyeStyle.mapViewParam.screenHeight = RootUtil.getScreenHeight();
        int i2 = i / 2;
        int i3 = i2 * i2;
        eagleEyeStyle.eagleEyeParam.targetWidth = (((int) Math.sqrt(i3 + i3)) - 30) - 8;
        eagleEyeStyle.eagleEyeParam.endPreviewLength = 2000L;
        eagleEyeStyle.mapViewParam.x = iArr[0];
        eagleEyeStyle.mapViewParam.y = iArr[1];
        long j = i;
        eagleEyeStyle.mapViewParam.width = j;
        eagleEyeStyle.mapViewParam.height = j;
        eagleEyeStyle.mapViewParam.cacheCountFactor = 1.0f;
        eagleEyeStyle.eagleEyeParam.dataBuff = new BinaryStream(FileUtil.loadDataFromAssets("small_map_bg.png"));
        eagleEyeStyle.mapColorParamDay.fRed = 0.8862745f;
        eagleEyeStyle.mapColorParamDay.fGreen = 0.90588236f;
        eagleEyeStyle.mapColorParamDay.fBlue = 0.9254902f;
        eagleEyeStyle.mapColorParamDay.fAlpha = 0.8f;
        eagleEyeStyle.mapColorParamNight.fRed = 0.14117648f;
        eagleEyeStyle.mapColorParamNight.fGreen = 0.1490196f;
        eagleEyeStyle.mapColorParamNight.fBlue = 0.20392156f;
        eagleEyeStyle.mapColorParamNight.fAlpha = 0.8f;
        return eagleEyeStyle;
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void updateStyle(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.updateStyle(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.control.base.IBizControlProxy
    public void setVisible(boolean z) {
        if (checkMapViewValid()) {
            setBizGuideEagleEyeControl();
            this.mGuideEagleEyeControl.setVisible(z);
        }
    }
}
