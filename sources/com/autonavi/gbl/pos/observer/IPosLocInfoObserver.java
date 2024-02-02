package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.router.PosLocInfoObserverRouter;
@IntfAuto(target = PosLocInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosLocInfoObserver {
    void onLocInfoUpdate(LocInfo locInfo);
}
