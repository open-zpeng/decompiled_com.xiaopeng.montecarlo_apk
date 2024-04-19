package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.AnmCallbackParam;
import com.autonavi.gbl.map.observer.IAnimationObserver;
@IntfAuto(target = IAnimationObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IAnimationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IAnimationObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IAnimationObserverImpl_change_ownership(IAnimationObserverImpl iAnimationObserverImpl, long j, boolean z);

    private static native void IAnimationObserverImpl_director_connect(IAnimationObserverImpl iAnimationObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void processMapAnimationFinishedNative(long j, IAnimationObserverImpl iAnimationObserverImpl, long j2, long j3, AnmCallbackParam anmCallbackParam);

    public IAnimationObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAnimationObserverImpl) && getUID(this) == getUID((IAnimationObserverImpl) obj);
    }

    private static long getUID(IAnimationObserverImpl iAnimationObserverImpl) {
        long cPtr = getCPtr(iAnimationObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAnimationObserverImpl iAnimationObserverImpl) {
        if (iAnimationObserverImpl == null) {
            return 0L;
        }
        return iAnimationObserverImpl.swigCPtr;
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
        IAnimationObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IAnimationObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void processMapAnimationFinished(long j, AnmCallbackParam anmCallbackParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        processMapAnimationFinishedNative(j2, this, j, 0L, anmCallbackParam);
    }

    public IAnimationObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IAnimationObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
