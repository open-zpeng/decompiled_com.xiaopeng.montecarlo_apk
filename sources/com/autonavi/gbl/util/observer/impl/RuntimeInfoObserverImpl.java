package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.RuntimeInfo;
import com.autonavi.gbl.util.observer.IRuntimeInfoObserver;
@IntfAuto(target = IRuntimeInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RuntimeInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RuntimeInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void RuntimeInfoObserverImpl_change_ownership(RuntimeInfoObserverImpl runtimeInfoObserverImpl, long j, boolean z);

    private static native void RuntimeInfoObserverImpl_director_connect(RuntimeInfoObserverImpl runtimeInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRuntimeInfoResponseNative(long j, RuntimeInfoObserverImpl runtimeInfoObserverImpl, long j2, RuntimeInfo runtimeInfo);

    public RuntimeInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeInfoObserverImpl) && getUID(this) == getUID((RuntimeInfoObserverImpl) obj);
    }

    private static long getUID(RuntimeInfoObserverImpl runtimeInfoObserverImpl) {
        long cPtr = getCPtr(runtimeInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RuntimeInfoObserverImpl runtimeInfoObserverImpl) {
        if (runtimeInfoObserverImpl == null) {
            return 0L;
        }
        return runtimeInfoObserverImpl.swigCPtr;
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
        RuntimeInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RuntimeInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRuntimeInfoResponse(RuntimeInfo runtimeInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRuntimeInfoResponseNative(j, this, 0L, runtimeInfo);
    }

    public RuntimeInfoObserverImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        RuntimeInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
