package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAuthcarTokenRouter;
@IntfAuto(target = CallBackWsAuthcarTokenRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAuthcarToken {
    void onRecvAck(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam);
}
