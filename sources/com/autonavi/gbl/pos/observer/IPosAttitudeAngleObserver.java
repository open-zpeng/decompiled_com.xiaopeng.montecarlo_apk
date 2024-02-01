package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.RawAttitudeAngle;
import com.autonavi.gbl.pos.router.PosAttitudeAngleObserverRouter;
@IntfAuto(target = PosAttitudeAngleObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosAttitudeAngleObserver {
    void onAttitudeAngleUpdate(RawAttitudeAngle rawAttitudeAngle);
}
