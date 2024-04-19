package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackCarLtdUnbindRouter;
@IntfAuto(target = CallBackCarLtdUnbindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackCarLtdUnbind {
    void onRecvAck(GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam);
}
