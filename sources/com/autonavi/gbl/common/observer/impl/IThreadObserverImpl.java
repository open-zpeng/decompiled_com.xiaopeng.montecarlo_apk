package com.autonavi.gbl.common.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.observer.IThreadObserver;
@IntfAuto(target = IThreadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IThreadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IThreadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IThreadObserverImpl_change_ownership(IThreadObserverImpl iThreadObserverImpl, long j, boolean z);

    private static native void IThreadObserverImpl_director_connect(IThreadObserverImpl iThreadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void threadCallbackNative(long j, IThreadObserverImpl iThreadObserverImpl, long j2, byte b);

    public IThreadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IThreadObserverImpl) && getUID(this) == getUID((IThreadObserverImpl) obj);
    }

    private static long getUID(IThreadObserverImpl iThreadObserverImpl) {
        long cPtr = getCPtr(iThreadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IThreadObserverImpl iThreadObserverImpl) {
        if (iThreadObserverImpl == null) {
            return 0L;
        }
        return iThreadObserverImpl.swigCPtr;
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
        IThreadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IThreadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void threadCallback(long j, byte b) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        threadCallbackNative(j2, this, j, b);
    }

    public IThreadObserverImpl() {
        this(createNativeObj(), true);
        BLCommonObserverJNI.swig_jni_init();
        IThreadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
