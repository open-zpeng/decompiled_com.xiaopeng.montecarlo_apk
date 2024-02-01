package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GTripodCompanyResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackTripodCompanyRouter;
@IntfAuto(target = CallBackTripodCompanyRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackTripodCompany {
    void onRecvAck(GTripodCompanyResponseParam gTripodCompanyResponseParam);
}
