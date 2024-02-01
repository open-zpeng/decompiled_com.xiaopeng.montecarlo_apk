package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.FuelTradeObserverRouter;
import com.autonavi.gbl.information.trade.model.FuelOrderDetailResult;
import com.autonavi.gbl.information.trade.model.FuelTradePriceResult;
import com.autonavi.gbl.information.trade.model.FuelTradeSubmitResult;
@IntfAuto(target = FuelTradeObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IFuelTradeObserver {
    default void onResult(FuelOrderDetailResult fuelOrderDetailResult) {
    }

    default void onResult(FuelTradePriceResult fuelTradePriceResult) {
    }

    default void onResult(FuelTradeSubmitResult fuelTradeSubmitResult) {
    }
}
