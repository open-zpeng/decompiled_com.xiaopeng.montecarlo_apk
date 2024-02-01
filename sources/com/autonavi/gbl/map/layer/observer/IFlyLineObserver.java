package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.router.FlyLineObserverRouter;
@IntfAuto(target = FlyLineObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IFlyLineObserver {
    default void onEndChange(Coord3DDouble coord3DDouble) {
    }

    default void onFlyLineClick(Coord3DDouble coord3DDouble) {
    }

    default void onStartChange(Coord3DDouble coord3DDouble) {
    }
}
