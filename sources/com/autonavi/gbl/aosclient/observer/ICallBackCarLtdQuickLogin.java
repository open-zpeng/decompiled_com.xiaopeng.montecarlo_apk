package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdQuickLoginRouter;
@IntfAuto(target = CallBackCarLtdQuickLoginRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdQuickLogin {
    void onRecvAck(GCarLtdQuickLoginResponseParam gCarLtdQuickLoginResponseParam);
}
