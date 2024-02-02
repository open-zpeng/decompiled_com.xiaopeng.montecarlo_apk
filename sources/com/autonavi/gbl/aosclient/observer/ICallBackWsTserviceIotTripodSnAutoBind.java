package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodSnAutoBindRouter;
@IntfAuto(target = CallBackWsTserviceIotTripodSnAutoBindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceIotTripodSnAutoBind {
    void onRecvAck(GWsTserviceIotTripodSnAutoBindResponseParam gWsTserviceIotTripodSnAutoBindResponseParam);
}
