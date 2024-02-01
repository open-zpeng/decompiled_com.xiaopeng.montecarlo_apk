package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import com.autonavi.gbl.route.observer.IRouteWeatherObserver;
import java.util.ArrayList;
@IntfAuto(target = IRouteWeatherObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteWeatherObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteWeatherObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRouteWeatherObserverImpl_change_ownership(IRouteWeatherObserverImpl iRouteWeatherObserverImpl, long j, boolean z);

    private static native void IRouteWeatherObserverImpl_director_connect(IRouteWeatherObserverImpl iRouteWeatherObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onWeatherUpdatedNative(long j, IRouteWeatherObserverImpl iRouteWeatherObserverImpl, long j2, ArrayList<WeatherLabelItem> arrayList);

    public IRouteWeatherObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteWeatherObserverImpl) && getUID(this) == getUID((IRouteWeatherObserverImpl) obj);
    }

    private static long getUID(IRouteWeatherObserverImpl iRouteWeatherObserverImpl) {
        long cPtr = getCPtr(iRouteWeatherObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteWeatherObserverImpl iRouteWeatherObserverImpl) {
        if (iRouteWeatherObserverImpl == null) {
            return 0L;
        }
        return iRouteWeatherObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IRouteWeatherObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRouteWeatherObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onWeatherUpdated(long j, ArrayList<WeatherLabelItem> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onWeatherUpdatedNative(j2, this, j, arrayList);
    }

    public IRouteWeatherObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        IRouteWeatherObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
