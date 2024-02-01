package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.CancelOrderObserverRouter;
import com.autonavi.gbl.information.trade.model.OrderCancelResult;
@IntfAuto(target = CancelOrderObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICancelOrderObserver {
    void onResult(OrderCancelResult orderCancelResult);
}
