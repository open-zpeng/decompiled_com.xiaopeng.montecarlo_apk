package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.gbl.information.trade.model.AgreementStatusResult;
import com.autonavi.gbl.information.trade.model.DiningTradePriceResult;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmitResult;
import com.autonavi.gbl.information.trade.model.FuelOrderDetailResult;
import com.autonavi.gbl.information.trade.model.FuelTradePriceResult;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmitResult;
import com.autonavi.gbl.information.trade.model.ObtainCouponResult;
import com.autonavi.gbl.information.trade.model.ObtainableCouponResult;
import com.autonavi.gbl.information.trade.model.ObtainedCouponResult;
import com.autonavi.gbl.information.trade.model.OrderCancelResult;
import com.autonavi.gbl.information.trade.model.OrderDetailResult;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailResult;
import com.autonavi.gbl.information.trade.model.OrderRefundPageResult;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitResult;
import com.autonavi.gbl.information.trade.model.OrderWaitingResult;
import com.autonavi.gbl.information.trade.model.UsableCouponResult;
/* loaded from: classes.dex */
public class InformationTradeObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IObtainableCouponObserverImpl_onResult(IObtainableCouponObserverImpl iObtainableCouponObserverImpl, ObtainableCouponResult obtainableCouponResult) {
        iObtainableCouponObserverImpl.onResult(obtainableCouponResult);
    }

    public static void SwigDirector_IObtainCouponObserverImpl_onResult(IObtainCouponObserverImpl iObtainCouponObserverImpl, ObtainCouponResult obtainCouponResult) {
        iObtainCouponObserverImpl.onResult(obtainCouponResult);
    }

    public static void SwigDirector_IUsableCouponObserverImpl_onResult(IUsableCouponObserverImpl iUsableCouponObserverImpl, UsableCouponResult usableCouponResult) {
        iUsableCouponObserverImpl.onResult(usableCouponResult);
    }

    public static void SwigDirector_IObtainedCouponObserverImpl_onResult(IObtainedCouponObserverImpl iObtainedCouponObserverImpl, ObtainedCouponResult obtainedCouponResult) {
        iObtainedCouponObserverImpl.onResult(obtainedCouponResult);
    }

    public static void SwigDirector_IAgreementStatusObserverImpl_onResult(IAgreementStatusObserverImpl iAgreementStatusObserverImpl, AgreementStatusResult agreementStatusResult) {
        iAgreementStatusObserverImpl.onResult(agreementStatusResult);
    }

    public static void SwigDirector_IWaitingOrderObserverImpl_onResult(IWaitingOrderObserverImpl iWaitingOrderObserverImpl, OrderWaitingResult orderWaitingResult) {
        iWaitingOrderObserverImpl.onResult(orderWaitingResult);
    }

    public static void SwigDirector_ICancelOrderObserverImpl_onResult(ICancelOrderObserverImpl iCancelOrderObserverImpl, OrderCancelResult orderCancelResult) {
        iCancelOrderObserverImpl.onResult(orderCancelResult);
    }

    public static void SwigDirector_IOrderDetailObserverImpl_onResult(IOrderDetailObserverImpl iOrderDetailObserverImpl, OrderDetailResult orderDetailResult) {
        iOrderDetailObserverImpl.onResult(orderDetailResult);
    }

    public static void SwigDirector_IOrderRefundObserverImpl_onResult__SWIG_0(IOrderRefundObserverImpl iOrderRefundObserverImpl, OrderRefundPageResult orderRefundPageResult) {
        iOrderRefundObserverImpl.onResult(orderRefundPageResult);
    }

    public static void SwigDirector_IOrderRefundObserverImpl_onResult__SWIG_1(IOrderRefundObserverImpl iOrderRefundObserverImpl, OrderRefundSubmitResult orderRefundSubmitResult) {
        iOrderRefundObserverImpl.onResult(orderRefundSubmitResult);
    }

    public static void SwigDirector_IOrderRefundObserverImpl_onResult__SWIG_2(IOrderRefundObserverImpl iOrderRefundObserverImpl, OrderRefundDetailResult orderRefundDetailResult) {
        iOrderRefundObserverImpl.onResult(orderRefundDetailResult);
    }

    public static void SwigDirector_IDiningTradeObserverImpl_onResult__SWIG_0(IDiningTradeObserverImpl iDiningTradeObserverImpl, DiningTradePriceResult diningTradePriceResult) {
        iDiningTradeObserverImpl.onResult(diningTradePriceResult);
    }

    public static void SwigDirector_IDiningTradeObserverImpl_onResult__SWIG_1(IDiningTradeObserverImpl iDiningTradeObserverImpl, DiningTradeSubmitResult diningTradeSubmitResult) {
        iDiningTradeObserverImpl.onResult(diningTradeSubmitResult);
    }

    public static void SwigDirector_IFuelTradeObserverImpl_onResult__SWIG_0(IFuelTradeObserverImpl iFuelTradeObserverImpl, FuelTradePriceResult fuelTradePriceResult) {
        iFuelTradeObserverImpl.onResult(fuelTradePriceResult);
    }

    public static void SwigDirector_IFuelTradeObserverImpl_onResult__SWIG_1(IFuelTradeObserverImpl iFuelTradeObserverImpl, FuelTradeSubmitResult fuelTradeSubmitResult) {
        iFuelTradeObserverImpl.onResult(fuelTradeSubmitResult);
    }

    public static void SwigDirector_IFuelTradeObserverImpl_onResult__SWIG_2(IFuelTradeObserverImpl iFuelTradeObserverImpl, FuelOrderDetailResult fuelOrderDetailResult) {
        iFuelTradeObserverImpl.onResult(fuelOrderDetailResult);
    }
}
