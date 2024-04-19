package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.observer.IMapLifecycleObserverInterface;
@IntfAuto(target = IMapLifecycleObserverInterface.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapLifecycleObserver {
    private static BindTable BIND_TABLE = new BindTable(IMapLifecycleObserver.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapLifecycleObserver_change_ownership(IMapLifecycleObserver iMapLifecycleObserver, long j, boolean z);

    private static native void IMapLifecycleObserver_director_connect(IMapLifecycleObserver iMapLifecycleObserver, long j, boolean z, boolean z2);

    private static native void beforeEGLDeviceCreateNative(long j, IMapLifecycleObserver iMapLifecycleObserver, long j2, MapDeviceImpl mapDeviceImpl);

    private static native void beforeEGLMapViewCreateNative(long j, IMapLifecycleObserver iMapLifecycleObserver, long j2, MapViewImpl mapViewImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public IMapLifecycleObserver(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapLifecycleObserver) && getUID(this) == getUID((IMapLifecycleObserver) obj);
    }

    private static long getUID(IMapLifecycleObserver iMapLifecycleObserver) {
        long cPtr = getCPtr(iMapLifecycleObserver);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapLifecycleObserver iMapLifecycleObserver) {
        if (iMapLifecycleObserver == null) {
            return 0L;
        }
        return iMapLifecycleObserver.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        IMapLifecycleObserver_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapLifecycleObserver_change_ownership(this, this.swigCPtr, true);
    }

    public void beforeEGLDeviceCreate(MapDeviceImpl mapDeviceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLDeviceCreateNative(j, this, MapDeviceImpl.getCPtr(mapDeviceImpl), mapDeviceImpl);
    }

    public void beforeEGLMapViewCreate(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeEGLMapViewCreateNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
    }

    public IMapLifecycleObserver() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapLifecycleObserver_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
