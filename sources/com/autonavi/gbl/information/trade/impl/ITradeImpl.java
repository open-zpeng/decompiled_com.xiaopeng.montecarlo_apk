package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.Trade;
@IntfAuto(target = Trade.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITradeImpl {
    private static BindTable BIND_TABLE = new BindTable(ITradeImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortNative(long j, ITradeImpl iTradeImpl);

    private static native void destroyNativeObj(long j);

    private static native long getCouponNative(long j, ITradeImpl iTradeImpl);

    private static native long getOrderNative(long j, ITradeImpl iTradeImpl);

    private static native long getPaymentNative(long j, ITradeImpl iTradeImpl);

    public ITradeImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITradeImpl) && getUID(this) == getUID((ITradeImpl) obj);
    }

    private static long getUID(ITradeImpl iTradeImpl) {
        long cPtr = getCPtr(iTradeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITradeImpl iTradeImpl) {
        if (iTradeImpl == null) {
            return 0L;
        }
        return iTradeImpl.swigCPtr;
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

    public ITradeOrderImpl getOrder() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long orderNative = getOrderNative(j, this);
        if (orderNative == 0) {
            return null;
        }
        return new ITradeOrderImpl(orderNative, false);
    }

    public ITradeCouponImpl getCoupon() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long couponNative = getCouponNative(j, this);
        if (couponNative == 0) {
            return null;
        }
        return new ITradeCouponImpl(couponNative, false);
    }

    public ITradePaymentImpl getPayment() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long paymentNative = getPaymentNative(j, this);
        if (paymentNative == 0) {
            return null;
        }
        return new ITradePaymentImpl(paymentNative, false);
    }

    public void abort() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortNative(j, this);
    }
}
