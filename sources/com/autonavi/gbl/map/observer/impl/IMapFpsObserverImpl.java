package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.IMapFpsObserver;
@IntfAuto(target = IMapFpsObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapFpsObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapFpsObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapFpsObserverImpl_change_ownership(IMapFpsObserverImpl iMapFpsObserverImpl, long j, boolean z);

    private static native void IMapFpsObserverImpl_director_connect(IMapFpsObserverImpl iMapFpsObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapRenderConfigFpsNative(long j, IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2);

    private static native void onMapRenderRealFpsNative(long j, IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2, int i3);

    private static native void onMapRenderTimeOutNative(long j, IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2, int i3);

    public IMapFpsObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapFpsObserverImpl) && getUID(this) == getUID((IMapFpsObserverImpl) obj);
    }

    private static long getUID(IMapFpsObserverImpl iMapFpsObserverImpl) {
        long cPtr = getCPtr(iMapFpsObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapFpsObserverImpl iMapFpsObserverImpl) {
        if (iMapFpsObserverImpl == null) {
            return 0L;
        }
        return iMapFpsObserverImpl.swigCPtr;
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
        IMapFpsObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapFpsObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapRenderTimeOut(int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapRenderTimeOutNative(j, this, i, i2, i3);
    }

    public void onMapRenderRealFps(int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapRenderRealFpsNative(j, this, i, i2, i3);
    }

    public void onMapRenderConfigFps(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapRenderConfigFpsNative(j, this, i, i2);
    }

    public IMapFpsObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapFpsObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
