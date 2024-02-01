package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchLineDeepInfoResult;
import com.autonavi.gbl.search.router.GSearchLineDeepInfoObserverRouter;
@IntfAuto(target = GSearchLineDeepInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchLineDeepInfoObserver {
    void onGetLineDeepInfoResult(int i, int i2, SearchLineDeepInfoResult searchLineDeepInfoResult);
}
