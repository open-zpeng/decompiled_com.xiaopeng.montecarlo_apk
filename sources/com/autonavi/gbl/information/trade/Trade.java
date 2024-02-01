package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.impl.ITradeCouponImpl;
import com.autonavi.gbl.information.trade.impl.ITradeImpl;
import com.autonavi.gbl.information.trade.impl.ITradeOrderImpl;
import com.autonavi.gbl.information.trade.impl.ITradePaymentImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ITradeImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class Trade {
    private static String PACKAGE = ReflexTool.PN(Trade.class);
    private ITradeImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
    }

    protected Trade(long j, boolean z) {
        this(new ITradeImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(Trade.class, this, this.mControl);
        }
    }

    public Trade(ITradeImpl iTradeImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTradeImpl);
    }

    private void $constructor(ITradeImpl iTradeImpl) {
        if (iTradeImpl != null) {
            this.mControl = iTradeImpl;
            this.mTargetId = String.format("Trade_%s_%d", String.valueOf(ITradeImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITradeImpl getControl() {
        return this.mControl;
    }

    public TradeOrder getOrder() {
        ITradeOrderImpl order;
        TypeHelper typeHelper;
        try {
            Method method = Trade.class.getMethod("getOrder", new Class[0]);
            ITradeImpl iTradeImpl = this.mControl;
            if (iTradeImpl == null || (order = iTradeImpl.getOrder()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradeOrder) typeHelper.transfer(method, -1, (Object) order, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TradeCoupon getCoupon() {
        ITradeCouponImpl coupon;
        TypeHelper typeHelper;
        try {
            Method method = Trade.class.getMethod("getCoupon", new Class[0]);
            ITradeImpl iTradeImpl = this.mControl;
            if (iTradeImpl == null || (coupon = iTradeImpl.getCoupon()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradeCoupon) typeHelper.transfer(method, -1, (Object) coupon, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TradePayment getPayment() {
        ITradePaymentImpl payment;
        TypeHelper typeHelper;
        try {
            Method method = Trade.class.getMethod("getPayment", new Class[0]);
            ITradeImpl iTradeImpl = this.mControl;
            if (iTradeImpl == null || (payment = iTradeImpl.getPayment()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradePayment) typeHelper.transfer(method, -1, (Object) payment, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void abort() {
        ITradeImpl iTradeImpl = this.mControl;
        if (iTradeImpl != null) {
            iTradeImpl.abort();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
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
