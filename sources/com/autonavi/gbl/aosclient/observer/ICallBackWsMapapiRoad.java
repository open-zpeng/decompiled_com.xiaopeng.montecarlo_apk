package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiRoadResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiRoadRouter;
@IntfAuto(target = CallBackWsMapapiRoadRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiRoad {
    void onRecvAck(GWsMapapiRoadResponseParam gWsMapapiRoadResponseParam);
}
