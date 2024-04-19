package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.autonavi.gbl.search.router.GSearchAlongWayObserverRouter;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = GSearchAlongWayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchAlongWayObserver {
    void onGetAlongWayResult(int i, @EGErr.EGErr1 int i2, SearchAlongWayResult searchAlongWayResult);
}
