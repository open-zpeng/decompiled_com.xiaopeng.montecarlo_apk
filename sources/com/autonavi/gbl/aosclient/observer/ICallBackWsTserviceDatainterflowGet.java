package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceDatainterflowGetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceDatainterflowGetRouter;
@IntfAuto(target = CallBackWsTserviceDatainterflowGetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceDatainterflowGet {
    void onRecvAck(GWsTserviceDatainterflowGetResponseParam gWsTserviceDatainterflowGetResponseParam);
}
