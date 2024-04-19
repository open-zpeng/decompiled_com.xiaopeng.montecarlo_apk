package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAudiHcp3EventSearchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAudiHcp3EventSearchRouter;
@IntfAuto(target = CallBackWsAudiHcp3EventSearchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAudiHcp3EventSearch {
    void onRecvAck(GWsAudiHcp3EventSearchResponseParam gWsAudiHcp3EventSearchResponseParam);
}
