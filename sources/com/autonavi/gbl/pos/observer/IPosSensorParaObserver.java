package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.router.PosSensorParaObserverRouter;
@IntfAuto(target = PosSensorParaObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosSensorParaObserver {
    void onSensorParaUpdate(String str);
}
