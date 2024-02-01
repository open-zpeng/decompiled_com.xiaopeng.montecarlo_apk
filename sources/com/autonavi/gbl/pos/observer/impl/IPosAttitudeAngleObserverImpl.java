package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.RawAttitudeAngle;
import com.autonavi.gbl.pos.observer.IPosAttitudeAngleObserver;
@IntfAuto(target = IPosAttitudeAngleObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosAttitudeAngleObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosAttitudeAngleObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosAttitudeAngleObserverImpl_change_ownership(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl, long j, boolean z);

    private static native void IPosAttitudeAngleObserverImpl_director_connect(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onAttitudeAngleUpdateNative(long j, IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl, long j2, RawAttitudeAngle rawAttitudeAngle);

    public IPosAttitudeAngleObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosAttitudeAngleObserverImpl) && getUID(this) == getUID((IPosAttitudeAngleObserverImpl) obj);
    }

    private static long getUID(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl) {
        long cPtr = getCPtr(iPosAttitudeAngleObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl) {
        if (iPosAttitudeAngleObserverImpl == null) {
            return 0L;
        }
        return iPosAttitudeAngleObserverImpl.swigCPtr;
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
        IPosAttitudeAngleObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosAttitudeAngleObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onAttitudeAngleUpdate(RawAttitudeAngle rawAttitudeAngle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onAttitudeAngleUpdateNative(j, this, 0L, rawAttitudeAngle);
    }

    public IPosAttitudeAngleObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosAttitudeAngleObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
