package com.autonavi.gbl.activation.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.activation.model.ActivateErrorCode;
import com.autonavi.gbl.activation.observer.INetActivateObserver;
@IntfAuto(target = INetActivateObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class INetActivateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(INetActivateObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void INetActivateObserverImpl_change_ownership(INetActivateObserverImpl iNetActivateObserverImpl, long j, boolean z);

    private static native void INetActivateObserverImpl_director_connect(INetActivateObserverImpl iNetActivateObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNetActivateResponseNative(long j, INetActivateObserverImpl iNetActivateObserverImpl, int i);

    public INetActivateObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INetActivateObserverImpl) && getUID(this) == getUID((INetActivateObserverImpl) obj);
    }

    private static long getUID(INetActivateObserverImpl iNetActivateObserverImpl) {
        long cPtr = getCPtr(iNetActivateObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INetActivateObserverImpl iNetActivateObserverImpl) {
        if (iNetActivateObserverImpl == null) {
            return 0L;
        }
        return iNetActivateObserverImpl.swigCPtr;
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
        INetActivateObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        INetActivateObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNetActivateResponse(@ActivateErrorCode.ActivateErrorCode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNetActivateResponseNative(j, this, i);
    }

    public INetActivateObserverImpl() {
        this(createNativeObj(), true);
        ActivationObserverJNI.swig_jni_init();
        INetActivateObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
