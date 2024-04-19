package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.adapter.DefaultMapFontObserver;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapServiceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.observer.IAnimationObserver;
import com.autonavi.gbl.map.observer.IBLMapBusinessDataObserver;
import com.autonavi.gbl.map.observer.IBLMapEngineObserver;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.IDeviceObserver;
import com.autonavi.gbl.map.observer.IMapLifecycleObserverInterface;
import com.autonavi.gbl.map.observer.IMapRunnable;
import com.autonavi.gbl.map.observer.MapFontObserver;
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
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
@IntfAuto(target = MapServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapService implements IService {
    private MapServiceImpl mControl;
    private boolean mHasDestroy;
    private Set mMapDeviceSet;
    private Set mMapViewSet;
    private String mTargetId;
    private TypeHelper mTypeHelper;
    private static DefaultMapFontObserver s_pFontObserver = new DefaultMapFontObserver();
    private static String PACKAGE = ReflexTool.PN(MapService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);

    public int initMap(InitMapParam initMapParam) {
        return initMap(initMapParam, s_pFontObserver);
    }

    protected MapService(long j, boolean z) {
        this((MapServiceImpl) ReflexTool.invokeDeclConstructorSafe(MapServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapService.class, this, this.mControl);
        }
    }

    public MapService(MapServiceImpl mapServiceImpl) {
        this.mMapViewSet = Collections.synchronizedSet(new HashSet());
        this.mMapDeviceSet = Collections.synchronizedSet(new HashSet());
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(mapServiceImpl);
    }

    private void $constructor(MapServiceImpl mapServiceImpl) {
        if (mapServiceImpl != null) {
            this.mControl = mapServiceImpl;
            this.mTargetId = String.format("MapService_%s_%d", String.valueOf(MapServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected MapServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public static String getMapEngineVersion() {
        return MapServiceImpl.getMapEngineVersion();
    }

    public static String getNaviRebuildVersion() {
        return MapServiceImpl.getNaviRebuildVersion();
    }

    @EGErr.EGErr1
    public int initMap(InitMapParam initMapParam, MapFontObserver mapFontObserver) {
        try {
            Method method = MapService.class.getMethod("initMap", InitMapParam.class, MapFontObserver.class);
            if (mapFontObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IMapFontObserverImpl) typeHelper.transfer(method, 1, mapFontObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pFontObsever == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.1
                    }));
                    return Integer.MIN_VALUE;
                }
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                int initMap = mapServiceImpl.initMap(initMapParam, r2);
                openFpsControl();
                return initMap;
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    @EGErr.EGErr1
    public int unitMap() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.unitMap();
        }
        return Integer.MIN_VALUE;
    }

    public void setMapFontObserver(MapFontObserver mapFontObserver) {
        try {
            Method method = MapService.class.getMethod("setMapFontObserver", MapFontObserver.class);
            if (mapFontObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapFontObserverImpl) typeHelper.transfer(method, 0, mapFontObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapFontObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.2
                    }));
                }
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                mapServiceImpl.setMapFontObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public MapDevice createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IDeviceObserver iDeviceObserver) {
        IDeviceObserverImpl iDeviceObserverImpl;
        MapDevice mapDevice;
        Set set;
        try {
            Method method = MapService.class.getMethod("createDevice", Integer.TYPE, DeviceAttribute.class, IDeviceObserver.class);
            if (iDeviceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iDeviceObserverImpl = typeHelper != null ? (IDeviceObserverImpl) typeHelper.transfer(method, 2, iDeviceObserver) : null;
                if (iDeviceObserverImpl == null) {
                    DebugTool.e("%s: $pIDeviceObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.3
                    }));
                    return null;
                }
            } else {
                iDeviceObserverImpl = null;
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                MapDeviceImpl createDevice = mapServiceImpl.createDevice(i, deviceAttribute, iDeviceObserverImpl);
                if (createDevice != null) {
                    TypeHelper typeHelper2 = this.mTypeHelper;
                    mapDevice = typeHelper2 != null ? (MapDevice) typeHelper2.transfer(method, -1, (Object) createDevice, true) : null;
                    if (mapDevice == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.4
                        }));
                    }
                } else {
                    mapDevice = null;
                }
                TypeHelper typeHelper3 = mapDevice != null ? (TypeHelper) ReflexTool.getDeclFieldSafe(mapDevice, "mTypeHelper") : null;
                if (typeHelper3 != null) {
                    typeHelper3.transfer(method, 2, iDeviceObserver);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 2, iDeviceObserver);
                }
                if (mapDevice == null || (set = this.mMapDeviceSet) == null) {
                    return mapDevice;
                }
                synchronized (set) {
                    this.mMapDeviceSet.add(mapDevice);
                }
                return mapDevice;
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public MapDevice createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IMapLifecycleObserverInterface iMapLifecycleObserverInterface) {
        IMapLifecycleObserver iMapLifecycleObserver;
        MapDevice mapDevice;
        Set set;
        try {
            Method method = MapService.class.getMethod("createDevice", Integer.TYPE, DeviceAttribute.class, IMapLifecycleObserverInterface.class);
            if (iMapLifecycleObserverInterface != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iMapLifecycleObserver = typeHelper != null ? (IMapLifecycleObserver) typeHelper.transfer(method, 2, iMapLifecycleObserverInterface) : null;
                if (iMapLifecycleObserver == null) {
                    DebugTool.e("%s: $pIDeviceObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.5
                    }));
                    return null;
                }
            } else {
                iMapLifecycleObserver = null;
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                MapDeviceImpl createDevice = mapServiceImpl.createDevice(i, deviceAttribute, iMapLifecycleObserver);
                if (createDevice != null) {
                    TypeHelper typeHelper2 = this.mTypeHelper;
                    mapDevice = typeHelper2 != null ? (MapDevice) typeHelper2.transfer(method, -1, (Object) createDevice, true) : null;
                    if (mapDevice == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.6
                        }));
                    }
                } else {
                    mapDevice = null;
                }
                TypeHelper typeHelper3 = mapDevice != null ? (TypeHelper) ReflexTool.getDeclFieldSafe(mapDevice, "mTypeHelper") : null;
                if (typeHelper3 != null) {
                    typeHelper3.transfer(method, 2, iMapLifecycleObserverInterface);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 2, iMapLifecycleObserverInterface);
                }
                if (mapDevice == null || (set = this.mMapDeviceSet) == null) {
                    return mapDevice;
                }
                synchronized (set) {
                    this.mMapDeviceSet.add(mapDevice);
                }
                return mapDevice;
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public MapDevice getDevice(@EGLDeviceID.EGLDeviceID1 int i) {
        MapDeviceImpl device;
        try {
            Method method = MapService.class.getMethod("getDevice", Integer.TYPE);
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null && (device = mapServiceImpl.getDevice(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapDevice) typeHelper.transfer(method, -1, (Object) device, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.7
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean destroyDevice(MapDevice mapDevice) {
        MapDeviceImpl mapDeviceImpl;
        boolean z = false;
        try {
            Method method = MapService.class.getMethod("destroyDevice", MapDevice.class);
            if (mapDevice != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapDeviceImpl = typeHelper != null ? (MapDeviceImpl) typeHelper.transfer(method, 0, mapDevice) : null;
                if (mapDeviceImpl == null) {
                    DebugTool.e("%s: $pIMapDevice == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.8
                    }));
                    return false;
                }
            } else {
                mapDeviceImpl = null;
            }
            if (this.mControl != null) {
                if (mapDevice != null) {
                    ReflexTool.invokeDeclMethodSafe(mapDevice, "onDestroy", null, null);
                }
                z = this.mControl.destroyDevice(mapDeviceImpl);
                if (mapDevice != null) {
                    Set set = this.mMapDeviceSet;
                    if (set != null) {
                        synchronized (set) {
                            this.mMapDeviceSet.remove(mapDevice);
                        }
                    }
                    ReflexTool.invokeDeclMethodSafe(mapDevice, RequestParameters.SUBRESOURCE_DELETE, null, null);
                }
            }
            return z;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public long[] getDeviceIds() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.getDeviceIds();
        }
        return null;
    }

    public boolean changeMapEnv(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.changeMapEnv(bArr);
        }
        return false;
    }

    public MapView createMapView(MapViewParam mapViewParam) {
        MapView createMapView = createMapView(mapViewParam, null, null, null, null);
        if (createMapView != null) {
            this.mMapViewSet.add(createMapView);
        }
        return createMapView;
    }

    public MapView createMapView(MapViewParam mapViewParam, IBLMapViewProxy iBLMapViewProxy, IMapLifecycleObserverInterface iMapLifecycleObserverInterface) {
        IBLMapViewProxyImpl iBLMapViewProxyImpl;
        IMapLifecycleObserver iMapLifecycleObserver;
        Set set;
        try {
            Method method = MapService.class.getMethod("createMapView", MapViewParam.class, IBLMapViewProxy.class, IMapLifecycleObserverInterface.class);
            if (iBLMapViewProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iBLMapViewProxyImpl = typeHelper != null ? (IBLMapViewProxyImpl) typeHelper.transfer(method, 1, iBLMapViewProxy) : null;
                if (iBLMapViewProxyImpl == null) {
                    DebugTool.e("%s: $mapViewProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.9
                    }));
                    return null;
                }
            } else {
                iBLMapViewProxyImpl = null;
            }
            if (iMapLifecycleObserverInterface != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                iMapLifecycleObserver = typeHelper2 != null ? (IMapLifecycleObserver) typeHelper2.transfer(method, 2, iMapLifecycleObserverInterface) : null;
                if (iMapLifecycleObserver == null) {
                    DebugTool.e("%s: $pIDeviceObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.10
                    }));
                    return null;
                }
            } else {
                iMapLifecycleObserver = null;
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                MapViewImpl createMapView = mapServiceImpl.createMapView(mapViewParam, iBLMapViewProxyImpl, iMapLifecycleObserver);
                if (createMapView != null) {
                    TypeHelper typeHelper3 = this.mTypeHelper;
                    r0 = typeHelper3 != null ? (MapView) typeHelper3.transfer(method, -1, (Object) createMapView, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.11
                        }));
                    }
                }
                if (r0 != null && (set = this.mMapViewSet) != null) {
                    synchronized (set) {
                        this.mMapViewSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.autonavi.gbl.map.MapService$1MapEngineObserverInnerBridge, java.lang.Object] */
    public MapView createMapView(MapViewParam mapViewParam, IBLMapViewProxy iBLMapViewProxy, IBLMapEngineObserver iBLMapEngineObserver, IBLMapBusinessDataObserver iBLMapBusinessDataObserver, IAnimationObserver iAnimationObserver) {
        IBLMapViewProxyImpl iBLMapViewProxyImpl;
        IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl;
        IAnimationObserverImpl iAnimationObserverImpl;
        MapView mapView;
        Set set;
        ?? r4 = new IBLMapEngineObserver(iBLMapEngineObserver) { // from class: com.autonavi.gbl.map.MapService.1MapEngineObserverInnerBridge
            private MapView mMapView;
            private IBLMapEngineObserver mObserver;

            {
                this.mObserver = iBLMapEngineObserver;
            }

            public void setMapView(MapView mapView2) {
                this.mMapView = mapView2;
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapRender(long j, int i) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapRender(j, i);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapOrthoRender(long j) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapOrthoRender(j);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapTransferParam(long j, int[] iArr) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapTransferParam(j, iArr);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapOfflineError(long j, String str, int i) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapOfflineError(j, str, i);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapAnimationFinished(long j) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapAnimationFinished(j);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapFunctionActivity(long j, MapFuncActiveParam mapFuncActiveParam) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapFunctionActivity(j, mapFuncActiveParam);
                }
            }

            @Override // com.autonavi.gbl.map.observer.IBLMapEngineObserver
            public void onMapViewDestroyed(long j) {
                IBLMapEngineObserver iBLMapEngineObserver2 = this.mObserver;
                if (iBLMapEngineObserver2 != null) {
                    iBLMapEngineObserver2.onMapViewDestroyed(j);
                }
                final MapView mapView2 = this.mMapView;
                if (mapView2 != null) {
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() { // from class: com.autonavi.gbl.map.MapService.1MapEngineObserverInnerBridge.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            MapView mapView3 = mapView2;
                            if (mapView3 != null) {
                                mapView3.unbind();
                            }
                            timer.cancel();
                        }
                    }, 1500L);
                    this.mMapView = null;
                }
            }
        };
        try {
            Method method = MapService.class.getMethod("createMapView", MapViewParam.class, IBLMapViewProxy.class, IBLMapEngineObserver.class, IBLMapBusinessDataObserver.class, IAnimationObserver.class);
            if (iBLMapViewProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                IBLMapViewProxyImpl iBLMapViewProxyImpl2 = typeHelper != null ? (IBLMapViewProxyImpl) typeHelper.transfer(method, 1, iBLMapViewProxy) : null;
                if (iBLMapViewProxyImpl2 == null) {
                    DebugTool.e("%s: $mapViewProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.12
                    }));
                    return null;
                }
                iBLMapViewProxyImpl = iBLMapViewProxyImpl2;
            } else {
                iBLMapViewProxyImpl = null;
            }
            TypeHelper typeHelper2 = this.mTypeHelper;
            IBLMapEngineObserverImpl iBLMapEngineObserverImpl = typeHelper2 != 0 ? (IBLMapEngineObserverImpl) typeHelper2.transfer(method, 2, (Object) r4) : null;
            if (iBLMapEngineObserverImpl == null) {
                DebugTool.e("%s: $mapEngineObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.13
                }));
                return null;
            }
            if (iBLMapBusinessDataObserver != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl2 = typeHelper3 != null ? (IBLMapBusinessDataObserverImpl) typeHelper3.transfer(method, 3, iBLMapBusinessDataObserver) : null;
                if (iBLMapBusinessDataObserverImpl2 == null) {
                    DebugTool.e("%s: $mapBusinessDataObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.14
                    }));
                    return null;
                }
                iBLMapBusinessDataObserverImpl = iBLMapBusinessDataObserverImpl2;
            } else {
                iBLMapBusinessDataObserverImpl = null;
            }
            if (iAnimationObserver != null) {
                TypeHelper typeHelper4 = this.mTypeHelper;
                IAnimationObserverImpl iAnimationObserverImpl2 = typeHelper4 != null ? (IAnimationObserverImpl) typeHelper4.transfer(method, 4, iAnimationObserver) : null;
                if (iAnimationObserverImpl2 == null) {
                    DebugTool.e("%s: $animationObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.15
                    }));
                    return null;
                }
                iAnimationObserverImpl = iAnimationObserverImpl2;
            } else {
                iAnimationObserverImpl = null;
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                MapViewImpl createMapView = mapServiceImpl.createMapView(mapViewParam, iBLMapViewProxyImpl, iBLMapEngineObserverImpl, iBLMapBusinessDataObserverImpl, iAnimationObserverImpl);
                if (createMapView != null) {
                    TypeHelper typeHelper5 = this.mTypeHelper;
                    mapView = typeHelper5 != null ? (MapView) typeHelper5.transfer(method, -1, (Object) createMapView, true) : null;
                    if (mapView == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.16
                        }));
                    }
                } else {
                    mapView = null;
                }
                TypeHelper typeHelper6 = mapView != null ? (TypeHelper) ReflexTool.getDeclFieldSafe(mapView, "mTypeHelper") : 0;
                if (typeHelper6 != 0) {
                    typeHelper6.transfer(method, 1, iBLMapViewProxy);
                }
                TypeHelper typeHelper7 = this.mTypeHelper;
                if (typeHelper7 != null) {
                    typeHelper7.unbind(method, 1, iBLMapViewProxy);
                }
                if (typeHelper6 != 0) {
                    typeHelper6.transfer(method, 2, (Object) r4);
                }
                TypeHelper typeHelper8 = this.mTypeHelper;
                if (typeHelper8 != 0) {
                    typeHelper8.unbind(method, 2, (Object) r4);
                }
                if (typeHelper6 != 0) {
                    typeHelper6.transfer(method, 3, iBLMapBusinessDataObserver);
                }
                TypeHelper typeHelper9 = this.mTypeHelper;
                if (typeHelper9 != null) {
                    typeHelper9.unbind(method, 3, iBLMapBusinessDataObserver);
                }
                if (typeHelper6 != 0) {
                    typeHelper6.transfer(method, 4, iAnimationObserver);
                }
                TypeHelper typeHelper10 = this.mTypeHelper;
                if (typeHelper10 != null) {
                    typeHelper10.unbind(method, 4, iAnimationObserver);
                }
                if (mapView != null && (set = this.mMapViewSet) != null) {
                    synchronized (set) {
                        this.mMapViewSet.add(mapView);
                    }
                }
                r4.setMapView(mapView);
                return mapView;
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void openFpsControl() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.openFpsControl();
        }
    }

    public MapView getMapView(@MapEngineID.MapEngineID1 int i) {
        MapViewImpl mapView;
        try {
            Method method = MapService.class.getMethod("getMapView", Integer.TYPE);
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null && (mapView = mapServiceImpl.getMapView(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapView) typeHelper.transfer(method, -1, (Object) mapView, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.17
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public IBLMapViewProxy getMapViewProxy(@MapEngineID.MapEngineID1 int i) {
        IBLMapViewProxyImpl mapViewProxy;
        try {
            Method method = MapService.class.getMethod("getMapViewProxy", Integer.TYPE);
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null && (mapViewProxy = mapServiceImpl.getMapViewProxy(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (IBLMapViewProxy) typeHelper.transfer(method, -1, (Object) mapViewProxy, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.18
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public long[] getServiceViewIds() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.getServiceViewIds();
        }
        return null;
    }

    public long[] getMapViewIds() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.getMapViewIds();
        }
        return null;
    }

    public long getEngineIdWithGesture(GestureInfo gestureInfo) {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.getEngineIdWithGesture(gestureInfo);
        }
        return 0L;
    }

    public boolean destroyMapView(MapView mapView) {
        MapViewImpl mapViewImpl;
        boolean z = false;
        try {
            Method method = MapService.class.getMethod("destroyMapView", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pIMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.19
                    }));
                    return false;
                }
            } else {
                mapViewImpl = null;
            }
            if (this.mControl != null) {
                if (mapView != null) {
                    ReflexTool.invokeDeclMethodSafe(mapView, "onDestroy", null, null);
                }
                z = this.mControl.destroyMapView(mapViewImpl);
                if (mapView != null) {
                    Set set = this.mMapViewSet;
                    if (set != null) {
                        synchronized (set) {
                            this.mMapViewSet.remove(mapView);
                        }
                    }
                    ReflexTool.invokeDeclMethodSafe(mapView, RequestParameters.SUBRESOURCE_DELETE, null, null);
                }
            }
            return z;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void queueEvent(@EGLDeviceID.EGLDeviceID1 int i, final IMapRunnable iMapRunnable) {
        IMapRunnable iMapRunnable2 = new IMapRunnable() { // from class: com.autonavi.gbl.map.MapService.20
            @Override // com.autonavi.gbl.map.observer.IMapRunnable
            public void run() {
                IMapRunnable iMapRunnable3 = iMapRunnable;
                if (iMapRunnable3 != null) {
                    iMapRunnable3.run();
                }
            }
        };
        try {
            Method method = MapService.class.getMethod("queueEvent", Integer.TYPE, IMapRunnable.class);
            TypeHelper typeHelper = this.mTypeHelper;
            IMapRunnableImpl iMapRunnableImpl = typeHelper != null ? (IMapRunnableImpl) typeHelper.transfer(method, 1, iMapRunnable2) : null;
            if (iMapRunnableImpl == null) {
                DebugTool.e("%s: $runnable == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.21
                }));
            }
            MapServiceImpl mapServiceImpl = this.mControl;
            if (mapServiceImpl != null) {
                mapServiceImpl.queueEvent(i, iMapRunnableImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setNetworkType(@NetworkStatus.NetworkStatus1 int i) {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.setNetworkType(i);
        }
    }

    public void abortNetwork() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.abortNetwork();
        }
    }

    public void setNeedRecreateSurface(boolean z, @EGLDeviceID.EGLDeviceID1 int i) {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.setNeedRecreateSurface(z, i);
        }
    }

    public void setNeedRecreateSurface(boolean z) {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            mapServiceImpl.setNeedRecreateSurface(z);
        }
    }

    public boolean clearCache() {
        MapServiceImpl mapServiceImpl = this.mControl;
        if (mapServiceImpl != null) {
            return mapServiceImpl.clearCache();
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.22
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        HashSet<MapDevice> hashSet;
        HashSet<MapView> hashSet2;
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.23
        }));
        Set set = this.mMapViewSet;
        if (set != null) {
            synchronized (set) {
                hashSet2 = new HashSet(this.mMapViewSet);
            }
            for (MapView mapView : hashSet2) {
                destroyMapView(mapView);
            }
        }
        Set set2 = this.mMapDeviceSet;
        if (set2 != null) {
            synchronized (set2) {
                hashSet = new HashSet(this.mMapDeviceSet);
            }
            for (MapDevice mapDevice : hashSet) {
                destroyDevice(mapDevice);
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapService.24
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
