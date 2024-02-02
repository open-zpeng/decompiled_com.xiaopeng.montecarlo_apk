package com.autonavi.gbl.search.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchChargingLiveStatusResult;
import com.autonavi.gbl.search.router.GSearchChargingLiveStatusObserverRouter;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = GSearchChargingLiveStatusObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGSearchChargingLiveStatusObserver {
    void onGetChargingLiveStatusResult(int i, @EGErr.EGErr1 int i2, SearchChargingLiveStatusResult searchChargingLiveStatusResult);
}
