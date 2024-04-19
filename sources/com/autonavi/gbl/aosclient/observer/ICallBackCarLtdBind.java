package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdBindRouter;
@IntfAuto(target = CallBackCarLtdBindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdBind {
    void onRecvAck(GCarLtdBindResponseParam gCarLtdBindResponseParam);
}
