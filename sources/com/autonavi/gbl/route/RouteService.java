package com.autonavi.gbl.route;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.route.impl.IRouteConsisAdditionServiceImpl;
import com.autonavi.gbl.route.impl.IRouteServiceImpl;
import com.autonavi.gbl.route.model.RouteControlKey;
import com.autonavi.gbl.route.model.RouteInitParam;
import com.autonavi.gbl.route.model.RouteRestorationOption;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import com.autonavi.gbl.route.observer.IChargingStationIDObserver;
import com.autonavi.gbl.route.observer.INaviRerouteObserver;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import com.autonavi.gbl.route.observer.IRouteServiceAreaObserver;
import com.autonavi.gbl.route.observer.IRouteWeatherObserver;
import com.autonavi.gbl.route.observer.impl.IChargingStationIDObserverImpl;
import com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl;
import com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl;
import com.autonavi.gbl.route.observer.impl.IRouteServiceAreaObserverImpl;
import com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
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

    public int init() {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public int init(RouteInitParam routeInitParam) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.init(routeInitParam);
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
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("requestRoute", RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            if (routeOption != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 0, routeOption);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.requestRoute(iRouteOptionImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

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
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("requestRouteRestoration", RouteRestorationOption.class);
            IRouteRestorationOptionImpl iRouteRestorationOptionImpl = null;
            if (routeRestorationOption != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteRestorationOptionImpl = (IRouteRestorationOptionImpl) typeHelper.transfer(method, 0, routeRestorationOption);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                return iRouteServiceImpl.requestRouteRestoration(iRouteRestorationOptionImpl);
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

    public long requestPathWeather(PathInfo pathInfo) {
        IRouteServiceImpl iRouteServiceImpl = this.mControl;
        if (iRouteServiceImpl != null) {
            return iRouteServiceImpl.requestPathWeather(pathInfo);
        }
        return 0L;
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
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("addRouteResultObserver", IRouteResultObserver.class);
            IRouteResultObserverImpl iRouteResultObserverImpl = null;
            if (iRouteResultObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteResultObserverImpl = (IRouteResultObserverImpl) typeHelper.transfer(method, 0, iRouteResultObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRouteResultObserver(iRouteResultObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteResultObserver(IRouteResultObserver iRouteResultObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("removeRouteResultObserver", IRouteResultObserver.class);
            IRouteResultObserverImpl iRouteResultObserverImpl = null;
            if (iRouteResultObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteResultObserverImpl = (IRouteResultObserverImpl) typeHelper.transfer(method, 0, iRouteResultObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRouteResultObserver(iRouteResultObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("addRouteWeatherObserver", IRouteWeatherObserver.class);
            IRouteWeatherObserverImpl iRouteWeatherObserverImpl = null;
            if (iRouteWeatherObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteWeatherObserverImpl = (IRouteWeatherObserverImpl) typeHelper.transfer(method, 0, iRouteWeatherObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRouteWeatherObserver(iRouteWeatherObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteWeatherObserver(IRouteWeatherObserver iRouteWeatherObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("removeRouteWeatherObserver", IRouteWeatherObserver.class);
            IRouteWeatherObserverImpl iRouteWeatherObserverImpl = null;
            if (iRouteWeatherObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteWeatherObserverImpl = (IRouteWeatherObserverImpl) typeHelper.transfer(method, 0, iRouteWeatherObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRouteWeatherObserver(iRouteWeatherObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRouteWeatherObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addRerouteObserver(INaviRerouteObserver iNaviRerouteObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("addRerouteObserver", INaviRerouteObserver.class);
            INaviRerouteObserverImpl iNaviRerouteObserverImpl = null;
            if (iNaviRerouteObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNaviRerouteObserverImpl = (INaviRerouteObserverImpl) typeHelper.transfer(method, 0, iNaviRerouteObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRerouteObserver(iNaviRerouteObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRerouteObserver(INaviRerouteObserver iNaviRerouteObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("removeRerouteObserver", INaviRerouteObserver.class);
            INaviRerouteObserverImpl iNaviRerouteObserverImpl = null;
            if (iNaviRerouteObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNaviRerouteObserverImpl = (INaviRerouteObserverImpl) typeHelper.transfer(method, 0, iNaviRerouteObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRerouteObserver(iNaviRerouteObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iNaviRerouteObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addChargingStationIDObserver(IChargingStationIDObserver iChargingStationIDObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("addChargingStationIDObserver", IChargingStationIDObserver.class);
            IChargingStationIDObserverImpl iChargingStationIDObserverImpl = null;
            if (iChargingStationIDObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChargingStationIDObserverImpl = (IChargingStationIDObserverImpl) typeHelper.transfer(method, 0, iChargingStationIDObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addChargingStationIDObserver(iChargingStationIDObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeChargingStationIDObserver(IChargingStationIDObserver iChargingStationIDObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("removeChargingStationIDObserver", IChargingStationIDObserver.class);
            IChargingStationIDObserverImpl iChargingStationIDObserverImpl = null;
            if (iChargingStationIDObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iChargingStationIDObserverImpl = (IChargingStationIDObserverImpl) typeHelper.transfer(method, 0, iChargingStationIDObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeChargingStationIDObserver(iChargingStationIDObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iChargingStationIDObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addRouteServiceAreaObserver(IRouteServiceAreaObserver iRouteServiceAreaObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("addRouteServiceAreaObserver", IRouteServiceAreaObserver.class);
            IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl = null;
            if (iRouteServiceAreaObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteServiceAreaObserverImpl = (IRouteServiceAreaObserverImpl) typeHelper.transfer(method, 0, iRouteServiceAreaObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.addRouteServiceAreaObserver(iRouteServiceAreaObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteServiceAreaObserver(IRouteServiceAreaObserver iRouteServiceAreaObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("removeRouteServiceAreaObserver", IRouteServiceAreaObserver.class);
            IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl = null;
            if (iRouteServiceAreaObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteServiceAreaObserverImpl = (IRouteServiceAreaObserverImpl) typeHelper.transfer(method, 0, iRouteServiceAreaObserver);
            }
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl != null) {
                iRouteServiceImpl.removeRouteServiceAreaObserver(iRouteServiceAreaObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRouteServiceAreaObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public RouteConsisAdditionService getRouteConsisAdditionService() {
        IRouteConsisAdditionServiceImpl routeConsisAdditionService;
        TypeHelper typeHelper;
        try {
            Method method = RouteService.class.getMethod("getRouteConsisAdditionService", new Class[0]);
            IRouteServiceImpl iRouteServiceImpl = this.mControl;
            if (iRouteServiceImpl == null || (routeConsisAdditionService = iRouteServiceImpl.getRouteConsisAdditionService()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (RouteConsisAdditionService) typeHelper.transfer(method, -1, (Object) routeConsisAdditionService, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
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
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.route.observer.INaviRerouteObserver")).iterator();
            while (it3.hasNext()) {
                removeRerouteObserver((INaviRerouteObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.route.observer.IChargingStationIDObserver")).iterator();
            while (it4.hasNext()) {
                removeChargingStationIDObserver((IChargingStationIDObserver) it4.next());
            }
        }
        TypeHelper typeHelper5 = this.mTypeHelper;
        if (typeHelper5 != null) {
            Iterator it5 = ((HashSet) typeHelper5.getBindSet("com.autonavi.gbl.route.observer.IRouteServiceAreaObserver")).iterator();
            while (it5.hasNext()) {
                removeRouteServiceAreaObserver((IRouteServiceAreaObserver) it5.next());
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
