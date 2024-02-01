package com.autonavi.gbl.multi.display.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.router.RemoteDisplayObserverRouter;
@IntfAuto(target = RemoteDisplayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRemoteDisplayObserver {
    default void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
    }

    default void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2) {
    }
}
