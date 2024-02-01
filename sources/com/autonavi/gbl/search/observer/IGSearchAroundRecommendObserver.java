package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.router.GSearchAroundRecommendObserverRouter;
@IntfAuto(target = GSearchAroundRecommendObserverRouter.class, type = BuildType.JINTF)
@Deprecated
/* loaded from: classes2.dex */
public interface IGSearchAroundRecommendObserver {
    void onGetAroundRecommendResult(int i, int i2, SearchAroundRecommendResult searchAroundRecommendResult);
}
