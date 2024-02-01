package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.observer.IMapLifecycleObserver;
@IntfAuto(target = IMapLifecycleObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapLifecycleObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapLifecycleObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapLifecycleObserverImpl_change_ownership(IMapLifecycleObserverImpl iMapLifecycleObserverImpl, long j, boolean z);

    private static native void IMapLifecycleObserverImpl_director_connect(IMapLifecycleObserverImpl iMapLifecycleObserverImpl, long j, boolean z, boolean z2);

    private static native void beforeEGLDeviceCreateNative(long j, IMapLifecycleObserverImpl iMapLifecycleObserverImpl, long j2, IMapDeviceImpl iMapDeviceImpl);

    private static native void beforeEGLMapViewCreateNative(long j, IMapLifecycleObserverImpl iMapLifecycleObserverImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public IMapLifecycleObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapLifecycleObserverImpl) && getUID(this) == getUID((IMapLifecycleObserverImpl) obj);
    }

    private static long getUID(IMapLifecycleObserverImpl iMapLifecycleObserverImpl) {
        long cPtr = getCPtr(iMapLifecycleObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapLifecycleObserverImpl iMapLifecycleObserverImpl) {
        if (iMapLifecycleObserverImpl == null) {
            return 0L;
        }
        return iMapLifecycleObserverImpl.swigCPtr;
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
        IMapLifecycleObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapLifecycleObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void beforeEGLDeviceCreate(IMapDeviceImpl iMapDeviceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLDeviceCreateNative(j, this, IMapDeviceImpl.getCPtr(iMapDeviceImpl), iMapDeviceImpl);
    }

    public void beforeEGLMapViewCreate(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLMapViewCreateNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
    }

    public IMapLifecycleObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapLifecycleObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
