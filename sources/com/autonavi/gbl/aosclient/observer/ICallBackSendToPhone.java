package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GSendToPhoneResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackSendToPhoneRouter;
@IntfAuto(target = CallBackSendToPhoneRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackSendToPhone {
    void onRecvAck(GSendToPhoneResponseParam gSendToPhoneResponseParam);
}
