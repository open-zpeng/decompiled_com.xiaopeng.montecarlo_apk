package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.router.CarObserverRouter;
@IntfAuto(target = CarObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICarObserver {
    default void onCarClick(CarLoc carLoc) {
    }

    default void onCarLocChange(CarLoc carLoc) {
    }
}
