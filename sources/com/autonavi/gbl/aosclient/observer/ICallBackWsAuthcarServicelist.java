package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAuthcarServicelistRouter;
@IntfAuto(target = CallBackWsAuthcarServicelistRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAuthcarServicelist {
    void onRecvAck(GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam);
}
