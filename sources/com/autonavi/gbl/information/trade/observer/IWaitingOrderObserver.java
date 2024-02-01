package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.WaitingOrderObserverRouter;
import com.autonavi.gbl.information.trade.model.OrderWaitingResult;
@IntfAuto(target = WaitingOrderObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IWaitingOrderObserver {
    void onResult(OrderWaitingResult orderWaitingResult);
}
