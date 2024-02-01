package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.DiningTrade;
import com.autonavi.gbl.information.trade.model.DiningTradePrice;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmit;
import com.autonavi.gbl.information.trade.observer.impl.IDiningTradeObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
@IntfAuto(target = DiningTrade.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDiningTradeImpl extends ITradeImpl {
    private static BindTable BIND_TABLE = new BindTable(IDiningTradeImpl.class);
    private transient long swigCPtr;

    private static native long IDiningTradeImpl_SWIGUpcast(long j);

    private static native void addObserverNative(long j, IDiningTradeImpl iDiningTradeImpl, long j2, IDiningTradeObserverImpl iDiningTradeObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void removeObserverNative(long j, IDiningTradeImpl iDiningTradeImpl, long j2, IDiningTradeObserverImpl iDiningTradeObserverImpl);

    private static native TaskResult request1Native(long j, IDiningTradeImpl iDiningTradeImpl, long j2, DiningTradeSubmit diningTradeSubmit);

    private static native TaskResult requestNative(long j, IDiningTradeImpl iDiningTradeImpl, long j2, DiningTradePrice diningTradePrice);

    public IDiningTradeImpl(long j, boolean z) {
        super(IDiningTradeImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.information.trade.impl.ITradeImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.information.trade.impl.ITradeImpl
    public boolean equals(Object obj) {
        if (obj instanceof IDiningTradeImpl) {
            return getUID(this) == getUID((IDiningTradeImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IDiningTradeImpl iDiningTradeImpl) {
        long cPtr = getCPtr(iDiningTradeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDiningTradeImpl iDiningTradeImpl) {
        if (iDiningTradeImpl == null) {
            return 0L;
        }
        return iDiningTradeImpl.swigCPtr;
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

    public void addObserver(IDiningTradeObserverImpl iDiningTradeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addObserverNative(j, this, IDiningTradeObserverImpl.getCPtr(iDiningTradeObserverImpl), iDiningTradeObserverImpl);
    }

    public void removeObserver(IDiningTradeObserverImpl iDiningTradeObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, IDiningTradeObserverImpl.getCPtr(iDiningTradeObserverImpl), iDiningTradeObserverImpl);
    }

    public TaskResult request(DiningTradePrice diningTradePrice) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, diningTradePrice);
    }

    public TaskResult request(DiningTradeSubmit diningTradeSubmit) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request1Native(j, this, 0L, diningTradeSubmit);
    }
}
