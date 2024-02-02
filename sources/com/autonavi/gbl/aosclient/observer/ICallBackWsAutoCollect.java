package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAutoCollectRouter;
@IntfAuto(target = CallBackWsAutoCollectRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAutoCollect {
    void onRecvAck(GWsAutoCollectResponseParam gWsAutoCollectResponseParam);
}
