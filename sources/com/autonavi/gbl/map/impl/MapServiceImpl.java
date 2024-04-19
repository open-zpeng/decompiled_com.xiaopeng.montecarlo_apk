package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.MapService;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.observer.impl.IAnimationObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapLifecycleObserver;
import com.autonavi.gbl.map.observer.impl.IMapRunnableImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.EGErr;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = MapService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(MapServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortNetworkNative(long j, MapServiceImpl mapServiceImpl);

    private static native boolean changeMapEnvNative(long j, MapServiceImpl mapServiceImpl, byte[] bArr);

    private static native boolean clearCacheNative(long j, MapServiceImpl mapServiceImpl);

    private static native long createDevice1Native(long j, MapServiceImpl mapServiceImpl, int i, long j2, DeviceAttribute deviceAttribute, long j3, IMapLifecycleObserver iMapLifecycleObserver);

    private static native long createDeviceNative(long j, MapServiceImpl mapServiceImpl, int i, long j2, DeviceAttribute deviceAttribute, long j3, IDeviceObserverImpl iDeviceObserverImpl);

    private static native long createMapView1Native(long j, MapServiceImpl mapServiceImpl, long j2, MapViewParam mapViewParam, long j3, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j4, IMapLifecycleObserver iMapLifecycleObserver);

    private static native long createMapView2Native(long j, MapServiceImpl mapServiceImpl, long j2, MapViewParam mapViewParam, long j3, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j4, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j5, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, long j6, IAnimationObserverImpl iAnimationObserverImpl);

    private static native long createMapViewNative(long j, MapServiceImpl mapServiceImpl, long j2, MapViewParam mapViewParam);

    private static native boolean destroyDeviceNative(long j, MapServiceImpl mapServiceImpl, long j2, MapDeviceImpl mapDeviceImpl);

    private static native boolean destroyMapViewNative(long j, MapServiceImpl mapServiceImpl, long j2, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native long getDeviceIdsNative(long j, MapServiceImpl mapServiceImpl, long[] jArr);

    private static native long getDeviceNative(long j, MapServiceImpl mapServiceImpl, int i);

    private static native long getEngineIdWithGestureNative(long j, MapServiceImpl mapServiceImpl, long j2, GestureInfo gestureInfo);

    private static native String getMapEngineVersionNative();

    private static native long getMapViewIdsNative(long j, MapServiceImpl mapServiceImpl, long[] jArr);

    private static native long getMapViewNative(long j, MapServiceImpl mapServiceImpl, int i);

    private static native long getMapViewProxyNative(long j, MapServiceImpl mapServiceImpl, int i);

    private static native String getNaviRebuildVersionNative();

    private static native long getServiceViewIdsNative(long j, MapServiceImpl mapServiceImpl, long[] jArr);

    private static native int initMapNative(long j, MapServiceImpl mapServiceImpl, long j2, InitMapParam initMapParam, long j3, IMapFontObserverImpl iMapFontObserverImpl);

    private static native int isInitNative(long j, MapServiceImpl mapServiceImpl);

    private static native void openFpsControlNative(long j, MapServiceImpl mapServiceImpl);

    private static native void queueEventNative(long j, MapServiceImpl mapServiceImpl, int i, long j2, IMapRunnableImpl iMapRunnableImpl);

    private static native void setMapFontObserverNative(long j, MapServiceImpl mapServiceImpl, long j2, IMapFontObserverImpl iMapFontObserverImpl);

    private static native void setNeedRecreateSurface1Native(long j, MapServiceImpl mapServiceImpl, boolean z);

    private static native void setNeedRecreateSurfaceNative(long j, MapServiceImpl mapServiceImpl, boolean z, int i);

    private static native void setNetworkTypeNative(long j, MapServiceImpl mapServiceImpl, int i);

    private static native int unitMapNative(long j, MapServiceImpl mapServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected MapServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MapServiceImpl) && getUID(this) == getUID((MapServiceImpl) obj);
    }

    private static long getUID(MapServiceImpl mapServiceImpl) {
        long cPtr = getCPtr(mapServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapServiceImpl mapServiceImpl) {
        if (mapServiceImpl == null) {
            return 0L;
        }
        return mapServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
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

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public static String getMapEngineVersion() {
        return getMapEngineVersionNative();
    }

    public static String getNaviRebuildVersion() {
        return getNaviRebuildVersionNative();
    }

    @EGErr.EGErr1
    public int initMap(InitMapParam initMapParam, IMapFontObserverImpl iMapFontObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initMapNative(j, this, 0L, initMapParam, IMapFontObserverImpl.getCPtr(iMapFontObserverImpl), iMapFontObserverImpl);
    }

    @EGErr.EGErr1
    public int unitMap() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        onDestroy();
        return unitMapNative(this.swigCPtr, this);
    }

    public void setMapFontObserver(IMapFontObserverImpl iMapFontObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapFontObserverNative(j, this, IMapFontObserverImpl.getCPtr(iMapFontObserverImpl), iMapFontObserverImpl);
    }

    public MapDeviceImpl createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IDeviceObserverImpl iDeviceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDeviceNative = createDeviceNative(j, this, i, 0L, deviceAttribute, IDeviceObserverImpl.getCPtr(iDeviceObserverImpl), iDeviceObserverImpl);
        if (createDeviceNative == 0) {
            return null;
        }
        return new MapDeviceImpl(createDeviceNative, false);
    }

    public MapDeviceImpl createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IMapLifecycleObserver iMapLifecycleObserver) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDevice1Native = createDevice1Native(j, this, i, 0L, deviceAttribute, IMapLifecycleObserver.getCPtr(iMapLifecycleObserver), iMapLifecycleObserver);
        if (createDevice1Native == 0) {
            return null;
        }
        return new MapDeviceImpl(createDevice1Native, false);
    }

    public MapDeviceImpl getDevice(@EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long deviceNative = getDeviceNative(j, this, i);
        if (deviceNative == 0) {
            return null;
        }
        return new MapDeviceImpl(deviceNative, false);
    }

    public boolean destroyDevice(MapDeviceImpl mapDeviceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyDeviceNative(j, this, MapDeviceImpl.getCPtr(mapDeviceImpl), mapDeviceImpl);
    }

    public long[] getDeviceIds() {
        long[] jArr = new long[15];
        Long valueOf = Long.valueOf(getDeviceIds(jArr));
        long[] jArr2 = new long[valueOf.intValue()];
        for (int i = 0; i < valueOf.intValue(); i++) {
            jArr2[i] = jArr[i];
        }
        return jArr2;
    }

    private long getDeviceIds(long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDeviceIdsNative(j, this, jArr);
    }

    public boolean changeMapEnv(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return changeMapEnvNative(j, this, bArr);
    }

    public MapViewImpl createMapView(MapViewParam mapViewParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapViewNative = createMapViewNative(j, this, 0L, mapViewParam);
        if (createMapViewNative == 0) {
            return null;
        }
        return new MapViewImpl(createMapViewNative, false);
    }

    public MapViewImpl createMapView(MapViewParam mapViewParam, IBLMapViewProxyImpl iBLMapViewProxyImpl, IMapLifecycleObserver iMapLifecycleObserver) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapView1Native = createMapView1Native(j, this, 0L, mapViewParam, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl, IMapLifecycleObserver.getCPtr(iMapLifecycleObserver), iMapLifecycleObserver);
        if (createMapView1Native == 0) {
            return null;
        }
        return new MapViewImpl(createMapView1Native, false);
    }

    public MapViewImpl createMapView(MapViewParam mapViewParam, IBLMapViewProxyImpl iBLMapViewProxyImpl, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, IAnimationObserverImpl iAnimationObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapView2Native = createMapView2Native(j, this, 0L, mapViewParam, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl, IBLMapEngineObserverImpl.getCPtr(iBLMapEngineObserverImpl), iBLMapEngineObserverImpl, IBLMapBusinessDataObserverImpl.getCPtr(iBLMapBusinessDataObserverImpl), iBLMapBusinessDataObserverImpl, IAnimationObserverImpl.getCPtr(iAnimationObserverImpl), iAnimationObserverImpl);
        if (createMapView2Native == 0) {
            return null;
        }
        return new MapViewImpl(createMapView2Native, false);
    }

    public void openFpsControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openFpsControlNative(j, this);
    }

    public MapViewImpl getMapView(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewNative = getMapViewNative(j, this, i);
        if (mapViewNative == 0) {
            return null;
        }
        return new MapViewImpl(mapViewNative, false);
    }

    public IBLMapViewProxyImpl getMapViewProxy(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewProxyNative = getMapViewProxyNative(j, this, i);
        if (mapViewProxyNative == 0) {
            return null;
        }
        return new IBLMapViewProxyImpl(mapViewProxyNative, false);
    }

    public long[] getServiceViewIds() {
        long[] jArr = new long[15];
        Long valueOf = Long.valueOf(getServiceViewIds(jArr));
        long[] jArr2 = new long[valueOf.intValue()];
        for (int i = 0; i < valueOf.intValue(); i++) {
            jArr2[i] = jArr[i];
        }
        return jArr2;
    }

    private long getServiceViewIds(long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceViewIdsNative(j, this, jArr);
    }

    public long[] getMapViewIds() {
        long[] jArr = new long[15];
        Long valueOf = Long.valueOf(getMapViewIds(jArr));
        long[] jArr2 = new long[valueOf.intValue()];
        for (int i = 0; i < valueOf.intValue(); i++) {
            jArr2[i] = jArr[i];
        }
        return jArr2;
    }

    private long getMapViewIds(long[] jArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapViewIdsNative(j, this, jArr);
    }

    public long getEngineIdWithGesture(GestureInfo gestureInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEngineIdWithGestureNative(j, this, 0L, gestureInfo);
    }

    public boolean destroyMapView(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyMapViewNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
    }

    public void queueEvent(@EGLDeviceID.EGLDeviceID1 int i, IMapRunnableImpl iMapRunnableImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        queueEventNative(j, this, i, IMapRunnableImpl.getCPtr(iMapRunnableImpl), iMapRunnableImpl);
    }

    public void setNetworkType(@NetworkStatus.NetworkStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNetworkTypeNative(j, this, i);
    }

    public void abortNetwork() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortNetworkNative(j, this);
    }

    public void setNeedRecreateSurface(boolean z, @EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNeedRecreateSurfaceNative(j, this, z, i);
    }

    public void setNeedRecreateSurface(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNeedRecreateSurface1Native(j, this, z);
    }

    public boolean clearCache() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clearCacheNative(j, this);
    }
}
