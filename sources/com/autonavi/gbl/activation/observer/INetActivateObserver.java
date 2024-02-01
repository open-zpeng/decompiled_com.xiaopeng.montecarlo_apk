package com.autonavi.gbl.activation.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.activation.router.NetActivateObserverRouter;
@IntfAuto(target = NetActivateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface INetActivateObserver {
    void onNetActivateResponse(int i);
}
