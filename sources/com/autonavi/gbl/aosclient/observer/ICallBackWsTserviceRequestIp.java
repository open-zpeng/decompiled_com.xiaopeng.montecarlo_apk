package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceRequestIpResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceRequestIpRouter;
@IntfAuto(target = CallBackWsTserviceRequestIpRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceRequestIp {
    void onRecvAck(GWsTserviceRequestIpResponseParam gWsTserviceRequestIpResponseParam);
}
