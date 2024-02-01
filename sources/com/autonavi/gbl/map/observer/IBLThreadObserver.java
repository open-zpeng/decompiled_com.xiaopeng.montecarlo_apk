package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.BLThreadObserverRouter;
@IntfAuto(target = BLThreadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBLThreadObserver {
    void threadCallback(long j, byte b);
}
