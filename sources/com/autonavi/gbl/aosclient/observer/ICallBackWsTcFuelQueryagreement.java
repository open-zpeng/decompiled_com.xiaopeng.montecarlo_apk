package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelQueryagreementResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcFuelQueryagreementRouter;
@IntfAuto(target = CallBackWsTcFuelQueryagreementRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcFuelQueryagreement {
    void onRecvAck(GWsTcFuelQueryagreementResponseParam gWsTcFuelQueryagreementResponseParam);
}
