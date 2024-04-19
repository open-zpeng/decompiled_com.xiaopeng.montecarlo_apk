package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickRegisterRouter;
@IntfAuto(target = CallBackCarLtdQuickRegisterRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdQuickRegister {
    void onRecvAck(GCarLtdQuickRegisterResponseParam gCarLtdQuickRegisterResponseParam);
}
