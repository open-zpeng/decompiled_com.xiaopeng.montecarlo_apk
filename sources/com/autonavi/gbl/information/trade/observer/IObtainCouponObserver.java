package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.ObtainCouponObserverRouter;
import com.autonavi.gbl.information.trade.model.ObtainCouponResult;
@IntfAuto(target = ObtainCouponObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IObtainCouponObserver {
    void onResult(ObtainCouponResult obtainCouponResult);
}
