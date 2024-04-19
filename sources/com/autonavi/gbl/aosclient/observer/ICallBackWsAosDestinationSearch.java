package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAosDestinationSearchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAosDestinationSearchRouter;
@IntfAuto(target = CallBackWsAosDestinationSearchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAosDestinationSearch {
    void onRecvAck(GWsAosDestinationSearchResponseParam gWsAosDestinationSearchResponseParam);
}
