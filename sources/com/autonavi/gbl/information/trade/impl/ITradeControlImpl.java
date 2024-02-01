package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.model.InformationBizType;
import com.autonavi.gbl.information.trade.TradeControl;
import com.autonavi.gbl.information.trade.model.DiningTradeInitParam;
import com.autonavi.gbl.information.trade.model.FuelTradeInitParam;
@IntfAuto(target = TradeControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITradeControlImpl {
    private static BindTable BIND_TABLE = new BindTable(ITradeControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createCouponNative(long j, ITradeControlImpl iTradeControlImpl, int i);

    private static native long createDiningTradeNative(long j, ITradeControlImpl iTradeControlImpl, long j2, DiningTradeInitParam diningTradeInitParam);

    private static native long createFuelTradeNative(long j, ITradeControlImpl iTradeControlImpl, long j2, FuelTradeInitParam fuelTradeInitParam);

    private static native long createOrderNative(long j, ITradeControlImpl iTradeControlImpl, int i);

    private static native long createPaymentNative(long j, ITradeControlImpl iTradeControlImpl, int i);

    private static native void destroyCouponNative(long j, ITradeControlImpl iTradeControlImpl, long j2, ITradeCouponImpl iTradeCouponImpl);

    private static native void destroyNativeObj(long j);

    private static native void destroyOrderNative(long j, ITradeControlImpl iTradeControlImpl, long j2, ITradeOrderImpl iTradeOrderImpl);

    private static native void destroyPaymentNative(long j, ITradeControlImpl iTradeControlImpl, long j2, ITradePaymentImpl iTradePaymentImpl);

    private static native void destroyTradeNative(long j, ITradeControlImpl iTradeControlImpl, long j2, ITradeImpl iTradeImpl);

    public ITradeControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITradeControlImpl) && getUID(this) == getUID((ITradeControlImpl) obj);
    }

    private static long getUID(ITradeControlImpl iTradeControlImpl) {
        long cPtr = getCPtr(iTradeControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITradeControlImpl iTradeControlImpl) {
        if (iTradeControlImpl == null) {
            return 0L;
        }
        return iTradeControlImpl.swigCPtr;
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

    public ITradeOrderImpl createOrder(@InformationBizType.InformationBizType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createOrderNative = createOrderNative(j, this, i);
        if (createOrderNative == 0) {
            return null;
        }
        return new ITradeOrderImpl(createOrderNative, false);
    }

    public ITradeCouponImpl createCoupon(@InformationBizType.InformationBizType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createCouponNative = createCouponNative(j, this, i);
        if (createCouponNative == 0) {
            return null;
        }
        return new ITradeCouponImpl(createCouponNative, false);
    }

    public ITradePaymentImpl createPayment(@InformationBizType.InformationBizType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createPaymentNative = createPaymentNative(j, this, i);
        if (createPaymentNative == 0) {
            return null;
        }
        return new ITradePaymentImpl(createPaymentNative, false);
    }

    public IDiningTradeImpl createDiningTrade(DiningTradeInitParam diningTradeInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createDiningTradeNative = createDiningTradeNative(j, this, 0L, diningTradeInitParam);
        if (createDiningTradeNative == 0) {
            return null;
        }
        return new IDiningTradeImpl(createDiningTradeNative, false);
    }

    public IFuelTradeImpl createFuelTrade(FuelTradeInitParam fuelTradeInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createFuelTradeNative = createFuelTradeNative(j, this, 0L, fuelTradeInitParam);
        if (createFuelTradeNative == 0) {
            return null;
        }
        return new IFuelTradeImpl(createFuelTradeNative, false);
    }

    public void destroyOrder(ITradeOrderImpl iTradeOrderImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyOrderNative(j, this, ITradeOrderImpl.getCPtr(iTradeOrderImpl), iTradeOrderImpl);
    }

    public void destroyCoupon(ITradeCouponImpl iTradeCouponImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyCouponNative(j, this, ITradeCouponImpl.getCPtr(iTradeCouponImpl), iTradeCouponImpl);
    }

    public void destroyPayment(ITradePaymentImpl iTradePaymentImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyPaymentNative(j, this, ITradePaymentImpl.getCPtr(iTradePaymentImpl), iTradePaymentImpl);
    }

    public void destroyTrade(ITradeImpl iTradeImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyTradeNative(j, this, ITradeImpl.getCPtr(iTradeImpl), iTradeImpl);
    }
}
