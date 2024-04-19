package com.autonavi.gbl.route.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.RouteService;
import com.autonavi.gbl.route.model.RouteControlKey;
import com.autonavi.gbl.route.model.impl.IRouteAosOptionImpl;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl;
import com.autonavi.gbl.route.observer.impl.IRouteWeatherObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = RouteService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IRouteServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortAllAosRouteRequestNative(long j, IRouteServiceImpl iRouteServiceImpl);

    private static native void abortAllPathWeatherRequestNative(long j, IRouteServiceImpl iRouteServiceImpl);

    private static native void abortAosRouteRequestNative(long j, IRouteServiceImpl iRouteServiceImpl, int i);

    private static native void abortPathWeatherRequestNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2);

    private static native boolean abortRequestNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2);

    private static native void abortRouteRestorationRequestNative(long j, IRouteServiceImpl iRouteServiceImpl, int i);

    private static native void addRouteResultObserverNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteResultObserverImpl iRouteResultObserverImpl);

    private static native void addRouteWeatherObserverNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteWeatherObserverImpl iRouteWeatherObserverImpl);

    private static native boolean controlNative(long j, IRouteServiceImpl iRouteServiceImpl, int i, String str);

    private static native void destroyNativeObj(long j);

    private static native String getAosRequestRouteURLNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteAosOptionImpl iRouteAosOptionImpl);

    private static native String getEngineVersionNative();

    private static native void getRouteConsisAdditionServiceNative(long j, IRouteServiceImpl iRouteServiceImpl, ArrayList<IRouteConsisAdditionServiceImpl> arrayList);

    private static native String getRouteVersionNative();

    private static native String getVersionNative(long j, IRouteServiceImpl iRouteServiceImpl);

    private static native int initNative(long j, IRouteServiceImpl iRouteServiceImpl);

    private static native int isInitNative(long j, IRouteServiceImpl iRouteServiceImpl);

    private static native void logSwitchNative(long j, IRouteServiceImpl iRouteServiceImpl, int i);

    private static native void removeRouteResultObserverNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteResultObserverImpl iRouteResultObserverImpl);

    private static native void removeRouteWeatherObserverNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteWeatherObserverImpl iRouteWeatherObserverImpl);

    private static native long requestPathWeatherNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native long requestRouteNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native int requestRouteRestorationNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, IRouteRestorationOptionImpl iRouteRestorationOptionImpl);

    private static native int retryRequestRouteNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2);

    private static native void setElecInfoConfigNative(long j, IRouteServiceImpl iRouteServiceImpl, long j2, ElecInfoConfig elecInfoConfig);

    private static native void unInitNative(long j, IRouteServiceImpl iRouteServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IRouteServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteServiceImpl) && getUID(this) == getUID((IRouteServiceImpl) obj);
    }

    private static long getUID(IRouteServiceImpl iRouteServiceImpl) {
        long cPtr = getCPtr(iRouteServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteServiceImpl iRouteServiceImpl) {
        if (iRouteServiceImpl == null) {
            return 0L;
        }
        return iRouteServiceImpl.swigCPtr;
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

    public IRouteConsisAdditionServiceImpl getRouteConsisAdditionService() {
        ArrayList<IRouteConsisAdditionServiceImpl> arrayList = new ArrayList<>();
        getRouteConsisAdditionService(arrayList);
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    @ErrorCode.ErrorCode1
    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
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

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public void setElecInfoConfig(ElecInfoConfig elecInfoConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setElecInfoConfigNative(j, this, 0L, elecInfoConfig);
    }

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public static String getRouteVersion() {
        return getRouteVersionNative();
    }

    public boolean control(@RouteControlKey.RouteControlKey1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return controlNative(j, this, i, str);
    }

    public long requestRoute(IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRouteNative(j, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    @RouteErrorcode.RouteErrorcode1
    public int retryRequestRoute(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return retryRequestRouteNative(j2, this, j);
    }

    public boolean abortRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRequestNative(j2, this, j);
    }

    public int requestRouteRestoration(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRouteRestorationNative(j, this, IRouteRestorationOptionImpl.getCPtr(iRouteRestorationOptionImpl), iRouteRestorationOptionImpl);
    }

    public void abortRouteRestorationRequest(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortRouteRestorationRequestNative(j, this, i);
    }

    public void abortAosRouteRequest(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAosRouteRequestNative(j, this, i);
    }

    public void abortAllAosRouteRequest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAllAosRouteRequestNative(j, this);
    }

    public long requestPathWeather(PathInfoImpl pathInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestPathWeatherNative(j, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl);
    }

    public void abortPathWeatherRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        abortPathWeatherRequestNative(j2, this, j);
    }

    public void abortAllPathWeatherRequest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAllPathWeatherRequestNative(j, this);
    }

    public void addRouteResultObserver(IRouteResultObserverImpl iRouteResultObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addRouteResultObserverNative(j, this, IRouteResultObserverImpl.getCPtr(iRouteResultObserverImpl), iRouteResultObserverImpl);
    }

    public void removeRouteResultObserver(IRouteResultObserverImpl iRouteResultObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeRouteResultObserverNative(j, this, IRouteResultObserverImpl.getCPtr(iRouteResultObserverImpl), iRouteResultObserverImpl);
    }

    public void addRouteWeatherObserver(IRouteWeatherObserverImpl iRouteWeatherObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addRouteWeatherObserverNative(j, this, IRouteWeatherObserverImpl.getCPtr(iRouteWeatherObserverImpl), iRouteWeatherObserverImpl);
    }

    public void removeRouteWeatherObserver(IRouteWeatherObserverImpl iRouteWeatherObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeRouteWeatherObserverNative(j, this, IRouteWeatherObserverImpl.getCPtr(iRouteWeatherObserverImpl), iRouteWeatherObserverImpl);
    }

    public String getAosRequestRouteURL(IRouteAosOptionImpl iRouteAosOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAosRequestRouteURLNative(j, this, IRouteAosOptionImpl.getCPtr(iRouteAosOptionImpl), iRouteAosOptionImpl);
    }

    private void getRouteConsisAdditionService(ArrayList<IRouteConsisAdditionServiceImpl> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getRouteConsisAdditionServiceNative(j, this, arrayList);
    }
}
