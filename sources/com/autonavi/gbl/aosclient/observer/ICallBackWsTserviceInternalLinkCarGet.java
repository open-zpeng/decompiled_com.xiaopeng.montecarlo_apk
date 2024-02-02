package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarGetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarGetRouter;
@IntfAuto(target = CallBackWsTserviceInternalLinkCarGetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceInternalLinkCarGet {
    void onRecvAck(GWsTserviceInternalLinkCarGetResponseParam gWsTserviceInternalLinkCarGetResponseParam);
}
