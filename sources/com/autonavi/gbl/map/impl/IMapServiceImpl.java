package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.MapService;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapThemeInfo;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.observer.impl.IAnimationObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapFontObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapLifecycleObserverImpl;
import com.autonavi.gbl.map.observer.impl.MapRunnableImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = MapService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IMapServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortNetworkNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native boolean changeMapEnvNative(long j, IMapServiceImpl iMapServiceImpl, byte[] bArr);

    private static native boolean clearCacheNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native long createDevice1Native(long j, IMapServiceImpl iMapServiceImpl, int i, long j2, DeviceAttribute deviceAttribute, long j3, IMapLifecycleObserverImpl iMapLifecycleObserverImpl);

    private static native long createDeviceNative(long j, IMapServiceImpl iMapServiceImpl, int i, long j2, DeviceAttribute deviceAttribute, long j3, IDeviceObserverImpl iDeviceObserverImpl);

    private static native long createMapView1Native(long j, IMapServiceImpl iMapServiceImpl, long j2, MapViewParam mapViewParam, long j3, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j4, IMapLifecycleObserverImpl iMapLifecycleObserverImpl);

    private static native long createMapView2Native(long j, IMapServiceImpl iMapServiceImpl, long j2, MapViewParam mapViewParam, long j3, IBLMapViewProxyImpl iBLMapViewProxyImpl, long j4, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j5, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, long j6, IAnimationObserverImpl iAnimationObserverImpl);

    private static native long createMapViewNative(long j, IMapServiceImpl iMapServiceImpl, long j2, MapViewParam mapViewParam);

    private static native boolean destroyDeviceNative(long j, IMapServiceImpl iMapServiceImpl, long j2, IMapDeviceImpl iMapDeviceImpl);

    private static native boolean destroyMapViewNative(long j, IMapServiceImpl iMapServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native ArrayList<Long> getDeviceIdsNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native long getDeviceNative(long j, IMapServiceImpl iMapServiceImpl, int i);

    private static native long getEngineIdWithGestureNative(long j, IMapServiceImpl iMapServiceImpl, long j2, GestureInfo gestureInfo);

    private static native String getMMMainRunTimeInfoNative(int[] iArr, int[] iArr2);

    private static native String getMapEngineVersionNative();

    private static native ArrayList<Long> getMapViewIdsNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native long getMapViewNative(long j, IMapServiceImpl iMapServiceImpl, int i);

    private static native long getMapViewProxyNative(long j, IMapServiceImpl iMapServiceImpl, int i);

    private static native String getNaviRebuildVersionNative();

    private static native boolean getThemeListNative(long j, IMapServiceImpl iMapServiceImpl, ArrayList<MapThemeInfo> arrayList);

    private static native int initMapNative(long j, IMapServiceImpl iMapServiceImpl, long j2, InitMapParam initMapParam, long j3, IMapFontObserverImpl iMapFontObserverImpl);

    private static native int isInitNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native void openFpsControlNative(long j, IMapServiceImpl iMapServiceImpl);

    private static native void queueEventNative(long j, IMapServiceImpl iMapServiceImpl, int i, long j2, MapRunnableImpl mapRunnableImpl);

    private static native void setMapFontObserverNative(long j, IMapServiceImpl iMapServiceImpl, long j2, IMapFontObserverImpl iMapFontObserverImpl);

    private static native void setNeedRecreateSurface1Native(long j, IMapServiceImpl iMapServiceImpl, boolean z);

    private static native void setNeedRecreateSurfaceNative(long j, IMapServiceImpl iMapServiceImpl, boolean z, int i);

    private static native void setNetworkTypeNative(long j, IMapServiceImpl iMapServiceImpl, int i);

    private static native int unitMapNative(long j, IMapServiceImpl iMapServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IMapServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapServiceImpl) && getUID(this) == getUID((IMapServiceImpl) obj);
    }

    private static long getUID(IMapServiceImpl iMapServiceImpl) {
        long cPtr = getCPtr(iMapServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapServiceImpl iMapServiceImpl) {
        if (iMapServiceImpl == null) {
            return 0L;
        }
        return iMapServiceImpl.swigCPtr;
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

    public static String getMMMainRunTimeInfo(int[] iArr, int[] iArr2) {
        return getMMMainRunTimeInfoNative(iArr, iArr2);
    }

    public int initMap(InitMapParam initMapParam, IMapFontObserverImpl iMapFontObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initMapNative(j, this, 0L, initMapParam, IMapFontObserverImpl.getCPtr(iMapFontObserverImpl), iMapFontObserverImpl);
    }

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

    public IMapDeviceImpl createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IDeviceObserverImpl iDeviceObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDeviceNative = createDeviceNative(j, this, i, 0L, deviceAttribute, IDeviceObserverImpl.getCPtr(iDeviceObserverImpl), iDeviceObserverImpl);
        if (createDeviceNative == 0) {
            return null;
        }
        return new IMapDeviceImpl(createDeviceNative, false);
    }

    public IMapDeviceImpl createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IMapLifecycleObserverImpl iMapLifecycleObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDevice1Native = createDevice1Native(j, this, i, 0L, deviceAttribute, IMapLifecycleObserverImpl.getCPtr(iMapLifecycleObserverImpl), iMapLifecycleObserverImpl);
        if (createDevice1Native == 0) {
            return null;
        }
        return new IMapDeviceImpl(createDevice1Native, false);
    }

    public IMapDeviceImpl getDevice(@EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long deviceNative = getDeviceNative(j, this, i);
        if (deviceNative == 0) {
            return null;
        }
        return new IMapDeviceImpl(deviceNative, false);
    }

    public boolean destroyDevice(IMapDeviceImpl iMapDeviceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyDeviceNative(j, this, IMapDeviceImpl.getCPtr(iMapDeviceImpl), iMapDeviceImpl);
    }

    public ArrayList<Long> getDeviceIds() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDeviceIdsNative(j, this);
    }

    public boolean changeMapEnv(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return changeMapEnvNative(j, this, bArr);
    }

    public IMapViewImpl createMapView(MapViewParam mapViewParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapViewNative = createMapViewNative(j, this, 0L, mapViewParam);
        if (createMapViewNative == 0) {
            return null;
        }
        return new IMapViewImpl(createMapViewNative, false);
    }

    public IMapViewImpl createMapView(MapViewParam mapViewParam, IBLMapViewProxyImpl iBLMapViewProxyImpl, IMapLifecycleObserverImpl iMapLifecycleObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapView1Native = createMapView1Native(j, this, 0L, mapViewParam, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl, IMapLifecycleObserverImpl.getCPtr(iMapLifecycleObserverImpl), iMapLifecycleObserverImpl);
        if (createMapView1Native == 0) {
            return null;
        }
        return new IMapViewImpl(createMapView1Native, false);
    }

    public IMapViewImpl createMapView(MapViewParam mapViewParam, IBLMapViewProxyImpl iBLMapViewProxyImpl, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, IAnimationObserverImpl iAnimationObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createMapView2Native = createMapView2Native(j, this, 0L, mapViewParam, IBLMapViewProxyImpl.getCPtr(iBLMapViewProxyImpl), iBLMapViewProxyImpl, IBLMapEngineObserverImpl.getCPtr(iBLMapEngineObserverImpl), iBLMapEngineObserverImpl, IBLMapBusinessDataObserverImpl.getCPtr(iBLMapBusinessDataObserverImpl), iBLMapBusinessDataObserverImpl, IAnimationObserverImpl.getCPtr(iAnimationObserverImpl), iAnimationObserverImpl);
        if (createMapView2Native == 0) {
            return null;
        }
        return new IMapViewImpl(createMapView2Native, false);
    }

    public void openFpsControl() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openFpsControlNative(j, this);
    }

    public IMapViewImpl getMapView(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long mapViewNative = getMapViewNative(j, this, i);
        if (mapViewNative == 0) {
            return null;
        }
        return new IMapViewImpl(mapViewNative, false);
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

    public ArrayList<Long> getMapViewIds() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMapViewIdsNative(j, this);
    }

    public long getEngineIdWithGesture(GestureInfo gestureInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEngineIdWithGestureNative(j, this, 0L, gestureInfo);
    }

    public boolean destroyMapView(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyMapViewNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
    }

    public void queueEvent(@EGLDeviceID.EGLDeviceID1 int i, MapRunnableImpl mapRunnableImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        queueEventNative(j, this, i, MapRunnableImpl.getCPtr(mapRunnableImpl), mapRunnableImpl);
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

    public ArrayList<MapThemeInfo> getThemeList() {
        ArrayList<MapThemeInfo> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getThemeList(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getThemeList(ArrayList<MapThemeInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getThemeListNative(j, this, arrayList);
    }
}
