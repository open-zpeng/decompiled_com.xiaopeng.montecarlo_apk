package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.observer.IPosSensorParaObserver;
@IntfAuto(target = IPosSensorParaObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosSensorParaObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosSensorParaObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosSensorParaObserverImpl_change_ownership(IPosSensorParaObserverImpl iPosSensorParaObserverImpl, long j, boolean z);

    private static native void IPosSensorParaObserverImpl_director_connect(IPosSensorParaObserverImpl iPosSensorParaObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onSensorParaUpdateNative(long j, IPosSensorParaObserverImpl iPosSensorParaObserverImpl, String str);

    public IPosSensorParaObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosSensorParaObserverImpl) && getUID(this) == getUID((IPosSensorParaObserverImpl) obj);
    }

    private static long getUID(IPosSensorParaObserverImpl iPosSensorParaObserverImpl) {
        long cPtr = getCPtr(iPosSensorParaObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosSensorParaObserverImpl iPosSensorParaObserverImpl) {
        if (iPosSensorParaObserverImpl == null) {
            return 0L;
        }
        return iPosSensorParaObserverImpl.swigCPtr;
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
        IPosSensorParaObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosSensorParaObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSensorParaUpdate(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSensorParaUpdateNative(j, this, str);
    }

    public IPosSensorParaObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosSensorParaObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
