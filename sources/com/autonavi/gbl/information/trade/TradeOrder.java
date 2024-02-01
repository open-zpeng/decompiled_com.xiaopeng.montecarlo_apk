package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.ITradeOrderImpl;
import com.autonavi.gbl.information.trade.model.OrderCancelRequest;
import com.autonavi.gbl.information.trade.model.OrderDetailRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundPageRequest;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitRequest;
import com.autonavi.gbl.information.trade.model.OrderWaitingRequest;
import com.autonavi.gbl.information.trade.observer.ICancelOrderObserver;
import com.autonavi.gbl.information.trade.observer.IOrderDetailObserver;
import com.autonavi.gbl.information.trade.observer.IOrderRefundObserver;
import com.autonavi.gbl.information.trade.observer.IWaitingOrderObserver;
import com.autonavi.gbl.information.trade.observer.impl.ICancelOrderObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IOrderDetailObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IOrderRefundObserverImpl;
import com.autonavi.gbl.information.trade.observer.impl.IWaitingOrderObserverImpl;
import com.autonavi.gbl.util.model.TaskResult;
import com.lzy.okgo.model.Progress;
@IntfAuto(target = ITradeOrderImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TradeOrder {
    private static String PACKAGE = ReflexTool.PN(TradeOrder.class);
    private ITradeOrderImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected TradeOrder(long j, boolean z) {
        this(new ITradeOrderImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TradeOrder.class, this, this.mControl);
        }
    }

    public TradeOrder(ITradeOrderImpl iTradeOrderImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTradeOrderImpl);
    }

    private void $constructor(ITradeOrderImpl iTradeOrderImpl) {
        if (iTradeOrderImpl != null) {
            this.mControl = iTradeOrderImpl;
            this.mTargetId = String.format("TradeOrder_%s_%d", String.valueOf(ITradeOrderImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITradeOrderImpl getControl() {
        return this.mControl;
    }

    public TaskResult request(OrderWaitingRequest orderWaitingRequest, IWaitingOrderObserver iWaitingOrderObserver) {
        TypeHelper typeHelper;
        try {
            IWaitingOrderObserverImpl iWaitingOrderObserverImpl = (iWaitingOrderObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IWaitingOrderObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderWaitingRequest.class, IWaitingOrderObserver.class), 1, iWaitingOrderObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderWaitingRequest, iWaitingOrderObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(OrderCancelRequest orderCancelRequest, ICancelOrderObserver iCancelOrderObserver) {
        TypeHelper typeHelper;
        try {
            ICancelOrderObserverImpl iCancelOrderObserverImpl = (iCancelOrderObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (ICancelOrderObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderCancelRequest.class, ICancelOrderObserver.class), 1, iCancelOrderObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderCancelRequest, iCancelOrderObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(OrderDetailRequest orderDetailRequest, IOrderDetailObserver iOrderDetailObserver) {
        TypeHelper typeHelper;
        try {
            IOrderDetailObserverImpl iOrderDetailObserverImpl = (iOrderDetailObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IOrderDetailObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderDetailRequest.class, IOrderDetailObserver.class), 1, iOrderDetailObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderDetailRequest, iOrderDetailObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(OrderRefundPageRequest orderRefundPageRequest, IOrderRefundObserver iOrderRefundObserver) {
        TypeHelper typeHelper;
        try {
            IOrderRefundObserverImpl iOrderRefundObserverImpl = (iOrderRefundObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IOrderRefundObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderRefundPageRequest.class, IOrderRefundObserver.class), 1, iOrderRefundObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderRefundPageRequest, iOrderRefundObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(OrderRefundSubmitRequest orderRefundSubmitRequest, IOrderRefundObserver iOrderRefundObserver) {
        TypeHelper typeHelper;
        try {
            IOrderRefundObserverImpl iOrderRefundObserverImpl = (iOrderRefundObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IOrderRefundObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderRefundSubmitRequest.class, IOrderRefundObserver.class), 1, iOrderRefundObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderRefundSubmitRequest, iOrderRefundObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TaskResult request(OrderRefundDetailRequest orderRefundDetailRequest, IOrderRefundObserver iOrderRefundObserver) {
        TypeHelper typeHelper;
        try {
            IOrderRefundObserverImpl iOrderRefundObserverImpl = (iOrderRefundObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IOrderRefundObserverImpl) typeHelper.transfer(TradeOrder.class.getMethod(Progress.REQUEST, OrderRefundDetailRequest.class, IOrderRefundObserver.class), 1, iOrderRefundObserver);
            ITradeOrderImpl iTradeOrderImpl = this.mControl;
            if (iTradeOrderImpl != null) {
                return iTradeOrderImpl.request(orderRefundDetailRequest, iOrderRefundObserverImpl);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void abort(long j) {
        ITradeOrderImpl iTradeOrderImpl = this.mControl;
        if (iTradeOrderImpl != null) {
            iTradeOrderImpl.abort(j);
        }
    }

    public void abortAll() {
        ITradeOrderImpl iTradeOrderImpl = this.mControl;
        if (iTradeOrderImpl != null) {
            iTradeOrderImpl.abortAll();
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
