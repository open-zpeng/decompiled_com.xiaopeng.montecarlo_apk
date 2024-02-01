package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdBindAuthInfoResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdBindAuthInfoRouter;
@IntfAuto(target = CallBackCarLtdBindAuthInfoRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdBindAuthInfo {
    void onRecvAck(GCarLtdBindAuthInfoResponseParam gCarLtdBindAuthInfoResponseParam);
}
