package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiCmallDetailSearchResult;
import com.autonavi.gbl.search.router.PoiCmallDetailSearchObserverRouter;
@IntfAuto(target = PoiCmallDetailSearchObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPoiCmallDetailSearchObserver {
    void onGetPoiCmallDetailResult(int i, int i2, PoiCmallDetailSearchResult poiCmallDetailSearchResult);
}
