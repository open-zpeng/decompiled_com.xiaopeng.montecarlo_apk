package com.autonavi.gbl.user.forcast.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedData;
import com.autonavi.gbl.user.router.ForcastServiceObserverRouter;
@IntfAuto(target = ForcastServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IForcastServiceObserver {
    default void onForcastArrivedData(ForcastArrivedData forcastArrivedData) {
    }

    default void onInit(int i) {
    }

    default void onSetLoginInfo(int i) {
    }
}
