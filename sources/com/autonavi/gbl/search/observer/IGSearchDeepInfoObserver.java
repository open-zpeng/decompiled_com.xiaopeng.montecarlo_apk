package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.autonavi.gbl.search.router.GSearchDeepInfoObserverRouter;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = GSearchDeepInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchDeepInfoObserver {
    void onGetDeepInfoResult(int i, @EGErr.EGErr1 int i2, SearchDeepInfoResult searchDeepInfoResult);
}
