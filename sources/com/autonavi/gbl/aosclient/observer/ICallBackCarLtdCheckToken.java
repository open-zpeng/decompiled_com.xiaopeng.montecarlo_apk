package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdCheckTokenRouter;
@IntfAuto(target = CallBackCarLtdCheckTokenRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdCheckToken {
    void onRecvAck(GCarLtdCheckTokenResponseParam gCarLtdCheckTokenResponseParam);
}
