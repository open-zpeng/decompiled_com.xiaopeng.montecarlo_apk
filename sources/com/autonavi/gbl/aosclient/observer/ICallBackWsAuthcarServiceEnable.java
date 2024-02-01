package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServiceEnableResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAuthcarServiceEnableRouter;
@IntfAuto(target = CallBackWsAuthcarServiceEnableRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAuthcarServiceEnable {
    void onRecvAck(GWsAuthcarServiceEnableResponseParam gWsAuthcarServiceEnableResponseParam);
}
