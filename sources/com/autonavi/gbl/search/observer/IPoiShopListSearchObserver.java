package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.PoiShopListSearchResult;
import com.autonavi.gbl.search.router.PoiShopListSearchObserverRouter;
@IntfAuto(target = PoiShopListSearchObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPoiShopListSearchObserver {
    void onGetPoiShopListResult(int i, int i2, PoiShopListSearchResult poiShopListSearchResult);
}
