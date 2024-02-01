package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailResult;
import com.autonavi.gbl.information.trade.model.OrderRefundPageResult;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitResult;
import com.autonavi.gbl.information.trade.observer.IOrderRefundObserver;
@IntfAuto(target = IOrderRefundObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IOrderRefundObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IOrderRefundObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IOrderRefundObserverImpl_change_ownership(IOrderRefundObserverImpl iOrderRefundObserverImpl, long j, boolean z);

    private static native void IOrderRefundObserverImpl_director_connect(IOrderRefundObserverImpl iOrderRefundObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResult1Native(long j, IOrderRefundObserverImpl iOrderRefundObserverImpl, long j2, OrderRefundSubmitResult orderRefundSubmitResult);

    private static native void onResult2Native(long j, IOrderRefundObserverImpl iOrderRefundObserverImpl, long j2, OrderRefundDetailResult orderRefundDetailResult);

    private static native void onResultNative(long j, IOrderRefundObserverImpl iOrderRefundObserverImpl, long j2, OrderRefundPageResult orderRefundPageResult);

    public IOrderRefundObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOrderRefundObserverImpl) && getUID(this) == getUID((IOrderRefundObserverImpl) obj);
    }

    private static long getUID(IOrderRefundObserverImpl iOrderRefundObserverImpl) {
        long cPtr = getCPtr(iOrderRefundObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOrderRefundObserverImpl iOrderRefundObserverImpl) {
        if (iOrderRefundObserverImpl == null) {
            return 0L;
        }
        return iOrderRefundObserverImpl.swigCPtr;
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
        IOrderRefundObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IOrderRefundObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(OrderRefundPageResult orderRefundPageResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, orderRefundPageResult);
    }

    public void onResult(OrderRefundSubmitResult orderRefundSubmitResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResult1Native(j, this, 0L, orderRefundSubmitResult);
    }

    public void onResult(OrderRefundDetailResult orderRefundDetailResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResult2Native(j, this, 0L, orderRefundDetailResult);
    }

    public IOrderRefundObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IOrderRefundObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
