package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.observer.IBLGLRenderStateObserver;
@IntfAuto(target = IBLGLRenderStateObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLGLRenderStateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLGLRenderStateObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLGLRenderStateObserverImpl_change_ownership(IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl, long j, boolean z);

    private static native void IBLGLRenderStateObserverImpl_director_connect(IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapGLRenderNative(long j, IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl, long j2, int i);

    public IBLGLRenderStateObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLGLRenderStateObserverImpl) && getUID(this) == getUID((IBLGLRenderStateObserverImpl) obj);
    }

    private static long getUID(IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl) {
        long cPtr = getCPtr(iBLGLRenderStateObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl) {
        if (iBLGLRenderStateObserverImpl == null) {
            return 0L;
        }
        return iBLGLRenderStateObserverImpl.swigCPtr;
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
        IBLGLRenderStateObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLGLRenderStateObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapGLRender(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapGLRenderNative(j2, this, j, i);
    }

    public IBLGLRenderStateObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLGLRenderStateObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
