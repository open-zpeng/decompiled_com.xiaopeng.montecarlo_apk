package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.OrderWaitingResult;
import com.autonavi.gbl.information.trade.observer.IWaitingOrderObserver;
@IntfAuto(target = IWaitingOrderObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IWaitingOrderObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IWaitingOrderObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IWaitingOrderObserverImpl_change_ownership(IWaitingOrderObserverImpl iWaitingOrderObserverImpl, long j, boolean z);

    private static native void IWaitingOrderObserverImpl_director_connect(IWaitingOrderObserverImpl iWaitingOrderObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, IWaitingOrderObserverImpl iWaitingOrderObserverImpl, long j2, OrderWaitingResult orderWaitingResult);

    public IWaitingOrderObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IWaitingOrderObserverImpl) && getUID(this) == getUID((IWaitingOrderObserverImpl) obj);
    }

    private static long getUID(IWaitingOrderObserverImpl iWaitingOrderObserverImpl) {
        long cPtr = getCPtr(iWaitingOrderObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IWaitingOrderObserverImpl iWaitingOrderObserverImpl) {
        if (iWaitingOrderObserverImpl == null) {
            return 0L;
        }
        return iWaitingOrderObserverImpl.swigCPtr;
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
        IWaitingOrderObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IWaitingOrderObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(OrderWaitingResult orderWaitingResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, orderWaitingResult);
    }

    public IWaitingOrderObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IWaitingOrderObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
