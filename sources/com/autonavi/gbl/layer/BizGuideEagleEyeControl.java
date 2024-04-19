package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizCustomControl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControl;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.model.EagleEyeParam;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.RoutePathLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.util.model.ErrorCode;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizGuideEagleEyeControl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizGuideEagleEyeControl {
    private static String PACKAGE = ReflexTool.PN(BizGuideEagleEyeControl.class);
    private IBizGuideEagleEyeControl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizGuideEagleEyeControl(long j, boolean z) {
        this(new IBizGuideEagleEyeControl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizGuideEagleEyeControl.class, this, this.mControl);
        }
    }

    public BizGuideEagleEyeControl(IBizGuideEagleEyeControl iBizGuideEagleEyeControl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizGuideEagleEyeControl);
    }

    private void $constructor(IBizGuideEagleEyeControl iBizGuideEagleEyeControl) {
        if (iBizGuideEagleEyeControl != null) {
            this.mControl = iBizGuideEagleEyeControl;
            this.mTargetId = String.format("BizGuideEagleEyeControl_%s_%d", String.valueOf(IBizGuideEagleEyeControl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizGuideEagleEyeControl getControl() {
        return this.mControl;
    }

    public ArrayList<RoutePathLayer> getRoutePathLayers() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            return iBizGuideEagleEyeControl.getRoutePathLayers();
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init(EagleEyeStyle eagleEyeStyle, IPrepareLayerStyle iPrepareLayerStyle) {
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("init", EagleEyeStyle.class, IPrepareLayerStyle.class);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IPrepareLayerStyleImpl) typeHelper.transfer(method, 1, iPrepareLayerStyle) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $layerStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
            if (iBizGuideEagleEyeControl != null) {
                return iBizGuideEagleEyeControl.init(eagleEyeStyle, r2);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public boolean unInit() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            return iBizGuideEagleEyeControl.unInit();
        }
        return false;
    }

    public boolean isInitialized() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            return iBizGuideEagleEyeControl.isInitialized();
        }
        return false;
    }

    public MapView getMapView() {
        MapViewImpl mapView;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getMapView", new Class[0]);
            IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
            if (iBizGuideEagleEyeControl != null && (mapView = iBizGuideEagleEyeControl.getMapView()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapView) typeHelper.transfer(method, -1, (Object) mapView, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BaseLayer getBaseLayer(long j) {
        BaseLayerImpl baseLayer;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getBaseLayer", Long.TYPE);
            IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
            if (iBizGuideEagleEyeControl != null && (baseLayer = iBizGuideEagleEyeControl.getBaseLayer(j)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, -1, (Object) baseLayer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setVisible(boolean z) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.setVisible(z);
        }
    }

    public boolean getVisible() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            return iBizGuideEagleEyeControl.getVisible();
        }
        return false;
    }

    public void setPassGreyMode(boolean z) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.setPassGreyMode(z);
        }
    }

    public void drawPath(RouteDrawStyle routeDrawStyle) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.drawPath(routeDrawStyle);
        }
    }

    public void clearPath() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.clearPath();
        }
    }

    public void updateStyle(boolean z) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateStyle(z);
        }
    }

    public void updatePaths() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updatePaths();
        }
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateNaviInfo(naviInfo);
        }
    }

    public void stopNavi() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.stopNavi();
        }
    }

    public void updateCarLocation(CarLoc carLoc) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateCarLocation(carLoc);
        }
    }

    public void updateMapViewPort(MapViewPortParam mapViewPortParam) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateMapViewPort(mapViewPortParam);
        }
    }

    public void updateEagleEyeColorParam(MapColorParam mapColorParam, MapColorParam mapColorParam2) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateEagleEyeColorParam(mapColorParam, mapColorParam2);
        }
    }

    public void updateEagleEyeParam(EagleEyeParam eagleEyeParam) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateEagleEyeParam(eagleEyeParam);
        }
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        if (fArr != null && fArr.length == 0) {
            fArr = null;
        }
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            return iBizGuideEagleEyeControl.setCarScaleByMapLevel(fArr);
        }
        return false;
    }

    public void setParkFloor(int i) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.setParkFloor(i);
        }
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateRangeOnMapPolygon(arrayList);
        }
    }

    public void clearRangeOnMapPolygon() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.clearRangeOnMapPolygon();
        }
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateRangeOnMapCircle(bizCircleBusinessInfo);
        }
    }

    public void clearRangeOnMapCircle() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.clearRangeOnMapCircle();
        }
    }

    public void updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.updateSearchChargeStation(arrayList);
        }
    }

    public void clearSearchChargeStation() {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.clearSearchChargeStation();
        }
    }

    public BizCustomControl getCustomControl() {
        IBizCustomControl customControl;
        try {
            Method method = BizGuideEagleEyeControl.class.getMethod("getCustomControl", new Class[0]);
            IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
            if (iBizGuideEagleEyeControl != null && (customControl = iBizGuideEagleEyeControl.getCustomControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizCustomControl) typeHelper.transfer(method, -1, (Object) customControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void previewCustomLayer(long j) {
        IBizGuideEagleEyeControl iBizGuideEagleEyeControl = this.mControl;
        if (iBizGuideEagleEyeControl != null) {
            iBizGuideEagleEyeControl.previewCustomLayer(j);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.5
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.6
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizGuideEagleEyeControl.7
        }));
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
