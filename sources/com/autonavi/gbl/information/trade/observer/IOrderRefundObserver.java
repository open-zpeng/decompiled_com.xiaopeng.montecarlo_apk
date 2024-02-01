package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.OrderRefundObserverRouter;
import com.autonavi.gbl.information.trade.model.OrderRefundDetailResult;
import com.autonavi.gbl.information.trade.model.OrderRefundPageResult;
import com.autonavi.gbl.information.trade.model.OrderRefundSubmitResult;
@IntfAuto(target = OrderRefundObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IOrderRefundObserver {
    default void onResult(OrderRefundDetailResult orderRefundDetailResult) {
    }

    default void onResult(OrderRefundPageResult orderRefundPageResult) {
    }

    default void onResult(OrderRefundSubmitResult orderRefundSubmitResult) {
    }
}
