package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.DiningTradePriceResult;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmitResult;
import com.autonavi.gbl.information.trade.observer.IDiningTradeObserver;
@IntfAuto(target = IDiningTradeObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDiningTradeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDiningTradeObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDiningTradeObserverImpl_change_ownership(IDiningTradeObserverImpl iDiningTradeObserverImpl, long j, boolean z);

    private static native void IDiningTradeObserverImpl_director_connect(IDiningTradeObserverImpl iDiningTradeObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResult1Native(long j, IDiningTradeObserverImpl iDiningTradeObserverImpl, long j2, DiningTradeSubmitResult diningTradeSubmitResult);

    private static native void onResultNative(long j, IDiningTradeObserverImpl iDiningTradeObserverImpl, long j2, DiningTradePriceResult diningTradePriceResult);

    private static native void onResultSwigExplicitIDiningTradeObserverImpl1Native(long j, IDiningTradeObserverImpl iDiningTradeObserverImpl, long j2, DiningTradeSubmitResult diningTradeSubmitResult);

    private static native void onResultSwigExplicitIDiningTradeObserverImplNative(long j, IDiningTradeObserverImpl iDiningTradeObserverImpl, long j2, DiningTradePriceResult diningTradePriceResult);

    public IDiningTradeObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDiningTradeObserverImpl) && getUID(this) == getUID((IDiningTradeObserverImpl) obj);
    }

    private static long getUID(IDiningTradeObserverImpl iDiningTradeObserverImpl) {
        long cPtr = getCPtr(iDiningTradeObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDiningTradeObserverImpl iDiningTradeObserverImpl) {
        if (iDiningTradeObserverImpl == null) {
            return 0L;
        }
        return iDiningTradeObserverImpl.swigCPtr;
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
        IDiningTradeObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDiningTradeObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(DiningTradePriceResult diningTradePriceResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IDiningTradeObserverImpl.class) {
            onResultNative(this.swigCPtr, this, 0L, diningTradePriceResult);
        } else {
            onResultSwigExplicitIDiningTradeObserverImplNative(this.swigCPtr, this, 0L, diningTradePriceResult);
        }
    }

    public void onResult(DiningTradeSubmitResult diningTradeSubmitResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IDiningTradeObserverImpl.class) {
            onResult1Native(this.swigCPtr, this, 0L, diningTradeSubmitResult);
        } else {
            onResultSwigExplicitIDiningTradeObserverImpl1Native(this.swigCPtr, this, 0L, diningTradeSubmitResult);
        }
    }

    public IDiningTradeObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IDiningTradeObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
