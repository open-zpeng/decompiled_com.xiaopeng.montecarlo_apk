package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceProvisionResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAuthcarServiceProvisionRouter;
@IntfAuto(target = CallBackWsAuthcarServiceProvisionRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAuthcarServiceProvision {
    void onRecvAck(GWsAuthcarServiceProvisionResponseParam gWsAuthcarServiceProvisionResponseParam);
}
