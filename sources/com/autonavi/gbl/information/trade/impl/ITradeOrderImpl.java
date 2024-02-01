package com.autonavi.gbl.information.trade.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.TradeOrder;
import com.autonavi.gbl.information.trade.model.OrderCancelRequest;
import com.autonavi.gbl.information.trade.model.OrderDetailRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundPageRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitRequest;
import com.autonavi.gbl.information.trade.model.OrderWaitingRequest;
import com.autonavi.gbl.information.trade.observer.impl.ICancelOrderObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IOrderDetailObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IWaitingOrderObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
@IntfAuto(target = TradeOrder.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITradeOrderImpl {
    private static BindTable BIND_TABLE = new BindTable(ITradeOrderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortAllNative(long j, ITradeOrderImpl iTradeOrderImpl);

    private static native void abortNative(long j, ITradeOrderImpl iTradeOrderImpl, long j2);

    private static native void destroyNativeObj(long j);

    private static native TaskResult request1Native(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderCancelRequest orderCancelRequest, long j3, ICancelOrderObserverImpl iCancelOrderObserverImpl);

    private static native TaskResult request2Native(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderDetailRequest orderDetailRequest, long j3, IOrderDetailObserverImpl iOrderDetailObserverImpl);

    private static native TaskResult request3Native(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderRefundPageRequest orderRefundPageRequest, long j3, IOrderRefundObserverImpl iOrderRefundObserverImpl);

    private static native TaskResult request4Native(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderRefundSubmitRequest orderRefundSubmitRequest, long j3, IOrderRefundObserverImpl iOrderRefundObserverImpl);

    private static native TaskResult request5Native(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderRefundDetailRequest orderRefundDetailRequest, long j3, IOrderRefundObserverImpl iOrderRefundObserverImpl);

    private static native TaskResult requestNative(long j, ITradeOrderImpl iTradeOrderImpl, long j2, OrderWaitingRequest orderWaitingRequest, long j3, IWaitingOrderObserverImpl iWaitingOrderObserverImpl);

    public ITradeOrderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITradeOrderImpl) && getUID(this) == getUID((ITradeOrderImpl) obj);
    }

    private static long getUID(ITradeOrderImpl iTradeOrderImpl) {
        long cPtr = getCPtr(iTradeOrderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITradeOrderImpl iTradeOrderImpl) {
        if (iTradeOrderImpl == null) {
            return 0L;
        }
        return iTradeOrderImpl.swigCPtr;
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

    public TaskResult request(OrderWaitingRequest orderWaitingRequest, IWaitingOrderObserverImpl iWaitingOrderObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, orderWaitingRequest, IWaitingOrderObserverImpl.getCPtr(iWaitingOrderObserverImpl), iWaitingOrderObserverImpl);
    }

    public TaskResult request(OrderCancelRequest orderCancelRequest, ICancelOrderObserverImpl iCancelOrderObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request1Native(j, this, 0L, orderCancelRequest, ICancelOrderObserverImpl.getCPtr(iCancelOrderObserverImpl), iCancelOrderObserverImpl);
    }

    public TaskResult request(OrderDetailRequest orderDetailRequest, IOrderDetailObserverImpl iOrderDetailObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request2Native(j, this, 0L, orderDetailRequest, IOrderDetailObserverImpl.getCPtr(iOrderDetailObserverImpl), iOrderDetailObserverImpl);
    }

    public TaskResult request(OrderRefundPageRequest orderRefundPageRequest, IOrderRefundObserverImpl iOrderRefundObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request3Native(j, this, 0L, orderRefundPageRequest, IOrderRefundObserverImpl.getCPtr(iOrderRefundObserverImpl), iOrderRefundObserverImpl);
    }

    public TaskResult request(OrderRefundSubmitRequest orderRefundSubmitRequest, IOrderRefundObserverImpl iOrderRefundObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request4Native(j, this, 0L, orderRefundSubmitRequest, IOrderRefundObserverImpl.getCPtr(iOrderRefundObserverImpl), iOrderRefundObserverImpl);
    }

    public TaskResult request(OrderRefundDetailRequest orderRefundDetailRequest, IOrderRefundObserverImpl iOrderRefundObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return request5Native(j, this, 0L, orderRefundDetailRequest, IOrderRefundObserverImpl.getCPtr(iOrderRefundObserverImpl), iOrderRefundObserverImpl);
    }

    public void abort(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        abortNative(j2, this, j);
    }

    public void abortAll() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        abortAllNative(j, this);
    }
}
