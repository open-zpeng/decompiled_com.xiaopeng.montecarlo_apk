package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.adapter.DefaultMapFontObserver;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
import com.autonavi.gbl.map.impl.IMapServiceImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.model.MapThemeInfo;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.observer.IAnimationObserver;
import com.autonavi.gbl.map.observer.IBLMapBusinessDataObserver;
import com.autonavi.gbl.map.observer.IBLMapEngineObserver;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.IDeviceObserver;
import com.autonavi.gbl.map.observer.IMapLifecycleObserver;
import com.autonavi.gbl.map.observer.IMapRunnable;
import com.autonavi.gbl.map.observer.MapFontObserver;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
@IntfAuto(target = IMapServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapService implements IService {
    private IMapServiceImpl mControl;
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
        this((IMapServiceImpl) ReflexTool.invokeDeclConstructorSafe(IMapServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapService.class, this, this.mControl);
        }
    }

    public MapService(IMapServiceImpl iMapServiceImpl) {
        this.mMapViewSet = Collections.synchronizedSet(new HashSet());
        this.mMapDeviceSet = Collections.synchronizedSet(new HashSet());
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMapServiceImpl);
    }

    private void $constructor(IMapServiceImpl iMapServiceImpl) {
        if (iMapServiceImpl != null) {
            this.mControl = iMapServiceImpl;
            this.mTargetId = String.format("MapService_%s_%d", String.valueOf(IMapServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMapServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public static String getMapEngineVersion() {
        return IMapServiceImpl.getMapEngineVersion();
    }

    public static String getNaviRebuildVersion() {
        return IMapServiceImpl.getNaviRebuildVersion();
    }

    public static String getMMMainRunTimeInfo(int[] iArr, int[] iArr2) {
        if (iArr != null && iArr.length == 0) {
            iArr = null;
        }
        if (iArr2 != null && iArr2.length == 0) {
            iArr2 = null;
        }
        return IMapServiceImpl.getMMMainRunTimeInfo(iArr, iArr2);
    }

    public int initMap(InitMapParam initMapParam, MapFontObserver mapFontObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapService.class.getMethod("initMap", InitMapParam.class, MapFontObserver.class);
            IMapFontObserverImpl iMapFontObserverImpl = null;
            if (mapFontObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapFontObserverImpl = (IMapFontObserverImpl) typeHelper.transfer(method, 1, mapFontObserver);
            }
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                int initMap = iMapServiceImpl.initMap(initMapParam, iMapFontObserverImpl);
                openFpsControl();
                return initMap;
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int unitMap() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.unitMap();
        }
        return Integer.MIN_VALUE;
    }

    public void setMapFontObserver(MapFontObserver mapFontObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapService.class.getMethod("setMapFontObserver", MapFontObserver.class);
            IMapFontObserverImpl iMapFontObserverImpl = null;
            if (mapFontObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapFontObserverImpl = (IMapFontObserverImpl) typeHelper.transfer(method, 0, mapFontObserver);
            }
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                iMapServiceImpl.setMapFontObserver(iMapFontObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public MapDevice createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IDeviceObserver iDeviceObserver) {
        Set set;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = MapService.class.getMethod("createDevice", Integer.TYPE, DeviceAttribute.class, IDeviceObserver.class);
            IDeviceObserverImpl iDeviceObserverImpl = (iDeviceObserver == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IDeviceObserverImpl) typeHelper2.transfer(method, 2, iDeviceObserver);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                IMapDeviceImpl createDevice = iMapServiceImpl.createDevice(i, deviceAttribute, iDeviceObserverImpl);
                MapDevice mapDevice = (createDevice == null || (typeHelper = this.mTypeHelper) == null) ? null : (MapDevice) typeHelper.transfer(method, -1, (Object) createDevice, true);
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

    public MapDevice createDevice(@EGLDeviceID.EGLDeviceID1 int i, DeviceAttribute deviceAttribute, IMapLifecycleObserver iMapLifecycleObserver) {
        Set set;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = MapService.class.getMethod("createDevice", Integer.TYPE, DeviceAttribute.class, IMapLifecycleObserver.class);
            IMapLifecycleObserverImpl iMapLifecycleObserverImpl = (iMapLifecycleObserver == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapLifecycleObserverImpl) typeHelper2.transfer(method, 2, iMapLifecycleObserver);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                IMapDeviceImpl createDevice = iMapServiceImpl.createDevice(i, deviceAttribute, iMapLifecycleObserverImpl);
                MapDevice mapDevice = (createDevice == null || (typeHelper = this.mTypeHelper) == null) ? null : (MapDevice) typeHelper.transfer(method, -1, (Object) createDevice, true);
                TypeHelper typeHelper3 = mapDevice != null ? (TypeHelper) ReflexTool.getDeclFieldSafe(mapDevice, "mTypeHelper") : null;
                if (typeHelper3 != null) {
                    typeHelper3.transfer(method, 2, iMapLifecycleObserver);
                }
                TypeHelper typeHelper4 = this.mTypeHelper;
                if (typeHelper4 != null) {
                    typeHelper4.unbind(method, 2, iMapLifecycleObserver);
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
        IMapDeviceImpl device;
        TypeHelper typeHelper;
        try {
            Method method = MapService.class.getMethod("getDevice", Integer.TYPE);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl == null || (device = iMapServiceImpl.getDevice(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapDevice) typeHelper.transfer(method, -1, (Object) device, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean destroyDevice(MapDevice mapDevice) {
        TypeHelper typeHelper;
        boolean z = false;
        try {
            IMapDeviceImpl iMapDeviceImpl = (mapDevice == null || (typeHelper = this.mTypeHelper) == null) ? null : (IMapDeviceImpl) typeHelper.transfer(MapService.class.getMethod("destroyDevice", MapDevice.class), 0, mapDevice);
            if (this.mControl != null) {
                if (mapDevice != null) {
                    ReflexTool.invokeDeclMethodSafe(mapDevice, "onDestroy", null, null);
                }
                z = this.mControl.destroyDevice(iMapDeviceImpl);
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

    public ArrayList<Long> getDeviceIds() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.getDeviceIds();
        }
        return null;
    }

    public boolean changeMapEnv(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.changeMapEnv(bArr);
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

    public MapView createMapView(MapViewParam mapViewParam, IBLMapViewProxy iBLMapViewProxy, IMapLifecycleObserver iMapLifecycleObserver) {
        Set set;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        TypeHelper typeHelper3;
        try {
            Method method = MapService.class.getMethod("createMapView", MapViewParam.class, IBLMapViewProxy.class, IMapLifecycleObserver.class);
            IBLMapViewProxyImpl iBLMapViewProxyImpl = (iBLMapViewProxy == null || (typeHelper3 = this.mTypeHelper) == null) ? null : (IBLMapViewProxyImpl) typeHelper3.transfer(method, 1, iBLMapViewProxy);
            IMapLifecycleObserverImpl iMapLifecycleObserverImpl = (iMapLifecycleObserver == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapLifecycleObserverImpl) typeHelper2.transfer(method, 2, iMapLifecycleObserver);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                IMapViewImpl createMapView = iMapServiceImpl.createMapView(mapViewParam, iBLMapViewProxyImpl, iMapLifecycleObserverImpl);
                MapView mapView = (createMapView == null || (typeHelper = this.mTypeHelper) == null) ? null : (MapView) typeHelper.transfer(method, -1, (Object) createMapView, true);
                TypeHelper typeHelper4 = mapView != null ? (TypeHelper) ReflexTool.getDeclFieldSafe(mapView, "mTypeHelper") : null;
                if (typeHelper4 != null) {
                    typeHelper4.transfer(method, 1, iBLMapViewProxy);
                }
                TypeHelper typeHelper5 = this.mTypeHelper;
                if (typeHelper5 != null) {
                    typeHelper5.unbind(method, 1, iBLMapViewProxy);
                }
                if (typeHelper4 != null) {
                    typeHelper4.transfer(method, 2, iMapLifecycleObserver);
                }
                TypeHelper typeHelper6 = this.mTypeHelper;
                if (typeHelper6 != null) {
                    typeHelper6.unbind(method, 2, iMapLifecycleObserver);
                }
                if (mapView == null || (set = this.mMapViewSet) == null) {
                    return mapView;
                }
                synchronized (set) {
                    this.mMapViewSet.add(mapView);
                }
                return mapView;
            }
            return null;
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
        Set set;
        TypeHelper typeHelper;
        ?? r4 = new IBLMapEngineObserver(iBLMapEngineObserver) { // from class: com.autonavi.gbl.map.MapService.1MapEngineObserverInnerBridge
            private MapView mMapView;
            private IBLMapEngineObserver mObserver;

            {
                this.mObserver = iBLMapEngineObserver;
            }

            public void setMapView(MapView mapView) {
                this.mMapView = mapView;
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
                final MapView mapView = this.mMapView;
                if (mapView != null) {
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() { // from class: com.autonavi.gbl.map.MapService.1MapEngineObserverInnerBridge.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            MapView mapView2 = mapView;
                            if (mapView2 != null) {
                                mapView2.unbind();
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
                TypeHelper typeHelper2 = this.mTypeHelper;
                iBLMapViewProxyImpl = typeHelper2 != null ? (IBLMapViewProxyImpl) typeHelper2.transfer(method, 1, iBLMapViewProxy) : null;
            } else {
                iBLMapViewProxyImpl = null;
            }
            TypeHelper typeHelper3 = this.mTypeHelper;
            IBLMapEngineObserverImpl iBLMapEngineObserverImpl = typeHelper3 != 0 ? (IBLMapEngineObserverImpl) typeHelper3.transfer(method, 2, (Object) r4) : null;
            if (iBLMapBusinessDataObserver != null) {
                TypeHelper typeHelper4 = this.mTypeHelper;
                iBLMapBusinessDataObserverImpl = typeHelper4 != null ? (IBLMapBusinessDataObserverImpl) typeHelper4.transfer(method, 3, iBLMapBusinessDataObserver) : null;
            } else {
                iBLMapBusinessDataObserverImpl = null;
            }
            if (iAnimationObserver != null) {
                TypeHelper typeHelper5 = this.mTypeHelper;
                iAnimationObserverImpl = typeHelper5 != null ? (IAnimationObserverImpl) typeHelper5.transfer(method, 4, iAnimationObserver) : null;
            } else {
                iAnimationObserverImpl = null;
            }
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                IMapViewImpl createMapView = iMapServiceImpl.createMapView(mapViewParam, iBLMapViewProxyImpl, iBLMapEngineObserverImpl, iBLMapBusinessDataObserverImpl, iAnimationObserverImpl);
                MapView mapView = (createMapView == null || (typeHelper = this.mTypeHelper) == null) ? null : (MapView) typeHelper.transfer(method, -1, (Object) createMapView, true);
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
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.openFpsControl();
        }
    }

    public MapView getMapView(@MapEngineID.MapEngineID1 int i) {
        IMapViewImpl mapView;
        TypeHelper typeHelper;
        try {
            Method method = MapService.class.getMethod("getMapView", Integer.TYPE);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl == null || (mapView = iMapServiceImpl.getMapView(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapView) typeHelper.transfer(method, -1, (Object) mapView, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public IBLMapViewProxy getMapViewProxy(@MapEngineID.MapEngineID1 int i) {
        IBLMapViewProxyImpl mapViewProxy;
        TypeHelper typeHelper;
        try {
            Method method = MapService.class.getMethod("getMapViewProxy", Integer.TYPE);
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl == null || (mapViewProxy = iMapServiceImpl.getMapViewProxy(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IBLMapViewProxy) typeHelper.transfer(method, -1, (Object) mapViewProxy, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<Long> getMapViewIds() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.getMapViewIds();
        }
        return null;
    }

    public long getEngineIdWithGesture(GestureInfo gestureInfo) {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.getEngineIdWithGesture(gestureInfo);
        }
        return 0L;
    }

    public boolean destroyMapView(MapView mapView) {
        TypeHelper typeHelper;
        boolean z = false;
        try {
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper.transfer(MapService.class.getMethod("destroyMapView", MapView.class), 0, mapView);
            if (this.mControl != null) {
                if (mapView != null) {
                    ReflexTool.invokeDeclMethodSafe(mapView, "onDestroy", null, null);
                }
                z = this.mControl.destroyMapView(iMapViewImpl);
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
        IMapRunnable iMapRunnable2 = new IMapRunnable() { // from class: com.autonavi.gbl.map.MapService.1
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
            MapRunnableImpl mapRunnableImpl = typeHelper != null ? (MapRunnableImpl) typeHelper.transfer(method, 1, iMapRunnable2) : null;
            IMapServiceImpl iMapServiceImpl = this.mControl;
            if (iMapServiceImpl != null) {
                iMapServiceImpl.queueEvent(i, mapRunnableImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setNetworkType(@NetworkStatus.NetworkStatus1 int i) {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.setNetworkType(i);
        }
    }

    public void abortNetwork() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.abortNetwork();
        }
    }

    public void setNeedRecreateSurface(boolean z, @EGLDeviceID.EGLDeviceID1 int i) {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.setNeedRecreateSurface(z, i);
        }
    }

    public void setNeedRecreateSurface(boolean z) {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            iMapServiceImpl.setNeedRecreateSurface(z);
        }
    }

    public boolean clearCache() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.clearCache();
        }
        return false;
    }

    public ArrayList<MapThemeInfo> getThemeList() {
        IMapServiceImpl iMapServiceImpl = this.mControl;
        if (iMapServiceImpl != null) {
            return iMapServiceImpl.getThemeList();
        }
        return null;
    }

    protected void unbind() {
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
