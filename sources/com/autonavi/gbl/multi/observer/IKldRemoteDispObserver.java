package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.router.KldRemoteDispObserverRouter;
@IntfAuto(target = KldRemoteDispObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKldRemoteDispObserver {
    void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2);

    void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2);
}
