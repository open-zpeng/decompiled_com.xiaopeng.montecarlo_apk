package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GImGetLoginTokenResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackImGetLoginTokenRouter;
@IntfAuto(target = CallBackImGetLoginTokenRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackImGetLoginToken {
    void onRecvAck(GImGetLoginTokenResponseParam gImGetLoginTokenResponseParam);
}
