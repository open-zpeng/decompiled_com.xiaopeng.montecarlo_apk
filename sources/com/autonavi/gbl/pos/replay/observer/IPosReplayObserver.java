package com.autonavi.gbl.pos.replay.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.replay.model.PosReplayStatus;
import com.autonavi.gbl.pos.router.PosReplayObserverRouter;
@IntfAuto(target = PosReplayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosReplayObserver {
    default void onGpsReplayStatusUpdate(@PosReplayStatus.PosReplayStatus1 int i) {
    }

    default void onLocSignDataUpdate(LocSignData locSignData) {
    }
}
