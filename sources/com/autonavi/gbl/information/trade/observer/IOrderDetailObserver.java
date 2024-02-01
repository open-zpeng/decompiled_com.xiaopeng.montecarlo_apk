package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.OrderDetailObserverRouter;
import com.autonavi.gbl.information.trade.model.OrderDetailResult;
@IntfAuto(target = OrderDetailObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IOrderDetailObserver {
    void onResult(OrderDetailResult orderDetailResult);
}
