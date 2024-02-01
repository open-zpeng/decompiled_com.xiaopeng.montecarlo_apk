package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.ObtainedCouponResult;
import com.autonavi.gbl.information.trade.observer.IObtainedCouponObserver;
@IntfAuto(target = IObtainedCouponObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IObtainedCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IObtainedCouponObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IObtainedCouponObserverImpl_change_ownership(IObtainedCouponObserverImpl iObtainedCouponObserverImpl, long j, boolean z);

    private static native void IObtainedCouponObserverImpl_director_connect(IObtainedCouponObserverImpl iObtainedCouponObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, IObtainedCouponObserverImpl iObtainedCouponObserverImpl, long j2, ObtainedCouponResult obtainedCouponResult);

    public IObtainedCouponObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IObtainedCouponObserverImpl) && getUID(this) == getUID((IObtainedCouponObserverImpl) obj);
    }

    private static long getUID(IObtainedCouponObserverImpl iObtainedCouponObserverImpl) {
        long cPtr = getCPtr(iObtainedCouponObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IObtainedCouponObserverImpl iObtainedCouponObserverImpl) {
        if (iObtainedCouponObserverImpl == null) {
            return 0L;
        }
        return iObtainedCouponObserverImpl.swigCPtr;
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
        IObtainedCouponObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IObtainedCouponObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(ObtainedCouponResult obtainedCouponResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, obtainedCouponResult);
    }

    public IObtainedCouponObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IObtainedCouponObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
