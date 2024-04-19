package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.autonavi.gbl.search.router.GSearchKeyWordObserverRouter;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = GSearchKeyWordObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchKeyWordObserver {
    void onGetKeyWordResult(int i, @EGErr.EGErr1 int i2, SearchKeywordResult searchKeywordResult);
}
