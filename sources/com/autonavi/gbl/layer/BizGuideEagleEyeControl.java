package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizCustomControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControlImpl;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.model.EagleEyeParam;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.RoutePathLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizGuideEagleEyeControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizGuideEagleEyeControl {
    private static String PACKAGE = ReflexTool.PN(BizGuideEagleEyeControl.class);
    private IBizGuideEagleEyeControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizGuideEagleEyeControl(long j, boolean z) {
        this(new IBizGuideEagleEyeControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizGuideEagleEyeControl.class, this, this.mControl);
        }
    }

    public BizGuideEagleEyeControl(IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizGuideEagleEyeControlImpl);
    }

    private void $constructor(IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl) {
        if (iBizGuideEagleEyeControlImpl != null) {
            this.mControl = iBizGuideEagleEyeControlImpl;
            this.mTargetId = String.format("BizGuideEagleEyeControl_%s_%d", String.valueOf(IBizGuideEagleEyeControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizGuideEagleEyeControlImpl getControl() {
        return this.mControl;
    }

    public int init(EagleEyeStyle eagleEyeStyle, IPrepareLayerStyle iPrepareLayerStyle) {
        TypeHelper typeHelper;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("init", EagleEyeStyle.class, IPrepareLayerStyle.class);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 1, iPrepareLayerStyle);
            }
            IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
            if (iBizGuideEagleEyeControlImpl != null) {
                return iBizGuideEagleEyeControlImpl.init(eagleEyeStyle, iPrepareLayerStyleImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public boolean unInit() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            return iBizGuideEagleEyeControlImpl.unInit();
        }
        return false;
    }

    public boolean isInitialized() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            return iBizGuideEagleEyeControlImpl.isInitialized();
        }
        return false;
    }

    public MapView getMapView() {
        IMapViewImpl mapView;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getMapView", new Class[0]);
            IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
            if (iBizGuideEagleEyeControlImpl == null || (mapView = iBizGuideEagleEyeControlImpl.getMapView()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapView) typeHelper.transfer(method, -1, (Object) mapView, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BaseLayer getBaseLayer(long j) {
        BaseLayerImpl baseLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getBaseLayer", Long.TYPE);
            IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
            if (iBizGuideEagleEyeControlImpl == null || (baseLayer = iBizGuideEagleEyeControlImpl.getBaseLayer(j)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) baseLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<RoutePathLayer> getRoutePathLayers() {
        ArrayList<RoutePathLayerImpl> routePathLayers;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getRoutePathLayers", new Class[0]);
            IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
            if (iBizGuideEagleEyeControlImpl == null || (routePathLayers = iBizGuideEagleEyeControlImpl.getRoutePathLayers()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) routePathLayers, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setVisible(boolean z) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.setVisible(z);
        }
    }

    public boolean getVisible() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            return iBizGuideEagleEyeControlImpl.getVisible();
        }
        return false;
    }

    public void setPassGreyMode(boolean z) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.setPassGreyMode(z);
        }
    }

    public void drawPath(RouteDrawStyle routeDrawStyle) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.drawPath(routeDrawStyle);
        }
    }

    public void clearPath() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.clearPath();
        }
    }

    public void updateStyle(boolean z) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateStyle(z);
        }
    }

    public void updatePaths() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updatePaths();
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateNaviInfo(naviInfo);
        }
    }

    public void stopNavi() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.stopNavi();
        }
    }

    public void updateCarLocation(CarLoc carLoc) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateCarLocation(carLoc);
        }
    }

    public void updateMapViewPort(MapViewPortParam mapViewPortParam) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateMapViewPort(mapViewPortParam);
        }
    }

    public void updateEagleEyeColorParam(MapColorParam mapColorParam, MapColorParam mapColorParam2) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateEagleEyeColorParam(mapColorParam, mapColorParam2);
        }
    }

    public void updateEagleEyeParam(EagleEyeParam eagleEyeParam) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateEagleEyeParam(eagleEyeParam);
        }
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            return iBizGuideEagleEyeControlImpl.setCarScaleByMapLevel(fArr);
        }
        return false;
    }

    public void setParkFloor(int i, int i2) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.setParkFloor(i, i2);
        }
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateRangeOnMapPolygon(arrayList);
        }
    }

    public void clearRangeOnMapPolygon() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.clearRangeOnMapPolygon();
        }
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateRangeOnMapCircle(bizCircleBusinessInfo);
        }
    }

    public void clearRangeOnMapCircle() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.clearRangeOnMapCircle();
        }
    }

    public void updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.updateSearchChargeStation(arrayList);
        }
    }

    public void clearSearchChargeStation() {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.clearSearchChargeStation();
        }
    }

    public BizCustomControl getCustomControl() {
        IBizCustomControlImpl customControl;
        TypeHelper typeHelper;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getCustomControl", new Class[0]);
            IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
            if (iBizGuideEagleEyeControlImpl == null || (customControl = iBizGuideEagleEyeControlImpl.getCustomControl()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizCustomControl) typeHelper.transfer(method, -1, (Object) customControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void previewCustomLayer(long j) {
        IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl = this.mControl;
        if (iBizGuideEagleEyeControlImpl != null) {
            iBizGuideEagleEyeControlImpl.previewCustomLayer(j);
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
