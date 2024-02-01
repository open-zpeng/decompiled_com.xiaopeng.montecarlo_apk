package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.ObtainableCouponObserverRouter;
import com.autonavi.gbl.information.trade.model.ObtainableCouponResult;
@IntfAuto(target = ObtainableCouponObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IObtainableCouponObserver {
    void onResult(ObtainableCouponResult obtainableCouponResult);
}
