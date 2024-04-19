package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.layer.impl.LayerMgrImpl;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapControllerStatesType;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapLeftTop;
import com.autonavi.gbl.map.model.MapMessageType;
import com.autonavi.gbl.map.model.MapPositionParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.map.model.MapViewStateType;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.map.model.NaviMessageParam;
import com.autonavi.gbl.map.model.PointF;
import com.autonavi.gbl.map.model.PreviewParam;
import com.autonavi.gbl.map.model.ScreenShotInfo;
import com.autonavi.gbl.map.model.TestMapPara;
import com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapRunnableImpl;
import com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl;
import com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl;
import com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl;
@IntfAuto(target = MapView.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapViewImpl {
    private static BindTable BIND_TABLE = new BindTable(MapViewImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addGestureObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapGestureObserverImpl iMapGestureObserverImpl);

    private static native boolean addLayer3DModelNative(long j, MapViewImpl mapViewImpl, long j2, Layer3DModel layer3DModel);

    private static native boolean addLayerTextureNative(long j, MapViewImpl mapViewImpl, long j2, LayerTexture layerTexture);

    private static native boolean addMapEventObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapEventObserverImpl iMapEventObserverImpl);

    private static native void addMapviewObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapviewObserverImpl iMapviewObserverImpl);

    private static native void addNaviMessageNative(long j, MapViewImpl mapViewImpl, long j2, NaviMessageParam naviMessageParam);

    private static native void addReculateOverlayObserverNative(long j, MapViewImpl mapViewImpl, long j2, IReculateOverlayImpl iReculateOverlayImpl);

    private static native boolean cancelMapPostureCacheNative(long j, MapViewImpl mapViewImpl);

    private static native void clearMessageNative(long j, MapViewImpl mapViewImpl, int i);

    private static native boolean destroyLayer3DModelNative(long j, MapViewImpl mapViewImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native boolean destroyTextureNative(long j, MapViewImpl mapViewImpl, int i);

    private static native boolean doDataControlNative(long j, MapViewImpl mapViewImpl, int i, int i2, int i3, int i4);

    private static native void doRenderMapNative(long j, MapViewImpl mapViewImpl, boolean z);

    private static native void exitPreviewNative(long j, MapViewImpl mapViewImpl, boolean z);

    private static native boolean flushMapPostureCacheNative(long j, MapViewImpl mapViewImpl, long j2, boolean z, long j3);

    private static native boolean get3DModelBoundRectNative(long j, MapViewImpl mapViewImpl, int i, long j2, RectDouble rectDouble);

    private static native RectInt getBoundRectNative(long j, MapViewImpl mapViewImpl, int i, int i2, int i3, float f);

    private static native long getCapacityTextureCountNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getControllerStatesOperatorNative(long j, MapViewImpl mapViewImpl, int i, int[] iArr);

    private static native int getDeviceIdNative(long j, MapViewImpl mapViewImpl);

    private static native int getEngineIdNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getLayerCollisionEnableNative(long j, MapViewImpl mapViewImpl);

    private static native long getLayerMgrNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getLayerTextureNative(long j, MapViewImpl mapViewImpl, int i, long j2, LayerTexture layerTexture);

    private static native float getMapFadeAnimAlphaNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getMapFadeAnimOverNative(long j, MapViewImpl mapViewImpl);

    private static native void getMapLeftTopNative(long j, MapViewImpl mapViewImpl, int[] iArr, int[] iArr2);

    private static native int getMapMessageCountNative(long j, MapViewImpl mapViewImpl, int i);

    private static native int getMapModeNative(long j, MapViewImpl mapViewImpl);

    private static native void getMapProjectionCenterNative(long j, MapViewImpl mapViewImpl, float[] fArr, float[] fArr2);

    private static native long getMapViewProxyNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getMapViewStatesOperatorNative(long j, MapViewImpl mapViewImpl, int i, int[] iArr);

    private static native boolean getMapviewPortNative(long j, MapViewImpl mapViewImpl, long j2, MapViewPortParam mapViewPortParam);

    private static native long getOperatorAnimationNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorBusinessNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorCollisionNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorGestureNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorPostureNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorScaleNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorStyleNative(long j, MapViewImpl mapViewImpl);

    private static native long getOperatorWeatherNative(long j, MapViewImpl mapViewImpl);

    private static native int getRCTCityDataVersionNative(long j, MapViewImpl mapViewImpl, int i);

    private static native float getRealRenderFPSNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getScreenShotInfoNative(long j, MapViewImpl mapViewImpl, long j2, RectInt rectInt, long j3, ScreenShotInfo screenShotInfo, long j4, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl);

    private static native long getUsedTextureCountNative(long j, MapViewImpl mapViewImpl);

    private static native long getUsedVideoMemoryNative(long j, MapViewImpl mapViewImpl);

    private static native boolean getZoomableNative(long j, MapViewImpl mapViewImpl);

    private static native void goToPositionNative(long j, MapViewImpl mapViewImpl, long j2, MapPositionParam mapPositionParam, boolean z);

    private static native boolean isEagleEyeViewNative(long j, MapViewImpl mapViewImpl);

    private static native void mapZoomInNative(long j, MapViewImpl mapViewImpl, boolean z, boolean z2);

    private static native void mapZoomOutNative(long j, MapViewImpl mapViewImpl, boolean z, boolean z2);

    private static native void queueEventNative(long j, MapViewImpl mapViewImpl, long j2, IMapRunnableImpl iMapRunnableImpl);

    private static native void removeGestureObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapGestureObserverImpl iMapGestureObserverImpl);

    private static native void removeMapEngineObserverNative(long j, MapViewImpl mapViewImpl);

    private static native boolean removeMapEventObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapEventObserverImpl iMapEventObserverImpl);

    private static native void removeMapviewObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapviewObserverImpl iMapviewObserverImpl);

    private static native void removeReculateOverlayObserverNative(long j, MapViewImpl mapViewImpl, long j2, IReculateOverlayImpl iReculateOverlayImpl);

    private static native void resetMapviewPortNative(long j, MapViewImpl mapViewImpl);

    private static native void resetTickCountNative(long j, MapViewImpl mapViewImpl, int i);

    private static native void setCarPositionRatioNative(long j, MapViewImpl mapViewImpl, float f, float f2);

    private static native boolean setControllerStatesOperatorNative(long j, MapViewImpl mapViewImpl, int i, int i2, boolean z);

    private static native void setLayerCollisionEnableNative(long j, MapViewImpl mapViewImpl, boolean z);

    private static native void setMapEngineObserverNative(long j, MapViewImpl mapViewImpl, long j2, IBLMapEngineObserverImpl iBLMapEngineObserverImpl);

    private static native void setMapFadeInNative(long j, MapViewImpl mapViewImpl, int i);

    private static native void setMapFadeOutNative(long j, MapViewImpl mapViewImpl, int i);

    private static native void setMapFpsObserverNative(long j, MapViewImpl mapViewImpl, long j2, IMapFpsObserverImpl iMapFpsObserverImpl);

    private static native void setMapLeftTopNative(long j, MapViewImpl mapViewImpl, int i, int i2);

    private static native void setMapModeNative(long j, MapViewImpl mapViewImpl, long j2, MapviewModeParam mapviewModeParam, boolean z);

    private static native void setMapNeedForceDrawLabel1Native(long j, MapViewImpl mapViewImpl);

    private static native void setMapNeedForceDrawLabelNative(long j, MapViewImpl mapViewImpl, int i);

    private static native void setMapProjectionCenterNative(long j, MapViewImpl mapViewImpl, float f, float f2);

    private static native void setMapViewProxyNative(long j, MapViewImpl mapViewImpl, long j2, IBLMapViewProxyImpl iBLMapViewProxyImpl);

    private static native boolean setMapViewStatesOperatorNative(long j, MapViewImpl mapViewImpl, int i, int i2);

    private static native void setMapVisibleNative(long j, MapViewImpl mapViewImpl, boolean z);

    private static native void setMapviewPortNative(long j, MapViewImpl mapViewImpl, long j2, MapViewPortParam mapViewPortParam);

    private static native boolean setMaxRenderDurationNative(long j, MapViewImpl mapViewImpl, long j2);

    private static native void setTextTextureObserverNative(long j, MapViewImpl mapViewImpl, long j2, ITextTextureObserverImpl iTextTextureObserverImpl);

    private static native void setZoomableNative(long j, MapViewImpl mapViewImpl, boolean z);

    private static native boolean showEarthViewNative(long j, MapViewImpl mapViewImpl, boolean z, float f, float f2);

    private static native void showPreviewNative(long j, MapViewImpl mapViewImpl, long j2, PreviewParam previewParam, boolean z, int i, int i2);

    private static native boolean startMapPostureCacheNative(long j, MapViewImpl mapViewImpl);

    private static native boolean testMapParamterNative(long j, MapViewImpl mapViewImpl, long j2, TestMapPara testMapPara);

    private static native boolean updateLayer3DModelNative(long j, MapViewImpl mapViewImpl, long j2, Layer3DModel layer3DModel);

    private static native boolean updateTextureNative(long j, MapViewImpl mapViewImpl, long j2, LayerTexture layerTexture);

    public MapViewImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MapViewImpl) && getUID(this) == getUID((MapViewImpl) obj);
    }

    private static long getUID(MapViewImpl mapViewImpl) {
        long cPtr = getCPtr(mapViewImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapViewImpl mapViewImpl) {
        if (mapViewImpl == null) {
            return 0L;
        }
        return mapViewImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void queueEvent(IMapRunnableImpl iMapRunnableImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        queueEventNative(j, this, IMapRunnableImpl.getCPtr(iMapRunnableImpl), iMapRunnableImpl);
    }

    public OperatorStyleImpl getOperatorStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorStyleNative = getOperatorStyleNative(j, this);
        if (operatorStyleNative == 0) {
            return null;
        }
        return new OperatorStyleImpl(operatorStyleNative, false);
    }

    public LayerMgrImpl getLayerMgr() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long layerMgrNative = getLayerMgrNative(j, this);
        if (layerMgrNative == 0) {
            return null;
        }
        return new LayerMgrImpl(layerMgrNative, false);
    }

    public OperatorBusinessImpl getOperatorBusiness() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorBusinessNative = getOperatorBusinessNative(j, this);
        if (operatorBusinessNative == 0) {
            return null;
        }
        return new OperatorBusinessImpl(operatorBusinessNative, false);
    }

    public OperatorPostureImpl getOperatorPosture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorPostureNative = getOperatorPostureNative(j, this);
        if (operatorPostureNative == 0) {
            return null;
        }
        return new OperatorPostureImpl(operatorPostureNative, false);
    }

    public OperatorGestureImpl getOperatorGesture() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorGestureNative = getOperatorGestureNative(j, this);
        if (operatorGestureNative == 0) {
            return null;
        }
        return new OperatorGestureImpl(operatorGestureNative, false);
    }

    public OperatorAnimationImpl getOperatorAnimation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorAnimationNative = getOperatorAnimationNative(j, this);
        if (operatorAnimationNative == 0) {
            return null;
        }
        return new OperatorAnimationImpl(operatorAnimationNative, false);
    }

    public OperatorCollisionImpl getOperatorCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorCollisionNative = getOperatorCollisionNative(j, this);
        if (operatorCollisionNative == 0) {
            return null;
        }
        return new OperatorCollisionImpl(operatorCollisionNative, false);
    }

    public OperatorScaleImpl getOperatorScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorScaleNative = getOperatorScaleNative(j, this);
        if (operatorScaleNative == 0) {
            return null;
        }
        return new OperatorScaleImpl(operatorScaleNative, false);
    }

    public OperatorWeatherImpl getOperatorWeather() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long operatorWeatherNative = getOperatorWeatherNative(j, this);
        if (operatorWeatherNative == 0) {
            return null;
        }
        return new OperatorWeatherImpl(operatorWeatherNative, false);
    }

    public boolean addLayer3DModel(Layer3DModel layer3DModel) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addLayer3DModelNative(j, this, 0L, layer3DModel);
    }

    public boolean updateLayer3DModel(Layer3DModel layer3DModel) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateLayer3DModelNative(j, this, 0L, layer3DModel);
    }

    public boolean destroyLayer3DModel(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyLayer3DModelNative(j, this, i);
    }

    public RectDouble get3DModelBoundRect(int i) {
        RectDouble rectDouble = new RectDouble();
        if (Boolean.valueOf(get3DModelBoundRect(i, rectDouble)).booleanValue()) {
            return rectDouble;
        }
        return null;
    }

    private boolean get3DModelBoundRect(int i, RectDouble rectDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get3DModelBoundRectNative(j, this, i, 0L, rectDouble);
    }

    public boolean addLayerTexture(LayerTexture layerTexture) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addLayerTextureNative(j, this, 0L, layerTexture);
    }

    public boolean updateTexture(LayerTexture layerTexture) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateTextureNative(j, this, 0L, layerTexture);
    }

    public boolean destroyTexture(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyTextureNative(j, this, i);
    }

    public LayerTexture getLayerTexture(int i) {
        LayerTexture layerTexture = new LayerTexture();
        if (Boolean.valueOf(getLayerTexture(i, layerTexture)).booleanValue()) {
            return layerTexture;
        }
        return null;
    }

    private boolean getLayerTexture(int i, LayerTexture layerTexture) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLayerTextureNative(j, this, i, 0L, layerTexture);
    }

    public long getCapacityTextureCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCapacityTextureCountNative(j, this);
    }

    public long getUsedTextureCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUsedTextureCountNative(j, this);
    }

    public RectInt getBoundRect(int i, int i2, int i3, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBoundRectNative(j, this, i, i2, i3, f);
    }

    public void addMapviewObserver(IMapviewObserverImpl iMapviewObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addMapviewObserverNative(j, this, IMapviewObserverImpl.getCPtr(iMapviewObserverImpl), iMapviewObserverImpl);
    }

    public void removeMapviewObserver(IMapviewObserverImpl iMapviewObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeMapviewObserverNative(j, this, IMapviewObserverImpl.getCPtr(iMapviewObserverImpl), iMapviewObserverImpl);
    }

    public boolean addMapEventObserver(IMapEventObserverImpl iMapEventObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addMapEventObserverNative(j, this, IMapEventObserverImpl.getCPtr(iMapEventObserverImpl), iMapEventObserverImpl);
    }

    public boolean removeMapEventObserver(IMapEventObserverImpl iMapEventObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeMapEventObserverNative(j, this, IMapEventObserverImpl.getCPtr(iMapEventObserverImpl), iMapEventObserverImpl);
    }

    public void addGestureObserver(IMapGestureObserverImpl iMapGestureObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addGestureObserverNative(j, this, IMapGestureObserverImpl.getCPtr(iMapGestureObserverImpl), iMapGestureObserverImpl);
    }

    public void removeGestureObserver(IMapGestureObserverImpl iMapGestureObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeGestureObserverNative(j, this, IMapGestureObserverImpl.getCPtr(iMapGestureObserverImpl), iMapGestureObserverImpl);
    }

    public void setMapEngineObserver(IBLMapEngineObserverImpl iBLMapEngineObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapEngineObserverNative(j, this, IBLMapEngineObserverImpl.getCPtr(iBLMapEngineObserverImpl), iBLMapEngineObserverImpl);
    }

    public void removeMapEngineObserver() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeMapEngineObserverNative(j, this);
    }

    public void addReculateOverlayObserver(IReculateOverlayImpl iReculateOverlayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addReculateOverlayObserverNative(j, this, IReculateOverlayImpl.getCPtr(iReculateOverlayImpl), iReculateOverlayImpl);
    }

    public void removeReculateOverlayObserver(IReculateOverlayImpl iReculateOverlayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeReculateOverlayObserverNative(j, this, IReculateOverlayImpl.getCPtr(iReculateOverlayImpl), iReculateOverlayImpl);
    }

    public void setTextTextureObserver(ITextTextureObserverImpl iTextTextureObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setTextTextureObserverNative(j, this, ITextTextureObserverImpl.getCPtr(iTextTextureObserverImpl), iTextTextureObserverImpl);
    }

    public void setMapFpsObserver(IMapFpsObserverImpl iMapFpsObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapFpsObserverNative(j, this, IMapFpsObserverImpl.getCPtr(iMapFpsObserverImpl), iMapFpsObserverImpl);
    }

    public void setMapViewProxy(IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapViewProxyNative(j, this, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl);
    }

    public IBLMapViewProxyImpl getMapViewProxy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewProxyNative = getMapViewProxyNative(j, this);
        if (mapViewProxyNative == 0) {
            return null;
        }
        return new IBLMapViewProxyImpl(mapViewProxyNative, false);
    }

    @MapEngineID.MapEngineID1
    public int getEngineId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEngineIdNative(j, this);
    }

    public boolean isEagleEyeView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEagleEyeViewNative(j, this);
    }

    @EGLDeviceID.EGLDeviceID1
    public int getDeviceId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDeviceIdNative(j, this);
    }

    public int getRCTCityDataVersion(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRCTCityDataVersionNative(j, this, i);
    }

    public float getRealRenderFPS() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRealRenderFPSNative(j, this);
    }

    public long getUsedVideoMemory() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUsedVideoMemoryNative(j, this);
    }

    public boolean setMaxRenderDuration(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setMaxRenderDurationNative(j2, this, j);
    }

    public void resetTickCount(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetTickCountNative(j, this, i);
    }

    public void setMapNeedForceDrawLabel(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapNeedForceDrawLabelNative(j, this, i);
    }

    public void setMapNeedForceDrawLabel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapNeedForceDrawLabel1Native(j, this);
    }

    public void doRenderMap(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        doRenderMapNative(j, this, z);
    }

    public void addNaviMessage(NaviMessageParam naviMessageParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addNaviMessageNative(j, this, 0L, naviMessageParam);
    }

    public int getMapMessageCount(@MapMessageType.MapMessageType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapMessageCountNative(j, this, i);
    }

    public void clearMessage(@MapMessageType.MapMessageType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearMessageNative(j, this, i);
    }

    public boolean showEarthView(boolean z, float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return showEarthViewNative(j, this, z, f, f2);
    }

    public boolean setMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMapViewStatesOperatorNative(j, this, i, i2);
    }

    public int getMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i) {
        int[] iArr = new int[1];
        if (Boolean.valueOf(getMapViewStatesOperator(i, iArr)).booleanValue()) {
            return iArr[0];
        }
        return 0;
    }

    private boolean getMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i, int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapViewStatesOperatorNative(j, this, i, iArr);
    }

    public boolean setControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i, int i2, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setControllerStatesOperatorNative(j, this, i, i2, z);
    }

    public int getControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i) {
        int[] iArr = new int[1];
        if (Boolean.valueOf(getControllerStatesOperator(i, iArr)).booleanValue()) {
            return iArr[0];
        }
        return 0;
    }

    private boolean getControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i, int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getControllerStatesOperatorNative(j, this, i, iArr);
    }

    public void setMapVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapVisibleNative(j, this, z);
    }

    public void setMapviewPort(MapViewPortParam mapViewPortParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapviewPortNative(j, this, 0L, mapViewPortParam);
    }

    public void resetMapviewPort() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetMapviewPortNative(j, this);
    }

    public MapViewPortParam getMapviewPort() {
        MapViewPortParam mapViewPortParam = new MapViewPortParam();
        if (Boolean.valueOf(getMapviewPort(mapViewPortParam)).booleanValue()) {
            return mapViewPortParam;
        }
        return null;
    }

    private boolean getMapviewPort(MapViewPortParam mapViewPortParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapviewPortNative(j, this, 0L, mapViewPortParam);
    }

    public void setMapLeftTop(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapLeftTopNative(j, this, i, i2);
    }

    public MapLeftTop getMapLeftTop() {
        MapLeftTop mapLeftTop = new MapLeftTop();
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        getMapLeftTop(iArr, iArr2);
        mapLeftTop.left = iArr[0];
        mapLeftTop.top = iArr2[0];
        return mapLeftTop;
    }

    private void getMapLeftTop(int[] iArr, int[] iArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapLeftTopNative(j, this, iArr, iArr2);
    }

    public void setMapProjectionCenter(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapProjectionCenterNative(j, this, f, f2);
    }

    public PointF getMapProjectionCenter() {
        PointF pointF = new PointF();
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        getMapProjectionCenter(fArr, fArr2);
        pointF.x = fArr[0];
        pointF.y = fArr2[0];
        return pointF;
    }

    private void getMapProjectionCenter(float[] fArr, float[] fArr2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getMapProjectionCenterNative(j, this, fArr, fArr2);
    }

    public void mapZoomIn(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapZoomInNative(j, this, z, z2);
    }

    public void mapZoomOut(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapZoomOutNative(j, this, z, z2);
    }

    public void setCarPositionRatio(float f, float f2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarPositionRatioNative(j, this, f, f2);
    }

    public void setMapMode(MapviewModeParam mapviewModeParam, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapModeNative(j, this, 0L, mapviewModeParam, z);
    }

    @MapviewMode.MapviewMode1
    public int getMapMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapModeNative(j, this);
    }

    public void goToPosition(MapPositionParam mapPositionParam, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        goToPositionNative(j, this, 0L, mapPositionParam, z);
    }

    public void showPreview(PreviewParam previewParam, boolean z, int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showPreviewNative(j, this, 0L, previewParam, z, i, i2);
    }

    public void exitPreview(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        exitPreviewNative(j, this, z);
    }

    public ScreenShotInfo getScreenShotInfo(RectInt rectInt, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl) {
        ScreenShotInfo screenShotInfo = new ScreenShotInfo();
        Boolean.valueOf(getScreenShotInfo(rectInt, screenShotInfo, iBLMapBusinessDataObserverImpl));
        return screenShotInfo;
    }

    private boolean getScreenShotInfo(RectInt rectInt, ScreenShotInfo screenShotInfo, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScreenShotInfoNative(j, this, 0L, rectInt, 0L, screenShotInfo, IBLMapBusinessDataObserverImpl.getCPtr(iBLMapBusinessDataObserverImpl), iBLMapBusinessDataObserverImpl);
    }

    public boolean doDataControl(int i, int i2, int i3, int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return doDataControlNative(j, this, i, i2, i3, i4);
    }

    public boolean testMapParamter(TestMapPara testMapPara) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return testMapParamterNative(j, this, 0L, testMapPara);
    }

    public void setMapFadeIn(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapFadeInNative(j, this, i);
    }

    public void setMapFadeOut(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapFadeOutNative(j, this, i);
    }

    public boolean getMapFadeAnimOver() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapFadeAnimOverNative(j, this);
    }

    public float getMapFadeAnimAlpha() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapFadeAnimAlphaNative(j, this);
    }

    public void setLayerCollisionEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLayerCollisionEnableNative(j, this, z);
    }

    public boolean getLayerCollisionEnable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLayerCollisionEnableNative(j, this);
    }

    public boolean startMapPostureCache() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startMapPostureCacheNative(j, this);
    }

    public boolean cancelMapPostureCache() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return cancelMapPostureCacheNative(j, this);
    }

    public boolean flushMapPostureCache(long j, boolean z, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        return flushMapPostureCacheNative(j3, this, j, z, j2);
    }

    public void setZoomable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setZoomableNative(j, this, z);
    }

    public boolean getZoomable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getZoomableNative(j, this);
    }
}
