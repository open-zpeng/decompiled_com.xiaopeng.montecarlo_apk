package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchNaviInfoResult;
import com.autonavi.gbl.search.router.GSearchNaviInfoObserverRouter;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = GSearchNaviInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchNaviInfoObserver {
    void onGetNaviInfoResult(int i, @EGErr.EGErr1 int i2, SearchNaviInfoResult searchNaviInfoResult);
}
