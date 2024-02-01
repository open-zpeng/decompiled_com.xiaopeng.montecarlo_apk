package com.autonavi.gbl.information.nearby.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendResult;
import com.autonavi.gbl.information.router.NearbyRecommendObserverRouter;
@IntfAuto(target = NearbyRecommendObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface INearbyRecommendObserver {
    void onResult(int i, NearbyRecommendResult nearbyRecommendResult);
}
