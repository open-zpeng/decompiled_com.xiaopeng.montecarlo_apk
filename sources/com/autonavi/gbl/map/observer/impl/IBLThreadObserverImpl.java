package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.observer.IBLThreadObserver;
@IntfAuto(target = IBLThreadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLThreadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLThreadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLThreadObserverImpl_change_ownership(IBLThreadObserverImpl iBLThreadObserverImpl, long j, boolean z);

    private static native void IBLThreadObserverImpl_director_connect(IBLThreadObserverImpl iBLThreadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void threadCallbackNative(long j, IBLThreadObserverImpl iBLThreadObserverImpl, long j2, byte b);

    public IBLThreadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLThreadObserverImpl) && getUID(this) == getUID((IBLThreadObserverImpl) obj);
    }

    private static long getUID(IBLThreadObserverImpl iBLThreadObserverImpl) {
        long cPtr = getCPtr(iBLThreadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLThreadObserverImpl iBLThreadObserverImpl) {
        if (iBLThreadObserverImpl == null) {
            return 0L;
        }
        return iBLThreadObserverImpl.swigCPtr;
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
        IBLThreadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLThreadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void threadCallback(long j, byte b) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        threadCallbackNative(j2, this, j, b);
    }

    public IBLThreadObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLThreadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
