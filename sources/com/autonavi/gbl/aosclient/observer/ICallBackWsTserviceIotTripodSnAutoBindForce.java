package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindForceResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodSnAutoBindForceRouter;
@IntfAuto(target = CallBackWsTserviceIotTripodSnAutoBindForceRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceIotTripodSnAutoBindForce {
    void onRecvAck(GWsTserviceIotTripodSnAutoBindForceResponseParam gWsTserviceIotTripodSnAutoBindForceResponseParam);
}
