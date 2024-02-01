package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiDetailSearchResult;
import com.autonavi.gbl.search.router.PoiDetailSearchObserverRouter;
@IntfAuto(target = PoiDetailSearchObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPoiDetailSearchObserver {
    void onGetPoiDetailResult(int i, int i2, PoiDetailSearchResult poiDetailSearchResult);
}
