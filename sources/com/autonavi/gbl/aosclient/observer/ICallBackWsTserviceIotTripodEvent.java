package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodEventResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodEventRouter;
@IntfAuto(target = CallBackWsTserviceIotTripodEventRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceIotTripodEvent {
    void onRecvAck(GWsTserviceIotTripodEventResponseParam gWsTserviceIotTripodEventResponseParam);
}
