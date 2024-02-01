package com.autonavi.gbl.information.trade.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.router.AgreementStatusObserverRouter;
import com.autonavi.gbl.information.trade.model.AgreementStatusResult;
@IntfAuto(target = AgreementStatusObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IAgreementStatusObserver {
    void onResult(AgreementStatusResult agreementStatusResult);
}
