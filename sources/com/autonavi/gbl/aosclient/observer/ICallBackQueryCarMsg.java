package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQueryCarMsgResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackQueryCarMsgRouter;
@IntfAuto(target = CallBackQueryCarMsgRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackQueryCarMsg {
    void onRecvAck(GQueryCarMsgResponseParam gQueryCarMsgResponseParam);
}
