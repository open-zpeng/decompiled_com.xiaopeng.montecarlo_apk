package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.router.LaneMockObserverRouter;
@IntfAuto(target = LaneMockObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneMockObserver {
    void onLaneMockFinish();
}
