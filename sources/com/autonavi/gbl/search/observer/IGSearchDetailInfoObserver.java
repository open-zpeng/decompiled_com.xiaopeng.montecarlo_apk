package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.autonavi.gbl.search.router.GSearchDetailInfoObserverRouter;
@IntfAuto(target = GSearchDetailInfoObserverRouter.class, type = BuildType.JINTF)
@Deprecated
/* loaded from: classes2.dex */
public interface IGSearchDetailInfoObserver {
    void onGetDetailInfoResult(int i, int i2, SearchDetailInfoResult searchDetailInfoResult);
}
