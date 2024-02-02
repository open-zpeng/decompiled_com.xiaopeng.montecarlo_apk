package com.autonavi.gbl.route;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.impl.IRouteServiceImpl;
import com.autonavi.gbl.route.model.RouteAosOption;
import com.autonavi.gbl.route.model.RouteControlKey;
import com.autonavi.gbl.route.model.RouteRestorationOption;
import com.autonavi.gbl.route.model.impl.IRouteAosOptionImpl;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import com.autonavi.gbl.route.observer.IRouteWeatherObserver;
import com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl;
import com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IRouteServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class RouteService implements IService {
    private static String PACKAGE = ReflexTool.PN(RouteService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IRouteServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteService(long j, boolean z) {
        this((IRouteServiceImpl) ReflexTool.invokeDeclConstructorSafe(IRouteServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RouteService.class, this, this.mControl);
        }
    }

    public RouteService(IRouteServiceImpl iRouteServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRouteServiceImpl);
    }

    private void $constructor(IRouteServiceImpl iRouteServiceImpl) {
        if (iRouteServiceImpl != null) {
            this.mControl = iRouteServiceImpl;
            this.mTargetId = String.format("RouteService_%s_%d", String.valueOf(IRouteServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRouteServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.onCreate();
        }
    }

    @ErrorCode.ErrorCode1
    public int init() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.logSwitch(i);
        }
    }

    public void setElecInfoConfig(ElecInfoConfig elecInfoConfig) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.setElecInfoConfig(elecInfoConfig);
        }
    }

    public static String getEngineVersion() {
        return IRouteServiceImpl.getEngineVersion();
    }

    public static String getRouteVersion() {
        return IRouteServiceImpl.getRouteVersion();
    }

    public boolean control(@RouteControlKey.RouteControlKey1 int i, String str) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.control(i, str);
        }
        return false;
    }

    public long requestRoute(RouteOption routeOption) {
        try {
            Method method = RouteService.class.getMethod("requestRoute", RouteOption.class);
            if (routeOption != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (IRouteOptionImpl) typeHelper.transfer(method, 0, routeOption) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $routeOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.1
                    }));
                    return 0L;
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.requestRoute(r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    @RouteErrorcode.RouteErrorcode1
    public int retryRequestRoute(long j) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.retryRequestRoute(j);
        }
        return Integer.MIN_VALUE;
    }

    public boolean abortRequest(long j) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.abortRequest(j);
        }
        return false;
    }

    public int requestRouteRestoration(RouteRestorationOption routeRestorationOption) {
        try {
            Method method = RouteService.class.getMethod("requestRouteRestoration", RouteRestorationOption.class);
            if (routeRestorationOption != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IRouteRestorationOptionImpl) typeHelper.transfer(method, 0, routeRestorationOption) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $routeOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.2
                    }));
                    return 0;
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.requestRouteRestoration(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void abortRouteRestorationRequest(int i) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.abortRouteRestorationRequest(i);
        }
    }

    public void abortAosRouteRequest(int i) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.abortAosRouteRequest(i);
        }
    }

    public void abortAllAosRouteRequest() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.abortAllAosRouteRequest();
        }
    }

    public long requestPathWeather(PathInfo pathInfo) {
        try {
            Method method = RouteService.class.getMethod("requestPathWeather", PathInfo.class);
            if (pathInfo != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r3 = typeHelper != null ? (PathInfoImpl) typeHelper.transfer(method, 0, pathInfo) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.3
                    }));
                    return 0L;
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.requestPathWeather(r3);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public void abortPathWeatherRequest(long j) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.abortPathWeatherRequest(j);
        }
    }

    public void abortAllPathWeatherRequest() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            iRouteServiceImpl.abortAllPathWeatherRequest();
        }
    }

    public void addRouteResultObserver(IRouteResultObserver iRouteResultObserver) {
        try {
            Method method = RouteService.class.getMethod("addRouteResultObserver", IRouteResultObserver.class);
            if (iRouteResultObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteResultObserverImpl) typeHelper.transfer(method, 0, iRouteResultObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.4
                    }));
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRouteResultObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteResultObserver(IRouteResultObserver iRouteResultObserver) {
        try {
            Method method = RouteService.class.getMethod("removeRouteResultObserver", IRouteResultObserver.class);
            if (iRouteResultObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteResultObserverImpl) typeHelper.transfer(method, 0, iRouteResultObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.5
                    }));
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRouteResultObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRouteResultObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addRouteWeatherObserver(IRouteWeatherObserver iRouteWeatherObserver) {
        try {
            Method method = RouteService.class.getMethod("addRouteWeatherObserver", IRouteWeatherObserver.class);
            if (iRouteWeatherObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteWeatherObserverImpl) typeHelper.transfer(method, 0, iRouteWeatherObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.6
                    }));
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRouteWeatherObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteWeatherObserver(IRouteWeatherObserver iRouteWeatherObserver) {
        try {
            Method method = RouteService.class.getMethod("removeRouteWeatherObserver", IRouteWeatherObserver.class);
            if (iRouteWeatherObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteWeatherObserverImpl) typeHelper.transfer(method, 0, iRouteWeatherObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.7
                    }));
                }
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRouteWeatherObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRouteWeatherObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public String getAosRequestRouteURL(RouteAosOption routeAosOption) {
        IRouteAosOptionImpl iRouteAosOptionImpl;
        try {
            Method method = RouteService.class.getMethod("getAosRequestRouteURL", RouteAosOption.class);
            if (routeAosOption != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iRouteAosOptionImpl = typeHelper != null ? (IRouteAosOptionImpl) typeHelper.transfer(method, 0, routeAosOption) : null;
                if (iRouteAosOptionImpl == null) {
                    DebugTool.e("%s: $routeAosOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.8
                    }));
                    return null;
                }
            } else {
                iRouteAosOptionImpl = null;
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.getAosRequestRouteURL(iRouteAosOptionImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.9
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.10
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.route.observer.IRouteResultObserver")).iterator();
            while (it.hasNext()) {
                removeRouteResultObserver((IRouteResultObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.route.observer.IRouteWeatherObserver")).iterator();
            while (it2.hasNext()) {
                removeRouteWeatherObserver((IRouteWeatherObserver) it2.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteService.11
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
