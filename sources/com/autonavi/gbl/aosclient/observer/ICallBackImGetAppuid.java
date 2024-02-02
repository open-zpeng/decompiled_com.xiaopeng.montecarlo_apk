package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GImGetAppuidResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackImGetAppuidRouter;
@IntfAuto(target = CallBackImGetAppuidRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackImGetAppuid {
    void onRecvAck(GImGetAppuidResponseParam gImGetAppuidResponseParam);
}
