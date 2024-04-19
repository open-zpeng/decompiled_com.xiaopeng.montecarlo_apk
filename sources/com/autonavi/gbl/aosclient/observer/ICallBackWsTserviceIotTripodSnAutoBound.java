package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBoundResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodSnAutoBoundRouter;
@IntfAuto(target = CallBackWsTserviceIotTripodSnAutoBoundRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceIotTripodSnAutoBound {
    void onRecvAck(GWsTserviceIotTripodSnAutoBoundResponseParam gWsTserviceIotTripodSnAutoBoundResponseParam);
}
