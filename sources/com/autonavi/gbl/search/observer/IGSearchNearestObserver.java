package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.autonavi.gbl.search.router.GSearchNearestObserverRouter;
@IntfAuto(target = GSearchNearestObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchNearestObserver {
    void onGetNearestResult(int i, int i2, SearchNearestResult searchNearestResult);
}
