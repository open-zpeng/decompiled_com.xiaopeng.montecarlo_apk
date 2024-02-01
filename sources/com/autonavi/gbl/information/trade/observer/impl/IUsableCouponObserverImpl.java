package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.UsableCouponResult;
import com.autonavi.gbl.information.trade.observer.IUsableCouponObserver;
@IntfAuto(target = IUsableCouponObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IUsableCouponObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IUsableCouponObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IUsableCouponObserverImpl_change_ownership(IUsableCouponObserverImpl iUsableCouponObserverImpl, long j, boolean z);

    private static native void IUsableCouponObserverImpl_director_connect(IUsableCouponObserverImpl iUsableCouponObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, IUsableCouponObserverImpl iUsableCouponObserverImpl, long j2, UsableCouponResult usableCouponResult);

    public IUsableCouponObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IUsableCouponObserverImpl) && getUID(this) == getUID((IUsableCouponObserverImpl) obj);
    }

    private static long getUID(IUsableCouponObserverImpl iUsableCouponObserverImpl) {
        long cPtr = getCPtr(iUsableCouponObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IUsableCouponObserverImpl iUsableCouponObserverImpl) {
        if (iUsableCouponObserverImpl == null) {
            return 0L;
        }
        return iUsableCouponObserverImpl.swigCPtr;
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
        IUsableCouponObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IUsableCouponObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(UsableCouponResult usableCouponResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, usableCouponResult);
    }

    public IUsableCouponObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IUsableCouponObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
