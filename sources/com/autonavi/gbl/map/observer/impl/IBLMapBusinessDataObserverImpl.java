package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.IBLMapBusinessDataObserver;
@IntfAuto(target = IBLMapBusinessDataObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLMapBusinessDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLMapBusinessDataObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLMapBusinessDataObserverImpl_change_ownership(IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, long j, boolean z);

    private static native void IBLMapBusinessDataObserverImpl_director_connect(IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onBusinessDataObserverNative(long j, IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, int i, long j2, long j3);

    public IBLMapBusinessDataObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLMapBusinessDataObserverImpl) && getUID(this) == getUID((IBLMapBusinessDataObserverImpl) obj);
    }

    private static long getUID(IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl) {
        long cPtr = getCPtr(iBLMapBusinessDataObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl) {
        if (iBLMapBusinessDataObserverImpl == null) {
            return 0L;
        }
        return iBLMapBusinessDataObserverImpl.swigCPtr;
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
        IBLMapBusinessDataObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLMapBusinessDataObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onBusinessDataObserver(int i, long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        return onBusinessDataObserverNative(j3, this, i, j, j2);
    }

    public IBLMapBusinessDataObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLMapBusinessDataObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
