package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.DiningTradeObserverRouter;
import com.autonavi.gbl.information.trade.model.DiningTradePriceResult;
import com.autonavi.gbl.information.trade.model.DiningTradeSubmitResult;
@IntfAuto(target = DiningTradeObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IDiningTradeObserver {
    default void onResult(DiningTradePriceResult diningTradePriceResult) {
    }

    default void onResult(DiningTradeSubmitResult diningTradeSubmitResult) {
    }
}
