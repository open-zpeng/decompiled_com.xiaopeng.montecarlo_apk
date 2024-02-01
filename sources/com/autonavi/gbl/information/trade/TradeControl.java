package com.autonavi.gbl.information.trade;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.model.InformationBizType;
import com.autonavi.gbl.information.trade.impl.IDiningTradeImpl;
import com.autonavi.gbl.information.trade.impl.IFuelTradeImpl;
import com.autonavi.gbl.information.trade.impl.ITradeControlImpl;
import com.autonavi.gbl.information.trade.impl.ITradeCouponImpl;
import com.autonavi.gbl.information.trade.impl.ITradeImpl;
import com.autonavi.gbl.information.trade.impl.ITradeOrderImpl;
import com.autonavi.gbl.information.trade.impl.ITradePaymentImpl;
import com.autonavi.gbl.information.trade.model.DiningTradeInitParam;
import com.autonavi.gbl.information.trade.model.FuelTradeInitParam;
import java.lang.reflect.Method;
@IntfAuto(target = ITradeControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TradeControl {
    private static String PACKAGE = ReflexTool.PN(TradeControl.class);
    private ITradeControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected TradeControl(long j, boolean z) {
        this(new ITradeControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TradeControl.class, this, this.mControl);
        }
    }

    public TradeControl(ITradeControlImpl iTradeControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTradeControlImpl);
    }

    private void $constructor(ITradeControlImpl iTradeControlImpl) {
        if (iTradeControlImpl != null) {
            this.mControl = iTradeControlImpl;
            this.mTargetId = String.format("TradeControl_%s_%d", String.valueOf(ITradeControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITradeControlImpl getControl() {
        return this.mControl;
    }

    public TradeOrder createOrder(@InformationBizType.InformationBizType1 int i) {
        ITradeOrderImpl createOrder;
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("createOrder", Integer.TYPE);
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl == null || (createOrder = iTradeControlImpl.createOrder(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradeOrder) typeHelper.transfer(method, -1, (Object) createOrder, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TradeCoupon createCoupon(@InformationBizType.InformationBizType1 int i) {
        ITradeCouponImpl createCoupon;
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("createCoupon", Integer.TYPE);
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl == null || (createCoupon = iTradeControlImpl.createCoupon(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradeCoupon) typeHelper.transfer(method, -1, (Object) createCoupon, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public TradePayment createPayment(@InformationBizType.InformationBizType1 int i) {
        ITradePaymentImpl createPayment;
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("createPayment", Integer.TYPE);
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl == null || (createPayment = iTradeControlImpl.createPayment(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradePayment) typeHelper.transfer(method, -1, (Object) createPayment, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public DiningTrade createDiningTrade(DiningTradeInitParam diningTradeInitParam) {
        IDiningTradeImpl createDiningTrade;
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("createDiningTrade", DiningTradeInitParam.class);
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl == null || (createDiningTrade = iTradeControlImpl.createDiningTrade(diningTradeInitParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (DiningTrade) typeHelper.transfer(method, -1, (Object) createDiningTrade, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public FuelTrade createFuelTrade(FuelTradeInitParam fuelTradeInitParam) {
        IFuelTradeImpl createFuelTrade;
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("createFuelTrade", FuelTradeInitParam.class);
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl == null || (createFuelTrade = iTradeControlImpl.createFuelTrade(fuelTradeInitParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (FuelTrade) typeHelper.transfer(method, -1, (Object) createFuelTrade, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void destroyOrder(TradeOrder tradeOrder) {
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("destroyOrder", TradeOrder.class);
            ITradeOrderImpl iTradeOrderImpl = null;
            if (tradeOrder != null && (typeHelper = this.mTypeHelper) != null) {
                iTradeOrderImpl = (ITradeOrderImpl) typeHelper.transfer(method, 0, tradeOrder);
            }
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl != null) {
                iTradeControlImpl.destroyOrder(iTradeOrderImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void destroyCoupon(TradeCoupon tradeCoupon) {
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("destroyCoupon", TradeCoupon.class);
            ITradeCouponImpl iTradeCouponImpl = null;
            if (tradeCoupon != null && (typeHelper = this.mTypeHelper) != null) {
                iTradeCouponImpl = (ITradeCouponImpl) typeHelper.transfer(method, 0, tradeCoupon);
            }
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl != null) {
                iTradeControlImpl.destroyCoupon(iTradeCouponImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void destroyPayment(TradePayment tradePayment) {
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("destroyPayment", TradePayment.class);
            ITradePaymentImpl iTradePaymentImpl = null;
            if (tradePayment != null && (typeHelper = this.mTypeHelper) != null) {
                iTradePaymentImpl = (ITradePaymentImpl) typeHelper.transfer(method, 0, tradePayment);
            }
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl != null) {
                iTradeControlImpl.destroyPayment(iTradePaymentImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void destroyTrade(Trade trade) {
        TypeHelper typeHelper;
        try {
            Method method = TradeControl.class.getMethod("destroyTrade", Trade.class);
            ITradeImpl iTradeImpl = null;
            if (trade != null && (typeHelper = this.mTypeHelper) != null) {
                iTradeImpl = (ITradeImpl) typeHelper.transfer(method, 0, trade);
            }
            ITradeControlImpl iTradeControlImpl = this.mControl;
            if (iTradeControlImpl != null) {
                iTradeControlImpl.destroyTrade(iTradeImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
