package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.DrInfo;
import com.autonavi.gbl.pos.router.PosDrInfoObserverRouter;
@IntfAuto(target = PosDrInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPosDrInfoObserver {
    void onDrInfoUpdate(DrInfo drInfo);
}
