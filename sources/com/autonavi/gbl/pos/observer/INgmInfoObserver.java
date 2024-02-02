package com.autonavi.gbl.pos.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.NgmDiff;
import com.autonavi.gbl.pos.router.NgmInfoObserverRouter;
@IntfAuto(target = NgmInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface INgmInfoObserver {
    void onNgmInfoUpdate(NgmDiff ngmDiff);
}
