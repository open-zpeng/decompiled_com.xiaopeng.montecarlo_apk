package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldRemoteDispObserver;
@IntfAuto(target = IKldRemoteDispObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldRemoteDispObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldRemoteDispObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKldRemoteDispObserverImpl_change_ownership(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, long j, boolean z);

    private static native void IKldRemoteDispObserverImpl_director_connect(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRemoteDisplayCreatedNative(long j, IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, int i, int i2);

    private static native void onRemoteDisplayDestroyedNative(long j, IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, int i, int i2);

    public IKldRemoteDispObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldRemoteDispObserverImpl) && getUID(this) == getUID((IKldRemoteDispObserverImpl) obj);
    }

    private static long getUID(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl) {
        long cPtr = getCPtr(iKldRemoteDispObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl) {
        if (iKldRemoteDispObserverImpl == null) {
            return 0L;
        }
        return iKldRemoteDispObserverImpl.swigCPtr;
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
        IKldRemoteDispObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKldRemoteDispObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRemoteDisplayCreatedNative(j, this, i, i2);
    }

    public void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRemoteDisplayDestroyedNative(j, this, i, i2);
    }

    public IKldRemoteDispObserverImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        IKldRemoteDispObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
