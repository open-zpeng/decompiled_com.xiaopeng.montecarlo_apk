package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.FuelTrade;
import com.autonavi.gbl.information.trade.model.FuelTradePrice;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmit;
import com.autonavi.gbl.information.trade.observer.impl.IFuelTradeObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
@IntfAuto(target = FuelTrade.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IFuelTradeImpl extends ITradeImpl {
    private static BindTable BIND_TABLE = new BindTable(IFuelTradeImpl.class);
    private transient long swigCPtr;

    private static native long IFuelTradeImpl_SWIGUpcast(long j);

    private static native void addObserverNative(long j, IFuelTradeImpl iFuelTradeImpl, long j2, IFuelTradeObserverImpl iFuelTradeObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void removeObserverNative(long j, IFuelTradeImpl iFuelTradeImpl, long j2, IFuelTradeObserverImpl iFuelTradeObserverImpl);

    private static native TaskResult request1Native(long j, IFuelTradeImpl iFuelTradeImpl, long j2, FuelTradeSubmit fuelTradeSubmit);

    private static native TaskResult requestNative(long j, IFuelTradeImpl iFuelTradeImpl, long j2, FuelTradePrice fuelTradePrice);

    public IFuelTradeImpl(long j, boolean z) {
        super(IFuelTradeImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.information.trade.impl.ITradeImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.information.trade.impl.ITradeImpl
    public boolean equals(Object obj) {
        if (obj instanceof IFuelTradeImpl) {
            return getUID(this) == getUID((IFuelTradeImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IFuelTradeImpl iFuelTradeImpl) {
        long cPtr = getCPtr(iFuelTradeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IFuelTradeImpl iFuelTradeImpl) {
        if (iFuelTradeImpl == null) {
            return 0L;
        }
        return iFuelTradeImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.impl.ITradeImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void addObserver(IFuelTradeObserverImpl iFuelTradeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addObserverNative(j, this, IFuelTradeObserverImpl.getCPtr(iFuelTradeObserverImpl), iFuelTradeObserverImpl);
    }

    public void removeObserver(IFuelTradeObserverImpl iFuelTradeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IFuelTradeObserverImpl.getCPtr(iFuelTradeObserverImpl), iFuelTradeObserverImpl);
    }

    public TaskResult request(FuelTradePrice fuelTradePrice) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, fuelTradePrice);
    }

    public TaskResult request(FuelTradeSubmit fuelTradeSubmit) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request1Native(j, this, 0L, fuelTradeSubmit);
    }
}
