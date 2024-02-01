package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.pos.router.PosParallelRoadObserverRouter;
@IntfAuto(target = PosParallelRoadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosParallelRoadObserver {
    void onParallelRoadUpdate(LocParallelRoadInfo locParallelRoadInfo);
}
