package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackTrafficEventDetailRouter;
@IntfAuto(target = CallBackTrafficEventDetailRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackTrafficEventDetail {
    void onRecvAck(GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam);
}
