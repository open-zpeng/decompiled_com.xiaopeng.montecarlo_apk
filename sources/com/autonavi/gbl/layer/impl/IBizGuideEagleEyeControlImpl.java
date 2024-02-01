package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizGuideEagleEyeControl;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.model.EagleEyeParam;
import com.autonavi.gbl.layer.model.EagleEyeStyle;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import java.util.ArrayList;
@IntfAuto(target = BizGuideEagleEyeControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizGuideEagleEyeControlImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizGuideEagleEyeControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizGuideEagleEyeControlImpl_SWIGUpcast(long j);

    private static native void clearPathNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void clearRangeOnMapCircleNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void clearRangeOnMapPolygonNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void clearSearchChargeStationNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void destroyNativeObj(long j);

    private static native void drawPathNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, RouteDrawStyle routeDrawStyle);

    private static native long getBaseLayerNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2);

    private static native long getCustomControlNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native long getMapViewNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native boolean getRoutePathLayersNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, ArrayList<RoutePathLayerImpl> arrayList);

    private static native boolean getVisibleNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native int initNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, EagleEyeStyle eagleEyeStyle, long j3, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native boolean isInitializedNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void previewCustomLayerNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2);

    private static native boolean setCarScaleByMapLevelNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, float[] fArr);

    private static native void setParkFloorNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, int i, int i2);

    private static native void setPassGreyModeNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, boolean z);

    private static native void setVisibleNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, boolean z);

    private static native void stopNaviNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native boolean unInitNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void updateCarLocationNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, CarLoc carLoc);

    private static native void updateEagleEyeColorParamNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, MapColorParam mapColorParam, long j3, MapColorParam mapColorParam2);

    private static native void updateEagleEyeParamNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, EagleEyeParam eagleEyeParam);

    private static native void updateMapViewPortNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, MapViewPortParam mapViewPortParam);

    private static native void updateNaviInfoNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, NaviInfo naviInfo);

    private static native void updatePathsNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl);

    private static native void updateRangeOnMapCircleNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, long j2, BizCircleBusinessInfo bizCircleBusinessInfo);

    private static native void updateRangeOnMapPolygonNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, ArrayList<RangeOnMapPolygonInfo> arrayList);

    private static native void updateSearchChargeStationNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, ArrayList<BizSearchChargeStationInfo> arrayList);

    private static native void updateStyleNative(long j, IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl, boolean z);

    public IBizGuideEagleEyeControlImpl(long j, boolean z) {
        super(IBizGuideEagleEyeControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizGuideEagleEyeControlImpl) {
            return getUID(this) == getUID((IBizGuideEagleEyeControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl) {
        long cPtr = getCPtr(iBizGuideEagleEyeControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizGuideEagleEyeControlImpl iBizGuideEagleEyeControlImpl) {
        if (iBizGuideEagleEyeControlImpl == null) {
            return 0L;
        }
        return iBizGuideEagleEyeControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public int init(EagleEyeStyle eagleEyeStyle, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, eagleEyeStyle, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public boolean unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return unInitNative(j, this);
    }

    public boolean isInitialized() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitializedNative(j, this);
    }

    public IMapViewImpl getMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewNative = getMapViewNative(j, this);
        if (mapViewNative == 0) {
            return null;
        }
        return new IMapViewImpl(mapViewNative, false);
    }

    public BaseLayerImpl getBaseLayer(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        long baseLayerNative = getBaseLayerNative(j2, this, j);
        if (baseLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(baseLayerNative, false);
    }

    public ArrayList<RoutePathLayerImpl> getRoutePathLayers() {
        ArrayList<RoutePathLayerImpl> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getRoutePathLayers(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getRoutePathLayers(ArrayList<RoutePathLayerImpl> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoutePathLayersNative(j, this, arrayList);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, z);
    }

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public void setPassGreyMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPassGreyModeNative(j, this, z);
    }

    public void drawPath(RouteDrawStyle routeDrawStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        drawPathNative(j, this, 0L, routeDrawStyle);
    }

    public void clearPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPathNative(j, this);
    }

    public void updateStyle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this, z);
    }

    public void updatePaths() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePathsNative(j, this);
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, 0L, naviInfo);
    }

    public void stopNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        stopNaviNative(j, this);
    }

    public void updateCarLocation(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCarLocationNative(j, this, 0L, carLoc);
    }

    public void updateMapViewPort(MapViewPortParam mapViewPortParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateMapViewPortNative(j, this, 0L, mapViewPortParam);
    }

    public void updateEagleEyeColorParam(MapColorParam mapColorParam, MapColorParam mapColorParam2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateEagleEyeColorParamNative(j, this, 0L, mapColorParam, 0L, mapColorParam2);
    }

    public void updateEagleEyeParam(EagleEyeParam eagleEyeParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateEagleEyeParamNative(j, this, 0L, eagleEyeParam);
    }

    public boolean setCarScaleByMapLevel(float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCarScaleByMapLevelNative(j, this, fArr);
    }

    public void setParkFloor(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setParkFloorNative(j, this, i, i2);
    }

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRangeOnMapPolygonNative(j, this, arrayList);
    }

    public void clearRangeOnMapPolygon() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearRangeOnMapPolygonNative(j, this);
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRangeOnMapCircleNative(j, this, 0L, bizCircleBusinessInfo);
    }

    public void clearRangeOnMapCircle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearRangeOnMapCircleNative(j, this);
    }

    public void updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateSearchChargeStationNative(j, this, arrayList);
    }

    public void clearSearchChargeStation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearSearchChargeStationNative(j, this);
    }

    public IBizCustomControlImpl getCustomControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long customControlNative = getCustomControlNative(j, this);
        if (customControlNative == 0) {
            return null;
        }
        return new IBizCustomControlImpl(customControlNative, false);
    }

    public void previewCustomLayer(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        previewCustomLayerNative(j2, this, j);
    }
}
