package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.ObtainedCouponObserverRouter;
import com.autonavi.gbl.information.trade.model.ObtainedCouponResult;
@IntfAuto(target = ObtainedCouponObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IObtainedCouponObserver {
    void onResult(ObtainedCouponResult obtainedCouponResult);
}
