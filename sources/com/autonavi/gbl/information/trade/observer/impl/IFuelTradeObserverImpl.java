package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.FuelOrderDetailResult;
import com.autonavi.gbl.information.trade.model.FuelTradePriceResult;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmitResult;
import com.autonavi.gbl.information.trade.observer.IFuelTradeObserver;
@IntfAuto(target = IFuelTradeObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IFuelTradeObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IFuelTradeObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IFuelTradeObserverImpl_change_ownership(IFuelTradeObserverImpl iFuelTradeObserverImpl, long j, boolean z);

    private static native void IFuelTradeObserverImpl_director_connect(IFuelTradeObserverImpl iFuelTradeObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResult1Native(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelTradeSubmitResult fuelTradeSubmitResult);

    private static native void onResult2Native(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelOrderDetailResult fuelOrderDetailResult);

    private static native void onResultNative(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelTradePriceResult fuelTradePriceResult);

    private static native void onResultSwigExplicitIFuelTradeObserverImpl1Native(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelTradeSubmitResult fuelTradeSubmitResult);

    private static native void onResultSwigExplicitIFuelTradeObserverImpl2Native(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelOrderDetailResult fuelOrderDetailResult);

    private static native void onResultSwigExplicitIFuelTradeObserverImplNative(long j, IFuelTradeObserverImpl iFuelTradeObserverImpl, long j2, FuelTradePriceResult fuelTradePriceResult);

    public IFuelTradeObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IFuelTradeObserverImpl) && getUID(this) == getUID((IFuelTradeObserverImpl) obj);
    }

    private static long getUID(IFuelTradeObserverImpl iFuelTradeObserverImpl) {
        long cPtr = getCPtr(iFuelTradeObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IFuelTradeObserverImpl iFuelTradeObserverImpl) {
        if (iFuelTradeObserverImpl == null) {
            return 0L;
        }
        return iFuelTradeObserverImpl.swigCPtr;
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
        IFuelTradeObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IFuelTradeObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(FuelTradePriceResult fuelTradePriceResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IFuelTradeObserverImpl.class) {
            onResultNative(this.swigCPtr, this, 0L, fuelTradePriceResult);
        } else {
            onResultSwigExplicitIFuelTradeObserverImplNative(this.swigCPtr, this, 0L, fuelTradePriceResult);
        }
    }

    public void onResult(FuelTradeSubmitResult fuelTradeSubmitResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IFuelTradeObserverImpl.class) {
            onResult1Native(this.swigCPtr, this, 0L, fuelTradeSubmitResult);
        } else {
            onResultSwigExplicitIFuelTradeObserverImpl1Native(this.swigCPtr, this, 0L, fuelTradeSubmitResult);
        }
    }

    public void onResult(FuelOrderDetailResult fuelOrderDetailResult) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == IFuelTradeObserverImpl.class) {
            onResult2Native(this.swigCPtr, this, 0L, fuelOrderDetailResult);
        } else {
            onResultSwigExplicitIFuelTradeObserverImpl2Native(this.swigCPtr, this, 0L, fuelOrderDetailResult);
        }
    }

    public IFuelTradeObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IFuelTradeObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
