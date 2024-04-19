package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsCommerceInfraChargeRecordsWaitingEnableResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter;
@IntfAuto(target = CallBackWsCommerceInfraChargeRecordsWaitingEnableRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsCommerceInfraChargeRecordsWaitingEnable {
    void onRecvAck(GWsCommerceInfraChargeRecordsWaitingEnableResponseParam gWsCommerceInfraChargeRecordsWaitingEnableResponseParam);
}
