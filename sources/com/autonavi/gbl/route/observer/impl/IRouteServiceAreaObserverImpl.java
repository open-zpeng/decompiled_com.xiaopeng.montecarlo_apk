package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.RouteAlongServiceAreaInfo;
import com.autonavi.gbl.route.model.RouteServiceArea;
import com.autonavi.gbl.route.observer.IRouteServiceAreaObserver;
import java.util.ArrayList;
@IntfAuto(target = IRouteServiceAreaObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteServiceAreaObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteServiceAreaObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRouteServiceAreaObserverImpl_change_ownership(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, long j, boolean z);

    private static native void IRouteServiceAreaObserverImpl_director_connect(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onServiceAreaUpdatedNative(long j, IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, ArrayList<RouteServiceArea> arrayList);

    private static native void onUpdateAlongServiceAreaNative(long j, IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, ArrayList<RouteAlongServiceAreaInfo> arrayList);

    private static native void onUpdateAlongServiceAreaSwigExplicitIRouteServiceAreaObserverImplNative(long j, IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, ArrayList<RouteAlongServiceAreaInfo> arrayList);

    public IRouteServiceAreaObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteServiceAreaObserverImpl) && getUID(this) == getUID((IRouteServiceAreaObserverImpl) obj);
    }

    private static long getUID(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl) {
        long cPtr = getCPtr(iRouteServiceAreaObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl) {
        if (iRouteServiceAreaObserverImpl == null) {
            return 0L;
        }
        return iRouteServiceAreaObserverImpl.swigCPtr;
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
        IRouteServiceAreaObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRouteServiceAreaObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onServiceAreaUpdated(ArrayList<RouteServiceArea> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onServiceAreaUpdatedNative(j, this, arrayList);
    }

    public void onUpdateAlongServiceArea(ArrayList<RouteAlongServiceAreaInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IRouteServiceAreaObserverImpl.class) {
            onUpdateAlongServiceAreaNative(this.swigCPtr, this, arrayList);
        } else {
            onUpdateAlongServiceAreaSwigExplicitIRouteServiceAreaObserverImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public IRouteServiceAreaObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        IRouteServiceAreaObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
