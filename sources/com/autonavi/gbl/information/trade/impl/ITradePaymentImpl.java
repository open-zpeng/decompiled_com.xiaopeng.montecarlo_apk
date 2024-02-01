package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.TradePayment;
import com.autonavi.gbl.information.trade.model.AgreementStatusRequest;
import com.autonavi.gbl.information.trade.observer.impl.IAgreementStatusObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
@IntfAuto(target = TradePayment.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITradePaymentImpl {
    private static BindTable BIND_TABLE = new BindTable(ITradePaymentImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortAllNative(long j, ITradePaymentImpl iTradePaymentImpl);

    private static native void abortNative(long j, ITradePaymentImpl iTradePaymentImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native TaskResult requestNative(long j, ITradePaymentImpl iTradePaymentImpl, long j2, AgreementStatusRequest agreementStatusRequest, long j3, IAgreementStatusObserverImpl iAgreementStatusObserverImpl);

    public ITradePaymentImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITradePaymentImpl) && getUID(this) == getUID((ITradePaymentImpl) obj);
    }

    private static long getUID(ITradePaymentImpl iTradePaymentImpl) {
        long cPtr = getCPtr(iTradePaymentImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITradePaymentImpl iTradePaymentImpl) {
        if (iTradePaymentImpl == null) {
            return 0L;
        }
        return iTradePaymentImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public TaskResult request(AgreementStatusRequest agreementStatusRequest, IAgreementStatusObserverImpl iAgreementStatusObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, agreementStatusRequest, IAgreementStatusObserverImpl.getCPtr(iAgreementStatusObserverImpl), iAgreementStatusObserverImpl);
    }

    public void abort(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortNative(j, this, i);
    }

    public void abortAll() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAllNative(j, this);
    }
}
