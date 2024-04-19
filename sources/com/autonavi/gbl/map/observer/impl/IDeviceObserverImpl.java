package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.EGLColorBits;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLDeviceRenderStatus;
import com.autonavi.gbl.map.observer.IDeviceObserver;
@IntfAuto(target = IDeviceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDeviceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDeviceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDeviceObserverImpl_change_ownership(IDeviceObserverImpl iDeviceObserverImpl, long j, boolean z);

    private static native void IDeviceObserverImpl_director_connect(IDeviceObserverImpl iDeviceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDeviceCreatedNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i);

    private static native void onDeviceDestroyedNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i);

    private static native void onDeviceRenderNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i, int i2);

    private static native void onEGLDoRenderNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i);

    private static native void onSurfaceChangedNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, int i4);

    private static native void onSurfaceCreatedNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, int i4);

    private static native void onSurfaceDestroyedNative(long j, IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, int i4);

    public IDeviceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDeviceObserverImpl) && getUID(this) == getUID((IDeviceObserverImpl) obj);
    }

    private static long getUID(IDeviceObserverImpl iDeviceObserverImpl) {
        long cPtr = getCPtr(iDeviceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDeviceObserverImpl iDeviceObserverImpl) {
        if (iDeviceObserverImpl == null) {
            return 0L;
        }
        return iDeviceObserverImpl.swigCPtr;
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
        IDeviceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDeviceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onDeviceCreated(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDeviceCreatedNative(j, this, i);
    }

    public void onDeviceDestroyed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDeviceDestroyedNative(j, this, i);
    }

    public void onSurfaceCreated(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSurfaceCreatedNative(j, this, i, i2, i3, i4);
    }

    public void onSurfaceDestroyed(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSurfaceDestroyedNative(j, this, i, i2, i3, i4);
    }

    public void onSurfaceChanged(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSurfaceChangedNative(j, this, i, i2, i3, i4);
    }

    public void onDeviceRender(int i, @EGLDeviceRenderStatus.EGLDeviceRenderStatus1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDeviceRenderNative(j, this, i, i2);
    }

    public void onEGLDoRender(@EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onEGLDoRenderNative(j, this, i);
    }

    public IDeviceObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IDeviceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
