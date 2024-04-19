package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.GraspRoadResult;
import com.autonavi.gbl.pos.router.PosGraspRoadResultObserverRouter;
@IntfAuto(target = PosGraspRoadResultObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosGraspRoadResultObserver {
    void onGraspRoadResult(GraspRoadResult graspRoadResult);
}
