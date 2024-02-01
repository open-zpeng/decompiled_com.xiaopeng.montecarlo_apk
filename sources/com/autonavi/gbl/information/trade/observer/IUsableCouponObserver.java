package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.UsableCouponObserverRouter;
import com.autonavi.gbl.information.trade.model.UsableCouponResult;
@IntfAuto(target = UsableCouponObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IUsableCouponObserver {
    void onResult(UsableCouponResult usableCouponResult);
}
