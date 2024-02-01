package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.OrderCancelResult;
import com.autonavi.gbl.information.trade.observer.ICancelOrderObserver;
@IntfAuto(target = ICancelOrderObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICancelOrderObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ICancelOrderObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICancelOrderObserverImpl_change_ownership(ICancelOrderObserverImpl iCancelOrderObserverImpl, long j, boolean z);

    private static native void ICancelOrderObserverImpl_director_connect(ICancelOrderObserverImpl iCancelOrderObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, ICancelOrderObserverImpl iCancelOrderObserverImpl, long j2, OrderCancelResult orderCancelResult);

    public ICancelOrderObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICancelOrderObserverImpl) && getUID(this) == getUID((ICancelOrderObserverImpl) obj);
    }

    private static long getUID(ICancelOrderObserverImpl iCancelOrderObserverImpl) {
        long cPtr = getCPtr(iCancelOrderObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICancelOrderObserverImpl iCancelOrderObserverImpl) {
        if (iCancelOrderObserverImpl == null) {
            return 0L;
        }
        return iCancelOrderObserverImpl.swigCPtr;
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
        ICancelOrderObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICancelOrderObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(OrderCancelResult orderCancelResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, orderCancelResult);
    }

    public ICancelOrderObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        ICancelOrderObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
