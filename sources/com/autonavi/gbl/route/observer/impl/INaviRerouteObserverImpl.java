package com.autonavi.gbl.route.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.route.model.BLRerouteRequestInfo;
import com.autonavi.gbl.route.observer.INaviRerouteObserver;
@IntfAuto(target = INaviRerouteObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class INaviRerouteObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(INaviRerouteObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void INaviRerouteObserverImpl_change_ownership(INaviRerouteObserverImpl iNaviRerouteObserverImpl, long j, boolean z);

    private static native void INaviRerouteObserverImpl_director_connect(INaviRerouteObserverImpl iNaviRerouteObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onModifyRerouteOptionNative(long j, INaviRerouteObserverImpl iNaviRerouteObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native void onRerouteInfoNative(long j, INaviRerouteObserverImpl iNaviRerouteObserverImpl, long j2, BLRerouteRequestInfo bLRerouteRequestInfo);

    private static native void onSwitchParallelRoadRerouteInfoNative(long j, INaviRerouteObserverImpl iNaviRerouteObserverImpl, long j2, BLRerouteRequestInfo bLRerouteRequestInfo);

    public INaviRerouteObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INaviRerouteObserverImpl) && getUID(this) == getUID((INaviRerouteObserverImpl) obj);
    }

    private static long getUID(INaviRerouteObserverImpl iNaviRerouteObserverImpl) {
        long cPtr = getCPtr(iNaviRerouteObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INaviRerouteObserverImpl iNaviRerouteObserverImpl) {
        if (iNaviRerouteObserverImpl == null) {
            return 0L;
        }
        return iNaviRerouteObserverImpl.swigCPtr;
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
        INaviRerouteObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        INaviRerouteObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onModifyRerouteOption(IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onModifyRerouteOptionNative(j, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public void onRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRerouteInfoNative(j, this, 0L, bLRerouteRequestInfo);
    }

    public void onSwitchParallelRoadRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSwitchParallelRoadRerouteInfoNative(j, this, 0L, bLRerouteRequestInfo);
    }

    public INaviRerouteObserverImpl() {
        this(createNativeObj(), true);
        RouteObserverJNI.swig_jni_init();
        INaviRerouteObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
