package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.ObtainCouponResult;
import com.autonavi.gbl.information.trade.observer.IObtainCouponObserver;
@IntfAuto(target = IObtainCouponObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IObtainCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IObtainCouponObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IObtainCouponObserverImpl_change_ownership(IObtainCouponObserverImpl iObtainCouponObserverImpl, long j, boolean z);

    private static native void IObtainCouponObserverImpl_director_connect(IObtainCouponObserverImpl iObtainCouponObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, IObtainCouponObserverImpl iObtainCouponObserverImpl, long j2, ObtainCouponResult obtainCouponResult);

    public IObtainCouponObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IObtainCouponObserverImpl) && getUID(this) == getUID((IObtainCouponObserverImpl) obj);
    }

    private static long getUID(IObtainCouponObserverImpl iObtainCouponObserverImpl) {
        long cPtr = getCPtr(iObtainCouponObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IObtainCouponObserverImpl iObtainCouponObserverImpl) {
        if (iObtainCouponObserverImpl == null) {
            return 0L;
        }
        return iObtainCouponObserverImpl.swigCPtr;
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
        IObtainCouponObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IObtainCouponObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(ObtainCouponResult obtainCouponResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, obtainCouponResult);
    }

    public IObtainCouponObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IObtainCouponObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
